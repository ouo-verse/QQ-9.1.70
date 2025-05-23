package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0001\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/n;", "K", "Lcom/tencent/mobileqq/zplan/utils/d;", "key", "", "e", "(Ljava/lang/Object;)Ljava/lang/String;", "Ljava/io/InputStream;", "a", "(Ljava/lang/Object;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "b", "(Ljava/lang/Object;)Ljava/io/OutputStream;", "V", "Lkotlin/Function0;", "block", "c", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "mmkv", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class n<K> extends d<K> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final IZPlanMMKVApi mmkv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/utils/n$a", "Ljava/io/ByteArrayOutputStream;", "", "close", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends ByteArrayOutputStream {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n<K> f335832d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ K f335833e;

        a(n<K> nVar, K k3) {
            this.f335832d = nVar;
            this.f335833e = k3;
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            IZPlanMMKVApi iZPlanMMKVApi = ((n) this.f335832d).mmkv;
            String e16 = this.f335832d.e(this.f335833e);
            byte[] byteArray = toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "this.toByteArray()");
            iZPlanMMKVApi.setBytes(e16, byteArray);
        }
    }

    public n(String TAG) {
        Intrinsics.checkNotNullParameter(TAG, "TAG");
        this.TAG = TAG;
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        this.mmkv = (IZPlanMMKVApi) api;
    }

    static /* synthetic */ <V> Object f(n<K> nVar, Function0<? extends V> function0, Continuation<? super V> continuation) {
        return function0.invoke();
    }

    @Override // com.tencent.mobileqq.zplan.utils.d
    public InputStream a(K key) {
        return new ByteArrayInputStream(this.mmkv.getBytes(e(key), new byte[0]));
    }

    @Override // com.tencent.mobileqq.zplan.utils.d
    public OutputStream b(K key) {
        return new a(this, key);
    }

    @Override // com.tencent.mobileqq.zplan.utils.d
    public <V> Object c(Function0<? extends V> function0, Continuation<? super V> continuation) {
        return f(this, function0, continuation);
    }

    protected String e(K key) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = this.TAG;
        objArr[1] = Integer.valueOf(key != null ? key.hashCode() : 0);
        String format = String.format("zplan_%s_%08X", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
