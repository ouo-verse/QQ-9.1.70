package com.tencent.mobileqq.search.searchdetail.content.template;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateDoubleColumnListItem;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00103\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0012\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/TemplateDoubleColumnListSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/l;", "", "position", "", "Z", "Landroid/view/View;", "containerView", "y", "data", "", "", "payload", "Y", "", "getViewStubLayoutId", "D", "Landroid/view/View;", "getDividerTop", "()Landroid/view/View;", "setDividerTop", "(Landroid/view/View;)V", "dividerTop", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "tvTitle", "Landroidx/constraintlayout/helper/widget/Layer;", UserInfo.SEX_FEMALE, "Landroidx/constraintlayout/helper/widget/Layer;", "getLayoutMore", "()Landroidx/constraintlayout/helper/widget/Layer;", "setLayoutMore", "(Landroidx/constraintlayout/helper/widget/Layer;)V", "layoutMore", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "getLayoutContent", "()Landroid/widget/LinearLayout;", "setLayoutContent", "(Landroid/widget/LinearLayout;)V", "layoutContent", "H", "getDividerList", "setDividerList", "dividerList", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TemplateDoubleColumnListSection extends BaseSearchTemplateSection<NetSearchTemplateDoubleColumnListItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View dividerTop;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView tvTitle;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Layer layoutMore;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private LinearLayout layoutContent;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View dividerList;

    /* JADX WARN: Multi-variable type inference failed */
    private final void Z(final int position) {
        TextView textView;
        Iterator it;
        int i3;
        final TemplateDoubleColumnListSection templateDoubleColumnListSection = this;
        LinearLayout linearLayout = templateDoubleColumnListSection.layoutContent;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() != 0) {
                linearLayout.removeAllViews();
            }
            Iterator it5 = ((NetSearchTemplateDoubleColumnListItem) templateDoubleColumnListSection.mData).z().iterator();
            int i16 = 0;
            int i17 = 0;
            while (it5.hasNext()) {
                Object next = it5.next();
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ArrayList arrayList = (ArrayList) next;
                LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setOrientation(i16);
                int i19 = -1;
                int i26 = -2;
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                ViewExtKt.f(linearLayout2, ViewUtils.dip2px(8.0f));
                int i27 = i16;
                for (Object obj : arrayList) {
                    int i28 = i27 + 1;
                    if (i27 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    final SearchListDetail searchListDetail = (SearchListDetail) obj;
                    TextView textView2 = new TextView(linearLayout.getContext());
                    textView2.setPadding(ViewUtils.dip2px(10.0f), ViewUtils.dip2px(6.0f), ViewUtils.dip2px(10.0f), ViewUtils.dip2px(6.0f));
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i19, i26);
                    layoutParams2.weight = 1.0f;
                    if (i27 > 0) {
                        layoutParams2.leftMargin = ViewUtils.dip2px(8.0f);
                    }
                    textView2.setText(searchListDetail.title.text);
                    textView2.setMaxLines(1);
                    textView2.setEllipsize(TextUtils.TruncateAt.END);
                    textView2.setTextSize(1, 14.0f);
                    textView2.setTextColor(linearLayout.getResources().getColor(R.color.qui_common_text_link));
                    int i29 = i27;
                    textView2.setBackground(rn2.j.f431768a.g(ViewUtils.dip2px(4.0f), ViewUtils.dip2px(4.0f), ViewUtils.dip2px(4.0f), ViewUtils.dip2px(4.0f), linearLayout.getResources().getColor(R.color.qui_common_fill_standard_primary)));
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TemplateDoubleColumnListSection.a0(SearchListDetail.this, templateDoubleColumnListSection, view);
                        }
                    });
                    final SearchReportInfo reportInfo = searchListDetail.reportInfo;
                    if (reportInfo != null) {
                        Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                        textView = textView2;
                        it = it5;
                        i3 = i29;
                        V(textView2, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateDoubleColumnListSection$initContentView$1$1$1$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final JSONObject invoke() {
                                TemplateDoubleColumnListSection templateDoubleColumnListSection2 = TemplateDoubleColumnListSection.this;
                                return BaseSearchTemplateSection.S(templateDoubleColumnListSection2, reportInfo, templateDoubleColumnListSection2.T(position), null, 2, null);
                            }
                        }, String.valueOf(reportInfo.hashCode()));
                    } else {
                        textView = textView2;
                        it = it5;
                        i3 = i29;
                    }
                    linearLayout2.addView(textView, layoutParams2);
                    if (i3 == arrayList.size() - 1 && arrayList.size() < 2) {
                        for (int i36 = i28; i36 < 2; i36++) {
                            View view = new View(linearLayout.getContext());
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams3.leftMargin = ViewUtils.dip2px(8.0f);
                            layoutParams3.weight = 1.0f;
                            linearLayout2.addView(view, layoutParams3);
                        }
                    }
                    templateDoubleColumnListSection = this;
                    i26 = -2;
                    i19 = -1;
                    i27 = i28;
                    it5 = it;
                }
                linearLayout.addView(linearLayout2, layoutParams);
                i16 = 0;
                templateDoubleColumnListSection = this;
                i17 = i18;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(SearchListDetail searchListDetail, TemplateDoubleColumnListSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(searchListDetail, "$searchListDetail");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QSearchDetailUtilKt.i(searchListDetail.jumpLink)) {
            g.a.a(this$0, searchListDetail.jumpLink, null, 2, null);
        } else {
            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = this$0.getDtReportIoc();
            if (dtReportIoc != null) {
                String str = searchListDetail.title.text;
                Intrinsics.checkNotNullExpressionValue(str, "searchListDetail.title.text");
                dtReportIoc.b(str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        if (r5 != false) goto L37;
     */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(@NotNull NetSearchTemplateDoubleColumnListItem data, int position, @Nullable List<Object> payload) {
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.dividerTop;
        int i17 = 8;
        if (view != null) {
            if (data.getLayoutInfo().showDivider) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            view.setVisibility(i16);
        }
        TextView textView = this.tvTitle;
        boolean z18 = true;
        if (textView != null) {
            if (data.getTitle().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
        TextView textView2 = this.tvTitle;
        if (textView2 != null) {
            textView2.setText(data.getTitle());
        }
        View view2 = this.dividerList;
        if (view2 != null) {
            if (data.getTotalItemSize() > 0) {
                if (data.getTitle().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            z18 = false;
            if (z18) {
                i17 = 0;
            }
            view2.setVisibility(i17);
        }
        Z(position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        View view;
        TextView textView;
        Layer layer;
        LinearLayout linearLayout;
        Layer layer2;
        int[] referencedIds;
        boolean z16;
        View view2 = null;
        if (containerView != null) {
            view = containerView.findViewById(R.id.bnb);
        } else {
            view = null;
        }
        this.dividerTop = view;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.kbs);
        } else {
            textView = null;
        }
        this.tvTitle = textView;
        if (containerView != null) {
            layer = (Layer) containerView.findViewById(R.id.e4a);
        } else {
            layer = null;
        }
        this.layoutMore = layer;
        if (containerView != null) {
            linearLayout = (LinearLayout) containerView.findViewById(R.id.e38);
        } else {
            linearLayout = null;
        }
        this.layoutContent = linearLayout;
        if (containerView != null) {
            view2 = containerView.findViewById(R.id.ujz);
        }
        this.dividerList = view2;
        Layer layer3 = this.layoutMore;
        boolean z17 = false;
        if (layer3 != null && (referencedIds = layer3.getReferencedIds()) != null) {
            if (referencedIds.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17 && (layer2 = this.layoutMore) != null) {
            layer2.setReferencedIds(new int[]{R.id.k9m, R.id.y8a});
        }
    }
}
