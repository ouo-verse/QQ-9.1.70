package com.tencent.robot.widget.bottomdialog;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ml3.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\rR2\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/DefaultFunctionEmitter;", "T", "Lml3/a;", "callback", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "b", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;)V", "", "c", "(Ljava/lang/Object;)Z", "a", "(Ljava/lang/Object;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setMFunctionsCallbacks", "(Ljava/util/ArrayList;)V", "mFunctionsCallbacks", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class DefaultFunctionEmitter<T> implements a<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<T> mFunctionsCallbacks = new ArrayList<>();

    @Override // ml3.a
    public void a(T callback) {
        ArrayList<T> arrayList = this.mFunctionsCallbacks;
        if (!(!arrayList.contains(callback))) {
            arrayList = null;
        }
        if (arrayList != null) {
            arrayList.add(callback);
        }
    }

    @Override // ml3.a
    public void b(final T callback, @NotNull final LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifeCycleWrapperObserver lifeCycleWrapperObserver = new LifeCycleWrapperObserver(lifecycleOwner) { // from class: com.tencent.robot.widget.bottomdialog.DefaultFunctionEmitter$addCallBack$1
            @Override // com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver
            public void onDestroy() {
                this.c(callback);
            }
        };
        if (!lifeCycleWrapperObserver.a()) {
            lifeCycleWrapperObserver = null;
        }
        if (lifeCycleWrapperObserver != null) {
            lifecycleOwner.getLifecycle().addObserver(lifeCycleWrapperObserver);
            a(callback);
        }
    }

    @Override // ml3.a
    public boolean c(T callback) {
        if (this.mFunctionsCallbacks.contains(callback)) {
            this.mFunctionsCallbacks.remove(callback);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<T> d() {
        return this.mFunctionsCallbacks;
    }
}
