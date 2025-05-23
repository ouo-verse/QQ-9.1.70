package com.tencent.gcloud;

import androidx.core.content.FileProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes6.dex */
public class ApolloProvider extends FileProvider {
    static IPatchRedirector $redirector_;

    public ApolloProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
