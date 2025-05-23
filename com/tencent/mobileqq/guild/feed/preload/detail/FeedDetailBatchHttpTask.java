package com.tencent.mobileqq.guild.feed.preload.detail;

import android.util.Base64;
import androidx.annotation.Keep;
import com.google.gson.Gson;
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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0004 !\u0019\"B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J \u0010\u0019\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask;", "Lcom/tencent/mobileqq/guild/feed/preload/detail/d;", "Lokhttp3/Response;", "response", "Lcom/tencent/mobileqq/guild/feed/preload/detail/g;", "callback", "", "f", "", "responseBody", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheResponse;", "g", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/ResponseCode;", "error", "", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheData;", "cacheList", "", h.F, "str", "d", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "params", "c", "e", "a", "", "J", "startTime", "<init>", "()V", "b", "BatchRequest", "ChannelSign", "FeedDetailRequestParam", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDetailBatchHttpTask implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$ChannelSign;", "", "guild_id", "", "channel_id", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannel_id", "()Ljava/lang/String;", "getGuild_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$FeedDetailRequestParam;", "", "userId", "", "feedId", WadlProxyConsts.CREATE_TIME, "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCreateTime", "()J", "getFeedId", "()Ljava/lang/String;", "getUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class FeedDetailRequestParam {
        private final long createTime;

        @NotNull
        private final String feedId;

        @NotNull
        private final String userId;

        public FeedDetailRequestParam(@NotNull String userId, @NotNull String feedId, long j3) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.userId = userId;
            this.feedId = feedId;
            this.createTime = j3;
        }

        public static /* synthetic */ FeedDetailRequestParam copy$default(FeedDetailRequestParam feedDetailRequestParam, String str, String str2, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = feedDetailRequestParam.userId;
            }
            if ((i3 & 2) != 0) {
                str2 = feedDetailRequestParam.feedId;
            }
            if ((i3 & 4) != 0) {
                j3 = feedDetailRequestParam.createTime;
            }
            return feedDetailRequestParam.copy(str, str2, j3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCreateTime() {
            return this.createTime;
        }

        @NotNull
        public final FeedDetailRequestParam copy(@NotNull String userId, @NotNull String feedId, long createTime) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            return new FeedDetailRequestParam(userId, feedId, createTime);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedDetailRequestParam)) {
                return false;
            }
            FeedDetailRequestParam feedDetailRequestParam = (FeedDetailRequestParam) other;
            if (Intrinsics.areEqual(this.userId, feedDetailRequestParam.userId) && Intrinsics.areEqual(this.feedId, feedDetailRequestParam.feedId) && this.createTime == feedDetailRequestParam.createTime) {
                return true;
            }
            return false;
        }

        public final long getCreateTime() {
            return this.createTime;
        }

        @NotNull
        public final String getFeedId() {
            return this.feedId;
        }

        @NotNull
        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (((this.userId.hashCode() * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime);
        }

        @NotNull
        public String toString() {
            return "FeedDetailRequestParam(userId=" + this.userId + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "exception", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f222764b;

        b(g gVar) {
            this.f222764b = gVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException exception) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(exception, "exception");
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "sendBatchRequest onFailure, exception " + exception;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedDetailBatchHttpTask", 1, (String) it.next(), null);
            }
            FeedDetailBatchHttpTask feedDetailBatchHttpTask = FeedDetailBatchHttpTask.this;
            g gVar = this.f222764b;
            int a16 = hj1.a.f405185a.a(exception);
            String localizedMessage = exception.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "IOException";
            }
            FeedDetailBatchHttpTask.i(feedDetailBatchHttpTask, gVar, new ResponseCode(a16, localizedMessage), null, 4, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            FeedDetailBatchHttpTask.this.f(response, this.f222764b);
        }
    }

    private final String c(List<GuildFeedDetailPreloadParams> params) {
        int collectionSizeOrDefault;
        String str;
        GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = params.get(0);
        ChannelSign channelSign = new ChannelSign(String.valueOf(guildFeedDetailPreloadParams.getGuildId()), String.valueOf(guildFeedDetailPreloadParams.getChannelId()));
        List<GuildFeedDetailPreloadParams> list = params;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (GuildFeedDetailPreloadParams guildFeedDetailPreloadParams2 : list) {
            arrayList.add(new FeedDetailRequestParam(guildFeedDetailPreloadParams2.getUserId(), guildFeedDetailPreloadParams2.getFeedId(), guildFeedDetailPreloadParams2.getCreateTime()));
        }
        try {
            str = new Gson().toJson(new BatchRequest(0, 0, arrayList, channelSign, 3, null));
            Intrinsics.checkNotNullExpressionValue(str, "Gson().toJson(BatchReque\u2026annelSign = channelSign))");
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "covertToBatchRequestBody error " + e16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedDetailBatchHttpTask", 1, (String) it.next(), null);
            }
            str = "";
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("FeedDetailBatchHttpTask", 2, "covertToBatchRequestBody " + ((Object) str));
        }
        return str;
    }

    private final String d(String str) {
        Object obj;
        String str2 = null;
        try {
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] decode = Base64.decode(bytes, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(str.toByteArray(c\u2026UTF-8\")), Base64.DEFAULT)");
            obj = new String(decode, Charsets.UTF_8);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str3 = "decodeToString error " + e16;
            if (str3 instanceof String) {
                bVar.a().add(str3);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedDetailBatchHttpTask", 1, (String) it.next(), null);
            }
            obj = Unit.INSTANCE;
        }
        if (obj instanceof String) {
            str2 = (String) obj;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    private final String e() {
        return ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).getFeedDetailBatchPreloadUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(Response response, g callback) {
        String str;
        boolean z16;
        int code = response.code();
        if (code != 200) {
            i(this, callback, new ResponseCode(60002, "responseCode is " + code), null, 4, null);
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
            i(this, callback, new ResponseCode(60001, "responseBody is empty"), null, 4, null);
            return true;
        }
        GuildFeedDetailCacheResponse g16 = g(str);
        h(callback, g16.getError(), g16.getCacheList());
        return false;
    }

    private final GuildFeedDetailCacheResponse g(String responseBody) {
        int a16;
        JSONObject jSONObject;
        String str;
        JSONArray jSONArray;
        ResponseCode responseCode;
        boolean z16;
        boolean z17 = true;
        try {
            jSONObject = new JSONObject(responseBody);
            a16 = 0;
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "parseBatchResp covert root json error, " + ((Object) null);
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedDetailBatchHttpTask", 1, (String) it.next(), null);
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
            String str3 = "parseBatchResp error " + optJSONObject;
            if (str3 instanceof String) {
                bVar2.a().add(str3);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("FeedDetailBatchHttpTask", 1, (String) it5.next(), null);
            }
            return new GuildFeedDetailCacheResponse(null, 0L, new ResponseCode(i3, str), 0, 11, null);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("response");
        if (optJSONObject2 != null) {
            jSONArray = optJSONObject2.optJSONArray("feeds");
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return new GuildFeedDetailCacheResponse(null, 0L, new ResponseCode(60003, "feeds is invalid"), 0, 11, null);
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i16 = 0; i16 < length; i16++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
            String base64Str = jSONObject2.optString("feed", "");
            Intrinsics.checkNotNullExpressionValue(base64Str, "base64Str");
            if (base64Str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Logger logger3 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                String str4 = "decodeCacheData base64Str empty! " + jSONObject2;
                if (str4 instanceof String) {
                    bVar3.a().add(str4);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("FeedDetailBatchHttpTask", 1, (String) it6.next(), null);
                }
            } else {
                String optString = jSONObject2.optString("feed_id", "");
                Intrinsics.checkNotNullExpressionValue(optString, "feedObj.optString(\"feed_id\", \"\")");
                GuildFeedDetailCacheData guildFeedDetailCacheData = new GuildFeedDetailCacheData(optString, d(base64Str), null, jSONObject2.optLong("last_modified_time"), 4, null);
                if (!guildFeedDetailCacheData.isValid()) {
                    Logger logger4 = Logger.f235387a;
                    Logger.b bVar4 = new Logger.b();
                    String str5 = "decodeCacheData error " + jSONObject2;
                    if (str5 instanceof String) {
                        bVar4.a().add(str5);
                    }
                    Iterator<T> it7 = bVar4.a().iterator();
                    while (it7.hasNext()) {
                        Logger.f235387a.d().e("FeedDetailBatchHttpTask", 1, (String) it7.next(), null);
                    }
                } else {
                    arrayList.add(guildFeedDetailCacheData);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it8 = arrayList.iterator();
            while (true) {
                if (!it8.hasNext()) {
                    break;
                }
                if (!((GuildFeedDetailCacheData) it8.next()).isValid()) {
                    z17 = false;
                    break;
                }
            }
        }
        if (z17) {
            responseCode = new ResponseCode(0, "");
        } else {
            responseCode = new ResponseCode(60003, "feeds is invalid");
        }
        return new GuildFeedDetailCacheResponse(arrayList, 0L, responseCode, 0, 10, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        if (r10.getCode() == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(g callback, ResponseCode error, List<GuildFeedDetailCacheData> cacheList) {
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
            callback.a(z17, new GuildFeedDetailCacheResponse(cacheList, System.currentTimeMillis() - this.startTime, error, 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void i(FeedDetailBatchHttpTask feedDetailBatchHttpTask, g gVar, ResponseCode responseCode, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        feedDetailBatchHttpTask.h(gVar, responseCode, list);
    }

    @Override // com.tencent.mobileqq.guild.feed.preload.detail.d
    public void a(@NotNull List<GuildFeedDetailPreloadParams> params, @Nullable g callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.startTime = System.currentTimeMillis();
        if (!params.isEmpty()) {
            List<GuildFeedDetailPreloadParams> list = params;
            boolean z16 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!((GuildFeedDetailPreloadParams) it.next()).isValid()) {
                        z16 = true;
                        break;
                    }
                }
            }
            if (!z16) {
                String e16 = e();
                GuildFeedDetailOkHttpFactory guildFeedDetailOkHttpFactory = GuildFeedDetailOkHttpFactory.f222769a;
                OkHttpClient d16 = guildFeedDetailOkHttpFactory.d();
                Request b16 = guildFeedDetailOkHttpFactory.b(e16, GuildFeedDetailHttpUtil.f223767a.c(e16), c(params));
                if (b16 == null) {
                    i(this, callback, new ResponseCode(-8, "request is invalid"), null, 4, null);
                    return;
                } else {
                    d16.newCall(b16).enqueue(new b(callback));
                    return;
                }
            }
        }
        Logger.f235387a.d().d("FeedDetailBatchHttpTask", 1, "FeedDetailBatchHttpTask param list is empty or invalid");
        i(this, callback, new ResponseCode(-7, "param list is empty or invalid"), null, 4, null);
    }

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\tH\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$BatchRequest;", "", "from", "", "detail_type", "feed_param", "", "Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$FeedDetailRequestParam;", "channelSign", "Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$ChannelSign;", "(IILjava/util/List;Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$ChannelSign;)V", "getChannelSign", "()Lcom/tencent/mobileqq/guild/feed/preload/detail/FeedDetailBatchHttpTask$ChannelSign;", "getDetail_type", "()I", "getFeed_param", "()Ljava/util/List;", "getFrom", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class BatchRequest {

        @NotNull
        private final ChannelSign channelSign;
        private final int detail_type;

        @NotNull
        private final List<FeedDetailRequestParam> feed_param;
        private final int from;

        public BatchRequest(int i3, int i16, @NotNull List<FeedDetailRequestParam> feed_param, @NotNull ChannelSign channelSign) {
            Intrinsics.checkNotNullParameter(feed_param, "feed_param");
            Intrinsics.checkNotNullParameter(channelSign, "channelSign");
            this.from = i3;
            this.detail_type = i16;
            this.feed_param = feed_param;
            this.channelSign = channelSign;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BatchRequest copy$default(BatchRequest batchRequest, int i3, int i16, List list, ChannelSign channelSign, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = batchRequest.from;
            }
            if ((i17 & 2) != 0) {
                i16 = batchRequest.detail_type;
            }
            if ((i17 & 4) != 0) {
                list = batchRequest.feed_param;
            }
            if ((i17 & 8) != 0) {
                channelSign = batchRequest.channelSign;
            }
            return batchRequest.copy(i3, i16, list, channelSign);
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
        public final List<FeedDetailRequestParam> component3() {
            return this.feed_param;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final ChannelSign getChannelSign() {
            return this.channelSign;
        }

        @NotNull
        public final BatchRequest copy(int from, int detail_type, @NotNull List<FeedDetailRequestParam> feed_param, @NotNull ChannelSign channelSign) {
            Intrinsics.checkNotNullParameter(feed_param, "feed_param");
            Intrinsics.checkNotNullParameter(channelSign, "channelSign");
            return new BatchRequest(from, detail_type, feed_param, channelSign);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BatchRequest)) {
                return false;
            }
            BatchRequest batchRequest = (BatchRequest) other;
            if (this.from == batchRequest.from && this.detail_type == batchRequest.detail_type && Intrinsics.areEqual(this.feed_param, batchRequest.feed_param) && Intrinsics.areEqual(this.channelSign, batchRequest.channelSign)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ChannelSign getChannelSign() {
            return this.channelSign;
        }

        public final int getDetail_type() {
            return this.detail_type;
        }

        @NotNull
        public final List<FeedDetailRequestParam> getFeed_param() {
            return this.feed_param;
        }

        public final int getFrom() {
            return this.from;
        }

        public int hashCode() {
            return (((((this.from * 31) + this.detail_type) * 31) + this.feed_param.hashCode()) * 31) + this.channelSign.hashCode();
        }

        @NotNull
        public String toString() {
            return "BatchRequest(from=" + this.from + ", detail_type=" + this.detail_type + ", feed_param=" + this.feed_param + ", channelSign=" + this.channelSign + ")";
        }

        public /* synthetic */ BatchRequest(int i3, int i16, List list, ChannelSign channelSign, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 2 : i16, list, channelSign);
        }
    }
}
