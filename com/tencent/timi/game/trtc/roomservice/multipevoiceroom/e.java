package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.timi.game.utils.l;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private TRTCCloud f380008a;

    /* renamed from: b, reason: collision with root package name */
    private final String f380009b;

    /* renamed from: c, reason: collision with root package name */
    private final String f380010c;

    /* renamed from: n, reason: collision with root package name */
    private TRTCCloudListener f380021n;

    /* renamed from: d, reason: collision with root package name */
    private int f380011d = 21;

    /* renamed from: e, reason: collision with root package name */
    private boolean f380012e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f380013f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f380014g = true;

    /* renamed from: h, reason: collision with root package name */
    private int f380015h = 100;

    /* renamed from: i, reason: collision with root package name */
    private sn4.a f380016i = new sn4.a();

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f380017j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> f380018k = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    final MutableLiveData<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> f380019l = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private tn4.a f380020m = new tn4.a();

    /* renamed from: o, reason: collision with root package name */
    private final MutableLiveData<ConcurrentHashMap<String, Integer>> f380022o = new MutableLiveData<>();

    /* renamed from: p, reason: collision with root package name */
    private final MutableLiveData<Boolean> f380023p = new MutableLiveData<>();

    /* renamed from: q, reason: collision with root package name */
    private final MutableLiveData<Boolean> f380024q = new MutableLiveData<>();

    /* renamed from: r, reason: collision with root package name */
    private final MutableLiveData<Boolean> f380025r = new MutableLiveData<>();

    /* renamed from: s, reason: collision with root package name */
    private final MutableLiveData<Integer> f380026s = new MutableLiveData<>();

    /* renamed from: t, reason: collision with root package name */
    private final MutableLiveData<sn4.a> f380027t = new a();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends MutableLiveData<sn4.a> {
        a() {
            setValue(e.this.f380016i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b extends tn4.b {
        b(tn4.a aVar) {
            super(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c extends TRTCCloudListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380030a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TRTCCloud f380031b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f380032c;

        c(String str, TRTCCloud tRTCCloud, String str2) {
            this.f380030a = str;
            this.f380031b = tRTCCloud;
            this.f380032c = str2;
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionLost() {
            super.onConnectionLost();
            e.this.t(1);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionRecovery() {
            super.onConnectionRecovery();
            e.this.t(0);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onEnterRoom(long j3) {
            super.onEnterRoom(j3);
            e.this.t(0);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onError(int i3, String str, Bundle bundle) {
            super.onError(i3, str, bundle);
            l.e("TRTCMultipeVoiceRoom", "TRTCListenerOnError roomID:" + this.f380032c + " errCode:" + i3 + " msg:" + str);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onExitRoom(int i3) {
            super.onExitRoom(i3);
            e.this.t(4);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserEnterRoom(String str) {
            super.onRemoteUserEnterRoom(str);
            l.b("TRTCMultipeVoiceRoom", "onRemoteUserEnterRoom uid: " + str);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserLeaveRoom(String str, int i3) {
            super.onRemoteUserLeaveRoom(str, i3);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onScreenCapturePaused() {
            super.onScreenCapturePaused();
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onScreenCaptureResumed() {
            super.onScreenCaptureResumed();
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onScreenCaptureStarted() {
            super.onScreenCaptureStarted();
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onScreenCaptureStopped(int i3) {
            super.onScreenCaptureStopped(i3);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onSendFirstLocalVideoFrame(int i3) {
            super.onSendFirstLocalVideoFrame(i3);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onStartPublishing(int i3, String str) {
            super.onStartPublishing(i3, str);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onTryToReconnect() {
            super.onTryToReconnect();
            e.this.t(2);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserSubStreamAvailable(String str, boolean z16) {
            super.onUserSubStreamAvailable(str, z16);
            l.b("TRTCMultipeVoiceRoom", "onUserSubStreamAvailable uid: " + str + " " + z16);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVideoAvailable(String str, boolean z16) {
            super.onUserVideoAvailable(str, z16);
            l.b("TRTCMultipeVoiceRoom", "onUserVideoAvailable uid: " + str + " " + z16);
            if (z16) {
                f.u().y(this.f380032c, str);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i3) {
            super.onUserVoiceVolume(arrayList, i3);
            e.this.f380017j.clear();
            Iterator<TRTCCloudDef.TRTCVolumeInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TRTCCloudDef.TRTCVolumeInfo next = it.next();
                if (next.userId.equals(this.f380030a)) {
                    if (e.this.f380012e && !e.this.f380014g) {
                        e.this.f380017j.put(next.userId, Integer.valueOf(next.volume));
                    }
                } else {
                    e.this.f380017j.put(next.userId, Integer.valueOf(next.volume));
                }
                this.f380031b.setRemoteAudioVolume(next.userId, e.this.f380015h);
            }
            e.this.f380018k.put(this.f380032c, e.this.f380017j);
            if (e.this.f380019l.hasObservers()) {
                e eVar = e.this;
                eVar.f380019l.setValue(eVar.f380018k);
            }
            if (e.this.f380022o.hasObservers()) {
                e.this.f380022o.setValue(e.this.f380017j);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onWarning(int i3, String str, Bundle bundle) {
            super.onWarning(i3, str, bundle);
            l.m("TRTCMultipeVoiceRoom", "TRTCListenerOnError roomID:" + this.f380032c + " errCode:" + i3 + " msg:" + str);
        }
    }

    public e(TRTCCloud tRTCCloud, String str, String str2) {
        this.f380008a = tRTCCloud;
        this.f380009b = str;
        this.f380010c = str2;
        tRTCCloud.enableAudioVolumeEvaluation(300);
        tRTCCloud.setListener(new b(this.f380020m));
        tn4.a aVar = this.f380020m;
        c cVar = new c(str2, tRTCCloud, str);
        this.f380021n = cVar;
        aVar.M(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        this.f380016i.f434005a = i3;
        l.i("TRTCMultipeVoiceRoom", "setRoomState:" + this.f380016i.a() + " roomID" + this.f380009b);
        this.f380027t.setValue(this.f380016i);
        f.u().A();
    }

    public String i() {
        return this.f380009b;
    }

    public MutableLiveData<Boolean> j() {
        return this.f380025r;
    }

    public MutableLiveData<Boolean> k() {
        return this.f380024q;
    }

    public MutableLiveData<ConcurrentHashMap<String, Integer>> l() {
        return this.f380022o;
    }

    public MutableLiveData<sn4.a> m() {
        return this.f380027t;
    }

    public TRTCCloud n() {
        return this.f380008a;
    }

    public boolean o() {
        return this.f380014g;
    }

    public boolean p() {
        return this.f380013f;
    }

    public void q(TRTCCloudListener tRTCCloudListener) {
        this.f380020m.M(tRTCCloudListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z16) {
        this.f380014g = z16;
        this.f380025r.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z16) {
        this.f380012e = z16;
        this.f380023p.setValue(Boolean.valueOf(z16));
    }

    @NotNull
    public String toString() {
        return "TRTCMultipeVoiceRoom{roomID='" + this.f380009b + "', userID='" + this.f380010c + "', role=" + this.f380011d + ", isOnMicPosition=" + this.f380012e + ", isSpeakerMute=" + this.f380013f + ", isMicMute=" + this.f380014g + ", volume=" + this.f380015h + ", roomState=" + this.f380016i.a() + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(boolean z16) {
        this.f380013f = z16;
        this.f380024q.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i3) {
        this.f380015h = i3;
        this.f380026s.setValue(Integer.valueOf(i3));
    }

    public void w(TRTCCloudListener tRTCCloudListener) {
        this.f380020m.N(tRTCCloudListener);
    }
}
