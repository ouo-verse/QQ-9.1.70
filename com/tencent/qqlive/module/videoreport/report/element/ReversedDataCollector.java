package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReversedDataCollector {
    public static PathData collect(@NonNull View view) {
        PathData pathData = new PathData();
        while (view != null) {
            DataEntity dataEntity = DataBinder.getDataEntity(view);
            if (PathDataUtils.canCollect(dataEntity)) {
                pathData.addLast(dataEntity);
            }
            PageInfo findRelatedPage = PageFinder.findRelatedPage(view);
            if (findRelatedPage != null) {
                dataEntity = DataBinder.getDataEntity(findRelatedPage.getPage());
                if (PathDataUtils.shouldStop(dataEntity)) {
                    pathData.setPage(findRelatedPage.getPage());
                    return pathData;
                }
            }
            view = ReportHelper.findParent(view, dataEntity);
        }
        return pathData;
    }
}
