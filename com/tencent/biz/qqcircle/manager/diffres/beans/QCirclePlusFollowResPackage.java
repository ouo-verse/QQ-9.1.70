package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QCirclePlusFollowResPackage extends QCircleBaseWnsConfigResPackage {
    public String iconAnimUrl;
    public String iconUrl;

    public static int getDefaultIconRes() {
        return R.drawable.f162041oo1;
    }

    public static QCirclePlusFollowResPackage getDefaultResBean() {
        QCirclePlusFollowResPackage qCirclePlusFollowResPackage = new QCirclePlusFollowResPackage();
        qCirclePlusFollowResPackage.iconAnimUrl = "https://downv6.qq.com/video_story/qcircle/feed/interact/qvideo_feed_follow_btn_seq.zip";
        return qCirclePlusFollowResPackage;
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
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getResConfigKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<QCircleActionType> getResRefreshActionTypeList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleActionType.TURN_PAGE);
        return arrayList;
    }
}
