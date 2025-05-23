package com.tencent.guild.aio.msglist.holder.component.newmsgline;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\r\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0017\u0010\u0016\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/newmsgline/GuildBubbleNewMsgLineComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "d1", "", "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", h.F, "Lkotlin/Lazy;", "i1", "newMsgLineView", "<init>", "(Landroid/view/View;)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildBubbleNewMsgLineComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy newMsgLineView;

    public GuildBubbleNewMsgLineComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.guild.aio.msglist.holder.component.newmsgline.GuildBubbleNewMsgLineComponent$newMsgLineView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                return new a(GuildBubbleNewMsgLineComponent.this.getRoot().getContext()).b();
            }
        });
        this.newMsgLineView = lazy;
    }

    private final View i1() {
        Object value = this.newMsgLineView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-newMsgLineView>(...)");
        return (View) value;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        int i3;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        boolean areEqual = Intrinsics.areEqual(GuildMsgItem.getExtInfoFromExtStr$default((GuildMsgItem) msgItem, "guild_first_unread_msg_seq_json_key", null, 2, null), "1");
        View i16 = i1();
        if (areEqual) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        i16.setVisibility(i3);
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

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildBubbleNewMsgLineComponent";
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
