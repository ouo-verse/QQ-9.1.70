package og2;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.wx.api.IECWXAuthApi;
import com.tencent.ecommerce.base.wx.api.IECWXAuthApiCallback;
import com.tencent.mobileqq.utils.NetworkUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Log2/b;", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApiCallback;", "authApiCallback", "", "reqWXAuthCode", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements IECWXAuthApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"og2/b$a", "Log2/c;", "", "errorCode", "", "errorMsg", "authCode", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECWXAuthApiCallback f422659a;

        a(IECWXAuthApiCallback iECWXAuthApiCallback) {
            this.f422659a = iECWXAuthApiCallback;
        }

        @Override // og2.c
        public void a(int errorCode, String errorMsg, String authCode) {
            this.f422659a.onAuthorizationResult(errorCode, errorMsg, authCode);
        }
    }

    @Override // com.tencent.ecommerce.base.wx.api.IECWXAuthApi
    public void reqWXAuthCode(IECWXAuthApiCallback authApiCallback) {
        Intrinsics.checkNotNullParameter(authApiCallback, "authApiCallback");
        ng2.a aVar = new ng2.a();
        if (!NetworkUtil.isNetworkAvailable()) {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            aVar.makeText(application, "\u65e0\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25", ECToastIcon.ICON_NONE, 0);
            authApiCallback.onAuthorizationResult(-1, "\u65e0\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25", null);
            return;
        }
        og2.a aVar2 = og2.a.f422654d;
        if (!aVar2.d()) {
            BaseApplicationImpl application2 = BaseApplicationImpl.getApplication();
            Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
            aVar.makeText(application2, "\u672a\u5b89\u88c5\u5fae\u4fe1", ECToastIcon.ICON_NONE, 0);
            authApiCallback.onAuthorizationResult(-5, "\u672a\u5b89\u88c5\u5fae\u4fe1", null);
            return;
        }
        aVar2.e(new a(authApiCallback));
    }
}
