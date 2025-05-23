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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J]\u0010\u0003\u001a\u00020\u00002\b\b\u0003\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\u0014\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0015\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b.\u0010&R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b/\u0010&\u00a8\u00062"}, d2 = {"Lcom/tencent/luggage/wxa/f8/p;", "Lcom/tencent/luggage/wxa/f8/i;", "", "a", "", "b", "Lcom/tencent/luggage/wxa/f8/a;", "c", "d", "e", "", "f", "Lcom/tencent/luggage/wxa/f8/u;", "g", tl.h.F, "i", com.tencent.luggage.wxa.c8.c.f123400v, com.tencent.luggage.wxa.c8.c.W, "path", com.tencent.luggage.wxa.c8.c.Y, com.tencent.luggage.wxa.c8.c.T, com.tencent.luggage.wxa.c8.c.Z, "shimmerPath", "shimmerPathMd5", "toString", "hashCode", "", "other", "", "equals", UserInfo.SEX_FEMALE, "j", "()F", "Lcom/tencent/luggage/wxa/f8/a;", "k", "()Lcom/tencent/luggage/wxa/f8/a;", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "I", "l", "()I", "Lcom/tencent/luggage/wxa/f8/u;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/luggage/wxa/f8/u;", "o", "p", "<init>", "(FLcom/tencent/luggage/wxa/f8/a;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/luggage/wxa/f8/u;Ljava/lang/String;Ljava/lang/String;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.luggage.wxa.f8.p, reason: from toString */
/* loaded from: classes8.dex */
public final /* data */ class LipStickInfoV1 implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final a blendMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pathMd5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int faceModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final u shimmerType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shimmerPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String shimmerPathMd5;

    public LipStickInfoV1(@FloatRange(from = 0.0d, to = 1.0d) float f16, @NotNull a blendMode, @NotNull String path, @Nullable String str, int i3, @NotNull u shimmerType, @NotNull String shimmerPath, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(shimmerType, "shimmerType");
        Intrinsics.checkNotNullParameter(shimmerPath, "shimmerPath");
        this.alpha = f16;
        this.blendMode = blendMode;
        this.path = path;
        this.pathMd5 = str;
        this.faceModel = i3;
        this.shimmerType = shimmerType;
        this.shimmerPath = shimmerPath;
        this.shimmerPathMd5 = str2;
    }

    @NotNull
    public final LipStickInfoV1 a(@FloatRange(from = 0.0d, to = 1.0d) float alpha, @NotNull a blendMode, @NotNull String path, @Nullable String pathMd5, int faceModel, @NotNull u shimmerType, @NotNull String shimmerPath, @Nullable String shimmerPathMd5) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(shimmerType, "shimmerType");
        Intrinsics.checkNotNullParameter(shimmerPath, "shimmerPath");
        return new LipStickInfoV1(alpha, blendMode, path, pathMd5, faceModel, shimmerType, shimmerPath, shimmerPathMd5);
    }

    /* renamed from: b, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final a getBlendMode() {
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
        if (!(other instanceof LipStickInfoV1)) {
            return false;
        }
        LipStickInfoV1 lipStickInfoV1 = (LipStickInfoV1) other;
        if (Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(lipStickInfoV1.alpha)) && this.blendMode == lipStickInfoV1.blendMode && Intrinsics.areEqual(this.path, lipStickInfoV1.path) && Intrinsics.areEqual(this.pathMd5, lipStickInfoV1.pathMd5) && this.faceModel == lipStickInfoV1.faceModel && this.shimmerType == lipStickInfoV1.shimmerType && Intrinsics.areEqual(this.shimmerPath, lipStickInfoV1.shimmerPath) && Intrinsics.areEqual(this.shimmerPathMd5, lipStickInfoV1.shimmerPathMd5)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getFaceModel() {
        return this.faceModel;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final u getShimmerType() {
        return this.shimmerType;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getShimmerPath() {
        return this.shimmerPath;
    }

    public int hashCode() {
        int hashCode;
        int floatToIntBits = ((((Float.floatToIntBits(this.alpha) * 31) + this.blendMode.hashCode()) * 31) + this.path.hashCode()) * 31;
        String str = this.pathMd5;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode2 = (((((((floatToIntBits + hashCode) * 31) + this.faceModel) * 31) + this.shimmerType.hashCode()) * 31) + this.shimmerPath.hashCode()) * 31;
        String str2 = this.shimmerPathMd5;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode2 + i3;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getShimmerPathMd5() {
        return this.shimmerPathMd5;
    }

    public final float j() {
        return this.alpha;
    }

    @NotNull
    public final a k() {
        return this.blendMode;
    }

    public final int l() {
        return this.faceModel;
    }

    @NotNull
    public final String m() {
        return this.path;
    }

    @Nullable
    public final String n() {
        return this.pathMd5;
    }

    @NotNull
    public final String o() {
        return this.shimmerPath;
    }

    @Nullable
    public final String p() {
        return this.shimmerPathMd5;
    }

    @NotNull
    public final u q() {
        return this.shimmerType;
    }

    @NotNull
    public String toString() {
        return "LipStickInfoV1(alpha=" + this.alpha + ", blendMode=" + this.blendMode + ", path=" + this.path + ", pathMd5=" + this.pathMd5 + ", faceModel=" + this.faceModel + ", shimmerType=" + this.shimmerType + ", shimmerPath=" + this.shimmerPath + ", shimmerPathMd5=" + this.shimmerPathMd5 + ')';
    }

    @Override // com.tencent.luggage.wxa.f8.i
    @NotNull
    public String a() {
        return "LipStickInfoV1(path='" + this.path + "', pathMd5='" + this.pathMd5 + "', shimmerPath=" + this.shimmerPath + ", shimmerPathMd5='" + this.shimmerPathMd5 + "')";
    }

    public /* synthetic */ LipStickInfoV1(float f16, a aVar, String str, String str2, int i3, u uVar, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, aVar, str, (i16 & 8) != 0 ? "" : str2, i3, uVar, str3, (i16 & 128) != 0 ? "" : str4);
    }
}
