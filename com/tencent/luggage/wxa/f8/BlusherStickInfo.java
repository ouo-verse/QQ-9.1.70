package com.tencent.luggage.wxa.f8;

import androidx.annotation.FloatRange;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J=\u0010\u0003\u001a\u00020\u00002\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b#\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/luggage/wxa/f8/b;", "Lcom/tencent/luggage/wxa/f8/i;", "", "a", "", "b", "", "c", "Lcom/tencent/luggage/wxa/f8/a;", "d", "e", "f", com.tencent.luggage.wxa.c8.c.f123400v, com.tencent.luggage.wxa.c8.c.T, com.tencent.luggage.wxa.c8.c.W, "path", com.tencent.luggage.wxa.c8.c.Y, "toString", "hashCode", "", "other", "", "equals", UserInfo.SEX_FEMALE, "g", "()F", "I", "i", "()I", "Lcom/tencent/luggage/wxa/f8/a;", tl.h.F, "()Lcom/tencent/luggage/wxa/f8/a;", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "k", "<init>", "(FILcom/tencent/luggage/wxa/f8/a;Ljava/lang/String;Ljava/lang/String;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.luggage.wxa.f8.b, reason: from toString */
/* loaded from: classes8.dex */
public final /* data */ class BlusherStickInfo implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int faceModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final a blendMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pathMd5;

    public BlusherStickInfo(@FloatRange(from = 0.0d, to = 1.0d) float f16, int i3, @NotNull a blendMode, @NotNull String path, @Nullable String str) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(path, "path");
        this.alpha = f16;
        this.faceModel = i3;
        this.blendMode = blendMode;
        this.path = path;
        this.pathMd5 = str;
    }

    @NotNull
    public final BlusherStickInfo a(@FloatRange(from = 0.0d, to = 1.0d) float alpha, int faceModel, @NotNull a blendMode, @NotNull String path, @Nullable String pathMd5) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(path, "path");
        return new BlusherStickInfo(alpha, faceModel, blendMode, path, pathMd5);
    }

    /* renamed from: b, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: c, reason: from getter */
    public final int getFaceModel() {
        return this.faceModel;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final a getBlendMode() {
        return this.blendMode;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlusherStickInfo)) {
            return false;
        }
        BlusherStickInfo blusherStickInfo = (BlusherStickInfo) other;
        if (Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(blusherStickInfo.alpha)) && this.faceModel == blusherStickInfo.faceModel && this.blendMode == blusherStickInfo.blendMode && Intrinsics.areEqual(this.path, blusherStickInfo.path) && Intrinsics.areEqual(this.pathMd5, blusherStickInfo.pathMd5)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getPathMd5() {
        return this.pathMd5;
    }

    public final float g() {
        return this.alpha;
    }

    @NotNull
    public final a h() {
        return this.blendMode;
    }

    public int hashCode() {
        int hashCode;
        int floatToIntBits = ((((((Float.floatToIntBits(this.alpha) * 31) + this.faceModel) * 31) + this.blendMode.hashCode()) * 31) + this.path.hashCode()) * 31;
        String str = this.pathMd5;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return floatToIntBits + hashCode;
    }

    public final int i() {
        return this.faceModel;
    }

    @NotNull
    public final String j() {
        return this.path;
    }

    @Nullable
    public final String k() {
        return this.pathMd5;
    }

    @NotNull
    public String toString() {
        return "BlusherStickInfo(alpha=" + this.alpha + ", faceModel=" + this.faceModel + ", blendMode=" + this.blendMode + ", path=" + this.path + ", pathMd5=" + this.pathMd5 + ')';
    }

    public static /* synthetic */ BlusherStickInfo a(BlusherStickInfo blusherStickInfo, float f16, int i3, a aVar, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            f16 = blusherStickInfo.alpha;
        }
        if ((i16 & 2) != 0) {
            i3 = blusherStickInfo.faceModel;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            aVar = blusherStickInfo.blendMode;
        }
        a aVar2 = aVar;
        if ((i16 & 8) != 0) {
            str = blusherStickInfo.path;
        }
        String str3 = str;
        if ((i16 & 16) != 0) {
            str2 = blusherStickInfo.pathMd5;
        }
        return blusherStickInfo.a(f16, i17, aVar2, str3, str2);
    }

    @Override // com.tencent.luggage.wxa.f8.i
    @NotNull
    public String a() {
        return "BlusherStickInfo(path='" + this.path + "', pathMd5='" + this.pathMd5 + "')";
    }

    public /* synthetic */ BlusherStickInfo(float f16, int i3, a aVar, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, i3, aVar, str, (i16 & 16) != 0 ? "" : str2);
    }
}
