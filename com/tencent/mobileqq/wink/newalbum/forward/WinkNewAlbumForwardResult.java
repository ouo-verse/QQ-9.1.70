package com.tencent.mobileqq.wink.newalbum.forward;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/forward/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "[F", "d", "()[F", "f", "([F)V", "photoFeature", "Lcom/tencent/mobileqq/wink/newalbum/forward/a;", "b", "Lcom/tencent/mobileqq/wink/newalbum/forward/a;", "c", "()Lcom/tencent/mobileqq/wink/newalbum/forward/a;", "e", "(Lcom/tencent/mobileqq/wink/newalbum/forward/a;)V", "forwardCallback", "<init>", "([FLcom/tencent/mobileqq/wink/newalbum/forward/a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.forward.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumForwardResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private float[] photoFeature;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private a forwardCallback;

    public WinkNewAlbumForwardResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final a getForwardCallback() {
        return this.forwardCallback;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final float[] getPhotoFeature() {
        return this.photoFeature;
    }

    public final void e(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.forwardCallback = aVar;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumForwardResult)) {
            return false;
        }
        WinkNewAlbumForwardResult winkNewAlbumForwardResult = (WinkNewAlbumForwardResult) other;
        if (Intrinsics.areEqual(this.photoFeature, winkNewAlbumForwardResult.photoFeature) && Intrinsics.areEqual(this.forwardCallback, winkNewAlbumForwardResult.forwardCallback)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.photoFeature = fArr;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.photoFeature) * 31) + this.forwardCallback.hashCode();
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumForwardResult(photoFeature=" + Arrays.toString(this.photoFeature) + ", forwardCallback=" + this.forwardCallback + ")";
    }

    public WinkNewAlbumForwardResult(@NotNull float[] photoFeature, @NotNull a forwardCallback) {
        Intrinsics.checkNotNullParameter(photoFeature, "photoFeature");
        Intrinsics.checkNotNullParameter(forwardCallback, "forwardCallback");
        this.photoFeature = photoFeature;
        this.forwardCallback = forwardCallback;
    }

    public /* synthetic */ WinkNewAlbumForwardResult(float[] fArr, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new float[1024] : fArr, (i3 & 2) != 0 ? new a() { // from class: com.tencent.mobileqq.wink.newalbum.forward.d
            @Override // com.tencent.mobileqq.wink.newalbum.forward.a
            public final void a(float[] fArr2, boolean z16) {
                WinkNewAlbumForwardResult.b(fArr2, z16);
            }
        } : aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(float[] fArr, boolean z16) {
    }
}
