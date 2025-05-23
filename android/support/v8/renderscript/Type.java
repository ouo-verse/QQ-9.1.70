package android.support.v8.renderscript;

/* compiled from: P */
/* loaded from: classes.dex */
public class Type extends BaseObj {
    boolean mDimFaces;
    boolean mDimMipmaps;
    int mDimX;
    int mDimY;
    int mDimYuv;
    int mDimZ;
    Element mElement;
    int mElementCount;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Builder {
        boolean mDimFaces;
        boolean mDimMipmaps;
        int mDimX = 1;
        int mDimY;
        int mDimZ;
        Element mElement;
        RenderScript mRS;
        int mYuv;

        public Builder(RenderScript renderScript, Element element) {
            element.checkValid();
            this.mRS = renderScript;
            this.mElement = element;
        }

        public Type create() {
            Type type;
            int i3 = this.mDimZ;
            if (i3 > 0) {
                if (this.mDimX >= 1 && this.mDimY >= 1) {
                    if (this.mDimFaces) {
                        throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                    }
                } else {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                }
            }
            int i16 = this.mDimY;
            if (i16 > 0 && this.mDimX < 1) {
                throw new RSInvalidStateException("X dimension required when Y is present.");
            }
            boolean z16 = this.mDimFaces;
            if (z16 && i16 < 1) {
                throw new RSInvalidStateException("Cube maps require 2D Types.");
            }
            int i17 = this.mYuv;
            if (i17 != 0 && (i3 != 0 || z16 || this.mDimMipmaps)) {
                throw new RSInvalidStateException("YUV only supports basic 2D.");
            }
            RenderScript renderScript = this.mRS;
            if (RenderScript.isNative) {
                type = TypeThunker.create((RenderScriptThunker) renderScript, this.mElement, this.mDimX, i16, i3, this.mDimMipmaps, z16, i17);
            } else {
                type = new Type(renderScript.nTypeCreate(this.mElement.getID(renderScript), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
            }
            type.mElement = this.mElement;
            type.mDimX = this.mDimX;
            type.mDimY = this.mDimY;
            type.mDimZ = this.mDimZ;
            type.mDimMipmaps = this.mDimMipmaps;
            type.mDimFaces = this.mDimFaces;
            type.mDimYuv = this.mYuv;
            type.calcElementCount();
            return type;
        }

        public Builder setFaces(boolean z16) {
            this.mDimFaces = z16;
            return this;
        }

        public Builder setMipmaps(boolean z16) {
            this.mDimMipmaps = z16;
            return this;
        }

        public Builder setX(int i3) {
            if (i3 >= 1) {
                this.mDimX = i3;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
        }

        public Builder setY(int i3) {
            if (i3 >= 1) {
                this.mDimY = i3;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
        }

        public Builder setYuvFormat(int i3) {
            if (i3 != 17 && i3 != 842094169) {
                throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
            }
            this.mYuv = i3;
            return this;
        }

        public Builder setZ(int i3) {
            if (i3 >= 1) {
                this.mDimZ = i3;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum CubemapFace {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5);

        int mID;

        CubemapFace(int i3) {
            this.mID = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calcElementCount() {
        int i3;
        boolean hasMipmaps = hasMipmaps();
        int x16 = getX();
        int y16 = getY();
        int z16 = getZ();
        if (hasFaces()) {
            i3 = 6;
        } else {
            i3 = 1;
        }
        if (x16 == 0) {
            x16 = 1;
        }
        if (y16 == 0) {
            y16 = 1;
        }
        if (z16 == 0) {
            z16 = 1;
        }
        int i16 = x16 * y16 * z16 * i3;
        while (hasMipmaps && (x16 > 1 || y16 > 1 || z16 > 1)) {
            if (x16 > 1) {
                x16 >>= 1;
            }
            if (y16 > 1) {
                y16 >>= 1;
            }
            if (z16 > 1) {
                z16 >>= 1;
            }
            i16 += x16 * y16 * z16 * i3;
        }
        this.mElementCount = i16;
    }

    public int getCount() {
        return this.mElementCount;
    }

    public Element getElement() {
        return this.mElement;
    }

    public int getX() {
        return this.mDimX;
    }

    public int getY() {
        return this.mDimY;
    }

    public int getYuv() {
        return this.mDimYuv;
    }

    public int getZ() {
        return this.mDimZ;
    }

    public boolean hasFaces() {
        return this.mDimFaces;
    }

    public boolean hasMipmaps() {
        return this.mDimMipmaps;
    }
}
