package com.tencent.mobileqq.search.searchdetail.content.template;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateHorizontalListItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchListItemModel;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107JC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\u001cR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/HorizontalListSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/m;", "model", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/v;", "Lkotlin/ParameterName;", "name", "data", "Landroid/view/View;", "itemBuilder", "", "maxNumberOfViews", "itemPosition", "", "g0", "b0", "c0", "", "getViewStubLayoutId", "containerView", "y", "position", "", "", "payload", "d0", "D", "Landroid/view/View;", "divider", "E", "headerView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "titleView", "H", "arrowView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "I", "Landroidx/constraintlayout/widget/ConstraintLayout;", "itemsLayout", "Landroid/graphics/Typeface;", "J", "Landroid/graphics/Typeface;", "subheadingTypeface", "Landroid/content/Context;", "K", "Landroid/content/Context;", "context", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class HorizontalListSection extends BaseSearchTemplateSection<NetSearchTemplateHorizontalListItem> {

    /* renamed from: D, reason: from kotlin metadata */
    private View divider;

    /* renamed from: E, reason: from kotlin metadata */
    private View headerView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView iconView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: H, reason: from kotlin metadata */
    private View arrowView;

    /* renamed from: I, reason: from kotlin metadata */
    private ConstraintLayout itemsLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private Typeface subheadingTypeface;

    /* renamed from: K, reason: from kotlin metadata */
    private Context context;

    /* JADX INFO: Access modifiers changed from: private */
    public final View b0(QSearchListItemModel data) {
        boolean z16;
        boolean z17;
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context3 = null;
        }
        ImageView imageView = new ImageView(context3);
        imageView.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        u.e(imageView, bj.a(20));
        u.c(imageView, data.b(), null, 2, null);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(bj.a(40), bj.a(40));
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        layoutParams.setMargins(0, bj.a(8), 0, 0);
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(imageView, layoutParams);
        Context context4 = this.context;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context4 = null;
        }
        TextView textView = new TextView(context4);
        textView.setId(View.generateViewId());
        if (data.e().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            textView.setText(data.e());
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_primary));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextAlignment(4);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, 0);
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
            layoutParams2.startToStart = 0;
            layoutParams2.endToEnd = 0;
            layoutParams2.topToBottom = imageView.getId();
            layoutParams2.setMargins(0, bj.a(8), 0, 0);
            constraintLayout.addView(textView, layoutParams2);
        }
        Context context5 = this.context;
        if (context5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context5;
        }
        TextView textView2 = new TextView(context2);
        if (data.a().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            textView2.setText(data.a());
            textView2.setTextSize(2, 12.0f);
            textView2.setTextColor(textView2.getContext().getColor(R.color.qui_common_text_secondary));
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextAlignment(4);
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(0, 0);
            ((ViewGroup.MarginLayoutParams) layoutParams3).height = -2;
            layoutParams3.startToStart = 0;
            layoutParams3.endToEnd = 0;
            layoutParams3.topToBottom = textView.getId();
            layoutParams3.bottomToBottom = 0;
            layoutParams3.setMargins(0, 0, 0, bj.a(8));
            constraintLayout.addView(textView2, layoutParams3);
        }
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View c0(QSearchListItemModel data) {
        boolean z16;
        boolean z17;
        Context context = this.context;
        Typeface typeface = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        ImageView imageView = new ImageView(context2);
        imageView.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        u.e(imageView, bj.a(4));
        u.c(imageView, data.b(), null, 2, null);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        layoutParams.dimensionRatio = "1:1";
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(imageView, layoutParams);
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context3 = null;
        }
        TextView textView = new TextView(context3);
        textView.setId(View.generateViewId());
        if (data.e().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            textView.setText(data.e());
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_primary));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, 0);
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
            layoutParams2.startToStart = imageView.getId();
            layoutParams2.endToEnd = imageView.getId();
            layoutParams2.topToBottom = imageView.getId();
            layoutParams2.setMargins(0, bj.a(4), 0, 0);
            constraintLayout.addView(textView, layoutParams2);
        }
        Context context4 = this.context;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context4 = null;
        }
        TextView textView2 = new TextView(context4);
        if (data.a().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            textView2.setText(data.a());
            textView2.setTextSize(2, 16.0f);
            textView2.setTextColor(textView2.getContext().getColor(R.color.qui_common_text_primary));
            Typeface typeface2 = this.subheadingTypeface;
            if (typeface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subheadingTypeface");
            } else {
                typeface = typeface2;
            }
            textView2.setTypeface(typeface);
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setPadding(0, bj.a(4), 0, 4);
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(0, 0);
            ((ViewGroup.MarginLayoutParams) layoutParams3).height = -2;
            layoutParams3.startToStart = textView.getId();
            layoutParams3.endToEnd = textView.getId();
            layoutParams3.topToBottom = textView.getId();
            layoutParams3.setMargins(0, bj.a(2), 0, 0);
            constraintLayout.addView(textView2, layoutParams3);
        }
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(HorizontalListSection this$0, NetSearchTemplateHorizontalListItem data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.d(data.getHorizontalList().button.jumpLink, data.q());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g0(NetSearchTemplateHorizontalListItem model, Function1<? super QSearchListItemModel, ? extends View> itemBuilder, int maxNumberOfViews, final int itemPosition) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2 = this.itemsLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.removeAllViews();
        int size = model.z().size();
        for (int i3 = 0; i3 < size; i3++) {
            final QSearchListItemModel qSearchListItemModel = model.z().get(i3);
            View invoke = itemBuilder.invoke(qSearchListItemModel);
            invoke.setId(View.generateViewId());
            final SearchReportInfo reportInfo = qSearchListItemModel.getReportInfo();
            if (reportInfo != null) {
                V(invoke, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.HorizontalListSection$setupItems$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        HorizontalListSection horizontalListSection = HorizontalListSection.this;
                        return BaseSearchTemplateSection.S(horizontalListSection, reportInfo, horizontalListSection.T(itemPosition), null, 2, null);
                    }
                }, String.valueOf(reportInfo.hashCode()));
            }
            invoke.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HorizontalListSection.i0(HorizontalListSection.this, qSearchListItemModel, view);
                }
            });
            ConstraintLayout constraintLayout3 = this.itemsLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsLayout");
                constraintLayout3 = null;
            }
            constraintLayout3.addView(invoke, new ConstraintLayout.LayoutParams(0, -2));
        }
        ConstraintLayout constraintLayout4 = this.itemsLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsLayout");
            constraintLayout = null;
        } else {
            constraintLayout = constraintLayout4;
        }
        com.tencent.mobileqq.search.util.l.f(constraintLayout, maxNumberOfViews, bj.a(8), 0, 0, false, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(HorizontalListSection this$0, QSearchListItemModel item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        g.a.a(this$0, item.getJumpLink(), null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull final NetSearchTemplateHorizontalListItem data, int position, @Nullable List<Object> payload) {
        int i3;
        boolean z16;
        int i16;
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.divider;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("divider");
            view = null;
        }
        if (data.getLayoutInfo().showDivider) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view3 = this.headerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view3 = null;
        }
        String str = data.getHorizontalList().title.text;
        Intrinsics.checkNotNullExpressionValue(str, "data.horizontalList.title.text");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        view3.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, view3)) == null) {
            view3.setVisibility(8);
        }
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView = null;
        }
        imageView.setVisibility(8);
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        textView.setText(data.getHorizontalList().title.text);
        boolean i17 = QSearchDetailUtilKt.i(data.getHorizontalList().button.jumpLink);
        View view4 = this.arrowView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arrowView");
            view4 = null;
        }
        if (i17) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        view4.setVisibility(i16);
        if (i17) {
            View view5 = this.arrowView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowView");
                view5 = null;
            }
            view5.setVisibility(0);
            View view6 = this.headerView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerView");
            } else {
                view2 = view6;
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    HorizontalListSection.e0(HorizontalListSection.this, data, view7);
                }
            });
        } else {
            View view7 = this.arrowView;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowView");
            } else {
                view2 = view7;
            }
            view2.setVisibility(8);
        }
        if (data.getType() == 2) {
            g0(data, new HorizontalListSection$doOnBindData$2(this), 4, position);
        } else {
            g0(data, new HorizontalListSection$doOnBindData$3(this), 3, position);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        Typeface create;
        Typeface.Builder weight;
        if (containerView != null) {
            Context context = containerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            this.context = context;
            String str = "fonts" + File.separator + "Qvideo Digit.ttf";
            Context context2 = null;
            if (Build.VERSION.SDK_INT >= 26) {
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context2 = context3;
                }
                weight = new Typeface.Builder(context2.getAssets(), str).setWeight(700);
                create = weight.build();
                Intrinsics.checkNotNullExpressionValue(create, "{\n                Typefa\u202600).build()\n            }");
            } else {
                Context context4 = this.context;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context2 = context4;
                }
                create = Typeface.create(Typeface.createFromAsset(context2.getAssets(), str), 1);
                Intrinsics.checkNotNullExpressionValue(create, "{\n                Typefa\u2026eface.BOLD)\n            }");
            }
            this.subheadingTypeface = create;
            View findViewById = containerView.findViewById(R.id.bmt);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.divider)");
            this.divider = findViewById;
            View findViewById2 = containerView.findViewById(R.id.tnt);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.card_header_layout)");
            this.headerView = findViewById2;
            View findViewById3 = containerView.findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.icon)");
            this.iconView = (ImageView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.title)");
            this.titleView = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.f164472yw);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.arrow)");
            this.arrowView = findViewById5;
            View findViewById6 = containerView.findViewById(R.id.xyc);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.items_layout)");
            this.itemsLayout = (ConstraintLayout) findViewById6;
        }
    }
}
