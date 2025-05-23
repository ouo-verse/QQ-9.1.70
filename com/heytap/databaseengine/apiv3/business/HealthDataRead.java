package com.heytap.databaseengine.apiv3.business;

import android.content.pm.PackageManager;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.ISportHealthManager;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.apiv2.health.business.ParamChecker;
import com.heytap.databaseengine.apiv3.DataReadRequest;
import com.heytap.databaseengine.apiv3.data.DataSet;
import com.heytap.databaseengine.callback.IDataReadResultListener;
import com.heytap.databaseengine.constant.AppType;
import com.heytap.databaseengine.utils.HLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
class HealthDataRead extends HRunnable {
    public static final int READ_ALL_OVER = 2;
    public static final int READ_POINT_PART = 3;
    public static final int READ_SET_PART = 4;
    private static final String TAG = "HealthDataRead";
    private final HResponse<List<DataSet>> mCallback;
    private final DataReadRequest mParams;

    public HealthDataRead(DataReadRequest dataReadRequest, HResponse<List<DataSet>> hResponse) {
        this.mParams = dataReadRequest;
        this.mCallback = hResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean receiveDataOver(List list, int i3, List<DataSet> list2) {
        if (i3 == 3) {
            DataSet dataSet = list2.get(list2.size() - 1);
            dataSet.getDataPoints().addAll(((DataSet) list.get(0)).getDataPoints());
            HLog.i(TAG, "receive points part");
            return false;
        }
        if (i3 == 4) {
            list2.addAll(list);
            HLog.i(TAG, "receive set part");
            return false;
        }
        if (i3 == 2) {
            HLog.i(TAG, "receive all over");
            return true;
        }
        HLog.i(TAG, "result type error");
        return true;
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void onException(Exception exc) {
        HLog.e(TAG, exc.getMessage());
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
        if (!new ParamChecker().timeCheck(this.mParams.getStartTime(), this.mParams.getEndTime())) {
            this.mCallback.onFailure(100001);
        } else if (InstalledAppListMonitor.getPackageInfo(_HeytapHealth.getContext().getPackageManager(), AppType.HEALTH_PACKAGE_NAME, 0).versionCode < 3120000) {
            this.mCallback.onFailure(100008);
        } else {
            final ArrayList arrayList = new ArrayList();
            ((ISportHealthManager) HRemoteService.getInstance().remoteApi(ISportHealthManager.class)).readv2(this.mParams, new IDataReadResultListener.Stub() { // from class: com.heytap.databaseengine.apiv3.business.HealthDataRead.1
                @Override // com.heytap.databaseengine.callback.IDataReadResultListener
                public void onResult(List list, int i3, int i16) {
                    if (!HealthDataRead.this.receiveDataOver(list, i16, arrayList)) {
                        return;
                    }
                    if (i3 != 0) {
                        HLog.i(HealthDataRead.TAG, "get data failed, errorCode: " + i3);
                        HealthDataRead.this.mCallback.onFailure(i3);
                        return;
                    }
                    HealthDataRead.this.mCallback.onSuccess(arrayList);
                }
            });
        }
    }
}
