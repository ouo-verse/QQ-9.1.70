package com.tencent.mobileqq.mini.entry.search.comm;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StUserInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StoreAppInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch$SearchExtInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchInfo implements ItemInfo {
    public String categoryDesc;
    public MiniAppInfo miniAppInfo;
    public String playingFriendsDesc;
    private int position;
    private String recommendReason;
    private MiniAppSearch$SearchExtInfo searchExtInfo;
    public List<STORE_APP_CLIENT$StUserInfo> userInfoList;
    public int userNum;

    public SearchInfo(STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo) {
        this.miniAppInfo = MiniAppInfo.from(sTORE_APP_CLIENT$StoreAppInfo.userAppInfo.get());
        this.categoryDesc = sTORE_APP_CLIENT$StoreAppInfo.serviceCategoryText.get();
        this.userNum = sTORE_APP_CLIENT$StoreAppInfo.userNum.get();
        this.userInfoList = sTORE_APP_CLIENT$StoreAppInfo.users.get();
        this.playingFriendsDesc = sTORE_APP_CLIENT$StoreAppInfo.playingFriText.get();
        this.recommendReason = sTORE_APP_CLIENT$StoreAppInfo.recommendReason.get();
    }

    public String getCategoryDesc() {
        return this.categoryDesc;
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.miniAppInfo;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRecommendReason() {
        return this.recommendReason;
    }

    public MiniAppSearch$SearchExtInfo getSearchExtInfo() {
        return this.searchExtInfo;
    }

    @Override // com.tencent.mobileqq.mini.entry.search.comm.ItemInfo
    public int getType() {
        return 2;
    }

    public String getUseNumberDesc() {
        int i3 = this.userNum;
        if (i3 < 10000) {
            return this.userNum + HardCodeUtil.qqStr(R.string.f167572da);
        }
        if (i3 >= 100000000) {
            return (this.userNum / 100000000) + HardCodeUtil.qqStr(R.string.f167562d_);
        }
        return (this.userNum / 10000) + HardCodeUtil.qqStr(R.string.f167582db);
    }

    public void setPosition(int i3) {
        this.position = i3;
    }

    public void setSearchExtInfo(MiniAppSearch$SearchExtInfo miniAppSearch$SearchExtInfo) {
        this.searchExtInfo = miniAppSearch$SearchExtInfo;
    }
}
