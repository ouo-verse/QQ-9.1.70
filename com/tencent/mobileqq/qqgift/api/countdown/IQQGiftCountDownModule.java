package com.tencent.mobileqq.qqgift.api.countdown;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import nh2.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IQQGiftCountDownModule extends a {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class CountDownStrategy {
        private static final /* synthetic */ CountDownStrategy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CountDownStrategy COUNT_DOWN_PANEL;
        public static final CountDownStrategy COUNT_DOWN_ROOM;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29062);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CountDownStrategy countDownStrategy = new CountDownStrategy("COUNT_DOWN_ROOM", 0);
            COUNT_DOWN_ROOM = countDownStrategy;
            CountDownStrategy countDownStrategy2 = new CountDownStrategy("COUNT_DOWN_PANEL", 1);
            COUNT_DOWN_PANEL = countDownStrategy2;
            $VALUES = new CountDownStrategy[]{countDownStrategy, countDownStrategy2};
        }

        CountDownStrategy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CountDownStrategy valueOf(String str) {
            return (CountDownStrategy) Enum.valueOf(CountDownStrategy.class, str);
        }

        public static CountDownStrategy[] values() {
            return (CountDownStrategy[]) $VALUES.clone();
        }
    }

    void enterRoom();

    void exitRoom();

    void j(CountDownStrategy countDownStrategy);

    CountDownStrategy q();
}
