package com.tencent.qqlive.module.videoreport.report.userprivacy;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTPublicParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes22.dex */
public class UserPrivacyEventReporter implements AppEventReporter.IAppEventListener {
    private static final String EMPTY_FLAG_PREFIX = "dt_inner_agg_";
    private static final int MAX_COUNT = 30;
    private Map<String, UserPrivacyData> mUserPrivacyData;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final UserPrivacyEventReporter INSTANCE;

        static {
            UserPrivacyEventReporter userPrivacyEventReporter = new UserPrivacyEventReporter();
            INSTANCE = userPrivacyEventReporter;
            userPrivacyEventReporter.init();
        }

        InstanceHolder() {
        }
    }

    public static UserPrivacyEventReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        AppEventReporter.getInstance().register(this);
    }

    private void reportAll() {
        for (String str : this.mUserPrivacyData.keySet()) {
            reportUserPrivacy(str, this.mUserPrivacyData.get(str));
        }
        this.mUserPrivacyData.clear();
    }

    private void reportUserPrivacy(String str, UserPrivacyData userPrivacyData) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(DTEventKey.USER_PRIVACY);
        if (!str.startsWith(EMPTY_FLAG_PREFIX)) {
            finalData.put(DTParamKey.REPORT_KEY_AGG_FLAG, str);
        }
        finalData.putAll(userPrivacyData.getInfoMap());
        finalData.put(DTParamKey.REPORT_KEY_INFO_COUNT, Integer.valueOf(userPrivacyData.getCount()));
        finalData.put(DTPublicParamKey.DT_MAIN_LOGIN, userPrivacyData.getMainLogin());
        finalData.put(DTPublicParamKey.DT_ACCOUNT_ID, userPrivacyData.getAccountId());
        FinalDataTarget.handle(null, finalData);
    }

    public void handleUserPrivacy(String str, Map<String, String> map) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str = EMPTY_FLAG_PREFIX + System.currentTimeMillis();
        }
        UserPrivacyData userPrivacyData = this.mUserPrivacyData.get(str);
        if (userPrivacyData != null) {
            userPrivacyData.append(map);
        } else {
            IDTParamProvider dTParamProvider = DTEventDynamicParams.getInstance().getDTParamProvider();
            if (dTParamProvider != null) {
                str2 = dTParamProvider.getAccountID();
                str3 = dTParamProvider.getMainLogin();
            } else {
                str2 = "";
                str3 = "";
            }
            this.mUserPrivacyData.put(str, new UserPrivacyData(str2, str3, map));
        }
        if (this.mUserPrivacyData.keySet().size() > 30) {
            reportAll();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppOut(boolean z16) {
        reportAll();
    }

    UserPrivacyEventReporter() {
        this.mUserPrivacyData = new ConcurrentHashMap();
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppIn() {
    }
}
