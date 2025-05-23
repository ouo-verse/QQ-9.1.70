package com.tencent.mobileqq.aio.msglist.msgrepo;

import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/MultiSelectAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "isSelectMode", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "g", "", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "c", "i", "Z", "mIsSelectMode", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MultiSelectAbility extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSelectAbility(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        }
    }

    private final void n(boolean isSelectMode) {
        this.mIsSelectMode = isSelectMode;
        BuildersKt__Builders_commonKt.launch$default(f(), zs.b.a(Dispatchers.INSTANCE), null, new MultiSelectAbility$handleMultiSelectModeChange$1(this, isSelectMode, null), 2, null);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void c(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItemList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        super.c(msgItemList);
        for (com.tencent.aio.data.msglist.a aVar : msgItemList) {
            if (aVar instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null) {
                aIOMsgItem.P1(this.mIsSelectMode);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            n(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new HashSet();
    }
}
