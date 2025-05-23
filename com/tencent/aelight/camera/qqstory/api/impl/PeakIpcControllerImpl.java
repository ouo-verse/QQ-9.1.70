package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.editipc.a;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.mobileqq.data.MessageRecord;

/* loaded from: classes32.dex */
public class PeakIpcControllerImpl implements IPeakIpcController {
    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String ACTION_UPLOAD_ARK_VIDEO_CANCEL() {
        return "action_upload_ark_video_cancel";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String ACTION_UPLOAD_ARK_VIDEO_FAIL() {
        return "action_upload_ark_video_fail";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String ACTION_UPLOAD_ARK_VIDEO_PROGRESS_UPDATE() {
        return "action_upload_ark_video_progress_update";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String ACTION_UPLOAD_ARK_VIDEO_SUCCESS() {
        return "action_upload_ark_video_success";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String KEY_UPLOAD_ARK_VIDEO_CALLBACK_CLIENT_NAME() {
        return "key_upload_ark_video_callback_client_name";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String KEY_UPLOAD_ARK_VIDEO_DOWNLOAD_URL() {
        return "key_upload_ark_video_download_url";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String KEY_UPLOAD_ARK_VIDEO_PROGRESS() {
        return "key_upload_ark_video_progress";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String KEY_UPLOAD_COMMAND_ID() {
        return "key_upload_command_id";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public String keyUploadProcessName() {
        return "key_upload_ark_video_process_name";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public void report(String str, String str2) {
        a.f(str, str2);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public void updatePeakVideoAndPicStatus(MessageRecord messageRecord, int i3, int i16) {
        a.m(messageRecord, i3, i16);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public void report(String str, String str2, String str3) {
        a.g(str, str2, str3);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public void report(String str, String str2, String str3, long j3, String str4) {
        a.h(str, str2, str3, j3, str4);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPeakIpcController
    public void report(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        a.i(str, str2, str3, str4, str5, str6, str7, str8);
    }
}
