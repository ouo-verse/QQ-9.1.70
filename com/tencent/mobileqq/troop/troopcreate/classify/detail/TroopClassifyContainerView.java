package com.tencent.mobileqq.troop.troopcreate.classify.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0010\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0004J,\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyContainerView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyChildView;", "itemView", "", "l", "", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/b;", "items", "", "firstLevelName", "f", "Landroid/widget/TextView;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "e", "k", "", "size", "b", "i", "Landroid/view/View;", tl.h.F, "d", "childContainerView", "c", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyChildView;", "preClickChildView", "Lkotlin/Lazy;", "j", "()Landroid/widget/LinearLayout;", "expandLayout", "I", "curExpandChildSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopClassifyContainerView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopClassifyChildView preClickChildView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy expandLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curExpandChildSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyContainerView$a;", "", "", "EXPAND_LAYOUT_COLUMN", "I", "", "FIRST_ITEM_TOP_MARGIN", UserInfo.SEX_FEMALE, "GROUP_BOTTOM_MARGIN", "ITEM_HEIGHT", "ITEM_HOR_GAP_WIDTH", "ITEM_HOT_MARGIN", "ITEM_TEXT_SIZE", "ITEM_VER_MARGIN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.classify.detail.TroopClassifyContainerView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25190);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyContainerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    private final void b(int size) {
        int i3;
        int dip2px;
        int i16 = this.curExpandChildSize;
        int i17 = size - i16;
        if (i17 % 3 == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        int i18 = ((i17 / 3) + i3) * 3;
        this.curExpandChildSize = i16 + i18;
        LinearLayout linearLayout = null;
        for (int i19 = 0; i19 < i18; i19++) {
            int i26 = i19 % 3;
            if (i26 == 0) {
                linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum(3.0f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (j().getChildCount() == 0) {
                    dip2px = ViewUtils.dip2px(12.0f);
                } else {
                    dip2px = ViewUtils.dip2px(4.0f);
                }
                layoutParams.topMargin = dip2px;
                layoutParams.bottomMargin = ViewUtils.dip2px(4.0f);
                layoutParams.leftMargin = ViewUtils.dip2px(16.0f);
                layoutParams.rightMargin = ViewUtils.dip2px(16.0f);
                linearLayout.setLayoutParams(layoutParams);
                j().addView(linearLayout);
            }
            if (linearLayout != null) {
                linearLayout.addView(i());
            }
            if (i26 != 2 && linearLayout != null) {
                linearLayout.addView(h());
            }
        }
    }

    private final void e(TextView itemView, b item, String firstLevelName) {
        VideoReport.setElementId(itemView, "em_group_classify_icon");
        VideoReport.setElementClickPolicy(itemView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("group_first_level", firstLevelName);
        hashMap.put("group_second_level", item.e());
        hashMap.put("group_level_id", item.c());
        VideoReport.setElementParams(itemView, hashMap);
    }

    private final void f(List<b> items, String firstLevelName) {
        LinearLayout linearLayout;
        IntRange until;
        IntProgression step;
        TextView textView;
        int childCount = j().getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = j().getChildAt(i16);
            if (childAt instanceof LinearLayout) {
                linearLayout = (LinearLayout) childAt;
            } else {
                linearLayout = null;
            }
            if (i3 >= items.size()) {
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            if (linearLayout != null) {
                until = RangesKt___RangesKt.until(0, linearLayout.getChildCount());
                step = RangesKt___RangesKt.step(until, 2);
                int first = step.getFirst();
                int last = step.getLast();
                int step2 = step.getStep();
                if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                    while (true) {
                        View childAt2 = linearLayout.getChildAt(first);
                        if (childAt2 instanceof TextView) {
                            textView = (TextView) childAt2;
                        } else {
                            textView = null;
                        }
                        if (textView != null) {
                            if (i3 < items.size()) {
                                textView.setVisibility(0);
                                final b bVar = items.get(i3);
                                textView.setText(bVar.e());
                                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.detail.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        TroopClassifyContainerView.g(TroopClassifyContainerView.this, bVar, view);
                                    }
                                });
                                e(textView, bVar, firstLevelName);
                            } else {
                                textView.setVisibility(8);
                                VideoReport.setElementId(textView, "");
                            }
                        }
                        i3++;
                        if (first != last) {
                            first += step2;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TroopClassifyContainerView this$0, b item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.k(item);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View h() {
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dip2px(12.0f), 0));
        return view;
    }

    private final TextView i() {
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewUtils.dip2px(40.0f));
        layoutParams.weight = 1.0f;
        textView.setLayoutParams(layoutParams);
        textView.setMaxLines(1);
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_primary));
        textView.setTextSize(0, ViewUtils.dip2px(13.0f));
        textView.setBackgroundResource(R.drawable.lvz);
        textView.setGravity(17);
        return textView;
    }

    private final LinearLayout j() {
        return (LinearLayout) this.expandLayout.getValue();
    }

    private final void k(b item) {
        Activity activity;
        Intent intent = new Intent();
        intent.putExtra("url", item.d());
        intent.putExtra("isShowAd", false);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        com.tencent.mobileqq.troop.troopcreate.a.k(getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
        QLog.i("TroopClassifyContainerView", 1, "[jumpToH5] item:" + item);
    }

    private final void l(TroopClassifyChildView itemView) {
        TroopClassifyChildView troopClassifyChildView = this.preClickChildView;
        if (troopClassifyChildView != null) {
            troopClassifyChildView.g(false);
        }
        if (itemView != null) {
            itemView.g(true);
        }
        this.preClickChildView = itemView;
    }

    public final void c(@NotNull LinearLayout childContainerView, @NotNull TroopClassifyChildView itemView, @NotNull List<b> items, @NotNull String firstLevelName) {
        View view;
        int i3;
        boolean z16;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, childContainerView, itemView, items, firstLevelName);
            return;
        }
        Intrinsics.checkNotNullParameter(childContainerView, "childContainerView");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(firstLevelName, "firstLevelName");
        Object parent = itemView.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        int indexOfChild = childContainerView.indexOfChild(view);
        int indexOfChild2 = childContainerView.indexOfChild(j());
        if (indexOfChild2 != -1 && indexOfChild2 < indexOfChild) {
            i3 = indexOfChild - 1;
        } else {
            i3 = indexOfChild;
        }
        QLog.i("TroopClassifyContainerView", 1, "[clickToSwitch]index:" + i3 + ", itemIndex:" + indexOfChild + ",indexOfExpandLayout:" + indexOfChild2 + ", curSize:" + this.curExpandChildSize + ", itemSize:" + items.size());
        if (indexOfChild == -1) {
            return;
        }
        if (j().getParent() != null) {
            ViewParent parent2 = j().getParent();
            if (parent2 instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent2;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(j());
            }
        }
        if (this.preClickChildView == itemView) {
            if (j().getParent() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("TroopClassifyContainerView", 4, "[clickToSwitch] same preItem, expandLayout.parent is null:" + z16);
            l(null);
            return;
        }
        if (items.size() > this.curExpandChildSize) {
            b(items.size());
        }
        f(items, firstLevelName);
        childContainerView.addView(j(), i3 + 1);
        l(itemView);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        d d16 = g.d("TroopClassifyContainerView");
        for (h hVar : d16.b()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TroopClassifyGroupView troopClassifyGroupView = new TroopClassifyGroupView(context, null, 0, 6, null);
            troopClassifyGroupView.a(d16, hVar, this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ViewUtils.dip2px(16.0f);
            Unit unit = Unit.INSTANCE;
            addView(troopClassifyGroupView, layoutParams);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopClassifyContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopClassifyContainerView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(context) { // from class: com.tencent.mobileqq.troop.troopcreate.classify.detail.TroopClassifyContainerView$expandLayout$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(this.$context);
                    linearLayout.setOrientation(1);
                    return linearLayout;
                }
            });
            this.expandLayout = lazy;
        }
    }
}
