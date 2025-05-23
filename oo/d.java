package oo;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003R0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Loo/d;", "", "", "", "map", "a", "path", "", "", "c", "paramJson", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "pathToParamMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f423238a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, String> pathToParamMap = new HashMap<>();

    d() {
    }

    public final String a(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (!map.containsKey(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE)) {
            return null;
        }
        String str = map.get(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE);
        if (str == null) {
            str = "";
        }
        String str2 = map.get(WinkPublishMediaRecord.QZONE_PUBLISH_STYLE_ID);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = map.get(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID);
        if (str3 == null) {
            str3 = "";
        }
        String str4 = map.get(WinkPublishMediaRecord.QZONE_MAGIC_STUDIO_TAB);
        String str5 = str4 != null ? str4 : "";
        QLog.d("QZoneWatermarkUtil", 4, "convertToWinkPublishMaterialParamJson materialType:" + str + ",styleId:" + str2);
        return new a(str, str2, str3, str5).toString();
    }

    public final void b(String path, String paramJson) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paramJson, "paramJson");
        pathToParamMap.put(path, paramJson);
        QLog.d("QZoneWatermarkUtil", 4, "recordPathToParam success,path:" + path + "\nparamJson:" + paramJson);
    }

    public final void c(String path, Map<String, String> map) {
        a aVar;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(map, "map");
        HashMap<String, String> hashMap = pathToParamMap;
        if (hashMap.get(path) != null) {
            String str = hashMap.get(path);
            try {
                aVar = (a) new Gson().fromJson(str, a.class);
            } catch (JsonSyntaxException unused) {
                QLog.e("QZoneWatermarkUtil", 1, "unboxAndReBoxMaterialParam error. content=" + str);
                aVar = null;
            }
            if (aVar != null) {
                if (!(aVar.getAppId().length() == 0)) {
                    QLog.d("QZoneWatermarkUtil", 4, "unboxAndReBoxMaterialParam success,param=" + aVar);
                    pathToParamMap.remove(path);
                    aVar.b(map);
                    return;
                }
            }
            QLog.d("QZoneWatermarkUtil", 4, "unboxAndReBoxMaterialParam failed,param=" + aVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\rB'\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Loo/d$a;", "", "", "toString", "", "map", "", "b", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appId", "getStyleId", "styleId", "c", "getMaterialId", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "d", "getMaterialTab", "materialTab", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String styleId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String materialId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String materialTab;

        public a(String appId, String styleId, String materialId, String materialTab) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(styleId, "styleId");
            Intrinsics.checkNotNullParameter(materialId, "materialId");
            Intrinsics.checkNotNullParameter(materialTab, "materialTab");
            this.appId = appId;
            this.styleId = styleId;
            this.materialId = materialId;
            this.materialTab = materialTab;
        }

        /* renamed from: a, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        public final void b(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            map.put("style_appid", this.appId);
            map.put("style_id", this.styleId);
            map.put("material_id", this.materialId);
            map.put("material_tab", this.materialTab);
        }

        public int hashCode() {
            return (((((this.appId.hashCode() * 31) + this.styleId.hashCode()) * 31) + this.materialId.hashCode()) * 31) + this.materialTab.hashCode();
        }

        public String toString() {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.appId, aVar.appId) && Intrinsics.areEqual(this.styleId, aVar.styleId) && Intrinsics.areEqual(this.materialId, aVar.materialId) && Intrinsics.areEqual(this.materialTab, aVar.materialTab);
        }
    }
}
