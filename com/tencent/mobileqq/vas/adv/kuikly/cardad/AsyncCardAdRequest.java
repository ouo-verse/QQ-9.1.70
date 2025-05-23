package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u000e\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getPosId", "()Ljava/lang/String;", "posId", "b", "Z", "getFinished", "()Z", "(Z)V", IXWebBroadcastListener.STAGE_FINISHED, "Lcom/tencent/gdtad/aditem/GdtAd;", "c", "Lcom/tencent/gdtad/aditem/GdtAd;", "()Lcom/tencent/gdtad/aditem/GdtAd;", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "result", "<init>", "(Ljava/lang/String;ZLcom/tencent/gdtad/aditem/GdtAd;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.adv.kuikly.cardad.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class AsyncCardAdRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String posId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean finished;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private GdtAd result;

    public AsyncCardAdRequest(@NotNull String posId, boolean z16, @Nullable GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        this.posId = posId;
        this.finished = z16;
        this.result = gdtAd;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final GdtAd getResult() {
        return this.result;
    }

    public final void b(boolean z16) {
        this.finished = z16;
    }

    public final void c(@Nullable GdtAd gdtAd) {
        this.result = gdtAd;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsyncCardAdRequest)) {
            return false;
        }
        AsyncCardAdRequest asyncCardAdRequest = (AsyncCardAdRequest) other;
        if (Intrinsics.areEqual(this.posId, asyncCardAdRequest.posId) && this.finished == asyncCardAdRequest.finished && Intrinsics.areEqual(this.result, asyncCardAdRequest.result)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.posId.hashCode() * 31;
        boolean z16 = this.finished;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        GdtAd gdtAd = this.result;
        if (gdtAd == null) {
            hashCode = 0;
        } else {
            hashCode = gdtAd.hashCode();
        }
        return i16 + hashCode;
    }

    @NotNull
    public String toString() {
        return "AsyncCardAdRequest(posId=" + this.posId + ", finished=" + this.finished + ", result=" + this.result + ')';
    }

    public /* synthetic */ AsyncCardAdRequest(String str, boolean z16, GdtAd gdtAd, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? null : gdtAd);
    }
}
