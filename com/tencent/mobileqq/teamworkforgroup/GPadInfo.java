package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg$UinRightInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes18.dex */
public class GPadInfo extends PadInfo implements h {
    public String creatorCard;
    public long creatorUid;
    public long groupCode;
    public String lastModifyCard;
    public long lastModifyUid;

    @notColumn
    public boolean mSelectable;

    @notColumn
    public List<TimDocSSOMsg$UinRightInfo> mUins;
    public String ownerCard;
    public long ownerUin;
    public long owneruid;

    @notColumn
    public List<String> searchKeyWordList = new ArrayList();

    @notColumn
    public boolean mClickable = true;

    @Override // com.tencent.mobileqq.teamwork.PadInfo
    public void copyFrom(PadInfo padInfo) {
        GPadInfo gPadInfo = (GPadInfo) padInfo;
        super.copyFrom(gPadInfo);
        this.groupCode = gPadInfo.groupCode;
        this.creatorCard = gPadInfo.creatorCard;
        this.ownerUin = gPadInfo.ownerUin;
        this.ownerCard = gPadInfo.ownerCard;
        this.lastModifyCard = gPadInfo.lastModifyCard;
        this.owneruid = gPadInfo.owneruid;
        this.lastModifyUid = gPadInfo.lastModifyUid;
        this.creatorUid = gPadInfo.creatorUid;
        this.searchKeyWordList.addAll(gPadInfo.searchKeyWordList);
    }

    @Override // com.tencent.mobileqq.teamworkforgroup.h
    public int getCloudFileType() {
        return 2;
    }

    @Override // com.tencent.mobileqq.teamworkforgroup.h
    public boolean isClickable() {
        return this.mClickable;
    }

    @Override // com.tencent.mobileqq.teamwork.PadInfo
    public String toString() {
        return " == padInfo == \ndomainId: " + this.domainId + ",padId: " + this.padId + ",lastUnPinnedTime: " + this.lastUnPinnedTime + ",itemDeleteFlag: " + this.itemDeleteFlag + ",itemLateDeleteTime: " + this.itemLateDeleteTime + ",thumbUrl: " + this.thumbUrl + ",pad_url: " + this.pad_url + ",type: " + this.type + ",title: " + this.title + ",createTime: " + this.createTime + ",creatorUin: " + this.creatorUin + ",creatorNick: " + this.creatorNick + ",lastEditorUin: " + this.lastEditorUin + ",lastEditorNick: " + this.lastEditorNick + ",lastEditTime: " + this.lastEditTime + ",pinedFlag: " + this.pinedFlag + ",policy: " + this.policy + ",group code: " + this.groupCode + ",creator card: " + this.creatorCard + ",owner uin: " + this.ownerUin + ", owner card " + this.ownerCard + ", lastModifyCard: " + this.lastModifyCard + ", creator uid: " + this.creatorUid + " , last modify uid: " + this.lastModifyUid + ", owner uid" + this.owneruid;
    }
}
