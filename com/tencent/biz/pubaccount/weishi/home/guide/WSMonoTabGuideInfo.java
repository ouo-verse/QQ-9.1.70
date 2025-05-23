package com.tencent.biz.pubaccount.weishi.home.guide;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/guide/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/biz/pubaccount/weishi/home/guide/g;", "a", "Lcom/tencent/biz/pubaccount/weishi/home/guide/g;", "()Lcom/tencent/biz/pubaccount/weishi/home/guide/g;", "setPopupWindowGuideInfo", "(Lcom/tencent/biz/pubaccount/weishi/home/guide/g;)V", "popupWindowGuideInfo", "Lcom/tencent/biz/pubaccount/weishi/home/guide/h;", "b", "Lcom/tencent/biz/pubaccount/weishi/home/guide/h;", "()Lcom/tencent/biz/pubaccount/weishi/home/guide/h;", "setRedDotGuideInfo", "(Lcom/tencent/biz/pubaccount/weishi/home/guide/h;)V", "redDotGuideInfo", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/home/guide/g;Lcom/tencent/biz/pubaccount/weishi/home/guide/h;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.home.guide.c, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class WSMonoTabGuideInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private WSMonoTabPopupWindowGuideInfo popupWindowGuideInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private WSMonoTabRedDotGuideInfo redDotGuideInfo;

    public WSMonoTabGuideInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final WSMonoTabPopupWindowGuideInfo getPopupWindowGuideInfo() {
        return this.popupWindowGuideInfo;
    }

    /* renamed from: b, reason: from getter */
    public final WSMonoTabRedDotGuideInfo getRedDotGuideInfo() {
        return this.redDotGuideInfo;
    }

    public int hashCode() {
        return (this.popupWindowGuideInfo.hashCode() * 31) + this.redDotGuideInfo.hashCode();
    }

    public String toString() {
        return "WSMonoTabGuideInfo(popupWindowGuideInfo=" + this.popupWindowGuideInfo + ", redDotGuideInfo=" + this.redDotGuideInfo + ")";
    }

    public WSMonoTabGuideInfo(WSMonoTabPopupWindowGuideInfo popupWindowGuideInfo, WSMonoTabRedDotGuideInfo redDotGuideInfo) {
        Intrinsics.checkNotNullParameter(popupWindowGuideInfo, "popupWindowGuideInfo");
        Intrinsics.checkNotNullParameter(redDotGuideInfo, "redDotGuideInfo");
        this.popupWindowGuideInfo = popupWindowGuideInfo;
        this.redDotGuideInfo = redDotGuideInfo;
    }

    public /* synthetic */ WSMonoTabGuideInfo(WSMonoTabPopupWindowGuideInfo wSMonoTabPopupWindowGuideInfo, WSMonoTabRedDotGuideInfo wSMonoTabRedDotGuideInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new WSMonoTabPopupWindowGuideInfo(false, null, null, null, 0L, 0, 0, 127, null) : wSMonoTabPopupWindowGuideInfo, (i3 & 2) != 0 ? new WSMonoTabRedDotGuideInfo(false, 0L, 3, null) : wSMonoTabRedDotGuideInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSMonoTabGuideInfo)) {
            return false;
        }
        WSMonoTabGuideInfo wSMonoTabGuideInfo = (WSMonoTabGuideInfo) other;
        return Intrinsics.areEqual(this.popupWindowGuideInfo, wSMonoTabGuideInfo.popupWindowGuideInfo) && Intrinsics.areEqual(this.redDotGuideInfo, wSMonoTabGuideInfo.redDotGuideInfo);
    }
}
