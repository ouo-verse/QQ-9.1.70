package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes33.dex */
public class MiniArkShareAsyncTransProcessorHandler extends TransProcessorHandler {
    private static final String TAG = "MiniArkShareImageTransP";
    private final IMiniCallback cmdCallback;

    public MiniArkShareAsyncTransProcessorHandler(Looper looper, IMiniCallback iMiniCallback) {
        super(looper);
        this.cmdCallback = iMiniCallback;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        FileMsg fileMsg = (FileMsg) message.obj;
        if (fileMsg != null && fileMsg.commandId == 62 && fileMsg.fileType == 24) {
            int i3 = message.what;
            if (i3 != 1007 && i3 != 1003) {
                if (i3 == 1005) {
                    QLog.e(TAG, 2, "handleMessage send error");
                    IMiniCallback iMiniCallback = this.cmdCallback;
                    if (iMiniCallback != null) {
                        try {
                            iMiniCallback.onCallbackResult(false, new Bundle());
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime instanceof QQAppInterface) {
                        ((ITransFileController) ((QQAppInterface) runtime).getRuntimeService(ITransFileController.class)).removeHandle(this);
                        return;
                    }
                    return;
                }
                return;
            }
            Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
            try {
                uploadPicExtInfo.mergeFrom(fileMsg.bdhExtendInfo);
                String stringUtf8 = uploadPicExtInfo.bytes_file_resid.get().toStringUtf8();
                String stringUtf82 = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                String stringUtf83 = uploadPicExtInfo.bytes_thumb_download_url.get().toStringUtf8();
                QLog.d(TAG, 2, "handleMessage " + stringUtf8 + " " + stringUtf82 + " " + stringUtf83);
                if (this.cmdCallback != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("imageUUID", stringUtf8);
                    bundle.putString("imageUrl", stringUtf82);
                    bundle.putString("imageThumbUrl", stringUtf83);
                    try {
                        this.cmdCallback.onCallbackResult(true, bundle);
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d(TAG, 2, "handleMessage ", e16);
                IMiniCallback iMiniCallback2 = this.cmdCallback;
                if (iMiniCallback2 != null) {
                    try {
                        iMiniCallback2.onCallbackResult(false, new Bundle());
                    } catch (Throwable th7) {
                        QLog.d(TAG, 2, "handleMessage ", th7);
                    }
                }
            }
            AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime2 instanceof QQAppInterface) {
                ((ITransFileController) ((QQAppInterface) runtime2).getRuntimeService(ITransFileController.class)).removeHandle(this);
            }
        }
    }
}
