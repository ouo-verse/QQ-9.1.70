package com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.a;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.b;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.datasource.PlatformSearchFileSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$b;", "userIntent", "", "T1", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$a;", "S1", "W1", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/datasource/PlatformSearchFileSource;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/datasource/PlatformSearchFileSource;", "resource", "U1", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a;", "mNoneValueIntent", "<init>", "()V", "G", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryFileModel extends BaseHistoryViewModel<b, com.tencent.qqnt.chathistory.ui.file.c2c.data.a> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a G;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final PlatformSearchFileSource resource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46287);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            G = new a(null);
        }
    }

    public ChatHistoryFileModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.resource = new PlatformSearchFileSource(ViewModelKt.getViewModelScope(this));
        }
    }

    private final void S1(a.C9533a userIntent) {
        FlowKt.launchIn(FlowKt.onEach(PlatformSearchFileSource.c(this.resource, M1(), N1(), 0L, 0L, 0L, userIntent.b(), userIntent.a(), 28, null), new ChatHistoryFileModel$fetchFile$1(this, userIntent, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void T1(a.b userIntent) {
        FlowKt.launchIn(FlowKt.onEach(this.resource.b(M1(), N1(), userIntent.a(), userIntent.c(), userIntent.b(), userIntent.e(), userIntent.d()), new ChatHistoryFileModel$fetchMoreFile$1(this, userIntent, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.chathistory.ui.file.c2c.data.a getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chathistory.ui.file.c2c.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.c.f353568a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.chathistory.ui.file.c2c.data.a userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof a.C9533a) {
            S1((a.C9533a) userIntent);
        } else if (userIntent instanceof a.b) {
            T1((a.b) userIntent);
        }
    }
}
