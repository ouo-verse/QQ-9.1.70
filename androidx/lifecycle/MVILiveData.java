package androidx.lifecycle;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u000f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0012\b\u0012\u00060\tR\u00020\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Landroidx/lifecycle/MVILiveData;", "Landroidx/lifecycle/MutableLiveData;", "", "()V", "mCurrentVersion", "Ljava/util/concurrent/atomic/AtomicInteger;", "observerMap", "Ljava/util/WeakHashMap;", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/MVILiveData$MVIObserverWrapper;", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "removeObserver", HippyTextInputController.COMMAND_setValue, "value", "MVIObserverWrapper", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class MVILiveData extends MutableLiveData<Object> {
    private final AtomicInteger mCurrentVersion = new AtomicInteger(-1);
    private final WeakHashMap<Observer<Object>, MVIObserverWrapper> observerMap = new WeakHashMap<>();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Landroidx/lifecycle/MVILiveData$MVIObserverWrapper;", "Landroidx/lifecycle/Observer;", "", "observer", "version", "", "(Landroidx/lifecycle/MVILiveData;Landroidx/lifecycle/Observer;I)V", "mVersion", "equals", "", "other", "hashCode", "onChanged", "", "t", "mvi_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes.dex */
    private final class MVIObserverWrapper implements Observer<Object> {
        private int mVersion;
        private final Observer<Object> observer;
        final /* synthetic */ MVILiveData this$0;

        public MVIObserverWrapper(@NotNull MVILiveData mVILiveData, Observer<Object> observer, int i3) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.this$0 = mVILiveData;
            this.observer = observer;
            this.mVersion = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other != null && !(true ^ Intrinsics.areEqual(MVIObserverWrapper.class, other.getClass()))) {
                Observer<Object> observer = null;
                if (!(other instanceof MVIObserverWrapper)) {
                    other = null;
                }
                MVIObserverWrapper mVIObserverWrapper = (MVIObserverWrapper) other;
                Observer<Object> observer2 = this.observer;
                if (mVIObserverWrapper != null) {
                    observer = mVIObserverWrapper.observer;
                }
                return Intrinsics.areEqual(observer2, observer);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.observer);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Object t16) {
            if (this.this$0.mCurrentVersion.get() > this.mVersion) {
                this.observer.onChanged(t16);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NotNull LifecycleOwner owner, @NotNull Observer<Object> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        MVIObserverWrapper mVIObserverWrapper = new MVIObserverWrapper(this, observer, this.mCurrentVersion.get());
        super.observe(owner, mVIObserverWrapper);
        this.observerMap.put(observer, mVIObserverWrapper);
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(@NotNull Observer<Object> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        MVIObserverWrapper mVIObserverWrapper = new MVIObserverWrapper(this, observer, this.mCurrentVersion.get());
        super.observeForever(mVIObserverWrapper);
        this.observerMap.put(observer, mVIObserverWrapper);
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NotNull Observer<Object> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        MVIObserverWrapper remove = this.observerMap.remove(observer);
        if (remove != null) {
            super.removeObserver(remove);
        } else {
            super.removeObserver(observer);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(@NotNull Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mCurrentVersion.getAndIncrement();
        super.setValue(value);
    }
}
