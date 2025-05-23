package com.tencent.mobileqq.qqlive.anchor.beauty.ui.select;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes17.dex */
public interface SelectPanelClickListener {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes17.dex */
    public static final class SelectAction {
        private static final /* synthetic */ SelectAction[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SelectAction CLICK_BEAUTY;
        public static final SelectAction CLICK_PROP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55147);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            SelectAction selectAction = new SelectAction("CLICK_BEAUTY", 0);
            CLICK_BEAUTY = selectAction;
            SelectAction selectAction2 = new SelectAction("CLICK_PROP", 1);
            CLICK_PROP = selectAction2;
            $VALUES = new SelectAction[]{selectAction, selectAction2};
        }

        SelectAction(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static SelectAction valueOf(String str) {
            return (SelectAction) Enum.valueOf(SelectAction.class, str);
        }

        public static SelectAction[] values() {
            return (SelectAction[]) $VALUES.clone();
        }
    }

    void a(Activity activity, SelectAction selectAction);
}
