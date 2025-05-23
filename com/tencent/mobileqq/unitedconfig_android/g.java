package com.tencent.mobileqq.unitedconfig_android;

import com.tencent.freesia.IKVBridgeCreator;
import com.tencent.freesia.KVBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/g;", "Lcom/tencent/freesia/IKVBridgeCreator;", "", "uin", "Lcom/tencent/freesia/KVBridge;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g implements IKVBridgeCreator {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.IKVBridgeCreator
    @NotNull
    public KVBridge create(@NotNull String uin) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (KVBridge) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (uin.length() > 4) {
            String substring = uin.substring(0, uin.length() - 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            str = substring + "****";
        } else {
            str = uin;
        }
        QLog.d("FreesiaKV", 1, "create: " + str);
        return new i(uin);
    }
}
