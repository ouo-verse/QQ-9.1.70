package com.tencent.mobileqq.tianshu;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState", "", "Lcom/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState;", "", "value", "<init>", "(Ljava/lang/String;II)V", "UN_KNOW", "LOCAL", "NET", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TianshuConstants$RedDataChangeState {
    private static final /* synthetic */ TianshuConstants$RedDataChangeState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TianshuConstants$RedDataChangeState LOCAL;
    public static final TianshuConstants$RedDataChangeState NET;
    public static final TianshuConstants$RedDataChangeState UN_KNOW;

    private static final /* synthetic */ TianshuConstants$RedDataChangeState[] $values() {
        return new TianshuConstants$RedDataChangeState[]{UN_KNOW, LOCAL, NET};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        UN_KNOW = new TianshuConstants$RedDataChangeState("UN_KNOW", 0, 0);
        LOCAL = new TianshuConstants$RedDataChangeState("LOCAL", 1, 1);
        NET = new TianshuConstants$RedDataChangeState("NET", 2, 2);
        $VALUES = $values();
    }

    TianshuConstants$RedDataChangeState(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public static TianshuConstants$RedDataChangeState valueOf(String str) {
        return (TianshuConstants$RedDataChangeState) Enum.valueOf(TianshuConstants$RedDataChangeState.class, str);
    }

    public static TianshuConstants$RedDataChangeState[] values() {
        return (TianshuConstants$RedDataChangeState[]) $VALUES.clone();
    }
}
