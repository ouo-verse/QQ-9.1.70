package mqq.app;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* loaded from: classes28.dex */
public class Packet {
    private String account;
    public boolean autoResend;
    private UniPacket client;
    private boolean noResponse;
    private byte[] sendData;
    private String ssoCommand;
    private String traceInfo;
    private HashMap<String, String> transInfo;
    private long timeout = 30000;
    public boolean quickSendEnable = false;
    public int quickSendStrategy = 0;
    private HashMap<String, Object> attributes = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Packet(String str) {
        this.account = "0";
        UniPacket uniPacket = new UniPacket(true);
        this.client = uniPacket;
        uniPacket.setEncodeName("UTF-8");
        if (str != null) {
            this.account = str;
        }
    }

    public static <T> T decodePacket(byte[] bArr, String str, T t16) {
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.decode(bArr);
        return (T) uniPacket.getByClass(str, t16);
    }

    public Object addAttribute(String str, Object obj) {
        return this.attributes.put(str, obj);
    }

    public void addRequestPacket(String str, JceStruct jceStruct) {
        this.client.put(str, jceStruct);
    }

    public HashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getFuncName() {
        return this.client.getServantName();
    }

    public String getServantName() {
        return this.client.getServantName();
    }

    public void putSendData(byte[] bArr) {
        this.sendData = bArr;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAttributes(HashMap<String, Object> hashMap) {
        this.attributes = hashMap;
    }

    public void setFuncName(String str) {
        this.client.setFuncName(str);
    }

    public void setNoResponse() {
        this.noResponse = true;
    }

    public void setQuickSend(boolean z16, int i3) {
        this.quickSendEnable = z16;
        this.quickSendStrategy = i3;
    }

    public void setSSOCommand(String str) {
        this.ssoCommand = str;
    }

    public void setServantName(String str) {
        this.client.setServantName(str);
    }

    public void setTimeout(long j3) {
        this.timeout = j3;
    }

    public void setTraceInfo(String str) {
        this.traceInfo = str;
    }

    public void setTransInfo(HashMap<String, String> hashMap) {
        this.transInfo = hashMap;
    }

    public ToServiceMsg toMsg() {
        if (this.ssoCommand == null) {
            return null;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, this.account, this.ssoCommand);
        long j3 = this.timeout;
        if (j3 > 0) {
            toServiceMsg.setTimeout(j3);
        }
        if (this.noResponse) {
            toServiceMsg.setNeedCallback(false);
        }
        if (this.sendData == null) {
            this.sendData = this.client.encode();
        }
        toServiceMsg.putWupBuffer(this.sendData);
        toServiceMsg.setAttributes(this.attributes);
        toServiceMsg.setEnableFastResend(this.autoResend);
        toServiceMsg.setQuickSend(this.quickSendEnable, this.quickSendStrategy);
        if (!TextUtils.isEmpty(this.traceInfo)) {
            toServiceMsg.setTraceInfo(this.traceInfo);
        }
        HashMap<String, String> hashMap = this.transInfo;
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : this.transInfo.keySet()) {
                toServiceMsg.addTransInfo(str, this.transInfo.get(str).getBytes(StandardCharsets.UTF_8));
            }
        }
        return toServiceMsg;
    }
}
