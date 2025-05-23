package com.tencent.mobileqq.search.searchdetail.banner;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import hp2.u;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/h;", "", "", "tabName", "", "tabMask", "", "source", "Lcom/tencent/mobileqq/search/searchdetail/content/model/b;", "data", "", "d", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lcom/tencent/mobileqq/search/searchdetail/content/model/b;)V", NodeProps.MAX_WIDTH, "e", "g", "f", "Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "dtreport", tl.h.F, "Lhp2/u;", "a", "Lhp2/u;", "getBinding", "()Lhp2/u;", "binding", "<init>", "(Lhp2/u;)V", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u binding;

    public h(@NotNull u binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    private final void d(String tabName, Long tabMask, Integer source, com.tencent.mobileqq.search.searchdetail.content.model.b data) {
        Map mapOf;
        VideoReport.setElementId(this.binding.getRoot(), "em_bas_error_correction_prompt");
        ConstraintLayout root = this.binding.getRoot();
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(root, exposurePolicy);
        ConstraintLayout root2 = this.binding.getRoot();
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(root2, endExposurePolicy);
        ConstraintLayout root3 = this.binding.getRoot();
        Pair[] pairArr = new Pair[6];
        if (tabName == null) {
            tabName = "";
        }
        pairArr[0] = TuplesKt.to("tab_name", tabName);
        Object obj = tabMask;
        if (tabMask == null) {
            obj = "";
        }
        pairArr[1] = TuplesKt.to("tab_mask", obj);
        pairArr[2] = TuplesKt.to("search_query_text", data.getKeyword());
        pairArr[3] = TuplesKt.to("error_correction_query", data.getCorrectionQuery());
        pairArr[4] = TuplesKt.to("search_trace_id", data.getCommonInfo().getTraceId());
        Object obj2 = source;
        if (source == null) {
            obj2 = "";
        }
        pairArr[5] = TuplesKt.to("query_source", obj2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.setElementParams(root3, mapOf);
        VideoReport.setElementId(this.binding.f405753d, "em_bas_unmodify");
        VideoReport.setElementExposePolicy(this.binding.f405753d, exposurePolicy);
        VideoReport.setElementEndExposePolicy(this.binding.f405753d, endExposurePolicy);
        TextView textView = this.binding.f405753d;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(textView, clickPolicy);
        VideoReport.setElementId(this.binding.f405754e, "em_bas_error_correcting_words");
        VideoReport.setElementExposePolicy(this.binding.f405754e, exposurePolicy);
        VideoReport.setElementEndExposePolicy(this.binding.f405754e, endExposurePolicy);
        VideoReport.setElementClickPolicy(this.binding.f405754e, clickPolicy);
    }

    private final void e(int maxWidth) {
        TextView textView = this.binding.f405752c;
        textView.measure(0, 0);
        int measuredWidth = textView.getMeasuredWidth();
        this.binding.f405754e.measure(0, 0);
        float measureText = this.binding.f405754e.getPaint().measureText(this.binding.f405754e.getText().toString());
        TextView textView2 = this.binding.f405754e;
        float paddingEnd = measureText + textView2.getPaddingEnd() + textView2.getPaddingStart();
        this.binding.f405753d.measure(0, 0);
        float measuredWidth2 = measuredWidth + paddingEnd + r3.getMeasuredWidth();
        ConstraintLayout root = this.binding.getRoot();
        if (measuredWidth2 >= maxWidth - (root.getPaddingEnd() + root.getPaddingStart())) {
            g();
        } else {
            f();
        }
    }

    private final void f() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.binding.getRoot());
        constraintSet.clear(this.binding.f405754e.getId(), 6);
        constraintSet.clear(this.binding.f405754e.getId(), 3);
        constraintSet.connect(this.binding.f405754e.getId(), 3, this.binding.getRoot().getId(), 3, 0);
        constraintSet.connect(this.binding.f405754e.getId(), 6, this.binding.f405752c.getId(), 7, 0);
        constraintSet.clear(this.binding.f405752c.getId(), 4);
        constraintSet.connect(this.binding.f405752c.getId(), 4, this.binding.getRoot().getId(), 4, 0);
        constraintSet.applyTo(this.binding.getRoot());
    }

    private final void g() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.binding.getRoot());
        constraintSet.clear(this.binding.f405754e.getId(), 6);
        constraintSet.connect(this.binding.f405754e.getId(), 3, this.binding.f405752c.getId(), 4, 0);
        constraintSet.connect(this.binding.f405754e.getId(), 6, this.binding.getRoot().getId(), 6, 0);
        constraintSet.clear(this.binding.f405752c.getId(), 4);
        constraintSet.connect(this.binding.f405752c.getId(), 4, this.binding.f405754e.getId(), 3, 0);
        constraintSet.applyTo(this.binding.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(com.tencent.mobileqq.search.searchdetail.content.base.c cVar, com.tencent.mobileqq.search.searchdetail.content.model.b data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        if (cVar != null) {
            cVar.d(data.getCorrectionQuery());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(com.tencent.mobileqq.search.searchdetail.content.base.c cVar, com.tencent.mobileqq.search.searchdetail.content.model.b data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        if (cVar != null) {
            cVar.g(data.getKeyword());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e(this$0.binding.getRoot().getWidth());
    }

    public final void h(@NotNull final com.tencent.mobileqq.search.searchdetail.content.model.b data, @Nullable final com.tencent.mobileqq.search.searchdetail.content.base.c dtreport) {
        Integer num;
        String str;
        Long l3;
        boolean contains$default;
        int a16;
        Intrinsics.checkNotNullParameter(data, "data");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String correctionQuery = data.getCorrectionQuery();
        int length = correctionQuery.length();
        int i3 = 0;
        while (true) {
            num = null;
            if (i3 >= length) {
                break;
            }
            char charAt = correctionQuery.charAt(i3);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) data.getKeyword(), charAt, false, 2, (Object) null);
            if (contains$default) {
                a16 = com.tencent.mobileqq.webview.view.b.a(R.color.qui_common_text_primary);
            } else {
                a16 = com.tencent.mobileqq.webview.view.b.a(R.color.qui_common_brand_standard);
            }
            SpannableString spannableString = new SpannableString(String.valueOf(charAt));
            spannableString.setSpan(new ForegroundColorSpan(a16), 0, 1, 17);
            spannableStringBuilder.append((CharSequence) spannableString);
            i3++;
        }
        this.binding.f405754e.setText(spannableStringBuilder);
        this.binding.f405754e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.banner.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.i(com.tencent.mobileqq.search.searchdetail.content.base.c.this, data, view);
            }
        });
        this.binding.f405753d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.banner.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.j(com.tencent.mobileqq.search.searchdetail.content.base.c.this, data, view);
            }
        });
        int width = this.binding.getRoot().getWidth();
        if (width == 0) {
            this.binding.getRoot().post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.banner.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.k(h.this);
                }
            });
        } else {
            e(width);
        }
        if (dtreport != null) {
            str = dtreport.getTabName();
        } else {
            str = null;
        }
        if (dtreport != null) {
            l3 = Long.valueOf(dtreport.getTabMask());
        } else {
            l3 = null;
        }
        if (dtreport != null) {
            num = Integer.valueOf(dtreport.getUserSource());
        }
        d(str, l3, num, data);
    }
}
