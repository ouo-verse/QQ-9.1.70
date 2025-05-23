package com.tencent.xweb.updater;

import com.tencent.xweb.CalledByApi;

/* compiled from: P */
@CalledByApi
/* loaded from: classes27.dex */
public interface IXWebBroadcastListener {
    public static final String DATA_TAG = "extra_data";
    public static final String ERROR_CODE = "error_code";
    public static final int FINISHED_CODE_CANCELED = -2;
    public static final int FINISHED_CODE_FAILED = -1;
    public static final int FINISHED_CODE_SUC = 0;
    public static final String PACKAGE_NAME = "package_name";
    public static final int SCHEDULER_TYPE_NORMAL = 0;
    public static final int SCHEDULER_TYPE_PREDOWNLOAD = 1;
    public static final String STAGE_FINISHED = "finished";
    public static final String STAGE_MAINCFG_UPDATE = "cfg_update";
    public static final String STAGE_PLUGINCFG_UPDATE = "plugin_update";
    public static final String STAGE_PROGRESSED = "updating";
    public static final String STAGE_START = "start";
    public static final String STAGE_TAG = "stage";
    public static final String UPDATE_ACTION = "com.tencent.xweb.update";

    void onMainCfgUpdated();

    void onPluginCfgUpdated();

    void onUpdateFinished(int i3, int i16);

    void onUpdateProgressed(int i3);

    void onUpdateStart(int i3);
}
