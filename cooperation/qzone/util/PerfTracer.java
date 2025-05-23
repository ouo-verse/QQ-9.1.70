package cooperation.qzone.util;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes28.dex */
public final class PerfTracer {
    public static final String APP_ONCREATE = "App_onCreate";
    public static final String BASEFEED_SUPER_ONCREATE = "BaseFeed_super_onCreate";
    public static final String CLICK2LOADACTIVITYCREATE = "click2LoadActivityCreate";
    public static final String CLICK2LOADCOMPLETED = "click2LoadCompleted";
    public static final String ClICK2WINDOWSHOW = "click2WindowShow";
    public static final String DETAIL_INIT = "Detail_init";
    public static final String DETAIL_INITEMOVIEW = "Detail_initEmoView";
    public static final String DETAIL_ONCREATE = "Detail_onCreate";
    public static final String DETAIL_ONRESUME = "Detail_onResume";
    public static final String DETAIL_RENDER = "Detail_render";
    public static final String EXTEND_FEED_DELAYSHOW = "ExtendFeed__delayShow";
    public static final String EXTEND_FEED_FRAGMENT_ONCREATE = "ExtendFeed_fragement_onActivityCreated";
    public static final String EXTEND_FEED_INITDATA = "ExtendFeed_initData";
    public static final String EXTEND_FEED_INITFAKEUI = "ExtendFeed_initFakeUI";
    public static final String EXTEND_FEED_INITHEADER = "ExtendFeed_initHeader";
    public static final String EXTEND_FEED_INITUI = "ExtendFeed_initUI";
    public static final String EXTEND_FEED_ONCREATE = "ExtendFeed_onCreate";
    public static final String EXTEND_FEED_ONCREATE2WINDOWFOCUS = "ExtendFeed_onCreate2WindowFocus";
    public static final String EXTEND_FEED_ONRESUME = "ExtendFeed_onResume";
    public static final String EXTEND_FEED_PARSEINTENT = "ExtendFeed_parseIntent";
    public static final String EXTEND_FEED_SUPER_ONCREATE = "ExtendFeed_Super_onCreate";
    public static final String FRENIDFEED_GET_VIEW = "Friendfeed_getview";
    public static final String FRIENDFEED_DELAYSHOW = "FriendFeed_delayShow";
    public static final String FRIENDFEED_FRAGMENT_ONCREATE = "FriendFeed_fragement_onActivityCreated";
    public static final String FRIENDFEED_INITDATA = "FriendFeed_initData";
    public static final String FRIENDFEED_INITFAKEUI = "FriendFeed_initFakeUI";
    public static final String FRIENDFEED_INITHEADER = "FriendFeed_initHeader";
    public static final String FRIENDFEED_INITHEADER_COVER = "FriendFeed_initHeader_Cover";
    public static final String FRIENDFEED_INITUI = "FriendFeed_initUI";
    public static final String FRIENDFEED_ONCREATE = "FriendFeed_onCreate";
    public static final String FRIENDFEED_ONCREATE2WINDOWFOCUS = "FriendFeed_onCreate2WindowFocus";
    public static final String FRIENDFEED_ONRESUME = "FriendFeed_onResume";
    public static final String FRIENDFEED_PARSEINTENT = "FriendFeed_parseIntent";
    public static final String FRIENDFEED_PHOTOGUIDEBANNERSHOW = "FriendFeed_photoGuidebannerShow";
    public static final String FRIENDFEED_SUPER_ONCREATE = "FriendFeed_Super_onCreate";
    public static final String MOODLIST_INITDATA = "MoodList_initData";
    public static final String MOODLIST_INITUI = "MoodList_initUI";
    public static final String MOODLIST_ONCREATE = "MoodList_onCreate";
    public static final String MYFEED_INITDATA = "MyFeed_initData";
    public static final String MYFEED_INITUI = "MyFeed_initUI";
    public static final String MYFEED_ONCREATE = "MyFeed_onCreate";
    public static final String MYFEED_ONRESUME = "MyFeed_onResume";
    public static final String NUAN_FRIEND_FEED_DELAYSHOW = "ExtendFeed__delayShow";
    public static final String NUAN_FRIEND_FEED_FRAGMENT_ONCREATE = "ExtendFeed_fragement_onActivityCreated";
    public static final String NUAN_FRIEND_FEED_INITDATA = "ExtendFeed_initData";
    public static final String NUAN_FRIEND_FEED_INITFAKEUI = "ExtendFeed_initFakeUI";
    public static final String NUAN_FRIEND_FEED_INITHEADER = "ExtendFeed_initHeader";
    public static final String NUAN_FRIEND_FEED_INITUI = "ExtendFeed_initUI";
    public static final String NUAN_FRIEND_FEED_ONCREATE = "ExtendFeed_onCreate";
    public static final String NUAN_FRIEND_FEED_ONCREATE2WINDOWFOCUS = "ExtendFeed_onCreate2WindowFocus";
    public static final String NUAN_FRIEND_FEED_ONRESUME = "ExtendFeed_onResume";
    public static final String NUAN_FRIEND_FEED_PARSEINTENT = "ExtendFeed_parseIntent";
    public static final String NUAN_FRIEND_FEED_SUPER_ONCREATE = "ExtendFeed_Super_onCreate";
    public static final String PARAM_CLICK_TIME = "click_time";
    public static final String PARAM_STARTUP_SCENEID = "startup_sceneid";
    public static final String PHOTOWALL_INITDATA = "PhotoWall_initData";
    public static final String PHOTOWALL_INITUI = "PhotoWall_initUI";
    public static final String PHOTOWALL_ONCREATE = "PhotoWall_onCreate";
    public static final String PHOTOWALL_ONRESUME = "PhotoWall_onResume";
    public static final String PRELOAD_ADV_FEED_VIEW = "Prload_advFeedView";
    public static final String PRELOAD_AVATAR = "Preload_Avatar";
    public static final String PRELOAD_CONTENT_VIEW = "Preload_contentView";
    public static final String PRELOAD_COVER = "Preload_Cover";
    public static final String PRELOAD_FEED_VIEW = "Preload_Feed_View";
    public static final String PRELOAD_FEED_VIEW_SECTIONS = "Preload_Feed_View_Sections";
    public static final String PRELOAD_FRIENDFEED_DATA = "Preload_FriendFeedData";
    public static final String PRELOAD_HEAD_VIEW = "Preload_headView";
    public static final String PRELOAD_LOAD_FRIENDFEED_CLASS = "Preload_New_FriendFeed";
    public static final String PRELOAD_LOAD_USERHOME_CLASS = "Preload_Load_UserHome_Class";
    public static final String PRELOAD_NAVIGATOR_RES = "Preload_Navigator_Res";
    public static final String PRELOAD_NICK_NAME = "Preload_Nick_Name";
    public static final String PRELOAD_QCIRCLE_PUBLISH_CLASS = "Preload_Qcircle_Publish_Class";
    public static final String PRELOAD_QCIRCLE_PUBLISH_LAYOUT = "Preload_Qcircle_Publish_Layout";
    public static final String PRELOAD_QUNFEED_DATA = "Preload_QunFeedData";
    public static final String PRELOAD_USERHOME_LAYOUT = "Preload_UserHomeLayout";
    public static final String PUBLISHMOOD_INITDATA = "PublishMood_initData";
    public static final String PUBLISHMOOD_INITUI = "PublishMood_initUI";
    public static final String PUBLISHMOOD_ONCREATE = "PublishMood_onCreate";
    public static final String PUBLISHMOOD_ONRESUME = "PublishMood_onResume";
    public static final String PUBLISHMOOD_STATE_INIT = "PublishMood_state_init";
    public static final String QUNALBUM_INITDATA = "QunAlbum_initData";
    public static final String QUNALBUM_INITUI = "QunAlbum_initUI";
    public static final String QUNALBUM_ONCREATE = "QunAlbum_onCreate";
    public static final String QUNALBUM_ONRESUME = "QunAlbum_onResume";
    public static final String QUNALBUM_PARSEINTENT = "QunAlbum_parseIntent";
    public static final String QUNALBUM_STATE_INIT = "QunAlbum_state_init";
    public static final String QUNFEED_INITDATA = "QunFeed_initData";
    public static final String QUNFEED_INITUI = "QunFeed_initUI";
    public static final String QUNFEED_ONCREATE = "QunFeed_onCreate";
    public static final String QUNFEED_ONRESUME = "QunFeed_onResume";
    public static final String QUNFEED_PARSEINTENT = "QunFeed_parseIntent";
    public static final String QZONEALBUM_INITDATA = "QzoneAlbum_initData";
    public static final String QZONEALBUM_INITUI = "QzoneAlbum_initUI";
    public static final String QZONEALBUM_ONCREATE = "QzoneAlbum_onCreate";
    public static final String QZONEALBUM_ONRESUME = "QzoneAlbum_onResume";
    public static final String QZONEALBUM_PARSEINTENT = "QzoneAlbum_parseIntent";
    public static final String QZONEALBUM_SHOW = "QzoneAlbum_show";
    public static final String REACT_ONCREATE = "React_onCreate";
    public static final String RUNTIME_BUSINESS_ONLOGIN = "Runtime_Business_onLogin";
    public static final String RUNTIME_FEED_ENV_INIT = "Runtime_Feed_Env_Init";
    public static final String RUNTIME_FIRST_INIT = "Runtime_first_init";
    public static final String RUNTIME_INIT_SKIN = "Runtime_init_skin";
    public static final String RUNTIME_LOAD_LIVE_MAIN_RUNTIME = "Runtime_load_live_main_runtime";
    public static final String RUNTIME_LOAD_MAIN_RUNTIME = "Runtime_load_main_runtime";
    public static final String RUNTIME_LOAD_RUNTIME = "Runtime_load_runtime";
    public static final String RUNTIME_ONCREATE = "Runtime_onCreate";
    public static final String RUNTIME_RUN_IN_QQ = "Runtime_run_in_qq";
    public static final String RUNTIME_SUPER_ONCREATE = "Runtime_super_onCreate";
    public static final String RUNTIME_VIDEO_INIT = "Runtime_Video_Init";
    public static final int STARTUP_SCENEID_ALBUM = 3;
    public static final int STARTUP_SCENEID_DETAIL = 4;
    public static final int STARTUP_SCENEID_EXTEND_FEEDS = 7;
    public static final int STARTUP_SCENEID_FRIEND_FEED = 1;
    public static final int STARTUP_SCENEID_GROUPFEED = 8;
    public static final int STARTUP_SCENEID_PUBLISHMOOD = 5;
    public static final int STARTUP_SCENEID_UPLOADPHOTO = 6;
    public static final int STARTUP_SCENEID_USERHOME = 2;
    private static final String SUB_TAG = "FeedsScrollPerformanceAutoMonitor";
    private static final String TAG = "Perf.Qzone";
    public static final String THREADTIME_TAG = "threadtime";
    public static final boolean TRACE = true;
    public static final String UPLOADPHOTO_INITDATA = "UploadPhoto_initData";
    public static final String UPLOADPHOTO_INITEMOVIEW = "UploadPhoto_initEmoView";
    public static final String UPLOADPHOTO_INITUI = "UploadPhoto_initUI";
    public static final String UPLOADPHOTO_ONCREATE = "UploadPhoto_onCreate";
    public static final String UPLOADPHOTO_ONRESUME = "UploadPhoto_onResume";
    public static final String UPLOADPHOTO_STATE_INIT = "UploadPhoto_state_init";
    public static final String USERHOME_HEADRESUME = "UserHome_Header_Resume";
    public static final String USERHOME_INITDATA = "UserHome_initData";
    public static final String USERHOME_INITHEADER = "UserHome_initHeader";
    public static final String USERHOME_INITUI = "UserHome_initUI";
    public static final String USERHOME_ONCREATE = "UserHome_onCreate";
    public static final String USERHOME_ONRESUME = "UserHome_onResume";
    public static final String USERHOME_PARSEINTENT = "UserHome_parseIntent";
    public static final String USERHOME_PERFORMREPORTRESUME = "UserHome_PerformanceReport_Resume";
    public static final String VIDEO_COMPONENT_ONCREATE = "Video_component_onCreate";
    public static final String VIDEO_COMPONENT_PRE_LAUNCH = "Video_component_pre_launch";
    public static final ConcurrentHashMap<String, Long> sLogs = new ConcurrentHashMap<>(new HashMap(8));

    /* loaded from: classes28.dex */
    public interface PerfTimeReport {
        void reportPerfTime(TimeCostTrace timeCostTrace);
    }

    public static void reportTracePerf(final String str, final long j3) {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.qzone.util.PerfTracer.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(str, String.valueOf(j3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "QzoneTracePref", true, 0L, 0L, hashMap, (String) null, true);
            }
        }, 128, null, false);
    }

    public static void trace(String str, String str2) {
        trace(str, str2, -1, false);
    }

    public static void traceClick2Activity(Intent intent) {
        if (intent == null) {
            return;
        }
        long longExtra = intent.getLongExtra(PARAM_CLICK_TIME, 0L);
        if (longExtra > 0) {
            ConcurrentHashMap<String, Long> concurrentHashMap = sLogs;
            concurrentHashMap.put(CLICK2LOADACTIVITYCREATE, Long.valueOf(longExtra));
            concurrentHashMap.put(CLICK2LOADCOMPLETED, Long.valueOf(longExtra));
            boolean booleanExtra = intent.getBooleanExtra("QZoneExtra.Plugin.isloading", false);
            TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).markFirst(longExtra, intent.getIntExtra(PARAM_STARTUP_SCENEID, -1), booleanExtra);
            TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).startStep(CLICK2LOADACTIVITYCREATE, longExtra);
            TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).startStep(CLICK2LOADCOMPLETED, longExtra);
            TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).startStep(ClICK2WINDOWSHOW, longExtra);
            traceEnd(CLICK2LOADACTIVITYCREATE);
        }
    }

    public static void traceClick2Completed(PerfTimeReport perfTimeReport) {
        traceEnd(CLICK2LOADCOMPLETED);
        TimeCostTrace trace = TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH);
        if (trace == null) {
            return;
        }
        if (trace.getTimeCost() > 0 && perfTimeReport != null) {
            perfTimeReport.reportPerfTime(trace);
        } else {
            trace.destroy();
        }
    }

    public static void traceClick2Window() {
        traceEnd(ClICK2WINDOWSHOW);
    }

    public static void traceEnd(String str) {
        trace(str, null);
    }

    public static void traceStart(String str) {
        trace(null, str);
    }

    public static void trace(String str, String str2, int i3, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).stopStep(str);
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_LAUNCH).startStep(str2);
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap<String, Long> concurrentHashMap = sLogs;
            Long remove = concurrentHashMap.remove(str);
            Long remove2 = concurrentHashMap.remove(str + THREADTIME_TAG);
            if (remove != null && remove.longValue() != 0 && remove2 != null && remove2.longValue() != 0) {
                QLog.d(TAG, 1, "FeedsScrollPerformanceAutoMonitor, " + str + ", position," + i3 + "  , cost=" + (currentTimeMillis - remove.longValue()) + ", costThreadtime:" + (currentThreadTimeMillis - remove2.longValue()) + ", thread name: " + Thread.currentThread().getName());
                if (z16) {
                    reportTracePerf(str, currentTimeMillis - remove.longValue());
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ConcurrentHashMap<String, Long> concurrentHashMap2 = sLogs;
        concurrentHashMap2.put(str2, Long.valueOf(currentTimeMillis));
        concurrentHashMap2.put(str2 + THREADTIME_TAG, Long.valueOf(currentThreadTimeMillis));
    }

    public static void traceEnd(String str, int i3) {
        trace(str, null, i3, false);
    }

    public static void traceEnd(String str, boolean z16) {
        trace(str, null, -1, z16);
    }
}
