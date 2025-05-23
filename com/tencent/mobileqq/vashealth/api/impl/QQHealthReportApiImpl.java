package com.tencent.mobileqq.vashealth.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthReportApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R6\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthReportApiImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthReportApi;", "", "extString", "getMsgType", "Lcom/tencent/common/app/AppInterface;", "app", "", "hasUnreadMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "mr", "", "reportHealthMessageExpose", "reportHealthMessageClick", "reportHealthMessageArrive", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQHealthReportApiImpl implements IQQHealthReportApi {

    @NotNull
    public static final String APP_KEY = "0DOU0D6PDI4ITQXP";

    @NotNull
    public static final String ARRIVE_EVENT = "qqsport_message_arrive";

    @NotNull
    public static final String AUTH_BUTTON_CLICK = "and_empower_button_click";

    @NotNull
    public static final String AUTH_BUTTON_REJECT_CLICK = "and_reject_empower_button_click";

    @NotNull
    public static final String AUTH_WINDOW_AUTH_EXPOSE = "and_empower_dialog_expose";

    @NotNull
    public static final String CLICK_EVENT = "qqsport_message_click";

    @NotNull
    public static final String EXPOSE_EVENT = "qqsport_message_expose";

    @NotNull
    public static final String MSG_ARRIVE_KEY = "013";

    @NotNull
    public static final String MSG_CLICK_KEY = "002";

    @NotNull
    public static final String MSG_EXPOSE_KEY = "001";

    @NotNull
    public static final String MSG_READ_KEY = "0";

    @NotNull
    public static final String MSG_TYPE_KEY = "msg_type";

    @NotNull
    public static final String MSG_UNREAD_KEY = "1";

    @NotNull
    public static final String OAC_CLIENT_PARAMS_SPORTS_EXTRA = "sports_extra";

    @NotNull
    public static final String REPORT_KEY_BYTES_OAC_MSG_EXTEND = "report_key_bytes_oac_msg_extend";

    @NotNull
    public static final String TAG = "QQHealthReport";

    @NotNull
    public static final String UNKNOWN_MSG_TYPE = "-1";

    @Nullable
    private HashMap<String, String> reportParams;

    public QQHealthReportApiImpl() {
        if (this.reportParams == null) {
            this.reportParams = com.tencent.mobileqq.vashealth.a.f312206a.a();
        }
    }

    private final String getMsgType(String extString) {
        try {
            String optString = new JSONObject(new JSONObject(new JSONObject(extString).optString(REPORT_KEY_BYTES_OAC_MSG_EXTEND, "")).optString(OAC_CLIENT_PARAMS_SPORTS_EXTRA)).optString(MSG_TYPE_KEY, "-1");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(MSG_TYPE_KEY, msgType)");
            return optString;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "get msgType failed, error is " + e16);
            return "-1";
        }
    }

    private final boolean hasUnreadMsg(AppInterface app) {
        if (((IConversationFacade) app.getRuntimeService(IConversationFacade.class, ProcessConstant.MULTI)).getUnreadCount(IPublicAccountUtil.UIN_FOR_HEALTH, 1008) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthReportApi
    public void reportHealthMessageArrive(@Nullable MessageRecord mr5) {
        String msgType;
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report message arrive, mr is " + mr5);
        }
        if (mr5 != null) {
            HashMap<String, String> hashMap = this.reportParams;
            if (hashMap == null) {
                hashMap = com.tencent.mobileqq.vashealth.a.f312206a.a();
            }
            if (hashMap != null) {
                hashMap.put("act_id", MSG_ARRIVE_KEY);
            }
            if (hashMap != null) {
                if (TextUtils.isEmpty(mr5.extStr)) {
                    msgType = "-1";
                } else {
                    String str = mr5.extStr;
                    Intrinsics.checkNotNullExpressionValue(str, "mr.extStr");
                    msgType = getMsgType(str);
                }
                hashMap.put("module_id", msgType);
            }
            QQBeaconReport.reportWithAppKey(APP_KEY, VasUtil.getCurrentUin(), ARRIVE_EVENT, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthReportApi
    public void reportHealthMessageClick(@NotNull AppInterface app, @Nullable MessageRecord mr5) {
        String str;
        String msgType;
        Intrinsics.checkNotNullParameter(app, "app");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report message click, mr is " + mr5);
        }
        if (mr5 != null) {
            HashMap<String, String> hashMap = this.reportParams;
            if (hashMap == null) {
                hashMap = com.tencent.mobileqq.vashealth.a.f312206a.a();
            }
            if (hashMap != null) {
                hashMap.put("act_id", MSG_CLICK_KEY);
            }
            if (hashMap != null) {
                if (TextUtils.isEmpty(mr5.extStr)) {
                    msgType = "-1";
                } else {
                    String str2 = mr5.extStr;
                    Intrinsics.checkNotNullExpressionValue(str2, "mr.extStr");
                    msgType = getMsgType(str2);
                }
                hashMap.put("module_id", msgType);
            }
            if (hashMap != null) {
                if (hasUnreadMsg(app)) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("ext_3", str);
            }
            QQBeaconReport.reportWithAppKey(APP_KEY, VasUtil.getCurrentUin(), CLICK_EVENT, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthReportApi
    public void reportHealthMessageExpose(@NotNull AppInterface app, @Nullable MessageRecord mr5) {
        String str;
        String msgType;
        Intrinsics.checkNotNullParameter(app, "app");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report message expose, mr is " + mr5);
        }
        if (mr5 != null) {
            HashMap<String, String> hashMap = this.reportParams;
            if (hashMap == null) {
                hashMap = com.tencent.mobileqq.vashealth.a.f312206a.a();
            }
            if (hashMap != null) {
                hashMap.put("act_id", MSG_EXPOSE_KEY);
            }
            if (hashMap != null) {
                if (TextUtils.isEmpty(mr5.extStr)) {
                    msgType = "-1";
                } else {
                    String str2 = mr5.extStr;
                    Intrinsics.checkNotNullExpressionValue(str2, "mr.extStr");
                    msgType = getMsgType(str2);
                }
                hashMap.put("module_id", msgType);
            }
            if (hashMap != null) {
                if (hasUnreadMsg(app)) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("ext_3", str);
            }
            QQBeaconReport.reportWithAppKey(APP_KEY, VasUtil.getCurrentUin(), EXPOSE_EVENT, hashMap);
        }
    }
}
