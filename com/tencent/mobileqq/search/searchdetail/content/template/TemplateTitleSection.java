package com.tencent.mobileqq.search.searchdetail.content.template;

import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchShowHighlightTextView;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchTitle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/TemplateTitleSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/q;", "Lhp2/ae;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTitle;", "model", "", "Y", "Z", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "y", "data", "", "position", "", "", "payload", "a0", "D", "Lhp2/ae;", "binding", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "subTitleTextView", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TemplateTitleSection extends BaseSearchTemplateSection<NetSearchTemplateTitleItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private hp2.ae binding;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView subTitleTextView;

    private final void Y(hp2.ae aeVar, SearchTitle searchTitle) {
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

    private final void Z(hp2.ae aeVar, SearchTitle searchTitle) {
        String str;
        boolean z16;
        TextView textView;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc == null || (str = dtReportIoc.getKeyword()) == null) {
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
    public static final void b0(TemplateTitleSection this$0, SearchTitle model, NetSearchTemplateTitleItem data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.d(model.button.jumpLink, data.q());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull final NetSearchTemplateTitleItem data, final int position, @Nullable List<Object> payload) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.TemplateTitleSection", "doOnBindData position=" + position + " data=" + data.hashCode());
        }
        hp2.ae aeVar = this.binding;
        if (aeVar != null) {
            View bottomDivider = aeVar.f405547c;
            Intrinsics.checkNotNullExpressionValue(bottomDivider, "bottomDivider");
            if (data.getLayoutInfo().showBottomDivider) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            bottomDivider.setVisibility(i3);
            final SearchTitle searchTitle = data.getSearchTitle();
            Z(aeVar, searchTitle);
            Y(aeVar, searchTitle);
            final SearchReportInfo reportInfo = searchTitle.button.reportInfo;
            if (reportInfo != null) {
                Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                ConstraintLayout cardHeaderLayout = aeVar.f405548d;
                String str = reportInfo.eid;
                String valueOf = String.valueOf(reportInfo.hashCode());
                Intrinsics.checkNotNullExpressionValue(cardHeaderLayout, "cardHeaderLayout");
                V(cardHeaderLayout, str, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateTitleSection$doOnBindData$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        TemplateTitleSection templateTitleSection = TemplateTitleSection.this;
                        return BaseSearchTemplateSection.S(templateTitleSection, reportInfo, templateTitleSection.T(position), null, 2, null);
                    }
                }, valueOf);
            }
            aeVar.f405548d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplateTitleSection.b0(TemplateTitleSection.this, searchTitle, data, view);
                }
            });
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
        QSearchShowHighlightTextView title;
        if (containerView != null) {
            this.binding = hp2.ae.e(containerView);
            TextView textView = new TextView(containerView.getContext());
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_primary));
            textView.setTextSize(16.0f);
            textView.setTypeface(Typeface.create(textView.getTypeface(), 0));
            textView.setMaxLines(1);
            textView.setEllipsize(null);
            hp2.ae aeVar = this.binding;
            if (aeVar != null && (title = aeVar.f405552h) != null) {
                Intrinsics.checkNotNullExpressionValue(title, "title");
                QSearchShowHighlightTextView.b(title, textView, null, 2, null);
            }
            this.subTitleTextView = textView;
        }
    }
}
