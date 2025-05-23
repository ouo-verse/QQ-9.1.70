package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002\u000b\u0012B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSReportReasonItemView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", "e", "Landroid/graphics/drawable/Drawable;", "c", "", "text", "", com.tencent.luggage.wxa.c8.c.G, "a", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "d", "Lcom/tencent/biz/qqcircle/widgets/QFSReportReasonItemView$b;", "listener", "b", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mReasonItemTv", "I", "mPos", "", "f", "Z", "mIsSelect", tl.h.F, "Lcom/tencent/biz/qqcircle/widgets/QFSReportReasonItemView$b;", "mItemListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSReportReasonItemView extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mReasonItemTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mItemListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSReportReasonItemView$b;", "", "", com.tencent.luggage.wxa.c8.c.G, "", "isSelect", "", "a0", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public interface b {
        void a0(int pos, boolean isSelect);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSReportReasonItemView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable c() {
        int i3;
        int i16;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(DisplayUtil.dip2px(getContext(), 4.0f));
        int dip2px = DisplayUtil.dip2px(getContext(), 1.0f);
        Context context = getContext();
        if (this.mIsSelect) {
            i3 = R.color.qui_common_brand_standard;
        } else {
            i3 = R.color.qui_common_border_light;
        }
        gradientDrawable.setStroke(dip2px, QFSQUIUtilsKt.d(context, i3));
        Context context2 = getContext();
        if (this.mIsSelect) {
            i16 = R.color.qui_common_overlay_light;
        } else {
            i16 = R.color.ajr;
        }
        gradientDrawable.setColor(QFSQUIUtilsKt.d(context2, i16));
        return gradientDrawable;
    }

    private final void e() {
        int i3;
        TextView textView = this.mReasonItemTv;
        Context context = getContext();
        if (this.mIsSelect) {
            i3 = R.color.qui_common_brand_standard;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        textView.setTextColor(QFSQUIUtilsKt.d(context, i3));
    }

    public final void a(@NotNull String text, int pos) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mReasonItemTv.setText(text);
        this.mPos = pos;
        d();
    }

    public final void b(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mItemListener = listener;
    }

    public final void d() {
        this.mIsSelect = false;
        setBackground(c());
        e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!fb0.a.b(String.valueOf(hashCode()), 200L)) {
            this.mIsSelect = !this.mIsSelect;
            setBackground(c());
            e();
            b bVar = this.mItemListener;
            if (bVar != null) {
                bVar.a0(this.mPos, this.mIsSelect);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSReportReasonItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.gqe, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f520429q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_re\u2026tom_sheet_reason_item_tv)");
        this.mReasonItemTv = (TextView) findViewById;
        setOnClickListener(this);
    }
}
