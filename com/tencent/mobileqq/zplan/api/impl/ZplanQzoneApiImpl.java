package com.tencent.mobileqq.zplan.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ipc.af;
import com.tencent.mobileqq.zplan.api.IZplanQzoneApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.IQzoneZplanApi;
import cooperation.qzone.statistic.access.concept.Global;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZplanQzoneApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZplanQzoneApi;", "", "initForQzone", "Lorg/json/JSONObject;", "value", "openQzonePicList", "getValidUrlByInvalidUrl", "onGetValidUrl", "onQzonePicSelected", "", "hasQzoneInit", "Z", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanQzoneApiImpl implements IZplanQzoneApi {
    public static final String KEY_ACTION = "keyAction";
    public static final int REQUEST_FOR_COVER_PICK_QZONE = 1020;
    public static final String TAG = "ZplanQzoneApiImpl";
    public static final String VALUE_ACTION = "actionSelectPicture";
    private boolean hasQzoneInit;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initForQzone$lambda$0(ZplanQzoneApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean qzoneEnvInit = ((IQzoneZplanApi) QRoute.api(IQzoneZplanApi.class)).qzoneEnvInit(MobileQQ.sMobileQQ.peekAppRuntime());
        this$0.hasQzoneInit = qzoneEnvInit;
        QLog.i(TAG, 4, "initForQzone " + qzoneEnvInit);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanQzoneApi
    public void getValidUrlByInvalidUrl(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "getValidUrlByInvalidUrl " + value);
        ((IQzoneZplanApi) QRoute.api(IQzoneZplanApi.class)).sendChangePicUrlRequest(value.optString("invalidUrl"));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanQzoneApi
    public void initForQzone() {
        QLog.i(TAG, 4, "initForQzone hasQzoneInit" + this.hasQzoneInit);
        if (this.hasQzoneInit) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.y
            @Override // java.lang.Runnable
            public final void run() {
                ZplanQzoneApiImpl.initForQzone$lambda$0(ZplanQzoneApiImpl.this);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanQzoneApi
    public void onGetValidUrl(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "onGetValidUrl " + value);
        ((af) k74.i.INSTANCE.a(af.class)).onGetValidUrlOnMain(value);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanQzoneApi
    public void onQzonePicSelected(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "onQzonePicSelected " + value);
        ((af) k74.i.INSTANCE.a(af.class)).onQzonePicSelectedOnMain(value);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanQzoneApi
    public void openQzonePicList(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "openQzonePicList " + value);
        value.optInt("picType");
        Bundle bundle = new Bundle();
        bundle.putInt("key_personal_album_enter_model", 2);
        bundle.putInt("_input_max", 1);
        bundle.putString("key_source", QZoneHelper.QZoneAlbumConstants.VALUE_SOURCE_FROM_XIAOWO);
        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, false);
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        bundle.putString("keyAction", "actionSelectPicture");
        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
        Intent qzoneActivityIntentForName = QZoneHelper.getQzoneActivityIntentForName(userInfo, QZoneHelper.PERSONAL_ALBUM_SELECT);
        qzoneActivityIntentForName.putExtras(bundle);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(Global.getContext(), userInfo.qzone_uin, qzoneActivityIntentForName, 1020);
    }
}
