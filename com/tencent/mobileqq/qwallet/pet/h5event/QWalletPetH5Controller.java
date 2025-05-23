package com.tencent.mobileqq.qwallet.pet.h5event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pet.QWalletPetFragment;
import com.tencent.mobileqq.qwallet.pet.h5event.PetH5Method;
import com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002-\u000eB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J/\u0010\u000e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "Landroidx/lifecycle/LifecycleObserver;", "", "e", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method$ToH5DispatchEvent;", "dataName", "g", "", "callback", "", "code", "message", "b", "(Ljava/lang/String;ILjava/lang/String;)V", "Lorg/json/JSONObject;", "data", "c", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "d", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "f", "()Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "fragment", "", "value", "Z", "isWebLoadComplete", "()Z", "i", "(Z)V", "isNativeLoadComplete", h.F, "", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller$b;", "Ljava/util/List;", "processors", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletPetH5Controller implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletPetFragment fragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isWebLoadComplete;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNativeLoadComplete;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> processors;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BroadcastReceiver broadcastReceiver;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller$b;", "", "", "methodName", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method;", "h5Method", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        boolean a(@NotNull String methodName, @NotNull PetH5Method h5Method);
    }

    public QWalletPetH5Controller(@NotNull QWalletPetFragment fragment) {
        List<b> listOf;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new b[]{new PetCommonH5ActionProcessor(this), new PetActionProcessor(this)});
        this.processors = listOf;
        this.broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller$broadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @Nullable Intent intent) {
                List list;
                Intrinsics.checkNotNullParameter(context, "context");
                if (intent == null) {
                    return;
                }
                String stringExtra = intent.getStringExtra("qw_extra_json");
                QLog.d("QWallet.Pet.H5Controller", 1, "onReceive " + stringExtra + " " + intent.getStringExtra("qw_js_callback"));
                PetH5Method a16 = PetH5Method.INSTANCE.a(stringExtra);
                if (a16 != null) {
                    list = QWalletPetH5Controller.this.processors;
                    Iterator it = list.iterator();
                    while (it.hasNext() && !((QWalletPetH5Controller.b) it.next()).a(a16.getMethod(), a16)) {
                    }
                    return;
                }
                QLog.w("QWallet.Pet.H5Controller", 1, "parseFrom fail");
            }
        };
        fragment.getLifecycle().addObserver(this);
    }

    public static /* synthetic */ void d(QWalletPetH5Controller qWalletPetH5Controller, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            str2 = null;
        }
        qWalletPetH5Controller.b(str, i3, str2);
    }

    private final void e() {
        if (this.isNativeLoadComplete && this.isWebLoadComplete) {
            g(PetH5Method.ToH5DispatchEvent.NativeSceneLoadComplete);
        }
    }

    public final void b(@Nullable String callback, int code, @Nullable String message) {
        WebViewPlugin webViewPlugin;
        WebViewPluginEngine pluginEngine;
        if (callback == null) {
            return;
        }
        QLog.i("QWallet.Pet.H5Controller", 1, "callJs: " + callback + " " + code + " " + message);
        CustomWebView webView = this.fragment.getWebView();
        if (webView != null && (pluginEngine = webView.getPluginEngine()) != null) {
            webViewPlugin = pluginEngine.m("event");
        } else {
            webViewPlugin = null;
        }
        if (webViewPlugin != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", code);
            jSONObject.put("message", message);
            Unit unit = Unit.INSTANCE;
            webViewPlugin.callJs(callback, jSONObject.toString());
        }
    }

    public final void c(@Nullable String callback, @Nullable JSONObject data) {
        WebViewPlugin webViewPlugin;
        String str;
        WebViewPluginEngine pluginEngine;
        if (callback == null) {
            return;
        }
        QLog.i("QWallet.Pet.H5Controller", 1, "callJs: " + callback + " " + data);
        CustomWebView webView = this.fragment.getWebView();
        if (webView != null && (pluginEngine = webView.getPluginEngine()) != null) {
            webViewPlugin = pluginEngine.m("event");
        } else {
            webViewPlugin = null;
        }
        if (webViewPlugin != null) {
            String[] strArr = new String[1];
            if (data == null || (str = data.toString()) == null) {
                str = "";
            }
            strArr[0] = str;
            webViewPlugin.callJs(callback, strArr);
        }
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final QWalletPetFragment getFragment() {
        return this.fragment;
    }

    public final void g(@NotNull PetH5Method.ToH5DispatchEvent dataName) {
        WebViewPlugin webViewPlugin;
        WebViewPluginEngine pluginEngine;
        Intrinsics.checkNotNullParameter(dataName, "dataName");
        QLog.i("QWallet.Pet.H5Controller", 1, "sendDispatchJSEvent: " + dataName);
        CustomWebView webView = this.fragment.getWebView();
        if (webView != null && (pluginEngine = webView.getPluginEngine()) != null) {
            webViewPlugin = pluginEngine.m("event");
        } else {
            webViewPlugin = null;
        }
        if (webViewPlugin != null) {
            webViewPlugin.dispatchJsEvent("financial-pet-event", new JSONObject().put(AdMetricTag.EVENT_NAME, dataName.name()), null);
        }
    }

    public final void h(boolean z16) {
        this.isNativeLoadComplete = z16;
        e();
    }

    public final void i(boolean z16) {
        this.isWebLoadComplete = z16;
        e();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        QLog.i("QWallet.Pet.H5Controller", 1, "register broadcastReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("qw_action_pet_operate");
        this.fragment.requireContext().getApplicationContext().registerReceiver(this.broadcastReceiver, intentFilter);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        try {
            this.fragment.requireContext().getApplicationContext().unregisterReceiver(this.broadcastReceiver);
        } catch (Exception e16) {
            QLog.d("QWallet.Pet.H5Controller", 2, "unregister catch:", e16);
        }
    }
}
