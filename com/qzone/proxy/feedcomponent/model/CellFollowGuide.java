package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_follow_guide;
import NS_MOBILE_FEEDS.single_feed;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellFollowGuide implements SmartParcelable {
    public static final int STATUS_FOLD = 0;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_UNFOLD = 2;

    @NeedParcel
    public int action_type;

    @NeedParcel
    public String action_url;

    @NeedParcel
    public String button_text;

    @NeedParcel
    public long count;

    @NeedParcel
    public String displayBarSummary;

    @NeedParcel
    public String displaySummary;

    @NeedParcel
    public int displaySummaryEllipsizeEnd;

    @NeedParcel
    public int displaySummaryEllipsizeStart;

    @NeedParcel
    public int feed_type;

    @NeedParcel
    public ArrayList<User> followed_list;

    @NeedParcel
    public boolean hideTextAndAvatar;

    @NeedParcel
    public String icon_url;

    @NeedParcel
    public String summary;

    @NeedParcel
    public String title;

    @NeedParcel
    public ArrayList<BusinessFeedData> unreadFollowFeeds;

    @NeedParcel
    public String attach_info = "";
    public int status = 0;

    public List<CellLikeInfo.LikeMan> convertUserList() {
        if (this.followed_list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.followed_list.size(); i3++) {
            CellLikeInfo.LikeMan likeMan = new CellLikeInfo.LikeMan();
            likeMan.user = this.followed_list.get(i3);
            arrayList.add(likeMan);
        }
        return arrayList;
    }

    public int getStatus() {
        return this.status;
    }

    public List<BusinessFeedData> getUnreadFollowFeeds() {
        return this.unreadFollowFeeds;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public static CellFollowGuide create(l lVar) {
        if (lVar == null || lVar.f50359j0 == null) {
            return null;
        }
        CellFollowGuide cellFollowGuide = new CellFollowGuide();
        cellFollowGuide.followed_list = User.fromSUserList(lVar.f50359j0.followed_list);
        cell_follow_guide cell_follow_guideVar = lVar.f50359j0;
        cellFollowGuide.count = cell_follow_guideVar.count;
        cellFollowGuide.title = cell_follow_guideVar.title;
        String str = cell_follow_guideVar.summary;
        cellFollowGuide.summary = str;
        cellFollowGuide.displaySummary = str;
        cellFollowGuide.displayBarSummary = str;
        cellFollowGuide.icon_url = cell_follow_guideVar.icon_url;
        cellFollowGuide.action_type = cell_follow_guideVar.action_type;
        cellFollowGuide.action_url = cell_follow_guideVar.action_url;
        cellFollowGuide.feed_type = cell_follow_guideVar.feed_type;
        cellFollowGuide.button_text = cell_follow_guideVar.button_text;
        cellFollowGuide.attach_info = cell_follow_guideVar.attach_info;
        cellFollowGuide.status = 0;
        return cellFollowGuide;
    }

    public void setUnreadFollowFeeds(List<single_feed> list, BusinessFeedData businessFeedData) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (this.unreadFollowFeeds == null) {
            this.unreadFollowFeeds = new ArrayList<>();
        }
        this.unreadFollowFeeds.clear();
        Iterator<single_feed> it = list.iterator();
        while (it.hasNext()) {
            BusinessFeedData createFrom = BusinessFeedData.createFrom(it.next(), 4097);
            createFrom.isFromFollowGuide = true;
            createFrom.parentFeedData = businessFeedData;
            if (!createFrom.hasCalculate) {
                createFrom.preCalculate();
            }
            this.unreadFollowFeeds.add(createFrom);
        }
    }
}
