package com.tencent.mobileqq.search.searchdetail.content.template;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.search.searchdetail.eventbus.QSearchPostEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/d;", "", "", "b", "troopUin", "", "status", "Lcom/tencent/mobileqq/search/searchdetail/d;", "dtReportIoc", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f284208a = new d();

    d() {
    }

    private final String b(String str) {
        return "QSearchTroopStatus_" + str;
    }

    public final void a(@NotNull String troopUin, int status, @Nullable com.tencent.mobileqq.search.searchdetail.d dtReportIoc) {
        Map<String, Object> pageCacheMap;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (dtReportIoc != null && (pageCacheMap = dtReportIoc.getPageCacheMap()) != null) {
            pageCacheMap.put(b(troopUin), Integer.valueOf(status));
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("troop_uin", troopUin);
        jSONObject.put("status", status);
        Unit unit = Unit.INSTANCE;
        simpleEventBus.dispatchEvent(new QSearchPostEvent("update_troop_join_status", jSONObject));
    }
}
