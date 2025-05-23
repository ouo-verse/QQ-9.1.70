package com.tencent.qqlive.module.videoreport.report.keyboard;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class KeyBoardEditorActionReporter extends DefaultEventListener {
    private static final String TAG = "KeyBoardClickReporter";
    private static final HashMap<Integer, String> VALID_ACTION_MAP;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final KeyBoardEditorActionReporter INSTANCE;

        static {
            KeyBoardEditorActionReporter keyBoardEditorActionReporter = new KeyBoardEditorActionReporter();
            INSTANCE = keyBoardEditorActionReporter;
            keyBoardEditorActionReporter.init();
        }

        InstanceHolder() {
        }
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        VALID_ACTION_MAP = hashMap;
        hashMap.put(6, DTConstants.KeyBoardAction.ACTION_DONE);
        hashMap.put(2, DTConstants.KeyBoardAction.ACTION_GO);
        hashMap.put(3, DTConstants.KeyBoardAction.ACTION_SEARCH);
        hashMap.put(4, DTConstants.KeyBoardAction.ACTION_SEND);
    }

    public static KeyBoardEditorActionReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        EventCollector.getInstance().registerEventListener(this);
    }

    private boolean isValidAction(int i3) {
        return VALID_ACTION_MAP.containsKey(Integer.valueOf(i3));
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onEditorAction(TextView textView, int i3, KeyEvent keyEvent, int i16) {
        DataEntity dataEntity = DataBinder.getDataEntity(textView);
        if (dataEntity == null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "onEditorAction: dataEntity=" + dataEntity);
                return;
            }
            return;
        }
        if (!isValidAction(i3)) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "onEditorAction: isValidAction " + i3);
                return;
            }
            return;
        }
        FinalData build = DataBuilderFactory.obtain().build(DTEventKey.SUBMIT, ReversedDataCollector.collect(textView));
        if (build == null) {
            return;
        }
        build.setEventKey(DTEventKey.SUBMIT);
        build.setEventType(DataRWProxy.getEventType(textView));
        build.put(DTParamKey.REPORT_KEY_SUBMIT_TYPE, VALID_ACTION_MAP.get(Integer.valueOf(i3)));
        build.put(DTParamKey.REPORT_KEY_SUBMIT_WAY, Integer.valueOf(i16));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(DTEventKey.SUBMIT, build.getEventParams());
        }
        FinalDataTarget.handle(textView, build);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onViewClick(View view, DTConstants.ClickEventSource clickEventSource) {
        Object obj;
        if (!ReportHelper.needReportClick(view, clickEventSource) || !ReportHelper.allowReportClick(DataBinder.getDataEntity(view))) {
            return;
        }
        Object extendParam = DataRWProxy.getExtendParam(view, DTConstants.DTExtendMapKey.SUBMIT_TARGET);
        if (extendParam instanceof WeakReference) {
            obj = ((WeakReference) extendParam).get();
        } else {
            obj = null;
        }
        if (!(obj instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) obj;
        int imeOptions = textView.getImeOptions();
        if (imeOptions == 0) {
            imeOptions = 6;
        }
        onEditorAction(textView, imeOptions, null, 2);
    }

    KeyBoardEditorActionReporter() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "init ");
        }
    }
}
