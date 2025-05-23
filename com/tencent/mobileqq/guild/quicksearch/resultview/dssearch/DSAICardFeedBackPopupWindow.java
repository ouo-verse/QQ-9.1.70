package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ck;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002J(\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0014H\u0002J\u0016\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0018J&\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00142\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010/\u001a\n ,*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAICardFeedBackPopupWindow;", "", "Lvp1/ck;", "binding", "", "o", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/FeedBackItemView;", "view", "originOption", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "Lkotlin/collections/ArrayList;", "feedBackList", "j", "u", "Landroid/view/View;", "button", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "", "offX", "offY", HippyTKDListViewAdapter.X, "r", NodeProps.MARGIN_RIGHT, "y", "target", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Landroid/view/View;", "customView", "c", "Lvp1/ck;", "rootBinding", "Lcom/tencent/mobileqq/widget/tip/a;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/mobileqq/widget/tip/a;", "bubbleTip", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "Lkotlin/Lazy;", "t", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "popupView", "", "f", "I", "checkedItemCount", "g", UserInfo.SEX_FEMALE, "triangleMarginRight", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DSAICardFeedBackPopupWindow {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View customView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ck rootBinding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.widget.tip.a bubbleTip;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int checkedItemCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float triangleMarginRight;

    public DSAICardFeedBackPopupWindow(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.bubbleTip = com.tencent.mobileqq.widget.tip.a.r(context).b0(-1L).k0(1).R(2).p(false);
        lazy = LazyKt__LazyJVMKt.lazy(new DSAICardFeedBackPopupWindow$popupView$2(this));
        this.popupView = lazy;
        this.triangleMarginRight = 20.0f;
    }

    private final void j(ArrayList<SearchText> feedBackList, final ck binding) {
        this.checkedItemCount = 0;
        if (feedBackList.size() > 3) {
            FeedBackItemView feedBackItemView = binding.f442722f;
            String str = feedBackList.get(3).text;
            Intrinsics.checkNotNullExpressionValue(str, "feedBackList[3].text");
            feedBackItemView.setContent(str);
            binding.f442722f.setState(false);
            binding.f442722f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAICardFeedBackPopupWindow.k(DSAICardFeedBackPopupWindow.this, binding, view);
                }
            });
        }
        if (feedBackList.size() > 2) {
            FeedBackItemView feedBackItemView2 = binding.f442721e;
            String str2 = feedBackList.get(2).text;
            Intrinsics.checkNotNullExpressionValue(str2, "feedBackList[2].text");
            feedBackItemView2.setContent(str2);
            binding.f442721e.setState(false);
            binding.f442721e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAICardFeedBackPopupWindow.l(DSAICardFeedBackPopupWindow.this, binding, view);
                }
            });
        }
        if (feedBackList.size() > 1) {
            FeedBackItemView feedBackItemView3 = binding.f442720d;
            String str3 = feedBackList.get(1).text;
            Intrinsics.checkNotNullExpressionValue(str3, "feedBackList[1].text");
            feedBackItemView3.setContent(str3);
            binding.f442720d.setState(false);
            binding.f442720d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAICardFeedBackPopupWindow.m(DSAICardFeedBackPopupWindow.this, binding, view);
                }
            });
        }
        if (feedBackList.size() > 0) {
            FeedBackItemView feedBackItemView4 = binding.f442719c;
            String str4 = feedBackList.get(0).text;
            Intrinsics.checkNotNullExpressionValue(str4, "feedBackList[0].text");
            feedBackItemView4.setContent(str4);
            binding.f442719c.setState(false);
            binding.f442719c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAICardFeedBackPopupWindow.n(DSAICardFeedBackPopupWindow.this, binding, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DSAICardFeedBackPopupWindow this$0, ck binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f442722f;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item4");
        this$0.u(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DSAICardFeedBackPopupWindow this$0, ck binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f442721e;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item3");
        this$0.u(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DSAICardFeedBackPopupWindow this$0, ck binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f442720d;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item2");
        this$0.u(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DSAICardFeedBackPopupWindow this$0, ck binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        FeedBackItemView feedBackItemView = binding.f442719c;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item1");
        this$0.u(feedBackItemView);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o(final ck binding) {
        binding.f442725i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DSAICardFeedBackPopupWindow.p(DSAICardFeedBackPopupWindow.this, binding, view);
            }
        });
        VideoReport.setElementId(binding.f442725i, "em_sgrp_ai_search_result_feedback_float");
        VideoReport.setElementClickPolicy(binding.f442725i, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DSAICardFeedBackPopupWindow this$0, ck binding, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        QUIButton qUIButton = binding.f442725i;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.submitBtn");
        this$0.z(qUIButton);
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

    private final HashMap<String, Object> s(ck binding) {
        FeedBackItemView feedBackItemView = binding.f442719c;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView, "binding.item1");
        String q16 = q(feedBackItemView, "");
        FeedBackItemView feedBackItemView2 = binding.f442720d;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView2, "binding.item2");
        String q17 = q(feedBackItemView2, q16);
        FeedBackItemView feedBackItemView3 = binding.f442721e;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView3, "binding.item3");
        String q18 = q(feedBackItemView3, q17);
        FeedBackItemView feedBackItemView4 = binding.f442722f;
        Intrinsics.checkNotNullExpressionValue(feedBackItemView4, "binding.item4");
        String q19 = q(feedBackItemView4, q18);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_content_feedback_reason", q19);
        return hashMap;
    }

    private final ConstraintLayout t() {
        return (ConstraintLayout) this.popupView.getValue();
    }

    private final void u(FeedBackItemView view) {
        QUIButton qUIButton;
        QUIButton qUIButton2;
        QUIButton qUIButton3;
        boolean z16;
        boolean z17 = true;
        boolean z18 = !view.getIsChecked();
        view.setState(z18);
        if (z18) {
            this.checkedItemCount++;
        } else {
            this.checkedItemCount--;
        }
        ck ckVar = this.rootBinding;
        if (ckVar != null && (qUIButton3 = ckVar.f442725i) != null) {
            if (this.checkedItemCount > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qUIButton3.setClickable(z16);
            if (this.checkedItemCount <= 0) {
                z17 = false;
            }
            qUIButton3.setEnabled(z17);
        }
        if (this.checkedItemCount == 0) {
            ck ckVar2 = this.rootBinding;
            if (ckVar2 != null && (qUIButton2 = ckVar2.f442725i) != null) {
                qUIButton2.setOnClickListener(null);
                return;
            }
            return;
        }
        ck ckVar3 = this.rootBinding;
        if (ckVar3 != null && (qUIButton = ckVar3.f442725i) != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DSAICardFeedBackPopupWindow.v(DSAICardFeedBackPopupWindow.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DSAICardFeedBackPopupWindow this$0, View view) {
        QUIButton qUIButton;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ck ckVar = this$0.rootBinding;
        if (ckVar != null) {
            qUIButton = ckVar.f442725i;
        } else {
            qUIButton = null;
        }
        Intrinsics.checkNotNull(qUIButton);
        this$0.z(qUIButton);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(View view) {
        this.customView = view;
        this.bubbleTip.a0(view).Z(2, 4);
    }

    private final void z(View button) {
        QQToast.makeText(button.getContext(), 2, "\u5df2\u53cd\u9988", 0).show();
        r();
        ck ckVar = this.rootBinding;
        Intrinsics.checkNotNull(ckVar);
        VideoReport.reportEvent("clck", button, s(ckVar));
    }

    public final void A(@NotNull View target, @NotNull ArrayList<SearchText> feedBackList) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(feedBackList, "feedBackList");
        if (this.customView == null) {
            ConstraintLayout popupView = t();
            Intrinsics.checkNotNullExpressionValue(popupView, "popupView");
            w(popupView);
        }
        VideoReport.setLogicParent(t(), target);
        ck ckVar = this.rootBinding;
        if (ckVar != null) {
            o(ckVar);
            j(feedBackList, ckVar);
        }
        this.bubbleTip.S(target);
        this.bubbleTip.s0();
        VideoReport.setLogicParent(this.bubbleTip.v(), target);
    }

    public final void r() {
        this.bubbleTip.o();
    }

    @NotNull
    public final DSAICardFeedBackPopupWindow x(float offX, float offY) {
        this.bubbleTip.i0(offX, offY);
        return this;
    }

    public final void y(float marginRight) {
        this.triangleMarginRight = marginRight;
    }
}
