package com.tencent.icgame.game.liveroom.impl.room.followguide;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0006\u0010\u0017\"\u0004\b\u001d\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/i;", "", "", "f", "toString", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "", "", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "j", "(Ljava/util/List;)V", "todayRoomIds", "c", "e", "k", "weeklyRoomIds", "J", "()J", "i", "(J)V", "refreshWeeklyDataTimestamp", tl.h.F, "refreshTodayDataTimestamp", "g", "lastDialogShowTimestamp", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> todayRoomIds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<Long> weeklyRoomIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long refreshWeeklyDataTimestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long refreshTodayDataTimestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long lastDialogShowTimestamp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/i$a;", "", "", "jsonStr", "Lcom/tencent/icgame/game/liveroom/impl/room/followguide/i;", "a", "LAST_DIALOG_SHOW_TIMESTAMP", "Ljava/lang/String;", "REFRESH_DATE_TIMES_TIMESTAMP", "REFRESH_WEEK_TIMES_TIMESTAMP", "ROOM_ID_LIST_HAS_SHOW_DAILY", "ROOM_ID_LIST_HAS_SHOW_WEEKLY", "TAG", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.followguide.i$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final i a(@NotNull String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            i iVar = new i();
            JSONObject jSONObject = new JSONObject(jsonStr);
            JSONArray optJSONArray = jSONObject.optJSONArray("roomid_list_has_show_daily");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("roomid_list_has_show_weekly");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(Long.valueOf(optJSONArray.optLong(i3)));
                }
            }
            iVar.j(arrayList);
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    arrayList2.add(Long.valueOf(optJSONArray2.optLong(i16)));
                }
            }
            iVar.k(arrayList);
            iVar.h(jSONObject.optLong("refresh_date_times_timestamp"));
            iVar.i(jSONObject.optLong("refresh_week_times_timestamp"));
            iVar.g(jSONObject.optLong("last_dialog_show_times_timestamp"));
            return iVar;
        }

        Companion() {
        }
    }

    public i() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.todayRoomIds = new ArrayList();
        this.weeklyRoomIds = new ArrayList();
    }

    /* renamed from: a, reason: from getter */
    public final long getLastDialogShowTimestamp() {
        return this.lastDialogShowTimestamp;
    }

    /* renamed from: b, reason: from getter */
    public final long getRefreshTodayDataTimestamp() {
        return this.refreshTodayDataTimestamp;
    }

    /* renamed from: c, reason: from getter */
    public final long getRefreshWeeklyDataTimestamp() {
        return this.refreshWeeklyDataTimestamp;
    }

    @NotNull
    public final List<Long> d() {
        return this.todayRoomIds;
    }

    @NotNull
    public final List<Long> e() {
        return this.weeklyRoomIds;
    }

    @NotNull
    public final String f() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("last_dialog_show_times_timestamp", this.lastDialogShowTimestamp);
        jSONObject.put("refresh_week_times_timestamp", this.refreshWeeklyDataTimestamp);
        jSONObject.put("refresh_date_times_timestamp", this.refreshTodayDataTimestamp);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        Iterator<T> it = this.todayRoomIds.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Number) it.next()).longValue());
        }
        Iterator<T> it5 = this.todayRoomIds.iterator();
        while (it5.hasNext()) {
            jSONArray2.put(((Number) it5.next()).longValue());
        }
        jSONObject.put("roomid_list_has_show_daily", jSONArray);
        jSONObject.put("roomid_list_has_show_weekly", jSONArray2);
        this.mAegisLog.i("ICGameFollowGuideModel", 1, "model2Json =" + jSONObject);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public final void g(long j3) {
        this.lastDialogShowTimestamp = j3;
    }

    public final void h(long j3) {
        this.refreshTodayDataTimestamp = j3;
    }

    public final void i(long j3) {
        this.refreshWeeklyDataTimestamp = j3;
    }

    public final void j(@NotNull List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.todayRoomIds = list;
    }

    public final void k(@NotNull List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.weeklyRoomIds = list;
    }

    @NotNull
    public String toString() {
        return "FollowGuideModel{todayRoomIds=" + this.todayRoomIds + ", weeklyRoomIds=" + this.weeklyRoomIds + ", refreshWeeklyDataTimestamp=" + this.refreshWeeklyDataTimestamp + ", refreshTodayDataTimestamp=" + this.refreshTodayDataTimestamp + ", lastDialogShowTimestamp=" + this.lastDialogShowTimestamp + "}";
    }
}
