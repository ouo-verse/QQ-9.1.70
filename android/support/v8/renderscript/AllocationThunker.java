package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Allocation;
import android.support.v8.renderscript.Allocation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class AllocationThunker extends Allocation {
    static BitmapFactory.Options mBitmapOptions;
    android.renderscript.Allocation mN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: android.support.v8.renderscript.AllocationThunker$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl;

        static {
            int[] iArr = new int[Allocation.MipmapControl.values().length];
            $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl = iArr;
            try {
                iArr[Allocation.MipmapControl.MIPMAP_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[Allocation.MipmapControl.MIPMAP_FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        mBitmapOptions = options;
        options.inScaled = false;
    }

    AllocationThunker(RenderScript renderScript, Type type, int i3, android.renderscript.Allocation allocation) {
        super(0, renderScript, type, i3);
        this.mType = type;
        this.mUsage = i3;
        this.mN = allocation;
    }

    static Allocation.MipmapControl convertMipmapControl(Allocation.MipmapControl mipmapControl) {
        int i3 = AnonymousClass1.$SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[mipmapControl.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE;
            }
            return Allocation.MipmapControl.MIPMAP_FULL;
        }
        return Allocation.MipmapControl.MIPMAP_NONE;
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap, Allocation.MipmapControl mipmapControl, int i3) {
        android.renderscript.Allocation createCubemapFromBitmap = android.renderscript.Allocation.createCubemapFromBitmap(((RenderScriptThunker) renderScript).mN, bitmap, convertMipmapControl(mipmapControl), i3);
        return new AllocationThunker(renderScript, new TypeThunker(renderScript, createCubemapFromBitmap.getType()), i3, createCubemapFromBitmap);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, Allocation.MipmapControl mipmapControl, int i3) {
        android.renderscript.Allocation createCubemapFromCubeFaces = android.renderscript.Allocation.createCubemapFromCubeFaces(((RenderScriptThunker) renderScript).mN, bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, convertMipmapControl(mipmapControl), i3);
        return new AllocationThunker(renderScript, new TypeThunker(renderScript, createCubemapFromCubeFaces.getType()), i3, createCubemapFromCubeFaces);
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap, Allocation.MipmapControl mipmapControl, int i3) {
        android.renderscript.Allocation createFromBitmap = android.renderscript.Allocation.createFromBitmap(((RenderScriptThunker) renderScript).mN, bitmap, convertMipmapControl(mipmapControl), i3);
        return new AllocationThunker(renderScript, new TypeThunker(renderScript, createFromBitmap.getType()), i3, createFromBitmap);
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i3, Allocation.MipmapControl mipmapControl, int i16) {
        android.renderscript.Allocation createFromBitmapResource = android.renderscript.Allocation.createFromBitmapResource(((RenderScriptThunker) renderScript).mN, resources, i3, convertMipmapControl(mipmapControl), i16);
        return new AllocationThunker(renderScript, new TypeThunker(renderScript, createFromBitmapResource.getType()), i16, createFromBitmapResource);
    }

    public static Allocation createFromString(RenderScript renderScript, String str, int i3) {
        android.renderscript.Allocation createFromString = android.renderscript.Allocation.createFromString(((RenderScriptThunker) renderScript).mN, str, i3);
        return new AllocationThunker(renderScript, new TypeThunker(renderScript, createFromString.getType()), i3, createFromString);
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i3, int i16) {
        android.renderscript.Allocation createSized = android.renderscript.Allocation.createSized(((RenderScriptThunker) renderScript).mN, (android.renderscript.Element) element.getNObj(), i3, i16);
        return new AllocationThunker(renderScript, new TypeThunker(renderScript, createSized.getType()), i16, createSized);
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, Allocation.MipmapControl mipmapControl, int i3) {
        return new AllocationThunker(renderScript, type, i3, android.renderscript.Allocation.createTyped(((RenderScriptThunker) renderScript).mN, ((TypeThunker) type).mN, convertMipmapControl(mipmapControl), i3));
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFrom(int i3, int i16, int[] iArr) {
        this.mN.copy1DRangeFrom(i3, i16, iArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i3, int i16, int[] iArr) {
        this.mN.copy1DRangeFromUnchecked(i3, i16, iArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, byte[] bArr) {
        this.mN.copy2DRangeFrom(i3, i16, i17, i18, bArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFrom(BaseObj[] baseObjArr) {
        if (baseObjArr == null) {
            return;
        }
        android.renderscript.BaseObj[] baseObjArr2 = new android.renderscript.BaseObj[baseObjArr.length];
        for (int i3 = 0; i3 < baseObjArr.length; i3++) {
            baseObjArr2[i3] = baseObjArr[i3].getNObj();
        }
        this.mN.copyFrom(baseObjArr2);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFromUnchecked(int[] iArr) {
        this.mN.copyFromUnchecked(iArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyTo(Bitmap bitmap) {
        this.mN.copyTo(bitmap);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void generateMipmaps() {
        this.mN.generateMipmaps();
    }

    @Override // android.support.v8.renderscript.Allocation
    public int getBytesSize() {
        return this.mN.getBytesSize();
    }

    @Override // android.support.v8.renderscript.Allocation
    public Element getElement() {
        return getType().getElement();
    }

    @Override // android.support.v8.renderscript.Allocation
    public Type getType() {
        return TypeThunker.find(this.mN.getType());
    }

    @Override // android.support.v8.renderscript.Allocation
    public int getUsage() {
        return this.mN.getUsage();
    }

    @Override // android.support.v8.renderscript.Allocation
    public void ioReceive() {
        this.mN.ioReceive();
    }

    @Override // android.support.v8.renderscript.Allocation
    public void ioSend() {
        this.mN.ioSend();
    }

    @Override // android.support.v8.renderscript.Allocation
    public void setFromFieldPacker(int i3, FieldPacker fieldPacker) {
        this.mN.setFromFieldPacker(i3, new android.renderscript.FieldPacker(fieldPacker.getData()));
    }

    @Override // android.support.v8.renderscript.Allocation
    public void syncAll(int i3) {
        this.mN.syncAll(i3);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFrom(int i3, int i16, short[] sArr) {
        this.mN.copy1DRangeFrom(i3, i16, sArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i3, int i16, short[] sArr) {
        this.mN.copy1DRangeFromUnchecked(i3, i16, sArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, short[] sArr) {
        this.mN.copy2DRangeFrom(i3, i16, i17, i18, sArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFromUnchecked(short[] sArr) {
        this.mN.copyFromUnchecked(sArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyTo(byte[] bArr) {
        this.mN.copyTo(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v8.renderscript.BaseObj
    public android.renderscript.Allocation getNObj() {
        return this.mN;
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFrom(int i3, int i16, byte[] bArr) {
        this.mN.copy1DRangeFrom(i3, i16, bArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i3, int i16, byte[] bArr) {
        this.mN.copy1DRangeFromUnchecked(i3, i16, bArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, int[] iArr) {
        this.mN.copy2DRangeFrom(i3, i16, i17, i18, iArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFromUnchecked(byte[] bArr) {
        this.mN.copyFromUnchecked(bArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyTo(short[] sArr) {
        this.mN.copyTo(sArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void setFromFieldPacker(int i3, int i16, FieldPacker fieldPacker) {
        this.mN.setFromFieldPacker(i3, i16, new android.renderscript.FieldPacker(fieldPacker.getData()));
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFrom(int i3, int i16, float[] fArr) {
        this.mN.copy1DRangeFrom(i3, i16, fArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFromUnchecked(int i3, int i16, float[] fArr) {
        this.mN.copy1DRangeFromUnchecked(i3, i16, fArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, float[] fArr) {
        this.mN.copy2DRangeFrom(i3, i16, i17, i18, fArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFromUnchecked(float[] fArr) {
        this.mN.copyFromUnchecked(fArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyTo(int[] iArr) {
        this.mN.copyTo(iArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy1DRangeFrom(int i3, int i16, Allocation allocation, int i17) {
        this.mN.copy1DRangeFrom(i3, i16, ((AllocationThunker) allocation).mN, i17);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy2DRangeFrom(int i3, int i16, int i17, int i18, Allocation allocation, int i19, int i26) {
        this.mN.copy2DRangeFrom(i3, i16, i17, i18, ((AllocationThunker) allocation).mN, i19, i26);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFrom(int[] iArr) {
        this.mN.copyFrom(iArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyTo(float[] fArr) {
        this.mN.copyTo(fArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFrom(short[] sArr) {
        this.mN.copyFrom(sArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copy2DRangeFrom(int i3, int i16, Bitmap bitmap) {
        this.mN.copy2DRangeFrom(i3, i16, bitmap);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFrom(byte[] bArr) {
        this.mN.copyFrom(bArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFrom(float[] fArr) {
        this.mN.copyFrom(fArr);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFrom(Bitmap bitmap) {
        this.mN.copyFrom(bitmap);
    }

    @Override // android.support.v8.renderscript.Allocation
    public void copyFrom(Allocation allocation) {
        this.mN.copyFrom(((AllocationThunker) allocation).mN);
    }
}
