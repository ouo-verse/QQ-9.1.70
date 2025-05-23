package com.tencent.mobileqq.guild.discoveryv2.tips;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/tips/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/tips/ReservePart;", "Lqh1/d;", "state", "Landroid/view/View;", "A9", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends ReservePart {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refresh();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.tips.ReservePart
    @Nullable
    public View A9(@NotNull qh1.d state) {
        View view;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof d.b) {
            QUIEmptyState.Builder builder = new QUIEmptyState.Builder(getContext());
            builder.setThemeType(0);
            builder.setImageType(5);
            builder.setBackgroundColorType(0);
            builder.setHalfScreenState(false);
            builder.setAutoCenter(true);
            String string = getContext().getString(R.string.f153041b1);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_request_error)");
            builder.setDesc(string);
            String string2 = getContext().getString(R.string.f143170lc);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026ld_dicovery_mine_refresh)");
            builder.setButton(string2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.tips.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    g.D9(g.this, view2);
                }
            });
            view = builder.build();
        } else if (state instanceof d.C11077d) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
            scanningLightView.setImageResource(R.drawable.guild_discovery_v2_loading1);
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            view = scanningLightView;
        } else if (state instanceof d.a) {
            GuildQUIEmptyState.a aVar = new GuildQUIEmptyState.a(getContext());
            aVar.t(0);
            aVar.o(0);
            aVar.r(false);
            aVar.n(true);
            aVar.s(3);
            String string3 = getContext().getString(R.string.f152761a_);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026ently_viewed_empty_title)");
            aVar.u(string3);
            view = aVar.a();
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        return view;
    }
}
