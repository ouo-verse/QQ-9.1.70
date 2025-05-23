package com.tencent.mobileqq.qqsomonitor.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ISoMonitorIPCModuleApi extends QRouteApi {
    public static final String ACTION_GET_SO_FILE_INFO = "get_so_file_info";
    public static final String ACTION_REGISTER_SO_FILE_INFO = "register_so_file_info";
    public static final String BUNDLE_KEY_SO_FILE_INFO = "so_file_info";
    public static final String BUNDLE_KEY_SO_FILE_PATH = "so_file_path";
    public static final String NAME = "SoMonitorIPCModule";

    QIPCModule getQIPCModule();
}
