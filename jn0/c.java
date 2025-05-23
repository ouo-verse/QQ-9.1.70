package jn0;

import android.view.View;
import androidx.core.util.SparseArrayKt;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00012B)\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u0012\b\b\u0002\u0010.\u001a\u00020\u0015\u00a2\u0006\u0004\b/\u00100J&\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\t0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u0016J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00100\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J$\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0017\u0010.\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Ljn0/c;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "Landroid/view/View;", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/list/b;", "b1", "Ljava/lang/Class;", "getObserverStates", "state", "", "e1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "d1", "d", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "e", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "f", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", h.F, "I", "getViewType", "()I", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.d componentProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.c factoryProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    public c(@NotNull View itemView, @NotNull com.tencent.guild.aio.msglist.holder.config.d componentProvider, @NotNull com.tencent.guild.aio.msglist.holder.config.c factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.itemView = itemView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    @Override // com.tencent.aio.api.list.a
    @Nullable
    public com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b1() {
        return this.factoryProvider.a(this.viewType).a();
    }

    public final void d1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                aVar.b1(position, msgItem, payloads);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MsgListItemState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        d1(state.getPosition(), state.getData(), state.b());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MsgListItemState>> getObserverStates() {
        List<Class<? extends MsgListItemState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(MsgListItemState.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        View view;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                view = aVar.getContainerView();
            } else {
                view = null;
            }
            if (view != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.itemView;
    }
}
