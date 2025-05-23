package com.tencent.mobileqq.guild.live.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/MoreIconViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Lkotlin/Lazy;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "text", "Lcom/airbnb/lottie/LottieAnimationView;", "G", "l", "()Lcom/airbnb/lottie/LottieAnimationView;", "animView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MoreIconViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy icon;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy text;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy animView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreIconViewHolder(@NotNull final View itemView) {
        super(itemView);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.live.widget.MoreIconViewHolder$icon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) itemView.findViewById(R.id.f165861dq1);
            }
        });
        this.icon = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.live.widget.MoreIconViewHolder$text$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) itemView.findViewById(R.id.dpr);
            }
        });
        this.text = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.tencent.mobileqq.guild.live.widget.MoreIconViewHolder$animView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LottieAnimationView invoke() {
                return (LottieAnimationView) itemView.findViewById(R.id.spg);
            }
        });
        this.animView = lazy3;
    }

    @NotNull
    public final ImageView getIcon() {
        Object value = this.icon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-icon>(...)");
        return (ImageView) value;
    }

    @NotNull
    public final LottieAnimationView l() {
        Object value = this.animView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-animView>(...)");
        return (LottieAnimationView) value;
    }

    @NotNull
    public final TextView m() {
        Object value = this.text.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-text>(...)");
        return (TextView) value;
    }
}
