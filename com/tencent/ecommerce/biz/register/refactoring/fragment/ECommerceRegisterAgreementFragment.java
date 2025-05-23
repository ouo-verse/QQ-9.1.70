package com.tencent.ecommerce.biz.register.refactoring.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterSuccessDialog;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterSuccessEvent;
import com.tencent.ecommerce.biz.register.refactoring.utils.b;
import com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterAgreementViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.register.ECAgreementCheckBox;
import com.tencent.ecommerce.repo.register.ECAgreementLink;
import com.tencent.ecommerce.repo.register.ECRegisterAgreementInfo;
import com.tencent.ecommerce.repo.register.ECRegisterBindFlagToastInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import pg0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 e2\u00020\u0001:\u0001fB\u0007\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010O\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020_0^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006g"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAgreementFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getBusinessDescription", "", "Eh", "ki", "li", "initUI", "oi", "mi", "gi", "ni", "Landroid/widget/CheckBox;", "agreementCheckBox", "Landroid/widget/TextView;", "agreementTv", "isChecked", "pi", "Lcom/tencent/ecommerce/repo/register/a;", "checkBox", "Landroid/text/SpannableStringBuilder;", "fi", "initListener", "ii", "", "viewHeight", WidgetCacheLunarData.JI, "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "registerAgreementFloatWindow", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "outerStateCenterView", BdhLogUtil.LogTag.Tag_Req, "stateCenterView", "Landroid/widget/FrameLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/FrameLayout;", "pageRootView", "Landroid/widget/RelativeLayout;", "T", "Landroid/widget/RelativeLayout;", "viewContainer", "U", "Landroid/widget/TextView;", "titleTv", "V", "tipsTitleTv", "Landroid/widget/ScrollView;", "W", "Landroid/widget/ScrollView;", "descScrollView", "Landroid/widget/LinearLayout;", "X", "Landroid/widget/LinearLayout;", "descContainer", "Y", "agreementContainer", "Landroid/widget/Button;", "Z", "Landroid/widget/Button;", "cancelBtn", "a0", "confirmBtn", "b0", "Ljava/lang/String;", "isMcn", "c0", "jumpScheme", "d0", "deliverProductCallbackId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "e0", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "deliverProductCallback", "Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterAgreementViewModel;", "f0", "Lkotlin/Lazy;", "hi", "()Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterAgreementViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;", "g0", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "successRegisteredEventObserve", "<init>", "()V", "h0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceRegisterAgreementFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout registerAgreementFloatWindow;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECStateCenterView outerStateCenterView;

    /* renamed from: R, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: S, reason: from kotlin metadata */
    private FrameLayout pageRootView;

    /* renamed from: T, reason: from kotlin metadata */
    private RelativeLayout viewContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView tipsTitleTv;

    /* renamed from: W, reason: from kotlin metadata */
    private ScrollView descScrollView;

    /* renamed from: X, reason: from kotlin metadata */
    private LinearLayout descContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private LinearLayout agreementContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private Button cancelBtn;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Button confirmBtn;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String isMcn = "0";

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String jumpScheme = "";

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String deliverProductCallbackId = "";

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private IECSchemeCallback deliverProductCallback;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final EventObserver<ECRegisterSuccessEvent> successRegisteredEventObserve;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAgreementFragment$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "p0", "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ECAgreementLink f104033d;

        b(ECAgreementLink eCAgreementLink) {
            this.f104033d = eCAgreementLink;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View p06) {
            if (this.f104033d.getType() == 1) {
                a.f426137b.a();
                return;
            }
            ECScheme.g(this.f104033d.url, null, 2, null);
            cg0.a.b("ECommerceRegisterAgreementFragment", "[constructAgreementSpannable] jump to URl, url = " + this.f104033d.url);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            super.updateDrawState(ds5);
            ds5.setColor(ECSkin.INSTANCE.getColor(R.color.f6932w));
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAgreementFragment$c", "Lcom/tencent/ecommerce/base/ui/c;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends com.tencent.ecommerce.base.ui.c {
        c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAgreementFragment$d", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends com.tencent.ecommerce.base.ui.c {
        d() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECommerceRegisterAgreementFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAgreementFragment$e", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements ECFloatGestureLayout.ContentScrollListener {
        e() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECommerceRegisterAgreementFragment", "cancelBtn click");
            ECommerceRegisterAgreementFragment.Vh(ECommerceRegisterAgreementFragment.this).E();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Map mutableMapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECommerceRegisterAgreementFragment", "confirmBtn click confirmBtn.isEnabled=" + ECommerceRegisterAgreementFragment.Nh(ECommerceRegisterAgreementFragment.this).isEnabled() + " isMcn=" + ECommerceRegisterAgreementFragment.this.isMcn);
            if (ECommerceRegisterAgreementFragment.Nh(ECommerceRegisterAgreementFragment.this).isEnabled()) {
                String str = "1";
                if (Intrinsics.areEqual(ECommerceRegisterAgreementFragment.this.isMcn, "1")) {
                    ECommerceRegisterAgreementFragment.this.hi().N1();
                } else {
                    Pair[] pairArr = new Pair[4];
                    pairArr[0] = TuplesKt.to("jump_scheme", ECommerceRegisterAgreementFragment.this.jumpScheme);
                    pairArr[1] = TuplesKt.to("scheme_callback_id", ECommerceRegisterAgreementFragment.this.deliverProductCallbackId);
                    pairArr[2] = TuplesKt.to("is_mcn", ECommerceRegisterAgreementFragment.this.isMcn);
                    if (!ECommerceRegisterAgreementFragment.this.hi().getAccountFollowChecked()) {
                        str = "0";
                    }
                    pairArr[3] = TuplesKt.to("is_follow", str);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    yi0.a.t(Uri.parse(String.valueOf(47)), mutableMapOf, null, null, 12, null);
                    ECommerceRegisterAgreementFragment.Vh(ECommerceRegisterAgreementFragment.this).E();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/repo/register/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/repo/register/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<ECRegisterAgreementInfo> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECRegisterAgreementInfo eCRegisterAgreementInfo) {
            ECommerceRegisterAgreementFragment.Sh(ECommerceRegisterAgreementFragment.this).setSucceededState();
            if (eCRegisterAgreementInfo == null) {
                IStateCenterView.a.b(ECommerceRegisterAgreementFragment.Wh(ECommerceRegisterAgreementFragment.this), null, 1, null);
                ECommerceRegisterAgreementFragment.this.ni();
            } else {
                ECommerceRegisterAgreementFragment.Wh(ECommerceRegisterAgreementFragment.this).setSucceededState();
                ECommerceRegisterAgreementFragment.this.oi();
                ECommerceRegisterAgreementFragment.this.gi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECommerceRegisterAgreementFragment.Nh(ECommerceRegisterAgreementFragment.this).setEnabled(bool.booleanValue());
            cg0.a.b("ECommerceRegisterAgreementFragment", "goOnIsEnableLiveData confirmBtn.isEnabled=" + bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECAgreementCheckBox f104042e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CheckBox f104043f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TextView f104044h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f104045i;

        k(ECAgreementCheckBox eCAgreementCheckBox, CheckBox checkBox, TextView textView, int i3) {
            this.f104042e = eCAgreementCheckBox;
            this.f104043f = checkBox;
            this.f104044h = textView;
            this.f104045i = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = !this.f104042e.getIsChecked();
            this.f104042e.c(z16);
            ECommerceRegisterAgreementFragment.this.pi(this.f104043f, this.f104044h, z16);
            this.f104043f.setChecked(z16);
            ECommerceRegisterAgreementFragment.this.hi().W1(this.f104045i, z16);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;", "it", "", "a", "(Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class l<T> implements EventObserver<ECRegisterSuccessEvent> {
        l() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECRegisterSuccessEvent eCRegisterSuccessEvent) {
            FragmentActivity activity = ECommerceRegisterAgreementFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public ECommerceRegisterAgreementFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECRegisterAgreementViewModel>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAgreementFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECRegisterAgreementViewModel invoke() {
                return (ECRegisterAgreementViewModel) new ViewModelProvider(ECommerceRegisterAgreementFragment.this).get(ECRegisterAgreementViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.successRegisteredEventObserve = new l();
    }

    public static final /* synthetic */ LinearLayout Mh(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        LinearLayout linearLayout = eCommerceRegisterAgreementFragment.agreementContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreementContainer");
        }
        return linearLayout;
    }

    public static final /* synthetic */ Button Nh(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        Button button = eCommerceRegisterAgreementFragment.confirmBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        }
        return button;
    }

    public static final /* synthetic */ LinearLayout Ph(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        LinearLayout linearLayout = eCommerceRegisterAgreementFragment.descContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descContainer");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ScrollView Qh(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        ScrollView scrollView = eCommerceRegisterAgreementFragment.descScrollView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descScrollView");
        }
        return scrollView;
    }

    public static final /* synthetic */ ECStateCenterView Sh(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        ECStateCenterView eCStateCenterView = eCommerceRegisterAgreementFragment.outerStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerStateCenterView");
        }
        return eCStateCenterView;
    }

    public static final /* synthetic */ FrameLayout Th(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        FrameLayout frameLayout = eCommerceRegisterAgreementFragment.pageRootView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageRootView");
        }
        return frameLayout;
    }

    public static final /* synthetic */ ECFloatGestureLayout Vh(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCommerceRegisterAgreementFragment.registerAgreementFloatWindow;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAgreementFloatWindow");
        }
        return eCFloatGestureLayout;
    }

    public static final /* synthetic */ ECStateCenterView Wh(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        ECStateCenterView eCStateCenterView = eCommerceRegisterAgreementFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    public static final /* synthetic */ RelativeLayout Xh(ECommerceRegisterAgreementFragment eCommerceRegisterAgreementFragment) {
        RelativeLayout relativeLayout = eCommerceRegisterAgreementFragment.viewContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewContainer");
        }
        return relativeLayout;
    }

    private final SpannableStringBuilder fi(ECAgreementCheckBox checkBox) {
        int indexOf$default;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(checkBox.text);
        for (ECAgreementLink eCAgreementLink : checkBox.a()) {
            String str = eCAgreementLink.text;
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) checkBox.text, str, 0, false, 6, (Object) null);
            spannableStringBuilder.setSpan(new b(eCAgreementLink), indexOf$default, str.length() + indexOf$default, 33);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        LinearLayout linearLayout = this.agreementContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreementContainer");
        }
        linearLayout.post(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAgreementFragment$dynamicCalScrollViewHeight$1
            @Override // java.lang.Runnable
            public final void run() {
                ECFloatGestureLayout eCFloatGestureLayout;
                eCFloatGestureLayout = ECommerceRegisterAgreementFragment.this.registerAgreementFloatWindow;
                if (eCFloatGestureLayout != null) {
                    return;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                ECommerceRegisterAgreementFragment.Mh(ECommerceRegisterAgreementFragment.this).measure(makeMeasureSpec, makeMeasureSpec2);
                ECDeviceUtils eCDeviceUtils = ECDeviceUtils.f104857e;
                float i3 = eCDeviceUtils.i(ECommerceRegisterAgreementFragment.Mh(ECommerceRegisterAgreementFragment.this).getHeight());
                ECommerceRegisterAgreementFragment.Ph(ECommerceRegisterAgreementFragment.this).measure(makeMeasureSpec, makeMeasureSpec2);
                float i16 = eCDeviceUtils.i(ECommerceRegisterAgreementFragment.Ph(ECommerceRegisterAgreementFragment.this).getHeight());
                float i17 = eCDeviceUtils.i((float) (eCDeviceUtils.d() * 0.75d));
                float f16 = i16 + i3 + 118;
                if (f16 <= i17) {
                    ECommerceRegisterAgreementFragment.Qh(ECommerceRegisterAgreementFragment.this).setOverScrollMode(2);
                    i17 = f16;
                }
                ECommerceRegisterAgreementFragment.this.ji(i17);
                int Q = ECommerceRegisterAgreementFragment.Vh(ECommerceRegisterAgreementFragment.this).Q(ECommerceRegisterAgreementFragment.this.requireActivity());
                ViewGroup.LayoutParams layoutParams = ECommerceRegisterAgreementFragment.Th(ECommerceRegisterAgreementFragment.this).getLayoutParams();
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.bottomMargin = e.e(eCDeviceUtils.i(eCDeviceUtils.d()) - i17) - Q;
                    ECommerceRegisterAgreementFragment.Th(ECommerceRegisterAgreementFragment.this).setLayoutParams(layoutParams2);
                    ECommerceRegisterAgreementFragment.Xh(ECommerceRegisterAgreementFragment.this).setVisibility(0);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECRegisterAgreementViewModel hi() {
        return (ECRegisterAgreementViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii() {
        final ECRegisterSuccessDialog eCRegisterSuccessDialog = new ECRegisterSuccessDialog();
        eCRegisterSuccessDialog.uh(getChildFragmentManager(), new Function1<ECRegisterSuccessDialog.RegisterSuccessResult, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAgreementFragment$handleBindFlagSuccess$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECRegisterSuccessDialog.RegisterSuccessResult registerSuccessResult) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECRegisterSuccessDialog.RegisterSuccessResult registerSuccessResult) {
                invoke2(registerSuccessResult);
                return Unit.INSTANCE;
            }
        });
        ECFloatGestureLayout eCFloatGestureLayout = this.registerAgreementFloatWindow;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAgreementFloatWindow");
        }
        eCFloatGestureLayout.setFloatEventListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.registerAgreementFloatWindow;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAgreementFloatWindow");
        }
        eCFloatGestureLayout2.E();
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAgreementFragment$handleBindFlagSuccess$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                eCRegisterSuccessDialog.dismiss();
                b.b(b.f104104a, ECommerceRegisterAgreementFragment.this.jumpScheme, ECommerceRegisterAgreementFragment.this.deliverProductCallbackId, null, 4, null);
                LifecycleEventBus.f100688b.f(new ECRegisterSuccessEvent(true));
            }
        }, 800L);
    }

    private final void initListener() {
        Button button = this.cancelBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        }
        button.setOnClickListener(new f());
        Button button2 = this.confirmBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        }
        button2.setOnClickListener(new g());
    }

    private final void initUI() {
        yh().setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.f7153h));
        this.pageRootView = (FrameLayout) yh().findViewById(R.id.o8u);
        this.viewContainer = (RelativeLayout) yh().findViewById(R.id.of6);
        this.titleTv = (TextView) yh().findViewById(R.id.o8z);
        this.tipsTitleTv = (TextView) yh().findViewById(R.id.o8w);
        this.descScrollView = (ScrollView) yh().findViewById(R.id.o8x);
        this.descContainer = (LinearLayout) yh().findViewById(R.id.o8s);
        this.agreementContainer = (LinearLayout) yh().findViewById(R.id.o8r);
        this.cancelBtn = (Button) yh().findViewById(R.id.nxb);
        this.confirmBtn = (Button) yh().findViewById(R.id.nxe);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) yh().findViewById(R.id.o8v);
        this.stateCenterView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAgreementFragment$initUI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IStateCenterView.a.c(ECommerceRegisterAgreementFragment.Wh(ECommerceRegisterAgreementFragment.this), null, 1, null);
                ECommerceRegisterAgreementFragment.this.hi().R1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(float viewHeight) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putBoolean("need_pop_anim", true);
        bundle.putInt("container_color", R.color.f6491p);
        int i3 = (int) (ECDeviceUtils.f104857e.i(r1.d()) - viewHeight);
        bundle.putBoolean("disallow_pulling", true);
        bundle.putInt("scroll_margin_top", i3);
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.registerAgreementFloatWindow = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new d());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.registerAgreementFloatWindow;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAgreementFloatWindow");
        }
        eCFloatGestureLayout2.setContentScrollListener(new e());
        ECFloatGestureLayout eCFloatGestureLayout3 = this.registerAgreementFloatWindow;
        if (eCFloatGestureLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAgreementFloatWindow");
        }
        eCFloatGestureLayout3.C(this, -1, R.id.nrl);
    }

    private final void ki() {
        yh().setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.f7153h));
        ECStateCenterView eCStateCenterView = (ECStateCenterView) yh().findViewById(R.id.o5y);
        this.outerStateCenterView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerStateCenterView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
    }

    private final void li() {
        hi().S1().observe(getViewLifecycleOwner(), new h());
        hi().U1().observe(getViewLifecycleOwner(), new i());
        hi().T1().observe(getViewLifecycleOwner(), new j());
    }

    private final void mi() {
        ECRegisterAgreementInfo value = hi().S1().getValue();
        List<ECAgreementCheckBox> a16 = value != null ? value.a() : null;
        List<ECAgreementCheckBox> list = a16;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ECAgreementCheckBox eCAgreementCheckBox = a16.get(i3);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cve, (ViewGroup) null, false);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.o8q);
            TextView textView = (TextView) inflate.findViewById(R.id.f163091o90);
            checkBox.setChecked(eCAgreementCheckBox.checkByDefault);
            pi(checkBox, textView, eCAgreementCheckBox.checkByDefault);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(fi(eCAgreementCheckBox));
            checkBox.setOnClickListener(new k(eCAgreementCheckBox, checkBox, textView, i3));
            LinearLayout linearLayout = this.agreementContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreementContainer");
            }
            linearLayout.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni() {
        FrameLayout frameLayout = this.pageRootView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageRootView");
        }
        frameLayout.post(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAgreementFragment$setFailUIContent$1
            @Override // java.lang.Runnable
            public final void run() {
                ECDeviceUtils eCDeviceUtils = ECDeviceUtils.f104857e;
                float i3 = eCDeviceUtils.i((float) (eCDeviceUtils.d() * 0.75d));
                ECommerceRegisterAgreementFragment.this.ji(i3);
                int Q = ECommerceRegisterAgreementFragment.Vh(ECommerceRegisterAgreementFragment.this).Q(ECommerceRegisterAgreementFragment.this.requireActivity());
                ViewGroup.LayoutParams layoutParams = ECommerceRegisterAgreementFragment.Th(ECommerceRegisterAgreementFragment.this).getLayoutParams();
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.bottomMargin = e.e(eCDeviceUtils.i(eCDeviceUtils.d()) - i3) - Q;
                    ECommerceRegisterAgreementFragment.Th(ECommerceRegisterAgreementFragment.this).setLayoutParams(layoutParams2);
                    ECommerceRegisterAgreementFragment.Xh(ECommerceRegisterAgreementFragment.this).setVisibility(0);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi() {
        String str;
        List<String> split$default;
        ECRegisterAgreementInfo value = hi().S1().getValue();
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        }
        textView.setText(value != null ? value.title : null);
        TextView textView2 = this.tipsTitleTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsTitleTv");
        }
        textView2.setText(value != null ? value.tips : null);
        if (value == null || (str = value.desc) == null) {
            str = "";
        }
        String str2 = str;
        if (str2.length() > 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{RedTouch.NEWLINE_CHAR}, false, 0, 6, (Object) null);
            for (String str3 : split$default) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cvf, (ViewGroup) null, false);
                TextView textView3 = (TextView) inflate.findViewById(R.id.o8y);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
                spannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(0, com.tencent.ecommerce.biz.util.e.c(20.0f)), 0, str3.length(), 18);
                textView3.setText(spannableStringBuilder);
                LinearLayout linearLayout = this.descContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descContainer");
                }
                linearLayout.addView(inflate);
            }
        }
        mi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(CheckBox agreementCheckBox, TextView agreementTv, boolean isChecked) {
        agreementCheckBox.setBackground(ECSkin.INSTANCE.getDrawable(isChecked ? R.drawable.e6v : R.drawable.e5s));
        agreementTv.setTextColor(ECSkin.INSTANCE.getColor(isChecked ? R.color.f6942x : R.color.f6962z));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECommerceRegisterAgreementFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cvd;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECRegisterSuccessEvent.class, this.successRegisteredEventObserve);
        Bundle arguments = getArguments();
        String str2 = "0";
        if (arguments != null && (string2 = arguments.getString("is_mcn", "0")) != null) {
            str2 = string2;
        }
        this.isMcn = str2;
        Bundle arguments2 = getArguments();
        String str3 = "";
        if (arguments2 == null || (str = arguments2.getString("jump_scheme", "")) == null) {
            str = "";
        }
        this.jumpScheme = str;
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (string = arguments3.getString("scheme_callback_id", "")) != null) {
            str3 = string;
        }
        this.deliverProductCallbackId = str3;
        this.deliverProductCallback = ug0.a.b(str3);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        LifecycleEventBus.f100688b.e(this.successRegisteredEventObserve);
        super.onDestroy();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ki();
        li();
        initUI();
        hi().R1();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/repo/register/d;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/repo/register/d;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<ECRegisterBindFlagToastInfo> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECRegisterBindFlagToastInfo eCRegisterBindFlagToastInfo) {
            if (eCRegisterBindFlagToastInfo != null) {
                if (eCRegisterBindFlagToastInfo.state == 0) {
                    ECommerceRegisterAgreementFragment.this.ii();
                } else {
                    com.tencent.ecommerce.base.ui.i.f(com.tencent.ecommerce.base.ui.i.f101155b, eCRegisterBindFlagToastInfo.getMsg(), null, 0, 6, null);
                }
            }
        }
    }
}
