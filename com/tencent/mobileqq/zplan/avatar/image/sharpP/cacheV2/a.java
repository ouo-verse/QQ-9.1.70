package com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2;

import com.tencent.mobileqq.ark.util.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.meme.frameanim.StrategyId;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\bB\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/a;", "", "", "c", "", "key", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "a", "Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "getStrategyId", "()Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "strategyId", "", "I", "getOwnerCapacity", "()I", "ownerCapacity", "getTotalCapacity", "totalCapacity", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getOwnerCacheList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "ownerCacheList", "e", "getGuestCacheList", "guestCacheList", "<init>", "(Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;II)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final StrategyId strategyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int ownerCapacity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int totalCapacity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<String> ownerCacheList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<String> guestCacheList;

    public a(StrategyId strategyId, int i3, int i16) {
        Intrinsics.checkNotNullParameter(strategyId, "strategyId");
        this.strategyId = strategyId;
        this.ownerCapacity = i3;
        this.totalCapacity = i16;
        this.ownerCacheList = b("owenr_cache_list");
        this.guestCacheList = b("guest_cache_list");
    }

    private final CopyOnWriteArrayList<String> b(String key) {
        try {
            IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
            String str = "zplan_avatar_shp_image_cache_" + this.strategyId;
            String jSONObject = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            JSONArray optJSONArray = new JSONObject(iZPlanMMKVApi.getString(str, jSONObject)).optJSONArray(key);
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            if (optJSONArray != null) {
                List<Object> a16 = i.a(optJSONArray);
                Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                copyOnWriteArrayList.addAll((ArrayList) a16);
            }
            QLog.i("BaseZPlanAvatarShpImageCache", 1, "[restoreShpImagesCacheFromMMKV] key:" + key + " list:" + copyOnWriteArrayList);
            return copyOnWriteArrayList;
        } catch (Throwable th5) {
            QLog.e("BaseZPlanAvatarShpImageCache", 1, "[restoreShpImagesCacheFromMMKV] error", th5);
            return new CopyOnWriteArrayList<>();
        }
    }

    private final void c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("owenr_cache_list", new JSONArray((Collection) this.ownerCacheList));
        jSONObject.put("guest_cache_list", new JSONArray((Collection) this.guestCacheList));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply{\n    \u2026st))\n        }.toString()");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_avatar_shp_image_cache_" + this.strategyId, jSONObject2);
        QLog.i("BaseZPlanAvatarShpImageCache", 1, "[saveShpImagesCacheToMMKV] json:" + jSONObject2);
    }

    public final synchronized void a() {
        QLog.i("BaseZPlanAvatarShpImageCache", 1, "[cleanShpImagesCache]");
        this.ownerCacheList.clear();
        this.guestCacheList.clear();
        c();
    }
}
