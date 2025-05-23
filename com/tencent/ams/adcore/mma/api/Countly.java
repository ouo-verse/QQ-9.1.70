package com.tencent.ams.adcore.mma.api;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.b;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.adcore.mma.bean.Argument;
import com.tencent.ams.adcore.mma.bean.Company;
import com.tencent.ams.adcore.mma.bean.Config;
import com.tencent.ams.adcore.mma.bean.Domain;
import com.tencent.ams.adcore.mma.bean.SDK;
import com.tencent.ams.adcore.mma.bean.Signature;
import com.tencent.ams.adcore.mma.util.CommonUtil;
import com.tencent.ams.adcore.mma.util.DeviceInfoUtil;
import com.tencent.ams.adcore.mma.util.SdkConfigUpdateUtil;
import com.tencent.ams.adcore.utility.SLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Countly {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Countly";
    private static Countly mCountly;
    private static Context sContext;
    private boolean isInitExecuted;
    private Map<String, String> params;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            mCountly = new Countly();
        }
    }

    Countly() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private synchronized void doInit(Context context, String str) {
        if (this.isInitExecuted) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            if (this.params == null) {
                this.params = DeviceInfoUtil.fulfillTrackingInfo(applicationContext);
            }
            SdkConfigUpdateUtil.initCachedSdk(sContext);
            this.isInitExecuted = true;
            new BaseThread(new Runnable(context, str) { // from class: com.tencent.ams.adcore.mma.api.Countly.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$configUrl;
                final /* synthetic */ Context val$context;

                {
                    this.val$context = context;
                    this.val$configUrl = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Countly.this, context, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        SdkConfigUpdateUtil.updateSdk(this.val$context, this.val$configUrl);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static Countly sharedInstance() {
        return mCountly;
    }

    public String getReportUrl(String str) {
        List<Company> list;
        String str2;
        String str3;
        List<Argument> list2;
        List<Argument> list3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        SLog.d("mma_origin_url: " + str);
        try {
        } catch (Throwable th5) {
            SLog.e("MMA", "getReportUrl error.", th5);
            StatTracer.trackEvent(100182, 0, (b) null);
            GDTLogger.e(TAG, th5);
        }
        if (!TextUtils.isEmpty(str) && this.params != null) {
            String hostURL = CommonUtil.getHostURL(str);
            if (TextUtils.isEmpty(hostURL)) {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            SDK sdk = SdkConfigUpdateUtil.getSdk();
            if (sdk != null && (list = sdk.companies) != null && list.size() != 0) {
                HashMap hashMap = new HashMap(this.params);
                long currentTimeMillis = System.currentTimeMillis();
                for (Company company : sdk.companies) {
                    Domain domain = company.domain;
                    if (domain != null && !TextUtils.isEmpty(domain.url) && hostURL.endsWith(company.domain.url)) {
                        hashMap.putAll(DeviceInfoUtil.getUniqueData(sContext, company.name, company.encryptType));
                        ArrayList arrayList = new ArrayList();
                        Config config = company.config;
                        String str4 = "";
                        if (config == null || (list3 = config.arguments) == null) {
                            str2 = "";
                            str3 = str2;
                        } else {
                            str2 = "";
                            str3 = str2;
                            for (Argument argument : list3) {
                                if (argument != null && argument.isRequired) {
                                    str2 = company.separator;
                                    str3 = company.equalizer;
                                    arrayList.add(argument.value);
                                }
                            }
                        }
                        sb5.append((String) CommonUtil.removeExistArgmentAndGetRedirectURL(str, arrayList, str2, str3, "").get(Global.TRACKING_URL));
                        Config config2 = company.config;
                        if (config2 != null && (list2 = config2.arguments) != null) {
                            for (Argument argument2 : list2) {
                                if (argument2 != null && argument2.isRequired) {
                                    if ("TS".equals(argument2.key)) {
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append(company.separator);
                                        sb6.append(argument2.value);
                                        String str5 = company.equalizer;
                                        if (str5 == null) {
                                            str5 = "";
                                        }
                                        sb6.append(str5);
                                        sb6.append(currentTimeMillis);
                                        sb5.append(sb6.toString());
                                    } else if (Global.TRACKING_MUDS.equals(argument2.key)) {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append(company.separator);
                                        sb7.append(argument2.value);
                                        String str6 = company.equalizer;
                                        if (str6 == null) {
                                            str6 = "";
                                        }
                                        sb7.append(str6);
                                        sb7.append(CommonUtil.encodingUTF8("", argument2, company));
                                        sb5.append(sb7.toString());
                                    } else {
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append(company.separator);
                                        sb8.append(argument2.value);
                                        String str7 = company.equalizer;
                                        if (str7 == null) {
                                            str7 = "";
                                        }
                                        sb8.append(str7);
                                        sb8.append(CommonUtil.encodingUTF8((String) hashMap.get(argument2.key), argument2, company));
                                        sb5.append(sb8.toString());
                                    }
                                }
                            }
                        }
                        StringBuilder sb9 = new StringBuilder(CommonUtil.removeExistEvent(sb5.toString(), new ArrayList(), str2, str3));
                        sb9.append("");
                        Signature signature = company.signature;
                        if (signature != null && signature.paramKey != null) {
                            String signature2 = CommonUtil.getSignature(sContext, sb9.toString());
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append(company.separator);
                            sb10.append(company.signature.paramKey);
                            String str8 = company.equalizer;
                            if (str8 != null) {
                                str4 = str8;
                            }
                            sb10.append(str4);
                            sb10.append(CommonUtil.encodingUTF8(signature2));
                            sb9.append(sb10.toString());
                        }
                        SLog.d("mma_request_url: " + sb9.toString());
                        return sb9.toString();
                    }
                }
                return null;
            }
        }
        return null;
    }

    public synchronized void init(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (!this.isInitExecuted && context != null) {
            doInit(context, str);
        }
    }
}
