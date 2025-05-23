package com.tencent.qqnt.chathistory.ui.test;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.base.mvi.b;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/test/a;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/base/mvi/a;", "Lcom/tencent/qqnt/base/mvi/b;", "userIntent", "", "handleIntent", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/base/mvi/b;", "getMNoneValueIntent", "()Lcom/tencent/qqnt/base/mvi/b;", "mNoneValueIntent", "<init>", "(Lcom/tencent/qqnt/base/mvi/b;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends BaseHistoryViewModel<com.tencent.qqnt.base.mvi.a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    public a(@NotNull b mNoneValueIntent) {
        Intrinsics.checkNotNullParameter(mNoneValueIntent, "mNoneValueIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mNoneValueIntent);
        } else {
            this.mNoneValueIntent = mNoneValueIntent;
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
        } else {
            Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        }
    }
}
