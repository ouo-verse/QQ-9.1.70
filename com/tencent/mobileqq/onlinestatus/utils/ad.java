package com.tencent.mobileqq.onlinestatus.utils;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import tencent.im.onlinestatus.OnlineStatusExtInfo$SynchVideoBizInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ad {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(IOnlineStatusMiniService.c cVar, EIPCResult eIPCResult) {
        boolean z16;
        boolean z17 = false;
        if (eIPCResult == null) {
            QLog.e("OnlineStatusTencentVideoSetStatusUtil", 1, "ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW error, result is null");
            cVar.a(false);
            return;
        }
        if (eIPCResult.code == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        cVar.a(z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ACTION_SET_ONLINE_STATUS_MAIN result.code: ");
        if (eIPCResult.code == 0) {
            z17 = true;
        }
        sb5.append(z17);
        QLog.d("OnlineStatusTencentVideoSetStatusUtil", 1, sb5.toString());
    }

    public static void c(String str, String str2, CustomShareInfo customShareInfo, AppInterface appInterface, IOnlineStatusMiniService.b bVar) {
        Bundle bundle = new Bundle();
        OnlineStatusExtInfo$SynchVideoBizInfo onlineStatusExtInfo$SynchVideoBizInfo = new OnlineStatusExtInfo$SynchVideoBizInfo();
        onlineStatusExtInfo$SynchVideoBizInfo.string_cid.set(str);
        onlineStatusExtInfo$SynchVideoBizInfo.string_tvURL.set(str2);
        onlineStatusExtInfo$SynchVideoBizInfo.synch_type.set(2);
        bundle.putByteArray("TencentVideoInfo", onlineStatusExtInfo$SynchVideoBizInfo.toByteArray());
        bundle.putInt("StatusId", 1021);
        OnlineStatusHandler onlineStatusHandler = (OnlineStatusHandler) appInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
        if (bVar != null) {
            onlineStatusHandler.i3(bVar);
        }
        onlineStatusHandler.c3(5, bundle, null, customShareInfo);
    }

    public static void d(String str, String str2, CustomShareInfo customShareInfo, final IOnlineStatusMiniService.c cVar) {
        Bundle bundle = new Bundle();
        bundle.putString("cid", str);
        bundle.putString("url", str2);
        if (customShareInfo != null) {
            bundle.putInt("shareType", customShareInfo.getShareType());
            bundle.putString("shareUrl", customShareInfo.getUrl());
            bundle.putString("shareWording", customShareInfo.getSubTitle());
        }
        QIPCClientHelper.getInstance().callServer("TencentVideoStatusQIPCModule", "ACTION_SET_ONLINE_STATUS_MAIN", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.onlinestatus.utils.ac
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                ad.b(IOnlineStatusMiniService.c.this, eIPCResult);
            }
        });
    }
}
