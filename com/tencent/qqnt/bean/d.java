package com.tencent.qqnt.bean;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBeatRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/bean/d;", "", "", "b", "", "toString", "Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "a", "Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "()Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "setFunctionLockBeatRsp", "(Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;)V", "functionLockBeatRsp", "", "securityTrans", "<init>", "([B)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FunctionLockMsg$FunctionLockBeatRsp functionLockBeatRsp;

    public d(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
            return;
        }
        if (bArr != null) {
            FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp = new FunctionLockMsg$FunctionLockBeatRsp();
            this.functionLockBeatRsp = functionLockMsg$FunctionLockBeatRsp;
            try {
                functionLockMsg$FunctionLockBeatRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.e("JoinTroopHint", 1, "[JoinTroopKaiYangTransInfo] parse error");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Nullable
    public final FunctionLockMsg$FunctionLockBeatRsp a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FunctionLockMsg$FunctionLockBeatRsp) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.functionLockBeatRsp;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.functionLockBeatRsp != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        String str;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp = this.functionLockBeatRsp;
        if (functionLockMsg$FunctionLockBeatRsp != null && (pBStringField = functionLockMsg$FunctionLockBeatRsp.wording) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        return "wording:" + str;
    }
}
