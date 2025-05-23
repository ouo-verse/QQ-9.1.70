package com.tencent.mobileqq.guild.webview;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private BaseQQAppInterface f235749d;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        boolean a(g gVar, String str, String str2, String str3, String... strArr);
    }

    private boolean q(String str) {
        if (com.tencent.mobileqq.guild.share.shorturl.a.m(str) && !r()) {
            Activity a16 = this.mRuntime.a();
            Bundle bundle = new Bundle();
            String stringExtra = a16.getIntent().getStringExtra("SourceActivityName");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("JumpActivity")) {
                bundle.putBoolean("OPEN_FROM_OUTSIDE", true);
            }
            GuildJumpUtil.i(a16, str, bundle);
            return true;
        }
        return false;
    }

    public void callbackError(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 1);
            jSONObject.put("msg", str2);
            super.callJs(str + "&&" + str + "(" + jSONObject + ");");
        } catch (Exception e16) {
            QLog.e("Guild.jump.JS.QQGuildJsPlugin", 1, e16.getMessage());
        }
        if (QLog.isColorLevel()) {
            QLog.e("Guild.jump.JS.QQGuildJsPlugin", 2, "callbackId->" + str + " errorMsg: " + str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "guild";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.jump.JS.QQGuildJsPlugin", 2, "getWebViewEventByNameSpace-> ", str);
            return 0L;
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.jump.JS.QQGuildJsPlugin", 2, "getWebViewEventByNameSpace-> ", str);
            return 4294967295L;
        }
        return 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.jump.JS.QQGuildJsPlugin", 4, "handleEvent-> ", str, " type: ", Long.toBinaryString(j3), " info: ", String.valueOf(map));
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        try {
        } catch (Exception e16) {
            QLog.e("Guild.jump.JS.QQGuildJsPlugin", 1, "handleJsRequest exception=", e16);
        }
        if ("guild".equals(str2) && !TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.jump.JS.QQGuildJsPlugin", 2, "handleJsRequest-> ", "url: ", str, str2, " method:", str3, " args:", Arrays.toString(strArr));
            }
            a a16 = GuildJsBridgeMethodRegistry.a(str3);
            if (a16 != null) {
                return a16.a(this, str, str2, str3, strArr);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.jump.JS.QQGuildJsPlugin", 2, "handleSchemaRequest-> ", str, " scheme:", str2);
        }
        if (!q(str)) {
            return false;
        }
        QQGuildUIUtil.c(this.mRuntime.a(), 2000);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        super.onActivityReady();
        AppRuntime c16 = this.mRuntime.c();
        if (c16 instanceof BaseQQAppInterface) {
            this.f235749d = (BaseQQAppInterface) c16;
        }
    }

    public String p() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.e() != null) {
            Object tag = this.mRuntime.e().getTag(R.id.f72813rv);
            if (tag instanceof String) {
                return (String) tag;
            }
            return "";
        }
        return "";
    }

    public boolean r() {
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return false;
        }
        String stringExtra = a16.getIntent().getStringExtra("key_web_page_id");
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        return stringExtra.startsWith("GuildRemoteSurfaceHolder");
    }
}
