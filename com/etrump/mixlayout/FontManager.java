package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.etrump.mixlayout.api.ETFontUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.ev;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class FontManager implements Manager, Handler.Callback {
    private static ConcurrentHashMap<String, k> W = null;
    private static int X = -1;
    private static int Y;
    private static boolean Z = ar.b("kenaiyu", "2024-08-27", "vas_bug_129514453").isEnable(true);
    public HandlerThread I;
    public Handler J;
    public String K;
    public String P;

    /* renamed from: d, reason: collision with root package name */
    public boolean f32639d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f32640e;

    /* renamed from: f, reason: collision with root package name */
    protected ETEngine f32641f = null;

    /* renamed from: h, reason: collision with root package name */
    protected ETEngine f32642h = null;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.vip.k f32643i = null;

    /* renamed from: m, reason: collision with root package name */
    public AtomicBoolean f32644m = new AtomicBoolean(false);
    public int C = -1;
    public String D = null;
    private boolean E = false;
    private Map<Integer, Float> G = new ConcurrentHashMap();
    private final Object H = new Object();
    private CopyOnWriteArrayList<FontLoadCallback> L = new CopyOnWriteArrayList<>();
    private int M = -1;
    public String N = HardCodeUtil.qqStr(R.string.mmy);
    public int Q = 1;
    private Map<Integer, String> R = new ConcurrentHashMap();
    private Map<Integer, Long> S = new ConcurrentHashMap();
    private long T = 0;
    private long U = 0;
    private ConcurrentHashMap<String, ConcurrentHashMap<Integer, k>> V = new ConcurrentHashMap<>();
    public AtomicBoolean F = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f32656a;

        a(int i3) {
            this.f32656a = i3;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            FontManager fontManager = (FontManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.CHAT_FONT_MANAGER);
            if (fontManager != null) {
                fontManager.D(this.f32656a, 0, "");
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            FontManager fontManager = (FontManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.CHAT_FONT_MANAGER);
            if (fontManager != null) {
                fontManager.D(this.f32656a, 0, "");
            }
        }
    }

    public FontManager(QQAppInterface qQAppInterface) {
        W = new ConcurrentHashMap<>();
        FontManagerConstants.updateFontSwitch(ea.D(qQAppInterface.getApp(), qQAppInterface.getCurrentUin(), AppConstants.Preferences.VAS_FONT_SWITCH_CONFIG));
        if (Z) {
            this.f32640e = true;
        } else {
            this.f32640e = BaseApplicationImpl.getApplication().getSharedPreferences(FontManagerConstants.FONT_OPEN_SWITCH, 4).getBoolean(FontManagerConstants.ISUSEROPENFONTSWITCH + qQAppInterface.getAccount(), false);
        }
        if (!this.E) {
            ah.F();
            ah.n();
            ah.l();
            com.tencent.mobileqq.utils.m.c();
        }
        this.f32639d = s();
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("VasFont", 0);
        this.I = newFreeHandlerThread;
        newFreeHandlerThread.start();
        this.J = new Handler(this.I.getLooper(), this);
    }

    public static int A(long j3) {
        k kVar;
        int i3;
        ConcurrentHashMap<String, k> concurrentHashMap = W;
        if (concurrentHashMap != null) {
            kVar = concurrentHashMap.get(Integer.valueOf((int) j3));
        } else {
            kVar = null;
        }
        int i16 = 0;
        if (kVar != null) {
            i3 = kVar.f32758h;
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            i16 = Y % i3;
        }
        Y++;
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "getVariedStyleIndex: sIndex=" + Y + " fontId=" + j3 + " styleCount=" + i3 + " index=" + i16);
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z16) {
        boolean z17;
        String str;
        try {
            boolean s16 = s();
            this.f32639d = s16;
            if (s16) {
                this.f32641f = ETEngine.getInstance();
                ETEngine instanceForAnimation = ETEngine.getInstanceForAnimation();
                this.f32642h = instanceForAnimation;
                if (this.f32641f != null && instanceForAnimation != null) {
                    int H2 = ChatTextSizeSettingActivity.H2(BaseApplicationImpl.getApplication());
                    int i3 = H2 * H2 * 240 * 18 * 2;
                    if (i3 <= 1048576) {
                        i3 = 1048576;
                    }
                    boolean z18 = this.f32641f.isEngineReady.get();
                    boolean z19 = this.f32642h.isEngineReady.get();
                    if (!z18) {
                        try {
                            z18 = this.f32641f.initEngine(18, i3);
                        } catch (Exception e16) {
                            QLog.e("VasFont", 1, "init font engine fail " + e16.getMessage());
                            return;
                        }
                    }
                    if (!z19) {
                        z19 = this.f32642h.initEngine(10, 3145728);
                    }
                    if (z18 && z19) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z16) {
                        String str2 = "1";
                        if (z17) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(u()), "VasFont");
                        if (vasSimpleInfoWithUid != null && 0 != vasSimpleInfoWithUid.uVipFont && vasSimpleInfoWithUid.vipFontType == 1) {
                            str2 = "0";
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("VasFont", 2, "VipFontReport: AIO engine status, status=" + str + ", hgType=" + str2);
                        }
                    }
                    if (z17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VasFont", 2, "start init font engine fontsize=" + H2 + ",num=18,cache=" + i3);
                        }
                        ETEngine.getInstance().isEngineReady.set(true);
                        if (!z16 && QLog.isColorLevel()) {
                            QLog.d("VasFont", 2, "VipFontReport: AioRefreshed");
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new Exception("create font engine Instance fail");
            }
        } catch (Throwable th5) {
            QLog.e("VasFont", 1, "init font engine fail " + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean M(k kVar, String str, int i3) {
        File file;
        boolean native_loadFont;
        boolean native_loadFont2;
        boolean equals = u().equals(str);
        try {
            file = new File(kVar.f32752b);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "load font fail", th5);
            }
        }
        if (!file.exists()) {
            P(kVar.f32751a, null, 1);
            if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "load font fail file not exist font id=" + kVar.f32751a);
            }
            return false;
        }
        if (FileUtils.fileToBytes(file) == null) {
            I(kVar.f32751a, 1);
            VasWebviewUtil.reportVasStatus("Font", "FontMd5Check", "0", 0, 0, kVar.f32751a, 1, "", "");
            return false;
        }
        QLog.d("VasFont", 1, "ET load font start id = " + kVar.f32751a + " time = " + System.currentTimeMillis());
        synchronized (this.H) {
            native_loadFont = this.f32641f.native_loadFont(kVar.f32752b, kVar.f32751a, equals);
            native_loadFont2 = this.f32642h.native_loadFont(kVar.f32752b, kVar.f32751a, equals);
        }
        QLog.d("VasFont", 1, "ET load font end id = " + kVar.f32751a + " time = " + System.currentTimeMillis());
        if (native_loadFont && native_loadFont2) {
            if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "setActiveFonts refreshAIO");
            }
            C(str, kVar, i3);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "load font fail font id=" + kVar.f32751a + " ret=" + native_loadFont + " ret2=" + native_loadFont2);
        }
        return false;
    }

    private void j(final String str, final k kVar, final int i3) {
        this.J.post(new Runnable() { // from class: com.etrump.mixlayout.l
            @Override // java.lang.Runnable
            public final void run() {
                FontManager.this.C(str, kVar, i3);
            }
        });
    }

    private void k(final int i3, final int i16, final boolean z16, final String str, final int i17) {
        this.J.post(new Runnable() { // from class: com.etrump.mixlayout.FontManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (FontManager.W.get(str + "|" + i3) != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VasFont", 2, "asyncLoadFont font " + i3 + " has loaded");
                        return;
                    }
                    return;
                }
                String tTFPath = FontManagerConstants.getTTFPath(i3, i16);
                if (new File(tTFPath).exists()) {
                    k kVar = new k(i3, tTFPath);
                    int i18 = i16;
                    kVar.f32753c = i18;
                    if (i18 == 0) {
                        kVar.f32753c = 1;
                    }
                    if (i18 != 1) {
                        if (i18 == 2) {
                            try {
                                kVar.f32754d = Typeface.createFromFile(kVar.f32752b);
                                FontManager.W.put(String.valueOf(i3), kVar);
                                FontManager.W.put(str + "|" + i3, kVar);
                                FontManager.this.l();
                                return;
                            } catch (Exception e16) {
                                QLog.e("VasFont", 1, "getFontInfo createTypeface error: " + e16.getMessage());
                                kVar.f32754d = null;
                                return;
                            }
                        }
                        return;
                    }
                    if (!ETEngine.getInstance().isEngineInited.get()) {
                        if (QLog.isColorLevel()) {
                            QLog.e("VasFont", 2, "doGetUserFont and fontEngine not init");
                        }
                        FontManager.this.R();
                    }
                    if (ETEngine.getInstance().isEngineReady.get()) {
                        ETEngine eTEngine = FontManager.this.f32641f;
                        if (eTEngine == null) {
                            if (QLog.isColorLevel()) {
                                QLog.e("VasFont", 2, "doGetUserFont mEngine = null");
                                return;
                            }
                            return;
                        }
                        if (!eTEngine.native_isFontLoaded(i3) || !FontManager.this.f32642h.native_isFontLoaded(i3)) {
                            if (!FontManager.this.M(kVar, str, i17)) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
                                    return;
                                }
                                return;
                            }
                            kVar.f32758h = FontManager.this.f32641f.native_getVariantStyleComboCount(new ETFont(kVar.f32751a, kVar.f32752b, 1.0f));
                            if (QLog.isColorLevel()) {
                                QLog.i("VasFont", 2, "asyncLoadFont: id=" + kVar.f32751a + " styleCount=" + kVar.f32758h);
                            }
                        }
                        FontManagerConstants.sHasChatFont = true;
                        FontManager.W.put(String.valueOf(i3), kVar);
                        FontManager.W.put(str + "|" + i3, kVar);
                        FontManager.this.l();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("VasFont", 2, "doGetUserFont fontEngine not init mIsFontEngineReady = " + ETEngine.getInstance().isEngineReady.get() + " mIsFontEngineInited = " + ETEngine.getInstance().isEngineInited.get());
                        return;
                    }
                    return;
                }
                if (!FontManager.this.u().equals(str) && z16 && !NetworkUtil.isWifiConnected(BaseApplicationImpl.getApplication()) && !NetworkUtil.is3Gor4G(BaseApplicationImpl.getApplication())) {
                    if (QLog.isColorLevel()) {
                        QLog.e("VasFont", 2, "getFontInfo isTroopOrDiscussion but no wifi or 3G 4G.");
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("VasFont", 2, "getFontInfo startDownload no cache");
                    }
                    FontManager.this.P(i3, null, i16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Iterator<FontLoadCallback> it = this.L.iterator();
        while (it.hasNext()) {
            FontLoadCallback next = it.next();
            if (next != null) {
                next.onFontLoaded();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean C(String str, k kVar, int i3) {
        if (kVar.f32756f == null) {
            kVar.f32756f = new ETFont(kVar.f32751a, kVar.f32752b, 16.0f, kVar.f32753c, kVar.f32754d);
        }
        ConcurrentHashMap<Integer, k> concurrentHashMap = this.V.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        if (!ETEngine.getInstance().native_diyFontIsDIYFont(kVar.f32756f)) {
            return false;
        }
        kVar.f32757g = true;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "VasFont");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo();
            vasSimpleInfoWithUid.f(str);
            vasSimpleInfoWithUid.e(uidFromUin);
        }
        if (n(str, vasSimpleInfoWithUid, kVar.f32751a, i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "isDIYFont fontId = " + kVar.f32751a + " uin = " + str + " needUpdateDiyConfig");
            }
            if (concurrentHashMap.containsKey(Integer.valueOf(kVar.f32751a))) {
                return false;
            }
            concurrentHashMap.put(Integer.valueOf(kVar.f32751a), new k(0, ""));
            this.V.put(str, concurrentHashMap);
            return false;
        }
        if (concurrentHashMap.containsKey(Integer.valueOf(kVar.f32751a))) {
            if (kVar.f32751a == 0) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "isDIYFont fontid = " + kVar.f32751a + " is diy font handle = " + kVar.f32756f.mDiyHandle);
            }
            kVar.f32757g = true;
        } else {
            ConcurrentHashMap<Integer, String> concurrentHashMap2 = vasSimpleInfoWithUid.diyFontConfigMap;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(Integer.valueOf(kVar.f32751a))) {
                String str2 = vasSimpleInfoWithUid.diyFontConfigMap.get(Integer.valueOf(kVar.f32751a));
                if (QLog.isColorLevel()) {
                    QLog.d("VasFont", 2, "isDIYFont fontId = " + kVar.f32751a + " uin = " + str + " config = " + str2);
                }
                kVar.f32756f.parseDIYJsonString(str2);
                k kVar2 = new k(kVar.f32751a, kVar.f32752b);
                kVar2.f32753c = kVar.f32753c;
                kVar2.f32757g = true;
                ETFont eTFont = new ETFont(kVar.f32751a, kVar.f32752b, 16.0f, kVar.f32753c, null);
                eTFont.copy(kVar.f32756f);
                kVar2.f32756f = eTFont;
                concurrentHashMap.put(Integer.valueOf(kVar.f32751a), kVar2);
                this.V.put(str, concurrentHashMap);
            } else {
                k kVar3 = new k(kVar.f32751a, kVar.f32752b);
                kVar3.f32753c = kVar.f32753c;
                kVar3.f32757g = true;
                kVar3.f32756f = new ETFont(kVar.f32751a, kVar.f32752b, 16.0f, kVar.f32753c, null);
                concurrentHashMap.put(Integer.valueOf(kVar.f32751a), kVar3);
                this.V.put(str, concurrentHashMap);
            }
        }
        return true;
    }

    public static boolean n(String str, NTVasSimpleInfo nTVasSimpleInfo, int i3, int i16) {
        if (nTVasSimpleInfo == null) {
            nTVasSimpleInfo = new NTVasSimpleInfo();
            nTVasSimpleInfo.f(str);
            nTVasSimpleInfo.e(ev.b(str));
        }
        if (nTVasSimpleInfo.diyFontTimestampMap == null) {
            nTVasSimpleInfo.diyFontTimestampMap = new ConcurrentHashMap<>();
        }
        if (nTVasSimpleInfo.diyFontTimestampMap.get(Integer.valueOf(i3)) != null && nTVasSimpleInfo.diyFontTimestampMap.get(Integer.valueOf(i3)).intValue() >= i16) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "checkUpdateDIYConfig uin = " + str + " fontId = " + i3 + " oldTime = " + nTVasSimpleInfo.diyFontTimestampMap.get(Integer.valueOf(i3)) + " newTime = " + i16);
        }
        nTVasSimpleInfo.diyFontTimestampMap.put(Integer.valueOf(i3), Integer.valueOf(i16));
        NTVasSimpleInfo nTVasSimpleInfo2 = new NTVasSimpleInfo(nTVasSimpleInfo.getUid(), nTVasSimpleInfo.getUin());
        nTVasSimpleInfo2.c();
        nTVasSimpleInfo2.diyFontConfigMap = new ConcurrentHashMap<>(nTVasSimpleInfo.diyFontConfigMap);
        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo2, "VasFont", (hx3.c<NTVasSimpleInfo>) null);
        return true;
    }

    private void o() {
        if (this.f32641f != null) {
            try {
                synchronized (this.H) {
                    ETFontUtil.clearMap(this.f32641f);
                    ETEngine eTEngine = this.f32641f;
                    if (eTEngine != null) {
                        eTEngine.native_doneEngine();
                        this.f32641f.isEngineInited.set(false);
                        this.f32641f.isEngineReady.set(false);
                    }
                    this.f32641f = null;
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.i("VasFont", 2, th5.getMessage());
                }
            }
        }
    }

    private void p() {
        if (this.f32642h != null) {
            try {
                synchronized (this.H) {
                    ETFontUtil.clearMap(this.f32642h);
                    ETEngine eTEngine = this.f32642h;
                    if (eTEngine != null) {
                        eTEngine.native_doneEngine();
                        this.f32642h.isEngineInited.set(false);
                        this.f32642h.isEngineReady.set(false);
                    }
                    this.f32642h = null;
                }
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("VasFont", 2, e16.getMessage());
                }
            }
        }
    }

    private void q() {
        if (this.I != null) {
            Handler handler = ETTextView.N0;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            ETTextView.N0 = null;
            this.I.quit();
        }
    }

    private boolean t(String str) {
        if (this.M == -1) {
            if (((ah.n() >= 2 && ah.l() > 1000) || ah.n() >= 4) && com.tencent.mobileqq.utils.m.c() > 838860800) {
                if (QLog.isColorLevel()) {
                    QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return true");
                }
                this.M = 1;
            } else {
                this.M = 0;
                if (QLog.isColorLevel()) {
                    QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return false. CPU number = " + ah.n() + " CPU Frequency = " + ah.l() + " Memory = " + com.tencent.mobileqq.utils.m.c());
                }
            }
        }
        if (this.M != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentUin();
    }

    public void D(int i3, int i16, String str) {
        long j3;
        QLog.e("DIYProfileTemplate.VasFont", 1, "\u5b57\u4f53\u4e0b\u8f7d\u5b8c\u6210\u56de\u8c03:" + i3 + " error:" + i16);
        if (this.S.containsKey(Integer.valueOf(i3))) {
            j3 = this.S.get(Integer.valueOf(i3)).longValue();
            this.S.remove(Integer.valueOf(i3));
        } else {
            j3 = 0;
        }
        if (i16 == 0) {
            if (j3 > 0) {
                n.a("action_download", i3, 4, 0, System.currentTimeMillis() - j3);
            }
            this.G.put(Integer.valueOf(i3), Float.valueOf(1.0f));
        }
        String str2 = this.R.get(Integer.valueOf(i3));
        if (str2 != null && !str2.equals("0")) {
            if (TextUtils.isDigitsOnly(str2)) {
                int parseInt = Integer.parseInt(str2);
                EIPCResult eIPCResult = new EIPCResult();
                eIPCResult.code = i16;
                new Bundle().putInt("id", i3);
                VasFontIPCModule.f().callbackResult(parseInt, eIPCResult);
            }
            if (this.f32643i != null) {
                Bundle bundle = new Bundle();
                bundle.putString("callbackId", str2);
                bundle.putInt("srcType", 2);
                this.f32643i.a(i3, i16, bundle);
            }
        }
        if (i16 == 0) {
            l();
        }
    }

    public void E(int i3, float f16) {
        if (VasToggle.BUG_110439111.isEnable(true)) {
            if (f16 < 1.0f) {
                this.G.put(Integer.valueOf(i3), Float.valueOf(f16));
                return;
            }
            return;
        }
        this.G.put(Integer.valueOf(i3), Float.valueOf(f16));
    }

    public void F(final int i3, int i16) {
        if (i16 == 0) {
            this.J.post(new Runnable() { // from class: com.etrump.mixlayout.FontManager.2
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    int i17 = i3;
                    if (i17 != 1) {
                        if (i17 != 4) {
                            str = null;
                        } else {
                            str = FontSoBusiness.FZ_COLOR_FONT_SO_NAME;
                        }
                    } else {
                        str = FontSoBusiness.HY_FONT_SO_NAME;
                    }
                    ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(MobileQQ.sMobileQQ, new File(VasSoUtils.getSoDir(i3), str));
                    if (VasSoUtils.loadLibrary(VasSoUtils.getSoDir(i3), str) == 0) {
                        VasFontIPCModule.f().h(i3, 0);
                        if (i3 == 1) {
                            if (!TextUtils.isEmpty(FontManager.this.K) && FontManager.this.f32643i != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString("callbackId", FontManager.this.K);
                                bundle.putInt("srcType", 9);
                                FontManager.this.f32643i.a(0L, 0, bundle);
                                FontManager.this.K = null;
                            }
                            ETEngine.isSOLoaded.set(true);
                            VasMMKV.getFontSo(BaseApplication.getContext()).edit().putBoolean("vip_font_so_downloaded", true).commit();
                            ((IFontSoLoaderAdapter) QRoute.api(IFontSoLoaderAdapter.class)).setVipFontSoLoad(true);
                            FontManager.this.B(false);
                        }
                        FontManager.this.l();
                        return;
                    }
                    VasFontIPCModule.f().h(i3, -102);
                }
            });
            return;
        }
        VasFontIPCModule.f().h(i3, -102);
        if (!TextUtils.isEmpty(this.K) && this.f32643i != null) {
            Bundle bundle = new Bundle();
            bundle.putString("callbackId", this.K);
            bundle.putInt("srcType", 9);
            this.f32643i.a(0L, i16, bundle);
            this.K = null;
        }
    }

    public void G(boolean z16) {
        this.f32644m.set(z16);
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(FontManagerConstants.FONTTEST, 0).edit();
        edit.putBoolean(FontManagerConstants.FONT_TEST_SWITCH, z16);
        edit.commit();
    }

    public JSONObject H(int i3, int i16) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i17 = 0;
            if (r(i3, i16) != null) {
                jSONObject2.put("status", 3);
                jSONObject2.put("progress", 100);
                jSONObject.put("result", 0);
                jSONObject.put("message", HardCodeUtil.qqStr(R.string.mmz));
            } else if (this.G.containsKey(Integer.valueOf(i3))) {
                float floatValue = this.G.get(Integer.valueOf(i3)).floatValue();
                if (floatValue == 1.0f) {
                    jSONObject2.put("status", 3);
                    jSONObject.put("result", 0);
                    jSONObject.put("message", HardCodeUtil.qqStr(R.string.f171991mn0));
                } else if (floatValue == 2.0f) {
                    jSONObject2.put("status", 1);
                    jSONObject.put("result", -1);
                    jSONObject.put("message", HardCodeUtil.qqStr(R.string.mmx));
                } else {
                    jSONObject2.put("status", 2);
                    jSONObject.put("result", 0);
                    jSONObject.put("message", HardCodeUtil.qqStr(R.string.mmv));
                }
                if (floatValue == 3.0f) {
                    i17 = 1;
                }
                jSONObject2.put("canceling", i17);
                jSONObject2.put("progress", floatValue * 100.0f);
            } else {
                jSONObject2.put("status", 1);
                jSONObject2.put("progress", 0);
                jSONObject.put("result", 0);
                jSONObject.put("message", HardCodeUtil.qqStr(R.string.mmw));
            }
            jSONObject2.put("id", i3);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "queryInfo fontId=" + i3 + ",json=" + jSONObject.toString());
        }
        return jSONObject;
    }

    public void I(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reDownloadFont start");
        }
        k r16 = r(i3, i16);
        if (r16 != null) {
            W.remove(String.valueOf(i3));
            for (String str : W.keySet()) {
                String[] split = str.split("|");
                if (split.length >= 2 && String.valueOf(i3).equals(split[1])) {
                    W.remove(str);
                }
            }
            File file = new File(r16.f32752b);
            if (file.exists()) {
                File file2 = new File(file.getParent());
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (int i17 = 0; i17 < listFiles.length; i17++) {
                        boolean delete = listFiles[i17].delete();
                        if (QLog.isColorLevel()) {
                            QLog.d("VasFont", 2, "reDownloadFont delete " + listFiles[i17].getName() + " ret = " + delete);
                        }
                    }
                }
                boolean delete2 = file2.delete();
                if (QLog.isColorLevel()) {
                    QLog.d("VasFont", 2, "reDownloadFont delete " + file2.getName() + " ret = " + delete2);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "reDownloadFont fontFile not exist");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reDownload startDownload");
        }
        P(i3, null, i16);
    }

    public void J(com.tencent.mobileqq.vip.k kVar) {
        this.f32643i = kVar;
    }

    public void K(FontLoadCallback fontLoadCallback) {
        if (fontLoadCallback == null) {
            return;
        }
        this.L.remove(fontLoadCallback);
    }

    public void L() {
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "resetLastSendReportTime.");
        }
        this.T = 0L;
        this.U = NetConnInfoCenter.getServerTimeMillis();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            SharedPreferences.Editor edit = VasMMKV.getMagicFont(peekAppRuntime.getApplicationContext(), u()).edit();
            edit.putLong("magic_font_last_send_report", this.T);
            edit.putLong("magic_font_reset_time", this.U);
            edit.apply();
        }
    }

    public void N(boolean z16) {
        BaseApplicationImpl.getApplication().getSharedPreferences(FontManagerConstants.FONT_OPEN_SWITCH, 4).edit().putBoolean(FontManagerConstants.ISUSEROPENFONTSWITCH + u(), z16).apply();
        this.f32640e = z16;
    }

    public void O(boolean z16, int i3, String str) {
        this.f32644m.set(z16);
        this.C = i3;
        this.D = str;
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(FontManagerConstants.FONTTEST, 0).edit();
        edit.putBoolean(FontManagerConstants.FONT_TEST_SWITCH, z16);
        edit.putInt(FontManagerConstants.FONT_TEST_TYPE, i3);
        edit.putString(FontManagerConstants.FONT_TEST_FILE, str);
        edit.commit();
    }

    public void P(int i3, String str, int i16) {
        FontBusiness fontBusiness = (FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class);
        if (fontBusiness.isFileExists(i3)) {
            D(i3, 0, "");
        }
        Map<Integer, String> map = this.R;
        Integer valueOf = Integer.valueOf(i3);
        if (str == null) {
            str = "0";
        }
        map.put(valueOf, str);
        if (i16 == 4) {
            this.S.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        }
        String str2 = "font.main.android." + i3;
        if (!TextUtils.isEmpty(str2)) {
            fontBusiness.startDownload(str2);
            fontBusiness.addDownLoadListener(str2, new a(i3));
            VasLogReporter.getFont().reportHighest("native startDownload - fontId:" + i3 + "+scid:" + str2);
        }
        this.G.put(Integer.valueOf(i3), Float.valueOf(0.0f));
    }

    public int Q(int i3) {
        return 0;
    }

    public void R() {
        if (ETEngine.getInstance().isEngineInited.compareAndSet(false, true) && o.c()) {
            this.J.postDelayed(new Runnable() { // from class: com.etrump.mixlayout.FontManager.1
                @Override // java.lang.Runnable
                public void run() {
                    FontManager.this.B(true);
                    FontManager.this.l();
                }
            }, 2000L);
        }
    }

    public void S(final String str, final int i3) {
        this.J.post(new Runnable() { // from class: com.etrump.mixlayout.FontManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (FontManager.this.V.containsKey(str)) {
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) FontManager.this.V.get(str);
                    if (concurrentHashMap.containsKey(Integer.valueOf(i3))) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VasFont", 2, "updateDiyConfig uin = " + str + " fontId = " + i3);
                        }
                        concurrentHashMap.remove(Integer.valueOf(i3));
                    }
                }
            }
        });
    }

    public void T(String str, int i3) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, str);
        nTVasSimpleInfo.c();
        nTVasSimpleInfo.fontEffect = i3;
        nTVasSimpleInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        iVasInfoService.accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "VasFont", (hx3.c<NTVasSimpleInfo>) null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return true;
    }

    public void i(FontLoadCallback fontLoadCallback) {
        if (fontLoadCallback != null && !this.L.contains(fontLoadCallback)) {
            this.L.add(fontLoadCallback);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        FontManagerConstants.mMineLastReportTime = 0L;
        FontManagerConstants.mOthersLastReportTime = 0L;
        W.clear();
        Handler handler = this.J;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        q();
        o();
        p();
        this.L.clear();
        if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "onDestroy...");
        }
    }

    public k r(int i3, int i16) {
        k kVar = W.get(Integer.valueOf(i3));
        if (kVar == null) {
            File file = new File(FontManagerConstants.getTTFPath(i3, i16));
            boolean exists = file.exists();
            if (exists) {
                kVar = new k(i3, file.getAbsolutePath());
            }
            if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "findFontInfo|find from local|fontExists=" + exists);
            }
        }
        return kVar;
    }

    public boolean s() {
        if (Z) {
            this.f32639d = true;
            this.M = 1;
            return true;
        }
        int i3 = this.M;
        if (i3 != -1) {
            if (i3 == 1) {
                return true;
            }
            return false;
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.chat_font.name(), "default");
        QLog.d("VasFont", 1, "fontSwitch = " + featureValue);
        if (featureValue.equals("1")) {
            this.f32639d = true;
            this.M = 1;
            return true;
        }
        if (this.f32640e) {
            this.f32639d = true;
            this.M = 1;
            return true;
        }
        if (featureValue.equals(TVKUpdateInfo.APP_ID) || featureValue.equals("default")) {
            this.f32639d = t(featureValue);
        }
        if (featureValue.equals("0")) {
            this.M = 0;
        }
        return this.f32639d;
    }

    public File v() {
        File file = new File(FontManagerConstants.FONT_DOWN_LOAD_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public k w(final int i3, int i16, boolean z16, final String str, final int i17) {
        if (i16 == 4 || i16 == 3) {
            return null;
        }
        k kVar = W.get(str + "|" + i3);
        if (kVar == null) {
            k(i3, i16, z16, str, i17);
            return kVar;
        }
        if (kVar.f32756f == null) {
            kVar.f32756f = new ETFont(i3, kVar.f32752b, 16.0f, kVar.f32753c, kVar.f32754d);
        }
        if (kVar.f32757g) {
            ConcurrentHashMap<Integer, k> concurrentHashMap = this.V.get(str);
            if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3))) {
                k kVar2 = concurrentHashMap.get(Integer.valueOf(i3));
                this.J.post(new Runnable() { // from class: com.etrump.mixlayout.FontManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FontManager.n(str, ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "VasFont"), i3, i17);
                    }
                });
                return kVar2;
            }
            j(str, kVar, i17);
            return null;
        }
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable x(int i3) {
        Bitmap bitmap;
        File file = new File(FontManagerConstants.FONT_DOWN_LOAD_PATH + File.separatorChar + i3 + File.separatorChar + "fontname.png");
        if (!file.exists()) {
            return null;
        }
        try {
            new BitmapFactory.Options().inJustDecodeBounds = true;
            FileInputStream fileInputStream = new FileInputStream(file);
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            try {
                fileInputStream.close();
            } catch (FileNotFoundException e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.d("VasFont", 2, e.toString());
                }
                if (bitmap == null) {
                }
            } catch (IOException e17) {
                e = e17;
                e.printStackTrace();
                if (bitmap == null) {
                }
            }
        } catch (FileNotFoundException e18) {
            e = e18;
            bitmap = null;
        } catch (IOException e19) {
            e = e19;
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(bitmap);
    }

    public boolean y() {
        if (X == -1) {
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
            if (!TextUtils.isEmpty(featureValue)) {
                String[] split = featureValue.split("\\|");
                if (split.length >= 9) {
                    QLog.d("VasFont", 1, "FounderDynamicFont DPC value = " + split[8]);
                    if ("0".equals(split[8])) {
                        X = 0;
                    } else {
                        X = 1;
                    }
                }
            }
        }
        int i3 = X;
        if (i3 != 1 && i3 != -1) {
            return false;
        }
        return true;
    }

    public boolean z() {
        return FontManagerConstants.mFontSwitchFZ.get();
    }
}
