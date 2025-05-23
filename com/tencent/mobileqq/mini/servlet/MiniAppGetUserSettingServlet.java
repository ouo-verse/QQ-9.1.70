package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import java.util.ArrayList;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetUserSettingServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "KEY_APP_ID";
    public static final String KEY_OPEN_ID = "KEY_OPEN_ID";
    public static final String KEY_SETTING_ITEM = "KEY_SETTING_ITEM";
    public static final String KEY_TEMPLATE_IDS = "KEY_TEMPLATE_IDS";
    public static final String TAG = "MiniAppGetUserSettingServlet";

    public MiniAppGetUserSettingServlet() {
        this.observerId = 1051;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
        iNTERFACE$StGetUserSettingRsp.mergeFrom(bArr);
        String str = iNTERFACE$StGetUserSettingRsp.setting.settingItem.get();
        String str2 = iNTERFACE$StGetUserSettingRsp.setting.desc.get();
        int i3 = iNTERFACE$StGetUserSettingRsp.setting.authState.get();
        bundle.putString("settingItem", str);
        bundle.putString("desc", str2);
        bundle.putInt("authState", i3);
        bundle.putByteArray("originalData", bArr);
        notifyObserver(intent, 1051, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        String stringExtra = intent.getStringExtra(KEY_APP_ID);
        String stringExtra2 = intent.getStringExtra(KEY_OPEN_ID);
        String stringExtra3 = intent.getStringExtra(KEY_SETTING_ITEM);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(KEY_TEMPLATE_IDS);
        if (!TextUtils.isEmpty(stringExtra)) {
            byte[] encode = new GetUserSettingRequest(stringExtra, stringExtra2, stringExtra3, stringArrayListExtra).encode(intent, intExtra, getTraceId());
            if (encode == null) {
                encode = new byte[4];
            }
            packet.setSSOCommand(GetUserSettingRequest.CMD_STRING);
            packet.putSendData(fh.b(encode));
            packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intExtra);
            bundle.putString("errMsg", "openId is null, request failed!");
            notifyObserver(intent, 1051, false, bundle, MiniAppObserver.class);
        }
        super.onSend(intent, packet);
    }
}
