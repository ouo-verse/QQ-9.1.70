package com.tencent.mobileqq.aio.msglist.msgprocessor;

import com.tencent.mobileqq.aio.msg.LocationShareMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOLocationShareApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/d;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        int lastIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (((IAIOLocationShareApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOLocationShareApi.class)).getLocationShareStatus(b())) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(displayList);
            while (true) {
                if (-1 >= lastIndex) {
                    break;
                }
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) displayList.get(lastIndex);
                if (aVar instanceof LocationShareMsgItem) {
                    ((LocationShareMsgItem) aVar).k2(true);
                    break;
                }
                lastIndex--;
            }
            return displayList;
        }
        return displayList;
    }
}
