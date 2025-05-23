package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSCommentEmojiAddedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "emojiUrl", "", "(Ljava/lang/String;)V", "getEmojiUrl", "()Ljava/lang/String;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSCommentEmojiAddedEvent extends SimpleBaseEvent {

    @NotNull
    private final String emojiUrl;

    public QFSCommentEmojiAddedEvent(@NotNull String emojiUrl) {
        Intrinsics.checkNotNullParameter(emojiUrl, "emojiUrl");
        this.emojiUrl = emojiUrl;
    }

    @NotNull
    public final String getEmojiUrl() {
        return this.emojiUrl;
    }
}
