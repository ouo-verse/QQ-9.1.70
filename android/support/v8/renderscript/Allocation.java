package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.Type;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes.dex */
public class Allocation extends BaseObj {
    public static final int USAGE_GRAPHICS_TEXTURE = 2;
    public static final int USAGE_IO_INPUT = 32;
    public static final int USAGE_IO_OUTPUT = 64;
    public static final int USAGE_SCRIPT = 1;
    public static final int USAGE_SHARED = 128;
    static BitmapFactory.Options mBitmapOptions;
    Allocation mAdaptedAllocation;
    Bitmap mBitmap;
    boolean mConstrainedFace;
    boolean mConstrainedLOD;
    boolean mConstrainedY;
    boolean mConstrainedZ;
    int mCurrentCount;
    int mCurrentDimX;
    int mCurrentDimY;
    int mCurrentDimZ;
    boolean mReadAllowed;
    Type.CubemapFace mSelectedFace;
    int mSelectedLOD;
    int mSelectedY;
    int mSelectedZ;
    int mSize;
    Type mType;
    int mUsage;
    boolean mWriteAllowed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: android.support.v8.renderscript.Allocation$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum MipmapControl {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);

        int mID;

        MipmapControl(int i3) {
            this.mID = i3;
        }
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        mBitmapOptions = options;
        options.inScaled = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Allocation(int i3, RenderScript renderScript, Type type, int i16) {
        super(i3, renderScript);
        this.mReadAllowed = true;
        this.mWriteAllowed = true;
        this.mSelectedFace = Type.CubemapFace.POSITIVE_X;
        if ((i16 & (-228)) == 0) {
            if ((i16 & 32) != 0) {
                this.mWriteAllowed = false;
                if ((i16 & (-36)) != 0) {
                    throw new RSIllegalArgumentException("Invalid usage combination.");
                }
            }
            this.mType = type;
            this.mUsage = i16;
            this.mSize = type.getCount() * this.mType.getElement().getBytesSize();
            if (type != null) {
                updateCacheInfo(type);
            }
            if (RenderScript.sUseGCHooks) {
                try {
                    RenderScript.registerNativeAllocation.invoke(RenderScript.sRuntime, Integer.valueOf(this.mSize));
                    return;
                } catch (Exception e16) {
                    Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:" + e16);
                    throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:" + e16);
                }
            }
            return;
        }
        throw new RSIllegalArgumentException("Unknown usage specified.");
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i3) {
        renderScript.validate();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (width % 6 == 0) {
            if (width / 6 != height) {
                throw new RSIllegalArgumentException("Only square cube map faces supported");
            }
            if (((height + (-1)) & height) == 0) {
                Element elementFromBitmap = elementFromBitmap(renderScript, bitmap);
                Type.Builder builder = new Type.Builder(renderScript, elementFromBitmap);
                builder.setX(height);
                builder.setY(height);
                builder.setFaces(true);
                builder.setMipmaps(mipmapControl == MipmapControl.MIPMAP_FULL);
                Type create = builder.create();
                int nAllocationCubeCreateFromBitmap = renderScript.nAllocationCubeCreateFromBitmap(create.getID(renderScript), mipmapControl.mID, bitmap, i3);
                if (nAllocationCubeCreateFromBitmap != 0) {
                    return new Allocation(nAllocationCubeCreateFromBitmap, renderScript, create, i3);
                }
                throw new RSRuntimeException("Load failed for bitmap " + bitmap + " element " + elementFromBitmap);
            }
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        }
        throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, MipmapControl mipmapControl, int i3) {
        return null;
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i3) {
        if (RenderScript.isNative) {
            return AllocationThunker.createFromBitmap((RenderScriptThunker) renderScript, bitmap, mipmapControl, i3);
        }
        renderScript.validate();
        if (bitmap.getConfig() == null) {
            if ((i3 & 128) == 0) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                return createFromBitmap(renderScript, createBitmap, mipmapControl, i3);
            }
            throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
        }
        Type typeFromBitmap = typeFromBitmap(renderScript, bitmap, mipmapControl);
        if (mipmapControl == MipmapControl.MIPMAP_NONE && typeFromBitmap.getElement().isCompatible(Element.RGBA_8888(renderScript)) && i3 == 131) {
            int nAllocationCreateBitmapBackedAllocation = renderScript.nAllocationCreateBitmapBackedAllocation(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i3);
            if (nAllocationCreateBitmapBackedAllocation != 0) {
                Allocation allocation = new Allocation(nAllocationCreateBitmapBackedAllocation, renderScript, typeFromBitmap, i3);
                allocation.setBitmap(bitmap);
                return allocation;
            }
            throw new RSRuntimeException("Load failed.");
        }
        int nAllocationCreateFromBitmap = renderScript.nAllocationCreateFromBitmap(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i3);
        if (nAllocationCreateFromBitmap != 0) {
            return new Allocation(nAllocationCreateFromBitmap, renderScript, typeFromBitmap, i3);
        }
        throw new RSRuntimeException("Load failed.");
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i3, MipmapControl mipmapControl, int i16) {
        renderScript.validate();
        if ((i16 & 224) == 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, i3);
            Allocation createFromBitmap = createFromBitmap(renderScript, decodeResource, mipmapControl, i16);
            decodeResource.recycle();
            return createFromBitmap;
        }
        throw new RSIllegalArgumentException("Unsupported usage specified.");
    }

    public static Allocation createFromString(RenderScript renderScript, String str, int i3) {
        renderScript.validate();
        try {
            byte[] bytes = str.getBytes("UTF-8");
            Allocation createSized = createSized(renderScript, Element.U8(renderScript), bytes.length, i3);
            createSized.copyFrom(bytes);
            return createSized;
        } catch (Exception unused) {
            throw new RSRuntimeException("Could not convert string to utf-8.");
        }
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i3, int i16) {
        if (RenderScript.isNative) {
            return AllocationThunker.createSized(renderScript, element, i3, i16);
        }
        renderScript.validate();
        Type.Builder builder = new Type.Builder(renderScript, element);
        builder.setX(i3);
        Type create = builder.create();
        int nAllocationCreateTyped = renderScript.nAllocationCreateTyped(create.getID(renderScript), MipmapControl.MIPMAP_NONE.mID, i16, 0);
        if (nAllocationCreateTyped != 0) {
            return new Allocation(nAllocationCreateTyped, renderScript, create, i16);
        }
        throw new RSRuntimeException("Allocation creation failed.");
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, MipmapControl mipmapControl, int i3) {
        if (RenderScript.isNative) {
            return AllocationThunker.createTyped((RenderScriptThunker) renderScript, type, mipmapControl, i3);
        }
        renderScript.validate();
        if (type.getID(renderScript) != 0) {
            int nAllocationCreateTyped = renderScript.nAllocationCreateTyped(type.getID(renderScript), mipmapControl.mID, i3, 0);
            if (nAllocationCreateTyped != 0) {
                return new Allocation(nAllocationCreateTyped, renderScript, type, i3);
            }
            throw new RSRuntimeException("Allocation creation failed.");
        }
        throw new RSInvalidStateException("Bad Type");
    }

    private void data1DChecks(int i3, int i16, int i17, int i18) {
        this.mRS.validate();
        if (i3 >= 0) {
            if (i16 >= 1) {
                if (i3 + i16 <= this.mCurrentCount) {
                    if (i17 >= i18) {
                        return;
                    } else {
                        throw new RSIllegalArgumentException("Array too small for allocation type.");
                    }
                }
                throw new RSIllegalArgumentException("Overflow, Available count " + this.mCurrentCount + ", got " + i16 + " at offset " + i3 + ".");
            }
            throw new RSIllegalArgumentException("Count must be >= 1.");
        }
        throw new RSIllegalArgumentException("Offset must be >= 0.");
    }

    static Element elementFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == Bitmap.Config.ALPHA_8) {
            return Element.A_8(renderScript);
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return Element.RGBA_4444(renderScript);
        }
        if (config == Bitmap.Config.ARGB_8888) {
            return Element.RGBA_8888(renderScript);
        }
        if (config == Bitmap.Config.RGB_565) {
            return Element.RGB_565(renderScript);
        }
        throw new RSInvalidStateException("Bad bitmap type: " + config);
    }

    private int getIDSafe() {
        Allocation allocation = this.mAdaptedAllocation;
        if (allocation != null) {
            return allocation.getID(this.mRS);
        }
        return getID(this.mRS);
    }

    private void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    static Type typeFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl) {
        boolean z16;
        Type.Builder builder = new Type.Builder(renderScript, elementFromBitmap(renderScript, bitmap));
        builder.setX(bitmap.getWidth());
        builder.setY(bitmap.getHeight());
        if (mipmapControl == MipmapControl.MIPMAP_FULL) {
            z16 = true;
        } else {
            z16 = false;
        }
        builder.setMipmaps(z16);
        return builder.create();
    }

    private void updateCacheInfo(Type type) {
        this.mCurrentDimX = type.getX();
        this.mCurrentDimY = type.getY();
        int z16 = type.getZ();
        this.mCurrentDimZ = z16;
        int i3 = this.mCurrentDimX;
        this.mCurrentCount = i3;
        int i16 = this.mCurrentDimY;
        if (i16 > 1) {
            this.mCurrentCount = i3 * i16;
        }
        if (z16 > 1) {
            this.mCurrentCount *= z16;
        }
    }

    private void validate2DRange(int i3, int i16, int i17, int i18) {
        if (this.mAdaptedAllocation == null) {
            if (i3 >= 0 && i16 >= 0) {
                if (i18 >= 0 && i17 >= 0) {
                    if (i3 + i17 <= this.mCurrentDimX && i16 + i18 <= this.mCurrentDimY) {
                        return;
                    } else {
                        throw new RSIllegalArgumentException("Updated region larger than allocation.");
                    }
                }
                throw new RSIllegalArgumentException("Height or width cannot be negative.");
            }
            throw new RSIllegalArgumentException("Offset cannot be negative.");
        }
    }

    private void validate3DRange(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (this.mAdaptedAllocation == null) {
            if (i3 >= 0 && i16 >= 0 && i17 >= 0) {
                if (i19 >= 0 && i18 >= 0 && i26 >= 0) {
                    if (i3 + i18 <= this.mCurrentDimX && i16 + i19 <= this.mCurrentDimY && i17 + i26 <= this.mCurrentDimZ) {
                        return;
                    } else {
                        throw new RSIllegalArgumentException("Updated region larger than allocation.");
                    }
                }
                throw new RSIllegalArgumentException("Height or width cannot be negative.");
            }
            throw new RSIllegalArgumentException("Offset cannot be negative.");
        }
    }

    private void validateBitmapFormat(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config != null) {
            int i3 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            if (this.mType.getElement().mKind != Element.DataKind.PIXEL_RGBA || this.mType.getElement().getBytesSize() != 2) {
                                throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
                            }
                            return;
                        }
                        return;
                    }
                    if (this.mType.getElement().mKind != Element.DataKind.PIXEL_RGB || this.mType.getElement().getBytesSize() != 2) {
                        throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
                    }
                    return;
                }
                if (this.mType.getElement().mKind != Element.DataKind.PIXEL_RGBA || this.mType.getElement().getBytesSize() != 4) {
                    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
                }
                return;
            }
            if (this.mType.getElement().mKind == Element.DataKind.PIXEL_A) {
                return;
            }
            throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
        }
        throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
    }

    private void validateBitmapSize(Bitmap bitmap) {
        if (this.mCurrentDimX == bitmap.getWidth() && this.mCurrentDimY == bitmap.getHeight()) {
        } else {
            throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
        }
    }

    private void validateIsFloat32() {
        if (this.mType.mElement.mType == Element.DataType.FLOAT_32) {
            return;
        }
        throw new RSIllegalArgumentException("32 bit float source does not match allocation type " + this.mType.mElement.mType);
    }

    private void validateIsInt16() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType != Element.DataType.SIGNED_16 && dataType != Element.DataType.UNSIGNED_16) {
            throw new RSIllegalArgumentException("16 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt32() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType != Element.DataType.SIGNED_32 && dataType != Element.DataType.UNSIGNED_32) {
            throw new RSIllegalArgumentException("32 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt8() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType != Element.DataType.SIGNED_8 && dataType != Element.DataType.UNSIGNED_8) {
            throw new RSIllegalArgumentException("8 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsObject() {
        Element.DataType dataType = this.mType.mElement.mType;
        if (dataType != Element.DataType.RS_ELEMENT && dataType != Element.DataType.RS_TYPE && dataType != Element.DataType.RS_ALLOCATION && dataType != Element.DataType.RS_SAMPLER && dataType != Element.DataType.RS_SCRIPT) {
            throw new RSIllegalArgumentException("Object source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    public void copy1DRangeFrom(int i3, int i16, int[] iArr) {
        validateIsInt32();
        copy1DRangeFromUnchecked(i3, i16, iArr);
    }

    public void copy1DRangeFromUnchecked(int i3, int i16, int[] iArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i16;
        data1DChecks(i3, i16, iArr.length * 4, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i3, this.mSelectedLOD, i16, iArr, bytesSize);
    }

    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, byte[] bArr) {
        validateIsInt8();
        copy2DRangeFromUnchecked(i3, i16, i17, i18, bArr);
    }

    void copy2DRangeFromUnchecked(int i3, int i16, int i17, int i18, byte[] bArr) {
        this.mRS.validate();
        validate2DRange(i3, i16, i17, i18);
        this.mRS.nAllocationData2D(getIDSafe(), i3, i16, this.mSelectedLOD, this.mSelectedFace.mID, i17, i18, bArr, bArr.length);
    }

    public void copy3DRangeFrom(int i3, int i16, int i17, int i18, int i19, int i26, byte[] bArr) {
        validateIsInt8();
        copy3DRangeFromUnchecked(i3, i16, i17, i18, i19, i26, bArr);
    }

    void copy3DRangeFromUnchecked(int i3, int i16, int i17, int i18, int i19, int i26, byte[] bArr) {
        this.mRS.validate();
        validate3DRange(i3, i16, i17, i18, i19, i26);
        this.mRS.nAllocationData3D(getIDSafe(), i3, i16, i17, this.mSelectedLOD, i18, i19, i26, bArr, bArr.length);
    }

    public void copyFrom(BaseObj[] baseObjArr) {
        this.mRS.validate();
        validateIsObject();
        if (baseObjArr.length == this.mCurrentCount) {
            int[] iArr = new int[baseObjArr.length];
            for (int i3 = 0; i3 < baseObjArr.length; i3++) {
                iArr[i3] = baseObjArr[i3].getID(this.mRS);
            }
            copy1DRangeFromUnchecked(0, this.mCurrentCount, iArr);
            return;
        }
        throw new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " + this.mCurrentCount + ", array length = " + baseObjArr.length);
    }

    public void copyFromUnchecked(int[] iArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, iArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i16, iArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, iArr);
        }
    }

    public void copyTo(Bitmap bitmap) {
        this.mRS.validate();
        validateBitmapFormat(bitmap);
        validateBitmapSize(bitmap);
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationCopyToBitmap(getID(renderScript), bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v8.renderscript.BaseObj
    public void finalize() throws Throwable {
        if (RenderScript.sUseGCHooks) {
            RenderScript.registerNativeFree.invoke(RenderScript.sRuntime, Integer.valueOf(this.mSize));
        }
        super.finalize();
    }

    public void generateMipmaps() {
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationGenerateMipmaps(getID(renderScript));
    }

    public int getBytesSize() {
        return this.mType.getCount() * this.mType.getElement().getBytesSize();
    }

    public Element getElement() {
        return this.mType.getElement();
    }

    public Type getType() {
        return this.mType;
    }

    public int getUsage() {
        return this.mUsage;
    }

    public void ioReceive() {
        if ((this.mUsage & 32) != 0) {
            this.mRS.validate();
            RenderScript renderScript = this.mRS;
            renderScript.nAllocationIoReceive(getID(renderScript));
            return;
        }
        throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
    }

    public void ioSend() {
        if ((this.mUsage & 64) != 0) {
            this.mRS.validate();
            RenderScript renderScript = this.mRS;
            renderScript.nAllocationIoSend(getID(renderScript));
            return;
        }
        throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
    }

    public void ioSendOutput() {
        ioSend();
    }

    public void setFromFieldPacker(int i3, FieldPacker fieldPacker) {
        this.mRS.validate();
        int bytesSize = this.mType.mElement.getBytesSize();
        byte[] data = fieldPacker.getData();
        int length = data.length / bytesSize;
        if (bytesSize * length == data.length) {
            copy1DRangeFromUnchecked(i3, length, data);
            return;
        }
        throw new RSIllegalArgumentException("Field packer length " + data.length + " not divisible by element size " + bytesSize + ".");
    }

    public void syncAll(int i3) {
        if (i3 != 1 && i3 != 2) {
            throw new RSIllegalArgumentException("Source must be exactly one usage type.");
        }
        this.mRS.validate();
        this.mRS.nAllocationSyncAll(getIDSafe(), i3);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        return createCubemapFromCubeFaces(renderScript, bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, MipmapControl.MIPMAP_NONE, 2);
    }

    public void copy1DRangeFrom(int i3, int i16, short[] sArr) {
        validateIsInt16();
        copy1DRangeFromUnchecked(i3, i16, sArr);
    }

    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, short[] sArr) {
        validateIsInt16();
        copy2DRangeFromUnchecked(i3, i16, i17, i18, sArr);
    }

    public void copy3DRangeFrom(int i3, int i16, int i17, int i18, int i19, int i26, short[] sArr) {
        validateIsInt16();
        copy3DRangeFromUnchecked(i3, i16, i17, i18, i19, i26, sArr);
    }

    public void copy1DRangeFromUnchecked(int i3, int i16, short[] sArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i16;
        data1DChecks(i3, i16, sArr.length * 2, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i3, this.mSelectedLOD, i16, sArr, bytesSize);
    }

    void copy2DRangeFromUnchecked(int i3, int i16, int i17, int i18, short[] sArr) {
        this.mRS.validate();
        validate2DRange(i3, i16, i17, i18);
        this.mRS.nAllocationData2D(getIDSafe(), i3, i16, this.mSelectedLOD, this.mSelectedFace.mID, i17, i18, sArr, sArr.length * 2);
    }

    void copy3DRangeFromUnchecked(int i3, int i16, int i17, int i18, int i19, int i26, short[] sArr) {
        this.mRS.validate();
        validate3DRange(i3, i16, i17, i18, i19, i26);
        this.mRS.nAllocationData3D(getIDSafe(), i3, i16, i17, this.mSelectedLOD, i18, i19, i26, sArr, sArr.length * 2);
    }

    public void copy1DRangeFrom(int i3, int i16, byte[] bArr) {
        validateIsInt8();
        copy1DRangeFromUnchecked(i3, i16, bArr);
    }

    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, int[] iArr) {
        validateIsInt32();
        copy2DRangeFromUnchecked(i3, i16, i17, i18, iArr);
    }

    public void copy3DRangeFrom(int i3, int i16, int i17, int i18, int i19, int i26, int[] iArr) {
        validateIsInt32();
        copy3DRangeFromUnchecked(i3, i16, i17, i18, i19, i26, iArr);
    }

    public void copyTo(byte[] bArr) {
        validateIsInt8();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), bArr);
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i3) {
        return createFromBitmapResource(renderScript, resources, i3, MipmapControl.MIPMAP_NONE, 3);
    }

    public void copy1DRangeFrom(int i3, int i16, float[] fArr) {
        validateIsFloat32();
        copy1DRangeFromUnchecked(i3, i16, fArr);
    }

    public void copy1DRangeFromUnchecked(int i3, int i16, byte[] bArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i16;
        data1DChecks(i3, i16, bArr.length, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i3, this.mSelectedLOD, i16, bArr, bytesSize);
    }

    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, float[] fArr) {
        validateIsFloat32();
        copy2DRangeFromUnchecked(i3, i16, i17, i18, fArr);
    }

    void copy2DRangeFromUnchecked(int i3, int i16, int i17, int i18, int[] iArr) {
        this.mRS.validate();
        validate2DRange(i3, i16, i17, i18);
        this.mRS.nAllocationData2D(getIDSafe(), i3, i16, this.mSelectedLOD, this.mSelectedFace.mID, i17, i18, iArr, iArr.length * 4);
    }

    public void copy3DRangeFrom(int i3, int i16, int i17, int i18, int i19, int i26, float[] fArr) {
        validateIsFloat32();
        copy3DRangeFromUnchecked(i3, i16, i17, i18, i19, i26, fArr);
    }

    void copy3DRangeFromUnchecked(int i3, int i16, int i17, int i18, int i19, int i26, int[] iArr) {
        this.mRS.validate();
        validate3DRange(i3, i16, i17, i18, i19, i26);
        this.mRS.nAllocationData3D(getIDSafe(), i3, i16, i17, this.mSelectedLOD, i18, i19, i26, iArr, iArr.length * 4);
    }

    public void copyFromUnchecked(short[] sArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, sArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i16, sArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, sArr);
        }
    }

    public void copyTo(short[] sArr) {
        validateIsInt16();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), sArr);
    }

    public void setFromFieldPacker(int i3, int i16, FieldPacker fieldPacker) {
        this.mRS.validate();
        if (i16 >= this.mType.mElement.mElements.length) {
            throw new RSIllegalArgumentException("Component_number " + i16 + " out of range.");
        }
        if (i3 >= 0) {
            byte[] data = fieldPacker.getData();
            int bytesSize = this.mType.mElement.mElements[i16].getBytesSize() * this.mType.mElement.mArraySizes[i16];
            if (data.length == bytesSize) {
                this.mRS.nAllocationElementData1D(getIDSafe(), i3, this.mSelectedLOD, i16, data, data.length);
                return;
            }
            throw new RSIllegalArgumentException("Field packer sizelength " + data.length + " does not match component size " + bytesSize + ".");
        }
        throw new RSIllegalArgumentException("Offset must be >= 0.");
    }

    public void copy1DRangeFrom(int i3, int i16, Allocation allocation, int i17) {
        this.mRS.nAllocationData2D(getIDSafe(), i3, 0, this.mSelectedLOD, this.mSelectedFace.mID, i16, 1, allocation.getID(this.mRS), i17, 0, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, Allocation allocation, int i19, int i26) {
        this.mRS.validate();
        validate2DRange(i3, i16, i17, i18);
        this.mRS.nAllocationData2D(getIDSafe(), i3, i16, this.mSelectedLOD, this.mSelectedFace.mID, i17, i18, allocation.getID(this.mRS), i19, i26, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy3DRangeFrom(int i3, int i16, int i17, int i18, int i19, int i26, Allocation allocation, int i27, int i28, int i29) {
        this.mRS.validate();
        validate3DRange(i3, i16, i17, i18, i19, i26);
        this.mRS.nAllocationData3D(getIDSafe(), i3, i16, i17, this.mSelectedLOD, i18, i19, i26, allocation.getID(this.mRS), i27, i28, i29, allocation.mSelectedLOD);
    }

    public void copyFrom(int[] iArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, iArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i16, iArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, iArr);
        }
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, int i3) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, i3);
    }

    public void copy1DRangeFromUnchecked(int i3, int i16, float[] fArr) {
        int bytesSize = this.mType.mElement.getBytesSize() * i16;
        data1DChecks(i3, i16, fArr.length * 4, bytesSize);
        this.mRS.nAllocationData1D(getIDSafe(), i3, this.mSelectedLOD, i16, fArr, bytesSize);
    }

    void copy2DRangeFromUnchecked(int i3, int i16, int i17, int i18, float[] fArr) {
        this.mRS.validate();
        validate2DRange(i3, i16, i17, i18);
        this.mRS.nAllocationData2D(getIDSafe(), i3, i16, this.mSelectedLOD, this.mSelectedFace.mID, i17, i18, fArr, fArr.length * 4);
    }

    void copy3DRangeFromUnchecked(int i3, int i16, int i17, int i18, int i19, int i26, float[] fArr) {
        this.mRS.validate();
        validate3DRange(i3, i16, i17, i18, i19, i26);
        this.mRS.nAllocationData3D(getIDSafe(), i3, i16, i17, this.mSelectedLOD, i18, i19, i26, fArr, fArr.length * 4);
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i3) {
        return createSized(renderScript, element, i3, 1);
    }

    public static Allocation createTyped(RenderScript renderScript, Type type) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, 1);
    }

    public void copyTo(int[] iArr) {
        validateIsInt32();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), iArr);
    }

    public void copy2DRangeFrom(int i3, int i16, Bitmap bitmap) {
        this.mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            copy2DRangeFrom(i3, i16, createBitmap);
        } else {
            validateBitmapFormat(bitmap);
            validate2DRange(i3, i16, bitmap.getWidth(), bitmap.getHeight());
            this.mRS.nAllocationData2D(getIDSafe(), i3, i16, this.mSelectedLOD, this.mSelectedFace.mID, bitmap);
        }
    }

    public void copyFromUnchecked(byte[] bArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, bArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i16, bArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, bArr);
        }
    }

    public void copyTo(float[] fArr) {
        validateIsFloat32();
        this.mRS.validate();
        RenderScript renderScript = this.mRS;
        renderScript.nAllocationRead(getID(renderScript), fArr);
    }

    public void copyFrom(short[] sArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, sArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i16, sArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, sArr);
        }
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createCubemapFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 2);
    }

    public void copyFromUnchecked(float[] fArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, fArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i16, fArr);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, fArr);
        }
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 131);
    }

    public void copyFrom(byte[] bArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, bArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i16, bArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, bArr);
        }
    }

    public void copyFrom(float[] fArr) {
        this.mRS.validate();
        int i3 = this.mCurrentDimZ;
        if (i3 > 0) {
            copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i3, fArr);
            return;
        }
        int i16 = this.mCurrentDimY;
        if (i16 > 0) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, i16, fArr);
        } else {
            copy1DRangeFrom(0, this.mCurrentCount, fArr);
        }
    }

    public void copyFrom(Bitmap bitmap) {
        this.mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            copyFrom(createBitmap);
        } else {
            validateBitmapSize(bitmap);
            validateBitmapFormat(bitmap);
            RenderScript renderScript = this.mRS;
            renderScript.nAllocationCopyFromBitmap(getID(renderScript), bitmap);
        }
    }

    public void copyFrom(Allocation allocation) {
        this.mRS.validate();
        if (this.mType.equals(allocation.getType())) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, allocation, 0, 0);
            return;
        }
        throw new RSIllegalArgumentException("Types of allocations must match.");
    }
}
