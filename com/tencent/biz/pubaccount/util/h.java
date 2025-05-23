package com.tencent.biz.pubaccount.util;

import android.util.Log;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h {
    public static String a() {
        try {
            return ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountArticleHandler.class);
        } catch (Throwable th5) {
            Log.w("PublicAccountClassApi", "getPublicAccountArticleHandlerClassName", th5);
            return "";
        }
    }

    public static String b() {
        try {
            return ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountHandler.class);
        } catch (Throwable th5) {
            Log.w("PublicAccountClassApi", "getPublicAccountHandlerClassName", th5);
            return "";
        }
    }
}
