package com.tencent.biz.qcircleshadow.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.QQHeadUrl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHandler extends BusinessHandler {
    private static final String ATTR_KEY_FROM_OTHER_PROCESS = "attr_key_from_other_process";
    private static final String TAG = "QCircleHandler";
    private static QCircleHandler sOtherProcessHandler;
    private ConcurrentHashMap<String, IAvatarListener> mAvatarListener;
    private ConcurrentHashMap<ToServiceMsg, IPCAvatarListener> mIPCAvatarListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class HeadInfo {
        public String downLoadUrl;
        private byte dwFaceFlag;

        HeadInfo() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface IPCAvatarListener {
        void handlerAvatarReceive(Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult.isSuccess()) {
                QCircleHandler.this.handleAvatarReceive((ToServiceMsg) eIPCResult.data.getParcelable(IQCircleIPCApi.BUNDLE_KEY_AVATAR_REQUEST), (FromServiceMsg) eIPCResult.data.getParcelable(IQCircleIPCApi.BUNDLE_KEY_AVATAR_RESPONSE), eIPCResult.data.getByteArray(IQCircleIPCApi.BUNDLE_KEY_AVATAR_BYTES_DATA));
            }
        }
    }

    protected QCircleHandler(AppInterface appInterface) {
        super(appInterface);
        this.mAvatarListener = new ConcurrentHashMap<>();
        this.mIPCAvatarListener = new ConcurrentHashMap<>();
    }

    private HeadInfo getAvatarInfo(String str, byte b16, QQHeadUrl.QQHeadUrlRsp qQHeadUrlRsp) {
        String valueOf;
        for (QQHeadUrl.RspHeadInfo rspHeadInfo : qQHeadUrlRsp.dstHeadInfos.get()) {
            if (qQHeadUrlRsp.dstEncryptType.get() == 1) {
                valueOf = rspHeadInfo.dstUid.get();
            } else {
                valueOf = String.valueOf(rspHeadInfo.dstUin.get());
            }
            if (str.equals(valueOf)) {
                HeadInfo headInfo = new HeadInfo();
                headInfo.dwFaceFlag = (byte) rspHeadInfo.faceFlag.get();
                int qQHeadImageSize = AvatarDownloadUtil.getQQHeadImageSize(headInfo.dwFaceFlag);
                headInfo.downLoadUrl = rspHeadInfo.url.get() + qQHeadImageSize;
                QLog.d(TAG, 4, "  size:" + qQHeadImageSize + "url :" + headInfo.downLoadUrl);
                return headInfo;
            }
        }
        return null;
    }

    public static QCircleHandler getQCircleHandler() {
        if (MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof AppInterface) {
            return (QCircleHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(QCircleHandler.class.getName());
        }
        if (sOtherProcessHandler == null) {
            sOtherProcessHandler = new QCircleHandler(null);
        }
        return sOtherProcessHandler;
    }

    private void handleAvatarError(String str, int i3) {
        IAvatarListener iAvatarListener;
        if (!TextUtils.isEmpty(str) && (iAvatarListener = this.mAvatarListener.get(str)) != null) {
            iAvatarListener.onAvatarBack(false, i3, null);
            this.mAvatarListener.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAvatarReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        QQHeadUrl.QQHeadUrlRsp qQHeadUrlRsp = null;
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
                    QQHeadUrl.QQHeadUrlRsp qQHeadUrlRsp2 = new QQHeadUrl.QQHeadUrlRsp();
                    qQHeadUrlRsp2.mergeFrom((byte[]) obj);
                    qQHeadUrlRsp = qQHeadUrlRsp2;
                }
            } catch (Exception unused) {
            }
        }
        String string = toServiceMsg.extraData.getString("dstUin", "");
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && qQHeadUrlRsp != null && qQHeadUrlRsp.result.get() == 0) {
            HeadInfo avatarInfo = getAvatarInfo(string, (byte) 1, qQHeadUrlRsp);
            if (avatarInfo != null) {
                handleAvatarSuccess(string, avatarInfo);
                return;
            } else {
                handleAvatarError(string, -1);
                return;
            }
        }
        if (qQHeadUrlRsp != null) {
            i3 = qQHeadUrlRsp.result.get();
        } else if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = 65535;
        }
        handleAvatarError(string, i3);
    }

    private void handleAvatarSuccess(String str, HeadInfo headInfo) {
        IAvatarListener iAvatarListener;
        if (!TextUtils.isEmpty(str) && (iAvatarListener = this.mAvatarListener.get(str)) != null) {
            QCircleAvatarInfo qCircleAvatarInfo = new QCircleAvatarInfo();
            qCircleAvatarInfo.dwFaceFlag = headInfo.dwFaceFlag;
            qCircleAvatarInfo.setTimestamp(String.valueOf(System.currentTimeMillis())).setDownLoadUrl(headInfo.downLoadUrl).setUin(str);
            iAvatarListener.onAvatarBack(true, 0, qCircleAvatarInfo);
            this.mAvatarListener.remove(str);
        }
    }

    public void clearAvatarListener() {
        ConcurrentHashMap<String, IAvatarListener> concurrentHashMap = this.mAvatarListener;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<ToServiceMsg, IPCAvatarListener> concurrentHashMap2 = this.mIPCAvatarListener;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    public void clearPedPoint() {
        QLog.d(TAG, 1, "clearRedPoint");
        QCircleChatBoxHelper.getInstance().clearUnReadInfo();
        notifyUI(1, true, 0);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD_NEW);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public String getCurrentAccountUin() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return null;
        }
        return waitAppRuntime.getAccount();
    }

    protected void notifyIPCResult(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
        IPCAvatarListener remove;
        ConcurrentHashMap<ToServiceMsg, IPCAvatarListener> concurrentHashMap = this.mIPCAvatarListener;
        if (concurrentHashMap != null && (remove = concurrentHashMap.remove(toServiceMsg)) != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(IQCircleIPCApi.BUNDLE_KEY_AVATAR_REQUEST, toServiceMsg);
            bundle.putParcelable(IQCircleIPCApi.BUNDLE_KEY_AVATAR_RESPONSE, fromServiceMsg);
            bundle.putByteArray(IQCircleIPCApi.BUNDLE_KEY_AVATAR_BYTES_DATA, bArr);
            remove.handlerAvatarReceive(bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return QCircleObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (!msgCmdFilter(toServiceMsg.getServiceCmd()) && FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD_NEW.equals(fromServiceMsg.getServiceCmd()) && toServiceMsg.extraData.getBoolean("qcircle")) {
            handleAvatarReceive(toServiceMsg, fromServiceMsg, obj);
            notifyIPCResult(toServiceMsg, fromServiceMsg, (byte[]) obj);
        }
    }

    public void registerAvatarListener(String str, IAvatarListener iAvatarListener) {
        ConcurrentHashMap<String, IAvatarListener> concurrentHashMap = this.mAvatarListener;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, iAvatarListener);
        }
    }

    public void sendIPCHeadRequest(ToServiceMsg toServiceMsg, IPCAvatarListener iPCAvatarListener) {
        sendPbReq(toServiceMsg);
        ConcurrentHashMap<ToServiceMsg, IPCAvatarListener> concurrentHashMap = this.mIPCAvatarListener;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(toServiceMsg, iPCAvatarListener);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void sendPbReq(ToServiceMsg toServiceMsg) {
        if (MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof AppInterface) {
            super.sendPbReq(toServiceMsg);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(ToServiceMsg.class.getClassLoader());
        bundle.putParcelable(IQCircleIPCApi.BUNDLE_KEY_AVATAR_REQUEST, toServiceMsg);
        QIPCClientHelper.getInstance().getClient().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_GET_AVATAR, bundle, new a());
    }

    public void updateRedPoint() {
        notifyUI(1, true, 0);
    }
}
