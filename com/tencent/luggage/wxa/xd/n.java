package com.tencent.luggage.wxa.xd;

import android.webkit.JavascriptInterface;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public volatile e f144866a;

    public n(e eVar) {
        this.f144866a = eVar;
    }

    public void a() {
        this.f144866a = null;
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        try {
            e eVar = this.f144866a;
            if (eVar == null) {
                return "";
            }
            return eVar.a(str, str2, "", i3);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSInterface", e16, DebugUtils.Method.INVOKEHANDLER, new Object[0]);
            throw e16;
        }
    }

    @JavascriptInterface
    public String invokeHandler2(String str, String str2, int i3, String str3) {
        try {
            e eVar = this.f144866a;
            if (eVar == null) {
                return "";
            }
            return eVar.a(str, str2, str3, i3);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSInterface", e16, DebugUtils.Method.INVOKEHANDLER, new Object[0]);
            throw e16;
        }
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        try {
            e eVar = this.f144866a;
            if (eVar == null) {
                return;
            }
            eVar.a(str, str2, a(str3));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSInterface", e16, DebugUtils.Method.PUBLISHHANDLER, new Object[0]);
            throw e16;
        }
    }

    public final int[] a(String str) {
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                iArr[i3] = jSONArray.getInt(i3);
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSInterface", e16.getMessage());
        }
        return iArr;
    }
}
