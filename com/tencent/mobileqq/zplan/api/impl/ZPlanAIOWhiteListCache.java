package com.tencent.mobileqq.zplan.api.impl;

import com.google.gson.Gson;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.api.impl.ZPlanAIOWhiteListApiImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIOWhiteListCache;", "", "", "uin", "", "a", "Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIOWhiteListApiImpl$b;", "data", "", "g", "bytes", "b", "", "e", "c", "whiteListData", "", "f", "J", "accountUin", "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "zPlanMMKV", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAIOWhiteListCache {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanAIOWhiteListCache f331339a = new ZPlanAIOWhiteListCache();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long accountUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy zPlanMMKV;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanMMKVApi>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanAIOWhiteListCache$zPlanMMKV$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanMMKVApi invoke() {
                QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
                return (IZPlanMMKVApi) api;
            }
        });
        zPlanMMKV = lazy;
    }

    ZPlanAIOWhiteListCache() {
    }

    private final String a(long uin) {
        return String.valueOf(uin) + "ZPlanAIOWhiteListCache";
    }

    private final IZPlanMMKVApi d() {
        return (IZPlanMMKVApi) zPlanMMKV.getValue();
    }

    public final boolean e(long uin) {
        boolean z16 = accountUin == uin;
        if (!z16) {
            accountUin = uin;
        }
        return z16;
    }

    public final void f(ZPlanAIOWhiteListApiImpl.WhiteListData whiteListData, long uin) {
        byte[] g16;
        accountUin = uin;
        if (whiteListData == null || (g16 = g(whiteListData)) == null) {
            return;
        }
        if (!(g16.length == 0)) {
            try {
                d().setBytes(a(uin), g16);
            } catch (Exception unused) {
            }
        }
    }

    public final ZPlanAIOWhiteListApiImpl.WhiteListData c(long uin) {
        byte[] bArr;
        try {
            bArr = d().getBytes(a(uin), new byte[0]);
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                return b(bArr);
            }
        }
        return null;
    }

    private final ZPlanAIOWhiteListApiImpl.WhiteListData b(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try {
            return (ZPlanAIOWhiteListApiImpl.WhiteListData) new Gson().fromJson(new String(bytes, Charsets.UTF_8), ZPlanAIOWhiteListApiImpl.WhiteListData.class);
        } catch (Exception unused) {
            QLog.i("ZPlanAIOWhiteListCache", 2, "fromBytes error");
            return null;
        }
    }

    private final byte[] g(ZPlanAIOWhiteListApiImpl.WhiteListData data) {
        if (data == null) {
            return null;
        }
        try {
            String json = new Gson().toJson(data);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(whiteListData)");
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (Exception unused) {
            QLog.i("ZPlanAIOWhiteListCache", 2, "toBytes error");
            return null;
        }
    }
}
