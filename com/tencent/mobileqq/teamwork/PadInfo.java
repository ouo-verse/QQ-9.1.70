package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.pb.teamwork.TimDocSSOMsg$UinRightInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes18.dex */
public class PadInfo extends Entity {
    public static final int TYPE_DOC = 1;
    public static final int TYPE_FORM = 3;
    public static final int TYPE_LIST_ALL = 4;
    public static final int TYPE_LIST_BROWSE = 2;
    public static final int TYPE_LIST_CREATE = 1;
    public static final int TYPE_LIST_SHARED = 3;
    public static final int TYPE_PDF = 5;
    public static final int TYPE_PIN_LIST_IN_LIST_ALL = 5;
    public static final int TYPE_PPT = 4;
    public static final int TYPE_SHEET = 2;
    public long createTime;
    public String creatorNick;
    public long creatorUin;
    public long currentUserBrowseTime;
    public long domainId;
    public boolean itemDeleteFlag;
    public long itemLateDeleteTime;
    public long lastEditTime;
    public String lastEditorNick;
    public long lastEditorUin;
    public long lastPinnedTime;
    public long lastPinnedTimeInAllList;
    public long lastUnPinnedTime;
    public long lastViewTime;
    public String lastViewerNick;
    public long lastViewerUin;
    public long lastshardTime;
    public String padId;

    @unique
    public String pad_url;
    public boolean pinInAllList;
    public boolean pinedFlag;
    public String shardNick;
    public long shardUin;
    public String thumbUrl;
    public String title;
    public int type;
    public int type_list;
    public int policy = 2;

    @notColumn
    private List<TimDocSSOMsg$UinRightInfo> mUins = new ArrayList();

    public void copyFrom(PadInfo padInfo) {
        this.domainId = padInfo.domainId;
        this.padId = padInfo.padId;
        this.lastUnPinnedTime = padInfo.lastUnPinnedTime;
        this.itemDeleteFlag = padInfo.itemDeleteFlag;
        this.itemLateDeleteTime = padInfo.itemLateDeleteTime;
        this.thumbUrl = padInfo.thumbUrl;
        this.pad_url = padInfo.pad_url;
        this.type_list = padInfo.type_list;
        this.type = padInfo.type;
        this.title = padInfo.title;
        this.createTime = padInfo.createTime;
        this.creatorUin = padInfo.creatorUin;
        this.creatorNick = padInfo.creatorNick;
        this.lastEditorUin = padInfo.lastEditorUin;
        this.lastEditorNick = padInfo.lastEditorNick;
        this.lastEditTime = padInfo.lastEditTime;
        this.pinedFlag = padInfo.pinedFlag;
        this.lastViewerUin = padInfo.lastViewerUin;
        this.lastViewerNick = padInfo.lastViewerNick;
        this.lastViewTime = padInfo.lastViewTime;
        this.lastPinnedTime = padInfo.lastPinnedTime;
        this.currentUserBrowseTime = padInfo.currentUserBrowseTime;
        this.shardUin = padInfo.shardUin;
        this.shardNick = padInfo.shardNick;
        this.lastshardTime = padInfo.lastshardTime;
        this.policy = padInfo.policy;
        this.mUins.addAll(padInfo.mUins);
    }

    public boolean equals(Object obj) {
        if (obj instanceof PadInfo) {
            String str = this.pad_url;
            if (str != null && str.equalsIgnoreCase(((PadInfo) obj).pad_url)) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public List<TimDocSSOMsg$UinRightInfo> getRightList() {
        return this.mUins;
    }

    public void setRightsList(List<TimDocSSOMsg$UinRightInfo> list) {
        this.mUins = list;
    }

    public String toString() {
        return " == padInfo == \ndomainId: " + this.domainId + ",padId: " + this.padId + ",lastUnPinnedTime: " + this.lastUnPinnedTime + ",itemDeleteFlag: " + this.itemDeleteFlag + ",itemLateDeleteTime: " + this.itemLateDeleteTime + ",thumbUrl: " + this.thumbUrl + ",pad_url: " + this.pad_url + ",type: " + this.type + ",title: " + this.title + ",createTime: " + this.createTime + ",creatorUin: " + this.creatorUin + ",creatorNick: " + this.creatorNick + ",lastEditorUin: " + this.lastEditorUin + ",lastEditorNick: " + this.lastEditorNick + ",lastEditTime: " + this.lastEditTime + ",pinedFlag: " + this.pinedFlag + ",policy: " + this.policy;
    }
}
