package com.tencent.mobileqq.guild.media.qcircle;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.u;
import com.tencent.mobileqq.guild.media.core.q;
import com.tencent.mobileqq.guild.media.game.widget.GameContentView;
import com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter;
import com.tencent.mobileqq.guild.media.listen.widget.ListenWidget;
import com.tencent.mobileqq.guild.media.qcircle.normal.MediaNormalView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001)\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001XB\u001d\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010IR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/MediaRoomContent;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/qcircle/e;", "", DomainData.DOMAIN_NAME, "", "themeType", "o", "k", "type", "p", "", "reason", "l", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "Lcom/tencent/mobileqq/guild/media/qcircle/c;", "roomInfo", "Lj30/a;", "controller", tl.h.F, "Lcom/tencent/mobileqq/guild/media/qcircle/d;", "setFeedController", "g", "e", "onActivityDestroy", "onPagePause", "f", "b", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "switchThemeObserver", "I", "lastThemeType", "com/tencent/mobileqq/guild/media/qcircle/MediaRoomContent$c", "Lcom/tencent/mobileqq/guild/media/qcircle/MediaRoomContent$c;", "listenStateObserver", "Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;", "i", "Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;", "listenWidget", "Lcom/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter;", "Lcom/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter;", "listenWidgetPresenter", "Lcom/tencent/mobileqq/guild/media/qcircle/normal/MediaNormalView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/qcircle/normal/MediaNormalView;", "normalContentView", "Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "D", "Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "gameContentView", "Lcom/tencent/mobileqq/guild/media/qcircle/b;", "E", "Lcom/tencent/mobileqq/guild/media/qcircle/b;", "gamePresenter", UserInfo.SEX_FEMALE, "Lj30/a;", "mediaController", "G", "Lcom/tencent/mobileqq/guild/media/qcircle/d;", "baseViewController", "H", "Lfeedcloud/FeedCloudMeta$StFeed;", "feedData", "Lfeedcloud/FeedCloudMeta$StLive;", "Lfeedcloud/FeedCloudMeta$StLive;", "mediaData", "J", "Lcom/tencent/mobileqq/guild/media/qcircle/c;", "", "K", "Z", "needExitRoom", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaRoomContent extends FrameLayout implements e {

    /* renamed from: C, reason: from kotlin metadata */
    private MediaNormalView normalContentView;

    /* renamed from: D, reason: from kotlin metadata */
    private GameContentView gameContentView;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.media.qcircle.b gamePresenter;

    /* renamed from: F, reason: from kotlin metadata */
    private j30.a mediaController;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.qcircle.d baseViewController;

    /* renamed from: H, reason: from kotlin metadata */
    private FeedCloudMeta$StFeed feedData;

    /* renamed from: I, reason: from kotlin metadata */
    private FeedCloudMeta$StLive mediaData;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.qcircle.c roomInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean needExitRoom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final o<SwitchThemeEvent> switchThemeObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastThemeType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c listenStateObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ListenWidget listenWidget;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ListenWidgetPresenter listenWidgetPresenter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/MediaRoomContent$b", "Lcom/tencent/mobileqq/guild/media/core/b;", "", "isSuccess", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.qcircle.c f229161b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j30.a f229162c;

        b(com.tencent.mobileqq.guild.media.qcircle.c cVar, j30.a aVar) {
            this.f229161b = cVar;
            this.f229162c = aVar;
        }

        @Override // com.tencent.mobileqq.guild.media.core.b
        public void a(boolean isSuccess, @Nullable IGProSecurityResult securityResult) {
            QLog.d("QGMC.QCircle.MediaRoomContent", 1, "enterChannel " + isSuccess);
            FeedCloudMeta$StLive feedCloudMeta$StLive = null;
            if (!isSuccess) {
                com.tencent.mobileqq.guild.media.qcircle.d dVar = MediaRoomContent.this.baseViewController;
                if (dVar != null) {
                    FeedCloudMeta$StLive feedCloudMeta$StLive2 = MediaRoomContent.this.mediaData;
                    if (feedCloudMeta$StLive2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaData");
                    } else {
                        feedCloudMeta$StLive = feedCloudMeta$StLive2;
                    }
                    dVar.a(feedCloudMeta$StLive.room.roomType.get());
                    return;
                }
                return;
            }
            com.tencent.mobileqq.guild.media.core.j.a().J().i(false, null);
            g.c(this.f229161b.getChannelId());
            this.f229162c.m();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/MediaRoomContent$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/u;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<u> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull u event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            String roomID = event.getRoomID();
            com.tencent.mobileqq.guild.media.qcircle.c cVar = MediaRoomContent.this.roomInfo;
            if (cVar != null) {
                str = cVar.getChannelId();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(roomID, str)) {
                QLog.d("QGMC.QCircle.MediaRoomContent", 1, "listenStateObserver not same room!");
            } else if (!event.getIsFromEnter()) {
                MediaRoomContent.this.n();
            } else {
                com.tencent.mobileqq.guild.media.core.j.a().M0().F0();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/MediaRoomContent$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements o<SwitchThemeEvent> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            com.tencent.mobileqq.guild.media.qcircle.c cVar = MediaRoomContent.this.roomInfo;
            if (cVar != null) {
                str = cVar.getChannelId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, com.tencent.mobileqq.guild.media.core.j.a().E())) {
                MediaRoomContent.this.o(event.getNewThemeType());
            } else {
                QLog.d("QGMC.QCircle.MediaRoomContent", 1, "switchThemeObserver not same room!");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaRoomContent(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void k() {
        com.tencent.mobileqq.guild.media.core.j.d().V(SwitchThemeEvent.class, this.switchThemeObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(u.class, this.listenStateObserver);
        com.tencent.mobileqq.guild.media.core.j.a().M0().W0(this.listenWidgetPresenter);
    }

    private final void l(String reason) {
        com.tencent.mobileqq.guild.media.core.j.a().D(null, reason);
        com.tencent.mobileqq.guild.media.core.j.d().j(SwitchThemeEvent.class, this.switchThemeObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(u.class, this.listenStateObserver);
        com.tencent.mobileqq.guild.media.qcircle.b bVar = this.gamePresenter;
        if (bVar != null) {
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gamePresenter");
                bVar = null;
            }
            bVar.d();
        }
        MediaNormalView mediaNormalView = this.normalContentView;
        if (mediaNormalView != null) {
            if (mediaNormalView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalContentView");
                mediaNormalView = null;
            }
            mediaNormalView.b();
        }
        this.listenWidget.setVisibility(8);
        this.lastThemeType = 0;
        com.tencent.mobileqq.guild.media.core.j.a().M0().W0(null);
        g.c("");
    }

    private final JumpGuildParam.JoinInfoParam m() {
        com.tencent.mobileqq.guild.media.qcircle.c cVar = this.roomInfo;
        Intrinsics.checkNotNull(cVar);
        return new JumpGuildParam.JoinInfoParam(cVar.getChannelId(), cVar.getJoinSig(), cVar.getMainSourceId(), cVar.getSubSourceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        this.listenWidgetPresenter.K();
        this.listenWidgetPresenter.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int themeType) {
        QLog.d("QGMC.QCircle.MediaRoomContent", 1, "setThemeConfig " + themeType);
        if (this.lastThemeType != themeType) {
            p(themeType);
            this.lastThemeType = themeType;
        }
    }

    private final void p(int type) {
        QLog.d("QGMC.QCircle.MediaRoomContent", 1, "switchContentType " + type);
        com.tencent.mobileqq.guild.media.qcircle.b bVar = null;
        FeedCloudMeta$StLive feedCloudMeta$StLive = null;
        MediaNormalView mediaNormalView = null;
        if (type != 1) {
            if (type != 2) {
                QLog.d("QGMC.QCircle.MediaRoomContent", 1, "\u4e0d\u652f\u6301\u7684\u4e3b\u9898\u7c7b\u578b");
                com.tencent.mobileqq.guild.media.qcircle.d dVar = this.baseViewController;
                if (dVar != null) {
                    FeedCloudMeta$StLive feedCloudMeta$StLive2 = this.mediaData;
                    if (feedCloudMeta$StLive2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaData");
                    } else {
                        feedCloudMeta$StLive = feedCloudMeta$StLive2;
                    }
                    dVar.a(feedCloudMeta$StLive.room.roomType.get());
                    return;
                }
                return;
            }
            this.rootView.removeAllViews();
            if (this.gameContentView == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.gameContentView = new GameContentView(context, null, 2, null);
            }
            ViewGroup viewGroup = this.rootView;
            GameContentView gameContentView = this.gameContentView;
            if (gameContentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameContentView");
                gameContentView = null;
            }
            viewGroup.addView(gameContentView);
            if (this.gamePresenter == null) {
                GameContentView gameContentView2 = this.gameContentView;
                if (gameContentView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gameContentView");
                    gameContentView2 = null;
                }
                this.gamePresenter = new com.tencent.mobileqq.guild.media.qcircle.b(gameContentView2);
            }
            com.tencent.mobileqq.guild.media.qcircle.b bVar2 = this.gamePresenter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gamePresenter");
                bVar2 = null;
            }
            bVar2.c();
            com.tencent.mobileqq.guild.media.qcircle.b bVar3 = this.gamePresenter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gamePresenter");
                bVar3 = null;
            }
            bVar3.b();
            MediaNormalView mediaNormalView2 = this.normalContentView;
            if (mediaNormalView2 != null) {
                if (mediaNormalView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("normalContentView");
                } else {
                    mediaNormalView = mediaNormalView2;
                }
                mediaNormalView.b();
                return;
            }
            return;
        }
        this.rootView.removeAllViews();
        if (this.normalContentView == null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this.normalContentView = new MediaNormalView(context2, null, 2, null);
        }
        ViewGroup viewGroup2 = this.rootView;
        MediaNormalView mediaNormalView3 = this.normalContentView;
        if (mediaNormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalContentView");
            mediaNormalView3 = null;
        }
        viewGroup2.addView(mediaNormalView3);
        MediaNormalView mediaNormalView4 = this.normalContentView;
        if (mediaNormalView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalContentView");
            mediaNormalView4 = null;
        }
        if (!mediaNormalView4.a()) {
            QLog.d("QGMC.QCircle.MediaRoomContent", 1, "findFragment failed");
            com.tencent.mobileqq.guild.media.qcircle.d dVar2 = this.baseViewController;
            if (dVar2 != null) {
                FeedCloudMeta$StLive feedCloudMeta$StLive3 = this.mediaData;
                if (feedCloudMeta$StLive3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaData");
                    feedCloudMeta$StLive3 = null;
                }
                dVar2.a(feedCloudMeta$StLive3.room.roomType.get());
            }
        }
        com.tencent.mobileqq.guild.media.qcircle.b bVar4 = this.gamePresenter;
        if (bVar4 != null) {
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gamePresenter");
            } else {
                bVar = bVar4;
            }
            bVar.e();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void b() {
        l("\u6ed1\u5230\u4e0b\u4e00\u4e2a\u89c6\u9891\u4e86");
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void e() {
        if (this.roomInfo == null) {
            QLog.d("QGMC.QCircle.MediaRoomContent", 1, "onPageResume roomInfo is null");
            return;
        }
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        com.tencent.mobileqq.guild.media.qcircle.c cVar = this.roomInfo;
        Intrinsics.checkNotNull(cVar);
        if (!a16.K(cVar.getChannelId())) {
            QLog.d("QGMC.QCircle.MediaRoomContent", 1, "onPageResume need reEnter");
        } else if (MediaChannelCore.INSTANCE.a().o0().getStartParams().getFromPreView() == 0) {
            QLog.d("QGMC.QCircle.MediaRoomContent", 1, "onPageResume \u5df2\u7ecf\u6b63\u5f0f\u8fdb\u623f\u5728\u623f\u95f4\u91cc\u4e86");
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feedData;
        MediaNormalView mediaNormalView = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            feedCloudMeta$StFeed = null;
        }
        com.tencent.mobileqq.guild.media.qcircle.c cVar2 = this.roomInfo;
        Intrinsics.checkNotNull(cVar2);
        j30.a aVar = this.mediaController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaController");
            aVar = null;
        }
        h(feedCloudMeta$StFeed, cVar2, aVar);
        this.needExitRoom = true;
        MediaNormalView mediaNormalView2 = this.normalContentView;
        if (mediaNormalView2 != null) {
            if (mediaNormalView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalContentView");
            } else {
                mediaNormalView = mediaNormalView2;
            }
            mediaNormalView.setIsPause(false);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void f() {
        this.needExitRoom = false;
        if (this.roomInfo == null) {
            QLog.d("QGMC.QCircle.MediaRoomContent", 1, "jumpToChannel roomInfo is null");
            return;
        }
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo("functional_qq_little_world_feed", "");
        Bundle bundle = new Bundle();
        bundle.putInt("load_key_audio_entrance_type", 4);
        bundle.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
        bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, m());
        com.tencent.mobileqq.guild.media.qcircle.c cVar = this.roomInfo;
        Intrinsics.checkNotNull(cVar);
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(getContext(), ch.L(cVar.getGuildId()), ch.B(cVar.getChannelId()), bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void g() {
        this.roomInfo = null;
        String d16 = com.dataline.util.j.d("\u5c0f\u4e16\u754c\u6ed1\u8d70");
        Intrinsics.checkNotNullExpressionValue(d16, "replaceToDynamicNameText(\"\u5c0f\u4e16\u754c\u6ed1\u8d70\")");
        l(d16);
        g.d(-1);
        g.c("");
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void h(@NotNull FeedCloudMeta$StFeed data, @NotNull com.tencent.mobileqq.guild.media.qcircle.c roomInfo, @NotNull j30.a controller) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(controller, "controller");
        g.d(1);
        this.feedData = data;
        FeedCloudMeta$StLive feedCloudMeta$StLive = data.live.get();
        Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StLive, "data.live.get()");
        this.mediaData = feedCloudMeta$StLive;
        this.mediaController = controller;
        this.roomInfo = roomInfo;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = controller.c();
        k();
        q qVar = new q(roomInfo.getGuildId(), roomInfo.getChannelId(), 0, null, 12, null);
        qVar.m("functional_qq_little_world_feed");
        qVar.k(100);
        com.tencent.mobileqq.guild.media.core.j.a().c(qVar, new b(roomInfo, controller));
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void onActivityDestroy() {
        this.roomInfo = null;
        String d16 = com.dataline.util.j.d("\u5c0f\u4e16\u754c\u6240\u5728\u7684\u9875\u9762activity\u5df2\u7ecf\u9500\u6bc1");
        Intrinsics.checkNotNullExpressionValue(d16, "replaceToDynamicNameText(\"\u5c0f\u4e16\u754c\u6240\u5728\u7684\u9875\u9762activity\u5df2\u7ecf\u9500\u6bc1\")");
        l(d16);
        g.d(-1);
        g.c("");
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void onPagePause() {
        QLog.d("QGMC.QCircle.MediaRoomContent", 1, "page is paused");
        if (this.needExitRoom) {
            l("\u9875\u9762\u5207\u6362\u6682\u505c\u9000\u51fa");
        }
        MediaNormalView mediaNormalView = this.normalContentView;
        if (mediaNormalView != null) {
            if (mediaNormalView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalContentView");
                mediaNormalView = null;
            }
            mediaNormalView.setIsPause(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.e
    public void setFeedController(@Nullable com.tencent.mobileqq.guild.media.qcircle.d controller) {
        this.baseViewController = controller;
    }

    public /* synthetic */ MediaRoomContent(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaRoomContent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.ezb, this);
        View findViewById = findViewById(R.id.u8b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.content_ll)");
        this.rootView = (ViewGroup) findViewById;
        this.switchThemeObserver = new d();
        this.listenStateObserver = new c();
        View findViewById2 = findViewById(R.id.wpw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_\u2026_fragment_container_view)");
        ListenWidget listenWidget = (ListenWidget) findViewById2;
        this.listenWidget = listenWidget;
        this.listenWidgetPresenter = new ListenWidgetPresenter(listenWidget);
        this.needExitRoom = true;
    }
}
