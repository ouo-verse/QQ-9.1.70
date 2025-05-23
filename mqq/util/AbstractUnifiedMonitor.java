package mqq.util;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractUnifiedMonitor {
    public static final int FAMILY_ACT_TIME = 8;
    public static final int FAMILY_BG_TASK = 6;
    public static final int FAMILY_CPU_STATS = 11;
    public static final int FAMILY_DROP_FRAME = 10;
    public static final int FAMILY_FILE_TASK = 5;
    public static final int FAMILY_IMAGE_DRAWABLE = 2;
    public static final int FAMILY_IMAGE_VIEW = 3;
    public static final int FAMILY_LAST = 22;
    public static final int FAMILY_LOOPER = 0;
    public static final int FAMILY_MSF_LIGHT_SENDER = 17;
    public static final int FAMILY_MSF_MSG = 7;
    public static final int FAMILY_MSF_MSG_HIGH_PRIORITY = 21;
    public static final int FAMILY_MSF_NETWORK = 18;
    public static final int FAMILY_MSF_RECVER = 16;
    public static final int FAMILY_MSF_SENDER = 15;
    public static final int FAMILY_NEW_FPS = 12;
    public static final int FAMILY_OBSERVER = 1;
    public static final int FAMILY_QZONE_LOOPER = 14;
    public static final int FAMILY_RECENT = 13;
    public static final int FAMILY_SCENE_PERF = 20;
    public static final int FAMILY_SCENE_SMOOTH = 9;
    public static final int FAMILY_SUB_TASK = 4;
    public static final int FAMILY_TOOL_LOOPER = 19;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ThreadMonitorCallback {
        void onThreadMonitorEnd(int i3);
    }

    public abstract void addEvent(int i3, String str, int i16, int i17, Map<String, String> map);

    public abstract int getThreshold(int i3);

    public abstract void notifyNotTimeout(int i3);

    public abstract void reportStackIfTimeout(int i3);

    public abstract boolean setMonitoredThread(int i3, Thread thread, ThreadMonitorCallback threadMonitorCallback);

    public abstract boolean whetherReportDuringThisStartup(int i3);

    public abstract boolean whetherReportThisTime(int i3);

    public abstract boolean whetherReportThisTime(int i3, boolean z16);

    public abstract boolean whetherStackEnabled(int i3);
}
