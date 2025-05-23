package com.tencent.qqnt.aio.settings;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public /* synthetic */ class NTFriendSettingHelper$clearMsgRecords$1 extends FunctionReferenceImpl implements Function1<NTFriendSettingHelper.a, Boolean> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NTFriendSettingHelper$clearMsgRecords$1(Object obj) {
        super(1, obj, NTFriendSettingHelper.class, "checkParamsInvalid", "checkParamsInvalid(Lcom/tencent/qqnt/aio/settings/NTFriendSettingHelper$ParamsBean;)Z", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull NTFriendSettingHelper.a p06) {
        boolean r16;
        Intrinsics.checkNotNullParameter(p06, "p0");
        r16 = ((NTFriendSettingHelper) this.receiver).r(p06);
        return Boolean.valueOf(r16);
    }
}
