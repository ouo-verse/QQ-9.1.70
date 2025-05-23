package com.tencent.icgame.game.live.impl.danmuku.selector;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/icgame/game/live/impl/danmuku/selector/DanmakuSelectorItemView;", "Landroid/widget/FrameLayout;", "", "select", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "", "a", "Landroid/view/View;", "d", "Landroid/view/View;", "bgView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "danmakuEffectsTv", "Lcom/tencent/icgame/game/live/impl/danmuku/selector/DanmakuSelectorPagView;", "f", "Lcom/tencent/icgame/game/live/impl/danmuku/selector/DanmakuSelectorPagView;", "danmakuEffectsPAGView", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class DanmakuSelectorItemView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bgView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView danmakuEffectsTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DanmakuSelectorPagView danmakuEffectsPAGView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void a(boolean select, int showType) {
        int i3;
        TextView textView = this.danmakuEffectsTv;
        int i16 = 0;
        if (textView != null) {
            if (showType == 0) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
        DanmakuSelectorPagView danmakuSelectorPagView = this.danmakuEffectsPAGView;
        if (danmakuSelectorPagView != null) {
            if (showType == 0) {
                i16 = 8;
            }
            danmakuSelectorPagView.setVisibility(i16);
        }
        DanmakuSelectorPagView danmakuSelectorPagView2 = this.danmakuEffectsPAGView;
        if (danmakuSelectorPagView2 != null) {
            danmakuSelectorPagView2.m();
        }
        if (showType != 1) {
            if (showType != 2) {
                TextView textView2 = this.danmakuEffectsTv;
                if (textView2 != null) {
                    textView2.setText("\u666e");
                }
            } else {
                DanmakuSelectorPagView danmakuSelectorPagView3 = this.danmakuEffectsPAGView;
                if (danmakuSelectorPagView3 != null) {
                    danmakuSelectorPagView3.l("tg_danmaku_ktv.pag");
                }
            }
        } else {
            DanmakuSelectorPagView danmakuSelectorPagView4 = this.danmakuEffectsPAGView;
            if (danmakuSelectorPagView4 != null) {
                danmakuSelectorPagView4.l("tg_danmaku_big.pag");
            }
        }
        View view = this.bgView;
        if (view != null) {
            view.setSelected(select);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ DanmakuSelectorItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        View view = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(uu0.a.b(39), uu0.a.b(39));
        layoutParams.topMargin = uu0.a.b(10);
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.f162568lt1);
        addView(view);
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(uu0.a.b(39), uu0.a.b(39));
        layoutParams2.topMargin = uu0.a.b(10);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#DBE4EB"));
        textView.setTextSize(1, 14.0f);
        this.danmakuEffectsTv = textView;
        addView(textView);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DanmakuSelectorPagView danmakuSelectorPagView = new DanmakuSelectorPagView(context, null, 0, 6, null);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(uu0.a.b(39), uu0.a.b(39));
        layoutParams3.topMargin = uu0.a.b(10);
        danmakuSelectorPagView.setLayoutParams(layoutParams3);
        this.danmakuEffectsPAGView = danmakuSelectorPagView;
        addView(danmakuSelectorPagView);
    }
}
