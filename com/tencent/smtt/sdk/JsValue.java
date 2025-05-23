package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JsValue {

    /* renamed from: a, reason: collision with root package name */
    private final JsContext f368971a;

    /* renamed from: b, reason: collision with root package name */
    private final IX5JsValue f368972b;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class a implements IX5JsValue.JsValueFactory {
        a() {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public String getJsValueClassName() {
            return JsValue.class.getName();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public IX5JsValue unwrap(Object obj) {
            if (obj != null && (obj instanceof JsValue)) {
                return ((JsValue) obj).f368972b;
            }
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public Object wrap(IX5JsValue iX5JsValue) {
            JsContext current;
            if (iX5JsValue != null && (current = JsContext.current()) != null) {
                return new JsValue(current, iX5JsValue);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JsValue(JsContext jsContext, IX5JsValue iX5JsValue) {
        this.f368971a = jsContext;
        this.f368972b = iX5JsValue;
    }

    public JsValue call(Object... objArr) {
        return a(this.f368972b.call(objArr));
    }

    public JsValue construct(Object... objArr) {
        return a(this.f368972b.construct(objArr));
    }

    public JsContext context() {
        return this.f368971a;
    }

    public boolean isArray() {
        return this.f368972b.isArray();
    }

    public boolean isArrayBufferOrArrayBufferView() {
        return this.f368972b.isArrayBufferOrArrayBufferView();
    }

    public boolean isBoolean() {
        return this.f368972b.isBoolean();
    }

    public boolean isFunction() {
        return this.f368972b.isFunction();
    }

    public boolean isInteger() {
        return this.f368972b.isInteger();
    }

    public boolean isJavascriptInterface() {
        return this.f368972b.isJavascriptInterface();
    }

    public boolean isNull() {
        return this.f368972b.isNull();
    }

    public boolean isNumber() {
        return this.f368972b.isNumber();
    }

    public boolean isObject() {
        return this.f368972b.isObject();
    }

    public boolean isPromise() {
        return this.f368972b.isPromise();
    }

    public boolean isString() {
        return this.f368972b.isString();
    }

    public boolean isUndefined() {
        return this.f368972b.isUndefined();
    }

    public void reject(Object obj) {
        this.f368972b.resolveOrReject(obj, false);
    }

    public void resolve(Object obj) {
        this.f368972b.resolveOrReject(obj, true);
    }

    public boolean toBoolean() {
        return this.f368972b.toBoolean();
    }

    public ByteBuffer toByteBuffer() {
        return this.f368972b.toByteBuffer();
    }

    public int toInteger() {
        return this.f368972b.toInteger();
    }

    public Object toJavascriptInterface() {
        return this.f368972b.toJavascriptInterface();
    }

    public Number toNumber() {
        return this.f368972b.toNumber();
    }

    public <T> T toObject(Class<T> cls) {
        return (T) this.f368972b.toObject(cls);
    }

    public String toString() {
        return this.f368972b.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static IX5JsValue.JsValueFactory a() {
        return new a();
    }

    private JsValue a(IX5JsValue iX5JsValue) {
        if (iX5JsValue == null) {
            return null;
        }
        return new JsValue(this.f368971a, iX5JsValue);
    }
}
