package com.tencent.mobileqq.qqlive.sail.ui.game;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.gamedownloader.GameDistributeNotifyEvent;
import com.tencent.mobileqq.qqlive.room.gamedownloader.card.CardMode;
import com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeBtn;
import com.tencent.mobileqq.qqlive.room.gamedownloader.widget.State;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt3.ab;
import tl.h;

@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 l2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001mB\u0007\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\u0014\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-0,H\u0016J\u0012\u0010/\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010?\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0018\u0010A\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0018\u0010C\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00106R\u0018\u0010E\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00102R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u0004\u0018\u00010c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020[8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bg\u0010h\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/game/QQLiveGameCardPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qqlive/gamedownloader/GameDistributeNotifyEvent;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "Da", "", "url", "Lcom/tencent/biz/ui/TouchWebView;", "xa", "Lcr4/b;", "gameInfo", "Fa", "qa", "sa", "ta", VirtualAppProxy.KEY_GAME_ID, "arg0", "", "state", "va", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "U9", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Lfp4/c;", "msgInfo", "onPush", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onPartPause", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "cardContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "gameLogoIv", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "gameNameTv", "i", "gameDescTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "permissionTv", BdhLogUtil.LogTag.Tag_Conn, "privacyTv", "D", "closeBtn", "E", "gameCenterBtnContainer", "Landroid/widget/Button;", UserInfo.SEX_FEMALE, "Landroid/widget/Button;", "gameCustomBtn", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeBtn;", "G", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeBtn;", "customDistributeBtn", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "H", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "distributeButton", "I", "Lcom/tencent/biz/ui/TouchWebView;", "cardWebView", "Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", "J", "Lkotlin/Lazy;", "za", "()Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", "gameViewModel", "", "K", "Z", "isTriggering", "Ljava/lang/Runnable;", "L", "Ljava/lang/Runnable;", "bindCardRunnable", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "Ba", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "Aa", "()Z", "hasGameInfo", "<init>", "()V", "M", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveGameCardPart extends com.tencent.mobileqq.qqlive.sail.base.c implements SimpleEventReceiver<GameDistributeNotifyEvent>, View.OnClickListener, com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView privacyTv;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView closeBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ViewGroup gameCenterBtnContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Button gameCustomBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QQLiveCustomDistributeBtn customDistributeBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private IDistributeButton distributeButton;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TouchWebView cardWebView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isTriggering;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Runnable bindCardRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup cardContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView gameLogoIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView gameNameTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView gameDescTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView permissionTv;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/game/QQLiveGameCardPart$a;", "", "", "ICON_SIZE", UserInfo.SEX_FEMALE, "", "NOTIFY_DELAY", "J", "", "SCALE_HEIGHT_FACTOR", "D", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.game.QQLiveGameCardPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveGameCardPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<GameRecommendViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.QQLiveGameCardPart$gameViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGameCardPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GameRecommendViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GameRecommendViewModel) QQLiveGameCardPart.this.getViewModel(GameRecommendViewModel.class) : (GameRecommendViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.gameViewModel = lazy;
            this.bindCardRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.e
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGameCardPart.ua(QQLiveGameCardPart.this);
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final boolean Aa() {
        AudienceRoomInfo b16;
        ab o16;
        com.tencent.mobileqq.qqlive.sail.room.e Ba = Ba();
        if (Ba == null || (b16 = Ba.b()) == null || (o16 = b16.o()) == null || !o16.f432226a) {
            return false;
        }
        return true;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e Ba() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Da() {
        String S1 = za().S1();
        if (za().U1() == 1) {
            za().k2(getActivity(), null, S1);
        } else {
            za().k2(getActivity(), xa(S1), S1);
        }
        if (za().h2()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGameCardPart.Ea(QQLiveGameCardPart.this);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(QQLiveGameCardPart this$0) {
        State state;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn = this$0.customDistributeBtn;
        if (qQLiveCustomDistributeBtn == null || (state = qQLiveCustomDistributeBtn.o()) == null) {
            state = State.IDLE;
        }
        int value = state.getValue();
        QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn2 = this$0.customDistributeBtn;
        if (qQLiveCustomDistributeBtn2 != null) {
            i3 = qQLiveCustomDistributeBtn2.n();
        } else {
            i3 = 0;
        }
        this$0.va(this$0.za().a2(), String.valueOf(i3), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa(cr4.b gameInfo) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = wi2.c.a(54.0f);
        obtain.mRequestHeight = wi2.c.a(54.0f);
        URLDrawable drawable = URLDrawable.getDrawable(gameInfo.f391713d, obtain);
        ImageView imageView = this.gameLogoIv;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        TextView textView = this.gameNameTv;
        if (textView != null) {
            textView.setText(gameInfo.f391711b);
        }
        TextView textView2 = this.gameDescTv;
        if (textView2 != null) {
            textView2.setText(gameInfo.f391714e);
        }
        if (za().f2()) {
            sa(gameInfo);
        } else if (za().g2()) {
            ta();
        } else {
            qa(gameInfo);
        }
        ViewGroup viewGroup = this.cardContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.bindCardRunnable, 1000L);
    }

    private final void qa(cr4.b gameInfo) {
        AegisLogger.INSTANCE.i("Audience|QQLiveGameCardPart", "addCustomDownloadBtn");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        final QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn = new QQLiveCustomDistributeBtn(context, null, 0, 6, null);
        qQLiveCustomDistributeBtn.q(getActivity(), gameInfo);
        qQLiveCustomDistributeBtn.C();
        qQLiveCustomDistributeBtn.setListener(za().W1());
        qQLiveCustomDistributeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveGameCardPart.ra(QQLiveGameCardPart.this, qQLiveCustomDistributeBtn, view);
            }
        });
        this.customDistributeBtn = qQLiveCustomDistributeBtn;
        ViewGroup viewGroup = this.gameCenterBtnContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(qQLiveCustomDistributeBtn, new ViewGroup.LayoutParams(-1, -1));
            viewGroup.setVisibility(0);
            Button button = this.gameCustomBtn;
            if (button != null) {
                button.setVisibility(8);
            }
            a.a(za(), qQLiveCustomDistributeBtn);
        }
        Button button2 = this.gameCustomBtn;
        if (button2 != null) {
            button2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(QQLiveGameCardPart this$0, QQLiveCustomDistributeBtn this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        a.g(this$0.za(), this_apply);
        this_apply.A();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void sa(cr4.b gameInfo) {
        int i3;
        boolean z16;
        ViewGroup viewGroup;
        AegisLogger.INSTANCE.i("Audience|QQLiveGameCardPart", "addGameCenterIcon");
        String string = getContext().getResources().getString(R.string.f210665iq);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ng.qqlive_game_subscribe)");
        String string2 = getContext().getResources().getString(R.string.f210645io);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026ing.qqlive_game_download)");
        String string3 = getContext().getResources().getString(R.string.f210655ip);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026ring.qqlive_game_pausing)");
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("biz_ext_data");
        if (bundleExtra != null) {
            i3 = bundleExtra.getInt(WadlProxyConsts.VIA_AUTO_DOWNLOAD, 0);
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        GameRecommendViewModel za5 = za();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        IDistributeButton P1 = za5.P1(context, gameInfo, string, string2, string3, z16);
        this.distributeButton = P1;
        if (P1 != 0 && (viewGroup = this.gameCenterBtnContainer) != null) {
            P1.addEventListener(za().Z1());
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            viewGroup.removeAllViews();
            viewGroup.addView((View) P1, layoutParams);
            viewGroup.setVisibility(0);
            QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn = this.customDistributeBtn;
            if (qQLiveCustomDistributeBtn != null) {
                qQLiveCustomDistributeBtn.setVisibility(8);
            }
        }
        Button button = this.gameCustomBtn;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    private final void ta() {
        String string;
        AegisLogger.INSTANCE.i("Audience|QQLiveGameCardPart", "addNormalBtn");
        ViewGroup viewGroup = this.gameCenterBtnContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        Button button = this.gameCustomBtn;
        if (button != null) {
            if (za().T1() == CardMode.SUBSCRIBE_FROM_CUSTOM_H5) {
                string = button.getResources().getString(R.string.f210665iq);
            } else {
                string = button.getResources().getString(R.string.f210645io);
            }
            button.setText(string);
            button.setVisibility(0);
            a.a(za(), button);
        }
        ViewGroup viewGroup2 = this.gameCenterBtnContainer;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(QQLiveGameCardPart this$0) {
        int c26;
        State state;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.za().e2()) {
            if (this$0.za().h2()) {
                QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn = this$0.customDistributeBtn;
                if (qQLiveCustomDistributeBtn == null || (state = qQLiveCustomDistributeBtn.o()) == null) {
                    state = State.IDLE;
                }
                c26 = state.getValue();
            } else {
                c26 = this$0.za().c2();
            }
        } else {
            c26 = this$0.za().c2();
        }
        ViewGroup viewGroup = this$0.cardContainer;
        if (viewGroup != null) {
            a.b(this$0.za(), viewGroup, c26);
        }
    }

    private final void va(final String gameId, final String arg0, final int state) {
        AegisLogger.INSTANCE.i("Audience|QQLiveGameCardPart", "callJs", "state=" + state + ", arg0=" + arg0 + ", gameId=" + gameId);
        final TouchWebView touchWebView = this.cardWebView;
        if (touchWebView != null) {
            touchWebView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGameCardPart.wa(TouchWebView.this, state, arg0, gameId);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(TouchWebView this_run, int i3, String arg0, String gameId) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(arg0, "$arg0");
        Intrinsics.checkNotNullParameter(gameId, "$gameId");
        this_run.loadUrl("javascript:notifyGameDownloadStatus('" + i3 + "','" + arg0 + "','" + gameId + "');");
    }

    private final TouchWebView xa(String url) {
        if (this.cardWebView == null) {
            GameRecommendViewModel za5 = za();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            this.cardWebView = za5.t2(activity, url);
        }
        return this.cardWebView;
    }

    private final GameRecommendViewModel za() {
        Object value = this.gameViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gameViewModel>(...)");
        return (GameRecommendViewModel) value;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.U9();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            if (!Aa()) {
                AegisLogger.INSTANCE.i("Audience|QQLiveGameCardPart", "onEnterRoom", "no game info");
                ViewGroup viewGroup = this.cardContainer;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                    return;
                }
                return;
            }
            startInit();
            F9.p(285, this);
            za().j2(F9.getRoomId(), C9());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Audience|QQLiveGameCardPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.V9();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.bindCardRunnable);
        QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn = this.customDistributeBtn;
        if (qQLiveCustomDistributeBtn != null) {
            qQLiveCustomDistributeBtn.B();
        }
        this.customDistributeBtn = null;
        IDistributeButton iDistributeButton = this.distributeButton;
        if (iDistributeButton != null) {
            iDistributeButton.removeEventListeners();
        }
        this.distributeButton = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GameDistributeNotifyEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        ArrayList<Class<GameDistributeNotifyEvent>> arrayList = new ArrayList<>();
        arrayList.add(GameDistributeNotifyEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f60882wm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            final View view = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60882wm) {
                Da();
            } else if (num != null && num.intValue() == R.id.f631232o) {
                Da();
                Button button = this.gameCustomBtn;
                if (button != null) {
                    a.g(za(), button);
                }
            } else if (num != null && num.intValue() == R.id.f631832u) {
                GameRecommendViewModel za5 = za();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                za5.p2(context);
            } else if (num != null && num.intValue() == R.id.f631732t) {
                GameRecommendViewModel za6 = za();
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                za6.o2(context2);
            } else if (num != null && num.intValue() == R.id.f631332p) {
                ViewGroup viewGroup = this.cardContainer;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
            } else if (num != null && num.intValue() == R.id.f631132n && !this.isTriggering) {
                ViewGroup viewGroup2 = this.gameCenterBtnContainer;
                if (viewGroup2 != null) {
                    view = viewGroup2.getChildAt(0);
                }
                if (view != null) {
                    if (!za().i2()) {
                        view.performClick();
                    } else {
                        this.isTriggering = true;
                        za().s2(new Function1<Boolean, Unit>(view, this) { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.QQLiveGameCardPart$onClick$2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ View $childBtn;
                            final /* synthetic */ QQLiveGameCardPart this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                this.$childBtn = view;
                                this.this$0 = this;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) view, (Object) this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                    return;
                                }
                                if (z16) {
                                    this.$childBtn.performClick();
                                } else {
                                    QQToast.makeText(this.this$0.getContext(), 1, "\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", 0).show();
                                }
                                this.this$0.isTriggering = false;
                            }
                        });
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null && (viewGroup = this.cardContainer) != null) {
            if (configuration.orientation != 2) {
                i3 = 0;
            }
            viewGroup.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        ViewGroup viewGroup2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Button button = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f60882wm);
        } else {
            viewGroup = null;
        }
        this.cardContainer = viewGroup;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f631532r);
        } else {
            imageView = null;
        }
        this.gameLogoIv = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f631632s);
        } else {
            textView = null;
        }
        this.gameNameTv = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f631432q);
        } else {
            textView2 = null;
        }
        this.gameDescTv = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        if (rootView != null) {
            textView3 = (TextView) rootView.findViewById(R.id.f631732t);
        } else {
            textView3 = null;
        }
        this.permissionTv = textView3;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        if (rootView != null) {
            textView4 = (TextView) rootView.findViewById(R.id.f631832u);
        } else {
            textView4 = null;
        }
        this.privacyTv = textView4;
        if (textView4 != null) {
            textView4.setOnClickListener(this);
        }
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.f631332p);
        } else {
            imageView2 = null;
        }
        this.closeBtn = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        if (rootView != null) {
            viewGroup2 = (ViewGroup) rootView.findViewById(R.id.f631132n);
        } else {
            viewGroup2 = null;
        }
        this.gameCenterBtnContainer = viewGroup2;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
        }
        if (rootView != null) {
            button = (Button) rootView.findViewById(R.id.f631232o);
        }
        this.gameCustomBtn = button;
        if (button != null) {
            button.setOnClickListener(this);
        }
        LiveData<cr4.b> b26 = za().b2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<cr4.b, Unit> function1 = new Function1<cr4.b, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.QQLiveGameCardPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGameCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cr4.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable cr4.b bVar) {
                ViewGroup viewGroup3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                if (bVar == null) {
                    viewGroup3 = QQLiveGameCardPart.this.cardContainer;
                    if (viewGroup3 == null) {
                        return;
                    }
                    viewGroup3.setVisibility(8);
                    return;
                }
                QQLiveGameCardPart.this.Fa(bVar);
            }
        };
        b26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveGameCardPart.Ca(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn = this.customDistributeBtn;
        if (qQLiveCustomDistributeBtn != null) {
            qQLiveCustomDistributeBtn.B();
        }
        this.customDistributeBtn = null;
        IDistributeButton iDistributeButton = this.distributeButton;
        if (iDistributeButton != null) {
            iDistributeButton.removeEventListeners();
        }
        this.distributeButton = null;
        TouchWebView touchWebView = this.cardWebView;
        if (touchWebView != null) {
            touchWebView.clearView();
        }
        TouchWebView touchWebView2 = this.cardWebView;
        if (touchWebView2 != null) {
            touchWebView2.destroy();
        }
        this.cardWebView = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        TouchWebView touchWebView = this.cardWebView;
        if (touchWebView != null) {
            touchWebView.clearView();
        }
        TouchWebView touchWebView2 = this.cardWebView;
        if (touchWebView2 != null) {
            touchWebView2.destroy();
        }
        this.cardWebView = null;
        com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.e();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        QQLiveCustomDistributeBtn qQLiveCustomDistributeBtn = this.customDistributeBtn;
        if (qQLiveCustomDistributeBtn != null) {
            qQLiveCustomDistributeBtn.C();
        }
        IDistributeButton iDistributeButton = this.distributeButton;
        if (iDistributeButton != null) {
            iDistributeButton.update();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        wq4.a t16 = com.tencent.mobileqq.qqlive.sail.push.a.t(msgInfo);
        if (t16 != null) {
            za().q2(t16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) event);
        } else if (event instanceof GameDistributeNotifyEvent) {
            GameDistributeNotifyEvent gameDistributeNotifyEvent = (GameDistributeNotifyEvent) event;
            va(gameDistributeNotifyEvent.getGameId(), gameDistributeNotifyEvent.getArg0(), gameDistributeNotifyEvent.getCurrentState());
        }
    }
}
