package com.tencent.mobileqq.utils;

import ActionMsg.MsgBody;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f307513a;

        /* renamed from: b, reason: collision with root package name */
        public int f307514b = -3000;

        /* renamed from: c, reason: collision with root package name */
        public int f307515c;

        /* renamed from: d, reason: collision with root package name */
        public String f307516d;
    }

    public static MsgBody a(String str) {
        MsgBody msgBody = new MsgBody();
        try {
            JceInputStream jceInputStream = new JceInputStream(com.qq.taf.jce.HexUtil.hexStr2Bytes(str));
            jceInputStream.setServerEncoding("utf-8");
            msgBody.readFrom(jceInputStream);
        } catch (Exception e16) {
            QLog.w("ActionMsgUtil", 2, "decode error msg = " + str);
            QLog.w("ActionMsgUtil", 2, e16.toString());
            msgBody.f24895msg = "";
            msgBody.action = "";
            msgBody.shareAppID = 0L;
            msgBody.actMsgContentValue = "";
        }
        return msgBody;
    }

    public static a b(byte[] bArr) {
        int i3;
        a aVar = new a();
        if (bArr != null && bArr.length > 0) {
            try {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                aVar.f307513a = wrap.get();
                if (wrap.get() == 0) {
                    i3 = MessageRecord.MSG_TYPE_GAME_INVITE;
                } else {
                    i3 = MessageRecord.MSG_TYPE_GAME_SHARE;
                }
                aVar.f307514b = i3;
                if (wrap.hasRemaining()) {
                    byte b16 = wrap.get();
                    byte[] bArr2 = new byte[wrap.getShort()];
                    wrap.get(bArr2);
                    aVar.f307515c = b16;
                    aVar.f307516d = new String(bArr2);
                    if (QLog.isColorLevel()) {
                        QLog.d("ActionMsgUtil", 2, "decodeAppShareCookie succes appShareCookie.buissnessType =" + aVar.f307513a + "appShareCookie.action" + aVar.f307514b + "appShareCookie.actionType" + aVar.f307515c + "appShareCookie.actionValue" + aVar.f307516d);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("ActionMsgUtil", 2, "decodeAppShareCookie", e16);
                }
            }
        }
        return aVar;
    }

    public static String c(String str, String str2) {
        return d(str, str2, 0L, null);
    }

    public static String d(String str, String str2, long j3, String str3) {
        if (str == null) {
            QLog.w("ActionMsgUtil", 2, "encode msg is null");
            str = "";
        }
        if (str2 == null) {
            QLog.w("ActionMsgUtil", 2, "encode action is null");
            str2 = "";
        }
        MsgBody msgBody = new MsgBody();
        msgBody.f24895msg = str;
        msgBody.action = str2;
        msgBody.shareAppID = j3;
        msgBody.actMsgContentValue = str3;
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf-8");
        msgBody.writeTo(jceOutputStream);
        return com.qq.taf.jce.HexUtil.bytes2HexStr(jceOutputStream.toByteArray());
    }

    public static boolean e(int i3) {
        if (i3 == -2007) {
            return true;
        }
        return false;
    }

    public static boolean f(int i3) {
        if (i3 == -8018) {
            return true;
        }
        return false;
    }

    public static boolean g(int i3) {
        if (i3 == -2016) {
            return true;
        }
        return false;
    }

    public static boolean h(int i3) {
        if (i3 != -3000 && i3 != -3004 && i3 != -3005) {
            return false;
        }
        return true;
    }

    public static boolean i(int i3) {
        if (i3 != -2009 && i3 != -3012) {
            return false;
        }
        return true;
    }
}
