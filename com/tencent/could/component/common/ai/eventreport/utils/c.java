package com.tencent.could.component.common.ai.eventreport.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.could.component.common.ai.eventreport.api.EventReportConfig;
import com.tencent.could.component.common.ai.eventreport.api.EventReporter;
import com.tencent.could.component.common.ai.eventreport.entry.ErrorInfo;
import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.could.component.common.ai.net.HttpMethod;
import com.tencent.could.component.common.ai.net.TXCHttp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f99947a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f99948b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f99949c;

    public c(String str, String str2, String str3) {
        this.f99947a = str;
        this.f99948b = str2;
        this.f99949c = str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setAction(this.f99947a);
        errorInfo.setStack(this.f99948b);
        errorInfo.setToken(this.f99949c);
        errorInfo.setDeviceInfo(DeviceInfoUtil.createDeviceInfo());
        EventReportConfig eventReportConfig = EventReporter.getInstance().getEventReportConfig();
        errorInfo.setBusiness(eventReportConfig.getBusiness());
        errorInfo.setVersion(eventReportConfig.getSdkVersion());
        errorInfo.setOrigin(eventReportConfig.getOrigin());
        try {
            String jsonString = errorInfo.toJsonString();
            String errorInfoUrl = eventReportConfig.getErrorInfoUrl();
            if (!TextUtils.isEmpty(errorInfoUrl)) {
                TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(errorInfoUrl).setGzip(true).setHttpMethod(HttpMethod.POST).setRequestData(jsonString).createNetWorkParam(), new d());
            }
        } catch (JSONException e16) {
            Log.e("NetReportUtil", "doReportErrorInfo change error! e: " + e16.getLocalizedMessage());
        }
    }
}
