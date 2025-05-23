package kc4;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tav.core.AssetExtension;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lkc4/a;", "", "Lorg/json/JSONObject;", "draftJson", "Lorg/json/JSONArray;", "resultJson", "", "c", "", "oldIconPath", "d", "productIds", "", "b", "a", "Ljava/lang/String;", "PRE_PATH", "getZPLAN_DRAFT_PATH", "()Ljava/lang/String;", "ZPLAN_DRAFT_PATH", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f412032a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String PRE_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String ZPLAN_DRAFT_PATH;

    static {
        String path;
        File externalFilesDir = BaseApplication.context.getExternalFilesDir(null);
        if (externalFilesDir == null || (path = externalFilesDir.getPath()) == null) {
            path = BaseApplication.context.getFilesDir().getPath();
        }
        String str = File.separator;
        PRE_PATH = path + str;
        ZPLAN_DRAFT_PATH = "ZplanDownload" + str + "FashionDesigner" + str;
    }

    a() {
    }

    private final boolean b(JSONArray productIds, JSONObject draftJson) {
        Object obj = draftJson.get("productId");
        int length = productIds.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (Intrinsics.areEqual(obj, productIds.getString(i3))) {
                return true;
            }
        }
        return false;
    }

    private final void c(JSONObject draftJson, JSONArray resultJson) {
        String icon = draftJson.getString("icon");
        Intrinsics.checkNotNullExpressionValue(icon, "icon");
        if (icon.length() > 0) {
            draftJson.put("icon", d(icon));
        }
        String thumb = draftJson.getString(AssetExtension.SCENE_THUMBNAIL);
        Intrinsics.checkNotNullExpressionValue(thumb, "thumb");
        if (thumb.length() > 0) {
            draftJson.put(AssetExtension.SCENE_THUMBNAIL, d(thumb));
        }
        resultJson.mo162put(draftJson);
    }

    private final String d(String oldIconPath) {
        int indexOf$default;
        String replace$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) oldIconPath, ZPLAN_DRAFT_PATH, 0, false, 6, (Object) null);
        String substring = oldIconPath.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        replace$default = StringsKt__StringsJVMKt.replace$default(oldIconPath, substring, PRE_PATH, false, 4, (Object) null);
        return replace$default;
    }

    public final JSONArray a(JSONArray productIds) {
        String readFileContent = FileUtils.readFileContent(new File(PRE_PATH + ZPLAN_DRAFT_PATH + "H5" + File.separator + "FashionDesigner.json"));
        JSONArray jSONArray = new JSONArray();
        if (readFileContent != null) {
            int i3 = 0;
            if (!(readFileContent.length() == 0)) {
                if (productIds != null && productIds.length() != 0) {
                    JSONArray jSONArray2 = new JSONArray(readFileContent);
                    int length = jSONArray2.length();
                    while (i3 < length) {
                        JSONObject draftJson = jSONArray2.getJSONObject(i3);
                        Intrinsics.checkNotNullExpressionValue(draftJson, "draftJson");
                        if (b(productIds, draftJson)) {
                            c(draftJson, jSONArray);
                        }
                        i3++;
                    }
                } else {
                    JSONArray jSONArray3 = new JSONArray(readFileContent);
                    int length2 = jSONArray3.length();
                    while (i3 < length2) {
                        JSONObject draftJson2 = jSONArray3.getJSONObject(i3);
                        Intrinsics.checkNotNullExpressionValue(draftJson2, "draftJson");
                        c(draftJson2, jSONArray);
                        i3++;
                    }
                }
            }
        }
        return jSONArray;
    }
}
