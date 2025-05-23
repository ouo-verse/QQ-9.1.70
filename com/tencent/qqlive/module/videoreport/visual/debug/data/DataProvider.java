package com.tencent.qqlive.module.videoreport.visual.debug.data;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes22.dex */
public class DataProvider {
    private static boolean enableReportClick(View view) {
        ClickPolicy elementClickPolicy = VideoReportInner.getInstance().getElementClickPolicy(view);
        if (elementClickPolicy == null) {
            elementClickPolicy = VideoReportInner.getInstance().getConfiguration().getElementClickPolicy();
        }
        if (elementClickPolicy != ClickPolicy.REPORT_NONE) {
            return true;
        }
        return false;
    }

    private static boolean enableReportEndExposure(View view) {
        EndExposurePolicy elementEndExposePolicy = VideoReportInner.getInstance().getElementEndExposePolicy(view);
        if (elementEndExposePolicy == null) {
            elementEndExposePolicy = VideoReportInner.getInstance().getConfiguration().getElementEndExposePolicy();
        }
        if (elementEndExposePolicy != EndExposurePolicy.REPORT_NONE) {
            return true;
        }
        return false;
    }

    private static boolean enableReportExposure(View view) {
        ExposurePolicy elementExposePolicy = VideoReportInner.getInstance().getElementExposePolicy(view);
        if (elementExposePolicy == null) {
            elementExposePolicy = VideoReportInner.getInstance().getConfiguration().getElementExposePolicy();
        }
        if (elementExposePolicy != ExposurePolicy.REPORT_NONE) {
            return true;
        }
        return false;
    }

    public static List<PageData> getPageInfo(View view) {
        ArrayList arrayList = new ArrayList();
        PageInfo currentPageInfo = PageManager.getInstance().getCurrentPageInfo();
        if (currentPageInfo == null) {
            return arrayList;
        }
        if (currentPageInfo.getPageView() != null && currentPageInfo.getPageView().getRootView() == view) {
            while (currentPageInfo != null) {
                Object page = currentPageInfo.getPage();
                View pageView = currentPageInfo.getPageView();
                if (page != null && pageView != null) {
                    PageData pageData = new PageData(page, pageView);
                    pageData.pageId = DataRWProxy.getPageId(page);
                    pageData.pageParams = DataRWProxy.getPageParams(page);
                    arrayList.add(pageData);
                }
                currentPageInfo = currentPageInfo.getParentPage();
            }
        }
        return arrayList;
    }

    @Nullable
    public static ViewData getViewInfo(View view) {
        PageInfo findOwnerPage;
        String elementId = DataRWProxy.getElementId(view);
        if (TextUtils.isEmpty(elementId) || (findOwnerPage = PageFinder.findOwnerPage(view)) == null) {
            return null;
        }
        ViewData viewData = new ViewData(view);
        viewData.elementId = elementId;
        viewData.elementParams = DataRWProxy.getElementParams(view);
        viewData.pageId = DataRWProxy.getPageId(findOwnerPage.getPage());
        viewData.reportClick = enableReportClick(view);
        viewData.reportExposure = enableReportExposure(view);
        viewData.reportEndExposure = enableReportEndExposure(view);
        viewData.hasClickListener = view.hasOnClickListeners();
        viewData.hasInject = VideoReport.isInjectSuccess();
        return viewData;
    }
}
