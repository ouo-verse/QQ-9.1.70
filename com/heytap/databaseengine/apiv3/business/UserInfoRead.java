package com.heytap.databaseengine.apiv3.business;

import android.content.pm.PackageManager;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.IUserInfoManager;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.apiv3.data.DataSet;
import com.heytap.databaseengine.callback.ICommonListener;
import com.heytap.databaseengine.constant.AppType;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/heytap/databaseengine/apiv3/business/UserInfoRead;", "Lcom/heytap/databaseengine/apiv2/common/HRunnable;", "hResponse", "Lcom/heytap/databaseengine/apiv2/HResponse;", "", "Lcom/heytap/databaseengine/apiv3/data/DataSet;", "(Lcom/heytap/databaseengine/apiv2/HResponse;)V", "realRun", "", "heytap_health_sdk_v2.1.5_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserInfoRead extends HRunnable {

    @NotNull
    private final HResponse<List<DataSet>> hResponse;

    public UserInfoRead(@NotNull HResponse<List<DataSet>> hResponse) {
        Intrinsics.checkNotNullParameter(hResponse, "hResponse");
        this.hResponse = hResponse;
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void realRun() {
        try {
            if (InstalledAppListMonitor.getPackageInfo(_HeytapHealth.getContext().getPackageManager(), AppType.HEALTH_PACKAGE_NAME, 0).versionCode < 3180000) {
                this.hResponse.onFailure(100008);
                return;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            this.hResponse.onFailure(100007);
        }
        ((IUserInfoManager) HRemoteService.getInstance().remoteApi(IUserInfoManager.class)).readV2(new ICommonListener.Stub() { // from class: com.heytap.databaseengine.apiv3.business.UserInfoRead$realRun$1
            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onFailure(int errCode, @Nullable List<Object> errMsg) {
                HResponse hResponse;
                hResponse = UserInfoRead.this.hResponse;
                hResponse.onFailure(errCode);
            }

            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onSuccess(int intent, @Nullable List<Object> data) {
                HResponse hResponse;
                hResponse = UserInfoRead.this.hResponse;
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.heytap.databaseengine.apiv3.data.DataSet>");
                hResponse.onSuccess(data);
            }
        });
    }
}
