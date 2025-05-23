package com.tencent.ecommerce.biz.showwindow.repo;

import android.os.Bundle;
import ck0.Product;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.biz.showwindow.repo.window.j;
import com.tencent.ecommerce.biz.showwindow.repo.window.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001Jj\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0002H&JZ\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH&JF\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH&J@\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH&JF\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH&J@\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH&J\\\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/IECShowWindowNetRepo;", "", "", WadlProxyConsts.CHANNEL, "", "query", "categoryId", "windowType", "cookie", "Landroid/os/Bundle;", "ext", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/j;", "", "successCallback", "Lcom/tencent/ecommerce/base/network/api/e;", "errorCallback", "source", "getProductAndCategoryList", "mediaId", "sellerUin", "", "isNight", "getViewProductList", "", "Lck0/c;", "products", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "reqDeleteProduct", "product", "reqSetTopProduct", "reqAddProduct", "addProducts", "delProducts", "reqUpdateProduct", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECShowWindowNetRepo {
    void getProductAndCategoryList(int channel, String query, String categoryId, int windowType, String cookie, Bundle ext, Function1<? super j, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback, int source);

    void getViewProductList(int channel, String mediaId, String sellerUin, String cookie, boolean isNight, Function1<? super j, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback);

    void reqAddProduct(int channel, Product product, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback);

    void reqAddProduct(int channel, List<Product> products, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback);

    void reqDeleteProduct(int channel, List<Product> products, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback);

    void reqSetTopProduct(int channel, Product product, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback);

    void reqUpdateProduct(int channel, List<Product> addProducts, List<Product> delProducts, Bundle ext, Function1<? super k, Unit> successCallback, Function1<? super ECRemoteResponse, Unit> errorCallback);
}
