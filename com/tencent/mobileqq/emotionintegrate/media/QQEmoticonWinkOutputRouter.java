package com.tencent.mobileqq.emotionintegrate.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b93.OutputData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/media/QQEmoticonWinkOutputRouter;", "Lb93/a;", "Landroid/content/Context;", "context", "Lb93/b;", "outputData", "", "handleCaptureResult", "", "interceptExitWink", "Landroid/os/Bundle;", "bundle", "onBack", "onOutput", "<init>", "()V", "Companion", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQEmoticonWinkOutputRouter implements b93.a {
    public static final String OUTPUT_MEDIA = "OUTPUT_MEDIA";
    public static final String ROUTE_PATH = "/wink/output/emotion";
    public static final String TAG = "QQEmotionWinkOutputRouter";

    private final void handleCaptureResult(Context context, OutputData outputData) {
        QLog.d(TAG, 1, "[handleCaptureResult]");
        if (context == null) {
            QLog.w(TAG, 1, "[handleExportResult] no context");
            return;
        }
        if (outputData.e().isEmpty()) {
            QLog.d(TAG, 1, "[handleExportResult] no medias");
            return;
        }
        QRouteApi api = QRoute.api(IWinkAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
        IWinkAPI iWinkAPI = (IWinkAPI) api;
        Intent intent = new Intent();
        Bundle bundle = outputData.getBundle();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("OUTPUT_MEDIA", new ArrayList(outputData.e()));
        Unit unit = Unit.INSTANCE;
        IWinkAPI.DefaultImpls.exitWink$default(iWinkAPI, false, -1, intent, 1, null);
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        return true;
    }

    @Override // b93.a
    public void onBack(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d(TAG, 1, "[handleCaptureResult] onBack");
        QRouteApi api = QRoute.api(IWinkAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
        IWinkAPI iWinkAPI = (IWinkAPI) api;
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        Unit unit = Unit.INSTANCE;
        IWinkAPI.DefaultImpls.exitWink$default(iWinkAPI, false, 0, intent, 3, null);
    }

    @Override // b93.a
    public void onOutput(Context context, OutputData outputData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        QLog.d(TAG, 1, "[handleCaptureResult] begin");
        if (outputData.getOutputPoint() == 8) {
            handleCaptureResult(context, outputData);
        }
    }
}
