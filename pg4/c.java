package pg4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.component.qqlive.impl.anchor.QQLiveEndLiveEventByAdmin;
import com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static c f426190f;

    /* renamed from: a, reason: collision with root package name */
    private final LiveRoomStatusListener f426191a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final RoomAudienceInfoListener f426192b = new b();

    /* renamed from: c, reason: collision with root package name */
    private final ReceiveGiftMessageListener f426193c = new C11017c();

    /* renamed from: d, reason: collision with root package name */
    private final AudienceRoomPlayerListener f426194d = new d();

    /* renamed from: e, reason: collision with root package name */
    private final ILiveRoom f426195e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements LiveRoomStatusListener {

        /* compiled from: P */
        /* renamed from: pg4.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C11016a implements IResultListener<EndPageRealTimeInfo> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QQLiveRoomStatusInfo f426197a;

            C11016a(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
                this.f426197a = qQLiveRoomStatusInfo;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable EndPageRealTimeInfo endPageRealTimeInfo) {
                SimpleEventBus.getInstance().dispatchEvent(new QQLiveEndLiveEventByAdmin(endPageRealTimeInfo, this.f426197a.closeReason));
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                SimpleEventBus.getInstance().dispatchEvent(new QQLiveEndLiveEventByAdmin(new EndPageRealTimeInfo(), this.f426197a.closeReason));
            }
        }

        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomClose(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            l.e("TgLiveTag_TgLiveRoomListenerHandler", "onRoomClose, closeType:" + qQLiveRoomStatusInfo.closeType + " closeReason:" + qQLiveRoomStatusInfo.closeReason + " uin = " + qQLiveRoomStatusInfo.uin);
            if (((Boolean) ko4.b.a(pg4.d.b().d(), Boolean.FALSE)).booleanValue() && lg4.b.E().G().getAnchorInfo().getAnchorUid() == qQLiveRoomStatusInfo.uin) {
                TGLiveFloatManager.f377649d.l();
                lg4.b.E().t(new C11016a(qQLiveRoomStatusInfo));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomOpen(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            l.i("TgLiveTag_TgLiveRoomListenerHandler", "onRoomOpen");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomPause(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            l.i("TgLiveTag_TgLiveRoomListenerHandler", "onRoomPause");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomResume(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            l.i("TgLiveTag_TgLiveRoomListenerHandler", "onRoomResume");
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements RoomAudienceInfoListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onAudienceEnterRoom(LiveMessageData.SpeakerInfo speakerInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("TgLiveTag_TgLiveRoomListenerHandler", 1, "onAudienceEnterRoom, speakId=" + speakerInfo.mSpeakId + " speakName=" + speakerInfo.mSpeakerName);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onRecAudienceInfo(RoomAudienceInfo roomAudienceInfo) {
            if (QLog.isColorLevel() && roomAudienceInfo != null) {
                QLog.d("TgLiveTag_TgLiveRoomListenerHandler", 1, "onRecAudienceInfo fakeTotalPeople=" + roomAudienceInfo.fakeTotalPeople + " userCount=" + roomAudienceInfo.userCount);
            }
            if (roomAudienceInfo != null) {
                pg4.d.b().h(roomAudienceInfo.userCount);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: pg4.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11017c implements ReceiveGiftMessageListener {
        C11017c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onError(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("TgLiveTag_TgLiveRoomListenerHandler", 1, "onError,", Integer.valueOf(i3), "+ msg: ", str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onGiftMessageReceive(GiftMessage giftMessage) {
            if (QLog.isColorLevel()) {
                QLog.d("TgLiveTag_TgLiveRoomListenerHandler", 1, "onGiftMessageReceive," + giftMessage.toString());
            }
            c.this.c(giftMessage);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d extends ng4.a {
        d() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onError(int i3, int i16, int i17, String str) {
            QLog.e("TgLiveTag_TgLiveRoomListenerHandler", 1, "[onError] module=" + i3 + ", errorType=" + i16 + ", errorCode=" + i17 + ", extraInfo" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onFirstFrameCome(long j3, long j16) {
            QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onFirstFrameCome");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPlayCompleted() {
            QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onStartBuffer() {
            QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStartBuffer");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onStopBuffer() {
            QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onVideoSizeChanged(int i3, int i16) {
            boolean z16 = true;
            QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onVideoSizeChanged,w:" + i3 + " h:" + i16);
            pg4.d b16 = pg4.d.b();
            if (i3 < i16) {
                z16 = false;
            }
            b16.k(Boolean.valueOf(z16));
            lg4.b.E().O(i3, i16);
        }
    }

    public c(@NonNull ILiveRoom iLiveRoom) {
        this.f426195e = iLiveRoom;
    }

    private void b() {
        ILiveRoom iLiveRoom = this.f426195e;
        if (iLiveRoom == null) {
            QLog.e("TgLiveTag_TgLiveRoomListenerHandler", 1, "mLiveRoom is null.");
            return;
        }
        iLiveRoom.unRegisterAudienceInfoListener(this.f426192b);
        this.f426195e.unRegisterReceiveGiftMessageListener(this.f426193c);
        this.f426195e.unRegisterRoomStatusListener(this.f426191a);
        ILiveRoom iLiveRoom2 = this.f426195e;
        if (iLiveRoom2 instanceof ILiveTPPlayerRoom) {
            ((ILiveTPPlayerRoom) iLiveRoom2).unRegisterRoomPlayerListener(this.f426194d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GiftMessage giftMessage) {
        if (giftMessage == null) {
            QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "giftMessage == null");
        } else {
            pg4.d.b().e(giftMessage);
        }
    }

    private void d() {
        this.f426195e.registerAudienceInfoListener(this.f426192b);
        this.f426195e.registerReceiveGiftMessageListener(this.f426193c);
        this.f426195e.registerRoomStatusListener(this.f426191a);
        ILiveRoom iLiveRoom = this.f426195e;
        if (iLiveRoom instanceof ILiveTPPlayerRoom) {
            ((ILiveTPPlayerRoom) iLiveRoom).registerRoomPlayerListener(this.f426194d);
        }
    }

    public static void e(ILiveRoom iLiveRoom) {
        synchronized (c.class) {
            if (f426190f == null) {
                c cVar = new c(iLiveRoom);
                f426190f = cVar;
                cVar.d();
            }
        }
    }

    public static void f() {
        synchronized (c.class) {
            c cVar = f426190f;
            if (cVar != null) {
                cVar.b();
                f426190f = null;
            }
        }
    }
}
