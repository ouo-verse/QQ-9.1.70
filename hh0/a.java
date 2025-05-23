package hh0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.wx.api.IECWXAuthApi;
import com.tencent.ecommerce.base.wx.api.IECWXAuthApiCallback;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lhh0/a;", "", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApiCallback;", "authCallback", "", "a", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "wxApi", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f404923b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECWXAuthApi wxApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getWxAuthApi();

    a() {
    }

    public final void a(IECWXAuthApiCallback authCallback) {
        IECWXAuthApi iECWXAuthApi = wxApi;
        if (iECWXAuthApi != null) {
            iECWXAuthApi.reqWXAuthCode(authCallback);
        }
    }
}
