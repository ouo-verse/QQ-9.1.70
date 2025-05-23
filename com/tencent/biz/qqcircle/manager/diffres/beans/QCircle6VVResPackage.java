package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QCircle6VVResPackage extends QCircleBaseWnsConfigResPackage {
    public static final String ICON_AWARD = "qvideo_6vv_award.png";
    public static final String ICON_COIN = "qvideo_6vv_coin.png";
    public static final String ICON_GUN_CHARING_0 = "qvideo_6vv_skin_gun_charging_0.png";
    public static final String ICON_GUN_CHARING_1 = "qvideo_6vv_skin_gun_charging_1.png";
    public static final String ICON_GUN_CHARING_2 = "qvideo_6vv_skin_gun_charging_2.png";
    public static final String ICON_GUN_CHARING_3 = "qvideo_6vv_skin_gun_charging_3.png";
    public static final String ICON_SLOT = "qvideo_6vv_slot.png";
    public String mIconResUrl = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_skin_6vv_icon_res.zip";
    public String mCoinChange4Url = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_coin_changing_4.zip";
    public String mCoinChange5Url = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_coin_changing_5.zip";
    public String mCoinChange6Url = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_coin_changing_6.zip";
    public String mCoinStart1 = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_skin_gun_shooting_1.zip";
    public String mCoinStart2 = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_skin_gun_shooting_2.zip";
    public String mCoinStart3 = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_skin_gun_shooting_3.zip";
    public String mSendCoinEnd = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_skin_gun_shooted_coin.zip";
    public String mSenderAppear = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_skin_gun_showup.zip";
    public String mSenderDisAppear = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_skin_gun_shooted_disappear.zip";
    public String mCoinMissed = "https://downv6.qq.com/video_story/qcircle/feed/6vv/qvideo_6vv_coin_missed.zip";

    public static QCircle6VVResPackage getDefaultResBean() {
        return new QCircle6VVResPackage();
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getDiffTimeConfigKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getMainKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<String> getPreloadZipList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mIconResUrl);
        arrayList.add(this.mCoinChange4Url);
        arrayList.add(this.mCoinChange5Url);
        arrayList.add(this.mCoinChange6Url);
        arrayList.add(this.mCoinStart1);
        arrayList.add(this.mCoinStart2);
        arrayList.add(this.mCoinStart3);
        arrayList.add(this.mSendCoinEnd);
        arrayList.add(this.mSenderAppear);
        arrayList.add(this.mSenderDisAppear);
        arrayList.add(this.mCoinMissed);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getResConfigKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<QCircleActionType> getResRefreshActionTypeList() {
        return new ArrayList();
    }
}
