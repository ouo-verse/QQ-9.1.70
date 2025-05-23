package com.tencent.qqnt.chats.core.ui.third.p013const;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "", "(Ljava/lang/String;I)V", "SP_CARE", "KEYWORD", "LITTLE_EAR", "TIANSHU_AD", "DEFAULT", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class ThirdViewEnum {
    private static final /* synthetic */ ThirdViewEnum[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ThirdViewEnum DEFAULT;
    public static final ThirdViewEnum KEYWORD;
    public static final ThirdViewEnum LITTLE_EAR;
    public static final ThirdViewEnum SP_CARE;
    public static final ThirdViewEnum TIANSHU_AD;

    private static final /* synthetic */ ThirdViewEnum[] $values() {
        return new ThirdViewEnum[]{SP_CARE, KEYWORD, LITTLE_EAR, TIANSHU_AD, DEFAULT};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SP_CARE = new ThirdViewEnum("SP_CARE", 0);
        KEYWORD = new ThirdViewEnum("KEYWORD", 1);
        LITTLE_EAR = new ThirdViewEnum("LITTLE_EAR", 2);
        TIANSHU_AD = new ThirdViewEnum("TIANSHU_AD", 3);
        DEFAULT = new ThirdViewEnum("DEFAULT", 4);
        $VALUES = $values();
    }

    ThirdViewEnum(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ThirdViewEnum valueOf(String str) {
        return (ThirdViewEnum) Enum.valueOf(ThirdViewEnum.class, str);
    }

    public static ThirdViewEnum[] values() {
        return (ThirdViewEnum[]) $VALUES.clone();
    }
}
