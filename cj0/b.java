package cj0;

import cj0.a;
import com.tencent.ecommerce.biz.showwindow.repo.window.ECShowWindowAddProductRsp;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcj0/a$b;", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/ECShowWindowAddProductRsp$a;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class b {
    public static final ECShowWindowAddProductRsp.a a(a.b bVar) {
        return new ECShowWindowAddProductRsp.a(bVar.getDisplay(), bVar.getTitle(), bVar.getText(), bVar.getLeftBtnText(), bVar.getLeftBtnUrl(), bVar.getRightBtnText(), bVar.getRightBtnUrl());
    }
}
