package com.tencent.luggage.sdk.jsapi.component.webaudio;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.cb.a;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.lm.a;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.tk.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.libwxaudio.WxAudioNative;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class WxAudioNativeInstallHelper {
    private static final String TAG = "Luggage.WxAudioNativeInstallHelper";
    private static Vector<String> mAppIdList = new Vector<>();
    private boolean bMuteOnBg;
    private final i destroyTask;
    private boolean isGame;
    private boolean isSupportWebAudio;
    private boolean loadSoResult;
    private com.tencent.luggage.wxa.lm.a mAudioOutputListener;
    private IListener<com.tencent.luggage.wxa.p9.d> mCustomLoadingStateEventListener;
    private WxAudioNative.NativeAudioPcmCallback nativeAudioPcmCallback;
    private Map<String, a.c> sessionIdMap;
    protected WxAudioNative wxAudioNative;
    private boolean xLibUVSwitch;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.cb.a.b
        public void loadLibrary(String str) {
            try {
                w.d(WxAudioNativeInstallHelper.TAG, "loadLibrary libName:%s", str);
                com.tencent.luggage.wxa.aa.h.b(str, WxAudioNativeInstallHelper.class.getClassLoader());
                WxAudioNativeInstallHelper.this.loadSoResult = true;
            } catch (SecurityException e16) {
                w.a(WxAudioNativeInstallHelper.TAG, e16, "load so %s error!!", str);
                WxAudioNativeInstallHelper.this.loadSoResult = false;
            } catch (UnsatisfiedLinkError e17) {
                w.a(WxAudioNativeInstallHelper.TAG, e17, "load so %s error!!", str);
                WxAudioNativeInstallHelper.this.loadSoResult = false;
            } catch (Throwable th5) {
                w.a(WxAudioNativeInstallHelper.TAG, th5, "load so %s error!!", str);
                WxAudioNativeInstallHelper.this.loadSoResult = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.cb.a.b
        public void loadLibrary(String str) {
            try {
                w.d(WxAudioNativeInstallHelper.TAG, "loadLibrary libName:%s", str);
                com.tencent.luggage.wxa.aa.h.b(str, WxAudioNativeInstallHelper.class.getClassLoader());
                WxAudioNativeInstallHelper.this.loadSoResult = true;
            } catch (SecurityException e16) {
                w.a(WxAudioNativeInstallHelper.TAG, e16, "load so %s error!!", str);
                WxAudioNativeInstallHelper.this.loadSoResult = false;
            } catch (UnsatisfiedLinkError e17) {
                w.a(WxAudioNativeInstallHelper.TAG, e17, "load so %s error!!", str);
                WxAudioNativeInstallHelper.this.loadSoResult = false;
            } catch (Throwable th5) {
                w.a(WxAudioNativeInstallHelper.TAG, th5, "load so %s error!!", str);
                WxAudioNativeInstallHelper.this.loadSoResult = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements WxAudioNative.NativeCallBackInterface {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f120238a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f120239b;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f120241a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f120242b;

            public a(String str, long j3) {
                this.f120241a = str;
                this.f120242b = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.a(WxAudioNativeInstallHelper.TAG, "wxAudio jsThreadHandler run onCallBack apiName:%s,engineId:%d", this.f120241a, Long.valueOf(this.f120242b));
                WxAudioNativeInstallHelper.this.wxAudioNative.update(this.f120242b);
            }
        }

        public c(WeakReference weakReference, com.tencent.luggage.wxa.xd.d dVar) {
            this.f120238a = weakReference;
            this.f120239b = dVar;
        }

        @Override // com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface
        public String getFilePath(String str) {
            w.d(WxAudioNativeInstallHelper.TAG, "getFilePath src:%s", str);
            if (WxAudioNative.NativeCallBackInterface.KEY_GET_FILE_PATH_CACHE_DIR.equals(str)) {
                com.tencent.luggage.wxa.t4.b bVar = (com.tencent.luggage.wxa.t4.b) this.f120239b.b(com.tencent.luggage.wxa.t4.b.class);
                if (bVar != null) {
                    return bVar.m();
                }
                return "";
            }
            if (str.startsWith("file://")) {
                String substring = str.substring(7);
                w.d(WxAudioNativeInstallHelper.TAG, "filePath:%s", substring);
                return substring;
            }
            if (str.contains("base64") && str.startsWith("data:audio")) {
                String a16 = com.tencent.luggage.wxa.oi.g.a(str.substring(str.indexOf("base64,") + 7).trim());
                w.d(WxAudioNativeInstallHelper.TAG, "base64 decode filePath:%s", a16);
                return a16;
            }
            if (str.startsWith("wxblob://")) {
                v privateAbsoluteFile = this.f120239b.getFileSystem().getPrivateAbsoluteFile(str);
                if (privateAbsoluteFile != null && privateAbsoluteFile.e()) {
                    return privateAbsoluteFile.g();
                }
                w.b(WxAudioNativeInstallHelper.TAG, "wxblob localFile is null");
                return str;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return com.tencent.luggage.wxa.oi.g.a(this.f120239b, str);
            }
            return str;
        }

        @Override // com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface
        public void onCallBack(long j3, String str) {
            ((q) this.f120238a.get()).a(new a(str, j3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.j f120244a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WxAudioNative.NativeCallBackInterface f120245b;

        public d(com.tencent.luggage.wxa.ei.j jVar, WxAudioNative.NativeCallBackInterface nativeCallBackInterface) {
            this.f120244a = jVar;
            this.f120245b = nativeCallBackInterface;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(WxAudioNativeInstallHelper.TAG, "createWxAudioBinding InitCallBack ");
            if (WxAudioNativeInstallHelper.this.wxAudioNative != null) {
                w.d(WxAudioNativeInstallHelper.TAG, "createWxAudioBinding  udpNative != null");
                return;
            }
            com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) this.f120244a.a(com.tencent.luggage.wxa.ei.v.class);
            if (vVar == null) {
                w.b(WxAudioNativeInstallHelper.TAG, "createWxAudioBinding v8Addon is null");
                return;
            }
            if (WxAudioNativeInstallHelper.this.xLibUVSwitch) {
                WxAudioNativeInstallHelper.this.wxAudioNative = new WxAudioNative(vVar.f(), vVar.B(), vVar.j());
            } else {
                WxAudioNativeInstallHelper.this.wxAudioNative = new WxAudioNative(vVar.f(), vVar.B(), 0L);
            }
            w.d(WxAudioNativeInstallHelper.TAG, "createWxAudioBinding InitCallBack ret:%d", Integer.valueOf(WxAudioNativeInstallHelper.this.wxAudioNative.InitCallBack(this.f120245b)));
            com.tencent.luggage.wxa.p9.j jVar = new com.tencent.luggage.wxa.p9.j();
            jVar.f137481d.f137482a = 0;
            jVar.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements c.InterfaceC6640c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f120247a;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WxAudioNativeInstallHelper.this.wxAudioNative != null) {
                    w.d(WxAudioNativeInstallHelper.TAG, "app enter suspend, pause all players");
                    WxAudioNativeInstallHelper.this.wxAudioNative.forcePauseAllPlayer(false);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WxAudioNativeInstallHelper.this.wxAudioNative != null) {
                    w.d(WxAudioNativeInstallHelper.TAG, "app enter fg, resume players if need");
                    WxAudioNativeInstallHelper.this.wxAudioNative.forceResumeAllPlayer(false);
                }
            }
        }

        public e(q qVar) {
            this.f120247a = qVar;
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (WxAudioNativeInstallHelper.this.wxAudioNative == null) {
                return;
            }
            if (com.tencent.luggage.wxa.qc.b.SUSPEND == bVar) {
                this.f120247a.a(new a(), true);
            } else if (com.tencent.luggage.wxa.qc.b.FOREGROUND == bVar) {
                this.f120247a.a(new b(), true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (WxAudioNativeInstallHelper.this) {
                if (WxAudioNativeInstallHelper.this.wxAudioNative != null) {
                    w.d(WxAudioNativeInstallHelper.TAG, "DestroyTask destroy wxAudioNative");
                    WxAudioNativeInstallHelper.this.wxAudioNative.destroyWebAudioContext();
                    WxAudioNativeInstallHelper.this.wxAudioNative = null;
                } else {
                    w.d(WxAudioNativeInstallHelper.TAG, "DestroyTask wxAudioNative is null");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f120252a;

        public g(String str) {
            this.f120252a = str;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onCreate() {
            w.d(WxAudioNativeInstallHelper.TAG, "onCreate, appId:%s", this.f120252a);
            com.tencent.luggage.wxa.lm.i.o().g();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d(WxAudioNativeInstallHelper.TAG, "onDestroy, appId:%s", this.f120252a);
            WxAudioNativeInstallHelper.mAppIdList.remove(this.f120252a);
            com.tencent.luggage.wxa.lm.i.o().e();
            WxAudioNativeInstallHelper.this.removeAudioOutputListener();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d(WxAudioNativeInstallHelper.TAG, "onPause, appId:%s", this.f120252a);
            WxAudioNativeInstallHelper.this.pauseAudio();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            w.d(WxAudioNativeInstallHelper.TAG, "onResume, appId:%s", this.f120252a);
            WxAudioNativeInstallHelper.this.resumeAudio();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h implements WxAudioNative.NativeAudioPcmCallback {
        public h() {
        }

        @Override // com.tencent.mm.libwxaudio.WxAudioNative.NativeAudioPcmCallback
        public void onPcmCallback(String str, byte[] bArr, int i3, int i16, int i17, int i18) {
            a.c cVar;
            if (WxAudioNativeInstallHelper.this.mAudioOutputListener != null) {
                synchronized (WxAudioNativeInstallHelper.this.sessionIdMap) {
                    if (WxAudioNativeInstallHelper.this.sessionIdMap.containsKey(str)) {
                        cVar = (a.c) WxAudioNativeInstallHelper.this.sessionIdMap.get(str);
                    } else {
                        a.c cVar2 = new a.c(3, "wx_webaudio_mix_audio_buffer_" + str);
                        w.d(WxAudioNativeInstallHelper.TAG, "create new session: %s", str);
                        WxAudioNativeInstallHelper.this.sessionIdMap.put(str, cVar2);
                        WxAudioNativeInstallHelper.this.mAudioOutputListener.c(cVar2);
                        cVar = cVar2;
                    }
                }
                WxAudioNativeInstallHelper.this.mAudioOutputListener.a(cVar, 1, i16, i17, bArr);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class i extends k implements n.a {
        public i(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.luggage.wxa.ei.n.a
        public void onDestroy() {
            run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface j extends com.tencent.luggage.wxa.eo.c {
        boolean O();
    }

    public WxAudioNativeInstallHelper() {
        this(false);
    }

    @Keep
    public static int audioHardwareBufferSize() {
        if (!com.tencent.luggage.wxa.tn.e.f141559a && com.tencent.luggage.wxa.im.a.b().a("clicfg_appbrand_android_webaudio_use_hw_buffer_size", 1) != 1) {
            return 0;
        }
        return 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseAudio() {
        WxAudioNative wxAudioNative = this.wxAudioNative;
        if (wxAudioNative != null) {
            if (this.bMuteOnBg) {
                wxAudioNative.setMute(true);
            } else {
                wxAudioNative.forcePauseAllPlayer();
            }
        }
        com.tencent.luggage.wxa.lm.i.o().e();
    }

    private static void printKeyLog(ArrayList<IDKey> arrayList) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("idkeyGroupStat:  id:1702");
        Iterator<IDKey> it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey next = it.next();
            sb5.append(", key:" + next.GetKey() + " value:" + next.GetValue());
        }
        w.a(TAG, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeAudio() {
        WxAudioNative wxAudioNative = this.wxAudioNative;
        if (wxAudioNative != null) {
            if (this.bMuteOnBg) {
                wxAudioNative.setMute(false);
            } else {
                wxAudioNative.forceResumeAllPlayer(!this.isGame);
            }
        }
        com.tencent.luggage.wxa.lm.i.o().g();
    }

    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public void createWxAudioBinding(com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.xd.d dVar) {
        ?? r56;
        w.d(TAG, "createWxAudioBinding");
        if (jVar == null) {
            w.b(TAG, "createWxAudioBinding jsruntime is null");
            return;
        }
        this.isSupportWebAudio = true;
        j jVar2 = (j) com.tencent.luggage.wxa.eo.g.a(j.class);
        if (jVar2 != null && jVar2.O()) {
            r56 = 1;
        } else {
            r56 = 0;
        }
        this.bMuteOnBg = r56;
        w.d(TAG, "support WebAudio, bMuteOnBg: %d", Integer.valueOf((int) r56));
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(FSUploadConst.ERR_LOGIN_STATUS_EMPTY);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(FSUploadConst.ERR_LOGIN_STATUS_EMPTY);
        iDKey2.SetValue(1);
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(FSUploadConst.ERR_LOGIN_STATUS_EMPTY);
        iDKey3.SetValue(1);
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            w.d(TAG, "run debug mode");
            com.tencent.luggage.wxa.cb.a.a(new a());
            com.tencent.luggage.wxa.cb.a.a();
            iDKey2.SetKey(3);
            if (!this.loadSoResult) {
                iDKey3.SetKey(6);
            }
        } else {
            w.d(TAG, "run release mode");
            try {
                com.tencent.luggage.wxa.aa.h.g("c++_shared");
                com.tencent.luggage.wxa.aa.h.g("xffmpeg");
            } catch (SecurityException e16) {
                w.a(TAG, e16, "load so %s error!!", "c++_shared");
            } catch (UnsatisfiedLinkError e17) {
                w.a(TAG, e17, "load so %s error!!", "c++_shared");
            } catch (Throwable th5) {
                w.a(TAG, th5, "load so %s error!!", "c++_shared");
            }
            w.d(TAG, "load so from apk");
            com.tencent.luggage.wxa.cb.a.a(new b());
            com.tencent.luggage.wxa.cb.a.a();
            iDKey2.SetKey(1);
            if (!this.loadSoResult) {
                iDKey3.SetKey(4);
            }
        }
        if (!this.loadSoResult) {
            w.b(TAG, "load so fail!!!, don't init webaudio");
            arrayList.add(iDKey3);
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(arrayList, true);
            printKeyLog(arrayList);
            return;
        }
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(arrayList, true);
        printKeyLog(arrayList);
        try {
            w.d(TAG, "call jni initAndroidAssetMgr");
            WxAudioNative.initAndroidAssetMgr(dVar.getContext().getAssets());
        } catch (SecurityException e18) {
            w.a(TAG, e18, "initAndroidAssetMgr error!!", new Object[0]);
            this.loadSoResult = false;
        } catch (UnsatisfiedLinkError e19) {
            w.a(TAG, e19, "initAndroidAssetMgr error!!", new Object[0]);
            this.loadSoResult = false;
        } catch (Throwable th6) {
            w.a(TAG, th6, "initAndroidAssetMgr error!!", new Object[0]);
            this.loadSoResult = false;
        }
        if (!this.loadSoResult) {
            w.b(TAG, "call jni initAndroidAssetMgr fail, load so fail!!!, don't init webaudio");
            return;
        }
        q qVar = (q) jVar.a(q.class);
        if (qVar == null) {
            w.b(TAG, "createWxAudioBinding jsThreadHandler is null");
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.o4.d.class));
        qVar.d(new d(jVar, com.tencent.luggage.wxa.s4.a.a(new c(new WeakReference(qVar), dVar), (n) jVar.a(n.class))));
        IListener<com.tencent.luggage.wxa.p9.d> iListener = new IListener<com.tencent.luggage.wxa.p9.d>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.luggage.sdk.jsapi.component.webaudio.WxAudioNativeInstallHelper.5
            public boolean a(com.tencent.luggage.wxa.p9.d dVar2) {
                throw null;
            }

            @Override // com.tencent.mm.sdk.event.IListener
            public /* bridge */ /* synthetic */ boolean callback(com.tencent.luggage.wxa.on.c cVar) {
                com.tencent.luggage.wxa.k0.d.a(cVar);
                return a((com.tencent.luggage.wxa.p9.d) null);
            }
        };
        this.mCustomLoadingStateEventListener = iListener;
        iListener.alive();
    }

    public void destroyWxAudioBinding(com.tencent.luggage.wxa.ei.j jVar) {
        w.d(TAG, "destroyWxAudioBinding");
        IListener<com.tencent.luggage.wxa.p9.d> iListener = this.mCustomLoadingStateEventListener;
        if (iListener != null) {
            iListener.dead();
        }
        if (jVar == null) {
            w.b(TAG, "destroyWxAudioBinding jsruntime is null");
        } else {
            ((n) jVar.a(n.class)).b(this.destroyTask);
        }
    }

    public void initConfigWXAudio(com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.xd.i iVar) {
        if (jVar != null && iVar != null) {
            q qVar = (q) jVar.a(q.class);
            if (qVar == null) {
                w.b(TAG, "jsThreadHandler is null");
                return;
            } else {
                if (this.bMuteOnBg) {
                    iVar.getRuntime().c0().a(new e(qVar));
                    return;
                }
                return;
            }
        }
        w.b(TAG, "jsruntime or service is null");
    }

    public void listenLifeCycle(com.tencent.luggage.wxa.xd.d dVar) {
        if (!this.isSupportWebAudio) {
            w.b(TAG, "listenLifeCycle now is not support webaudio");
            return;
        }
        if (!this.loadSoResult) {
            w.b(TAG, "listenLifeCycle so load fail ");
            return;
        }
        String appId = dVar.getAppId();
        g gVar = new g(appId);
        w.d(TAG, "listenLifeCycle appId:%s", appId);
        if (!mAppIdList.contains(appId)) {
            com.tencent.luggage.wxa.ic.e.a(appId, gVar);
            mAppIdList.add(appId);
        }
    }

    public void removeAudioOutputListener() {
        this.mAudioOutputListener = null;
        if (!this.isSupportWebAudio) {
            w.b(TAG, "listenLifeCycle now is not support webaudio");
            return;
        }
        if (!this.loadSoResult) {
            w.b(TAG, "listenLifeCycle so load fail ");
            return;
        }
        WxAudioNative wxAudioNative = this.wxAudioNative;
        if (wxAudioNative != null) {
            wxAudioNative.unregisterAudioPcmCallback();
        }
        this.sessionIdMap.clear();
    }

    public void setAudioOutputListener(com.tencent.luggage.wxa.lm.a aVar) {
        this.mAudioOutputListener = aVar;
        if (!this.isSupportWebAudio) {
            w.b(TAG, "listenLifeCycle now is not support webaudio");
            return;
        }
        if (!this.loadSoResult) {
            w.b(TAG, "listenLifeCycle so load fail ");
            return;
        }
        WxAudioNative wxAudioNative = this.wxAudioNative;
        if (wxAudioNative != null && aVar != null) {
            wxAudioNative.registerAudioPcmCallback(this.nativeAudioPcmCallback);
        }
        this.sessionIdMap.clear();
    }

    public WxAudioNativeInstallHelper(boolean z16) {
        this.xLibUVSwitch = true;
        this.isSupportWebAudio = false;
        this.loadSoResult = false;
        this.isGame = false;
        this.mAudioOutputListener = null;
        this.bMuteOnBg = false;
        this.destroyTask = new i(new f());
        this.sessionIdMap = new HashMap();
        this.nativeAudioPcmCallback = new h();
        this.isGame = z16;
    }
}
