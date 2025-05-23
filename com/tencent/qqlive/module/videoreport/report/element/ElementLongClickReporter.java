package com.tencent.qqlive.module.videoreport.report.element;

import android.view.View;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickType;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ElementLongClickReporter extends DefaultEventListener {
    private static final String TAG = "ElementClickReporter";
    private boolean mIsInitialed;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final ElementLongClickReporter INSTANCE;

        static {
            ElementLongClickReporter elementLongClickReporter = new ElementLongClickReporter();
            INSTANCE = elementLongClickReporter;
            elementLongClickReporter.init();
        }

        InstanceHolder() {
        }
    }

    private String getEventKey() {
        return "clck";
    }

    public static ElementLongClickReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        if (this.mIsInitialed) {
            return;
        }
        EventCollector.getInstance().registerEventListener(this);
        this.mIsInitialed = true;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onViewLongClick(View view, DTConstants.ClickEventSource clickEventSource) {
        super.onViewLongClick(view, clickEventSource);
        if (view == null || !ReportHelper.needReportLongClick(view, clickEventSource) || !ReportHelper.allowReportClick(DataBinder.getDataEntity(view))) {
            return;
        }
        FinalData build = DataBuilderFactory.obtain().build(getEventKey(), ReversedDataCollector.collect(view));
        if (build == null) {
            return;
        }
        build.eventKey = getEventKey();
        build.eventType = DataRWProxy.getEventType(view);
        build.eventParams.put(DTParamKey.REPORT_KEY_CLICK_TYPE, Integer.valueOf(ClickType.VIEW_LONG_CLICK.getType()));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(getEventKey(), build.getEventParams());
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onViewLongClick: view=" + view + ",finalData=" + build);
        }
        FinalDataTarget.handle(view, build);
    }

    ElementLongClickReporter() {
        this.mIsInitialed = false;
    }
}
