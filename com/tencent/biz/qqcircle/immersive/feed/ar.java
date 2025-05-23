package com.tencent.biz.qqcircle.immersive.feed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.events.QCircleShareItemClickEvent;
import com.tencent.biz.qqcircle.immersive.feed.ar;
import com.tencent.biz.qqcircle.immersive.feed.live.StartingShareEvent;
import com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.QFSTRTCEngineHelper;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import weprotocols.WEProtocolsVaslive$DatingRoomInfo;
import weprotocols.WEProtocolsVaslive$SeatUserList;
import weprotocols.WEProtocolsVaslive$TrtcInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ar extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private IAegisLogApi I;
    private FeedCloudMeta$StFeed J;
    private WEProtocolsVaslive$TrtcInfo K;
    private WEProtocolsVaslive$DatingRoomInfo L;
    private FeedCloudMeta$RoomInfoData M;
    private e N;
    private com.tencent.biz.qqcircle.immersive.feed.live.od.a P;
    private boolean Q;
    private long R;
    private boolean T;
    private boolean W;
    private int S = 0;
    private boolean U = false;
    private boolean V = false;
    private final ITRTCRoomListener X = new a();
    private final com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a Y = new b();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a {
        b() {
        }

        private boolean a(String str, ArrayList<RemoteUserAudioInfo> arrayList) {
            Iterator<RemoteUserAudioInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                RemoteUserAudioInfo next = it.next();
                if (TextUtils.equals(str, next.userId)) {
                    if (next.volume <= 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.trtc.a
        public void onUserVoiceVolume(ArrayList<RemoteUserAudioInfo> arrayList, int i3) {
            if (ar.this.P == null) {
                ar.this.I.w("QFSFeedChildODTrtcPresenter", "ODGameView is not inited !!");
                return;
            }
            if (ar.this.L != null && ar.this.L.seatUsers.get() != null) {
                for (WEProtocolsVaslive$SeatUserList wEProtocolsVaslive$SeatUserList : ar.this.L.seatUsers.get()) {
                    long j3 = wEProtocolsVaslive$SeatUserList.uid.get();
                    boolean a16 = a("" + j3, arrayList);
                    if (!ar.this.N.a("" + j3, a16)) {
                        ar.this.P.L(wEProtocolsVaslive$SeatUserList.seatNo.get(), a16);
                    }
                }
                return;
            }
            ar.this.I.w("QFSFeedChildODTrtcPresenter", "mDatingRoomInfo or seatUsers is not inited !!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends d {
        c() {
            super();
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.ar.d
        public void a(int i3) {
            super.a(i3);
            ar.this.V = false;
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.ar.d
        public void b() {
            ar.this.V = false;
            ar.this.q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d {
        d() {
        }

        public void a(int i3) {
            ar.this.I.i("QFSFeedChildODTrtcPresenter", "trtc sdk init fail! code:" + i3);
        }

        public void b() {
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, Boolean> f85988a = new HashMap();

        e() {
        }

        public boolean a(String str, boolean z16) {
            Boolean bool = this.f85988a.get(str);
            if (bool == null || z16 != bool.booleanValue()) {
                return false;
            }
            return true;
        }
    }

    @Nullable
    private QQLiveRoomParams p1() {
        if (this.J == null) {
            this.I.w("QFSFeedChildODTrtcPresenter", "StFeed is null!!");
            return null;
        }
        if (this.K == null) {
            this.I.w("QFSFeedChildODTrtcPresenter", "trtc info is null !!");
            return null;
        }
        QQLiveRoomParams.Builder builder = new QQLiveRoomParams.Builder();
        String str = "" + this.R;
        builder.setUserId(str).setRoomId(this.M.roomId.get()).setRoleType(1).setScene(1).setUserSig(this.K.sig.get());
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        if (this.W) {
            this.I.i("QFSFeedChildODTrtcPresenter", com.dataline.util.j.d("\u5c0f\u4e16\u754c activity destroy!!"));
            return;
        }
        if (!this.T && !this.U) {
            this.I.i("QFSFeedChildODTrtcPresenter", "\u6ca1\u6709\u8c03\u7528onSelect or Resume");
            return;
        }
        if (!E0()) {
            this.I.i("QFSFeedChildODTrtcPresenter", "\u4e0d\u5728\u5c4f\u5e55\u4e0a\u663e\u793a,\u4e0d\u8fdb\u623f");
            return;
        }
        if (com.tencent.biz.qqcircle.immersive.feed.live.w.f(this.J, this.L)) {
            this.I.i("QFSFeedChildODTrtcPresenter", "\u76f4\u64ad\u5df2\u7ed3\u675f,\u4e0d\u8fdb\u623f");
            return;
        }
        int i3 = this.S;
        if (i3 != 2 && i3 != 1) {
            QQLiveRoomParams p16 = p1();
            if (p16 == null) {
                this.I.i("QFSFeedChildODTrtcPresenter", "QQLiveRoomParams is null!!");
                return;
            }
            this.I.i("QFSFeedChildODTrtcPresenter", "real enter trtc room");
            this.S = 1;
            QFSTRTCEngineHelper.i().g(p16);
            QFSTRTCEngineHelper.i().f(p16.getRoomId(), this.Y);
            return;
        }
        this.I.i("QFSFeedChildODTrtcPresenter", "\u5df2\u7ecf\u8fdb\u623f\u6216\u8005\u8fdb\u623f\u6210\u529f\uff0c\u4e0d\u7528\u518d\u6b21\u8fdb\u623f status:" + this.S);
    }

    private void r1() {
        if (!QFSTRTCEngineHelper.i().k()) {
            return;
        }
        this.S = 4;
        QFSTRTCEngineHelper.i().h();
        w1();
    }

    private com.tencent.biz.qqcircle.immersive.feed.live.od.a s1(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() > 0) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                KeyEvent.Callback childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof com.tencent.biz.qqcircle.immersive.feed.live.od.a) {
                    return (com.tencent.biz.qqcircle.immersive.feed.live.od.a) childAt;
                }
            }
        }
        return null;
    }

    private void t1(@Nullable final d dVar) {
        QFSTRTCEngineHelper.i().j(m0(), new TRTCInitCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.aq
            @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
            public final void onInitEvent(int i3, int i16) {
                ar.u1(ar.d.this, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u1(d dVar, int i3, int i16) {
        if (i3 == 2) {
            if (dVar != null) {
                dVar.b();
            }
        } else if (i3 == 3 && dVar != null) {
            dVar.a(i16);
        }
    }

    private void w1() {
        if (this.M != null) {
            QFSTRTCEngineHelper.i().m(this.M.roomId.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        if (QFSTRTCEngineHelper.i().k()) {
            q1();
        } else if (this.V) {
            this.I.i("QFSFeedChildODTrtcPresenter", "trtc \u6b63\u5728\u521d\u59cb\u5316");
        } else {
            this.V = true;
            t1(new c());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.W = false;
        this.I = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.N = new e();
        this.f85016f = view.findViewById(R.id.f40791fb);
        t1(null);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(StartingShareEvent.class);
        eventClass.add(QCircleShareItemClickEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        this.W = true;
        QFSTRTCEngineHelper.i().o();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.T = true;
        x1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        this.T = false;
        r1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        this.U = false;
        if (this.Q) {
            return;
        }
        r1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof StartingShareEvent) {
            this.I.i("QFSFeedChildODTrtcPresenter", "receive starting share panel even!!!");
            this.Q = true;
        } else if ((simpleBaseEvent instanceof QCircleShareItemClickEvent) && 2 == ((QCircleShareItemClickEvent) simpleBaseEvent).getAction()) {
            this.I.i("QFSFeedChildODTrtcPresenter", "receive KEY_SPECIFIED_FRIEND_SHARE_OPERATION");
            this.Q = true;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        this.U = true;
        this.Q = false;
        if (E0()) {
            x1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        w1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.J = feedCloudMeta$StFeed;
        FeedCloudMeta$RoomInfoData h16 = com.tencent.biz.qqcircle.immersive.feed.live.w.h(feedCloudMeta$StFeed);
        this.M = h16;
        if (h16 != null) {
            QFSTRTCEngineHelper.i().n(this.M.roomId.get(), this.X);
        }
        this.P = s1(this.f85016f);
        this.K = com.tencent.biz.qqcircle.immersive.feed.live.w.e(this.E);
        this.L = com.tencent.biz.qqcircle.immersive.feed.live.w.c(this.E);
        this.R = com.tencent.biz.qqcircle.immersive.feed.live.w.i(feedCloudMeta$StFeed);
        if (this.K == null) {
            this.I.w("QFSFeedChildODTrtcPresenter", "trtc info is null!! please check data");
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ap
            @Override // java.lang.Runnable
            public final void run() {
                ar.this.x1();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildODTrtcPresenter";
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements ITRTCRoomListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEnterRoom(long j3, String str) {
            if (j3 >= 0) {
                ar.this.I.i("QFSFeedChildODTrtcPresenter", "enterRoom success cost:" + j3);
                ar.this.S = 2;
                return;
            }
            if (!HostNetworkUtils.isNetworkAvailable()) {
                QCircleToast.i(QCircleToast.f91645e, R.string.f1920346e, 0);
            } else {
                QCircleToast.j(QCircleToast.f91645e, str, 0);
            }
            ar.this.I.w("QFSFeedChildODTrtcPresenter", "enterRoom fail code:" + j3 + " msg:" + str);
            ar.this.S = 3;
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onExitRoom(int i3) {
            if (i3 == 0) {
                ar.this.S = 5;
            } else {
                ar.this.S = 6;
            }
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

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEvent(int i3, int i16, String str, Bundle bundle) {
        }
    }
}
