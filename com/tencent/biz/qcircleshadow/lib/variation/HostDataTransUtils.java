package com.tencent.biz.qcircleshadow.lib.variation;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.IQCircleChatMsgNtApi;
import com.tencent.mobileqq.qcircle.api.data.IQCircleMessageFacadeListener;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QUA;
import g20.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostDataTransUtils {
    private static final String TAG = "HostDataTransUtils";
    private static final a sCardObserver = new a();
    private static String sAccountUin = "";

    public static void addMsgFacadeObserver(IQCircleMessageFacadeListener iQCircleMessageFacadeListener) {
        ((IQCircleChatMsgNtApi) QRoute.api(IQCircleChatMsgNtApi.class)).addOrRemoveMsgFacadeObserver(iQCircleMessageFacadeListener);
    }

    public static void clearRedDotInfo() {
        if (QCircleHandler.getQCircleHandler() != null) {
            QCircleHandler.getQCircleHandler().clearPedPoint();
        }
    }

    public static String getAccount() {
        if (TextUtils.isEmpty(sAccountUin)) {
            sAccountUin = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        }
        return sAccountUin;
    }

    public static Bundle getArkDialogZipArgs(String str, String str2, String str3, String str4) {
        return QQCustomArkDialogUtil.zipArgs(str, str2, str3, str4, null);
    }

    public static String getBuddyName(String str, boolean z16) {
        return ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(str, z16);
    }

    public static long getLongAccountUin() {
        try {
            if (TextUtils.isEmpty(sAccountUin)) {
                sAccountUin = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            }
            return Long.valueOf(sAccountUin).longValue();
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return 0L;
        }
    }

    public static String getQUA3() {
        return QUA.getQUA3();
    }

    public static void getUserFaceBitmap(String str, final QCircleFaceBitmapListener qCircleFaceBitmapListener) {
        AppInterface appInterface = (AppInterface) QCircleServiceImpl.getAppRunTime();
        final IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        Bitmap bitmapFromCache = iQQAvatarService.getBitmapFromCache(1, str, 1, (byte) 1);
        if (bitmapFromCache == null) {
            QLog.d(TAG, 1, "shareToWeChat share user icon(need decode task)");
            iQQAvatarService.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils.1
                @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
                public void onDecodeTaskCompleted(int i3, int i16, String str2, Bitmap bitmap) {
                    QLog.d(HostDataTransUtils.TAG, 1, "shareToWeChat share user icon(need decode task)  onDecodeTaskCompleted");
                    QCircleFaceBitmapListener.this.getFaceBitmap(bitmap);
                    iQQAvatarService.setDecodeTaskCompletionListener(null);
                    iQQAvatarService.destory();
                }
            });
            iQQAvatarService.requestDecodeFace(str, 200, false, 1, true, (byte) 1, 1);
        } else {
            QLog.d(TAG, 1, "shareToWeChat share user icon(have cache)");
            qCircleFaceBitmapListener.getFaceBitmap(bitmapFromCache);
            iQQAvatarService.destory();
        }
    }

    public static void init() {
        if (QCircleServiceImpl.getAppRunTime() instanceof AppInterface) {
            ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).addObserver(sCardObserver);
        }
    }

    public static boolean isStudyMode() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    public static void release() {
        if (QCircleServiceImpl.getAppRunTime() instanceof AppInterface) {
            a aVar = sCardObserver;
            aVar.a();
            ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).removeObserver(aVar);
        }
    }

    public static void removeMessage(QCircleRecentDataInterface qCircleRecentDataInterface) {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.d(TAG, 1, "[removeMessage] appInterface == null");
            return;
        }
        aa recentContactService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.d(TAG, 1, "[removeMessage] recentContactService == null");
            return;
        }
        if (qCircleRecentDataInterface == null) {
            QLog.d(TAG, 1, "[removeMessage] data == null");
            return;
        }
        ArrayList<Contact> arrayList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setPeerUid(qCircleRecentDataInterface.getRecentUserUid());
        contact.setChatType(113);
        arrayList.add(contact);
        recentContactService.a0(arrayList, new IOperateCallback() { // from class: com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils.2
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public void onResult(int i3, String str) {
                QLog.d(HostDataTransUtils.TAG, 1, "[removeNtMessage] result: ", Integer.valueOf(i3), " errMsg: ", str);
            }
        });
    }

    public static void removeMsgFacadeObserver(IQCircleMessageFacadeListener iQCircleMessageFacadeListener) {
        ((IQCircleChatMsgNtApi) QRoute.api(IQCircleChatMsgNtApi.class)).addOrRemoveMsgFacadeObserver(null);
    }

    public static void resetAccount() {
        sAccountUin = "";
    }

    public static void setP2POpenStatus(boolean z16) {
        if (c.X0("qqcircle", "qqcircle_video_enable_p2p", 0).intValue() == 0) {
            return;
        }
        if (z16) {
            SuperPlayerSDKMgr.notifyEnterP2PScene(126);
        } else {
            SuperPlayerSDKMgr.notifyExitP2PScene(126);
        }
    }

    public static Serializable wrapSerializableMap(HashMap hashMap) {
        SerializableMap serializableMap = new SerializableMap();
        serializableMap.setMap(hashMap);
        return serializableMap;
    }
}
