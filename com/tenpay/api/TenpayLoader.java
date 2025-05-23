package com.tenpay.api;

import android.content.Context;
import com.tenpay.QwLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayLoader {
    private static final String TAG = "TenpayLoader";

    private Object loadCls(Context context, String str) throws Exception {
        QwLog.i("load new cls : " + str);
        try {
            return context.getClassLoader().loadClass(str).newInstance();
        } catch (Exception unused) {
            return Class.forName(str).newInstance();
        }
    }

    public <T> T getObject(Context context, String str) throws Exception {
        QwLog.i("get object : " + str);
        return (T) loadCls(context, str);
    }
}
