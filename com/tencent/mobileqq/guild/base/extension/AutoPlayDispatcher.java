package com.tencent.mobileqq.guild.base.extension;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001(J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u001a\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0014R/\u0010\u001b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010'\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/base/extension/AutoPlayDispatcher;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "", "i", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "reason", "f", "Lkotlin/Function2;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "Lkotlin/jvm/functions/Function2;", tl.h.F, "()Lkotlin/jvm/functions/Function2;", "callback", "e", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Z", "j", "()Z", "setPaused", "(Z)V", "isPaused", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class AutoPlayDispatcher extends RecyclerView.OnScrollListener implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<List<? extends RecyclerView.ViewHolder>, Boolean, Unit> callback;

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
    public static final void k(AutoPlayDispatcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g(this$0, false, "onScrollStateChanged", 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AutoPlayDispatcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g(this$0, false, "onResume", 1, null);
    }

    protected void f(boolean force, @NotNull String reason) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (this.isPaused) {
            Logger logger = Logger.f235387a;
            String i3 = i();
            if (QLog.isColorLevel()) {
                logger.d().d(i3, 2, "paused. not dispatch force=" + force + " reason=" + reason);
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        String i16 = i();
        if (QLog.isDevelopLevel()) {
            Log.d(i16, "dispatchVisibleViewHolders force=" + force + " reason=" + reason);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        LinearLayoutManager linearLayoutManager = null;
        if (recyclerView2 != null) {
            layoutManager = recyclerView2.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager == null || (recyclerView = this.recyclerView) == null) {
            return;
        }
        IntRange intRange = new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(recyclerView.findViewHolderForAdapterPosition(((IntIterator) it).nextInt()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            it5.next();
        }
        this.callback.invoke(arrayList2, Boolean.valueOf(force));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @NotNull
    public final Function2<List<? extends RecyclerView.ViewHolder>, Boolean, Unit> h() {
        return this.callback;
    }

    @NotNull
    protected String i() {
        return "Guild.discovery.AutoPlayDispatcher";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j, reason: from getter */
    public final boolean getIsPaused() {
        return this.isPaused;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState != 0) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.base.extension.b
            @Override // java.lang.Runnable
            public final void run() {
                AutoPlayDispatcher.k(AutoPlayDispatcher.this);
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        List<? extends RecyclerView.ViewHolder> emptyList;
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
                recyclerView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.base.extension.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutoPlayDispatcher.l(AutoPlayDispatcher.this);
                    }
                });
            }
        }
        if (event == Lifecycle.Event.ON_STOP || event == Lifecycle.Event.ON_PAUSE) {
            Function2<List<? extends RecyclerView.ViewHolder>, Boolean, Unit> function2 = this.callback;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            function2.invoke(emptyList, Boolean.FALSE);
            this.isPaused = true;
            Logger logger = Logger.f235387a;
            String i3 = i();
            if (QLog.isDevelopLevel()) {
                Log.d(i3, "stop event=" + event);
            }
        }
    }
}
