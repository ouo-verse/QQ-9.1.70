package com.tencent.mobileqq.guild.aisearch.history;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class AIChatHistoryPopupWindow$popupView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ AIChatHistoryPopupWindow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatHistoryPopupWindow$popupView$2(AIChatHistoryPopupWindow aIChatHistoryPopupWindow) {
        super(0);
        this.this$0 = aIChatHistoryPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIChatHistoryPopupWindow this$0, View view) {
        Function1 function1;
        PopupWindow popupWindow;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        function1 = this$0.itemClickListener;
        if (function1 != null) {
            function1.invoke(1);
        }
        this$0.itemClickListener = null;
        popupWindow = this$0.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        Context context;
        int i3;
        context = this.this$0.context;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.edr, (ViewGroup) null);
        final AIChatHistoryPopupWindow aIChatHistoryPopupWindow = this.this$0;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bfq);
        GuildVectorDrawableCompat create = GuildVectorDrawableCompat.create(imageView.getResources(), R.drawable.guild_vector_icon_delete, null);
        if (create != null) {
            create.setTintList(ContextCompat.getColorStateList(imageView.getContext(), R.color.qui_common_feedback_error));
        }
        if (create != null) {
            create.setOverrideStrokeWidth(1.37f);
        }
        imageView.setImageDrawable(create);
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) inflate.findViewById(R.id.f26460dl);
        roundFrameLayout.setCorners(15);
        i3 = AIChatHistoryPopupWindow.f213990f;
        roundFrameLayout.setRadius(i3);
        if (Build.VERSION.SDK_INT < 28) {
            roundFrameLayout.setElevation(com.tencent.guild.aio.util.c.b(10));
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.history.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIChatHistoryPopupWindow$popupView$2.b(AIChatHistoryPopupWindow.this, view);
            }
        });
        return inflate;
    }
}
