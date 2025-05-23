package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes27.dex */
public final class HandlerPoster extends AbsEventBatcher<PendingPost> {
    private final CopyOnWriteArraySet<PosterRunner> mPosterRunners;

    /* loaded from: classes27.dex */
    public interface PosterRunner {
        boolean acceptTag(Object obj);

        void run(@NonNull String str, @NonNull Dispatcher.Dispatchable dispatchable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerPoster(Looper looper, int i3) {
        super(looper, new PendingPostQueue(), i3);
        this.mPosterRunners = new CopyOnWriteArraySet<>();
    }

    private void notifyAllPosterRunner(@NonNull Object obj, @NonNull String str, @NonNull Dispatcher.Dispatchable dispatchable) {
        Iterator<PosterRunner> it = this.mPosterRunners.iterator();
        while (it.hasNext()) {
            PosterRunner next = it.next();
            if (next.acceptTag(obj)) {
                next.run(str, dispatchable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPosterRunner(PosterRunner posterRunner) {
        this.mPosterRunners.add(posterRunner);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(Object obj, String str, Dispatcher.Dispatchable dispatchable) {
        AssertUtils.checkNotNull(obj);
        AssertUtils.checkNotNull(str);
        AssertUtils.checkNotNull(dispatchable);
        enqueue(PendingPost.obtainPendingPost(obj, str, dispatchable));
    }

    void removePosterRunner(PosterRunner posterRunner) {
        this.mPosterRunners.remove(posterRunner);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.dispatch.AbsEventBatcher
    public void handleItem(PendingPost pendingPost) {
        AssertUtils.checkNotNull(pendingPost.group);
        AssertUtils.checkNotNull(pendingPost.dispatchable);
        notifyAllPosterRunner(pendingPost.tag, pendingPost.group, pendingPost.dispatchable);
        PendingPost.releasePendingPost(pendingPost);
    }
}
