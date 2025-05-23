package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import com.google.gson.Gson;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionAttr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ@\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022.\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006`\u0007H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012R#\u0010\u001b\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAParseUtil;", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "resultMap", "", "b", "data", PM.BASE, "c", "", ark.ARKMETADATA_JSON, "", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteActionAttr;", "attr", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/a;", "a", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "d", "()Lcom/google/gson/Gson;", "gsonSingle", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAParseUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LIAParseUtil f353136a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy gsonSingle;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29841);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f353136a = new LIAParseUtil();
        lazy = LazyKt__LazyJVMKt.lazy(LIAParseUtil$gsonSingle$2.INSTANCE);
        gsonSingle = lazy;
    }

    LIAParseUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b item, HashMap<Integer, List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> resultMap) {
        if (item.c().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : item.c()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar = (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) obj;
            f353136a.c(bVar, item);
            if (bVar.m() == -1) {
                bVar.q(i3);
            }
            arrayList.add(bVar);
            i3 = i16;
        }
        resultMap.put(Integer.valueOf(item.n()), arrayList);
    }

    private final void c(com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b data, com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b base) {
        boolean z16;
        boolean z17 = true;
        if (data.e().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            data.p(base.e());
        }
        if (data.a().length() != 0) {
            z17 = false;
        }
        if (z17) {
            data.o(base.a());
        }
        data.r(base.n());
    }

    private final Gson d() {
        return (Gson) gsonSingle.getValue();
    }

    @NotNull
    public final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a a(@NotNull LiteActionAttr attr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) attr);
        }
        Intrinsics.checkNotNullParameter(attr, "attr");
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a aVar = new com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a();
        aVar.f(attr.type);
        aVar.e(attr.subType);
        aVar.d(attr.objectType);
        return aVar;
    }

    @NotNull
    public final Map<Integer, List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> e(@NotNull String json) {
        boolean z16;
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) json);
        }
        Intrinsics.checkNotNullParameter(json, "json");
        HashMap<Integer, List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> hashMap = new HashMap<>();
        try {
            JSONArray optJSONArray = new JSONObject(json).optJSONArray("actions_resource");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                Gson d16 = f353136a.d();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String itemJson = optJSONArray.optString(i3, "");
                    Intrinsics.checkNotNullExpressionValue(itemJson, "itemJson");
                    if (itemJson.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && (bVar = (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) d16.fromJson(itemJson, com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b.class)) != null) {
                        Intrinsics.checkNotNullExpressionValue(bVar, "gson.fromJson(itemJson, \u2026::class.java) ?: continue");
                        f353136a.b(bVar, hashMap);
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.d("LIAConfigManager", 1, "[initConfigAsync] parse err, ", th5);
        }
        return hashMap;
    }
}
