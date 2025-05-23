package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Map;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes16.dex */
public interface IFeatureRuntimeService extends IRuntimeService {
    public static final String MODULE_ID = "268";
    public static final String PRODUCT_EN = "QQ";
    public static final String PRODUCT_ID = "e59599c0-b795-4136-925d-3a59ce7d09d5";

    boolean clearAllData();

    boolean clearData(String str);

    FeatureSwitch getFeatureSwitch(String str);

    int getInt(String str, int i3);

    JSONObject getJSONObject(String str, String str2);

    String getString(String str, String str2);

    void initSdk();

    Map<String, String> isEnabledWithDataSet(String str, String str2);

    boolean isFeatureSwitchEnable(String str);

    boolean isFeatureSwitchEnable(String str, boolean z16);
}
