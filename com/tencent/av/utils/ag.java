package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.s;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ag {
    public static int a(VideoAppInterface videoAppInterface, int i3, String str, int i16) {
        if (i3 == 19 && !TextUtils.isEmpty(str)) {
            return videoAppInterface.q(str);
        }
        return com.tencent.av.r.s(i3, false, i16);
    }

    public static boolean b(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("Fromwhere");
        } else {
            str = null;
        }
        if (str != null && str.compareTo("AVNotification") == 0) {
            return true;
        }
        return false;
    }

    public static String c(s.a aVar) {
        String valueOf = String.valueOf(aVar.f74252m);
        int i3 = aVar.f74251l;
        if (i3 != 4 && i3 != 5) {
            switch (i3) {
                case 24:
                case 25:
                case 26:
                    break;
                default:
                    return valueOf;
            }
        }
        return aVar.f74241b + aVar.f74240a;
    }

    public static Intent d(Context context, String str) {
        SessionInfo i3;
        if (TextUtils.isEmpty(str) || (i3 = com.tencent.av.n.e().i(str)) == null) {
            return null;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) GaInviteLockActivity.class);
            intent.addFlags(268435456);
            g(intent, i3);
            return intent;
        } catch (Throwable th5) {
            QLog.i("QAVNotificationUtil", 1, "getGroupInviteIntent error", th5);
            return null;
        }
    }

    public static Intent e(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) MultiIncomingCallsActivity.class);
        if (TextUtils.isEmpty(str)) {
            return intent;
        }
        SessionInfo i3 = com.tencent.av.n.e().i(str);
        if (i3 == null) {
            return intent;
        }
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3.f73035i);
        if (AVUtil.o(i3.f73067q)) {
            g(intent, i3);
        } else {
            f(intent, i3);
        }
        return intent;
    }

    public static void f(Intent intent, SessionInfo sessionInfo) {
        intent.putExtra("uinType", sessionInfo.f73067q);
        intent.putExtra("relationType", ba.uinType2AVRelationType(sessionInfo.f73067q));
        intent.putExtra("peerUin", sessionInfo.f73091w);
        intent.putExtra("extraUin", sessionInfo.f73103z);
        intent.putExtra("isAudioMode", sessionInfo.M0);
        intent.putExtra("isDoubleVideoMeeting", sessionInfo.f73060o0);
        intent.putExtra("bindType", sessionInfo.B0);
    }

    public static void g(Intent intent, SessionInfo sessionInfo) {
        long j3;
        try {
            j3 = Long.parseLong(sessionInfo.Y0);
        } catch (Throwable th5) {
            th5.printStackTrace();
            j3 = 0;
        }
        intent.putExtra("uinType", sessionInfo.f73067q);
        intent.putExtra("peerUin", sessionInfo.Y0);
        intent.putExtra("friendUin", j3);
        intent.putExtra("relationType", sessionInfo.S0);
        intent.putExtra("MultiAVType", sessionInfo.f73063p);
        intent.putExtra("discussId", sessionInfo.P0);
        intent.putExtra("memberList", sessionInfo.Q0);
    }

    public static void h(String str, String str2, VideoAppInterface videoAppInterface, s.a aVar, String str3) {
        boolean z16;
        String str4;
        boolean z17;
        String str5;
        int i3;
        String str6;
        String str7;
        Bitmap bitmap;
        Bitmap bitmap2;
        if (QLog.isColorLevel()) {
            QLog.i("CompatModeTag", 2, "showInviteNotification videoPacket[" + aVar + "], session[" + str2 + "], from[" + str + "]");
        }
        String valueOf = String.valueOf(aVar.f74247h);
        int a16 = a(videoAppInterface, aVar.f74251l, valueOf, 0);
        String c16 = c(aVar);
        if (aVar.f74248i == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            if (!com.tencent.av.r.h0().f1(a16, valueOf, c16, null, z16, null, 0, aVar.f74245f)) {
                QLog.w("CompatModeTag", 1, "showNotification() return ! isRequestVideo = false");
                return;
            }
            QAVNotification l3 = QAVNotification.l(videoAppInterface);
            Bitmap J = videoAppInterface.J(a16, valueOf, c16, true, true);
            String G = videoAppInterface.G(a16, valueOf, c16);
            if (AVUtil.p()) {
                if (z16) {
                    bitmap2 = J;
                    str4 = G;
                    z17 = z16;
                    str5 = c16;
                    i3 = a16;
                    str6 = "CompatModeTag";
                    str7 = valueOf;
                    l3.a(true, str2, G, J, null, 45, a16, 1, null, str3);
                } else {
                    str4 = G;
                    z17 = z16;
                    str5 = c16;
                    i3 = a16;
                    str6 = "CompatModeTag";
                    str7 = valueOf;
                    bitmap2 = J;
                    l3.a(true, str2, str4, J, null, 40, i3, 2, null, str3);
                }
                bitmap = bitmap2;
            } else {
                str4 = G;
                z17 = z16;
                str5 = c16;
                i3 = a16;
                str6 = "CompatModeTag";
                str7 = valueOf;
                bitmap = J;
                if (z17) {
                    l3.b(false, str2, str4, bitmap, null, 45, i3, 1, str3);
                } else {
                    l3.b(false, str2, str4, bitmap, null, 40, i3, 2, str3);
                }
            }
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder(200);
                sb5.append("showNotification, isAudioMode=");
                sb5.append(z17);
                sb5.append(", sessionId=");
                sb5.append(str2);
                sb5.append(", uinType=");
                sb5.append(i3);
                sb5.append(", peerUin=");
                sb5.append(str7);
                sb5.append(", extraUin=");
                sb5.append(str5);
                sb5.append(", face=");
                sb5.append(bitmap);
                sb5.append(", peerName=");
                sb5.append(str4);
                sb5.append(", videoPacket=");
                sb5.append(aVar);
                QLog.i(str6, 2, sb5.toString());
            }
        } catch (Exception e16) {
            QLog.w("CompatModeTag", 1, "showNotification() return ! Exception = ", e16);
        }
    }
}
