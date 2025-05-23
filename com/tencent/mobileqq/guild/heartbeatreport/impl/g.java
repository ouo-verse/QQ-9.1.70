package com.tencent.mobileqq.guild.heartbeatreport.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import wh2.es;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/heartbeatreport/impl/g;", "", "", "f", "", "nextReportInterval", "d", "e", "c", "", "b", "Z", "isCodeStart", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "reportRunnable", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f224685a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isCodeStart = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable reportRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.e
        @Override // java.lang.Runnable
        public final void run() {
            g.h();
        }
    };

    g() {
    }

    private final void d(long nextReportInterval) {
        Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "postDelay nextReportInterval:" + nextReportInterval);
        UiThreadUtil.runOnUiThread(reportRunnable, nextReportInterval * ((long) 1000));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[Catch: Exception -> 0x0116, TryCatch #0 {Exception -> 0x0116, blocks: (B:3:0x0008, B:5:0x0012, B:8:0x001c, B:10:0x0023, B:15:0x002f, B:17:0x0045, B:19:0x0049, B:21:0x0053, B:23:0x0057, B:25:0x0069, B:27:0x0077, B:29:0x0084, B:31:0x00b0, B:33:0x00b7, B:35:0x00d7, B:37:0x00db, B:38:0x00e1, B:40:0x00e7, B:41:0x00ee, B:43:0x00eb), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[Catch: Exception -> 0x0116, TryCatch #0 {Exception -> 0x0116, blocks: (B:3:0x0008, B:5:0x0012, B:8:0x001c, B:10:0x0023, B:15:0x002f, B:17:0x0045, B:19:0x0049, B:21:0x0053, B:23:0x0057, B:25:0x0069, B:27:0x0077, B:29:0x0084, B:31:0x00b0, B:33:0x00b7, B:35:0x00d7, B:37:0x00db, B:38:0x00e1, B:40:0x00e7, B:41:0x00ee, B:43:0x00eb), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f() {
        boolean z16;
        String str;
        FrameFragment.d dVar;
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                d(10L);
                QLog.e("Guild.report.online.GuildForegroundReporter", 1, "runtime is null");
                return;
            }
            String account = peekAppRuntime.getAccount();
            if (account != null && account.length() != 0) {
                z16 = false;
                if (!z16) {
                    QLog.e("Guild.report.online.GuildForegroundReporter", 1, "account is invalid account:" + account);
                    return;
                }
                if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
                    d(10L);
                    QLog.e("Guild.report.online.GuildForegroundReporter", 1, "runtime is not BaseQQAppInterface");
                    return;
                }
                if (isCodeStart) {
                    Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "codeStart is true");
                    isCodeStart = false;
                    d(10L);
                    return;
                }
                if (!((IGuildUserService) peekAppRuntime.getRuntimeService(IGuildUserService.class, "")).isGuildUser()) {
                    Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "not guild user");
                    return;
                }
                IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
                cn cnVar = new cn();
                String selfTinyId = iGPSService.getSelfTinyId();
                Intrinsics.checkNotNullExpressionValue(selfTinyId, "service.selfTinyId");
                cnVar.o(Long.parseLong(selfTinyId));
                cnVar.m(3);
                if (cnVar.h() == 0) {
                    QLog.d("Guild.report.online.GuildForegroundReporter", 1, "tinyId is 0");
                    return;
                }
                FrameFragment mainFragment = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getMainFragment(QBaseActivity.sTopActivity);
                String name = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName();
                if (mainFragment != null && (dVar = mainFragment.mTabIndicator) != null) {
                    str = dVar.getCurrentTabTag();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(name, str)) {
                    cnVar.i(1);
                } else {
                    cnVar.i(0);
                }
                Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "reportInternal req.activeTab:" + cnVar.a());
                iGPSService.userOnlineReport(cnVar, new es() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.f
                    @Override // wh2.es
                    public final void a(int i3, String str2, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
                        g.g(i3, str2, iGProGuildOnlineReportRsp);
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "userOnlineReport except:" + e16.getStackTrace();
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.report.online.GuildForegroundReporter", 1, (String) it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, String str, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
        if (iGProGuildOnlineReportRsp.getNextReportInterval() <= 0) {
            f224685a.d(600L);
        } else {
            f224685a.d(iGProGuildOnlineReportRsp.getNextReportInterval());
        }
        if (i3 != 0) {
            QLog.e("Guild.report.online.GuildForegroundReporter", 1, "userOnlineReport failed, result:" + i3 + ", errMsg:" + str);
            return;
        }
        Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "userOnlineReport success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "reportRunnable");
        f224685a.f();
    }

    public final void c() {
        Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "background");
        UiThreadUtil.remove(reportRunnable);
    }

    public final void e() {
        Logger.f235387a.d().d("Guild.report.online.GuildForegroundReporter", 1, "reportForeground");
        UiThreadUtil.remove(reportRunnable);
        f();
    }
}
