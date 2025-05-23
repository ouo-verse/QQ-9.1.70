package kc2;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0002*\u00020\t\u001a\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f\u001a\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0002\u001a\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0017\u001a\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010!\u001a\u00020 2\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\"\u001a\u00020\u0002\u001a\u0006\u0010#\u001a\u00020\u0002\u001a\b\u0010%\u001a\u00020$H\u0002\u001a\u0006\u0010&\u001a\u00020\u0002\u001a\u0006\u0010'\u001a\u00020\u0002\u001a\u0016\u0010(\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u000e\u0010)\u001a\u00020 2\u0006\u0010\u0001\u001a\u00020\u0000\"\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b,\u0010-\"\u0017\u00100\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b/\u0010-\u00a8\u00061"}, d2 = {"Lmqq/app/AppRuntime;", "app", "", "todayConstellationTrend", "", "t", HippyTKDListViewAdapter.X, "uin", "w", "Lcom/tencent/mobileqq/data/Friends;", "b", "v", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "onlineStatusSimpleInfo", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "k", "l", DomainData.DOMAIN_NAME, "a", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, ReportConstant.COSTREPORT_PREFIX, "", h.F, "color", "r", "e", "c", "ts", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "", "o", "f", "g", "Ljava/util/Date;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "i", "p", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "j", "()Ljava/text/SimpleDateFormat;", "defaultDateFormat", "getDefaultRequestDateFormat", "defaultRequestDateFormat", "qqonlinestatus-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final SimpleDateFormat f412019a = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SimpleDateFormat f412020b = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);

    @NotNull
    public static final String A() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(m());
        calendar.add(5, -1);
        String format = f412020b.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "defaultRequestDateFormat.format(cal.time)");
        return format;
    }

    @Nullable
    public static final String a(@NotNull AppRuntime app) {
        String j3;
        Intrinsics.checkNotNullParameter(app, "app");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("ConstellationUtil");
        if (H == null || (j3 = H.j()) == null) {
            return "";
        }
        return j3;
    }

    @NotNull
    public static final String b(@NotNull Friends friends) {
        Intrinsics.checkNotNullParameter(friends, "<this>");
        return " uin: " + friends.uin + " constellationTodayTrend: " + friends.constellationTodayTrend + " constellationTomorrowTrend: " + friends.constellationTomorrowTrend + " constellationDateStr: " + friends.constellationDateStr;
    }

    @NotNull
    public static final String c(@NotNull AppRuntime app) {
        String m3;
        Intrinsics.checkNotNullParameter(app, "app");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("ConstellationUtil");
        if (H == null || (m3 = H.m()) == null) {
            return "";
        }
        return m3;
    }

    public static final long d(@NotNull AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Object b16 = p.b(MobileQQ.sMobileQQ, app.getCurrentAccountUin(), AppConstants.Preferences.KEY_CONSTELLATION_LAST_REQ_S, 0L);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) b16).longValue();
    }

    @NotNull
    public static final String e(@NotNull AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Object b16 = p.b(MobileQQ.sMobileQQ, app.getCurrentAccountUin(), AppConstants.Preferences.KEY_CONSTELLATION_TEXT_COLOR, "");
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.String");
        return (String) b16;
    }

    @NotNull
    public static final String f() {
        String format = f412019a.format(m());
        Intrinsics.checkNotNullExpressionValue(format, "defaultDateFormat.format(date)");
        return format;
    }

    @NotNull
    public static final String g() {
        String format = f412020b.format(m());
        Intrinsics.checkNotNullExpressionValue(format, "defaultRequestDateFormat.format(date)");
        return format;
    }

    public static final long h(@NotNull AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Object b16 = p.b(MobileQQ.sMobileQQ, app.getCurrentAccountUin(), AppConstants.Preferences.KEY_EXT_INFO_REQ_INTERVAL_S, 0L);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) b16).longValue();
    }

    @NotNull
    public static final String i(@NotNull AppRuntime app, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uin, "uin");
        String constellationStr = bs.u(((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).initCard(app, uin).constellation);
        Intrinsics.checkNotNullExpressionValue(constellationStr, "constellationStr");
        return constellationStr;
    }

    @NotNull
    public static final SimpleDateFormat j() {
        return f412019a;
    }

    @NotNull
    public static final String k(@NotNull String uin) {
        String n3;
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = bs.A(uin, "ConstellationUtil");
        if (A == null || (n3 = A.n()) == null) {
            return "";
        }
        return n3;
    }

    @NotNull
    public static final String l(@NotNull String uin) {
        String o16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = bs.A(uin, "ConstellationUtil");
        if (A == null || (o16 = A.o()) == null) {
            return "";
        }
        return o16;
    }

    private static final Date m() {
        return new Date(NetConnInfoCenter.getServerTimeMillis());
    }

    @Nullable
    public static final String n(@NotNull AppRuntime app) {
        String l3;
        Intrinsics.checkNotNullParameter(app, "app");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("ConstellationUtil");
        if (H == null || (l3 = H.l()) == null) {
            return "";
        }
        return l3;
    }

    public static final boolean o(@NotNull AppRuntime app) {
        boolean z16;
        Intrinsics.checkNotNullParameter(app, "app");
        if ((System.currentTimeMillis() / 1000) - d(app) >= h(app)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationUtil", 2, "isConstellationRequestExpired: called. ", "expired: " + z16);
        }
        return z16;
    }

    public static final boolean p(@NotNull AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        IRuntimeService runtimeService = app.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) runtimeService;
        if (iOnlineStatusService.getOnlineStatus() == AppRuntime.Status.online && iOnlineStatusService.getExtOnlineStatus() == 1040) {
            return true;
        }
        return false;
    }

    public static final void q(@NotNull AppRuntime app, long j3) {
        Intrinsics.checkNotNullParameter(app, "app");
        p.g(MobileQQ.sMobileQQ, app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_CONSTELLATION_LAST_REQ_S, Long.valueOf(j3));
    }

    public static final void r(@NotNull AppRuntime app, @NotNull String color) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(color, "color");
        p.g(MobileQQ.sMobileQQ, app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_CONSTELLATION_TEXT_COLOR, color);
    }

    public static final void s(@NotNull AppRuntime app, int i3) {
        Intrinsics.checkNotNullParameter(app, "app");
        p.g(MobileQQ.sMobileQQ, app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_EXT_INFO_REQ_INTERVAL_S, Integer.valueOf(i3));
    }

    public static final void t(@NotNull AppRuntime app, @Nullable String str) {
        Intrinsics.checkNotNullParameter(app, "app");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String currentAccountUin = app.getCurrentAccountUin();
        if (str == null) {
            str = "";
        }
        p.g(mobileQQ, currentAccountUin, true, AppConstants.Preferences.KEY_TODAY_TRENDS_JSON, str);
    }

    @NotNull
    public static final String u(@NotNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfo) {
        String q16;
        Intrinsics.checkNotNullParameter(onlineStatusSimpleInfo, "onlineStatusSimpleInfo");
        String str = "";
        if (!Intrinsics.areEqual(g(), onlineStatusSimpleInfo.k()) ? !(!Intrinsics.areEqual(A(), onlineStatusSimpleInfo.k()) || (q16 = onlineStatusSimpleInfo.q()) == null) : (q16 = onlineStatusSimpleInfo.p()) != null) {
            str = q16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationUtil", 2, "suitableTrend: " + str);
        }
        return str;
    }

    @NotNull
    public static final String v(@NotNull AppRuntime app, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = bs.A(uin, "ConstellationUtil");
        if (A == null) {
            return "";
        }
        return u(A);
    }

    @NotNull
    public static final String w(@NotNull String uin) {
        String str;
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = bs.A(uin, "ConstellationUtil");
        if (A == null || (str = A.p()) == null) {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationUtil", 2, "todayTrendFromEntity: called. ", "trend: " + str);
        }
        return str;
    }

    @NotNull
    public static final String x(@NotNull AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Object b16 = p.b(MobileQQ.sMobileQQ, app.getCurrentAccountUin(), AppConstants.Preferences.KEY_TODAY_TRENDS_JSON, "");
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.String");
        return (String) b16;
    }

    @NotNull
    public static final String y() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(m());
        calendar.add(5, 1);
        String format = f412020b.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "defaultRequestDateFormat.format(cal.time)");
        return format;
    }

    @NotNull
    public static final String z(@NotNull String uin) {
        String q16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = bs.A(uin, "ConstellationUtil");
        if (A == null || (q16 = A.q()) == null) {
            return "";
        }
        return q16;
    }
}
