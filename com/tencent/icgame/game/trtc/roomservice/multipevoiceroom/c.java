package com.tencent.icgame.game.trtc.roomservice.multipevoiceroom;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.icgame.game.utils.g;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private TRTCCloud f115858a;

    /* renamed from: b, reason: collision with root package name */
    private final String f115859b;

    /* renamed from: c, reason: collision with root package name */
    private final String f115860c;

    /* renamed from: n, reason: collision with root package name */
    private TRTCCloudListener f115871n;

    /* renamed from: d, reason: collision with root package name */
    private int f115861d = 21;

    /* renamed from: e, reason: collision with root package name */
    private boolean f115862e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f115863f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f115864g = true;

    /* renamed from: h, reason: collision with root package name */
    private int f115865h = 100;

    /* renamed from: i, reason: collision with root package name */
    private zx0.a f115866i = new zx0.a();

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f115867j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> f115868k = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    final MutableLiveData<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> f115869l = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private ay0.a f115870m = new ay0.a();

    /* renamed from: o, reason: collision with root package name */
    private final MutableLiveData<ConcurrentHashMap<String, Integer>> f115872o = new MutableLiveData<>();

    /* renamed from: p, reason: collision with root package name */
    private final MutableLiveData<Boolean> f115873p = new MutableLiveData<>();

    /* renamed from: q, reason: collision with root package name */
    private final MutableLiveData<Boolean> f115874q = new MutableLiveData<>();

    /* renamed from: r, reason: collision with root package name */
    private final MutableLiveData<Boolean> f115875r = new MutableLiveData<>();

    /* renamed from: s, reason: collision with root package name */
    private final MutableLiveData<Integer> f115876s = new MutableLiveData<>();

    /* renamed from: t, reason: collision with root package name */
    private final MutableLiveData<zx0.a> f115877t = new a();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a extends MutableLiveData<zx0.a> {
        a() {
            setValue(c.this.f115866i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b extends ay0.b {
        b(ay0.a aVar) {
            super(aVar);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.trtc.roomservice.multipevoiceroom.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C5845c extends TRTCCloudListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f115880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TRTCCloud f115881b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f115882c;

        C5845c(String str, TRTCCloud tRTCCloud, String str2) {
            this.f115880a = str;
            this.f115881b = tRTCCloud;
            this.f115882c = str2;
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionLost() {
            super.onConnectionLost();
            c.this.n(1);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionRecovery() {
            super.onConnectionRecovery();
            c.this.n(0);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onEnterRoom(long j3) {
            super.onEnterRoom(j3);
            c.this.n(0);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onError(int i3, String str, Bundle bundle) {
            super.onError(i3, str, bundle);
            g.d("ICGameTRTCMultipeVoiceRoom", "TRTCListenerOnError roomID:" + this.f115882c + " errCode:" + i3 + " msg:" + str);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onExitRoom(int i3) {
            super.onExitRoom(i3);
            c.this.n(4);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserEnterRoom(String str) {
            super.onRemoteUserEnterRoom(str);
            g.a("ICGameTRTCMultipeVoiceRoom", "onRemoteUserEnterRoom uid: " + str);
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
            c.this.n(2);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserSubStreamAvailable(String str, boolean z16) {
            super.onUserSubStreamAvailable(str, z16);
            g.a("ICGameTRTCMultipeVoiceRoom", "onUserSubStreamAvailable uid: " + str + " " + z16);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVideoAvailable(String str, boolean z16) {
            super.onUserVideoAvailable(str, z16);
            g.a("ICGameTRTCMultipeVoiceRoom", "onUserVideoAvailable uid: " + str + " " + z16);
            if (z16) {
                d.h().q(this.f115882c, str);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i3) {
            super.onUserVoiceVolume(arrayList, i3);
            c.this.f115867j.clear();
            Iterator<TRTCCloudDef.TRTCVolumeInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TRTCCloudDef.TRTCVolumeInfo next = it.next();
                if (next.userId.equals(this.f115880a)) {
                    if (c.this.f115862e && !c.this.f115864g) {
                        c.this.f115867j.put(next.userId, Integer.valueOf(next.volume));
                    }
                } else {
                    c.this.f115867j.put(next.userId, Integer.valueOf(next.volume));
                }
                this.f115881b.setRemoteAudioVolume(next.userId, c.this.f115865h);
            }
            c.this.f115868k.put(this.f115882c, c.this.f115867j);
            if (c.this.f115869l.hasObservers()) {
                c cVar = c.this;
                cVar.f115869l.setValue(cVar.f115868k);
            }
            if (c.this.f115872o.hasObservers()) {
                c.this.f115872o.setValue(c.this.f115867j);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onWarning(int i3, String str, Bundle bundle) {
            super.onWarning(i3, str, bundle);
            g.j("ICGameTRTCMultipeVoiceRoom", "TRTCListenerOnError roomID:" + this.f115882c + " errCode:" + i3 + " msg:" + str);
        }
    }

    public c(TRTCCloud tRTCCloud, String str, String str2) {
        this.f115858a = tRTCCloud;
        this.f115859b = str;
        this.f115860c = str2;
        tRTCCloud.enableAudioVolumeEvaluation(300);
        tRTCCloud.setListener(new b(this.f115870m));
        ay0.a aVar = this.f115870m;
        C5845c c5845c = new C5845c(str2, tRTCCloud, str);
        this.f115871n = c5845c;
        aVar.M(c5845c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3) {
        this.f115866i.f453654a = i3;
        g.h("ICGameTRTCMultipeVoiceRoom", "setRoomState:" + this.f115866i.a() + " roomID" + this.f115859b);
        this.f115877t.setValue(this.f115866i);
        d.h().s();
    }

    public String i() {
        return this.f115859b;
    }

    public TRTCCloud j() {
        return this.f115858a;
    }

    public boolean k() {
        return this.f115864g;
    }

    public boolean l() {
        return this.f115863f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z16) {
        this.f115864g = z16;
        this.f115875r.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z16) {
        this.f115863f = z16;
        this.f115874q.setValue(Boolean.valueOf(z16));
    }

    @NotNull
    public String toString() {
        return "TRTCMultipeVoiceRoom{roomID='" + this.f115859b + "', userID='" + this.f115860c + "', role=" + this.f115861d + ", isOnMicPosition=" + this.f115862e + ", isSpeakerMute=" + this.f115863f + ", isMicMute=" + this.f115864g + ", volume=" + this.f115865h + ", roomState=" + this.f115866i.a() + '}';
    }
}
