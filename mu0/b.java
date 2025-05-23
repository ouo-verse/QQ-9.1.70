package mu0;

import androidx.annotation.NonNull;
import b32.e;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static b f417610f;

    /* renamed from: a, reason: collision with root package name */
    private final e f417611a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final a32.a f417612b = new C10806b();

    /* renamed from: c, reason: collision with root package name */
    private final v22.a f417613c = new c();

    /* renamed from: d, reason: collision with root package name */
    private final b32.a f417614d = new d();

    /* renamed from: e, reason: collision with root package name */
    private final ILiveRoom f417615e;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements e {
        a() {
        }

        @Override // b32.e
        public void onRoomClose(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            g.d("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", "onRoomClose, closeType:" + qQLiveRoomStatusInfo.closeType + " closeReason:" + qQLiveRoomStatusInfo.closeReason + " uin = " + qQLiveRoomStatusInfo.uin);
            ((Boolean) ko4.b.a(mu0.c.b().d(), Boolean.FALSE)).booleanValue();
        }

        @Override // b32.e
        public void onRoomOpen(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            g.h("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", "onRoomOpen");
        }

        @Override // b32.e
        public void onRoomPause(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            g.h("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", "onRoomPause");
        }

        @Override // b32.e
        public void onRoomResume(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            g.h("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", "onRoomResume");
        }
    }

    /* compiled from: P */
    /* renamed from: mu0.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C10806b implements a32.a {
        C10806b() {
        }

        @Override // a32.a
        public void a(LiveMessageData.SpeakerInfo speakerInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "onAudienceEnterRoom, speakId=" + speakerInfo.mSpeakId + " speakName=" + speakerInfo.mSpeakerName);
            }
        }

        @Override // a32.a
        public void onRecAudienceInfo(RoomAudienceInfo roomAudienceInfo) {
            if (roomAudienceInfo != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "onRecAudienceInfo fakeTotalPeople=" + roomAudienceInfo.fakeTotalPeople + " userCount=" + roomAudienceInfo.userCount);
                }
                mu0.c.b().h(roomAudienceInfo.userCount);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements v22.a {
        c() {
        }

        @Override // v22.a
        public void a(GiftMessage giftMessage) {
            if (QLog.isColorLevel()) {
                QLog.d("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "onGiftMessageReceive," + giftMessage.toString());
            }
            b.this.c(giftMessage);
        }

        @Override // v22.a
        public void onError(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "onError,", Integer.valueOf(i3), "+ msg: ", str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class d extends iu0.a {
        d() {
        }

        @Override // b32.a
        public void onError(int i3, int i16, int i17, String str) {
            QLog.e("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "[onError] module=" + i3 + ", errorType=" + i16 + ", errorCode=" + i17 + ", extraInfo" + str);
        }

        @Override // b32.a
        public void onFirstFrameCome(long j3, long j16) {
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onFirstFrameCome");
        }

        @Override // b32.a
        public void onPlayCompleted() {
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
        }

        @Override // b32.a
        public void onStartBuffer() {
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStartBuffer");
        }

        @Override // b32.a
        public void onStopBuffer() {
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer");
        }

        @Override // b32.a
        public void onVideoSizeChanged(int i3, int i16) {
            boolean z16 = true;
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onVideoSizeChanged,w:" + i3 + " h:" + i16);
            mu0.c b16 = mu0.c.b();
            if (i3 < i16) {
                z16 = false;
            }
            b16.k(Boolean.valueOf(z16));
        }
    }

    public b(@NonNull ILiveRoom iLiveRoom) {
        this.f417615e = iLiveRoom;
    }

    private void b() {
        this.f417615e.unRegisterAudienceInfoListener(this.f417612b);
        this.f417615e.unRegisterReceiveGiftMessageListener(this.f417613c);
        this.f417615e.unRegisterRoomStatusListener(this.f417611a);
        ILiveRoom iLiveRoom = this.f417615e;
        if (iLiveRoom instanceof ILiveTPPlayerRoom) {
            ((ILiveTPPlayerRoom) iLiveRoom).unRegisterRoomPlayerListener(this.f417614d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GiftMessage giftMessage) {
        if (giftMessage == null) {
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomListenerHandler", 1, "giftMessage == null");
        } else {
            mu0.c.b().e(giftMessage);
        }
    }

    private void d() {
        this.f417615e.registerAudienceInfoListener(this.f417612b);
        this.f417615e.registerReceiveGiftMessageListener(this.f417613c);
        this.f417615e.registerRoomStatusListener(this.f417611a);
        ILiveRoom iLiveRoom = this.f417615e;
        if (iLiveRoom instanceof ILiveTPPlayerRoom) {
            ((ILiveTPPlayerRoom) iLiveRoom).registerRoomPlayerListener(this.f417614d);
        }
    }

    public static void e(ILiveRoom iLiveRoom) {
        synchronized (b.class) {
            if (f417610f == null) {
                b bVar = new b(iLiveRoom);
                f417610f = bVar;
                bVar.d();
            }
        }
    }

    public static void f() {
        synchronized (b.class) {
            b bVar = f417610f;
            if (bVar != null) {
                bVar.b();
                f417610f = null;
            }
        }
    }
}
