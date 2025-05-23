package com.tencent.luggage.wxa.f8;

import androidx.annotation.FloatRange;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J3\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0003\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001d\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/luggage/wxa/f8/e;", "Lcom/tencent/luggage/wxa/f8/i;", "", "a", "", "b", "", "c", "d", "e", com.tencent.luggage.wxa.c8.c.T, com.tencent.luggage.wxa.c8.c.f123400v, "path", com.tencent.luggage.wxa.c8.c.Y, "toString", "hashCode", "", "other", "", "equals", "I", "g", "()I", UserInfo.SEX_FEMALE, "f", "()F", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "i", "<init>", "(IFLjava/lang/String;Ljava/lang/String;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.luggage.wxa.f8.e, reason: from toString */
/* loaded from: classes8.dex */
public final /* data */ class FaceContourInfo implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int faceModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float alpha;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pathMd5;

    public FaceContourInfo(int i3, @FloatRange(from = 0.0d, to = 1.0d) float f16, @NotNull String path, @Nullable String str) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.faceModel = i3;
        this.alpha = f16;
        this.path = path;
        this.pathMd5 = str;
    }

    @NotNull
    public final FaceContourInfo a(int faceModel, @FloatRange(from = 0.0d, to = 1.0d) float alpha, @NotNull String path, @Nullable String pathMd5) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new FaceContourInfo(faceModel, alpha, path, pathMd5);
    }

    /* renamed from: b, reason: from getter */
    public final int getFaceModel() {
        return this.faceModel;
    }

    /* renamed from: c, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
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
        if (!(other instanceof FaceContourInfo)) {
            return false;
        }
        FaceContourInfo faceContourInfo = (FaceContourInfo) other;
        if (this.faceModel == faceContourInfo.faceModel && Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(faceContourInfo.alpha)) && Intrinsics.areEqual(this.path, faceContourInfo.path) && Intrinsics.areEqual(this.pathMd5, faceContourInfo.pathMd5)) {
            return true;
        }
        return false;
    }

    public final float f() {
        return this.alpha;
    }

    public final int g() {
        return this.faceModel;
    }

    @NotNull
    public final String h() {
        return this.path;
    }

    public int hashCode() {
        int hashCode;
        int floatToIntBits = ((((this.faceModel * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.path.hashCode()) * 31;
        String str = this.pathMd5;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return floatToIntBits + hashCode;
    }

    @Nullable
    public final String i() {
        return this.pathMd5;
    }

    @NotNull
    public String toString() {
        return "FaceContourInfo(faceModel=" + this.faceModel + ", alpha=" + this.alpha + ", path=" + this.path + ", pathMd5=" + this.pathMd5 + ')';
    }

    public static /* synthetic */ FaceContourInfo a(FaceContourInfo faceContourInfo, int i3, float f16, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = faceContourInfo.faceModel;
        }
        if ((i16 & 2) != 0) {
            f16 = faceContourInfo.alpha;
        }
        if ((i16 & 4) != 0) {
            str = faceContourInfo.path;
        }
        if ((i16 & 8) != 0) {
            str2 = faceContourInfo.pathMd5;
        }
        return faceContourInfo.a(i3, f16, str, str2);
    }

    @Override // com.tencent.luggage.wxa.f8.i
    @NotNull
    public String a() {
        return "FaceContourInfo(path='" + this.path + "', pathMd5='" + this.pathMd5 + "')";
    }

    public /* synthetic */ FaceContourInfo(int i3, float f16, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, f16, str, (i16 & 8) != 0 ? "" : str2);
    }
}
