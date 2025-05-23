package com.tencent.xweb.pinus.sdk;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.luggage.wxa.ar.g0;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HttpAuthHandlerInterfaceImpl implements HttpAuthHandlerInterface {
    private static final String TAG = "HttpAuthHandlerInterfaceImpl";
    private g0 cancelMethod;
    private final Object inner;
    private g0 proceedStringStringMethod;
    private g0 useHttpAuthUsernamePasswordMethod;

    public HttpAuthHandlerInterfaceImpl(Object obj) {
        this.inner = obj;
    }

    private synchronized g0 getCancelMethod() {
        g0 g0Var;
        g0Var = this.cancelMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "cancel", new Class[0]);
            this.cancelMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getProceedStringStringMethod() {
        g0 g0Var;
        g0Var = this.proceedStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "proceed", String.class, String.class);
            this.proceedStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getUseHttpAuthUsernamePasswordMethod() {
        g0 g0Var;
        g0Var = this.useHttpAuthUsernamePasswordMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "useHttpAuthUsernamePassword", new Class[0]);
            this.useHttpAuthUsernamePasswordMethod = g0Var;
        }
        return g0Var;
    }

    @SuppressLint({"LongLogTag"})
    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface
    public void cancel() {
        try {
            getCancelMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface
    public void proceed(String str, String str2) {
        try {
            getProceedStringStringMethod().a(str, str2);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface
    public boolean useHttpAuthUsernamePassword() {
        try {
            return ((Boolean) getUseHttpAuthUsernamePasswordMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }
}
