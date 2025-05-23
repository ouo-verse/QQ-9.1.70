package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.util.Consumer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.r;
import com.tencent.mobileqq.tvideo.view.TVideoSettingChooseItemView;
import com.tencent.mobileqq.tvideo.view.TVideoSettingSpeedChooseView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import gy2.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u001dB1\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/TVideoSettingSpeedChooseView;", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseView;", "", "g", "", "speed", "i", "Landroid/view/View;", "view", "", "j", "d", "c", "f", "Landroidx/core/util/Consumer;", "callback", "setOnSpeedChangedCallback", h.F, "Landroidx/core/util/Consumer;", "speedConsumer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoSettingSpeedChooseView extends TVideoSettingChooseView {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final ArrayList<Pair<Float, String>> f304814m;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Consumer<Float> speedConsumer;

    static {
        ArrayList<Pair<Float, String>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Pair(Float.valueOf(0.5f), "0.5X"), new Pair(Float.valueOf(0.75f), "0.75X"), new Pair(Float.valueOf(1.0f), "1X"), new Pair(Float.valueOf(1.25f), "1.25X"), new Pair(Float.valueOf(1.5f), "1.5X"), new Pair(Float.valueOf(2.0f), "2X"));
        f304814m = arrayListOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSpeedChooseView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g() {
        LinearLayout itemContainerView = getItemContainerView();
        if (itemContainerView != null) {
            itemContainerView.removeAllViews();
        }
        Iterator<Pair<Float, String>> it = f304814m.iterator();
        while (it.hasNext()) {
            final Pair<Float, String> next = it.next();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            final TVideoSettingChooseItemView tVideoSettingChooseItemView = new TVideoSettingChooseItemView(context, null, 0, 6, null);
            tVideoSettingChooseItemView.setContent(next.getSecond());
            LinearLayout itemContainerView2 = getItemContainerView();
            if (itemContainerView2 != null) {
                itemContainerView2.addView(tVideoSettingChooseItemView);
            }
            b().add(tVideoSettingChooseItemView);
            tVideoSettingChooseItemView.setOnClickListener(new View.OnClickListener() { // from class: ky2.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TVideoSettingSpeedChooseView.h(TVideoSettingChooseItemView.this, this, next, view);
                }
            });
            j(tVideoSettingChooseItemView, next.getSecond());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TVideoSettingChooseItemView itemView, TVideoSettingSpeedChooseView this$0, Pair speed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(speed, "$speed");
        if (!itemView.getIsChosen()) {
            this$0.i(((Number) speed.getFirst()).floatValue());
        }
        VideoReport.reportEvent("clck", itemView, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i(float speed) {
        f(speed);
        Consumer<Float> consumer = this.speedConsumer;
        if (consumer != null) {
            consumer.accept(Float.valueOf(speed));
        }
    }

    private final void j(View view, String speed) {
        Map<String, Object> h16 = c.h("more_float");
        h16.put("speed_cnfrm_type", speed);
        VideoReport.setElementParams(view, h16);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, "playspeed");
    }

    @Override // com.tencent.mobileqq.tvideo.view.TVideoSettingChooseView
    @NotNull
    protected String c() {
        return "\u500d  \u901f";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.view.TVideoSettingChooseView
    public void d() {
        super.d();
        g();
    }

    public final void f(float speed) {
        int size = f304814m.size();
        for (int i3 = 0; i3 < size; i3++) {
            b().get(i3).setChosen(r.a(speed, f304814m.get(i3).getFirst().floatValue()));
        }
    }

    public final void setOnSpeedChangedCallback(@NotNull Consumer<Float> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.speedConsumer = callback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSpeedChooseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSpeedChooseView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TVideoSettingSpeedChooseView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSpeedChooseView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        d();
    }
}
