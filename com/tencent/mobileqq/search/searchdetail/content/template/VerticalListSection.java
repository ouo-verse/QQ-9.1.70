package com.tencent.mobileqq.search.searchdetail.content.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateVerticalListItem;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u0014R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010#\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/VerticalListSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/s;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", "data", "", "index", "Landroid/view/View;", "c0", "", "getViewStubLayoutId", "containerView", "", "y", "position", "", "", "payload", "g0", "D", "Landroid/view/View;", "divider", "E", "headerView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "titleView", "H", "arrowView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "I", "Landroidx/constraintlayout/widget/ConstraintLayout;", "itemsLayout", "Landroid/content/Context;", "J", "Landroid/content/Context;", "context", "K", "itemPosition", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class VerticalListSection extends BaseSearchTemplateSection<NetSearchTemplateVerticalListItem> {

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
    private Context context;

    /* renamed from: K, reason: from kotlin metadata */
    private int itemPosition;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v23, types: [android.widget.TextView, T, android.view.View] */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.widget.TextView, T, android.view.View] */
    private final View c0(final SearchListDetail data, final int index) {
        String str;
        boolean z16;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
            str = "";
        }
        String str2 = str;
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setId(View.generateViewId());
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerticalListSection.e0(VerticalListSection.this, data, view);
            }
        });
        final SearchReportInfo reportInfo = data.reportInfo;
        if (reportInfo != null) {
            Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
            V(constraintLayout, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.VerticalListSection$buildItem$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final JSONObject invoke() {
                    int i3;
                    JSONObject Q;
                    VerticalListSection verticalListSection = VerticalListSection.this;
                    SearchReportInfo searchReportInfo = reportInfo;
                    i3 = verticalListSection.itemPosition;
                    JSONObject T = verticalListSection.T(i3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("doc_position", index);
                    Unit unit = Unit.INSTANCE;
                    Q = verticalListSection.Q(searchReportInfo, T, jSONObject);
                    return Q;
                }
            }, String.valueOf(reportInfo.hashCode()));
        }
        ImageView imageView = new ImageView(constraintLayout.getContext());
        imageView.setId(View.generateViewId());
        u.e(imageView, bj.a(4));
        String str3 = data.icon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str3, "data.icon.iconLink");
        u.c(imageView, str3, null, 2, null);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(bj.a(40), bj.a(40));
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(constraintLayout.getContext());
        textView.setId(View.generateViewId());
        rn2.j jVar = rn2.j.f431768a;
        String str4 = data.title.text;
        Intrinsics.checkNotNullExpressionValue(str4, "data.title.text");
        textView.setText(rn2.j.k(jVar, str2, str4, false, 4, null));
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_primary));
        boolean z17 = true;
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str5 = data.subTitle.text;
        Intrinsics.checkNotNullExpressionValue(str5, "data.subTitle.text");
        if (str5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ?? textView2 = new TextView(constraintLayout.getContext());
            textView2.setId(View.generateViewId());
            textView2.setText(data.subTitle.text);
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(textView2.getContext().getColor(R.color.qui_common_text_secondary));
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            objectRef.element = textView2;
        }
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        String str6 = data.button.title;
        Intrinsics.checkNotNullExpressionValue(str6, "data.button.title");
        if (str6.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            ?? textView3 = new TextView(constraintLayout.getContext());
            textView3.setId(View.generateViewId());
            textView3.setText(data.button.title);
            textView3.setBackground(ContextCompat.getDrawable(textView3.getContext(), R.drawable.qui_button_bg_secondary_default_bg_corner_4_border_1));
            textView3.setTextColor(textView3.getContext().getColor(R.color.qui_button_text_secondary_default));
            textView3.setPadding(bj.a(16), bj.a(4), bj.a(16), bj.a(4));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerticalListSection.d0(VerticalListSection.this, data, view);
                }
            });
            objectRef2.element = textView3;
        }
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, -2);
        layoutParams2.topToTop = 0;
        layoutParams2.startToEnd = imageView.getId();
        T t16 = objectRef.element;
        if (t16 != 0) {
            layoutParams2.bottomToTop = ((TextView) t16).getId();
        } else {
            layoutParams2.bottomToBottom = 0;
        }
        T t17 = objectRef2.element;
        if (t17 != 0) {
            layoutParams2.endToStart = ((View) t17).getId();
        } else {
            layoutParams2.endToEnd = 0;
        }
        layoutParams2.setMargins(bj.a(12), 0, 0, 0);
        constraintLayout.addView(textView, layoutParams2);
        TextView textView4 = (TextView) objectRef.element;
        if (textView4 != null) {
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(0, -2);
            layoutParams3.startToStart = textView.getId();
            layoutParams3.endToEnd = textView.getId();
            layoutParams3.topToBottom = textView.getId();
            layoutParams3.bottomToBottom = 0;
            layoutParams3.setMargins(0, bj.a(4), 0, 0);
            constraintLayout.addView(textView4, layoutParams3);
        }
        View view = (View) objectRef2.element;
        if (view != null) {
            ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams4.startToEnd = textView.getId();
            layoutParams4.endToEnd = 0;
            layoutParams4.topToTop = 0;
            layoutParams4.bottomToBottom = 0;
            layoutParams4.setMargins(bj.a(12), 0, 0, 0);
            constraintLayout.addView(view, layoutParams4);
        }
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(VerticalListSection this$0, SearchListDetail data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        g.a.a(this$0, data.button.jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(VerticalListSection this$0, SearchListDetail data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        g.a.a(this$0, data.jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(VerticalListSection this$0, NetSearchTemplateVerticalListItem data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.d(data.getVerticalList().button.jumpLink, data.q());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull final NetSearchTemplateVerticalListItem data, int position, @Nullable List<Object> payload) {
        int i3;
        boolean z16;
        int collectionSizeOrDefault;
        ConstraintLayout constraintLayout;
        View view;
        Intrinsics.checkNotNullParameter(data, "data");
        this.itemPosition = position;
        View view2 = this.divider;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("divider");
            view2 = null;
        }
        int i16 = 8;
        if (data.getLayoutInfo().showDivider) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view2.setVisibility(i3);
        String str = data.getVerticalList().title.text;
        Intrinsics.checkNotNullExpressionValue(str, "data.verticalList.title.text");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view3 = this.headerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view3 = null;
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
        textView.setText(data.getVerticalList().title.text);
        boolean i17 = QSearchDetailUtilKt.i(data.getVerticalList().button.jumpLink);
        View view4 = this.arrowView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arrowView");
            view4 = null;
        }
        if (i17) {
            i16 = 0;
        }
        view4.setVisibility(i16);
        if (i17) {
            View view5 = this.headerView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerView");
                view5 = null;
            }
            view5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    VerticalListSection.i0(VerticalListSection.this, data, view6);
                }
            });
            final SearchReportInfo searchReportInfo = data.getVerticalList().button.reportInfo;
            if (searchReportInfo != null) {
                View view6 = this.arrowView;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("arrowView");
                    view = null;
                } else {
                    view = view6;
                }
                V(view, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.VerticalListSection$doOnBindData$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        int i18;
                        VerticalListSection verticalListSection = VerticalListSection.this;
                        SearchReportInfo searchReportInfo2 = searchReportInfo;
                        i18 = verticalListSection.itemPosition;
                        return BaseSearchTemplateSection.S(verticalListSection, searchReportInfo2, verticalListSection.T(i18), null, 2, null);
                    }
                }, String.valueOf(searchReportInfo.hashCode()));
            }
        }
        ConstraintLayout constraintLayout2 = this.itemsLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.removeAllViews();
        List<SearchListDetail> y16 = data.y();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(y16, 10);
        ArrayList<View> arrayList = new ArrayList(collectionSizeOrDefault);
        int i18 = 0;
        for (Object obj : y16) {
            int i19 = i18 + 1;
            if (i18 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(c0((SearchListDetail) obj, i18));
            i18 = i19;
        }
        for (View view7 : arrayList) {
            ConstraintLayout constraintLayout3 = this.itemsLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsLayout");
                constraintLayout3 = null;
            }
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
            if (!z16) {
                layoutParams.setMargins(0, bj.a(12), 0, 0);
            }
            Unit unit = Unit.INSTANCE;
            constraintLayout3.addView(view7, layoutParams);
        }
        ConstraintLayout constraintLayout4 = this.itemsLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsLayout");
            constraintLayout = null;
        } else {
            constraintLayout = constraintLayout4;
        }
        com.tencent.mobileqq.search.util.l.f(constraintLayout, 1, bj.a(16), 0, 0, false, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView != null) {
            Context context = containerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            this.context = context;
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
