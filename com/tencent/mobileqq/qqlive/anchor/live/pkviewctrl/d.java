package com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnDisconnectOtherRoomEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnFirstVideoFrameEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnUserVideoAvailableEvent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001HB\u000f\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J(\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u0004\u0018\u00010\u0011J\u0012\u0010%\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&H\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00108R\u0016\u0010;\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010=\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00102R\u0018\u0010@\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/d;", "Lcom/tencent/mobileqq/qqlive/framework/component/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnDisconnectOtherRoomEvent;", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnUserVideoAvailableEvent;", "w", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnFirstVideoFrameEvent;", "t", HippyTKDListViewAdapter.X, "Lhn3/a;", "anchorInfo", "v", "u", "Landroid/widget/FrameLayout;", "anchorVideoView", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/PKOtherAnchorVideoView;", "otherAnchorVideoView", "Landroid/view/ViewGroup;", "videoParent", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "otherAnchorVideoViewContainer", "y", "", "url", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "failedDrawable", "o", "k", "i", "r", ReportConstant.COSTREPORT_PREFIX, "p", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/component/core/event/Eventor;", "e", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lcom/tencent/mobileqq/qqlive/anchor/live/startlive/c;", "anchorStartLiveSupport", "Lcom/tencent/mobileqq/qqlive/anchor/live/startlive/c;", "", "f", "Z", "isLinkScreenState", "Landroid/content/Context;", h.F, "Landroid/content/Context;", "context", "Ljava/lang/String;", "otherAnchorUid", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "otherAnchorFirstFrameRendered", BdhLogUtil.LogTag.Tag_Conn, "otherAnchorVideoAvailable", "D", "Landroid/graphics/drawable/Drawable;", "videoParentBackground", "E", "Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/PKOtherAnchorVideoView;", "Lfi2/a;", "componentContext", "<init>", "(Lfi2/a;)V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d extends com.tencent.mobileqq.qqlive.framework.component.b implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean otherAnchorVideoAvailable;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Drawable videoParentBackground;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private PKOtherAnchorVideoView otherAnchorVideoViewContainer;

    @InjectService(key = com.tencent.mobileqq.qqlive.anchor.live.startlive.c.class)
    private com.tencent.mobileqq.qqlive.anchor.live.startlive.c anchorStartLiveSupport;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isLinkScreenState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String otherAnchorUid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean otherAnchorFirstFrameRendered;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/d$a;", "", "", "LINK_SCREEN_BG_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.pkviewctrl.d$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/pkviewctrl/d$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/b;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements OnEvent<LinkScreenEvent> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkScreenEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNull(event);
            LinkScreenAnchorInfo linkScreenAnchorInfo = event.getLinkScreenAnchorInfo();
            AegisLogger.INSTANCE.i("PK_Biz|PKVideoViewControlComponent", "rev LinkScreenEvent: " + event + ", anchorInfo " + linkScreenAnchorInfo);
            int type = event.getType();
            com.tencent.mobileqq.qqlive.anchor.live.startlive.c cVar = null;
            if (type != 1) {
                if (type == 2) {
                    d.this.u();
                    if (com.tencent.mobileqq.qqlive.sail.c.f272176a.d().r() == 2) {
                        com.tencent.mobileqq.qqlive.anchor.live.startlive.c cVar2 = d.this.anchorStartLiveSupport;
                        if (cVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("anchorStartLiveSupport");
                        } else {
                            cVar = cVar2;
                        }
                        cVar.c();
                        return;
                    }
                    return;
                }
                return;
            }
            com.tencent.mobileqq.qqlive.sail.c cVar3 = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            if (cVar3.d().r() == 2) {
                com.tencent.mobileqq.qqlive.anchor.live.startlive.c cVar4 = d.this.anchorStartLiveSupport;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("anchorStartLiveSupport");
                } else {
                    cVar = cVar4;
                }
                cVar.d(event.c(cVar3.G()));
            }
            d.this.v(linkScreenAnchorInfo);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull fi2.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentContext);
        } else {
            this.eventor = new Eventor();
        }
    }

    private final Drawable o(String url, Drawable loadingDrawable, Drawable failedDrawable) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = loadingDrawable;
        obtain.mFailedDrawable = failedDrawable;
        obtain.mRequestHeight = ViewUtils.getScreenHeight() / 8;
        obtain.mRequestWidth = ViewUtils.getScreenWidth() / 8;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, option)");
        return drawable;
    }

    private final void q(OnDisconnectOtherRoomEvent event) {
        AegisLogger.INSTANCE.i("PK_Biz|PKVideoViewControlComponent", "onDisConnectRoom", "appId: " + event.getAppId() + ", isLinkScreenState " + this.isLinkScreenState);
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID) && this.isLinkScreenState) {
            u();
        }
    }

    private final void t(OnFirstVideoFrameEvent event) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|PKVideoViewControlComponent", "onFirstFrameEvent, appId: " + event.getAppId() + ", userId: " + event.getUserId() + ", otherAnchorUid: " + this.otherAnchorUid);
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID) && !TextUtils.isEmpty(event.getUserId())) {
            this.otherAnchorFirstFrameRendered = true;
            PKOtherAnchorVideoView pKOtherAnchorVideoView = this.otherAnchorVideoViewContainer;
            if (pKOtherAnchorVideoView != null) {
                pKOtherAnchorVideoView.c();
                Unit unit = Unit.INSTANCE;
                companion.i("PK_Biz|PKVideoViewControlComponent", UIJsPlugin.EVENT_HIDE_LOADING);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|PKVideoViewControlComponent", "onLinkScreenEnd");
        com.tencent.mobileqq.qqlive.anchor.live.startlive.c cVar = this.anchorStartLiveSupport;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorStartLiveSupport");
            cVar = null;
        }
        FrameLayout b16 = cVar.b();
        if (b16 == null) {
            companion.w("PK_Biz|PKVideoViewControlComponent", "empty anchorVideoView");
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.live.startlive.c cVar2 = this.anchorStartLiveSupport;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorStartLiveSupport");
            cVar2 = null;
        }
        ViewGroup a16 = cVar2.a();
        if (a16 == null) {
            companion.w("PK_Biz|PKVideoViewControlComponent", "empty anchorVideoViewParent");
            return;
        }
        PKOtherAnchorVideoView pKOtherAnchorVideoView = this.otherAnchorVideoViewContainer;
        if (pKOtherAnchorVideoView == null) {
            companion.w("PK_Biz|PKVideoViewControlComponent", "empty otherAnchorVideoViewContainer");
            return;
        }
        this.otherAnchorUid = null;
        this.isLinkScreenState = false;
        this.otherAnchorVideoAvailable = false;
        this.otherAnchorFirstFrameRendered = false;
        y(b16, pKOtherAnchorVideoView, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(LinkScreenAnchorInfo anchorInfo) {
        Context context;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|PKVideoViewControlComponent", "onLinkScreenStart");
        com.tencent.mobileqq.qqlive.anchor.live.startlive.c cVar = this.anchorStartLiveSupport;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorStartLiveSupport");
            cVar = null;
        }
        FrameLayout b16 = cVar.b();
        if (b16 == null) {
            companion.w("PK_Biz|PKVideoViewControlComponent", "empty anchorVideoView");
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.live.startlive.c cVar2 = this.anchorStartLiveSupport;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorStartLiveSupport");
            cVar2 = null;
        }
        ViewGroup a16 = cVar2.a();
        if (a16 == null) {
            companion.w("PK_Biz|PKVideoViewControlComponent", "empty anchorVideoViewParent");
            return;
        }
        if (anchorInfo == null) {
            companion.w("PK_Biz|PKVideoViewControlComponent", "empty anchorInfo");
            return;
        }
        this.isLinkScreenState = true;
        this.otherAnchorUid = String.valueOf(anchorInfo.getUin());
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        } else {
            context = context2;
        }
        PKOtherAnchorVideoView pKOtherAnchorVideoView = new PKOtherAnchorVideoView(context, null, 0, 6, null);
        this.otherAnchorVideoViewContainer = pKOtherAnchorVideoView;
        z(b16, pKOtherAnchorVideoView, a16);
    }

    private final void w(OnUserVideoAvailableEvent event) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|PKVideoViewControlComponent", "onUserVideoAvailable", "appId: " + event.getAppId() + "userId: " + event.getUserId() + ", available: " + event.getAvailable() + ", otherAnchorUid " + this.otherAnchorUid);
        if (Intrinsics.areEqual(event.getAppId(), QQLiveBusinessConfig.QQLIVE_APP_ID) && !TextUtils.isEmpty(event.getUserId())) {
            if (event.getAvailable()) {
                PKOtherAnchorVideoView pKOtherAnchorVideoView = this.otherAnchorVideoViewContainer;
                if (pKOtherAnchorVideoView != null) {
                    pKOtherAnchorVideoView.c();
                    Unit unit = Unit.INSTANCE;
                    companion.i("PK_Biz|PKVideoViewControlComponent", UIJsPlugin.EVENT_HIDE_LOADING);
                }
            } else {
                PKOtherAnchorVideoView pKOtherAnchorVideoView2 = this.otherAnchorVideoViewContainer;
                if (pKOtherAnchorVideoView2 != null) {
                    pKOtherAnchorVideoView2.d();
                    Unit unit2 = Unit.INSTANCE;
                    companion.i("PK_Biz|PKVideoViewControlComponent", UIJsPlugin.EVENT_SHOW_LOADING);
                }
            }
            this.otherAnchorVideoAvailable = event.getAvailable();
        }
    }

    private final void x() {
        this.eventor.addOnEvent(new b());
    }

    private final void y(FrameLayout anchorVideoView, FrameLayout otherAnchorVideoViewContainer, ViewGroup videoParent) {
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
        AegisLogger.INSTANCE.i("PK_Biz|PKVideoViewControlComponent", "switchToAnchorLiveState done");
    }

    private final void z(FrameLayout anchorVideoView, PKOtherAnchorVideoView otherAnchorVideoView, ViewGroup videoParent) {
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
        videoParent.setBackground(o("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLC5ccicyozZfWWO2B0b4wIc0cHEnic21sRGsGaaeUVEyVVQ/", new ColorDrawable(0), videoParent.getBackground()));
        videoParent.addView(otherAnchorVideoView, 0, layoutParams3);
        AegisLogger.INSTANCE.i("PK_Biz|PKVideoViewControlComponent", "switchToLinkScreenState", "otherAnchorFirstFrameRendered:" + this.otherAnchorFirstFrameRendered);
        if (this.otherAnchorFirstFrameRendered) {
            otherAnchorVideoView.c();
        } else {
            otherAnchorVideoView.d();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(OnFirstVideoFrameEvent.class, OnUserVideoAvailableEvent.class, OnDisconnectOtherRoomEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            AegisLogger.INSTANCE.d("PK_Biz|PKVideoViewControlComponent", "unInitComponent");
            this.eventor.removeAll();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.context = e().getContext();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        if (event instanceof OnFirstVideoFrameEvent) {
            t((OnFirstVideoFrameEvent) event);
        } else if (event instanceof OnUserVideoAvailableEvent) {
            w((OnUserVideoAvailableEvent) event);
        } else if (event instanceof OnDisconnectOtherRoomEvent) {
            q((OnDisconnectOtherRoomEvent) event);
        }
    }

    @Nullable
    public final FrameLayout p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        PKOtherAnchorVideoView pKOtherAnchorVideoView = this.otherAnchorVideoViewContainer;
        if (pKOtherAnchorVideoView != null) {
            return pKOtherAnchorVideoView.b();
        }
        return null;
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("PK_Biz|PKVideoViewControlComponent", "onEnterRoom");
        x();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("PK_Biz|PKVideoViewControlComponent", "onExitRoom, isLinkScreenState " + this.isLinkScreenState);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.eventor.removeAll();
        if (this.isLinkScreenState) {
            u();
        }
    }
}
