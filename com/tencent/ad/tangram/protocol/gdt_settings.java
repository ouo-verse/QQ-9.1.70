package com.tencent.ad.tangram.protocol;

import com.tencent.ad.tangram.protocol.gdt_abtest;
import com.tencent.ad.tangram.protocol.gdt_experiment_settings;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class gdt_settings {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Settings {
        public int version = 0;
        public String timeExpiredMillis = "";
        public int intervalMillis = 0;
        public String urlForSettings = "";
        public SettingsForAnalysis settingsForAnalysis = new SettingsForAnalysis();
        public SettingsForSdkMsg settingsForSdkMsg = new SettingsForSdkMsg();
        public SettingsForDeviceInfo settingsForDeviceInfo = new SettingsForDeviceInfo();
        public gdt_experiment_settings.SettingsForJointExperiment[] settingsForJointExperiment = new gdt_experiment_settings.SettingsForJointExperiment[0];
        public SettingsForLinkEventReporter settingsForLinkEventReporter = new SettingsForLinkEventReporter();
        public SettingsForQuickApp settingsForQuickApp = new SettingsForQuickApp();
        public SettingsForDynamic settingsForDynamic = new SettingsForDynamic();
        public SettingsForClick settingsForClick = new SettingsForClick();

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class SettingsForAnalysis {
            public static final int DEFAULT = 1;
            public static final int SHUTDOWN = 3;
            public int mode = 1;
            public String urlForReport = "";
            public Batch batch = new Batch();
            public gdt_abtest.ABTest abTestV2 = new gdt_abtest.ABTest();

            /* compiled from: P */
            /* loaded from: classes3.dex */
            public static final class Batch {
                public int limit = 0;
            }
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class SettingsForClick {
            public gdt_abtest.ABTest antiSpamForFeedBackReportTest = new gdt_abtest.ABTest();
            public gdt_abtest.ABTest antiSpamForFeedBackActionTest = new gdt_abtest.ABTest();
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class SettingsForDeviceInfo {
            public static final int SWITCH_INDEX_ENABLE_DELETE_FILE = 2;
            public static final int SWITCH_INDEX_ENABLE_USE_INTERFACE = 0;
            public static final int SWITCH_INDEX_ENABLE_USE_WRITE_FILE = 1;
            public static final int SWITCH_INDEX_MAX = 3;
            public Switches switches = new Switches();
            public Ext[] ext = new Ext[0];

            /* compiled from: P */
            /* loaded from: classes3.dex */
            public static final class Ext {

                /* renamed from: id, reason: collision with root package name */
                public int f61322id = 0;

                /* renamed from: s, reason: collision with root package name */
                public boolean[] f61323s = new boolean[0];
            }

            /* compiled from: P */
            /* loaded from: classes3.dex */
            public static final class Switches {
                public boolean switch128 = false;
                public boolean switch315 = false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class SettingsForDynamic {
            public int loadTimeOut = 0;
            public int updateVersionCacheIntervalSeconds = 0;
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class SettingsForLinkEventReporter {
            public String jsUrlForPagePerformance = "";
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class SettingsForQuickApp {
            public String deeplink = "";
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class SettingsForSdkMsg {

            /* renamed from: k, reason: collision with root package name */
            public String f61324k = "";
        }
    }

    gdt_settings() {
    }
}
