package com.tencent.mobileqq.vas.ui;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u001d\u001e\u001fB\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\r\u0010\u0015\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0007J\r\u0010\u0016\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0012H$J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\fH$R*\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "T", "", "()V", "value", "currentObject", "getCurrentObject", "()Ljava/lang/Object;", "setCurrentObject", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "failedBuilder", "Lkotlin/Function0;", "getFailedBuilder", "()Lkotlin/jvm/functions/Function0;", "sucessedBuilder", "getSucessedBuilder", "build", "", "loader", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "doFailedBuilder", "doSucessedBuilder", "loadAndRefresh", "onCurrentObjectChanged", "onLoadFailed", "onLoadSucceed", "onPostLoaderTask", "block", "Loader", "LoaderCallback", "MyLoaderCallback", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class AbsAsyncLoadProxy<T> {

    @Nullable
    private T currentObject;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "", "isLoaded", "", "syncLoad", "", "callback", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface Loader {
        boolean isLoaded();

        void syncLoad(@NotNull LoaderCallback callback);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "", "onLoadFailed", "", "onLoadSucceed", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface LoaderCallback {
        void onLoadFailed();

        void onLoadSucceed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$MyLoaderCallback;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadFailed", "", "onLoadSucceed", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class MyLoaderCallback implements LoaderCallback {

        @NotNull
        private final WeakReference<AbsAsyncLoadProxy<?>> drawableRef;

        public MyLoaderCallback(@NotNull WeakReference<AbsAsyncLoadProxy<?>> drawableRef) {
            Intrinsics.checkNotNullParameter(drawableRef, "drawableRef");
            this.drawableRef = drawableRef;
        }

        @NotNull
        public final WeakReference<AbsAsyncLoadProxy<?>> getDrawableRef() {
            return this.drawableRef;
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.LoaderCallback
        public void onLoadFailed() {
            AbsAsyncLoadProxy<?> absAsyncLoadProxy = this.drawableRef.get();
            if (absAsyncLoadProxy != null) {
                absAsyncLoadProxy.onLoadFailed();
            }
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.LoaderCallback
        public void onLoadSucceed() {
            AbsAsyncLoadProxy<?> absAsyncLoadProxy = this.drawableRef.get();
            if (absAsyncLoadProxy != null) {
                absAsyncLoadProxy.onLoadSucceed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadAndRefresh(Loader loader) {
        MyLoaderCallback myLoaderCallback = new MyLoaderCallback(new WeakReference(this));
        if (!loader.isLoaded()) {
            loader.syncLoad(myLoaderCallback);
        } else {
            myLoaderCallback.onLoadSucceed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadFailed() {
        if (this.currentObject == null) {
            setCurrentObject(doFailedBuilder());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadSucceed() {
        T doSucessedBuilder = doSucessedBuilder();
        if (doSucessedBuilder != null) {
            setCurrentObject(doSucessedBuilder);
        }
        if (this.currentObject == null) {
            setCurrentObject(doFailedBuilder());
        }
    }

    private final void setCurrentObject(T t16) {
        if (!Intrinsics.areEqual(t16, this.currentObject)) {
            this.currentObject = t16;
            onCurrentObjectChanged();
        }
    }

    public final void build(@NotNull final Loader loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        if (!loader.isLoaded()) {
            onLoadFailed();
        }
        if (loader.isLoaded()) {
            loadAndRefresh(loader);
        } else {
            onPostLoaderTask(new Function0<Unit>(this) { // from class: com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy$build$1
                final /* synthetic */ AbsAsyncLoadProxy<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.loadAndRefresh(loader);
                }
            });
        }
    }

    @Nullable
    public final T doFailedBuilder() {
        try {
            return getFailedBuilder().invoke();
        } catch (Throwable th5) {
            if (!com.tencent.mobileqq.vas.api.g.f308459b.isDebugVersion()) {
                return null;
            }
            throw new RuntimeException(th5);
        }
    }

    @Nullable
    public final T doSucessedBuilder() {
        try {
            return getSucessedBuilder().invoke();
        } catch (Throwable th5) {
            if (!com.tencent.mobileqq.vas.api.g.f308459b.isDebugVersion()) {
                return null;
            }
            throw new RuntimeException(th5);
        }
    }

    @Nullable
    public final T getCurrentObject() {
        return this.currentObject;
    }

    @NotNull
    public abstract Function0<T> getFailedBuilder();

    @NotNull
    public abstract Function0<T> getSucessedBuilder();

    protected abstract void onCurrentObjectChanged();

    protected abstract void onPostLoaderTask(@NotNull Function0<Unit> block);
}
