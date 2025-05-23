package com.tencent.mobileqq.mini.share;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniArkShareModel implements Serializable {
    private static final long serialVersionUID = 1;
    private final String appId;
    private final String appidRich;
    private final String description;
    private final EntryModel entryModel;
    private final COMM.StCommonExt extInfo;
    private int guildSuccessAction;
    private final String iconUrl;
    private final String jumpUrl;
    private final int miniAppShareFrom;
    private String picUrl;
    private String pkgName = "";
    private final String rcvOpenId;
    private final int shareBusinessType;
    private final ShareChatModel shareChatModel;
    private final int shareOrigin;
    private int shareRequestCode;
    private final int shareScene;
    private final int shareTarget;
    private final int shareTemplateType;
    private final String templateData;
    private final String templateId;
    private final String title;
    private final String versionId;
    private final int versionType;
    private final String vidUrl;
    private final String webURL;
    private final boolean withShareTicket;

    public MiniArkShareModel(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7, int i18, String str8, String str9, String str10, String str11, String str12, EntryModel entryModel, ShareChatModel shareChatModel, int i19, String str13, boolean z16, int i26, COMM.StCommonExt stCommonExt, int i27, int i28, int i29) {
        this.appId = str;
        this.title = str2;
        this.description = str3;
        this.shareScene = i3;
        this.shareTemplateType = i16;
        this.shareBusinessType = i17;
        this.picUrl = str4;
        this.vidUrl = str5;
        this.jumpUrl = str6;
        this.iconUrl = str7;
        this.versionType = i18;
        this.versionId = str8;
        this.webURL = str9;
        this.appidRich = str10;
        this.entryModel = entryModel;
        this.shareChatModel = shareChatModel;
        this.templateId = str11;
        this.templateData = str12;
        this.shareTarget = i19;
        this.rcvOpenId = str13;
        this.withShareTicket = z16;
        this.miniAppShareFrom = i26;
        this.extInfo = stCommonExt;
        this.shareOrigin = i27;
        this.guildSuccessAction = i28;
        this.shareRequestCode = i29;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppidRich() {
        return this.appidRich;
    }

    public String getDescription() {
        return this.description;
    }

    public EntryModel getEntryModel() {
        return this.entryModel;
    }

    public COMM.StCommonExt getExtInfo() {
        return this.extInfo;
    }

    public int getGuildSuccessAction() {
        return this.guildSuccessAction;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getMiniAppShareFrom() {
        return this.miniAppShareFrom;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getRcvOpenId() {
        return this.rcvOpenId;
    }

    public int getShareBusinessType() {
        return this.shareBusinessType;
    }

    public ShareChatModel getShareChatModel() {
        return this.shareChatModel;
    }

    public int getShareOrigin() {
        return this.shareOrigin;
    }

    public int getShareRequestCode() {
        return this.shareRequestCode;
    }

    public int getShareScene() {
        return this.shareScene;
    }

    public int getShareTarget() {
        return this.shareTarget;
    }

    public int getShareTemplateType() {
        return this.shareTemplateType;
    }

    public String getTemplateData() {
        return this.templateData;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public int getVersionType() {
        return this.versionType;
    }

    public String getVidUrl() {
        return this.vidUrl;
    }

    public String getWebURL() {
        return this.webURL;
    }

    public boolean isWithShareTicket() {
        return this.withShareTicket;
    }

    public void setGuildSuccessAction(int i3) {
        this.guildSuccessAction = i3;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }
}
