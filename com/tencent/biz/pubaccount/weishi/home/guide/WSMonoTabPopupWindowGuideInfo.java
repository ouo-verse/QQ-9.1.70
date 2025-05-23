package com.tencent.biz.pubaccount.weishi.home.guide;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u001c\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010$\u001a\u0004\b\u0019\u0010%\"\u0004\b&\u0010'R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010$\u001a\u0004\b\u001d\u0010%\"\u0004\b)\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/guide/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "g", "()Z", "setShow", "(Z)V", ViewStickEventHelper.IS_SHOW, "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "bgColor", "c", "setDesc", "desc", "d", "setDescColor", "descColor", "", "e", "J", "f", "()J", "setShowDurationSec", "(J)V", "showDurationSec", "I", "()I", "setIntervalDays", "(I)V", "intervalDays", "setMaxTimes", "maxTimes", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JII)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.home.guide.g, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class WSMonoTabPopupWindowGuideInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isShow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String bgColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String descColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long showDurationSec;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int intervalDays;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int maxTimes;

    public WSMonoTabPopupWindowGuideInfo() {
        this(false, null, null, null, 0L, 0, 0, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getBgColor() {
        return this.bgColor;
    }

    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescColor() {
        return this.descColor;
    }

    /* renamed from: d, reason: from getter */
    public final int getIntervalDays() {
        return this.intervalDays;
    }

    /* renamed from: e, reason: from getter */
    public final int getMaxTimes() {
        return this.maxTimes;
    }

    /* renamed from: f, reason: from getter */
    public final long getShowDurationSec() {
        return this.showDurationSec;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z16 = this.isShow;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((((((r06 * 31) + this.bgColor.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.descColor.hashCode()) * 31) + f.a(this.showDurationSec)) * 31) + this.intervalDays) * 31) + this.maxTimes;
    }

    public String toString() {
        return "WSMonoTabPopupWindowGuideInfo(isShow=" + this.isShow + ", bgColor=" + this.bgColor + ", desc=" + this.desc + ", descColor=" + this.descColor + ", showDurationSec=" + this.showDurationSec + ", intervalDays=" + this.intervalDays + ", maxTimes=" + this.maxTimes + ")";
    }

    public WSMonoTabPopupWindowGuideInfo(boolean z16, String bgColor, String desc, String descColor, long j3, int i3, int i16) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(descColor, "descColor");
        this.isShow = z16;
        this.bgColor = bgColor;
        this.desc = desc;
        this.descColor = descColor;
        this.showDurationSec = j3;
        this.intervalDays = i3;
        this.maxTimes = i16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSMonoTabPopupWindowGuideInfo)) {
            return false;
        }
        WSMonoTabPopupWindowGuideInfo wSMonoTabPopupWindowGuideInfo = (WSMonoTabPopupWindowGuideInfo) other;
        return this.isShow == wSMonoTabPopupWindowGuideInfo.isShow && Intrinsics.areEqual(this.bgColor, wSMonoTabPopupWindowGuideInfo.bgColor) && Intrinsics.areEqual(this.desc, wSMonoTabPopupWindowGuideInfo.desc) && Intrinsics.areEqual(this.descColor, wSMonoTabPopupWindowGuideInfo.descColor) && this.showDurationSec == wSMonoTabPopupWindowGuideInfo.showDurationSec && this.intervalDays == wSMonoTabPopupWindowGuideInfo.intervalDays && this.maxTimes == wSMonoTabPopupWindowGuideInfo.maxTimes;
    }

    public /* synthetic */ WSMonoTabPopupWindowGuideInfo(boolean z16, String str, String str2, String str3, long j3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? "#FFFFFF" : str, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? "#000000" : str3, (i17 & 16) != 0 ? 5L : j3, (i17 & 32) != 0 ? 7 : i3, (i17 & 64) != 0 ? 3 : i16);
    }
}
