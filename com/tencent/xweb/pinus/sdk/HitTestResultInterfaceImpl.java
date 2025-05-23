package com.tencent.xweb.pinus.sdk;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.luggage.wxa.ar.g0;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HitTestResultInterfaceImpl implements HitTestResultInterface {
    private static final String TAG = "HitTestResultInterfaceImpl";
    private g0 getExtraMethod;
    private g0 getTypeMethod;
    private final Object inner;

    public HitTestResultInterfaceImpl(Object obj) {
        this.inner = obj;
    }

    private synchronized g0 getGetExtraMethod() {
        g0 g0Var;
        g0Var = this.getExtraMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getExtra", new Class[0]);
            this.getExtraMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetTypeMethod() {
        g0 g0Var;
        g0Var = this.getTypeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getType", new Class[0]);
            this.getTypeMethod = g0Var;
        }
        return g0Var;
    }

    @SuppressLint({"LongLogTag"})
    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.HitTestResultInterface
    public String getExtra() {
        try {
            return (String) getGetExtraMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.HitTestResultInterface
    public int getType() {
        try {
            return ((Integer) getGetTypeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }
}
