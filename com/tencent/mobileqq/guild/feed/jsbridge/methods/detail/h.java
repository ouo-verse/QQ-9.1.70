package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailLikeEvent;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/h;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "doubleClickToLike";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDetailLikeEvent(0.0f, 0.0f, true));
        QLog.e("DoubleClickToLikeMethod", 1, " DoubleClickToLikeMethod  onInvoke");
        return true;
    }
}
