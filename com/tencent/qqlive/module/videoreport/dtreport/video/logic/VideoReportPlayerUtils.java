package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.text.TextUtils;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.tpplayer.TPPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes22.dex */
public class VideoReportPlayerUtils {
    private static final int SCENES_ID = 1;
    private static final String TAG = "video.VideoReportPlayerUtils";
    private static final String TP_ASSET_PARAM_KEY_STRING_DT_REPORT_FLOWID = "tp_asset_param_key_string_flowid";
    private static final String TP_ASSET_PARAM_KEY_STRING_DT_REPORT_PLAY_SCENE_TYPE = "tp_asset_param_key_string_play_scene_type";
    private static final String TP_ASSET_PARAM_KEY_STRING_DT_REPORT_VID = "tp_asset_param_key_string_vid";
    private static int sBufferEndEventId;
    private static int sBufferStartEventId;
    private static Method sGeOptionalParamKey;
    private static Method sGetCurrentPosition;
    private static Method sGetDuration;
    private static Method sGetKey;
    private static Method sGetOptionalParamValue;
    private static Method sGetParamLong;
    private static Method sGetParamType;
    private static int sLoopEndId;
    private static int sLoopStartId;
    private static int sParamsTypeLongId;
    private static Field sParamsValue;
    private static Field sScenesId;
    private static int sStartParamsId;
    private static String sStartParamsIdNew;
    private static Class<?> sTpDefaultReportInfoClass;
    private static Class<?> sTpOptionalParamClass;
    private static Class<?> sTpOptionalParamLongClass;
    private static Class<?> sTpPlayerClass;
    private static Field sVid;
    private static Field sVideoEntity;

    /* loaded from: classes22.dex */
    public static class DebugTime {
        private static final String TAG = "DebugTime::";
        private long mStartTime;

        public DebugTime(long j3) {
            this.mStartTime = j3;
        }

        public void debug(String str) {
            Log.d(TAG, str + " time=" + (System.currentTimeMillis() - this.mStartTime));
        }
    }

    public static int convertEventIdToPlayer(int i3) {
        switch (i3) {
            case 1:
                return getEventOfBufferStart();
            case 2:
                return getEventOfBufferEnd();
            case 3:
                return getEventOfSetStartPosition();
            case 4:
                return getEventOfParamTypeLong();
            case 5:
                return getEventOfLoopStart();
            case 6:
                return getEventOfLoopEnd();
            default:
                return -1;
        }
    }

    public static float correctPlaySpeedRatio(float f16) {
        float max = Math.max(Math.min(Math.round(f16 / 0.25f) * 0.25f, 3.0f), 0.5f);
        Log.d(TAG, "correctSpeedRatio origin: " + f16 + ", corrected: " + max);
        return max;
    }

    public static void debugEnd(String str, DebugTime debugTime) {
        if (debugTime != null && VideoReportInner.getInstance().isDebugMode()) {
            debugTime.debug(str);
        }
    }

    public static DebugTime debugStart() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            return new DebugTime(System.currentTimeMillis());
        }
        return null;
    }

    public static String entityLog(VideoEntity videoEntity) {
        return "contentId=" + videoEntity.getContentId() + ", identifyer=" + videoEntity.getIdentifier() + ", contentType=" + videoEntity.getContentType() + ", isBizReady=" + videoEntity.isBizReady();
    }

    private static Field findFieldSafely(Class<?> cls, String str) {
        try {
            return cls.getField(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static long getCurrentPosition(Object obj) {
        try {
            if (sTpPlayerClass == null) {
                sTpPlayerClass = Class.forName("com.tencent.thumbplayer.api.ITPPlayer");
            }
            if (sGetCurrentPosition == null) {
                sGetCurrentPosition = sTpPlayerClass.getDeclaredMethod("getCurrentPositionMs", new Class[0]);
            }
            long longValue = ((Long) sGetCurrentPosition.invoke(obj, new Object[0])).longValue();
            Log.i(TAG, "getCurrentPosition form old,time=" + longValue);
            return longValue;
        } catch (Exception e16) {
            Log.w(TAG, "getCurrentPosition from old," + e16.toString());
            return getCurrentPositionFromNew(obj);
        }
    }

    private static long getCurrentPositionFromNew(Object obj) {
        try {
            if (sTpPlayerClass == null) {
                sTpPlayerClass = ITPPlayer.class;
            }
            if (sGetCurrentPosition == null) {
                sGetCurrentPosition = sTpPlayerClass.getDeclaredMethod("getCurrentPositionMs", new Class[0]);
            }
            long longValue = ((Long) sGetCurrentPosition.invoke(obj, new Object[0])).longValue();
            Log.i(TAG, "getCurrentPosition form new,time=" + longValue);
            return longValue;
        } catch (Exception e16) {
            Log.w(TAG, "getCurrentPosition from new," + e16.toString());
            return 0L;
        }
    }

    public static int getDuration(Object obj) {
        try {
            if (sTpPlayerClass == null) {
                sTpPlayerClass = Class.forName("com.tencent.thumbplayer.api.ITPPlayer");
            }
            if (sGetDuration == null) {
                sGetDuration = sTpPlayerClass.getDeclaredMethod("getDurationMs", new Class[0]);
            }
            int intValue = ((Integer) sGetDuration.invoke(obj, new Object[0])).intValue();
            Log.i(TAG, "getDuration,time=" + intValue);
            return intValue;
        } catch (Exception e16) {
            Log.w(TAG, "getDuration," + e16.toString());
            return getDurationFromNew(obj);
        }
    }

    public static int getDurationFromNew(Object obj) {
        try {
            if (sTpPlayerClass == null) {
                sTpPlayerClass = ITPPlayer.class;
            }
            if (sGetDuration == null) {
                sGetDuration = sTpPlayerClass.getDeclaredMethod("getDurationMs", new Class[0]);
            }
            int intValue = ((Integer) sGetDuration.invoke(obj, new Object[0])).intValue();
            Log.i(TAG, "getDuration,time=" + intValue);
            return intValue;
        } catch (Exception e16) {
            Log.w(TAG, "getDuration," + e16.toString());
            return 0;
        }
    }

    private static int getEventOfBufferEnd() {
        int i3 = sBufferEndEventId;
        if (i3 <= 0) {
            i3 = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", "TP_PLAYER_INFO_LONG0_BUFFERING_END");
            sBufferEndEventId = i3;
        }
        if (i3 == -1) {
            return getEventOfBufferEndFromNew();
        }
        return i3;
    }

    private static int getEventOfBufferEndFromNew() {
        int i3 = sBufferEndEventId;
        if (i3 <= 0) {
            sBufferEndEventId = 201;
            return 201;
        }
        return i3;
    }

    private static int getEventOfBufferStart() {
        int i3 = sBufferStartEventId;
        if (i3 <= 0) {
            i3 = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", "TP_PLAYER_INFO_LONG0_BUFFERING_START");
            sBufferStartEventId = i3;
        }
        if (i3 == -1) {
            return getEventOfBufferStartFromNew();
        }
        return i3;
    }

    private static int getEventOfBufferStartFromNew() {
        int i3 = sBufferStartEventId;
        if (i3 <= 0) {
            sBufferStartEventId = 200;
            return 200;
        }
        return i3;
    }

    private static int getEventOfLoopEnd() {
        int i3 = sLoopEndId;
        if (i3 <= 0) {
            i3 = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", "TP_PLAYER_INFO_LONG0_CURRENT_LOOP_END");
            sLoopEndId = i3;
        }
        if (i3 == -1) {
            return getEventOfLoopEndFromNew();
        }
        return i3;
    }

    private static int getEventOfLoopEndFromNew() {
        int i3 = sLoopEndId;
        if (i3 <= 0) {
            sLoopEndId = 151;
            return 151;
        }
        return i3;
    }

    private static int getEventOfLoopStart() {
        int i3 = sLoopStartId;
        if (i3 <= 0) {
            i3 = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", "TP_PLAYER_INFO_LONG0_CURRENT_LOOP_START");
            sLoopStartId = i3;
        }
        if (i3 == -1) {
            return getEventOfLoopStartFromNew();
        }
        return i3;
    }

    private static int getEventOfLoopStartFromNew() {
        int i3 = sLoopStartId;
        if (i3 <= 0) {
            sLoopStartId = 150;
            return 150;
        }
        return i3;
    }

    private static int getEventOfParamTypeLong() {
        int i3 = sParamsTypeLongId;
        if (i3 <= 0) {
            int staticFiledFromClass = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalParam", "TP_OPTIONAL_RARAM_TYPE_LONG", "TP_OPTIONAL_PARAM_TYPE_LONG");
            sParamsTypeLongId = staticFiledFromClass;
            return staticFiledFromClass;
        }
        return i3;
    }

    private static int getEventOfSetStartPosition() {
        int i3 = sStartParamsId;
        if (i3 <= 0) {
            int staticFiledFromClass = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalID", "OPTION_ID_BEFORE_LONG_START_PLAYING_TIME_MS");
            sStartParamsId = staticFiledFromClass;
            return staticFiledFromClass;
        }
        return i3;
    }

    private static String getEventOfSetStartPositionFromNew() {
        if (!TextUtils.isEmpty(sStartParamsIdNew)) {
            return sStartParamsIdNew;
        }
        sStartParamsIdNew = TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS;
        return TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS;
    }

    public static String getFlowIdFromNewPlayerDataSource(Object obj, Object obj2) {
        try {
            if (obj2 instanceof TPMediaAsset) {
                return ((TPMediaAsset) obj2).getParam("tp_asset_param_key_string_flowid", "");
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return getVidByReportInfo(obj);
        }
    }

    public static long getStartPosition(Object obj) {
        try {
            if (sTpOptionalParamClass == null) {
                sTpOptionalParamClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam");
            }
            if (sGetParamType == null) {
                sGetParamType = sTpOptionalParamClass.getMethod("getParamType", new Class[0]);
            }
            if (((Integer) sGetParamType.invoke(obj, new Object[0])).intValue() != convertEventIdToPlayer(4)) {
                return 0L;
            }
            if (sGetParamLong == null) {
                sGetParamLong = sTpOptionalParamClass.getMethod("getParamLong", new Class[0]);
            }
            Object invoke = sGetParamLong.invoke(obj, new Object[0]);
            if (sTpOptionalParamLongClass == null) {
                sTpOptionalParamLongClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam$OptionalParamLong");
            }
            if (sParamsValue == null) {
                sParamsValue = sTpOptionalParamLongClass.getField("value");
            }
            return ((Long) sParamsValue.get(invoke)).longValue();
        } catch (Exception e16) {
            Log.w(TAG, "getStartPosition," + e16.toString());
            return getStartPositionFormNew(obj);
        }
    }

    public static long getStartPositionFormNew(Object obj) {
        try {
            if (sTpOptionalParamClass == null) {
                sTpOptionalParamClass = TPOptionalParam.class;
            }
            if (sGetOptionalParamValue == null) {
                sGetOptionalParamValue = sTpOptionalParamClass.getMethod(HippyTextInputController.COMMAND_getValue, new Class[0]);
            }
            Object invoke = sGetOptionalParamValue.invoke(obj, new Object[0]);
            if (!(invoke instanceof Long)) {
                return 0L;
            }
            return ((Long) invoke).longValue();
        } catch (Exception e16) {
            Log.w(TAG, "getStartPosition," + e16.toString());
            return 0L;
        }
    }

    private static int getStaticFiledFromClass(String str, String... strArr) {
        try {
            Class<?> cls = Class.forName(str);
            for (String str2 : strArr) {
                Field findFieldSafely = findFieldSafely(cls, str2);
                if (findFieldSafely != null) {
                    return ((Integer) findFieldSafely.get(findFieldSafely)).intValue();
                }
            }
            return -1;
        } catch (Exception e16) {
            Log.w(TAG, "getStaticFiledFromClass," + e16.toString());
            return -1;
        }
    }

    public static String getVidByReportInfo(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (sTpDefaultReportInfoClass == null) {
                sTpDefaultReportInfoClass = Class.forName("com.tencent.thumbplayer.api.report.TPDefaultReportInfo");
            }
            if (sVid == null) {
                sVid = sTpDefaultReportInfoClass.getField("vid");
            }
            return (String) sVid.get(obj);
        } catch (Exception e16) {
            Log.w(TAG, "getVidByReportInfo," + e16.toString());
            return null;
        }
    }

    public static String getVidFromNewPlayerDataSource(Object obj, Object obj2) {
        try {
            if (obj2 instanceof TPMediaAsset) {
                return ((TPMediaAsset) obj2).getParam("tp_asset_param_key_string_vid", "");
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return getVidByReportInfo(obj);
        }
    }

    public static VideoEntity getVideoEntity(Object obj) {
        try {
            if (sTpPlayerClass == null) {
                sTpPlayerClass = TPPlayer.class;
            }
            if (sVideoEntity == null) {
                Field declaredField = sTpPlayerClass.getDeclaredField("mReportParam");
                sVideoEntity = declaredField;
                declaredField.setAccessible(true);
            }
            VideoEntity videoEntity = (VideoEntity) sVideoEntity.get(obj);
            Log.i(TAG, "getVideoEntity form Player");
            return videoEntity;
        } catch (Exception e16) {
            Log.w(TAG, "getVideoEntity form Player" + e16);
            return null;
        }
    }

    public static boolean isPlayAdFormNewPlayerDataSource(Object obj) {
        try {
            if (obj instanceof TPMediaAsset) {
                return "ad".equals(((TPMediaAsset) obj).getParam("tp_asset_param_key_string_play_scene_type", ""));
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean isSetStartPosition(Object obj) {
        try {
            if (sTpOptionalParamClass == null) {
                sTpOptionalParamClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam");
            }
            if (sGetKey == null) {
                sGetKey = sTpOptionalParamClass.getMethod("getKey", new Class[0]);
            }
            if (((Integer) sGetKey.invoke(obj, new Object[0])).intValue() != convertEventIdToPlayer(3)) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            Log.w(TAG, "isSetStartPosition from old, " + e16.toString());
            return isSetStartPositionFromNew(obj);
        }
    }

    public static boolean isSetStartPositionFromNew(Object obj) {
        try {
            if (sTpOptionalParamClass == null) {
                sTpOptionalParamClass = TPOptionalParam.class;
            }
            if (sGeOptionalParamKey == null) {
                sGeOptionalParamKey = sTpOptionalParamClass.getMethod("getKey", new Class[0]);
            }
            Object invoke = sGeOptionalParamKey.invoke(obj, new Object[0]);
            if (invoke instanceof String) {
                return invoke.equals(getEventOfSetStartPositionFromNew());
            }
        } catch (Exception e16) {
            Log.w(TAG, "isSetStartPosition from new, " + e16.toString());
        }
        return false;
    }

    public static String sessionLog(VideoSession videoSession) {
        return "contentId=" + videoSession.getContentId() + ", identifyer=" + videoSession.getIdentifier() + ", contentType=" + videoSession.getContentType() + ", isBizReady=" + videoSession.isBizReady();
    }

    public static String stateToString(int i3) {
        if (i3 != -1) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return "";
                        }
                        return "stoped";
                    }
                    return "paused";
                }
                return "started";
            }
            return "prepared";
        }
        return "init";
    }
}
