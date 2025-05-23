package com.tencent.mobileqq.database.corrupt;

import android.app.Dialog;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$DBFix;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/database/corrupt/d;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$DBFix;", "fixInfo", "", "g", "", "cmd", "", "pbBuffer", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "c", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d implements com.tencent.qqnt.kernel.frequencycontrol.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/database/corrupt/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.database.corrupt.d$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54909);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void g(final FrequencyControlField$DBFix fixInfo) {
        DBFixManager.f203266g0 = 0;
        QLog.d("DBFixDispatcher", 1, "[onCorruptNotify]: NOTIFY_CORRUPT, db_size: " + fixInfo.db_size.get() + ", db_path: " + fixInfo.db_path.get() + ", status: " + DBFixManager.f203266g0);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.c
            @Override // java.lang.Runnable
            public final void run() {
                d.h(FrequencyControlField$DBFix.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(FrequencyControlField$DBFix fixInfo) {
        DBFixManager dBFixManager;
        Intrinsics.checkNotNullParameter(fixInfo, "$fixInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QLog.d("DBFixDispatcher", 1, "[onDispatchCall], NOTIFY_CORRUPT status in main: " + DBFixManager.f203266g0);
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.DB_FIX_MANAGER);
        if (manager instanceof DBFixManager) {
            dBFixManager = (DBFixManager) manager;
        } else {
            dBFixManager = null;
        }
        DBFixManager dBFixManager2 = dBFixManager;
        if (dBFixManager2 != null) {
            dBFixManager2.m(null, true, fixInfo.db_size.get(), fixInfo.db_path.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Dialog dialog, FrequencyControlField$DBFix body) {
        Intrinsics.checkNotNullParameter(body, "$body");
        QLog.d("DBFixDispatcher", 1, "[onDispatchCall], NOTIFY_PROGRESS status in main: " + DBFixManager.f203266g0);
        ((DBFixLoadingDialog) dialog).f0(body);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Dialog dialog, FrequencyControlField$DBFix body) {
        Intrinsics.checkNotNullParameter(body, "$body");
        QLog.d("DBFixDispatcher", 1, "[onDispatchCall] NOTIFY_COMPLETE body in main: " + DBFixManager.f203267h0 + ", status: " + DBFixManager.f203266g0);
        ((DBFixLoadingDialog) dialog).e0(body);
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    @NotNull
    public int[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{221012};
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void b(int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, cmd, (Object) pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        final FrequencyControlField$DBFix frequencyControlField$DBFix = new FrequencyControlField$DBFix();
        try {
            frequencyControlField$DBFix.mergeFrom(pbBuffer);
        } catch (Exception e16) {
            QLog.e("FrequencyControlUtils", 1, "[parseResourceItemListBody]: " + e16);
        }
        if (!frequencyControlField$DBFix.event.has()) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("DBFixDispatcher", 2, "[onDispatchCall]: cmd is " + cmd + ", event is " + frequencyControlField$DBFix.event.get());
        }
        switch (frequencyControlField$DBFix.event.get()) {
            case 222201:
                g(frequencyControlField$DBFix);
                return;
            case 222202:
            default:
                return;
            case 222203:
                DBFixManager.f203266g0 = 1;
                QLog.d("DBFixDispatcher", 1, "[onDispatchCall]: NOTIFY_PROGRESS, progress: " + frequencyControlField$DBFix.progress.get() + ", status: " + DBFixManager.f203266g0);
                final Dialog dialog = DBFixDialogUI.f203218m;
                if (dialog instanceof DBFixLoadingDialog) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.i(dialog, frequencyControlField$DBFix);
                        }
                    });
                    return;
                }
                return;
            case 222204:
                DBFixManager.f203266g0 = 100;
                DBFixManager.f203267h0 = frequencyControlField$DBFix;
                QLog.d("DBFixDispatcher", 1, "[onDispatchCall] NOTIFY_COMPLETE body: " + DBFixManager.f203267h0 + ", status: " + DBFixManager.f203266g0);
                final Dialog dialog2 = DBFixDialogUI.f203218m;
                if (dialog2 instanceof DBFixLoadingDialog) {
                    QLog.d("DBFixDispatcher", 1, "[onDispatchCall] DBFixLoadingDialog");
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.database.corrupt.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.j(dialog2, frequencyControlField$DBFix);
                        }
                    });
                    return;
                }
                return;
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(requestId), Integer.valueOf(cmd), pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        QLog.d("DBFixDispatcher", 1, "[onDispatchRequest]: cmd is " + cmd + ", requestId is " + requestId);
    }
}
