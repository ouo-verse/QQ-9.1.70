package com.tencent.mobileqq.service.qzone.bean;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\fR\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\fR\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/service/qzone/bean/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "holidayId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "beginTime", "I", "a", "()I", "endTime", "b", "addTitle", "getAddTitle", "addDesc", "getAddDesc", "addIcon", "getAddIcon", "publishText", "f", "publishBgDay", "d", "publishBgNight", "e", "publishTextColorDay", "g", "publishTextColorNight", h.F, "thirdPartAppId", "i", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    @SerializedName("add_desc")
    @NotNull
    private final String addDesc;

    @SerializedName("add_icon")
    @NotNull
    private final String addIcon;

    @SerializedName("add_title")
    @NotNull
    private final String addTitle;

    @SerializedName(QCircleLpReportDc05502.KEY_BEGIN_TIME)
    private final int beginTime;

    @SerializedName("end_time")
    private final int endTime;

    @SerializedName("holiday_id")
    @NotNull
    private final String holidayId;

    @SerializedName("publish_bg_day")
    @NotNull
    private final String publishBgDay;

    @SerializedName("publish_bg_night")
    @NotNull
    private final String publishBgNight;

    @SerializedName("publish_text")
    @NotNull
    private final String publishText;

    @SerializedName("publish_text_color_day")
    @NotNull
    private final String publishTextColorDay;

    @SerializedName("publish_text_color_night")
    @NotNull
    private final String publishTextColorNight;

    @SerializedName(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID)
    @NotNull
    private final String thirdPartAppId;

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.beginTime;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.endTime;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.holidayId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.publishBgDay;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.publishBgNight;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.holidayId, cVar.holidayId) && this.beginTime == cVar.beginTime && this.endTime == cVar.endTime && Intrinsics.areEqual(this.addTitle, cVar.addTitle) && Intrinsics.areEqual(this.addDesc, cVar.addDesc) && Intrinsics.areEqual(this.addIcon, cVar.addIcon) && Intrinsics.areEqual(this.publishText, cVar.publishText) && Intrinsics.areEqual(this.publishBgDay, cVar.publishBgDay) && Intrinsics.areEqual(this.publishBgNight, cVar.publishBgNight) && Intrinsics.areEqual(this.publishTextColorDay, cVar.publishTextColorDay) && Intrinsics.areEqual(this.publishTextColorNight, cVar.publishTextColorNight) && Intrinsics.areEqual(this.thirdPartAppId, cVar.thirdPartAppId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.publishText;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.publishTextColorDay;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.publishTextColorNight;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return (((((((((((((((((((((this.holidayId.hashCode() * 31) + this.beginTime) * 31) + this.endTime) * 31) + this.addTitle.hashCode()) * 31) + this.addDesc.hashCode()) * 31) + this.addIcon.hashCode()) * 31) + this.publishText.hashCode()) * 31) + this.publishBgDay.hashCode()) * 31) + this.publishBgNight.hashCode()) * 31) + this.publishTextColorDay.hashCode()) * 31) + this.publishTextColorNight.hashCode()) * 31) + this.thirdPartAppId.hashCode();
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.thirdPartAppId;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "QZoneHolidayPublishConfBean(holidayId=" + this.holidayId + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", addTitle=" + this.addTitle + ", addDesc=" + this.addDesc + ", addIcon=" + this.addIcon + ", publishText=" + this.publishText + ", publishBgDay=" + this.publishBgDay + ", publishBgNight=" + this.publishBgNight + ", publishTextColorDay=" + this.publishTextColorDay + ", publishTextColorNight=" + this.publishTextColorNight + ", thirdPartAppId=" + this.thirdPartAppId + ")";
    }
}
