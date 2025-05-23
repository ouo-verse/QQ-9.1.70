package com.tencent.ecommerce.biz.retain.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/repo/a;", "", "", "retainId", "", "f", "d", "e", "", "c", "Lcom/tencent/ecommerce/biz/retain/repo/b;", "b", "info", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNeedRetain", "Lcom/tencent/ecommerce/biz/retain/repo/b;", "cacheInfo", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "retainIdAry", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f104126d = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isNeedRetain = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ECRetainInfoModel cacheInfo = ECRetainInfoModel.INSTANCE.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static CopyOnWriteArrayList<String> retainIdAry = new CopyOnWriteArrayList<>();

    a() {
    }

    public final void a(ECRetainInfoModel info) {
        if (info != null) {
            if (!(info.retainId.length() == 0)) {
                if (info.type == ECRetainInfoPromoteType.PROMOTE_TYPE_UNKNOWN) {
                    cg0.a.b("Retain", "the retain info is not retain, retainID:" + info.retainId);
                    return;
                }
                if (!isNeedRetain.get() && (!retainIdAry.isEmpty())) {
                    cg0.a.b("Retain", "not need retain and retain id not empty");
                    return;
                }
                cacheInfo = info;
                isNeedRetain.set(true);
                retainIdAry.add(info.retainId);
                return;
            }
        }
        cg0.a.f("Retain", "add retain info invalid");
    }

    public final ECRetainInfoModel b() {
        return ECRetainInfoModel.b(cacheInfo, null, null, null, null, 15, null);
    }

    public final boolean c(String retainId) {
        if (retainId.length() == 0) {
            return false;
        }
        return isNeedRetain.get() && retainIdAry.contains(retainId);
    }

    public final void d(String retainId) {
        retainIdAry.remove(retainId);
    }

    public final void e() {
        isNeedRetain.set(false);
    }

    public final void f(String retainId) {
        if (retainId.length() == 0) {
            cg0.a.f("Retain", "mark retain showed invalid");
        } else {
            isNeedRetain.set(false);
            retainIdAry.remove(retainId);
        }
    }
}
