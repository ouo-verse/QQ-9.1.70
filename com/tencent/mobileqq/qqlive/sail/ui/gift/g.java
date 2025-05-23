package com.tencent.mobileqq.qqlive.sail.ui.gift;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.live.gift.AnchorLiveGiftLogic;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanelEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015`\u0016H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/g;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", MiniChatConstants.MINI_APP_LANDSCAPE, "", "ha", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "U9", "V9", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/qqlive/anchor/live/gift/AnchorLiveGiftLogic;", "e", "Lcom/tencent/mobileqq/qqlive/anchor/live/gift/AnchorLiveGiftLogic;", "giftLogic", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "giftBanner", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "giftEffect", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g extends com.tencent.mobileqq.qqlive.sail.base.c implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorLiveGiftLogic giftLogic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout giftBanner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout giftEffect;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.gift.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.giftLogic = new AnchorLiveGiftLogic();
        }
    }

    private final void ha(boolean isLandscape) {
        LinearLayout linearLayout = this.giftBanner;
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (isLandscape) {
                layoutParams2.bottomToBottom = -1;
                layoutParams2.bottomToTop = R.id.f59752tk;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = wi2.c.b(62);
            } else {
                layoutParams2.bottomToTop = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = -1;
                layoutParams2.bottomToBottom = R.id.f61672yr;
            }
            linearLayout.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (F9() != null) {
            startInit();
            com.tencent.timi.game.initer.impl.b.f377190a.f(QQLiveSDKConfigHelper.getSceneId());
            this.giftLogic.i(this.giftBanner);
            this.giftLogic.j(this.giftEffect);
            this.giftLogic.f(H9(), J9(), Q9(), C9());
            SimpleEventBus.getInstance().registerReceiver(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveGiftShowPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.giftLogic.g();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(TimiGiftPanelEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f60972wv;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.giftLogic.h(z16);
            ha(z16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        LinearLayout linearLayout;
        KeyEvent.Callback callback;
        ViewStub viewStub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        FrameLayout frameLayout = null;
        if (rootView != null) {
            linearLayout = (LinearLayout) rootView.findViewById(R.id.f60972wv);
        } else {
            linearLayout = null;
        }
        this.giftBanner = linearLayout;
        if (rootView != null && (viewStub = (ViewStub) rootView.findViewById(R.id.f60982ww)) != null) {
            callback = viewStub.inflate();
        } else {
            callback = null;
        }
        if (callback instanceof FrameLayout) {
            frameLayout = (FrameLayout) callback;
        }
        this.giftEffect = frameLayout;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        if ((event instanceof TimiGiftPanelEvent) && (linearLayout = this.giftBanner) != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            TimiGiftPanelEvent timiGiftPanelEvent = (TimiGiftPanelEvent) event;
            if (timiGiftPanelEvent.getCmd() == 1) {
                int[] iArr = new int[2];
                linearLayout.getLocationOnScreen(iArr);
                int height = (iArr[1] + linearLayout.getHeight()) - (ViewUtils.getScreenHeight() - timiGiftPanelEvent.getPanelHeight());
                if (height >= 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = height;
                } else {
                    return;
                }
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = -1;
            }
            linearLayout.setLayoutParams(layoutParams2);
        }
    }
}
