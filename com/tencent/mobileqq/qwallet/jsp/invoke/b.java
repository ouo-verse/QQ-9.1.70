package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerFragment;
import com.tencent.mobileqq.qwallet.hb.aigc.data.OutputImageInfo;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.BuildParams;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J2\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/b;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "retCode", "", "retMsg", "imageUrl", "imagePath", "", "d", "plugin", "Lorg/json/JSONObject;", "jsonData", "jsCallback", "a", "Landroid/content/Intent;", "intent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "b", "Ljava/lang/String;", "currentCallbackId", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends QWInvokeHandler.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentCallbackId;

    private final void d(WebViewPlugin webViewPlugin, int i3, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", i3);
        jSONObject.put("retMsg", str);
        jSONObject.put("imageUrl", str2);
        jSONObject.put("imagePath", str3);
        webViewPlugin.callJs(this.currentCallbackId, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        this.currentCallbackId = jsCallback;
        String bizId = jsonData.optString("bussID");
        if (bizId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d(plugin, -2, "bussID is empty", null, null);
            return;
        }
        BuildParams buildParams = new BuildParams("QCIRCLE_REDPACKET", null, null, null, null, null);
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext c16 = companion.c(buildParams);
        companion.o(c16);
        Config.Companion companion2 = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.f(true);
        aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
        Intrinsics.checkNotNullExpressionValue(bizId, "bizId");
        aVar.g(bizId);
        Config a16 = aVar.a();
        Activity a17 = plugin.mRuntime.a();
        Unit unit = null;
        if (a17 != null) {
            Intent intent = new Intent();
            intent.setClass(a17, QQWinkActivity.class);
            intent.putExtras(UniversalMediaPickerFragment.Companion.b(UniversalMediaPickerFragment.INSTANCE, a16, null, 2, null));
            intent.putExtra("public_fragment_class", QWalletMediaPickerFragment.class.getName());
            intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
            intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, c16.getTraceId());
            intent.putExtra("request_biz_id", bizId);
            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.O.b());
            plugin.startActivityForResult(intent, (byte) 10);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.w("QWalletJsPlugin.qw.invoke", 1, "current context is null");
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.c
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        OutputImageInfo outputImageInfo;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        super.b(plugin, intent, requestCode, resultCode);
        if (requestCode != 10) {
            return;
        }
        QLog.w("QWalletJsPlugin.qw.invoke", 1, "requestCode=" + ((int) requestCode) + ", resultCode=" + resultCode + ", data=" + intent);
        if (intent != null) {
            outputImageInfo = (OutputImageInfo) intent.getParcelableExtra("result_selected_image_info");
        } else {
            outputImageInfo = null;
        }
        if (outputImageInfo == null) {
            d(plugin, 1, MobileQQ.sMobileQQ.getString(R.string.f2176361j), null, null);
        } else {
            d(plugin, 0, null, outputImageInfo.getUploadUrl(), outputImageInfo.getLocalPath());
        }
    }
}
