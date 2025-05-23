package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StPlugin;
import NS_MINI_INTERFACE.INTERFACE$StVerifyPluginRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.apkg.PluginInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import java.util.ArrayList;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class MiniAppVerifyPluginServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_PLUGIN_IDS = "key_plugin_ids";
    public static final String KEY_PLUGIN_PROFILE = "plugin_profile";
    public static final String TAG = "MiniAppVerifyPluginServlet";

    public MiniAppVerifyPluginServlet() {
        this.observerId = 1038;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StVerifyPluginRsp iNTERFACE$StVerifyPluginRsp = new INTERFACE$StVerifyPluginRsp();
        iNTERFACE$StVerifyPluginRsp.mergeFrom(bArr);
        if (bundle.getLong("retCode") == 0) {
            Object pbToJson = GdtJsonPbUtil.pbToJson(iNTERFACE$StVerifyPluginRsp.pluginList);
            if (pbToJson != null) {
                bundle.putString(KEY_PLUGIN_PROFILE, pbToJson.toString());
            }
            notifyObserver(intent, 1038, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1038, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_app_id");
        ArrayList<PluginInfo> parcelableArrayListExtra = intent.getParcelableArrayListExtra(KEY_PLUGIN_IDS);
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        ArrayList arrayList = new ArrayList();
        for (PluginInfo pluginInfo : parcelableArrayListExtra) {
            if (pluginInfo != null) {
                INTERFACE$StPlugin iNTERFACE$StPlugin = new INTERFACE$StPlugin();
                iNTERFACE$StPlugin.plugin_id.set(pluginInfo.getPluginId());
                iNTERFACE$StPlugin.inner_version.set(pluginInfo.getInnerVersion());
                arrayList.add(iNTERFACE$StPlugin);
            }
        }
        byte[] encode = new VerifyPluginRequest(stringExtra, arrayList).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(VerifyPluginRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
