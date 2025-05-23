package af2;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.mobileqq.auto.engine.enter.ASEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.QQECommerceSdkImpl;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J>\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ>\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\fJD\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0012"}, d2 = {"Laf2/d;", "", "", "target", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "logicCallback", "", "a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "c", "url", "d", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f26007a = new d();

    d() {
    }

    public final void a(int target, HashMap<String, String> params, IECLogicCallback logicCallback) {
        Intrinsics.checkNotNullParameter(params, "params");
        ASEnterBean aSEnterBean = new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE);
        aSEnterBean.setLoadAction(1003);
        aSEnterBean.setAttrs(QQEcommerceSdk.createLogicRequestParams(target, params, logicCallback));
        if (!aSEnterBean.getAttrs().containsKey("KEY_ENTER_TIME")) {
            HashMap<String, String> attrs = aSEnterBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs, "enterBean.attrs");
            attrs.put("KEY_ENTER_TIME", String.valueOf(System.currentTimeMillis()));
        }
        HashMap<String, String> attrs2 = aSEnterBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs2, "enterBean.attrs");
        attrs2.put("KEY_FORCE_NATIVE", String.valueOf(QQECommerceSdkImpl.INSTANCE.a(target)));
        ASEngineEnter.b(aSEnterBean);
    }

    public final void c(int target, HashMap<String, String> params, IECSchemeCallback logicCallback) {
        Intrinsics.checkNotNullParameter(params, "params");
        ASEnterBean aSEnterBean = new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE);
        aSEnterBean.setLoadAction(1003);
        aSEnterBean.setAttrs(QQEcommerceSdk.createSchemeRequestParams(target, params, logicCallback));
        if (!com.tencent.mobileqq.qqecommerce.base.somanager.d.f262484a.isPtsLiteSoReady()) {
            HashMap<String, String> attrs = aSEnterBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs, "enterBean.attrs");
            attrs.put("KEY_FORCE_SHOWLOADING", "true");
        }
        if (!aSEnterBean.getAttrs().containsKey("KEY_ENTER_TIME")) {
            HashMap<String, String> attrs2 = aSEnterBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs2, "enterBean.attrs");
            attrs2.put("KEY_ENTER_TIME", String.valueOf(System.currentTimeMillis()));
        }
        ASEngineEnter.b(aSEnterBean);
    }

    public final void d(String url, HashMap<String, String> params, IECSchemeCallback logicCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        ASEnterBean aSEnterBean = new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE);
        aSEnterBean.setLoadAction(1003);
        aSEnterBean.setAttrs(QQEcommerceSdk.createSchemeRequestParams(url, logicCallback, params));
        if (!com.tencent.mobileqq.qqecommerce.base.somanager.d.f262484a.isPtsLiteSoReady()) {
            HashMap<String, String> attrs = aSEnterBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs, "enterBean.attrs");
            attrs.put("KEY_FORCE_SHOWLOADING", "true");
        }
        if (!aSEnterBean.getAttrs().containsKey("KEY_ENTER_TIME")) {
            HashMap<String, String> attrs2 = aSEnterBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs2, "enterBean.attrs");
            attrs2.put("KEY_ENTER_TIME", String.valueOf(System.currentTimeMillis()));
        }
        ASEngineEnter.b(aSEnterBean);
    }

    public static /* synthetic */ void b(d dVar, int i3, HashMap hashMap, IECLogicCallback iECLogicCallback, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            iECLogicCallback = null;
        }
        dVar.a(i3, hashMap, iECLogicCallback);
    }
}
