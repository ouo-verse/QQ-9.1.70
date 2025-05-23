package com.tencent.sqshow.zootopia.publish.page.samestyle;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.publish.page.BaseSelectContentPage;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentPageType;
import com.tencent.sqshow.zootopia.samestyle.TemplateEntranceViewModel;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateCat;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.r;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import n74.ci;
import vc4.i;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bC\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b7\u00108\u0012\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/samestyle/SameStyleContentPage;", "Lcom/tencent/sqshow/zootopia/publish/page/BaseSelectContentPage;", "", "getPageId", "", "Dh", "Ln74/ci;", "binding", "Bh", "initViews", "initData", "initViewPager", "Kh", "Lh", "Eh", "Nh", "Fh", "Jh", "Ih", "Ah", OcrConfig.CHINESE, "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentPageType;", "Ch", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "E", "Ln74/ci;", "mBinding", "Lcom/tencent/sqshow/zootopia/samestyle/TemplateEntranceViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/samestyle/TemplateEntranceViewModel;", "mViewModel", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "G", "Ljava/util/List;", "mDataList", "Landroid/app/Dialog;", "H", "Landroid/app/Dialog;", "mLoadingDialog", "Lcom/tencent/sqshow/zootopia/publish/page/samestyle/d;", "I", "Lcom/tencent/sqshow/zootopia/publish/page/samestyle/d;", "mPageAdapter", "J", "Ljava/lang/String;", "getMFrom$annotations", "()V", "mFrom", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "K", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "L", "Landroid/os/Bundle;", "mExtraParams", "<init>", "M", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SameStyleContentPage extends BaseSelectContentPage {

    /* renamed from: M, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private ci mBinding;

    /* renamed from: H, reason: from kotlin metadata */
    private Dialog mLoadingDialog;

    /* renamed from: I, reason: from kotlin metadata */
    private d mPageAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private Bundle mExtraParams;

    /* renamed from: F, reason: from kotlin metadata */
    private final TemplateEntranceViewModel mViewModel = new TemplateEntranceViewModel();

    /* renamed from: G, reason: from kotlin metadata */
    private final List<ZPlanTemplateCat> mDataList = new ArrayList();

    /* renamed from: J, reason: from kotlin metadata */
    private String mFrom = SameStyleContentPageFrom.FROM_SAME_STYLE;

    /* renamed from: K, reason: from kotlin metadata */
    private final ZplanViewReportHelper mReporter = new ZplanViewReportHelper();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/samestyle/SameStyleContentPage$a;", "", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "a", "", "from", "Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/sqshow/zootopia/publish/page/samestyle/SameStyleContentPage;", "b", "KEY_EXTRA_PARAMS", "Ljava/lang/String;", "KEY_FROM", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPage$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FragmentSource a(ZootopiaSource source) {
            if (source.getMainSource() == Source.ProfileEntry) {
                return new FragmentSource(Source.Profile, source);
            }
            return new FragmentSource(Source.ZootopiaActivity, source);
        }

        public final SameStyleContentPage b(@SameStyleContentPageFrom String from, ZootopiaSource source, Bundle extraParams) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(source, "source");
            SameStyleContentPage sameStyleContentPage = new SameStyleContentPage();
            Bundle bundle = new Bundle();
            if (extraParams == null) {
                extraParams = new Bundle();
            }
            bundle.putBundle("KEY_EXTRA_PARAMS", extraParams);
            bundle.putSerializable(ZootopiaSource.KEY_FRAGMENT_SOURCE, a(source));
            bundle.putString("KEY_FROM", from);
            sameStyleContentPage.setArguments(bundle);
            return sameStyleContentPage;
        }

        Companion() {
        }

        public static /* synthetic */ SameStyleContentPage c(Companion companion, String str, ZootopiaSource zootopiaSource, Bundle bundle, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                bundle = null;
            }
            return companion.b(str, zootopiaSource, bundle);
        }
    }

    private final void Ah() {
        ci ciVar = this.mBinding;
        if (ciVar == null) {
            return;
        }
        SameStyleViewPagerTitleInner sameStyleViewPagerTitleInner = ciVar.f419020i;
        ViewPager viewPager = ciVar.f419018g;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.sameStyleViewPager");
        sameStyleViewPagerTitleInner.b(viewPager);
        SameStyleViewPagerTitleInner sameStyleViewPagerTitleInner2 = ciVar.f419020i;
        HorizontalScrollView horizontalScrollView = ciVar.f419022k;
        Intrinsics.checkNotNullExpressionValue(horizontalScrollView, "binding.viewPagerTitleArea");
        sameStyleViewPagerTitleInner2.p(horizontalScrollView, i.b(4));
    }

    private final void Bh(ci binding) {
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        String pageId = getPageId();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(uh()));
        Unit unit = Unit.INSTANCE;
        zplanViewReportHelper.a(this, root, pageId, linkedHashMap);
        ZplanViewReportHelper zplanViewReportHelper2 = this.mReporter;
        ImageView imageView = binding.f419013b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeIcon");
        zplanViewReportHelper2.g(imageView, "em_zplan_back_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void Dh() {
        Bundle arguments = getArguments();
        String str = SameStyleContentPageFrom.FROM_SAME_STYLE;
        String string = arguments != null ? arguments.getString("KEY_FROM", SameStyleContentPageFrom.FROM_SAME_STYLE) : null;
        if (string != null) {
            str = string;
        }
        this.mFrom = str;
        this.mViewModel.R1(str);
        this.mExtraParams = arguments != null ? arguments.getBundle("KEY_EXTRA_PARAMS") : null;
        QLog.i("SameStyleContentPage_", 1, "handleIntent mFrom:" + this.mFrom);
    }

    private final void Eh() {
        ci ciVar = this.mBinding;
        if (ciVar == null) {
            return;
        }
        ciVar.f419015d.setVisibility(8);
    }

    private final void Fh() {
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(SameStyleContentPage this$0, List dataList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.i("SameStyleContentPage_", 1, "dataList:" + dataList);
        List list = dataList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            this$0.Lh();
            return;
        }
        this$0.mDataList.clear();
        List<ZPlanTemplateCat> list2 = this$0.mDataList;
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        list2.addAll(list);
        this$0.Kh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(SameStyleContentPage this$0, ci binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        ImageView imageView = binding.f419013b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeIcon");
        ZplanViewReportHelper.f(zplanViewReportHelper, imageView, "em_zplan_back_btn", null, 4, null);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Ih() {
        ci ciVar = this.mBinding;
        if (ciVar == null) {
            return;
        }
        SameStyleViewPagerTitleInner sameStyleViewPagerTitleInner = ciVar.f419020i;
        Intrinsics.checkNotNullExpressionValue(sameStyleViewPagerTitleInner, "binding.titleInnerView");
        i.a.a(sameStyleViewPagerTitleInner, this.mDataList, 0, 2, null);
    }

    private final void Jh() {
        d dVar = this.mPageAdapter;
        if (dVar != null) {
            dVar.f(this.mDataList);
        }
    }

    private final void Kh() {
        Fh();
        Ih();
        Jh();
        Ah();
    }

    private final void Lh() {
        Fh();
        ci ciVar = this.mBinding;
        if (ciVar == null) {
            return;
        }
        ciVar.f419015d.c();
        ciVar.f419015d.setVisibility(0);
        aa.d(ciVar.f419015d.getBtnNetworkError(), new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.publish.page.samestyle.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SameStyleContentPage.Mh(SameStyleContentPage.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(final SameStyleContentPage this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Eh();
        TemplateEntranceViewModel templateEntranceViewModel = this$0.mViewModel;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        templateEntranceViewModel.O1((AppInterface) peekAppRuntime, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPage$showErrorUI$1$1
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
                SameStyleContentPage.this.Nh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Dialog dialog = this.mLoadingDialog;
        if (dialog == null) {
            dialog = new Dialog(activity, R.style.qZoneInputDialog);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.f168383uh);
            this.mLoadingDialog = dialog;
        }
        dialog.show();
    }

    private final String getPageId() {
        if (Intrinsics.areEqual(this.mFrom, SameStyleContentPageFrom.FROM_CONTENT_PUBLISH)) {
            return "pg_zplan_outfit_samestyle_gallery";
        }
        return "pg_zplan_samestyle_gallery";
    }

    private final void initData() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.mViewModel.Q1().observe(activity, new Observer() { // from class: com.tencent.sqshow.zootopia.publish.page.samestyle.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SameStyleContentPage.Gh(SameStyleContentPage.this, (List) obj);
            }
        });
        TemplateEntranceViewModel templateEntranceViewModel = this.mViewModel;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        templateEntranceViewModel.O1((AppInterface) peekAppRuntime, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPage$initData$2
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
                SameStyleContentPage.this.Nh();
            }
        });
    }

    private final void initViewPager() {
        ci ciVar = this.mBinding;
        if (ciVar == null) {
            return;
        }
        ZootopiaSource th5 = th();
        String str = this.mFrom;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        d dVar = new d(th5, str, childFragmentManager, this.mExtraParams);
        ciVar.f419018g.setAdapter(dVar);
        this.mPageAdapter = dVar;
    }

    private final void initViews() {
        final ci ciVar = this.mBinding;
        if (ciVar == null) {
            return;
        }
        ciVar.f419013b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.publish.page.samestyle.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SameStyleContentPage.Hh(SameStyleContentPage.this, ciVar, view);
            }
        });
        Ih();
        initViewPager();
    }

    private final void zh() {
        FragmentActivity activity;
        ci ciVar = this.mBinding;
        if (ciVar == null || (activity = getActivity()) == null) {
            return;
        }
        ciVar.getRoot().setPadding(0, CommonExKt.e(activity), 0, 0);
    }

    @Override // vc4.h
    /* renamed from: Ch, reason: merged with bridge method [inline-methods] */
    public SelectPublishContentPageType getType() {
        return SelectPublishContentPageType.SAME_STYLE;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dh();
    }

    @Override // com.tencent.sqshow.zootopia.publish.page.BaseSelectContentPage, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ci g16 = ci.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.mBinding = g16;
        return g16.getRoot();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        zh();
        initViews();
        initData();
        r.d(getActivity());
        FragmentActivity activity = getActivity();
        r.c(activity != null ? activity.getWindow() : null);
        QRouteApi api = QRoute.api(ICommonApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ICommonApi::class.java)");
        ICommonApi.a.a((ICommonApi) api, null, 1, null);
        ci ciVar = this.mBinding;
        if (ciVar != null) {
            Bh(ciVar);
        }
        FragmentActivity activity2 = getActivity();
        ZootopiaActivity zootopiaActivity = activity2 instanceof ZootopiaActivity ? (ZootopiaActivity) activity2 : null;
        if (zootopiaActivity != null) {
            zootopiaActivity.M2(R.anim.f154375jw);
        }
    }
}
