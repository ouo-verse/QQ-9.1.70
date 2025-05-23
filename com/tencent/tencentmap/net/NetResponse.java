package com.tencent.tencentmap.net;

import com.tencent.map.tools.net.exception.NetErrorException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class NetResponse {
    public String charset;
    public byte[] data;
    public int errorCode;
    public byte[] errorData;
    public Exception exception;
    public int statusCode;

    public NetResponse() {
        this.errorCode = -1;
        this.charset = "GBK";
    }

    public boolean available() {
        if (this.errorCode != 0 || this.statusCode != 200) {
            byte[] bArr = this.data;
            if (bArr != null && bArr.length > 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    public String toString() {
        try {
            byte[] bArr = this.data;
            if (bArr != null) {
                return new String(bArr, this.charset);
            }
            return "";
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public NetResponse(com.tencent.map.tools.net.NetResponse netResponse) {
        this.errorCode = -1;
        this.charset = "GBK";
        if (netResponse != null) {
            this.errorCode = netResponse.errorCode;
            this.statusCode = netResponse.statusCode;
            this.data = netResponse.data;
            this.charset = netResponse.charset;
            this.exception = netResponse.exception;
            this.errorData = netResponse.errorData;
        }
    }

    public NetResponse(Exception exc) {
        this.errorCode = -1;
        this.charset = "GBK";
        this.exception = exc;
        if (exc instanceof NetErrorException) {
            NetErrorException netErrorException = (NetErrorException) exc;
            this.errorCode = netErrorException.errorCode;
            this.statusCode = netErrorException.statusCode;
        }
    }
}
