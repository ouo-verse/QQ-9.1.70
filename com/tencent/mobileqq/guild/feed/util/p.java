package com.tencent.mobileqq.guild.feed.util;

import com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Ljj1/b;", "", "key", "", "value", "", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class p {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/util/p$a", "Lcom/tencent/mobileqq/guild/feed/data/datacenter/datastore/GuildFeedTempDataStore$b;", "", "", "d", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "e", "Ljava/lang/Object;", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedTempDataStore.b<Object> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String key;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object value;

        a(String str, Object obj) {
            this.key = str;
            this.value = obj;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore.b
        @NotNull
        public String getKey() {
            return this.key;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore.b
        @NotNull
        public Object getValue() {
            return this.value;
        }
    }

    public static final void a(@NotNull jj1.b bVar, @NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bVar.addData("GuildFeedTempDataStore", new a(key, value));
    }
}
