package com.tencent.mobileqq.guild.media.qcircle;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.j;
import com.tencent.mobileqq.guild.live.livemanager.player.l;
import com.tencent.mobileqq.guild.live.livemanager.player.m;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sq1.GLiveOutPlayerInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001X\u0018\u0000 d2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001eB\u001d\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010,R\u001c\u0010/\u001a\n +*\u0004\u0018\u00010\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010=R\u0016\u0010@\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010B\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010(R\u0016\u0010E\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010LR\u0016\u0010P\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010(R\u0016\u0010T\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010]\u001a\u00020<8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\\\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/LiveRoomContent;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/qcircle/e;", "Landroidx/lifecycle/Observer;", "Ljava/lang/Void;", "", "isLand", "", BdhLogUtil.LogTag.Tag_Conn, "y", "Lfeedcloud/FeedCloudMeta$StLive;", "data", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "videoView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "r", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", ReportConstant.COSTREPORT_PREFIX, "Lfeedcloud/FeedCloudMeta$StFeed;", "Lcom/tencent/mobileqq/guild/media/qcircle/c;", "roomInfo", "Lj30/a;", "controller", tl.h.F, "Lcom/tencent/mobileqq/guild/media/qcircle/d;", "setFeedController", "e", "onActivityDestroy", "onPagePause", "f", "g", "t", HippyTKDListViewAdapter.X, "b", "", "d", "Ljava/lang/String;", "mTag", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Landroid/widget/ImageView;", "coverIV", "Landroid/widget/FrameLayout;", "mVideoContainer", "Lcom/tencent/mobileqq/guild/live/livemanager/player/h;", "Lkotlin/Lazy;", "v", "()Lcom/tencent/mobileqq/guild/live/livemanager/player/h;", "playerMgr", "Ltq1/b;", "i", "u", "()Ltq1/b;", "liveUiData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "", "I", "videoWidth", "D", "videoHeight", "E", "liveFeedId", UserInfo.SEX_FEMALE, "Lj30/a;", "feedController", "G", "Lcom/tencent/mobileqq/guild/media/qcircle/d;", "baseViewController", "H", "Lfeedcloud/FeedCloudMeta$StLive;", "liveData", "Lcom/tencent/mobileqq/guild/media/qcircle/c;", "liveRoomInfo", "J", "Z", "clickJumpToChannel", "K", "playURL", "L", "videoIsLand", "M", "Landroidx/lifecycle/Observer;", "isUserOutPlayerObserver", "com/tencent/mobileqq/guild/media/qcircle/LiveRoomContent$b", "N", "Lcom/tencent/mobileqq/guild/media/qcircle/LiveRoomContent$b;", "playerInfoListener", "()I", "liveTopMargin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "P", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveRoomContent extends FrameLayout implements e, Observer<Void> {

    /* renamed from: C, reason: from kotlin metadata */
    private int videoWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int videoHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String liveFeedId;

    /* renamed from: F, reason: from kotlin metadata */
    private j30.a feedController;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private d baseViewController;

    /* renamed from: H, reason: from kotlin metadata */
    private FeedCloudMeta$StLive liveData;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.qcircle.c liveRoomInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean clickJumpToChannel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String playURL;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean videoIsLand;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Observer<Boolean> isUserOutPlayerObserver;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final b playerInfoListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView coverIV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout mVideoContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy playerMgr;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveUiData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View videoView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/LiveRoomContent$c", "Lcom/tencent/mobileqq/guild/live/livemanager/player/m;", "", "disableViewCallback", "enableViewCallback", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements m {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean disableViewCallback() {
            return LiveRoomContent.this.v().f(GuildLivePlayerTag.Q_CIRCLE_LIVE_ITEM);
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean enableViewCallback() {
            return LiveRoomContent.this.v().g(GuildLivePlayerTag.Q_CIRCLE_LIVE_ITEM);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveRoomContent(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(FeedCloudMeta$StLive data) {
        QLog.d(this.mTag, 1, "play url " + this.playURL + " ");
        QLog.d(this.mTag, 1, "play url roomID " + data.room.roomId.get() + " ");
        com.tencent.mobileqq.guild.live.livemanager.player.h v3 = v();
        String str = this.playURL;
        GuildLivePlayerTag guildLivePlayerTag = GuildLivePlayerTag.Q_CIRCLE_LIVE_ITEM;
        this.videoView = l.a.a(v3, str, guildLivePlayerTag, 0, false, true, 12, null);
        v().d(guildLivePlayerTag, this.playerInfoListener);
        View view = this.videoView;
        Intrinsics.checkNotNull(view);
        q(view);
    }

    private final void B() {
        this.videoView = null;
        this.mVideoContainer.removeAllViews();
        v().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean isLand) {
        View childAt = this.mVideoContainer.getChildAt(0);
        if (childAt == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (isLand) {
            layoutParams.height = gq1.b.b(getContext());
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = t();
        } else {
            layoutParams.height = -1;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
        }
        childAt.setLayoutParams(layoutParams);
    }

    private final void q(View videoView) {
        boolean z16;
        FrameLayout mVideoContainer = this.mVideoContainer;
        Intrinsics.checkNotNullExpressionValue(mVideoContainer, "mVideoContainer");
        int i3 = 0;
        int i16 = -1;
        if (mVideoContainer.indexOfChild(videoView) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ViewParent parent = videoView.getParent();
        if (parent instanceof ViewGroup) {
            if (QLog.isColorLevel()) {
                QLog.i(this.mTag, 2, "videoView.parent remove.");
            }
            v().f(GuildLivePlayerTag.Q_CIRCLE_LIVE_ITEM);
            ((ViewGroup) parent).removeView(videoView);
        }
        ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
        layoutParams.width = -1;
        if (this.videoIsLand) {
            i16 = gq1.b.b(getContext());
        }
        layoutParams.height = i16;
        ViewGroup.LayoutParams layoutParams2 = videoView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (this.videoIsLand) {
            i3 = t();
        }
        marginLayoutParams.topMargin = i3;
        QLog.i(this.mTag, 1, "containerView add videoView suc." + videoView);
        this.mVideoContainer.addView(videoView, layoutParams);
        j30.a aVar = this.feedController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedController");
            aVar = null;
        }
        aVar.m();
        v().g(GuildLivePlayerTag.Q_CIRCLE_LIVE_ITEM);
    }

    private final JumpGuildParam.JoinInfoParam r() {
        com.tencent.mobileqq.guild.media.qcircle.c cVar = this.liveRoomInfo;
        Intrinsics.checkNotNull(cVar);
        return new JumpGuildParam.JoinInfoParam(cVar.getChannelId(), cVar.getJoinSig(), cVar.getMainSourceId(), cVar.getSubSourceId());
    }

    private final GuildAppReportSourceInfo s() {
        return new GuildAppReportSourceInfo("functional_qq_little_world_feed", "");
    }

    private final int t() {
        int f16 = QQGuildUIUtil.f(78.0f);
        j30.a aVar = this.feedController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedController");
            aVar = null;
        }
        return f16 + aVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final tq1.b u() {
        return (tq1.b) this.liveUiData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.live.livemanager.player.h v() {
        return (com.tencent.mobileqq.guild.live.livemanager.player.h) this.playerMgr.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(LiveRoomContent this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!bool.booleanValue()) {
            this$0.B();
        }
    }

    private final void y() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.drawable.guild_live_bg_1));
        arrayList.add(Integer.valueOf(R.drawable.guild_live_bg_2));
        arrayList.add(Integer.valueOf(R.drawable.guild_live_bg_3));
        Integer it = (Integer) arrayList.get(Random.INSTANCE.nextInt(3));
        ImageView imageView = this.coverIV;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        imageView.setImageResource(it.intValue());
    }

    private final void z() {
        if (this.videoView == null) {
            return;
        }
        c cVar = new c();
        tq1.b u16 = u();
        com.tencent.mobileqq.guild.media.qcircle.c cVar2 = this.liveRoomInfo;
        Intrinsics.checkNotNull(cVar2);
        String guildId = cVar2.getGuildId();
        com.tencent.mobileqq.guild.media.qcircle.c cVar3 = this.liveRoomInfo;
        Intrinsics.checkNotNull(cVar3);
        String channelId = cVar3.getChannelId();
        View view = this.videoView;
        Intrinsics.checkNotNull(view);
        u16.h0(new GLiveOutPlayerInfo(guildId, channelId, view, cVar, this.videoWidth, this.videoHeight));
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void b() {
        QLog.d(this.mTag, 1, "onOtherAudioOrVideoPlay");
        B();
        u().o().removeObserver(this.isUserOutPlayerObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void e() {
        QLog.d(this.mTag, 4, "onPageResume. " + v() + ", " + this.videoView);
        if (this.liveRoomInfo == null) {
            QLog.d(this.mTag, 1, "onPageResume liveRoomInfo is null");
            B();
            return;
        }
        View view = this.videoView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            q(view);
            return;
        }
        FeedCloudMeta$StLive feedCloudMeta$StLive = this.liveData;
        if (feedCloudMeta$StLive == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveData");
            feedCloudMeta$StLive = null;
        }
        A(feedCloudMeta$StLive);
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void f() {
        if (this.liveRoomInfo == null) {
            QLog.d(this.mTag, 1, "jumpToChannel liveRoomInfo is null");
            return;
        }
        z();
        this.clickJumpToChannel = true;
        com.tencent.mobileqq.guild.media.qcircle.c cVar = this.liveRoomInfo;
        Intrinsics.checkNotNull(cVar);
        GLiveChannelStartParams.b bVar = new GLiveChannelStartParams.b();
        bVar.i(cVar.getGuildId());
        bVar.h(cVar.getChannelId());
        bVar.n(this.playURL);
        bVar.j("");
        bVar.m("");
        bVar.k(String.valueOf(cVar.getAnchorId()));
        bVar.l(Long.parseLong(cVar.getLiveRoomId()));
        GLiveChannelStartParams c16 = GLiveChannelStartParams.INSTANCE.c(bVar);
        Bundle bundle = new Bundle();
        bundle.putSerializable(JumpGuildParam.KEY_JOIN_INFO_PARAM, r());
        bundle.putSerializable("GuildAppReportSourceInfo", s());
        bundle.putString("guild_id", cVar.getGuildId());
        c16.setBundle(bundle);
        gq1.c.e(c16);
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void g() {
        QLog.i(this.mTag, 1, "onDestroy." + v() + "," + this.videoView);
        u().v().removeObserver(this);
        u().o().removeObserver(this.isUserOutPlayerObserver);
        v().e();
        this.liveRoomInfo = null;
        if (this.videoView != null && Intrinsics.areEqual(u().z().getValue(), this.videoView)) {
            u().l0(null, null);
            u().w0(Boolean.TRUE);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void h(@NotNull FeedCloudMeta$StFeed data, @NotNull com.tencent.mobileqq.guild.media.qcircle.c roomInfo, @NotNull j30.a controller) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(controller, "controller");
        y();
        FeedCloudMeta$StLive feedCloudMeta$StLive = data.live.get();
        Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StLive, "data.live.get()");
        this.liveData = feedCloudMeta$StLive;
        this.feedController = controller;
        String str2 = data.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "data.id.get()");
        this.liveFeedId = str2;
        this.liveRoomInfo = roomInfo;
        FeedCloudMeta$StLive feedCloudMeta$StLive2 = this.liveData;
        FeedCloudMeta$StLive feedCloudMeta$StLive3 = null;
        if (feedCloudMeta$StLive2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveData");
            feedCloudMeta$StLive2 = null;
        }
        if (feedCloudMeta$StLive2.room.isUseFlvUrl.get()) {
            FeedCloudMeta$StLive feedCloudMeta$StLive4 = this.liveData;
            if (feedCloudMeta$StLive4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveData");
                feedCloudMeta$StLive4 = null;
            }
            str = feedCloudMeta$StLive4.room.flvUrl.get();
            Intrinsics.checkNotNullExpressionValue(str, "{\n            liveData.room.flvUrl.get()\n        }");
        } else {
            FeedCloudMeta$StLive feedCloudMeta$StLive5 = this.liveData;
            if (feedCloudMeta$StLive5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveData");
                feedCloudMeta$StLive5 = null;
            }
            str = feedCloudMeta$StLive5.room.rtmpUrl.get();
            Intrinsics.checkNotNullExpressionValue(str, "{\n            liveData.r\u2026m.rtmpUrl.get()\n        }");
        }
        this.playURL = str;
        FeedCloudMeta$StLive feedCloudMeta$StLive6 = this.liveData;
        if (feedCloudMeta$StLive6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveData");
        } else {
            feedCloudMeta$StLive3 = feedCloudMeta$StLive6;
        }
        A(feedCloudMeta$StLive3);
        u().v().removeObserver(this);
        u().v().observeForever(this);
        u().o().removeObserver(this.isUserOutPlayerObserver);
        u().o().observeForever(this.isUserOutPlayerObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void onActivityDestroy() {
        B();
        u().v().removeObserver(this);
        u().o().removeObserver(this.isUserOutPlayerObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void onPagePause() {
        QLog.d(this.mTag, 4, "onPagePause. " + v() + "," + this.videoView);
        if (this.clickJumpToChannel) {
            this.clickJumpToChannel = false;
        } else {
            B();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void setFeedController(@Nullable d controller) {
        this.baseViewController = controller;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable Void t16) {
        View view = this.videoView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            q(view);
        }
    }

    public /* synthetic */ LiveRoomContent(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveRoomContent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTag = "QGL.QGMC.QCircle.LiveRoomContent." + hashCode();
        View.inflate(context, R.layout.ex5, this);
        this.coverIV = (ImageView) findViewById(R.id.ykz);
        this.mVideoContainer = (FrameLayout) findViewById(R.id.f165195v44);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.live.livemanager.player.h>() { // from class: com.tencent.mobileqq.guild.media.qcircle.LiveRoomContent$playerMgr$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.live.livemanager.player.h invoke() {
                return new com.tencent.mobileqq.guild.live.livemanager.player.h();
            }
        });
        this.playerMgr = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<tq1.b>() { // from class: com.tencent.mobileqq.guild.media.qcircle.LiveRoomContent$liveUiData$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final tq1.b invoke() {
                return GLiveChannelCore.f226698a.t();
            }
        });
        this.liveUiData = lazy2;
        this.liveFeedId = "";
        this.playURL = "";
        this.videoIsLand = true;
        this.isUserOutPlayerObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.qcircle.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveRoomContent.w(LiveRoomContent.this, (Boolean) obj);
            }
        };
        this.playerInfoListener = new b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/LiveRoomContent$b", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "", "onFirstFrameCome", "", "width", "height", "onVideoSizeChanged", "onError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.live.livemanager.player.j {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onCurrentLoopEnd() {
            j.a.a(this);
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onError() {
            QLog.d(LiveRoomContent.this.mTag, 1, "onError ");
            d dVar = LiveRoomContent.this.baseViewController;
            if (dVar != null) {
                dVar.a(2);
            }
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onVideoSizeChanged(int width, int height) {
            boolean z16;
            if (LiveRoomContent.this.videoView != null) {
                LiveRoomContent.this.videoWidth = width;
                LiveRoomContent.this.videoHeight = height;
                LiveRoomContent liveRoomContent = LiveRoomContent.this;
                if (width >= height) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                liveRoomContent.videoIsLand = z16;
                if (Intrinsics.areEqual(LiveRoomContent.this.u().z().getValue(), LiveRoomContent.this.videoView)) {
                    LiveRoomContent.this.u().x0(width, height);
                    LiveRoomContent.this.u().w0(Boolean.valueOf(LiveRoomContent.this.videoIsLand));
                }
                LiveRoomContent liveRoomContent2 = LiveRoomContent.this;
                liveRoomContent2.C(liveRoomContent2.videoIsLand);
            }
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onFirstFrameCome() {
        }
    }
}
