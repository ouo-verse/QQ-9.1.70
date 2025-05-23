package com.tencent.qqnt.chathistory.ui.sticker.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.sticker.data.a;
import com.tencent.qqnt.chathistory.ui.sticker.data.b;
import com.tencent.qqnt.chathistory.ui.sticker.data.datasource.PlatformSearchStickerSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/viewmodel/ChatStickerViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/a;", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/b;", "userIntent", "", "T1", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/datasource/PlatformSearchStickerSource;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/ui/sticker/data/datasource/PlatformSearchStickerSource;", "platformDataSource", "S1", "()Lcom/tencent/qqnt/chathistory/ui/sticker/data/b;", "mNoneValueIntent", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatStickerViewModel extends BaseHistoryViewModel<a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final PlatformSearchStickerSource platformDataSource;

    public ChatStickerViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.platformDataSource = new PlatformSearchStickerSource();
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.c.f353904a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.C9552b) {
            FlowKt.launchIn(FlowKt.onEach(this.platformDataSource.b(M1(), N1(), ((b.C9552b) userIntent).a()), new ChatStickerViewModel$handleIntent$1(this, userIntent, null)), ViewModelKt.getViewModelScope(this));
        } else if (userIntent instanceof b.a) {
            b.a aVar = (b.a) userIntent;
            FlowKt.launchIn(FlowKt.onEach(this.platformDataSource.c(M1(), N1(), aVar.a(), aVar.c(), aVar.b(), aVar.d()), new ChatStickerViewModel$handleIntent$2(this, userIntent, null)), ViewModelKt.getViewModelScope(this));
        }
    }
}
