package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendSearchParam;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes7.dex */
public class V2TIMFriendSearchParam implements Serializable {
    private static final int SEARCH_FIELD_NICK_NAME = 2;
    private static final int SEARCH_FIELD_REMARK = 4;
    private static final int SEARCH_FIELD_USER_ID = 1;
    private FriendSearchParam friendSearchParam = new FriendSearchParam();

    /* JADX INFO: Access modifiers changed from: protected */
    public FriendSearchParam getFriendSearchParam() {
        return this.friendSearchParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> getKeywordList() {
        return this.friendSearchParam.getKeywordList();
    }

    public void setKeywordList(List<String> list) {
        this.friendSearchParam.setKeywordList(list);
    }

    public void setSearchNickName(boolean z16) {
        if (z16) {
            this.friendSearchParam.addSearchField(2);
        } else {
            this.friendSearchParam.removeSearchField(2);
        }
    }

    public void setSearchRemark(boolean z16) {
        if (z16) {
            this.friendSearchParam.addSearchField(4);
        } else {
            this.friendSearchParam.removeSearchField(4);
        }
    }

    public void setSearchUserID(boolean z16) {
        if (z16) {
            this.friendSearchParam.addSearchField(1);
        } else {
            this.friendSearchParam.removeSearchField(1);
        }
    }
}
