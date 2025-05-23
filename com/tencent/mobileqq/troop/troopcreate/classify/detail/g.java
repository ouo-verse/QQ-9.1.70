package com.tencent.mobileqq.troop.troopcreate.classify.detail;

import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0006\u0010\u0014\u001a\u00020\nR\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/g;", "", "", "from", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/d;", "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/troopcatalog/a;", "Lkotlin/collections/ArrayList;", "e", "", "f", "jsonConfig", "c", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "key", tl.h.F, "Lorg/json/JSONArray;", "g", "i", "b", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/d;", "groupConfig", "", "Z", "hasLoaded", "isLoading", "Ljava/lang/String;", "curUin", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f300087a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static d groupConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasLoaded;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isLoading;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile String curUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopcreate/classify/detail/g$a", "Lpy2/a;", "", DownloadInfo.spKey_Config, "", "b", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements py2.a<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable String config) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
                return;
            }
            boolean z17 = true;
            if (config != null && config.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.i("TroopClassifyDetailConfig", 1, "[startLoadConfig] config is null:" + z16);
            if (config != null && config.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                g.f300087a.c(config);
            }
            g.isLoading = false;
        }
    }

    static {
        d a16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f300087a = new g();
        if (((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).isNewCreateTroopExperiment()) {
            a16 = i.a();
        } else {
            a16 = f.a();
        }
        groupConfig = a16;
        curUin = "";
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String jsonConfig) {
        g gVar = this;
        String str = "id";
        if (QLog.isDebugVersion()) {
            QLog.d("TroopClassifyDetailConfig", 4, "[doParse] jsonConfig:" + jsonConfig);
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonConfig);
            String h16 = gVar.h(jSONObject, "title");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            JSONArray g16 = gVar.g(jSONObject, "deprecatedId");
            int length = g16.length();
            for (int i3 = 0; i3 < length; i3++) {
                linkedHashSet.add(g16.get(i3).toString());
            }
            JSONArray g17 = gVar.g(jSONObject, "groups");
            ArrayList arrayList = new ArrayList();
            int length2 = g17.length();
            int i16 = 0;
            while (i16 < length2) {
                JSONObject obj = g17.getJSONObject(i16);
                Intrinsics.checkNotNullExpressionValue(obj, "obj");
                String h17 = gVar.h(obj, "name");
                JSONArray g18 = gVar.g(obj, "child");
                ArrayList arrayList2 = new ArrayList();
                int length3 = g18.length();
                int i17 = 0;
                while (i17 < length3) {
                    JSONArray jSONArray = g17;
                    JSONObject childObj = g18.getJSONObject(i17);
                    int i18 = length2;
                    Intrinsics.checkNotNullExpressionValue(childObj, "childObj");
                    String h18 = gVar.h(childObj, "name");
                    String h19 = gVar.h(childObj, str);
                    String h26 = gVar.h(childObj, "iconUrl");
                    String h27 = gVar.h(childObj, "iconUrlDark");
                    String h28 = gVar.h(childObj, WadlProxyConsts.KEY_JUMP_URL);
                    int i19 = length3;
                    boolean areEqual = Intrinsics.areEqual("1", gVar.h(childObj, "hideInEdit"));
                    ArrayList arrayList3 = new ArrayList();
                    JSONArray g19 = gVar.g(childObj, "items");
                    int length4 = g19.length();
                    JSONArray jSONArray2 = g18;
                    int i26 = 0;
                    while (i26 < length4) {
                        int i27 = length4;
                        JSONObject itemObj = g19.getJSONObject(i26);
                        Intrinsics.checkNotNullExpressionValue(itemObj, "itemObj");
                        arrayList3.add(new b(gVar.h(itemObj, str), gVar.h(itemObj, "name"), gVar.h(itemObj, WadlProxyConsts.KEY_JUMP_URL)));
                        i26++;
                        gVar = this;
                        length4 = i27;
                        g19 = g19;
                        str = str;
                    }
                    arrayList2.add(new com.tencent.mobileqq.troop.troopcreate.classify.detail.a(h19, h18, h26, h27, h28, arrayList3, areEqual));
                    i17++;
                    gVar = this;
                    g17 = jSONArray;
                    length2 = i18;
                    length3 = i19;
                    g18 = jSONArray2;
                    str = str;
                }
                arrayList.add(new h(h17, arrayList2));
                i16++;
                gVar = this;
                g17 = g17;
                length2 = length2;
                str = str;
            }
            groupConfig = new d(h16, linkedHashSet, arrayList);
            hasLoaded = true;
            QLog.i("TroopClassifyDetailConfig", 1, "[doParse] json parse success");
        } catch (JSONException e16) {
            QLog.e("TroopClassifyDetailConfig", 1, "[doParse] json parse exception:" + e16.getMessage());
        }
    }

    @JvmStatic
    @NotNull
    public static final d d(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (!hasLoaded) {
            f(from);
        }
        return groupConfig;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> e(@NotNull String from) {
        List<h> list;
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(from, "from");
        ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> arrayList = new ArrayList<>();
        d d16 = d(from);
        List<h> b16 = d16.b();
        Set<String> a16 = d16.a();
        int size = b16.size();
        for (int i16 = 0; i16 < size; i16++) {
            List<com.tencent.mobileqq.troop.troopcreate.classify.detail.a> a17 = b16.get(i16).a();
            int size2 = a17.size();
            int i17 = 0;
            while (i17 < size2) {
                com.tencent.mobileqq.troop.troopcreate.classify.detail.a aVar = a17.get(i17);
                String a18 = aVar.a();
                String b17 = aVar.b();
                List<b> c16 = aVar.c();
                if (aVar.d()) {
                    list = b16;
                    i3 = size;
                } else {
                    com.tencent.mobileqq.troop.troopcatalog.a aVar2 = new com.tencent.mobileqq.troop.troopcatalog.a(1, a18, b17);
                    boolean contains = a16.contains(a18);
                    int size3 = c16.size();
                    int i18 = 0;
                    while (i18 < size3) {
                        b bVar = c16.get(i18);
                        String a19 = bVar.a();
                        String b18 = bVar.b();
                        List<h> list2 = b16;
                        int i19 = size;
                        com.tencent.mobileqq.troop.troopcatalog.a aVar3 = new com.tencent.mobileqq.troop.troopcatalog.a(2, a19, b18);
                        aVar3.e(aVar2);
                        if (!contains && !a16.contains(a19)) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        aVar3.f299964f = z16;
                        aVar2.a(aVar3);
                        i18++;
                        b16 = list2;
                        size = i19;
                    }
                    list = b16;
                    i3 = size;
                    aVar2.f299964f = a16.contains(a18);
                    arrayList.add(aVar2);
                }
                i17++;
                b16 = list;
                size = i3;
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final void f(@NotNull String from) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("TroopClassifyDetailConfig", 1, "[preLoad] from:" + from + ", hasLoaded:" + hasLoaded + ", isLoading:" + isLoading);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        }
        if (str != null && !Intrinsics.areEqual(curUin, appInterface.getCurrentAccountUin())) {
            QLog.i("TroopClassifyDetailConfig", 1, "account changed");
            String currentAccountUin = appInterface.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            curUin = currentAccountUin;
            hasLoaded = false;
            isLoading = false;
        }
        if (!hasLoaded && !isLoading) {
            isLoading = true;
            f300087a.i();
        }
    }

    private final JSONArray g(JSONObject json, String key) {
        if (json.has(key)) {
            JSONArray jSONArray = json.getJSONArray(key);
            Intrinsics.checkNotNullExpressionValue(jSONArray, "{\n            json.getJSONArray(key)\n        }");
            return jSONArray;
        }
        return new JSONArray();
    }

    private final String h(JSONObject json, String key) {
        if (json.has(key)) {
            String string = json.getString(key);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            json.getString(key)\n        }");
            return string;
        }
        return "";
    }

    public final void i() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("TroopClassifyDetailConfig", 1, "[startLoadConfig] ");
        if (((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).isNewCreateTroopExperiment()) {
            str = "102944";
        } else {
            str = "102793";
        }
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsStringAsync(str, "", new a());
    }
}
