package com.tencent.xweb.pinus.sdk;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.luggage.wxa.ar.g0;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebResourceErrorInterfaceImpl implements WebResourceErrorInterface {
    private static final String TAG = "WebResourceErrorInterfaceImpl";
    private g0 getDescriptionMethod;
    private g0 getErrorCodeMethod;
    private final Object inner;

    public WebResourceErrorInterfaceImpl(Object obj) {
        this.inner = obj;
    }

    private synchronized g0 getGetDescriptionMethod() {
        g0 g0Var;
        g0Var = this.getDescriptionMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDescription", new Class[0]);
            this.getDescriptionMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetErrorCodeMethod() {
        g0 g0Var;
        g0Var = this.getErrorCodeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getErrorCode", new Class[0]);
            this.getErrorCodeMethod = g0Var;
        }
        return g0Var;
    }

    @SuppressLint({"LongLogTag"})
    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebResourceErrorInterface
    public CharSequence getDescription() {
        try {
            return (CharSequence) getGetDescriptionMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebResourceErrorInterface
    public int getErrorCode() {
        try {
            return ((Integer) getGetErrorCodeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }
}
