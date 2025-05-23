package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class OperateDownloadTaskRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static IPCBaseParam cache_baseParam = new IPCBaseParam();
    static Map<String, Long> cache_timePoint = new HashMap();
    public String actionFlag;
    public IPCBaseParam baseParam;
    public String opList;
    public int requestType;
    public Map<String, Long> timePoint;
    public String verifyType;

    static {
        cache_timePoint.put("", 0L);
    }

    public OperateDownloadTaskRequest() {
        this.requestType = 0;
        this.baseParam = null;
        this.opList = "";
        this.actionFlag = "";
        this.verifyType = "";
        this.timePoint = null;
    }

    public String className() {
        return "jce.OperateDownloadTaskRequest";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.requestType, "requestType");
        jceDisplayer.display((JceStruct) this.baseParam, "baseParam");
        jceDisplayer.display(this.opList, "opList");
        jceDisplayer.display(this.actionFlag, "actionFlag");
        jceDisplayer.display(this.verifyType, "verifyType");
        jceDisplayer.display((Map) this.timePoint, "timePoint");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.requestType, true);
        jceDisplayer.displaySimple((JceStruct) this.baseParam, true);
        jceDisplayer.displaySimple(this.opList, true);
        jceDisplayer.displaySimple(this.actionFlag, true);
        jceDisplayer.displaySimple(this.verifyType, true);
        jceDisplayer.displaySimple((Map) this.timePoint, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        OperateDownloadTaskRequest operateDownloadTaskRequest = (OperateDownloadTaskRequest) obj;
        if (!JceUtil.equals(this.requestType, operateDownloadTaskRequest.requestType) || !JceUtil.equals(this.baseParam, operateDownloadTaskRequest.baseParam) || !JceUtil.equals(this.opList, operateDownloadTaskRequest.opList) || !JceUtil.equals(this.actionFlag, operateDownloadTaskRequest.actionFlag) || !JceUtil.equals(this.verifyType, operateDownloadTaskRequest.verifyType) || !JceUtil.equals(this.timePoint, operateDownloadTaskRequest.timePoint)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest";
    }

    public String getActionFlag() {
        return this.actionFlag;
    }

    public IPCBaseParam getBaseParam() {
        return this.baseParam;
    }

    public String getOpList() {
        return this.opList;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public Map<String, Long> getTimePoint() {
        return this.timePoint;
    }

    public String getVerifyType() {
        return this.verifyType;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.requestType = jceInputStream.read(this.requestType, 0, true);
        this.baseParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_baseParam, 1, true);
        this.opList = jceInputStream.readString(2, false);
        this.actionFlag = jceInputStream.readString(3, false);
        this.verifyType = jceInputStream.readString(4, false);
        this.timePoint = (Map) jceInputStream.read((JceInputStream) cache_timePoint, 5, false);
    }

    public void setActionFlag(String str) {
        this.actionFlag = str;
    }

    public void setBaseParam(IPCBaseParam iPCBaseParam) {
        this.baseParam = iPCBaseParam;
    }

    public void setOpList(String str) {
        this.opList = str;
    }

    public void setRequestType(int i3) {
        this.requestType = i3;
    }

    public void setTimePoint(Map<String, Long> map) {
        this.timePoint = map;
    }

    public void setVerifyType(String str) {
        this.verifyType = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestType, 0);
        jceOutputStream.write((JceStruct) this.baseParam, 1);
        String str = this.opList;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.actionFlag;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.verifyType;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        Map<String, Long> map = this.timePoint;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public OperateDownloadTaskRequest(int i3, IPCBaseParam iPCBaseParam, String str, String str2, String str3, Map<String, Long> map) {
        this.requestType = i3;
        this.baseParam = iPCBaseParam;
        this.opList = str;
        this.actionFlag = str2;
        this.verifyType = str3;
        this.timePoint = map;
    }
}
