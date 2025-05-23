package com.tencent.state.library.calendar;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/library/calendar/CalendarGuideConfig;", "Ljava/io/Serializable;", ViewStickEventHelper.IS_SHOW, "", "iconUrl", "", "title", "detail", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "getIconUrl", "()Z", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class CalendarGuideConfig implements Serializable {
    private final String detail;
    private final String iconUrl;
    private final boolean isShow;
    private final String title;

    public CalendarGuideConfig() {
        this(false, null, null, null, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    public final CalendarGuideConfig copy(boolean isShow, String iconUrl, String title, String detail) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(detail, "detail");
        return new CalendarGuideConfig(isShow, iconUrl, title, detail);
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isShow;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.iconUrl;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.detail;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public String toString() {
        return "CalendarGuideConfig(isShow=" + this.isShow + ", iconUrl=" + this.iconUrl + ", title=" + this.title + ", detail=" + this.detail + ")";
    }

    public CalendarGuideConfig(boolean z16, String iconUrl, String title, String detail) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.isShow = z16;
        this.iconUrl = iconUrl;
        this.title = title;
        this.detail = detail;
    }

    public /* synthetic */ CalendarGuideConfig(boolean z16, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarGuideConfig)) {
            return false;
        }
        CalendarGuideConfig calendarGuideConfig = (CalendarGuideConfig) other;
        return this.isShow == calendarGuideConfig.isShow && Intrinsics.areEqual(this.iconUrl, calendarGuideConfig.iconUrl) && Intrinsics.areEqual(this.title, calendarGuideConfig.title) && Intrinsics.areEqual(this.detail, calendarGuideConfig.detail);
    }

    public static /* synthetic */ CalendarGuideConfig copy$default(CalendarGuideConfig calendarGuideConfig, boolean z16, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = calendarGuideConfig.isShow;
        }
        if ((i3 & 2) != 0) {
            str = calendarGuideConfig.iconUrl;
        }
        if ((i3 & 4) != 0) {
            str2 = calendarGuideConfig.title;
        }
        if ((i3 & 8) != 0) {
            str3 = calendarGuideConfig.detail;
        }
        return calendarGuideConfig.copy(z16, str, str2, str3);
    }
}
