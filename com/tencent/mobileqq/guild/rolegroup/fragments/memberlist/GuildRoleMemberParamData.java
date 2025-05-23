package com.tencent.mobileqq.guild.rolegroup.fragments.memberlist;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes14.dex */
public class GuildRoleMemberParamData implements Serializable {
    public static final int CHANNEL_VISIBLE_SELECT_REQUEST_CODE_CREATE = 2005;
    public static final int DEFAULT_ROLE_GROUP_MEMBER_LIMIT = 1000;
    public static final int DELETE = 2;
    public static final int FETCH_CATEGORY_ADMIN_LIST = 4;
    public static final int FETCH_CATEGORY_NOT_ADMIN_LIST = 7;
    public static final int FETCH_CHANNEL_ACTIVE_MEMBER_LIST = 15;
    public static final int FETCH_CHANNEL_ADMIN_MEMBER_LIST = 3;
    public static final int FETCH_CHANNEL_INACTIVE_MEMBER_LIST = 16;
    public static final int FETCH_CHANNEL_INVISIBLE_MEMBER_LIST = 10;
    public static final int FETCH_CHANNEL_LIVE_MEMBER_LIST = 13;
    public static final int FETCH_CHANNEL_NOT_ADMIN_MEMBER_LIST = 6;
    public static final int FETCH_CHANNEL_NO_LIVE_MEMBER_LIST = 14;
    public static final int FETCH_CHANNEL_SPEAKABLE_MEMBER_LIST = 11;
    public static final int FETCH_CHANNEL_UNSPEAKABLE_MEMBER_LIST = 12;
    public static final int FETCH_CHANNEL_VISIBLE_MEMBER_LIST = 9;
    public static final int FETCH_CHANNEL_VISIBLE_MEMBER_LIST_WITH_ROLE = 8;
    public static final int FETCH_FULL_MEMBER_LIST = 1;
    public static final int FETCH_GUILD_AUDIO_LIVE_CHANNEL_USER_LIST = 17;
    public static final int FETCH_GUILD_SPEAKABLE_MEMBER_LIST = 21;
    public static final int FETCH_GUILD_UNSPEAKABLE_MEMBER_LIST = 22;
    public static final int FETCH_LOCAL_CACHE = 0;
    public static final int FETCH_NON_ROLE_MEMBER_LIST = 5;
    public static final int FETCH_ROLE_MEMBER_LIST = 2;
    public static final int FETCH_SPEAK_RULE_LIMITED_MEMBER_LIST = 20;
    public static final int FETCH_SPEAK_RULE_UNLIMITED_MEMBER_LIST = 19;
    public static final int LEVEL_ROLE = 8;
    public static final int LOCAL_CACHE_DELETE = 5;
    public static final int MUL_ADD = 1;
    public static final int MUL_SELECT = 0;
    public static final int NORMAL_ROLE_MANAGE = 6;
    public static final int PAGE_SLIDE_TYPE_BOTTOM_TOP = 1;
    public static final int PAGE_SLIDE_TYPE_LEFT_RIGHT = 2;
    public static final int ROLE_GROUP_SELECT_REQUEST_CODE_CREATE = 2000;
    public static final int ROLE_GROUP_SELECT_REQUEST_CODE_INVALID = 0;
    public static final int ROLE_GROUP_SELECT_REQUEST_CODE_LOCAL_CACHE_DELETE = 2004;
    public static final int ROLE_GROUP_SELECT_REQUEST_CODE_MODIFY_ADD = 2002;
    public static final int ROLE_GROUP_SELECT_REQUEST_CODE_MODIFY_DEL = 2001;
    public static final int ROLE_GROUP_SELECT_REQUEST_CODE_VIEW_ONLY = 2003;
    public static final int SINGLE_SELECT = 7;
    public static final int VIEW_ONLY = 3;
    private final int mFetchType;
    private final String mGuildId;
    private final int mLayoutType;
    private final String mMainTitleStr;
    private String mNextAddPageTitle;
    private String mSubTitleStr = "";
    private int mMaxCountCanSelect = 1000;
    private int mActivityRequestCode = 0;
    private String mGuildCreatorId = "";
    private String mCategoryId = "";
    private String mSubChannelId = "";
    private String mRoleGroupId = "";
    private List<String> mLocalMemberList = new ArrayList();
    private List<String> mSelectedIdList = new ArrayList();
    private List<RoleGroupUserUIData> mSelectedUIList = new ArrayList();
    private final List<String> mExcludeList = new ArrayList();
    private int mOpenPageSlideType = 1;

    public GuildRoleMemberParamData(String str, String str2, int i3, int i16) {
        this.mGuildId = str;
        this.mMainTitleStr = str2;
        this.mLayoutType = i3;
        this.mFetchType = i16;
    }

    public int getActivityRequestCode() {
        return this.mActivityRequestCode;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public List<String> getExcludeList() {
        return this.mExcludeList;
    }

    public int getFetchType() {
        return this.mFetchType;
    }

    public String getGuildCreatorId() {
        return this.mGuildCreatorId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    public int getLayoutType() {
        return this.mLayoutType;
    }

    public List<String> getLocalMemberList() {
        return this.mLocalMemberList;
    }

    public String getMainTitleStr() {
        return this.mMainTitleStr;
    }

    public int getMaxCountCanSelect() {
        return this.mMaxCountCanSelect;
    }

    public String getNextAddPageTitle() {
        return this.mNextAddPageTitle;
    }

    public int getOpenPageSlideType() {
        return this.mOpenPageSlideType;
    }

    public String getRoleGroupId() {
        return this.mRoleGroupId;
    }

    public List<String> getSelectedIdList() {
        return this.mSelectedIdList;
    }

    public List<RoleGroupUserUIData> getSelectedUIList() {
        return this.mSelectedUIList;
    }

    public String getSubChannelId() {
        return this.mSubChannelId;
    }

    public String getSubTitleStr() {
        return this.mSubTitleStr;
    }

    public boolean judgeParamIllegal() {
        if (TextUtils.isEmpty(this.mGuildId)) {
            return false;
        }
        return true;
    }

    public GuildRoleMemberParamData setActivityRequestCode(int i3) {
        this.mActivityRequestCode = i3;
        return this;
    }

    public GuildRoleMemberParamData setCategoryId(String str) {
        this.mCategoryId = str;
        return this;
    }

    public GuildRoleMemberParamData setExcludeList(List<String> list) {
        this.mExcludeList.addAll(list);
        return this;
    }

    public GuildRoleMemberParamData setGuildCreatorId(String str) {
        this.mGuildCreatorId = str;
        return this;
    }

    public GuildRoleMemberParamData setLocalMemberList(@NonNull List<String> list) {
        this.mLocalMemberList = list;
        return this;
    }

    public GuildRoleMemberParamData setMaxCountCanSelect(int i3) {
        this.mMaxCountCanSelect = i3;
        return this;
    }

    public GuildRoleMemberParamData setNextAddPageTitle(String str) {
        this.mNextAddPageTitle = str;
        return this;
    }

    public GuildRoleMemberParamData setOpenPageSlideType(int i3) {
        this.mOpenPageSlideType = i3;
        return this;
    }

    public GuildRoleMemberParamData setRoleGroupId(String str) {
        this.mRoleGroupId = str;
        return this;
    }

    public GuildRoleMemberParamData setSelectedIdList(@NonNull List<String> list) {
        this.mSelectedIdList = list;
        return this;
    }

    public GuildRoleMemberParamData setSelectedUIList(@NonNull List<RoleGroupUserUIData> list) {
        this.mSelectedUIList = list;
        return this;
    }

    public GuildRoleMemberParamData setSubChannelId(String str) {
        this.mSubChannelId = str;
        return this;
    }

    public GuildRoleMemberParamData setSubTitleStr(String str) {
        this.mSubTitleStr = str;
        return this;
    }

    public String toString() {
        return "GuildRoleMemberParamData{mGuildId='" + this.mGuildId + ", mTitleBarStr='" + this.mMainTitleStr + ", mLayoutType=" + this.mLayoutType + ", mFetchType=" + this.mFetchType + ", mMaxCountCanSelect=" + this.mMaxCountCanSelect + ", mActivityRequestCode=" + this.mActivityRequestCode + ", mGuildCreatorId='" + this.mGuildCreatorId + ", mCategoryId='" + this.mCategoryId + ", mSubChannelId='" + this.mSubChannelId + ", mRoleGroupId='" + this.mRoleGroupId + ", mLocalMemberList=" + this.mLocalMemberList.size() + ", mSelectedIdList=" + this.mSelectedIdList.size() + ", mSelectedUIList=" + this.mSelectedUIList.size() + ", mExcludeList=" + this.mExcludeList.size() + ", mOpenPageSlideType=" + this.mOpenPageSlideType + ", mNextAddPageTitle='" + this.mNextAddPageTitle + '}';
    }

    public GuildRoleMemberParamData setSelectedIdList(@NonNull String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.mSelectedIdList = Arrays.asList(strArr);
        }
        return this;
    }

    public GuildRoleMemberParamData setSelectedUIList(@NonNull Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            this.mSelectedUIList = Arrays.asList((RoleGroupUserUIData[]) objArr);
        }
        return this;
    }
}
