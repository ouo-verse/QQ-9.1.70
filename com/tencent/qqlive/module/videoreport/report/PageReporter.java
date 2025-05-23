package com.tencent.qqlive.module.videoreport.report;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.flutter.DTFlutterPageManager;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageBodyInfo;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.report.bizready.IBizReadyListener;
import com.tencent.qqlive.module.videoreport.report.bizready.IPageBizReady;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.sample.SampleInfo;
import com.tencent.qqlive.module.videoreport.sample.SampleInfoManager;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes22.dex */
public class PageReporter implements PageManager.IPageListener, IBizReadyListener<PageInfo> {
    private static final String TAG = "PageReporter";
    private IPageBizReady mPageBizReady;
    private final SparseArray<Long> mPageInTimes;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final PageReporter INSTANCE;

        static {
            PageReporter pageReporter = new PageReporter();
            INSTANCE = pageReporter;
            pageReporter.init();
        }

        InstanceHolder() {
        }
    }

    private void addKeySampleRate(Object obj, FinalData finalData) {
        SampleInfo pageSampleInfoByObject = SampleInfoManager.getInstance().getPageSampleInfoByObject(obj);
        if (pageSampleInfoByObject != null) {
            finalData.put(DTParamKey.REPORT_KEY_PG_SAMPLE_RATE, Float.valueOf(pageSampleInfoByObject.getSampleRate()));
        }
    }

    private FinalData createPgInFinalData(@NonNull PageInfo pageInfo) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey("pgin");
        finalData.setEventType(DataRWProxy.getEventType(pageInfo.getPage()));
        finalData.putAll(addIsPageReturnParam(getPageReportInfo("pgin", pageInfo), pageInfo));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("pgin", finalData.getEventParams());
        }
        addKeySampleRate(pageInfo.getPage(), finalData);
        return finalData;
    }

    private FinalData createPgOutFinalData(@NonNull PageInfo pageInfo) {
        long longValue;
        Long l3 = this.mPageInTimes.get(pageInfo.getPageHashCode());
        this.mPageInTimes.remove(pageInfo.getPageHashCode());
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey("pgout");
        finalData.setEventType(DataRWProxy.getEventType(pageInfo.getPage()));
        finalData.put(ParamKey.REPORT_KEY_LVTM, Long.valueOf(SystemClock.elapsedRealtime() - longValue));
        putPageBodyInfo(finalData);
        putInteractiveFlag(finalData, pageInfo);
        finalData.putAll(getPageReportInfo("pgout", pageInfo));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("pgout", finalData.getEventParams());
        }
        addKeySampleRate(pageInfo.getPage(), finalData);
        return finalData;
    }

    private Object getCurPage() {
        PageInfo currentPageInfo = PageManager.getInstance().getCurrentPageInfo();
        if (currentPageInfo == null) {
            return null;
        }
        return currentPageInfo.getPage();
    }

    public static PageReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @NonNull
    private Map<String, Object> getPageReportInfo(String str, @NonNull PageInfo pageInfo) {
        return PageUtils.getPageInfo(str, pageInfo.getPage(), pageInfo.getPageHashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        PageManager.getInstance().register(this);
        PageBizReadyImp pageBizReadyImp = new PageBizReadyImp();
        this.mPageBizReady = pageBizReadyImp;
        pageBizReadyImp.setOnBizReadyListener(this);
    }

    private void initInteractiveFlag(Object obj) {
        if (obj == null) {
            return;
        }
        DataRWProxy.removeInnerParam(obj, InnerKey.PAGE_INTERACTIVE_FLAG);
    }

    private void putInteractiveFlag(@NonNull FinalData finalData, PageInfo pageInfo) {
        String str;
        Object page = pageInfo.getPage();
        if (page == null) {
            return;
        }
        if (DataRWProxy.getInnerParam(page, InnerKey.PAGE_INTERACTIVE_FLAG) == Boolean.TRUE) {
            str = "1";
        } else {
            str = "0";
        }
        finalData.put(ParamKey.REPORT_KEY_INTERACTIVE_FLAG, str);
    }

    private void putPageBodyInfo(@NonNull FinalData finalData) {
        Object innerParam = DataRWProxy.getInnerParam(getCurPage(), InnerKey.PAGE_BODY_INFO);
        if (!(innerParam instanceof PageBodyInfo)) {
            return;
        }
        PageBodyInfo pageBodyInfo = (PageBodyInfo) innerParam;
        finalData.put(ParamKey.REPORT_KEY_PG_AREA, String.valueOf(pageBodyInfo.getPageArea()));
        finalData.put(ParamKey.REPORT_KEY_PG_IMP_AREA, String.valueOf(pageBodyInfo.getProgressArea()));
        finalData.put(ParamKey.REPORT_KEY_PG_IMP_RATE, String.format(Locale.getDefault(), "%.2f", Double.valueOf(pageBodyInfo.getProgressRate())));
    }

    @NonNull
    Map<String, Object> addIsPageReturnParam(@NonNull Map<String, Object> map, PageInfo pageInfo) {
        int i3;
        if (pageInfo != null) {
            i3 = isPageReturn(DataBinder.getDataEntity(pageInfo.getPage()));
        } else {
            i3 = 0;
        }
        map.put(DTParamKey.REPORT_KEY_IS_PAGE_RETURN, Integer.valueOf(i3));
        return map;
    }

    public void doReportPageIn(PageInfo pageInfo, boolean z16) {
        if (pageInfo == null) {
            return;
        }
        SampleInfoManager.getInstance().startSample(1, pageInfo.getPage());
        this.mPageInTimes.put(pageInfo.getPageHashCode(), Long.valueOf(SystemClock.elapsedRealtime()));
        initInteractiveFlag(pageInfo.getPage());
        PageInfo handleExposureInfo = this.mPageBizReady.handleExposureInfo(pageInfo);
        if (handleExposureInfo == null) {
            Log.d(TAG, "onPageIn() bizNotReady,so return... -> pageInfo=" + pageInfo);
            return;
        }
        reportPageInFinalData(handleExposureInfo, z16);
    }

    public void doReportPgOut(PageInfo pageInfo, boolean z16, boolean z17) {
        this.mPageBizReady.reportNotBizReadyPages();
        PageReportPolicy pageReportPolicy = VideoReportInner.getInstance().getPageReportPolicy(pageInfo.getPage());
        if (pageReportPolicy != PageReportPolicy.REPORT_PGOUT && pageReportPolicy != PageReportPolicy.REPORT_ALL) {
            SampleInfoManager.getInstance().unLockSampleInfo(1, pageInfo.getPage());
            if (z17) {
                return;
            }
        }
        if (z16) {
            FinalDataTarget.handleInMainThread(pageInfo.getPage(), createPgOutFinalData(pageInfo));
        } else {
            FinalDataTarget.handle(pageInfo.getPage(), createPgOutFinalData(pageInfo));
        }
        SampleInfoManager.getInstance().unLockSampleInfo(1, pageInfo.getPage());
    }

    @NonNull
    public Map<String, Object> getCurPageReportInfo(String str) {
        PageInfo currentPageInfo = PageManager.getInstance().getCurrentPageInfo();
        if (currentPageInfo == null) {
            return new HashMap();
        }
        return getPageReportInfo(str, currentPageInfo);
    }

    int isPageReturn(@Nullable DataEntity dataEntity) {
        String str = (String) DataEntityOperator.getInnerParam(dataEntity, InnerKey.PAGE_LAST_CONTENT_ID);
        String contentId = DataEntityOperator.getContentId(dataEntity);
        if (dataEntity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(contentId)) {
            return 0;
        }
        return contentId.equals(str) ? 1 : 0;
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageIn(@NonNull PageInfo pageInfo, @NonNull Set<PageInfo> set, int i3) {
        ArrayList arrayList = new ArrayList(set);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            PageInfo pageInfo2 = (PageInfo) arrayList.get(size);
            doReportPageIn(pageInfo2, true);
            updateLastContentId(pageInfo2);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageOut(@NonNull PageInfo pageInfo, DataEntity dataEntity, @NonNull Set<PageInfo> set, boolean z16) {
        for (PageInfo pageInfo2 : set) {
            if (DTFlutterPageManager.getInstance().isFlutterView(pageInfo2.getPageView())) {
                SampleInfoManager.getInstance().unLockSampleInfo(1, pageInfo2.getPage());
            } else {
                doReportPgOut(pageInfo2, z16, true);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageUpdate(PageInfo pageInfo, int i3) {
        if (ReportHelper.allPageReportEnabled(pageInfo)) {
            Set<PageInfo> inPagesWhenUpdate = pageInfo.getInPagesWhenUpdate();
            if (inPagesWhenUpdate != null) {
                Iterator it = new ArrayList(inPagesWhenUpdate).iterator();
                while (it.hasNext()) {
                    doReportPageIn((PageInfo) it.next(), true);
                }
            }
            Set<PageInfo> outPagesWhenUpdate = pageInfo.getOutPagesWhenUpdate();
            if (outPagesWhenUpdate != null) {
                Iterator it5 = new ArrayList(outPagesWhenUpdate).iterator();
                while (it5.hasNext()) {
                    doReportPgOut((PageInfo) it5.next(), false, true);
                }
            }
        }
    }

    void reportPageInFinalData(PageInfo pageInfo, boolean z16) {
        if (pageInfo == null) {
            return;
        }
        PageReportPolicy pageReportPolicy = VideoReportInner.getInstance().getPageReportPolicy(pageInfo.getPage());
        if (pageReportPolicy != PageReportPolicy.REPORT_PGIN && pageReportPolicy != PageReportPolicy.REPORT_ALL && z16) {
            PageReportPolicyManager.skipPageReport(pageInfo, pageReportPolicy);
        } else if (!DTFlutterPageManager.getInstance().isFlutterView(pageInfo.getPageView())) {
            FinalDataTarget.handle(pageInfo.getPage(), createPgInFinalData(pageInfo));
        }
    }

    public void setPageBizReady(Object obj, boolean z16) {
        this.mPageBizReady.setBizReady(obj, z16);
    }

    void updateLastContentId(PageInfo pageInfo) {
        if (pageInfo != null && pageInfo.getPage() != null) {
            Object page = pageInfo.getPage();
            DataRWProxy.setInnerParam(page, InnerKey.PAGE_LAST_CONTENT_ID, DataRWProxy.getContentId(page));
        }
    }

    PageReporter() {
        this.mPageInTimes = new SparseArray<>();
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReadyListener
    public void onBizReady(PageInfo pageInfo) {
        reportPageInFinalData(pageInfo, true);
    }
}
