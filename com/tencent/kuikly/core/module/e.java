package com.tencent.kuikly.core.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/module/e;", "Lcom/tencent/kuikly/core/module/Module;", "", "key", "", "value", "", "e", "a", "c", "g", "f", "b", "d", "moduleName", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends Module {
    public final byte[] a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return b(key);
    }

    public final byte[] b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object syncToNativeMethod = syncToNativeMethod("getByteArrayItem", new Object[]{key}, (Function1<Object, Unit>) null);
        byte[] bArr = syncToNativeMethod instanceof byte[] ? (byte[]) syncToNativeMethod : null;
        return bArr == null ? new byte[0] : bArr;
    }

    public final String c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object syncToNativeMethod = syncToNativeMethod("getStringItem", new Object[]{key}, (Function1<Object, Unit>) null);
        String str = syncToNativeMethod instanceof String ? (String) syncToNativeMethod : null;
        return str == null ? "" : str;
    }

    public final void d(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        syncToNativeMethod("removeItem", new Object[]{key}, (Function1<Object, Unit>) null);
    }

    public final void e(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        f(key, value);
    }

    public final void f(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        syncToNativeMethod("setByteArrayItem", new Object[]{key, value}, (Function1<Object, Unit>) null);
    }

    public final void g(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        syncToNativeMethod("setStringItem", new Object[]{key, value}, (Function1<Object, Unit>) null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRDiskCacheModule";
    }
}
