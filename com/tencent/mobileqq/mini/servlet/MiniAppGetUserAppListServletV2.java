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
public class MiniAppGetUserAppListServletV2 extends MiniAppAbstractServlet {
    public static final String KEY_EXT_INFO = "key_ext_info";
    public static final String KEY_GET_USER_APP_LIST_V2 = "getUserAppListV2";
    public static final String KEY_ITEM_IDS = "key_item_ids";
    public static final String KEY_MODULE_TYPES = "key_module_types";
    public static final String KEY_OLD_RECOMMEND_LIST = "key_old_recommend_list";
    public static final String KEY_SCENE = "scene";
    public static final String KEY_SUB_TYPES = "key_sub_types";
    public static final String KEY_USE_CACHE = "key_use_cache";
    public static final String TAG = "MiniAppGetUserAppListServletV2";

    public MiniAppGetUserAppListServletV2() {
        this.observerId = 1047;
    }

    private COMM.StCommonExt buildExtInfo(byte[] bArr, int i3) {
        COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
        if (bArr != null) {
            try {
                stCommonExt.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "[MiniAppGetUserAppListServletV2] onSend. exception=" + e16.getMessage());
            }
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("scene");
        entry.value.set(String.valueOf(i3));
        stCommonExt.mapInfo.get().add(entry);
        return stCommonExt;
    }

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
                    bundle.putParcelable(KEY_GET_USER_APP_LIST_V2, fromServiceMsg);
                    notifyObserver(intent, 1047, true, bundle, MiniAppObserver.class);
                } else {
                    bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                    notifyObserver(intent, 1047, false, bundle, MiniAppObserver.class);
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
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_old_recommend_list");
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
        byte[] encode = new GetUserAppListRequestV2(buildExtInfo(intent.getByteArrayExtra("key_ext_info"), intent.getIntExtra("scene", 0)), arrayList, intent.getIntegerArrayListExtra("key_module_types"), intent.getIntExtra("key_use_cache", 0), AdUtils.getDeviceInfo(BaseApplication.getContext()), intent.getIntegerArrayListExtra("key_sub_types"), intent.getStringArrayListExtra("key_item_ids")).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetUserAppListRequestV2.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
