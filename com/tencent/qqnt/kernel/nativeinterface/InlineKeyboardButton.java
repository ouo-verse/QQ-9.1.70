package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InlineKeyboardButton {
    public int anchor;
    public boolean atBotShowChannelList;
    public int clickLimit;
    public String data;
    public boolean enter;
    public FeedBackData feedBackData;
    public String groupId;
    public long hideSeconds;

    /* renamed from: id, reason: collision with root package name */
    public String f359191id;
    public boolean isReply;
    public String label;
    public InlineKetBoardModal modal;
    public int permissionType;
    public ArrayList<String> specifyRoleIds;
    public ArrayList<String> specifyTinyids;
    public int style;
    public ArrayList<SubscribeMsgTemplateID> subscribeDataTemplateIds;
    public int type;
    public String unsupportTips;
    public String visitedLabel;

    public InlineKeyboardButton() {
        this.f359191id = "";
        this.label = "";
        this.visitedLabel = "";
        this.unsupportTips = "";
        this.data = "";
        this.specifyRoleIds = new ArrayList<>();
        this.specifyTinyids = new ArrayList<>();
        this.groupId = "";
        this.subscribeDataTemplateIds = new ArrayList<>();
        this.feedBackData = new FeedBackData();
        this.modal = new InlineKetBoardModal();
    }

    public int getAnchor() {
        return this.anchor;
    }

    public boolean getAtBotShowChannelList() {
        return this.atBotShowChannelList;
    }

    public int getClickLimit() {
        return this.clickLimit;
    }

    public String getData() {
        return this.data;
    }

    public boolean getEnter() {
        return this.enter;
    }

    public FeedBackData getFeedBackData() {
        return this.feedBackData;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long getHideSeconds() {
        return this.hideSeconds;
    }

    public String getId() {
        return this.f359191id;
    }

    public boolean getIsReply() {
        return this.isReply;
    }

    public String getLabel() {
        return this.label;
    }

    public InlineKetBoardModal getModal() {
        return this.modal;
    }

    public int getPermissionType() {
        return this.permissionType;
    }

    public ArrayList<String> getSpecifyRoleIds() {
        return this.specifyRoleIds;
    }

    public ArrayList<String> getSpecifyTinyids() {
        return this.specifyTinyids;
    }

    public int getStyle() {
        return this.style;
    }

    public ArrayList<SubscribeMsgTemplateID> getSubscribeDataTemplateIds() {
        return this.subscribeDataTemplateIds;
    }

    public int getType() {
        return this.type;
    }

    public String getUnsupportTips() {
        return this.unsupportTips;
    }

    public String getVisitedLabel() {
        return this.visitedLabel;
    }

    public String toString() {
        return "InlineKeyboardButton{id=" + this.f359191id + ",label=" + this.label + ",visitedLabel=" + this.visitedLabel + ",style=" + this.style + ",type=" + this.type + ",clickLimit=" + this.clickLimit + ",unsupportTips=" + this.unsupportTips + ",data=" + this.data + ",atBotShowChannelList=" + this.atBotShowChannelList + ",permissionType=" + this.permissionType + ",specifyRoleIds=" + this.specifyRoleIds + ",specifyTinyids=" + this.specifyTinyids + ",isReply=" + this.isReply + ",anchor=" + this.anchor + ",enter=" + this.enter + ",groupId=" + this.groupId + ",subscribeDataTemplateIds=" + this.subscribeDataTemplateIds + ",feedBackData=" + this.feedBackData + ",modal=" + this.modal + ",hideSeconds=" + this.hideSeconds + ",}";
    }

    public InlineKeyboardButton(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, boolean z16, int i18, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z17, int i19, boolean z18, ArrayList<SubscribeMsgTemplateID> arrayList3, FeedBackData feedBackData) {
        this.f359191id = "";
        this.label = "";
        this.visitedLabel = "";
        this.unsupportTips = "";
        this.data = "";
        this.specifyRoleIds = new ArrayList<>();
        this.specifyTinyids = new ArrayList<>();
        this.groupId = "";
        this.subscribeDataTemplateIds = new ArrayList<>();
        this.feedBackData = new FeedBackData();
        this.modal = new InlineKetBoardModal();
        this.f359191id = str;
        this.label = str2;
        this.visitedLabel = str3;
        this.style = i3;
        this.type = i16;
        this.clickLimit = i17;
        this.unsupportTips = str4;
        this.data = str5;
        this.atBotShowChannelList = z16;
        this.permissionType = i18;
        this.specifyRoleIds = arrayList;
        this.specifyTinyids = arrayList2;
        this.isReply = z17;
        this.anchor = i19;
        this.enter = z18;
        this.subscribeDataTemplateIds = arrayList3;
        this.feedBackData = feedBackData;
    }
}
