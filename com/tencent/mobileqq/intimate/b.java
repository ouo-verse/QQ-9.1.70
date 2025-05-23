package com.tencent.mobileqq.intimate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friends.intimate.IntimateDisbandLoveRelationResponseEvent;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends WebViewPlugin implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private String f238535d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238536d;

        a(String str) {
            this.f238536d = str;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("IntimatePlugin", 2, "[handleDisconnectRelation] --> not lover relation, response errorCode:" + i3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (i3 == 0 && bArr != null) {
                    jSONObject.put("status", 1);
                } else {
                    jSONObject.put("status", 0);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            b.this.callJs(this.f238536d, jSONObject.toString());
        }
    }

    private void q(final BaseApplication baseApplication, final int i3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.intimate.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.u(baseApplication, i3);
                }
            }, 64, null, true);
        } else {
            u(baseApplication, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007a A[Catch: JSONException -> 0x0095, TryCatch #0 {JSONException -> 0x0095, blocks: (B:10:0x0014, B:13:0x0025, B:16:0x0030, B:17:0x0046, B:22:0x007a, B:24:0x0085, B:26:0x008e, B:30:0x0040), top: B:9:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085 A[Catch: JSONException -> 0x0095, TryCatch #0 {JSONException -> 0x0095, blocks: (B:10:0x0014, B:13:0x0025, B:16:0x0030, B:17:0x0046, B:22:0x007a, B:24:0x0085, B:26:0x008e, B:30:0x0040), top: B:9:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t(AppRuntime appRuntime, String... strArr) {
        long j3;
        if (strArr == null || strArr.length <= 0) {
            QLog.e("IntimatePlugin", 1, "[handleDisconnectRelation] args is null or empty");
            return;
        }
        if (appRuntime == null) {
            QLog.e("IntimatePlugin", 1, "[handleDisconnectRelation] app is null");
            return;
        }
        try {
            int i3 = 0;
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("callback");
            try {
                j3 = Long.parseLong(jSONObject.optString("friUin"));
                try {
                    i3 = Integer.parseInt(jSONObject.optString("irType"));
                } catch (NumberFormatException e16) {
                    e = e16;
                    QLog.e("IntimatePlugin", 1, "[handleDisconnectRelation] type coversion error:", e);
                    long longAccountUin = appRuntime.getLongAccountUin();
                    QLog.d("IntimatePlugin", 1, "[handleDisconnectRelation] intimateType = " + i3 + ", friendUin = " + j3 + ", curUin = " + longAccountUin);
                    if (j3 > 0) {
                        if (i3 != 1) {
                        }
                    }
                    QLog.e("IntimatePlugin", 1, "[handleDisconnectRelation] irType or friUin is error");
                }
            } catch (NumberFormatException e17) {
                e = e17;
                j3 = 0;
            }
            long longAccountUin2 = appRuntime.getLongAccountUin();
            QLog.d("IntimatePlugin", 1, "[handleDisconnectRelation] intimateType = " + i3 + ", friendUin = " + j3 + ", curUin = " + longAccountUin2);
            if (j3 > 0 && i3 > 0) {
                if (i3 != 1) {
                    this.f238535d = optString;
                    new cooperation.vip.manager.c().f(longAccountUin2, j3);
                    return;
                } else {
                    com.tencent.mobileqq.friends.intimate.a.a(appRuntime, j3, i3, new a(optString));
                    return;
                }
            }
            QLog.e("IntimatePlugin", 1, "[handleDisconnectRelation] irType or friUin is error");
        } catch (JSONException e18) {
            QLog.e("IntimatePlugin", 1, "[handleDisconnectRelation] error:", e18);
        }
    }

    private void v(String str, String str2) {
        try {
            boolean optBoolean = new JSONObject(str2).optBoolean("statue", true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_web_mutual_mark_switch_status", optBoolean);
            QLog.i("IntimatePlugin", 1, "change mutualmark switch, method = " + str + ", statue = " + optBoolean);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "IntimateQIPCModule", "key_web_change_switch_request", bundle);
        } catch (Exception e16) {
            QLog.e("IntimatePlugin", 1, "change mutualmark switch exception e = ", e16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(IntimateDisbandLoveRelationResponseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "emojiEggSetting";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("IntimatePlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if ("emojiEggSetting".equals(str2)) {
            if ("showVC".equals(str3)) {
                try {
                    int optInt = new JSONObject(strArr[0]).optInt("entry");
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_web_jump_show_reactive_entry_value", optInt);
                    if (QLog.isColorLevel()) {
                        QLog.i("IntimatePlugin", 2, "showVC, method = " + str3 + ", entry = " + optInt);
                    }
                    BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "IntimateQIPCModule", "key_web_jump_show_reactive_request", bundle);
                } catch (Exception e16) {
                    QLog.e("IntimatePlugin", 1, "openConfessAIO exception e = ", e16);
                    return false;
                }
            } else {
                if (!"changeSwitch".equals(str3)) {
                    return false;
                }
                v(str3, strArr[0]);
            }
        } else if ("interactionScore".equals(str2)) {
            if ("gotoChat".equals(str3)) {
                r(1, strArr);
            } else if ("gotoCall".equals(str3)) {
                r(2, strArr);
            } else if ("saveConnectionsSwitch".equals(str3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("IntimatePlugin", 2, "IntimatePlugin: METHOD_SAVE_CONNECTIONS_SWITCH called");
                }
                try {
                    AppInterface b16 = this.mRuntime.b();
                    if (b16 != null) {
                        q(b16.getApp(), new JSONObject(strArr[0]).optInt("flag"));
                    }
                } catch (Exception unused) {
                    QLog.e("IntimatePlugin", 2, "IntimatePlugin: METHOD_SAVE_CONNECTIONS_SWITCH called exception");
                }
            } else if ("disconnectRelation".equals(str3)) {
                t(this.mRuntime.c(), strArr);
            }
        } else {
            return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof IntimateDisbandLoveRelationResponseEvent) {
            s((IntimateDisbandLoveRelationResponseEvent) simpleBaseEvent);
        }
    }

    private void r(int i3, String... strArr) {
        try {
            Activity a16 = this.mRuntime.a();
            String optString = new JSONObject(strArr[0]).optString("frd_uin");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a16), new int[]{2});
            m3.putExtra("uin", optString);
            if (i3 == 1) {
                m3.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
            } else if (i3 == 2) {
                m3.putExtra("KEY_SHOULD_SHOW_PLUS_PANEL", true);
            }
            m3.putExtra("uintype", 0);
            a16.startActivity(m3);
        } catch (Exception e16) {
            QLog.e("IntimatePlugin", 1, "gotoC2C exception e = ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void u(BaseApplication baseApplication, int i3) {
        if (baseApplication == null) {
            QLog.e("IntimatePlugin", 1, "writeSwitchInternal fail, app is null");
            return;
        }
        SharedPreferences sharedPreferences = baseApplication.getSharedPreferences("mayknow_connections_switch", 4);
        if (sharedPreferences == null) {
            QLog.e("IntimatePlugin", 1, "writeSwitchInternal fail, sharedPreferences is null");
        } else {
            sharedPreferences.edit().putInt("key_mayknow_connections_switch", i3).apply();
        }
    }

    private void s(IntimateDisbandLoveRelationResponseEvent intimateDisbandLoveRelationResponseEvent) {
        if (intimateDisbandLoveRelationResponseEvent == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f238535d)) {
            QLog.e("IntimatePlugin", 1, "[handleDisbandLoveRelationResponseEvent] mDisbandLoveCallBack is empty");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IntimatePlugin", 2, "[handleDisbandLoveRelationResponseEvent] isSuccess = " + intimateDisbandLoveRelationResponseEvent.isSuccess() + ", retCode = " + intimateDisbandLoveRelationResponseEvent.getRetCode() + ", errMsg = " + intimateDisbandLoveRelationResponseEvent.getErrMsg() + ", friUin = " + intimateDisbandLoveRelationResponseEvent.getFriUin() + ", callBack = " + this.f238535d);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (intimateDisbandLoveRelationResponseEvent.isSuccess()) {
                jSONObject.put("status", 1);
            } else {
                jSONObject.put("status", 0);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        callJs(this.f238535d, jSONObject.toString());
        this.f238535d = "";
    }
}
