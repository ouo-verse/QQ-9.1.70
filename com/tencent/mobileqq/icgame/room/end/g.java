package com.tencent.mobileqq.icgame.room.end;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.end.IQQLiveEndView;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0017J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u0016\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010.R \u00102\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00050/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/end/g;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Landroid/widget/FrameLayout;", "", "anchorId", "", "follow", "", "J", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/icgame/api/message/IQQLiveFollowMsgService;", "followMsgService", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "anchorInfo", "Lcom/tencent/mobileqq/icgame/api/end/IQQLiveEndView;", "liveEndView", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "Landroid/view/ViewGroup$LayoutParams;", "f", "k", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "E", "D", "H", "", "isPageClosed", "shouldExitRoom", "I", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "endInfo", "K", "Lfu0/c;", tl.h.F, "Lfu0/c;", "tgLiveRoomService", "Lh22/a;", "liveRoomService", "Lh22/a;", "Lp22/a;", "switchRoomService", "Lp22/a;", "Lcom/tencent/mobileqq/icgame/api/end/IQQLiveEndView;", "", "", "Ljava/util/Map;", "mFollowingStateCache", "Ls22/b;", "Ls22/b;", "fetchRoomListCallback", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g extends SingleUIComponent<FrameLayout> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final s22.b fetchRoomListCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fu0.c tgLiveRoomService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQLiveEndView liveEndView;

    @InjectService(key = h22.a.class)
    private h22.a liveRoomService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Integer> mFollowingStateCache;

    @InjectService(key = p22.a.class)
    private p22.a switchRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/room/end/g$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements IQQLiveFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveEndView f237555a;

        b(IQQLiveEndView iQQLiveEndView) {
            this.f237555a = iQQLiveEndView;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            rt0.a.INSTANCE.k("ICGameAudienceView", "doUnFollowAction", "on follow failed");
            if (TextUtils.isEmpty(errMsg)) {
                errMsg = "\u6536\u85cf\u5931\u8d25";
            }
            com.tencent.icgame.game.ui.widget.f.b(errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            rt0.a.INSTANCE.k("ICGameAudienceView", "doUnFollowAction", "on follow success");
            IQQLiveEndView iQQLiveEndView = this.f237555a;
            if (iQQLiveEndView != null) {
                iQQLiveEndView.setFollow(1);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/room/end/g$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements IQQLiveFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveEndView f237556a;

        c(IQQLiveEndView iQQLiveEndView) {
            this.f237556a = iQQLiveEndView;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            y32.d.b();
            if (TextUtils.isEmpty(errMsg)) {
                errMsg = "\u6536\u85cf\u5931\u8d25";
            }
            com.tencent.icgame.game.ui.widget.f.b(errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            y32.d.a();
            IQQLiveEndView iQQLiveEndView = this.f237556a;
            if (iQQLiveEndView != null) {
                iQQLiveEndView.setFollow(2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/icgame/room/end/g$d", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements IQQLiveCheckFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IQQLiveFollowMsgService f237558b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LiveAnchorInfo f237559c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQLiveEndView f237560d;

        d(IQQLiveFollowMsgService iQQLiveFollowMsgService, LiveAnchorInfo liveAnchorInfo, IQQLiveEndView iQQLiveEndView) {
            this.f237558b = iQQLiveFollowMsgService;
            this.f237559c = liveAnchorInfo;
            this.f237560d = iQQLiveEndView;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            y32.d.s(errCode, errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            if (isFollow == 1) {
                g.this.A(this.f237558b, this.f237559c, this.f237560d);
            } else {
                g.this.z(this.f237558b, this.f237559c, this.f237560d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/icgame/room/end/g$e", "Ls22/a;", "Landroid/view/View;", "view", "", "onCloseClick", "onFollowClick", "onHeadIconClick", "onNickClick", "onPopularityClick", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements s22.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LiveRoomExtraInfo f237561a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f237562b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f237563c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQLiveSDK f237564d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LiveAnchorInfo f237565e;

        e(LiveRoomExtraInfo liveRoomExtraInfo, Context context, g gVar, IQQLiveSDK iQQLiveSDK, LiveAnchorInfo liveAnchorInfo) {
            this.f237561a = liveRoomExtraInfo;
            this.f237562b = context;
            this.f237563c = gVar;
            this.f237564d = iQQLiveSDK;
            this.f237565e = liveAnchorInfo;
        }

        @Override // s22.a
        public void onCloseClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            String str = this.f237561a.I;
            Intrinsics.checkNotNullExpressionValue(str, "extraInfo.jumpSource");
            if (!q32.b.b(str)) {
                q32.b.c(this.f237562b);
            }
            ((Activity) this.f237562b).finish();
        }

        @Override // s22.a
        public void onFollowClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            rt0.a.INSTANCE.k("ICGameAudienceView", "showLiveEndView", "onFollowClick");
            IQQLiveEndView iQQLiveEndView = this.f237563c.liveEndView;
            if (iQQLiveEndView != null) {
                g gVar = this.f237563c;
                IQQLiveSDK iQQLiveSDK = this.f237564d;
                LiveAnchorInfo liveAnchorInfo = this.f237565e;
                IQQLiveFollowMsgService followMsgService = iQQLiveSDK.getFollowMsgService();
                Intrinsics.checkNotNullExpressionValue(followMsgService, "liveSDK.followMsgService");
                gVar.G(followMsgService, liveAnchorInfo, iQQLiveEndView);
            }
        }

        @Override // s22.a
        public void onHeadIconClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // s22.a
        public void onNickClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // s22.a
        public void onPopularityClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/icgame/room/end/g$f", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f implements IQQLiveCheckFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LiveAnchorInfo f237567b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IQQLiveEndView f237568c;

        f(LiveAnchorInfo liveAnchorInfo, IQQLiveEndView iQQLiveEndView) {
            this.f237567b = liveAnchorInfo;
            this.f237568c = iQQLiveEndView;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            rt0.a.INSTANCE.k("ICGameAudienceView", "showLiveEndView", "checkFollowStatus onFail:error_code:" + errCode + " errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            g.this.J(this.f237567b.uid, isFollow);
            this.f237568c.setFollow(isFollow);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        mm4.a b16 = qx0.a.b(fu0.c.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        this.tgLiveRoomService = (fu0.c) b16;
        this.mFollowingStateCache = new HashMap();
        this.fetchRoomListCallback = new s22.b() { // from class: com.tencent.mobileqq.icgame.room.end.f
            @Override // s22.b
            public final void onRoomListUpdate(List list) {
                g.B(g.this, list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(IQQLiveFollowMsgService followMsgService, LiveAnchorInfo anchorInfo, IQQLiveEndView liveEndView) {
        long j3 = anchorInfo.uid;
        h22.a aVar = this.liveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
            aVar = null;
        }
        followMsgService.unFollowAnchor(j3, aVar.getRoomId(), new c(liveEndView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(g this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.liveEndView != null) {
            gw0.b bVar = gw0.b.f403451a;
            h22.a aVar = this$0.liveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
                aVar = null;
            }
            bVar.d(aVar.getRoomId(), this$0.liveEndView, this$0.tgLiveRoomService.f());
        }
    }

    private final int C(long anchorId) {
        Long K = this.tgLiveRoomService.K();
        Intrinsics.checkNotNullExpressionValue(K, "tgLiveRoomService.selfUserId");
        long longValue = K.longValue();
        Integer num = this.mFollowingStateCache.get(longValue + "_" + anchorId);
        if (num != null) {
            return num.intValue();
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(IQQLiveFollowMsgService followMsgService, LiveAnchorInfo anchorInfo, IQQLiveEndView liveEndView) {
        followMsgService.checkFollowAnchor(anchorInfo.uid, new d(followMsgService, anchorInfo, liveEndView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(long anchorId, int follow) {
        Long K = this.tgLiveRoomService.K();
        Intrinsics.checkNotNullExpressionValue(K, "tgLiveRoomService.selfUserId");
        long longValue = K.longValue();
        Integer valueOf = Integer.valueOf(follow);
        this.mFollowingStateCache.put(longValue + "_" + anchorId, valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(IQQLiveFollowMsgService followMsgService, LiveAnchorInfo anchorInfo, IQQLiveEndView liveEndView) {
        long j3 = anchorInfo.uid;
        h22.a aVar = this.liveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
            aVar = null;
        }
        followMsgService.followAnchor(j3, aVar.getRoomId(), new b(liveEndView));
    }

    public final void D() {
        IQQLiveEndView iQQLiveEndView = this.liveEndView;
        if (iQQLiveEndView != null) {
            iQQLiveEndView.onResume();
        }
    }

    public final void E() {
        IQQLiveEndView iQQLiveEndView = this.liveEndView;
        if (iQQLiveEndView != null) {
            iQQLiveEndView.onStop();
        }
    }

    public final void F() {
        IQQLiveEndView iQQLiveEndView = this.liveEndView;
        if (iQQLiveEndView != null) {
            iQQLiveEndView.onConfigurationChanged();
        }
    }

    public final void H() {
        IQQLiveSDK f16 = this.tgLiveRoomService.f();
        if (f16 != null) {
            f16.registerFetchRoomListUpdateCallback(this.fetchRoomListCallback);
        }
    }

    public final void I(boolean isPageClosed, boolean shouldExitRoom) {
        IQQLiveEndView iQQLiveEndView = this.liveEndView;
        if (iQQLiveEndView != null) {
            h22.a aVar = this.liveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
                aVar = null;
            }
            iQQLiveEndView.onPageOut(aVar.getRoomId(), isPageClosed, shouldExitRoom);
        }
        IQQLiveSDK f16 = this.tgLiveRoomService.f();
        if (f16 != null) {
            f16.unRegisterFetchRoomListUpdateCallback(this.fetchRoomListCallback);
        }
    }

    public final void K(@Nullable EndPageRealTimeInfo endInfo) {
        String str;
        LiveAnchorInfo liveAnchorInfo;
        LiveRoomInfo liveRoomInfo;
        h22.a aVar = this.liveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
            aVar = null;
        }
        LiveInfo curLiveInfo = aVar.getCurLiveInfo();
        if (curLiveInfo != null && (liveRoomInfo = curLiveInfo.roomInfo) != null) {
            str = liveRoomInfo.getProgramId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        h22.a aVar3 = this.liveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
            aVar3 = null;
        }
        LiveInfo curLiveInfo2 = aVar3.getCurLiveInfo();
        if (curLiveInfo2 != null) {
            liveAnchorInfo = curLiveInfo2.anchorInfo;
        } else {
            liveAnchorInfo = null;
        }
        if (liveAnchorInfo == null) {
            rt0.a.INSTANCE.h("ICGameAudienceView", "showLiveEndView", "anchorInfo == null, return");
            return;
        }
        long j3 = liveAnchorInfo.uid;
        a.Companion companion = rt0.a.INSTANCE;
        h22.a aVar4 = this.liveRoomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
            aVar4 = null;
        }
        companion.k("ICGameAudienceView", "showLiveEndView", "roomId:" + aVar4.getRoomId() + ", programId=" + str2 + ", anchorId=" + j3);
        p22.a aVar5 = this.switchRoomService;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchRoomService");
            aVar5 = null;
        }
        au0.c roomSwitcher = aVar5.getRoomSwitcher();
        Context context = getComponentContext().getContext();
        if (!(context instanceof Activity)) {
            companion.h("ICGameAudienceView", "showLiveEndView", "activityContext not Activity, return");
            return;
        }
        h22.a aVar6 = this.liveRoomService;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
            aVar6 = null;
        }
        LiveRoomExtraInfo extraInfo = aVar6.getExtraInfo();
        if (extraInfo == null) {
            companion.h("ICGameAudienceView", "showLiveEndView", "extraInfo == null, return");
            return;
        }
        IQQLiveSDK f16 = this.tgLiveRoomService.f();
        if (f16 == null) {
            companion.h("ICGameAudienceView", "showLiveEndView", "liveSDK == null, return");
            return;
        }
        h hVar = h.f237569a;
        Activity activity = (Activity) context;
        h22.a aVar7 = this.liveRoomService;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
            aVar7 = null;
        }
        long roomId = aVar7.getRoomId();
        LiveUserInfo selfUserInfo = this.tgLiveRoomService.getSelfUserInfo();
        h22.a aVar8 = this.liveRoomService;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveRoomService");
        } else {
            aVar2 = aVar8;
        }
        LiveAnchorInfo liveAnchorInfo2 = liveAnchorInfo;
        IQQLiveEndView a16 = hVar.a(activity, roomId, str2, f16, selfUserInfo, liveAnchorInfo, endInfo, aVar2.getExtraInfo(), 2, roomSwitcher, new e(extraInfo, context, this, f16, liveAnchorInfo2));
        this.liveEndView = a16;
        if (a16 == null) {
            companion.h("ICGameAudienceView", "showLiveEndView", "curLiveEndView == null, return");
            return;
        }
        View view = a16.getView();
        p().removeAllViews();
        p().addView(view, new FrameLayout.LayoutParams(-1, -1));
        p().setVisibility(0);
        a16.setFollow(C(liveAnchorInfo2.uid));
        hVar.c(f16, liveAnchorInfo2.uid, new f(liveAnchorInfo2, a16));
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent, com.tencent.mobileqq.icgame.framework.component.i
    @NotNull
    public ViewGroup.LayoutParams f() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.xcy;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public FrameLayout n() {
        return new FrameLayout(getComponentContext().getContext());
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    @SuppressLint({"ClickableViewAccessibility"})
    public void k() {
    }
}
