package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudWatchlater$Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0014J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/QFSWatchLaterHintView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lfeedcloud/FeedCloudWatchlater$Feed;", "", "l0", "", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "initView", "objData", com.tencent.luggage.wxa.c8.c.G, "k0", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "formerHintView", "e", "clearHintView", "Landroid/view/View$OnClickListener;", "f", "Landroid/view/View$OnClickListener;", "getClearClickListener", "()Landroid/view/View$OnClickListener;", "setClearClickListener", "(Landroid/view/View$OnClickListener;)V", "clearClickListener", "<init>", "(Landroid/content/Context;)V", tl.h.F, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSWatchLaterHintView extends QCircleBaseWidgetView<FeedCloudWatchlater$Feed> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView formerHintView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView clearHintView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener clearClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSWatchLaterHintView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l0() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TextView textView = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        textView.setLayoutParams(layoutParams2);
        textView2.setLayoutParams(layoutParams2);
        textView.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary));
        textView.setTextSize(1, 12.0f);
        textView2.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_button_bg_primary_default));
        textView2.setTextSize(1, 12.0f);
        textView2.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f196504hh));
        textView2.setPadding(cx.a(4.0f), 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        addView(linearLayout);
        this.formerHintView = textView;
        this.clearHintView = textView2;
        int a16 = cx.a(20.0f);
        setPadding(0, a16, 0, a16);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        l0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable FeedCloudWatchlater$Feed objData, int pos) {
        if (objData == null) {
            return;
        }
        TextView textView = this.formerHintView;
        if (textView != null) {
            textView.setText(objData.feed_info.content.get());
        }
        TextView textView2 = this.clearHintView;
        if (textView2 != null) {
            textView2.setOnClickListener(this.clearClickListener);
        }
    }

    public final void setClearClickListener(@Nullable View.OnClickListener onClickListener) {
        this.clearClickListener = onClickListener;
    }
}
