package com.tencent.ecommerce.repo.live;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/live/e;", "", "", "roomId", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f105131a = new e();

    e() {
    }

    public final void a(String roomId) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_product_dynamic_svr.QqliveProductDynamicSvr", "/trpc.ecom.qqlive_product_dynamic_svr.QqliveProductDynamicSvr/RecordBuyingPeople", new di0.g(roomId), new di0.h(), new a());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/e$a", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/g;", "Ldi0/h;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkCallback<di0.g, di0.h> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(di0.g reqModel, ECRemoteResponse errorResponse) {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(di0.g reqModel, di0.h respModel) {
        }
    }
}
