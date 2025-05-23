package com.tencent.qqlive.module.videoreport.report.element;

import android.os.SystemClock;
import android.view.View;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickType;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.sample.SampleInfo;
import com.tencent.qqlive.module.videoreport.sample.SampleInfoManager;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ElementClickReporter extends DefaultEventListener {
    private static final String TAG = "ElementClickReporter";
    private WeakHashMap<View, Long> mClickTimeMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final ElementClickReporter INSTANCE;

        static {
            ElementClickReporter elementClickReporter = new ElementClickReporter();
            INSTANCE = elementClickReporter;
            elementClickReporter.init();
        }

        InstanceHolder() {
        }
    }

    private void addKeySampleRate(View view, FinalData finalData) {
        SampleInfo elementSampleInfoByObject = SampleInfoManager.getInstance().getElementSampleInfoByObject(view, "clck");
        if (elementSampleInfoByObject != null) {
            finalData.put(DTParamKey.REPORT_KEY_ELE_SAMPLE_RATE, Float.valueOf(elementSampleInfoByObject.getSampleRate()));
        }
    }

    public static ElementClickReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        EventCollector.getInstance().registerEventListener(this);
    }

    private boolean isValidClick(DataEntity dataEntity, View view) {
        Long l3 = this.mClickTimeMap.get(view);
        if (l3 == null) {
            return true;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Long l16 = (Long) DataEntityOperator.getInnerParam(dataEntity, InnerKey.CLICK_INTERVAL);
        if (l16 == null) {
            l16 = Long.valueOf(VideoReportInner.getInstance().getConfiguration().getClickReportInterval());
        }
        if (uptimeMillis > l3.longValue() + l16.longValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onViewClick(View view, DTConstants.ClickEventSource clickEventSource) {
        if (!ReportHelper.needReportClick(view, clickEventSource)) {
            return;
        }
        DataEntity dataEntity = DataBinder.getDataEntity(view);
        if (!ReportHelper.allowReportClick(dataEntity)) {
            return;
        }
        if (!isValidClick(dataEntity, view)) {
            Log.i(TAG, "onViewClick: not valid click ");
            return;
        }
        this.mClickTimeMap.put(view, Long.valueOf(SystemClock.uptimeMillis()));
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onViewClick: view=" + view);
        }
        FinalData build = DataBuilderFactory.obtain().build("clck", ReversedDataCollector.collect(view));
        if (build == null) {
            return;
        }
        build.setEventKey("clck");
        build.setEventType(DataRWProxy.getEventType(view));
        build.put(DTParamKey.REPORT_KEY_CLICK_TYPE, Integer.valueOf(ClickType.VIEW_CLICK.getType()));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("clck", build.getEventParams());
        }
        addKeySampleRate(view, build);
        FinalDataTarget.handle(view, build);
    }

    ElementClickReporter() {
        this.mClickTimeMap = new WeakHashMap<>();
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "init ");
        }
    }
}
