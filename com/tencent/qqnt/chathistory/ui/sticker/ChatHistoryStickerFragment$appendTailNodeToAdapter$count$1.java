package com.tencent.qqnt.chathistory.ui.sticker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public /* synthetic */ class ChatHistoryStickerFragment$appendTailNodeToAdapter$count$1 extends FunctionReferenceImpl implements Function1<com.tencent.qqnt.expandRecyclerView.adapter.node.b, Boolean> {
    static IPatchRedirector $redirector_;
    public static final ChatHistoryStickerFragment$appendTailNodeToAdapter$count$1 INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new ChatHistoryStickerFragment$appendTailNodeToAdapter$count$1();
        }
    }

    ChatHistoryStickerFragment$appendTailNodeToAdapter$count$1() {
        super(1, ExtensionsKt.class, "predicateSticker", "predicateSticker(Lcom/tencent/qqnt/expandRecyclerView/adapter/node/BaseNode;)Z", 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return Boolean.valueOf(ExtensionsKt.y(p06));
    }
}
