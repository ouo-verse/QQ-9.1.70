package com.tencent.mobileqq.qqmatrix.threadleak;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQThreadBusinessHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    public static final String f274133d = "com.tencent.mobileqq.qqmatrix.threadleak.QQThreadBusinessHandler";

    protected QQThreadBusinessHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private List<matrix_thread$ThreadStackInfo> D2(JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                JSONArray optJSONArray = jSONObject2.optJSONArray("threads");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i16);
                        matrix_thread$ThreadInfo matrix_thread_threadinfo = new matrix_thread$ThreadInfo();
                        matrix_thread_threadinfo.name.set(jSONObject3.optString("name").replaceAll("\\d+", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
                        matrix_thread_threadinfo.tid.set(jSONObject3.optString("tid"));
                        arrayList2.add(matrix_thread_threadinfo);
                    }
                    matrix_thread$ThreadStackInfo matrix_thread_threadstackinfo = new matrix_thread$ThreadStackInfo();
                    matrix_thread_threadstackinfo.threads.addAll(arrayList2);
                    matrix_thread_threadstackinfo.count.set(Integer.parseInt(jSONObject2.optString("count")));
                    matrix_thread_threadstackinfo.native_stack.set(jSONObject2.optString("native"));
                    matrix_thread_threadstackinfo.java_stack.set(jSONObject2.optString(ResourceAttributes.TelemetrySdkLanguageValues.JAVA));
                    matrix_thread_threadstackinfo.hash.set(jSONObject2.optString("hash"));
                    arrayList.add(matrix_thread_threadstackinfo);
                }
                QLog.w("QQThreadBusinessHandler", 1, "[convertJsonArrayToThreadInfo] threads info empty");
            }
            return arrayList;
        } catch (JSONException e16) {
            QLog.e("QQThreadBusinessHandler", 1, "[convertJsonArrayToThreadInfo] error:" + e16.getMessage());
            return arrayList;
        }
    }

    private void E2(JSONObject jSONObject, matrix_thread$SsoThreadMonitorRequest matrix_thread_ssothreadmonitorrequest) {
        matrix_thread_ssothreadmonitorrequest.top_threads.addAll(D2(jSONObject, "TopCountThreadInfo"));
        matrix_thread_ssothreadmonitorrequest.leak_threads.addAll(D2(jSONObject, "LeakThreadInfo"));
        matrix_thread$Business matrix_thread_business = new matrix_thread$Business();
        matrix_thread_business.app.set(1);
        matrix_thread_business.token.set("");
        matrix_thread_ssothreadmonitorrequest.business.set(matrix_thread_business);
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            currentAccountUin = "1000";
        }
        matrix_thread_ssothreadmonitorrequest.uin.set(currentAccountUin);
        matrix_thread_ssothreadmonitorrequest.version.set(jSONObject.optString("VersionName"));
        matrix_thread_ssothreadmonitorrequest.timestamp_millisecond.set(jSONObject.optLong("Timestamps"));
        matrix_thread_ssothreadmonitorrequest.model.set(jSONObject.optString("Model"));
        matrix_thread_ssothreadmonitorrequest.brand.set(jSONObject.optString("Brand"));
        matrix_thread_ssothreadmonitorrequest.total_thread_num.set(jSONObject.optInt("TotalThreadNum"));
    }

    public void F2(JSONObject jSONObject) {
        if (this.appRuntime != null) {
            matrix_thread$SsoThreadMonitorRequest matrix_thread_ssothreadmonitorrequest = new matrix_thread$SsoThreadMonitorRequest();
            E2(jSONObject, matrix_thread_ssothreadmonitorrequest);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "trpc.ep.thread.ThreadReportService.SsoThreadMonitor");
            toServiceMsg.putWupBuffer(matrix_thread_ssothreadmonitorrequest.toByteArray());
            QLog.d("QQThreadBusinessHandler", 1, "[postMsgThroughSSO] requestBody size:" + matrix_thread_ssothreadmonitorrequest.toByteArray().length);
            super.sendPbReq(toServiceMsg);
            return;
        }
        QLog.e("QQThreadBusinessHandler", 1, "appRuntime = null which should never happen");
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.ep.thread.ThreadReportService.SsoThreadMonitor");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return zi2.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            matrix_thread$SsoThreadMonitorResponse matrix_thread_ssothreadmonitorresponse = new matrix_thread$SsoThreadMonitorResponse();
            try {
                matrix_thread_ssothreadmonitorresponse.mergeFrom((byte[]) obj);
                if (matrix_thread_ssothreadmonitorresponse.code.get() == 0) {
                    notifyUI(0, true, null);
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQThreadBusinessHandler", 1, "[onReceive] error:" + e16.getMessage());
                return;
            }
        }
        QLog.e("QQThreadBusinessHandler", 1, "fail to send to server");
    }
}
