package com.tencent.luggage.wxa.f8;

import androidx.annotation.FloatRange;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0003BE\u0012\b\b\u0001\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003JK\u0010\u0003\u001a\u00020\u00002\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b\"\u0010!R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b#\u0010!R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b$\u0010!R\u0017\u0010)\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/luggage/wxa/f8/d;", "Lcom/tencent/luggage/wxa/f8/i;", "", "a", "", "b", "Lcom/tencent/luggage/wxa/f8/a;", "c", "d", "e", "f", "g", com.tencent.luggage.wxa.c8.c.f123400v, com.tencent.luggage.wxa.c8.c.W, "path", com.tencent.luggage.wxa.c8.c.Y, "shimmerPosPath", "shimmerPosPathMd5", "toString", "", "hashCode", "", "other", "", "equals", UserInfo.SEX_FEMALE, tl.h.F, "()F", "Lcom/tencent/luggage/wxa/f8/a;", "i", "()Lcom/tencent/luggage/wxa/f8/a;", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/luggage/wxa/f8/d$a;", "Lcom/tencent/luggage/wxa/f8/d$a;", DomainData.DOMAIN_NAME, "()Lcom/tencent/luggage/wxa/f8/d$a;", "type", "<init>", "(FLcom/tencent/luggage/wxa/f8/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.luggage.wxa.f8.d, reason: from toString */
/* loaded from: classes8.dex */
public final /* data */ class EyeShadowInfoV2 implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.luggage.wxa.f8.a blendMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pathMd5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String shimmerPosPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String shimmerPosPathMd5;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0005j\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/luggage/wxa/f8/d$a;", "", "", "a", "I", "b", "()I", "jsonVal", "<init>", "(Ljava/lang/String;II)V", "c", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.wxa.f8.d$a */
    /* loaded from: classes8.dex */
    public enum a {
        MATTE(0),
        FINE_FLASH(1);


        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int jsonVal;

        a(int i3) {
            this.jsonVal = i3;
        }

        /* renamed from: b, reason: from getter */
        public final int getJsonVal() {
            return this.jsonVal;
        }
    }

    public EyeShadowInfoV2(@FloatRange(from = 0.0d, to = 1.0d) float f16, @NotNull com.tencent.luggage.wxa.f8.a blendMode, @NotNull String path, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(path, "path");
        this.alpha = f16;
        this.blendMode = blendMode;
        this.path = path;
        this.pathMd5 = str;
        this.shimmerPosPath = str2;
        this.shimmerPosPathMd5 = str3;
        this.type = str2 == null || str2.length() == 0 ? a.MATTE : a.FINE_FLASH;
    }

    @NotNull
    public final EyeShadowInfoV2 a(@FloatRange(from = 0.0d, to = 1.0d) float alpha, @NotNull com.tencent.luggage.wxa.f8.a blendMode, @NotNull String path, @Nullable String pathMd5, @Nullable String shimmerPosPath, @Nullable String shimmerPosPathMd5) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(path, "path");
        return new EyeShadowInfoV2(alpha, blendMode, path, pathMd5, shimmerPosPath, shimmerPosPathMd5);
    }

    /* renamed from: b, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final com.tencent.luggage.wxa.f8.a getBlendMode() {
        return this.blendMode;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getPathMd5() {
        return this.pathMd5;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EyeShadowInfoV2)) {
            return false;
        }
        EyeShadowInfoV2 eyeShadowInfoV2 = (EyeShadowInfoV2) other;
        if (Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(eyeShadowInfoV2.alpha)) && this.blendMode == eyeShadowInfoV2.blendMode && Intrinsics.areEqual(this.path, eyeShadowInfoV2.path) && Intrinsics.areEqual(this.pathMd5, eyeShadowInfoV2.pathMd5) && Intrinsics.areEqual(this.shimmerPosPath, eyeShadowInfoV2.shimmerPosPath) && Intrinsics.areEqual(this.shimmerPosPathMd5, eyeShadowInfoV2.shimmerPosPathMd5)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getShimmerPosPath() {
        return this.shimmerPosPath;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getShimmerPosPathMd5() {
        return this.shimmerPosPathMd5;
    }

    public final float h() {
        return this.alpha;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int floatToIntBits = ((((Float.floatToIntBits(this.alpha) * 31) + this.blendMode.hashCode()) * 31) + this.path.hashCode()) * 31;
        String str = this.pathMd5;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (floatToIntBits + hashCode) * 31;
        String str2 = this.shimmerPosPath;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.shimmerPosPathMd5;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public final com.tencent.luggage.wxa.f8.a i() {
        return this.blendMode;
    }

    @NotNull
    public final String j() {
        return this.path;
    }

    @Nullable
    public final String k() {
        return this.pathMd5;
    }

    @Nullable
    public final String l() {
        return this.shimmerPosPath;
    }

    @Nullable
    public final String m() {
        return this.shimmerPosPathMd5;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final a getType() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "EyeShadowInfoV2(alpha=" + this.alpha + ", blendMode=" + this.blendMode + ", path=" + this.path + ", pathMd5=" + this.pathMd5 + ", shimmerPosPath=" + this.shimmerPosPath + ", shimmerPosPathMd5=" + this.shimmerPosPathMd5 + ')';
    }

    public static /* synthetic */ EyeShadowInfoV2 a(EyeShadowInfoV2 eyeShadowInfoV2, float f16, com.tencent.luggage.wxa.f8.a aVar, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = eyeShadowInfoV2.alpha;
        }
        if ((i3 & 2) != 0) {
            aVar = eyeShadowInfoV2.blendMode;
        }
        com.tencent.luggage.wxa.f8.a aVar2 = aVar;
        if ((i3 & 4) != 0) {
            str = eyeShadowInfoV2.path;
        }
        String str5 = str;
        if ((i3 & 8) != 0) {
            str2 = eyeShadowInfoV2.pathMd5;
        }
        String str6 = str2;
        if ((i3 & 16) != 0) {
            str3 = eyeShadowInfoV2.shimmerPosPath;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = eyeShadowInfoV2.shimmerPosPathMd5;
        }
        return eyeShadowInfoV2.a(f16, aVar2, str5, str6, str7, str4);
    }

    @Override // com.tencent.luggage.wxa.f8.i
    @NotNull
    public String a() {
        return "EyeShadowInfoV1(path='" + this.path + "', pathMd5='" + this.pathMd5 + "', shimmerPosPath=" + this.shimmerPosPath + ", shimmerPosPathMd5='" + this.shimmerPosPathMd5 + "')";
    }

    public /* synthetic */ EyeShadowInfoV2(float f16, com.tencent.luggage.wxa.f8.a aVar, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, aVar, str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? "" : str4);
    }
}
