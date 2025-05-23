package com.tencent.mobileqq.app.multilanguage;

import android.content.res.Resources;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DelegateResources extends Resources {
    static IPatchRedirector $redirector_;
    private QQResourcesImpl mQQResourcesImpl;

    public DelegateResources(QQResourcesImpl qQResourcesImpl) {
        super(qQResourcesImpl.getDefaultResource().getAssets(), qQResourcesImpl.getDefaultResource().getDisplayMetrics(), qQResourcesImpl.getDefaultResource().getConfiguration());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQResourcesImpl);
        } else {
            this.mQQResourcesImpl = qQResourcesImpl;
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) throws Resources.NotFoundException {
        CharSequence text;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        int multiLangResid = this.mQQResourcesImpl.getMultiLangResid(i3);
        try {
            if (multiLangResid > 0) {
                text = this.mQQResourcesImpl.getMultiLangResource().getText(multiLangResid);
            } else {
                text = this.mQQResourcesImpl.getDefaultResource().getText(i3);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(MultiLanguageEngine.TAG, 4, "getText delegate:", Integer.valueOf(i3), " ,langId:", Integer.valueOf(multiLangResid), " ,content:" + ((Object) text));
                return text;
            }
            return text;
        } catch (Resources.NotFoundException unused) {
            return this.mQQResourcesImpl.getDefaultResource().getText(i3);
        }
    }
}
