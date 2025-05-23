package com.tencent.qphone.base.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    public static int a(int i3) {
        return ((i3 & 255) << 8) | ((65280 & i3) >> 8);
    }

    public static String b(String str) {
        StringBuilder sb5 = new StringBuilder();
        if (str != null) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                String hexString = Integer.toHexString(str.charAt(i3));
                if (hexString.length() % 2 == 0) {
                    sb5.append(hexString);
                } else {
                    sb5.append("0");
                    sb5.append(hexString);
                }
            }
        }
        return sb5.toString();
    }

    public static InetAddress a(long j3) throws UnknownHostException {
        return InetAddress.getByAddress(new byte[]{(byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255)});
    }

    public static InetAddress a(com.tencent.msf.service.protocol.push.h.a aVar) throws UnknownHostException {
        try {
            return InetAddress.getByAddress(aVar.f336575d);
        } catch (UnknownHostException unused) {
            return a(aVar.f336572a);
        }
    }

    public static final long a(String str) {
        Matcher matcher = Pattern.compile("((\\d{1,3}\\.){3}\\d{1,3})").matcher(str);
        if (!matcher.find()) {
            QLog.d("MSF.C.NetConnTag.", 1, "ip not match:" + str);
            return -2L;
        }
        String[] split = matcher.group(1).split("\\.");
        return (Long.parseLong(split[3]) << 24) + (Long.parseLong(split[2]) << 16) + (Long.parseLong(split[1]) << 8) + Long.parseLong(split[0]);
    }
}
