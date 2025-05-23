package com.tencent.mobileqq.guild.feed.preload.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheData;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheResponse;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.preload.detail.data.ResponseCode;
import com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001f\u0018 B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J \u0010\u0018\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailSingleHttpTask;", "Lcom/tencent/mobileqq/guild/feed/preload/detail/d;", "Lokhttp3/Response;", "response", "Lcom/tencent/mobileqq/guild/feed/preload/detail/g;", "callback", "", "e", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/ResponseCode;", "error", "", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheData;", "cacheList", "", "g", "", "responseBody", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheResponse;", "f", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "preloadParams", "c", "d", "params", "a", "", "J", "startTime", "<init>", "()V", "b", "ChannelSign", "SingleRequest", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDetailSingleHttpTask implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailSingleHttpTask$ChannelSign;", "", "guild_id", "", "channel_id", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannel_id", "()Ljava/lang/String;", "getGuild_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class ChannelSign {

        @NotNull
        private final String channel_id;

        @NotNull
        private final String guild_id;

        public ChannelSign(@NotNull String guild_id, @NotNull String channel_id) {
            Intrinsics.checkNotNullParameter(guild_id, "guild_id");
            Intrinsics.checkNotNullParameter(channel_id, "channel_id");
            this.guild_id = guild_id;
            this.channel_id = channel_id;
        }

        public static /* synthetic */ ChannelSign copy$default(ChannelSign channelSign, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = channelSign.guild_id;
            }
            if ((i3 & 2) != 0) {
                str2 = channelSign.channel_id;
            }
            return channelSign.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGuild_id() {
            return this.guild_id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getChannel_id() {
            return this.channel_id;
        }

        @NotNull
        public final ChannelSign copy(@NotNull String guild_id, @NotNull String channel_id) {
            Intrinsics.checkNotNullParameter(guild_id, "guild_id");
            Intrinsics.checkNotNullParameter(channel_id, "channel_id");
            return new ChannelSign(guild_id, channel_id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelSign)) {
                return false;
            }
            ChannelSign channelSign = (ChannelSign) other;
            if (Intrinsics.areEqual(this.guild_id, channelSign.guild_id) && Intrinsics.areEqual(this.channel_id, channelSign.channel_id)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannel_id() {
            return this.channel_id;
        }

        @NotNull
        public final String getGuild_id() {
            return this.guild_id;
        }

        public int hashCode() {
            return (this.guild_id.hashCode() * 31) + this.channel_id.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelSign(guild_id=" + this.guild_id + ", channel_id=" + this.channel_id + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/preload/detail/FeedDetailSingleHttpTask$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "exception", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f222768b;

        b(g gVar) {
            this.f222768b = gVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException exception) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(exception, "exception");
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "sendSingleRequest onFailure, exception " + exception;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedDetailSingleHttpTask", 1, (String) it.next(), null);
            }
            FeedDetailSingleHttpTask feedDetailSingleHttpTask = FeedDetailSingleHttpTask.this;
            g gVar = this.f222768b;
            int a16 = hj1.a.f405185a.a(exception);
            String localizedMessage = exception.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "IOException";
            }
            FeedDetailSingleHttpTask.h(feedDetailSingleHttpTask, gVar, new ResponseCode(a16, localizedMessage), null, 4, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            FeedDetailSingleHttpTask.this.e(response, this.f222768b);
        }
    }

    private final String c(GuildFeedDetailPreloadParams preloadParams) {
        String str;
        try {
            str = new Gson().toJson(new SingleRequest(0, 0, preloadParams.getUserId(), preloadParams.getFeedId(), preloadParams.getCreateTime(), new ChannelSign(String.valueOf(preloadParams.getGuildId()), String.valueOf(preloadParams.getChannelId())), 3, null));
            Intrinsics.checkNotNullExpressionValue(str, "Gson().toJson(singleRequest)");
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "covertToSingleRequestBody error " + e16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedDetailSingleHttpTask", 1, (String) it.next(), null);
            }
            str = "";
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("FeedDetailSingleHttpTask", 2, "covertToSingleRequestBody " + ((Object) str));
        }
        return str;
    }

    private final String d() {
        return ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).getFeedDetailSinglePreloadUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(Response response, g callback) {
        String str;
        boolean z16;
        int code = response.code();
        if (code != 200) {
            h(this, callback, new ResponseCode(60002, "responseCode is " + code), null, 4, null);
            return true;
        }
        ResponseBody body = response.body();
        if (body == null || (str = body.string()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h(this, callback, new ResponseCode(60001, "responseBody is empty"), null, 4, null);
            return true;
        }
        GuildFeedDetailCacheResponse f16 = f(str);
        g(callback, f16.getError(), f16.getCacheList());
        return false;
    }

    private final GuildFeedDetailCacheResponse f(String responseBody) {
        int a16;
        JSONObject jSONObject;
        String str;
        long j3;
        List listOf;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(responseBody);
            a16 = 0;
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "parseSingleResponse covert root json error, " + ((Object) null);
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedDetailSingleHttpTask", 1, (String) it.next(), null);
            }
            a16 = hj1.a.f405185a.a(e16);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return new GuildFeedDetailCacheResponse(null, 0L, new ResponseCode(a16, "root json is illegal"), 0, 11, null);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("error");
        int i3 = -1;
        if (optJSONObject != null) {
            i3 = optJSONObject.optInt("code", -1);
        }
        if (optJSONObject != null) {
            str = optJSONObject.optString("message", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (i3 != 0) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str3 = "parseSingleResponse error " + optJSONObject;
            if (str3 instanceof String) {
                bVar2.a().add(str3);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("FeedDetailSingleHttpTask", 1, (String) it5.next(), null);
            }
            return new GuildFeedDetailCacheResponse(null, 0L, new ResponseCode(i3, str), 0, 11, null);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("response");
        if (optJSONObject2 != null) {
            jSONObject2 = optJSONObject2.optJSONObject("feed");
        }
        if (jSONObject2 == null) {
            return new GuildFeedDetailCacheResponse(null, 0L, new ResponseCode(60003, "feeds is invalid"), 0, 11, null);
        }
        String optString = jSONObject2.optString("id", "");
        Intrinsics.checkNotNullExpressionValue(optString, "feedObj.optString(\"id\", \"\")");
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "feedObj.toString()");
        JSONObject optJSONObject3 = jSONObject2.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        if (optJSONObject3 != null) {
            j3 = optJSONObject3.optLong("last_modified_time", 0L);
        } else {
            j3 = 0;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new GuildFeedDetailCacheData(optString, jSONObject3, null, j3, 4, null));
        return new GuildFeedDetailCacheResponse(listOf, 0L, new ResponseCode(i3, str), 0, 10, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        if (r10.getCode() == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void g(g callback, ResponseCode error, List<GuildFeedDetailCacheData> cacheList) {
        boolean z16;
        boolean z17 = true;
        if (!cacheList.isEmpty()) {
            List<GuildFeedDetailCacheData> list = cacheList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!((GuildFeedDetailCacheData) it.next()).isValid()) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        z17 = false;
        if (callback != null) {
            callback.a(z17, new GuildFeedDetailCacheResponse(cacheList, System.currentTimeMillis() - this.startTime, error, 0));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void h(FeedDetailSingleHttpTask feedDetailSingleHttpTask, g gVar, ResponseCode responseCode, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        feedDetailSingleHttpTask.g(gVar, responseCode, list);
    }

    @Override // com.tencent.mobileqq.guild.feed.preload.detail.d
    public void a(@NotNull List<GuildFeedDetailPreloadParams> params, @Nullable g callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.startTime = System.currentTimeMillis();
        if (!params.isEmpty() && params.size() <= 1) {
            GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = params.get(0);
            if (!guildFeedDetailPreloadParams.isValid()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "sendSingleRequest invalid params " + guildFeedDetailPreloadParams;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("FeedDetailSingleHttpTask", 1, (String) it.next(), null);
                }
                h(this, callback, new ResponseCode(-7, "params is invalid"), null, 4, null);
                return;
            }
            String d16 = d();
            GuildFeedDetailOkHttpFactory guildFeedDetailOkHttpFactory = GuildFeedDetailOkHttpFactory.f222769a;
            OkHttpClient d17 = guildFeedDetailOkHttpFactory.d();
            Request b16 = guildFeedDetailOkHttpFactory.b(d16, GuildFeedDetailHttpUtil.f223767a.c(d16), c(guildFeedDetailPreloadParams));
            if (b16 == null) {
                h(this, callback, new ResponseCode(-8, "request is invalid"), null, 4, null);
                return;
            } else {
                d17.newCall(b16).enqueue(new b(callback));
                return;
            }
        }
        Logger.f235387a.d().d("FeedDetailSingleHttpTask", 1, "sendSingleRequest not support multi or empty params, size: " + params.size());
        h(this, callback, new ResponseCode(-7, "not support multi(" + params.size() + ") or empty params"), null, 4, null);
    }

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailSingleHttpTask$SingleRequest;", "", "from", "", "detail_type", "userId", "", "feedId", WadlProxyConsts.CREATE_TIME, "", "channelSign", "Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailSingleHttpTask$ChannelSign;", "(IILjava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailSingleHttpTask$ChannelSign;)V", "getChannelSign", "()Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailSingleHttpTask$ChannelSign;", "getCreateTime", "()J", "getDetail_type", "()I", "getFeedId", "()Ljava/lang/String;", "getFrom", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class SingleRequest {

        @NotNull
        private final ChannelSign channelSign;
        private final long createTime;
        private final int detail_type;

        @NotNull
        private final String feedId;
        private final int from;

        @NotNull
        private final String userId;

        public SingleRequest(int i3, int i16, @NotNull String userId, @NotNull String feedId, long j3, @NotNull ChannelSign channelSign) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(channelSign, "channelSign");
            this.from = i3;
            this.detail_type = i16;
            this.userId = userId;
            this.feedId = feedId;
            this.createTime = j3;
            this.channelSign = channelSign;
        }

        public static /* synthetic */ SingleRequest copy$default(SingleRequest singleRequest, int i3, int i16, String str, String str2, long j3, ChannelSign channelSign, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = singleRequest.from;
            }
            if ((i17 & 2) != 0) {
                i16 = singleRequest.detail_type;
            }
            int i18 = i16;
            if ((i17 & 4) != 0) {
                str = singleRequest.userId;
            }
            String str3 = str;
            if ((i17 & 8) != 0) {
                str2 = singleRequest.feedId;
            }
            String str4 = str2;
            if ((i17 & 16) != 0) {
                j3 = singleRequest.createTime;
            }
            long j16 = j3;
            if ((i17 & 32) != 0) {
                channelSign = singleRequest.channelSign;
            }
            return singleRequest.copy(i3, i18, str3, str4, j16, channelSign);
        }

        /* renamed from: component1, reason: from getter */
        public final int getFrom() {
            return this.from;
        }

        /* renamed from: component2, reason: from getter */
        public final int getDetail_type() {
            return this.detail_type;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: component5, reason: from getter */
        public final long getCreateTime() {
            return this.createTime;
        }

        @NotNull
        /* renamed from: component6, reason: from getter */
        public final ChannelSign getChannelSign() {
            return this.channelSign;
        }

        @NotNull
        public final SingleRequest copy(int from, int detail_type, @NotNull String userId, @NotNull String feedId, long createTime, @NotNull ChannelSign channelSign) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(channelSign, "channelSign");
            return new SingleRequest(from, detail_type, userId, feedId, createTime, channelSign);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SingleRequest)) {
                return false;
            }
            SingleRequest singleRequest = (SingleRequest) other;
            if (this.from == singleRequest.from && this.detail_type == singleRequest.detail_type && Intrinsics.areEqual(this.userId, singleRequest.userId) && Intrinsics.areEqual(this.feedId, singleRequest.feedId) && this.createTime == singleRequest.createTime && Intrinsics.areEqual(this.channelSign, singleRequest.channelSign)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ChannelSign getChannelSign() {
            return this.channelSign;
        }

        public final long getCreateTime() {
            return this.createTime;
        }

        public final int getDetail_type() {
            return this.detail_type;
        }

        @NotNull
        public final String getFeedId() {
            return this.feedId;
        }

        public final int getFrom() {
            return this.from;
        }

        @NotNull
        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (((((((((this.from * 31) + this.detail_type) * 31) + this.userId.hashCode()) * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime)) * 31) + this.channelSign.hashCode();
        }

        @NotNull
        public String toString() {
            return "SingleRequest(from=" + this.from + ", detail_type=" + this.detail_type + ", userId=" + this.userId + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ", channelSign=" + this.channelSign + ")";
        }

        public /* synthetic */ SingleRequest(int i3, int i16, String str, String str2, long j3, ChannelSign channelSign, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 1 : i16, str, str2, j3, channelSign);
        }
    }
}
