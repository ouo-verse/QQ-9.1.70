package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.aio.monitor.b;
import com.tencent.aio.monitor.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f307225a = "QQUtils";

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.aio.monitor.b f307226b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.utils.QQUtils$3, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f307234d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f307235e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f307236f;

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (this.f307234d) {
                str = this.f307235e.getApp().getString(R.string.htx);
            } else {
                str = null;
            }
            if (str != null) {
                QQToast.makeText(this.f307235e.getApp(), 2, str, 0).show(this.f307236f);
            }
        }
    }

    public static void a() {
        Context applicationContext;
        if (Build.VERSION.SDK_INT < 25 || (applicationContext = MobileQQ.sMobileQQ.getApplicationContext()) == null) {
            return;
        }
        try {
            ShortcutInfoCompat b16 = b(applicationContext, "qq_pay", R.string.dzs, R.drawable.qq_payment, "mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=8&entry=1");
            ShortcutInfoCompat b17 = b(applicationContext, "add_contact", R.string.a97, R.drawable.qq_add_contact, "mqqapi://contact/add?src_type=internal&version=1&des_type=0");
            ShortcutInfoCompat b18 = b(applicationContext, "create_troop", R.string.f2327575e, R.drawable.qq_create_troop, "mqqapi://createTroop/open?source=1");
            ShortcutInfoCompat b19 = b(applicationContext, "qq_scanner", R.string.conversation_options_saoyisao, R.drawable.qq_qrscan, "mqqapi://qrscan/open?source=1");
            ArrayList arrayList = new ArrayList();
            arrayList.add(b19);
            arrayList.add(b17);
            arrayList.add(b18);
            arrayList.add(b16);
            ShortcutManagerCompat.addDynamicShortcuts(applicationContext, arrayList);
            QLog.i(f307225a, 1, "addLongShortcut");
        } catch (Exception e16) {
            QLog.e(f307225a, 1, "addLongShortcut " + e16);
            if (AppSetting.isPublicVersion()) {
            } else {
                throw new RuntimeException(e16);
            }
        }
    }

    private static ShortcutInfoCompat b(Context context, String str, int i3, int i16, String str2) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        aliasIntent.setAction("android.intent.action.MAIN");
        aliasIntent.addCategory("android.intent.category.LAUNCHER");
        aliasIntent.addFlags(67108864);
        aliasIntent.addFlags(268435456);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra("shortcut_jump", str2);
        return new ShortcutInfoCompat.Builder(context, str).setShortLabel(context.getString(i3)).setLongLabel(context.getString(i3)).setIcon(IconCompat.createWithResource(context, i16)).setIntent(aliasIntent).build();
    }

    public static void c(QQAppInterface qQAppInterface, Intent intent, String str, Bitmap bitmap) {
        Intent intent2 = new Intent();
        wy2.c.d().k(intent);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        int e16 = al.e(qQAppInterface.getApp());
        if (e16 != bitmap.getWidth()) {
            if (!wy2.d.f446753c) {
                bitmap = wy2.c.d().a(bitmap, e16);
            } else {
                bitmap = Bitmap.createScaledBitmap(bitmap, e16, e16, false);
            }
        }
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        qQAppInterface.getApp().sendOrderedBroadcast(intent2, null);
        if (QLog.isColorLevel()) {
            QLog.d(f307225a, 2, "createShortcut.finish.");
        }
    }

    public static void d(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", str);
        hashMap.put("nickname", str2);
        hashMap.put("uinType", Integer.valueOf(i3));
        Intent h16 = h(qQAppInterface, "uin", hashMap);
        Bitmap faceBitmap = qQAppInterface.getFaceBitmap(1, str, (byte) 3, true, 0);
        if (faceBitmap == null) {
            faceBitmap = BaseImageUtil.getDefaultFaceBitmap();
        }
        c(qQAppInterface, h16, str2, faceBitmap);
    }

    public static void e(final QQAppInterface qQAppInterface, String str, String str2, final int i3, MqqHandler mqqHandler, int i16, final String str3, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d(f307225a, 2, "createShortcutWhihTips.begin.");
        }
        if (j(qQAppInterface.getApp(), new String[]{str2})) {
            final String string = qQAppInterface.getApp().getString(R.string.b1c);
            if (string != null) {
                mqqHandler.post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(QQAppInterface.this.getApp(), string, 0).show(i3);
                    }
                });
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f307225a, 2, "createShortcutWhihTips.no shortcut.");
        }
        d(qQAppInterface, str, str2, i17);
        final boolean j3 = j(qQAppInterface.getApp(), new String[]{str2});
        mqqHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.QQUtils.2
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                String str5;
                if (j3) {
                    str4 = qQAppInterface.getApp().getString(R.string.htx);
                    str5 = "0";
                } else {
                    str4 = null;
                    str5 = "1";
                }
                String str6 = str5;
                if (str4 != null) {
                    QQToast.makeText(qQAppInterface.getApp(), 2, str4, 0).show(i3);
                }
                ReportController.o(qQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, str3, str6, "", "");
            }
        }, i16);
    }

    public static void f(Activity activity, Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("shortcut_jump");
        if (TextUtils.isEmpty(string)) {
            QLog.d(f307225a, 1, "jumpUri == null");
            return;
        }
        activity.getIntent().putExtra("shortcut_jump", "");
        QLog.d(f307225a, 1, "jump " + string);
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(activity, string);
    }

    public static boolean g() {
        if (AppSetting.isPublicVersion()) {
            return false;
        }
        return QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeBool("aio_debug_main_thread_monitor_switch", false);
    }

    public static Intent h(QQAppInterface qQAppInterface, String str, Map<String, Object> map) {
        Intent intent = new Intent(QZoneHelper.ACTION_SHORT_CUT);
        intent.setClassName(qQAppInterface.getApp(), ShortcutGuideActivity.class.getName());
        intent.addCategory("android.intent.category.LAUNCHER");
        String str2 = (String) map.get("nickname");
        if (str.endsWith("sid")) {
            String str3 = (String) map.get("starHomeUrl");
            intent.putExtra("sid", (String) map.get("starId"));
            intent.putExtra("from", "starShortcut");
            intent.putExtra("starhomeurl", str3);
        } else {
            String str4 = (String) map.get("uin");
            int intValue = Integer.valueOf(map.get("uinType").toString()).intValue();
            intent.putExtra("uin", str4);
            if (str2 == null || str2.trim().length() == 0) {
                str2 = str4;
            }
            if (intValue == 1024) {
                intent.putExtra("uintype", 1024);
            } else {
                intent.putExtra("uintype", 0);
            }
        }
        intent.putExtra("uinname", str2);
        return intent;
    }

    public static String i(String str) {
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append(AppConstants.SDCARD_STAR_HEAD);
        sb5.append(MD5.toMD5(MD5.toMD5(MD5.toMD5(str) + str) + str));
        sb5.append(".png");
        return sb5.toString();
    }

    public static boolean j(Context context, String[] strArr) {
        return ec.k(context, strArr);
    }

    public static final boolean k(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static void l(Context context) {
        if (f307226b != null) {
            return;
        }
        QLog.i(f307225a, 1, "startMonitor");
        com.tencent.aio.monitor.sampler.a.INSTANCE.b(60);
        b.Companion companion = com.tencent.aio.monitor.b.INSTANCE;
        companion.a("com.tencent.mobileqq.config.QConfigManager.loadConObj");
        companion.a("com.tencent.mobileqq.persistence.EntityManager.query");
        companion.b("android.view.LayoutInflater.inflate");
        companion.b("java.lang.Class.getAnnotation");
        companion.b("com.Vas.ColorFont.FreeTypeLib.initColorFont");
        companion.b("com.tencent.theme.SkinEngine.loadConstantStateOld");
        companion.b("com.tencent.theme.SkinEngine.invalidateAll");
        companion.b("com.tencent.theme.SkinEngine.loadColorStateListOld");
        companion.b("com.tencent.mobileqq.vas.theme.SkinBitmapFilter.printError");
        companion.b("com.tencent.mobileqq.vas.theme.SimpleUIManager.checkResLegalAndUnzip");
        companion.b("com.tencent.mobileqq.aio.widget.NTViewFlipper");
        companion.b("android.graphics.HardwareRenderer.nSetStopped");
        companion.b("com.tencent.mobileqq.bizParts.QQSettingMeSettingPart.onInitView");
        com.tencent.aio.monitor.c a16 = new c.a().a(context);
        a16.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_THREAD java.lang.String = Thread.currentThread();
        com.tencent.aio.monitor.b bVar = new com.tencent.aio.monitor.b(a16);
        f307226b = bVar;
        bVar.h();
    }
}
