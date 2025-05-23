package cooperation.qqcircle.helpers;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import qqcircle.Hotspots$HotSpotReq;
import qqcircle.Hotspots$HotSpotRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleSilenceInsertHelper {
    public static final String LOG_TAG = "QCircleSilenceInsertHelper";
    private static volatile QCircleSilenceInsertHelper sInstance;
    private int mCurrentFeedPos = -1;
    private Hotspots$HotSpotRsp mHotSpotRsp;
    private long mLastGetListTime;

    public static QCircleSilenceInsertHelper getInstance() {
        if (sInstance == null) {
            synchronized (QCircleSilenceInsertHelper.class) {
                if (sInstance == null) {
                    sInstance = new QCircleSilenceInsertHelper();
                }
            }
        }
        return sInstance;
    }

    private boolean isUiStateSupport() {
        if (QCircleHostGlobalInfo.getFolderUIType() == 3 && this.mCurrentFeedPos >= 0) {
            return true;
        }
        return false;
    }

    private boolean isWnsDisable() {
        if (uq3.c.X0("qqcircle", "qqcircle_disable_hotspot_insert", 0).intValue() != 1) {
            return false;
        }
        return true;
    }

    public void clear() {
        QLog.d(LOG_TAG, 1, QCircleLpReportDc05507.KEY_CLEAR);
        this.mHotSpotRsp = null;
        this.mLastGetListTime = 0L;
        this.mCurrentFeedPos = -1;
    }

    public void clearSilenceInsertFlag() {
        Hotspots$HotSpotRsp hotspots$HotSpotRsp = this.mHotSpotRsp;
        if (hotspots$HotSpotRsp == null) {
            return;
        }
        QLog.d(LOG_TAG, 1, "clearSilenceInsertFlag");
        hotspots$HotSpotRsp.needUpdate.set(false);
    }

    public ByteStringMicro getReqByte() {
        Hotspots$HotSpotReq hotspots$HotSpotReq = new Hotspots$HotSpotReq();
        Hotspots$HotSpotRsp hotspots$HotSpotRsp = this.mHotSpotRsp;
        if (hotspots$HotSpotRsp != null) {
            hotspots$HotSpotReq.attachInfo.set(hotspots$HotSpotRsp.attachInfo.get());
        }
        long j3 = 0;
        if (this.mLastGetListTime != 0) {
            j3 = (System.currentTimeMillis() - this.mLastGetListTime) / 1000;
        }
        QLog.d(LOG_TAG, 1, "getReqByte old hotSpotRsp\uff1a" + hotspots$HotSpotRsp + ",timeInterval:" + j3 + ",mCurrentFeedPos:" + this.mCurrentFeedPos);
        hotspots$HotSpotReq.curFeedPosition.set((long) this.mCurrentFeedPos);
        hotspots$HotSpotReq.intervalFromLastReqFeedList.set(j3);
        return ByteStringMicro.copyFrom(hotspots$HotSpotReq.toByteArray());
    }

    public boolean needSilenceInsert() {
        Hotspots$HotSpotRsp hotspots$HotSpotRsp;
        if (!isUiStateSupport()) {
            QLog.d(LOG_TAG, 1, "needSilenceInsert isUiSupport return false, mCurrentFeedPos:" + this.mCurrentFeedPos);
            return false;
        }
        if (isWnsDisable() || (hotspots$HotSpotRsp = this.mHotSpotRsp) == null) {
            return false;
        }
        return hotspots$HotSpotRsp.needUpdate.get();
    }

    public void receiveHotSpotReqData(Hotspots$HotSpotRsp hotspots$HotSpotRsp) {
        this.mHotSpotRsp = hotspots$HotSpotRsp;
        if (hotspots$HotSpotRsp == null) {
            QLog.d(LOG_TAG, 1, "receiveHotSpotReqData hotSpotRsp\uff1ais null");
            return;
        }
        QLog.d(LOG_TAG, 1, "receiveHotSpotReqData hotSpotRsp\uff1a" + hotspots$HotSpotRsp + ",need request:" + hotspots$HotSpotRsp.needUpdate.get());
    }

    public void refreshGetListTime(long j3) {
        QLog.d(LOG_TAG, 1, "setLastGetListTime:" + j3);
        clearSilenceInsertFlag();
        this.mLastGetListTime = j3;
    }

    public void setCurrentFeedPos(int i3) {
        QLog.d(LOG_TAG, 1, "setCurrentFeedPos:" + i3);
        this.mCurrentFeedPos = i3;
    }
}
