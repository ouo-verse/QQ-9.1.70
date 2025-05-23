package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QCirclePushButtonResPackage extends QCircleBaseWnsConfigResPackage {
    public String iconRes;
    public String pushAppear;

    public static QCirclePushButtonResPackage getDefaultResBean() {
        QCirclePushButtonResPackage qCirclePushButtonResPackage = new QCirclePushButtonResPackage();
        qCirclePushButtonResPackage.pushAppear = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_pushappear_seq.zip";
        return qCirclePushButtonResPackage;
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
        arrayList.add(this.iconRes);
        arrayList.add(this.pushAppear);
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
        return "QCirclePushButtonResInfo{iconRes='" + this.iconRes + "', pushAppear='" + this.pushAppear + "'}";
    }
}
