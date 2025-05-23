package com.tencent.qqmini.sdk.launcher.model;

import NS_COMM.COMM;
import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InnerShareData extends ShareData {
    public static final int SUB_SCENE_ARK_INVITE_API = 4023;
    public int callbackId;
    public EntryModel entryModel;
    public String entryPath;
    public String event;
    public COMM.StCommonExt extInfo;
    public Activity fromActivity;
    public JSONObject jsonObject;
    public String recvOpenId;
    public ShareChatModel shareChatModel;
    public int shareScene;
    public int subScene;
    public String templateData;
    public String templateId;
    public String webURL;
    public boolean withShareTicket;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        private InnerShareData shareData = new InnerShareData();

        public InnerShareData build() {
            return this.shareData;
        }

        public Builder setCallbackId(int i3) {
            this.shareData.callbackId = i3;
            return this;
        }

        public Builder setEntryModel(EntryModel entryModel) {
            this.shareData.entryModel = entryModel;
            return this;
        }

        public Builder setEntryPath(String str) {
            QMLog.i("delan", "entryPath\uff1a" + str);
            this.shareData.entryPath = str;
            return this;
        }

        public Builder setEvent(String str) {
            this.shareData.event = str;
            return this;
        }

        public Builder setExtInfo(COMM.StCommonExt stCommonExt) {
            this.shareData.extInfo = stCommonExt;
            return this;
        }

        public Builder setFromActivity(Activity activity) {
            this.shareData.fromActivity = activity;
            return this;
        }

        public Builder setIsLocalPic(boolean z16) {
            this.shareData.isLocalPic = z16;
            return this;
        }

        public Builder setMiniAppInfo(MiniAppInfo miniAppInfo) {
            this.shareData.miniAppInfo = miniAppInfo;
            return this;
        }

        public Builder setRecvOpenId(String str) {
            this.shareData.recvOpenId = str;
            return this;
        }

        public Builder setShareChatModel(ShareChatModel shareChatModel) {
            this.shareData.shareChatModel = shareChatModel;
            return this;
        }

        public Builder setShareInMiniProcess(boolean z16) {
            this.shareData.shareInMiniProcess = z16;
            return this;
        }

        public Builder setShareItemId(int i3) {
            this.shareData.shareItemId = i3;
            return this;
        }

        public Builder setShareOrigin(int i3) {
            this.shareData.shareOrigin = i3;
            return this;
        }

        public Builder setSharePicPath(String str) {
            this.shareData.sharePicPath = str;
            return this;
        }

        public Builder setShareScene(int i3) {
            this.shareData.shareScene = i3;
            return this;
        }

        public Builder setShareSource(int i3) {
            this.shareData.shareSource = i3;
            return this;
        }

        public Builder setShareTarget(int i3) {
            this.shareData.shareTarget = i3;
            switch (i3) {
                case 0:
                case 2:
                case 5:
                case 6:
                    setShareItemId(1);
                    break;
                case 1:
                    setShareItemId(2);
                    break;
                case 3:
                    setShareItemId(3);
                    break;
                case 4:
                    setShareItemId(4);
                    break;
            }
            if (MoreItem.isValidExtendedItemId(i3)) {
                setShareItemId(i3);
            }
            return this;
        }

        public Builder setSubScene(int i3) {
            this.shareData.subScene = i3;
            return this;
        }

        public Builder setSummary(String str) {
            this.shareData.summary = str;
            return this;
        }

        public Builder setTargetUrl(String str) {
            this.shareData.targetUrl = str;
            return this;
        }

        public Builder setTemplateData(String str) {
            this.shareData.templateData = str;
            return this;
        }

        public Builder setTemplateId(String str) {
            this.shareData.templateId = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.shareData.title = str;
            return this;
        }

        public Builder setWebUrl(String str) {
            this.shareData.webURL = str;
            return this;
        }

        public Builder setWithShareTicket(boolean z16) {
            this.shareData.withShareTicket = z16;
            return this;
        }
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.miniAppInfo;
    }

    public int getShareType() {
        switch (this.shareTarget) {
            case 0:
            case 2:
            case 5:
            case 6:
                return 0;
            case 1:
                return 1;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 6;
        }
    }

    public void shareAppMessage() {
        AppLoaderFactory.g().getMiniAppEnv().getShareManager().shareAppMessage(this);
    }

    public void shareAppPictureMessage(IMiniAppContext iMiniAppContext) {
        AppLoaderFactory.g().getMiniAppEnv().getShareManager().shareAppPictureMessage(iMiniAppContext, this);
    }

    public String toString() {
        return "InnerShareData{fromActivity=" + this.fromActivity + ", entryPath='" + this.entryPath + "', webURL='" + this.webURL + "', templateId='" + this.templateId + "', templateData='" + this.templateData + "', entryModel=" + this.entryModel + ", shareChatModel=" + this.shareChatModel + ", withShareTicket=" + this.withShareTicket + ", recvOpenId='" + this.recvOpenId + "', event='" + this.event + "', callbackId=" + this.callbackId + ", jsonObject=" + this.jsonObject + '}';
    }

    InnerShareData() {
        this.shareScene = 1;
    }
}
