package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProNotice {
    public int createTs;
    public int expireTs;
    public long guildId;
    public int handleTs;
    public long handlerTinyId;
    public long handlerUin;
    public int msgType;
    public int noticeType;
    public int templateId;
    public String noticeId = "";
    public ArrayList<GProNoticeText> title = new ArrayList<>();
    public ArrayList<GProNoticeText> subTitle = new ArrayList<>();
    public ArrayList<GProNoticeText> comment = new ArrayList<>();
    public GProNoticeCover cover = new GProNoticeCover();
    public ArrayList<GProNoticeAction> actionList = new ArrayList<>();
    public String joinSign = "";
    public ArrayList<GProNoticeJump> jumpLink = new ArrayList<>();
    public String handleResult = "";
    public String handlerNickName = "";
    public ArrayList<GProNoticeJumpButton> jumpButtons = new ArrayList<>();

    public ArrayList<GProNoticeAction> getActionList() {
        return this.actionList;
    }

    public ArrayList<GProNoticeText> getComment() {
        return this.comment;
    }

    public GProNoticeCover getCover() {
        return this.cover;
    }

    public int getCreateTs() {
        return this.createTs;
    }

    public int getExpireTs() {
        return this.expireTs;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getHandleResult() {
        return this.handleResult;
    }

    public int getHandleTs() {
        return this.handleTs;
    }

    public String getHandlerNickName() {
        return this.handlerNickName;
    }

    public long getHandlerTinyId() {
        return this.handlerTinyId;
    }

    public long getHandlerUin() {
        return this.handlerUin;
    }

    public String getJoinSign() {
        return this.joinSign;
    }

    public ArrayList<GProNoticeJumpButton> getJumpButtons() {
        return this.jumpButtons;
    }

    public ArrayList<GProNoticeJump> getJumpLink() {
        return this.jumpLink;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getNoticeId() {
        return this.noticeId;
    }

    public int getNoticeType() {
        return this.noticeType;
    }

    public ArrayList<GProNoticeText> getSubTitle() {
        return this.subTitle;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public ArrayList<GProNoticeText> getTitle() {
        return this.title;
    }

    public void setActionList(ArrayList<GProNoticeAction> arrayList) {
        this.actionList = arrayList;
    }

    public void setComment(ArrayList<GProNoticeText> arrayList) {
        this.comment = arrayList;
    }

    public void setCover(GProNoticeCover gProNoticeCover) {
        this.cover = gProNoticeCover;
    }

    public void setCreateTs(int i3) {
        this.createTs = i3;
    }

    public void setExpireTs(int i3) {
        this.expireTs = i3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setHandleResult(String str) {
        this.handleResult = str;
    }

    public void setHandleTs(int i3) {
        this.handleTs = i3;
    }

    public void setHandlerNickName(String str) {
        this.handlerNickName = str;
    }

    public void setHandlerTinyId(long j3) {
        this.handlerTinyId = j3;
    }

    public void setHandlerUin(long j3) {
        this.handlerUin = j3;
    }

    public void setJoinSign(String str) {
        this.joinSign = str;
    }

    public void setJumpButtons(ArrayList<GProNoticeJumpButton> arrayList) {
        this.jumpButtons = arrayList;
    }

    public void setJumpLink(ArrayList<GProNoticeJump> arrayList) {
        this.jumpLink = arrayList;
    }

    public void setMsgType(int i3) {
        this.msgType = i3;
    }

    public void setNoticeId(String str) {
        this.noticeId = str;
    }

    public void setNoticeType(int i3) {
        this.noticeType = i3;
    }

    public void setSubTitle(ArrayList<GProNoticeText> arrayList) {
        this.subTitle = arrayList;
    }

    public void setTemplateId(int i3) {
        this.templateId = i3;
    }

    public void setTitle(ArrayList<GProNoticeText> arrayList) {
        this.title = arrayList;
    }

    public String toString() {
        return "GProNotice{noticeId=" + this.noticeId + ",templateId=" + this.templateId + ",createTs=" + this.createTs + ",expireTs=" + this.expireTs + ",handleTs=" + this.handleTs + ",guildId=" + this.guildId + ",title=" + this.title + ",subTitle=" + this.subTitle + ",comment=" + this.comment + ",cover=" + this.cover + ",actionList=" + this.actionList + ",joinSign=" + this.joinSign + ",msgType=" + this.msgType + ",jumpLink=" + this.jumpLink + ",noticeType=" + this.noticeType + ",handlerUin=" + this.handlerUin + ",handleResult=" + this.handleResult + ",handlerTinyId=" + this.handlerTinyId + ",handlerNickName=" + this.handlerNickName + ",jumpButtons=" + this.jumpButtons + ",}";
    }
}
