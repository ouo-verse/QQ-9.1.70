package com.tencent.guild.aio.msglist.holder.component;

import android.view.View;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b&\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\b\u0010\u000e\u001a\u00020\rH&J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0014\u001a\u00020\u0013H\u0016J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR$\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/aio/base/mvvm/b;", "e1", "Lcom/tencent/aio/api/runtime/a;", "f1", "", "getTag", "c1", "d", "Landroid/view/View;", "g1", "()Landroid/view/View;", "h1", "(Landroid/view/View;)V", "containerView", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a extends com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View containerView;

    public abstract void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads);

    public final void c1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        g12.b bVar = g12.b.f401087a;
        GuildHistogramScene guildHistogramScene = GuildHistogramScene.GUILD_AIO_BIND_COMPONENT_TIME_COST;
        bVar.h(guildHistogramScene, getTag());
        b1(position, msgItem, payloads);
        bVar.a(guildHistogramScene, getTag());
    }

    @NotNull
    public abstract View d1();

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new t();
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a f1() {
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, 0 == true ? 1 : 0);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        return aioContextWrapper.getContext();
    }

    @Nullable
    /* renamed from: g1, reason: from getter */
    public final View getContainerView() {
        return this.containerView;
    }

    @NotNull
    public String getTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void h1(@Nullable View view) {
        this.containerView = view;
    }
}
