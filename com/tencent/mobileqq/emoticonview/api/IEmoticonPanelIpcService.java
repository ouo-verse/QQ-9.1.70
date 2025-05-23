package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonPanelIpcService extends QRouteApi {
    public static final String ACTION_GET_AI_EMOTICON_LIST = "getAiEmoticonList";
    public static final String ACTION_UPLOAD_PIC_AND_CHECK = "uploadPicAndCheck";
    public static final String CAMERAEMOIPC_SERVER_NAME = "CameraEmoIpcServer";
    public static final String EMOTICON_IPC_NAME = "EmoticonIPCModule";
    public static final String EMOTICON_MAINPANEL_IPC_NAME = "module_emoticon_mainpanel";
    public static final String PARAM_FILE_PATH = "paramFilePath";

    QIPCModule onCreateModule(String str);
}
