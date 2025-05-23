package com.tencent.mobileqq.magicface.service;

import android.hardware.SensorManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.RecordVolume;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MagicfaceActionManager implements ActionGlobalData.a, MagicfaceContainerView.b {
    static IPatchRedirector $redirector_;

    /* renamed from: y, reason: collision with root package name */
    static final float[] f243470y;

    /* renamed from: z, reason: collision with root package name */
    static final int[] f243471z;

    /* renamed from: a, reason: collision with root package name */
    public int f243472a;

    /* renamed from: b, reason: collision with root package name */
    Emoticon f243473b;

    /* renamed from: c, reason: collision with root package name */
    String f243474c;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.mobileqq.magicface.magicfaceaction.b f243475d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.magicface.service.b f243476e;

    /* renamed from: f, reason: collision with root package name */
    List<Action> f243477f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.magicface.model.f f243478g;

    /* renamed from: h, reason: collision with root package name */
    Action f243479h;

    /* renamed from: i, reason: collision with root package name */
    volatile boolean f243480i;

    /* renamed from: j, reason: collision with root package name */
    volatile boolean f243481j;

    /* renamed from: k, reason: collision with root package name */
    volatile boolean f243482k;

    /* renamed from: l, reason: collision with root package name */
    d f243483l;

    /* renamed from: m, reason: collision with root package name */
    g f243484m;

    /* renamed from: n, reason: collision with root package name */
    e f243485n;

    /* renamed from: o, reason: collision with root package name */
    SoundPoolUtil f243486o;

    /* renamed from: p, reason: collision with root package name */
    ActionGlobalData f243487p;

    /* renamed from: q, reason: collision with root package name */
    int f243488q;

    /* renamed from: r, reason: collision with root package name */
    long f243489r;

    /* renamed from: s, reason: collision with root package name */
    long f243490s;

    /* renamed from: t, reason: collision with root package name */
    MagicfaceViewController f243491t;

    /* renamed from: u, reason: collision with root package name */
    f f243492u;

    /* renamed from: v, reason: collision with root package name */
    int f243493v;

    /* renamed from: w, reason: collision with root package name */
    public ShakeListener f243494w;

    /* renamed from: x, reason: collision with root package name */
    public RecordVolume f243495x;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MagicfaceActionManager.this);
            }
        }

        @Override // com.tencent.mobileqq.magicface.service.MagicfaceActionManager.f
        public void stop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (MagicfaceActionManager.this.f243472a == 1) {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null && (runtime instanceof QQAppInterface)) {
                    ReportController.o((QQAppInterface) runtime, "CliOper", "", "", "MbJieshou", "MbWanchengXiaochu", 0, 0, MagicfaceActionManager.this.f243473b.epId, "", "", "");
                    return;
                }
                return;
            }
            AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime2 != null && (runtime2 instanceof QQAppInterface)) {
                MagicfaceActionManager.this.f243489r = System.currentTimeMillis();
                ReportController.o((QQAppInterface) runtime2, "CliOper", "", "", "MbFasong", "MbZhudongChaozuo", 0, 0, MagicfaceActionManager.this.f243473b.epId, "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends ShakeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MagicfaceActionManager.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements RecordVolume.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MagicfaceActionManager.this);
            }
        }

        @Override // com.tencent.mobileqq.magicface.model.RecordVolume.a
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            MagicfaceActionManager magicfaceActionManager = MagicfaceActionManager.this;
            Action action = magicfaceActionManager.f243479h;
            if (action != null) {
                action.a(i3, magicfaceActionManager.f243492u);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void magicfaceActionEnd(ActionGlobalData actionGlobalData);

        void magicfaceActionStart(ActionGlobalData actionGlobalData);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void magicfaceClose();
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface f {
        void stop();
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface g {
        void a(String str);

        void b(String str);

        void c(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            f243470y = new float[]{1.4f, 1.5f, 1.6f, 1.7f, 1.8f, 1.9f, 2.0f, 2.1f, 2.2f, 2.3f};
            f243471z = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        }
    }

    public MagicfaceActionManager(MagicfaceViewController magicfaceViewController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) magicfaceViewController);
            return;
        }
        this.f243472a = 0;
        this.f243480i = false;
        this.f243481j = false;
        this.f243482k = false;
        this.f243487p = null;
        this.f243488q = 0;
        this.f243492u = new a();
        this.f243493v = 0;
        this.f243494w = new b();
        this.f243495x = new RecordVolume(new c());
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager begins");
        }
        this.f243491t = magicfaceViewController;
        this.f243475d = new com.tencent.mobileqq.magicface.magicfaceaction.b();
        this.f243486o = new SoundPoolUtil();
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager ends");
        }
    }

    public static int k(Emoticon emoticon, int i3) {
        String str;
        com.tencent.mobileqq.magicface.model.f fVar = new com.tencent.mobileqq.magicface.model.f(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", emoticon.epId));
        if (i3 == 0) {
            str = fVar.f("send.xml");
        } else if (i3 == 1) {
            str = fVar.f(QzoneGiftFullScreenActionManager.MAGICFACE_RECEIVE_XML);
        } else {
            str = null;
        }
        return new com.tencent.mobileqq.magicface.magicfaceaction.b().c(str);
    }

    public static ActionGlobalData n(Emoticon emoticon, int i3) {
        return o(emoticon, i3, 1);
    }

    public static ActionGlobalData o(Emoticon emoticon, int i3, int i16) {
        return p(emoticon, i3, i16, 0);
    }

    public static ActionGlobalData p(Emoticon emoticon, int i3, int i16, int i17) {
        com.tencent.mobileqq.magicface.model.f fVar;
        String replace;
        String str;
        if (i16 == 1) {
            fVar = new com.tencent.mobileqq.magicface.model.f(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", emoticon.epId));
        } else if (i16 == 2) {
            if (i17 == 1) {
                replace = EmotionPanelConstans.giftBigAnimationPath.replace("[epId]", emoticon.epId + "_V");
            } else {
                replace = EmotionPanelConstans.giftBigAnimationPath.replace("[epId]", emoticon.epId + "_HD");
            }
            fVar = new com.tencent.mobileqq.magicface.model.f(replace, 2);
        } else {
            if (i16 != 3) {
                return null;
            }
            fVar = new com.tencent.mobileqq.magicface.model.f(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", emoticon.epId), 3);
        }
        if (i3 == 0) {
            str = fVar.f("send.xml");
        } else if (i3 == 1) {
            str = fVar.f(QzoneGiftFullScreenActionManager.MAGICFACE_RECEIVE_XML);
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return new com.tencent.mobileqq.magicface.magicfaceaction.b().b(str);
    }

    public void A(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else {
            this.f243484m = gVar;
        }
    }

    public void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean(QzoneGiftFullScreenActionManager.MAGICFACE_RECEIVE_SOUND, z16).commit();
        }
    }

    public void C(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("sendSound", z16).commit();
        }
    }

    public int[] D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (int[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func splitVersion begins, version:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int[] iArr = new int[3];
        for (int i3 = 0; i3 < 3; i3++) {
            iArr[i3] = 0;
        }
        String[] split = str.split("\\.");
        if (split != null && split.length > 1) {
            for (int i16 = 0; i16 < 3; i16++) {
                try {
                    iArr[i16] = Integer.valueOf(split[i16]).intValue();
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicfaceActionManager", 2, "func splitVersion, intVers[" + i16 + "],=" + iArr[i16]);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func splitVersion ends");
        }
        return iArr;
    }

    public void E(ActionGlobalData actionGlobalData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) actionGlobalData);
        } else if (MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC.equalsIgnoreCase(actionGlobalData.f243355h)) {
            this.f243495x.stop();
        } else if (LayoutAttrDefine.Gravity.Gravity.equalsIgnoreCase(actionGlobalData.f243355h)) {
            ((SensorManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.f243494w);
        }
    }

    public void F(ActionGlobalData actionGlobalData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) actionGlobalData);
            return;
        }
        if (MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC.equalsIgnoreCase(actionGlobalData.f243355h)) {
            ThreadManagerV2.executeOnNetWorkThread(this.f243495x);
        } else if (LayoutAttrDefine.Gravity.Gravity.equalsIgnoreCase(actionGlobalData.f243355h)) {
            SensorManager sensorManager = (SensorManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            SensorMonitor.registerListener(sensorManager, this.f243494w, SensorMonitor.getDefaultSensor(sensorManager, 1), 0);
        } else {
            WebRTCSDK.PRIVILEGE_TOUCH.equalsIgnoreCase(actionGlobalData.f243355h);
        }
    }

    void G() {
        Action action;
        MagicfaceViewController magicfaceViewController = this.f243491t;
        if (magicfaceViewController != null && this.f243472a == 0 && (action = this.f243479h) != null && action.f243343n) {
            magicfaceViewController.e();
        }
    }

    @Override // com.tencent.mobileqq.magicface.view.MagicfaceContainerView.b
    public boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, i3)).booleanValue();
        }
        Action action = this.f243479h;
        if (action != null) {
            action.e(i3, this.f243492u);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.a
    public void b() {
        com.tencent.mobileqq.magicface.magicfaceaction.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Action action = this.f243479h;
        if (action != null && (aVar = action.f243338i) != null && LayoutAttrDefine.Gravity.Gravity.equalsIgnoreCase(aVar.f243375b)) {
            if (QQPermissionConstants.Permission.AUIDO_GROUP.equalsIgnoreCase(aVar.f243374a)) {
                g gVar = this.f243484m;
                if (gVar != null) {
                    ActionGlobalData actionGlobalData = this.f243487p;
                    this.f243488q = actionGlobalData.f243356i;
                    gVar.c(actionGlobalData.f243358k);
                    return;
                }
                return;
            }
            g gVar2 = this.f243484m;
            if (gVar2 != null) {
                ActionGlobalData actionGlobalData2 = this.f243487p;
                gVar2.c(actionGlobalData2.f243360m.a(1, actionGlobalData2.f243363p));
            }
        }
    }

    @Override // com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.a
    public void c() {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.f243481j = true;
        Action action = this.f243479h;
        if (action != null) {
            action.d();
            this.f243479h.g();
        }
        this.f243490s = System.currentTimeMillis();
        ActionGlobalData actionGlobalData = this.f243487p;
        if (actionGlobalData != null && (gVar = this.f243484m) != null && actionGlobalData.f243358k != null) {
            int i3 = actionGlobalData.f243356i;
            this.f243488q = i3;
            gVar.c(actionGlobalData.f243360m.a(i3, actionGlobalData.f243363p));
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            e(null);
        }
    }

    public void e(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) eVar);
            return;
        }
        if (eVar != null) {
            this.f243485n = eVar;
        }
        this.f243481j = true;
        Action action = this.f243479h;
        if (action != null) {
            action.g();
        }
        ActionGlobalData actionGlobalData = this.f243487p;
        if (actionGlobalData != null) {
            actionGlobalData.a(null);
        }
    }

    public void f(Emoticon emoticon, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, emoticon, Integer.valueOf(i3), str);
        } else {
            g(emoticon, i3, str, 1);
        }
    }

    public void g(Emoticon emoticon, int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, emoticon, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func doAction begins. isStart:" + this.f243480i + ",isRelease:" + this.f243482k);
        }
        if (this.f243480i) {
            return;
        }
        this.f243473b = emoticon;
        this.f243472a = i3;
        this.f243474c = str;
        ThreadManagerV2.post(new Runnable(i16, i3) { // from class: com.tencent.mobileqq.magicface.service.MagicfaceActionManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f243496d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f243497e;

            {
                this.f243496d = i16;
                this.f243497e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MagicfaceActionManager.this, Integer.valueOf(i16), Integer.valueOf(i3));
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
            
                r7.this$0.G();
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00cb, code lost:
            
                if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L51;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00f9, code lost:
            
                r0 = r7.this$0;
                r0.s(r0.f243487p);
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x0100, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x00f6, code lost:
            
                com.tencent.qphone.base.util.QLog.d("MagicfaceActionManager", 2, "func doAction, \u3010magic end\u3011");
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x00f4, code lost:
            
                if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L52;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    try {
                        if (MagicfaceActionManager.this.f243482k) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MagicfaceActionManager", 2, "func doAction, \u3010magic end\u3011");
                            }
                            MagicfaceActionManager magicfaceActionManager = MagicfaceActionManager.this;
                            magicfaceActionManager.s(magicfaceActionManager.f243487p);
                            return;
                        }
                        MagicfaceActionManager.this.q(this.f243496d);
                        int i17 = this.f243497e;
                        if (i17 == 0) {
                            str2 = MagicfaceActionManager.this.f243478g.f("send.xml");
                        } else if (i17 == 1) {
                            str2 = MagicfaceActionManager.this.f243478g.f(QzoneGiftFullScreenActionManager.MAGICFACE_RECEIVE_XML);
                        } else {
                            str2 = null;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("MagicfaceActionManager", 2, "func doAction. step 1");
                        }
                        if (str2 != null) {
                            MagicfaceActionManager magicfaceActionManager2 = MagicfaceActionManager.this;
                            magicfaceActionManager2.f243487p = magicfaceActionManager2.f243475d.b(str2);
                            if (this.f243497e == 1) {
                                MagicfaceActionManager.this.v();
                            }
                            MagicfaceActionManager magicfaceActionManager3 = MagicfaceActionManager.this;
                            magicfaceActionManager3.t(magicfaceActionManager3.f243487p);
                            MagicfaceActionManager magicfaceActionManager4 = MagicfaceActionManager.this;
                            magicfaceActionManager4.f243477f = magicfaceActionManager4.f243475d.d(str2);
                            MagicfaceActionManager.this.h();
                            Iterator<Action> it = MagicfaceActionManager.this.f243477f.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Action next = it.next();
                                MagicfaceActionManager magicfaceActionManager5 = MagicfaceActionManager.this;
                                magicfaceActionManager5.f243479h = next;
                                next.f243336g = magicfaceActionManager5.f243476e;
                                next.f243330a = magicfaceActionManager5.f243487p;
                                boolean b16 = next.b();
                                if (!MagicfaceActionManager.this.f243481j) {
                                    if (!next.f243343n) {
                                        if (!b16 || MagicfaceActionManager.this.f243481j) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MagicfaceActionManager", 2, "doaction=Exception=" + e16.toString());
                        }
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicfaceActionManager", 2, "func doAction, \u3010magic end\u3011");
                    }
                    MagicfaceActionManager magicfaceActionManager6 = MagicfaceActionManager.this;
                    magicfaceActionManager6.s(magicfaceActionManager6.f243487p);
                    throw th5;
                }
            }
        }, 8, null, true);
    }

    public void h() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ActionGlobalData actionGlobalData = this.f243487p;
        boolean z16 = false;
        if (actionGlobalData != null && !"non-ver".equals(actionGlobalData.f243353f)) {
            int[] D = D(AppSetting.f99551k);
            int[] D2 = D(this.f243487p.f243353f);
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceActionManager", 2, "func filterAction, qqver:" + D + ",magicVer:" + D2);
            }
            if (D != null && D2 != null && D.length == D2.length) {
                for (int i17 = 0; i17 < D2.length && (i3 = D[i17]) <= (i16 = D2[i17]); i17++) {
                    if (i3 < i16) {
                        break;
                    }
                }
            }
            z16 = true;
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceActionManager", 2, "func filterAction, isQQSupport:" + z16);
            }
            this.f243477f = m(!z16);
            return;
        }
        this.f243477f = m(false);
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean(QzoneGiftFullScreenActionManager.MAGICFACE_RECEIVE_SOUND, false);
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("sendSound", false);
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        ActionGlobalData actionGlobalData = this.f243487p;
        if (actionGlobalData != null && actionGlobalData.f243360m != null) {
            return this.f243488q;
        }
        return 0;
    }

    public List<Action> m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Action> it = this.f243477f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Action next = it.next();
            if (next != null) {
                if (z16) {
                    if ("default".equals(next.f243331b)) {
                        arrayList.add(next);
                        break;
                    }
                } else if (!"default".equals(next.f243331b)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    void q(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func initActionData begins.");
        }
        this.f243480i = true;
        this.f243481j = false;
        this.f243476e.b();
        if (i3 == 1) {
            this.f243478g = new com.tencent.mobileqq.magicface.model.f(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", this.f243473b.epId));
        } else if (i3 == 2) {
            this.f243478g = new com.tencent.mobileqq.magicface.model.f(EmotionPanelConstans.giftBigAnimationPath.replace("[epId]", this.f243473b.epId), 2);
        } else if (i3 == 3) {
            this.f243478g = new com.tencent.mobileqq.magicface.model.f(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", this.f243473b.epId), 3);
        }
        this.f243476e.i(this.f243478g);
        this.f243476e.g(this.f243486o);
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func initActionData ends.");
        }
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.f243480i;
    }

    public void s(ActionGlobalData actionGlobalData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) actionGlobalData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, \u3010magic end\u3011");
        }
        e eVar = this.f243485n;
        if (eVar != null) {
            eVar.magicfaceClose();
        }
        this.f243480i = false;
        if (actionGlobalData != null) {
            E(actionGlobalData);
        }
        d dVar = this.f243483l;
        if (dVar != null) {
            dVar.magicfaceActionEnd(actionGlobalData);
        }
    }

    public void t(ActionGlobalData actionGlobalData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) actionGlobalData);
            return;
        }
        if (actionGlobalData == null) {
            QLog.e("MagicfaceActionManager", 1, "onStartMagicface error : actionGlobalData = null");
            return;
        }
        F(actionGlobalData);
        d dVar = this.f243483l;
        if (dVar != null) {
            dVar.magicfaceActionStart(actionGlobalData);
        }
        g gVar = this.f243484m;
        if (gVar != null) {
            gVar.b(actionGlobalData.f243357j);
            if (this.f243472a == 1) {
                String str = actionGlobalData.f243359l;
                if (str != null) {
                    this.f243484m.a(str.replace("%param%", "" + actionGlobalData.f243356i));
                } else {
                    this.f243484m.a("");
                }
            }
        }
        if (actionGlobalData.f243360m != null) {
            actionGlobalData.a(this);
            actionGlobalData.b();
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        ActionGlobalData actionGlobalData = this.f243487p;
        if (actionGlobalData != null) {
            actionGlobalData.f243361n = true;
        }
    }

    public void v() {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, magicValue:" + this.f243473b.magicValue);
        }
        String str = this.f243473b.magicValue;
        if (str != null) {
            String[] split2 = str.split(ContainerUtils.FIELD_DELIMITER);
            if (split2.length >= 0 && split2[0].contains("value") && (split = split2[0].split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length == 2) {
                this.f243487p.f243356i = Integer.parseInt(split[1]);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, value:" + this.f243487p.f243356i);
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            d();
            f(this.f243473b, this.f243472a, this.f243474c);
        }
    }

    public void x() {
        AppRuntime runtime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        this.f243482k = true;
        ActionGlobalData actionGlobalData = this.f243487p;
        if (actionGlobalData != null) {
            actionGlobalData.a(null);
        }
        com.tencent.mobileqq.magicface.service.b bVar = this.f243476e;
        if (bVar != null) {
            bVar.g(null);
            this.f243476e.f();
        }
        SoundPoolUtil soundPoolUtil = this.f243486o;
        if (soundPoolUtil != null) {
            soundPoolUtil.c();
            this.f243486o = null;
        }
        if (this.f243472a == 0 && this.f243490s - this.f243489r > 0 && (runtime = BaseApplicationImpl.getApplication().getRuntime()) != null && (runtime instanceof QQAppInterface)) {
            ReportController.o((QQAppInterface) runtime, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.f243490s - this.f243489r), "", "", "");
        }
        this.f243491t = null;
    }

    public void y(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else {
            this.f243483l = dVar;
        }
    }

    public void z(com.tencent.mobileqq.magicface.service.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.f243476e = bVar;
        }
    }
}
