package com.tencent.mobileqq.icgame.api.end;

import android.view.View;
import com.tencent.mobileqq.icgame.data.QQLiveEndRecommendInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveEndView {
    View getView();

    void onConfigurationChanged();

    void onPageOut(long j3, boolean z16, boolean z17);

    void onResume();

    void onStop();

    void setCommentNum(long j3);

    void setFollow(int i3);

    void setFollowVisible(boolean z16);

    void setGiftPopularity(long j3);

    void setGiftValue(long j3);

    void setHeadIcon(String str);

    void setLeftRecommend(QQLiveEndRecommendInfo qQLiveEndRecommendInfo);

    void setLiveTime(long j3);

    void setNewFans(long j3);

    void setNick(String str);

    void setPopularity(String str);

    void setPraiseNum(long j3);

    void setRecommendList(List<QQLiveEndRecommendInfo> list);

    void setRightRecommend(QQLiveEndRecommendInfo qQLiveEndRecommendInfo);
}
