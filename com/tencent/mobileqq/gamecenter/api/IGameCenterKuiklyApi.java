package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH&J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IGameCenterKuiklyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalModule", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QZoneDTLoginReporter.SCHEMA, "openKuiklyFloatDialog", "Lorg/json/JSONObject;", "dataObj", "", "checkIfOpenFloatInCurProcess", QQPermissionConstants.Permission.AUIDO_GROUP, "removeRecordKey", "pushMsg", "onMsgForwardToFrontReceived", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterKuiklyApi extends QRouteApi {
    boolean checkIfOpenFloatInCurProcess(@Nullable String schema);

    void onMsgForwardToFrontReceived(@Nullable String pushMsg);

    void openKuiklyFloatDialog(@Nullable Activity activity, @Nullable String schema);

    void openKuiklyFloatDialog(@Nullable Activity activity, @Nullable JSONObject dataObj);

    void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport);

    void removeRecordKey(@NotNull String record);
}
