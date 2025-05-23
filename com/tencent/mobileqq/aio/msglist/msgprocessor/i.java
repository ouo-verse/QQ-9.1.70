package com.tencent.mobileqq.aio.msglist.msgprocessor;

import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/i;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "", "g", "msgItem", "", "f", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        }
    }

    private final boolean f(com.tencent.aio.data.msglist.a msgItem) {
        if (!(msgItem instanceof PicMsgItem)) {
            return false;
        }
        PicMsgItem picMsgItem = (PicMsgItem) msgItem;
        if (picMsgItem.p2().emojiZplan == null || picMsgItem.p2().emojiZplan.actionId == 0) {
            return false;
        }
        return true;
    }

    private final void g(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        int lastIndex;
        if (!displayList.isEmpty()) {
            for (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(displayList); -1 < lastIndex; lastIndex--) {
                com.tencent.aio.data.msglist.a aVar = displayList.get(lastIndex);
                if (!aVar.isSelf() && f(aVar)) {
                    ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(INTZPlanAdapterApi.class)).showZPlanEmoticonGrayTips(b());
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        g(displayList);
        return displayList;
    }
}
