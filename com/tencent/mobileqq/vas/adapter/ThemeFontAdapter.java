package com.tencent.mobileqq.vas.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.k;
import com.etrump.mixlayout.m;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.f;
import com.tencent.mobileqq.util.g;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.TextHook;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeFontAdapter extends com.tencent.mobileqq.vas.adapter.a {

    /* renamed from: n, reason: collision with root package name */
    private static int f307921n;

    /* renamed from: o, reason: collision with root package name */
    private static b f307922o = new b();

    /* renamed from: p, reason: collision with root package name */
    private static int f307923p = 10;

    /* renamed from: q, reason: collision with root package name */
    private static int f307924q = 0;

    /* renamed from: r, reason: collision with root package name */
    private static final boolean f307925r = ar.b("linkliang", "2024-08-14", "vas_bug_128882697").isEnable(true);

    /* renamed from: s, reason: collision with root package name */
    static f f307926s = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends f {
        a() {
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void e(boolean z16, boolean z17, boolean z18, int i3) {
            if (z16) {
                Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
                int i16 = 0;
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    String fontPath = TextHook.getFontPath(applicationContext);
                    if (!TextUtils.isEmpty(fontPath)) {
                        ThemeFontAdapter.A(applicationContext, fontPath);
                        ThemeFontAdapter.y(false);
                        return;
                    }
                    return;
                }
                String u16 = ThemeFontAdapter.u(applicationContext);
                if (!TextUtils.isEmpty(u16)) {
                    String[] split = FileManagerUtil.getFileName(u16).split("\\.");
                    try {
                        int parseInt = Integer.parseInt(split[0]);
                        if (split.length > 2) {
                            i16 = Integer.parseInt(split[1]);
                        }
                        ThemeFontAdapter.C(parseInt, i16);
                    } catch (NumberFormatException e16) {
                        QLog.e("ThemeFontAdapter", 1, "switchFont  prePath:" + u16, e16);
                        e16.printStackTrace();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("isFont", false)) {
                TextHook.getInstance().checkTypeface(context);
            }
        }
    }

    public ThemeFontAdapter(VasRes vasRes, AppRuntime appRuntime, int i3) {
        super(vasRes, appRuntime, i3);
    }

    public static void A(Context context, String str) {
        SkinEngine.getInstances().getSharedPreference(context).edit().putString("theme_font_root_pre", str).remove(SkinEngine.KEY_THEME_FONT).apply();
    }

    public static void B(int i3) {
        long j3 = i3;
        C((int) FontManagerConstants.parseFontId(j3), FontManagerConstants.parseFontType(j3));
    }

    public static void C(final int i3, final int i16) {
        QLog.d("ThemeFontAdapter", 1, "switchFont  fontId:" + i3 + " fontType:" + i16);
        try {
            if (VasToggle.isEnable("vas_bugfix_theme_font_2", true) && f307921n == 0 && !TextUtils.isEmpty(t())) {
                QLog.d("ThemeFontAdapter", 1, "switchFont sCurrentFontId = -1");
                f307921n = -1;
            }
        } catch (Exception e16) {
            QLog.e("ThemeFontAdapter", 2, "switchFont :" + e16);
        }
        if (f307921n == i3) {
            QLog.d("ThemeFontAdapter", 1, "switchFont already set fontId:" + i3 + " fontType:" + i16);
            return;
        }
        if (i3 == 0) {
            y(true);
        } else {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    String tTFPath = FontManagerConstants.getTTFPath(i3, i16);
                    if (!new File(tTFPath).exists()) {
                        QLog.d("ThemeFontAdapter", 1, "switchFont  fontPath not exists:" + i3);
                        ThemeFontAdapter.v(i3, i16);
                        return;
                    }
                    if (i16 == 1) {
                        if (!ETEngine.isSOLoaded.get()) {
                            int i17 = ThemeFontAdapter.f307924q;
                            ThemeFontAdapter.f307924q = i17 + 1;
                            if (i17 < ThemeFontAdapter.f307923p) {
                                ThemeFontAdapter.v(i3, i16);
                                return;
                            }
                        }
                        String staticTTFPath = FontManagerConstants.getStaticTTFPath(i3, i16);
                        if (ThemeFontAdapter.s(tTFPath, staticTTFPath)) {
                            tTFPath = staticTTFPath;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("ThemeFontAdapter", 2, "switchFont  fontPath:" + tTFPath);
                    }
                    Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
                    if (applicationContext == null) {
                        QLog.e("ThemeFontAdapter", 1, "switchFont  context is null");
                        return;
                    }
                    if (SimpleUIUtil.getSimpleUISwitch()) {
                        ThemeFontAdapter.A(applicationContext, tTFPath);
                        return;
                    }
                    if (TextHook.getInstance().switchFont(applicationContext, tTFPath)) {
                        ThemeFontAdapter.f307924q = 0;
                        ThemeFontAdapter.f307921n = i3;
                        QLog.e("ThemeFontAdapter", 2, "switchFont  success:" + i3 + " type:" + i16);
                        TextHook.saveLastPath(applicationContext, tTFPath);
                        SkinEngine.getInstances().getSharedPreference(applicationContext).edit().remove("theme_font_root_pre").apply();
                    }
                }
            });
        }
    }

    public static void D(Context context) {
        context.unregisterReceiver(f307922o);
    }

    public static void r(Context context) {
        SkinEngine.getInstances().getSharedPreference(context).edit().remove("theme_font_root_pre").remove(SkinEngine.KEY_THEME_FONT).apply();
    }

    public static boolean s(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                return true;
            }
            String str3 = str2 + "." + Process.myPid() + ".tmp";
            try {
                ETEngine.getInstanceForSpace();
                boolean native_ftf2ttf = ETEngine.native_ftf2ttf(str, str3);
                if (native_ftf2ttf) {
                    File file2 = new File(str3);
                    boolean renameTo = file2.renameTo(file);
                    if (!renameTo) {
                        QLog.e("ThemeFontAdapter", 1, "failed to move trueType font file, from path = " + file2.getAbsolutePath());
                    }
                    return renameTo;
                }
                QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error");
                return native_ftf2ttf;
            } catch (Throwable th5) {
                QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error, errMsg = " + th5.toString());
            }
        }
        return false;
    }

    private static String t() {
        Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        return SkinEngine.getInstances().getSharedPreference(applicationContext).getString(SkinEngine.KEY_THEME_FONT, null);
    }

    public static String u(Context context) {
        return SkinEngine.getInstances().getSharedPreference(context).getString("theme_font_root_pre", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(int i3, int i16) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        VasRes vasRes = new VasRes(runtime, i3);
        vasRes.setAdapter(new ThemeFontAdapter(vasRes, runtime, i16));
    }

    public static void w() {
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).addObserver(f307926s);
    }

    public static void x(Context context) {
        TextHook.setSupportProcess(true);
        context.registerReceiver(f307922o, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
    }

    public static void y(final boolean z16) {
        if (f307925r) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    ThemeFontAdapter.z(z16);
                }
            }, 16, null, false);
        } else {
            z(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(boolean z16) {
        if (z16) {
            r(BaseApplicationImpl.getApplication().getApplicationContext());
        }
        if (!TextHook.getInstance().isDefault()) {
            QLog.d("ThemeFontAdapter", 1, "resetDefaultFont");
            TextHook.getInstance().switchDefault();
            TextHook.getInstance().update(BaseApplicationImpl.getApplication().getApplicationContext());
        }
        f307921n = -1;
        f307924q = 0;
    }

    @Override // com.tencent.mobileqq.vas.adapter.a, com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void load() {
        k d16;
        if (g.b()) {
            d16 = f(this.f307930a.getId(), this.f307931b);
        } else {
            d16 = m.e().d(this.f307930a.getId(), this.f307931b);
        }
        QLog.e("ThemeFontAdapter", 2, "load   fontInfo:" + d16 + " sCurrentTryNumber:" + f307924q);
        if (d16 != null) {
            C(d16.f32751a, this.f307931b);
            destroy();
        }
    }
}
