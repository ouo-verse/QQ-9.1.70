package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import zp3.d;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes16.dex */
public class OnlineStateOpenSdkCommonChannelActionHandler implements zp3.c {

    /* renamed from: a, reason: collision with root package name */
    protected Handler f255334a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f255335b;

    private void d(final String str, final zp3.d dVar) {
        Handler handler = new Handler();
        this.f255334a = handler;
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.ao
            @Override // java.lang.Runnable
            public final void run() {
                OnlineStateOpenSdkCommonChannelActionHandler.this.f();
            }
        }, 20000L);
        dVar.a(new d.b() { // from class: com.tencent.mobileqq.onlinestatus.ap
            @Override // zp3.d.b
            public final void a(int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
                OnlineStateOpenSdkCommonChannelActionHandler.this.g(dVar, str, i3, bArr, bundle, appInfo);
            }
        });
    }

    private void e(Context context) {
        if (context instanceof JumpActivity) {
            ((JumpActivity) context).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f255335b = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(zp3.d dVar, String str, int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
        if (this.f255335b && dVar.getContext() != null) {
            QQToast.makeText(dVar.getContext(), 1, R.string.izn, 1).show();
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            RouteUtils.startActivity(dVar.getContext(), intent, RouterConstants.UI_ROUTER_SPLASH);
            e(dVar.getContext());
            return;
        }
        Handler handler = this.f255334a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        QLog.e("OnlineStateOpenSdkCommonChannelActionHandler", 1, "connectTencentVideo errorCode = " + i3);
        if (i3 != 0 && i3 != 25501) {
            dVar.c(Foreground.getTopActivity(), i3, "errorCode = " + i3);
            return;
        }
        try {
            QLog.d("OnlineStateOpenSdkCommonChannelActionHandler", 1, "start SplashActivity to show AccountPanel");
            Intent intent2 = new Intent();
            String packageName = dVar.getPackageName();
            if ("com.tencent.qqlive".equals(packageName)) {
                intent2.putExtra(IOnlineStatusService.SYNC_TYPE, 1);
            } else if (QZoneHelper.PACKAGENAME_QQMUSIC.equals(packageName)) {
                intent2.putExtra(IOnlineStatusService.SYNC_TYPE, 2);
            }
            intent2.putExtra("extInfo", str);
            intent2.addFlags(67108864);
            intent2.addFlags(268435456);
            intent2.putExtra(SplashActivity.FRAGMENT_ID, 1);
            dVar.d(intent2);
            RouteUtils.startActivity(dVar.getContext(), intent2, RouterConstants.UI_ROUTER_SPLASH);
            MobileQQ.sMobileQQ.peekAppRuntime().registObserver(new com.tencent.mobileqq.onlinestatus.observer.c(dVar));
        } catch (Exception e16) {
            QLog.e("OnlineStateOpenSdkCommonChannelActionHandler", 1, "Exception: " + e16);
        }
    }

    @Override // zp3.c
    public void a(@NonNull String str, zp3.d dVar) {
        if (dVar.getContext() == null) {
            QLog.d("OnlineStateOpenSdkCommonChannelActionHandler", 1, "helper.getContext() == null");
        } else {
            d(str, dVar);
        }
    }
}
