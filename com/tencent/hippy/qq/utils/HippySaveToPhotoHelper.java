package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002JT\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001728\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001eH\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002JT\u0010%\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u001728\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001eH\u0002J^\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u001728\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001e2\b\u0010(\u001a\u0004\u0018\u00010)JX\u0010*\u001a\u00020\u0015*\u00020+2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001728\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/hippy/qq/utils/HippySaveToPhotoHelper;", "", "()V", "CALLBACK_KEY_RET_CODE", "", "CALLBACK_KEY_RET_MSG", "EVENT_HIPPY_SAVE_TO_PHOTO_PROGRESS_CHANGE", "GAME_CENTER_SP_NAME", "MEDIA_TYPE_PIC", "", "MEDIA_TYPE_VIDEO", "PARAM_KEY_BUSINESS", "PARAM_KEY_TYPE", "PARAM_KEY_URL", "RET_CODE_DOWNLOAD_FAILED", "RET_CODE_INSERT_NO_PERMISSION", "RET_CODE_INSERT_PHOTO_FAILED", "RET_CODE_INSERT_PHOTO_SUCCESS", "RET_CODE_PARAM_INVALID", "TAG", "callbackSaveToPhoto", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "retCode", HippySaveToPhotoHelper.CALLBACK_KEY_RET_MSG, "doSaveToPhoto", "jsonObj", "Lorg/json/JSONObject;", "receiver", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "url", "", "progress", "makePromiseInfo", "savePicOrVideoToPhoto", "saveToPhoto", "jsonParams", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "doReqPermission", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "HippyMediaDownloadStrategy", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippySaveToPhotoHelper {

    @NotNull
    private static final String CALLBACK_KEY_RET_CODE = "retCode";

    @NotNull
    private static final String CALLBACK_KEY_RET_MSG = "retMsg";

    @NotNull
    public static final String EVENT_HIPPY_SAVE_TO_PHOTO_PROGRESS_CHANGE = "hippy_save_to_photo_progress_change";

    @NotNull
    public static final String GAME_CENTER_SP_NAME = "game_center_sp";

    @NotNull
    public static final HippySaveToPhotoHelper INSTANCE = new HippySaveToPhotoHelper();
    private static final int MEDIA_TYPE_PIC = 2;
    private static final int MEDIA_TYPE_VIDEO = 1;

    @NotNull
    private static final String PARAM_KEY_BUSINESS = "business";

    @NotNull
    private static final String PARAM_KEY_TYPE = "type";

    @NotNull
    private static final String PARAM_KEY_URL = "url";
    private static final int RET_CODE_DOWNLOAD_FAILED = -2;
    private static final int RET_CODE_INSERT_NO_PERMISSION = -4;
    private static final int RET_CODE_INSERT_PHOTO_FAILED = -3;
    private static final int RET_CODE_INSERT_PHOTO_SUCCESS = 0;
    private static final int RET_CODE_PARAM_INVALID = -1;

    @NotNull
    private static final String TAG = "HippySaveToPhotoHelper";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/hippy/qq/utils/HippySaveToPhotoHelper$HippyMediaDownloadStrategy;", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "()V", "HIPPY_BUSINESS_KEY", "", "HIPPY_FILE_TYPE_MEDIA_RES", "getBusinessKey", "getDownloadRootPath", "getSP", "Landroid/content/SharedPreferences;", "supportBreakPointDownload", "", "supportUnZipFile", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class HippyMediaDownloadStrategy extends RFWDownloadStrategy {

        @NotNull
        private static final String HIPPY_BUSINESS_KEY = "HippyStrategy";

        @NotNull
        private static final String HIPPY_FILE_TYPE_MEDIA_RES = "photoRes";

        @NotNull
        public static final HippyMediaDownloadStrategy INSTANCE = new HippyMediaDownloadStrategy();

        HippyMediaDownloadStrategy() {
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @NotNull
        public String getBusinessKey() {
            return HIPPY_BUSINESS_KEY;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @NotNull
        public String getDownloadRootPath() {
            return ((IHippySetting) QRoute.api(IHippySetting.class)).getHippyFileByType(HIPPY_FILE_TYPE_MEDIA_RES).getAbsolutePath() + "/";
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @Nullable
        public SharedPreferences getSP() {
            return BaseApplication.getContext().getSharedPreferences("game_center_sp", 4);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportBreakPointDownload() {
            return true;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportUnZipFile() {
            return true;
        }
    }

    HippySaveToPhotoHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackSaveToPhoto(Promise promise, int retCode, String retMsg) {
        String makePromiseInfo = makePromiseInfo(retCode, retMsg);
        if (promise != null) {
            promise.resolve(makePromiseInfo);
        }
        QLog.i(TAG, 1, "[callbackSaveToPhoto] promiseInfo:" + makePromiseInfo);
    }

    private final void doReqPermission(QQPermission qQPermission, final JSONObject jSONObject, final Promise promise, final Function2<? super String, ? super Float, Unit> function2) {
        QLog.i(TAG, 1, "[saveToPhoto] no write permission now,just request");
        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new QQPermission.BasePermissionsListener() { // from class: com.tencent.hippy.qq.utils.HippySaveToPhotoHelper$doReqPermission$1
            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                QLog.i("HippySaveToPhotoHelper", 1, "[saveToPhoto] onAllGranted");
                HippySaveToPhotoHelper.INSTANCE.doSaveToPhoto(JSONObject.this, promise, function2);
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
                super.onDenied(permissions, results);
                HippySaveToPhotoHelper.INSTANCE.callbackSaveToPhoto(promise, -4, "permission is denied");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSaveToPhoto(JSONObject jsonObj, Promise promise, Function2<? super String, ? super Float, Unit> receiver) {
        boolean z16;
        String url = jsonObj.optString("url");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            callbackSaveToPhoto(promise, -1, "url is empty");
            return;
        }
        int optInt = jsonObj.optInt("type");
        if (optInt != 1 && optInt != 2) {
            callbackSaveToPhoto(promise, -1, "not support type:" + optInt);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        savePicOrVideoToPhoto(url, promise, receiver);
    }

    private final String makePromiseInfo(int retCode, String retMsg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", retCode);
        jSONObject.put(CALLBACK_KEY_RET_MSG, retMsg);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026Msg)\n        }.toString()");
        return jSONObject2;
    }

    private final void savePicOrVideoToPhoto(String url, Promise promise, Function2<? super String, ? super Float, Unit> receiver) {
        RFWDownloaderFactory.getDownloader(HippyMediaDownloadStrategy.INSTANCE).download(url, new HippySaveToPhotoHelper$savePicOrVideoToPhoto$1$1(promise, receiver, url));
    }

    public final void saveToPhoto(@Nullable String jsonParams, @Nullable Promise promise, @Nullable Function2<? super String, ? super Float, Unit> receiver, @Nullable Activity activity) {
        boolean z16 = true;
        QLog.i(TAG, 1, "[saveToPhoto] jsonParams:" + jsonParams);
        if (activity != null && !activity.isFinishing()) {
            if (jsonParams != null && jsonParams.length() != 0) {
                z16 = false;
            }
            if (z16) {
                callbackSaveToPhoto(promise, -1, "jsonParams is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonParams);
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_GAME_CENTER, QQPermissionConstants.Business.SCENE.GAME_CENTER_SCENE));
                Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026E\n            )\n        )");
                if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                    if (!Intrinsics.areEqual(jSONObject.optString("business"), QQPermissionConstants.Business.ID.QQ_BUSINESS_GAME_CENTER)) {
                        INSTANCE.callbackSaveToPhoto(promise, -4, "no storage permission");
                        return;
                    } else {
                        INSTANCE.doReqPermission(qQPermission, jSONObject, promise, receiver);
                        return;
                    }
                }
                INSTANCE.doSaveToPhoto(jSONObject, promise, receiver);
                return;
            } catch (Exception unused) {
                callbackSaveToPhoto(promise, -1, "json parse failed");
                return;
            }
        }
        callbackSaveToPhoto(promise, -1, "activity is finish");
    }
}
