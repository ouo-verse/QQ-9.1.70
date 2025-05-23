package com.tencent.ecommerce.biz.showwindow.repo;

import android.os.Bundle;
import ck0.Product;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.showwindow.repo.window.GetProductListRsp;
import com.tencent.ecommerce.biz.showwindow.repo.window.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import di0.ad;
import di0.ae;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$Jh\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016JX\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016JF\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J@\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016JF\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J@\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J\\\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/c;", "Lcom/tencent/ecommerce/biz/showwindow/repo/IECShowWindowNetRepo;", "", WadlProxyConsts.CHANNEL, "", "query", "categoryId", "windowType", "cookie", "Landroid/os/Bundle;", "ext", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/j;", "", "successCallback", "Lcom/tencent/ecommerce/base/network/api/e;", "errorCallback", "source", "getProductAndCategoryList", "mediaId", "sellerUin", "", "isNight", "getViewProductList", "", "Lck0/c;", "products", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "reqDeleteProduct", "product", "reqSetTopProduct", "reqAddProduct", "addProducts", "delProducts", "reqUpdateProduct", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements IECShowWindowNetRepo {

    /* renamed from: a, reason: collision with root package name */
    public static final c f104652a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/repo/c$b", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/ad;", "Ldi0/ae;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkCallback<ad, ae> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f104655a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f104656b;

        b(Function1 function1, Function1 function12) {
            this.f104655a = function1;
            this.f104656b = function12;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(ad reqModel, ECRemoteResponse errorResponse) {
            this.f104656b.invoke(errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ad reqModel, ae respModel) {
            int i3;
            if (respModel.getIsSuccess()) {
                i3 = respModel.a().isEmpty() ? 1 : 3;
            } else {
                i3 = 2;
            }
            this.f104655a.invoke(new k(i3, respModel.getFaildMsg(), new HashMap(), respModel.a(), respModel.getTotalAddSuccessCount()));
        }
    }

    c() {
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqAddProduct(int channel, Product product, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqDeleteProduct(int channel, List<Product> products, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
        List<Product> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        reqUpdateProduct(channel, emptyList, products, new Bundle(), successCallback, errorCallback);
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqUpdateProduct(int channel, List<Product> addProducts, List<Product> delProducts, Bundle ext, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr", "/trpc.ecom.qqlive_master_window_svr.QqliveMasterWindowSvr/Update", new ad(channel, ext.getLong("roomId"), addProducts, delProducts, LiveTabId.LIVE_TAB_PRODUCT), new ae(), new b(successCallback, errorCallback));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/repo/c$a", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldj0/a;", "Ldj0/b;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkCallback<dj0.a, dj0.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f104653a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f104654b;

        a(Function1 function1, Function1 function12) {
            this.f104653a = function1;
            this.f104654b = function12;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(dj0.a reqModel, ECRemoteResponse errorResponse) {
            this.f104654b.invoke(errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(dj0.a reqModel, dj0.b respModel) {
            List emptyList;
            List emptyList2;
            Function1 function1 = this.f104653a;
            JSONObject dataJson = respModel.getDataJson();
            int total = respModel.getTotal();
            String cookie = respModel.getCookie();
            boolean isEnd = respModel.getIsEnd();
            List<Product> e16 = respModel.e();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            function1.invoke(new GetProductListRsp(dataJson, total, cookie, isEnd, e16, emptyList, emptyList2, respModel.getLiveProductCountLimit(), respModel.getLiveProductSelectedCount(), null, 512, null));
        }
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqAddProduct(int channel, List<Product> products, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
        List<Product> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        reqUpdateProduct(channel, products, emptyList, new Bundle(), successCallback, errorCallback);
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void getProductAndCategoryList(int channel, String query, String categoryId, int windowType, String cookie, Bundle ext, Function1<? super GetProductListRsp, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback, int source) {
        String string = ext.getString("userId");
        if (string == null) {
            string = "";
        }
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_my_window_svr.QqliveMyWindowSvr", "/trpc.ecom.qqlive_my_window_svr.QqliveMyWindowSvr/GetProducts", new dj0.a(channel, ext.getLong("roomId"), string, query, 1, cookie), new dj0.b(), new a(successCallback, errorCallback));
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqSetTopProduct(int channel, Product product, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void getViewProductList(int channel, String mediaId, String sellerUin, String cookie, boolean isNight, Function1<? super GetProductListRsp, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
    }
}
