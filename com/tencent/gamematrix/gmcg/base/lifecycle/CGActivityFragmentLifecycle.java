package com.tencent.gamematrix.gmcg.base.lifecycle;

import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.base.utils.CGCollectionUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGActivityFragmentLifecycle implements CGLifecycle {
    private final Set<CGLifecycleListener> mLifecycleListeners = Collections.newSetFromMap(new WeakHashMap());
    boolean mIsPaused = false;
    boolean mIsStopped = false;

    @Override // com.tencent.gamematrix.gmcg.base.lifecycle.CGLifecycle
    public void addListener(@NonNull CGLifecycleListener cGLifecycleListener) {
        this.mLifecycleListeners.add(cGLifecycleListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroy() {
        Iterator it = CGCollectionUtil.getSnapshot(this.mLifecycleListeners).iterator();
        while (it.hasNext()) {
            ((CGLifecycleListener) it.next()).onActivityLifecycleDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPause() {
        this.mIsPaused = true;
        Iterator it = CGCollectionUtil.getSnapshot(this.mLifecycleListeners).iterator();
        while (it.hasNext()) {
            ((CGLifecycleListener) it.next()).onActivityLifecyclePause();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume() {
        if (!this.mIsPaused) {
            return;
        }
        this.mIsPaused = false;
        Iterator it = CGCollectionUtil.getSnapshot(this.mLifecycleListeners).iterator();
        while (it.hasNext()) {
            ((CGLifecycleListener) it.next()).onActivityLifecycleResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStart() {
        if (!this.mIsStopped) {
            return;
        }
        this.mIsStopped = false;
        Iterator it = CGCollectionUtil.getSnapshot(this.mLifecycleListeners).iterator();
        while (it.hasNext()) {
            ((CGLifecycleListener) it.next()).onActivityLifecycleStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStop() {
        this.mIsStopped = true;
        Iterator it = CGCollectionUtil.getSnapshot(this.mLifecycleListeners).iterator();
        while (it.hasNext()) {
            ((CGLifecycleListener) it.next()).onActivityLifecycleStop();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.base.lifecycle.CGLifecycle
    public void removeListener(@NonNull CGLifecycleListener cGLifecycleListener) {
        this.mLifecycleListeners.remove(cGLifecycleListener);
    }
}
