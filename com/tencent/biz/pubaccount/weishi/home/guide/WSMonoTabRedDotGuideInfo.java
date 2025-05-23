package com.tencent.biz.pubaccount.weishi.home.guide;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/guide/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "setShow", "(Z)V", ViewStickEventHelper.IS_SHOW, "", "J", "()J", "setIntervalDurationSec", "(J)V", "intervalDurationSec", "<init>", "(ZJ)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.home.guide.h, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class WSMonoTabRedDotGuideInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isShow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long intervalDurationSec;

    public WSMonoTabRedDotGuideInfo() {
        this(false, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getIntervalDurationSec() {
        return this.intervalDurationSec;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isShow;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + f.a(this.intervalDurationSec);
    }

    public String toString() {
        return "WSMonoTabRedDotGuideInfo(isShow=" + this.isShow + ", intervalDurationSec=" + this.intervalDurationSec + ")";
    }

    public WSMonoTabRedDotGuideInfo(boolean z16, long j3) {
        this.isShow = z16;
        this.intervalDurationSec = j3;
    }

    public /* synthetic */ WSMonoTabRedDotGuideInfo(boolean z16, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? 3600L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSMonoTabRedDotGuideInfo)) {
            return false;
        }
        WSMonoTabRedDotGuideInfo wSMonoTabRedDotGuideInfo = (WSMonoTabRedDotGuideInfo) other;
        return this.isShow == wSMonoTabRedDotGuideInfo.isShow && this.intervalDurationSec == wSMonoTabRedDotGuideInfo.intervalDurationSec;
    }
}
