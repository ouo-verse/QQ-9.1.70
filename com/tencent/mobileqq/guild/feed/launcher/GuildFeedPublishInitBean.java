package com.tencent.mobileqq.guild.feed.launcher;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* loaded from: classes13.dex */
public class GuildFeedPublishInitBean extends GuildFeedSchemeBean {

    @Nullable
    private GuildFeedPublishEditDraftInitBean draftBean;
    private String mExInfo;
    private String mNickName;
    private String mTinyId;

    @Nullable
    public GuildFeedPublishEditDraftInitBean getDraftBean() {
        return this.draftBean;
    }

    public String getExInfo() {
        return this.mExInfo;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public String getTinyId() {
        return this.mTinyId;
    }

    public boolean isEditDraft() {
        GuildFeedPublishEditDraftInitBean guildFeedPublishEditDraftInitBean = this.draftBean;
        if (guildFeedPublishEditDraftInitBean != null && !TextUtils.isEmpty(guildFeedPublishEditDraftInitBean.getTaskId()) && !TextUtils.isEmpty(this.draftBean.getFeedJson())) {
            return true;
        }
        return false;
    }

    public boolean isEditPublish() {
        if (!(this instanceof GuildFeedPublishEditPostInitBean)) {
            return false;
        }
        return !TextUtils.isEmpty(((GuildFeedPublishEditPostInitBean) this).getFeedId());
    }

    public boolean isSwitchFromNative() {
        return this instanceof GuildFeedPublishSwitchInitBean;
    }

    public boolean isThirdContentPublish() {
        return this instanceof GuildFeedPublishThirdContentInitBean;
    }

    public void setDraftBean(@Nullable GuildFeedPublishEditDraftInitBean guildFeedPublishEditDraftInitBean) {
        this.draftBean = guildFeedPublishEditDraftInitBean;
    }

    public void setExInfo(String str) {
        this.mExInfo = str;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public void setTinyId(String str) {
        this.mTinyId = str;
    }

    @Override // com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean
    public String toString() {
        return "GuildFeedPublishInitBean{mTinyId='" + this.mTinyId + "', mNickName='" + this.mNickName + "', mExInfo='" + this.mExInfo + "'} " + super.toString();
    }
}
