package hg2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.router.api.IECScheme;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECWebSchemeUserDataMap;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.QQECommerceSdkImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J$\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lhg2/a;", "Lcom/tencent/ecommerce/base/router/api/IECScheme;", "", "url", "", "a", "", "userData", "", "handleWebScheme", "target", "data", "handleCommonPage", "handleOtherScheme", "Landroidx/collection/ArrayMap;", "Lhg2/b;", "Landroidx/collection/ArrayMap;", "schemeOtherTargetHandlerMap", "<init>", "()V", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECScheme {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<Integer, b> schemeOtherTargetHandlerMap = new ArrayMap<>();

    private final void a(String url) {
        Intent intent = new Intent(BaseApplicationImpl.getApplication(), (Class<?>) JumpActivity.class);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(url));
        BaseApplicationImpl.getApplication().startActivity(intent);
    }

    @Override // com.tencent.ecommerce.base.router.api.IECScheme
    public int handleCommonPage(int target, Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b bVar = this.schemeOtherTargetHandlerMap.get(Integer.valueOf(target));
        if (bVar != null) {
            return bVar.a(data);
        }
        return 0;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECScheme
    public int handleOtherScheme(String url) {
        if (QQECommerceSdkImpl.INSTANCE.b()) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplication().applicationContext");
            if (Foreground.getTopActivity() != null) {
                applicationContext = Foreground.getTopActivity();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getTopActivity()");
            }
            ax c16 = bi.c(qQAppInterface, applicationContext, url);
            if (c16 != null) {
                c16.b();
                return 0;
            }
            a(url);
            return 0;
        }
        a(url);
        return 0;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECScheme
    public int handleWebScheme(String url, Map<String, String> userData) {
        if (url != null && !TextUtils.isEmpty(url)) {
            Bundle bundle = new Bundle();
            Context application = BaseApplicationImpl.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            if (Foreground.getTopActivity() != null) {
                application = Foreground.getTopActivity();
                Intrinsics.checkNotNullExpressionValue(application, "getTopActivity()");
                bundle.putBoolean("ecommerce_web", true);
            }
            if (userData != null) {
                ECWebSchemeUserDataMap eCWebSchemeUserDataMap = new ECWebSchemeUserDataMap();
                eCWebSchemeUserDataMap.setMap(userData);
                bundle.putSerializable("ecommerce_user_data", eCWebSchemeUserDataMap);
            }
            QLog.d("ECWebSchemeManager", 1, "Qroute:  RIJDetail");
            return ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpTo(application, url, bundle);
        }
        QLog.i("ECWebSchemeManager", 1, "[handleScheme] url is empty.");
        return -1;
    }
}
