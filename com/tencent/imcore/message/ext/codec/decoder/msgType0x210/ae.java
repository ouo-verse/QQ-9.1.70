package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.util.cr;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm$MsgType0x210;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ae implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean b(long j3, boolean z16, String str) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        long decodeLong = from.decodeLong(str + "_msg_revoke_withdraw_begin", 0L);
        long decodeLong2 = from.decodeLong(str + "_msg_revoke_withdraw_end", 0L);
        long decodeLong3 = from.decodeLong(str + "_msg_revoke_msg_begin", 0L);
        long decodeLong4 = from.decodeLong(str + "_msg_revoke_msg_end", 0L);
        e("decodeMsg", str, decodeLong, decodeLong2, decodeLong3, decodeLong4, from.decodeInt(str + "_msg_revoke_config_version", 0));
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("SubType0x157", 2, "decodeMsg, curTime=", c(currentTimeMillis), ", msg.time=", c(j3 * 1000), ", oldStrategy=", z16 + ", msg=" + j3);
        }
        if (decodeLong != 0 && decodeLong2 != 0 && decodeLong3 != 0 && decodeLong4 != 0 && decodeLong <= currentTimeMillis && decodeLong2 >= currentTimeMillis) {
            long j16 = j3 * 1000;
            if (decodeLong3 <= j16 && decodeLong4 >= j16) {
                return true;
            }
        }
        return z16;
    }

    private static String c(long j3) {
        return cr.a(j3);
    }

    public static void d(AppRuntime appRuntime, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        com.tencent.mobileqq.revokemsg.a.a(appRuntime);
    }

    private static void e(String str, String str2, long j3, long j16, long j17, long j18, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SubType0x157", 2, str, ", configVersion=", Integer.valueOf(i3), ", currentUin=", StringUtil.getSimpleUinForPrint(str2), ", withDrawBegin=", c(j3), ", withDrawEnd=", c(j16), ", msgBegin=", c(j17), ", msgEnd=", c(j18));
        }
    }

    public static boolean f(AppRuntime appRuntime, long j3, long j16) {
        boolean z16;
        if (NetConnInfoCenter.getServerTimeMillis() - (1000 * j3) < j16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!com.tencent.mobileqq.revokemsg.a.a(appRuntime)) {
            return z16;
        }
        String currentUin = appRuntime.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            QLog.e("SubType0x157", 1, "currentUin is null");
            return z16;
        }
        return b(j3, z16, currentUin);
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        com.tencent.mobileqq.revokemsg.a.a(afVar.d());
        return null;
    }
}
