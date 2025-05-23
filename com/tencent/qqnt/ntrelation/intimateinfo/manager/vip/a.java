package com.tencent.qqnt.ntrelation.intimateinfo.manager.vip;

import com.qzone.module.vipcomponent.common.VipUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(long j3, byte[] bArr) {
        if (bArr != null && bArr.length > 2) {
            submsgtype0xc7$SpecialInfo submsgtype0xc7_specialinfo = new submsgtype0xc7$SpecialInfo();
            try {
                submsgtype0xc7_specialinfo.mergeFrom(bArr, 2, bArr.length - 2);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isDebugVersion()) {
                    QLog.e(VipUtils.TAG, 1, "getCurSpecialType InvalidProtocolBufferMicroException : ", e16);
                }
            }
            for (submsgtype0xc7$SpeciesFlag submsgtype0xc7_speciesflag : submsgtype0xc7_specialinfo.list.get()) {
                if (submsgtype0xc7_speciesflag.flag_id.get() == j3) {
                    return submsgtype0xc7_speciesflag.special_type.get();
                }
            }
        }
        return 0;
    }

    public static int b(String str, int i3, byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int c16 = c(i3, bArr);
        if (QLog.isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                sb5.append("" + ((int) b16) + " ");
            }
            VasLogNtReporter.getMutualMark().reportDebug("getFriendRelationIconType uin=" + str + " relationType=" + i3 + " relationIconType=" + c16 + " vas_flags=" + ((Object) sb5));
        }
        return c16;
    }

    private static int c(int i3, byte[] bArr) {
        int i16;
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 1) {
            i16 = (bArr[0] & 255) | (bArr[1] << 8);
        } else if (bArr.length == 1) {
            i16 = bArr[0];
        } else {
            i16 = 0;
        }
        if (QLog.isDebugVersion()) {
            VasLogNtReporter.getMutualMark().reportDebug("relationIconFlag " + Integer.toBinaryString(i16));
        }
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            if (i3 != 5) {
                return 0;
            }
            return (i16 >> (i3 * 2)) & 7;
        }
        return (i16 >> (i3 * 2)) & 3;
    }

    public static int d(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 == 12) {
                    return 1;
                }
                if (i3 == 19) {
                    return 5;
                }
                return -1;
            }
            return 0;
        }
        return 4;
    }
}
