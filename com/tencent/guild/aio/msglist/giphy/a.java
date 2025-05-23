package com.tencent.guild.aio.msglist.giphy;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.util.SparseArrayKt;
import com.tencent.aio.api.list.b;
import com.tencent.guild.aio.msglist.holder.config.c;
import com.tencent.guild.aio.msglist.holder.config.d;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.util.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B)\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\b\b\u0002\u0010-\u001a\u00020\u0014\u00a2\u0006\u0004\b.\u0010/J&\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\t0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J$\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010-\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/guild/aio/msglist/giphy/a;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "Landroid/view/View;", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/list/b;", "b1", "", "bindViewAndData", "state", "e1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "d1", "d", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "e", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "f", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", h.F, "I", "getViewType", "()I", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d componentProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c factoryProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    public a(@NotNull View itemView, @NotNull d componentProvider, @NotNull c factoryProvider, int i3) {
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
    public b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b1() {
        return this.factoryProvider.a(this.viewType).a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        t.e(this.componentProvider, this);
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
        GuildCombineUtil.f111919a.u(this.itemView, (GuildMsgItem) msgItem);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MsgListItemState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        d1(state.getPosition(), state.getData(), state.b());
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
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.zfv);
        if (linearLayout != null) {
            linearLayout.setBackground(null);
            int b16 = com.tencent.guild.aio.util.c.b(0);
            linearLayout.setPadding(b16, b16, b16, b16);
        }
        return this.itemView;
    }
}
