package com.heytap.databaseengine.apiv3.business;

import android.content.pm.PackageManager;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.ISportHealthManager;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.apiv3.DataInsertRequest;
import com.heytap.databaseengine.apiv3.utils.DataSplitUtil;
import com.heytap.databaseengine.callback.IDataOperateListener;
import com.heytap.databaseengine.constant.AppType;
import com.heytap.databaseengine.utils.AlertNullOrEmptyUtil;
import com.heytap.databaseengine.utils.HLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
class HealthDataInsert extends HRunnable {
    private static final String TAG = "HealthDataInsert";
    private final HResponse<Integer> mCallback;
    private final DataInsertRequest mParams;

    public HealthDataInsert(DataInsertRequest dataInsertRequest, HResponse<Integer> hResponse) {
        this.mParams = dataInsertRequest;
        this.mCallback = hResponse;
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void onException(Exception exc) {
        HLog.e(TAG, exc.getMessage());
        exc.printStackTrace();
        if (exc.getClass().equals(PackageManager.NameNotFoundException.class)) {
            this.mCallback.onFailure(100007);
        } else if (exc.getClass().equals(IllegalStateException.class)) {
            this.mCallback.onFailure(100008);
        } else {
            this.mCallback.onFailure(100003);
        }
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void realRun() throws Exception {
        if (AlertNullOrEmptyUtil.isNullOrEmpty(this.mParams.getData())) {
            this.mCallback.onFailure(100001);
            return;
        }
        if (InstalledAppListMonitor.getPackageInfo(_HeytapHealth.getContext().getPackageManager(), AppType.HEALTH_PACKAGE_NAME, 0).versionCode < 4000000) {
            this.mCallback.onFailure(100008);
            return;
        }
        List<DataInsertRequest> splitInsertRequest = DataSplitUtil.splitInsertRequest(this.mParams);
        final int[] iArr = {0};
        final int size = splitInsertRequest.size();
        for (final int i3 = 0; i3 < size; i3++) {
            ((ISportHealthManager) HRemoteService.getInstance().remoteApi(ISportHealthManager.class)).insert(splitInsertRequest.get(i3), new IDataOperateListener.Stub() { // from class: com.heytap.databaseengine.apiv3.business.HealthDataInsert.1
                @Override // com.heytap.databaseengine.callback.IDataOperateListener
                public void onResult(int i16, List list) {
                    if (i16 != 0) {
                        iArr[0] = i16;
                    }
                    if (i3 == size - 1) {
                        if (iArr[0] != 0) {
                            HealthDataInsert.this.mCallback.onFailure(i16);
                            HLog.i(HealthDataInsert.TAG, "insert data failed, errorCode: " + i16 + ", endTime = " + System.currentTimeMillis());
                            return;
                        }
                        HealthDataInsert.this.mCallback.onSuccess(0);
                        HLog.i(HealthDataInsert.TAG, "insert data success, endTime = " + System.currentTimeMillis());
                    }
                }
            });
        }
    }
}
