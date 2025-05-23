package cooperation.qqcircle.helpers;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.data.QFSClockInBean;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleVVGameConfigBean;
import cooperation.qqcircle.utils.JsonBinder;
import qqcircle.TaskCenterReader$EeveeAttach;
import uq3.k;
import uq3.n;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum QCircleVVGameHelper {
    INSTANCE;

    private static final String TAG = "nvvGame-QCircleVVGameHelper";
    private long mLastCompleteTime;
    private QCircleVVGameConfigBean mVVConfigBean;

    public static QCircleVVGameConfigBean getUserHaveBeginCacheTask() {
        try {
            return (QCircleVVGameConfigBean) JsonBinder.getInstance().fromJson(k.a().h("sp_key_nvv_game_server_config_cache", ""), QCircleVVGameConfigBean.class);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "load cache config from sp error:" + e16);
            return null;
        }
    }

    public static void saveHaveBeginTask(QCircleVVGameConfigBean qCircleVVGameConfigBean) {
        String str;
        if (qCircleVVGameConfigBean != null) {
            str = JsonBinder.getInstance().toJson(qCircleVVGameConfigBean);
        } else {
            str = "";
        }
        QLog.e(TAG, 1, "saveHaveBeginTask\uff1a" + str);
        k.a().p("sp_key_nvv_game_server_config_cache", str);
    }

    public ByteStringMicro getReqByte() {
        TaskCenterReader$EeveeAttach taskCenterReader$EeveeAttach = new TaskCenterReader$EeveeAttach();
        QCircleVVGameConfigBean qCircleVVGameConfigBean = this.mVVConfigBean;
        boolean z16 = false;
        if (n.c(System.currentTimeMillis(), this.mLastCompleteTime)) {
            QLog.d(TAG, 1, "getReqByte today have complete data");
        } else if (qCircleVVGameConfigBean != null && n.c(System.currentTimeMillis(), qCircleVVGameConfigBean.getGetConfigTime())) {
            QLog.d(TAG, 1, "getReqByte today have load data");
        } else {
            QLog.d(TAG, 1, "getReqByte need load data");
            z16 = true;
        }
        taskCenterReader$EeveeAttach.need_vv_info.set(z16);
        QFSClockInBean clockInfoBean = QCircleHostGlobalInfo.getClockInfoBean();
        if (clockInfoBean != null && clockInfoBean.getTransInfo() != null) {
            taskCenterReader$EeveeAttach.trans_info.set(clockInfoBean.getTransInfo());
        }
        return ByteStringMicro.copyFrom(taskCenterReader$EeveeAttach.toByteArray());
    }

    public QCircleVVGameConfigBean getVVConfigBean() {
        return this.mVVConfigBean;
    }

    public QCircleVVGameConfigBean getValidVVGame() {
        long f16 = k.a().f("sp_key_nvv_game_last_complete_time", 0L);
        if (n.c(System.currentTimeMillis(), f16)) {
            QLog.d(TAG, 1, "canShowVVGame lastCompleteTime :" + f16 + ",is today");
            return null;
        }
        QCircleVVGameConfigBean userHaveBeginCacheTask = getUserHaveBeginCacheTask();
        if (userHaveBeginCacheTask != null && !userHaveBeginCacheTask.isTaskTimeOut()) {
            QLog.d(TAG, 1, "nvvGame load from cache un complete Task");
            return userHaveBeginCacheTask;
        }
        QCircleVVGameConfigBean qCircleVVGameConfigBean = this.mVVConfigBean;
        if (qCircleVVGameConfigBean == null) {
            QLog.d(TAG, 1, "nvvGame configBean is null");
            return null;
        }
        if (qCircleVVGameConfigBean.getVVCount() <= 0) {
            QLog.d(TAG, 1, "nvvGame config count is 0,reason is " + qCircleVVGameConfigBean.getVVReason());
            return null;
        }
        return qCircleVVGameConfigBean;
    }

    public void onCompleteTask() {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(TAG, 1, "onCompleteTask:" + currentTimeMillis);
        this.mLastCompleteTime = currentTimeMillis;
        k.a().n("sp_key_nvv_game_last_complete_time", currentTimeMillis);
        saveHaveBeginTask(null);
    }

    public void resetInfo() {
        QLog.d(TAG, 1, "resetInfo");
        this.mVVConfigBean = null;
        this.mLastCompleteTime = 0L;
    }

    public void setVVConfigBean(QCircleVVGameConfigBean qCircleVVGameConfigBean) {
        this.mVVConfigBean = qCircleVVGameConfigBean;
        QLog.d(TAG, 1, "setVVConfigBean:" + qCircleVVGameConfigBean);
    }
}
