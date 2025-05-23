package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog;
import com.tencent.mobileqq.vas.pay.page.bean.RenewalPageToggleConfig;
import com.tencent.mobileqq.vas.pay.page.j;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010!\u001a\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/VipExpiredPayPage;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Zh", "Lh23/a;", "action", "ai", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/widget/FrameLayout;", "Ph", "onPostThemeChanged", "onResume", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "isWrapContent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vas/pay/page/ak;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/pay/page/ak;", "vm", "Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalTitle;", "D", "Lkotlin/Lazy;", "Mh", "()Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalTitle;", "title", "", "E", "Ljava/lang/String;", "source", UserInfo.SEX_FEMALE, "Z", "isNight", "G", "Landroid/view/View;", "root", "Lcom/tencent/mobileqq/vas/pay/page/QvipRenewalPersonalInfo;", "H", "Lcom/tencent/mobileqq/vas/pay/page/QvipRenewalPersonalInfo;", "personalInfo", "I", "topBgView", "Landroidx/recyclerview/widget/RecyclerView;", "J", "Landroidx/recyclerview/widget/RecyclerView;", "preferentialList", "Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalPreferentialServiceItemDetail;", "K", "Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalPreferentialServiceItemDetail;", "preferentialItemDetail", "Lcom/tencent/mobileqq/vas/pay/page/QVipPayItem;", "L", "Lcom/tencent/mobileqq/vas/pay/page/QVipPayItem;", "payItem", "Lcom/tencent/mobileqq/vas/pay/page/HippyContainer;", "M", "Lcom/tencent/mobileqq/vas/pay/page/HippyContainer;", "hippyContainer", "Lcom/tencent/mobileqq/vas/pay/page/a;", "N", "Lcom/tencent/mobileqq/vas/pay/page/a;", "centerLayoutManager", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "P", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "hippyFragment", "Lcom/tencent/mobileqq/vas/pay/page/PreferentialItemAdapter;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lh", "()Lcom/tencent/mobileqq/vas/pay/page/PreferentialItemAdapter;", "itemAdapter", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipExpiredPayPage extends QPublicBaseFragment {
    private static final String S = VipExpiredPayPage.class.getSimpleName();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ak vm = new ak();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy title;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String source;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isNight;

    /* renamed from: G, reason: from kotlin metadata */
    private View root;

    /* renamed from: H, reason: from kotlin metadata */
    private QvipRenewalPersonalInfo personalInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private View topBgView;

    /* renamed from: J, reason: from kotlin metadata */
    private RecyclerView preferentialList;

    /* renamed from: K, reason: from kotlin metadata */
    private QVipRenewalPreferentialServiceItemDetail preferentialItemDetail;

    /* renamed from: L, reason: from kotlin metadata */
    private QVipPayItem payItem;

    /* renamed from: M, reason: from kotlin metadata */
    private HippyContainer hippyContainer;

    /* renamed from: N, reason: from kotlin metadata */
    private a centerLayoutManager;

    /* renamed from: P, reason: from kotlin metadata */
    private CommonHippyFragment hippyFragment;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemAdapter;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/pay/page/VipExpiredPayPage$b", "Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog$b;", "", "type", "", NodeProps.ON_CLICK, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements PayTypeSelectedDialog.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h23.a f310351b;

        b(h23.a aVar) {
            this.f310351b = aVar;
        }

        @Override // com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog.b
        public void onClick(int type) {
            QLog.i(VipExpiredPayPage.S, 1, "user selected pay type: " + type);
            VipExpiredPayPage.this.vm.M(type);
            this.f310351b.action();
        }
    }

    public VipExpiredPayPage() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new VipExpiredPayPage$title$2(this));
        this.title = lazy;
        this.source = "";
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PreferentialItemAdapter>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$itemAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PreferentialItemAdapter invoke() {
                return new PreferentialItemAdapter(VipExpiredPayPage.this.vm);
            }
        });
        this.itemAdapter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreferentialItemAdapter Lh() {
        return (PreferentialItemAdapter) this.itemAdapter.getValue();
    }

    private final QVipRenewalTitle Mh() {
        return (QVipRenewalTitle) this.title.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(VipExpiredPayPage this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(VipExpiredPayPage this$0, ScrollView this_apply, View view, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (i16 > 100) {
            this$0.Mh().setBackground(o.l(this_apply, R.drawable.lac, R.drawable.laf));
        } else {
            this$0.Mh().setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final ConstraintLayout Zh() {
        final ConstraintLayout constraintLayout = new ConstraintLayout(requireContext());
        o.p(constraintLayout, o.i(130));
        this.topBgView = o.c(constraintLayout, new ConstraintLayout.LayoutParams(-1, o.i(200)), new Function0<View>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$scrollContentView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                return o.x(ConstraintLayout.this, null, 1, null);
            }
        });
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = o.i(64) + ViewUtils.getStatusBarHeight(requireContext());
        layoutParams.setMarginStart(o.i(16));
        layoutParams.setMarginEnd(o.i(16));
        Unit unit = Unit.INSTANCE;
        this.personalInfo = (QvipRenewalPersonalInfo) o.a(constraintLayout, R.id.f67053ca, layoutParams, new VipExpiredPayPage$scrollContentView$1$3(this));
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.topToBottom = R.id.f67053ca;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = o.i(20);
        this.preferentialList = (RecyclerView) o.a(constraintLayout, R.id.f66953c1, layoutParams2, new VipExpiredPayPage$scrollContentView$1$5(this));
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams3.startToStart = 0;
        layoutParams3.endToEnd = 0;
        layoutParams3.topToBottom = R.id.f66953c1;
        layoutParams3.setMarginStart(o.i(16));
        layoutParams3.setMarginEnd(o.i(16));
        this.preferentialItemDetail = (QVipRenewalPreferentialServiceItemDetail) o.a(constraintLayout, R.id.f66923by, layoutParams3, new Function0<QVipRenewalPreferentialServiceItemDetail>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$scrollContentView$1$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QVipRenewalPreferentialServiceItemDetail invoke() {
                QVipRenewalPreferentialServiceItemDetail qVipRenewalPreferentialServiceItemDetail = new QVipRenewalPreferentialServiceItemDetail(VipExpiredPayPage.this.requireContext());
                qVipRenewalPreferentialServiceItemDetail.setVisibility(8);
                return qVipRenewalPreferentialServiceItemDetail;
            }
        });
        j.Companion companion = j.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, o.i(companion.h(requireContext)));
        layoutParams4.topToBottom = R.id.f66923by;
        this.hippyContainer = (HippyContainer) o.a(constraintLayout, R.id.f66913bx, layoutParams4, new Function0<HippyContainer>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$scrollContentView$1$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HippyContainer invoke() {
                Context requireContext2 = VipExpiredPayPage.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                return new HippyContainer(requireContext2);
            }
        });
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(h23.a action) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        PayTypeSelectedDialog payTypeSelectedDialog = new PayTypeSelectedDialog(requireContext);
        payTypeSelectedDialog.O(new b(action));
        payTypeSelectedDialog.show();
    }

    private final void initView() {
        Mh().a();
        View view = this.root;
        QvipRenewalPersonalInfo qvipRenewalPersonalInfo = null;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                view = null;
            }
            view.setBackgroundColor(o.f("#F5F5F5", "#000000"));
        }
        QVipPayItem qVipPayItem = this.payItem;
        if (qVipPayItem != null) {
            if (qVipPayItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payItem");
                qVipPayItem = null;
            }
            qVipPayItem.initView();
        }
        View view2 = this.topBgView;
        if (view2 != null) {
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBgView");
                view2 = null;
            }
            View view3 = this.topBgView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBgView");
                view3 = null;
            }
            view2.setBackground(o.l(view3, R.drawable.lad, R.drawable.lae));
        }
        QVipRenewalPreferentialServiceItemDetail qVipRenewalPreferentialServiceItemDetail = this.preferentialItemDetail;
        if (qVipRenewalPreferentialServiceItemDetail != null) {
            if (qVipRenewalPreferentialServiceItemDetail == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferentialItemDetail");
                qVipRenewalPreferentialServiceItemDetail = null;
            }
            qVipRenewalPreferentialServiceItemDetail.c();
        }
        QvipRenewalPersonalInfo qvipRenewalPersonalInfo2 = this.personalInfo;
        if (qvipRenewalPersonalInfo2 != null) {
            if (qvipRenewalPersonalInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personalInfo");
            } else {
                qvipRenewalPersonalInfo = qvipRenewalPersonalInfo2;
            }
            qvipRenewalPersonalInfo.initView();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    /* renamed from: Ph, reason: merged with bridge method [inline-methods] */
    public FrameLayout onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FrameLayout frameLayout = new FrameLayout(requireContext());
        this.root = frameLayout;
        final ScrollView scrollView = new ScrollView(requireContext());
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.vas.pay.page.q
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                VipExpiredPayPage.Qh(VipExpiredPayPage.this, scrollView, view, i3, i16, i17, i18);
            }
        });
        scrollView.addView(Zh(), o.o());
        frameLayout.addView(scrollView);
        frameLayout.addView(Mh(), new ViewGroup.LayoutParams(-1, -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        this.payItem = (QVipPayItem) o.a(frameLayout, R.id.f66993c5, layoutParams, new Function0<QVipPayItem>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onCreateView$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QVipPayItem invoke() {
                Context requireContext = VipExpiredPayPage.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                QVipPayItem qVipPayItem = new QVipPayItem(requireContext);
                final VipExpiredPayPage vipExpiredPayPage = VipExpiredPayPage.this;
                qVipPayItem.setVisibility(8);
                o.p(qVipPayItem, o.i(34));
                qVipPayItem.setPayOnClickListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onCreateView$1$3$1$1

                    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/pay/page/VipExpiredPayPage$onCreateView$1$3$1$1$a", "Lh23/a;", "", "action", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes20.dex */
                    public static final class a implements h23.a {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ VipExpiredPayPage f310352a;

                        a(VipExpiredPayPage vipExpiredPayPage) {
                            this.f310352a = vipExpiredPayPage;
                        }

                        @Override // h23.a
                        public void action() {
                            this.f310352a.vm.P(this.f310352a.getActivity(), true);
                        }
                    }

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
                        if (!VipExpiredPayPage.this.vm.C()) {
                            ak.Q(VipExpiredPayPage.this.vm, VipExpiredPayPage.this.getActivity(), false, 2, null);
                        } else {
                            VipExpiredPayPage vipExpiredPayPage2 = VipExpiredPayPage.this;
                            vipExpiredPayPage2.ai(new a(vipExpiredPayPage2));
                        }
                    }
                });
                return qVipPayItem;
            }
        });
        initView();
        this.vm.O();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        j23.g x16 = this.vm.x();
        if (x16 != null) {
            DialogUtil.createCustomDialog(requireContext(), 230, (String) null, x16.getTitle(), x16.getLeft(), x16.getRight(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    VipExpiredPayPage.Nh(VipExpiredPayPage.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    VipExpiredPayPage.Oh(dialogInterface, i3);
                }
            }).show();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        this.vm.B();
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("extra_source");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.source = str;
        QLog.i(S, 1, "renewal page source: " + str);
        this.vm.D(this.source);
        this.isNight = o.n();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.vm.n();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        if (this.isNight != o.n()) {
            initView();
            this.vm.H();
            boolean n3 = o.n();
            this.isNight = n3;
            QLog.i(S, 1, "trigger night theme changed , now is night " + n3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.vm.R();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MutableLiveData<List<j23.a>> t16 = this.vm.t();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<List<j23.a>, Unit> function1 = new Function1<List<j23.a>, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<j23.a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<j23.a> list) {
                PreferentialItemAdapter Lh;
                QLog.i(VipExpiredPayPage.S, 1, "observe item list > count:" + (list != null ? list.size() : 0));
                Lh = VipExpiredPayPage.this.Lh();
                if (list == null) {
                    list = Collections.emptyList();
                    Intrinsics.checkNotNullExpressionValue(list, "emptyList()");
                }
                Lh.setDataList(list);
            }
        };
        t16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Uh(Function1.this, obj);
            }
        });
        MutableLiveData<j23.a> y16 = this.vm.y();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<j23.a, Unit> function12 = new Function1<j23.a, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j23.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v5, types: [com.tencent.mobileqq.vas.pay.page.QVipRenewalPreferentialServiceItemDetail] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable j23.a aVar) {
                QVipRenewalPreferentialServiceItemDetail qVipRenewalPreferentialServiceItemDetail;
                QVipRenewalPreferentialServiceItemDetail qVipRenewalPreferentialServiceItemDetail2;
                QVipRenewalPreferentialServiceItemDetail qVipRenewalPreferentialServiceItemDetail3;
                a aVar2;
                RecyclerView recyclerView;
                PreferentialItemAdapter Lh;
                ?? r56;
                QLog.i(VipExpiredPayPage.S, 1, "observe selected item > " + aVar);
                RecyclerView recyclerView2 = null;
                if (aVar == null) {
                    r56 = VipExpiredPayPage.this.preferentialItemDetail;
                    if (r56 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("preferentialItemDetail");
                    } else {
                        recyclerView2 = r56;
                    }
                    recyclerView2.setVisibility(8);
                    return;
                }
                qVipRenewalPreferentialServiceItemDetail = VipExpiredPayPage.this.preferentialItemDetail;
                if (qVipRenewalPreferentialServiceItemDetail == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferentialItemDetail");
                    qVipRenewalPreferentialServiceItemDetail = null;
                }
                qVipRenewalPreferentialServiceItemDetail.setVisibility(0);
                qVipRenewalPreferentialServiceItemDetail2 = VipExpiredPayPage.this.preferentialItemDetail;
                if (qVipRenewalPreferentialServiceItemDetail2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferentialItemDetail");
                    qVipRenewalPreferentialServiceItemDetail2 = null;
                }
                qVipRenewalPreferentialServiceItemDetail2.setDetailText(aVar.h());
                qVipRenewalPreferentialServiceItemDetail3 = VipExpiredPayPage.this.preferentialItemDetail;
                if (qVipRenewalPreferentialServiceItemDetail3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferentialItemDetail");
                    qVipRenewalPreferentialServiceItemDetail3 = null;
                }
                qVipRenewalPreferentialServiceItemDetail3.setPic(aVar.g());
                aVar2 = VipExpiredPayPage.this.centerLayoutManager;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerLayoutManager");
                    aVar2 = null;
                }
                recyclerView = VipExpiredPayPage.this.preferentialList;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferentialList");
                } else {
                    recyclerView2 = recyclerView;
                }
                aVar2.smoothScrollToPosition(recyclerView2, new RecyclerView.State(), aVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String());
                Lh = VipExpiredPayPage.this.Lh();
                Lh.notifyDataSetChanged();
            }
        };
        y16.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Vh(Function1.this, obj);
            }
        });
        MutableLiveData<j23.e> v3 = this.vm.v();
        LifecycleOwner lifecycleOwner3 = getLifecycleOwner();
        final Function1<j23.e, Unit> function13 = new Function1<j23.e, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j23.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable j23.e eVar) {
                QvipRenewalPersonalInfo qvipRenewalPersonalInfo;
                QvipRenewalPersonalInfo qvipRenewalPersonalInfo2;
                QvipRenewalPersonalInfo qvipRenewalPersonalInfo3 = null;
                QLog.i(VipExpiredPayPage.S, 1, "observe personal info > vipState:" + (eVar != null ? eVar.getVipState() : null) + " desc:" + ((Object) (eVar != null ? eVar.f() : null)));
                if (eVar == null) {
                    return;
                }
                qvipRenewalPersonalInfo = VipExpiredPayPage.this.personalInfo;
                if (qvipRenewalPersonalInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("personalInfo");
                    qvipRenewalPersonalInfo = null;
                }
                qvipRenewalPersonalInfo.setNamePlate();
                qvipRenewalPersonalInfo2 = VipExpiredPayPage.this.personalInfo;
                if (qvipRenewalPersonalInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("personalInfo");
                } else {
                    qvipRenewalPersonalInfo3 = qvipRenewalPersonalInfo2;
                }
                qvipRenewalPersonalInfo3.setUserSubtitleInfo(eVar.f(), eVar.e());
            }
        };
        v3.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Wh(Function1.this, obj);
            }
        });
        MutableLiveData<j23.b> u16 = this.vm.u();
        LifecycleOwner lifecycleOwner4 = getLifecycleOwner();
        final Function1<j23.b, Unit> function14 = new Function1<j23.b, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j23.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable j23.b bVar) {
                QVipPayItem qVipPayItem;
                QVipPayItem qVipPayItem2;
                QVipPayItem qVipPayItem3;
                QVipPayItem qVipPayItem4;
                QVipPayItem qVipPayItem5;
                QVipPayItem qVipPayItem6;
                QLog.i(VipExpiredPayPage.S, 1, "observe pay item > " + bVar);
                QVipPayItem qVipPayItem7 = null;
                if (bVar == null) {
                    qVipPayItem6 = VipExpiredPayPage.this.payItem;
                    if (qVipPayItem6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("payItem");
                    } else {
                        qVipPayItem7 = qVipPayItem6;
                    }
                    qVipPayItem7.setVisibility(8);
                    return;
                }
                qVipPayItem = VipExpiredPayPage.this.payItem;
                if (qVipPayItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payItem");
                    qVipPayItem = null;
                }
                qVipPayItem.setVisibility(0);
                qVipPayItem2 = VipExpiredPayPage.this.payItem;
                if (qVipPayItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payItem");
                    qVipPayItem2 = null;
                }
                qVipPayItem2.setOriginPrice(bVar.b());
                qVipPayItem3 = VipExpiredPayPage.this.payItem;
                if (qVipPayItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payItem");
                    qVipPayItem3 = null;
                }
                qVipPayItem3.setSaveMoney(bVar.d());
                qVipPayItem4 = VipExpiredPayPage.this.payItem;
                if (qVipPayItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payItem");
                    qVipPayItem4 = null;
                }
                qVipPayItem4.setPayDisplayText(bVar.c());
                qVipPayItem5 = VipExpiredPayPage.this.payItem;
                if (qVipPayItem5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payItem");
                } else {
                    qVipPayItem7 = qVipPayItem5;
                }
                qVipPayItem7.setPayProtocol(bVar.e(), bVar.a());
            }
        };
        u16.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Xh(Function1.this, obj);
            }
        });
        MutableLiveData<OpenHippyInfo> s16 = this.vm.s();
        LifecycleOwner lifecycleOwner5 = getLifecycleOwner();
        final Function1<OpenHippyInfo, Unit> function15 = new Function1<OpenHippyInfo, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OpenHippyInfo openHippyInfo) {
                invoke2(openHippyInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable OpenHippyInfo openHippyInfo) {
                HippyContainer hippyContainer;
                HippyContainer hippyContainer2;
                HippyContainer hippyContainer3 = null;
                QLog.i(VipExpiredPayPage.S, 1, "observe hippy info > " + (openHippyInfo != null ? openHippyInfo.bundleName : null) + " - " + (openHippyInfo != null ? openHippyInfo.domain : null));
                if (openHippyInfo == null) {
                    hippyContainer2 = VipExpiredPayPage.this.hippyContainer;
                    if (hippyContainer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
                    } else {
                        hippyContainer3 = hippyContainer2;
                    }
                    hippyContainer3.setVisibility(8);
                    return;
                }
                hippyContainer = VipExpiredPayPage.this.hippyContainer;
                if (hippyContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
                } else {
                    hippyContainer3 = hippyContainer;
                }
                hippyContainer3.setVisibility(0);
                FragmentTransaction beginTransaction = VipExpiredPayPage.this.getChildFragmentManager().beginTransaction();
                CommonHippyFragment commonHippyFragment = new CommonHippyFragment();
                VipExpiredPayPage vipExpiredPayPage = VipExpiredPayPage.this;
                if (commonHippyFragment.getArguments() == null) {
                    commonHippyFragment.setArguments(new Bundle());
                }
                Bundle arguments = commonHippyFragment.getArguments();
                if (arguments != null) {
                    arguments.putBundle("params", openHippyInfo.toBundle());
                }
                vipExpiredPayPage.hippyFragment = commonHippyFragment;
                Unit unit = Unit.INSTANCE;
                beginTransaction.replace(R.id.f66913bx, commonHippyFragment, "qvip_renewal_hippy_frag").commitNow();
            }
        };
        s16.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Yh(Function1.this, obj);
            }
        });
        MutableLiveData<RenewalPageToggleConfig.DialogCall> w3 = this.vm.w();
        LifecycleOwner lifecycleOwner6 = getLifecycleOwner();
        final VipExpiredPayPage$onViewCreated$6 vipExpiredPayPage$onViewCreated$6 = new VipExpiredPayPage$onViewCreated$6(this);
        w3.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Rh(Function1.this, obj);
            }
        });
        MutableLiveData<RenewalPageToggleConfig.DialogCall> A = this.vm.A();
        LifecycleOwner lifecycleOwner7 = getLifecycleOwner();
        final VipExpiredPayPage$onViewCreated$7 vipExpiredPayPage$onViewCreated$7 = new VipExpiredPayPage$onViewCreated$7(this);
        A.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Sh(Function1.this, obj);
            }
        });
        MutableLiveData<h23.a> z16 = this.vm.z();
        LifecycleOwner lifecycleOwner8 = getLifecycleOwner();
        final Function1<h23.a, Unit> function16 = new Function1<h23.a, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage$onViewCreated$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(h23.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(h23.a aVar) {
                if (aVar != null) {
                    VipExpiredPayPage.this.ai(aVar);
                }
            }
        };
        z16.observe(lifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.vas.pay.page.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipExpiredPayPage.Th(Function1.this, obj);
            }
        });
        this.vm.J();
    }
}
