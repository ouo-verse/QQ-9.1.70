package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ac extends av {
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
            PublicFragmentActivity.start(this.f307437b, GameMsgBoxFragment.class);
            return true;
        }
    }

    public ac() {
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
        if (QLog.isColorLevel()) {
            QLog.d("GameMsgBoxParser", 2, "parse\uff1a" + str);
        }
        a aVar = new a(baseQQAppInterface, context);
        aVar.f307438c = str;
        if (jumpParserResult != null) {
            aVar.f307439d = jumpParserResult.getServer();
            aVar.f307440e = jumpParserResult.getAction();
            aVar.s(jumpParserResult.getParamMap());
        }
        return aVar;
    }
}
