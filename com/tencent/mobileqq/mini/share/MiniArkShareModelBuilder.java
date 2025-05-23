package com.tencent.mobileqq.mini.share;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniArkShareModelBuilder {
    private String appId;
    private String appidRich;
    private String description;
    private EntryModel entryModel;
    private COMM.StCommonExt extInfo;
    private int guildSuccessAction;
    private String iconUrl;
    private String jumpUrl;
    private int miniAppShareFrom;
    private String picUrl;
    private String rcvOpenId;
    private int requestCode = -1;
    private int shareBusinessType;
    private ShareChatModel shareChatModel;
    private int shareOrigin;
    private int shareScene;
    private int shareTarget;
    private int shareTemplateType;
    private String templateData;
    private String templateId;
    private String title;
    private String versionId;
    private int versionType;
    private String vidUrl;
    private String webURL;
    private boolean withShareTicket;

    public MiniArkShareModel createMiniArkShareModel() {
        return new MiniArkShareModel(this.appId, this.title, this.description, this.shareScene, this.shareTemplateType, this.shareBusinessType, this.picUrl, this.vidUrl, this.jumpUrl, this.iconUrl, this.versionType, this.versionId, this.webURL, this.appidRich, this.templateId, this.templateData, this.entryModel, this.shareChatModel, this.shareTarget, this.rcvOpenId, this.withShareTicket, this.miniAppShareFrom, this.extInfo, this.shareOrigin, this.guildSuccessAction, this.requestCode);
    }

    public MiniArkShareModelBuilder setAppId(String str) {
        this.appId = str;
        return this;
    }

    public MiniArkShareModelBuilder setAppidRich(String str) {
        this.appidRich = str;
        return this;
    }

    public MiniArkShareModelBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    public MiniArkShareModelBuilder setEntryModel(EntryModel entryModel) {
        this.entryModel = entryModel;
        return this;
    }

    public MiniArkShareModelBuilder setExtInfo(COMM.StCommonExt stCommonExt) {
        this.extInfo = stCommonExt;
        return this;
    }

    public MiniArkShareModelBuilder setGuildSuccessAction(int i3) {
        this.guildSuccessAction = i3;
        return this;
    }

    public MiniArkShareModelBuilder setIconUrl(String str) {
        this.iconUrl = str;
        return this;
    }

    public MiniArkShareModelBuilder setJumpUrl(String str) {
        this.jumpUrl = str;
        return this;
    }

    public MiniArkShareModelBuilder setMiniAppShareFrom(int i3) {
        this.miniAppShareFrom = i3;
        return this;
    }

    public MiniArkShareModelBuilder setPicUrl(String str) {
        this.picUrl = str;
        return this;
    }

    public MiniArkShareModelBuilder setRcvOpenId(String str) {
        this.rcvOpenId = str;
        return this;
    }

    public MiniArkShareModelBuilder setShareBusinessType(int i3) {
        this.shareBusinessType = i3;
        return this;
    }

    public MiniArkShareModelBuilder setShareChatModel(ShareChatModel shareChatModel) {
        this.shareChatModel = shareChatModel;
        return this;
    }

    public MiniArkShareModelBuilder setShareOrigin(int i3) {
        this.shareOrigin = i3;
        return this;
    }

    public MiniArkShareModelBuilder setShareRequestCode(int i3) {
        this.requestCode = i3;
        return this;
    }

    public MiniArkShareModelBuilder setShareScene(int i3) {
        this.shareScene = i3;
        return this;
    }

    public MiniArkShareModelBuilder setShareTarget(int i3) {
        this.shareTarget = i3;
        return this;
    }

    public MiniArkShareModelBuilder setShareTemplateType(int i3) {
        this.shareTemplateType = i3;
        return this;
    }

    public MiniArkShareModelBuilder setTemplateData(String str) {
        this.templateData = str;
        return this;
    }

    public MiniArkShareModelBuilder setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public MiniArkShareModelBuilder setTitle(String str) {
        this.title = str;
        return this;
    }

    public MiniArkShareModelBuilder setVersionId(String str) {
        this.versionId = str;
        return this;
    }

    public MiniArkShareModelBuilder setVersionType(int i3) {
        this.versionType = i3;
        return this;
    }

    public MiniArkShareModelBuilder setVidUrl(String str) {
        this.vidUrl = str;
        return this;
    }

    public MiniArkShareModelBuilder setWebURL(String str) {
        this.webURL = str;
        return this;
    }

    public MiniArkShareModelBuilder setWithShareTicket(boolean z16) {
        this.withShareTicket = z16;
        return this;
    }
}
