package com.tencent.superplayer.utils;

import android.text.TextUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.report.SPReportEvent;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static int a(long j3, int i3) {
        return (int) (((j3 / 1024) * 8) / i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(ISuperPlayer iSuperPlayer, SPReportEvent sPReportEvent, String str) {
        String str2;
        int i3;
        int i16;
        String str3;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        String str4;
        String str5 = sPReportEvent.url;
        String str6 = null;
        if (!TextUtils.isEmpty(str5)) {
            int indexOf = str5.indexOf(".f");
            int indexOf2 = str5.indexOf(".mp4?");
            int indexOf3 = str5.indexOf(".com/");
            if (indexOf > 0 && indexOf2 - 5 > 0 && indexOf < indexOf2) {
                str4 = str5.substring(indexOf + 1, indexOf2);
            } else {
                str4 = null;
            }
            if (indexOf3 > 0) {
                str6 = str5.substring(indexOf3 + 5, indexOf3 + 19);
            }
            str2 = str6;
            str6 = str4;
        } else {
            str2 = null;
        }
        long j3 = sPReportEvent.duration;
        int i28 = 0;
        if (j3 > 0) {
            long j16 = sPReportEvent.fileSize;
            if (j16 > 0) {
                i3 = (int) (((((float) j16) / 1024.0f) * 8.0f) / (((float) j3) / 1000.0f));
                i16 = (int) (((float) sPReportEvent.fileSize) / 1024.0f);
                if (i16 <= 1024000) {
                    i16 /= 1024;
                    str3 = "MB";
                } else {
                    str3 = "KB";
                }
                String str7 = LogUtil.TAG + str + " [" + sPReportEvent.width + "*" + sPReportEvent.height + "]\n" + str2 + "\n" + str6 + " " + i3 + "kbps filesize: " + i16 + str3;
                if (i3 <= 0) {
                    int a16 = a(sPReportEvent.httpDownloadSize - sPReportEvent.pcdnDownloadSize, i3);
                    i18 = a(sPReportEvent.pcdnDownloadSize, i3);
                    i19 = a(sPReportEvent.p2pDownloadSize, i3);
                    i26 = a(sPReportEvent.pcdnRepeatedSize, i3);
                    i27 = a(sPReportEvent.p2pRepeatedSize, i3);
                    i28 = a(sPReportEvent.totalDownloadedSize, i3);
                    i17 = a16;
                } else {
                    i17 = 0;
                    i18 = 0;
                    i19 = 0;
                    i26 = 0;
                    i27 = 0;
                }
                String str8 = str7 + "\nwatch/download/total: \n" + ((int) (iSuperPlayer.getCurrentPositionMs() / 1000)) + "/" + i28 + "/" + (sPReportEvent.duration / 1000);
                return (((str8 + "\ncdn/pcdn/p2p/other: \n" + i17 + "/" + i18 + "/" + i19 + "/" + (((((i28 - i17) - i18) - i19) - i26) - i27)) + "\nquic: " + sPReportEvent.quicEnableMode + " downloadByQuic: " + sPReportEvent.isDownloadByQuic) + "\nenableP2P: " + sPReportEvent.enableP2P + " nat: " + sPReportEvent.natType) + "\n" + sPReportEvent.extDebugInfo;
            }
        }
        i3 = 0;
        i16 = (int) (((float) sPReportEvent.fileSize) / 1024.0f);
        if (i16 <= 1024000) {
        }
        String str72 = LogUtil.TAG + str + " [" + sPReportEvent.width + "*" + sPReportEvent.height + "]\n" + str2 + "\n" + str6 + " " + i3 + "kbps filesize: " + i16 + str3;
        if (i3 <= 0) {
        }
        String str82 = str72 + "\nwatch/download/total: \n" + ((int) (iSuperPlayer.getCurrentPositionMs() / 1000)) + "/" + i28 + "/" + (sPReportEvent.duration / 1000);
        return (((str82 + "\ncdn/pcdn/p2p/other: \n" + i17 + "/" + i18 + "/" + i19 + "/" + (((((i28 - i17) - i18) - i19) - i26) - i27)) + "\nquic: " + sPReportEvent.quicEnableMode + " downloadByQuic: " + sPReportEvent.isDownloadByQuic) + "\nenableP2P: " + sPReportEvent.enableP2P + " nat: " + sPReportEvent.natType) + "\n" + sPReportEvent.extDebugInfo;
    }
}
