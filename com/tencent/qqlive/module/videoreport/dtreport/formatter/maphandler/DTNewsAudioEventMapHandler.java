package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
class DTNewsAudioEventMapHandler extends DTBaseEventMapHandler {
    private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTNewsAudioEventMapHandler instance = new DTNewsAudioEventMapHandler();

        Holder() {
        }
    }

    DTNewsAudioEventMapHandler() {
    }

    private void formatAudioEndParams(Map<String, Object> map, Map<String, Object> map2) {
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_ENDTIME);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_SESSIONID);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_DURATION_FOREGROUND);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_DURATION_BACKGROUND);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_CONTENTID);
    }

    private void formatAudioHeartParams(Map<String, Object> map, Map<String, Object> map2) {
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_HEARTBEAT_INTERVAL);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_SESSIONID);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_DURATION_FOREGROUND);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_DURATION_BACKGROUND);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_CONTENTID);
    }

    private void formatAudioStartParams(Map<String, Object> map, Map<String, Object> map2) {
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_STARTTIME);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_SESSIONID);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_HEARTBEAT_INTERVAL);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_FILE_INTERVAL);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_PLAY_TYPE);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_PLAYER_TYPE);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_AUDIO_CONTENTID);
    }

    public static DTNewsAudioEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        if (isValidMap(map) && isValidMap(map2)) {
            if (DTEventKey.AUDIO_START.equals(str)) {
                formatAudioStartParams(map, map2);
            } else if (DTEventKey.AUDIO_END.equals(str)) {
                formatAudioEndParams(map, map2);
            } else if (DTEventKey.AUDIO_HEARTBEAT.equals(str)) {
                formatAudioHeartParams(map, map2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
    public Object getOrRemove(@NonNull Map<?, ?> map, String str) {
        return this.mFlattenHelper.getOrRemove(map, str);
    }
}
