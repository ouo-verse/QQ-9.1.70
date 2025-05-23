package com.tencent.qqnt.chathistory.ui.shortvideo.adapter;

import com.tencent.qqnt.chathistory.ui.base.l;
import com.tencent.qqnt.chathistory.ui.base.n;
import com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel.ChatHistoryShortVideoViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0019\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/a;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "", "", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "data", "", "position", "o0", "G", "I", "source", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/viewmodel/ChatHistoryShortVideoViewModel;", "H", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/viewmodel/ChatHistoryShortVideoViewModel;", "viewModel", "", "S0", "()Z", "setChooseModel", "(Z)V", "chooseModel", "<init>", "(ILcom/tencent/qqnt/chathistory/ui/shortvideo/viewmodel/ChatHistoryShortVideoViewModel;)V", "J", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends com.tencent.qqnt.expandRecyclerView.adapter.provider.b {

    /* renamed from: G, reason: from kotlin metadata */
    private final int source;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ChatHistoryShortVideoViewModel viewModel;
    private final /* synthetic */ l I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i3, @NotNull ChatHistoryShortVideoViewModel viewModel) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.source = i3;
        this.viewModel = viewModel;
        this.I = new l();
        F0(new n());
        F0(new b());
        F0(new e());
        k0(new ChatHistoryShortVideoItemProvider());
    }

    public boolean S0() {
        return this.I.f();
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    protected int o0(@NotNull List<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = data.get(position);
        if (bVar instanceof com.tencent.qqnt.chathistory.ui.base.item.a) {
            return 0;
        }
        if (bVar instanceof com.tencent.qqnt.chathistory.ui.shortvideo.data.model.b) {
            return 800;
        }
        return 4;
    }
}
