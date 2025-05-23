package com.tencent.mobileqq.vas.ui;

import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "()V", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState$Callback;", "addCallBack", "", "callback", "getChangingConfigurations", "", "invalidateSelf", "isReusable", "", "scheduleSelf", "what", "Ljava/lang/Runnable;", RemoteMessageConst.Notification.WHEN, "", "Callback", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class AbsDynamicDrawableState extends Drawable.ConstantState {

    @NotNull
    private final CopyOnWriteArrayList<WeakReference<Callback>> callbacks = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState$Callback;", "", "onInvalidateSelf", "", "onScheduleSelf", "what", "Ljava/lang/Runnable;", RemoteMessageConst.Notification.WHEN, "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface Callback {
        void onInvalidateSelf();

        void onScheduleSelf(@NotNull Runnable what, long when);
    }

    public final void addCallBack(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.callbacks) {
            this.callbacks.add(new WeakReference<>(callback));
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return 0;
    }

    public final void invalidateSelf() {
        synchronized (this.callbacks) {
            Iterator<T> it = this.callbacks.iterator();
            while (it.hasNext()) {
                Callback callback = (Callback) ((WeakReference) it.next()).get();
                if (callback != null) {
                    callback.onInvalidateSelf();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public abstract boolean isReusable();

    public final void scheduleSelf(@NotNull Runnable what, long when) {
        Intrinsics.checkNotNullParameter(what, "what");
        synchronized (this.callbacks) {
            Iterator<T> it = this.callbacks.iterator();
            while (it.hasNext()) {
                Callback callback = (Callback) ((WeakReference) it.next()).get();
                if (callback != null) {
                    callback.onScheduleSelf(what, when);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
