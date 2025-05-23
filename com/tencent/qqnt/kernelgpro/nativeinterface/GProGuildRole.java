package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRole {
    public ArrayList<Long> approveSpeakChannels;
    public ArrayList<Long> approveVisibleChannels;
    public boolean bHoist;
    public long backgroudColor1;
    public long backgroudColor2;
    public long color;
    public int count;
    public String displayTagName;
    public int displayType;
    public long guildId;
    public boolean isChannelRole;
    public boolean isNotSort;
    public String levelBigIcon;
    public String levelDsc;
    public String levelIcon;
    public String levelSimpleDsc;
    public long levelSimpleDscColor;
    public long levelSplitLineColor;
    public ArrayList<Long> manageCategoryIdList;
    public long manageTagPendingColor;
    public int memberLimit;
    public String name;
    public int nameplate;
    public long outlineColor;
    public long roleId;
    public GProRolePermission rolePermissions;
    public int speakableChannelsCount;
    public int type;
    public int visibleChannelsCount;

    public GProGuildRole() {
        this.name = "";
        this.approveSpeakChannels = new ArrayList<>();
        this.approveVisibleChannels = new ArrayList<>();
        this.rolePermissions = new GProRolePermission();
        this.levelIcon = "";
        this.levelDsc = "";
        this.levelBigIcon = "";
        this.levelSimpleDsc = "";
        this.displayTagName = "";
        this.manageCategoryIdList = new ArrayList<>();
    }

    public ArrayList<Long> getApproveSpeakChannels() {
        return this.approveSpeakChannels;
    }

    public ArrayList<Long> getApproveVisibleChannels() {
        return this.approveVisibleChannels;
    }

    public boolean getBHoist() {
        return this.bHoist;
    }

    public long getBackgroudColor1() {
        return this.backgroudColor1;
    }

    public long getBackgroudColor2() {
        return this.backgroudColor2;
    }

    public long getColor() {
        return this.color;
    }

    public int getCount() {
        return this.count;
    }

    public String getDisplayTagName() {
        return this.displayTagName;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsChannelRole() {
        return this.isChannelRole;
    }

    public boolean getIsNotSort() {
        return this.isNotSort;
    }

    public String getLevelBigIcon() {
        return this.levelBigIcon;
    }

    public String getLevelDsc() {
        return this.levelDsc;
    }

    public String getLevelIcon() {
        return this.levelIcon;
    }

    public String getLevelSimpleDsc() {
        return this.levelSimpleDsc;
    }

    public long getLevelSimpleDscColor() {
        return this.levelSimpleDscColor;
    }

    public long getLevelSplitLineColor() {
        return this.levelSplitLineColor;
    }

    public ArrayList<Long> getManageCategoryIdList() {
        return this.manageCategoryIdList;
    }

    public long getManageTagPendingColor() {
        return this.manageTagPendingColor;
    }

    public int getMemberLimit() {
        return this.memberLimit;
    }

    public String getName() {
        return this.name;
    }

    public int getNameplate() {
        return this.nameplate;
    }

    public long getOutlineColor() {
        return this.outlineColor;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public GProRolePermission getRolePermissions() {
        return this.rolePermissions;
    }

    public int getSpeakableChannelsCount() {
        return this.speakableChannelsCount;
    }

    public int getType() {
        return this.type;
    }

    public int getVisibleChannelsCount() {
        return this.visibleChannelsCount;
    }

    public String toString() {
        return "GProGuildRole{guildId=" + this.guildId + ",roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",bHoist=" + this.bHoist + ",count=" + this.count + ",isNotSort=" + this.isNotSort + ",memberLimit=" + this.memberLimit + ",nameplate=" + this.nameplate + ",approveSpeakChannels=" + this.approveSpeakChannels + ",approveVisibleChannels=" + this.approveVisibleChannels + ",speakableChannelsCount=" + this.speakableChannelsCount + ",visibleChannelsCount=" + this.visibleChannelsCount + ",rolePermissions=" + this.rolePermissions + ",isChannelRole=" + this.isChannelRole + ",levelIcon=" + this.levelIcon + ",levelDsc=" + this.levelDsc + ",type=" + this.type + ",levelBigIcon=" + this.levelBigIcon + ",backgroudColor1=" + this.backgroudColor1 + ",backgroudColor2=" + this.backgroudColor2 + ",outlineColor=" + this.outlineColor + ",levelSimpleDsc=" + this.levelSimpleDsc + ",levelSimpleDscColor=" + this.levelSimpleDscColor + ",levelSplitLineColor=" + this.levelSplitLineColor + ",displayType=" + this.displayType + ",manageTagPendingColor=" + this.manageTagPendingColor + ",displayTagName=" + this.displayTagName + ",manageCategoryIdList=" + this.manageCategoryIdList + ",}";
    }

    public GProGuildRole(long j3, long j16, String str, long j17, boolean z16, int i3, boolean z17, int i16, int i17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i18, int i19, GProRolePermission gProRolePermission, boolean z18, String str2, String str3, int i26, String str4, long j18, long j19, long j26, String str5, long j27, long j28, int i27, long j29, String str6, ArrayList<Long> arrayList3) {
        this.name = "";
        this.approveSpeakChannels = new ArrayList<>();
        this.approveVisibleChannels = new ArrayList<>();
        this.rolePermissions = new GProRolePermission();
        this.levelIcon = "";
        this.levelDsc = "";
        this.levelBigIcon = "";
        this.levelSimpleDsc = "";
        this.displayTagName = "";
        new ArrayList();
        this.guildId = j3;
        this.roleId = j16;
        this.name = str;
        this.color = j17;
        this.bHoist = z16;
        this.count = i3;
        this.isNotSort = z17;
        this.memberLimit = i16;
        this.nameplate = i17;
        this.approveSpeakChannels = arrayList;
        this.approveVisibleChannels = arrayList2;
        this.speakableChannelsCount = i18;
        this.visibleChannelsCount = i19;
        this.rolePermissions = gProRolePermission;
        this.isChannelRole = z18;
        this.levelIcon = str2;
        this.levelDsc = str3;
        this.type = i26;
        this.levelBigIcon = str4;
        this.backgroudColor1 = j18;
        this.backgroudColor2 = j19;
        this.outlineColor = j26;
        this.levelSimpleDsc = str5;
        this.levelSimpleDscColor = j27;
        this.levelSplitLineColor = j28;
        this.displayType = i27;
        this.manageTagPendingColor = j29;
        this.displayTagName = str6;
        this.manageCategoryIdList = arrayList3;
    }
}
