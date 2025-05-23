package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/g;", "", "Landroid/content/Context;", "context", "", "a", "", "curConfig", "", "uin", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f294283a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62000);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f294283a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("NotificationConfigReportUtils", 4, "trigger report.");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String uin = peekAppRuntime.getCurrentAccountUin();
        int i3 = MMKV.u().getInt("sp_notification_config_report_config_" + uin, -1);
        boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(context);
        if (areNotificationsEnabled != i3) {
            g gVar = f294283a;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            gVar.b(areNotificationsEnabled ? 1 : 0, uin);
            return;
        }
        QLog.d("NotificationConfigReportUtils", 4, "report skipped.");
    }

    private final void b(int curConfig, String uin) {
        Map mapOf;
        QLog.d("NotificationConfigReportUtils", 4, "curConfig: " + curConfig + ", uin: " + uin);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("notification_permissions_state", Integer.valueOf(curConfig)));
        VideoReport.reportEvent("ev_bas_push_notification_permissions", mapOf);
        MMKV.u().putInt("sp_notification_config_report_config_" + uin, curConfig);
    }
}
