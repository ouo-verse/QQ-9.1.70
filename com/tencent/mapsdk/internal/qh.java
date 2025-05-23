package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonEncoder;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.bp;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qh {

    /* renamed from: d, reason: collision with root package name */
    private static final int f149801d = 256;

    /* renamed from: e, reason: collision with root package name */
    private static final String f149802e = "custom-layer";

    /* renamed from: f, reason: collision with root package name */
    private static final String f149803f = "layer-infos";

    /* renamed from: a, reason: collision with root package name */
    public re f149804a;

    /* renamed from: c, reason: collision with root package name */
    public int f149806c;

    /* renamed from: g, reason: collision with root package name */
    private Context f149807g;

    /* renamed from: h, reason: collision with root package name */
    private SharedPreferences f149808h;

    /* renamed from: b, reason: collision with root package name */
    public List<qi> f149805b = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private Set<a> f149809i = new HashSet();

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.qh$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 extends UrlTileProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qi f149810a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(qi qiVar) {
            super(256, 256);
            this.f149810a = qiVar;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
        public final URL getTileUrl(int i3, int i16, int i17) {
            qi qiVar = this.f149810a;
            if (i17 <= qiVar.f149819c && i17 >= qiVar.f149820d) {
                try {
                    return new URL(this.f149810a.a(i3, i16, i17));
                } catch (MalformedURLException e16) {
                    e16.printStackTrace();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements JsonEncoder, JsonParser {

        /* renamed from: b, reason: collision with root package name */
        private static final String f149812b = "id";

        /* renamed from: c, reason: collision with root package name */
        private static final String f149813c = "version";

        /* renamed from: d, reason: collision with root package name */
        private String f149815d;

        /* renamed from: e, reason: collision with root package name */
        private String f149816e;

        a() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.f149815d;
            if (str == null ? aVar.f149815d != null : !str.equals(aVar.f149815d)) {
                return false;
            }
            String str2 = this.f149816e;
            String str3 = aVar.f149816e;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            String str = this.f149815d;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.f149816e;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return i17 + i16;
        }

        @Override // com.tencent.map.tools.json.JsonParser
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f149815d = jSONObject.optString("id");
                this.f149816e = jSONObject.optString("version");
            }
        }

        @Override // com.tencent.map.tools.json.JsonEncoder
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f149815d);
                jSONObject.put("version", this.f149816e);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        /* synthetic */ a(qh qhVar, byte b16) {
            this();
        }
    }

    public qh(Context context, re reVar, bp.b bVar) {
        this.f149807g = context;
        this.f149804a = reVar;
        this.f149806c = reVar.f150022h.N;
        this.f149808h = kv.a(context, "custom-layer." + bVar.c());
        b();
    }

    private CustomLayer a(CustomLayerOptions customLayerOptions) {
        if (this.f149804a == null) {
            return null;
        }
        customLayerOptions.getLayerId();
        lc.b(ky.f149095a, this.f149806c);
        re reVar = this.f149804a;
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        String str = "custom_layer_" + lj.a(customLayerOptions.getLayerId());
        tileOverlayOptions.diskCacheDir(str);
        tileOverlayOptions.reuseTile(true);
        qi a16 = a(customLayerOptions.getLayerId());
        lc.a(ky.f149095a, XWalkReaderBasePlugin.PARAM_KEY_CACHE_DIR, (Object) str, this.f149806c);
        if (a16 != null) {
            lc.a(ky.f149095a, "version", (Object) a16.f149818b, this.f149806c);
            lc.a(ky.f149095a, "minZoom", Integer.valueOf(a16.f149820d), this.f149806c);
            lc.a(ky.f149095a, "maxZoom", Integer.valueOf(a16.f149819c), this.f149806c);
            lc.a(ky.f149095a, "layerId", (Object) a16.f149817a, this.f149806c);
            tileOverlayOptions.tileProvider(new AnonymousClass1(a16));
            tileOverlayOptions.versionInfo(a16.f149818b);
        }
        qz a17 = reVar.a(tileOverlayOptions);
        qi a18 = a(customLayerOptions.getLayerId());
        if (a17 == null || a18 == null) {
            return null;
        }
        if (a18.f149821e) {
            a17.e();
            a18.f149821e = false;
        }
        a17.a(a18.f149820d, a18.f149819c);
        this.f149804a.f150022h.f147918e.c().f148683a++;
        lc.d(ky.f149095a, this.f149806c);
        return new av(a17);
    }

    private void b() {
        SharedPreferences sharedPreferences = this.f149808h;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(f149803f, null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        this.f149809i.add((a) JsonUtils.parseToModel(jSONArray.getJSONObject(i3), a.class, this));
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    private TileOverlayOptions b(CustomLayerOptions customLayerOptions) {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        String str = "custom_layer_" + lj.a(customLayerOptions.getLayerId());
        tileOverlayOptions.diskCacheDir(str);
        tileOverlayOptions.reuseTile(true);
        qi a16 = a(customLayerOptions.getLayerId());
        lc.a(ky.f149095a, XWalkReaderBasePlugin.PARAM_KEY_CACHE_DIR, (Object) str, this.f149806c);
        if (a16 != null) {
            lc.a(ky.f149095a, "version", (Object) a16.f149818b, this.f149806c);
            lc.a(ky.f149095a, "minZoom", Integer.valueOf(a16.f149820d), this.f149806c);
            lc.a(ky.f149095a, "maxZoom", Integer.valueOf(a16.f149819c), this.f149806c);
            lc.a(ky.f149095a, "layerId", (Object) a16.f149817a, this.f149806c);
            tileOverlayOptions.tileProvider(new AnonymousClass1(a16));
            tileOverlayOptions.versionInfo(a16.f149818b);
        }
        return tileOverlayOptions;
    }

    public final qi a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (qi qiVar : this.f149805b) {
            if (qiVar != null && str.equals(qiVar.f149817a)) {
                return qiVar;
            }
        }
        return null;
    }

    public final void a() {
        boolean z16;
        boolean z17;
        byte b16 = 0;
        if (this.f149809i.isEmpty() && !this.f149805b.isEmpty()) {
            z16 = false;
            for (qi qiVar : this.f149805b) {
                a aVar = new a(this, b16);
                aVar.f149815d = qiVar.f149817a;
                aVar.f149816e = qiVar.f149818b;
                this.f149809i.add(aVar);
                z16 = true;
            }
        } else {
            z16 = false;
            for (qi qiVar2 : this.f149805b) {
                Iterator<a> it = this.f149809i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z17 = false;
                        break;
                    }
                    a next = it.next();
                    if (next.f149815d.equals(qiVar2.f149817a)) {
                        if (!next.f149816e.equalsIgnoreCase(qiVar2.f149818b)) {
                            qiVar2.f149821e = true;
                            next.f149816e = qiVar2.f149818b;
                        }
                        z17 = true;
                    }
                }
                if (!z17) {
                    a aVar2 = new a(this, b16);
                    aVar2.f149815d = qiVar2.f149817a;
                    aVar2.f149816e = qiVar2.f149818b;
                    this.f149809i.add(aVar2);
                    z16 = true;
                }
            }
        }
        if (z16) {
            kv.a(this.f149808h).a(f149803f, JsonUtils.collectionToJson(this.f149809i));
        }
    }

    private void a(qg qgVar) {
        if (qgVar == null || !qgVar.f149799a) {
            return;
        }
        this.f149805b.clear();
        this.f149805b.addAll(qgVar.f149800b);
        a();
    }
}
