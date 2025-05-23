package com.tencent.mobileqq.guild.feed.publish.event;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildDraftTaskResponseEvent extends GuildIPCCompatEvent {
    private s mContact;
    private String mFeedJson;
    private String mMainTaskId;
    private GuildGetDraftTaskOperationEvent mRequestEvent;

    public GuildDraftTaskResponseEvent(String str) {
        super("GuildDraftTaskResponseEvent" + str);
        this.mContact = GuildSimpleContact.INSTANCE.a();
    }

    private boolean b() {
        String str = this.mFeedJson;
        if (str != null && str.length() > 188184) {
            return true;
        }
        return false;
    }

    public static void saveInMMKVIfNeeded(@NonNull GuildDraftTaskResponseEvent guildDraftTaskResponseEvent) {
        GuildGetDraftTaskOperationEvent requestEvent = guildDraftTaskResponseEvent.getRequestEvent();
        if (requestEvent != null && requestEvent.isIpcEvent() && guildDraftTaskResponseEvent.b()) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildDraftTaskResponseEvent", 1, "[saveFeedJsonInMMKVFileIfNeeded]: store in mmkv, request= " + requestEvent);
            }
            guildDraftTaskResponseEvent.saveInFile();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent
    protected void afterSaveInFile() {
        this.mFeedJson = "";
    }

    public String getFeedJson() {
        return this.mFeedJson;
    }

    public s getGuildContact() {
        return this.mContact;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public GuildGetDraftTaskOperationEvent getRequestEvent() {
        return this.mRequestEvent;
    }

    public void setFeedJson(String str) {
        this.mFeedJson = str;
    }

    public void setGuildContact(s sVar) {
        this.mContact = sVar;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public void setRequestEvent(GuildGetDraftTaskOperationEvent guildGetDraftTaskOperationEvent) {
        this.mRequestEvent = guildGetDraftTaskOperationEvent;
    }

    @Override // com.tencent.mobileqq.guild.feed.event.bus.GuildIPCCompatEvent
    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GuildDraftTaskResponseEvent{ super: ");
        sb5.append(super.toString());
        sb5.append(" contact: ");
        sb5.append(this.mContact);
        sb5.append(" mMainTaskId='");
        sb5.append(this.mMainTaskId);
        sb5.append('\'');
        sb5.append(", feed.length =");
        String str = this.mFeedJson;
        if (str != null) {
            i3 = str.length();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(", mFeedJson='");
        sb5.append(this.mFeedJson);
        sb5.append('\'');
        sb5.append('}');
        return sb5.toString();
    }
}
