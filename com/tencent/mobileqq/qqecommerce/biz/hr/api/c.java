package com.tencent.mobileqq.qqecommerce.biz.hr.api;

import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001d\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00a6\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\bH&J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\u001c\u0010!\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\n\u0010#\u001a\u0004\u0018\u00010\"H&J\u001c\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001c\u0010%\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\u001c\u0010&\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\u001c\u0010'\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\u001c\u0010(\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\bH&J\u001c\u0010)\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\bH&J\u001c\u0010*\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\bH&J\u0014\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\bH&J\u0014\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&J\b\u0010.\u001a\u00020\u0004H&J\b\u0010/\u001a\u00020\u0004H&J\b\u00100\u001a\u00020\u0004H&J\u001c\u00101\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/c;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/g;", "callback", "", "setInvokeCallJSCallback", "Lorg/json/JSONObject;", "jsonObject", "", "callBackId", "invoke", "data", "startVideoPreDownload", "startImagePreDownload", "openVideo", QZoneDTLoginReporter.SCHEMA, "openApp", "handleClick", "c2sReport", "dwellTimeMillisReport", "updateIndepentTabState", "performLikeAnimation", "hideTopicVideoComment", "addFavorite", "getUserInfo", "callBack", "getMotiveAd", "getDeviceInfo", "params", "setTitle", "callbackId", "popBack", "shareVideoWithFriend", "shareVideoWithGPro", "Lfk0/c;", "getViolaInstance", "openLevelDialog", "getUploadVideoPermission", "openAddVideoView", "getUploadingVideoInfo", "pauseUploadingVideo", "cancelUploadingVideo", "resumeUploadingVideo", "errorMsg", "getFailInvokeObj", "getSuccInvokeObj", "cancelVideoPreDownload", "resetSatusBarBlackStyle", "resetSatusBarWhiteStyle", "sendRequest", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface c {
    void addFavorite(@Nullable JSONObject jsonObject);

    void c2sReport(@Nullable JSONObject jsonObject);

    void cancelUploadingVideo(@Nullable JSONObject jsonObject, @Nullable String callbackId);

    void cancelVideoPreDownload();

    void dwellTimeMillisReport(@Nullable JSONObject jsonObject);

    @Nullable
    JSONObject getDeviceInfo();

    @Nullable
    JSONObject getFailInvokeObj(@Nullable String errorMsg);

    void getMotiveAd(@Nullable String callBack, @Nullable JSONObject jsonObject);

    @Nullable
    JSONObject getSuccInvokeObj(@Nullable Object data);

    void getUploadVideoPermission(@Nullable JSONObject jsonObject, @Nullable String callback);

    void getUploadingVideoInfo(@Nullable JSONObject jsonObject, @Nullable String callback);

    @Nullable
    JSONObject getUserInfo();

    @Nullable
    fk0.c getViolaInstance();

    void handleClick(@Nullable JSONObject jsonObject);

    void hideTopicVideoComment(@Nullable JSONObject jsonObject);

    void invoke(@Nullable JSONObject jsonObject, @Nullable String callBackId);

    void openAddVideoView(@Nullable JSONObject jsonObject, @Nullable String callback);

    void openApp(@Nullable String schema);

    void openLevelDialog(@Nullable JSONObject jsonObject, @Nullable String callBackId);

    void openVideo(@Nullable JSONObject jsonObject);

    void pauseUploadingVideo(@Nullable JSONObject jsonObject, @Nullable String callbackId);

    void performLikeAnimation(@Nullable JSONObject jsonObject);

    void popBack(@Nullable String callbackId);

    void resetSatusBarBlackStyle();

    void resetSatusBarWhiteStyle();

    void resumeUploadingVideo(@Nullable JSONObject jsonObject, @Nullable String callbackId);

    void sendRequest(@Nullable JSONObject params, @Nullable String callback);

    void setInvokeCallJSCallback(@Nullable g callback);

    void setTitle(@Nullable JSONObject params, @Nullable String callback);

    void shareVideoWithFriend(@Nullable JSONObject jsonObject, @Nullable String callback);

    void shareVideoWithGPro(@Nullable JSONObject jsonObject, @Nullable String callback);

    void startImagePreDownload(@Nullable JSONObject data);

    void startVideoPreDownload(@Nullable JSONObject data);

    void updateIndepentTabState(@Nullable JSONObject data);
}
