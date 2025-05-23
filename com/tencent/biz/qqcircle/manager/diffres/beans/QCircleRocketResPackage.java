package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qcircleshadow.lib.QCirclePluginConstant;
import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QCircleRocketResPackage extends QCircleBaseWnsConfigResPackage {
    public String rocket1;
    public String rocket2;
    public String rocket3;
    public String rocketCount;
    public String rocketEnd;
    public String rocketFirework;
    public String rocketSingleClick;
    public boolean useSpNewCountMargin = false;

    public static QCircleRocketResPackage getDefaultResBean() {
        QCircleRocketResPackage qCircleRocketResPackage = new QCircleRocketResPackage();
        qCircleRocketResPackage.rocket1 = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_1_seq.zip";
        qCircleRocketResPackage.rocket2 = QCirclePluginConstant.DownLoad.URL_ANIMATION_DRAWABLE_ROCKEY_SECOND;
        qCircleRocketResPackage.rocket3 = QCirclePluginConstant.DownLoad.URL_ANIMATION_DRAWABLE_ROCKEY_THIRD;
        qCircleRocketResPackage.rocketCount = QCirclePluginConstant.DownLoad.URL_ANIMATION_DRAWABLE_ROCKEY_COUNT;
        qCircleRocketResPackage.rocketEnd = QCirclePluginConstant.DownLoad.URL_ANIMATION_DRAWABLE_ROCKEY_END;
        qCircleRocketResPackage.rocketSingleClick = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_1_seq.zip";
        qCircleRocketResPackage.rocketFirework = "https://downv6.qq.com/video_story/qcircle/feed/rocket/qvideo_rocket_feed_quickpush_3_decorate_seq.zip";
        return qCircleRocketResPackage;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getDiffTimeConfigKey() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage
    public String getMainKey() {
        return "smallworld";
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<String> getPreloadZipList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rocketSingleClick);
        arrayList.add(this.rocketCount);
        arrayList.add(this.rocket1);
        arrayList.add(this.rocket2);
        arrayList.add(this.rocket3);
        arrayList.add(this.rocketEnd);
        arrayList.add(this.rocketFirework);
        return arrayList;
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

    public String toString() {
        return "QCircleRocketResBean{rocketSingleClick='" + this.rocketSingleClick + "', rocketCount='" + this.rocketCount + "', rocket1='" + this.rocket1 + "', rocket2='" + this.rocket2 + "', rocket3='" + this.rocket3 + "', rocketEnd='" + this.rocketEnd + "', rocketFirework='" + this.rocketFirework + "', useSpNewCountMargin=" + this.useSpNewCountMargin + '}';
    }
}
