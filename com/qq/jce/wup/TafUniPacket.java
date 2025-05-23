package com.qq.jce.wup;

import com.qq.taf.RequestPacket;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class TafUniPacket extends UniPacket {
    private static final long serialVersionUID = 1;

    public TafUniPacket() {
        RequestPacket requestPacket = this._package;
        requestPacket.iVersion = (short) 2;
        requestPacket.cPacketType = (byte) 0;
        requestPacket.iMessageType = 0;
        requestPacket.iTimeout = 0;
        requestPacket.sBuffer = new byte[0];
        requestPacket.context = new HashMap();
        this._package.status = new HashMap();
    }

    public byte[] getTafBuffer() {
        return this._package.sBuffer;
    }

    public Map<String, String> getTafContext() {
        return this._package.context;
    }

    public int getTafMessageType() {
        return this._package.iMessageType;
    }

    public byte getTafPacketType() {
        return this._package.cPacketType;
    }

    public int getTafResultCode() {
        String str = this._package.status.get("STATUS_RESULT_CODE");
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public String getTafResultDesc() {
        String str = this._package.status.get("STATUS_RESULT_DESC");
        if (str == null) {
            return "";
        }
        return str;
    }

    public Map<String, String> getTafStatus() {
        return this._package.status;
    }

    public int getTafTimeout() {
        return this._package.iTimeout;
    }

    public short getTafVersion() {
        return this._package.iVersion;
    }

    public void setTafBuffer(byte[] bArr) {
        this._package.sBuffer = bArr;
    }

    public void setTafContext(Map<String, String> map) {
        this._package.context = map;
    }

    public void setTafMessageType(int i3) {
        this._package.iMessageType = i3;
    }

    public void setTafPacketType(byte b16) {
        this._package.cPacketType = b16;
    }

    public void setTafStatus(Map<String, String> map) {
        this._package.status = map;
    }

    public void setTafTimeout(int i3) {
        this._package.iTimeout = i3;
    }

    public void setTafVersion(short s16) {
        this._package.iVersion = s16;
        if (s16 == 3) {
            useVersion3();
        }
    }
}
