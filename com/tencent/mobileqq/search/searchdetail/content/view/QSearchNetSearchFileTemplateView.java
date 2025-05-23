package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.template.u;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFile;
import hp2.ab;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0015H\u0016R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchNetSearchFileTemplateView;", "Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchBaseTemplateView;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupFile;", "file", "", "v", "Landroid/view/ViewGroup;", "contentFlame", "Landroid/view/View;", "i", "Lcom/tencent/mobileqq/search/searchdetail/a;", "data", "", "position", "", "", "payload", "Lcom/tencent/mobileqq/search/searchdetail/d;", "pageIoc", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "Landroid/view/View;", "divider", "Lhp2/ab;", UserInfo.SEX_FEMALE, "Lhp2/ab;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchNetSearchFileTemplateView extends QSearchBaseTemplateView {

    /* renamed from: E, reason: from kotlin metadata */
    private View divider;

    /* renamed from: F, reason: from kotlin metadata */
    private ab binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchNetSearchFileTemplateView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    private final CharSequence v(SearchGroupFile file) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(file.groupName);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#2D77E5")), 0, file.groupName.length(), 17);
        spannableStringBuilder.append((CharSequence) file.fileSize).append((CharSequence) " \u6765\u81ea").append((CharSequence) spannableString);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QSearchNetSearchFileTemplateView this$0, com.tencent.mobileqq.search.searchdetail.content.template.model.d model, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        this$0.d(model.getJumpLink(), model.q());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView
    @NotNull
    public View i(@NotNull ViewGroup contentFlame) {
        Intrinsics.checkNotNullParameter(contentFlame, "contentFlame");
        ab g16 = ab.g(LayoutInflater.from(getContext()), contentFlame, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.binding = g16;
        ab abVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        View view = g16.f405530b;
        Intrinsics.checkNotNullExpressionValue(view, "binding.divider");
        this.divider = view;
        ab abVar2 = this.binding;
        if (abVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar2 = null;
        }
        ImageView imageView = abVar2.f405531c;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivLeftIcon");
        u.e(imageView, ViewUtils.dpToPx(8.0f));
        ab abVar3 = this.binding;
        if (abVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            abVar = abVar3;
        }
        ConstraintLayout root = abVar.getRoot();
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullExpressionValue(root, "binding.root.apply {\n   \u2026s.WRAP_CONTENT)\n        }");
        return root;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView
    public int m(@NotNull com.tencent.mobileqq.search.searchdetail.content.template.model.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return 0;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView
    public void s(@NotNull com.tencent.mobileqq.search.searchdetail.a data, int position, @Nullable List<Object> payload, @Nullable com.tencent.mobileqq.search.searchdetail.d pageIoc) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        final com.tencent.mobileqq.search.searchdetail.content.template.model.d dVar = (com.tencent.mobileqq.search.searchdetail.content.template.model.d) data;
        View view = this.divider;
        ab abVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("divider");
            view = null;
        }
        if (dVar.getLayoutInfo().showDivider) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QSearchNetSearchFileTemplateView.w(QSearchNetSearchFileTemplateView.this, dVar, view2);
            }
        });
        ab abVar2 = this.binding;
        if (abVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar2 = null;
        }
        abVar2.f405534f.setText(dVar.getGroupFile().fileName);
        ab abVar3 = this.binding;
        if (abVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar3 = null;
        }
        abVar3.f405532d.setText(v(dVar.getGroupFile()));
        if (dVar.getGroupFile().isInGroup == 0) {
            ab abVar4 = this.binding;
            if (abVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                abVar4 = null;
            }
            abVar4.f405533e.setVisibility(0);
            ab abVar5 = this.binding;
            if (abVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                abVar5 = null;
            }
            QUITagView qUITagView = abVar5.f405533e;
            QUITagType qUITagType = QUITagType.COLOR_BLUE;
            QUITagSize qUITagSize = QUITagSize.SMALL;
            String str = dVar.getGroupFile().tag;
            Intrinsics.checkNotNullExpressionValue(str, "model.groupFile.tag");
            qUITagView.setConfig(new QUITagViewConfig(qUITagType, qUITagSize, null, str));
            return;
        }
        ab abVar6 = this.binding;
        if (abVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            abVar = abVar6;
        }
        abVar.f405533e.setVisibility(4);
    }
}
