package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetExtConfigDetailRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetExtConfigDetailServlet extends MiniAppAbstractServlet {
    public static final String CONFIG_KEY_API_SCOPE = "apiscopeconfig";
    public static final String KEY_COMMON_EXT = "key_common_ext";
    public static final String KEY_EXT_CONFIG_DETAIL_RESULT = "key_ext_config_detail_result";
    public static final String KEY_EXT_CONFIG_INFO = "key_ext_config_info";
    private static final String TAG = "MiniAppGetExtConfigDetailServlet";

    public MiniAppGetExtConfigDetailServlet() {
        this.observerId = 1040;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetExtConfigDetailRsp iNTERFACE$StGetExtConfigDetailRsp = new INTERFACE$StGetExtConfigDetailRsp();
        iNTERFACE$StGetExtConfigDetailRsp.mergeFrom(bArr);
        List<INTERFACE$StExtConfigInfo> list = iNTERFACE$StGetExtConfigDetailRsp.configs.get();
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            try {
                Iterator<INTERFACE$StExtConfigInfo> it = list.iterator();
                while (it.hasNext()) {
                    ExtConfigInfo from = ExtConfigInfo.from(it.next());
                    if (from != null && !TextUtils.isEmpty(from.configKey)) {
                        jSONObject.put(from.configKey, from.toJson());
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onProcessData exception!", th5);
            }
        }
        bundle.putString(KEY_EXT_CONFIG_DETAIL_RESULT, jSONObject.toString());
        notifyObserver(intent, 1040, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_common_ext");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(KEY_EXT_CONFIG_INFO);
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onSend. StCommonExt mergeFrom exception!", th5);
            }
        } else {
            stCommonExt = null;
        }
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayListExtra != null) {
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                arrayList.add(((ExtConfigInfo) it.next()).toProto());
            }
        }
        byte[] encode = new GetExtConfigDetailRequest(stCommonExt, arrayList).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetExtConfigDetailRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
