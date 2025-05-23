package com.tencent.mobileqq.guild.discoveryv2.tips;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/tips/c;", "Lcom/tencent/mobileqq/guild/discoveryv2/tips/ReservePart;", "Lqh1/d;", "state", "Landroid/view/View;", "A9", "", "f", "I", "skeletonResId", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends ReservePart {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int skeletonResId;

    public c(int i3) {
        this.skeletonResId = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refresh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refresh();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.tips.ReservePart
    @Nullable
    public View A9(@NotNull qh1.d state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof d.b) {
            QUIEmptyState.Builder builder = new QUIEmptyState.Builder(getContext());
            builder.setThemeType(0);
            builder.setBackgroundColorType(0);
            builder.setHalfScreenState(false);
            builder.setAutoCenter(true);
            String string = getContext().getString(R.string.f152871ak);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_reload)");
            builder.setButton(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.tips.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.E9(c.this, view);
                }
            });
            builder.setTitle("\u7f51\u7edc\u5f02\u5e38");
            if (!AppNetConnInfo.isNetSupport()) {
                builder.setImageType(5);
                String string2 = getContext().getString(R.string.f2070459y);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026qq_video_play_error_hint)");
                builder.setDesc(string2);
            } else {
                builder.setImageType(13);
                String string3 = getContext().getString(R.string.oxz);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.te\u2026.qqstr_ocrresul_e4ff4aa7)");
                builder.setDesc(string3);
            }
            QUIEmptyState build = builder.build();
            ImageView imageView = (ImageView) build.findViewById(R.id.uuj);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.guild_net_error);
                return build;
            }
            return build;
        }
        if (state instanceof d.C11077d) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
            scanningLightView.setBackgroundResource(this.skeletonResId);
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            return scanningLightView;
        }
        if (!(state instanceof d.a)) {
            return null;
        }
        QUIEmptyState.Builder builder2 = new QUIEmptyState.Builder(getContext());
        builder2.setThemeType(0);
        builder2.setBackgroundColorType(0);
        builder2.setHalfScreenState(false);
        builder2.setImageType(8);
        String string4 = getContext().getString(R.string.f1513917k);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026d_notice_empty_view_text)");
        builder2.setDesc(string4);
        String string5 = getContext().getString(R.string.f152871ak);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.guild_reload)");
        builder2.setButton(string5, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.tips.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.F9(c.this, view);
            }
        });
        return builder2.build();
    }

    public /* synthetic */ c(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? R.drawable.guild_mvp_feeds_loading : i3);
    }
}
