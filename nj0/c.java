package nj0;

import com.tencent.ecommerce.biz.webview.IECWebViewPluginModel;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lnj0/c;", "", "", "methodName", "Lcom/tencent/ecommerce/biz/webview/IECWebViewPluginModel;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f420226a = new c();

    c() {
    }

    public final IECWebViewPluginModel a(String methodName) {
        int hashCode = methodName.hashCode();
        if (hashCode != -110831682) {
            if (hashCode == 110760 && methodName.equals(OpenConstants.ApiName.PAY)) {
                return new b();
            }
        } else if (methodName.equals("getAddress")) {
            return new a();
        }
        return null;
    }
}
