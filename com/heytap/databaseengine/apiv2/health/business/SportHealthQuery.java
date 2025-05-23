package com.heytap.databaseengine.apiv2.health.business;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.SparseArray;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.ISportHealthManager;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.apiv2.health.HeytapHealthParams;
import com.heytap.databaseengine.callback.IDataReadResultListener;
import com.heytap.databaseengine.constant.AppType;
import com.heytap.databaseengine.constant.ErrorCode;
import com.heytap.databaseengine.option.DataReadOption;
import com.heytap.databaseengine.utils.DataDivideUtil;
import com.heytap.databaseengine.utils.GsonUtil;
import com.heytap.databaseengine.utils.HLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SportHealthQuery<T> extends HRunnable {
    private static final String TAG = "SportHealthQuery";
    private HResponse<List<T>> mCallback;
    private ParamPack<HeytapHealthParams> mParam;

    public SportHealthQuery() {
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void onException(Exception exc) {
        HLog.e(TAG, exc.getMessage());
        if (exc.getClass().equals(PackageManager.NameNotFoundException.class)) {
            this.mCallback.onFailure(ErrorCode.transformToOld(true, 100007));
        } else if (exc.getClass().equals(IllegalStateException.class)) {
            this.mCallback.onFailure(ErrorCode.transformToOld(true, 100008));
        } else {
            this.mCallback.onFailure(ErrorCode.transformToOld(true, 100003));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public DataReadOption paramUnpack(HeytapHealthParams heytapHealthParams) {
        DataReadOption dataReadOption = new DataReadOption();
        dataReadOption.setStartTime(heytapHealthParams.getStartTime());
        dataReadOption.setEndTime(heytapHealthParams.getEndTime());
        int tableType = HeytapHealthParams.getTableType(heytapHealthParams.getDataType() + heytapHealthParams.getMode());
        dataReadOption.setDataTable(tableType);
        if (tableType != 1005) {
            if (tableType != 1009) {
                switch (tableType) {
                    case 1001:
                        dataReadOption.setAggregateType(107);
                        break;
                    case 1002:
                    case 1003:
                        dataReadOption.setReadSportMode(-2);
                        break;
                }
            } else {
                dataReadOption.setGroupUnitType(4);
            }
        } else {
            dataReadOption.setReadSportMode(-2);
            dataReadOption.setGroupUnitType(8);
        }
        return dataReadOption;
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void realRun() throws Exception {
        ParamChecker paramChecker = new ParamChecker();
        HeytapHealthParams userParams = this.mParam.getUserParams();
        if (!paramChecker.pass(userParams)) {
            HLog.w(TAG, "set time scope error or larger than 30 days, please check it!");
            this.mCallback.onFailure(ErrorCode.transformToOld(true, 100001));
            return;
        }
        final DataReadOption paramUnpack = paramUnpack(userParams);
        if (paramUnpack.getDataTable() == -1) {
            this.mCallback.onFailure(ErrorCode.transformToOld(true, 100009));
            return;
        }
        PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(_HeytapHealth.getContext().getPackageManager(), AppType.HEALTH_PACKAGE_NAME, 0);
        final SparseArray sparseArray = new SparseArray();
        final ArrayList arrayList = new ArrayList();
        IDataReadResultListener.Stub stub = new IDataReadResultListener.Stub() { // from class: com.heytap.databaseengine.apiv2.health.business.SportHealthQuery.1
            @Override // com.heytap.databaseengine.callback.IDataReadResultListener
            public void onResult(List list, int i3, int i16) {
                if (i3 != ErrorCode.transformToOld(true, 0) && i3 < 100) {
                    HLog.d(SportHealthQuery.TAG, "get data failed, errorCode: " + i3);
                    HLog.i(SportHealthQuery.TAG, "readSportHealthData onFailure: endTime = " + System.currentTimeMillis());
                    SportHealthQuery.this.mCallback.onFailure(i3);
                    return;
                }
                int dataTable = paramUnpack.getDataTable();
                if (!DataDivideUtil.packDivideReadData(list, i3, i16, arrayList, sparseArray)) {
                    return;
                }
                if (sparseArray.size() > 0) {
                    HLog.d(SportHealthQuery.TAG, "readSportHealthData table: " + dataTable + " allData.get size: " + ((List) sparseArray.get(dataTable)).size());
                    SportHealthQuery.this.mCallback.onSuccess((List) sparseArray.get(dataTable));
                } else {
                    HLog.d(SportHealthQuery.TAG, "allData is empty");
                    SportHealthQuery.this.mCallback.onFailure(ErrorCode.transformToOld(true, ErrorCode.ERR_QUERY_EMPTY));
                }
                HLog.i(SportHealthQuery.TAG, "readSportHealthData: endTime = " + System.currentTimeMillis());
            }
        };
        if (packageInfo.versionCode < 3100000) {
            ((ISportHealthManager) HRemoteService.getInstance().remoteApi(ISportHealthManager.class)).read(paramUnpack, stub);
        } else {
            ((ISportHealthManager) HRemoteService.getInstance().remoteApi(ISportHealthManager.class)).query(GsonUtil.toJson(userParams), stub);
        }
    }

    public SportHealthQuery(ParamPack<HeytapHealthParams> paramPack, HResponse<List<T>> hResponse) {
        this.mParam = paramPack;
        this.mCallback = hResponse;
    }
}
