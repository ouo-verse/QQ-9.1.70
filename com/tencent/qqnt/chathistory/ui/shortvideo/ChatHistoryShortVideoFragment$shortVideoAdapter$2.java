package com.tencent.qqnt.chathistory.ui.shortvideo;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel.ChatHistoryShortVideoViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/a;", "invoke", "()Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoFragment$shortVideoAdapter$2 extends Lambda implements Function0<com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a> {
    final /* synthetic */ ChatHistoryShortVideoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryShortVideoFragment$shortVideoAdapter$2(ChatHistoryShortVideoFragment chatHistoryShortVideoFragment) {
        super(0);
        this.this$0 = chatHistoryShortVideoFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ChatHistoryShortVideoFragment this$0, com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Vh();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this_apply, this_apply.m0().size() - 1, false, false, null, 14, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a invoke() {
        int i3;
        i3 = this.this$0.source;
        final com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a aVar = new com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a(i3, (ChatHistoryShortVideoViewModel) this.this$0.rh());
        final ChatHistoryShortVideoFragment chatHistoryShortVideoFragment = this.this$0;
        aVar.C0(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryShortVideoFragment$shortVideoAdapter$2.b(ChatHistoryShortVideoFragment.this, aVar, view);
            }
        });
        return aVar;
    }
}
