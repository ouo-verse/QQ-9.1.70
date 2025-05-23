package com.tencent.mobileqq.notification.modularize;

import android.service.notification.StatusBarNotification;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/m;", "", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f254314a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f254314a = new m();
        }
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032 A[Catch: Exception -> 0x0073, TryCatch #0 {Exception -> 0x0073, blocks: (B:10:0x001a, B:12:0x0024, B:19:0x0032, B:21:0x0039, B:23:0x0043), top: B:9:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039 A[Catch: Exception -> 0x0073, TryCatch #0 {Exception -> 0x0073, blocks: (B:10:0x001a, B:12:0x0024, B:19:0x0032, B:21:0x0039, B:23:0x0043), top: B:9:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d("TianShuManufacturerOfflineMsgHelper", 1, "handleSaveOfflineMsg");
        try {
            StatusBarNotification[] activeNotifications = QQNotificationManager.getInstance().getActiveNotifications();
            if (activeNotifications != null) {
                if (activeNotifications.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z16 = false;
                    if (!z16) {
                        QLog.w("TianShuManufacturerOfflineMsgHelper", 1, "handleSaveOfflineMsg  activeNotifications = null");
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(activeNotifications, "activeNotifications");
                    for (StatusBarNotification statusBarNotification : activeNotifications) {
                        String valueOf = String.valueOf(statusBarNotification.getId());
                        OnlineModulePushReceiver.Companion companion = OnlineModulePushReceiver.INSTANCE;
                        String g16 = companion.g(valueOf);
                        OnlineModulePushReceiver.Companion.q(companion, g16, 0L, 2, null);
                        QLog.i("TianShuManufacturerOfflineMsgHelper", 1, "handleSaveOfflineMsg  pushKey = " + g16);
                    }
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            QLog.e("TianShuManufacturerOfflineMsgHelper", 1, e16, new Object[0]);
        }
    }
}
