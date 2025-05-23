package com.tencent.biz.qcircleshadow.lib;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCircleReporter;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class QCirclePluginTrace implements Serializable {
    public static final String TAG = "QCirclePluginLoadTrace";
    public static final String TRACE_EVENT_ID_INIT_INFO = "qcircle_init_info";
    public static final String TRACE_LOAD_PLUGIN_LOADER = "qcircle_load_plugin_loader";
    public static final String TRACE_LOAD_RUNTIME = "qcircle_load_runtime";
    public static final String TRACE_ODEX_INSTALL = "qcircle_odex_install";
    public static final String TRACE_ON_CREATE = "qcircle_on_create";
    public static final String TRACE_START_SPLASH = "qcircle_trace_splash";
    public static final String TRACE_WAIT_FOR_SERVICE = "qcircle_wait_service_connect";
    private ConcurrentHashMap<String, Long> mTraceMapStart = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> mTraceMapCost = new ConcurrentHashMap<>();

    public static void traceEndAndUpdate(Bundle bundle, String str) {
        QCirclePluginInitBean qCirclePluginInitBean = (QCirclePluginInitBean) bundle.getSerializable(QCirclePluginConstant.Business.KEY_Q_CIRCLE_PLUGIN_INIT_BEAN);
        if (qCirclePluginInitBean != null && qCirclePluginInitBean.getTrace() != null) {
            qCirclePluginInitBean.getTrace().traceEnd(str);
            bundle.putSerializable(QCirclePluginConstant.Business.KEY_Q_CIRCLE_PLUGIN_INIT_BEAN, qCirclePluginInitBean);
        }
    }

    public static void traceStartAndUpdate(Bundle bundle, String str) {
        QCirclePluginInitBean qCirclePluginInitBean = (QCirclePluginInitBean) bundle.getSerializable(QCirclePluginConstant.Business.KEY_Q_CIRCLE_PLUGIN_INIT_BEAN);
        if (qCirclePluginInitBean != null) {
            QCirclePluginTrace trace = qCirclePluginInitBean.getTrace();
            if (trace == null) {
                trace = new QCirclePluginTrace();
            }
            trace.traceStart(str);
            qCirclePluginInitBean.setTrace(trace);
            bundle.putSerializable(QCirclePluginConstant.Business.KEY_Q_CIRCLE_PLUGIN_INIT_BEAN, qCirclePluginInitBean);
        }
    }

    public void flush(final long j3, final String str, final boolean z16) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qcircleshadow.lib.QCirclePluginTrace.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str2 : QCirclePluginTrace.this.mTraceMapCost.keySet()) {
                    long longValue = ((Long) QCirclePluginTrace.this.mTraceMapCost.remove(str2)).longValue();
                    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEventId(str2).setPluginVersion(j3).setPluginType(str).setTimeCost(String.valueOf(longValue)).setExt1(String.valueOf(z16)));
                    QLog.d(QCirclePluginTrace.TAG, 1, "flush  trace:" + str2 + ", time cost:" + longValue + ", has preload:" + z16);
                }
            }
        });
    }

    public void traceEnd(String str) {
        if (!TextUtils.isEmpty(str) && this.mTraceMapStart.containsKey(str)) {
            this.mTraceMapCost.put(str, Long.valueOf(System.currentTimeMillis() - this.mTraceMapStart.get(str).longValue()));
        }
    }

    public void traceStart(String str) {
        if (!TextUtils.isEmpty(str) && !this.mTraceMapStart.containsKey(str)) {
            this.mTraceMapStart.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
