package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB'\b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bB\t\b\u0016\u00a2\u0006\u0004\b\u0007\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSCommentInputButNotSendEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "showAt", "Z", "showEmoji", "showImage", "<init>", "(ZZZ)V", "()V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentInputButNotSendEvent extends SimpleBaseEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public final boolean showAt;

    @JvmField
    public final boolean showEmoji;

    @JvmField
    public final boolean showImage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSCommentInputButNotSendEvent$a;", "", "Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSCommentInputButNotSendEvent;", "a", "b", "c", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.event.QFSCommentInputButNotSendEvent$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QFSCommentInputButNotSendEvent a() {
            return new QFSCommentInputButNotSendEvent(true, false, false, 6, null);
        }

        @NotNull
        public final QFSCommentInputButNotSendEvent b() {
            return new QFSCommentInputButNotSendEvent(false, true, false, 5, null);
        }

        @NotNull
        public final QFSCommentInputButNotSendEvent c() {
            return new QFSCommentInputButNotSendEvent(false, false, true, 3, null);
        }

        Companion() {
        }
    }

    /* synthetic */ QFSCommentInputButNotSendEvent(boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18);
    }

    QFSCommentInputButNotSendEvent(boolean z16, boolean z17, boolean z18) {
        this.showAt = z16;
        this.showEmoji = z17;
        this.showImage = z18;
    }

    public QFSCommentInputButNotSendEvent() {
        this(false, false, false);
    }
}
