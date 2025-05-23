package lw1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.performance.report.x;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Llw1/h;", "", "Landroid/view/View;", "view", "", "e", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Llw1/j;", "clickCallback", "d", "c", "", "searchWord", "b", "a", "Landroid/view/View;", "mItemView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mHistoryItemView", "Llw1/j;", "mClickCallback", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View mItemView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TextView mHistoryItemView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j mClickCallback;

    private final void e(View view) {
        this.mItemView = view;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.wuy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mItemView.findViewById(R\u2026uick_search_history_item)");
        this.mHistoryItemView = (TextView) findViewById;
        View view3 = this.mItemView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: lw1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                h.f(h.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!QQGuildUIUtil.v()) {
            j jVar = this$0.mClickCallback;
            if (jVar != null) {
                TextView textView = this$0.mHistoryItemView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHistoryItemView");
                    textView = null;
                }
                jVar.c(textView.getText().toString());
            }
            x.b("click_history_item", 0, null, null, 14, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void b(@NotNull String searchWord) {
        HashMap hashMapOf;
        View view;
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        TextView textView = this.mHistoryItemView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistoryItemView");
            textView = null;
        }
        textView.setText(searchWord);
        TextView textView2 = this.mHistoryItemView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistoryItemView");
            textView2 = null;
        }
        VideoReport.setElementReuseIdentifier(textView2, searchWord);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_word", searchWord));
        View view2 = this.mItemView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            view = null;
        } else {
            view = view2;
        }
        bt.c(view, "em_sgrp_search_history", hashMapOf, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE);
    }

    public final void c(@NotNull View view, @NotNull j clickCallback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        e(view);
        this.mClickCallback = clickCallback;
    }

    @NotNull
    public final View d(@Nullable ViewGroup parent, @NotNull j clickCallback) {
        Context context;
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        if (parent != null) {
            context = parent.getContext();
        } else {
            context = null;
        }
        View view = LayoutInflater.from(context).inflate(R.layout.f3c, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        e(view);
        this.mClickCallback = clickCallback;
        return view;
    }
}
