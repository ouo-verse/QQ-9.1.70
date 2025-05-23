package com.tencent.biz.qqcircle.immersive.viewmodel.activity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J9\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u00c6\u0001J\t\u0010\f\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/d;", "", "", "toString", "activityId", "", "fetchIntervalMs", "", "fetchRetryCount", "", "preloadResourcesUrl", "a", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "J", "d", "()J", "I", "e", "()I", "Ljava/util/List;", "f", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;JILjava/util/List;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final /* data */ class d {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<String> f90263b;

    @SerializedName("alert_activity_id")
    @NotNull
    private final String activityId;

    @SerializedName("fetch_alert_time_interval")
    private final long fetchIntervalMs;

    @SerializedName("fetch_alert_repeat_times")
    private final int fetchRetryCount;

    @SerializedName("alert_view_resource")
    @Nullable
    private final List<String> preloadResourcesUrl;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/prize_toys.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/prize_qb.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/prize_cash_envelope.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/dialog_empty.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/prize_wallpaper.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/prize_wallpaper_wangzherongyao.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/btn_use.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/btn_back.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/btn_share.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/btn_showoff.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/small_btn_back.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/tooltip_redenvelope.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/popup_close.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/bg_dialog_congrats.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/bg_dialog_full.png", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/springfestival_2024/prize_dialog/bg_dialog_thankyou.png"});
        f90263b = listOf;
    }

    public d() {
        this(null, 0L, 0, null, 15, null);
    }

    public static /* synthetic */ d b(d dVar, String str, long j3, int i3, List list, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = dVar.activityId;
        }
        if ((i16 & 2) != 0) {
            j3 = dVar.fetchIntervalMs;
        }
        long j16 = j3;
        if ((i16 & 4) != 0) {
            i3 = dVar.fetchRetryCount;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            list = dVar.preloadResourcesUrl;
        }
        return dVar.a(str, j16, i17, list);
    }

    @NotNull
    public final d a(@NotNull String activityId, long fetchIntervalMs, int fetchRetryCount, @Nullable List<String> preloadResourcesUrl) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        return new d(activityId, fetchIntervalMs, fetchRetryCount, preloadResourcesUrl);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: d, reason: from getter */
    public final long getFetchIntervalMs() {
        return this.fetchIntervalMs;
    }

    /* renamed from: e, reason: from getter */
    public final int getFetchRetryCount() {
        return this.fetchRetryCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.activityId, dVar.activityId) && this.fetchIntervalMs == dVar.fetchIntervalMs && this.fetchRetryCount == dVar.fetchRetryCount && Intrinsics.areEqual(this.preloadResourcesUrl, dVar.preloadResourcesUrl)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<String> f() {
        return this.preloadResourcesUrl;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.activityId.hashCode() * 31) + androidx.fragment.app.a.a(this.fetchIntervalMs)) * 31) + this.fetchRetryCount) * 31;
        List<String> list = this.preloadResourcesUrl;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        Integer num;
        String str = this.activityId;
        long j3 = this.fetchIntervalMs;
        int i3 = this.fetchRetryCount;
        List<String> list = this.preloadResourcesUrl;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        return "QFSSpringFestivalConfig(activityId='" + str + "', fetchIntervalMs=" + j3 + ", fetchRetryCount=" + i3 + ", preloadResourcesUrl=" + num + ")";
    }

    public d(@NotNull String activityId, long j3, int i3, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        this.activityId = activityId;
        this.fetchIntervalMs = j3;
        this.fetchRetryCount = i3;
        this.preloadResourcesUrl = list;
    }

    public /* synthetic */ d(String str, long j3, int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "NVHVSYSZOZCW2Y2DJ44WKMDTGU3EQ52GPBZTK4SFKZMGSSDSGR3E6STTKVNGM5BVJZNG6PI=" : str, (i16 & 2) != 0 ? 3000L : j3, (i16 & 4) != 0 ? 3 : i3, (i16 & 8) != 0 ? f90263b : list);
    }
}
