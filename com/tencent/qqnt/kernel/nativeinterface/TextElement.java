package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TextElement implements IKernelModel {
    public Long atChannelId;
    public String atNtUid;
    public Integer atRoleColor;
    public Long atRoleId;
    public String atRoleName;
    public long atTinyId;
    public int atType;
    public long atUid;
    public String content;
    public LinkInfo linkInfo;
    public Integer needNotify;
    public Integer subElementType;

    public TextElement() {
        this.content = "";
    }

    public Long getAtChannelId() {
        return this.atChannelId;
    }

    public String getAtNtUid() {
        return this.atNtUid;
    }

    public Integer getAtRoleColor() {
        return this.atRoleColor;
    }

    public Long getAtRoleId() {
        return this.atRoleId;
    }

    public String getAtRoleName() {
        return this.atRoleName;
    }

    public long getAtTinyId() {
        return this.atTinyId;
    }

    public int getAtType() {
        return this.atType;
    }

    public long getAtUid() {
        return this.atUid;
    }

    public String getContent() {
        return this.content;
    }

    public LinkInfo getLinkInfo() {
        return this.linkInfo;
    }

    public Integer getNeedNotify() {
        return this.needNotify;
    }

    public Integer getSubElementType() {
        return this.subElementType;
    }

    public void setAtChannelId(Long l3) {
        this.atChannelId = l3;
    }

    public void setAtNtUid(String str) {
        this.atNtUid = str;
    }

    public void setAtRoleColor(Integer num) {
        this.atRoleColor = num;
    }

    public void setAtRoleId(Long l3) {
        this.atRoleId = l3;
    }

    public void setAtRoleName(String str) {
        this.atRoleName = str;
    }

    public void setAtTinyId(long j3) {
        this.atTinyId = j3;
    }

    public void setAtType(int i3) {
        this.atType = i3;
    }

    public void setAtUid(long j3) {
        this.atUid = j3;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLinkInfo(LinkInfo linkInfo) {
        this.linkInfo = linkInfo;
    }

    public void setNeedNotify(Integer num) {
        this.needNotify = num;
    }

    public void setSubElementType(Integer num) {
        this.subElementType = num;
    }

    public String toString() {
        return "TextElement{content=" + this.content + ",atType=" + this.atType + ",atUid=" + this.atUid + ",atTinyId=" + this.atTinyId + ",atNtUid=" + this.atNtUid + ",subElementType=" + this.subElementType + ",atChannelId=" + this.atChannelId + ",linkInfo=" + this.linkInfo + ",atRoleId=" + this.atRoleId + ",atRoleColor=" + this.atRoleColor + ",atRoleName=" + this.atRoleName + ",needNotify=" + this.needNotify + ",}";
    }

    public TextElement(String str, int i3, long j3, long j16, String str2, Integer num, Long l3, LinkInfo linkInfo, Long l16, Integer num2, String str3, Integer num3) {
        this.content = str;
        this.atType = i3;
        this.atUid = j3;
        this.atTinyId = j16;
        this.atNtUid = str2;
        this.subElementType = num;
        this.atChannelId = l3;
        this.linkInfo = linkInfo;
        this.atRoleId = l16;
        this.atRoleColor = num2;
        this.atRoleName = str3;
        this.needNotify = num3;
    }
}
