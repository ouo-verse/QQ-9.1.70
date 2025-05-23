package com.tencent.guild.aio.msglist.welcome;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0014\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgAvatarComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/ImageView;", h.F, "Lkotlin/Lazy;", "i1", "()Landroid/widget/ImageView;", "avatar", "<init>", "(Landroid/view/View;)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildWelcomeMsgAvatarComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatar;

    public GuildWelcomeMsgAvatarComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgAvatarComponent$avatar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                ImageView imageView = new ImageView(GuildWelcomeMsgAvatarComponent.this.getRoot().getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.guild.aio.util.c.b(30), com.tencent.guild.aio.util.c.b(30));
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                return imageView;
            }
        });
        this.avatar = lazy;
    }

    private final ImageView i1() {
        return (ImageView) this.avatar.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(msgItem instanceof GuildWelcomeMsgItem)) {
            QLog.e("GuildWelcomeMsgAvatarComponent", 1, "bind, msgItem = " + msgItem.getClass());
            return;
        }
        ImageView i16 = i1();
        Context context = i1().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "avatar.context");
        i16.setImageDrawable(GuildUIUtils.y(context, ((GuildWelcomeMsgItem) msgItem).getIconResId(), -1));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return i1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
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
