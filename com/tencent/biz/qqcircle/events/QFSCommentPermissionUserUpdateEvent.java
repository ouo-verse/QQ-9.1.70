package com.tencent.biz.qqcircle.events;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSCommentPermissionUserUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "(Landroid/content/Context;Landroid/content/Intent;)V", "getContext", "()Landroid/content/Context;", "getIntent", "()Landroid/content/Intent;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QFSCommentPermissionUserUpdateEvent extends SimpleBaseEvent {

    @NotNull
    private final Context context;

    @Nullable
    private final Intent intent;

    public QFSCommentPermissionUserUpdateEvent(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.intent = intent;
        this.mHashCode = context.hashCode();
    }

    public static /* synthetic */ QFSCommentPermissionUserUpdateEvent copy$default(QFSCommentPermissionUserUpdateEvent qFSCommentPermissionUserUpdateEvent, Context context, Intent intent, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = qFSCommentPermissionUserUpdateEvent.context;
        }
        if ((i3 & 2) != 0) {
            intent = qFSCommentPermissionUserUpdateEvent.intent;
        }
        return qFSCommentPermissionUserUpdateEvent.copy(context, intent);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Intent getIntent() {
        return this.intent;
    }

    @NotNull
    public final QFSCommentPermissionUserUpdateEvent copy(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new QFSCommentPermissionUserUpdateEvent(context, intent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSCommentPermissionUserUpdateEvent)) {
            return false;
        }
        QFSCommentPermissionUserUpdateEvent qFSCommentPermissionUserUpdateEvent = (QFSCommentPermissionUserUpdateEvent) other;
        if (Intrinsics.areEqual(this.context, qFSCommentPermissionUserUpdateEvent.context) && Intrinsics.areEqual(this.intent, qFSCommentPermissionUserUpdateEvent.intent)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final Intent getIntent() {
        return this.intent;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.context.hashCode() * 31;
        Intent intent = this.intent;
        if (intent == null) {
            hashCode = 0;
        } else {
            hashCode = intent.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "QFSCommentPermissionUserUpdateEvent(context=" + this.context + ", intent=" + this.intent + ")";
    }
}
