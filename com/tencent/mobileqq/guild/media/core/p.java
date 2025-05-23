package com.tencent.mobileqq.guild.media.core;

import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/p;", "", "Lorg/json/JSONObject;", "a", "", "", "b", "", "c", "", "e", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f228716a = new p();

    p() {
    }

    private final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("guild_id", j.c().r());
        jSONObject.put("channel_id", j.c().e());
        jSONObject.put("auth_meta", j.c().b());
        return jSONObject;
    }

    private final Map<String, String> b() {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("x-from", "prefetch"));
        return mapOf;
    }

    public final boolean c() {
        if (GuildMediaUtils.f227771a.n()) {
            QLog.w("MediaChannelPrefetchUtil", 1, "[isMiniPreTaskAllowed] is low perf device");
            return false;
        }
        if (bs.m()) {
            return true;
        }
        QLog.w("MediaChannelPrefetchUtil", 1, "[isMiniPreTaskAllowed] is switch off");
        return false;
    }

    public final void d() {
        if (com.tencent.mobileqq.guild.util.o.c("prefetchPlayList")) {
            QLog.w("MediaChannelPrefetchUtil", 1, "[prefetchPlayList] fast click");
            return;
        }
        if (!c()) {
            QLog.w("MediaChannelPrefetchUtil", 1, "[prefetchPlayList] stop by switch or device perf");
            return;
        }
        JSONObject a16 = a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("req_head", a16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("_p_=" + jSONObject);
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).prefetchPageDataWithExtraParam("10000-pages-together/playlist/playlist.html", sb5.toString(), b());
        QLog.i("MediaChannelPrefetchUtil", 1, "[prefetchPlayList] path: 10000-pages-together/playlist/playlist.html, query=" + ((Object) sb5));
    }

    public final void e() {
        if (com.tencent.mobileqq.guild.util.o.c("prefetchSongList")) {
            QLog.w("MediaChannelPrefetchUtil", 1, "[prefetchSongList] fast click");
            return;
        }
        if (!c()) {
            QLog.w("MediaChannelPrefetchUtil", 1, "[prefetchSongList] stop by switch or device perf");
            return;
        }
        JSONObject a16 = a();
        a16.put("confirm_exts", new JSONArray().mo162put(""));
        a16.put("page_cookies", "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("req_head", a16);
        jSONObject.put("query_song_req_type", 1);
        jSONObject.put("source_id", "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("_p_=" + jSONObject);
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).prefetchPageDataWithExtraParam("10000-pages-together/index/index.html", sb5.toString(), b());
        QLog.i("MediaChannelPrefetchUtil", 1, "[prefetchSongList] path: 10000-pages-together/index/index.html, query=" + ((Object) sb5));
    }
}
