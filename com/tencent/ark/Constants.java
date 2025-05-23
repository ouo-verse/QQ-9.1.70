package com.tencent.ark;

import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Constants {
    public static final Locale DEFAULT_LOCALE = Locale.CHINA;
    public static final String DEFAULT_MIN_APP_VERSION = "0.0.0.1";
    public static final String LOG_TAG = "ArkApp";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Event {
        public static final String Action_PerfCreateContext = "PerfCreateContext";
        public static final String Action_PerfCreateView = "PerfCreateView";
        public static final String Action_PerfDisplayTotalCost = "PerfDisplayTotalCost";
        public static final String Action_PerfDisplayView = "PerfDisplayView";
        public static final String Action_PerfFirstDraw = "PerfFirstDraw";
        public static final String Action_PerfGetApp = "PerfGetApp";
        public static final String Action_PerfSurfacePrepare = "PerfSurfacePrepare";
        public static final String ArkAppDisplayMonitor = "ArkAppDisplayMonitor";
        public static final String ArkAppUpdateMonitor = "ArkAppUpdateMonitor";
        public static final String EVENT_ID_ARK_APP_CLICK = "em_ark_click";
        public static final String EVENT_ID_ARK_APP_DISPLAY = "em_ark_exposure";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface NetType {
        public static final int NET_TYPE_2G = 3;
        public static final int NET_TYPE_3G = 4;
        public static final int NET_TYPE_4G = 5;
        public static final int NET_TYPE_UNKNOWN = -1;
        public static final int NET_TYPE_UNREACHABLE = 0;
        public static final int NET_TYPE_WIFI = 1;
        public static final int NET_TYPE_WWAN = 2;
        public static final int NET_TYPE_XG = 6;
    }
}
