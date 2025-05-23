package com.tencent.luggage.wxa.ol;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface t0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static t0 a(Context context) {
            Context baseContext;
            if (context == 0) {
                return null;
            }
            if (context instanceof t0) {
                return (t0) context;
            }
            if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
                return null;
            }
            return a(baseContext);
        }
    }

    boolean a();

    void d();

    void e();

    Activity f();

    void hideVKB(View view);
}
