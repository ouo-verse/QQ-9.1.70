package ib4;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lib4/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "iconResId", "b", "c", "textResId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "d", "Z", "()Z", "e", "(Z)V", "isChecked", "<init>", "(IIIZ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ib4.i, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ZplanPrivacyData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int iconResId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textResId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int showType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isChecked;

    public ZplanPrivacyData(int i3, int i16, int i17, boolean z16) {
        this.iconResId = i3;
        this.textResId = i16;
        this.showType = i17;
        this.isChecked = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    /* renamed from: b, reason: from getter */
    public final int getShowType() {
        return this.showType;
    }

    /* renamed from: c, reason: from getter */
    public final int getTextResId() {
        return this.textResId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void e(boolean z16) {
        this.isChecked = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((((this.iconResId * 31) + this.textResId) * 31) + this.showType) * 31;
        boolean z16 = this.isChecked;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    public String toString() {
        return "ZplanPrivacyData(iconResId=" + this.iconResId + ", textResId=" + this.textResId + ", showType=" + this.showType + ", isChecked=" + this.isChecked + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZplanPrivacyData)) {
            return false;
        }
        ZplanPrivacyData zplanPrivacyData = (ZplanPrivacyData) other;
        return this.iconResId == zplanPrivacyData.iconResId && this.textResId == zplanPrivacyData.textResId && this.showType == zplanPrivacyData.showType && this.isChecked == zplanPrivacyData.isChecked;
    }
}
