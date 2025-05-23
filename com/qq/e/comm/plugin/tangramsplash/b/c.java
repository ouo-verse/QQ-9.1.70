package com.qq.e.comm.plugin.tangramsplash.b;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.base.ad.model.ExtraCreativeElement;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.k;
import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.tangramsplash.d.e;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.report.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.comm.util.StringUtil;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static int f39802c;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f39801b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public static e f39800a = new e();

    /* renamed from: d, reason: collision with root package name */
    private static String f39803d = GDTADManager.getInstance().getAppStatus().getAPPID();

    /* renamed from: e, reason: collision with root package name */
    private static String f39804e = SharedPreferencedUtil.getString("splash_pos_id", "");

    /* renamed from: f, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<r>> f39805f = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<r>> f39806g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private static CopyOnWriteArrayList<b> f39807h = new CopyOnWriteArrayList<>();

    public static boolean b(r rVar) {
        if (rVar == null) {
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconFlipSrc, adInfo is null");
            return false;
        }
        if (!rVar.aI()) {
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconFlipSrc, not AuraIconFlipAd, just return true");
            return true;
        }
        InteractiveInfo bJ = rVar.bJ();
        if (bJ == null) {
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconFlipSrc, interactiveInfo is null");
            return false;
        }
        String s16 = rVar.s();
        String K = bJ.K();
        File a16 = at.a(s16, K);
        if (a16 != null && a16.exists()) {
            File[] listFiles = a16.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                File a17 = at.a(3, s16, K);
                if (a17 == null || !a17.exists()) {
                    return true;
                }
                GDTLogger.e("TGSplashMaterialUtil: checkAuraIconFlipSrc, hasn't finish unzip");
                return false;
            }
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconFlipSrc, iconsDir is empty");
            return false;
        }
        GDTLogger.e("TGSplashMaterialUtil: checkAuraIconFlipSrc, invalid iconsDir");
        return false;
    }

    public static boolean c(r rVar) {
        if (rVar == null) {
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, adInfo is null");
            return false;
        }
        if (!rVar.aJ()) {
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, not AuraIconTwistAd, just return true");
            return true;
        }
        InteractiveInfo bJ = rVar.bJ();
        if (bJ == null) {
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, interactiveInfo is null");
            return false;
        }
        String s16 = rVar.s();
        String K = bJ.K();
        File a16 = at.a(s16, K);
        if (a16 != null && a16.exists()) {
            File a17 = at.a(3, s16, K);
            if (a17 != null && a17.exists()) {
                GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, hasn't finish unzip");
                return false;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a16.getAbsolutePath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("1.png");
            if (!new File(sb5.toString()).exists()) {
                GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, leftIconFile doesn't exist");
                return false;
            }
            if (!new File(a16.getAbsolutePath() + str + "2.png").exists()) {
                GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, rightIconFile doesn't exist");
                return false;
            }
            String L = bJ.L();
            if (TextUtils.isEmpty(L)) {
                GDTLogger.i("TGSplashMaterialUtil: checkAuraIconTwistSrc, collisionAnimationUrl from backend is null or empty, ignore check apng");
                return true;
            }
            File a18 = k.a(1, rVar.s(), L);
            if (a18 != null && a18.exists()) {
                return true;
            }
            GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, invalid apngFile");
            return false;
        }
        GDTLogger.e("TGSplashMaterialUtil: checkAuraIconTwistSrc, invalid iconsDir");
        return false;
    }

    public static boolean d(r rVar) {
        File a16;
        if (rVar == null) {
            return false;
        }
        if ("LeanBlowInteractive".equals(rVar.bP())) {
            JSONObject bV = rVar.bV();
            if (!y.a(bV)) {
                return false;
            }
            JSONArray f16 = y.f(bV, "image_list");
            if (w.a(f16)) {
                return false;
            }
            for (int i3 = 0; i3 < f16.length(); i3++) {
                String a17 = w.a(f16, i3, "");
                if (TextUtils.isEmpty(a17) || (a16 = at.a(1, rVar.s(), a17)) == null || !a16.exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean e(r rVar) {
        if (rVar == null) {
            return false;
        }
        if ("ShakeAndClickInteractive".equals(rVar.bP()) || "GiftBoxInteractive".equals(rVar.bP()) || "IconFollowSlideInteractive".equals(rVar.bP()) || "LeanForwardCardInteractive".equals(rVar.bP()) || "LeanBlowInteractive".equals(rVar.bP())) {
            InteractiveInfo bJ = rVar.bJ();
            if (bJ == null) {
                return false;
            }
            if (!TextUtils.isEmpty(bJ.u())) {
                File a16 = at.a(1, rVar.s(), rVar.bJ().u());
                if (a16.exists() && ("LeanForwardCardInteractive".equals(rVar.bP()) || "LeanBlowInteractive".equals(rVar.bP()))) {
                    File f16 = com.qq.e.comm.plugin.tangramsplash.interactive.e.f(rVar);
                    if (f16 == null || !f16.exists()) {
                        return false;
                    }
                    return true;
                }
                return a16.exists();
            }
        }
        if (!b(rVar)) {
            GDTLogger.i("AuraIconFlipAd: checkInteractiveAdIconResource, icons don't exist");
            return false;
        }
        if (c(rVar)) {
            return true;
        }
        GDTLogger.i("AuraIconTwistAd: checkInteractiveAdIconResource, icons don't exist");
        return false;
    }

    public static boolean f(r rVar) {
        if (rVar == null) {
            return false;
        }
        if ("AnimationInteractive".equals(rVar.bP())) {
            InteractiveInfo bJ = rVar.bJ();
            if (bJ == null || bJ.g() == null) {
                return false;
            }
            List<String> b16 = bJ.g().b();
            if (g.b(b16)) {
                return false;
            }
            for (String str : b16) {
                GDTLogger.d("\u7ea2\u5305\u96e8\u7d20\u6750\u68c0\u67e5: " + str);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                File a16 = at.a(1, rVar.s(), str);
                if (!a16.exists()) {
                    GDTLogger.e("\u7ea2\u5305\u96e8\u7d20\u6750\u4e0d\u5b58\u5728: " + a16.getAbsolutePath());
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean g(r rVar) {
        boolean z16;
        File a16;
        boolean z17;
        if (!f.a(rVar)) {
            return false;
        }
        r bx4 = rVar.bx();
        if (at.a(1, bx4.s(), bx4.h()).exists()) {
            z16 = true;
        } else {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(14019, bx4, false);
            z16 = false;
        }
        if (!TextUtils.isEmpty(bx4.bt())) {
            a16 = at.a(2, bx4.s(), bx4.bt());
        } else {
            a16 = at.a(2, bx4.s(), bx4.x());
        }
        if (a16.exists()) {
            z17 = true;
        } else {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(14029, bx4, false);
            z17 = false;
        }
        if (com.qq.e.comm.plugin.j.c.a(bx4.s(), "splashOneshotStrictMode", 0, 1)) {
            if (bx4.w() == 1) {
                if (!z17 || !z16) {
                    return false;
                }
            } else {
                return z16;
            }
        } else if (!z16 && !z17) {
            return false;
        }
        return true;
    }

    public static boolean h(r rVar) {
        File a16;
        boolean z16 = false;
        if (!f.a(rVar)) {
            return false;
        }
        r bx4 = rVar.bx();
        if (TextUtils.isEmpty(bx4.ad())) {
            GDTLogger.i("OneShot Transparent Video Url is null");
            return false;
        }
        if (!TextUtils.isEmpty(bx4.bu())) {
            a16 = at.a(2, bx4.s(), bx4.bu());
        } else {
            a16 = at.a(2, bx4.s(), bx4.ad());
        }
        if (a16 != null && a16.exists()) {
            z16 = true;
        }
        GDTLogger.i("checkOneShotTransparentVideoSrc = " + z16);
        return z16;
    }

    public static boolean i(r rVar) {
        if (com.qq.e.comm.plugin.j.c.c()) {
            GDTLogger.i("checkOneshotFocusSrc on");
            if (!g(rVar)) {
                GDTLogger.i("checkOneshotFocusSrc failed");
                return false;
            }
        }
        if (com.qq.e.comm.plugin.j.c.d()) {
            GDTLogger.i("checkOneShotTransparentVideoSrc on");
            if (!h(rVar)) {
                GDTLogger.i("checkOneShotTransparentVideoSrc failed");
                return false;
            }
            return true;
        }
        return true;
    }

    private static boolean j(r rVar) {
        String str;
        if (rVar == null) {
            return false;
        }
        if ("SlideFlipInteractive".equals(rVar.bP())) {
            com.qq.e.comm.plugin.base.ad.model.k bK = rVar.bK();
            InteractiveInfo bJ = rVar.bJ();
            if (bK == null || bJ == null) {
                return false;
            }
            if (bJ.f() != null && bJ.f().a()) {
                String s16 = rVar.s();
                String str2 = null;
                if (bJ.f() != null) {
                    str = bJ.f().f38880a;
                } else {
                    str = null;
                }
                if (!at.a(1, s16, str).exists()) {
                    return false;
                }
                String s17 = rVar.s();
                if (bJ.f() != null) {
                    str2 = bJ.f().f38888i;
                }
                return at.a(1, s17, str2).exists();
            }
        }
        return true;
    }

    public static void a(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u542f\u52a8\u95ea\u5c4f\u7d20\u6750\u68c0\u6d4b\uff1a\u662f\u5426\u4e3asdk\u521d\u59cb\u5316");
        sb5.append(i3 == 2);
        GDTLogger.e(sb5.toString());
        f39802c = i3;
        if (TextUtils.isEmpty(f39804e)) {
            GDTLogger.e("\u672a\u8bfb\u5230\u7f13\u5b58posid");
            return;
        }
        final String[] split = f39804e.split(",");
        GDTLogger.e("\u542f\u52a8\u95ea\u5c4f\u7d20\u6750\u68c0\u6d4b\uff1aposid " + Arrays.toString(split));
        a(split);
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.a((Object[]) split)) {
                    for (String str : split) {
                        c.b(str);
                    }
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x006e, code lost:
    
        if (com.qq.e.comm.plugin.k.at.a(1, r6.s(), r6.h()).exists() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x009f, code lost:
    
        if (r1 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(r rVar) {
        boolean exists;
        r.a b16;
        if (rVar == null) {
            return false;
        }
        if (rVar.bI() != null && rVar.bI().size() > 0 && (b16 = com.qq.e.comm.plugin.tangramsplash.d.a.b(rVar)) != null) {
            rVar.a(b16);
        }
        int w3 = rVar.w();
        if (w3 != 0) {
            if (w3 == 1) {
                if (!StringUtil.isEmpty(rVar.bt())) {
                    exists = at.a(2, rVar.s(), rVar.bt()).exists();
                } else {
                    exists = at.a(2, rVar.s(), rVar.x()).exists();
                }
                if (!rVar.cc()) {
                    if (!exists) {
                    }
                    exists = true;
                }
            }
            exists = false;
        } else if (rVar.aH()) {
            ExtraCreativeElement bL = rVar.bL();
            if (bL != null) {
                boolean z16 = bL.c() != null && bL.c().b(rVar.s());
                boolean b17 = bL.b(rVar.s());
                if (z16) {
                }
            } else {
                GDTLogger.e("isOlympicGallery ExtraCreativeElement null");
            }
            exists = false;
        } else {
            exists = at.a(1, rVar.s(), rVar.h()).exists();
        }
        if (!exists) {
            return false;
        }
        if (f.a(rVar) && !i(rVar)) {
            return false;
        }
        if (rVar.bG()) {
            if (!at.a(1, rVar.s(), rVar.i()).exists()) {
                return false;
            }
            if (!TextUtils.isEmpty(rVar.bE()) && !at.a(2, rVar.s(), rVar.bE()).exists()) {
                return false;
            }
        }
        if (rVar.bJ() != null) {
            if (!e(rVar) || !f(rVar) || !d(rVar) || !j(rVar)) {
                return false;
            }
            if (rVar.bJ().f() != null && rVar.bJ().f().a()) {
                if ("ShakeInteractive".equals(rVar.bP())) {
                    File b18 = at.b(rVar.s(), com.qq.e.comm.plugin.tangramsplash.interactive.e.d(rVar));
                    if (b18 == null || !b18.exists()) {
                        return false;
                    }
                } else {
                    File e16 = com.qq.e.comm.plugin.tangramsplash.interactive.e.e(rVar);
                    if (!TextUtils.isEmpty(com.qq.e.comm.plugin.tangramsplash.interactive.e.a(rVar)) && (e16 == null || !e16.exists())) {
                        return false;
                    }
                }
            }
        }
        return exists;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("\u672a\u8c03\u7528\u9884\u52a0\u8f7d\u63a5\u53e3");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a(at.a(str), str);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310114, str, f39802c, System.currentTimeMillis() - currentTimeMillis);
    }

    private static void a(String[] strArr) {
        if (!g.a((Object[]) strArr)) {
            GDTLogger.e("\u672a\u8c03\u7528\u9884\u52a0\u8f7d\u63a5\u53e3");
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                a(at.c(str, false), false, str);
                a(at.c(str, true), true, str);
            }
        }
    }

    private static void a(File file, boolean z16, String str) {
        if (file == null || !file.exists()) {
            return;
        }
        List<r> a16 = com.qq.e.comm.plugin.tangramsplash.c.e.a().a(f39803d, str, com.qq.e.comm.plugin.k.a.a(f39803d, str, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId()), com.qq.e.comm.plugin.base.ad.b.SPLASH, z16, new c.a(0, 0), true);
        if (a16 != null) {
            synchronized (f39801b) {
                try {
                    if (z16) {
                        f39806g.put(str, a16);
                    } else {
                        f39805f.put(str, a16);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            com.qq.e.comm.plugin.tangramsplash.c.e.a().a(a16, str, z16, f39802c == 1);
            return;
        }
        GDTLogger.e("\u672c\u5730\u65e0\u9884\u52a0\u8f7d\u7f13\u5b58\u6570\u636e");
    }

    private static void a(File file, String str) {
        synchronized (f39801b) {
            GDTLogger.d("\u5904\u7406\u7f13\u5b58\u6587\u4ef6\u5939\uff1a" + file.getName());
            List<b> a16 = a(f39805f.get(str), false, str);
            List<b> a17 = a(f39806g.get(str), true, str);
            ConcurrentHashMap<String, List<r>> concurrentHashMap = f39806g;
            if (concurrentHashMap != null) {
                concurrentHashMap.remove(str);
            }
            ConcurrentHashMap<String, List<r>> concurrentHashMap2 = f39805f;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.remove(str);
            }
            try {
                a(str, a16, file, false);
                a(str, a17, file, true);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            f39807h.clear();
        }
    }

    private static void a(String str, List<b> list, File file, boolean z16) {
        if (list != null && file != null) {
            for (b bVar : list) {
                if (bVar == null) {
                    GDTLogger.e("handlePreloadDataFileDir error :info == null");
                } else {
                    try {
                        if (bVar.f() != 0 && !TextUtils.isEmpty(bVar.g())) {
                            a(bVar.g(), at.a(bVar.g()), z16, bVar);
                        } else {
                            a(str, file, z16, bVar);
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            return;
        }
        GDTLogger.e("handlePreloadDataFileDir error :infos == null || file == null  isHotStart " + z16);
    }

    private static void a(String str, File file, boolean z16, b bVar) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                int length = listFiles.length;
                boolean z17 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    File file2 = listFiles[i3];
                    if (file2 != null && !"preload".equals(file2.getName()) && !TextUtils.isEmpty(file2.getName()) && file2.getName().equals(bVar.e())) {
                        z17 = true;
                        break;
                    }
                    i3++;
                }
                if (z17) {
                    return;
                }
                a(str, bVar, file, z16);
                return;
            }
            GDTLogger.e("handlePreloadDataFileDir error :files is empty");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private static void a(String str, b bVar, File file, boolean z16) {
        if (bVar != null && !TextUtils.isEmpty(bVar.a()) && !TextUtils.isEmpty(bVar.e()) && file != null) {
            GDTLogger.e("\u53d1\u73b0\u672a\u4e0b\u8f7d\u7684\u7d20\u6750\uff0cmd5\uff1a" + bVar.e() + "posid " + str + " \u6765\u6e90\u5355:" + bVar.f() + " \u5f00\u59cb\u4e0b\u8f7durl:" + bVar.a() + " dir\uff1a" + file.getAbsolutePath());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file);
            sb5.append(File.separator);
            sb5.append(bVar.e());
            File file2 = new File(sb5.toString());
            if (file2.exists()) {
                GDTLogger.e("\u6587\u4ef6\u5df2\u5b58\u5728\uff1a" + file2.getAbsolutePath());
                return;
            }
            if ((bVar.c() == 2 || bVar.c() == 3) && (GDTADManager.getInstance().getSM().getInteger("preloadResNetwork", NetworkType.WIFI.getPermValue()) & GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue()) <= 0) {
                GDTLogger.i("\u521d\u59cb\u5316\u9884\u52a0\u8f7d-\u5f53\u524d\u8bbe\u5907\u7684\u7f51\u7edc\u7c7b\u578b\u4e0d\u7b26\u5408\u9884\u52a0\u8f7d\u5e7f\u544a\u8d44\u6e90\u7684\u6761\u4ef6\uff0c\u8bf7\u5c1d\u8bd5WIFI\u73af\u5883\u3002\u5982\u4ecd\u6709\u95ee\u9898\u8bf7\u8054\u7cfb\u5ba2\u670d");
                return;
            }
            h a16 = new h.a().c(bVar.a()).a(file).a(bVar.e()).a();
            GDTLogger.d("start supp download \uff1a" + a16.c());
            com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a(a16, bVar.a(), new a(a16, bVar.c(), str, bVar.d(), bVar.b(), z16, f39802c));
            f39800a.a("supplement_download" + bVar.e());
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310110, str, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, Integer.MIN_VALUE, Integer.MIN_VALUE, 1, bVar.c() == 1 ? 0 : 1, bVar.a(), z16, f39802c, Integer.MIN_VALUE), bVar.b()));
            return;
        }
        GDTLogger.e("handlePreloadMaterialUnDownload error :invalid params");
    }

    private static List<b> a(List<r> list, boolean z16, String str) {
        String c16;
        if (list != null && list.size() != 0) {
            GDTLogger.d("\u5f00\u59cb\u8bfb\u53d6\u672c\u5730\u9884\u52a0\u8f7d\u6570\u636e :\u70ed\u542f\u52a8:" + z16 + " size\uff1a" + list.size());
            for (int i3 = 0; i3 < list.size(); i3++) {
                r rVar = list.get(i3);
                if (rVar == null) {
                    GDTLogger.e("\u9884\u52a0\u8f7d\u6570\u636e\u4e3anull");
                } else {
                    if (!TextUtils.isEmpty(rVar.bw()) && !TextUtils.isEmpty(rVar.bv()) && rVar.bx() != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(rVar.bx());
                        a(arrayList, z16, str);
                    }
                    if (rVar.bI() != null && rVar.bI().size() > 0) {
                        for (r.a aVar : rVar.bI()) {
                            if (!TextUtils.isEmpty(aVar.f39127c)) {
                                b bVar = new b();
                                bVar.a(z16);
                                bVar.d(at.c(aVar.f39127c));
                                bVar.b(2);
                                bVar.a(1);
                                bVar.a(aVar.f39127c);
                                bVar.b(rVar.f());
                                bVar.e(rVar.s());
                                f39807h.add(bVar);
                            }
                            if (!TextUtils.isEmpty(aVar.f39128d)) {
                                b bVar2 = new b();
                                bVar2.a(z16);
                                bVar2.d(at.c(aVar.f39128d));
                                bVar2.b(2);
                                bVar2.a(2);
                                bVar2.a(aVar.f39128d);
                                bVar2.b(rVar.f());
                                bVar2.e(rVar.s());
                                f39807h.add(bVar2);
                            }
                        }
                    }
                    if (rVar.bJ() != null && !TextUtils.isEmpty(com.qq.e.comm.plugin.tangramsplash.interactive.e.a(rVar))) {
                        b bVar3 = new b();
                        bVar3.a(z16);
                        bVar3.d(at.c(com.qq.e.comm.plugin.tangramsplash.interactive.e.a(rVar)));
                        bVar3.b(3);
                        bVar3.a(2);
                        bVar3.a(com.qq.e.comm.plugin.tangramsplash.interactive.e.a(rVar));
                        bVar3.b(rVar.f());
                        bVar3.e(rVar.s());
                        f39807h.add(bVar3);
                    }
                    b bVar4 = new b();
                    bVar4.b(rVar.f());
                    if (TextUtils.isEmpty(rVar.bt())) {
                        if (rVar.w() == 1) {
                            c16 = at.c(rVar.x());
                            bVar4.a(rVar.x());
                            bVar4.a(2);
                        } else {
                            c16 = at.c(rVar.h());
                            bVar4.a(rVar.h());
                            bVar4.a(1);
                        }
                    } else {
                        c16 = at.c(rVar.bt());
                        bVar4.a(rVar.x());
                        bVar4.c(rVar.bt());
                        bVar4.a(2);
                    }
                    if (!TextUtils.isEmpty(c16)) {
                        bVar4.d(c16);
                        if (str.equals(rVar.s())) {
                            bVar4.b(0);
                        } else {
                            bVar4.b(1);
                        }
                        bVar4.e(rVar.s());
                        f39807h.add(bVar4);
                    }
                }
            }
            return f39807h;
        }
        GDTLogger.e("\u65e0\u672c\u5730\u9884\u52a0\u8f7d\u6570\u636e\u7f13\u5b58 isHotStart " + z16);
        return null;
    }
}
