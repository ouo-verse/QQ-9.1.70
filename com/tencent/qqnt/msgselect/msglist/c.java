package com.tencent.qqnt.msgselect.msglist;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/msgselect/msglist/c;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "g", "f", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "", "d", "I", "getINVITE_TO_GROUP", "()I", "INVITE_TO_GROUP", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int INVITE_TO_GROUP;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        } else {
            this.INVITE_TO_GROUP = 1002;
        }
    }

    private final boolean f(AIOMsgItem msgItem) {
        long j3 = b().g().l().getLong("key_limited_time");
        if (j3 > 0 && System.currentTimeMillis() - (msgItem.getMsgRecord().msgTime * 1000) >= j3) {
            return true;
        }
        return false;
    }

    private final boolean g(AIOMsgItem msgItem) {
        if (msgItem.getMsgRecord().sendStatus == 0 || msgItem.getMsgRecord().sendStatus == 1 || com.tencent.qqnt.aio.msg.d.i(msgItem) || f(msgItem)) {
            return true;
        }
        int i3 = msgItem.getMsgRecord().msgType;
        if (b().g().l().getInt("key_from", 0) == this.INVITE_TO_GROUP && (i3 == 6 || i3 == 19 || i3 == 23)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List<com.tencent.aio.data.msglist.a> mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) displayList);
        Iterator<com.tencent.aio.data.msglist.a> it = mutableList.iterator();
        while (it.hasNext()) {
            com.tencent.aio.data.msglist.a next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            if (g((AIOMsgItem) next)) {
                it.remove();
            }
        }
        return mutableList;
    }
}
