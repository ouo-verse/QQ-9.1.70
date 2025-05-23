package com.tencent.gamecenter.wadl.biz.entity;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f {
    public int flags;
    public int taskStatus;
    public String appId = "";
    public String pkgName = "";
    public String downloadFilePath = "";

    public String toString() {
        return "WadlBaseTask{appId='" + this.appId + "', pkgName='" + this.pkgName + "', taskStatus=" + this.taskStatus + ", downloadFilePath='" + this.downloadFilePath + "', flags=" + this.flags + '}';
    }
}
