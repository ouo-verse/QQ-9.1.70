package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes32.dex */
public class PeakIpcModuleServerImpl implements IPeakIpcModuleServer {
    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer
    public String ACTION_UPLOAD_ARK_VIDEO() {
        return "action_upload_ark_video";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer
    public String KEY_UPLOAD_ARK_RES_POSTFIX() {
        return "key_upload_ark_res_postfix";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer
    public String KEY_UPLOAD_ARK_VIDEO_PATH() {
        return "key_upload_ark_video_path";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer
    public String actionQcirclePickerReport() {
        return "action_qcircle_picker_report";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer
    public QIPCModule getPeakIpcModuleServerModule() {
        return PeakIpcModuleServer.c();
    }
}
