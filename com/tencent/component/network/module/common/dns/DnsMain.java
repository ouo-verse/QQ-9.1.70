package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DnsMain {
    private static final String TAG = "DnsMain";

    public static InetAddress[] getBetterHostByName(String str, long j3) {
        String hostName = getHostName(str);
        if (QDLog.isInfoEnable()) {
            QDLog.i(TAG, "hostName:" + hostName + ",timeout:" + j3 + "get better host for name:" + hostName);
        }
        if (hostName != null && hostName.trim().length() > 0) {
            String trim = hostName.trim();
            try {
                InetAddress[] run = new Lookup(DnsConstants.DNS_SERVER_ADDRESS_114).run(trim, j3);
                if (run != null && run.length > 0) {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(TAG, "get ip from Lookup: " + trim + " --- " + run);
                    }
                    return run;
                }
                QDLog.e(TAG, "114 - Address == null ? WTF ?!");
            } catch (WireParseException e16) {
                QDLog.e(TAG, "WireParseException cause[" + trim + "][114.114.114.114]." + e16.getMessage());
            } catch (SocketTimeoutException e17) {
                QDLog.e(TAG, "SocketTimeoutException cause[" + trim + "][114.114.114.114]." + e17.getMessage());
            } catch (UnknownHostException e18) {
                QDLog.e(TAG, "UnknownHostException cause[" + trim + "][114.114.114.114]." + e18.getMessage());
            } catch (IOException e19) {
                QDLog.e(TAG, "IOException cause[" + trim + "][114.114.114.114]." + e19.getMessage());
            } catch (Exception e26) {
                QDLog.e(TAG, "Exception cause[" + trim + "][114.114.114.114]." + e26.getMessage());
            }
        }
        return null;
    }

    public static String getHostName(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        String lowerCase = trim.toLowerCase();
        if (lowerCase.startsWith("http://")) {
            int indexOf = trim.indexOf("/", 8);
            if (indexOf > 7) {
                return trim.substring(7, indexOf);
            }
            return trim.substring(7);
        }
        if (lowerCase.startsWith("https://")) {
            int indexOf2 = trim.indexOf("/", 9);
            if (indexOf2 > 8) {
                return trim.substring(8, indexOf2);
            }
            return trim.substring(8);
        }
        if (trim.indexOf("/", 1) > 1) {
            return trim.substring(0, trim.indexOf("/", 1));
        }
        return trim;
    }
}
