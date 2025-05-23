package com.tencent.component.network.module.common.dns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Lookup {
    private String dnsServerAddress;

    public Lookup(String str) throws UnknownHostException {
        this.dnsServerAddress = str;
    }

    public InetAddress[] run(String str, long j3) throws IOException, SocketTimeoutException, WireParseException, UnknownHostException, Exception {
        RequestPacket requestPacket = new RequestPacket(str);
        byte[] queryData = requestPacket.getQueryData();
        InetAddress[] inetAddressArr = null;
        if (queryData == null) {
            return null;
        }
        try {
            UdpClient udpClient = new UdpClient();
            udpClient.setTimeout(j3);
            byte[] sendrecv = udpClient.sendrecv(this.dnsServerAddress, queryData);
            if (sendrecv != null) {
                ResponsePacket responsePacket = new ResponsePacket(new DNSInput(sendrecv), str);
                if (responsePacket.getReqId() == requestPacket.getReqId() && (inetAddressArr = responsePacket.getByAddress()) != null && inetAddressArr.length > 0) {
                    HostCacheManager.getInstance().addCache(str, inetAddressArr, responsePacket.getExpireTime());
                }
            }
            return inetAddressArr;
        } catch (WireParseException e16) {
            throw e16;
        } catch (SocketTimeoutException e17) {
            throw e17;
        } catch (IOException e18) {
            throw e18;
        }
    }

    public void setDnsAddress(String str) {
        this.dnsServerAddress = str;
    }
}
