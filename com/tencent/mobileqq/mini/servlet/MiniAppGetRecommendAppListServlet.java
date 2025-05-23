package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StRecommendApp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetRecommendAppListServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_EXT_INFO = "key_ext_info";
    public static final String KEY_OLD_RECOMMEND_LIST = "key_old_recommend_list";
    public static final String KEY_RECOMMEND_MODULE = "key_recommend_module";
    public static final String KEY_USE_TIME = "key_use_time";
    public static final String KEY_VER_TYPE = "key_ver_type";
    public static final String TAG = "MiniAppGetRecommendAppListServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                    bundle.putLong("retCode", stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    bundle.putParcelable(KEY_RECOMMEND_MODULE, fromServiceMsg);
                    notifyObserver(intent, 1048, true, bundle, MiniAppObserver.class);
                } else {
                    bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                    notifyObserver(intent, 1048, false, bundle, MiniAppObserver.class);
                }
            } else {
                QLog.e(TAG, 1, "onReceive. inform MiniAppGetUserAppListServletV2 response is null.");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + ", onReceive exception: " + Log.getStackTraceString(th5));
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        String stringExtra = intent.getStringExtra("key_app_id");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext_info");
        int intExtra2 = intent.getIntExtra(KEY_VER_TYPE, 3);
        long longExtra = intent.getLongExtra(KEY_USE_TIME, 5L);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_old_recommend_list");
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
        } else {
            stCommonExt = null;
        }
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayListExtra != null) {
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                RecommendAppInfo recommendAppInfo = (RecommendAppInfo) it.next();
                if (recommendAppInfo != null) {
                    INTERFACE$StRecommendApp iNTERFACE$StRecommendApp = new INTERFACE$StRecommendApp();
                    iNTERFACE$StRecommendApp.appId.set(recommendAppInfo.getAppId());
                    iNTERFACE$StRecommendApp.exposuredNum.set(recommendAppInfo.getExposuredNum());
                    iNTERFACE$StRecommendApp.pullTime.set(recommendAppInfo.getPullTime());
                    arrayList.add(iNTERFACE$StRecommendApp);
                }
            }
        }
        byte[] encode = new GetRecommendAppListRequest(stCommonExt, stringExtra, intExtra2, longExtra, arrayList, AdUtils.getDeviceInfo(BaseApplication.getContext())).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetRecommendAppListRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
