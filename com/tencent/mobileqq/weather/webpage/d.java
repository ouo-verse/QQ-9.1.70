package com.tencent.mobileqq.weather.webpage;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.p;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/weather/webpage/d;", "", "", "from", "", "j", h.F, "Landroid/content/Context;", "context", "Lcom/tencent/common/app/AppInterface;", "app", "c", "Lmqq/app/AppRuntime;", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "", "dateString", "f", "msg", "g", "preloadResult", "l", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f313707a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43889);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f313707a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int c(Context context, AppInterface app) {
        if (!e(app)) {
            return MessageRecord.MSG_TYPE_GAME_INVITE;
        }
        if (DeviceInfoUtils.isLowPerfDevice()) {
            com.tencent.mobileqq.weather.b.a().e(app, "new_folder_noprestart_lowsystem");
            return -3003;
        }
        Long lastOpenTime = (Long) p.a(context, app.getCurrentAccountUin(), AppConstants.Preferences.KEY_LAST_OPEN_WEATHER_PAGE, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(lastOpenTime, "lastOpenTime");
        if (currentTimeMillis - lastOpenTime.longValue() > 259200000) {
            g("lastOpenTime unable lastOpenTime \uff1a" + lastOpenTime);
            return -3002;
        }
        if (d(app) >= 3) {
            return MessageRecord.MSG_TYPE_GAME_SHARE;
        }
        return 0;
    }

    private final int d(AppInterface app) {
        List split$default;
        Integer num;
        String preloadString = (String) p.a(BaseApplication.context, app.getCurrentAccountUin(), AppConstants.Preferences.KEY_LAST_PRELOAD_WEB_PRECESS, "");
        g("getTodayPreInfoTimes \uff1a" + preloadString);
        if (TextUtils.isEmpty(preloadString)) {
            return 0;
        }
        Intrinsics.checkNotNullExpressionValue(preloadString, "preloadString");
        split$default = StringsKt__StringsKt.split$default((CharSequence) preloadString, new String[]{"|"}, false, 0, 6, (Object) null);
        if (split$default.size() != 2 || TextUtils.isEmpty((CharSequence) split$default.get(0)) || TextUtils.isEmpty((CharSequence) split$default.get(1)) || !f((String) split$default.get(0))) {
            return 0;
        }
        try {
            num = Integer.valueOf((String) split$default.get(1));
        } catch (Throwable th5) {
            QLog.i("WeatherPreloadHelper", 1, "getPreInfoTimes", th5);
            num = null;
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private final boolean e(AppRuntime app) {
        IRuntimeService runtimeService = app.getRuntimeService(IConversationFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IC\u2026va, ProcessConstant.MAIN)");
        int unreadCount = ((IConversationFacade) runtimeService).getUnreadCount("2658655094", 1008);
        if (unreadCount > 0 && (app instanceof BaseQQAppInterface)) {
            List<MessageRecord> aIOList = ((IMessageFacade) ((BaseQQAppInterface) app).getRuntimeService(IMessageFacade.class)).getAIOList("2658655094", 1008);
            int size = aIOList.size() - 1;
            int max = Math.max(0, aIOList.size() - unreadCount);
            if (max <= size) {
                while (!com.tencent.mobileqq.weather.util.d.f313638a.l(aIOList.get(size))) {
                    if (size != max) {
                        size--;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean f(@NotNull String dateString) {
        Calendar calendar;
        Calendar calendar2;
        Date parse;
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        if (TextUtils.isEmpty(dateString)) {
            return false;
        }
        Calendar calendar3 = null;
        try {
            parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).parse(dateString);
            calendar2 = Calendar.getInstance();
        } catch (Throwable th5) {
            th = th5;
            calendar = null;
        }
        try {
            calendar2.setTime(parse);
            calendar3 = Calendar.getInstance();
            calendar3.setTime(new Date());
        } catch (Throwable th6) {
            th = th6;
            calendar = calendar3;
            calendar3 = calendar2;
            QLog.i("WeatherPreloadHelper", 1, "isToady", th);
            Calendar calendar4 = calendar;
            calendar2 = calendar3;
            calendar3 = calendar4;
            if (calendar2 != null) {
            }
            return false;
        }
        if (calendar2 != null || calendar3 == null || calendar2.get(0) != calendar3.get(0) || calendar2.get(1) != calendar3.get(1) || calendar2.get(6) != calendar3.get(6)) {
            return false;
        }
        return true;
    }

    private final void g(String msg2) {
        QLog.i("WeatherPreloadHelper", 1, msg2);
    }

    private final void h() {
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            g("preloadWebProcess context error");
            return;
        }
        final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && (waitAppRuntime instanceof BaseToolAppInterface)) {
            if (!((BaseToolAppInterface) waitAppRuntime).isLogin()) {
                g("preloadWebProcess not login");
                return;
            }
            IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IW\u2026va, ProcessConstant.MAIN)");
            IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) runtimeService;
            if (!(iWebProcessManagerService instanceof IWebProcessManagerService)) {
                g("preloadWebProcess wpm error");
                l((AppInterface) waitAppRuntime, -2000);
                return;
            }
            AppInterface appInterface = (AppInterface) waitAppRuntime;
            int c16 = c(baseApplication, appInterface);
            if (c16 != 0) {
                g("preloadWebProcess no need result " + c16);
                l(appInterface, c16);
                return;
            }
            g("preloadWebProcess");
            final boolean isWebProcessExist = ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isWebProcessExist();
            iWebProcessManagerService.startWebProcess(26, new u() { // from class: com.tencent.mobileqq.weather.webpage.c
                @Override // com.tencent.mobileqq.webview.util.u
                public final void onResult(boolean z16) {
                    d.i(AppRuntime.this, isWebProcessExist, z16);
                }
            });
            return;
        }
        g("preloadWebProcess app error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AppRuntime app, boolean z16, boolean z17) {
        String str;
        int i3;
        if (z17) {
            str = "new_folder_prestart_success";
        } else {
            str = "new_folder_prestart_fail";
        }
        com.tencent.mobileqq.weather.b.a().e(app, str);
        d dVar = f313707a;
        dVar.g("preloadWebProcess isSuccess " + z17 + " isWebProcessExist " + z16);
        if (z17) {
            Intrinsics.checkNotNullExpressionValue(app, "app");
            dVar.m((AppInterface) app);
        }
        if (z17) {
            i3 = 0;
        } else {
            i3 = -4001;
        }
        if (i3 == -4001 && z16) {
            i3 = -4000;
        }
        Intrinsics.checkNotNullExpressionValue(app, "app");
        dVar.l((AppInterface) app, i3);
    }

    @JvmStatic
    public static final void j(int from) {
        f313707a.g("preloadWebProcessAsync from = " + from);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.weather.webpage.b
            @Override // java.lang.Runnable
            public final void run() {
                d.k();
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k() {
        f313707a.h();
    }

    private final void l(AppInterface app, int preloadResult) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE);
        p.g(BaseApplication.context, app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_LAST_PRELOAD_WEB_RESULT, simpleDateFormat.format(new Date()) + "|" + preloadResult);
        if (preloadResult == -4001 || preloadResult == -3005 || preloadResult == -2000) {
            com.tencent.mobileqq.weather.b.a().f(app, "new_folder_prestart_fail_others", Integer.valueOf(preloadResult));
        }
    }

    private final void m(AppInterface app) {
        MobileQQ.sMobileQQ.getAllAccounts();
        int d16 = d(app);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE);
        p.g(BaseApplication.context, app.getCurrentAccountUin(), true, AppConstants.Preferences.KEY_LAST_PRELOAD_WEB_PRECESS, simpleDateFormat.format(new Date()) + "|" + (d16 + 1));
    }
}
