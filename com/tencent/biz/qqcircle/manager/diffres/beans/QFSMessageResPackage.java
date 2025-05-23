package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSMessageResPackage extends QCircleBaseWnsConfigResPackage {
    public String mLikeAnimResUrl = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8915/msgpage_like/qvideo_msgpage_animation_thumb.zip";
    public String mBluePointAminUrl = QCircleAvatarView.f92909g0;

    public static QFSMessageResPackage getDefaultResBean() {
        return new QFSMessageResPackage();
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
        arrayList.add(this.mLikeAnimResUrl);
        arrayList.add(this.mBluePointAminUrl);
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
