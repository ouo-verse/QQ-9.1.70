package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.a;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.w;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes11.dex */
public class IndividualRedPacketManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    private static String f194757b0;

    /* renamed from: c0, reason: collision with root package name */
    public static String f194758c0;

    /* renamed from: d0, reason: collision with root package name */
    public static int f194759d0;

    /* renamed from: e0, reason: collision with root package name */
    public static String f194760e0;

    /* renamed from: f0, reason: collision with root package name */
    public static int f194761f0;

    /* renamed from: g0, reason: collision with root package name */
    public static int f194762g0;

    /* renamed from: h0, reason: collision with root package name */
    public static int f194763h0;

    /* renamed from: i0, reason: collision with root package name */
    public static int f194764i0;
    int C;
    float D;
    public AtomicBoolean E;
    public AtomicBoolean F;
    public AtomicBoolean G;
    ETFont H;
    QQAppInterface I;
    ETEngine J;
    public ConcurrentHashMap<String, RedPacketInfo> K;
    LinkedList<String> L;
    public com.tencent.mobileqq.vas.w M;
    SharedPreferences N;
    SharedPreferences P;
    Comparator<File> Q;
    Boolean R;
    AtomicBoolean S;
    AtomicBoolean T;
    bd U;
    c V;
    public bc W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f194765a0;

    /* renamed from: d, reason: collision with root package name */
    float f194766d;

    /* renamed from: e, reason: collision with root package name */
    int f194767e;

    /* renamed from: f, reason: collision with root package name */
    int f194768f;

    /* renamed from: h, reason: collision with root package name */
    int f194769h;

    /* renamed from: i, reason: collision with root package name */
    int f194770i;

    /* renamed from: m, reason: collision with root package name */
    int f194771m;

    /* loaded from: classes11.dex */
    class a implements Comparator<File> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IndividualRedPacketManager.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            long j16 = 0;
            if (file != null) {
                j3 = file.lastModified();
            } else {
                j3 = 0;
            }
            if (file2 != null) {
                j16 = file2.lastModified();
            }
            if (j16 < j3) {
                return -1;
            }
            if (j16 > j3) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f194777a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f194778b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f194779c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f194780d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f194777a = null;
            this.f194778b = false;
            this.f194779c = false;
            this.f194780d = false;
        }
    }

    /* loaded from: classes11.dex */
    public static class c implements Handler.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<QQAppInterface> f194781d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<IndividualRedPacketManager> f194782e;

        /* renamed from: f, reason: collision with root package name */
        w.b f194783f;

        /* renamed from: h, reason: collision with root package name */
        int f194784h;

        public c(IndividualRedPacketManager individualRedPacketManager, QQAppInterface qQAppInterface, w.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, individualRedPacketManager, qQAppInterface, bVar);
                return;
            }
            this.f194784h = 0;
            this.f194781d = new WeakReference<>(qQAppInterface);
            this.f194782e = new WeakReference<>(individualRedPacketManager);
            this.f194783f = bVar;
        }

        void a(int i3) {
            String str;
            int i16;
            int i17;
            QQAppInterface qQAppInterface = this.f194781d.get();
            IndividualRedPacketManager individualRedPacketManager = this.f194782e.get();
            if (qQAppInterface != null && individualRedPacketManager != null) {
                String a16 = this.f194783f.a();
                if (i3 >= a16.length()) {
                    File[] listFiles = new File(IndividualRedPacketManager.p(4)).listFiles();
                    SharedPreferences.Editor edit = individualRedPacketManager.n().edit();
                    if (listFiles != null && listFiles.length >= a16.length()) {
                        edit.putBoolean("font_precreate_finish", true);
                    } else {
                        edit.putInt("font_precreate_index", 0);
                    }
                    int i18 = individualRedPacketManager.n().getInt("font_precreate_count", 0);
                    edit.putInt("font_precreate_count", i18 + 1);
                    edit.commit();
                    QLog.d(IndividualRedPacketManager.f194757b0, 1, "preCreatePersonalFontImg create count = " + i18);
                    return;
                }
                if (individualRedPacketManager.v()) {
                    str = "1";
                } else {
                    str = "0";
                }
                String str2 = str;
                if (!individualRedPacketManager.T.get() && !Thread.currentThread().isInterrupted()) {
                    int i19 = i3 + 1;
                    String substring = a16.substring(i3, i19);
                    if (new File(IndividualRedPacketManager.x("", substring, 4, 0, 0)).exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.e(IndividualRedPacketManager.f194757b0, 2, "preCreatePersonalFontImg exists : " + substring + " address = " + IndividualRedPacketManager.x("", substring, 4, 0, 0));
                        }
                        individualRedPacketManager.n().edit().putInt("font_precreate_index", i19).commit();
                        Message i26 = individualRedPacketManager.W.i();
                        i26.what = i19;
                        individualRedPacketManager.W.e(i26, 500L);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    Bitmap g16 = individualRedPacketManager.g(substring, true);
                    if (g16 != null) {
                        this.f194784h = 0;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        individualRedPacketManager.n().edit().putInt("font_precreate_index", i19).commit();
                        if (i3 % 100 == 0) {
                            i17 = i19;
                            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, str2, "1", String.valueOf(currentTimeMillis2 - currentTimeMillis), substring);
                        } else {
                            i17 = i19;
                        }
                        if (!g16.isRecycled()) {
                            g16.recycle();
                        }
                        i16 = i17;
                    } else {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (QLog.isColorLevel()) {
                            QLog.d(IndividualRedPacketManager.f194757b0, 2, "preCreatePersonalFontImg " + substring + "fail");
                        }
                        if (i3 % 100 == 0) {
                            i16 = i19;
                            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, str2, "0", String.valueOf(currentTimeMillis3 - currentTimeMillis), substring);
                        } else {
                            i16 = i19;
                        }
                        int i27 = this.f194784h + 1;
                        this.f194784h = i27;
                        if (i27 >= this.f194783f.f311374j) {
                            QLog.e(IndividualRedPacketManager.f194757b0, 1, "preCreatePersonalFontImg fail count = " + this.f194784h + " max failcount = " + this.f194783f.f311374j);
                            return;
                        }
                    }
                    Message i28 = individualRedPacketManager.W.i();
                    i28.what = i16;
                    individualRedPacketManager.W.e(i28, 5000L);
                }
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQAppInterface qQAppInterface = this.f194781d.get();
            IndividualRedPacketManager individualRedPacketManager = this.f194782e.get();
            if (qQAppInterface != null && individualRedPacketManager != null && !individualRedPacketManager.G.get()) {
                if (individualRedPacketManager.n().getBoolean("font_precreate_finish", false)) {
                    return;
                }
                QLog.d(IndividualRedPacketManager.f194757b0, 1, "preCreatePersonalFontImg start!");
                int i3 = individualRedPacketManager.n().getInt("font_precreate_index", 0);
                Message i16 = individualRedPacketManager.W.i();
                i16.what = i3;
                individualRedPacketManager.W.h(i16);
                return;
            }
            QLog.d(IndividualRedPacketManager.f194757b0, 1, "preCreatePersonalFontImg return!");
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
            }
            a(message.what);
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69772);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        f194757b0 = "IndividualRedPacketManager";
        f194758c0 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "RedPacket/");
        f194759d0 = 10029;
        f194760e0 = "0";
        f194761f0 = 0;
        f194762g0 = -1;
        f194763h0 = 0;
        f194764i0 = -1;
    }

    public IndividualRedPacketManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194766d = 0.0f;
        this.f194767e = 0;
        this.f194768f = 0;
        this.f194769h = 0;
        this.f194770i = 0;
        this.f194771m = 0;
        this.C = 0;
        this.G = new AtomicBoolean(false);
        this.Q = new a();
        this.R = Boolean.FALSE;
        this.S = new AtomicBoolean(false);
        this.T = new AtomicBoolean(false);
        this.X = 0;
        this.Y = 0;
        this.Z = -1;
        this.I = qQAppInterface;
        SharedPreferences t16 = t();
        Q(t16.getInt(AppConstants.Preferences.VIP_INFO_CAN_USE_PACKET, 0), t16.getInt(AppConstants.Preferences.VIP_INFO_RED_PACKET_DISABLE, 0), false);
        R(t16.getInt(AppConstants.Preferences.VIP_INFO_RED_PACKET_ID, -1), t16.getString(AppConstants.Preferences.VIP_INFO_RED_PACKET_TEXT, null));
        this.J = ETEngine.getInstanceForRedPacket();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.E = atomicBoolean;
        atomicBoolean.set(false);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        this.F = atomicBoolean2;
        atomicBoolean2.set(false);
        this.L = new LinkedList<>();
        this.D = qQAppInterface.getApp().getApplicationContext().getResources().getDisplayMetrics().density;
        this.f194767e = (int) ((138.0f * r8) + 0.5d);
        this.f194768f = (int) ((115.0f * r8) + 0.5d);
        this.f194770i = (int) ((r8 * 280.0f) + 0.5d);
        this.f194769h = (int) ((280.0f * r8) + 0.5d);
        this.C = (int) ((r8 * 104.0f) + 0.5d);
        this.f194771m = (int) ((320.0f * r8) + 0.5d);
        this.f194766d = (int) ((r8 * 104.0f) + 0.5d);
        this.K = new ConcurrentHashMap<>();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.IndividualRedPacketManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IndividualRedPacketManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IndividualRedPacketManager.this.E(true);
                if (QLog.isColorLevel()) {
                    QLog.d(IndividualRedPacketManager.f194757b0, 2, "AIO_BG_WIDTH:" + IndividualRedPacketManager.this.f194767e);
                }
                IndividualRedPacketManager.this.u().J();
                IndividualRedPacketManager.this.u().t();
                IndividualRedPacketManager.this.k();
                IndividualRedPacketManager individualRedPacketManager = IndividualRedPacketManager.this;
                if (individualRedPacketManager.Z > 0) {
                    w.f m3 = individualRedPacketManager.u().m(String.valueOf(IndividualRedPacketManager.this.Z), true);
                    if (m3 == null || m3.f311392b == null || m3.f311393c == null || m3.f311394d == null) {
                        IndividualRedPacketManager.this.u().f(16L, String.valueOf(IndividualRedPacketManager.this.Z), null, "init_individual");
                    }
                }
            }
        }, 8, null, true);
    }

    @Nullable
    private static w.f B(IndividualRedPacketManager individualRedPacketManager, RedPacketInfo redPacketInfo, String str, String str2, com.tencent.mobileqq.vas.w wVar) {
        w.f m3 = wVar.m(str, true);
        if (m3 != null && m3.f311392b != null && m3.f311393c != null && m3.f311394d != null) {
            return m3;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "VIPHBStrategy.get not in local map. Id = " + str + "content = " + str2 + "mTemplateInfoMap.size=" + wVar.f311354b.h());
        }
        individualRedPacketManager.K.putIfAbsent(redPacketInfo.f277231m, redPacketInfo);
        individualRedPacketManager.K.putIfAbsent(redPacketInfo.f277231m + "_tp", redPacketInfo);
        synchronized (wVar.f311364l) {
            if (!wVar.f311364l.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(redPacketInfo.f277231m);
                wVar.f311364l.put(str, arrayList);
            } else {
                wVar.f311364l.get(str).add(redPacketInfo.f277231m);
            }
        }
        wVar.f(16L, str, redPacketInfo.f277231m, "TemplateInfo");
        return null;
    }

    private boolean G(int i3, RedPacketInfo redPacketInfo, w.f fVar, boolean z16) {
        if (i3 == 19) {
            w.c cVar = fVar.f311392b;
            if (cVar != null && cVar.f311378i != null) {
                String x16 = x(cVar.f311384b, null, cVar.f311388f, cVar.f311386d, 0);
                File file = new File(x16);
                if (file.exists() && file.isFile()) {
                    l(fVar, redPacketInfo, x16, false);
                }
                if (redPacketInfo.f277229h != null) {
                    z16 = true;
                }
            }
            return z16;
        }
        if (i3 != 2) {
            return true;
        }
        redPacketInfo.f277227e = j(w(fVar.f311391a, "", 6), null);
        return true;
    }

    private static void I(IndividualRedPacketManager individualRedPacketManager, RedPacketInfo redPacketInfo, String str, w.f fVar, String str2, int i3) {
        b bVar;
        if (TextUtils.isEmpty(str2)) {
            if (fVar.f311397g != 1) {
                bVar = individualRedPacketManager.A(str, i3);
            } else {
                bVar = new b();
                bVar.f194780d = true;
            }
            individualRedPacketManager.h(bVar, redPacketInfo, i3);
        }
    }

    private static String L(String str, String str2, int i3, String str3, String str4, String str5, int i16, String str6) {
        if (i3 == w.f.f311390i) {
            return p(1) + str + File.separator + str5;
        }
        if (!TextUtils.isEmpty(str2) && i3 == w.f.f311389h) {
            String str7 = p(i16) + str + str6 + Integer.toHexString(str2.charAt(0));
            if (str4 != null) {
                return str7 + str4;
            }
            return str7;
        }
        return str3;
    }

    private void N(b bVar, RedPacketInfo redPacketInfo, int i3, Bitmap bitmap) {
        if (i3 == 6) {
            redPacketInfo.f277227e = bitmap;
            return;
        }
        if (i3 == 7) {
            if (bVar.f194779c) {
                M(bitmap, redPacketInfo.templateId, redPacketInfo.f277226d, 13);
                return;
            } else {
                M(bitmap, redPacketInfo.templateId, redPacketInfo.f277226d, 7);
                return;
            }
        }
        if (i3 == 15) {
            if (bVar.f194779c) {
                M(bitmap, redPacketInfo.templateId, redPacketInfo.f277226d, 18);
            } else {
                M(bitmap, redPacketInfo.templateId, redPacketInfo.f277226d, 15);
            }
        }
    }

    private void O(int i3, RedPacketInfo redPacketInfo) {
        if (i3 == 2) {
            i3 = 6;
        } else if (i3 == 3) {
            i3 = 7;
        } else if (i3 == 14) {
            i3 = 15;
        }
        b A = A(redPacketInfo.f277226d, i3);
        Bitmap h16 = h(A, redPacketInfo, i3);
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "onDoneDownloadBG type = " + i3);
        }
        Bitmap bitmap = A.f194777a;
        if (bitmap != null && !A.f194778b) {
            M(bitmap, "", redPacketInfo.f277226d, 5);
        }
        if (6 == i3 && A.f194777a != null && h16 != null) {
            if (!A.f194779c) {
                M(h16, redPacketInfo.templateId, redPacketInfo.f277226d, 6);
            } else {
                M(h16, redPacketInfo.templateId, redPacketInfo.f277226d, 12);
            }
        }
    }

    private static void P(IndividualRedPacketManager individualRedPacketManager, String str, String str2, b bVar, Bitmap bitmap) {
        if (bVar == null) {
            return;
        }
        Bitmap bitmap2 = bVar.f194777a;
        if (bitmap2 != null && !bVar.f194778b && !bVar.f194780d) {
            individualRedPacketManager.M(bitmap2, "", str2, 5);
        }
        if (bitmap != null) {
            if (bVar.f194777a != null || bVar.f194780d) {
                if (bVar.f194779c) {
                    individualRedPacketManager.M(bitmap, str, str2, 12);
                } else {
                    individualRedPacketManager.M(bitmap, str, str2, 6);
                }
            }
        }
    }

    private static boolean c(IndividualRedPacketManager individualRedPacketManager, RedPacketInfo redPacketInfo, String str, com.tencent.mobileqq.vas.w wVar, w.f fVar) {
        w.c cVar = fVar.f311392b;
        boolean z16 = false;
        if (cVar == null || cVar.f311378i == null) {
            return false;
        }
        a.C8458a c8458a = redPacketInfo.f277229h;
        if (c8458a != null && !TextUtils.isEmpty(c8458a.f277232a)) {
            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(redPacketInfo);
            return true;
        }
        File file = null;
        String x16 = x(cVar.f311384b, null, cVar.f311388f, cVar.f311386d, 0);
        if (!TextUtils.isEmpty(x16)) {
            file = new File(x16);
        }
        if (file == null) {
            QLog.d(f194757b0, 2, "VIPHBStrategy.get animFolderPath file == null, zipPath=" + x16);
            return true;
        }
        if (file.exists() && file.isFile()) {
            boolean l3 = l(fVar, redPacketInfo, x16, false);
            if (QLog.isColorLevel() || !l3) {
                QLog.d(f194757b0, 2, "VIPHBStrategy.get animFolderPath getPathOk=" + l3 + ", zipPath=" + x16);
            }
            if (l3) {
                return true;
            }
            z16 = true;
        }
        individualRedPacketManager.K.putIfAbsent(redPacketInfo.f277231m, redPacketInfo);
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "wait animConfig id = " + str + ", exist = " + z16 + ", name=" + cVar.f311383a);
        }
        wVar.f(16L, str, redPacketInfo.f277231m, "animRedPacket");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap f(b bVar, String str, String str2, int i3) {
        String str3;
        Point point;
        int i16;
        int i17;
        int i18;
        Bitmap bitmap;
        int i19;
        w.f m3 = u().m(str, true);
        if (m3 != null && m3.f311392b != null && m3.f311393c != null && m3.f311394d != null) {
            String str4 = "#ffe589";
            if (i3 == 6) {
                str3 = x(str, "", 2, m3.f311396f, m3.f311395e);
                i16 = com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311392b.f311376g / 2);
                i17 = this.f194767e;
                i18 = this.f194768f;
                point = new Point(com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311392b.f311377h.left / 2), com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311392b.f311377h.top / 2));
            } else if (i3 == 7) {
                str3 = x(str, "", 3, m3.f311396f, m3.f311395e);
                i16 = com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311393c.f311376g / 2);
                i17 = this.f194769h;
                i18 = this.f194770i;
                point = new Point(com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311393c.f311377h.left / 2), com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311393c.f311377h.top / 2));
                str4 = "#d13d4b";
            } else if (i3 == 15) {
                str3 = x(str, "", 14, m3.f311396f, m3.f311395e);
                i16 = com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311394d.f311376g / 2);
                i17 = this.f194771m;
                i18 = this.C;
                point = new Point(com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311394d.f311377h.left / 2), com.tencent.mobileqq.util.x.c(this.I.getApp().getApplicationContext(), m3.f311394d.f311377h.top / 2));
                str4 = "#edd4d8";
            } else {
                str3 = null;
                point = null;
                i16 = 0;
                i17 = 0;
                i18 = 0;
            }
            if (str3 == null || point == null) {
                return null;
            }
            Bitmap j3 = j(str3, null);
            Bitmap bitmap2 = bVar.f194777a;
            if (j3 == null) {
                return null;
            }
            try {
                bitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "combineFinalImage Bitmap.createBitmap Error: " + e16.getMessage());
                }
                bitmap = null;
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "combineFinalImage Bitmap.createBitmap OutOfMemoryError: " + e17.getMessage());
                }
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_FailCode", "combineFinalImage");
                    StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, hashMap, "", false);
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            if (bitmap == null) {
                return bitmap;
            }
            RectF rectF = new RectF();
            Rect rect = new Rect();
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            Canvas canvas = new Canvas(bitmap);
            Bitmap bitmap3 = bitmap;
            rect.set(0, 0, j3.getWidth(), j3.getHeight());
            rectF.set(0.0f, 0.0f, i17, i18);
            canvas.drawBitmap(j3, rect, rectF, paint);
            if (bitmap2 != null) {
                if (i3 == 7 && !bVar.f194778b) {
                    i19 = 0;
                    paint.setColorFilter(new LightingColorFilter(0, 13712715));
                } else {
                    i19 = 0;
                    if (i3 == 15 && !bVar.f194778b) {
                        paint.setColorFilter(new LightingColorFilter(0, 15586520));
                    }
                }
                rect.set(i19, i19, bitmap2.getWidth(), bitmap2.getHeight());
                rectF.set(point.x, point.y, r1 + i16, r3 + i16);
                canvas.drawBitmap(bitmap2, rect, rectF, paint);
            } else {
                paint.setColor(Color.parseColor(str4));
                float f16 = i16;
                paint.setTextSize(0.7f * f16);
                float[] fArr = new float[1];
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                paint.getTextWidths(str2, fArr);
                int i26 = (int) (point.x + ((f16 - fArr[0]) / 2.0f));
                int i27 = point.y;
                int i28 = fontMetricsInt.ascent;
                canvas.drawText(str2, i26, (i27 - i28) + ((i16 - (fontMetricsInt.descent - i28)) / 2), paint);
            }
            return bitmap3;
        }
        if (QLog.isColorLevel()) {
            QLog.e(f194757b0, 2, "combineFinalImage init json fail, templateId:" + str);
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[Catch: all -> 0x00f1, TryCatch #0 {, blocks: (B:6:0x0009, B:11:0x0019, B:13:0x0020, B:16:0x0030, B:19:0x0039, B:20:0x0049, B:22:0x0050, B:24:0x0056, B:26:0x0065, B:27:0x0069, B:29:0x006f, B:31:0x0073, B:32:0x007f, B:33:0x009d, B:36:0x00a5, B:37:0x00ad, B:39:0x00b3, B:41:0x00b9, B:43:0x00c8, B:44:0x00cd, B:46:0x00dc, B:47:0x00e3, B:53:0x0078, B:54:0x0086, B:56:0x0040), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc A[Catch: all -> 0x00f1, TryCatch #0 {, blocks: (B:6:0x0009, B:11:0x0019, B:13:0x0020, B:16:0x0030, B:19:0x0039, B:20:0x0049, B:22:0x0050, B:24:0x0056, B:26:0x0065, B:27:0x0069, B:29:0x006f, B:31:0x0073, B:32:0x007f, B:33:0x009d, B:36:0x00a5, B:37:0x00ad, B:39:0x00b3, B:41:0x00b9, B:43:0x00c8, B:44:0x00cd, B:46:0x00dc, B:47:0x00e3, B:53:0x0078, B:54:0x0086, B:56:0x0040), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0086 A[Catch: all -> 0x00f1, TryCatch #0 {, blocks: (B:6:0x0009, B:11:0x0019, B:13:0x0020, B:16:0x0030, B:19:0x0039, B:20:0x0049, B:22:0x0050, B:24:0x0056, B:26:0x0065, B:27:0x0069, B:29:0x006f, B:31:0x0073, B:32:0x007f, B:33:0x009d, B:36:0x00a5, B:37:0x00ad, B:39:0x00b3, B:41:0x00b9, B:43:0x00c8, B:44:0x00cd, B:46:0x00dc, B:47:0x00e3, B:53:0x0078, B:54:0x0086, B:56:0x0040), top: B:5:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void i(AppInterface appInterface, IndividualRedPacketManager individualRedPacketManager, RedPacketInfo redPacketInfo) {
        boolean z16;
        String str;
        b bVar;
        Bitmap bitmap;
        String str2;
        String str3;
        b bVar2;
        synchronized (IndividualRedPacketManager.class) {
            if (individualRedPacketManager != null && redPacketInfo != null) {
                String str4 = redPacketInfo.templateId;
                String str5 = redPacketInfo.f277226d;
                com.tencent.mobileqq.vas.w u16 = individualRedPacketManager.u();
                w.f B = B(individualRedPacketManager, redPacketInfo, str4, str5, u16);
                if (B == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str5) && u16.f311356d.a().contains(str5)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (B.f311395e == w.f.f311389h) {
                    if (z16) {
                        str = individualRedPacketManager.w(str4, str5, 12);
                        if (TextUtils.isEmpty(str) && (TextUtils.isEmpty(str5) || TextUtils.isEmpty(individualRedPacketManager.w("", str5, 9)))) {
                            str = individualRedPacketManager.w(str4, str5, 6);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            if (B.f311397g != 1) {
                                bVar2 = individualRedPacketManager.A(str5, 6);
                            } else {
                                bVar2 = new b();
                                bVar2.f194780d = true;
                            }
                            bVar = bVar2;
                            bitmap = individualRedPacketManager.h(bVar2, redPacketInfo, 6);
                        } else {
                            redPacketInfo.f277227e = j(str, null);
                            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(redPacketInfo);
                            bVar = null;
                            bitmap = null;
                        }
                        if (B.f311395e != w.f.f311389h && z16) {
                            str2 = individualRedPacketManager.w(str4, str5, 13);
                        } else {
                            str2 = null;
                        }
                        if (TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str5) || TextUtils.isEmpty(individualRedPacketManager.w("", str5, 10)))) {
                            str2 = individualRedPacketManager.w(str4, str5, 7);
                        }
                        I(individualRedPacketManager, redPacketInfo, str5, B, str2, 7);
                        if (B.f311395e != w.f.f311389h) {
                            str3 = y(individualRedPacketManager, str4, str5, null, z16);
                        } else {
                            str3 = null;
                        }
                        I(individualRedPacketManager, redPacketInfo, str5, B, str3, 15);
                        P(individualRedPacketManager, str4, str5, bVar, bitmap);
                    }
                } else if (c(individualRedPacketManager, redPacketInfo, str4, u16, B)) {
                    return;
                }
                str = null;
                if (TextUtils.isEmpty(str)) {
                    str = individualRedPacketManager.w(str4, str5, 6);
                }
                if (!TextUtils.isEmpty(str)) {
                }
                if (B.f311395e != w.f.f311389h) {
                }
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                    str2 = individualRedPacketManager.w(str4, str5, 7);
                }
                I(individualRedPacketManager, redPacketInfo, str5, B, str2, 7);
                if (B.f311395e != w.f.f311389h) {
                }
                I(individualRedPacketManager, redPacketInfo, str5, B, str3, 15);
                P(individualRedPacketManager, str4, str5, bVar, bitmap);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.app.IndividualRedPacketManager.f194757b0, 2, "redpacket decodeBitmap, oom to ok");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        com.tencent.mobileqq.statistics.StatisticCollector.getInstance(com.tencent.common.app.BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((com.tencent.mobileqq.app.QQAppInterface) com.tencent.common.app.BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapOOM_To_OK", false, 1L, 0L, new java.util.HashMap<>(), "", false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Bitmap j(String str, BitmapFactory.Options options) {
        BitmapFactory.Options options2;
        Bitmap bitmap = null;
        try {
            try {
                try {
                    bitmap = ImageCacheHelper.f98636a.f(str);
                    if (bitmap == null) {
                        if (options == null) {
                            options2 = new BitmapFactory.Options();
                            options2.inPreferredConfig = Bitmap.Config.ARGB_4444;
                        } else {
                            options2 = options;
                        }
                        j.a f16 = com.tencent.mobileqq.util.j.f(str, options2);
                        bitmap = f16.f306778a;
                        if (QLog.isColorLevel()) {
                            QLog.d(f194757b0, 2, "redpacket decodeBitmap, path=" + str + ", result:" + f16.f306779b);
                        }
                        if (f16.f306779b == 1) {
                            int i3 = 2;
                            while (true) {
                                if (i3 > 4) {
                                    break;
                                }
                                options2.inSampleSize = i3;
                                j.a f17 = com.tencent.mobileqq.util.j.f(str, options2);
                                bitmap = f17.f306778a;
                                if (f17.f306779b != 1) {
                                    break;
                                }
                                i3 *= 2;
                            }
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("param_FailCode", "0");
                            StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapOOM", false, 1L, 0L, hashMap, "", false);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f194757b0, 2, "redpacket decodeBitmap, path=" + str + ", error:" + e16.getMessage());
                    }
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put("param_FailCode", "1");
                    StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapError", false, 1L, 0L, hashMap2, "", false);
                }
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "redpacket decodeBitmap, path=" + str + ", oom result:" + e17.getMessage());
                }
                HashMap<String, String> hashMap3 = new HashMap<>();
                hashMap3.put("param_FailCode", "1");
                StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapOOM", false, 1L, 0L, hashMap3, "", false);
            }
        } catch (Exception unused) {
        }
        return bitmap;
    }

    static boolean l(w.f fVar, RedPacketInfo redPacketInfo, String str, boolean z16) {
        int i3;
        boolean z17;
        if (fVar != null && fVar.f311392b != null && redPacketInfo != null && !TextUtils.isEmpty(str)) {
            w.c cVar = fVar.f311392b;
            try {
                String str2 = str + "_dir2";
                File file = new File(str2);
                if (file.exists() && file.isDirectory()) {
                    String[] list = file.list();
                    if (list.length > 0) {
                        int i16 = 0;
                        while (true) {
                            if (i16 < list.length) {
                                String str3 = file.getAbsolutePath() + File.separator + list[i16];
                                File file2 = new File(str3);
                                if (file2.exists()) {
                                    if (file2.isDirectory()) {
                                        String[] list2 = file2.list();
                                        if (list2.length > 0) {
                                            i3 = list2.length;
                                            str2 = str3;
                                            break;
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d(f194757b0, 2, "getAnimatePath Err_path id:" + redPacketInfo.templateId + ", path=" + str3 + ", name=" + cVar.f311383a);
                                        }
                                    } else {
                                        i3 = list.length;
                                        break;
                                    }
                                }
                                i16++;
                            } else {
                                i3 = 0;
                                break;
                            }
                        }
                        z17 = true;
                    } else {
                        i3 = 0;
                        z17 = false;
                    }
                    if (QLog.isColorLevel() || i3 == 0) {
                        QLog.d(f194757b0, 2, "getAnimatePath picNum Err id:" + redPacketInfo.templateId + ", fileNames=" + list + ", unZipDir=" + str2 + ", picNum=" + i3 + ", size=" + cVar.f311378i.f277233b);
                    }
                } else {
                    i3 = 0;
                    z17 = false;
                }
                if (!z16 && !z17 && (z17 = com.tencent.mobileqq.vas.w.I(str, str2))) {
                    boolean l3 = l(fVar, redPacketInfo, str, true);
                    if (QLog.isColorLevel()) {
                        QLog.d(f194757b0, 2, "set animConfig id:" + redPacketInfo.templateId + ", name=" + cVar.f311383a + " isRegetOk=" + l3);
                    }
                    return l3;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "set animConfig end name=" + cVar.f311383a + ", id=" + redPacketInfo.templateId + ", picNum=" + i3 + ", fileExist=" + z17 + ", isUnZipBack=" + z16 + ", unZipDir = " + str2);
                }
                if (z17) {
                    a.C8458a c8458a = cVar.f311378i;
                    c8458a.f277232a = str2;
                    redPacketInfo.f277229h = c8458a;
                    redPacketInfo.f277228f = true;
                    ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(redPacketInfo);
                    return true;
                }
                return false;
            } catch (Exception unused) {
                QLog.e(f194757b0, 2, "getAnimatePath Exception id:" + redPacketInfo.templateId + ", name=" + cVar.f311383a);
                return false;
            }
        }
        QLog.e(f194757b0, 2, "getAnimatePath Exception 0.zipPath=" + str);
        return false;
    }

    private static String o(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(p(2));
            sb5.append("images");
            String str4 = File.separator;
            sb5.append(str4);
            sb5.append(str3);
            sb5.append(str4);
            sb5.append(Integer.toHexString(str.charAt(0)));
            return sb5.toString();
        }
        return str2;
    }

    public static String p(int i3) {
        String str = f194758c0;
        switch (i3) {
            case 1:
                return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pddata/vas/") + "RedPacket/packets/";
            case 2:
                return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pddata/vas/") + "RedPacket/specialFont/";
            case 3:
                return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pddata/vas/") + "RedPacket/font/";
            case 4:
                return str + "fontimgprecreate/";
            case 5:
                return str + "personalfontimg/";
            case 6:
                return str + "AIOfinalimg/";
            case 7:
                return str + "TENPAYfinalimg/";
            case 8:
                return str + "SENDfinalimg/";
            default:
                return str;
        }
    }

    private static String q(String str, String str2, int i3) {
        if (!TextUtils.isEmpty(str)) {
            return p(i3) + Integer.toHexString(str.charAt(0));
        }
        return str2;
    }

    private boolean r(String str, int i3, b bVar) {
        InputStream open;
        AssetManager assets = this.I.getApplication().getApplicationContext().getResources().getAssets();
        try {
            if (6 == i3) {
                open = assets.open("specialFont/aio/" + Integer.toHexString(str.charAt(0)));
            } else if (7 == i3) {
                open = assets.open("specialFont/tp/" + Integer.toHexString(str.charAt(0)));
            } else {
                open = assets.open("specialFont/send/" + Integer.toHexString(str.charAt(0)));
            }
            bVar.f194777a = BitmapFactory.decodeStream(open);
            bVar.f194779c = true;
            open.close();
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "getPersonalFontImg success! Special char = " + str);
            }
            return true;
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, e16.getMessage());
            }
            return false;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, e17.getMessage());
            }
            return false;
        } catch (OutOfMemoryError e18) {
            QLog.d(f194757b0, 2, "getPersonalFontImg assets oom:" + e18.getMessage());
            return false;
        }
    }

    public static String s(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            QLog.e(f194757b0, 1, "getIDFromSCID error null: zipName=" + str);
            return null;
        }
        if (str.length() > 16 && str.indexOf(VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP) >= 0) {
            str2 = str.substring(16);
        }
        if (QLog.isColorLevel() || TextUtils.isEmpty(str2)) {
            QLog.d(f194757b0, 2, "getIDFromSCID ok, scid = " + str + ", redPacketid=" + str2);
        }
        return str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String x(String str, String str2, int i3, int i16, int i17) {
        String str3 = "";
        String str4 = null;
        switch (i3) {
            case 0:
                str3 = p(1) + str + File.separator + "config.json";
                break;
            case 2:
                str3 = p(1) + str + File.separator + "aioimg";
                break;
            case 3:
                str3 = p(1) + str + File.separator + "redenvelopeimg";
                break;
            case 4:
                str3 = q(str2, "", 4);
                break;
            case 5:
                str3 = q(str2, "", 5);
                break;
            case 6:
                str3 = L(str, str2, i17, "", str4, "aioimg", 6, "_aio_");
                break;
            case 7:
                str3 = L(str, str2, i17, "", str4, "redenvelopeimg", 7, "_tp_");
                break;
            case 8:
                str3 = p(3) + "font.ttf";
                break;
            case 9:
                str3 = o(str2, "", "aio");
                break;
            case 10:
                str3 = o(str2, "", "tp");
                break;
            case 11:
                str3 = p(0) + "specialzip";
                break;
            case 12:
                str4 = "_s";
                str3 = L(str, str2, i17, "", str4, "aioimg", 6, "_aio_");
                break;
            case 13:
                str4 = "_s";
                str3 = L(str, str2, i17, "", str4, "redenvelopeimg", 7, "_tp_");
                break;
            case 14:
                str3 = p(1) + str + File.separator + "sendimg";
                break;
            case 15:
                str3 = L(str, str2, i17, "", str4, "sendimg", 8, "_send_");
                break;
            case 16:
                str3 = o(str2, "", "send");
                break;
            case 18:
                str4 = "_s";
                str3 = L(str, str2, i17, "", str4, "sendimg", 8, "_send_");
                break;
            case 19:
                str3 = p(1) + str + File.separator + "aiopng.zip";
                break;
            case 21:
                str3 = p(3) + "config.json";
                break;
            case 24:
                str3 = p(1) + str;
                break;
            case 25:
                str3 = p(2) + "config.json";
                break;
            case 26:
                str3 = p(2) + "specialCharItem.zip";
                break;
        }
        if (TextUtils.isEmpty(str3) && QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "getLocalImgAddress Error templateId: " + str + ", name:" + str2 + ", type:" + i3 + ", filename:" + str3);
        }
        return str3;
    }

    private static String y(IndividualRedPacketManager individualRedPacketManager, String str, String str2, String str3, boolean z16) {
        if (z16) {
            str3 = individualRedPacketManager.w(str, str2, 18);
        }
        if (TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(individualRedPacketManager.w("", str2, 16))) {
                return individualRedPacketManager.w(str, str2, 15);
            }
            return str3;
        }
        return str3;
    }

    public static String z(int i3, QQAppInterface qQAppInterface) {
        String str;
        String marketUrl;
        String str2;
        if (qQAppInterface == null && (BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        }
        QQAppInterface qQAppInterface2 = qQAppInterface;
        if (qQAppInterface2 == null) {
            return "";
        }
        IndividualRedPacketManager individualRedPacketManager = (IndividualRedPacketManager) qQAppInterface2.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
        if (individualRedPacketManager != null) {
            if (individualRedPacketManager.v()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            str = str2;
        } else {
            str = null;
        }
        String marketUrl2 = IndividuationUrlHelper.getMarketUrl(qQAppInterface2.getApp().getApplicationContext(), "hongbao", "");
        if (1 == i3) {
            if (!TextUtils.isEmpty(marketUrl2)) {
                marketUrl2 = marketUrl2.replace("[from]", "1");
            }
            marketUrl = marketUrl2;
            ReportController.o(qQAppInterface2, "CliOper", "", "", "0X8006134", "0X8006134", 0, 0, str, "1", "", "");
        } else if (3 == i3) {
            if (individualRedPacketManager != null && individualRedPacketManager.H() && individualRedPacketManager.u().f311363k) {
                if (!TextUtils.isEmpty(marketUrl2)) {
                    marketUrl2 = marketUrl2.replace("[from]", "3");
                }
                marketUrl = marketUrl2;
                ReportController.o(qQAppInterface2, "CliOper", "", "", "0X8006136", "0X8006136", 0, 0, str, "1", "", "");
            } else {
                marketUrl = null;
            }
        } else {
            marketUrl = IndividuationUrlHelper.getMarketUrl(qQAppInterface2.getApp().getApplicationContext(), "hongbao", "");
            if (!TextUtils.isEmpty(marketUrl)) {
                marketUrl = marketUrl.replace("[from]", "2");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "IndividualRedPacketManager.getMallURL=" + ((String) null) + ", type:" + i3 + ", url:" + marketUrl);
        }
        return marketUrl;
    }

    public b A(String str, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (b) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        if (!TextUtils.isEmpty(str) && u().f311356d.a().contains(str)) {
            bVar.f194778b = true;
            if (!TextUtils.isEmpty(u().f311356d.f311372h) && u().f311356d.f311372h.contains(str)) {
                if (6 == i3) {
                    i16 = 9;
                } else if (7 == i3) {
                    i16 = 10;
                } else {
                    i16 = 16;
                }
                String x16 = x(null, str, i16, 0, 0);
                w("", str, i16);
                if (new File(x16).exists()) {
                    bVar.f194777a = j(x16, null);
                    bVar.f194779c = true;
                    if (QLog.isColorLevel()) {
                        QLog.d(f194757b0, 2, "getPersonalFontImg success! Special char = " + str);
                    }
                    return bVar;
                }
                if (!TextUtils.isEmpty(n().getString("special_unzip_version_key", ""))) {
                    n().edit().putString("special_unzip_version_key", "").commit();
                }
            } else if (TextUtils.isEmpty("") && "".contains(str) && r(str, i3, bVar)) {
                return bVar;
            }
        }
        String x17 = x("", str, 4, 0, 0);
        File file = new File(x17);
        synchronized (this.L) {
            if (!file.exists() || this.L.contains(x17)) {
                x17 = x("", str, 5, 0, 0);
                file = new File(x17);
                if (!file.exists() || this.L.contains(x17)) {
                    x17 = null;
                }
            }
        }
        if (!TextUtils.isEmpty(x17)) {
            file.setLastModified(System.currentTimeMillis());
            bVar.f194777a = j(x17, null);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "getPersonalFontImg from file success time-consuming = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        } else {
            bVar.f194777a = g(str, false);
            long currentTimeMillis3 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "getPersonalFontImg create success time-consuming = " + (currentTimeMillis3 - currentTimeMillis) + "ms");
            }
        }
        bVar.f194779c = false;
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "getPersonalFontImg fontImage = " + bVar.f194777a + "Special Char = " + bVar.f194778b + "Special image = " + bVar.f194779c);
        }
        return bVar;
    }

    public String C() {
        String x16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String valueOf = String.valueOf(this.Z);
        String str = this.f194765a0;
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "getSendCombineImg: templateId = " + valueOf + ";name = " + str);
        }
        if (F()) {
            String w3 = w(valueOf, str, 15);
            if (!TextUtils.isEmpty(w3)) {
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "getSendCombineImg templateId = " + valueOf + "; name = " + str + "; combinefilename = " + w3);
                }
                return w3;
            }
            w.f m3 = u().m(valueOf, true);
            if (m3 != null && m3.f311394d != null) {
                String x17 = x(valueOf, "", 14, m3.f311396f, m3.f311395e);
                File file = new File(x17);
                if (!file.exists()) {
                    w.c cVar = m3.f311394d;
                    if (cVar == null) {
                        QLog.e(f194757b0, 1, "getSendCombineImg filenot exists senddecorate = null; templateId = " + valueOf + ";name = " + str);
                        return null;
                    }
                    String str2 = cVar.f311385c;
                    if (TextUtils.isEmpty(str2)) {
                        QLog.e(f194757b0, 1, "getSendCombineImg filenot exists url is empty; templateId = " + valueOf + ";name = " + str);
                        return null;
                    }
                    int o16 = DownloaderFactory.o(new com.tencent.mobileqq.vip.g(str2, file), null);
                    if (o16 != 0) {
                        QLog.e(f194757b0, 1, "getSendCombineImg filenot exists download bg faile; templateId = " + valueOf + ";name = " + str + "; downloadresult = " + o16);
                        return null;
                    }
                }
                if (!file.exists()) {
                    QLog.e(f194757b0, 1, "getSendCombineImg filenot exists file not exists 2222; templateId = " + valueOf + ";name = " + str);
                    return null;
                }
                if (m3.f311395e != w.f.f311390i && !TextUtils.isEmpty(str)) {
                    b A = A(str, 15);
                    if (A == null) {
                        QLog.e(f194757b0, 1, "getSendCombineImg fontImg = null ; templateId = " + valueOf + "; name = " + str);
                        return null;
                    }
                    if (A.f194777a != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f194757b0, 2, "getSendCombineImg savefontimg");
                        }
                        M(A.f194777a, valueOf, str, 4);
                    }
                    Bitmap f16 = f(A, valueOf, str, 15);
                    if (f16 != null) {
                        if (A.f194779c) {
                            M(f16, valueOf, str, 18);
                            x16 = x(valueOf, str, 18, m3.f311396f, w.f.f311389h);
                        } else {
                            M(f16, valueOf, str, 15);
                            x16 = x(valueOf, str, 15, m3.f311396f, w.f.f311389h);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f194757b0, 2, "getSendCombineImg2 templateId = " + valueOf + "; name = " + str + "; combinefilename = " + w3);
                        }
                        return x16;
                    }
                    QLog.e(f194757b0, 1, "getSendCombineImg3 null allowshowredpacket templateId =" + valueOf + ";name = " + str);
                    return null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "getSendCombineImg1 templateId = " + valueOf + "; name = " + str + "; combinefilename = " + w3);
                }
                return x17;
            }
            QLog.e(f194757b0, 1, "getSendCombineImg info = null ; templateId = " + valueOf + "; name = " + str);
            u().f(16L, valueOf, null, "SendCombineImg");
            return null;
        }
        QLog.e(f194757b0, 1, "getSendCombineImg not allowshowredpacket templateId =" + valueOf + ";name = " + str);
        return null;
    }

    public String D(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
        String str3 = null;
        if (!F()) {
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "getTenpayCombineImg: isAllowShowRedpacket = false templateId = " + str + ";name = " + str2);
            }
            return null;
        }
        if (!TextUtils.isEmpty(str2) && u().f311356d.a().contains(str2)) {
            str3 = w(str, str2, 13);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = w(str, str2, 7);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "getTenpayCombineImg: templateId = " + str + ";name = " + str2 + ", path = " + str3);
        }
        return str3;
    }

    void E(boolean z16) {
        boolean z17 = true;
        String[] strArr = {p(1), p(3), p(1), p(5), p(4), p(6), p(7), p(8), p(2)};
        int i3 = 0;
        for (int i16 = 0; i16 < 9; i16++) {
            File file = new File(strArr[i16]);
            if (!file.exists() || !file.isDirectory()) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    i3++;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "initDir path:" + strArr[i16] + ", mkdirs:" + mkdirs + ", errCode:" + i3);
                }
            }
        }
        if (i3 > 0) {
            z17 = false;
        }
        if (!z17) {
            boolean isExternalStorageReady = VipFunCallUtil.isExternalStorageReady(this.I.getApplication(), f194757b0, false);
            this.G.set(!isExternalStorageReady);
            QLog.e(f194757b0, 2, "initDir Err haveSDCard:" + isExternalStorageReady + ", mIsSDCardError:" + this.G.get() + ", errCode:" + i3);
        }
        if (this.G.get() && z16) {
            f194758c0 = this.I.getApplication().getFilesDir() + File.separator + "dRedPacket/";
            E(false);
        }
    }

    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (H() && u().f311362j) {
            return true;
        }
        return false;
    }

    public boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (this.Y == 0) {
            return true;
        }
        return false;
    }

    public void J(String str, int i3) {
        w.f m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "onDoneDownloadBG id = " + str + ", resType:" + i3);
        }
        RedPacketInfo redPacketInfo = this.K.get(str);
        if (redPacketInfo == null || (m3 = u().m(redPacketInfo.templateId, true)) == null) {
            return;
        }
        boolean z16 = false;
        if (m3.f311395e == w.f.f311389h) {
            O(i3, redPacketInfo);
        } else {
            z16 = G(i3, redPacketInfo, m3, false);
        }
        this.K.remove(str);
        if (z16) {
            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(redPacketInfo);
        }
    }

    public void K(w.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
            return;
        }
        if (this.G.get()) {
            QLog.e(f194757b0, 1, "preCreatePersonalFontImg mIsSDCardError:" + this.G.get());
            return;
        }
        if (!this.S.get() && this.R.booleanValue() && bVar.f311373i != 0 && !TextUtils.isEmpty(bVar.a()) && com.tencent.mobileqq.vas.w.z(u().f311357e)) {
            if (n().getInt("font_precreate_count", 0) >= bVar.f311375k) {
                QLog.d(f194757b0, 1, "preCreatePersonalFontImg count >= " + bVar.f311375k);
                return;
            }
            if (H() && this.S.compareAndSet(false, true)) {
                this.U = ThreadManagerV2.newHandlerRecycleThread("RedPacketPrecreate", 19);
                c cVar = new c(this, this.I, bVar);
                this.V = cVar;
                this.W = this.U.a(cVar);
                this.V.b();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M(Bitmap bitmap, String str, String str2, int i3) {
        int i16;
        w.f m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, bitmap, str, str2, Integer.valueOf(i3));
            return;
        }
        if (bitmap == null) {
            if (QLog.isColorLevel()) {
                QLog.e(f194757b0, 2, "saveBitmap Bitmap == null ");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str) && (m3 = u().m(str, true)) != null) {
            i17 = m3.f311396f;
            i16 = m3.f311395e;
        } else {
            i16 = 0;
        }
        if (i3 == 5 && !TextUtils.isEmpty(str2) && u().f311356d.a().contains(str2)) {
            return;
        }
        String x16 = x(str, str2, i3, i17, i16);
        if (TextUtils.isEmpty(x16) && QLog.isColorLevel()) {
            QLog.e(f194757b0, 2, "saveBitmap saveAddress == null ");
        }
        File file = new File(x16);
        if (file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e(f194757b0, 2, "saveBitmap exists saveAddress:" + x16);
                return;
            }
            return;
        }
        synchronized (this.L) {
            this.L.add(x16);
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
        } catch (Exception e16) {
            QLog.e(f194757b0, 1, "saveBitmap close exception: ", e16);
        }
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    bufferedOutputStream2.close();
                } catch (FileNotFoundException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.e(f194757b0, 2, "saveBitmap exception " + e.getMessage());
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    synchronized (this.L) {
                    }
                } catch (IOException e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.e(f194757b0, 2, "saveBitmap exception " + e.getMessage());
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    synchronized (this.L) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e19) {
                            QLog.e(f194757b0, 1, "saveBitmap close exception: ", e19);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e26) {
                e = e26;
            } catch (IOException e27) {
                e = e27;
            }
            synchronized (this.L) {
                this.L.remove(x16);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void Q(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "IndividualRedPacketManager.setRedPacketFlags iCanUseRed:" + i3 + ", iRedDisable:" + i16 + ", isUpdate:" + z16 + ", this.iCanUseRed:" + this.X + ", this.iRedDisable:" + this.Y);
        }
        if (i3 < 0) {
            i3 = this.X;
        }
        if (i16 < 0) {
            i16 = this.Y;
        }
        if (this.X != i3 || this.Y != i16) {
            this.X = i3;
            this.Y = i16;
            if (z16) {
                SharedPreferences t16 = t();
                t16.edit().putInt(AppConstants.Preferences.VIP_INFO_CAN_USE_PACKET, i3);
                t16.edit().putInt(AppConstants.Preferences.VIP_INFO_RED_PACKET_DISABLE, i16);
                t16.edit().commit();
            }
            if (i3 == 1 && i16 == 0) {
                f194760e0 = "1";
            } else {
                f194760e0 = "0";
            }
        }
    }

    public void R(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f194757b0, 2, "setRedpacketInfo redpacketId = " + i3 + "; redpacketText = " + str);
        }
        this.Z = i3;
        this.f194765a0 = str;
        SharedPreferences t16 = t();
        t16.edit().putInt(AppConstants.Preferences.VIP_INFO_RED_PACKET_ID, i3);
        t16.edit().putString(AppConstants.Preferences.VIP_INFO_RED_PACKET_TEXT, str);
        t16.edit().commit();
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String string = n().getString("cach_font_id", "");
        if (!TextUtils.isEmpty(string) && !string.equals(u().f311357e.f311384b)) {
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "Clear SDCard Cache Start!");
            }
            String[] strArr = {p(4), p(5), p(6), p(7), p(8)};
            for (int i3 = 0; i3 < 5; i3++) {
                File file = new File(strArr[i3]);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (int i16 = 0; i16 < listFiles.length; i16++) {
                        File file2 = new File(listFiles[i16].getParent() + File.separator + System.currentTimeMillis());
                        listFiles[i16].renameTo(file2);
                        file2.delete();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f194757b0, 2, "Clear " + file.getAbsolutePath() + " done!");
                    }
                }
            }
        }
        n().edit().putString("cach_font_id", str).commit();
    }

    public void e(String str, Bundle bundle, MessengerService messengerService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, bundle, messengerService);
            return;
        }
        w.f m3 = u().m(str, true);
        int i3 = f194764i0;
        if (m3 != null && !TextUtils.isEmpty(str)) {
            w.c cVar = m3.f311392b;
            if (cVar != null) {
                int i16 = cVar.f311388f;
            }
            i3 = new File(x(str, "", 2, m3.f311396f, m3.f311395e)).exists() ? f194763h0 : f194764i0;
        }
        if (i3 != f194763h0) {
            u().f(16L, str, null, "checkTemplate");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("result", i3);
        bundle.putBundle("response", bundle2);
        messengerService.J(bundle);
    }

    public synchronized Bitmap g(String str, boolean z16) {
        String x16;
        Exception exc;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, this, str, Boolean.valueOf(z16));
        }
        synchronized (this.J) {
            BufferedOutputStream bufferedOutputStream = null;
            if (!this.F.get()) {
                this.F.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    if (this.J.initEngine(1, 524288)) {
                        if (com.tencent.mobileqq.vas.w.z(u().f311357e)) {
                            this.J.native_loadFont(x(null, null, 8, 0, 0), f194759d0, true);
                        }
                        this.E.set(true);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (QLog.isColorLevel()) {
                            QLog.d(f194757b0, 2, "RedPacket init Font Engine time = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        }
                    } else {
                        if (this.J.isEngineInited.compareAndSet(false, true)) {
                            com.etrump.mixlayout.o.c();
                        }
                        this.E.set(false);
                        QLog.d(f194757b0, 1, "vip font not downloaded, start early download.");
                    }
                } catch (Throwable th5) {
                    this.E.set(false);
                    QLog.e(f194757b0, 1, "initETEngine Exception:" + th5.getMessage());
                }
            }
            if (this.E.get() && !TextUtils.isEmpty(str)) {
                if (!com.tencent.mobileqq.vas.w.z(u().f311357e)) {
                    QLog.d(f194757b0, 1, "createPersonalFontImg fail font not exist!");
                    return null;
                }
                if (this.H == null) {
                    this.H = new ETFont(f194759d0, x(null, "", 8, 0, 0), this.f194766d);
                }
                this.H.setColor(Color.parseColor("#f8d798"));
                if (z16) {
                    x16 = x("", str, 4, 0, 0);
                } else {
                    x16 = x("", str, 5, 0, 0);
                }
                if (TextUtils.isEmpty(x16)) {
                    QLog.e(f194757b0, 1, "createPersonalFontImg fail : getLocalImgAddress = null");
                    return null;
                }
                File file = new File(x16);
                try {
                    float f16 = this.f194766d;
                    Bitmap createBitmap = Bitmap.createBitmap((int) f16, (int) f16, Bitmap.Config.ARGB_8888);
                    if (this.J.native_isPaintableChar(str.charAt(0), this.H) && this.J.native_drawText(str, createBitmap, 0, 0, this.H)) {
                        if (z16) {
                            try {
                                if (createBitmap != null) {
                                    try {
                                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                                        try {
                                            createBitmap.compress(Bitmap.CompressFormat.PNG, 90, bufferedOutputStream2);
                                            bufferedOutputStream2.flush();
                                        } catch (Exception e16) {
                                            e = e16;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (QLog.isColorLevel()) {
                                                QLog.e(f194757b0, 2, "createPersonalFontImg exception " + e.getMessage());
                                            }
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (Exception e17) {
                                                    exc = e17;
                                                    str2 = f194757b0;
                                                    str3 = "createPersonalFontImg close exception: ";
                                                    QLog.e(str2, 1, str3, exc);
                                                    return createBitmap;
                                                }
                                            }
                                            return createBitmap;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            Throwable th7 = th;
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                    throw th7;
                                                } catch (Exception e18) {
                                                    QLog.e(f194757b0, 1, "createPersonalFontImg close exception: ", e18);
                                                    throw th7;
                                                }
                                            }
                                            throw th7;
                                        }
                                        try {
                                            bufferedOutputStream2.close();
                                        } catch (Exception e19) {
                                            exc = e19;
                                            str2 = f194757b0;
                                            str3 = "createPersonalFontImg close exception: ";
                                            QLog.e(str2, 1, str3, exc);
                                            return createBitmap;
                                        }
                                    } catch (Exception e26) {
                                        e = e26;
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        }
                        return createBitmap;
                    }
                    QLog.d(f194757b0, 1, "createPersonalFontImg fail font not support: " + str.charAt(0));
                    return null;
                } catch (OutOfMemoryError e27) {
                    QLog.d(f194757b0, 1, "createPersonalFontImg Bitmap.createBitmap OutOfMemoryError: " + e27.getMessage());
                    try {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("param_FailCode", "createPersonalFontImg");
                        StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, hashMap, "", false);
                    } catch (Exception unused) {
                    }
                    return null;
                }
            }
            QLog.d(f194757b0, 1, "createPersonalFontImg fail EnigeReady = " + this.E.get() + " familyName = " + str);
            return null;
        }
    }

    public Bitmap h(b bVar, RedPacketInfo redPacketInfo, int i3) {
        String str;
        String str2;
        String str3;
        w.c cVar;
        Bitmap j3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, bVar, redPacketInfo, Integer.valueOf(i3));
        }
        if (i3 == 6) {
            str = redPacketInfo.f277226d;
            str2 = "0X800612F";
        } else {
            str = "";
            str2 = "0X800613F";
        }
        String str5 = str;
        String str6 = str2;
        if (v()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        String str7 = str3;
        long currentTimeMillis = System.currentTimeMillis();
        w.f m3 = u().m(redPacketInfo.templateId, true);
        if (m3 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(f194757b0, 2, "createRedPacketImg init json fail");
            }
            ReportController.o(this.I, "CliOper", "", "", str6, str6, 0, 0, str7, "0", "", str5);
            return null;
        }
        if (6 == i3) {
            cVar = m3.f311392b;
        } else if (7 == i3) {
            cVar = m3.f311393c;
        } else {
            cVar = m3.f311394d;
        }
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(f194757b0, 2, "createRedPacketImg decorateInfo = null");
            }
            ReportController.o(this.I, "CliOper", "", "", str6, str6, 0, 0, str7, "0", "", str5);
            return null;
        }
        if (!com.tencent.mobileqq.vas.w.z(cVar)) {
            int i16 = cVar.f311388f;
            if (i16 == 2) {
                str4 = redPacketInfo.f277231m;
            } else if (i16 == 3) {
                str4 = redPacketInfo.f277231m + "_tp";
            } else {
                str4 = redPacketInfo.f277231m + "_send";
            }
            this.K.putIfAbsent(str4, redPacketInfo);
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "createRedPacketImg id = " + redPacketInfo.templateId + " content = " + redPacketInfo.f277226d + " not exists!");
            }
            u().f(16L, cVar.f311384b, redPacketInfo.f277231m, "RedPacketImg");
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "createRedPacketImg BG not found,start download url : " + cVar.f311388f + ", id=" + cVar.f311384b);
            }
            ReportController.o(this.I, "CliOper", "", "", str6, str6, 0, 0, str7, "0", "", str5);
            return null;
        }
        int i17 = m3.f311395e;
        if (i17 == w.f.f311389h) {
            j3 = f(bVar, redPacketInfo.templateId, redPacketInfo.f277226d, i3);
        } else {
            j3 = j(x(redPacketInfo.templateId, redPacketInfo.f277226d, i3, m3.f311396f, i17), null);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (j3 != null) {
            N(bVar, redPacketInfo, i3, j3);
            ReportController.o(this.I, "CliOper", "", "", str6, str6, 0, 0, str7, "1", String.valueOf(currentTimeMillis2 - currentTimeMillis), str5);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "createRedPacketImg BG combine == null, templateinfo.type = " + m3.f311395e);
            }
            ReportController.o(this.I, "CliOper", "", "", str6, str6, 0, 0, str7, "0", String.valueOf(currentTimeMillis2 - currentTimeMillis), str5);
        }
        if (i3 == 6) {
            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(redPacketInfo);
        }
        return j3;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.IndividualRedPacketManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IndividualRedPacketManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String str = "font";
                    try {
                        String[] strArr = {IndividualRedPacketManager.p(5), IndividualRedPacketManager.p(6), IndividualRedPacketManager.p(7), IndividualRedPacketManager.p(8)};
                        String[] strArr2 = {"font", "aio", "tp", "send"};
                        for (int i3 = 0; i3 < 4; i3++) {
                            str = strArr2[i3];
                            File file = new File(strArr[i3]);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 150) {
                                Arrays.sort(listFiles, IndividualRedPacketManager.this.Q);
                                for (int i16 = 100; i16 < listFiles.length; i16++) {
                                    synchronized (IndividualRedPacketManager.this.L) {
                                        IndividualRedPacketManager.this.L.add(listFiles[i16].getAbsolutePath());
                                        File file2 = new File(listFiles[i16].getParent() + File.separator + System.currentTimeMillis());
                                        listFiles[i16].renameTo(file2);
                                        file2.delete();
                                        IndividualRedPacketManager.this.L.remove(listFiles[i16].getAbsolutePath());
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(IndividualRedPacketManager.f194757b0, 2, "eliminateImageCache error: " + e16.getMessage() + ", in step=" + str);
                        }
                        try {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("param_FailCode", str);
                            StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketClearCacheError", false, 1L, 0L, hashMap, "", false);
                        } catch (Exception unused) {
                        }
                    }
                }
            }, 2, null, true);
        }
    }

    public void m(String str, String str2, Bundle bundle, MessengerService messengerService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, str2, bundle, messengerService);
        } else {
            ThreadManagerV2.post(new Runnable(str, str2, bundle, messengerService) { // from class: com.tencent.mobileqq.app.IndividualRedPacketManager.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f194772d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f194773e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f194774f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ MessengerService f194775h;

                {
                    this.f194772d = str;
                    this.f194773e = str2;
                    this.f194774f = bundle;
                    this.f194775h = messengerService;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, IndividualRedPacketManager.this, str, str2, bundle, messengerService);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:13:0x00fd  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0149  */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0171  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0183  */
                /* JADX WARN: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    String str3;
                    b bVar;
                    Bitmap bitmap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i3 = IndividualRedPacketManager.f194762g0;
                    boolean z16 = true;
                    w.f m3 = IndividualRedPacketManager.this.u().m(this.f194772d, true);
                    String w3 = IndividualRedPacketManager.this.w(this.f194772d, this.f194773e, 6);
                    Bitmap bitmap2 = null;
                    if (IndividualRedPacketManager.this.G.get()) {
                        QLog.e(IndividualRedPacketManager.f194757b0, 2, "getBitmapForWebView error mIsSDCardError:" + IndividualRedPacketManager.this.G.get());
                        bVar = null;
                    } else {
                        int i16 = 0;
                        if (!TextUtils.isEmpty(w3)) {
                            try {
                                File file = new File(w3);
                                FileInputStream fileInputStream = new FileInputStream(file);
                                int length = (int) file.length();
                                byte[] bArr = new byte[length];
                                while (i16 < length) {
                                    int read = fileInputStream.read(bArr, i16, length - i16);
                                    if (read < 0) {
                                        break;
                                    } else {
                                        i16 += read;
                                    }
                                }
                                str3 = PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2);
                                try {
                                    i3 = IndividualRedPacketManager.f194761f0;
                                    fileInputStream.close();
                                } catch (IOException e16) {
                                    e = e16;
                                    if (QLog.isColorLevel()) {
                                        QLog.e(IndividualRedPacketManager.f194757b0, 2, "getBitmapForWebView error:" + e.getMessage());
                                    }
                                    bVar = null;
                                    if (bitmap2 != null) {
                                    }
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("templateId", this.f194772d);
                                    bundle2.putString("content", this.f194773e);
                                    bundle2.putInt("result", i3);
                                    bundle2.putString(MimeHelper.IMAGE_SUBTYPE_BITMAP, str3);
                                    this.f194774f.putBundle("response", bundle2);
                                    this.f194775h.J(this.f194774f);
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (bVar != null) {
                                    }
                                    if (bVar != null) {
                                    }
                                }
                            } catch (IOException e17) {
                                e = e17;
                                str3 = "";
                            }
                            bVar = null;
                            if (bitmap2 != null) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                str3 = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                                i3 = IndividualRedPacketManager.f194761f0;
                            }
                            Bundle bundle22 = new Bundle();
                            bundle22.putString("templateId", this.f194772d);
                            bundle22.putString("content", this.f194773e);
                            bundle22.putInt("result", i3);
                            bundle22.putString(MimeHelper.IMAGE_SUBTYPE_BITMAP, str3);
                            this.f194774f.putBundle("response", bundle22);
                            this.f194775h.J(this.f194774f);
                            if (QLog.isColorLevel()) {
                                QLog.d(IndividualRedPacketManager.f194757b0, 2, "getBitmapForWebView result = " + i3 + " base64 length = " + str3.length());
                            }
                            if (bVar != null && (bitmap = bVar.f194777a) != null && !bVar.f194778b) {
                                IndividualRedPacketManager.this.M(bitmap, "", this.f194773e, 5);
                            }
                            if (bVar != null && bVar.f194777a != null && bitmap2 != null) {
                                if (bVar.f194779c) {
                                    IndividualRedPacketManager.this.M(bitmap2, this.f194772d, this.f194773e, 12);
                                    return;
                                } else {
                                    IndividualRedPacketManager.this.M(bitmap2, this.f194772d, this.f194773e, 6);
                                    return;
                                }
                            }
                            return;
                        }
                        if (m3 != null && new File(IndividualRedPacketManager.x(this.f194772d, "", 2, m3.f311396f, m3.f311395e)).exists()) {
                            b A = IndividualRedPacketManager.this.A(this.f194773e, 6);
                            z16 = false;
                            bitmap2 = IndividualRedPacketManager.this.f(A, this.f194772d, this.f194773e, 6);
                            bVar = A;
                        } else {
                            bVar = null;
                        }
                        if (z16) {
                            IndividualRedPacketManager.this.u().f(16L, this.f194772d, null, "ForWebView");
                        }
                    }
                    str3 = "";
                    if (bitmap2 != null) {
                    }
                    Bundle bundle222 = new Bundle();
                    bundle222.putString("templateId", this.f194772d);
                    bundle222.putString("content", this.f194773e);
                    bundle222.putInt("result", i3);
                    bundle222.putString(MimeHelper.IMAGE_SUBTYPE_BITMAP, str3);
                    this.f194774f.putBundle("response", bundle222);
                    this.f194775h.J(this.f194774f);
                    if (QLog.isColorLevel()) {
                    }
                    if (bVar != null) {
                        IndividualRedPacketManager.this.M(bitmap, "", this.f194773e, 5);
                    }
                    if (bVar != null) {
                    }
                }
            }, 8, null, true);
        }
    }

    public SharedPreferences n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.P == null) {
            AppRuntime appRuntime = this.I;
            if (appRuntime == null) {
                appRuntime = BaseApplicationImpl.sApplication.getRuntime();
            }
            this.P = appRuntime.getApplication().getApplicationContext().getSharedPreferences("individRedPacket_common", 0);
        }
        return this.P;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.U != null) {
            this.U = null;
        }
        if (this.V != null) {
            this.W.removeCallbacksAndMessages(null);
        }
        com.tencent.mobileqq.vas.w wVar = this.M;
        if (wVar != null) {
            wVar.C();
            this.M = null;
        }
        this.T.set(true);
    }

    public SharedPreferences t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.N == null) {
            this.N = this.I.getApplication().getApplicationContext().getSharedPreferences("individRedPacket_" + this.I.getAccount(), 0);
        }
        return this.N;
    }

    public com.tencent.mobileqq.vas.w u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.mobileqq.vas.w) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        if (this.M == null) {
            this.M = new com.tencent.mobileqq.vas.w(this.I, this);
        }
        return this.M;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.X == 1 && this.Y == 0) {
            return true;
        }
        return false;
    }

    public String w(String str, String str2, int i3) {
        String x16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, str, str2, Integer.valueOf(i3));
        }
        if (!TextUtils.isEmpty(str)) {
            w.f m3 = u().m(str, true);
            if (m3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(f194757b0, 2, "getLocalImg fail! can't find template templateId = " + str + " name = " + str2 + "type = " + i3);
                }
                return null;
            }
            x16 = x(str, str2, i3, m3.f311396f, m3.f311395e);
        } else {
            x16 = x("", str2, i3, 0, 0);
        }
        synchronized (this.L) {
            if (x16 != null) {
                if (!this.L.contains(x16)) {
                    File file = new File(x16);
                    if (file.exists()) {
                        file.setLastModified(NetConnInfoCenter.getServerTimeMillis());
                        if (QLog.isColorLevel()) {
                            QLog.d(f194757b0, 2, "getLocalImg success! templateId = " + str + " name = " + str2 + "type = " + i3);
                        }
                        return x16;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f194757b0, 2, "getLocalImg fail! file not exists! templateId = " + str + " name = " + str2 + "type = " + i3);
                    }
                    return null;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f194757b0, 2, "getLocalImg fail! file Saving! templateId = " + str + " name = " + str2 + "type = " + i3);
            }
            return null;
        }
    }
}
