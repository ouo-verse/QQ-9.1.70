package com.tencent.mobileqq.wink.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.Foreground;
import zp3.d;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes21.dex */
public class WinkShareOpenSdkCommonChannelActionHandler implements zp3.c {

    /* renamed from: a, reason: collision with root package name */
    protected Handler f326339a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f326340b;

    private void d(final String str, final zp3.d dVar) {
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).preloadQQWink(dVar.getContext());
        Handler handler = new Handler();
        this.f326339a = handler;
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.share.q
            @Override // java.lang.Runnable
            public final void run() {
                WinkShareOpenSdkCommonChannelActionHandler.this.f();
            }
        }, 20000L);
        dVar.a(new d.b() { // from class: com.tencent.mobileqq.wink.share.r
            @Override // zp3.d.b
            public final void a(int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
                WinkShareOpenSdkCommonChannelActionHandler.this.g(dVar, str, i3, bArr, bundle, appInfo);
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
        this.f326340b = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(zp3.d dVar, String str, int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
        if (this.f326340b && dVar.getContext() != null) {
            QQToast.makeText(dVar.getContext(), 1, "\u8bf7\u6c42\u8d85\u65f6", 1).show();
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            RouteUtils.startActivity(dVar.getContext(), intent, RouterConstants.UI_ROUTER_SPLASH);
            e(dVar.getContext());
            return;
        }
        Handler handler = this.f326339a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        QLog.e("WinkShareOpenSdkCommonChannelActionHandler", 1, "connectTencentVideo errorCode = " + i3);
        if (i3 != 0 && i3 != 25501) {
            dVar.c(Foreground.getTopActivity(), i3, "errorCode = " + i3);
            return;
        }
        try {
            QLog.d("WinkShareOpenSdkCommonChannelActionHandler", 1, "start to winkShare");
            Bundle bundle2 = new Bundle();
            bundle2.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            HashMap hashMap = new HashMap();
            hashMap.put(QQWinkConstants.WINK_SHARE_APPID, dVar.getAppId());
            hashMap.put(QQWinkConstants.WINK_SHARE_PKGNAME, dVar.getPackageName());
            hashMap.put(QQWinkConstants.WINK_SHARE_OPENID, dVar.getOpenId());
            hashMap.put(QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG, "1");
            hashMap.put(QQWinkConstants.WINK_PUBLISH_TASK_ID, "hulian_" + dVar.getAppId());
            bundle2.putSerializable("key_attrs", hashMap);
            bundle2.putString(QQWinkConstants.WINK_SHARE_EXTRADATA, str);
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).shareToWink(dVar.getContext(), bundle2);
            e(dVar.getContext());
        } catch (Exception e16) {
            QLog.e("WinkShareOpenSdkCommonChannelActionHandler", 1, "Exception: " + e16);
            QQToast.makeText(dVar.getContext(), R.string.gjn, 0).show();
            dVar.c(Foreground.getTopActivity(), -1, "errorCode = param error");
        }
    }

    @Override // zp3.c
    public void a(@NonNull String str, @NonNull zp3.d dVar) {
        if (dVar.getContext() == null) {
            QLog.d("WinkShareOpenSdkCommonChannelActionHandler", 1, "helper.getContext() == null");
        } else if (QzoneConfig.getSupportWZShareToWink()) {
            d(str, dVar);
        } else if (Foreground.getTopActivity() != null) {
            dVar.c(Foreground.getTopActivity(), -1, "\u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301");
        }
    }
}
