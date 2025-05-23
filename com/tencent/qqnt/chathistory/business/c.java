package com.tencent.qqnt.chathistory.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chathistory/business/c;", "Lcom/tencent/qqnt/chathistory/business/C2CHistoryViewModel;", "", "L1", "G", "I", "getChatType", "()I", "chatType", "", "peerId", "sessionName", "", "fromStorageScan", "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c extends C2CHistoryViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    private final int chatType;

    public /* synthetic */ c(int i3, String str, String str2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, (i16 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // com.tencent.qqnt.chathistory.business.C2CHistoryViewModel, com.tencent.qqnt.chathistory.business.a
    public int L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.chatType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i3, @NotNull String peerId, @Nullable String str, boolean z16) {
        super(peerId, str, z16);
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.chatType = i3;
        } else {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), peerId, str, Boolean.valueOf(z16));
        }
    }
}
