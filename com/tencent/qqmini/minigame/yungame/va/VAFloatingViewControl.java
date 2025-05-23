package com.tencent.qqmini.minigame.yungame.va;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qqmini.minigame.yungame.GameLoadingStatus;
import com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncObjectResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.HotfixDownloadState;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.IHotfixloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.OnVADownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.ProxyCallback;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VADownloadState;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VAFloatingViewControl implements VAFloatDownloadTips.a {
    private HotfixDownloadState D;

    /* renamed from: d, reason: collision with root package name */
    private final MiniAppInfo f346918d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f346919e;

    /* renamed from: h, reason: collision with root package name */
    private VADownloadState f346921h;

    /* renamed from: f, reason: collision with root package name */
    private VAFloatDownloadTips f346920f = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f346922i = false;

    /* renamed from: m, reason: collision with root package name */
    private int f346923m = 0;
    private MenuButtonRect C = null;
    private boolean E = false;
    private final AtomicBoolean F = new AtomicBoolean(false);
    private final AtomicBoolean G = new AtomicBoolean(false);
    private com.tencent.qqmini.minigame.yungame.va.a H = new VADownloadDualChannelDelegate();
    private OnVADownloadListener I = new a();
    private IHotfixloadListener J = new b();
    private AsyncObjectResult K = new c();
    private final Handler L = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.qqmini.minigame.yungame.va.VAFloatingViewControl.4
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            switch (message.what) {
                case 256:
                    VAFloatingViewControl vAFloatingViewControl = VAFloatingViewControl.this;
                    vAFloatingViewControl.N(vAFloatingViewControl.f346921h);
                    return false;
                case 257:
                    VAFloatingViewControl vAFloatingViewControl2 = VAFloatingViewControl.this;
                    vAFloatingViewControl2.t(vAFloatingViewControl2.f346921h);
                    return false;
                case 258:
                    VAFloatingViewControl vAFloatingViewControl3 = VAFloatingViewControl.this;
                    vAFloatingViewControl3.O(vAFloatingViewControl3.D);
                    return false;
                case 259:
                    QMLog.e("VAFloatingViewControl", "check va download callback timeout!!!");
                    VAFloatingViewControl.this.E = true;
                    ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.yungame.va.VAFloatingViewControl.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            HashMap hashMap = new HashMap();
                            hashMap.put("ext7", "3");
                            hashMap.put("ext8", "1");
                            if (VAFloatingViewControl.this.f346918d == null) {
                                str = "";
                            } else {
                                str = VAFloatingViewControl.this.f346918d.appId;
                            }
                            com.tencent.qqmini.minigame.yungame.va.d.b("989405", "18", str, hashMap);
                        }
                    });
                    return false;
                case 260:
                    Object obj = message.obj;
                    if (obj instanceof Boolean) {
                        VAFloatingViewControl.this.y(((Boolean) obj).booleanValue());
                        return false;
                    }
                    QMLog.w("VAFloatingViewControl", "receive network change message, but obj invalid");
                    return false;
                case 261:
                    VAFloatingViewControl.this.v();
                    return false;
                default:
                    return false;
            }
        }
    });

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements OnVADownloadListener {
        a() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.OnVADownloadListener
        public void onDownloadUpdate(String str, int i3, int i16, long j3, long j16, String str2) {
            if (VAFloatingViewControl.this.f346921h == null) {
                return;
            }
            VAFloatingViewControl.this.f346921h.downloadStatus = i3;
            VAFloatingViewControl.this.f346921h.pkgSize = j16;
            VAFloatingViewControl.this.f346921h.progress = i16;
            VAFloatingViewControl.this.f346921h.downloadSize = j3;
            if (QMLog.isColorLevel()) {
                QMLog.d("VAFloatingViewControl", "onDownloadUpdate: currentDownloadState:" + VAFloatingViewControl.this.f346921h);
            }
            VAFloatingViewControl.this.L.sendEmptyMessage(256);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements IHotfixloadListener {
        b() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.IHotfixloadListener
        public void onDownloadStatusChange(@NonNull HotfixDownloadState hotfixDownloadState) {
            if (QMLog.isColorLevel()) {
                QMLog.d("VAFloatingViewControl", "onDownloadStatusChange: hotfixDownloadState:" + VAFloatingViewControl.this.D);
            }
            if (VAFloatingViewControl.this.D == null) {
                return;
            }
            VAFloatingViewControl.this.D.setStatus(hotfixDownloadState.getStatus());
            if (hotfixDownloadState.getProgess() != -1) {
                VAFloatingViewControl.this.D.setProgess(hotfixDownloadState.getProgess());
            }
            if (hotfixDownloadState.getTotalSize() != -1) {
                VAFloatingViewControl.this.D.setTotalSize(hotfixDownloadState.getTotalSize());
            }
            VAFloatingViewControl.this.D.setErrorCode(hotfixDownloadState.getErrorCode());
            VAFloatingViewControl.this.L.sendEmptyMessage(258);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class c implements AsyncObjectResult {
        c() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncObjectResult
        public void onReceiveResult(boolean z16, Object obj) {
            Message message = new Message();
            message.what = 260;
            message.obj = Boolean.valueOf(z16);
            VAFloatingViewControl.this.L.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class d implements ProxyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirtualAppProxy f346931a;

        d(VirtualAppProxy virtualAppProxy) {
            this.f346931a = virtualAppProxy;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.ProxyCallback
        public void onResult(String str, Object obj) {
            VAFloatingViewControl.this.E = false;
            VAFloatingViewControl.this.L.removeMessages(259);
            QMLog.i("VAFloatingViewControl", "checkVADownload queryDownloadState appId:" + str + " data:" + obj);
            HashMap hashMap = new HashMap();
            if (obj instanceof VADownloadState) {
                if (VAFloatingViewControl.this.f346921h != null) {
                    this.f346931a.removeDownloadListener(VAFloatingViewControl.this.f346921h.gameId, VAFloatingViewControl.this.I);
                }
                VAFloatingViewControl.this.f346921h = (VADownloadState) obj;
                if (VAFloatingViewControl.this.f346921h.autoDownload >= 0 && VAFloatingViewControl.this.f346921h.downloadTypeOnWifi >= 0) {
                    this.f346931a.addDownloadListener(VAFloatingViewControl.this.f346921h.gameId, VAFloatingViewControl.this.f346918d, VAFloatingViewControl.this.I);
                    VAFloatingViewControl.this.L.sendEmptyMessage(257);
                    hashMap.put("ext7", "1");
                } else {
                    QMLog.e("VAFloatingViewControl", "queryDownloadState mCurrentDownloadState.autoDownload < 0 || mCurrentDownloadState.downloadTypeOnWifi < 0");
                    return;
                }
            } else {
                hashMap.put("ext7", "2");
            }
            hashMap.put("ext8", "1");
            com.tencent.qqmini.minigame.yungame.va.d.b("989405", "18", str, hashMap);
        }
    }

    public VAFloatingViewControl(FrameLayout frameLayout, MiniAppInfo miniAppInfo) {
        this.f346919e = frameLayout;
        this.f346918d = miniAppInfo;
    }

    private void A(int i3) {
        QMLog.i("VAFloatingViewControl", "initTips scene:" + i3);
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            qQCustomizedProxy.setNetChangeReceiver(this.f346919e.getContext(), this.K);
        }
        VAFloatDownloadTips vAFloatDownloadTips = new VAFloatDownloadTips(this.f346919e.getContext(), i3);
        this.f346920f = vAFloatDownloadTips;
        vAFloatDownloadTips.setDualChannelDelegate(this.H);
        this.f346920f.setOperateClickListener(this);
        this.f346919e.addView(this.f346920f);
    }

    private boolean B() {
        boolean z16;
        boolean z17;
        HotfixDownloadState hotfixDownloadState = this.D;
        if (hotfixDownloadState != null && hotfixDownloadState.getStatus() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        VADownloadState vADownloadState = this.f346921h;
        if (vADownloadState != null && vADownloadState.downloadStatus == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        QMLog.i("VAFloatingViewControl", "isDownloadingState isVaDownloading:" + z17 + ", isHotfixDownloading:" + z16);
        if (!z16 && !z17) {
            return false;
        }
        return true;
    }

    private boolean C(VADownloadState vADownloadState) {
        if (vADownloadState == null) {
            return false;
        }
        if ((4 != vADownloadState.downloadStatus || NetworkUtil.getActiveNetworkType(this.f346919e.getContext()) != 0) && 6 != vADownloadState.downloadStatus) {
            return false;
        }
        return true;
    }

    private boolean D() {
        if (QMLog.isColorLevel()) {
            QMLog.d("VAFloatingViewControl", "getActiveNetworkType " + NetworkUtil.getActiveNetworkType(this.f346919e.getContext()));
        }
        if (1 == NetworkUtil.getActiveNetworkType(this.f346919e.getContext())) {
            return true;
        }
        return false;
    }

    private void J() {
        ((VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class)).restartVirtualApp(this.f346918d.appId, this.f346921h.gameId, new ProxyCallback() { // from class: com.tencent.qqmini.minigame.yungame.va.VAFloatingViewControl.6
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.ProxyCallback
            public void onResult(String str, Object obj) {
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() && (VAFloatingViewControl.this.f346919e.getContext() instanceof Activity)) {
                    ((Activity) VAFloatingViewControl.this.f346919e.getContext()).finish();
                    QMLog.i("VAFloatingViewControl", "restartVirtualApp onResult close activity");
                } else {
                    QMLog.i("VAFloatingViewControl", "restartVirtualApp onResult failed");
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.yungame.va.VAFloatingViewControl.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VAFloatingViewControl.this.f346920f != null) {
                                VAFloatingViewControl.this.f346920f.updateState(5);
                                VAFloatingViewControl.this.f346920f.setVisibility(8);
                                VAFloatingViewControl.this.f346920f = null;
                            }
                        }
                    });
                }
            }
        });
    }

    private void L(boolean z16) {
        String str;
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy == null) {
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.enableDualChannelTask(false);
        }
        virtualAppProxy.startHotfixDownload(this.f346921h.gameId);
        HashMap hashMap = new HashMap();
        hashMap.put("ext6", this.f346921h.gameVersionCode);
        if (!z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("ext7", str);
        hashMap.put("ext8", "1");
        hashMap.put("ext29", "2");
        com.tencent.qqmini.minigame.yungame.va.d.b("989319", "18", this.f346921h.gameId, hashMap);
        QMLog.w("VAFloatingViewControl", "startHotfixDownload gameId:" + this.f346921h.gameId + ", versionCode:" + this.f346921h.gameVersionCode + ", autoDownload:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z16, boolean z17) {
        String str;
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy == null) {
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.enableDualChannelTask(true);
        }
        virtualAppProxy.startDownload(this.f346921h.gameId, z17, null);
        HashMap hashMap = new HashMap();
        hashMap.put("ext6", this.f346921h.gameVersionCode);
        if (!z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("ext7", str);
        hashMap.put("ext8", "1");
        hashMap.put("ext29", "1");
        com.tencent.qqmini.minigame.yungame.va.d.b("989319", "18", this.f346921h.gameId, hashMap);
        QMLog.w("VAFloatingViewControl", "startVADownload gameId:" + this.f346921h.gameId + ", versionCode:" + this.f346921h.gameVersionCode + ", autoDownload:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(VADownloadState vADownloadState) {
        VAFloatDownloadTips vAFloatDownloadTips;
        if (vADownloadState != null && (vAFloatDownloadTips = this.f346920f) != null) {
            int i3 = vADownloadState.downloadStatus;
            if (10 == i3) {
                QMLog.i("VAFloatingViewControl", "VADownloadState.STATUS_DELETE == downloadState.downloadStatus" + this.f346921h);
                this.f346920f.updateState(1);
                this.f346920f.setVisibility(8);
                this.f346920f = null;
                return;
            }
            if (9 == i3) {
                vAFloatDownloadTips.updateDownloadProcess(x(100, 0), vADownloadState.downloadSize, vADownloadState.pkgSize);
                this.f346920f.updateState(2);
                if (!r()) {
                    w();
                    return;
                }
                return;
            }
            if (2 == i3) {
                vAFloatDownloadTips.updateDownloadProcess(x(vADownloadState.progress, 0), vADownloadState.downloadSize, vADownloadState.pkgSize);
                this.f346920f.updateState(2);
                this.H.a(vADownloadState.progress);
                return;
            }
            String str = "0";
            if (C(vADownloadState)) {
                this.f346920f.updateState(5);
                HashMap hashMap = new HashMap();
                hashMap.put("ext6", this.f346921h.gameVersionCode);
                if (!D()) {
                    str = "1";
                }
                hashMap.put("ext7", str);
                hashMap.put("ext8", "1");
                hashMap.put("ext29", "1");
                hashMap.put("ext49", "-1");
                com.tencent.qqmini.minigame.yungame.va.d.b("989320", "18", this.f346921h.gameId, hashMap);
                return;
            }
            if (4 == vADownloadState.downloadStatus && !this.G.compareAndSet(true, false)) {
                this.f346920f.updateDownloadProcess(x(vADownloadState.progress, 0), vADownloadState.downloadSize, vADownloadState.pkgSize);
                this.f346920f.updateState(3);
            } else if (5 == vADownloadState.downloadStatus) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ext6", this.f346921h.gameVersionCode);
                if (!D()) {
                    str = "1";
                }
                hashMap2.put("ext7", str);
                hashMap2.put("ext8", "1");
                hashMap2.put("ext29", "1");
                com.tencent.qqmini.minigame.yungame.va.d.b("989320", "18", this.f346921h.gameId, hashMap2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(HotfixDownloadState hotfixDownloadState) {
        String str;
        if (hotfixDownloadState == null) {
            return;
        }
        int status = hotfixDownloadState.getStatus();
        if (status != 0 && status != 1) {
            if (status == 2) {
                VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
                if (vAFloatDownloadTips != null) {
                    vAFloatDownloadTips.updateDownloadProcess(x(100, hotfixDownloadState.getProgess()));
                    this.f346920f.updateState(3);
                    return;
                }
                return;
            }
            if (status == 3 || status == 4) {
                w();
                HashMap hashMap = new HashMap();
                hashMap.put("ext6", this.f346921h.gameVersionCode);
                if (!D()) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("ext7", str);
                hashMap.put("ext8", "1");
                hashMap.put("ext29", "2");
                if (hotfixDownloadState.getErrorCode() != 0) {
                    hashMap.put("ext49", String.valueOf(hotfixDownloadState.getErrorCode()));
                }
                com.tencent.qqmini.minigame.yungame.va.d.b("989320", "18", this.f346921h.gameId, hashMap);
                return;
            }
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips2 = this.f346920f;
        if (vAFloatDownloadTips2 != null) {
            vAFloatDownloadTips2.updateDownloadProcess(x(100, hotfixDownloadState.getProgess()));
            this.f346920f.updateState(2);
        }
    }

    private boolean q() {
        if (this.f346923m == 1) {
            return true;
        }
        return false;
    }

    private boolean r() {
        VADownloadState vADownloadState;
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy != null && (vADownloadState = this.f346921h) != null) {
            virtualAppProxy.registerHotfixDownloadCallback(vADownloadState.gameId, this.f346918d, this.J);
            L(true);
            this.D = new HotfixDownloadState();
            return true;
        }
        return false;
    }

    private void s() {
        int top;
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips == null) {
            return;
        }
        float density = DisplayUtil.getDensity(vAFloatDownloadTips.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388613;
        if (this.C == null) {
            top = ViewUtils.dip2px(14.0f);
        } else {
            top = (int) (r2.getTop() * density);
        }
        layoutParams.topMargin = top;
        layoutParams.rightMargin = ViewUtils.dip2px(116.0f);
        this.f346920f.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(VADownloadState vADownloadState) {
        String str;
        VADownloadState vADownloadState2 = this.f346921h;
        if (vADownloadState2 == null) {
            return;
        }
        N(vADownloadState2);
        int i3 = vADownloadState.downloadStatus;
        if (i3 != 0 && 10 != this.f346921h.downloadStatus) {
            if (2 == i3 && vADownloadState.downloadScene != 1) {
                QMLog.i("VAFloatingViewControl", "checkStartDownload downloading but scene is:" + vADownloadState.downloadScene);
                M(true, true);
            } else {
                this.f346922i = false;
                if (2 != i3 && 9 != i3 && D()) {
                    VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
                    if (vAFloatDownloadTips != null) {
                        vAFloatDownloadTips.updateState(2);
                    }
                    M(true, true);
                    QMLog.i("VAFloatingViewControl", "checkStartDownload startDownload continue gameId:" + this.f346921h.gameId + " isDownloadFromInit:" + this.f346922i);
                }
            }
        } else {
            this.f346922i = true;
            if (1 == vADownloadState.autoDownload && D()) {
                VAFloatDownloadTips vAFloatDownloadTips2 = this.f346920f;
                if (vAFloatDownloadTips2 != null) {
                    vAFloatDownloadTips2.updateState(2);
                }
                M(true, true);
                QMLog.i("VAFloatingViewControl", "checkStartDownload startDownload init gameId:" + this.f346921h.gameId + " isDownloadFromInit:" + this.f346922i);
            }
        }
        if (this.f346920f != null) {
            s();
            this.f346920f.bringToFront();
            this.f346920f.setGameVersionCode(this.f346921h.gameVersionCode);
            this.f346920f.show(D(), this.C, this.f346921h.gameId);
            HashMap hashMap = new HashMap();
            hashMap.put("ext6", this.f346921h.gameVersionCode);
            String str2 = "1";
            if (!D()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("ext7", str);
            hashMap.put("ext8", "1");
            if (this.f346923m != 1) {
                str2 = "2";
            }
            hashMap.put("ext29", str2);
            com.tencent.qqmini.minigame.yungame.va.d.b("929207", "8", this.f346921h.gameId, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (q()) {
            VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
            if (vAFloatDownloadTips != null) {
                vAFloatDownloadTips.updateState(7);
            }
            J();
        } else {
            VAFloatDownloadTips vAFloatDownloadTips2 = this.f346920f;
            if (vAFloatDownloadTips2 != null) {
                vAFloatDownloadTips2.updateState(4);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ext6", this.f346921h.gameVersionCode);
        String str = "1";
        hashMap.put("ext8", "1");
        if (this.f346923m != 1) {
            str = "2";
        }
        hashMap.put("ext29", str);
        com.tencent.qqmini.minigame.yungame.va.d.b("929211", "8", this.f346921h.gameId, hashMap);
    }

    private void w() {
        QMLog.w("VAFloatingViewControl", "downloadComplete");
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy == null) {
            return;
        }
        this.D = null;
        VADownloadState vADownloadState = this.f346921h;
        if (vADownloadState != null) {
            virtualAppProxy.unregisterHotfixDownloadCallback(vADownloadState.gameId, this.J);
            virtualAppProxy.removeDownloadListener(this.f346921h.gameId, this.I);
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.updateDownloadProcess(x(100, 100));
        }
        this.L.sendEmptyMessage(261);
    }

    private int x(int i3, int i16) {
        return (int) ((i3 * 0.75f) + (i16 * 0.24f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16) {
        VAFloatDownloadTips vAFloatDownloadTips;
        if (QMLog.isColorLevel()) {
            QMLog.i("VAFloatingViewControl", "handleNetworkChange hasNet:$hasNet");
        }
        if (!z16 || this.f346921h == null || (vAFloatDownloadTips = this.f346920f) == null || vAFloatDownloadTips.getVisibility() != 0 || ((VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class)) == null) {
            return;
        }
        boolean D = D();
        this.H.c(D);
        this.f346920f.updateWifiState(D);
        if (!D && B()) {
            QMLog.i("VAFloatingViewControl", "stop when net type not wifi");
            z(false, true);
        } else if (D && !B()) {
            if (this.D != null) {
                L(true);
            } else if (this.f346921h != null) {
                M(true, true);
            }
        }
    }

    private void z(boolean z16, boolean z17) {
        QMLog.d("VAFloatingViewControl", "handleStopDownload currentDownloadState:" + this.f346921h + ", tips:" + this.f346920f);
        if (this.f346921h == null) {
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null && z17) {
            vAFloatDownloadTips.updateState(3);
            if (z16) {
                this.f346920f.setVisibility(8);
                this.f346920f = null;
            }
        }
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (this.D == null) {
            virtualAppProxy.stopDownload(this.f346921h.gameId, null);
        } else {
            virtualAppProxy.pauseHotfixDownload(this.f346921h.gameId);
        }
    }

    public void E() {
        this.L.removeCallbacksAndMessages(null);
        QMLog.i("VAFloatingViewControl", "onDestroy mCurrentDownloadState:" + this.f346921h);
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy == null) {
            return;
        }
        this.D = null;
        VADownloadState vADownloadState = this.f346921h;
        if (vADownloadState != null) {
            virtualAppProxy.unregisterHotfixDownloadCallback(vADownloadState.gameId, this.J);
            virtualAppProxy.removeDownloadListener(this.f346921h.gameId, this.I);
        }
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            qQCustomizedProxy.clearNetEventHandler(this.f346919e.getContext());
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.onDestroy();
        }
    }

    public void F(GameLoadingStatus gameLoadingStatus) {
        if (QMLog.isColorLevel()) {
            QMLog.d("VAFloatingViewControl", "onGameEvent status:" + gameLoadingStatus.getStatusDesc());
        }
        int statusCode = gameLoadingStatus.getStatusCode();
        if (statusCode != GameLoadingStatus.Guide_Finished_When_EnterFarm.getStatusCode() && statusCode != GameLoadingStatus.Guide_On_Fram_Guide_Finished.getStatusCode()) {
            return;
        }
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy != null && virtualAppProxy.queryDownloadIgnoreGameEvent(this.f346918d.appId)) {
            QMLog.w("VAFloatingViewControl", "onGameEvent queryDownloadIgnoreGameEvent break");
            return;
        }
        this.f346923m = 2;
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips == null) {
            A(2);
            u();
        } else {
            vAFloatDownloadTips.setScene(2);
        }
    }

    public void G() {
        if (QMLog.isColorLevel()) {
            QMLog.d("VAFloatingViewControl", "onGameScreenReady");
        }
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy != null && virtualAppProxy.queryDownloadIgnoreGameEvent(this.f346918d.appId)) {
            QMLog.w("VAFloatingViewControl", "onGameScreenReady ignore game event");
            this.f346923m = 2;
            VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
            if (vAFloatDownloadTips == null) {
                A(2);
                u();
            } else {
                vAFloatDownloadTips.setScene(2);
            }
        }
    }

    public void H(Intent intent) {
        VAFloatDownloadTips vAFloatDownloadTips;
        QMLog.i("VAFloatingViewControl", "onIntentUpdate:" + this.f346921h);
        if (this.E || (((vAFloatDownloadTips = this.f346920f) != null && vAFloatDownloadTips.getVisibility() != 0) || C(this.f346921h))) {
            u();
            this.D = null;
        }
    }

    public void I() {
        if (QMLog.isColorLevel()) {
            QMLog.d("VAFloatingViewControl", "onQueue, isFirstOnQueue:" + this.F.get());
        }
        if (this.F.compareAndSet(false, true)) {
            this.f346923m = 1;
            VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
            if (vAFloatDownloadTips == null) {
                A(1);
                u();
            } else {
                vAFloatDownloadTips.setScene(1);
                this.f346920f.bringToFront();
            }
        }
    }

    public void K() {
        QMLog.i("VAFloatingViewControl", "showVAFloatDownloadTips");
        if (this.f346920f == null) {
            this.f346923m = 2;
            A(2);
            u();
            t(this.f346921h);
        }
    }

    public void P(MenuButtonRect menuButtonRect) {
        this.C = menuButtonRect;
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onCancelClick() {
        QMLog.d("VAFloatingViewControl", "onCancelClick currentDownloadState:" + this.f346921h + ", tips:" + this.f346920f);
        if (this.f346921h == null) {
            return;
        }
        z(true, true);
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onContinueClick() {
        QMLog.d("VAFloatingViewControl", "onContinueClick currentDownloadState:" + this.f346921h + ", tips:" + this.f346920f);
        if (this.f346921h == null) {
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.updateState(2);
        }
        if (this.D == null) {
            M(false, true);
        } else {
            L(false);
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onDualChannelSwitch() {
        z(false, false);
        this.G.set(true);
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.yungame.va.VAFloatingViewControl.7
            @Override // java.lang.Runnable
            public void run() {
                VAFloatingViewControl.this.M(true, false);
            }
        }, 200L);
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onRestartClick() {
        QMLog.d("VAFloatingViewControl", "onRestartClick currentDownloadState:" + this.f346921h + ", tips:" + this.f346920f);
        if (this.f346921h == null) {
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.updateState(7);
            this.f346920f.resetDownloadProcess();
        }
        J();
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onRetryClick() {
        QMLog.d("VAFloatingViewControl", "onRetryClick currentDownloadState:" + this.f346921h + ", tips:" + this.f346920f);
        if (this.f346921h == null) {
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.updateState(2);
        }
        if (this.D == null) {
            M(false, true);
        } else {
            L(false);
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onStartDownloadClick() {
        QMLog.d("VAFloatingViewControl", "onStartDownloadClick currentDownloadState:" + this.f346921h + ", tips:" + this.f346920f);
        if (this.f346921h == null) {
            return;
        }
        VAFloatDownloadTips vAFloatDownloadTips = this.f346920f;
        if (vAFloatDownloadTips != null) {
            vAFloatDownloadTips.updateState(2);
        }
        if (this.D == null) {
            M(false, true);
        } else {
            L(false);
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onStopClick() {
        QMLog.d("VAFloatingViewControl", "onStopClick currentDownloadState:" + this.f346921h + ", tips:" + this.f346920f);
        if (this.f346921h == null) {
            return;
        }
        z(false, true);
    }

    public void u() {
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy == null) {
            QMLog.i("VAFloatingViewControl", "checkVADownload virtualAppProxy == null");
            return;
        }
        if (QMLog.isColorLevel()) {
            QMLog.d("VAFloatingViewControl", "checkVADownload");
        }
        this.L.sendEmptyMessageDelayed(259, 30000L);
        virtualAppProxy.queryDownloadState(this.f346918d.appId, new d(virtualAppProxy));
    }
}
