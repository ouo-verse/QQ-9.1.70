package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class SPDownloadEvent {
    private static final String TAG = "SPDownloadEvent";
    private static HashMap<Integer, String> sBossIdMap;
    private int mBossIdInt = 0;
    private Map<String, String> mData = new HashMap();

    SPDownloadEvent() {
        if (sBossIdMap == null) {
            HashMap<Integer, String> hashMap = new HashMap<>();
            sBossIdMap = hashMap;
            hashMap.put(3646, "ServerQuality");
            sBossIdMap.put(8954, "CdnQuality");
            sBossIdMap.put(8877, "DownloadSpeed");
        }
    }

    private void innerParseEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.w(TAG, "parseEvent failed for reportStr is empty");
            return;
        }
        String[] split = str.replaceFirst(".*\\?", "").split(ContainerUtils.FIELD_DELIMITER);
        if (split.length > 0) {
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length >= 2) {
                    this.mData.put(split2[0], split2[1]);
                }
            }
        }
        try {
            this.mBossIdInt = Integer.parseInt(this.mData.get("BossId"));
        } catch (Throwable th5) {
            LogUtil.e(TAG, "parseEvent exception", th5);
        }
    }

    public static SPDownloadEvent parseEvent(String str) {
        SPDownloadEvent sPDownloadEvent = new SPDownloadEvent();
        sPDownloadEvent.innerParseEvent(str);
        return sPDownloadEvent;
    }

    public int getBossIdInt() {
        return this.mBossIdInt;
    }

    public Map<String, String> getDataMap() {
        return this.mData;
    }

    public String getEventName() {
        return sBossIdMap.get(Integer.valueOf(this.mBossIdInt));
    }

    public boolean needReport() {
        return sBossIdMap.containsKey(Integer.valueOf(this.mBossIdInt));
    }
}
