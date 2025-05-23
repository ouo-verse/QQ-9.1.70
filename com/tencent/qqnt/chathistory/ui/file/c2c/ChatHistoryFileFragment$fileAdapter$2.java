package com.tencent.qqnt.chathistory.ui.file.c2c;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.ui.file.c2c.adapter.ChatHistoryFileAdapter;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel.ChatHistoryFileModel;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/ChatHistoryFileAdapter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class ChatHistoryFileFragment$fileAdapter$2 extends Lambda implements Function0<ChatHistoryFileAdapter> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ChatHistoryFileFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/c2c/ChatHistoryFileFragment$fileAdapter$2$a", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "file", "Landroid/view/View;", "view", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "allRichRecord", "", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.qqnt.chathistory.ui.file.c2c.adapter.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChatHistoryFileFragment f353521a;

        a(ChatHistoryFileFragment chatHistoryFileFragment) {
            this.f353521a = chatHistoryFileFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryFileFragment);
            }
        }

        @Override // com.tencent.qqnt.chathistory.ui.file.c2c.adapter.d
        public void a(@NotNull FileItemModel file, @NotNull View view, @NotNull List<MsgRecord> allRichRecord) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, file, view, allRichRecord);
                return;
            }
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(allRichRecord, "allRichRecord");
            com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
            Context requireContext = this.f353521a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            MsgRecord y16 = file.y();
            FileElement q16 = file.q();
            i3 = this.f353521a.source;
            aVar.a(requireContext, y16, q16, view, allRichRecord, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryFileFragment$fileAdapter$2(ChatHistoryFileFragment chatHistoryFileFragment) {
        super(0);
        this.this$0 = chatHistoryFileFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryFileFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ChatHistoryFileFragment this$0, ChatHistoryFileAdapter this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Zh();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this_apply, this_apply.m0().size() - 1, false, false, null, 14, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ChatHistoryFileAdapter invoke() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ChatHistoryFileAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ChatHistoryFileModel chatHistoryFileModel = (ChatHistoryFileModel) this.this$0.rh();
        a aVar = new a(this.this$0);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        i3 = this.this$0.source;
        final ChatHistoryFileAdapter chatHistoryFileAdapter = new ChatHistoryFileAdapter(chatHistoryFileModel, aVar, lifecycleScope, i3, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$fileAdapter$2.2
            static IPatchRedirector $redirector_;

            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
                }
            }

            public final void invoke(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ChatHistoryFileFragment.this.vh(z16, z17);
                } else {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }
        });
        final ChatHistoryFileFragment chatHistoryFileFragment = this.this$0;
        chatHistoryFileAdapter.C0(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryFileFragment$fileAdapter$2.b(ChatHistoryFileFragment.this, chatHistoryFileAdapter, view);
            }
        });
        return chatHistoryFileAdapter;
    }
}
