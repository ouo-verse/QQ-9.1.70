package com.tencent.mobileqq.identification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes15.dex */
public class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f238004a;

    /* renamed from: b, reason: collision with root package name */
    private static final com.tencent.mobileqq.qqconnectface.a f238005b;

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.qqconnectface.a f238006c;

    /* renamed from: d, reason: collision with root package name */
    private static BroadcastReceiver f238007d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            QLog.i("IdentificationinjectUtil", 2, "startLegacyActivity onReceive");
            if (!TextUtils.equals(z.f238004a, intent.getPackage())) {
                QLog.i("IdentificationinjectUtil", 2, "startLegacyActivity onReceive wrong packageName");
                return;
            }
            String action = intent.getAction();
            QLog.d("IdentificationinjectUtil", 1, "startLegacyActivity onReceive packageName ok, action = " + action);
            if (TextUtils.equals(action, "com.tencent.mobileqq.identification.callCallback")) {
                z.e(context, intent);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f238004a = BaseApplication.getContext().getPackageName();
        com.tencent.mobileqq.qqconnectface.a aVar = new com.tencent.mobileqq.qqconnectface.a();
        f238005b = aVar;
        f238006c = aVar;
    }

    @NotNull
    private static FaceConf c(com.tencent.mobileqq.qqconnectface.b bVar) {
        FaceConf faceConf = new FaceConf();
        faceConf.setPlatformAppId(bVar.f262371a);
        faceConf.setAppId(bVar.f262371a);
        faceConf.setOpenId(bVar.f262375e);
        faceConf.setKey(bVar.f262376f);
        faceConf.setMethod(bVar.f262372b);
        faceConf.setServiceType(bVar.f262373c);
        faceConf.setUin(bVar.f262374d);
        faceConf.setFromType(bVar.f262377g);
        faceConf.setImei(QQDeviceInfo.getIMEI("0"));
        faceConf.setQimei36(com.tencent.mobileqq.statistics.o.c());
        return faceConf;
    }

    @NotNull
    private static com.tencent.mobileqq.qqconnectface.c d(Bundle bundle) {
        com.tencent.mobileqq.qqconnectface.c cVar = new com.tencent.mobileqq.qqconnectface.c();
        if (bundle == null) {
            cVar.f262378a = 299;
            cVar.f262379b = HardCodeUtil.qqStr(R.string.f159511si);
            cVar.f262380c = "";
            cVar.f262381d = "";
            return cVar;
        }
        cVar.f262378a = bundle.getInt("ret", 299);
        cVar.f262379b = bundle.getString("errMsg", HardCodeUtil.qqStr(R.string.f159511si));
        cVar.f262380c = bundle.getString("idKey", "");
        String string = bundle.getString("allResults");
        if (!TextUtils.isEmpty(string) && string.endsWith("|")) {
            string = string.substring(0, string.length() - 1);
        }
        cVar.f262381d = string;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(Context context, Intent intent) {
        synchronized (z.class) {
            QLog.d("IdentificationinjectUtil", 1, "handleToCallCallback");
            String stringExtra = intent.getStringExtra("whichCallback");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (f238006c != null) {
                if (TextUtils.equals(stringExtra, "success")) {
                    f238006c.onIdentificationSuccess(d(bundleExtra));
                    f(context);
                } else if (TextUtils.equals(stringExtra, "failed")) {
                    f238006c.onIdentificationFailed(d(bundleExtra));
                    f(context);
                } else if (TextUtils.equals(stringExtra, "canceled")) {
                    f238006c.onIdentificationCanceled();
                    f(context);
                } else if (TextUtils.equals(stringExtra, "guidePageNextBtnClick")) {
                    f238006c.onLegacyPageNextBtnClick();
                } else if (TextUtils.equals(stringExtra, "guidePageNextBtnClick")) {
                    f238006c.onLegacyPageNextBtnClick();
                } else if (TextUtils.equals(stringExtra, "guidePageCreate")) {
                    f238006c.onLegacyPageCreate();
                } else if (TextUtils.equals(stringExtra, "identificationPageCancelBtnClick")) {
                    f238006c.onIdentificationCancelBtnClick();
                }
            }
        }
    }

    private static synchronized void f(Context context) {
        synchronized (z.class) {
            f238006c = f238005b;
            try {
                BroadcastReceiver broadcastReceiver = f238007d;
                if (broadcastReceiver != null) {
                    context.unregisterReceiver(broadcastReceiver);
                    f238007d = null;
                }
            } catch (Exception e16) {
                QLog.e("IdentificationinjectUtil", 1, "onFinishIdentification error: " + e16);
            }
        }
    }

    public static synchronized void g(Context context, String str, Bundle bundle) {
        synchronized (z.class) {
            QLog.d("IdentificationinjectUtil", 1, "sendBroadcastToCallCallback whichCallback = " + str + ", data = " + bundle);
            Intent intent = new Intent();
            intent.putExtra("whichCallback", str);
            intent.putExtra("data", bundle);
            intent.setAction("com.tencent.mobileqq.identification.callCallback");
            intent.setPackage(f238004a);
            context.sendBroadcast(intent);
        }
    }

    private static synchronized void h(com.tencent.mobileqq.qqconnectface.a aVar) {
        synchronized (z.class) {
            com.tencent.mobileqq.qqconnectface.a aVar2 = f238006c;
            com.tencent.mobileqq.qqconnectface.a aVar3 = f238005b;
            if (aVar2 != aVar3 && aVar2 != null) {
                aVar2.onCallbackError();
            }
            if (aVar == null) {
                f238006c = aVar3;
            } else {
                f238006c = aVar;
            }
        }
    }

    public static synchronized void i(Context context, com.tencent.mobileqq.qqconnectface.b bVar, com.tencent.mobileqq.qqconnectface.a aVar) {
        synchronized (z.class) {
            QLog.d("IdentificationinjectUtil", 1, "startLegacyActivity");
            h(aVar);
            if (f238007d == null) {
                f238007d = new a();
            }
            context.registerReceiver(f238007d, new IntentFilter("com.tencent.mobileqq.identification.callCallback"), null, null);
            Intent intent = new Intent();
            intent.putExtra("faceConf", c(bVar));
            RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTER_IDENTIFICATION_GUIDE_ACTIVITY, 21);
        }
    }

    public static synchronized void j(Context context, com.tencent.mobileqq.qqconnectface.a aVar) {
        synchronized (z.class) {
            if (f238006c == aVar) {
                f(context);
                QLog.d("IdentificationinjectUtil", 2, "unregisterCallback ok");
            } else {
                QLog.e("IdentificationinjectUtil", 1, "unregisterCallback error, no such callback");
            }
        }
    }
}
