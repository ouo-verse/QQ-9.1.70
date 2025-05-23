package com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "CheckPublishRestriction", "FindPublishInterceptor", "RebindMainTaskToCurrentGuildInfo", "TriggerPublish", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$CheckPublishRestriction;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$FindPublishInterceptor;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$RebindMainTaskToCurrentGuildInfo;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$TriggerPublish;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class PublishFeedMsgIntent implements MsgIntent {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$CheckPublishRestriction;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "feedJsonString", "Lorg/json/JSONObject;", "e", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "jsonFeedKeyJsonObject", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class CheckPublishRestriction extends PublishFeedMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedJsonString;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final JSONObject jsonFeedKeyJsonObject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckPublishRestriction(@NotNull String feedJsonString, @NotNull JSONObject jsonFeedKeyJsonObject) {
            super(null);
            Intrinsics.checkNotNullParameter(feedJsonString, "feedJsonString");
            Intrinsics.checkNotNullParameter(jsonFeedKeyJsonObject, "jsonFeedKeyJsonObject");
            this.feedJsonString = feedJsonString;
            this.jsonFeedKeyJsonObject = jsonFeedKeyJsonObject;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFeedJsonString() {
            return this.feedJsonString;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final JSONObject getJsonFeedKeyJsonObject() {
            return this.jsonFeedKeyJsonObject;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckPublishRestriction)) {
                return false;
            }
            CheckPublishRestriction checkPublishRestriction = (CheckPublishRestriction) other;
            if (Intrinsics.areEqual(this.feedJsonString, checkPublishRestriction.feedJsonString) && Intrinsics.areEqual(this.jsonFeedKeyJsonObject, checkPublishRestriction.jsonFeedKeyJsonObject)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.feedJsonString.hashCode() * 31) + this.jsonFeedKeyJsonObject.hashCode();
        }

        @NotNull
        public String toString() {
            return "CheckPublishRestriction(feedJsonString=" + this.feedJsonString + ", jsonFeedKeyJsonObject=" + this.jsonFeedKeyJsonObject + ")";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bRE\u0010\u0011\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\rj\u0002`\u000e0\f8\u0002@\u0002X\u0082\u000e\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R@\u0010\u0015\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\rj\u0002`\u000e0\u00128F\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$FindPublishInterceptor;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent;", "", "priority", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "interceptor", "", "a", "(ILkotlin/jvm/functions/Function1;)V", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/FindPublishInterceptorRecord;", "d", "Ljava/util/List;", "_interceptors", "", "b", "()Ljava/util/List;", "interceptors", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class FindPublishInterceptor extends PublishFeedMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<Pair<Integer, Function1<Continuation<? super Boolean>, Object>>> _interceptors;

        public FindPublishInterceptor() {
            super(null);
            this._interceptors = new LinkedList();
        }

        public final void a(int priority, @NotNull Function1<? super Continuation<? super Boolean>, ? extends Object> interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this._interceptors.add(TuplesKt.to(Integer.valueOf(priority), interceptor));
        }

        @NotNull
        public final List<Pair<Integer, Function1<Continuation<? super Boolean>, Object>>> b() {
            return this._interceptors;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent.FindPublishInterceptor";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$RebindMainTaskToCurrentGuildInfo;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class RebindMainTaskToCurrentGuildInfo extends PublishFeedMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RebindMainTaskToCurrentGuildInfo f222234d = new RebindMainTaskToCurrentGuildInfo();

        RebindMainTaskToCurrentGuildInfo() {
            super(null);
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent$TriggerPublish;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/msgintent/PublishFeedMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class TriggerPublish extends PublishFeedMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final TriggerPublish f222235d = new TriggerPublish();

        TriggerPublish() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent.TriggerPublish";
        }
    }

    public /* synthetic */ PublishFeedMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    PublishFeedMsgIntent() {
    }
}
