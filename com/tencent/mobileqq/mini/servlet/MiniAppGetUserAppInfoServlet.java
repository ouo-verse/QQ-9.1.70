package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppInfoRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetUserAppInfoServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPIDS = "key_appids";
    public static final String KEY_EXT = "key_ext";
    public static final String TAG = "MiniAppGetUserAppInfoServlet";

    public MiniAppGetUserAppInfoServlet() {
        this.observerId = 1008;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetUserAppInfoRsp iNTERFACE$StGetUserAppInfoRsp = new INTERFACE$StGetUserAppInfoRsp();
        iNTERFACE$StGetUserAppInfoRsp.mergeFrom(bArr);
        PBRepeatMessageField<INTERFACE$StUserAppInfo> pBRepeatMessageField = iNTERFACE$StGetUserAppInfoRsp.userAppList;
        if (pBRepeatMessageField != null) {
            INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo = pBRepeatMessageField.get().get(0);
            bundle.putInt(PictureConst.PHOTO_LIKE_NUM, iNTERFACE$StUserAppInfo.likeNum.get());
            bundle.putInt(MiniAppSetUserAppLikeServlet.KEY_DO_LIKE, iNTERFACE$StUserAppInfo.doLike.get());
            bundle.putSerializable("mini_app_info_data", MiniAppInfo.from(iNTERFACE$StUserAppInfo));
            notifyObserver(intent, 1008, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1008, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(KEY_APPIDS);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
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
        byte[] encode = new GetUserAppInfoRequest(stCommonExt, stringArrayListExtra).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_app_userapp.GetUserAppInfo");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
