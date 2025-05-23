package com.tencent.mobileqq.nearbypro.media;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RoutePage(desc = "\u65b0\u9644\u8fd1\u8c03\u7528wink\u7684\u8f93\u51fa\u8def\u7531", path = NBPWinkOutputRouter.ROUTE_PATH)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/media/NBPWinkOutputRouter;", "Lb93/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "onBack", "Lb93/b;", "outputData", "onOutput", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPWinkOutputRouter implements b93.a {

    @NotNull
    public static final String ROUTE_PATH = "/wink/output/nearbypro";

    @NotNull
    private static final String TAG = "NBPWinkOutputRouter";

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        j.c().c(TAG, "[onBack]");
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, new ArrayList<>());
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("NearbyProIPCModule", "ACTION_SELECTED_MEDIA_CALLBACK", bundle2, null);
        NBPMediaSelector.f253605a.c();
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        j.c().c(TAG, "[onOutput], outPoint= " + outputData.getOutputPoint());
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, new ArrayList<>(outputData.e()));
        Unit unit = Unit.INSTANCE;
        Activity activity = null;
        qIPCClientHelper.callServer("NearbyProIPCModule", "ACTION_SELECTED_MEDIA_CALLBACK", bundle, null);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null) {
            activity.finish();
        }
        QRouteApi api = QRoute.api(IWinkAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
        IWinkAPI.DefaultImpls.exitWink$default((IWinkAPI) api, false, 0, null, 7, null);
    }
}
