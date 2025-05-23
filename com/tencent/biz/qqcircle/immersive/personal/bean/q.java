package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class q extends QCircleBaseWnsConfigResPackage {

    /* renamed from: a, reason: collision with root package name */
    public String f88505a = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8918/achievement/qvideo_skin_tips_achievement.zip";

    /* renamed from: b, reason: collision with root package name */
    public String f88506b = "https://downv6.qq.com/video_story/qcircle/zip/darkmode/8918/achievement/qvideo_skin_tips_achievement.zip";

    public static q a() {
        return new q();
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
        arrayList.add(this.f88505a);
        arrayList.add(this.f88506b);
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
