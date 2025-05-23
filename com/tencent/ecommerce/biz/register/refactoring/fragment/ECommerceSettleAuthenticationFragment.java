package com.tencent.ecommerce.biz.register.refactoring.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import cg0.a;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECWxAuthSuccessEvent;
import com.tencent.ecommerce.biz.register.refactoring.utils.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\t*\u00015\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u0018\u00104\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010)R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceSettleAuthenticationFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getBusinessDescription", "", "Bh", "Eh", "Dh", "Vh", "initListener", "initArguments", "Wh", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "wxIdTextView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "qqIdTextView", "Landroid/widget/Button;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/Button;", "wxAuthBtn", ExifInterface.LATITUDE_SOUTH, "skipBtn", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "backBtn", "U", "goOnButton", "V", "Ljava/lang/String;", "jumpScheme", "Lcom/tencent/ecommerce/base/ui/d;", "W", "Lcom/tencent/ecommerce/base/ui/d;", "loadingDialog", "X", "callbackId", "Y", "isBack", "Z", "disableSkip", "com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1", "a0", "Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1;", "successWxAuthEventObserve", "<init>", "()V", "b0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceSettleAuthenticationFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private TextView wxIdTextView;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView qqIdTextView;

    /* renamed from: R, reason: from kotlin metadata */
    private Button wxAuthBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView skipBtn;

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView backBtn;

    /* renamed from: U, reason: from kotlin metadata */
    private Button goOnButton;

    /* renamed from: V, reason: from kotlin metadata */
    private String jumpScheme;

    /* renamed from: W, reason: from kotlin metadata */
    private com.tencent.ecommerce.base.ui.d loadingDialog;

    /* renamed from: X, reason: from kotlin metadata */
    private String callbackId = "";

    /* renamed from: Y, reason: from kotlin metadata */
    private String isBack = "";

    /* renamed from: Z, reason: from kotlin metadata */
    private String disableSkip = "";

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1 successWxAuthEventObserve = new ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECommerceSettleAuthenticationFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECommerceSettleAuthenticationFragment.this.Wh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.b("ECommerceSettleAuthenticationFragment", "wxAuthBtn");
            ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment = ECommerceSettleAuthenticationFragment.this;
            com.tencent.ecommerce.base.ui.d dVar = new com.tencent.ecommerce.base.ui.d(ECommerceSettleAuthenticationFragment.this.requireContext(), null, 2, null);
            dVar.show();
            Unit unit = Unit.INSTANCE;
            eCommerceSettleAuthenticationFragment.loadingDialog = dVar;
            hh0.a.f404923b.a(new ECWXAuthApiCallback());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Map<String, String> mutableMapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (Intrinsics.areEqual(ECommerceSettleAuthenticationFragment.this.isBack, "1")) {
                FragmentActivity activity = ECommerceSettleAuthenticationFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else {
                com.tencent.ecommerce.biz.register.refactoring.utils.b bVar = com.tencent.ecommerce.biz.register.refactoring.utils.b.f104104a;
                String Nh = ECommerceSettleAuthenticationFragment.Nh(ECommerceSettleAuthenticationFragment.this);
                String str = ECommerceSettleAuthenticationFragment.this.callbackId;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("settleAuthMessage", "\u6388\u6743\u6210\u529f"));
                bVar.a(Nh, str, mutableMapOf);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ Button Mh(ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment) {
        Button button = eCommerceSettleAuthenticationFragment.goOnButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goOnButton");
        }
        return button;
    }

    public static final /* synthetic */ String Nh(ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment) {
        String str = eCommerceSettleAuthenticationFragment.jumpScheme;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpScheme");
        }
        return str;
    }

    public static final /* synthetic */ com.tencent.ecommerce.base.ui.d Oh(ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment) {
        com.tencent.ecommerce.base.ui.d dVar = eCommerceSettleAuthenticationFragment.loadingDialog;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        }
        return dVar;
    }

    public static final /* synthetic */ TextView Ph(ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment) {
        TextView textView = eCommerceSettleAuthenticationFragment.skipBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipBtn");
        }
        return textView;
    }

    public static final /* synthetic */ Button Qh(ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment) {
        Button button = eCommerceSettleAuthenticationFragment.wxAuthBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxAuthBtn");
        }
        return button;
    }

    public static final /* synthetic */ TextView Rh(ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment) {
        TextView textView = eCommerceSettleAuthenticationFragment.wxIdTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxIdTextView");
        }
        return textView;
    }

    private final void Vh() {
        Resources resources;
        int i3;
        this.backBtn = (ImageView) yh().findViewById(R.id.o2l);
        this.skipBtn = (TextView) yh().findViewById(R.id.nxi);
        this.wxIdTextView = (TextView) yh().findViewById(R.id.odl);
        this.wxAuthBtn = (Button) yh().findViewById(R.id.f163004ns4);
        this.qqIdTextView = (TextView) yh().findViewById(R.id.odk);
        Button button = (Button) yh().findViewById(R.id.nry);
        this.goOnButton = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goOnButton");
        }
        if (Intrinsics.areEqual(this.isBack, "1")) {
            resources = getResources();
            i3 = R.string.wi6;
        } else {
            resources = getResources();
            i3 = R.string.wkr;
        }
        button.setText(resources.getString(i3));
        TextView textView = this.skipBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipBtn");
        }
        textView.setVisibility(Intrinsics.areEqual(this.disableSkip, "1") ? 4 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        g gVar = new g(requireContext());
        gVar.setTitle("");
        gVar.Y(getResources().getString(R.string.wtp));
        gVar.b0(getResources().getString(R.string.wgw));
        gVar.a0(null);
        gVar.f0(getResources().getString(R.string.wi6));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceSettleAuthenticationFragment$showSkipWxAuthDialog$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Map<String, String> mutableMapOf;
                FragmentActivity activity = ECommerceSettleAuthenticationFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                b bVar = b.f104104a;
                String Nh = ECommerceSettleAuthenticationFragment.Nh(ECommerceSettleAuthenticationFragment.this);
                String str = ECommerceSettleAuthenticationFragment.this.callbackId;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("settleAuthMessage", "\u5e26\u8d27\u529f\u80fd\u5f00\u901a\u6210\u529f"));
                bVar.a(Nh, str, mutableMapOf);
            }
        });
        gVar.show();
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        Intent intent;
        String stringExtra;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        FragmentActivity activity = getActivity();
        String str4 = "";
        if (activity == null || (intent4 = activity.getIntent()) == null || (str = intent4.getStringExtra("scheme_callback_id")) == null) {
            str = "";
        }
        this.callbackId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent3 = activity2.getIntent()) == null || (str2 = intent3.getStringExtra("jump_scheme")) == null) {
            str2 = "";
        }
        this.jumpScheme = str2;
        FragmentActivity activity3 = getActivity();
        if (activity3 == null || (intent2 = activity3.getIntent()) == null || (str3 = intent2.getStringExtra("is_back")) == null) {
            str3 = "";
        }
        this.isBack = str3;
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent = activity4.getIntent()) != null && (stringExtra = intent.getStringExtra("disable_skip")) != null) {
            str4 = stringExtra;
        }
        this.disableSkip = str4;
    }

    private final void initListener() {
        TextView textView = this.qqIdTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqIdTextView");
        }
        textView.setText(String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        ImageView imageView = this.backBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        }
        imageView.setOnClickListener(new b());
        TextView textView2 = this.skipBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipBtn");
        }
        textView2.setOnClickListener(new c());
        Button button = this.wxAuthBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxAuthBtn");
        }
        button.setOnClickListener(new d());
        Button button2 = this.goOnButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goOnButton");
        }
        button2.setOnClickListener(new e());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECommerceSettleAuthenticationFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cvj;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a.b("ECommerceSettleAuthenticationFragment", "[onDestroy] removeObserver");
        LifecycleEventBus.f100688b.e(this.successWxAuthEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        a.b("ECommerceSettleAuthenticationFragment", "[onResume] observeForever");
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECWxAuthSuccessEvent.class, this.successWxAuthEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        Vh();
        initListener();
    }
}
