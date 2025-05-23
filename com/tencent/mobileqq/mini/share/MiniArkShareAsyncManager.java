package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniArkShareAsyncManager {
    private static final String TAG = "MiniArkShareAsyncManage [miniappArkShare]";

    MiniArkShareAsyncManager() {
    }

    public static void performChangeArkShareImageUrl(String str, final CmdCallback cmdCallback) {
        if (TextUtils.isEmpty(str)) {
            try {
                cmdCallback.onCmdResult(true, new Bundle());
                return;
            } catch (RemoteException e16) {
                e16.printStackTrace();
                return;
            }
        }
        MiniAppCmdUtil.getInstance().changeShareImageUrl(str, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager.1
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                Bundle bundle = new Bundle();
                bundle.putString("imageUrl", jSONObject.optString("imageUrl"));
                try {
                    CmdCallback.this.onCmdResult(z16, bundle);
                } catch (RemoteException e17) {
                    e17.printStackTrace();
                }
            }
        });
    }

    public static void performUploadArkShareImage(String str, IMiniCallback iMiniCallback) {
        if (fb0.a.b(TAG, 2000L)) {
            QLog.d(TAG, 1, "avoid high frequent execute performUploadArkShareImage\uff01");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                TransferRequest transferRequest = new TransferRequest();
                transferRequest.mIsUp = true;
                transferRequest.mLocalPath = str;
                transferRequest.mCommandId = 62;
                transferRequest.mUniseq = (long) (Math.random() * 1000000.0d);
                transferRequest.mPeerUin = "0";
                transferRequest.mSelfUin = String.valueOf(com.tencent.open.adapter.a.f().l());
                transferRequest.mFileType = 24;
                transferRequest.mRichTag = StatisticCollector.MINI_APP_ARK_SHARE_PICTURE_UPLOAD;
                Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
                commFileExtReq.uint32_action_type.set(0);
                commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
                transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
                MiniArkShareAsyncTransProcessorHandler miniArkShareAsyncTransProcessorHandler = new MiniArkShareAsyncTransProcessorHandler(ThreadManagerV2.getFileThreadLooper(), iMiniCallback);
                miniArkShareAsyncTransProcessorHandler.addFilter(BDHCommonUploadProcessor.class);
                if (qQAppInterface.getRuntimeService(ITransFileController.class) != null) {
                    ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(miniArkShareAsyncTransProcessorHandler);
                    ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e(TAG, 2, "performUploadArkShareImage empty local image path");
        if (iMiniCallback != null) {
            try {
                iMiniCallback.onCallbackResult(false, new Bundle());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
