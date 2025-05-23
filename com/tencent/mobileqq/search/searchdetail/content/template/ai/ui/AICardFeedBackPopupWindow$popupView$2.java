package com.tencent.mobileqq.search.searchdetail.content.template.ai.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hp2.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class AICardFeedBackPopupWindow$popupView$2 extends Lambda implements Function0<ConstraintLayout> {
    final /* synthetic */ AICardFeedBackPopupWindow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AICardFeedBackPopupWindow$popupView$2(AICardFeedBackPopupWindow aICardFeedBackPopupWindow) {
        super(0);
        this.this$0 = aICardFeedBackPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ConstraintLayout invoke() {
        Context context;
        float f16;
        context = this.this$0.context;
        l g16 = l.g(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), null, false)");
        this.this$0.rootBinding = g16;
        ConstraintLayout constraintLayout = g16.f405689h;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28) {
            constraintLayout.setElevation(com.tencent.guild.aio.util.c.b(8));
        }
        View view = g16.f405694m;
        AICardFeedBackPopupWindow aICardFeedBackPopupWindow = this.this$0;
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Drawable background = view.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "background");
        view.setBackground(guildUIUtils.F(background, ContextCompat.getColor(view.getContext(), R.color.qui_common_bg_top_light)));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        f16 = aICardFeedBackPopupWindow.triangleMarginRight;
        layoutParams2.setMarginEnd(x.a(f16));
        view.setLayoutParams(layoutParams2);
        if (i3 < 28) {
            view.setElevation(com.tencent.guild.aio.util.c.b(8));
        }
        g16.f405689h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AICardFeedBackPopupWindow$popupView$2.b(view2);
            }
        });
        return g16.getRoot();
    }
}
