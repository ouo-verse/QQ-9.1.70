package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J9\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000f\"\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/gdtad/jsbridge/GdtReportAdJsCallHandler;", "Lcom/tencent/gdtad/jsbridge/GdtJsCallHandler;", "()V", "getExperimentIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "jsonArray", "Lorg/json/JSONArray;", "handleJsCallRequest", "", "webPlugin", "Lcom/tencent/gdtad/jsbridge/GdtAdWebPlugin;", "callback", "args", "", "(Lcom/tencent/gdtad/jsbridge/GdtAdWebPlugin;Ljava/lang/String;[Ljava/lang/String;)Z", "Companion", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GdtReportAdJsCallHandler implements GdtJsCallHandler {

    @NotNull
    private static final String TAG = "GdtReportAdJsCallHandler";

    @NotNull
    private static final String BUSI_TYPE_KEY = IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY;

    @NotNull
    private static String AID_KEY = "aid";

    @NotNull
    private static String AD_POS_TYPE_KEY = "adPosType";

    @NotNull
    private static String ACTION_TYPE_KEY = "actionType";

    @NotNull
    private static String ACTION_TIME_KEY = TianShuMMKVConstant.UserActionKey.ACTION_TIME;

    @NotNull
    private static String FEEDS_INDEX_KEY = TangramHippyConstants.FEEDS_INDEX;

    @NotNull
    private static String EXPERIMENT_ID_KEY = "experimentId";

    @NotNull
    private static String ATTACHMENT_KEY = FileUploadBase.ATTACHMENT;

    @NotNull
    private static String AD_POSID_KEY = "adPosId";

    @NotNull
    private static String TRACE_ID_KEY = "traceId";

    private final ArrayList<String> getExperimentIdList(JSONArray jsonArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(new JSONObject(jsonArray.optString(i3)).optString(EXPERIMENT_ID_KEY, ""));
        }
        return arrayList;
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin webPlugin, @Nullable String callback, @NotNull String... args) {
        Activity activity;
        Intrinsics.checkNotNullParameter(args, "args");
        if (webPlugin != null) {
            activity = webPlugin.getActivity();
        } else {
            activity = null;
        }
        if (webPlugin != null && activity != null) {
            try {
                JSONObject jSONObject = new JSONObject(args[0]);
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray(EXPERIMENT_ID_KEY);
                if (optJSONArray != null) {
                    arrayList = getExperimentIdList(optJSONArray);
                }
                GdtSsoReportParam.Builder busiType = new GdtSsoReportParam.Builder().setBusiType(jSONObject.optInt(BUSI_TYPE_KEY, 15));
                String optString = jSONObject.optString(AID_KEY, "");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(AID_KEY, \"\")");
                GdtSsoReportParam.Builder experimentId = busiType.setAId(optString).setAdPosType(jSONObject.optInt(AD_POS_TYPE_KEY, 0)).setActionType(jSONObject.optInt(ACTION_TYPE_KEY, 0)).setActionTime(jSONObject.optLong(ACTION_TIME_KEY, NetConnInfoCenter.getServerTime())).setFeedsIndex(jSONObject.optInt(FEEDS_INDEX_KEY, 0)).setExperimentId(arrayList);
                String optString2 = jSONObject.optString(ATTACHMENT_KEY, "");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(ATTACHMENT_KEY, \"\")");
                GdtSsoReportParam.Builder attachment = experimentId.setAttachment(optString2);
                String optString3 = jSONObject.optString(AD_POSID_KEY, "");
                Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(AD_POSID_KEY, \"\")");
                GdtSsoReportParam.Builder adPosId = attachment.setAdPosId(optString3);
                String optString4 = jSONObject.optString(TRACE_ID_KEY, "");
                Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(TRACE_ID_KEY, \"\")");
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(adPosId.setTraceId(optString4).build());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "parse json error: " + e16);
            }
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
