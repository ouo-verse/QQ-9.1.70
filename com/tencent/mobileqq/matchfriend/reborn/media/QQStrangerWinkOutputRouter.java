package com.tencent.mobileqq.matchfriend.reborn.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/QQStrangerWinkOutputRouter;", "Lb93/a;", "", "interceptExitWink", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "onBack", "Lb93/b;", "outputData", "onOutput", "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerWinkOutputRouter implements a {
    public static final String OUTPUT_MEDIA = "OUTPUT_MEDIA";
    public static final String ROUTE_PATH = "/wink/output/qqstranger";

    @Override // b93.a
    public boolean interceptExitWink() {
        return true;
    }

    @Override // b93.a
    public void onBack(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // b93.a
    public void onOutput(Context context, OutputData outputData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        if (outputData.getOutputPoint() == 1 || outputData.getOutputPoint() == 2) {
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
    }
}
