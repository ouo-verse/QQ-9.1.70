package com.tencent.mobileqq.qqlive.sail.ui.linkscreen;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.live.pkstate.h;
import com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.PKOtherAnchorVideoView;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnDisconnectOtherRoomEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnFirstVideoFrameEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnUserVideoAvailableEvent;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.now.linkscreengame.model.LinkScreenModel;
import com.tencent.qqlive.common.api.AegisLogger;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import io3.LinkMuteEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0017\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018J$\u0010\u001d\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u001f\u001a\u00020\u001eJ<\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eJ$\u0010#\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010!\u001a\u00020'2\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u0018\u0010*\u001a\u00020\u00102\u0006\u0010!\u001a\u00020)2\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ,\u0010,\u001a\u00020\u00102\u0006\u0010!\u001a\u00020+2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eR\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00105R\u0016\u0010A\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00105\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/d;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lhn3/a;", "info", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/c;", "pkViewService", "Lei2/a;", "crossRoomService", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/a;", "L1", "Landroid/widget/FrameLayout;", "anchorVideoView", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/PKOtherAnchorVideoView;", "otherAnchorVideoView", "Landroid/view/ViewGroup;", "videoParent", "", "Z1", "otherAnchorVideoViewContainer", "X1", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "failedDrawable", "M1", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "roomInfo", "P1", "preview", "previewContainer", "Q1", "", "N1", "Lhn3/b;", "event", "U1", "S1", "Lio3/a;", "muteEvent", "T1", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnUserVideoAvailableEvent;", "W1", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnFirstVideoFrameEvent;", "R1", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnDisconnectOtherRoomEvent;", "O1", "Lcom/tencent/now/linkscreengame/model/LinkScreenModel;", "i", "Lcom/tencent/now/linkscreengame/model/LinkScreenModel;", "linkScreenModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/anchor/live/pkstate/a;", "linkScreenAnchorPlay", BdhLogUtil.LogTag.Tag_Conn, "Z", "isLinkScreenState", "", "D", "Ljava/lang/String;", "otherAnchorUid", "E", "Landroid/graphics/drawable/Drawable;", "videoParentBackground", UserInfo.SEX_FEMALE, "otherAnchorFirstFrameRendered", "G", "otherAnchorVideoAvailable", "<init>", "()V", "H", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLinkScreenState;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String otherAnchorUid;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable videoParentBackground;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean otherAnchorFirstFrameRendered;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean otherAnchorVideoAvailable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinkScreenModel linkScreenModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.anchor.live.pkstate.a linkScreenAnchorPlay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/d$a;", "", "", "LINK_SCREEN_BG_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.d$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52314);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.otherAnchorUid = "";
        }
    }

    private final com.tencent.mobileqq.qqlive.anchor.live.pkstate.a L1(LinkScreenAnchorInfo info, com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c pkViewService, ei2.a crossRoomService) {
        if (com.tencent.now.linkscreengame.model.c.f338502a.a(info.getLiveType())) {
            return new com.tencent.mobileqq.qqlive.anchor.live.pkstate.c(pkViewService);
        }
        return new h(crossRoomService, pkViewService);
    }

    private final Drawable M1(Drawable loadingDrawable, Drawable failedDrawable) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = loadingDrawable;
        obtain.mFailedDrawable = failedDrawable;
        obtain.mRequestHeight = ViewUtils.getScreenHeight() / 8;
        obtain.mRequestWidth = ViewUtils.getScreenWidth() / 8;
        URLDrawable drawable = URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLC5ccicyozZfWWO2B0b4wIc0cHEnic21sRGsGaaeUVEyVVQ/", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(LINK_SCREEN_BG_URL, option)");
        return drawable;
    }

    private final void X1(FrameLayout anchorVideoView, FrameLayout otherAnchorVideoViewContainer, ViewGroup videoParent) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|LinkScreenViewModel", "switchToAnchorLiveState");
        videoParent.removeView(otherAnchorVideoViewContainer);
        videoParent.setBackground(this.videoParentBackground);
        this.videoParentBackground = null;
        ViewGroup.LayoutParams layoutParams = anchorVideoView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.topMargin = 0;
        anchorVideoView.setLayoutParams(layoutParams2);
        companion.i("PK_Biz|LinkScreenViewModel", "switchToAnchorLiveState done");
    }

    private final void Z1(FrameLayout anchorVideoView, PKOtherAnchorVideoView otherAnchorVideoView, ViewGroup videoParent) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|LinkScreenViewModel", "switchToLinkScreenState");
        com.tencent.now.linkscreengame.model.d dVar = com.tencent.now.linkscreengame.model.d.f338503a;
        Rect a16 = dVar.a();
        ViewGroup.LayoutParams layoutParams = anchorVideoView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = a16.width();
        layoutParams2.height = a16.height();
        layoutParams2.topMargin = a16.top;
        anchorVideoView.setLayoutParams(layoutParams2);
        Rect b16 = dVar.b();
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(b16.width(), b16.height());
        layoutParams3.leftMargin = b16.left;
        layoutParams3.topMargin = b16.top;
        this.videoParentBackground = videoParent.getBackground();
        videoParent.setBackground(M1(new ColorDrawable(0), videoParent.getBackground()));
        videoParent.addView(otherAnchorVideoView, 0, layoutParams3);
        companion.i("PK_Biz|LinkScreenViewModel", "switchToLinkScreenState", "otherAnchorFirstFrameRendered:" + this.otherAnchorFirstFrameRendered);
        if (this.otherAnchorFirstFrameRendered) {
            otherAnchorVideoView.c();
        } else {
            otherAnchorVideoView.d();
        }
    }

    public final boolean N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        LinkScreenModel linkScreenModel = this.linkScreenModel;
        if (linkScreenModel != null) {
            return linkScreenModel.j();
        }
        return false;
    }

    public final void O1(@NotNull OnDisconnectOtherRoomEvent event, @Nullable PKOtherAnchorVideoView otherAnchorVideoViewContainer, @Nullable FrameLayout preview, @Nullable ViewGroup previewContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, event, otherAnchorVideoViewContainer, preview, previewContainer);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenViewModel", "onDisconnectOtherRoom", "appId: " + event.getAppId() + ", isLinkScreenState=" + this.isLinkScreenState);
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID) && this.isLinkScreenState) {
            S1(otherAnchorVideoViewContainer, preview, previewContainer);
        }
    }

    public final void P1(@NotNull com.tencent.mobileqq.qqlive.sail.model.d roomInfo) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) roomInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenViewModel", "onEnterRoom");
        long roomId = roomInfo.getRoomId();
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j16 = roomInfo.j();
        if (j16 != null) {
            j3 = j16.f();
        } else {
            j3 = 0;
        }
        this.linkScreenModel = new LinkScreenModel(roomId, j3);
    }

    public final void Q1(@Nullable PKOtherAnchorVideoView otherAnchorVideoViewContainer, @Nullable FrameLayout preview, @Nullable ViewGroup previewContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, otherAnchorVideoViewContainer, preview, previewContainer);
            return;
        }
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenViewModel", "onExitRoom");
        LinkScreenModel linkScreenModel = this.linkScreenModel;
        if (linkScreenModel != null) {
            linkScreenModel.n();
        }
        this.linkScreenModel = null;
        if (this.isLinkScreenState) {
            S1(otherAnchorVideoViewContainer, preview, previewContainer);
        }
    }

    public final void R1(@NotNull OnFirstVideoFrameEvent event, @Nullable PKOtherAnchorVideoView otherAnchorVideoViewContainer) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event, (Object) otherAnchorVideoViewContainer);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenViewModel", "onFirstVideoFrame, appId: " + event.getAppId() + ", userId: " + event.getUserId());
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(event.getUserId());
            if (!isBlank) {
                this.otherAnchorFirstFrameRendered = true;
                if (otherAnchorVideoViewContainer != null) {
                    otherAnchorVideoViewContainer.c();
                }
            }
        }
    }

    public final void S1(@Nullable PKOtherAnchorVideoView otherAnchorVideoViewContainer, @Nullable FrameLayout preview, @Nullable ViewGroup previewContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, otherAnchorVideoViewContainer, preview, previewContainer);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|LinkScreenViewModel", "onLinkEnd");
        com.tencent.mobileqq.qqlive.anchor.live.pkstate.a aVar = this.linkScreenAnchorPlay;
        if (aVar != null) {
            aVar.a();
        }
        this.linkScreenAnchorPlay = null;
        if (preview != null && previewContainer != null && otherAnchorVideoViewContainer != null) {
            this.otherAnchorUid = "";
            this.isLinkScreenState = false;
            this.otherAnchorVideoAvailable = false;
            this.otherAnchorFirstFrameRendered = false;
            X1(preview, otherAnchorVideoViewContainer, previewContainer);
            return;
        }
        companion.i("PK_Biz|LinkScreenViewModel", "onLinkEnd", "invalid params");
    }

    public final void T1(@NotNull LinkMuteEvent muteEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) muteEvent);
            return;
        }
        Intrinsics.checkNotNullParameter(muteEvent, "muteEvent");
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenViewModel", "onLinkMute");
        com.tencent.mobileqq.qqlive.anchor.live.pkstate.a aVar = this.linkScreenAnchorPlay;
        if (aVar != null) {
            aVar.b(muteEvent);
        }
    }

    public final void U1(@NotNull LinkScreenEvent event, @NotNull com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.c pkViewService, @NotNull ei2.a crossRoomService, @Nullable PKOtherAnchorVideoView otherAnchorVideoViewContainer, @Nullable FrameLayout preview, @Nullable ViewGroup previewContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, event, pkViewService, crossRoomService, otherAnchorVideoViewContainer, preview, previewContainer);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(pkViewService, "pkViewService");
        Intrinsics.checkNotNullParameter(crossRoomService, "crossRoomService");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|LinkScreenViewModel", "onLinkStart");
        LinkScreenAnchorInfo linkScreenAnchorInfo = event.getLinkScreenAnchorInfo();
        if (linkScreenAnchorInfo == null) {
            companion.i("PK_Biz|LinkScreenViewModel", "onLinkStart", "invalid anchor info");
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.live.pkstate.a L1 = L1(linkScreenAnchorInfo, pkViewService, crossRoomService);
        this.linkScreenAnchorPlay = L1;
        companion.i("PK_Biz|LinkScreenViewModel", "onLinkStart", "create linkScreenAnchorPlay: " + L1);
        com.tencent.mobileqq.qqlive.anchor.live.pkstate.a aVar = this.linkScreenAnchorPlay;
        if (aVar != null) {
            aVar.c(event);
        }
        if (otherAnchorVideoViewContainer != null && preview != null && previewContainer != null) {
            this.isLinkScreenState = true;
            this.otherAnchorUid = String.valueOf(linkScreenAnchorInfo.getUin());
            Z1(preview, otherAnchorVideoViewContainer, previewContainer);
            return;
        }
        companion.i("PK_Biz|LinkScreenViewModel", "onLinkStart", "invalid views");
    }

    public final void W1(@NotNull OnUserVideoAvailableEvent event, @Nullable PKOtherAnchorVideoView otherAnchorVideoViewContainer) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event, (Object) otherAnchorVideoViewContainer);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenViewModel", "onUserVideoAvailable", "appId: " + event.getAppId() + ", userId=" + event.getUserId() + ", available=" + event.getAvailable());
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(event.getUserId());
            if (!isBlank) {
                if (event.getAvailable()) {
                    if (otherAnchorVideoViewContainer != null) {
                        otherAnchorVideoViewContainer.c();
                    }
                } else if (otherAnchorVideoViewContainer != null) {
                    otherAnchorVideoViewContainer.d();
                }
                this.otherAnchorVideoAvailable = event.getAvailable();
            }
        }
    }
}
