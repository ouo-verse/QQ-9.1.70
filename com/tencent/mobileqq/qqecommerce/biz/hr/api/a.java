package com.tencent.mobileqq.qqecommerce.biz.hr.api;

import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u001d\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001d\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u001d\u0010\u0015\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001d\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010\u001b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u001d\u0010\u001d\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0003J\u001d\u0010\u001e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001d\u0010!\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010\"\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u001d\u0010#\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010$\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010%\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010&\u001a\u00020\u0004H\u0096\u0001J\t\u0010'\u001a\u00020\u0004H\u0096\u0001J\u001d\u0010(\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001d\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010,\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010+H\u0096\u0001J\u001d\u0010-\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001d\u0010.\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001d\u0010/\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u00100\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u00101\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u00102\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0001\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/c;", "Lorg/json/JSONObject;", "jsonObject", "", "addFavorite", "c2sReport", "", "callbackId", "cancelUploadingVideo", "cancelVideoPreDownload", "dwellTimeMillisReport", "getDeviceInfo", "errorMsg", "getFailInvokeObj", "callBack", "getMotiveAd", "", "data", "getSuccInvokeObj", "callback", "getUploadVideoPermission", "getUploadingVideoInfo", "getUserInfo", "Lfk0/c;", "getViolaInstance", "handleClick", "hideTopicVideoComment", "callBackId", "invoke", "openAddVideoView", QZoneDTLoginReporter.SCHEMA, "openApp", "openLevelDialog", "openVideo", "pauseUploadingVideo", "performLikeAnimation", "popBack", "resetSatusBarBlackStyle", "resetSatusBarWhiteStyle", "resumeUploadingVideo", "params", "sendRequest", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/g;", "setInvokeCallJSCallback", "setTitle", "shareVideoWithFriend", "shareVideoWithGPro", "startImagePreDownload", "startVideoPreDownload", "updateIndepentTabState", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class a implements c {
    private final /* synthetic */ c $$delegate_0 = ((IBridgeModuleProxyFactory) QRoute.api(IBridgeModuleProxyFactory.class)).create();

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void addFavorite(@Nullable JSONObject jsonObject) {
        this.$$delegate_0.addFavorite(jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void c2sReport(@Nullable JSONObject jsonObject) {
        this.$$delegate_0.c2sReport(jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void cancelUploadingVideo(@Nullable JSONObject jsonObject, @Nullable String callbackId) {
        this.$$delegate_0.cancelUploadingVideo(jsonObject, callbackId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void cancelVideoPreDownload() {
        this.$$delegate_0.cancelVideoPreDownload();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void dwellTimeMillisReport(@Nullable JSONObject jsonObject) {
        this.$$delegate_0.dwellTimeMillisReport(jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @Nullable
    public JSONObject getDeviceInfo() {
        return this.$$delegate_0.getDeviceInfo();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @Nullable
    public JSONObject getFailInvokeObj(@Nullable String errorMsg) {
        return this.$$delegate_0.getFailInvokeObj(errorMsg);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void getMotiveAd(@Nullable String callBack, @Nullable JSONObject jsonObject) {
        this.$$delegate_0.getMotiveAd(callBack, jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @Nullable
    public JSONObject getSuccInvokeObj(@Nullable Object data) {
        return this.$$delegate_0.getSuccInvokeObj(data);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void getUploadVideoPermission(@Nullable JSONObject jsonObject, @Nullable String callback) {
        this.$$delegate_0.getUploadVideoPermission(jsonObject, callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void getUploadingVideoInfo(@Nullable JSONObject jsonObject, @Nullable String callback) {
        this.$$delegate_0.getUploadingVideoInfo(jsonObject, callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @Nullable
    public JSONObject getUserInfo() {
        return this.$$delegate_0.getUserInfo();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @Nullable
    public fk0.c getViolaInstance() {
        return this.$$delegate_0.getViolaInstance();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void handleClick(@Nullable JSONObject jsonObject) {
        this.$$delegate_0.handleClick(jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void hideTopicVideoComment(@Nullable JSONObject jsonObject) {
        this.$$delegate_0.hideTopicVideoComment(jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void invoke(@Nullable JSONObject jsonObject, @Nullable String callBackId) {
        this.$$delegate_0.invoke(jsonObject, callBackId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void openAddVideoView(@Nullable JSONObject jsonObject, @Nullable String callback) {
        this.$$delegate_0.openAddVideoView(jsonObject, callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void openApp(@Nullable String schema) {
        this.$$delegate_0.openApp(schema);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void openLevelDialog(@Nullable JSONObject jsonObject, @Nullable String callBackId) {
        this.$$delegate_0.openLevelDialog(jsonObject, callBackId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void openVideo(@Nullable JSONObject jsonObject) {
        this.$$delegate_0.openVideo(jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void pauseUploadingVideo(@Nullable JSONObject jsonObject, @Nullable String callbackId) {
        this.$$delegate_0.pauseUploadingVideo(jsonObject, callbackId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void performLikeAnimation(@Nullable JSONObject jsonObject) {
        this.$$delegate_0.performLikeAnimation(jsonObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c, com.tencent.mobileqq.qqecommerce.biz.hr.api.g
    public void popBack(@Nullable String callbackId) {
        this.$$delegate_0.popBack(callbackId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void resetSatusBarBlackStyle() {
        this.$$delegate_0.resetSatusBarBlackStyle();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void resetSatusBarWhiteStyle() {
        this.$$delegate_0.resetSatusBarWhiteStyle();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void resumeUploadingVideo(@Nullable JSONObject jsonObject, @Nullable String callbackId) {
        this.$$delegate_0.resumeUploadingVideo(jsonObject, callbackId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void sendRequest(@Nullable JSONObject params, @Nullable String callback) {
        this.$$delegate_0.sendRequest(params, callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void setInvokeCallJSCallback(@Nullable g callback) {
        this.$$delegate_0.setInvokeCallJSCallback(callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void setTitle(@Nullable JSONObject params, @Nullable String callback) {
        this.$$delegate_0.setTitle(params, callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void shareVideoWithFriend(@Nullable JSONObject jsonObject, @Nullable String callback) {
        this.$$delegate_0.shareVideoWithFriend(jsonObject, callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void shareVideoWithGPro(@Nullable JSONObject jsonObject, @Nullable String callback) {
        this.$$delegate_0.shareVideoWithGPro(jsonObject, callback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void startImagePreDownload(@Nullable JSONObject data) {
        this.$$delegate_0.startImagePreDownload(data);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void startVideoPreDownload(@Nullable JSONObject data) {
        this.$$delegate_0.startVideoPreDownload(data);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void updateIndepentTabState(@Nullable JSONObject data) {
        this.$$delegate_0.updateIndepentTabState(data);
    }
}
