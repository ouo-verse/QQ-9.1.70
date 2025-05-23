package com.tencent.state.square.avatar.filament;

import com.heytap.databaseengine.apiv3.data.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\bE\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 U2\u00020\u0001:\u0001UB\u00a5\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\u00a9\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001J\u0011\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020IH\u0086\u0002J\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010M\u001a\u00020NH\u00d6\u0001J\u0006\u0010O\u001a\u00020\u0000J\u0011\u0010P\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0000H\u0086\u0002J\u0006\u0010Q\u001a\u00020RJ\b\u0010S\u001a\u00020TH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017\u00a8\u0006V"}, d2 = {"Lcom/tencent/state/square/avatar/filament/Mat44F;", "", "m00", "", "m01", "m02", "m03", "m10", "m11", "m12", "m13", "m20", "m21", "m22", "m23", "m30", "m31", "m32", "m33", "(FFFFFFFFFFFFFFFF)V", "getM00", "()F", "setM00", "(F)V", "getM01", "setM01", "getM02", "setM02", "getM03", "setM03", "getM10", "setM10", "getM11", "setM11", "getM12", "setM12", "getM13", "setM13", "getM20", "setM20", "getM21", "setM21", "getM22", "setM22", "getM23", "setM23", "getM30", "setM30", "getM31", "setM31", "getM32", "setM32", "getM33", "setM33", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "div", "vec", "Lcom/tencent/state/square/avatar/filament/Vec3F;", "equals", "", "other", "hashCode", "", "inverse", Element.ELEMENT_NAME_TIMES, "toQuaternion", "Lcom/tencent/state/square/avatar/filament/QuatF;", "toString", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Mat44F {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private float m00;
    private float m01;
    private float m02;
    private float m03;
    private float m10;
    private float m11;
    private float m12;
    private float m13;
    private float m20;
    private float m21;
    private float m22;
    private float m23;
    private float m30;
    private float m31;
    private float m32;
    private float m33;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/avatar/filament/Mat44F$Companion;", "", "()V", "scaling", "Lcom/tencent/state/square/avatar/filament/Mat44F;", "scale", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Mat44F scaling(float scale) {
            return new Mat44F(scale, 0.0f, 0.0f, 0.0f, 0.0f, scale, 0.0f, 0.0f, 0.0f, 0.0f, scale, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    public Mat44F() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 65535, null);
    }

    /* renamed from: component1, reason: from getter */
    public final float getM00() {
        return this.m00;
    }

    /* renamed from: component10, reason: from getter */
    public final float getM21() {
        return this.m21;
    }

    /* renamed from: component11, reason: from getter */
    public final float getM22() {
        return this.m22;
    }

    /* renamed from: component12, reason: from getter */
    public final float getM23() {
        return this.m23;
    }

    /* renamed from: component13, reason: from getter */
    public final float getM30() {
        return this.m30;
    }

    /* renamed from: component14, reason: from getter */
    public final float getM31() {
        return this.m31;
    }

    /* renamed from: component15, reason: from getter */
    public final float getM32() {
        return this.m32;
    }

    /* renamed from: component16, reason: from getter */
    public final float getM33() {
        return this.m33;
    }

    /* renamed from: component2, reason: from getter */
    public final float getM01() {
        return this.m01;
    }

    /* renamed from: component3, reason: from getter */
    public final float getM02() {
        return this.m02;
    }

    /* renamed from: component4, reason: from getter */
    public final float getM03() {
        return this.m03;
    }

    /* renamed from: component5, reason: from getter */
    public final float getM10() {
        return this.m10;
    }

    /* renamed from: component6, reason: from getter */
    public final float getM11() {
        return this.m11;
    }

    /* renamed from: component7, reason: from getter */
    public final float getM12() {
        return this.m12;
    }

    /* renamed from: component8, reason: from getter */
    public final float getM13() {
        return this.m13;
    }

    /* renamed from: component9, reason: from getter */
    public final float getM20() {
        return this.m20;
    }

    public final float getM00() {
        return this.m00;
    }

    public final float getM01() {
        return this.m01;
    }

    public final float getM02() {
        return this.m02;
    }

    public final float getM03() {
        return this.m03;
    }

    public final float getM10() {
        return this.m10;
    }

    public final float getM11() {
        return this.m11;
    }

    public final float getM12() {
        return this.m12;
    }

    public final float getM13() {
        return this.m13;
    }

    public final float getM20() {
        return this.m20;
    }

    public final float getM21() {
        return this.m21;
    }

    public final float getM22() {
        return this.m22;
    }

    public final float getM23() {
        return this.m23;
    }

    public final float getM30() {
        return this.m30;
    }

    public final float getM31() {
        return this.m31;
    }

    public final float getM32() {
        return this.m32;
    }

    public final float getM33() {
        return this.m33;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Float.floatToIntBits(this.m00) * 31) + Float.floatToIntBits(this.m01)) * 31) + Float.floatToIntBits(this.m02)) * 31) + Float.floatToIntBits(this.m03)) * 31) + Float.floatToIntBits(this.m10)) * 31) + Float.floatToIntBits(this.m11)) * 31) + Float.floatToIntBits(this.m12)) * 31) + Float.floatToIntBits(this.m13)) * 31) + Float.floatToIntBits(this.m20)) * 31) + Float.floatToIntBits(this.m21)) * 31) + Float.floatToIntBits(this.m22)) * 31) + Float.floatToIntBits(this.m23)) * 31) + Float.floatToIntBits(this.m30)) * 31) + Float.floatToIntBits(this.m31)) * 31) + Float.floatToIntBits(this.m32)) * 31) + Float.floatToIntBits(this.m33);
    }

    public final void setM00(float f16) {
        this.m00 = f16;
    }

    public final void setM01(float f16) {
        this.m01 = f16;
    }

    public final void setM02(float f16) {
        this.m02 = f16;
    }

    public final void setM03(float f16) {
        this.m03 = f16;
    }

    public final void setM10(float f16) {
        this.m10 = f16;
    }

    public final void setM11(float f16) {
        this.m11 = f16;
    }

    public final void setM12(float f16) {
        this.m12 = f16;
    }

    public final void setM13(float f16) {
        this.m13 = f16;
    }

    public final void setM20(float f16) {
        this.m20 = f16;
    }

    public final void setM21(float f16) {
        this.m21 = f16;
    }

    public final void setM22(float f16) {
        this.m22 = f16;
    }

    public final void setM23(float f16) {
        this.m23 = f16;
    }

    public final void setM30(float f16) {
        this.m30 = f16;
    }

    public final void setM31(float f16) {
        this.m31 = f16;
    }

    public final void setM32(float f16) {
        this.m32 = f16;
    }

    public final void setM33(float f16) {
        this.m33 = f16;
    }

    public final QuatF toQuaternion() {
        float f16 = this.m00 + this.m11 + this.m22;
        QuatF quatF = new QuatF(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        if (f16 > 0.0f) {
            float sqrt = 0.5f / ((float) Math.sqrt(f16 + 1.0f));
            quatF.setW(0.25f / sqrt);
            quatF.setX((this.m21 - this.m12) * sqrt);
            quatF.setY((this.m02 - this.m20) * sqrt);
            quatF.setZ((this.m10 - this.m01) * sqrt);
        } else {
            float f17 = this.m00;
            float f18 = this.m11;
            if (f17 > f18) {
                if (f17 > this.m22) {
                    float sqrt2 = ((float) Math.sqrt(((f17 + 1.0f) - f18) - r4)) * 2.0f;
                    quatF.setW((this.m21 - this.m12) / sqrt2);
                    quatF.setX(0.25f * sqrt2);
                    quatF.setY((this.m01 + this.m10) / sqrt2);
                    quatF.setZ((this.m02 + this.m20) / sqrt2);
                }
            }
            if (f18 > this.m22) {
                float sqrt3 = ((float) Math.sqrt(((f18 + 1.0f) - f17) - r4)) * 2.0f;
                quatF.setW((this.m02 - this.m20) / sqrt3);
                quatF.setX((this.m01 + this.m10) / sqrt3);
                quatF.setY(0.25f * sqrt3);
                quatF.setZ((this.m12 + this.m21) / sqrt3);
            } else {
                float sqrt4 = ((float) Math.sqrt(((r4 + 1.0f) - f17) - f18)) * 2.0f;
                quatF.setW((this.m10 - this.m01) / sqrt4);
                quatF.setX((this.m02 + this.m20) / sqrt4);
                quatF.setY((this.m12 + this.m21) / sqrt4);
                quatF.setZ(sqrt4 * 0.25f);
            }
        }
        return quatF;
    }

    public String toString() {
        return "\n[" + this.m00 + ", " + this.m01 + ", " + this.m02 + ", " + this.m03 + "]\n[" + this.m10 + ", " + this.m11 + ", " + this.m12 + ", " + this.m13 + "]\n[" + this.m20 + ", " + this.m21 + ", " + this.m22 + ", " + this.m23 + "]\n[" + this.m30 + ", " + this.m31 + ", " + this.m32 + ", " + this.m33 + "]\n";
    }

    public Mat44F(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36, float f37, float f38, float f39, float f46, float f47, float f48, float f49) {
        this.m00 = f16;
        this.m01 = f17;
        this.m02 = f18;
        this.m03 = f19;
        this.m10 = f26;
        this.m11 = f27;
        this.m12 = f28;
        this.m13 = f29;
        this.m20 = f36;
        this.m21 = f37;
        this.m22 = f38;
        this.m23 = f39;
        this.m30 = f46;
        this.m31 = f47;
        this.m32 = f48;
        this.m33 = f49;
    }

    public /* synthetic */ Mat44F(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36, float f37, float f38, float f39, float f46, float f47, float f48, float f49, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19, (i3 & 16) != 0 ? 0.0f : f26, (i3 & 32) != 0 ? 0.0f : f27, (i3 & 64) != 0 ? 0.0f : f28, (i3 & 128) != 0 ? 0.0f : f29, (i3 & 256) != 0 ? 0.0f : f36, (i3 & 512) != 0 ? 0.0f : f37, (i3 & 1024) != 0 ? 0.0f : f38, (i3 & 2048) != 0 ? 0.0f : f39, (i3 & 4096) != 0 ? 0.0f : f46, (i3 & 8192) != 0 ? 0.0f : f47, (i3 & 16384) != 0 ? 0.0f : f48, (i3 & 32768) != 0 ? 0.0f : f49);
    }

    public final Mat44F div(Vec3F vec) {
        Intrinsics.checkNotNullParameter(vec, "vec");
        return new Mat44F(this.m00 / vec.getX(), this.m01 / vec.getY(), this.m02 / vec.getZ(), this.m03, this.m10 / vec.getX(), this.m11 / vec.getY(), this.m12 / vec.getZ(), this.m13, this.m20 / vec.getX(), this.m21 / vec.getY(), this.m22 / vec.getZ(), this.m23, this.m30 / vec.getX(), this.m31 / vec.getY(), this.m32 / vec.getZ(), this.m33);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mat44F)) {
            return false;
        }
        Mat44F mat44F = (Mat44F) other;
        return Float.compare(this.m00, mat44F.m00) == 0 && Float.compare(this.m01, mat44F.m01) == 0 && Float.compare(this.m02, mat44F.m02) == 0 && Float.compare(this.m03, mat44F.m03) == 0 && Float.compare(this.m10, mat44F.m10) == 0 && Float.compare(this.m11, mat44F.m11) == 0 && Float.compare(this.m12, mat44F.m12) == 0 && Float.compare(this.m13, mat44F.m13) == 0 && Float.compare(this.m20, mat44F.m20) == 0 && Float.compare(this.m21, mat44F.m21) == 0 && Float.compare(this.m22, mat44F.m22) == 0 && Float.compare(this.m23, mat44F.m23) == 0 && Float.compare(this.m30, mat44F.m30) == 0 && Float.compare(this.m31, mat44F.m31) == 0 && Float.compare(this.m32, mat44F.m32) == 0 && Float.compare(this.m33, mat44F.m33) == 0;
    }

    public final Mat44F inverse() {
        float[] fArr = new float[16];
        float f16 = this.m11;
        float f17 = this.m22;
        float f18 = this.m33;
        float f19 = this.m23;
        float f26 = this.m32;
        float f27 = this.m21;
        float f28 = this.m12;
        float f29 = this.m13;
        float f36 = this.m31;
        float f37 = ((((((f16 * f17) * f18) - ((f16 * f19) * f26)) - ((f27 * f28) * f18)) + ((f27 * f29) * f26)) + ((f36 * f28) * f19)) - ((f36 * f29) * f17);
        fArr[0] = f37;
        float f38 = this.m10;
        float f39 = this.m20;
        float f46 = this.m30;
        float f47 = (((((((-f38) * f17) * f18) + ((f38 * f19) * f26)) + ((f39 * f28) * f18)) - ((f39 * f29) * f26)) - ((f46 * f28) * f19)) + (f46 * f29 * f17);
        fArr[4] = f47;
        float f48 = ((((((f38 * f27) * f18) - ((f38 * f19) * f36)) - ((f39 * f16) * f18)) + ((f39 * f29) * f36)) + ((f46 * f16) * f19)) - ((f46 * f29) * f27);
        fArr[8] = f48;
        float f49 = (((((((-f38) * f27) * f26) + ((f38 * f17) * f36)) + ((f39 * f16) * f26)) - ((f39 * f28) * f36)) - ((f46 * f16) * f17)) + (f46 * f28 * f27);
        fArr[12] = f49;
        float f56 = this.m01;
        float f57 = this.m02;
        float f58 = this.m03;
        fArr[1] = (((((((-f56) * f17) * f18) + ((f56 * f19) * f26)) + ((f27 * f57) * f18)) - ((f27 * f58) * f26)) - ((f36 * f57) * f19)) + (f36 * f58 * f17);
        float f59 = this.m00;
        fArr[5] = ((((((f59 * f17) * f18) - ((f59 * f19) * f26)) - ((f39 * f57) * f18)) + ((f39 * f58) * f26)) + ((f46 * f57) * f19)) - ((f46 * f58) * f17);
        fArr[9] = (((((((-f59) * f27) * f18) + ((f59 * f19) * f36)) + ((f39 * f56) * f18)) - ((f39 * f58) * f36)) - ((f46 * f56) * f19)) + (f46 * f58 * f27);
        fArr[13] = ((((((f59 * f27) * f26) - ((f59 * f17) * f36)) - ((f39 * f56) * f26)) + ((f39 * f57) * f36)) + ((f46 * f56) * f17)) - ((f46 * f57) * f27);
        fArr[2] = ((((((f56 * f28) * f18) - ((f56 * f29) * f26)) - ((f16 * f57) * f18)) + ((f16 * f58) * f26)) + ((f36 * f57) * f29)) - ((f36 * f58) * f28);
        fArr[6] = (((((((-f59) * f28) * f18) + ((f59 * f29) * f26)) + ((f38 * f57) * f18)) - ((f38 * f58) * f26)) - ((f46 * f57) * f29)) + (f46 * f58 * f28);
        fArr[10] = ((((((f59 * f16) * f18) - ((f59 * f29) * f36)) - ((f38 * f56) * f18)) + ((f38 * f58) * f36)) + ((f46 * f56) * f29)) - ((f46 * f58) * f16);
        fArr[14] = (((((((-f59) * f16) * f26) + ((f59 * f28) * f36)) + ((f38 * f56) * f26)) - ((f38 * f57) * f36)) - ((f46 * f56) * f28)) + (f46 * f57 * f16);
        fArr[3] = (((((((-f56) * f28) * f19) + ((f56 * f29) * f17)) + ((f16 * f57) * f19)) - ((f16 * f58) * f17)) - ((f27 * f57) * f29)) + (f27 * f58 * f28);
        fArr[7] = ((((((f59 * f28) * f19) - ((f59 * f29) * f17)) - ((f38 * f57) * f19)) + ((f38 * f58) * f17)) + ((f39 * f57) * f29)) - ((f39 * f58) * f28);
        fArr[11] = (((((((-f59) * f16) * f19) + ((f59 * f29) * f27)) + ((f38 * f56) * f19)) - ((f38 * f58) * f27)) - ((f39 * f56) * f29)) + (f39 * f58 * f16);
        fArr[15] = ((((((f59 * f16) * f17) - ((f59 * f28) * f27)) - ((f38 * f56) * f17)) + ((f38 * f57) * f27)) + ((f39 * f56) * f28)) - ((f39 * f57) * f16);
        float f65 = (f59 * f37) + (f56 * f47) + (f57 * f48) + (f58 * f49);
        if (f65 != 0.0f) {
            float f66 = 1.0f / f65;
            for (int i3 = 0; i3 <= 15; i3++) {
                fArr[i3] = fArr[i3] * f66;
            }
            return new Mat44F(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8], fArr[9], fArr[10], fArr[11], fArr[12], fArr[13], fArr[14], fArr[15]);
        }
        throw new IllegalArgumentException("Matrix is not invertible");
    }

    public final Mat44F times(Mat44F other) {
        Intrinsics.checkNotNullParameter(other, "other");
        float f16 = this.m00;
        float f17 = other.m00;
        float f18 = this.m10;
        float f19 = other.m01;
        float f26 = this.m20;
        float f27 = other.m02;
        float f28 = this.m30;
        float f29 = other.m03;
        float f36 = (f16 * f17) + (f18 * f19) + (f26 * f27) + (f28 * f29);
        float f37 = this.m01;
        float f38 = this.m11;
        float f39 = this.m21;
        float f46 = this.m31;
        float f47 = (f37 * f17) + (f38 * f19) + (f39 * f27) + (f46 * f29);
        float f48 = this.m02;
        float f49 = this.m12;
        float f56 = this.m22;
        float f57 = (f48 * f17) + (f49 * f19) + (f56 * f27);
        float f58 = this.m32;
        float f59 = f57 + (f58 * f29);
        float f65 = this.m03;
        float f66 = f17 * f65;
        float f67 = this.m13;
        float f68 = f66 + (f19 * f67);
        float f69 = this.m23;
        float f75 = f68 + (f27 * f69);
        float f76 = this.m33;
        float f77 = f75 + (f29 * f76);
        float f78 = other.m10;
        float f79 = other.m11;
        float f85 = (f16 * f78) + (f18 * f79);
        float f86 = other.m12;
        float f87 = f85 + (f26 * f86);
        float f88 = other.m13;
        float f89 = f87 + (f28 * f88);
        float f95 = (f37 * f78) + (f38 * f79) + (f39 * f86) + (f46 * f88);
        float f96 = (f48 * f78) + (f49 * f79) + (f56 * f86) + (f58 * f88);
        float f97 = (f78 * f65) + (f79 * f67) + (f86 * f69) + (f88 * f76);
        float f98 = other.m20;
        float f99 = other.m21;
        float f100 = other.m22;
        float f101 = other.m23;
        float f102 = (f16 * f98) + (f18 * f99) + (f26 * f100) + (f28 * f101);
        float f103 = (f37 * f98) + (f38 * f99) + (f39 * f100) + (f46 * f101);
        float f104 = (f48 * f98) + (f49 * f99) + (f56 * f100) + (f58 * f101);
        float f105 = (f98 * f65) + (f99 * f67) + (f100 * f69) + (f101 * f76);
        float f106 = other.m30;
        float f107 = other.m31;
        float f108 = (f16 * f106) + (f18 * f107);
        float f109 = other.m32;
        float f110 = other.m33;
        return new Mat44F(f36, f47, f59, f77, f89, f95, f96, f97, f102, f103, f104, f105, f108 + (f26 * f109) + (f28 * f110), (f37 * f106) + (f38 * f107) + (f39 * f109) + (f46 * f110), (f48 * f106) + (f49 * f107) + (f56 * f109) + (f58 * f110), (f106 * f65) + (f67 * f107) + (f69 * f109) + (f76 * f110));
    }

    public final Mat44F copy(float m002, float m012, float m022, float m032, float m102, float m112, float m122, float m132, float m202, float m212, float m222, float m232, float m302, float m312, float m322, float m332) {
        return new Mat44F(m002, m012, m022, m032, m102, m112, m122, m132, m202, m212, m222, m232, m302, m312, m322, m332);
    }
}
