package com.tencent.image.api;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class ITool {
    static IPatchRedirector $redirector_;
    URLStreamHandlerFactory defaultHandlerFactory;

    public ITool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.defaultHandlerFactory = new URLStreamHandlerFactory() { // from class: com.tencent.image.api.ITool.1
                static IPatchRedirector $redirector_;
                URLStreamHandler handler;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ITool.this);
                    } else {
                        this.handler = new URLStreamHandler() { // from class: com.tencent.image.api.ITool.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.net.URLStreamHandler
                            protected URLConnection openConnection(URL url) throws IOException {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    return (URLConnection) iPatchRedirector3.redirect((short) 2, (Object) this, (Object) url);
                                }
                                return null;
                            }
                        };
                    }
                }

                @Override // java.net.URLStreamHandlerFactory
                public URLStreamHandler createURLStreamHandler(String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (URLStreamHandler) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    }
                    if ("http".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str) || "file".equalsIgnoreCase(str) || HttpMsg.FILE_JAR.equalsIgnoreCase(str)) {
                        return null;
                    }
                    return this.handler;
                }
            };
        }
    }

    public abstract Context getContext();

    public abstract URLStreamHandlerFactory getFactory();

    public void initURLStreamHandlerFactory() {
        ILog iLog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        URLStreamHandlerFactory factory = getFactory();
        if (factory == null) {
            factory = this.defaultHandlerFactory;
        }
        try {
            URL.setURLStreamHandlerFactory(factory);
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (URLDrawable.depImp != null) {
                iLog = URLDrawable.depImp.mLog;
            } else {
                iLog = null;
            }
            if (iLog != null) {
                iLog.e("initURLStreamHandlerFactory", 1, "setURLStreamHandlerFactory fail", th5);
            }
            try {
                Field declaredField = URL.class.getDeclaredField("factory");
                declaredField.setAccessible(true);
                URLStreamHandlerFactory uRLStreamHandlerFactory = (URLStreamHandlerFactory) declaredField.get(null);
                if (iLog != null) {
                    iLog.e("initURLStreamHandlerFactory", 1, uRLStreamHandlerFactory.toString(), th5);
                }
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
    }

    public abstract boolean loadSoByName(Context context, String str);
}
