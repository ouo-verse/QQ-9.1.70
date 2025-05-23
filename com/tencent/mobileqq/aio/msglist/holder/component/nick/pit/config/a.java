package com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000eJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R*\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/config/a;", "", "Lorg/json/JSONObject;", "e", "", "f", "", "bizId", "resId", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/config/b;", "b", "", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "d", "g", "Lorg/json/JSONObject;", "configIconJson", "Ljava/util/ArrayList;", "configIconIdList", "", "Ljava/util/Map;", "configIconInfoMap", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f191394a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static JSONObject configIconJson;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ArrayList<Integer> configIconIdList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, b> configIconInfoMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62714);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f191394a = new a();
            configIconInfoMap = new LinkedHashMap();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a() {
        return "{\"icon_groups\":[1,3,2],\"icon_info\":{}}";
    }

    private final b b(int bizId, int resId) {
        return configIconInfoMap.get(bizId + "-" + resId);
    }

    private final JSONObject e() {
        if (configIconJson == null) {
            g();
        }
        JSONObject jSONObject = configIconJson;
        if (jSONObject == null) {
            return new JSONObject(a());
        }
        return jSONObject;
    }

    private final void f() {
        try {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONArray jSONArray = e().getJSONArray("icon_groups");
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = jSONArray.getInt(i3);
                arrayList.add(Integer.valueOf(i16));
                if (i16 == 2) {
                    arrayList.add(-2);
                }
            }
            configIconIdList = arrayList;
        } catch (JSONException e16) {
            QLog.e("AIONickIconRefactorConfig", 1, "[getConfigIconIdList] exception = " + e16);
        }
    }

    @NotNull
    public final ArrayList<Integer> c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<Integer> arrayList = configIconIdList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f();
        }
        ArrayList<Integer> arrayList2 = configIconIdList;
        if (arrayList2 == null) {
            return new ArrayList<>();
        }
        return arrayList2;
    }

    @NotNull
    public final b d(int bizId, int resId) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(bizId), Integer.valueOf(resId));
        }
        b b16 = b(bizId, resId);
        if (b16 != null) {
            return b16;
        }
        b bVar = new b(null, null, 0, null, 15, null);
        try {
            JSONObject optJSONObject = e().optJSONObject("icon_info");
            if (optJSONObject != null) {
                jSONObject = optJSONObject.optJSONObject(String.valueOf(bizId));
            } else {
                jSONObject = null;
            }
        } catch (JSONException e16) {
            QLog.e("AIONickIconRefactorConfig", 1, "[getConfigIconInfoJson] exception = " + e16);
        }
        if (jSONObject == null) {
            return bVar;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(String.valueOf(resId));
        if (optJSONObject2 == null) {
            return bVar;
        }
        bVar.d(optJSONObject2.getString("url"));
        bVar.f(optJSONObject2.getString("target_page_url"));
        bVar.e(optJSONObject2.getInt("width"));
        if (bVar.b() <= 0) {
            bVar.e(16);
        }
        configIconInfoMap.put(bizId + "-" + resId, bVar);
        return bVar;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("101894", a());
        try {
            configIconJson = new JSONObject(loadConfigAsString);
            configIconInfoMap = new LinkedHashMap();
            f();
        } catch (JSONException e16) {
            QLog.e("AIONickIconRefactorConfig", 1, "[getConfigJson] configJSON = " + loadConfigAsString + " exception = " + e16);
        }
    }
}
