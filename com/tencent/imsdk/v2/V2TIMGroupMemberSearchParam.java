package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberSearchParam;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes7.dex */
public class V2TIMGroupMemberSearchParam implements Serializable {
    private static final int SEARCH_FIELD_MEMBER_NAME_CARD = 8;
    private static final int SEARCH_FIELD_MEMBER_NICK_NAME = 2;
    private static final int SEARCH_FIELD_MEMBER_REMARK = 4;
    private static final int SEARCH_FIELD_MEMBER_USER_ID = 1;
    private GroupMemberSearchParam groupMemberSearchParam = new GroupMemberSearchParam();

    protected List<String> getGroupIDList() {
        return this.groupMemberSearchParam.getGroupIDList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GroupMemberSearchParam getGroupMemberSearchParam() {
        return this.groupMemberSearchParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> getKeywordList() {
        return this.groupMemberSearchParam.getKeywordList();
    }

    public void setGroupIDList(List<String> list) {
        this.groupMemberSearchParam.setGroupIDList(list);
    }

    public void setKeywordList(List<String> list) {
        this.groupMemberSearchParam.setKeywordList(list);
    }

    public void setSearchMemberNameCard(boolean z16) {
        if (z16) {
            this.groupMemberSearchParam.addSearchField(8);
        } else {
            this.groupMemberSearchParam.removeSearchField(8);
        }
    }

    public void setSearchMemberNickName(boolean z16) {
        if (z16) {
            this.groupMemberSearchParam.addSearchField(2);
        } else {
            this.groupMemberSearchParam.removeSearchField(2);
        }
    }

    public void setSearchMemberRemark(boolean z16) {
        if (z16) {
            this.groupMemberSearchParam.addSearchField(4);
        } else {
            this.groupMemberSearchParam.removeSearchField(4);
        }
    }

    public void setSearchMemberUserID(boolean z16) {
        if (z16) {
            this.groupMemberSearchParam.addSearchField(1);
        } else {
            this.groupMemberSearchParam.removeSearchField(1);
        }
    }
}
