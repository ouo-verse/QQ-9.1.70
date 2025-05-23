package com.tencent.mobileqq.troop.troopcard.reborn.repo.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/model/a;", "", "", "a", "I", "()I", "errCode", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;", "rsp", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int errCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GetGroupLatestEssenceListRsp rsp;

    public a(int i3, @NotNull String errMsg, @Nullable GetGroupLatestEssenceListRsp getGroupLatestEssenceListRsp) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errMsg, getGroupLatestEssenceListRsp);
            return;
        }
        this.errCode = i3;
        this.errMsg = errMsg;
        this.rsp = getGroupLatestEssenceListRsp;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.errCode;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.errMsg;
    }

    @Nullable
    public final GetGroupLatestEssenceListRsp c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (GetGroupLatestEssenceListRsp) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.rsp;
    }
}
