package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.oscarcamera.particlesystem.AttributeConst;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0003\u0005\u0007B5\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J;\u0010\u0003\u001a\u00020\u00002\b\b\u0003\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\fH\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c;", "Lcom/tencent/luggage/wxa/f8/i;", "", "a", "", "b", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$a;", "c", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$b;", "d", "", "e", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$c;", "f", com.tencent.luggage.wxa.c8.c.f123400v, "color", "type", com.tencent.luggage.wxa.c8.c.T, "mouthShape", "toString", "hashCode", "", "other", "", "equals", UserInfo.SEX_FEMALE, "g", "()F", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$a;", tl.h.F, "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$a;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$b;", "k", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$b;", "I", "i", "()I", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$c;", "j", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$c;", "<init>", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$a;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$b;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$c;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c, reason: from toString */
/* loaded from: classes9.dex */
public final /* data */ class LipStickInfoV2 implements com.tencent.luggage.wxa.f8.i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Color color;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final b type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int faceModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final EnumC7006c mouthShape;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J'\u0010\u0003\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$a;", "", "", "a", "b", "c", AttributeConst.R, AttributeConst.G, AttributeConst.B, "", "toString", "hashCode", "other", "", "equals", "I", "f", "()I", "e", "d", "<init>", "(III)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c$a, reason: from toString */
    /* loaded from: classes9.dex */
    public static final /* data */ class Color {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int colorR;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int colorG;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int colorB;

        public Color(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0, to = 255) int i17) {
            this.colorR = i3;
            this.colorG = i16;
            this.colorB = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getColorR() {
            return this.colorR;
        }

        /* renamed from: b, reason: from getter */
        public final int getColorG() {
            return this.colorG;
        }

        /* renamed from: c, reason: from getter */
        public final int getColorB() {
            return this.colorB;
        }

        public final int d() {
            return this.colorB;
        }

        public final int e() {
            return this.colorG;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Color)) {
                return false;
            }
            Color color = (Color) other;
            if (this.colorR == color.colorR && this.colorG == color.colorG && this.colorB == color.colorB) {
                return true;
            }
            return false;
        }

        public final int f() {
            return this.colorR;
        }

        public int hashCode() {
            return (((this.colorR * 31) + this.colorG) * 31) + this.colorB;
        }

        @NotNull
        public String toString() {
            return "Color(colorR=" + this.colorR + ", colorG=" + this.colorG + ", colorB=" + this.colorB + ')';
        }

        @NotNull
        public final Color a(@IntRange(from = 0, to = 255) int colorR, @IntRange(from = 0, to = 255) int colorG, @IntRange(from = 0, to = 255) int colorB) {
            return new Color(colorR, colorG, colorB);
        }

        public static /* synthetic */ Color a(Color color, int i3, int i16, int i17, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i3 = color.colorR;
            }
            if ((i18 & 2) != 0) {
                i16 = color.colorG;
            }
            if ((i18 & 4) != 0) {
                i17 = color.colorB;
            }
            return color.a(i3, i16, i17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$b;", "", "", "a", "I", "b", "()I", "jsonVal", "<init>", "(Ljava/lang/String;II)V", "c", "d", "e", "f", "g", tl.h.F, "i", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c$b */
    /* loaded from: classes9.dex */
    public enum b {
        MATTE(0),
        SATIN(1),
        MOIST(2),
        HIGH_LIGHT(3),
        PEARL(4),
        METALLIC_LIGHT(5),
        NEON_LIGHT(6);


        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int jsonVal;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$b$a;", "", "", "typeInt", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$b;", "a", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c$b$a, reason: from kotlin metadata */
        /* loaded from: classes9.dex */
        public static final class Companion {
            Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final b a(int typeInt) {
                boolean z16;
                for (b bVar : b.values()) {
                    if (typeInt == bVar.getJsonVal()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return bVar;
                    }
                }
                return null;
            }
        }

        b(int i3) {
            this.jsonVal = i3;
        }

        /* renamed from: b, reason: from getter */
        public final int getJsonVal() {
            return this.jsonVal;
        }

        @JvmStatic
        @Nullable
        public static final b a(int i3) {
            return INSTANCE.a(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c$c;", "", "", "a", "I", "b", "()I", "jsonVal", "<init>", "(Ljava/lang/String;II)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c$c, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public enum EnumC7006c {
        STANDARD(0);


        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int jsonVal;

        EnumC7006c(int i3) {
            this.jsonVal = i3;
        }

        /* renamed from: b, reason: from getter */
        public final int getJsonVal() {
            return this.jsonVal;
        }
    }

    public LipStickInfoV2(@FloatRange(from = 0.0d, to = 1.0d) float f16, @NotNull Color color, @NotNull b type, int i3, @NotNull EnumC7006c mouthShape) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mouthShape, "mouthShape");
        this.alpha = f16;
        this.color = color;
        this.type = type;
        this.faceModel = i3;
        this.mouthShape = mouthShape;
    }

    @Override // com.tencent.luggage.wxa.f8.i
    @NotNull
    public String a() {
        return "LipStickInfoV2()";
    }

    /* renamed from: b, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final b getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final int getFaceModel() {
        return this.faceModel;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LipStickInfoV2)) {
            return false;
        }
        LipStickInfoV2 lipStickInfoV2 = (LipStickInfoV2) other;
        if (Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(lipStickInfoV2.alpha)) && Intrinsics.areEqual(this.color, lipStickInfoV2.color) && this.type == lipStickInfoV2.type && this.faceModel == lipStickInfoV2.faceModel && this.mouthShape == lipStickInfoV2.mouthShape) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final EnumC7006c getMouthShape() {
        return this.mouthShape;
    }

    public final float g() {
        return this.alpha;
    }

    @NotNull
    public final Color h() {
        return this.color;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.alpha) * 31) + this.color.hashCode()) * 31) + this.type.hashCode()) * 31) + this.faceModel) * 31) + this.mouthShape.hashCode();
    }

    public final int i() {
        return this.faceModel;
    }

    @NotNull
    public final EnumC7006c j() {
        return this.mouthShape;
    }

    @NotNull
    public final b k() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "LipStickInfoV2(alpha=" + this.alpha + ", color=" + this.color + ", type=" + this.type + ", faceModel=" + this.faceModel + ", mouthShape=" + this.mouthShape + ')';
    }

    @NotNull
    public final LipStickInfoV2 a(@FloatRange(from = 0.0d, to = 1.0d) float alpha, @NotNull Color color, @NotNull b type, int faceModel, @NotNull EnumC7006c mouthShape) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mouthShape, "mouthShape");
        return new LipStickInfoV2(alpha, color, type, faceModel, mouthShape);
    }

    public static /* synthetic */ LipStickInfoV2 a(LipStickInfoV2 lipStickInfoV2, float f16, Color color, b bVar, int i3, EnumC7006c enumC7006c, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            f16 = lipStickInfoV2.alpha;
        }
        if ((i16 & 2) != 0) {
            color = lipStickInfoV2.color;
        }
        Color color2 = color;
        if ((i16 & 4) != 0) {
            bVar = lipStickInfoV2.type;
        }
        b bVar2 = bVar;
        if ((i16 & 8) != 0) {
            i3 = lipStickInfoV2.faceModel;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            enumC7006c = lipStickInfoV2.mouthShape;
        }
        return lipStickInfoV2.a(f16, color2, bVar2, i17, enumC7006c);
    }

    public /* synthetic */ LipStickInfoV2(float f16, Color color, b bVar, int i3, EnumC7006c enumC7006c, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, color, (i16 & 4) != 0 ? b.MATTE : bVar, i3, (i16 & 16) != 0 ? EnumC7006c.STANDARD : enumC7006c);
    }
}
