package com.tencent.icgame.game.liveroom.impl.room.followguide;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.anchor.UserSelfSendMsgEvent;
import com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.icgame.game.liveroom.impl.room.followguide.a;
import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00012\u0018\u0000 :2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogController;", "", "", "p", "Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;", "liveRoom", "", "j", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", "context", "", "roomId", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "mRunnable", "b", "J", "mRoomId", "c", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "d", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoomMessage;", "e", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoomMessage;", "mLiveRoomMessage", "", "f", "I", "mFrom", "g", "Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;", "getQqLiveAudienceRoom", "()Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;", "setQqLiveAudienceRoom", "(Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;)V", "qqLiveAudienceRoom", "Lfu0/c;", tl.h.F, "Lkotlin/Lazy;", "i", "()Lfu0/c;", "liveRoomService", "com/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogController$c", "Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogController$c;", "mSelfMsgEvent", "Lv22/a;", "Lv22/a;", "mReceiveGiftMessageListener", "<init>", "()V", "k", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class FollowGuideDialogController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mRunnable = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.d
        @Override // java.lang.Runnable
        public final void run() {
            FollowGuideDialogController.k(FollowGuideDialogController.this);
        }
    };

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ILiveRoomMessage mLiveRoomMessage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mFrom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IAudienceRoom qqLiveAudienceRoom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mSelfMsgEvent;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final v22.a mReceiveGiftMessageListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogController$b", "Lv22/a;", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "giftMessage", "", "a", "", "code", "", "msg", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements v22.a {
        b() {
        }

        @Override // v22.a
        public void a(@NotNull GiftMessage giftMessage) {
            Intrinsics.checkNotNullParameter(giftMessage, "giftMessage");
            LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
            if (selfUserInfo == null) {
                FollowGuideDialogController.this.mAegisLog.e("ICGameFollowGuideDialogContro", 1, "none self userInfo");
            } else if (giftMessage.sender == selfUserInfo.uid) {
                FollowGuideDialogController.this.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "receive self gift msg");
                ThreadManager.getUIHandler().postDelayed(FollowGuideDialogController.this.mRunnable, j.f115347a.d() * 1000);
                FollowGuideDialogController.this.mFrom = 1;
            }
        }

        @Override // v22.a
        public void onError(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            FollowGuideDialogController.this.mAegisLog.e("ICGameFollowGuideDialogContro", 1, "mReceiveGiftMessageListener code=" + code + "msg=" + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideDialogController$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/icgame/game/liveroom/impl/room/anchor/UserSelfSendMsgEvent;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements SimpleEventReceiver<UserSelfSendMsgEvent> {
        c() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<UserSelfSendMsgEvent>> getEventClass() {
            ArrayList<Class<UserSelfSendMsgEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UserSelfSendMsgEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if ((event instanceof UserSelfSendMsgEvent) && ((UserSelfSendMsgEvent) event).getRoomId() == FollowGuideDialogController.this.mRoomId) {
                FollowGuideDialogController.this.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "receive msg send event");
                ThreadManager.getUIHandler().postDelayed(FollowGuideDialogController.this.mRunnable, j.f115347a.d() * 1000);
                FollowGuideDialogController.this.mFrom = 2;
            }
        }
    }

    public FollowGuideDialogController() {
        Lazy lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.FollowGuideDialogController$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        this.mSelfMsgEvent = new c();
        this.mReceiveGiftMessageListener = new b();
    }

    private final fu0.c i() {
        Object value = this.liveRoomService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-liveRoomService>(...)");
        return (fu0.c) value;
    }

    private final boolean j(IAudienceRoom liveRoom) {
        if (liveRoom.getRoomLiveInfo() != null && liveRoom.getRoomLiveInfo().anchorInfo != null && liveRoom.getRoomLiveInfo().anchorInfo.getAnchorUid() > 0) {
            return true;
        }
        this.mAegisLog.e("ICGameFollowGuideDialogContro", 1, "isAnchorInfoLegal false liveRoom.roomLiveInfo =" + liveRoom + ".roomLiveInfo");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FollowGuideDialogController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    private final void n() {
        IAudienceRoom iAudienceRoom;
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity);
            if (!activity.isFinishing() && (iAudienceRoom = this.qqLiveAudienceRoom) != null) {
                Intrinsics.checkNotNull(iAudienceRoom);
                if (iAudienceRoom.getRoomLiveInfo() != null) {
                    IAudienceRoom iAudienceRoom2 = this.qqLiveAudienceRoom;
                    Intrinsics.checkNotNull(iAudienceRoom2);
                    if (iAudienceRoom2.getRoomInfo() != null) {
                        Activity activity2 = this.mActivity;
                        Intrinsics.checkNotNull(activity2);
                        IAudienceRoom iAudienceRoom3 = this.qqLiveAudienceRoom;
                        Intrinsics.checkNotNull(iAudienceRoom3);
                        final Dialog f16 = FollowGuideDialogUtil.f(activity2, iAudienceRoom3, this.mFrom);
                        try {
                            f16.show();
                        } catch (Exception e16) {
                            this.mAegisLog.e("ICGameFollowGuideDialogContro", "realShowDialog   dialog.show() e= " + e16);
                        }
                        this.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "showDialog mRunnable showDialog ");
                        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                FollowGuideDialogController.o(FollowGuideDialogController.this, f16);
                            }
                        }, FollowGuideConfigModel.INSTANCE.a().getStayDismissDuration() * 1000);
                        j.f115347a.i(this.mRoomId);
                        return;
                    }
                }
                IAegisLogApi iAegisLogApi = this.mAegisLog;
                IAudienceRoom iAudienceRoom4 = this.qqLiveAudienceRoom;
                Intrinsics.checkNotNull(iAudienceRoom4);
                LiveInfo roomLiveInfo = iAudienceRoom4.getRoomLiveInfo();
                IAudienceRoom iAudienceRoom5 = this.qqLiveAudienceRoom;
                Intrinsics.checkNotNull(iAudienceRoom5);
                iAegisLogApi.e("ICGameFollowGuideDialogContro", "realShowDialog  roomLiveInfo =" + roomLiveInfo + ",roomInfo=" + iAudienceRoom5.getRoomInfo());
                return;
            }
        }
        this.mAegisLog.e("ICGameFollowGuideDialogContro", "realShowDialog  mActivity =" + this.mActivity + ",qqLiveAudienceRoom=" + this.qqLiveAudienceRoom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FollowGuideDialogController this$0, Dialog dialog) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Activity activity = this$0.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity);
            if (!activity.isFinishing() && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e16) {
                    this$0.mAegisLog.e("ICGameFollowGuideDialogContro", "realShowDialog   dialog.dismiss() e= " + e16);
                    return;
                }
            }
        }
        this$0.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "showDialog postDelayed mActivity =null ");
    }

    private final void p() {
        boolean n3;
        Long l3;
        BaseAnchorInfo anchorInfo;
        j jVar = j.f115347a;
        if (jVar.g(this.mRoomId) && jVar.h()) {
            if (this.qqLiveAudienceRoom == null) {
                this.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "showDialog qqLiveAudienceRoom =null ");
                return;
            }
            Activity activity = this.mActivity;
            if (activity != null) {
                Intrinsics.checkNotNull(activity);
                if (!activity.isFinishing()) {
                    if (m.b(this.mRoomId) != 2) {
                        IAudienceRoom iAudienceRoom = this.qqLiveAudienceRoom;
                        if (iAudienceRoom != null && (anchorInfo = iAudienceRoom.getAnchorInfo()) != null) {
                            l3 = Long.valueOf(anchorInfo.getAnchorUid());
                        } else {
                            l3 = null;
                        }
                        if (l3 != null && l3.longValue() > 0) {
                            n3 = TGLiveFollowManager.f115307a.j(l3.longValue());
                        } else {
                            this.mAegisLog.a("ICGameFollowGuideDialogContro", "showDialog err anchorId = " + l3);
                            return;
                        }
                    } else {
                        n3 = TGLiveFollowManager.f115307a.n(this.mRoomId);
                    }
                    if (n3) {
                        this.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "showDialog \u5df2\u7ecf\u6536\u85cf\u4e86\uff0c\u5c31\u4e0d\u5f39\u51fa\u4e86 roomId=" + this.mRoomId);
                        return;
                    }
                    IAudienceRoom iAudienceRoom2 = this.qqLiveAudienceRoom;
                    Intrinsics.checkNotNull(iAudienceRoom2);
                    if (!j(iAudienceRoom2)) {
                        return;
                    }
                    if (a.a()) {
                        a.d(new a.InterfaceC5835a() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.e
                            @Override // com.tencent.icgame.game.liveroom.impl.room.followguide.a.InterfaceC5835a
                            public final void show() {
                                FollowGuideDialogController.q(FollowGuideDialogController.this);
                            }
                        });
                        return;
                    } else {
                        n();
                        return;
                    }
                }
            }
            this.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "showDialog mActivity =null ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final FollowGuideDialogController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.followguide.g
            @Override // java.lang.Runnable
            public final void run() {
                FollowGuideDialogController.r(FollowGuideDialogController.this);
            }
        }, j.f115347a.d() * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(FollowGuideDialogController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
        a.b();
    }

    public final void l(@NotNull Activity context, long roomId) {
        Intrinsics.checkNotNullParameter(context, "context");
        a.b();
        if (!j.f115347a.g(roomId)) {
            this.mAegisLog.i("ICGameFollowGuideDialogContro", 1, "onPageIn roomId=" + roomId + "\u5f53\u524d\u623f\u95f4\u4e0d\u9700\u8981\u663e\u793a");
            return;
        }
        this.mRoomId = roomId;
        this.mActivity = context;
        this.qqLiveAudienceRoom = i().N(this.mRoomId);
        ILiveRoomMessage k3 = ((fu0.c) qx0.a.b(fu0.c.class)).k(this.mRoomId);
        this.mLiveRoomMessage = k3;
        if (k3 != null) {
            k3.registerReceiveGiftMessageListener(this.mReceiveGiftMessageListener);
        }
        SimpleEventBus.getInstance().registerReceiver(this.mSelfMsgEvent);
        this.mFrom = 0;
        ThreadManager.getUIHandler().postDelayed(this.mRunnable, r0.e() * 1000);
    }

    public final void m() {
        ThreadManager.getUIHandler().removeCallbacks(this.mRunnable);
        ILiveRoomMessage iLiveRoomMessage = this.mLiveRoomMessage;
        if (iLiveRoomMessage != null) {
            iLiveRoomMessage.unRegisterReceiveGiftMessageListener(this.mReceiveGiftMessageListener);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this.mSelfMsgEvent);
        a.b();
    }
}
