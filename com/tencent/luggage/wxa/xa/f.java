package com.tencent.luggage.wxa.xa;

import android.util.Log;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends JSONException {
    public f(String str) {
        super(str);
    }

    public f(Throwable th5) {
        super(Log.getStackTraceString(th5));
    }
}
