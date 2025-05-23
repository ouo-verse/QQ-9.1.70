package com.tencent.gdtad.util;

import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR3\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R3\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R3\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u0015\u0010\u001e\u001a\u00020\u001c*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/gdtad/util/j;", "", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "aid", "traceId", "clickParam", "posType", "feedIndex", "", "f", "", "isNeedReportClickPos", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "e", "()Ljava/util/HashMap;", "mAdExposureTimestamps", "Lcom/tencent/gdtad/util/j$a;", "c", "mAdClickDownPosMap", "d", "mAdClickUpPosMap", "", "(I)F", "dp", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f109555a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Long> mAdExposureTimestamps = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Location> mAdClickDownPosMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Location> mAdClickUpPosMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/gdtad/util/j$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", HippyTKDListViewAdapter.X, "b", "y", "<init>", "(II)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gdtad.util.j$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class Location {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int x;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int y;

        public Location(int i3, int i16) {
            this.x = i3;
            this.y = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getX() {
            return this.x;
        }

        /* renamed from: b, reason: from getter */
        public final int getY() {
            return this.y;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Location)) {
                return false;
            }
            Location location = (Location) other;
            if (this.x == location.x && this.y == location.y) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.x * 31) + this.y;
        }

        @NotNull
        public String toString() {
            return "Location(x=" + this.x + ", y=" + this.y + ')';
        }
    }

    j() {
    }

    @NotNull
    public final String a(@NotNull String traceId, boolean isNeedReportClickPos) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Location location = mAdClickDownPosMap.get(traceId);
        Location location2 = mAdClickUpPosMap.get(traceId);
        JSONObject jSONObject = new JSONObject();
        if (isNeedReportClickPos && location != null && location2 != null) {
            try {
                jSONObject.put("aa", "" + b(location.getX()));
                jSONObject.put("ab", "" + b(location.getY()));
                jSONObject.put("ba", "" + b(location2.getX()));
                jSONObject.put("bb", "" + b(location2.getY()));
            } catch (Exception e16) {
                QLog.e("GdtClickReportUtils", 1, "getClickData jsonObject error", e16);
            }
        }
        Long l3 = mAdExposureTimestamps.get(traceId);
        if (l3 != null) {
            jSONObject.put("p", "" + (System.currentTimeMillis() - l3.longValue()));
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final float b(int i3) {
        return ViewUtils.pxToDp(i3);
    }

    @NotNull
    public final HashMap<String, Location> c() {
        return mAdClickDownPosMap;
    }

    @NotNull
    public final HashMap<String, Location> d() {
        return mAdClickUpPosMap;
    }

    @NotNull
    public final HashMap<String, Long> e() {
        return mAdExposureTimestamps;
    }

    public final void f(int busiType, @NotNull String aid, @NotNull String traceId, @NotNull String clickParam, int posType, int feedIndex) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(clickParam, "clickParam");
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(busiType);
        build.setAid(aid);
        build.setAdPosType(posType);
        build.setActionType(1);
        build.setActionTime(System.currentTimeMillis() / 1000);
        build.setFeedsIndex(feedIndex);
        build.setAttachment(clickParam);
        build.setTraceId(traceId);
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }
}
