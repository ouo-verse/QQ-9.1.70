package com.tencent.guild.aio.msglist.wallet;

import android.view.View;
import android.widget.TextView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/msglist/wallet/GuildWalletUnSupportComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Landroid/widget/TextView;", "f", "Lkotlin/Lazy;", "i1", "()Landroid/widget/TextView;", "contentView", "root", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildWalletUnSupportComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public GuildWalletUnSupportComponent(@NotNull final View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.wallet.GuildWalletUnSupportComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return new TextView(root.getContext());
            }
        });
        this.contentView = lazy;
    }

    private final TextView i1() {
        return (TextView) this.contentView.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        i1().setText("[QQ\u7ea2\u5305]\u5f53\u524d\u5e73\u53f0\u7248\u672c\u6682\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7ea2\u5305");
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return i1();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
