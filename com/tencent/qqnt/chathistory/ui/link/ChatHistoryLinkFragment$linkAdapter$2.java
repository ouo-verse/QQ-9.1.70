package com.tencent.qqnt.chathistory.ui.link;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.ui.link.adapter.ChatHistoryLinkAdapter;
import com.tencent.qqnt.chathistory.ui.link.viewmodel.ChatHistoryLinkViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/qqnt/chathistory/ui/link/adapter/ChatHistoryLinkAdapter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class ChatHistoryLinkFragment$linkAdapter$2 extends Lambda implements Function0<ChatHistoryLinkAdapter> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ChatHistoryLinkFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chathistory/ui/link/ChatHistoryLinkFragment$linkAdapter$2$a", "Lcom/tencent/qqnt/chathistory/ui/link/adapter/b;", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "", "j0", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.qqnt.chathistory.ui.link.adapter.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChatHistoryLinkFragment f353685a;

        a(ChatHistoryLinkFragment chatHistoryLinkFragment) {
            this.f353685a = chatHistoryLinkFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryLinkFragment);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.chathistory.ui.link.adapter.b
        public void j0(@NotNull String link) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) link);
                return;
            }
            Intrinsics.checkNotNullParameter(link, "link");
            ChatHistoryLinkViewModel chatHistoryLinkViewModel = (ChatHistoryLinkViewModel) this.f353685a.rh();
            Context requireContext = this.f353685a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            i3 = this.f353685a.source;
            chatHistoryLinkViewModel.Z1(requireContext, link, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryLinkFragment$linkAdapter$2(ChatHistoryLinkFragment chatHistoryLinkFragment) {
        super(0);
        this.this$0 = chatHistoryLinkFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryLinkFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ChatHistoryLinkFragment this$0, ChatHistoryLinkAdapter this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.gi();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this_apply, this_apply.m0().size() - 1, false, false, null, 14, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ChatHistoryLinkAdapter invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ChatHistoryLinkAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final ChatHistoryLinkAdapter chatHistoryLinkAdapter = new ChatHistoryLinkAdapter(LifecycleOwnerKt.getLifecycleScope(this.this$0), (ChatHistoryLinkViewModel) this.this$0.rh(), new a(this.this$0), new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$linkAdapter$2.2
            static IPatchRedirector $redirector_;

            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                }
            }

            public final void invoke(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ChatHistoryLinkFragment.this.vh(z16, z17);
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
        final ChatHistoryLinkFragment chatHistoryLinkFragment = this.this$0;
        chatHistoryLinkAdapter.C0(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryLinkFragment$linkAdapter$2.b(ChatHistoryLinkFragment.this, chatHistoryLinkAdapter, view);
            }
        });
        return chatHistoryLinkAdapter;
    }
}
