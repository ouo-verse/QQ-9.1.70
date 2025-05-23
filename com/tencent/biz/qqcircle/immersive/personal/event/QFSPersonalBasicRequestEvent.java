package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPersonalBasicRequestEvent extends SimpleBaseEvent {
    private String errMsg;
    private boolean isSuccess;
    private long retCode;
    private String uin;

    public QFSPersonalBasicRequestEvent(String str, boolean z16) {
        this(str, z16, null, 0L);
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getRetCode() {
        return this.retCode;
    }

    public String getUin() {
        return this.uin;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setRetCode(long j3) {
        this.retCode = j3;
    }

    public void setSuccess(boolean z16) {
        this.isSuccess = z16;
    }

    public void setUin(String str) {
        this.uin = str;
    }

    public QFSPersonalBasicRequestEvent(String str, String str2) {
        this(str, false, str2, 0L);
    }

    public QFSPersonalBasicRequestEvent(String str, String str2, long j3) {
        this(str, false, str2, j3);
    }

    public QFSPersonalBasicRequestEvent(String str, boolean z16, String str2, long j3) {
        this.uin = str;
        this.isSuccess = z16;
        this.errMsg = str2;
        this.retCode = j3;
    }
}
