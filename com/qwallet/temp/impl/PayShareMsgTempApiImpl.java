package com.qwallet.temp.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.qwallet.temp.IPayShareMsgTempApi;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.jsp.ShareMsgImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J,\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J0\u0010#\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019H\u0016\u00a8\u0006*"}, d2 = {"Lcom/qwallet/temp/impl/PayShareMsgTempApiImpl;", "Lcom/qwallet/temp/IPayShareMsgTempApi;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/qwallet/temp/IPayShareMsgTempApi$a;", "listener", "", "createShareMsgImpl", "shareMsgImpl", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "", "initWebInterface", "Lcom/tencent/mobileqq/webview/swift/y;", "baseInterface", "onShareMsgImplSetWebUiInterface", "onShareMsgImplDestroy", "Lcom/qwallet/temp/IPayShareMsgTempApi$b;", "shareArkParam", "Lorg/json/JSONObject;", "buildArkMsgParamJSON", "", "forwardType", "dataObj", "", "handleWhiteList", "shareArkMsgToQQ", "requestCode", "", "forwardTitle", "forwardDialogText", "forwardMsgToQQ", "shareSupportType", "convertShareType", "<init>", "()V", "Companion", "a", "qqpay_temp_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class PayShareMsgTempApiImpl implements IPayShareMsgTempApi {
    public static final int FLAG_SHARE_TYPE_DISCUSS = 8;
    public static final int FLAG_SHARE_TYPE_FRIEND = 1;
    public static final int FLAG_SHARE_TYPE_TROOP = 4;
    private static final String TAG = "PayShareMsgTempApiImpl";

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/qwallet/temp/impl/PayShareMsgTempApiImpl$b", "Lcom/tencent/mobileqq/jsp/ShareMsgImpl$b;", "", "callbackId", "result", "", "onSharMsgcallback", "Landroid/content/Intent;", "intent", "", "requestCode", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "qqpay_temp_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements ShareMsgImpl.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPayShareMsgTempApi.a f41761a;

        b(IPayShareMsgTempApi.a aVar) {
            this.f41761a = aVar;
        }

        @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
        public void onSharMsgcallback(String callbackId, String result) {
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            Intrinsics.checkNotNullParameter(result, "result");
            this.f41761a.a(callbackId, result);
            QLog.i(PayShareMsgTempApiImpl.TAG, 2, "onSharMsgcallback callbackId:" + callbackId + ",result:" + result);
        }

        @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
        public void startActivityForResult(Intent intent, byte requestCode) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.f41761a.startActivityForResult(intent, requestCode);
        }
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public JSONObject buildArkMsgParamJSON(IPayShareMsgTempApi.ShareArkParam shareArkParam) {
        Intrinsics.checkNotNullParameter(shareArkParam, "shareArkParam");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appName", shareArkParam.getApp());
        jSONObject.put(QQCustomArkDialogUtil.APP_VIEW, shareArkParam.getView());
        jSONObject.put(QQCustomArkDialogUtil.META_DATA, shareArkParam.getMeta());
        jSONObject.put(QQCustomArkDialogUtil.APP_MIN_VERSION, shareArkParam.getVer());
        jSONObject.put("appConfig", shareArkParam.getConfig());
        jSONObject.put("appDesc", shareArkParam.getDesc());
        jSONObject.put(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, shareArkParam.getPrompt());
        jSONObject.put(AppConstants.Key.SHARE_REQ_QQ_TYPE, shareArkParam.getShareSupportType());
        return jSONObject;
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public int convertShareType(int shareSupportType) {
        QLog.i(TAG, 1, "[convertShareType] shareSupportType:" + shareSupportType);
        if (shareSupportType == 0) {
            return 13;
        }
        int i3 = (shareSupportType & 1) == 0 ? 0 : 1;
        if ((shareSupportType & 2) != 0) {
            i3 |= 4;
        }
        return (shareSupportType & 4) != 0 ? i3 | 8 : i3;
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public Object createShareMsgImpl(Context context, Activity activity, AppInterface appInterface, IPayShareMsgTempApi.a listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new ShareMsgImpl(context, activity, appInterface, new b(listener));
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public void forwardMsgToQQ(Activity activity, int requestCode, int forwardType, String forwardTitle, String forwardDialogText) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(forwardTitle, "forwardTitle");
        Intrinsics.checkNotNullParameter(forwardDialogText, "forwardDialogText");
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ForwardFriendListActivity.class);
        intent.putExtra("extra_choose_friend", 5);
        intent.putExtra("only_single_selection", true);
        intent.putExtra("call_by_forward", true);
        intent.putExtra("forward_type", forwardType);
        intent.putExtra("extra_forward_title", forwardTitle);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, forwardDialogText);
        intent.putExtra("share_not_send_by_client", true);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public void initWebInterface(Object shareMsgImpl, WebViewPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        if (shareMsgImpl instanceof ShareMsgImpl) {
            ((ShareMsgImpl) shareMsgImpl).e(plugin);
        }
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public void onShareMsgImplDestroy(Object shareMsgImpl) {
        if (shareMsgImpl instanceof ShareMsgImpl) {
            ((ShareMsgImpl) shareMsgImpl).g();
        }
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public void onShareMsgImplSetWebUiInterface(Object shareMsgImpl, y baseInterface) {
        if (shareMsgImpl instanceof ShareMsgImpl) {
            ((ShareMsgImpl) shareMsgImpl).l(baseInterface);
        }
    }

    @Override // com.qwallet.temp.IPayShareMsgTempApi
    public void shareArkMsgToQQ(int forwardType, Object shareMsgImpl, JSONObject dataObj, boolean handleWhiteList) {
        if (shareMsgImpl instanceof ShareMsgImpl) {
            ShareMsgImpl shareMsgImpl2 = (ShareMsgImpl) shareMsgImpl;
            if (dataObj == null) {
                dataObj = new JSONObject();
            }
            shareMsgImpl2.p(dataObj.toString(), false, forwardType);
        }
    }
}
