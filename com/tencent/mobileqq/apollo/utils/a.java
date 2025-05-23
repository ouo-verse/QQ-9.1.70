package com.tencent.mobileqq.apollo.utils;

import android.util.Log;
import com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a() {
        try {
            return ((IApolloClassFactory) QRoute.api(IApolloClassFactory.class)).getApolloExtensionHandlerClassName();
        } catch (Throwable th5) {
            Log.e("ApolloClassFactoryApi", "[getApolloExtensionHandlerClassName]", th5);
            return null;
        }
    }

    public static Class b() {
        try {
            return ((IApolloClassFactory) QRoute.api(IApolloClassFactory.class)).getApolloExtensionServletClass();
        } catch (Throwable th5) {
            Log.e("ApolloClassFactoryApi", "[getApolloExtensionServletClass]", th5);
            return null;
        }
    }
}
