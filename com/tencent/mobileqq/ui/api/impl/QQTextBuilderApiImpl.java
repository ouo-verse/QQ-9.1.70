package com.tencent.mobileqq.ui.api.impl;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.ui.api.IQQTextBuilderApi;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QQTextBuilderApiImpl implements IQQTextBuilderApi {
    static IPatchRedirector $redirector_;

    public QQTextBuilderApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ui.api.IQQTextBuilderApi
    public String toPlainText(SpannableStringBuilder spannableStringBuilder) {
        QQTextBuilder qQTextBuilder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) spannableStringBuilder);
        }
        if ((spannableStringBuilder instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) spannableStringBuilder) != null) {
            return qQTextBuilder.toPlainText();
        }
        return null;
    }
}
