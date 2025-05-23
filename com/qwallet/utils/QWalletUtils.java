package com.qwallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.qwallet.data.QWalletHomeDateRange;
import com.qwallet.data.b;
import com.qwallet.pay.r;
import com.qwallet.pay.v;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$DateRange;
import com.qwallet.view.k;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.FingerPayApi;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import cooperation.qwallet.plugin.ipc.BaseReq;
import cooperation.qwallet.plugin.ipc.TickReq;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletUtils {

    /* renamed from: a, reason: collision with root package name */
    private static ResultReceiver f41782a;

    /* renamed from: b, reason: collision with root package name */
    public static long f41783b;

    /* renamed from: c, reason: collision with root package name */
    public static String f41784c;

    /* renamed from: d, reason: collision with root package name */
    private static SharedPreferences f41785d;

    /* renamed from: e, reason: collision with root package name */
    private static String f41786e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f41788a;

        a(float f16) {
            this.f41788a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(this.f41788a));
        }
    }

    public static void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QwalletMainPageController", 2, "QWalletUtils destroyDrawable");
        }
        try {
            if (drawable instanceof k) {
                drawable.setCallback(null);
                ((k) drawable).a();
            } else if (drawable instanceof BitmapDrawable) {
                drawable.setCallback(null);
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.e("QWalletUtils", 1, "", e16);
            }
        }
    }

    public static void b(final Context context) {
        if (QLog.isColorLevel()) {
            QLog.i("QWalletUtils", 2, "enterQWalletPlug run");
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.qwallet.utils.QWalletUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QWalletUtils.n(QWalletUtils.h()) && context != null) {
                        QLog.i("QWalletUtils", 1, "DeviceId is Change \nclose finger pay");
                        FingerPayApi.closeFingerPay(context, QWalletUtils.h());
                    } else if (QLog.isColorLevel()) {
                        QLog.i("QWalletUtils", 2, "DeviceId no change");
                    }
                } catch (Throwable th5) {
                    QLog.e("QWalletUtils", 1, "", th5);
                }
            }
        });
    }

    public static Typeface c(Context context) {
        AssetManager assets;
        if (context == null || (assets = context.getAssets()) == null) {
            return null;
        }
        return Typeface.createFromAsset(assets, VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
    }

    public static String d() {
        return "release";
    }

    public static String e() {
        String str = b.f41553a;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String f() {
        return "";
    }

    public static String g(int i3) {
        return "service_manager_switch_" + com.tencent.mobileqq.base.a.c() + "_" + i3;
    }

    public static String h() {
        return com.tencent.mobileqq.base.a.c();
    }

    public static SharedPreferences i(Context context) {
        if (f41785d == null) {
            f41785d = context.getSharedPreferences("qwallet", 0);
        }
        return f41785d;
    }

    public static void j(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", com.tencent.mobileqq.base.b.b());
        bundle.putByteArray("guid", com.tencent.mobileqq.base.b.c());
        TenpayInterface.gotoView(context, "pswManage", com.tencent.mobileqq.base.a.c(), com.tencent.mobileqq.base.a.b(), bundle, null);
    }

    @Deprecated
    public static void k(Context context, String str) {
        l(context, str, null);
    }

    @Deprecated
    public static void l(Context context, String str, Bundle bundle) {
        int indexOf;
        if (context == null || TextUtils.isEmpty(str) || (indexOf = str.indexOf(58)) == -1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        if (TextUtils.isEmpty(substring)) {
            return;
        }
        String lowerCase = substring.toLowerCase();
        try {
            if (lowerCase.compareTo("http") != 0 && lowerCase.compareTo("https") != 0) {
                if (lowerCase.compareTo(SchemaUtils.SCHEMA_MQQAPI) == 0) {
                    Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                    intent.setData(Uri.parse(y(str)));
                    if (bundle != null) {
                        intent.putExtras(bundle);
                    }
                    if (context instanceof Activity) {
                        ((Activity) context).startActivityForResult(intent, -1);
                        return;
                    } else {
                        context.startActivity(intent);
                        return;
                    }
                }
                if (lowerCase.compareTo(TenpayJumpActivity.TENPAY_SCHEME) == 0) {
                    com.tencent.mobileqq.qwallet.utils.k.f(context, y(str));
                    return;
                }
                return;
            }
            String y16 = y(str);
            Intent intent2 = new Intent();
            intent2.putExtra("url", y16);
            intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent2.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
            if (bundle != null) {
                intent2.putExtras(bundle);
            }
            RouteUtils.startActivityForResult(context, intent2, RouterConstants.UI_ROUTE_BROWSER, -1);
        } catch (Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.e("QWalletUtils", 1, "", th5);
            }
        }
    }

    public static void m(Activity activity, APMidasBaseRequest aPMidasBaseRequest, boolean z16, ResultReceiver resultReceiver) {
        boolean z17;
        if (activity == null) {
            return;
        }
        APMidasPayAPI.setEnv(d());
        if (z16 && r.o()) {
            z17 = true;
        } else {
            z17 = false;
        }
        APMidasPayAPI.setLogEnable(z17);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(activity, aPMidasBaseRequest, resultReceiver);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean n(String str) {
        boolean equals;
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String qWDevId = QWalletHelperDelegate.getQWDevId();
        if (TextUtils.isEmpty(qWDevId)) {
            return false;
        }
        if (TextUtils.isEmpty(f41786e)) {
            String string = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(str, "business_Device", "");
            if (!TextUtils.isEmpty(string)) {
                String hexdigest = QWalletHelperDelegate.hexdigest(IQWalletHelper.DEV_SAVEKEY);
                String desDecrypt = QWalletHelperDelegate.desDecrypt(string, hexdigest.substring(0, 16), hexdigest.substring(hexdigest.length() - 16, hexdigest.length()));
                f41786e = desDecrypt;
                if (!TextUtils.isEmpty(desDecrypt)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QWalletUtils", 1, "mBeforeDeviceId is null,Cache DeviceId is:" + f41786e);
                    }
                    equals = f41786e.equals(qWDevId);
                }
            }
            if (z16) {
                QLog.i("QWalletUtils", 1, "Cache DeviceId is:" + f41786e + " qwDevId:" + qWDevId);
            }
            if (!TextUtils.isEmpty(f41786e) || (!TextUtils.isEmpty(f41786e) && !f41786e.equals(qWDevId))) {
                t(str, qWDevId);
                f41786e = qWDevId;
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QWalletUtils", 1, "mBeforeDeviceId not null,Cache DeviceId is:" + f41786e);
        }
        equals = f41786e.equals(qWDevId);
        z16 = !equals;
        if (z16) {
        }
        if (!TextUtils.isEmpty(f41786e)) {
        }
        t(str, qWDevId);
        f41786e = qWDevId;
        return z16;
    }

    public static boolean o(QWalletHomeDateRange qWalletHomeDateRange) {
        if (qWalletHomeDateRange == null) {
            return false;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime < qWalletHomeDateRange.f41526d || serverTime > qWalletHomeDateRange.f41527e) {
            return false;
        }
        return true;
    }

    public static boolean p(QWalletHomePage$DateRange qWalletHomePage$DateRange) {
        if (qWalletHomePage$DateRange == null) {
            return false;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime < qWalletHomePage$DateRange.begin.get() || serverTime > qWalletHomePage$DateRange.end.get()) {
            return false;
        }
        return true;
    }

    public static void q() {
        TickReq tickReq = new TickReq();
        tickReq.tickType = 4;
        u(tickReq);
    }

    public static void r(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        f41782a = (ResultReceiver) bundle.getParcelable(IQWalletHelper.QWALLET_EXTRA_KEY_MQQ_RECEIVER);
        f41783b = bundle.getLong(IQWalletHelper.QWALLET_LOAD_BEING_TIME, System.currentTimeMillis());
    }

    public static void s(String str, String str2, String str3, String str4, String str5) {
        ((IReportApi) QRoute.api(IReportApi.class)).reportToDengTa(str, str2, str3, str4, str5, com.tencent.mobileqq.base.a.c());
    }

    public static void t(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String hexdigest = QWalletHelperDelegate.hexdigest(IQWalletHelper.DEV_SAVEKEY);
            String desEncrypt = QWalletHelperDelegate.desEncrypt(str2, hexdigest.substring(0, 16), hexdigest.substring(hexdigest.length() - 16, hexdigest.length()));
            if (QLog.isColorLevel()) {
                QLog.d("QWalletUtils", 1, "save deviceId:" + str2);
            }
            if (!TextUtils.isEmpty(desEncrypt)) {
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, "business_Device", desEncrypt);
            }
        }
    }

    public static void u(BaseReq baseReq) {
        if (baseReq != null && f41782a != null) {
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            f41782a.send(0, bundle);
        }
    }

    public static void v(View view, float f16) {
        view.setOutlineProvider(new a(f16));
        view.setClipToOutline(true);
    }

    public static void w() {
        TickReq tickReq = new TickReq();
        tickReq.tickType = 2;
        tickReq.exitQWalletTime = NetConnInfoCenter.getServerTimeMillis() / 1000;
        u(tickReq);
    }

    public static void x(View view, String str) {
        if (view != null && str != null) {
            view.setContentDescription(str);
        }
    }

    public static String y(String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("[uin]")) {
            str = str.replaceAll("\\[uin\\]", com.tencent.mobileqq.base.a.c());
        }
        if (str.contains("[sid]") && !TextUtils.isEmpty(f())) {
            str = str.replaceAll("\\[sid\\]", f());
        }
        if (str.contains("[updateTime]")) {
            return str.replaceAll("\\[updateTime\\]", (System.currentTimeMillis() / 1000) + "");
        }
        return str;
    }
}
