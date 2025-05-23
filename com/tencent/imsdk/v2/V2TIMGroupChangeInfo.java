package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfoChangeItem;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupChangeInfo implements Serializable {
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_CUSTOM = 6;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_FACE_URL = 4;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_INTRODUCTION = 2;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_NAME = 1;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_NOTIFICATION = 3;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_OWNER = 5;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_SHUT_UP_ALL = 8;
    public static final int V2TIM_GROUP_INFO_INVALID = 0;
    private GroupInfoChangeItem groupInfoChangeItem = new GroupInfoChangeItem();

    public boolean getBoolValue() {
        return this.groupInfoChangeItem.getBoolValueChanged();
    }

    GroupInfoChangeItem getGroupInfoChangeItem() {
        return this.groupInfoChangeItem;
    }

    public String getKey() {
        return this.groupInfoChangeItem.getCustomInfoKey();
    }

    public int getType() {
        return this.groupInfoChangeItem.getGroupInfoChangeType();
    }

    public String getValue() {
        return this.groupInfoChangeItem.getValueChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupInfoChangeItem(GroupInfoChangeItem groupInfoChangeItem) {
        this.groupInfoChangeItem = groupInfoChangeItem;
    }
}
