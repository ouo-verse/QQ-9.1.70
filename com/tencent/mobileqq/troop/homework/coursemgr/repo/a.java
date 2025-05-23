package com.tencent.mobileqq.troop.homework.coursemgr.repo;

import android.os.Bundle;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001\u0003BS\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/a;", "", "", "a", "Lcom/tencent/common/app/AppInterface;", "appInterface", "psKey", IPublicAccountDetailReportUtil.KEY_SEARCH, "Landroid/os/Bundle;", "c", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "b", "I", "()I", "mgrType", "Ljava/lang/Integer;", "courseId", "d", "courseName", "e", "oriCourseName", "f", "startDate", "g", "getEndDate", "endDate", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", h.F, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mgrType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer courseId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String courseName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String oriCourseName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String startDate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String endDate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/a$a;", "", "", "MGR_TYPE_ADD", "I", "MGR_TYPE_DELETE", "MGR_TYPE_QUERY", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.coursemgr.repo.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50685);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull String troopUin, int i3, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, Integer.valueOf(i3), num, str, str2, str3, str4);
            return;
        }
        this.troopUin = troopUin;
        this.mgrType = i3;
        this.courseId = num;
        this.courseName = str;
        this.oriCourseName = str2;
        this.startDate = str3;
        this.endDate = str4;
    }

    private final String a() {
        int i3 = this.mgrType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return "delete";
            }
            return "add";
        }
        return "query";
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mgrType;
    }

    @NotNull
    public final Bundle c(@NotNull AppInterface appInterface, @Nullable String psKey, @Nullable String sKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, this, appInterface, psKey, sKey);
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Bundle bundle = new Bundle();
        bundle.putString("group_id", this.troopUin);
        bundle.putString("subcmd", a());
        bundle.putString(AudienceReportConst.CLIENT_TYPE, "1");
        bundle.putString("bkn", String.valueOf(((ITroopHWApi) QRoute.api(ITroopHWApi.class)).getBknBySkey(sKey)));
        bundle.putString("Cookie", "uin=o" + appInterface.getCurrentUin() + ";skey=" + sKey + ";p_uin=o" + appInterface.getCurrentUin() + ";p_skey=" + psKey);
        Integer num = this.courseId;
        if (num != null) {
            bundle.putInt("course_id", num.intValue());
        }
        String str = this.courseName;
        if (str != null) {
            bundle.putString(Element.ELEMENT_NAME_COURSE_NAME, str);
        }
        String str2 = this.oriCourseName;
        if (str2 != null) {
            bundle.putString("ori_course_name", str2);
        }
        String str3 = this.startDate;
        if (str3 != null) {
            bundle.putString("start_date", str3);
        }
        String str4 = this.endDate;
        if (str4 != null) {
            bundle.putString("end_date", str4);
        }
        return bundle;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.troopUin, aVar.troopUin) && this.mgrType == aVar.mgrType && Intrinsics.areEqual(this.courseId, aVar.courseId) && Intrinsics.areEqual(this.courseName, aVar.courseName) && Intrinsics.areEqual(this.oriCourseName, aVar.oriCourseName) && Intrinsics.areEqual(this.startDate, aVar.startDate) && Intrinsics.areEqual(this.endDate, aVar.endDate)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int hashCode5 = ((this.troopUin.hashCode() * 31) + this.mgrType) * 31;
        Integer num = this.courseId;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = (hashCode5 + hashCode) * 31;
        String str = this.courseName;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.oriCourseName;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.startDate;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str4 = this.endDate;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "TroopHwCourseMgrReq(troopUin=" + this.troopUin + ", mgrType=" + this.mgrType + ", courseId=" + this.courseId + ", courseName=" + this.courseName + ", oriCourseName=" + this.oriCourseName + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
    }

    public /* synthetic */ a(String str, int i3, Integer num, String str2, String str3, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? null : num, (i16 & 8) != 0 ? null : str2, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? null : str4, (i16 & 64) != 0 ? null : str5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), num, str2, str3, str4, str5, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
