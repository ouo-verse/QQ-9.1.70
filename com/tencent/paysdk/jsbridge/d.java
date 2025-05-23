package com.tencent.paysdk.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.api.l;
import com.tencent.paysdk.api.o;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b'\u0010(J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0017J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0018\u001a\u00020\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/paysdk/jsbridge/d;", "Lmq3/c;", "Landroid/content/Context;", "context", "Lcom/tencent/paysdk/api/o;", "webView", "Lcom/tencent/paysdk/api/c;", "provider", "Lcom/tencent/paysdk/vipauth/b;", "iVipInternalJSInterface", "Lcom/tencent/paysdk/api/l;", "jsDelegate", "", "d", "", "url", "", "c", "jsbridgeUrl", "b", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function1;", "safeReplay", "e", "Lmq3/b;", "Lmq3/b;", "getMJsModuleProvider", "()Lmq3/b;", "setMJsModuleProvider", "(Lmq3/b;)V", "mJsModuleProvider", "Lcom/tencent/paysdk/jsbridge/PaySdkJsModule;", "Lcom/tencent/paysdk/jsbridge/PaySdkJsModule;", "getMPaySdkJsModule", "()Lcom/tencent/paysdk/jsbridge/PaySdkJsModule;", "setMPaySdkJsModule", "(Lcom/tencent/paysdk/jsbridge/PaySdkJsModule;)V", "mPaySdkJsModule", "<init>", "(Landroid/content/Context;Lcom/tencent/paysdk/api/o;Lcom/tencent/paysdk/api/c;Lcom/tencent/paysdk/vipauth/b;Lcom/tencent/paysdk/api/l;)V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public class d implements mq3.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private mq3.b mJsModuleProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PaySdkJsModule mPaySdkJsModule;

    public d(@Nullable Context context, @Nullable o oVar, @Nullable com.tencent.paysdk.api.c cVar, @Nullable com.tencent.paysdk.vipauth.b bVar, @Nullable l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, context, oVar, cVar, bVar, lVar);
        } else {
            this.mJsModuleProvider = new a();
            d(context, oVar, cVar, bVar, lVar);
        }
    }

    @Override // mq3.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        PaySdkJsModule paySdkJsModule = this.mPaySdkJsModule;
        if (paySdkJsModule != null) {
            paySdkJsModule.onPageAppear();
        }
    }

    @Override // mq3.c
    @RequiresApi(11)
    public boolean b(@NotNull String jsbridgeUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) jsbridgeUrl)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(jsbridgeUrl, "jsbridgeUrl");
        Uri parse = Uri.parse(jsbridgeUrl);
        if (parse != null) {
            HashMap hashMap = new HashMap();
            for (String key : parse.getQueryParameterNames()) {
                if (Intrinsics.areEqual(key, "params")) {
                    try {
                        JSONObject jSONObject = new JSONObject(parse.getQueryParameter(key));
                        Iterator keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String jsonKey = (String) keys.next();
                            Intrinsics.checkNotNullExpressionValue(jsonKey, "jsonKey");
                            Object obj = jSONObject.get(jsonKey);
                            Intrinsics.checkNotNullExpressionValue(obj, "jsonObject[jsonKey]");
                            hashMap.put(jsonKey, obj);
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    String queryParameter = parse.getQueryParameter(key);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "u?.getQueryParameter(key) ?: \"\"");
                    hashMap.put(key, queryParameter);
                }
            }
            String authority = parse.getAuthority();
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                path = authority;
            }
            if (!TextUtils.isEmpty(path)) {
                if (path != null) {
                    path = path.substring(1, path.length());
                    Intrinsics.checkNotNullExpressionValue(path, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                } else {
                    path = null;
                }
            }
            mq3.b bVar = this.mJsModuleProvider;
            if (bVar != null) {
                bVar.b(authority, path, hashMap);
            }
            return true;
        }
        return false;
    }

    @Override // mq3.c
    public boolean c(@NotNull String url) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "tvajsbridge://", false, 2, null);
        return startsWith$default;
    }

    protected void d(@Nullable Context context, @Nullable o webView, @Nullable com.tencent.paysdk.api.c provider, @Nullable com.tencent.paysdk.vipauth.b iVipInternalJSInterface, @Nullable l jsDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, webView, provider, iVipInternalJSInterface, jsDelegate);
            return;
        }
        PaySdkJsModule paySdkJsModule = new PaySdkJsModule(context, webView, provider, iVipInternalJSInterface, jsDelegate);
        this.mPaySdkJsModule = paySdkJsModule;
        mq3.b bVar = this.mJsModuleProvider;
        if (bVar != null) {
            bVar.c(paySdkJsModule);
        }
    }

    public final void e(@NotNull Function1<? super Boolean, Unit> safeReplay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) safeReplay);
            return;
        }
        Intrinsics.checkNotNullParameter(safeReplay, "safeReplay");
        PaySdkJsModule paySdkJsModule = this.mPaySdkJsModule;
        if (paySdkJsModule != null) {
            paySdkJsModule.setReplayFun(safeReplay);
        }
    }

    @Override // mq3.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        mq3.b bVar = this.mJsModuleProvider;
        if (bVar != null) {
            bVar.a();
        }
    }
}
