package com.tencent.mobileqq.qqlive.sail.ui.paylevel;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView;
import ek4.PayLevelEnterRoomInfo;
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
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/paylevel/QQLivePayLevelPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "getInitRelyViewStubId", "U9", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "V9", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "payLevelContainer", "Lcom/tencent/timi/game/liveroom/impl/room/paylevel/bubble/view/PayLevelEnterRoomBubbleView;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/paylevel/bubble/view/PayLevelEnterRoomBubbleView;", "payLevelView", "Lcom/tencent/mobileqq/qqlive/sail/ui/paylevel/QQLivePayLevelViewModel;", h.F, "Lkotlin/Lazy;", "la", "()Lcom/tencent/mobileqq/qqlive/sail/ui/paylevel/QQLivePayLevelViewModel;", "viewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", LocaleUtils.L_JAPANESE, "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePayLevelPart extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout payLevelContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PayLevelEnterRoomBubbleView payLevelView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/paylevel/QQLivePayLevelPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.paylevel.QQLivePayLevelPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52654);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePayLevelPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLivePayLevelViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.paylevel.QQLivePayLevelPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePayLevelPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final QQLivePayLevelViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (QQLivePayLevelViewModel) QQLivePayLevelPart.this.getViewModel(QQLivePayLevelViewModel.class) : (QQLivePayLevelViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final e ja() {
        f F9 = F9();
        if (F9 instanceof e) {
            return (e) F9;
        }
        return null;
    }

    private final QQLivePayLevelViewModel la() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QQLivePayLevelViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        super.S9(updater);
        f F9 = F9();
        if (F9 != null) {
            la().N1(F9.getRoomId());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLivePayLevelPart", "onBusConfigUpdate", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f F9 = F9();
        Object obj = null;
        if (F9 != null) {
            startInit();
            QQLivePayLevelViewModel la5 = la();
            long roomId = F9.getRoomId();
            e ja5 = ja();
            if (ja5 != null) {
                obj = ja5.q();
            }
            if (obj == WindowMode.FLOAT) {
                z16 = true;
            } else {
                z16 = false;
            }
            la5.O1(roomId, z16);
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            AegisLogger.INSTANCE.e("Open_Live|QQLivePayLevelPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.V9();
        la().P1();
        PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView = this.payLevelView;
        if (payLevelEnterRoomBubbleView != null) {
            payLevelEnterRoomBubbleView.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f61192xg;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f61192xg);
        } else {
            frameLayout = null;
        }
        this.payLevelContainer = frameLayout;
        if (frameLayout != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView = new PayLevelEnterRoomBubbleView(context, null, 0, 6, null);
            this.payLevelView = payLevelEnterRoomBubbleView;
            frameLayout.addView(payLevelEnterRoomBubbleView);
        }
        LiveData<PayLevelEnterRoomInfo> enterRoomInfo = la().getEnterRoomInfo();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<PayLevelEnterRoomInfo, Unit> function1 = new Function1<PayLevelEnterRoomInfo, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.paylevel.QQLivePayLevelPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePayLevelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayLevelEnterRoomInfo payLevelEnterRoomInfo) {
                invoke2(payLevelEnterRoomInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PayLevelEnterRoomInfo it) {
                PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                AegisLogger.INSTANCE.d("Open_Live|QQLivePayLevelPart", "observeVm, enterRoomInfo:" + it);
                payLevelEnterRoomBubbleView2 = QQLivePayLevelPart.this.payLevelView;
                if (payLevelEnterRoomBubbleView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    payLevelEnterRoomBubbleView2.n(it);
                }
            }
        };
        enterRoomInfo.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.paylevel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePayLevelPart.ma(Function1.this, obj);
            }
        });
    }
}
