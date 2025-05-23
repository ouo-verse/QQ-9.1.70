package com.tencent.mobileqq.pic.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes16.dex */
public interface IPicPreDownload extends IRuntimeService {
    public static final String KEY_ACC_FLOW_PRE_TOTAL = "accFlowPreTotal";
    public static final String KEY_WIFI_HIT_COUNT = "wifiHitCount";
    public static final String KEY_WIFI_MANUL_CLICK_COUNT = "wifiManualClickCount";
    public static final String KEY_WIFI_MISS_COUNT = "wifiMissCount";
    public static final String KEY_WIFI_PRE_DOWN_COUT = "wifiPreDownCount";
    public static final String KEY_XG_FLOW_PRE = "xgFlowPre";
    public static final String KEY_XG_FLOW_WASTE = "xgFlowWaste";
    public static final String KEY_XG_FLOW_WASTE_BALANCE = "xgFlowWasteBalance";
    public static final String KEY_XG_HIT_COUNT = "xgHitCount";
    public static final String KEY_XG_MANUL_CLICK_COUNT = "xgManualClickCount";
    public static final String KEY_XG_MISS_COUNT = "xgMissCount";
    public static final String KEY_XG_PRE_DOWN_COUNT = "xgPreDownCount";
    public static final int TYPE_ALL = 3;
    public static final int TYPE_BIG = 2;
    public static final int TYPE_THUMB = 1;

    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f258626a;

        /* renamed from: b, reason: collision with root package name */
        public long f258627b;

        /* renamed from: c, reason: collision with root package name */
        public long f258628c;

        /* renamed from: d, reason: collision with root package name */
        public long f258629d;

        /* renamed from: e, reason: collision with root package name */
        public long f258630e;

        /* renamed from: f, reason: collision with root package name */
        public long f258631f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    int calcUinType(AppInterface appInterface, int i3, String str);

    void clearAIORequests();

    void commitTrafficPref();

    a getConfigs();

    HashMap<String, String> getDebugPreDownloadReportInfo();

    boolean getPreDownSwitch();

    void increaseTroopCountWhenEnterAIO(String str);

    boolean isScreenOn();

    void payPicFlow(MessageForPic messageForPic);

    void productFromAIO(MessageForPic messageForPic, int i3);

    void productFromAIODynamicPic(MessageForPic messageForPic);

    void productFromMsg(MessageRecord messageRecord, int i3);

    void switchOff();

    void switchOn();

    void updateConfigs(a aVar);
}
