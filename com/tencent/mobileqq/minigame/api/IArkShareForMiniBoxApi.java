package com.tencent.mobileqq.minigame.api;

import android.app.Activity;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IArkShareForMiniBoxApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getShareMiniAppInfo", "", PushClientConstants.TAG_PKG_NAME, "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/minigame/api/ShareAppInfo;", "Lkotlin/ParameterName;", "name", "shareAppInfo", "prepareArkModel", "miniArkShareModel", "Lcom/tencent/mobileqq/mini/share/MiniArkShareModel;", "onSharePrepareListener", "Lcom/tencent/mobileqq/minigame/api/OnSharePrepareListener;", "shareQQArk", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "ret", "Lorg/json/JSONObject;", "shareType", "", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IArkShareForMiniBoxApi extends QRouteApi {
    void getShareMiniAppInfo(@NotNull String pkgName, @NotNull Function1<? super ShareAppInfo, Unit> callback);

    void prepareArkModel(@NotNull MiniArkShareModel miniArkShareModel, @NotNull OnSharePrepareListener onSharePrepareListener);

    void shareQQArk(@NotNull Activity activity, @NotNull MiniArkShareModel miniArkShareModel, @NotNull JSONObject ret, int shareType);
}
