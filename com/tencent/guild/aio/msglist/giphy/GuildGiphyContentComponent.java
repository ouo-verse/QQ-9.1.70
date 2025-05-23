package com.tencent.guild.aio.msglist.giphy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.giphy.sdk.ui.views.GPHMediaView;
import com.tencent.guild.aio.msglist.giphy.util.GuildGiphyComponentUtilKt;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0016\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/msglist/giphy/GuildGiphyContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "i1", "Landroid/widget/FrameLayout;", "j1", "", "position", "", "", "payloads", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", h.F, "Lkotlin/Lazy;", "k1", "()Landroid/widget/FrameLayout;", "contentView", "<init>", "(Landroid/view/View;)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiphyContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public GuildGiphyContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.guild.aio.msglist.giphy.GuildGiphyContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                return new FrameLayout(GuildGiphyContentComponent.this.getRoot().getContext());
            }
        });
        this.contentView = lazy;
    }

    private final void i1(com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        MsgElement firstTypeElement = ((GuildMsgItem) msgItem).getFirstTypeElement(15);
        GuildGiphyRecyclerManager.f111293a.a().b(k1(), new Function1<GPHMediaView, Unit>() { // from class: com.tencent.guild.aio.msglist.giphy.GuildGiphyContentComponent$bindContentView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GPHMediaView gPHMediaView) {
                invoke2(gPHMediaView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GPHMediaView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.setImageDrawable((Drawable) null);
            }
        });
        if (firstTypeElement != null && firstTypeElement.giphyElement != null) {
            d1();
            FrameLayout k16 = k1();
            Context context = this.root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "root.context");
            GPHMediaView b16 = GuildGiphyComponentUtilKt.b(context);
            GuildGiphyComponentUtilKt.a(this.root, firstTypeElement, msgItem, b16);
            k16.addView((View) b16);
        }
    }

    private final FrameLayout k1() {
        return (FrameLayout) this.contentView.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        i1(msgItem);
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public FrameLayout d1() {
        return k1();
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
