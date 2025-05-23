package com.tencent.biz.qqcircle.immersive.feed.live.od.trtc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTRTCEngineHelper {

    /* renamed from: g, reason: collision with root package name */
    private static volatile QFSTRTCEngineHelper f86345g;

    /* renamed from: b, reason: collision with root package name */
    private long f86347b = -1;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Long, com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.b> f86348c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Long, WeakReference<com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a>> f86349d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final ITRTCRoomListener f86350e = new a();

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    private final ITRTCRemoteListener f86351f = new b();

    /* renamed from: a, reason: collision with root package name */
    private final ITRTCEngineApi f86346a = (ITRTCEngineApi) QRoute.api(ITRTCEngineApi.class);

    QFSTRTCEngineHelper() {
    }

    public static QFSTRTCEngineHelper i() {
        if (f86345g == null) {
            synchronized (QFSTRTCEngineHelper.class) {
                if (f86345g == null) {
                    f86345g = new QFSTRTCEngineHelper();
                }
            }
        }
        return f86345g;
    }

    private void l() {
        Iterator<Map.Entry<Long, com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.b>> it = this.f86348c.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.b value = it.next().getValue();
            if (value.b()) {
                this.f86346a.removeRoomListener(value);
            }
        }
    }

    public void f(long j3, com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a aVar) {
        Iterator<Map.Entry<Long, WeakReference<com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a>>> it = this.f86349d.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().get() == aVar) {
                return;
            }
        }
        this.f86349d.put(Long.valueOf(j3), new WeakReference<>(aVar));
    }

    public void g(QQLiveRoomParams qQLiveRoomParams) {
        this.f86347b = qQLiveRoomParams.getRoomId();
        this.f86346a.muteAllRemoteAudio(true);
        this.f86346a.enterRoom(qQLiveRoomParams);
    }

    public void h() {
        this.f86346a.stopAudio();
        this.f86346a.exitRoom();
    }

    public void j(Context context, final TRTCInitCallback tRTCInitCallback) {
        this.f86346a.initEngine(context, "0", new TRTCInitCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.QFSTRTCEngineHelper.3
            @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
            public void onInitEvent(final int i3, final int i16) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.QFSTRTCEngineHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.i("TRTCEngineHelper", 1, "trtc init result:" + i3 + ", code:" + i16);
                        if (i3 == 2) {
                            QFSTRTCEngineHelper.this.f86346a.addRoomListener(QFSTRTCEngineHelper.this.f86350e);
                            QFSTRTCEngineHelper.this.f86346a.setTRTCRemoteListener(QFSTRTCEngineHelper.this.f86351f);
                        }
                        TRTCInitCallback tRTCInitCallback2 = tRTCInitCallback;
                        if (tRTCInitCallback2 != null) {
                            tRTCInitCallback2.onInitEvent(i3, i16);
                        }
                    }
                });
            }
        });
    }

    public boolean k() {
        return this.f86346a.isEngineReady();
    }

    public void m(long j3) {
        this.f86349d.remove(Long.valueOf(j3));
    }

    public void n(long j3, ITRTCRoomListener iTRTCRoomListener) {
        com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.b bVar = null;
        for (Map.Entry<Long, com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.b> entry : this.f86348c.entrySet()) {
            if (entry.getValue().a(iTRTCRoomListener)) {
                bVar = entry.getValue();
            }
        }
        if (bVar == null) {
            bVar = new com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.b(iTRTCRoomListener);
        }
        this.f86348c.put(Long.valueOf(j3), bVar);
        this.f86346a.addRoomListener(bVar);
        l();
    }

    public void o() {
        this.f86348c.clear();
        this.f86349d.clear();
        this.f86346a.clearRoomListener();
        this.f86346a.destroyEngine();
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements ITRTCRoomListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEnterRoom(long j3, String str) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("TRTCEngineHelper", "onEnterRoom errorCode:" + j3 + " msg:" + str);
            if (j3 > 0) {
                QFSTRTCEngineHelper.this.f86346a.muteAllRemoteAudio(false);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEvent(int i3, int i16, String str, Bundle bundle) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("TRTCEngineHelper", "onEvent eventId:" + i3 + " errorCode:" + i16 + " message:" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onExitRoom(int i3) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("TRTCEngineHelper", "onExitRoom reason:" + i3);
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalAudioFrameSent() {
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalVideoFrameSent(int i3) {
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserEnterRoom(String str) {
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserLeaveRoom(String str, int i3) {
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onSwitchRoom(int i3, String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements ITRTCRemoteListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onConnectOtherRoom(String str, int i3, String str2) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.a(this, str, i3, str2);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onDisConnectOtherRoom(int i3, String str) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.b(this, i3, str);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onFirstAudioFrame(String str) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onFirstVideoFrame(String str, int i3, int i16, int i17) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.d(this, str, i3, i16, i17);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public /* synthetic */ void onNetworkQuality(QQLiveQuality qQLiveQuality, ArrayList arrayList) {
            com.tencent.mobileqq.qqlive.listener.trtc.a.e(this, qQLiveQuality, arrayList);
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserVoiceVolume(ArrayList<RemoteUserAudioInfo> arrayList, int i3) {
            WeakReference weakReference;
            com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a aVar;
            if (QFSTRTCEngineHelper.this.f86347b != -1 && (weakReference = (WeakReference) QFSTRTCEngineHelper.this.f86349d.get(Long.valueOf(QFSTRTCEngineHelper.this.f86347b))) != null && (aVar = (com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a) weakReference.get()) != null) {
                aVar.onUserVoiceVolume(arrayList, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserAudioAvailable(String str, boolean z16) {
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserSei(String str, byte[] bArr) {
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserVideoAvailable(String str, boolean z16) {
        }
    }
}
