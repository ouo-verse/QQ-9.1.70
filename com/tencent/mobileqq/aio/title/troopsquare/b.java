package com.tencent.mobileqq.aio.title.troopsquare;

import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.al;
import com.tencent.mobileqq.aio.title.troopsquare.TroopSquareUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopsquare/b;", "Lcom/tencent/mobileqq/aio/title/al;", "", "Lcom/tencent/mobileqq/aio/title/troopsquare/TroopSquareUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends al<Object, TroopSquareUIState> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.title.al
    public void E(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOTitleEvent.TroopSquareUpdateEvent) {
            AIOTitleEvent.TroopSquareUpdateEvent troopSquareUpdateEvent = (AIOTitleEvent.TroopSquareUpdateEvent) intent;
            updateUI(new TroopSquareUIState.EntryVisible(troopSquareUpdateEvent.a()));
            if (troopSquareUpdateEvent.a()) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTitleEvent.UpdateRight2IvEvent(false, false, null, 0, ""));
                return;
            }
            return;
        }
        if (intent instanceof AIOTitleEvent.GroupSquareRedpointEvent) {
            AIOTitleEvent.GroupSquareRedpointEvent groupSquareRedpointEvent = (AIOTitleEvent.GroupSquareRedpointEvent) intent;
            updateUI(new TroopSquareUIState.GroupSquareRedpointUIState(groupSquareRedpointEvent.c(), groupSquareRedpointEvent.a(), groupSquareRedpointEvent.b()));
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.TroopSquareUpdateEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.GroupSquareRedpointEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new HashSet();
    }
}
