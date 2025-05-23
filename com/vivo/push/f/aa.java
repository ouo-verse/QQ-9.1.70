package com.vivo.push.f;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class aa extends com.vivo.push.s {

    /* renamed from: b, reason: collision with root package name */
    protected PushMessageCallback f387661b;

    /* renamed from: c, reason: collision with root package name */
    private int f387662c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(com.vivo.push.v vVar) {
        super(vVar);
        this.f387662c = 0;
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.f387661b = pushMessageCallback;
    }

    public final int b() {
        NotificationChannel notificationChannel;
        int importance;
        boolean areNotificationsEnabled;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            NotificationManager notificationManager = (NotificationManager) this.f387838a.getSystemService("notification");
            if (notificationManager != null) {
                areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                if (!areNotificationsEnabled) {
                    return 2104;
                }
            }
            if (i3 >= 26 && notificationManager != null) {
                try {
                    notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
                    if (notificationChannel != null) {
                        importance = notificationChannel.getImportance();
                        if (importance == 0) {
                            return 2121;
                        }
                        return 0;
                    }
                    return 0;
                } catch (Exception unused) {
                    com.vivo.push.util.u.b("OnVerifyCallBackCommand", "\u5224\u65ad\u901a\u77e5\u901a\u9053\u51fa\u73b0\u7cfb\u7edf\u9519\u8bef");
                    return 0;
                }
            }
            return 0;
        }
        return 0;
    }

    public final int c() {
        return this.f387662c;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        if (!com.vivo.push.m.a().d()) {
            com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.u.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (com.vivo.push.util.ab.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                    com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(str));
                com.vivo.push.util.u.c(this.f387838a, "vertify fail srcDigest is ".concat(str));
                return false;
            } catch (Exception e16) {
                e16.printStackTrace();
                com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        }
        com.vivo.push.util.u.d("OnVerifyCallBackCommand", "vertify id is null");
        return false;
    }

    public final int a(NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        if (notifyArriveCallbackByUser == null) {
            com.vivo.push.util.u.b("OnVerifyCallBackCommand", "pkg name : " + this.f387838a.getPackageName() + " \u5e94\u7528\u5230\u8fbe\u56de\u8c03\u8fd4\u56de\u503c\u4e3a\u7a7a\uff0c\u4e0d\u505a\u5904\u7406");
            com.vivo.push.util.u.b(this.f387838a, "\u5e94\u7528\u5230\u8fbe\u56de\u8c03\u8fd4\u56de\u503c\u5f02\u5e38\uff0c\u5bfc\u81f4\u901a\u77e5\u65e0\u6cd5\u5c55\u793a\uff0c\u5982\u9700\u6253\u5f00\u8bf7\u5728onNotificationMessageArrived\u4e2d\u8fd4\u56de\u6b63\u786e\u7684\u5bf9\u8c61");
            return 2163;
        }
        if (!notifyArriveCallbackByUser.isIntercept()) {
            return 0;
        }
        com.vivo.push.util.u.b("OnVerifyCallBackCommand", "pkg name : " + this.f387838a.getPackageName() + " \u5e94\u7528\u4e3b\u52a8\u62e6\u622a\u901a\u77e5");
        com.vivo.push.util.u.b(this.f387838a, "\u5e94\u7528\u4e3b\u52a8\u62e6\u622a\u901a\u77e5\uff0c\u5bfc\u81f4\u901a\u77e5\u65e0\u6cd5\u5c55\u793a\uff0c\u5982\u9700\u6253\u5f00\u8bf7\u5728onNotificationMessageArrived\u4e2d\u8fd4\u56defalse");
        return 2120;
    }

    public final void a(int i3) {
        this.f387662c = i3;
    }
}
