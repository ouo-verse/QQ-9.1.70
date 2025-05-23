package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/emotion/utils/q;", "", "", "businessChatType", "", "a", "<init>", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f356700a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FILED_LOVE_LANGUAGE_MARK);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f356700a = new q();
        }
    }

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(int businessChatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, businessChatType);
        }
        if (businessChatType != 1) {
            if (businessChatType != 2) {
                if (businessChatType != 109 && businessChatType != 117) {
                    switch (businessChatType) {
                        default:
                            switch (businessChatType) {
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                    break;
                                default:
                                    return "4";
                            }
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                            return "3";
                    }
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }
}
