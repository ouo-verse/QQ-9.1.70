package com.tencent.ecommerce.biz.commission.subsidy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.d;
import com.tencent.ecommerce.biz.commission.ECCommissionUtils;
import com.tencent.ecommerce.biz.commission.detail.ECBill;
import com.tencent.ecommerce.biz.commission.detail.ECCommissionItemAdapter;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.json.JSONObject;
import tj0.ECSubsidyIncomeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001>\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "initView", "ai", "ci", "bi", "Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewViewModel;", "P", "Lkotlin/Lazy;", "Zh", "()Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewViewModel;", "viewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "contentView", BdhLogUtil.LogTag.Tag_Req, "networkErrorLayout", ExifInterface.LATITUDE_SOUTH, "paidStateLayout", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "paidStateImageView", "Landroid/widget/TextView;", "U", "Landroid/widget/TextView;", "paidStateTextView", "V", "paidStateRetryBtn", "W", "paidMoney", "X", "unpaidMoney", "Y", "expectedProfit", "Z", "hint", "Landroidx/recyclerview/widget/RecyclerView;", "a0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter;", "b0", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter;", "adapter", "Lcom/tencent/ecommerce/base/ui/d;", "c0", "Yh", "()Lcom/tencent/ecommerce/base/ui/d;", "loadingDialog", "com/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$k", "d0", "Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$k;", "ptsListener", "<init>", "()V", "e0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubsidyOverviewFragment extends ECBaseFragment {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private View contentView;

    /* renamed from: R, reason: from kotlin metadata */
    private View networkErrorLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private View paidStateLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView paidStateImageView;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView paidStateTextView;

    /* renamed from: V, reason: from kotlin metadata */
    private View paidStateRetryBtn;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView paidMoney;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView unpaidMoney;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView expectedProfit;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView hint;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECCommissionItemAdapter adapter;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Lazy loadingDialog;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final k ptsListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", "PACKAGE_NAME", "Ljava/lang/String;", "", "START_TO_REQUEST_POSITION", "I", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context) {
            yi0.a.q(context, ECSubsidyOverviewFragment.class, null, 0, null, 28, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                ECSubsidyOverviewFragment.this.Yh().show();
            } else {
                ECSubsidyOverviewFragment.this.Yh().dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        public static final e f101524d = new e();

        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            if (str.length() > 0) {
                ECScheme.g(str, null, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$initView$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSubsidyOverviewFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$initView$1$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSubsidyOverviewFragment.this.Zh().d2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$initView$1$3"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSubsidyOverviewFragment.this.Zh().b2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f101528d;

        i(View view) {
            this.f101528d = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSubsidyListFragment.INSTANCE.a(this.f101528d.getContext());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECSubsidyOverviewFragment() {
        Lazy lazy;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECSubsidyOverviewViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.base.ui.d>() { // from class: com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewFragment$loadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                d dVar = new d(ECSubsidyOverviewFragment.this.requireContext(), null, 2, null);
                dVar.setCanceledOnTouchOutside(false);
                return dVar;
            }
        });
        this.loadingDialog = lazy;
        this.ptsListener = new k();
    }

    public static final /* synthetic */ ECCommissionItemAdapter Lh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        ECCommissionItemAdapter eCCommissionItemAdapter = eCSubsidyOverviewFragment.adapter;
        if (eCCommissionItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return eCCommissionItemAdapter;
    }

    public static final /* synthetic */ View Mh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        View view = eCSubsidyOverviewFragment.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        return view;
    }

    public static final /* synthetic */ TextView Nh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        TextView textView = eCSubsidyOverviewFragment.expectedProfit;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expectedProfit");
        }
        return textView;
    }

    public static final /* synthetic */ TextView Oh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        TextView textView = eCSubsidyOverviewFragment.hint;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hint");
        }
        return textView;
    }

    public static final /* synthetic */ View Qh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        View view = eCSubsidyOverviewFragment.networkErrorLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkErrorLayout");
        }
        return view;
    }

    public static final /* synthetic */ TextView Rh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        TextView textView = eCSubsidyOverviewFragment.paidMoney;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidMoney");
        }
        return textView;
    }

    public static final /* synthetic */ View Sh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        View view = eCSubsidyOverviewFragment.paidStateLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateLayout");
        }
        return view;
    }

    public static final /* synthetic */ RecyclerView Th(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        RecyclerView recyclerView = eCSubsidyOverviewFragment.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ TextView Uh(ECSubsidyOverviewFragment eCSubsidyOverviewFragment) {
        TextView textView = eCSubsidyOverviewFragment.unpaidMoney;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unpaidMoney");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.base.ui.d Yh() {
        return (com.tencent.ecommerce.base.ui.d) this.loadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECSubsidyOverviewViewModel Zh() {
        return (ECSubsidyOverviewViewModel) this.viewModel.getValue();
    }

    private final void ai() {
        Zh().T1().observe(getViewLifecycleOwner(), new b());
        Zh().U1().observe(getViewLifecycleOwner(), new c());
        Zh().W1().observe(getViewLifecycleOwner(), new d());
        Zh().X1().observe(getViewLifecycleOwner(), e.f101524d);
        Zh().d2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setVisibility(8);
        View view = this.paidStateLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateLayout");
        }
        view.setVisibility(0);
        String url = ECSkin.INSTANCE.getUrl("qecommerce_skin_emptystate_img_wenjian");
        if (url != null) {
            ImageView imageView = this.paidStateImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paidStateImageView");
            }
            ImageViewKt.b(imageView, url, 0, 0, 0, 14, null);
        }
        TextView textView = this.paidStateTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateTextView");
        }
        textView.setText(getResources().getString(R.string.wpe));
        View view2 = this.paidStateRetryBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateRetryBtn");
        }
        view2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setVisibility(8);
        View view = this.paidStateLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateLayout");
        }
        view.setVisibility(0);
        Drawable drawable = ECSkin.INSTANCE.getDrawable("qecommerce_skin_emptystate_img_wuwangluo");
        if (drawable != null) {
            ImageView imageView = this.paidStateImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paidStateImageView");
            }
            imageView.setImageDrawable(drawable);
        }
        TextView textView = this.paidStateTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateTextView");
        }
        textView.setText(getResources().getString(R.string.wui));
        View view2 = this.paidStateRetryBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateRetryBtn");
        }
        view2.setVisibility(0);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECSubsidyOverviewFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167352cv0;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        ai();
        a.f101535a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<List<? extends ECBill>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECBill> list) {
            if (list == null) {
                ECSubsidyOverviewFragment.this.ci();
            } else {
                if (list.isEmpty()) {
                    ECSubsidyOverviewFragment.this.bi();
                    return;
                }
                ECSubsidyOverviewFragment.Th(ECSubsidyOverviewFragment.this).setVisibility(0);
                ECSubsidyOverviewFragment.Sh(ECSubsidyOverviewFragment.this).setVisibility(8);
                ECSubsidyOverviewFragment.Lh(ECSubsidyOverviewFragment.this).l0(list, "");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$j", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "lastVisiblePosition", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastVisiblePosition;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f101531f;

        j(LinearLayoutManager linearLayoutManager) {
            this.f101531f = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            this.lastVisiblePosition = this.f101531f.findLastVisibleItemPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState != 0 || ECSubsidyOverviewFragment.this.Zh().getIsEnd() || this.f101531f.getItemCount() - this.lastVisiblePosition > 4) {
                return;
            }
            ECSubsidyOverviewFragment.this.Zh().c2();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewFragment$k", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k extends com.tencent.ecommerce.base.ui.e {
        k() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String str2;
            String str3;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            int hashCode = str.hashCode();
            if (hashCode != 685833743) {
                if (hashCode == 1616635359 && str.equals("showFailReason") && (str3 = dataMap.get("errorMsgBox")) != null) {
                    ECCommissionUtils.f101430a.c(ECSubsidyOverviewFragment.this.requireContext(), new JSONObject(str3));
                    return;
                }
                return;
            }
            if (!str.equals("taxInfoClick") || (str2 = dataMap.get("taxInfoToken")) == null) {
                return;
            }
            ECSubsidyOverviewFragment.this.Zh().e2(str2);
        }
    }

    private final void initView(View view) {
        view.findViewById(R.id.o0w).setOnClickListener(new f());
        this.contentView = view.findViewById(R.id.obm);
        this.networkErrorLayout = view.findViewById(R.id.f163071o51);
        view.findViewById(R.id.f163072o52).setOnClickListener(new g());
        this.paidStateLayout = view.findViewById(R.id.f163077o61);
        this.paidStateImageView = (ImageView) view.findViewById(R.id.f163078o62);
        this.paidStateTextView = (TextView) view.findViewById(R.id.f163080o64);
        View findViewById = view.findViewById(R.id.f163079o63);
        this.paidStateRetryBtn = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paidStateRetryBtn");
        }
        findViewById.setOnClickListener(new h());
        view.findViewById(R.id.nyx).setOnClickListener(new i(view));
        this.paidMoney = (TextView) view.findViewById(R.id.o6c);
        this.unpaidMoney = (TextView) view.findViewById(R.id.oez);
        this.expectedProfit = (TextView) view.findViewById(R.id.nyw);
        this.hint = (TextView) view.findViewById(R.id.obn);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.o8n);
        this.adapter = new ECCommissionItemAdapter(requireContext(), this.ptsListener, "remittance_card");
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        ECCommissionItemAdapter eCCommissionItemAdapter = this.adapter;
        if (eCCommissionItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(eCCommissionItemAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.addOnScrollListener(new j(linearLayoutManager));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ltj0/b;", "it", "", "a", "(Ltj0/b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<ECSubsidyIncomeInfo> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECSubsidyIncomeInfo eCSubsidyIncomeInfo) {
            if (eCSubsidyIncomeInfo == null) {
                ECSubsidyOverviewFragment.Mh(ECSubsidyOverviewFragment.this).setVisibility(8);
                ECSubsidyOverviewFragment.Qh(ECSubsidyOverviewFragment.this).setVisibility(0);
                return;
            }
            ECSubsidyOverviewFragment.Mh(ECSubsidyOverviewFragment.this).setVisibility(0);
            ECSubsidyOverviewFragment.Qh(ECSubsidyOverviewFragment.this).setVisibility(8);
            TextView Rh = ECSubsidyOverviewFragment.Rh(ECSubsidyOverviewFragment.this);
            com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
            Rh.setText(iVar.b(eCSubsidyIncomeInfo.paidFen));
            ECSubsidyOverviewFragment.Uh(ECSubsidyOverviewFragment.this).setText(iVar.b(eCSubsidyIncomeInfo.unPaidFen));
            ECSubsidyOverviewFragment.Nh(ECSubsidyOverviewFragment.this).setText(iVar.b(eCSubsidyIncomeInfo.total));
            ECSubsidyOverviewFragment.Oh(ECSubsidyOverviewFragment.this).setVisibility(eCSubsidyIncomeInfo.hint.length() > 0 ? 0 : 8);
            ECSubsidyOverviewFragment.Oh(ECSubsidyOverviewFragment.this).setText(eCSubsidyIncomeInfo.hint);
        }
    }
}
