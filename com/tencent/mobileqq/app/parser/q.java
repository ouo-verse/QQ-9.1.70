package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ElderModeFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q extends av {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a extends com.tencent.mobileqq.utils.ax {
        static IPatchRedirector $redirector_;

        protected a(BaseQQAppInterface baseQQAppInterface, Context context) {
            super(baseQQAppInterface, context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.utils.ax
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            QPublicFragmentActivity.b.b(this.f307437b, new Intent(), QPublicFragmentActivity.class, ElderModeFragment.class);
            return true;
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        return new a(baseQQAppInterface, context);
    }
}
