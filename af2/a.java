package af2;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.plugin.IECActivityDelegate;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Laf2/a;", "Lcom/tencent/ecommerce/base/plugin/IECActivityDelegate;", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "beforeCreate", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Activity;", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements IECActivityDelegate {
    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View findViewById = activity.findViewById(R.id.title);
        ViewParent parent = findViewById != null ? findViewById.getParent() : null;
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.ecommerce.base.plugin.IECActivityDelegate
    public void beforeCreate(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.tencent.ecommerce.base.plugin.IECActivityDelegate
    public void onCreate(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).iniSdkConfig();
    }

    @Override // com.tencent.ecommerce.base.plugin.IECActivityDelegate
    public void onDestroy(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.tencent.ecommerce.base.plugin.IECActivityDelegate
    public void onResume(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity a16 = b.f25996a.a(activity);
        if (a16 != null) {
            a(a16);
        }
    }
}
