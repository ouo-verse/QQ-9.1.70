package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.litetransfersdk.LiteTransferType;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.guild.api.IGuildManageUtilApi;
import com.tencent.mobileqq.guild.config.GuildNTDBConfigProcessor;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildManageUtilApiImpl implements IGuildManageUtilApi {
    static final String TAG = "GuildManageUtil";

    private <T> T loadConObj(int i3) {
        return (T) am.s().x(i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildManageUtilApi
    public boolean enableRetrieveById() {
        com.tencent.mobileqq.guild.config.y yVar = (com.tencent.mobileqq.guild.config.y) am.s().x(733);
        if (yVar != null && yVar.N) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildManageUtilApi
    public void setConfigForNT() {
        String str;
        if (!((IGuildUserService) ch.R0(IGuildUserService.class)).isGuildUserCached()) {
            QLog.e(TAG, 1, "setConfigForNT: not Guild User");
            return;
        }
        GuildNTDBConfigProcessor.a aVar = (GuildNTDBConfigProcessor.a) loadConObj(LiteTransferType.MsgBodyType.MsgType_0x346);
        if (aVar != null) {
            str = aVar.b();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "setConfigForNT: content np");
            return;
        }
        com.tencent.qqnt.kernel.api.t guildMsgService = ((IKernelService) ch.R0(IKernelService.class)).getGuildMsgService();
        if (guildMsgService == null) {
            QLog.e(TAG, 1, "setConfigForNT: service np");
            return;
        }
        QLog.i(TAG, 1, "setConfigForNT:" + str);
        HashMap<Long, String> hashMap = new HashMap<>();
        hashMap.put(838L, str);
        guildMsgService.setConfigurationServiceData(hashMap);
    }
}
