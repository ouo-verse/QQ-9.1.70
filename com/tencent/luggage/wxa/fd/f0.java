package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.fd.d0;
import com.tencent.mm.udr.IUdrResourceFeature;
import com.tencent.mm.udr.api.CheckParameterModel;
import com.tencent.mm.udr.api.IUdrResourceCallback;
import com.tencent.mm.udr.api.WxUdrResource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f125713a;

    /* renamed from: b, reason: collision with root package name */
    public static final JSONObject f125714b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map f125715c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f125716d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fd.f0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6206a implements IUdrResourceCallback {
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b() {
            List listOf;
            boolean z16;
            boolean z17;
            WxUdrResource wxUdrResource;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WAGameTagConfigHelper", "initTagResource");
            IUdrResourceFeature a16 = com.tencent.luggage.wxa.eo.g.a(IUdrResourceFeature.class);
            WxUdrResource resource = a16.getResource("ilinkres_97097883", "wagame_icon_android");
            int i3 = 0;
            if (!com.tencent.luggage.wxa.h6.d.b(resource)) {
                String postPath = resource.getPostPath();
                boolean z18 = true;
                if (postPath != null && postPath.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    String postPath2 = resource.getPostPath();
                    if (postPath2 != null && postPath2.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (z17) {
                        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WAGameTagConfigHelper", "resource path invalid, path:" + resource.getPostPath());
                        return;
                    }
                    com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(resource.getPostPath(), "wagame_icon_android");
                    if (!vVar.e() || !d0.f125708a.a(resource)) {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WAGameTagConfigHelper", "try unzip resource again");
                        d0.a aVar = d0.f125708a;
                        aVar.c(resource);
                        com.tencent.luggage.wxa.cp.v vVar2 = new com.tencent.luggage.wxa.cp.v(resource.getPostPath(), "wagame_icon_android");
                        if (vVar2.e() && aVar.a(resource)) {
                            vVar = vVar2;
                        } else {
                            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WAGameTagConfigHelper", "resource file not ready, path:" + vVar2.m());
                            return;
                        }
                    }
                    try {
                        try {
                            String readText = TextStreamsKt.readText(new com.tencent.luggage.wxa.cp.y(vVar.m() + "/info.json"));
                            if (readText.length() != 0) {
                                z18 = false;
                            }
                            if (z18) {
                                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WAGameTagConfigHelper", "resource info json file empty");
                                return;
                            }
                            JSONObject jSONObject = new JSONObject(readText);
                            if (!com.tencent.luggage.wxa.h6.d.b(jSONObject)) {
                                JSONArray optJSONArray = jSONObject.optJSONArray("icon_info_list");
                                if (com.tencent.luggage.wxa.h6.d.b(optJSONArray)) {
                                    return;
                                }
                                int length = optJSONArray.length();
                                while (i3 < length) {
                                    JSONObject info = optJSONArray.getJSONObject(i3);
                                    int optInt = info.optInt("icon_type");
                                    int optInt2 = info.optInt("icon_width");
                                    int optInt3 = info.optInt("icon_height");
                                    String optString = info.optString("path");
                                    String optString2 = info.optString("url");
                                    String optString3 = info.optString("text");
                                    JSONArray jSONArray = optJSONArray;
                                    int i16 = length;
                                    StringBuilder sb5 = new StringBuilder();
                                    wxUdrResource = resource;
                                    try {
                                        sb5.append(vVar.m());
                                        sb5.append('/');
                                        sb5.append(optString);
                                        com.tencent.luggage.wxa.cp.v vVar3 = new com.tencent.luggage.wxa.cp.v(sb5.toString());
                                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WAGameTagConfigHelper", "iconType:" + optInt + " w:" + optInt2 + " h:" + optInt3 + " path:" + optString + " url:" + optString2 + " text:" + optString3 + " iconFileExist:" + vVar3.e());
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("icon_width", optInt2);
                                        jSONObject2.put("icon_height", optInt3);
                                        jSONObject2.put("iamgeURL", optString2);
                                        jSONObject2.put("text", optString3);
                                        Intrinsics.checkNotNullExpressionValue(info, "info");
                                        try {
                                            a(optInt, info, new com.tencent.luggage.wxa.cp.v(vVar3));
                                            a().put(String.valueOf(optInt), jSONObject2);
                                            i3++;
                                            optJSONArray = jSONArray;
                                            length = i16;
                                            resource = wxUdrResource;
                                        } catch (FileNotFoundException e16) {
                                            e = e16;
                                            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WAGameTagConfigHelper", "resource info json file not found, " + e);
                                            d0.f125708a.b(wxUdrResource);
                                            return;
                                        } catch (Exception e17) {
                                            e = e17;
                                            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WAGameTagConfigHelper", "resource info json invalid, " + e);
                                            return;
                                        }
                                    } catch (FileNotFoundException e18) {
                                        e = e18;
                                    }
                                }
                            }
                            return;
                        } catch (FileNotFoundException e19) {
                            e = e19;
                            wxUdrResource = resource;
                        }
                    } catch (Exception e26) {
                        e = e26;
                    }
                }
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WAGameTagConfigHelper", "resource path empty");
            listOf = CollectionsKt__CollectionsJVMKt.listOf("wagame_icon_android");
            a16.check(new CheckParameterModel("ilinkres_97097883", new ArrayList(listOf), 0, (Map) null), new C6206a());
        }

        public final JSONObject a() {
            return f0.f125714b;
        }

        public final void a(int i3, JSONObject jSONObject, com.tencent.luggage.wxa.cp.v vVar) {
            f0.f125715c.put(Integer.valueOf(i3), jSONObject);
            f0.f125716d.put(Integer.valueOf(i3), vVar);
        }
    }

    static {
        a aVar = new a(null);
        f125713a = aVar;
        f125714b = new JSONObject();
        f125715c = new LinkedHashMap();
        f125716d = new LinkedHashMap();
        aVar.b();
    }
}
