package com.tencent.kuikly.core.render.android.expand.module;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import d01.w;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002JI\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\u0004\u0018\u0001`\u0019H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/f;", "Li01/e;", "", "params", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "o", "d", "Landroid/content/Context;", "context", "cacheKey", "cacheData", "c", "", "a", "g", "i", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class f extends i01.e {
    private final void a(Context context, String cacheKey, byte[] cacheData) {
        String i3 = i(cacheKey, context);
        File file = new File(i3);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FilesKt__FileReadWriteKt.writeBytes(file, cacheData);
        } catch (Throwable th5) {
            w.f392617a.b("KRDiskCacheModule", "cacheByteArrayToDiskFileWithKey write data error: " + i3 + ", " + cacheKey + ", " + th5);
            file.deleteOnExit();
        }
    }

    private final void c(Context context, String cacheKey, String cacheData) {
        String i3 = i(cacheKey, context);
        File file = new File(i3);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FilesKt__FileReadWriteKt.writeText$default(file, cacheData, null, 2, null);
        } catch (Throwable th5) {
            w.f392617a.b("KRDiskCacheModule", "cacheStringToDiskFileWithKey write data error: " + i3 + ", " + cacheKey + ", " + th5);
            file.deleteOnExit();
        }
    }

    private final Object d(Object params) {
        boolean z16;
        Context context = getContext();
        if (context == null) {
            w.f392617a.b("KRDiskCacheModule", "getByteArrayItem: context is null");
            return new byte[0];
        }
        if (!(params instanceof Object[])) {
            params = null;
        }
        Object[] objArr = (Object[]) params;
        if (objArr == null) {
            w.f392617a.b("KRDiskCacheModule", "getByteArrayItem: param is not array");
            return new byte[0];
        }
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            w.f392617a.b("KRDiskCacheModule", "getByteArrayItem: param count < 1");
            return new byte[0];
        }
        Object obj = objArr[0];
        if (obj != null) {
            return g(context, (String) obj);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final byte[] g(Context context, String cacheKey) {
        byte[] readBytes;
        File file = new File(i(cacheKey, context));
        if (file.exists()) {
            readBytes = FilesKt__FileReadWriteKt.readBytes(file);
            return readBytes;
        }
        return new byte[0];
    }

    private final String i(String cacheKey, Context context) {
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        String str = filesDir.getAbsolutePath() + "/kt_disk_cache";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            w.f392617a.b("KRDiskCacheModule", "Error creating kt_disk_cache directory");
        }
        return str + '/' + e.INSTANCE.a(cacheKey);
    }

    private final String j(Object params) {
        boolean z16;
        String decodeToString;
        Context context = getContext();
        if (context == null) {
            w.f392617a.b("KRDiskCacheModule", "context is null");
            return "";
        }
        if (!(params instanceof Object[])) {
            params = null;
        }
        Object[] objArr = (Object[]) params;
        if (objArr == null) {
            w.f392617a.b("KRDiskCacheModule", "param is not array");
            return "";
        }
        boolean z17 = true;
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            w.f392617a.b("KRDiskCacheModule", "param count < 1");
            return "";
        }
        Object obj = objArr[0];
        if (obj != null) {
            byte[] g16 = g(context, (String) obj);
            if (g16.length != 0) {
                z17 = false;
            }
            if (!z17) {
                decodeToString = StringsKt__StringsJVMKt.decodeToString(g16);
                return decodeToString;
            }
            return "";
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void l(Object params) {
        boolean z16;
        Context context = getContext();
        if (context == null) {
            w.f392617a.b("KRDiskCacheModule", "removeItem context is null");
            return;
        }
        if (!(params instanceof Object[])) {
            params = null;
        }
        Object[] objArr = (Object[]) params;
        if (objArr == null) {
            w.f392617a.b("KRDiskCacheModule", "removeItem param is not array");
            return;
        }
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            w.f392617a.b("KRDiskCacheModule", "removeItem param count < 1");
            return;
        }
        Object obj = objArr[0];
        if (obj != null) {
            File file = new File(i((String) obj, context));
            if (file.exists()) {
                file.delete();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void m(Object params) {
        Object obj;
        Object orNull;
        Object orNull2;
        Context context = getContext();
        if (context == null) {
            w.f392617a.b("KRDiskCacheModule", "setByteArrayItem: context is null");
            return;
        }
        Object obj2 = null;
        if (!(params instanceof Object[])) {
            obj = null;
        } else {
            obj = params;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr == null) {
            w.f392617a.b("KRDiskCacheModule", "setByteArrayItem: param is not array");
            return;
        }
        if (objArr.length < 2) {
            w.f392617a.b("KRDiskCacheModule", "setByteArrayItem: param count < 2");
            return;
        }
        boolean z16 = false;
        orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
        if (!(orNull instanceof String)) {
            orNull = null;
        }
        String str = (String) orNull;
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            orNull2 = ArraysKt___ArraysKt.getOrNull((Object[]) params, 1);
            if (orNull2 instanceof byte[]) {
                obj2 = orNull2;
            }
            byte[] bArr = (byte[]) obj2;
            if (bArr == null) {
                w.f392617a.b("KRDiskCacheModule", "setByteArrayItem: cache Data is null");
                return;
            } else {
                a(context, str, bArr);
                return;
            }
        }
        w.f392617a.b("KRDiskCacheModule", "setByteArrayItem: cache key is null or empty");
    }

    private final void o(Object params) {
        Object obj;
        Object orNull;
        Object orNull2;
        Context context = getContext();
        if (context == null) {
            w.f392617a.b("KRDiskCacheModule", "setStringItem: context is null");
            return;
        }
        Object obj2 = null;
        if (!(params instanceof Object[])) {
            obj = null;
        } else {
            obj = params;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr == null) {
            w.f392617a.b("KRDiskCacheModule", "setStringItem: param is not array");
            return;
        }
        if (objArr.length < 2) {
            w.f392617a.b("KRDiskCacheModule", "setStringItem: param count < 2");
            return;
        }
        boolean z16 = false;
        orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
        if (!(orNull instanceof String)) {
            orNull = null;
        }
        String str = (String) orNull;
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            orNull2 = ArraysKt___ArraysKt.getOrNull((Object[]) params, 1);
            if (orNull2 instanceof String) {
                obj2 = orNull2;
            }
            String str2 = (String) obj2;
            if (str2 == null) {
                w.f392617a.b("KRDiskCacheModule", "setStringItem: cache Data is null");
                return;
            } else {
                c(context, str, str2);
                return;
            }
        }
        w.f392617a.b("KRDiskCacheModule", "setStringItem: cache key is null or empty");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1871145286:
                if (method.equals("getStringItem")) {
                    return j(params);
                }
                return super.call(method, params, callback);
            case -1449610962:
                if (method.equals("getByteArrayItem")) {
                    return d(params);
                }
                return super.call(method, params, callback);
            case -1097014074:
                if (method.equals("setStringItem")) {
                    o(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1013913506:
                if (method.equals("setByteArrayItem")) {
                    m(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1098253751:
                if (method.equals("removeItem")) {
                    l(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
