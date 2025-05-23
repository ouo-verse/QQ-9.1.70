package com.tencent.biz.qqcircle.immersive.search.prompt.rank;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import circlesearch.CircleSearchExhibition$PromptRankingInfo;
import circlesearch.CircleSearchExhibition$StPromptResp;
import circlesearch.CircleSearchExhibition$TabData;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u00015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/QFSSearchPromptRankPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcirclesearch/CircleSearchExhibition$StPromptResp;", "uiData", "", "L9", "", "Lcirclesearch/CircleSearchExhibition$PromptRankingInfo;", "rankInfos", "I9", "info", "", "E9", "D9", "", "N9", "Lcirclesearch/CircleSearchExhibition$TabData;", "tabData", "Landroid/view/View;", "G9", "Landroid/content/res/ColorStateList;", "F9", "", "id", "J9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lcom/google/android/material/tabs/TabLayout;", "e", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/e;", "f", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/e;", "rankAdapter", "Lcom/google/android/material/tabs/d;", h.F, "Lcom/google/android/material/tabs/d;", "tabLayoutMediator", "Lp70/e;", "i", "Lkotlin/Lazy;", "K9", "()Lp70/e;", "viewModel", "com/tencent/biz/qqcircle/immersive/search/prompt/rank/QFSSearchPromptRankPart$a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/QFSSearchPromptRankPart$a;", "onTabSelectedListener", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankPart extends u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TabLayout tabLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e rankAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.google.android.material.tabs.d tabLayoutMediator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a onTabSelectedListener;

    public QFSSearchPromptRankPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<p70.e>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p70.e invoke() {
                return (p70.e) QFSSearchPromptRankPart.this.getViewModel(p70.e.class);
            }
        });
        this.viewModel = lazy;
        this.onTabSelectedListener = new a();
    }

    private final boolean D9(CircleSearchExhibition$PromptRankingInfo info) {
        if (info.page.style.get() == 1 || info.page.style.get() == 4) {
            return true;
        }
        return false;
    }

    private final boolean E9(CircleSearchExhibition$PromptRankingInfo info) {
        if (info.type.get() == 2 || info.type.get() == 1) {
            return true;
        }
        return false;
    }

    private final ColorStateList F9(CircleSearchExhibition$TabData tabData) {
        boolean isBlank;
        int J9;
        String str = tabData.text_color.get();
        Intrinsics.checkNotNullExpressionValue(str, "tabData.text_color.get()");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if ((!isBlank) && !com.tencent.biz.qqcircle.immersive.utils.a.a()) {
            Integer F = p.F(tabData.text_color.get());
            if (F == null) {
                J9 = J9(R.color.qui_common_text_primary);
            } else {
                J9 = F.intValue();
            }
        } else {
            J9 = J9(R.color.qui_common_text_primary);
        }
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{J9, J9(R.color.qui_common_text_secondary)});
    }

    private final View G9(CircleSearchExhibition$TabData tabData) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setMaxLines(1);
        textView.setTextSize(15.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSSearchPromptRankPart.H9(view);
            }
        });
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_TAB);
        VideoReport.setElementExposePolicy(textView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(textView, ClickPolicy.REPORT_NONE);
        if (tabData != null) {
            textView.setText(tabData.text.get());
            textView.setTextColor(F9(tabData));
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(View view) {
        TextView textView;
        CharSequence charSequence;
        EventCollector.getInstance().onViewClickedBefore(view);
        View view2 = null;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = null;
        }
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_tab_name", charSequence);
        VideoReport.reportEvent("dt_clck", view, params);
        Object parent = view.getParent();
        if (parent instanceof View) {
            view2 = (View) parent;
        }
        if (view2 != null) {
            view2.performClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9(List<CircleSearchExhibition$PromptRankingInfo> rankInfos) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (Object obj : rankInfos) {
            CircleSearchExhibition$PromptRankingInfo circleSearchExhibition$PromptRankingInfo = (CircleSearchExhibition$PromptRankingInfo) obj;
            if (E9(circleSearchExhibition$PromptRankingInfo) && D9(circleSearchExhibition$PromptRankingInfo)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        if (this.rankAdapter == null) {
            QFSBaseFragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            e eVar = new e(hostFragment);
            this.rankAdapter = eVar;
            ViewPager2 viewPager2 = this.viewPager2;
            if (viewPager2 != null) {
                viewPager2.setAdapter(eVar);
            }
            N9(arrayList);
        }
        e eVar2 = this.rankAdapter;
        if (eVar2 != null) {
            eVar2.setData(arrayList);
        }
    }

    private final int J9(int id5) {
        return ie0.a.f().g(getContext(), id5, 1000);
    }

    private final p70.e K9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (p70.e) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(UIStateData<CircleSearchExhibition$StPromptResp> uiData) {
        int state = uiData.getState();
        if (state == 2 || state == 3) {
            List<CircleSearchExhibition$PromptRankingInfo> list = uiData.getData().ranking.rankings.get();
            Intrinsics.checkNotNullExpressionValue(list, "uiData.data.ranking.rankings.get()");
            I9(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9(final List<CircleSearchExhibition$PromptRankingInfo> rankInfos) {
        com.google.android.material.tabs.d dVar = this.tabLayoutMediator;
        if (dVar != null) {
            dVar.b();
        }
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            ViewPager2 viewPager2 = this.viewPager2;
            if (viewPager2 != null) {
                this.tabLayoutMediator = new com.google.android.material.tabs.d(tabLayout, viewPager2, new d.b() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.c
                    @Override // com.google.android.material.tabs.d.b
                    public final void a(TabLayout.g gVar, int i3) {
                        QFSSearchPromptRankPart.O9(QFSSearchPromptRankPart.this, rankInfos, gVar, i3);
                    }
                });
            }
            tabLayout.f(this.onTabSelectedListener);
        }
        com.google.android.material.tabs.d dVar2 = this.tabLayoutMediator;
        if (dVar2 != null) {
            dVar2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QFSSearchPromptRankPart this$0, List rankInfos, TabLayout.g tab, int i3) {
        Object orNull;
        CircleSearchExhibition$TabData circleSearchExhibition$TabData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rankInfos, "$rankInfos");
        Intrinsics.checkNotNullParameter(tab, "tab");
        orNull = CollectionsKt___CollectionsKt.getOrNull(rankInfos, i3);
        CircleSearchExhibition$PromptRankingInfo circleSearchExhibition$PromptRankingInfo = (CircleSearchExhibition$PromptRankingInfo) orNull;
        if (circleSearchExhibition$PromptRankingInfo != null) {
            circleSearchExhibition$TabData = circleSearchExhibition$PromptRankingInfo.tab;
        } else {
            circleSearchExhibition$TabData = null;
        }
        tab.p(this$0.G9(circleSearchExhibition$TabData));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewPager2 viewPager2;
        TabLayout tabLayout;
        Object obj;
        super.onInitView(rootView);
        AppBarLayout.LayoutParams layoutParams = null;
        if (rootView != null) {
            viewPager2 = (ViewPager2) rootView.findViewById(R.id.f54062e7);
        } else {
            viewPager2 = null;
        }
        this.viewPager2 = viewPager2;
        if (rootView != null) {
            tabLayout = (TabLayout) rootView.findViewById(R.id.f54012e2);
        } else {
            tabLayout = null;
        }
        this.tabLayout = tabLayout;
        if (!r60.a.f430818a.a()) {
            TabLayout tabLayout2 = this.tabLayout;
            if (tabLayout2 != null) {
                obj = tabLayout2.getLayoutParams();
            } else {
                obj = null;
            }
            if (obj instanceof AppBarLayout.LayoutParams) {
                layoutParams = (AppBarLayout.LayoutParams) obj;
            }
            if (layoutParams != null) {
                layoutParams.g(1);
            }
        }
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 != null) {
            viewPager22.setOffscreenPageLimit(1);
        }
        MutableLiveData<UIStateData<CircleSearchExhibition$StPromptResp>> M1 = K9().M1();
        QFSBaseFragment hostFragment = getHostFragment();
        final Function1<UIStateData<CircleSearchExhibition$StPromptResp>, Unit> function1 = new Function1<UIStateData<CircleSearchExhibition$StPromptResp>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<CircleSearchExhibition$StPromptResp> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<CircleSearchExhibition$StPromptResp> it) {
                QFSSearchPromptRankPart qFSSearchPromptRankPart = QFSSearchPromptRankPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qFSSearchPromptRankPart.L9(it);
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj2) {
                QFSSearchPromptRankPart.M9(Function1.this, obj2);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            tabLayout.O(this.onTabSelectedListener);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/search/prompt/rank/QFSSearchPromptRankPart$a", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements TabLayout.d {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@Nullable TabLayout.g tab) {
            VideoReport.traversePage(QFSSearchPromptRankPart.this.viewPager2);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(@Nullable TabLayout.g tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(@Nullable TabLayout.g tab) {
        }
    }
}
