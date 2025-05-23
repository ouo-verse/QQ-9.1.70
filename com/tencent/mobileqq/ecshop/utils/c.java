package com.tencent.mobileqq.ecshop.utils;

import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/ecshop/utils/c;", "", "", "a", "", ark.ARKMETADATA_JSON, "", "b", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f203952a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29266);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f203952a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        IRuntimeService runtimeService = a.a().getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppRunTime().getRunti\u2026ava, ProcessConstant.ALL)");
        if (((IPublicAccountDataManager) runtimeService).findPublicAccountInfo(IPublicAccountUtil.UIN_FOR_SHOP) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, String> b(@NotNull String json) {
        boolean z16;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this, (Object) json);
        }
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            return emptyMap2;
        }
        try {
            JSONObject jSONObject = new JSONObject(json);
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString = jSONObject.optString(str);
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(key)");
                hashMap.put(str, optString);
            }
            return hashMap;
        } catch (JSONException e16) {
            QLog.e("qqshop_EcshopUtils", 1, e16, new Object[0]);
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }
}
