package com.tencent.xweb.pinus.sdk;

import android.util.Log;
import com.tencent.luggage.wxa.ar.g0;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SslErrorHandlerInterfaceImpl implements SslErrorHandlerInterface {
    private static final String TAG = "SslErrHandlerInterface";
    private g0 cancelMethod;
    private final Object inner;
    private g0 proceedMethod;

    public SslErrorHandlerInterfaceImpl(Object obj) {
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

    private synchronized g0 getProceedMethod() {
        g0 g0Var;
        g0Var = this.proceedMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "proceed", new Class[0]);
            this.proceedMethod = g0Var;
        }
        return g0Var;
    }

    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.SslErrorHandlerInterface
    public void cancel() {
        try {
            getCancelMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.SslErrorHandlerInterface
    public void proceed() {
        try {
            getProceedMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }
}
