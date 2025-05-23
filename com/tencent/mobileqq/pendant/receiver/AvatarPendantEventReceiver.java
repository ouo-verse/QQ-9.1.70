package com.tencent.mobileqq.pendant.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.pendant.AvatarPendantShopFragment;
import com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout;
import com.tencent.mobileqq.pendant.view.ShopHalfScreenFloatingView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class AvatarPendantEventReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<AvatarPendantShopFragment> f257519a;

    public AvatarPendantEventReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a() {
        AvatarPendantShopFragment avatarPendantShopFragment;
        WeakReference<AvatarPendantShopFragment> weakReference = this.f257519a;
        if (weakReference == null || (avatarPendantShopFragment = weakReference.get()) == null) {
            return;
        }
        int i3 = (int) PendantAvatarShopLayout.B;
        int i16 = PendantAvatarShopLayout.A;
        PendantAvatarShopLayout pendantAvatarShopLayout = null;
        if (i16 == 23) {
            ShopHalfScreenFloatingView shopHalfScreenFloatingView = avatarPendantShopFragment.avatarShopListPopupWindow;
            if (shopHalfScreenFloatingView != null) {
                pendantAvatarShopLayout = shopHalfScreenFloatingView.f257573s0;
            }
            if (pendantAvatarShopLayout != null && i3 != 0) {
                pendantAvatarShopLayout.f257520a = i3;
            }
        } else if (i16 == 4 && (pendantAvatarShopLayout = avatarPendantShopFragment.pendantShopView) != null && i3 != 0) {
            pendantAvatarShopLayout.f257521b = i3;
        }
        Message obtain = Message.obtain();
        if (i3 == 0 && pendantAvatarShopLayout != null) {
            obtain.obj = pendantAvatarShopLayout;
            obtain.what = 3;
        } else {
            obtain.what = 2;
            obtain.obj = PendantAvatarShopLayout.C;
            if (pendantAvatarShopLayout != null) {
                pendantAvatarShopLayout.D();
            }
        }
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        if (pendantAvatarShopLayout != null) {
            pendantAvatarShopLayout.f257525f.sendMessageDelayed(obtain, 1000L);
        }
    }

    private void c(String str) {
        l.e(BaseApplication.getContext().getApplicationContext(), str, new JSONObject());
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        MobileQQ.sMobileQQ.peekAppRuntime().getApplication().registerReceiver(this, intentFilter, "com.tencent.msg.permission.pushnotify", null);
    }

    public void d(AvatarPendantShopFragment avatarPendantShopFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarPendantShopFragment);
        } else {
            this.f257519a = new WeakReference<>(avatarPendantShopFragment);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            MobileQQ.sMobileQQ.peekAppRuntime().getApplication().unregisterReceiver(this);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[ADDED_TO_REGION] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (!intent.getBooleanExtra("broadcast", true)) {
            return;
        }
        String stringExtra = intent.getStringExtra("event");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("data");
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantEventReceiver", 2, "checkDispatchEvent event:" + stringExtra + " dataStr:" + stringExtra2);
        }
        try {
            int hashCode = stringExtra.hashCode();
            if (hashCode != -829587912) {
                if (hashCode != 805993596) {
                    if (hashCode == 1093579329 && stringExtra.equals("openBeautyPaySuccess")) {
                        c16 = 0;
                        if (c16 == 0 && c16 != 1) {
                            if (c16 == 2) {
                                c(stringExtra);
                                return;
                            }
                            return;
                        } else {
                            a();
                            c(stringExtra);
                        }
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                    a();
                    c(stringExtra);
                }
                if (stringExtra.equals("openBeautyPayCancel")) {
                    c16 = 2;
                    if (c16 == 0) {
                    }
                    a();
                    c(stringExtra);
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
                a();
                c(stringExtra);
            }
            if (stringExtra.equals("vipPaySuccess")) {
                c16 = 1;
                if (c16 == 0) {
                }
                a();
                c(stringExtra);
            }
            c16 = '\uffff';
            if (c16 == 0) {
            }
            a();
            c(stringExtra);
        } catch (Throwable th5) {
            QLog.e("AvatarPendantEventReceiver", 1, th5, new Object[0]);
        }
    }
}
