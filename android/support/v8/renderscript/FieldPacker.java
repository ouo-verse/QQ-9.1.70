package android.support.v8.renderscript;

import android.util.Log;

/* loaded from: classes.dex */
public class FieldPacker {
    private final byte[] mData;
    private int mLen;
    private android.renderscript.FieldPacker mN;
    private int mPos = 0;

    public FieldPacker(int i3) {
        this.mLen = i3;
        this.mData = new byte[i3];
        if (RenderScript.shouldThunk()) {
            this.mN = new android.renderscript.FieldPacker(i3);
        }
    }

    public void addBoolean(boolean z16) {
        if (RenderScript.shouldThunk()) {
            this.mN.addBoolean(z16);
        } else {
            addI8(z16 ? (byte) 1 : (byte) 0);
        }
    }

    public void addF32(float f16) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF32(f16);
        } else {
            addI32(Float.floatToRawIntBits(f16));
        }
    }

    public void addF64(double d16) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF64(d16);
        } else {
            addI64(Double.doubleToRawLongBits(d16));
        }
    }

    public void addI16(short s16) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI16(s16);
            return;
        }
        align(2);
        byte[] bArr = this.mData;
        int i3 = this.mPos;
        int i16 = i3 + 1;
        bArr[i3] = (byte) (s16 & 255);
        this.mPos = i16 + 1;
        bArr[i16] = (byte) (s16 >> 8);
    }

    public void addI32(int i3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI32(i3);
            return;
        }
        align(4);
        byte[] bArr = this.mData;
        int i16 = this.mPos;
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i3 & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((i3 >> 8) & 255);
        int i19 = i18 + 1;
        bArr[i18] = (byte) ((i3 >> 16) & 255);
        this.mPos = i19 + 1;
        bArr[i19] = (byte) ((i3 >> 24) & 255);
    }

    public void addI64(long j3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI64(j3);
            return;
        }
        align(8);
        byte[] bArr = this.mData;
        int i3 = this.mPos;
        int i16 = i3 + 1;
        bArr[i3] = (byte) (j3 & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j3 >> 8) & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((j3 >> 16) & 255);
        int i19 = i18 + 1;
        bArr[i18] = (byte) ((j3 >> 24) & 255);
        int i26 = i19 + 1;
        bArr[i19] = (byte) ((j3 >> 32) & 255);
        int i27 = i26 + 1;
        bArr[i26] = (byte) ((j3 >> 40) & 255);
        int i28 = i27 + 1;
        bArr[i27] = (byte) ((j3 >> 48) & 255);
        this.mPos = i28 + 1;
        bArr[i28] = (byte) ((j3 >> 56) & 255);
    }

    public void addI8(byte b16) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI8(b16);
            return;
        }
        byte[] bArr = this.mData;
        int i3 = this.mPos;
        this.mPos = i3 + 1;
        bArr[i3] = b16;
    }

    public void addMatrix(Matrix4f matrix4f) {
        if (RenderScript.shouldThunk()) {
            this.mN.addMatrix(new android.renderscript.Matrix4f(matrix4f.getArray()));
            return;
        }
        int i3 = 0;
        while (true) {
            float[] fArr = matrix4f.mMat;
            if (i3 >= fArr.length) {
                return;
            }
            addF32(fArr[i3]);
            i3++;
        }
    }

    public void addObj(BaseObj baseObj) {
        if (RenderScript.shouldThunk()) {
            if (baseObj != null) {
                this.mN.addObj(baseObj.getNObj());
                return;
            } else {
                this.mN.addObj(null);
                return;
            }
        }
        if (baseObj != null) {
            addI32(baseObj.getID(null));
        } else {
            addI32(0);
        }
    }

    public void addU16(int i3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU16(i3);
            return;
        }
        if (i3 >= 0 && i3 <= 65535) {
            align(2);
            byte[] bArr = this.mData;
            int i16 = this.mPos;
            int i17 = i16 + 1;
            bArr[i16] = (byte) (i3 & 255);
            this.mPos = i17 + 1;
            bArr[i17] = (byte) (i3 >> 8);
            return;
        }
        Log.e("rs", "FieldPacker.addU16( " + i3 + " )");
        throw new IllegalArgumentException("Saving value out of range for type");
    }

    public void addU32(long j3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU32(j3);
            return;
        }
        if (j3 >= 0 && j3 <= 4294967295L) {
            align(4);
            byte[] bArr = this.mData;
            int i3 = this.mPos;
            int i16 = i3 + 1;
            bArr[i3] = (byte) (j3 & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) ((j3 >> 8) & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) ((j3 >> 16) & 255);
            this.mPos = i18 + 1;
            bArr[i18] = (byte) ((j3 >> 24) & 255);
            return;
        }
        Log.e("rs", "FieldPacker.addU32( " + j3 + " )");
        throw new IllegalArgumentException("Saving value out of range for type");
    }

    public void addU64(long j3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU64(j3);
            return;
        }
        if (j3 >= 0) {
            align(8);
            byte[] bArr = this.mData;
            int i3 = this.mPos;
            int i16 = i3 + 1;
            bArr[i3] = (byte) (j3 & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) ((j3 >> 8) & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) ((j3 >> 16) & 255);
            int i19 = i18 + 1;
            bArr[i18] = (byte) ((j3 >> 24) & 255);
            int i26 = i19 + 1;
            bArr[i19] = (byte) ((j3 >> 32) & 255);
            int i27 = i26 + 1;
            bArr[i26] = (byte) ((j3 >> 40) & 255);
            int i28 = i27 + 1;
            bArr[i27] = (byte) ((j3 >> 48) & 255);
            this.mPos = i28 + 1;
            bArr[i28] = (byte) ((j3 >> 56) & 255);
            return;
        }
        Log.e("rs", "FieldPacker.addU64( " + j3 + " )");
        throw new IllegalArgumentException("Saving value out of range for type");
    }

    public void addU8(short s16) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU8(s16);
            return;
        }
        if (s16 >= 0 && s16 <= 255) {
            byte[] bArr = this.mData;
            int i3 = this.mPos;
            this.mPos = i3 + 1;
            bArr[i3] = (byte) s16;
            return;
        }
        throw new IllegalArgumentException("Saving value out of range for type");
    }

    public void align(int i3) {
        if (RenderScript.shouldThunk()) {
            this.mN.align(i3);
            return;
        }
        if (i3 > 0) {
            int i16 = i3 - 1;
            if ((i3 & i16) == 0) {
                while (true) {
                    int i17 = this.mPos;
                    if ((i17 & i16) != 0) {
                        byte[] bArr = this.mData;
                        this.mPos = i17 + 1;
                        bArr[i17] = 0;
                    } else {
                        return;
                    }
                }
            }
        }
        throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + i3);
    }

    public final byte[] getData() {
        if (RenderScript.shouldThunk()) {
            return this.mN.getData();
        }
        return this.mData;
    }

    public void reset() {
        if (RenderScript.shouldThunk()) {
            this.mN.reset();
        } else {
            this.mPos = 0;
        }
    }

    public void skip(int i3) {
        if (RenderScript.shouldThunk()) {
            this.mN.skip(i3);
            return;
        }
        int i16 = this.mPos + i3;
        if (i16 >= 0 && i16 <= this.mLen) {
            this.mPos = i16;
            return;
        }
        throw new RSIllegalArgumentException("out of range argument: " + i3);
    }

    public void addF32(Float2 float2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF32(new android.renderscript.Float2(float2.f26416x, float2.f26417y));
        } else {
            addF32(float2.f26416x);
            addF32(float2.f26417y);
        }
    }

    public void addF64(Double2 double2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF64(new android.renderscript.Double2(double2.f26407x, double2.f26408y));
        } else {
            addF64(double2.f26407x);
            addF64(double2.f26408y);
        }
    }

    public void addI8(Byte2 byte2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI8(new android.renderscript.Byte2(byte2.f26398x, byte2.f26399y));
        } else {
            addI8(byte2.f26398x);
            addI8(byte2.f26399y);
        }
    }

    public void reset(int i3) {
        if (RenderScript.shouldThunk()) {
            this.mN.reset(i3);
            return;
        }
        if (i3 >= 0 && i3 < this.mLen) {
            this.mPos = i3;
            return;
        }
        throw new RSIllegalArgumentException("out of range argument: " + i3);
    }

    public void addMatrix(Matrix3f matrix3f) {
        if (RenderScript.shouldThunk()) {
            this.mN.addMatrix(new android.renderscript.Matrix3f(matrix3f.getArray()));
            return;
        }
        int i3 = 0;
        while (true) {
            float[] fArr = matrix3f.mMat;
            if (i3 >= fArr.length) {
                return;
            }
            addF32(fArr[i3]);
            i3++;
        }
    }

    public void addU8(Short2 short2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU8(new android.renderscript.Short2(short2.f26443x, short2.f26444y));
        } else {
            addU8(short2.f26443x);
            addU8(short2.f26444y);
        }
    }

    public void addI16(Short2 short2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI16(new android.renderscript.Short2(short2.f26443x, short2.f26444y));
        } else {
            addI16(short2.f26443x);
            addI16(short2.f26444y);
        }
    }

    public void addF32(Float3 float3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF32(new android.renderscript.Float3(float3.f26418x, float3.f26419y, float3.f26420z));
            return;
        }
        addF32(float3.f26418x);
        addF32(float3.f26419y);
        addF32(float3.f26420z);
    }

    public void addF64(Double3 double3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF64(new android.renderscript.Double3(double3.f26409x, double3.f26410y, double3.f26411z));
            return;
        }
        addF64(double3.f26409x);
        addF64(double3.f26410y);
        addF64(double3.f26411z);
    }

    public void addI32(Int2 int2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI32(new android.renderscript.Int2(int2.f26425x, int2.f26426y));
        } else {
            addI32(int2.f26425x);
            addI32(int2.f26426y);
        }
    }

    public void addI8(Byte3 byte3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI8(new android.renderscript.Byte3(byte3.f26400x, byte3.f26401y, byte3.f26402z));
            return;
        }
        addI8(byte3.f26400x);
        addI8(byte3.f26401y);
        addI8(byte3.f26402z);
    }

    public void addU16(Int2 int2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU16(new android.renderscript.Int2(int2.f26425x, int2.f26426y));
        } else {
            addU16(int2.f26425x);
            addU16(int2.f26426y);
        }
    }

    public void addMatrix(Matrix2f matrix2f) {
        if (RenderScript.shouldThunk()) {
            this.mN.addMatrix(new android.renderscript.Matrix2f(matrix2f.getArray()));
            return;
        }
        int i3 = 0;
        while (true) {
            float[] fArr = matrix2f.mMat;
            if (i3 >= fArr.length) {
                return;
            }
            addF32(fArr[i3]);
            i3++;
        }
    }

    public void addU8(Short3 short3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU8(new android.renderscript.Short3(short3.f26445x, short3.f26446y, short3.f26447z));
            return;
        }
        addU8(short3.f26445x);
        addU8(short3.f26446y);
        addU8(short3.f26447z);
    }

    public void addI16(Short3 short3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI16(new android.renderscript.Short3(short3.f26445x, short3.f26446y, short3.f26447z));
            return;
        }
        addI16(short3.f26445x);
        addI16(short3.f26446y);
        addI16(short3.f26447z);
    }

    public void addU32(Long2 long2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU32(new android.renderscript.Long2(long2.f26434x, long2.f26435y));
        } else {
            addU32(long2.f26434x);
            addU32(long2.f26435y);
        }
    }

    public void addI32(Int3 int3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI32(new android.renderscript.Int3(int3.f26427x, int3.f26428y, int3.f26429z));
            return;
        }
        addI32(int3.f26427x);
        addI32(int3.f26428y);
        addI32(int3.f26429z);
    }

    public void addI64(Long2 long2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI64(new android.renderscript.Long2(long2.f26434x, long2.f26435y));
        } else {
            addI64(long2.f26434x);
            addI64(long2.f26435y);
        }
    }

    public void addU16(Int3 int3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU16(new android.renderscript.Int3(int3.f26427x, int3.f26428y, int3.f26429z));
            return;
        }
        addU16(int3.f26427x);
        addU16(int3.f26428y);
        addU16(int3.f26429z);
    }

    public void addF32(Float4 float4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF32(new android.renderscript.Float4(float4.f26422x, float4.f26423y, float4.f26424z, float4.f26421w));
            return;
        }
        addF32(float4.f26422x);
        addF32(float4.f26423y);
        addF32(float4.f26424z);
        addF32(float4.f26421w);
    }

    public void addF64(Double4 double4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addF64(new android.renderscript.Double4(double4.f26413x, double4.f26414y, double4.f26415z, double4.f26412w));
            return;
        }
        addF64(double4.f26413x);
        addF64(double4.f26414y);
        addF64(double4.f26415z);
        addF64(double4.f26412w);
    }

    public void addI8(Byte4 byte4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI8(new android.renderscript.Byte4(byte4.f26404x, byte4.f26405y, byte4.f26406z, byte4.f26403w));
            return;
        }
        addI8(byte4.f26404x);
        addI8(byte4.f26405y);
        addI8(byte4.f26406z);
        addI8(byte4.f26403w);
    }

    public void addU32(Long3 long3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU32(new android.renderscript.Long3(long3.f26436x, long3.f26437y, long3.f26438z));
            return;
        }
        addU32(long3.f26436x);
        addU32(long3.f26437y);
        addU32(long3.f26438z);
    }

    public void addU64(Long2 long2) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU64(new android.renderscript.Long2(long2.f26434x, long2.f26435y));
        } else {
            addU64(long2.f26434x);
            addU64(long2.f26435y);
        }
    }

    public void addU8(Short4 short4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU8(new android.renderscript.Short4(short4.f26449x, short4.f26450y, short4.f26451z, short4.f26448w));
            return;
        }
        addU8(short4.f26449x);
        addU8(short4.f26450y);
        addU8(short4.f26451z);
        addU8(short4.f26448w);
    }

    public void addI16(Short4 short4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI16(new android.renderscript.Short4(short4.f26449x, short4.f26450y, short4.f26451z, short4.f26448w));
            return;
        }
        addI16(short4.f26449x);
        addI16(short4.f26450y);
        addI16(short4.f26451z);
        addI16(short4.f26448w);
    }

    public void addI64(Long3 long3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI64(new android.renderscript.Long3(long3.f26436x, long3.f26437y, long3.f26438z));
            return;
        }
        addI64(long3.f26436x);
        addI64(long3.f26437y);
        addI64(long3.f26438z);
    }

    public void addI32(Int4 int4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI32(new android.renderscript.Int4(int4.f26431x, int4.f26432y, int4.f26433z, int4.f26430w));
            return;
        }
        addI32(int4.f26431x);
        addI32(int4.f26432y);
        addI32(int4.f26433z);
        addI32(int4.f26430w);
    }

    public void addU16(Int4 int4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU16(new android.renderscript.Int4(int4.f26431x, int4.f26432y, int4.f26433z, int4.f26430w));
            return;
        }
        addU16(int4.f26431x);
        addU16(int4.f26432y);
        addU16(int4.f26433z);
        addU16(int4.f26430w);
    }

    public void addU64(Long3 long3) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU64(new android.renderscript.Long3(long3.f26436x, long3.f26437y, long3.f26438z));
            return;
        }
        addU64(long3.f26436x);
        addU64(long3.f26437y);
        addU64(long3.f26438z);
    }

    public void addU32(Long4 long4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU32(new android.renderscript.Long4(long4.f26440x, long4.f26441y, long4.f26442z, long4.f26439w));
            return;
        }
        addU32(long4.f26440x);
        addU32(long4.f26441y);
        addU32(long4.f26442z);
        addU32(long4.f26439w);
    }

    public void addI64(Long4 long4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addI64(new android.renderscript.Long4(long4.f26440x, long4.f26441y, long4.f26442z, long4.f26439w));
            return;
        }
        addI64(long4.f26440x);
        addI64(long4.f26441y);
        addI64(long4.f26442z);
        addI64(long4.f26439w);
    }

    public void addU64(Long4 long4) {
        if (RenderScript.shouldThunk()) {
            this.mN.addU64(new android.renderscript.Long4(long4.f26440x, long4.f26441y, long4.f26442z, long4.f26439w));
            return;
        }
        addU64(long4.f26440x);
        addU64(long4.f26441y);
        addU64(long4.f26442z);
        addU64(long4.f26439w);
    }
}
