package com.tencent.qqlive.module.videoreport.report.element;

import android.view.View;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.sample.SampleInfo;
import com.tencent.qqlive.module.videoreport.sample.SampleInfoManager;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ElementExposureEndReporter implements IExposureRecorder.OnExposureStatusListener {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final ElementExposureEndReporter INSTANCE;

        static {
            ElementExposureEndReporter elementExposureEndReporter = new ElementExposureEndReporter();
            INSTANCE = elementExposureEndReporter;
            IExposureRecorder.Factory.getInstance().registerOnExposureStatusListener(elementExposureEndReporter);
        }

        InstanceHolder() {
        }
    }

    private void addKeySampleRate(View view, FinalData finalData) {
        SampleInfo elementSampleInfoByObject;
        if (view != null && (elementSampleInfoByObject = SampleInfoManager.getInstance().getElementSampleInfoByObject(view, "imp_end")) != null) {
            finalData.put(DTParamKey.REPORT_KEY_ELE_SAMPLE_RATE, Float.valueOf(elementSampleInfoByObject.getSampleRate()));
        }
    }

    public static ElementExposureEndReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void reportFinalData(IExposureRecorder.ExposureInfoWrapper exposureInfoWrapper, long j3) {
        FinalData finalData;
        long j16;
        Map<String, Object> dynamicParams;
        ElementExposureReporter.getInstance().reportNotBizReadyElement(exposureInfoWrapper.uniqueId);
        if (exposureInfoWrapper.canReportExposureEnd && (finalData = exposureInfoWrapper.finalData) != null && exposureInfoWrapper.exposureView != null) {
            finalData.setEventKey("imp_end");
            finalData.eventParams.put("element_lvtm", String.valueOf(j3));
            AreaInfo areaInfo = exposureInfoWrapper.areaInfo;
            double d16 = 0.0d;
            long j17 = 0;
            if (areaInfo != null) {
                long j18 = areaInfo.viewArea;
                j16 = areaInfo.exposureArea;
                if (j18 != 0) {
                    d16 = j16 / j18;
                }
                j17 = j18;
            } else {
                j16 = 0;
            }
            finalData.put(ParamKey.REPORT_KEY_ELEMENT_AREA, String.valueOf(j17));
            finalData.put(ParamKey.REPORT_KEY_ELE_IMP_AREA, String.valueOf(j16));
            finalData.put(ParamKey.REPORT_KEY_ELE_IMP_RATE, String.format(Locale.getDefault(), "%.2f", Double.valueOf(d16)));
            addKeySampleRate(exposureInfoWrapper.exposureView.get(), finalData);
            IDynamicParams eventDynamicParams = DataRWProxy.getDataEntity(exposureInfoWrapper.exposureView.get(), true).getEventDynamicParams();
            if (eventDynamicParams == null) {
                dynamicParams = null;
            } else {
                dynamicParams = eventDynamicParams.getDynamicParams("imp_end");
            }
            if (!BaseUtils.isEmpty(dynamicParams)) {
                finalData.putAll(dynamicParams);
            }
            FinalDataTarget.handle(exposureInfoWrapper.exposureView.get(), finalData);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder.OnExposureStatusListener
    public void onViewUnexposed(IExposureRecorder.ExposureInfoWrapper exposureInfoWrapper, long j3) {
        reportFinalData(exposureInfoWrapper, j3);
        SampleInfoManager.getInstance().unLockSampleInfo(2, exposureInfoWrapper.exposureView.get());
    }

    ElementExposureEndReporter() {
    }
}
