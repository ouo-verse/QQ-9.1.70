package com.tencent.qqnt.chathistory.business;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chathistory/business/d;", "Lcom/tencent/qqnt/chathistory/business/TroopHistoryViewModel;", "", "L1", "category", "Lkotlin/Pair;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "N1", "", "peerId", "sessionName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d extends TroopHistoryViewModel {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull String peerId, @Nullable String str) {
        super(peerId, str, false, 4, null);
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) peerId, (Object) str);
        }
    }

    @Override // com.tencent.qqnt.chathistory.business.TroopHistoryViewModel, com.tencent.qqnt.chathistory.business.a
    public int L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.qqnt.chathistory.business.TroopHistoryViewModel, com.tencent.qqnt.chathistory.business.a
    @NotNull
    public Pair<Integer, BaseHistoryFragment<?>> N1(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, category);
        }
        if (category == 2) {
            return TuplesKt.to(Integer.valueOf(R.string.a1f), new ChatHistoryStickerFragment(0, 1, null));
        }
        return super.N1(category);
    }
}
