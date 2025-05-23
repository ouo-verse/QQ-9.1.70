package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.VideoLoader;
import com.tencent.oskplayer.model.VideoDecoderType;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeedVideoEnv {
    public static int ADVERTISE_ACTION_BUTTON_HEIGHT = 0;
    public static int ADVERTISE_ACTION_BUTTON_WIDTH = 0;
    public static int ADV_ACTION_TEXT_PADDING_TOP = 0;
    public static int ADV_ACTION_TEXT_PADDING_TOP_12 = 0;
    private static final String CHAR_COMMA = ",";
    private static final String CHAR_SPACE = " ";
    public static boolean CLOSE_HARDWARE_ACCELERATED = false;
    public static Drawable DEFAULT_BACKGROUND = null;
    private static final String DEFAULT_CHAR_TO_MEASURE = "\u89e3";
    private static final String DEFAULT_NUMBER_CHAR_TO_MEASURE = "8";
    private static final String DEFAULT_SIGN_TO_MEASURE = "''";
    public static int DEFAULT_TITLEBAR_HEIGHT = 0;
    public static int DEFAULT_WIDTH = 0;
    public static float DENSITY = -1.0f;
    public static int ERROR_ICON_HEIGTH = 0;
    public static int ERROR_ICON_WIDTH = 0;
    public static int ERROR_RECT_PADDING_TOP = 0;
    public static int ERROR_TEXT_PADDING_TOP = 0;
    private static final int FALSE_INT = 0;
    public static int FLOAT_COMPLETE_ICON_HEIGTH = 0;
    public static int FLOAT_COMPLETE_ICON_WIDTH = 0;
    public static final float GOLDEN_CUDGEL_RATIO = 1.78f;
    public static final int HLS_MODE_LIVE = 1;
    public static final int HLS_MODE_PLAYBACK = 2;
    private static final String LOG_TAG = "FeedVideoEnv";
    public static boolean OPEN_BITMAP = false;
    public static int READY_ICON_HEIGHT = 0;
    public static int READY_ICON_WIDTH = 0;
    public static int REMARK_LAYOUT_HEIGHT = 0;
    public static float SCALED_DENSITY = -1.0f;
    public static int SCREEN_HEIGHT = -1;
    public static int SCREEN_WIDTH = -1;
    public static int TEXT_PADDING_TOP = 0;
    private static final int TRUE_INT = 1;
    public static int actionCharWidth;
    public static Drawable actionIcon;
    public static int advCharWidth;
    public static int advCharWidth_12;
    public static Bitmap bitmapDst;
    public static Bitmap bitmapSrc;
    public static int charWidth;
    public static int commaCharWidth;
    public static Drawable completeMask;
    public static float density;

    /* renamed from: dp1, reason: collision with root package name */
    public static int f279794dp1;
    public static int dp10;
    public static int dp12;
    public static int dp13;
    public static int dp15;
    public static int dp20;
    public static int dp22;
    public static int dp24;
    public static int dp25;
    public static int dp27;
    public static int dp28;

    /* renamed from: dp3, reason: collision with root package name */
    public static int f279795dp3;
    public static int dp32;
    public static int dp33;
    public static int dp34;
    public static int dp35;
    public static int dp37;

    /* renamed from: dp4, reason: collision with root package name */
    public static int f279796dp4;
    public static int dp40;
    public static int dp42;
    public static int dp45;
    public static int dp48;
    public static int dp5;
    public static int dp58;
    public static int dp6;
    public static int dp60;
    public static int dp70;
    public static int dp75;
    public static int dp8;
    public static int dp9;
    public static FeedVideoExternalFunc externalFunc;
    public static FeedResources feedResources;
    public static int floatCharHeigth;
    public static Drawable floatMore;
    public static Drawable floatRedPacket;
    public static Drawable floatReplay;
    public static Drawable freeTrafficPlayIconBg;
    public static Drawable freeTrafficPlayIconButton;
    public static Drawable getMoreBtnNew;
    public static Drawable iconReadyPlay;
    public static Drawable liveVideoEndAnimPic;
    public static Drawable liveVideoStatusEnd;
    public static Drawable liveVideoStatusLive;
    public static Drawable liveVideoStatusReplay;
    private static int mCharWidth12;
    private static int mCharWidth14;
    public static NetworkInfo mCurrNetworkInfo;
    public static PlayerResources playerResources;
    public static Drawable replayBtnNew;
    public static Drawable retryIcon;
    public static long sGetNetworkInfoSpace;
    public static int signWidth;
    public static int spaceCharWidth;
    public static int videoDescCharWidth;
    public static int videoDurationCharWidth;
    public static Drawable videoError;
    public static Drawable videoFloatBgBottom;
    public static Drawable videoFloatBgTop;
    public static int videoPlayCountCharWidth;
    public static int warnCharWidth;
    public static Drawable warnIcon;
    public static Paint sPaint = new Paint(1);
    public static Paint advActionTextPaint = new Paint(1);
    public static Paint advActionTextPaint_12 = new Paint(1);
    public static Paint advActionMaskPaint = new Paint(1);
    public static Paint errorActionMaskPaint = new Paint(1);
    public static Paint errorActionTextPaint = new Paint(1);
    public static Paint retryActionTextPaint = new Paint(1);
    public static Paint warnActionTextPaint = new Paint(1);
    public static Paint actionActionTextPaint = new Paint(1);
    public static Paint actionActionBgPaint = new Paint(1);
    public static Paint videoFloatCompleteMaskPaint = new Paint(1);
    public static Paint videoFloatCompleteTextPaint = new Paint(1);
    public static TextPaint warnActionTextPaintNew = new TextPaint(1);
    public static TextPaint videoDescTextPaint = new TextPaint(1);
    public static TextPaint videoPlayCountTextPaint = new TextPaint(1);
    public static TextPaint videoDurationTimePaint = new TextPaint(1);
    public static TextPaint videoFreeTrafficPaint = new TextPaint(1);
    public static TextPaint videoOpenFreeTrafficPaint = new TextPaint(1);
    private static Double sTpCoreReportSampleRate = null;
    private static ArrayList<String> sBlacklistHLSPlayback = null;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface FeedVideoExternalFunc {
        boolean canVideoPlayAuto();

        void checkVideoIllegal(String str, u uVar);

        void cleanCacheFor403(String str);

        Bitmap drawableToBitmap(Drawable drawable);

        boolean forceUrlExpired();

        View getAvatarImageView(Context context, long j3);

        int getCommentWidth_Rec();

        boolean getCurrentLoadingImgStatus();

        HttpRetryLogic getHttpRetryLogic();

        int getIPStackType();

        boolean getLogLevel();

        long getLoginUin();

        int getNetworkType(Context context);

        HandlerThread getRealTimeThread();

        RunningEnv getRunningEnv();

        void getSafeurl(String str, String str2, String str3, String str4, i iVar);

        List<String> getUgcVideoIp(String str);

        VideoLoader getVideoLoader();

        VideoDecoderType.LocalSetting getVideoPlayerLocalSetting();

        List<String> getWeishiVideoIp(String str);

        int getWnsConfig(String str, String str2, int i3);

        String getWnsConfig(String str, String str2, String str3);

        void gotoVideoSetting(Context context);

        void hidePlayTips();

        void hideWindowPlay();

        void initAutoVideoSetting(Context context);

        boolean initTcDataSource();

        boolean initVideoSdk(k kVar);

        void injectExtraParam(ISuperPlayer iSuperPlayer, SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption);

        void injectPreloadParam(SuperPlayerVideoInfo superPlayerVideoInfo, AtomicLong atomicLong, AtomicLong atomicLong2, SuperPlayerDownOption superPlayerDownOption);

        boolean isDebugVersion();

        boolean isDecoderProbeEnabled();

        boolean isEnable360Video();

        boolean isForceDisableSuperPlayer();

        boolean isForceUseFFPlayer();

        boolean isFreeTraffic();

        boolean isListViewScrollIdle();

        boolean isNetworkAvailable(Context context);

        boolean isPicBigMode();

        boolean isSuperPlayerEnabled();

        boolean isUgcOnCloudUrl(String str);

        boolean needForceVkeyOutDate();

        void notifyVideoStart();

        void openBrowser(String str, int i3, Bundle bundle, String str2);

        void playWith(Context context, VideoPlayInfo videoPlayInfo, String str, VideoPlaybackReportInfo videoPlaybackReportInfo);

        void reportCanvasVideoPlay(String str, int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18);

        void reportClick(String str, String str2, String str3);

        void reportClick(String str, String str2, String str3, boolean z16);

        void reportFeedOpenShortVideoSoundClick();

        void reportMTA(MtaReportConfig mtaReportConfig, HashMap<String, Object> hashMap);

        void reportOnWifiPlay(long j3, long j16, String str, boolean z16);

        void reportTcDownloadProxySuccessRate(boolean z16);

        void reportTcSDK(String str);

        void reportToLp00064(int i3, int i16, int i17);

        void reportVideoPlay(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18, int i19);

        void reportVideoPlay(int i3, boolean z16, boolean z17, boolean z18, int i16, Map<Integer, String> map, int i17, int i18);

        void reportVideoSuccessRate(boolean z16, String str);

        void sendEvent(int i3);

        void showDebugDialog(Context context, String str);

        void showPlayTips(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i3);

        void showToast(String str);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public enum MtaReportConfig {
        MTA_REPORT_KEY_BUFFER_OCCURE_TIMES,
        MTA_REPORT_KEY_PLAY_H265_VIDEO,
        MTA_REPORT_KEY_VIDEO_TRAFFIC_MONITOR,
        MTA_REPORT_KEY_ILLEGAL_VIDEO_INFO,
        MTA_REPORT_KEY_PLAY_HLS_VIDEO,
        MTA_REPORT_KEY_PLAYER_TYPE,
        MTA_REPORT_KEY_FIND_VIDEO_PRELOAD,
        MTA_REPORT_KEY_INTERNAL_ERROR,
        MTA_REPORT_KEY_VIDEO_ACTIVITY,
        MTA_REPORT_KEY_PRELOAD,
        MTA_REPORT_KEY_VIDEO_TYPE,
        MTA_REPORT_KEY_VIDEO_RESOLUTION,
        MTA_REPORT_KEY_H265_DEC_STATS,
        MTA_REPORT_KEY_VIDEO_ENC
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public enum RunningEnv {
        DEFAULT,
        JIEHE_LIVE,
        DULI,
        JIEHE
    }

    public static int PxToDp(float f16) {
        return Math.round(f16 / density);
    }

    public static int dpToPx(float f16) {
        return Math.round(f16 * density);
    }

    public static int getActionCharWidth() {
        if (actionCharWidth <= 0) {
            actionCharWidth = getCharWidth14();
        }
        return actionCharWidth;
    }

    public static Drawable getActionIconDrawable() {
        if (actionIcon == null) {
            actionIcon = feedResources.getDrawable(1131);
        }
        return actionIcon;
    }

    public static int getAdvCharWidth() {
        if (advCharWidth <= 0) {
            advCharWidth = getCharWidth12();
        }
        return advCharWidth;
    }

    public static Context getApplicationContext() {
        return PlayerConfig.g().getAppContext();
    }

    public static int getCharWidth12() {
        if (mCharWidth12 <= 0) {
            Paint paint = new Paint();
            paint.setTextSize(getSpValue(12.0f));
            mCharWidth12 = getTextWidth(DEFAULT_CHAR_TO_MEASURE, paint);
        }
        return mCharWidth12;
    }

    public static int getCharWidth14() {
        if (mCharWidth14 <= 0) {
            Paint paint = new Paint();
            paint.setTextSize(getSpValue(14.0f));
            mCharWidth14 = getTextWidth(DEFAULT_CHAR_TO_MEASURE, paint);
        }
        return mCharWidth14;
    }

    public static int getCommaCharWidth() {
        if (commaCharWidth <= 0) {
            Paint paint = new Paint();
            paint.setTextSize(getSpValue(14.0f));
            commaCharWidth = getTextWidth(",", paint);
        }
        return commaCharWidth;
    }

    public static Drawable getCompleteTaskDrawable() {
        if (completeMask == null) {
            completeMask = feedResources.getDrawable(LaunchScene.LAUNCH_SCENE_VM_NOTIFICATION);
        }
        return completeMask;
    }

    public static float getDensity() {
        if (DENSITY == -1.0f) {
            DENSITY = getApplicationContext().getResources().getDisplayMetrics().density;
        }
        return DENSITY;
    }

    private static void getDisplayMetrics() {
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (i3 < i16) {
            SCREEN_WIDTH = i3;
            SCREEN_HEIGHT = i16;
        } else {
            SCREEN_WIDTH = i16;
            SCREEN_HEIGHT = i3;
        }
    }

    public static int getFloatCharWidth() {
        if (floatCharHeigth <= 0) {
            floatCharHeigth = getCharWidth12();
        }
        return floatCharHeigth;
    }

    public static Drawable getFloatMoreDrawable() {
        if (floatMore == null) {
            floatMore = feedResources.getDrawable(1124);
        }
        return floatMore;
    }

    public static Drawable getFloatRedPacketDrawable() {
        if (floatRedPacket == null) {
            floatRedPacket = feedResources.getDrawable(gdt_analysis_event.EVENT_GET_USER_AGENT);
        }
        return floatRedPacket;
    }

    public static Drawable getFloatReplayDrawable() {
        if (floatReplay == null) {
            floatReplay = feedResources.getDrawable(1126);
        }
        return floatReplay;
    }

    public static Drawable getFreeTrafficPlayIconBg() {
        if (freeTrafficPlayIconBg == null) {
            freeTrafficPlayIconBg = feedResources.getDrawable(1140);
        }
        return freeTrafficPlayIconBg;
    }

    public static Drawable getFreeTrafficPlayIconButton() {
        if (freeTrafficPlayIconButton == null) {
            freeTrafficPlayIconButton = feedResources.getDrawable(com.tencent.luggage.wxa.yh.b.CTRL_INDEX);
        }
        return freeTrafficPlayIconButton;
    }

    public static Drawable getIconReadyPlay() {
        if (iconReadyPlay == null) {
            iconReadyPlay = feedResources.getDrawable(1109);
        }
        return iconReadyPlay;
    }

    public static Drawable getLiveVideoEndAnimPicDrawable() {
        if (liveVideoEndAnimPic == null) {
            liveVideoEndAnimPic = feedResources.getDrawable(1132);
        }
        return liveVideoEndAnimPic;
    }

    public static Drawable getLiveVideoStatusEndDrawable() {
        if (liveVideoStatusEnd == null) {
            liveVideoStatusEnd = feedResources.getDrawable(IWeiyunResponseHandler.ERROR_DISK_SERVER_CODE_FLOW_LIMIT);
        }
        return liveVideoStatusEnd;
    }

    public static Drawable getLiveVideoStatusLiveDrawable() {
        if (liveVideoStatusLive == null) {
            liveVideoStatusLive = feedResources.getDrawable(1128);
        }
        return liveVideoStatusLive;
    }

    public static Drawable getLiveVideoStatusReplayDrawable() {
        if (liveVideoStatusReplay == null) {
            liveVideoStatusReplay = feedResources.getDrawable(1129);
        }
        return liveVideoStatusReplay;
    }

    public static Drawable getMoreBtnNew() {
        if (getMoreBtnNew == null) {
            getMoreBtnNew = feedResources.getDrawable(1135);
        }
        return getMoreBtnNew;
    }

    public static int getNetworkType() {
        FeedVideoExternalFunc feedVideoExternalFunc = externalFunc;
        if (feedVideoExternalFunc != null) {
            return feedVideoExternalFunc.getNetworkType(getApplicationContext());
        }
        return -1;
    }

    public static int getNumberCharWidth() {
        Paint paint;
        if (charWidth <= 0 && (paint = sPaint) != null) {
            charWidth = getTextWidth("8", paint);
        }
        return charWidth;
    }

    public static Drawable getReplayBtnNew() {
        if (replayBtnNew == null) {
            replayBtnNew = feedResources.getDrawable(1134);
        }
        return replayBtnNew;
    }

    public static Drawable getRetryIconDrawable() {
        if (retryIcon == null) {
            retryIcon = feedResources.getDrawable(1119);
        }
        return retryIcon;
    }

    public static float getScaledDensity() {
        if (SCALED_DENSITY == -1.0f) {
            SCALED_DENSITY = getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
        }
        return SCALED_DENSITY;
    }

    public static int getScreenHeight() {
        if (SCREEN_HEIGHT == -1) {
            getDisplayMetrics();
        }
        return SCREEN_HEIGHT;
    }

    public static int getScreenWidth() {
        if (SCREEN_WIDTH == -1) {
            getDisplayMetrics();
        }
        return SCREEN_WIDTH;
    }

    public static float getSpValue(float f16) {
        return TypedValue.applyDimension(2, f16, getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int getSpaceCharWidth() {
        if (spaceCharWidth <= 0) {
            Paint paint = new Paint();
            paint.setTextSize(getSpValue(14.0f));
            spaceCharWidth = getTextWidth(" ", paint);
        }
        return spaceCharWidth;
    }

    private static int getTextWidth(String str, Paint paint) {
        int measureText;
        long currentTimeMillis = System.currentTimeMillis();
        PlayerUtils.log(4, LOG_TAG, "getTextWidth start: " + str);
        if (Build.VERSION.SDK_INT >= 29) {
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            measureText = rect.width();
        } else {
            measureText = (int) paint.measureText(str);
        }
        PlayerUtils.log(4, LOG_TAG, "getTextWidth cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return measureText;
    }

    public static double getTpCoreSampleRate() {
        Double d16 = sTpCoreReportSampleRate;
        if (d16 != null) {
            return d16.doubleValue();
        }
        FeedVideoExternalFunc feedVideoExternalFunc = externalFunc;
        if (feedVideoExternalFunc != null) {
            String wnsConfig = feedVideoExternalFunc.getWnsConfig("QZVideo", "qzone_player_report_rate", "0");
            PlayerUtils.log(4, LOG_TAG, "getTpCoreSampleRate wns value:" + wnsConfig);
            if (!TextUtils.isEmpty(wnsConfig)) {
                try {
                    double parseDouble = Double.parseDouble(wnsConfig);
                    if (parseDouble >= 0.0d && parseDouble <= 1.0d) {
                        Double valueOf = Double.valueOf(parseDouble);
                        sTpCoreReportSampleRate = valueOf;
                        return valueOf.doubleValue();
                    }
                } catch (NumberFormatException e16) {
                    PlayerUtils.log(6, LOG_TAG, "getTpCoreSampleRate wns value parse error:" + e16);
                }
            }
        }
        return 0.0d;
    }

    public static int getVideoDescCharWidth() {
        if (videoDescCharWidth <= 0) {
            videoDescCharWidth = getCharWidth12();
        }
        return videoDescCharWidth;
    }

    public static Drawable getVideoErrorDrawable() {
        if (videoError == null) {
            videoError = feedResources.getDrawable(1120);
        }
        return videoError;
    }

    public static Drawable getVideoFloatBgBottomDrawable() {
        if (videoFloatBgBottom == null) {
            videoFloatBgBottom = feedResources.getDrawable(1139);
        }
        return videoFloatBgBottom;
    }

    public static Drawable getVideoFloatBgTopDrawable() {
        if (videoFloatBgTop == null) {
            videoFloatBgTop = feedResources.getDrawable(com.tencent.luggage.wxa.ef.h.CTRL_INDEX);
        }
        return videoFloatBgTop;
    }

    public static int getWarnCharWidth() {
        if (warnCharWidth <= 0) {
            warnCharWidth = getCharWidth14();
        }
        return warnCharWidth;
    }

    public static Drawable getWarnIconDrawable() {
        if (warnIcon == null) {
            warnIcon = feedResources.getDrawable(BusinessInfoCheckUpdateItem.UIAPPID_KANDIAN);
        }
        return warnIcon;
    }

    public static void init(FeedResources feedResources2, PlayerResources playerResources2, FeedVideoExternalFunc feedVideoExternalFunc) {
        PlayerUtils.log(4, LOG_TAG, "michal9 FeedVideoEnv init! pid=" + Process.myPid());
        feedResources = feedResources2;
        playerResources = playerResources2;
        externalFunc = feedVideoExternalFunc;
    }

    private static boolean isMainThread() {
        Looper mainLooper = Looper.getMainLooper();
        return mainLooper != null && mainLooper.getThread() == Thread.currentThread();
    }

    public static boolean isMobileConnected() {
        FeedVideoExternalFunc feedVideoExternalFunc = externalFunc;
        return feedVideoExternalFunc != null && feedVideoExternalFunc.getNetworkType(getApplicationContext()) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isModelInHLSBlackList(int i3) {
        String str;
        String lowerCase;
        if (i3 == 1) {
            str = externalFunc.getWnsConfig("VideoSDKSetting", "VideoBlackListHlsLive", "vivo X6a;VIVO xplay5A;MI 4S;LG-H968;");
        } else if (i3 != 2) {
            str = "";
        } else {
            str = externalFunc.getWnsConfig("VideoSDKSetting", "VideoBlackListHlsPlayback", "vivo X6a;VIVO xplay5A;MI 4S;LG-H968;");
        }
        if (DeviceInfoMonitor.getModel() == null) {
            lowerCase = "";
        } else {
            lowerCase = DeviceInfoMonitor.getModel().trim().toLowerCase();
        }
        String lowerCase2 = (TextUtils.isEmpty(str) ? "" : str).toLowerCase();
        if (sBlacklistHLSPlayback == null) {
            sBlacklistHLSPlayback = parseList(lowerCase2, ";");
        }
        if (sBlacklistHLSPlayback.size() <= 0) {
            return false;
        }
        Iterator<String> it = sBlacklistHLSPlayback.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), lowerCase)) {
                PlayerUtils.log(4, LOG_TAG, "current machine model:" + lowerCase + " in hls black list");
                return true;
            }
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        FeedVideoExternalFunc feedVideoExternalFunc = externalFunc;
        return feedVideoExternalFunc != null && feedVideoExternalFunc.isNetworkAvailable(context);
    }

    private static boolean isNetworkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return true;
        }
        if (URLUtil.isFileUrl(str)) {
            return false;
        }
        return URLUtil.isNetworkUrl(str);
    }

    public static boolean isWifiConnected() {
        FeedVideoExternalFunc feedVideoExternalFunc = externalFunc;
        return feedVideoExternalFunc != null && feedVideoExternalFunc.getNetworkType(getApplicationContext()) == 1;
    }

    private static ArrayList<String> parseList(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : str.split(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    arrayList.add(str3.trim());
                }
            }
        }
        return arrayList;
    }

    private static void preMeasureText() {
        charWidth = getTextWidth("8", sPaint);
        signWidth = getTextWidth(DEFAULT_SIGN_TO_MEASURE, sPaint);
        advCharWidth = getTextWidth(DEFAULT_CHAR_TO_MEASURE, advActionTextPaint);
        advCharWidth_12 = getTextWidth(DEFAULT_CHAR_TO_MEASURE, advActionTextPaint_12);
        warnCharWidth = getTextWidth(DEFAULT_CHAR_TO_MEASURE, warnActionTextPaint);
        commaCharWidth = getTextWidth(",", warnActionTextPaint);
        spaceCharWidth = getTextWidth(" ", warnActionTextPaint);
        actionCharWidth = getTextWidth(DEFAULT_CHAR_TO_MEASURE, actionActionTextPaint);
        floatCharHeigth = getTextWidth(DEFAULT_CHAR_TO_MEASURE, videoFloatCompleteTextPaint);
        videoDescCharWidth = getTextWidth(DEFAULT_CHAR_TO_MEASURE, videoDescTextPaint);
        videoPlayCountCharWidth = getTextWidth(DEFAULT_CHAR_TO_MEASURE, videoPlayCountTextPaint);
        videoDurationCharWidth = getTextWidth(DEFAULT_CHAR_TO_MEASURE, videoDurationTimePaint);
    }

    private static void preloadDrawable() {
        getFreeTrafficPlayIconBg();
        getFreeTrafficPlayIconButton();
        getIconReadyPlay();
        getReplayBtnNew();
        getMoreBtnNew();
        getCompleteTaskDrawable();
        getVideoErrorDrawable();
        getRetryIconDrawable();
        getWarnIconDrawable();
        getActionIconDrawable();
        getFloatReplayDrawable();
        getFloatRedPacketDrawable();
        getFloatMoreDrawable();
        getLiveVideoStatusEndDrawable();
        getLiveVideoStatusLiveDrawable();
        getLiveVideoStatusReplayDrawable();
        getLiveVideoEndAnimPicDrawable();
        getVideoFloatBgTopDrawable();
        getVideoFloatBgBottomDrawable();
    }

    public static void preloadResource(FeedResources feedResources2, FeedVideoExternalFunc feedVideoExternalFunc) {
        getDisplayMetrics();
        setH265ReportKeyVersion();
        density = getDensity();
        SCREEN_WIDTH = getScreenWidth();
        preloadDpValue();
        REMARK_LAYOUT_HEIGHT = dp42 + f279794dp1;
        DEFAULT_BACKGROUND = new ColorDrawable(feedResources2.getColor(1642));
        bitmapDst = feedVideoExternalFunc.drawableToBitmap(feedResources2.getDrawable(1115));
        bitmapSrc = feedVideoExternalFunc.drawableToBitmap(feedResources2.getDrawable(1116));
        DEFAULT_WIDTH = getScreenWidth() - (((int) (getScaledDensity() * 10.0f)) * 2);
        sPaint.setColor(-1);
        sPaint.setTextSize(getSpValue(12.0f));
        TEXT_PADDING_TOP = (int) (((dp22 - sPaint.descent()) - sPaint.ascent()) / 2.0f);
        advActionTextPaint.setColor(-1);
        advActionTextPaint.setTextSize(getSpValue(12.0f));
        advActionTextPaint_12.setColor(-1);
        advActionTextPaint_12.setTextSize(getSpValue(12.0f));
        errorActionTextPaint.setColor(-1);
        errorActionTextPaint.setTextSize(getSpValue(14.0f));
        warnActionTextPaint.setColor(-1);
        warnActionTextPaint.setTextSize(getSpValue(14.0f));
        warnActionTextPaintNew.setColor(-1);
        warnActionTextPaintNew.setTextSize(getSpValue(14.0f));
        actionActionTextPaint.setColor(-1);
        actionActionTextPaint.setTextSize(getSpValue(12.0f));
        retryActionTextPaint.setColor(-1);
        retryActionTextPaint.setAlpha(128);
        videoFloatCompleteTextPaint.setColor(-1);
        videoFloatCompleteTextPaint.setAlpha(230);
        videoFloatCompleteTextPaint.setTextSize(getSpValue(12.0f));
        videoFloatCompleteMaskPaint.setColor(Color.argb(102, 0, 0, 0));
        videoDescTextPaint.setColor(-1);
        videoDescTextPaint.setTextSize(getSpValue(16.0f));
        videoDescTextPaint.setShadowLayer(dpToPx(2.0f), 0.0f, dpToPx(1.0f), -16777216);
        videoPlayCountTextPaint.setColor(-1);
        videoPlayCountTextPaint.setAlpha(204);
        videoPlayCountTextPaint.setTextSize(getSpValue(12.0f));
        videoPlayCountTextPaint.setShadowLayer(dpToPx(2.0f), 0.0f, dpToPx(1.0f), -16777216);
        videoDurationTimePaint.setColor(-1);
        videoDurationTimePaint.setAlpha(179);
        videoDurationTimePaint.setTextSize(getSpValue(12.0f));
        videoDurationTimePaint.setShadowLayer(dpToPx(2.0f), 0.0f, dpToPx(1.0f), -16777216);
        videoFreeTrafficPaint.setColor(-1);
        videoFreeTrafficPaint.setTextSize(getSpValue(16.0f));
        ADV_ACTION_TEXT_PADDING_TOP = (int) (((dp42 - advActionTextPaint.descent()) - advActionTextPaint.ascent()) / 2.0f);
        ADV_ACTION_TEXT_PADDING_TOP_12 = (int) (((dpToPx(39.0f) - advActionTextPaint_12.descent()) - advActionTextPaint_12.ascent()) / 2.0f);
        ERROR_TEXT_PADDING_TOP = (int) (((dp42 + errorActionTextPaint.ascent()) - errorActionTextPaint.descent()) / 2.0f);
        ERROR_RECT_PADDING_TOP = (int) (((dp40 + errorActionTextPaint.ascent()) - errorActionTextPaint.descent()) / 2.0f);
        if (externalFunc.getWnsConfig("VideoSDKSetting", "feedVideoPreMeasureText", 0) == 1) {
            PlayerUtils.log(4, LOG_TAG, "preMeasureText start: " + System.currentTimeMillis());
            preMeasureText();
            PlayerUtils.log(4, LOG_TAG, "preMeasureText end: " + System.currentTimeMillis());
        } else {
            PlayerUtils.log(4, LOG_TAG, "disable preMeasureText");
        }
        advActionMaskPaint.setColor(Color.argb(128, 0, 0, 0));
        errorActionMaskPaint.setColor(Color.argb(204, 0, 0, 0));
        actionActionBgPaint.setColor(Color.argb(102, 0, 0, 0));
        videoOpenFreeTrafficPaint.setColor(Color.argb(255, 255, 255, 255));
        videoOpenFreeTrafficPaint.setTextSize(getSpValue(14.0f));
        preloadDrawable();
        READY_ICON_WIDTH = dpToPx(50.0f);
        READY_ICON_HEIGHT = dpToPx(50.0f);
        ADVERTISE_ACTION_BUTTON_WIDTH = dpToPx(40.0f);
        ADVERTISE_ACTION_BUTTON_HEIGHT = dpToPx(40.0f);
        FLOAT_COMPLETE_ICON_WIDTH = dpToPx(27.0f);
        FLOAT_COMPLETE_ICON_HEIGTH = dpToPx(25.0f);
        ERROR_ICON_WIDTH = dpToPx(15.0f);
        ERROR_ICON_HEIGTH = dpToPx(15.0f);
        DEFAULT_TITLEBAR_HEIGHT = (int) (getDensity() * 76.0f);
    }

    static void setH265ReportKeyVersion() {
        FeedVideoExternalFunc feedVideoExternalFunc = externalFunc;
        if (feedVideoExternalFunc != null) {
            int wnsConfig = feedVideoExternalFunc.getWnsConfig("VideoSDKSetting", "VideoDecodeScoreReportVersion", 2);
            PlayerUtils.log(4, LOG_TAG, "h265debug cfg h265ReportKeyVersion=" + wnsConfig);
            PlayerUtils.setH265ReportKeyVersion(wnsConfig);
        }
    }

    public static boolean isUrlEmpty(PictureUrl pictureUrl) {
        return pictureUrl == null || TextUtils.isEmpty(pictureUrl.url);
    }

    private static void preloadDpValue() {
        f279794dp1 = dpToPx(1.0f);
        f279795dp3 = dpToPx(3.0f);
        f279796dp4 = dpToPx(4.0f);
        dp5 = dpToPx(5.0f);
        dp6 = dpToPx(6.0f);
        dp8 = dpToPx(8.0f);
        dp9 = dpToPx(9.0f);
        dp10 = dpToPx(10.0f);
        dp12 = dpToPx(12.0f);
        dp13 = dpToPx(13.0f);
        dp15 = dpToPx(15.0f);
        dp20 = dpToPx(20.0f);
        dp22 = dpToPx(22.0f);
        dp24 = dpToPx(24.0f);
        dp25 = dpToPx(25.0f);
        dp27 = dpToPx(27.0f);
        dp28 = dpToPx(28.0f);
        dp32 = dpToPx(32.0f);
        dp33 = dpToPx(33.0f);
        dp34 = dpToPx(34.0f);
        dp35 = dpToPx(35.0f);
        dp37 = dpToPx(37.0f);
        dp40 = dpToPx(40.0f);
        dp42 = dpToPx(42.0f);
        dp45 = dpToPx(45.0f);
        dp48 = dpToPx(48.0f);
        dp58 = dpToPx(58.0f);
        dp60 = dpToPx(60.0f);
        dp70 = dpToPx(70.0f);
        dp75 = dpToPx(76.0f);
    }

    public static String getUrlKey(String str, boolean z16) {
        if (str == null) {
            return null;
        }
        if (!z16) {
            z16 = isNetworkUrl(str);
        }
        if (!z16) {
            return str;
        }
        int indexOf = str.indexOf(47, 8);
        int indexOf2 = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf == -1) {
            return str;
        }
        if (indexOf2 != -1) {
            return str.substring(indexOf + 1, indexOf2);
        }
        return str.substring(indexOf + 1);
    }

    public static boolean isGoldenCudgel(int i3, int i16) {
        return Math.ceil((double) (((float) i3) * 1.78f)) < ((double) i16);
    }

    public static String getShownTimeFromNumeric(long j3) {
        StringBuilder sb5;
        String str;
        int i3;
        Object obj;
        if (j3 >= 60000) {
            int round = (int) Math.round(((j3 % 60000) * 1.0d) / 1000.0d);
            if (round >= 60) {
                i3 = round / 60;
                round %= 60;
            } else {
                i3 = 0;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append((j3 / 60000) + i3);
            sb6.append(":");
            if (round > 9) {
                obj = Integer.valueOf(round);
            } else {
                obj = "0" + round;
            }
            sb6.append(obj);
            return sb6.toString();
        }
        int round2 = (int) Math.round((j3 * 1.0d) / 1000.0d);
        if (round2 == 60) {
            return "1:00";
        }
        if (round2 > 9) {
            sb5 = new StringBuilder();
            str = "0:";
        } else {
            sb5 = new StringBuilder();
            str = "0:0";
        }
        sb5.append(str);
        sb5.append(round2);
        return sb5.toString();
    }
}
