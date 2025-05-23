package com.tencent.ecommerce.biz.showwindow.repo;

import android.os.Bundle;
import ck0.Product;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.showwindow.repo.window.GetProductListRsp;
import com.tencent.ecommerce.biz.showwindow.repo.window.d;
import com.tencent.ecommerce.biz.showwindow.repo.window.e;
import com.tencent.ecommerce.biz.showwindow.repo.window.f;
import com.tencent.ecommerce.biz.showwindow.repo.window.g;
import com.tencent.ecommerce.biz.showwindow.repo.window.h;
import com.tencent.ecommerce.biz.showwindow.repo.window.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$Jh\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016JX\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016JF\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J@\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016JF\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J@\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J\\\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/d;", "Lcom/tencent/ecommerce/biz/showwindow/repo/IECShowWindowNetRepo;", "", WadlProxyConsts.CHANNEL, "", "query", "categoryId", "windowType", "cookie", "Landroid/os/Bundle;", "ext", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/j;", "", "successCallback", "Lcom/tencent/ecommerce/base/network/api/e;", "errorCallback", "source", "getProductAndCategoryList", "mediaId", "sellerUin", "", "isNight", "getViewProductList", "", "Lck0/c;", "products", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "reqDeleteProduct", "product", "reqSetTopProduct", "reqAddProduct", "addProducts", "delProducts", "reqUpdateProduct", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d implements IECShowWindowNetRepo {

    /* renamed from: a, reason: collision with root package name */
    public static final d f104657a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/repo/d$a", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/c;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/d;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkCallback<com.tencent.ecommerce.biz.showwindow.repo.window.c, com.tencent.ecommerce.biz.showwindow.repo.window.d> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f104658a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f104659b;

        a(Function1 function1, Function1 function12) {
            this.f104658a = function1;
            this.f104659b = function12;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(com.tencent.ecommerce.biz.showwindow.repo.window.c reqModel, ECRemoteResponse errorResponse) {
            this.f104659b.invoke(errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(com.tencent.ecommerce.biz.showwindow.repo.window.c reqModel, com.tencent.ecommerce.biz.showwindow.repo.window.d respModel) {
            d.b productListRsp = respModel.getProductListRsp();
            if (productListRsp != null) {
                this.f104658a.invoke(new GetProductListRsp(respModel.getDataJson(), productListRsp.getTotal(), productListRsp.getCookie(), productListRsp.getIsEnd(), productListRsp.d(), productListRsp.b(), productListRsp.a(), 0, 0, null, 896, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/repo/d$c", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/a;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/b;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkCallback<com.tencent.ecommerce.biz.showwindow.repo.window.a, com.tencent.ecommerce.biz.showwindow.repo.window.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f104662a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f104663b;

        c(Function1 function1, Function1 function12) {
            this.f104662a = function1;
            this.f104663b = function12;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(com.tencent.ecommerce.biz.showwindow.repo.window.a reqModel, ECRemoteResponse errorResponse) {
            this.f104663b.invoke(errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(com.tencent.ecommerce.biz.showwindow.repo.window.a reqModel, com.tencent.ecommerce.biz.showwindow.repo.window.b respModel) {
            k result = respModel.getResult();
            if (result != null) {
                this.f104662a.invoke(result);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/repo/d$d", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/e;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/f;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.showwindow.repo.d$d, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1101d implements IECNetworkCallback<e, f> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f104664a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f104665b;

        C1101d(Function1 function1, Function1 function12) {
            this.f104664a = function1;
            this.f104665b = function12;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(e reqModel, ECRemoteResponse errorResponse) {
            this.f104665b.invoke(errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(e reqModel, f respModel) {
            k result = respModel.getResult();
            if (result != null) {
                this.f104664a.invoke(result);
            }
        }
    }

    d() {
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void getViewProductList(int channel, String mediaId, String sellerUin, String cookie, boolean isNight, Function1<? super GetProductListRsp, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.show_window_svr.ShowWindowSvr", "/trpc.ecom.show_window_svr.ShowWindowSvr/ViewProducts", new g(channel, mediaId, sellerUin, cookie, 1), new h(isNight), new b(successCallback, errorCallback));
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqAddProduct(int channel, Product product, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqDeleteProduct(int channel, List<Product> products, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
        ArrayList arrayList = new ArrayList();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMediaProductId());
        }
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.show_window_svr.ShowWindowSvr", "/trpc.ecom.show_window_svr.ShowWindowSvr/DeleteProduct", new com.tencent.ecommerce.biz.showwindow.repo.window.a(1, arrayList), new com.tencent.ecommerce.biz.showwindow.repo.window.b(), new c(successCallback, errorCallback));
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqSetTopProduct(int channel, Product product, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.show_window_svr.ShowWindowSvr", "/trpc.ecom.show_window_svr.ShowWindowSvr/SetProductToTop", new e(1, product.getMediaProductId()), new f(), new C1101d(successCallback, errorCallback));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/repo/d$b", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/g;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/h;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkCallback<g, h> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f104660a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f104661b;

        b(Function1 function1, Function1 function12) {
            this.f104660a = function1;
            this.f104661b = function12;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(g reqModel, ECRemoteResponse errorResponse) {
            this.f104661b.invoke(errorResponse);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(g reqModel, h respModel) {
            this.f104660a.invoke(new GetProductListRsp(null, respModel.getTotal(), respModel.getCookie(), respModel.getIsEnd(), respModel.b(), new ArrayList(), null, 0, 0, respModel.getWindowTitle(), TroopInfo.PAY_PRIVILEGE_ALL, null));
        }
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqAddProduct(int channel, List<Product> products, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void getProductAndCategoryList(int channel, String query, String categoryId, int windowType, String cookie, Bundle ext, Function1<? super GetProductListRsp, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback, int source) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.show_window_svr.ShowWindowSvr", "/trpc.ecom.show_window_svr.ShowWindowSvr/GetProducts", new com.tencent.ecommerce.biz.showwindow.repo.window.c(query, categoryId, cookie, channel, windowType, source), new com.tencent.ecommerce.biz.showwindow.repo.window.d(ext.getBoolean("isShowAddBtn", false), ext.getBoolean("isEdited", false)), new a(successCallback, errorCallback));
    }

    @Override // com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo
    public void reqUpdateProduct(int channel, List<Product> addProducts, List<Product> delProducts, Bundle ext, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback) {
    }
}
