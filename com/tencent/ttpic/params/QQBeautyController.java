package com.tencent.ttpic.params;

import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public class QQBeautyController extends BeautyController {
    private static final String TAG = "QQBeautyController";
    private ConcurrentHashMap<Integer, Boolean> mBasicOpenStatus;

    public QQBeautyController(Map<String, String> map) {
        super(map);
        initBasicBeautyOpenStatus();
    }

    private void initBasicBeautyOpenStatus() {
        if (this.mBasicOpenStatus == null) {
            this.mBasicOpenStatus = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mBasicOpenStatus;
        Boolean bool = Boolean.FALSE;
        concurrentHashMap.put(1, bool);
        this.mBasicOpenStatus.put(2, bool);
        this.mBasicOpenStatus.put(3, bool);
    }

    public void checkAssetMakeup() {
        if (isAssetHasMakeUp(1)) {
            LogUtils.i(TAG, "updateAsset has lips");
            enableBasicBeautyMakeup(1, false);
            enableAssetBeautyMakeup(1, true);
        } else {
            LogUtils.i(TAG, "updateAsset has not lips");
            enableBasicBeautyMakeup(1, this.mBasicOpenStatus.get(1).booleanValue());
        }
        if (isAssetHasMakeUp(3)) {
            LogUtils.i(TAG, "updateAsset has saihong");
            enableBasicBeautyMakeup(3, false);
            enableAssetBeautyMakeup(3, true);
        } else {
            LogUtils.i(TAG, "updateAsset has not saihong");
            enableBasicBeautyMakeup(3, this.mBasicOpenStatus.get(3).booleanValue());
        }
        if (isAssetHasMakeUp(2)) {
            LogUtils.i(TAG, "updateAsset has wuguan");
            enableBasicBeautyMakeup(2, false);
            enableAssetBeautyMakeup(2, true);
        } else {
            LogUtils.i(TAG, "updateAsset has not wuguan");
            enableBasicBeautyMakeup(2, this.mBasicOpenStatus.get(2).booleanValue());
        }
    }

    public boolean isStatus(int i3) {
        if (i3 >= 1 && i3 <= 3) {
            return this.mBasicOpenStatus.get(Integer.valueOf(i3)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ttpic.params.BeautyController
    public void openAndUpdateBasicLips(String str, int i3, int i16) {
        super.openAndUpdateBasicLips(str, i3, i16);
        this.mBasicOpenStatus.put(1, Boolean.valueOf(!TextUtils.isEmpty(str)));
    }

    @Override // com.tencent.ttpic.params.BeautyController
    public void openAndUpdateBasicMultiply(String str, int i3) {
        super.openAndUpdateBasicMultiply(str, i3);
        this.mBasicOpenStatus.put(3, Boolean.valueOf(!TextUtils.isEmpty(str)));
    }

    @Override // com.tencent.ttpic.params.BeautyController
    public void openAndUpdateBasicSoftLight(String str, int i3) {
        super.openAndUpdateBasicSoftLight(str, i3);
        this.mBasicOpenStatus.put(2, Boolean.valueOf(!TextUtils.isEmpty(str)));
    }

    public void openBasicConfigMap(Map<String, String> map, int i3) {
        if (map == null) {
            return;
        }
        map.put("beauty.faceFeature.enable", "true");
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    map.put("beauty.makeupMultiply.enable", "true");
                    return;
                }
                return;
            }
            map.put("beauty.softLight.enable", "true");
            return;
        }
        map.put("beauty.lips.enable", "true");
    }

    public void setBasicValue(int i3, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.configData.put("beauty.faceFeatureRedCheek", formatDecimalValue(i16));
                    return;
                }
                return;
            }
            this.configData.put("beauty.faceFeatureSoftlight", formatDecimalValue(i16));
            return;
        }
        this.configData.put("beauty.faceFeatureLipsLut", formatDecimalValue(i16));
    }
}
