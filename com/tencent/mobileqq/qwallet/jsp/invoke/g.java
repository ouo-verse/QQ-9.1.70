package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/g;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "jsCallback", "", "a", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "Ljava/lang/String;", "currentJsCallback", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g extends QWInvokeHandler.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentJsCallback;

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Activity a16 = plugin.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            this.currentJsCallback = jsCallback;
            int optInt = jsonData.optInt("skinId");
            Class<? extends Fragment> skinPreviewEntryFragment = ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getSkinPreviewEntryFragment();
            Intent intent = new Intent(a16, (Class<?>) QPublicTransFragmentActivity.class);
            intent.putExtra("skin_id", optInt);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("public_fragment_class", skinPreviewEntryFragment.getName());
            plugin.startActivityForResult(intent, (byte) 101);
            return;
        }
        QLog.w("QWalletSkinPreviewProcessor", 1, "error, activity is finishing");
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.c
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        String str;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        super.b(plugin, intent, requestCode, resultCode);
        if (requestCode == 101) {
            JSONObject jSONObject = new JSONObject();
            int i3 = -2;
            if (intent != null) {
                i3 = intent.getIntExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_RESULT_CODE, -2);
            }
            if (intent == null || (str = intent.getStringExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_RESULT_MSG)) == null) {
                str = "";
            }
            if (intent != null) {
                z16 = intent.getBooleanExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_IS_SHARE, false);
            } else {
                z16 = false;
            }
            if (intent != null) {
                z17 = intent.getBooleanExtra(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_IS_GET, false);
            } else {
                z17 = false;
            }
            jSONObject.put("code", i3);
            jSONObject.put("msg", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("isShare", z16);
            jSONObject2.put("isGet", z17);
            Unit unit = Unit.INSTANCE;
            jSONObject.put("data", jSONObject2);
            plugin.callJs(this.currentJsCallback, jSONObject.toString());
        }
    }
}
