package com.tencent.ecommerce.biz.showwindow.viewmodel;

import ck0.Product;
import com.tencent.bugly.common.constants.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tR&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/viewmodel/a;", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/b;", "", "selectedCountFromBackend", "", "F3", "", "tabId", "", "Lck0/c;", "productList", Constants.EMULATOR_INFO, "H3", "product", "E3", "", "H0", "Ljava/util/Map;", "selectedProductInEachTab", "I0", "unselectedProductInEachTab", "<init>", "()V", "J0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends b {

    /* renamed from: H0, reason: from kotlin metadata */
    private final Map<String, List<Product>> selectedProductInEachTab = new LinkedHashMap();

    /* renamed from: I0, reason: from kotlin metadata */
    private final Map<String, List<Product>> unselectedProductInEachTab = new LinkedHashMap();

    public final void E3(Product product) {
        if (L2().contains(product)) {
            product.W(true);
        } else if (M2().contains(product)) {
            product.W(false);
        }
    }

    public final void F3(int selectedCountFromBackend) {
        super.j3(selectedCountFromBackend);
        y3();
    }

    public final void G3(String tabId, List<Product> productList) {
        this.selectedProductInEachTab.put(tabId, productList);
        L2().clear();
        Iterator<Map.Entry<String, List<Product>>> it = this.selectedProductInEachTab.entrySet().iterator();
        while (it.hasNext()) {
            L2().addAll(it.next().getValue());
        }
        y3();
        x3();
    }

    public final void H3(String tabId, List<Product> productList) {
        this.unselectedProductInEachTab.put(tabId, productList);
        M2().clear();
        Iterator<Map.Entry<String, List<Product>>> it = this.unselectedProductInEachTab.entrySet().iterator();
        while (it.hasNext()) {
            M2().addAll(it.next().getValue());
        }
        y3();
        x3();
    }
}
