package com.tencent.mobileqq.guild.feed.widget.comment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedDetailCommentDraftManager;", "Lcom/tencent/mobileqq/guild/feed/widget/comment/a;", "Landroidx/lifecycle/LifecycleObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/LifecycleOwner;", h.F, "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDetailCommentDraftManager extends com.tencent.mobileqq.guild.feed.widget.comment.a implements LifecycleObserver {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f224297i = new a(null);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner owner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedDetailCommentDraftManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public GuildFeedDetailCommentDraftManager(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        owner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        QLog.d("GuildFeedDetailCommentDraftManager", 1, "[clearDraft]");
        d();
        this.owner.getLifecycle().removeObserver(this);
    }
}
