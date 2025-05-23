package com.tencent.mobileqq.zplan.aigc.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import bv4.e;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\bJ\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/utils/SuitOutfitHelper;", "", "Lbv4/e;", "outfitInfo", "", "JumpToSource", "b", "feedId", "", "from", "a", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitOutfitHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final SuitOutfitHelper f330689a = new SuitOutfitHelper();

    SuitOutfitHelper() {
    }

    public final String a(String feedId, int from) {
        String joinToString$default;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject();
        if (feedId != null) {
            jSONObject.put("feedId", feedId);
        }
        jSONObject.put("from", from);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "pageData.toString()");
        linkedHashMap.put(ISchemeApi.KEY_PAGE_DATA, jSONObject2);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedHashMap.entrySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<String, Object>, CharSequence>() { // from class: com.tencent.mobileqq.zplan.aigc.utils.SuitOutfitHelper$buildOutfitDetailScheme$schemaUrl$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Map.Entry<String, Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String key = it.getKey();
                return ((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + it.getValue();
            }
        }, 30, null);
        String str = "mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=20&" + joinToString$default;
        QLog.d("SuitOutfitHelper", 1, "\u7a7f\u642d\u9875\u7684schemaUrl: " + str);
        return str;
    }

    public final String b(e outfitInfo, String JumpToSource) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (JumpToSource != null) {
            jSONObject2.put("TryOnSource", JumpToSource);
            jSONObject2.put("JumpToSource", JumpToSource);
        }
        if (outfitInfo != null) {
            jSONObject2.put("FemaleUgcids", new JSONArray(outfitInfo.f29274a));
            jSONObject2.put("FemaleGoods", new JSONArray(outfitInfo.f29276c));
            jSONObject2.put("MaleUgcids", new JSONArray(outfitInfo.f29275b));
            jSONObject2.put("MaleGoods", new JSONArray(outfitInfo.f29277d));
        }
        jSONObject.put("SceneParams", jSONObject2);
        String buildTryOnSameStyleScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildTryOnSameStyleScheme(new ZootopiaSource(Source.AIGCPreview, "", null, 4, null), jSONObject);
        QLog.d("SuitOutfitHelper", 1, "\u8bd5\u7a7f\u5168\u5957\u7684schemaUrl: " + buildTryOnSameStyleScheme);
        return buildTryOnSameStyleScheme;
    }

    public final URLDrawable.URLDrawableOptions c(Context context, Drawable drawable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.ihy);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable == null ? drawable2 : drawable;
        if (drawable == null) {
            drawable = drawable2;
        }
        obtain.mFailedDrawable = drawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026defaultDrawable\n        }");
        return obtain;
    }
}
