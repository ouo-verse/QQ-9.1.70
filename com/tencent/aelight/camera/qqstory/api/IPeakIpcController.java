package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPeakIpcController extends QRouteApi {
    String ACTION_UPLOAD_ARK_VIDEO_CANCEL();

    String ACTION_UPLOAD_ARK_VIDEO_FAIL();

    String ACTION_UPLOAD_ARK_VIDEO_PROGRESS_UPDATE();

    String ACTION_UPLOAD_ARK_VIDEO_SUCCESS();

    String KEY_UPLOAD_ARK_VIDEO_CALLBACK_CLIENT_NAME();

    String KEY_UPLOAD_ARK_VIDEO_DOWNLOAD_URL();

    String KEY_UPLOAD_ARK_VIDEO_PROGRESS();

    String KEY_UPLOAD_COMMAND_ID();

    String keyUploadProcessName();

    void report(String str, String str2);

    void report(String str, String str2, String str3);

    void report(String str, String str2, String str3, long j3, String str4);

    void report(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void updatePeakVideoAndPicStatus(MessageRecord messageRecord, int i3, int i16);
}
