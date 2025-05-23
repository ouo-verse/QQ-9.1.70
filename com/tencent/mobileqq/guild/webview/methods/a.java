package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.webview.g;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a implements g.a {

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f235755d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.guild.webview.g f235756e;

    /* renamed from: f, reason: collision with root package name */
    private String f235757f;

    @Override // com.tencent.mobileqq.guild.webview.g.a
    public final boolean a(com.tencent.mobileqq.guild.webview.g gVar, String str, String str2, String str3, String... strArr) {
        try {
            if (strArr.length > 0) {
                this.f235755d = new JSONObject(strArr[0]);
            } else {
                this.f235755d = new JSONObject();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.jump.JS.AbsJsBridgeMethod", 2, "onJsBridge invoke, method: ", str3, " data: ", this.f235755d.toString(1));
            }
            this.f235756e = gVar;
            this.f235757f = this.f235755d.optString("callback");
            return k(str, str2, str3);
        } catch (JSONException e16) {
            QLog.e("Guild.jump.JS.AbsJsBridgeMethod", 1, "invoke Exception:" + e16);
            return false;
        }
    }

    public boolean b(String str) {
        return this.f235755d.optBoolean(str);
    }

    public boolean c(String str, boolean z16) {
        return this.f235755d.optBoolean(str, z16);
    }

    public int d(String str) {
        return this.f235755d.optInt(str);
    }

    public int e(String str, int i3) {
        return this.f235755d.optInt(str, i3);
    }

    public String f(String str) {
        return this.f235755d.optString(str);
    }

    public String g(String str, @NonNull String str2) {
        return this.f235755d.optString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Exception exc) {
        QLog.e("Guild.jump.JS.AbsJsBridgeMethod", 1, "callbackId->" + this.f235757f + " Exception:" + exc);
        this.f235756e.callbackError(this.f235757f, "exception:" + exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.jump.JS.AbsJsBridgeMethod", 2, "callbackId->" + this.f235757f + " callbackOk" + str);
        }
        this.f235756e.callJs(this.f235757f, str);
    }

    public boolean j(String str) {
        return this.f235755d.has(str);
    }

    protected abstract boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3);
}
