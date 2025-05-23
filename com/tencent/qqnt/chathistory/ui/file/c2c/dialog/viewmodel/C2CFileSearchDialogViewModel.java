package com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource.C2CFileSearchDataSource;
import com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/C2CFileSearchDialogViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/b;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/a;", "", "keyword", "", "Q1", "R1", "userIntent", "P1", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/a$a;", "intent", "M1", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "O1", "()Ljava/lang/String;", "peerId", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/datasource/C2CFileSearchDataSource;", "D", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/datasource/C2CFileSearchDataSource;", "resource", "N1", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/a;", "mNoneValueIntent", "<init>", "(Ljava/lang/String;)V", "E", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class C2CFileSearchDialogViewModel extends BaseViewModel<b, com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.a> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String peerId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final C2CFileSearchDataSource resource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/C2CFileSearchDialogViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46278);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            E = new a(null);
        }
    }

    public C2CFileSearchDialogViewModel(@NotNull String peerId) {
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) peerId);
        } else {
            this.peerId = peerId;
            this.resource = new C2CFileSearchDataSource(ViewModelKt.getViewModelScope(this));
        }
    }

    private final void Q1(String keyword) {
        FlowKt.launchIn(FlowKt.onEach(this.resource.m(1, this.peerId, keyword), new C2CFileSearchDialogViewModel$searchByKeyword$1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void R1() {
        this.resource.k();
    }

    public final void M1(@NotNull a.C9536a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.resource.i(intent.a(), intent.b());
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.a getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.b.f353642a;
    }

    @NotNull
    public final String O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.peerId;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel.a userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof a.d) {
            Q1(((a.d) userIntent).a());
        } else if (userIntent instanceof a.c) {
            R1();
        } else if (userIntent instanceof a.C9536a) {
            M1((a.C9536a) userIntent);
        }
    }
}
