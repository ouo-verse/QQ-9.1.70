package com.tencent.xweb.pinus.sdk;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JsResultInterfaceImpl implements JsResultInterface {
    private static final String TAG = "JsResultInterfaceImpl";
    private g0 cancelMethod;
    private g0 confirmMethod;
    private g0 confirmStringMethod;
    private final Object inner;

    public JsResultInterfaceImpl(Object obj) {
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

    private synchronized g0 getConfirmMethod() {
        g0 g0Var;
        g0Var = this.confirmMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, new Class[0]);
            this.confirmMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getConfirmStringMethod() {
        g0 g0Var;
        g0Var = this.confirmStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, String.class);
            this.confirmStringMethod = g0Var;
        }
        return g0Var;
    }

    @SuppressLint({"LongLogTag"})
    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.JsResultInterface
    public void cancel() {
        try {
            getCancelMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.JsResultInterface
    public void confirm() {
        try {
            getConfirmMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.JsResultInterface
    public void confirm(String str) {
        try {
            getConfirmStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }
}
