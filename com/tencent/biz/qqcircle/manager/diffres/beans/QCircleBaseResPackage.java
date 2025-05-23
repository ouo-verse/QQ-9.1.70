package com.tencent.biz.qqcircle.manager.diffres.beans;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class QCircleBaseResPackage {
    public transient boolean isDefaultRes = false;
    public boolean isAutoPreloadRes = true;

    public abstract List<String> getPreloadZipList();

    public abstract List<QCircleActionType> getResRefreshActionTypeList();
}
