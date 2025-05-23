package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StBaseLibInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetNewBaseLibRsp;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgConfigManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.Arrays;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetNewBaseLibServlet extends MiniAppAbstractServlet {
    public static final String TAG = "MiniAppGetNewBaseLibServlet";

    public MiniAppGetNewBaseLibServlet() {
        this.observerId = 1004;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetNewBaseLibRsp iNTERFACE$StGetNewBaseLibRsp = new INTERFACE$StGetNewBaseLibRsp();
        iNTERFACE$StGetNewBaseLibRsp.mergeFrom(bArr);
        int i3 = iNTERFACE$StGetNewBaseLibRsp.interval.get();
        QLog.i(TAG, 2, "[MiniEng] GetNewBaseLib interval:" + i3);
        StorageUtil.getPreference().edit().putLong("baselib_min_update_time", ((long) (i3 * 1000)) + System.currentTimeMillis()).apply();
        StorageUtil.getPreference().edit().putString(ApkgConfigManager.KEY_BASELIB_UPDATE_QUA, QUA.getQUA3()).apply();
        for (INTERFACE$StBaseLibInfo iNTERFACE$StBaseLibInfo : iNTERFACE$StGetNewBaseLibRsp.jsOrsoLibs.get()) {
            BaseLibInfo baseLibInfo = new BaseLibInfo();
            baseLibInfo.baseLibUrl = iNTERFACE$StBaseLibInfo.downloadUrl.get();
            baseLibInfo.baseLibVersion = iNTERFACE$StBaseLibInfo.version.get();
            baseLibInfo.baseLibKey = null;
            String str = iNTERFACE$StBaseLibInfo.extInfo.get();
            baseLibInfo.baseLibDesc = str;
            if (TextUtils.isEmpty(str)) {
                baseLibInfo.baseLibDesc = "{'file_length':-1}";
            }
            baseLibInfo.baseLibType = iNTERFACE$StBaseLibInfo.libType.get();
            baseLibInfo.updateFor64AbiIfNeed();
            bundle.putParcelable(baseLibInfo.getKey(), baseLibInfo);
            QLog.i(TAG, 1, "[MiniEng] GetNewBaseLib " + baseLibInfo + ",abi:" + Build.CPU_ABI + ",buildAbi:true,Build.SUPPORTED_ABIS:" + Arrays.toString(Build.SUPPORTED_ABIS));
        }
        bundle.putString("version", iNTERFACE$StGetNewBaseLibRsp.libInfo.version.get());
        bundle.putString("downloadUrl", iNTERFACE$StGetNewBaseLibRsp.libInfo.downloadUrl.get());
        notifyObserver(intent, 1004, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        Long valueOf = Long.valueOf(intent.getLongExtra("key_uin", 0L));
        String stringExtra = intent.getStringExtra(MiniAppAbstractServlet.KEY_VERSION);
        byte[] encode = new GetNewBaseLibRequest(valueOf.longValue(), stringExtra, intent.getIntExtra(MiniAppCmdUtil.KEY_LIBTYPE, 0)).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetNewBaseLibRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        QLog.i(TAG, 1, "[MiniEng] GetNewBaseLibServlet send request");
        super.onSend(intent, packet);
    }
}
