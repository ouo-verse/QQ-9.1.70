package com.tencent.mobileqq.vas.pay.newcustomer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.page.HippyContainer;
import com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog;
import com.tencent.mobileqq.vas.pay.page.PreferentialItemAdapter;
import com.tencent.mobileqq.vas.pay.page.QVipRenewalTitle;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import i23.ExperienceExpiredCountDown;
import i23.PayListTop;
import i23.PayUserInfoText;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v23.Node;

@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 g2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010$\u001a\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerPage;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/content/Context;", "context", "Landroid/widget/ScrollView;", "Uh", "", "initView", "Lh23/a;", "action", "gi", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/widget/FrameLayout;", "Xh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onPostThemeChanged", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerViewModel;", "vm", "Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalTitle;", "D", "Lkotlin/Lazy;", "Wh", "()Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalTitle;", "title", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipBottomBtn;", "E", "Sh", "()Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipBottomBtn;", "bottomBtn", UserInfo.SEX_FEMALE, "Landroid/view/View;", "root", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "linearTopShadow", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipUserInfoCard;", "H", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipUserInfoCard;", "userInfoCard", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerPayListTitle;", "I", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerPayListTitle;", "payListTitle", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "payListContent", "Lcom/tencent/mobileqq/vas/pay/page/a;", "K", "Lcom/tencent/mobileqq/vas/pay/page/a;", "centerLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "L", "Landroidx/recyclerview/widget/RecyclerView;", "preferentialList", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "payBtn", "Lcom/tencent/mobileqq/vas/pay/page/HippyContainer;", "N", "Lcom/tencent/mobileqq/vas/pay/page/HippyContainer;", "hippyContainer", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "P", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "hippyFragment", "Lcom/tencent/mobileqq/vas/pay/page/PreferentialItemAdapter;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Th", "()Lcom/tencent/mobileqq/vas/pay/page/PreferentialItemAdapter;", "itemAdapter", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "source", "", ExifInterface.LATITUDE_SOUTH, "Z", "isNight", "Lx23/c;", "T", "Lx23/c;", "reportChain", "<init>", "()V", "U", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipNewCustomerPage extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QVipNewCustomerViewModel vm = new QVipNewCustomerViewModel();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy title;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private View root;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView linearTopShadow;

    /* renamed from: H, reason: from kotlin metadata */
    private QVipUserInfoCard userInfoCard;

    /* renamed from: I, reason: from kotlin metadata */
    private QVipNewCustomerPayListTitle payListTitle;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout payListContent;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.vas.pay.page.a centerLayoutManager;

    /* renamed from: L, reason: from kotlin metadata */
    private RecyclerView preferentialList;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView payBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private HippyContainer hippyContainer;

    /* renamed from: P, reason: from kotlin metadata */
    private CommonHippyFragment hippyFragment;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemAdapter;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String source;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isNight;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final x23.c reportChain;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerPage$b", "Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog$b;", "", "type", "", NodeProps.ON_CLICK, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements PayTypeSelectedDialog.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h23.a f310224b;

        b(h23.a aVar) {
            this.f310224b = aVar;
        }

        @Override // com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog.b
        public void onClick(int type) {
            QLog.i("QVipNewCustomerPage", 1, "user selected pay type: " + type);
            QVipNewCustomerPage.this.vm.n0(type);
            this.f310224b.action();
        }
    }

    public QVipNewCustomerPage() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new QVipNewCustomerPage$title$2(this));
        this.title = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new QVipNewCustomerPage$bottomBtn$2(this));
        this.bottomBtn = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PreferentialItemAdapter>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$itemAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PreferentialItemAdapter invoke() {
                PreferentialItemAdapter preferentialItemAdapter = new PreferentialItemAdapter(QVipNewCustomerPage.this.vm);
                preferentialItemAdapter.l0(false);
                return preferentialItemAdapter;
            }
        });
        this.itemAdapter = lazy3;
        this.source = "";
        this.reportChain = com.tencent.mobileqq.vas.report.a.f310626a.a(new w23.c("vas_new_customer", y23.a.INSTANCE.a(), 0, false, 0L, 28, null));
    }

    private final QVipBottomBtn Sh() {
        return (QVipBottomBtn) this.bottomBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreferentialItemAdapter Th() {
        return (PreferentialItemAdapter) this.itemAdapter.getValue();
    }

    private final ScrollView Uh(final Context context) {
        final ScrollView scrollView = new ScrollView(context);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.t
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                QVipNewCustomerPage.Vh(QVipNewCustomerPage.this, scrollView, view, i3, i16, i17, i18);
            }
        });
        com.tencent.mobileqq.vas.pay.page.o.c(scrollView, new FrameLayout.LayoutParams(-1, -1), new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(context);
                final Context context2 = context;
                final QVipNewCustomerPage qVipNewCustomerPage = this;
                linearLayout.setPadding(0, ViewUtils.getStatusBarHeight(context2) + com.tencent.mobileqq.vas.pay.page.o.i(50), 0, com.tencent.mobileqq.vas.pay.page.o.i(88));
                linearLayout.setOrientation(1);
                qVipNewCustomerPage.userInfoCard = (QVipUserInfoCard) com.tencent.mobileqq.vas.pay.page.o.a(linearLayout, R.id.f656639j, new LinearLayout.LayoutParams(-1, -2), new QVipNewCustomerPage$getScrollContent$1$2$1$1(context2, qVipNewCustomerPage));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = com.tencent.mobileqq.vas.pay.page.o.i(20);
                layoutParams.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(16));
                layoutParams.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(16));
                Unit unit = Unit.INSTANCE;
                qVipNewCustomerPage.payListTitle = (QVipNewCustomerPayListTitle) com.tencent.mobileqq.vas.pay.page.o.a(linearLayout, R.id.f655939c, layoutParams, new Function0<QVipNewCustomerPayListTitle>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final QVipNewCustomerPayListTitle invoke() {
                        return new QVipNewCustomerPayListTitle(context2);
                    }
                });
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(16));
                layoutParams2.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(16));
                layoutParams2.topMargin = com.tencent.mobileqq.vas.pay.page.o.i(-230);
                qVipNewCustomerPage.payListContent = (LinearLayout) com.tencent.mobileqq.vas.pay.page.o.c(linearLayout, layoutParams2, new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final LinearLayout invoke() {
                        final LinearLayout linearLayout2 = new LinearLayout(context2);
                        final QVipNewCustomerPage qVipNewCustomerPage2 = qVipNewCustomerPage;
                        linearLayout2.setOrientation(1);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams3.topMargin = com.tencent.mobileqq.vas.pay.page.o.i(16);
                        layoutParams3.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(16));
                        layoutParams3.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(16));
                        Unit unit2 = Unit.INSTANCE;
                        qVipNewCustomerPage2.preferentialList = (RecyclerView) com.tencent.mobileqq.vas.pay.page.o.a(linearLayout2, R.id.f66953c1, layoutParams3, new QVipNewCustomerPage$getScrollContent$1$2$1$5$1$2(qVipNewCustomerPage2));
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(45));
                        layoutParams4.setMarginStart(com.tencent.mobileqq.vas.pay.page.o.i(16));
                        layoutParams4.setMarginEnd(com.tencent.mobileqq.vas.pay.page.o.i(16));
                        layoutParams4.bottomMargin = com.tencent.mobileqq.vas.pay.page.o.i(16);
                        layoutParams4.topMargin = com.tencent.mobileqq.vas.pay.page.o.i(3);
                        qVipNewCustomerPage2.payBtn = (TextView) com.tencent.mobileqq.vas.pay.page.o.a(linearLayout2, R.id.f655639_, layoutParams4, new Function0<TextView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$5$1$4

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                            /* renamed from: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$5$1$4$1, reason: invalid class name */
                            /* loaded from: classes20.dex */
                            public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
                                final /* synthetic */ QVipNewCustomerPage this$0;

                                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/pay/newcustomer/QVipNewCustomerPage$getScrollContent$1$2$1$5$1$4$1$a", "Lh23/a;", "", "action", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
                                /* renamed from: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$5$1$4$1$a */
                                /* loaded from: classes20.dex */
                                public static final class a implements h23.a {

                                    /* renamed from: a, reason: collision with root package name */
                                    final /* synthetic */ QVipNewCustomerPage f310225a;

                                    a(QVipNewCustomerPage qVipNewCustomerPage) {
                                        this.f310225a = qVipNewCustomerPage;
                                    }

                                    @Override // h23.a
                                    public void action() {
                                        this.f310225a.vm.Y(this.f310225a.getActivity());
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(QVipNewCustomerPage qVipNewCustomerPage) {
                                    super(1);
                                    this.this$0 = qVipNewCustomerPage;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final void b(QVipNewCustomerPage this$0, View view) {
                                    EventCollector.getInstance().onViewClickedBefore(view);
                                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                                    if (this$0.vm.X()) {
                                        this$0.gi(new a(this$0));
                                    } else {
                                        this$0.vm.Y(this$0.getActivity());
                                    }
                                    EventCollector.getInstance().onViewClicked(view);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                                    invoke2(textView);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextView text) {
                                    Intrinsics.checkNotNullParameter(text, "$this$text");
                                    text.getPaint().setFakeBoldText(true);
                                    text.setText(this.this$0.getString(R.string.f2173360q));
                                    text.setTextSize(com.tencent.mobileqq.vas.pay.page.o.u(17));
                                    text.setGravity(17);
                                    text.setTextColor(Color.parseColor("#8F5600"));
                                    text.setBackgroundResource(R.drawable.l7s);
                                    final QVipNewCustomerPage qVipNewCustomerPage = this.this$0;
                                    text.setOnClickListener(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003d: INVOKE 
                                          (r3v0 'text' android.widget.TextView)
                                          (wrap:android.view.View$OnClickListener:0x003a: CONSTRUCTOR (r0v8 'qVipNewCustomerPage' com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage):void (m), WRAPPED] call: com.tencent.mobileqq.vas.pay.newcustomer.y.<init>(com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage):void type: CONSTRUCTOR)
                                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$5$1$4.1.invoke(android.widget.TextView):void, file: classes20.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.vas.pay.newcustomer.y, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 15 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "$this$text"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                        android.text.TextPaint r0 = r3.getPaint()
                                        r1 = 1
                                        r0.setFakeBoldText(r1)
                                        com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage r0 = r2.this$0
                                        r1 = 2131912866(0x7f1268a2, float:1.9461057E38)
                                        java.lang.String r0 = r0.getString(r1)
                                        r3.setText(r0)
                                        r0 = 17
                                        float r1 = com.tencent.mobileqq.vas.pay.page.o.u(r0)
                                        r3.setTextSize(r1)
                                        r3.setGravity(r0)
                                        java.lang.String r0 = "#8F5600"
                                        int r0 = android.graphics.Color.parseColor(r0)
                                        r3.setTextColor(r0)
                                        r0 = 2131244188(0x7f08349c, float:1.8104817E38)
                                        r3.setBackgroundResource(r0)
                                        com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage r0 = r2.this$0
                                        com.tencent.mobileqq.vas.pay.newcustomer.y r1 = new com.tencent.mobileqq.vas.pay.newcustomer.y
                                        r1.<init>(r0)
                                        r3.setOnClickListener(r1)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$5$1$4.AnonymousClass1.invoke2(android.widget.TextView):void");
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final TextView invoke() {
                                return com.tencent.mobileqq.vas.pay.page.o.v(linearLayout2, new AnonymousClass1(qVipNewCustomerPage2));
                            }
                        });
                        return linearLayout2;
                    }
                });
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, com.tencent.mobileqq.vas.pay.page.o.i(b.INSTANCE.a(context2, a.f310283a.a())));
                layoutParams3.topToBottom = R.id.f66923by;
                qVipNewCustomerPage.hippyContainer = (HippyContainer) com.tencent.mobileqq.vas.pay.page.o.a(linearLayout, R.id.f66913bx, layoutParams3, new Function0<HippyContainer>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$getScrollContent$1$2$1$7
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final HippyContainer invoke() {
                        Context requireContext = QVipNewCustomerPage.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        return new HippyContainer(requireContext);
                    }
                });
                return linearLayout;
            }
        });
        return scrollView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(QVipNewCustomerPage this$0, ScrollView scroll, View view, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scroll, "$scroll");
        if (i16 > 10) {
            this$0.Wh().setBackground(com.tencent.mobileqq.vas.pay.page.o.l(scroll, R.drawable.lac, R.drawable.laf));
        } else {
            this$0.Wh().setBackgroundColor(0);
        }
    }

    private final QVipRenewalTitle Wh() {
        return (QVipRenewalTitle) this.title.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(h23.a action) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        PayTypeSelectedDialog payTypeSelectedDialog = new PayTypeSelectedDialog(requireContext);
        payTypeSelectedDialog.O(new b(action));
        payTypeSelectedDialog.show();
    }

    private final void initView() {
        View view = this.root;
        QVipNewCustomerPayListTitle qVipNewCustomerPayListTitle = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        view.setBackgroundColor(com.tencent.mobileqq.vas.pay.page.o.f("#f5f5f5", "#000000"));
        Wh().a();
        QVipUserInfoCard qVipUserInfoCard = this.userInfoCard;
        if (qVipUserInfoCard != null) {
            if (qVipUserInfoCard == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                qVipUserInfoCard = null;
            }
            qVipUserInfoCard.initView();
        }
        if (this.linearTopShadow != null) {
            if (com.tencent.mobileqq.vas.pay.page.o.n()) {
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Drawable j3 = com.tencent.mobileqq.vas.pay.page.o.j(context, R.drawable.l7v);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = j3;
                obtain.mFailedDrawable = j3;
                URLDrawable drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/272f080d-ae54-44b6-9d36-b48b0e430213.png", obtain);
                ImageView imageView = this.linearTopShadow;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearTopShadow");
                    imageView = null;
                }
                imageView.setImageDrawable(drawable);
            } else {
                BaseApplication context2 = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                Drawable j16 = com.tencent.mobileqq.vas.pay.page.o.j(context2, R.drawable.l7u);
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mLoadingDrawable = j16;
                obtain2.mFailedDrawable = j16;
                URLDrawable drawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/d6224d94-7b07-4eab-95d4-8e9f1ecf2345.png", obtain2);
                ImageView imageView2 = this.linearTopShadow;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearTopShadow");
                    imageView2 = null;
                }
                imageView2.setImageDrawable(drawable2);
            }
        }
        QVipNewCustomerPayListTitle qVipNewCustomerPayListTitle2 = this.payListTitle;
        if (qVipNewCustomerPayListTitle2 != null) {
            if (qVipNewCustomerPayListTitle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payListTitle");
            } else {
                qVipNewCustomerPayListTitle = qVipNewCustomerPayListTitle2;
            }
            qVipNewCustomerPayListTitle.z0();
        }
        Sh().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    /* renamed from: Xh, reason: merged with bridge method [inline-methods] */
    public FrameLayout onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FrameLayout frameLayout = new FrameLayout(requireContext());
        this.root = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(requireContext());
        com.tencent.mobileqq.vas.pay.page.o.c(frameLayout2, new FrameLayout.LayoutParams(-1, (int) ((ScreenUtil.getInstantScreenWidth(requireContext()) / 750.0f) * 532.0f)), new Function0<ImageView>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onCreateView$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                ImageView imageView = new ImageView(QVipNewCustomerPage.this.requireContext());
                QVipNewCustomerPage.this.linearTopShadow = imageView;
                return imageView;
            }
        });
        frameLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, -2));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        frameLayout.addView(Uh(requireContext));
        frameLayout.addView(Wh(), new FrameLayout.LayoutParams(-1, -2));
        QVipBottomBtn Sh = Sh();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(Sh, layoutParams);
        this.reportChain.c(new Node(1));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        this.reportChain.c(new Node(0));
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
        QLog.i("QVipNewCustomerPage", 1, "newCustomer page source: " + str);
        this.vm.Z(this.source);
        this.isNight = com.tencent.mobileqq.vas.pay.page.o.n();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.vm.h0();
        this.reportChain.c(new Node(8)).end();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.reportChain.c(new Node(7));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.reportChain.c(new Node(5));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        if (this.isNight != com.tencent.mobileqq.vas.pay.page.o.n()) {
            this.isNight = com.tencent.mobileqq.vas.pay.page.o.n();
            initView();
            this.vm.d0();
            QLog.i("QVipNewCustomerPage", 1, "trigger night theme changed , now is night " + this.isNight);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.vm.A0();
        this.reportChain.c(new Node(4));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.reportChain.c(new Node(3));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.reportChain.c(new Node(6));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        MutableLiveData<List<? extends h23.c>> O = this.vm.O();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<List<? extends h23.c>, Unit> function1 = new Function1<List<? extends h23.c>, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends h23.c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<? extends h23.c> list) {
                PreferentialItemAdapter Th;
                QLog.i("QVipNewCustomerPage", 1, "observe item list > count:" + (list != null ? list.size() : 0));
                Th = QVipNewCustomerPage.this.Th();
                if (list == null) {
                    list = Collections.emptyList();
                    Intrinsics.checkNotNullExpressionValue(list, "emptyList()");
                }
                Th.setDataList(list);
            }
        };
        O.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.onViewCreated$lambda$3(Function1.this, obj);
            }
        });
        MutableLiveData<i23.c> P = this.vm.P();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<i23.c, Unit> function12 = new Function1<i23.c, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i23.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i23.c cVar) {
                TextView textView;
                TextView textView2;
                QLog.i("QVipNewCustomerPage", 1, "payBtnStyle changed: " + cVar);
                if (cVar == null) {
                    return;
                }
                textView = QVipNewCustomerPage.this.payBtn;
                TextView textView3 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payBtn");
                    textView = null;
                }
                textView.setText(cVar.getText());
                textView2 = QVipNewCustomerPage.this.payBtn;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payBtn");
                } else {
                    textView3 = textView2;
                }
                textView3.setBackgroundResource(cVar.getBgRes());
            }
        };
        P.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.ai(Function1.this, obj);
            }
        });
        MutableLiveData<PayListTop> R = this.vm.R();
        LifecycleOwner lifecycleOwner3 = getLifecycleOwner();
        final Function1<PayListTop, Unit> function13 = new Function1<PayListTop, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayListTop payListTop) {
                invoke2(payListTop);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PayListTop payListTop) {
                QVipNewCustomerPayListTitle qVipNewCustomerPayListTitle;
                QVipNewCustomerPayListTitle qVipNewCustomerPayListTitle2;
                QLog.i("QVipNewCustomerPage", 1, "payListTop changed: " + payListTop);
                if (payListTop == null) {
                    return;
                }
                qVipNewCustomerPayListTitle = QVipNewCustomerPage.this.payListTitle;
                QVipNewCustomerPayListTitle qVipNewCustomerPayListTitle3 = null;
                if (qVipNewCustomerPayListTitle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payListTitle");
                    qVipNewCustomerPayListTitle = null;
                }
                qVipNewCustomerPayListTitle.setTitle(payListTop.getTitle());
                qVipNewCustomerPayListTitle2 = QVipNewCustomerPage.this.payListTitle;
                if (qVipNewCustomerPayListTitle2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payListTitle");
                } else {
                    qVipNewCustomerPayListTitle3 = qVipNewCustomerPayListTitle2;
                }
                qVipNewCustomerPayListTitle3.setSubtitle(payListTop.getSubtitle());
            }
        };
        R.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.bi(Function1.this, obj);
            }
        });
        MutableLiveData<OpenHippyInfo> N = this.vm.N();
        LifecycleOwner lifecycleOwner4 = getLifecycleOwner();
        final Function1<OpenHippyInfo, Unit> function14 = new Function1<OpenHippyInfo, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$4
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
                QLog.i("QVipNewCustomerPage", 1, "observe hippy info > " + (openHippyInfo != null ? openHippyInfo.bundleName : null) + " - " + (openHippyInfo != null ? openHippyInfo.domain : null));
                if (openHippyInfo == null) {
                    hippyContainer2 = QVipNewCustomerPage.this.hippyContainer;
                    if (hippyContainer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
                    } else {
                        hippyContainer3 = hippyContainer2;
                    }
                    hippyContainer3.setVisibility(8);
                    return;
                }
                hippyContainer = QVipNewCustomerPage.this.hippyContainer;
                if (hippyContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hippyContainer");
                } else {
                    hippyContainer3 = hippyContainer;
                }
                hippyContainer3.setVisibility(0);
                FragmentTransaction beginTransaction = QVipNewCustomerPage.this.getChildFragmentManager().beginTransaction();
                CommonHippyFragment commonHippyFragment = new CommonHippyFragment();
                QVipNewCustomerPage qVipNewCustomerPage = QVipNewCustomerPage.this;
                if (commonHippyFragment.getArguments() == null) {
                    commonHippyFragment.setArguments(new Bundle());
                }
                Bundle arguments = commonHippyFragment.getArguments();
                if (arguments != null) {
                    arguments.putBundle("params", openHippyInfo.toBundle());
                }
                qVipNewCustomerPage.hippyFragment = commonHippyFragment;
                Unit unit = Unit.INSTANCE;
                beginTransaction.replace(R.id.f66913bx, commonHippyFragment, "qvip_new_customer_hippy_frag").commitNow();
            }
        };
        N.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.ci(Function1.this, obj);
            }
        });
        MutableLiveData<PayUserInfoText> V = this.vm.V();
        LifecycleOwner lifecycleOwner5 = getLifecycleOwner();
        final Function1<PayUserInfoText, Unit> function15 = new Function1<PayUserInfoText, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayUserInfoText payUserInfoText) {
                invoke2(payUserInfoText);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PayUserInfoText payUserInfoText) {
                QVipUserInfoCard qVipUserInfoCard;
                QVipUserInfoCard qVipUserInfoCard2;
                QVipUserInfoCard qVipUserInfoCard3;
                QVipUserInfoCard qVipUserInfoCard4;
                QVipUserInfoCard qVipUserInfoCard5;
                QVipUserInfoCard qVipUserInfoCard6;
                QVipUserInfoCard qVipUserInfoCard7;
                QLog.i("QVipNewCustomerPage", 1, "userInfoText changed: " + payUserInfoText);
                if (payUserInfoText == null) {
                    return;
                }
                qVipUserInfoCard = QVipNewCustomerPage.this.userInfoCard;
                QVipUserInfoCard qVipUserInfoCard8 = null;
                if (qVipUserInfoCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                    qVipUserInfoCard = null;
                }
                qVipUserInfoCard.initView();
                qVipUserInfoCard2 = QVipNewCustomerPage.this.userInfoCard;
                if (qVipUserInfoCard2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                    qVipUserInfoCard2 = null;
                }
                qVipUserInfoCard2.setPayBtn(payUserInfoText.getPayText(), payUserInfoText.getPayMarkText());
                qVipUserInfoCard3 = QVipNewCustomerPage.this.userInfoCard;
                if (qVipUserInfoCard3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                    qVipUserInfoCard3 = null;
                }
                qVipUserInfoCard3.setCountDownGetExperience(payUserInfoText.getIsCountDownGetExperience());
                qVipUserInfoCard4 = QVipNewCustomerPage.this.userInfoCard;
                if (qVipUserInfoCard4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                    qVipUserInfoCard4 = null;
                }
                qVipUserInfoCard4.setUserStatusTitle(payUserInfoText.getStatusTitle());
                qVipUserInfoCard5 = QVipNewCustomerPage.this.userInfoCard;
                if (qVipUserInfoCard5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                    qVipUserInfoCard5 = null;
                }
                qVipUserInfoCard5.setUserStatusSubtitle(payUserInfoText.getStatusSubtitle());
                qVipUserInfoCard6 = QVipNewCustomerPage.this.userInfoCard;
                if (qVipUserInfoCard6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                    qVipUserInfoCard6 = null;
                }
                qVipUserInfoCard6.setCountDownText(payUserInfoText.a());
                qVipUserInfoCard7 = QVipNewCustomerPage.this.userInfoCard;
                if (qVipUserInfoCard7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                } else {
                    qVipUserInfoCard8 = qVipUserInfoCard7;
                }
                qVipUserInfoCard8.setGetExperienceBtnText(payUserInfoText.getGetExperienceQualificationText());
            }
        };
        V.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.di(Function1.this, obj);
            }
        });
        MutableLiveData<i23.b> T = this.vm.T();
        LifecycleOwner lifecycleOwner6 = getLifecycleOwner();
        final Function1<i23.b, Unit> function16 = new Function1<i23.b, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i23.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable i23.b bVar) {
                com.tencent.mobileqq.vas.pay.page.a aVar;
                RecyclerView recyclerView;
                PreferentialItemAdapter Th;
                QLog.i("QVipNewCustomerPage", 1, "selectedItem changed: " + bVar);
                if (bVar == null) {
                    return;
                }
                aVar = QVipNewCustomerPage.this.centerLayoutManager;
                RecyclerView recyclerView2 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerLayoutManager");
                    aVar = null;
                }
                recyclerView = QVipNewCustomerPage.this.preferentialList;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferentialList");
                } else {
                    recyclerView2 = recyclerView;
                }
                aVar.smoothScrollToPosition(recyclerView2, new RecyclerView.State(), bVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String());
                Th = QVipNewCustomerPage.this.Th();
                Th.notifyDataSetChanged();
            }
        };
        T.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.ei(Function1.this, obj);
            }
        });
        MutableLiveData<ExperienceExpiredCountDown> M = this.vm.M();
        LifecycleOwner lifecycleOwner7 = getLifecycleOwner();
        final Function1<ExperienceExpiredCountDown, Unit> function17 = new Function1<ExperienceExpiredCountDown, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExperienceExpiredCountDown experienceExpiredCountDown) {
                invoke2(experienceExpiredCountDown);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ExperienceExpiredCountDown experienceExpiredCountDown) {
                QVipUserInfoCard qVipUserInfoCard;
                QVipUserInfoCard qVipUserInfoCard2;
                QLog.i("QVipNewCustomerPage", 1, "experienceExpiredCountDown changed: " + experienceExpiredCountDown);
                QVipUserInfoCard qVipUserInfoCard3 = null;
                if (experienceExpiredCountDown == null) {
                    qVipUserInfoCard2 = QVipNewCustomerPage.this.userInfoCard;
                    if (qVipUserInfoCard2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                    } else {
                        qVipUserInfoCard3 = qVipUserInfoCard2;
                    }
                    qVipUserInfoCard3.D0();
                    return;
                }
                qVipUserInfoCard = QVipNewCustomerPage.this.userInfoCard;
                if (qVipUserInfoCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userInfoCard");
                } else {
                    qVipUserInfoCard3 = qVipUserInfoCard;
                }
                qVipUserInfoCard3.setExperienceExpiredCountDown(experienceExpiredCountDown.getDay(), experienceExpiredCountDown.getHour(), experienceExpiredCountDown.getMinute(), experienceExpiredCountDown.getSec());
            }
        };
        M.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.fi(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> Q = this.vm.Q();
        LifecycleOwner lifecycleOwner8 = getLifecycleOwner();
        final Function1<Boolean, Unit> function18 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QVipNewCustomerPayListTitle qVipNewCustomerPayListTitle;
                LinearLayout linearLayout;
                QVipNewCustomerPayListTitle qVipNewCustomerPayListTitle2;
                LinearLayout linearLayout2;
                QLog.i("QVipNewCustomerPage", 1, "payContentVisible changed: " + it);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                LinearLayout linearLayout3 = null;
                if (it.booleanValue()) {
                    qVipNewCustomerPayListTitle2 = QVipNewCustomerPage.this.payListTitle;
                    if (qVipNewCustomerPayListTitle2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("payListTitle");
                        qVipNewCustomerPayListTitle2 = null;
                    }
                    qVipNewCustomerPayListTitle2.setVisibility(0);
                    linearLayout2 = QVipNewCustomerPage.this.payListContent;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("payListContent");
                    } else {
                        linearLayout3 = linearLayout2;
                    }
                    linearLayout3.setVisibility(0);
                    return;
                }
                qVipNewCustomerPayListTitle = QVipNewCustomerPage.this.payListTitle;
                if (qVipNewCustomerPayListTitle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payListTitle");
                    qVipNewCustomerPayListTitle = null;
                }
                qVipNewCustomerPayListTitle.setVisibility(8);
                linearLayout = QVipNewCustomerPage.this.payListContent;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payListContent");
                } else {
                    linearLayout3 = linearLayout;
                }
                linearLayout3.setVisibility(8);
            }
        };
        Q.observe(lifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.Yh(Function1.this, obj);
            }
        });
        MutableLiveData<h23.a> U = this.vm.U();
        LifecycleOwner lifecycleOwner9 = getLifecycleOwner();
        final Function1<h23.a, Unit> function19 = new Function1<h23.a, Unit>() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage$onViewCreated$9
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
                    QVipNewCustomerPage.this.gi(aVar);
                }
            }
        };
        U.observe(lifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QVipNewCustomerPage.Zh(Function1.this, obj);
            }
        });
        this.vm.k0();
        this.vm.p0();
        this.reportChain.c(new Node(2));
    }
}
