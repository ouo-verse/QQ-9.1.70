package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    static IPatchRedirector $redirector_;

    public static boolean a(String str, String str2, String str3) {
        int i3;
        int i16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] split = Pattern.compile(str3, 16).split(str);
                String[] split2 = Pattern.compile(str3, 16).split(str2);
                int max = Math.max(split.length, split2.length);
                for (int i17 = 0; i17 < max; i17++) {
                    if (split.length > i17) {
                        i3 = Integer.parseInt(split[i17]);
                    } else {
                        i3 = 0;
                    }
                    if (split2.length > i17) {
                        i16 = Integer.parseInt(split2[i17]);
                    } else {
                        i16 = 0;
                    }
                    if (i3 < i16) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static StructMsgForGeneralShare b() {
        return new StructMsgForGeneralShare();
    }

    public static AbsStructMsg c() {
        StructMsgForGeneralShare structMsgForGeneralShare = new StructMsgForGeneralShare();
        structMsgForGeneralShare.fwFlag = 0;
        structMsgForGeneralShare.mMsgTemplateID = 1;
        structMsgForGeneralShare.mMsgServiceID = 1;
        structMsgForGeneralShare.mMsgBrief = HardCodeUtil.qqStr(R.string.tvz);
        structMsgForGeneralShare.mMsgAction = "";
        structMsgForGeneralShare.mMsgActionData = "";
        structMsgForGeneralShare.mMsg_A_ActionData = "";
        structMsgForGeneralShare.mMsg_I_ActionData = "";
        structMsgForGeneralShare.mMsgUrl = "";
        structMsgForGeneralShare.mFlag = 55;
        h.c(0).m(new StructMsgItemTitle(""));
        return structMsgForGeneralShare;
    }

    public static AbsStructMsg d(byte[] bArr) {
        AbsStructMsg absStructMsg;
        AbsStructMsg structMsgForImageShare;
        ObjectInputStream objectInputStream = null;
        AbsStructMsg absStructMsg2 = null;
        ObjectInputStream objectInputStream2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            try {
                ObjectInputStream objectInputStream3 = new ObjectInputStream(new ByteArrayInputStream(bArr));
                try {
                    int readInt = objectInputStream3.readInt();
                    if (readInt == 2) {
                        structMsgForImageShare = new StructMsgForAudioShare();
                    } else {
                        if (readInt != 5 && readInt != 137) {
                            structMsgForImageShare = new StructMsgForGeneralShare();
                        }
                        structMsgForImageShare = new StructMsgForImageShare();
                    }
                    absStructMsg2 = structMsgForImageShare;
                    absStructMsg2.mMsgServiceID = readInt;
                    absStructMsg2.readExternal(objectInputStream3);
                    try {
                        objectInputStream3.close();
                        return absStructMsg2;
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StructMsg", 2, e16.getMessage());
                            return absStructMsg2;
                        }
                        return absStructMsg2;
                    }
                } catch (Exception e17) {
                    e = e17;
                    absStructMsg = absStructMsg2;
                    objectInputStream = objectInputStream3;
                    if (QLog.isColorLevel()) {
                        QLog.d("StructMsg", 2, e.getMessage());
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e18) {
                            if (QLog.isColorLevel()) {
                                QLog.d("StructMsg", 2, e18.getMessage());
                            }
                        }
                    }
                    return absStructMsg;
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream2 = objectInputStream3;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e19) {
                            if (QLog.isColorLevel()) {
                                QLog.d("StructMsg", 2, e19.getMessage());
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
                absStructMsg = null;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static AbsStructMsg e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i3 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE, 146);
        if (i3 != 2) {
            if (i3 != 5) {
                return new StructMsgForGeneralShare(bundle);
            }
            return new StructMsgForImageShare(bundle);
        }
        return new StructMsgForAudioShare(bundle);
    }

    public static AbsStructMsg f(QQAppInterface qQAppInterface, int i3, long j3, byte[] bArr, int i16) {
        AbsStructMsg g16 = g(bArr, i16);
        if (g16 != null && (g16 instanceof AbsShareMsg)) {
            long j16 = g16.mMsgServiceID;
            long j17 = ((AbsShareMsg) g16).mSourceAppid;
            if (j16 == 23 && (i3 == 82 || i3 == 43)) {
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_AIO", qQAppInterface.getCurrentAccountUin(), "AIOchat", "appear_obj", 0, 0, String.valueOf(j3), String.valueOf(j16), String.valueOf(j17), "");
            }
            if (j16 == 52) {
                QLog.i("StructMsg", 1, "rec flower msg," + com.tencent.mobileqq.structmsg.view.h.G(g16));
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff = null ,error happened ");
        }
        return g16;
    }

    public static AbsStructMsg g(byte[] bArr, int i3) {
        if (bArr != null && bArr.length >= 2) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff uncompress begin: ", HexUtil.bytes2HexStr(bArr));
            }
            byte[] i16 = k.i(bArr, i3);
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff uncompress finished");
            }
            String uuid = UUID.randomUUID().toString();
            try {
                String str = new String(i16, "utf-8");
                String j3 = j(EmotcationConstants.beforXml(str, uuid, i(str)));
                if (QLog.isDevelopLevel()) {
                    QLog.i("StructMsg", 4, "getStructMsgFromXmlBuff:" + j3);
                }
                return null;
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff = " + e16.getMessage());
                }
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff xmlbuff is null or lenght<2");
        }
        return null;
    }

    public static String h(j jVar) {
        String sb5;
        if (jVar.f290432f == 3) {
            sb5 = jVar.f290427a;
        } else {
            StringBuilder sb6 = new StringBuilder();
            int b16 = jVar.b();
            for (int i3 = 0; i3 < b16; i3++) {
                j c16 = jVar.c(i3);
                if (c16 != null && c16.f290432f == 3) {
                    sb6.append(c16.f290427a);
                }
            }
            sb5 = sb6.toString();
        }
        if (sb5 == null) {
            return "";
        }
        return sb5;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("serviceID=\"83\"")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String j(String str) {
        boolean a16;
        int i3;
        boolean z16;
        String property = System.getProperty("java.vm.version");
        if (!TextUtils.isEmpty(property)) {
            try {
                a16 = a(property, "2.0.0", ".");
            } catch (Exception unused) {
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("StructMsg", 4, "java vm version  = " + property + " isART = " + a16);
            }
            StringBuilder P = l.P();
            P.append(str);
            i3 = 0;
            int i16 = 0;
            while (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != '&' && charAt != '<' && charAt != '>') {
                    if ((charAt >= ' ' && charAt <= '\ud7ff') || (charAt >= '\ue000' && charAt <= '\ufffd')) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (a16) {
                        if (!z16) {
                            P.deleteCharAt(i3 - i16);
                            i16++;
                            if (QLog.isColorLevel()) {
                                QLog.d("StructMsg", 2, " ContainInvalidCharacter return null ,invalid char  = " + Integer.toHexString(charAt));
                            }
                        }
                    } else if (!z16) {
                        int codePointAt = str.codePointAt(i3);
                        if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) >= 0) {
                            if (codePointAt > 65535) {
                                i3++;
                            }
                        } else {
                            P.deleteCharAt(i3 - i16);
                            i16++;
                        }
                    }
                }
                i3++;
            }
            return P.toString();
        }
        a16 = false;
        if (QLog.isDevelopLevel()) {
        }
        StringBuilder P2 = l.P();
        P2.append(str);
        i3 = 0;
        int i162 = 0;
        while (i3 < str.length()) {
        }
        return P2.toString();
    }
}
