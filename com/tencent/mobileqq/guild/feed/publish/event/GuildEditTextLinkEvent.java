package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/GuildEditTextLinkEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "url", "", "desc", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getUrl", "setUrl", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildEditTextLinkEvent extends SimpleBaseEvent {

    @NotNull
    private String desc;

    @NotNull
    private String url;

    public GuildEditTextLinkEvent(@NotNull String url, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.url = url;
        this.desc = desc;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final void setDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "GuildEditTextLinkEvent{url='" + this.url + "', desc='" + this.desc + "'}";
    }
}
