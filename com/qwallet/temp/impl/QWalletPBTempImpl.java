package com.qwallet.temp.impl;

import com.qwallet.temp.IQWalletPBTemp;
import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x66$MsgBody;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x7e$MsgBody$OnlinePush;
import com.tencent.mobileqq.pb.ByteStringMicro;
import tencent.im.oidb.cmd0x857.TroopTips0x857$GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858$GoldMsgTipsElem;
import tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e$WalletMsgPush;

/* loaded from: classes39.dex */
public class QWalletPBTempImpl implements IQWalletPBTemp {
    @Override // com.qwallet.temp.IQWalletPBTemp
    public QWalletSubmsgtype0x66$MsgBody convertToMsgBody(byte[] bArr) throws Exception {
        ByteStringMicro byteStringMicro;
        submsgtype0x66$MsgBody mergeFrom = new submsgtype0x66$MsgBody().mergeFrom(bArr);
        QWalletSubmsgtype0x66$MsgBody qWalletSubmsgtype0x66$MsgBody = new QWalletSubmsgtype0x66$MsgBody();
        if (mergeFrom.uint32_type.has()) {
            qWalletSubmsgtype0x66$MsgBody.pushType = mergeFrom.uint32_type.get();
        }
        if (mergeFrom.bytes_push_data.has() && (byteStringMicro = mergeFrom.bytes_push_data.get()) != null) {
            qWalletSubmsgtype0x66$MsgBody.pushData = byteStringMicro.toByteArray();
        }
        return qWalletSubmsgtype0x66$MsgBody;
    }

    @Override // com.qwallet.temp.IQWalletPBTemp
    public QWalletSubmsgtype0x7e$MsgBody$OnlinePush convertToOnlinePush(byte[] bArr) throws Exception {
        submsgtype0x7e$WalletMsgPush submsgtype0x7e_walletmsgpush;
        String str;
        String str2;
        String str3;
        String str4;
        ByteStringMicro byteStringMicro;
        submsgtype0x7e$MsgBody mergeFrom = new submsgtype0x7e$MsgBody().mergeFrom(bArr);
        if (!mergeFrom.msg_online_push.has() || (submsgtype0x7e_walletmsgpush = mergeFrom.msg_online_push.get()) == null) {
            return null;
        }
        int i3 = submsgtype0x7e_walletmsgpush.uint32_action.has() ? submsgtype0x7e_walletmsgpush.uint32_action.get() : -1;
        int i16 = submsgtype0x7e_walletmsgpush.uint32_timestamp.has() ? submsgtype0x7e_walletmsgpush.uint32_timestamp.get() : -1;
        String str5 = "";
        if (!submsgtype0x7e_walletmsgpush.bytes_extend.has() || (byteStringMicro = submsgtype0x7e_walletmsgpush.bytes_extend.get()) == null) {
            str = "";
        } else {
            str = new String(byteStringMicro.toByteArray(), "UTF-8");
        }
        if (!submsgtype0x7e_walletmsgpush.str_serialno.has()) {
            str2 = "";
        } else {
            str2 = submsgtype0x7e_walletmsgpush.str_serialno.get();
        }
        if (!submsgtype0x7e_walletmsgpush.str_billno.has()) {
            str3 = "";
        } else {
            str3 = submsgtype0x7e_walletmsgpush.str_billno.get();
        }
        if (!submsgtype0x7e_walletmsgpush.str_appinfo.has()) {
            str4 = "";
        } else {
            str4 = submsgtype0x7e_walletmsgpush.str_appinfo.get();
        }
        int i17 = submsgtype0x7e_walletmsgpush.uint32_amount.has() ? submsgtype0x7e_walletmsgpush.uint32_amount.get() : -1;
        if (submsgtype0x7e_walletmsgpush.str_jumpurl.has()) {
            str5 = submsgtype0x7e_walletmsgpush.str_jumpurl.get();
        }
        QWalletSubmsgtype0x7e$MsgBody$OnlinePush qWalletSubmsgtype0x7e$MsgBody$OnlinePush = new QWalletSubmsgtype0x7e$MsgBody$OnlinePush();
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.action = i3;
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.timestamp = i16;
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.extend = str;
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.serialno = str2;
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.appinfo = str4;
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.jumpurl = str5;
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.billno = str3;
        qWalletSubmsgtype0x7e$MsgBody$OnlinePush.amount = i17;
        return qWalletSubmsgtype0x7e$MsgBody$OnlinePush;
    }

    @Override // com.qwallet.temp.IQWalletPBTemp
    public QWalletGoldMsgTipsElem convertTroopTips(byte[] bArr) throws Exception {
        TroopTips0x857$GoldMsgTipsElem troopTips0x857$GoldMsgTipsElem = new TroopTips0x857$GoldMsgTipsElem();
        troopTips0x857$GoldMsgTipsElem.mergeFrom(bArr);
        QWalletGoldMsgTipsElem qWalletGoldMsgTipsElem = new QWalletGoldMsgTipsElem();
        qWalletGoldMsgTipsElem.type = troopTips0x857$GoldMsgTipsElem.type.has() ? troopTips0x857$GoldMsgTipsElem.type.get() : 0;
        qWalletGoldMsgTipsElem.billno = troopTips0x857$GoldMsgTipsElem.billno.has() ? troopTips0x857$GoldMsgTipsElem.billno.get() : "";
        qWalletGoldMsgTipsElem.action = troopTips0x857$GoldMsgTipsElem.action.has() ? troopTips0x857$GoldMsgTipsElem.action.get() : 0;
        return qWalletGoldMsgTipsElem;
    }

    @Override // com.qwallet.temp.IQWalletPBTemp
    public QWalletGoldMsgTipsElem convertTroopTips(Object obj) throws Exception {
        String str;
        int i3;
        int i16;
        int i17 = 0;
        str = "";
        if (obj instanceof oidb_0x858$GoldMsgTipsElem) {
            oidb_0x858$GoldMsgTipsElem oidb_0x858_goldmsgtipselem = (oidb_0x858$GoldMsgTipsElem) obj;
            i16 = oidb_0x858_goldmsgtipselem.type.has() ? oidb_0x858_goldmsgtipselem.type.get() : 0;
            str = oidb_0x858_goldmsgtipselem.billno.has() ? oidb_0x858_goldmsgtipselem.billno.get() : "";
            if (oidb_0x858_goldmsgtipselem.action.has()) {
                i17 = oidb_0x858_goldmsgtipselem.action.get();
            }
        } else if (obj instanceof TroopTips0x857$GoldMsgTipsElem) {
            TroopTips0x857$GoldMsgTipsElem troopTips0x857$GoldMsgTipsElem = (TroopTips0x857$GoldMsgTipsElem) obj;
            i16 = troopTips0x857$GoldMsgTipsElem.type.has() ? troopTips0x857$GoldMsgTipsElem.type.get() : 0;
            str = troopTips0x857$GoldMsgTipsElem.billno.has() ? troopTips0x857$GoldMsgTipsElem.billno.get() : "";
            if (troopTips0x857$GoldMsgTipsElem.action.has()) {
                i17 = troopTips0x857$GoldMsgTipsElem.action.get();
            }
        } else {
            i3 = 0;
            QWalletGoldMsgTipsElem qWalletGoldMsgTipsElem = new QWalletGoldMsgTipsElem();
            qWalletGoldMsgTipsElem.type = i17;
            qWalletGoldMsgTipsElem.billno = str;
            qWalletGoldMsgTipsElem.action = i3;
            return qWalletGoldMsgTipsElem;
        }
        i3 = i17;
        i17 = i16;
        QWalletGoldMsgTipsElem qWalletGoldMsgTipsElem2 = new QWalletGoldMsgTipsElem();
        qWalletGoldMsgTipsElem2.type = i17;
        qWalletGoldMsgTipsElem2.billno = str;
        qWalletGoldMsgTipsElem2.action = i3;
        return qWalletGoldMsgTipsElem2;
    }
}
