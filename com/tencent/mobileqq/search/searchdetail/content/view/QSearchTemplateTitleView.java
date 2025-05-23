package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchTitle;
import hp2.ae;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&B\u0019\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J2\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchTemplateTitleView;", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchBaseTemplateView;", "Lsp2/b;", "Lhp2/ae;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", "model", "", "v", "w", "Landroid/view/View;", "getView", "Landroid/view/ViewGroup;", "contentFlame", "i", "Lcom/tencent/mobileqq/search/searchdetail/a;", "data", "", "position", "", "", "payload", "Lcom/tencent/mobileqq/search/searchdetail/d;", "pageIoc", ReportConstant.COSTREPORT_PREFIX, "E", "Lhp2/ae;", "binding", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "subTitleTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchTemplateTitleView extends QSearchBaseTemplateView implements sp2.b {

    /* renamed from: E, reason: from kotlin metadata */
    private ae binding;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView subTitleTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchTemplateTitleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void v(ae aeVar, SearchTitle searchTitle) {
        ImageView imageView = aeVar.f405546b;
        Boolean valueOf = Boolean.valueOf(QSearchDetailUtilKt.i(searchTitle.button.jumpLink));
        imageView.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, imageView)) == null) {
            imageView.setVisibility(8);
        }
        TextView textView = aeVar.f405551g;
        Boolean valueOf2 = Boolean.valueOf(QSearchDetailUtilKt.i(searchTitle.button.jumpLink));
        textView.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, textView)) == null) {
            textView.setVisibility(8);
        }
        aeVar.f405551g.setText(searchTitle.button.title);
    }

    private final void w(ae aeVar, SearchTitle searchTitle) {
        String str;
        boolean z16;
        TextView textView;
        com.tencent.mobileqq.search.searchdetail.d pageIOC = getPageIOC();
        if (pageIOC == null || (str = pageIOC.getKeyword()) == null) {
            str = "";
        }
        boolean z17 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            aeVar.f405552h.setHighlightText(str);
        }
        QSearchShowHighlightTextView qSearchShowHighlightTextView = aeVar.f405552h;
        String text = searchTitle.title.getText();
        Intrinsics.checkNotNullExpressionValue(text, "model.title.getText()");
        qSearchShowHighlightTextView.setText(text);
        String text2 = searchTitle.subTitle.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "model.subTitle.getText()");
        if (text2.length() <= 0) {
            z17 = false;
        }
        if (z17 && (textView = this.subTitleTextView) != null) {
            textView.setText(" - " + searchTitle.subTitle.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QSearchTemplateTitleView this$0, SearchTitle model, com.tencent.mobileqq.search.searchdetail.a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.d(model.button.jumpLink, ((NetSearchTemplateTitleItem) data).q());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView
    @NotNull
    public View i(@NotNull ViewGroup contentFlame) {
        Intrinsics.checkNotNullParameter(contentFlame, "contentFlame");
        ae g16 = ae.g(LayoutInflater.from(getContext()), contentFlame, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.binding = g16;
        TextView textView = new TextView(getContext());
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_primary));
        textView.setTextSize(16.0f);
        textView.setTypeface(Typeface.create(textView.getTypeface(), 0));
        textView.setMaxLines(1);
        ae aeVar = null;
        textView.setEllipsize(null);
        ae aeVar2 = this.binding;
        if (aeVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aeVar2 = null;
        }
        QSearchShowHighlightTextView qSearchShowHighlightTextView = aeVar2.f405552h;
        Intrinsics.checkNotNullExpressionValue(qSearchShowHighlightTextView, "binding.title");
        QSearchShowHighlightTextView.b(qSearchShowHighlightTextView, textView, null, 2, null);
        this.subTitleTextView = textView;
        ae aeVar3 = this.binding;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aeVar = aeVar3;
        }
        ConstraintLayout root = aeVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView
    public void s(@NotNull final com.tencent.mobileqq.search.searchdetail.a data, final int position, @Nullable List<Object> payload, @Nullable com.tencent.mobileqq.search.searchdetail.d pageIoc) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof NetSearchTemplateTitleItem)) {
            return;
        }
        ae aeVar = this.binding;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aeVar = null;
        }
        View bottomDivider = aeVar.f405547c;
        Intrinsics.checkNotNullExpressionValue(bottomDivider, "bottomDivider");
        NetSearchTemplateTitleItem netSearchTemplateTitleItem = (NetSearchTemplateTitleItem) data;
        if (netSearchTemplateTitleItem.getLayoutInfo().showBottomDivider) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        bottomDivider.setVisibility(i3);
        final SearchTitle searchTitle = netSearchTemplateTitleItem.getSearchTitle();
        w(aeVar, searchTitle);
        v(aeVar, searchTitle);
        final SearchReportInfo reportInfo = searchTitle.button.reportInfo;
        if (reportInfo != null) {
            Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
            ConstraintLayout cardHeaderLayout = aeVar.f405548d;
            String str = reportInfo.eid;
            String valueOf = String.valueOf(reportInfo.hashCode());
            Intrinsics.checkNotNullExpressionValue(cardHeaderLayout, "cardHeaderLayout");
            i.i(cardHeaderLayout, str, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchTemplateTitleView$initLayoutContentModel$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final JSONObject invoke() {
                    return i.f(SearchReportInfo.this, this.q(position, (com.tencent.mobileqq.search.searchdetail.content.template.model.a) data), null, 2, null);
                }
            }, valueOf);
        }
        aeVar.f405548d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QSearchTemplateTitleView.x(QSearchTemplateTitleView.this, searchTitle, data, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView, sp2.a
    @NotNull
    public View getView() {
        return this;
    }
}
