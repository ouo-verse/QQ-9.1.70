package com.tencent.now.od.ui.game.odgame.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/now/od/ui/game/odgame/widget/ODStageIndicatorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "d", "Landroid/view/View;", "gameNotStartView", "e", "gameStartView", "f", "stageSelfIntroducingView", h.F, "stageLoverChoosingView", "i", "stageResultShowingView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ODStageIndicatorView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View gameNotStartView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View gameStartView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View stageSelfIntroducingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View stageLoverChoosingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View stageResultShowingView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ODStageIndicatorView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ODStageIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ODStageIndicatorView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ODStageIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.e0d, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.vjo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.game_not_start)");
        this.gameNotStartView = findViewById;
        View findViewById2 = findViewById(R.id.vjy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.game_start)");
        this.gameStartView = findViewById2;
        View findViewById3 = findViewById(R.id.f87834vf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.stage_self_introducing)");
        this.stageSelfIntroducingView = findViewById3;
        View findViewById4 = findViewById(R.id.f87814vd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.stage_lover_choosing)");
        this.stageLoverChoosingView = findViewById4;
        View findViewById5 = findViewById(R.id.f87824ve);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.stage_result_showing)");
        this.stageResultShowingView = findViewById5;
    }
}
