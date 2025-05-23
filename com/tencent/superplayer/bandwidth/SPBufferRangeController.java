package com.tencent.superplayer.bandwidth;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.ISPBufferRangeController;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class SPBufferRangeController implements Comparator<Integer[]>, ISPBufferRangeController {
    public static final String CONFIG_EFFECTIVE_TIME = "effective_time";
    public static final String CONFIG_EMERGENCY_TIME = "emergency_time_config";
    public static final String CONFIG_EMERGENCY_TIME_FOR_PREPLAY = "emergency_time_for_preplay";
    public static final String CONFIG_PARAMS_FOR_UNEFFECTIVE_TIME = "uneffective_time_config";
    public static final String CONFIG_SAFE_PLAY_TIME = "safe_play_time_config";
    private static final int DEFAULT_EMERGENCY_TIME_FOR_PREPLAY = 3;
    private static final String TAG = "VideoBufferRangeController";
    private Map<String, String> configMap;
    private ISPBandwidthPredictor predictor;

    public SPBufferRangeController(@NonNull ISPBandwidthPredictor iSPBandwidthPredictor, @NonNull Map<String, String> map) {
        this.predictor = iSPBandwidthPredictor;
        this.configMap = map;
    }

    private int[] computeBufferange(long j3, long j16) {
        int i3;
        long currentPrediction = this.predictor.getCurrentPrediction();
        if (j16 > 0 && j3 > 0) {
            i3 = (int) (((j16 / 1024) * 8) / j3);
        } else {
            i3 = 0;
        }
        LogUtil.d(TAG, "getBufferRange: fileSize=" + j16 + ", duration=" + j3);
        if (!isPeakPeriod(getEffectiveTimeConfigs())) {
            int[] configsForUnPeekPeriod = getConfigsForUnPeekPeriod();
            LogUtil.d(TAG, "computeBufferange: no peak period\uff0cuse defaultConfig, range=" + configsForUnPeekPeriod[0] + ", " + configsForUnPeekPeriod[1]);
            return configsForUnPeekPeriod;
        }
        List<Integer[]> emergencyTimeConfigs = getEmergencyTimeConfigs();
        List<Integer[]> safePlayTimeConfigs = getSafePlayTimeConfigs();
        int judgeStrategy = judgeStrategy(emergencyTimeConfigs, currentPrediction, i3);
        int judgeStrategy2 = judgeStrategy(safePlayTimeConfigs, currentPrediction, i3);
        LogUtil.d(TAG, "getBufferRange: bandwidth=" + currentPrediction + ", bitrate=" + i3 + ", range=" + judgeStrategy + ", " + judgeStrategy2);
        return new int[]{judgeStrategy, judgeStrategy2};
    }

    private List<Integer[]> decodeConfigs(String str) {
        ArrayList arrayList = new ArrayList();
        String str2 = this.configMap.get(str);
        LogUtil.d(TAG, "decodeConfigs: key=" + str + ", configStr=" + str2);
        if (TextUtils.isEmpty(str2)) {
            return arrayList;
        }
        for (String str3 : str2.split("\\|")) {
            String[] split = str3.split(",");
            if (split.length == 2) {
                try {
                    arrayList.add(new Integer[]{Integer.valueOf(split[0]), Integer.valueOf(split[1])});
                } catch (Exception e16) {
                    LogUtil.e(TAG, "getConfigs: ", e16);
                }
            }
        }
        Collections.sort(arrayList, this);
        return arrayList;
    }

    private int[] getConfigsForUnPeekPeriod() {
        Integer[] numArr;
        List<Integer[]> decodeConfigs = decodeConfigs(CONFIG_PARAMS_FOR_UNEFFECTIVE_TIME);
        if (decodeConfigs.size() > 0) {
            numArr = decodeConfigs.get(0);
        } else {
            numArr = new Integer[]{0, 0};
        }
        return new int[]{numArr[0].intValue(), numArr[1].intValue()};
    }

    private List<Integer[]> getEffectiveTimeConfigs() {
        return decodeConfigs(CONFIG_EFFECTIVE_TIME);
    }

    private List<Integer[]> getEmergencyTimeConfigs() {
        return decodeConfigs(CONFIG_EMERGENCY_TIME);
    }

    private List<Integer[]> getSafePlayTimeConfigs() {
        return decodeConfigs(CONFIG_SAFE_PLAY_TIME);
    }

    private boolean isPeakPeriod(List<Integer[]> list) {
        boolean z16;
        int i3 = Calendar.getInstance().get(11);
        Iterator<Integer[]> it = list.iterator();
        while (true) {
            z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Integer[] next = it.next();
            if (i3 >= next[0].intValue()) {
                z16 = true;
                if (i3 < next[1].intValue()) {
                    break;
                }
            }
        }
        return z16;
    }

    private int judgeStrategy(List<Integer[]> list, long j3, int i3) {
        if (j3 > 0 && i3 > 0) {
            for (Integer[] numArr : list) {
                if (j3 > numArr[0].intValue() * (i3 / 8)) {
                    return numArr[1].intValue();
                }
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        Integer[] numArr2 = list.get(list.size() - 1);
        if (numArr2[0].intValue() > 0) {
            return 0;
        }
        return numArr2[1].intValue();
    }

    public void setupBufferRange(ISuperPlayer iSuperPlayer) {
        setupBufferRange(iSuperPlayer, (int) (iSuperPlayer.getDurationMs() / 1000), iSuperPlayer.getFileSizeBytes());
    }

    @Override // java.util.Comparator
    public int compare(Integer[] numArr, Integer[] numArr2) {
        return numArr2[0].intValue() - numArr[0].intValue();
    }

    @Override // com.tencent.superplayer.api.ISPBufferRangeController
    public void setupBufferRange(final ISuperPlayer iSuperPlayer, int i3, long j3) {
        final int[] computeBufferange = computeBufferange(i3, j3);
        final int p16 = CommonUtil.p(this.configMap.get(CONFIG_EMERGENCY_TIME_FOR_PREPLAY), 3);
        ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.bandwidth.SPBufferRangeController.1
            @Override // java.lang.Runnable
            public void run() {
                ISuperPlayer iSuperPlayer2 = iSuperPlayer;
                int[] iArr = computeBufferange;
                int i16 = iArr[0];
                int i17 = iArr[1];
                int i18 = p16;
                iSuperPlayer2.setBusinessDownloadStrategy(i16, i17, i18, i18);
            }
        });
    }
}
