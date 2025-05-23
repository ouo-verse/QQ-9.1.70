package com.tencent.guild.aio.msglist.holder.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$viewHolder$1", "", "Landroid/widget/LinearLayout;", "a", "Lkotlin/Lazy;", "b", "()Landroid/widget/LinearLayout;", "wrapperView", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "c", "(Landroid/view/View;)V", "avatarView", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildBubbleAvatarComponent$viewHolder$1 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy wrapperView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View avatarView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildBubbleAvatarComponent$viewHolder$1(final GuildBubbleAvatarComponent guildBubbleAvatarComponent) {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarComponent$viewHolder$1$wrapperView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(GuildBubbleAvatarComponent.this.getRoot().getContext());
                int dimensionPixelSize = GuildBubbleAvatarComponent.this.getRoot().getResources().getDimensionPixelSize(R.dimen.f158959cc4);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize));
                return linearLayout;
            }
        });
        this.wrapperView = lazy;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final View getAvatarView() {
        return this.avatarView;
    }

    @NotNull
    public final LinearLayout b() {
        return (LinearLayout) this.wrapperView.getValue();
    }

    public final void c(@Nullable View view) {
        this.avatarView = view;
    }
}
