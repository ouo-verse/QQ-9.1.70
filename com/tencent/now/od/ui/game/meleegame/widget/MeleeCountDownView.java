package com.tencent.now.od.ui.game.meleegame.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.od.ui.game.meleegame.widget.MeleeCountDownView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\b\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00064"}, d2 = {"Lcom/tencent/now/od/ui/game/meleegame/widget/MeleeCountDownView;", "Landroid/widget/FrameLayout;", "", "f", "e", "", "isPlayer", "setPlayer", "", "minute", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "setMinuteAndSecond", "", "d", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "setLowMode", "setNormalMode", "Landroid/view/View$OnClickListener;", "listener", "setAddTimeOnClickListener", "Ljava/text/DecimalFormat;", "Ljava/text/DecimalFormat;", "minFormat", "secondFormat", "Lcom/tencent/component/core/event/Eventor;", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "countDownText", "Landroid/view/View;", "i", "Landroid/view/View;", "startPkView", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "clickIconView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Boolean;", "D", "Landroid/view/View$OnClickListener;", "addTimeClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MeleeCountDownView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Boolean isPlayer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener addTimeClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DecimalFormat minFormat;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DecimalFormat secondFormat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView countDownText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View startPkView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView clickIconView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/od/ui/game/meleegame/widget/MeleeCountDownView$a", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lwn3/a;", "event", "", "a", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements OnEvent<wn3.a> {
        a() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull wn3.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MeleeCountDownView.this.clickIconView.setRotationX(180.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeCountDownView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MeleeCountDownView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.addTimeClickListener;
        if (onClickListener != null) {
            this$0.clickIconView.setRotationX(0.0f);
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e() {
        this.clickIconView.setVisibility(8);
    }

    private final void f() {
        this.startPkView.setVisibility(8);
        this.clickIconView.setVisibility(8);
    }

    @VisibleForTesting
    @NotNull
    public final String d(int minute, int second) {
        String format = this.secondFormat.format(second);
        if (minute >= 0) {
            String string = getContext().getString(R.string.zdq, this.minFormat.format(minute), format);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026t_down_min_sec, min, sec)");
            return string;
        }
        String string2 = getContext().getString(R.string.zdr, format);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026elee_count_down_sec, sec)");
        return string2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eventor.addOnEvent(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eventor.removeAll();
    }

    public final void setAddTimeOnClickListener(@Nullable View.OnClickListener listener) {
        this.addTimeClickListener = listener;
    }

    public final void setLowMode() {
        this.countDownText.setTextColor(Color.parseColor("#FF2842"));
    }

    public final void setMinuteAndSecond(int minute, int second) {
        if (second < 0) {
            this.countDownText.setText(R.string.f170596ze2);
            this.clickIconView.setVisibility(8);
        } else {
            this.countDownText.setText(d(minute, second));
        }
    }

    public final void setNormalMode() {
        this.countDownText.setTextColor(-1);
    }

    public final void setPlayer(boolean isPlayer) {
        if (Intrinsics.areEqual(this.isPlayer, Boolean.valueOf(isPlayer))) {
            return;
        }
        if (isPlayer) {
            f();
        } else {
            e();
        }
        this.isPlayer = Boolean.valueOf(isPlayer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeCountDownView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MeleeCountDownView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeCountDownView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.minFormat = new DecimalFormat("00");
        this.secondFormat = new DecimalFormat("00");
        this.eventor = new Eventor();
        LayoutInflater.from(getContext()).inflate(R.layout.dzq, this);
        View findViewById = findViewById(R.id.u_5);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.countDownText = textView;
        com.tencent.od.common.util.a.a(textView);
        View findViewById2 = findViewById(R.id.f87994vv);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.startPkView = findViewById2;
        View findViewById3 = findViewById(R.id.f164813ty1);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.clickIconView = (ImageView) findViewById3;
        f();
        setOnClickListener(new View.OnClickListener() { // from class: yn3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MeleeCountDownView.b(MeleeCountDownView.this, view);
            }
        });
    }
}
