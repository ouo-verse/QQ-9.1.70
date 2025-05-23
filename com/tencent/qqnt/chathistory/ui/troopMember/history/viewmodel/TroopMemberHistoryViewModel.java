package com.tencent.qqnt.chathistory.ui.troopMember.history.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.troopMember.history.data.b;
import com.tencent.qqnt.chathistory.ui.troopMember.history.data.datasource.PlatformTroopMemberHistorySource;
import com.tencent.qqnt.chathistory.util.d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/viewmodel/TroopMemberHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/a;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$b;", "userIntent", "", "U1", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b$a;", "S1", "X1", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/datasource/PlatformTroopMemberHistorySource;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "W1", "()Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/datasource/PlatformTroopMemberHistorySource;", "source", "T1", "()Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/b;", "mNoneValueIntent", "<init>", "()V", "G", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopMemberHistoryViewModel extends BaseHistoryViewModel<com.tencent.qqnt.chathistory.ui.troopMember.history.data.a, b> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a G;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/viewmodel/TroopMemberHistoryViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            G = new a(null);
        }
    }

    public TroopMemberHistoryViewModel() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopMemberHistoryViewModel$source$2.INSTANCE);
            this.source = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void S1(b.a userIntent) {
        d.f354054a.a("TroopMemberHistoryViewModel", "getFirstPageData  userIntent " + userIntent);
        FlowKt.launchIn(FlowKt.onEach(PlatformTroopMemberHistorySource.c(W1(), N1(), M1(), userIntent.a(), 0L, 0L, 0L, 0, 120, null), new TroopMemberHistoryViewModel$getFirstPageData$1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void U1(b.C9558b userIntent) {
        d.f354054a.a("TroopMemberHistoryViewModel", "getMorePageData  userIntent " + userIntent);
        FlowKt.launchIn(FlowKt.onEach(PlatformTroopMemberHistorySource.c(W1(), N1(), M1(), userIntent.d(), userIntent.a(), userIntent.c(), userIntent.b(), 0, 64, null), new TroopMemberHistoryViewModel$getMorePageData$1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final PlatformTroopMemberHistorySource W1() {
        return (PlatformTroopMemberHistorySource) this.source.getValue();
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.d.f353961a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            S1((b.a) userIntent);
        }
        if (userIntent instanceof b.C9558b) {
            U1((b.C9558b) userIntent);
        }
        if (userIntent instanceof b.c) {
            com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
            b.c cVar = (b.c) userIntent;
            Context a16 = cVar.a();
            int M1 = M1();
            String N1 = N1();
            String h16 = cVar.b().h();
            Intrinsics.checkNotNullExpressionValue(h16, "userIntent.troopMemberHistoryModel.peerName");
            aVar.d(a16, M1, N1, h16, cVar.b().f(), cVar.b().g(), cVar.b().j());
        }
    }
}
