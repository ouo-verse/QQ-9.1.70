package com.tencent.qqnt.chathistory.ui.menu.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.menu.data.a;
import com.tencent.qqnt.chathistory.ui.menu.data.b;
import com.tencent.qqnt.chathistory.ui.menu.data.datasource.PlatformSearchDataSource;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0006R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/menu/data/a;", "Lcom/tencent/qqnt/chathistory/ui/menu/data/b;", "Lcom/tencent/qqnt/chathistory/ui/menu/data/b$b;", "mainUserIntent", "", "X1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/qqnt/chathistory/ui/menu/data/b$c;", "Z1", "", "b2", "W1", "", "isSearch", "S1", "T1", "Lcom/tencent/qqnt/chathistory/ui/menu/data/repository/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/ui/menu/data/repository/a;", "dataSource", "G", "Lcom/tencent/qqnt/chathistory/ui/menu/data/b;", "U1", "()Lcom/tencent/qqnt/chathistory/ui/menu/data/b;", "mNoneValueIntent", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistorySearchViewModel extends BaseHistoryViewModel<a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chathistory.ui.menu.data.repository.a dataSource;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    public ChatHistorySearchViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.dataSource = new com.tencent.qqnt.chathistory.ui.menu.data.repository.a(new PlatformSearchDataSource(), new com.tencent.qqnt.chathistory.ui.menu.data.datasource.a());
            this.mNoneValueIntent = b.a.f353815a;
        }
    }

    private final void X1(b.C9545b mainUserIntent) {
        getMUiState().postValue(new a.c(mainUserIntent.a(), mainUserIntent.b()));
    }

    private final void Z1(b.c mainUserIntent) {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.dataSource.c(mainUserIntent.a(), M1(), N1()), new ChatHistorySearchViewModel$searchByKeyWord$1(this, null)), Dispatchers.getUnconfined()), ViewModelKt.getViewModelScope(this));
    }

    private final void a2() {
        this.dataSource.b();
    }

    public final void S1(boolean isSearch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isSearch);
        } else {
            d.f354054a.a("ChatHistoryViewModel", "cancelSearchMsgWithKeywords");
            this.dataSource.a(!isSearch ? 1 : 0, "");
        }
    }

    public final void T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            d.f354054a.a("ChatHistoryViewModel", "clear LiveData cache");
            getMUiState().postValue(a.C9544a.f353811a);
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b mainUserIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mainUserIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(mainUserIntent, "mainUserIntent");
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryViewModel", 2, "userIntent:" + mainUserIntent);
        }
        if (mainUserIntent instanceof b.a) {
            return;
        }
        if (mainUserIntent instanceof b.c) {
            Z1((b.c) mainUserIntent);
        }
        if (mainUserIntent instanceof b.d) {
            a2();
        }
        if (mainUserIntent instanceof b.C9545b) {
            X1((b.C9545b) mainUserIntent);
        }
    }

    @NotNull
    public final int[] b2() {
        int[] intArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            intArray = CollectionsKt___CollectionsKt.toIntArray(L1().Q1());
            return intArray;
        }
        return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
