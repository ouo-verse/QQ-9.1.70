package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StExpandItem;
import NS_MINI_INTERFACE.INTERFACE$StGetExpandAppListRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetKuolieApplistServlet extends MiniAppAbstractServlet {
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_KUOLIE_APPLIST = "mini_kuolie_applist_data";
    public static final int NO_REQUIRED = 0;
    public static final int REQUIRED = 1;
    public static final String TAG = "MiniAppGetKuolieApplistServlet";

    public MiniAppGetKuolieApplistServlet() {
        this.observerId = 1044;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo;
        String str;
        String str2;
        INTERFACE$StGetExpandAppListRsp iNTERFACE$StGetExpandAppListRsp = new INTERFACE$StGetExpandAppListRsp();
        iNTERFACE$StGetExpandAppListRsp.mergeFrom(bArr);
        if (bundle.getLong("retCode") == 0 && iNTERFACE$StGetExpandAppListRsp.expandItemList != null) {
            MiniAppRecommInfo miniAppRecommInfo = new MiniAppRecommInfo();
            miniAppRecommInfo.headDesc = iNTERFACE$StGetExpandAppListRsp.expandTitle.get();
            miniAppRecommInfo.cacheValidTime = (System.currentTimeMillis() / 1000) + iNTERFACE$StGetExpandAppListRsp.cacheTime.get();
            QLog.i(TAG, 1, "MiniAppKuolie StApiAppInfo cacheTime:" + iNTERFACE$StGetExpandAppListRsp.cacheTime.get() + " itemSize:" + iNTERFACE$StGetExpandAppListRsp.expandItemList.get().size());
            for (INTERFACE$StExpandItem iNTERFACE$StExpandItem : iNTERFACE$StGetExpandAppListRsp.expandItemList.get()) {
                if (iNTERFACE$StExpandItem != null && (iNTERFACE$StApiAppInfo = iNTERFACE$StExpandItem.appInfo.get()) != null) {
                    MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
                    MiniAppRecommInfo.MiniApp miniApp = new MiniAppRecommInfo.MiniApp();
                    miniApp.f263471h = iNTERFACE$StApiAppInfo.toByteArray();
                    miniApp.f263472i = iNTERFACE$StApiAppInfo;
                    miniApp.f263468d = from.appId;
                    if (!TextUtils.isEmpty(iNTERFACE$StExpandItem.icon.get())) {
                        str = iNTERFACE$StExpandItem.icon.get();
                    } else {
                        str = from.iconUrl;
                    }
                    miniApp.f263470f = str;
                    if (!TextUtils.isEmpty(iNTERFACE$StExpandItem.name.get())) {
                        str2 = iNTERFACE$StExpandItem.name.get();
                    } else {
                        str2 = from.name;
                    }
                    miniApp.f263469e = str2;
                    miniApp.f263473m = iNTERFACE$StExpandItem.adId.get();
                    miniAppRecommInfo.appInfoList.add(miniApp);
                }
            }
            bundle.putSerializable(KEY_KUOLIE_APPLIST, miniAppRecommInfo);
            notifyObserver(intent, 1044, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1044, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
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
        byte[] encode = new GetKuolieApplistRequest(stCommonExt).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetKuolieApplistRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
