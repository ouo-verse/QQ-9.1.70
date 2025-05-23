package com.tencent.mobileqq.icgame.room.message;

import androidx.exifinterface.media.ExifInterface;
import ap4.e;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import w42.FollowPushScreenMessage;
import w42.j;
import w42.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\t*\u0002\r\u0011\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager;", "Liw0/d;", "", ExifInterface.LATITUDE_SOUTH, "", "register", "unregister", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "r", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "o0", "()Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "iQQLiveAnnouncePushListener", "com/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager$c", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager$c;", "iQQLiveReceiveRoomFollowListener", "com/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager$d", "t", "Lcom/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager$d;", "sharePushCallback", "<init>", "()V", "u", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveChatMessageLayoutManager extends iw0.d {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener = new b();

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c iQQLiveReceiveRoomFollowListener = new c();

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d sharePushCallback = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager$d", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements IQQCmdPushCallback {
        d() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            a.INSTANCE.h(QQLiveChatMessageLayoutManager.this.S(), "share push onFailed", "code:" + errCode + ",msg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            if (data == null) {
                a.INSTANCE.h(QQLiveChatMessageLayoutManager.this.S(), "share push onReceive", "dara is null");
                return;
            }
            try {
                e c16 = e.c(data);
                QQLiveChatMessageLayoutManager qQLiveChatMessageLayoutManager = QQLiveChatMessageLayoutManager.this;
                LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
                speakerInfo.mSpeakId = c16.f26703b;
                speakerInfo.mSpeakerName = c16.f26702a;
                qQLiveChatMessageLayoutManager.s(new k(speakerInfo));
            } catch (InvalidProtocolBufferNanoException e16) {
                a.INSTANCE.i(QQLiveChatMessageLayoutManager.this.S(), "share push onReceive", "parse data failed", e16);
            }
        }
    }

    @Override // iw0.d
    @NotNull
    public String S() {
        return "ICGameChat_Message|ICGameChatMessageLayoutManager";
    }

    @NotNull
    /* renamed from: o0, reason: from getter */
    public IQQLiveAnnouncePushListener getIQQLiveAnnouncePushListener() {
        return this.iQQLiveAnnouncePushListener;
    }

    @Override // z42.a
    public void register() {
        QLog.d(S(), 4, "register");
        ILiveRoomMessage k3 = ((fu0.c) qx0.a.b(fu0.c.class)).k(getRoomId());
        if (k3 != null) {
            k3.registerRoomChatMsgListener(getIQQLiveReceiveMessageListener());
            k3.registerSystemMsgListener(getIQQLiveSysMessageListener());
            k3.registerAnnounceMessageListener(getIQQLiveAnnouncePushListener());
            k3.registerFollowMessageListener(getIQQLiveReceiveFollowListener());
            k3.registerRoomFollowListener(this.iQQLiveReceiveRoomFollowListener);
            k3.registerOnReceiveFloatHeartListener(getRoomLikeInfoListener());
            k3.registerAudienceInfoListener(getRoomAudienceInfoListener());
            k3.registerReceiveGiftMessageListener(getReceiveGiftMessageListener());
            k3.registerHighPriorityListener(61, this.sharePushCallback);
        }
        SimpleEventBus.getInstance().registerReceiver(R());
        TGLiveFollowManager.f115307a.p(getFollowStateListener());
        getFansGroupPushMgr().a(getRoomId(), new Function1<jz0.a, Unit>() { // from class: com.tencent.mobileqq.icgame.room.message.QQLiveChatMessageLayoutManager$register$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(jz0.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable jz0.a aVar) {
                if (aVar != null) {
                    QQLiveChatMessageLayoutManager qQLiveChatMessageLayoutManager = QQLiveChatMessageLayoutManager.this;
                    if (qQLiveChatMessageLayoutManager.getRoomId() == aVar.f411236e) {
                        String str = aVar.f411237f;
                        Intrinsics.checkNotNullExpressionValue(str, "pushMsg.content");
                        qQLiveChatMessageLayoutManager.s(new j(str, 0, 0, 6, null));
                    }
                }
            }
        });
    }

    @Override // z42.a
    public void unregister() {
        QLog.d(S(), 4, "unregister");
        ILiveRoomMessage k3 = ((fu0.c) qx0.a.b(fu0.c.class)).k(getRoomId());
        if (k3 != null) {
            k3.unRegisterRoomChatMsgListener(getIQQLiveReceiveMessageListener());
            k3.unRegisterAnnounceMessageListener(getIQQLiveAnnouncePushListener());
            k3.unRegisterFollowMessageListener(getIQQLiveReceiveFollowListener());
            k3.unRegisterRoomFollowListener(this.iQQLiveReceiveRoomFollowListener);
            k3.unRegisterOnReceiveFloatHeartListener(getRoomLikeInfoListener());
            k3.unRegisterAudienceInfoListener(getRoomAudienceInfoListener());
            k3.unRegisterReceiveGiftMessageListener(getReceiveGiftMessageListener());
            k3.unRegisterHighPriorityListener(61, this.sharePushCallback);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(R());
        TGLiveFollowManager.f115307a.r(getFollowStateListener());
        getFansGroupPushMgr().b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager$b", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "announcePushMessage", "", "onAnnounceReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements IQQLiveAnnouncePushListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener
        public void onAnnounceReceive(@NotNull AnnouncePushMessage announcePushMessage) {
            Intrinsics.checkNotNullParameter(announcePushMessage, "announcePushMessage");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/message/QQLiveChatMessageLayoutManager$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "", "onFollowReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements IQQLiveReceiveFollowListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFollowReceive(@NotNull FollowPushMessage followPushMessage) {
            Intrinsics.checkNotNullParameter(followPushMessage, "followPushMessage");
            a.INSTANCE.f(QQLiveChatMessageLayoutManager.this.S(), "onFollowReceive " + followPushMessage.nick);
            if (followPushMessage.type == 1) {
                QQLiveChatMessageLayoutManager.this.s(new FollowPushScreenMessage(followPushMessage));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }
}
