package com.tencent.mobileqq.matchfriend.reborn.content;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/QQStrangerAvatarUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "openId", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getOpenId", "()Ljava/lang/String;", "getUrl", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerAvatarUpdateEvent extends SimpleBaseEvent {
    private final String openId;
    private final String url;

    public QQStrangerAvatarUpdateEvent(String openId, String url) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(url, "url");
        this.openId = openId;
        this.url = url;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final String getUrl() {
        return this.url;
    }
}
