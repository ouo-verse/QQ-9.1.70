package com.tencent.mobileqq.qqecommerce.base.pageopener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/pageopener/ECWinkOutputRouter;", "Lb93/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "onBack", "Lb93/b;", "outputData", "onOutput", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECWinkOutputRouter implements a {
    public static final int FROM_ALBUM_SELECTOR = 2;
    public static final int FROM_CAMERA_CAPTURE = 1;
    public static final String FROM_TYPE = "from";
    public static final String ROUTE_PATH = "/wink/output/ecommerce";
    private static final String TAG = "ECWinkOutputRouter";

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d(TAG, 1, "[onBack]");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // b93.a
    public void onOutput(Context context, OutputData outputData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        int i3 = 1;
        QLog.d(TAG, 1, "[onOutput], outPoint= " + outputData.getOutputPoint());
        if (!(context instanceof Activity)) {
            QLog.e(TAG, 1, "context is not activity");
            return;
        }
        long outputPoint = outputData.getOutputPoint();
        if (outputPoint == 1) {
            i3 = 2;
        } else if (outputPoint != 2 && outputPoint != 8) {
            return;
        }
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, new ArrayList<>(outputData.e()));
        bundle.putInt("from", i3);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("EcommerceIPCModule", "ACTION_SELECTED_MEDIA_CALLBACK", bundle, null);
        ((Activity) context).finish();
        QRouteApi api = QRoute.api(IWinkAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
        IWinkAPI.DefaultImpls.exitWink$default((IWinkAPI) api, false, 0, null, 7, null);
    }
}
