package com.tencent.mobileqq.search.searchdetail.content.template.ai.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary;
import com.tencent.mobileqq.search.searchdetail.multimedia.p;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import hp2.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn2.j;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002J(\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0018H\u0002J\u0016\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u0004J2\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00182\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010/\u001a\n ,*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/AICardFeedBackPopupWindow;", "", "Lhp2/l;", "binding", "", "o", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/FeedBackItemView;", "view", "originOption", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "Lkotlin/collections/ArrayList;", "feedBackList", "i", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$c;", "modelInfo", DomainData.DOMAIN_NAME, "u", "v", "Landroid/view/View;", "w", "", "offX", "offY", HippyTKDListViewAdapter.X, "r", "target", "y", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Landroid/view/View;", "customView", "c", "Lhp2/l;", "rootBinding", "Lcom/tencent/mobileqq/widget/tip/a;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/mobileqq/widget/tip/a;", "bubbleTip", "", "e", "I", "checkedItemCount", "f", UserInfo.SEX_FEMALE, "triangleMarginRight", "Landroidx/constraintlayout/widget/ConstraintLayout;", "g", "Lkotlin/Lazy;", "t", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "popupView", "<init>", "(Landroid/content/Context;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class AICardFeedBackPopupWindow {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View customView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private l rootBinding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.widget.tip.a bubbleTip;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int checkedItemCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float triangleMarginRight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupView;

    public AICardFeedBackPopupWindow(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.bubbleTip = com.tencent.mobileqq.widget.tip.a.r(context).b0(-1L).k0(1).R(2).p(false);
        this.triangleMarginRight = 20.0f;
        lazy = LazyKt__LazyJVMKt.lazy(new AICardFeedBackPopupWindow$popupView$2(this));
        this.popupView = lazy;
    }

    private final void i(ArrayList<SearchText> feedBackList, final l binding) {
        this.checkedItemCount = 0;
        if (feedBackList.size() > 3) {
            FeedBackItemView feedBackItemView = binding.f405688g;
            String str = feedBackList.get(3).text;
            Intrinsics.checkNotNullExpressionValue(str, "feedBackList[3].text");
            feedBackItemView.setContent(str);
            binding.f405688g.setState(false);
            binding.f405688g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AICardFeedBackPopupWindow.j(AICardFeedBackPopupWindow.this, binding, view);
                }
            });
        } else {
            binding.f405688g.setState(false);
        }
        if (feedBackList.size() > 2) {
            FeedBackItemView feedBackItemView2 = binding.f405687f;
            String str2 = feedBackList.get(2).text;
            Intrinsics.checkNotNullExpressionValue(str2, "feedBackList[2].text");
            feedBackItemView2.setContent(str2);
            binding.f405687f.setState(false);
            binding.f405687f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AICardFeedBackPopupWindow.k(AICardFeedBackPopupWindow.this, binding, view);
                }
            });
        }
        if (feedBackList.size() > 1) {
            FeedBackItemView feedBackItemView3 = binding.f405686e;
            String str3 = feedBackList.get(1).text;
            Intrinsics.checkNotNullExpressionValue(str3, "feedBackList[1].text");
            feedBackItemView3.setContent(str3);
            binding.f405686e.setState(false);
            binding.f405686e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AICardFeedBackPopupWindow.l(AICardFeedBackPopupWindow.this, binding, view);
                }
            });
        }
        if (feedBackList.size() > 0) {
            FeedBackItemView feedBackItemView4 = binding.f405685d;
            String str4 = feedBackList.get(0).text;
            Intrinsics.checkNotNullExpressionValue(str4, "feedBackList[0].text");
            feedBackItemView4.setContent(str4);
            binding.f405685d.setState(false);
            binding.f405685d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AICardFeedBackPopupWindow.m(AICardFeedBackPopupWindow.this, binding, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AICardFeedBackPopupWindow this$0, l binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f405688g;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item4");
        this$0.v(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AICardFeedBackPopupWindow this$0, l binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f405687f;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item3");
        this$0.v(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AICardFeedBackPopupWindow this$0, l binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f405686e;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item2");
        this$0.v(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AICardFeedBackPopupWindow this$0, l binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f405685d;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item1");
        this$0.v(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n(final NetSearchHunYuanDepositary.ModelInfo modelInfo, final l binding) {
        boolean isBlank;
        boolean isBlank2;
        Map<String, ? extends Object> emptyMap;
        if (modelInfo != null) {
            String str = modelInfo.getOpenSourceInfo().text;
            Intrinsics.checkNotNullExpressionValue(str, "modelInfo.openSourceInfo.text");
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                String str2 = modelInfo.getOpenSourceInfo().url;
                Intrinsics.checkNotNullExpressionValue(str2, "modelInfo.openSourceInfo.url");
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank2) {
                    LinearLayout linearLayout = binding.f405691j;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.sourceInfo");
                    p.b(linearLayout, true);
                    View view = binding.f405683b;
                    Intrinsics.checkNotNullExpressionValue(view, "binding.divider");
                    p.b(view, true);
                    binding.f405692k.setText(modelInfo.getOpenSourceInfo().text);
                    j jVar = j.f431768a;
                    LinearLayout linearLayout2 = binding.f405691j;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.sourceInfo");
                    j.u(jVar, linearLayout2, "bindSourceInfo", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.AICardFeedBackPopupWindow$bindSourceInfo$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                            invoke2(view2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            boolean startsWith$default;
                            Context context;
                            boolean startsWith$default2;
                            Context context2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            String str3 = NetSearchHunYuanDepositary.ModelInfo.this.getOpenSourceInfo().url;
                            Intrinsics.checkNotNullExpressionValue(str3, "modelInfo.openSourceInfo.url");
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "http", false, 2, null);
                            if (!startsWith$default) {
                                String str4 = NetSearchHunYuanDepositary.ModelInfo.this.getOpenSourceInfo().url;
                                Intrinsics.checkNotNullExpressionValue(str4, "modelInfo.openSourceInfo.url");
                                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str4, "https", false, 2, null);
                                if (!startsWith$default2) {
                                    IJumpApi iJumpApi = (IJumpApi) QRoute.api(IJumpApi.class);
                                    context2 = this.context;
                                    iJumpApi.doJumpAction(context2, NetSearchHunYuanDepositary.ModelInfo.this.getOpenSourceInfo().url);
                                    VideoReport.reportEvent("clck", binding.f405691j, new HashMap());
                                    this.r();
                                }
                            }
                            IReadInJoyUtils iReadInJoyUtils = (IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class);
                            context = this.context;
                            String str5 = NetSearchHunYuanDepositary.ModelInfo.this.getOpenSourceInfo().url;
                            Intrinsics.checkNotNullExpressionValue(str5, "modelInfo.openSourceInfo.url");
                            iReadInJoyUtils.jumpTo(context, str5, null);
                            VideoReport.reportEvent("clck", binding.f405691j, new HashMap());
                            this.r();
                        }
                    }, 2, null);
                    com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
                    LinearLayout linearLayout3 = binding.f405691j;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.sourceInfo");
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    aVar.d("dt_imp", linearLayout3, "em_bas_open_source_statement", emptyMap);
                    return;
                }
            }
        }
        u(binding);
    }

    private final void o(final l binding) {
        binding.f405693l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AICardFeedBackPopupWindow.p(l.this, this, view);
            }
        });
        VideoReport.setElementId(binding.f405693l, "em_bas_feedback_submission");
        VideoReport.setElementClickPolicy(binding.f405693l, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(l binding, AICardFeedBackPopupWindow this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(binding.f405693l.getContext(), 2, "\u5df2\u53cd\u9988", 0).show();
        this$0.r();
        VideoReport.reportEvent("clck", binding.f405693l, this$0.s(binding));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String q(FeedBackItemView view, String originOption) {
        boolean z16;
        if (view.getIsChecked()) {
            if (originOption.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return originOption + "," + view.a();
            }
            return view.a();
        }
        return originOption;
    }

    private final HashMap<String, Object> s(l binding) {
        FeedBackItemView feedBackItemView = binding.f405685d;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item1");
        String q16 = q(feedBackItemView, "");
        FeedBackItemView feedBackItemView2 = binding.f405686e;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView2, "binding.item2");
        String q17 = q(feedBackItemView2, q16);
        FeedBackItemView feedBackItemView3 = binding.f405687f;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView3, "binding.item3");
        String q18 = q(feedBackItemView3, q17);
        FeedBackItemView feedBackItemView4 = binding.f405688g;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView4, "binding.item4");
        String q19 = q(feedBackItemView4, q18);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("feedback_option", q19);
        return hashMap;
    }

    private final ConstraintLayout t() {
        return (ConstraintLayout) this.popupView.getValue();
    }

    private final void u(l binding) {
        LinearLayout linearLayout = binding.f405691j;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.sourceInfo");
        p.b(linearLayout, false);
        View view = binding.f405683b;
        Intrinsics.checkNotNullExpressionValue(view, "binding.divider");
        p.b(view, false);
    }

    private final void v(FeedBackItemView view) {
        QUIButton qUIButton;
        boolean z16;
        boolean z17 = true;
        boolean z18 = !view.getIsChecked();
        view.setState(z18);
        if (z18) {
            this.checkedItemCount++;
        } else {
            this.checkedItemCount--;
        }
        l lVar = this.rootBinding;
        if (lVar != null && (qUIButton = lVar.f405693l) != null) {
            if (this.checkedItemCount > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qUIButton.setClickable(z16);
            if (this.checkedItemCount <= 0) {
                z17 = false;
            }
            qUIButton.setEnabled(z17);
        }
    }

    private final void w(View view) {
        this.customView = view;
        this.bubbleTip.a0(view).Z(2, 4);
    }

    public final void r() {
        this.bubbleTip.o();
    }

    @NotNull
    public final AICardFeedBackPopupWindow x(float offX, float offY) {
        this.bubbleTip.i0(offX, offY);
        return this;
    }

    public final void y(@NotNull View target, @NotNull ArrayList<SearchText> feedBackList, @Nullable NetSearchHunYuanDepositary.ModelInfo modelInfo) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(feedBackList, "feedBackList");
        if (this.customView == null) {
            ConstraintLayout popupView = t();
            Intrinsics.checkNotNullExpressionValue(popupView, "popupView");
            w(popupView);
        }
        VideoReport.setLogicParent(t(), target);
        l lVar = this.rootBinding;
        if (lVar != null) {
            o(lVar);
            i(feedBackList, lVar);
            n(modelInfo, lVar);
        }
        this.bubbleTip.S(target);
        this.bubbleTip.s0();
    }
}
