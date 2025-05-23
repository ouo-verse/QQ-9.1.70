package com.tencent.mobileqq.guild.feed.feedsquare.extension;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.feed.feedsquare.extension.AutoPlayDispatcher;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\"J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u001a\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0014R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/extension/AutoPlayDispatcher;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "", h.F, "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "reason", "f", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "getCallback", "()Lkotlin/jvm/functions/Function0;", "callback", "e", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Z", "isPaused", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class AutoPlayDispatcher extends RecyclerView.OnScrollListener implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPaused;

    public static /* synthetic */ void g(AutoPlayDispatcher autoPlayDispatcher, boolean z16, String str, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            autoPlayDispatcher.f(z16, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchVisibleViewHolders");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AutoPlayDispatcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g(this$0, false, "onScrollStateChanged", 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AutoPlayDispatcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g(this$0, false, "onResume", 1, null);
    }

    protected void f(boolean force, @NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (this.isPaused) {
            Logger logger = Logger.f235387a;
            String h16 = h();
            if (QLog.isColorLevel()) {
                logger.d().d(h16, 2, "paused. not dispatch force=" + force + " reason=" + reason);
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        String h17 = h();
        if (QLog.isDevelopLevel()) {
            Log.d(h17, "dispatchVisibleViewHolders force=" + force + " reason=" + reason);
        }
        this.callback.invoke();
    }

    @NotNull
    protected String h() {
        return "GuildFeedSquareAutoPlayDispatcher";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState != 0) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: wj1.b
            @Override // java.lang.Runnable
            public final void run() {
                AutoPlayDispatcher.i(AutoPlayDispatcher.this);
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.removeOnScrollListener(this);
            }
            source.getLifecycle().removeObserver(this);
            this.recyclerView = null;
        }
        if (event == Lifecycle.Event.ON_RESUME) {
            this.isPaused = false;
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.post(new Runnable() { // from class: wj1.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutoPlayDispatcher.j(AutoPlayDispatcher.this);
                    }
                });
            }
        }
        if (event == Lifecycle.Event.ON_STOP || event == Lifecycle.Event.ON_PAUSE) {
            this.isPaused = true;
            Logger logger = Logger.f235387a;
            String h16 = h();
            if (QLog.isDevelopLevel()) {
                Log.d(h16, "stop event=" + event);
            }
        }
    }
}
