package com.tencent.richframework.compat.immersive;

import android.util.Pair;
import android.view.View;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0002\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R0\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0002\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/richframework/compat/immersive/WindowColorFetcherState;", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/Window;", "windowWrf", "Ljava/lang/ref/WeakReference;", "getWindowWrf", "()Ljava/lang/ref/WeakReference;", "setWindowWrf", "(Ljava/lang/ref/WeakReference;)V", "", "hasSetStatusBarTextColor", "Z", "getHasSetStatusBarTextColor", "()Z", "setHasSetStatusBarTextColor", "(Z)V", "", "Landroid/view/View;", "statusAreaViews", "Ljava/util/List;", "getStatusAreaViews", "()Ljava/util/List;", "setStatusAreaViews", "(Ljava/util/List;)V", "Landroid/util/Pair;", "", "statusBarColorResult", "Landroid/util/Pair;", "getStatusBarColorResult", "()Landroid/util/Pair;", "setStatusBarColorResult", "(Landroid/util/Pair;)V", "hasSetNavigatorBarColor", "getHasSetNavigatorBarColor", "setHasSetNavigatorBarColor", "navigatorAreaViews", "getNavigatorAreaViews", "setNavigatorAreaViews", "navigatorColorResult", "getNavigatorColorResult", "setNavigatorColorResult", "<init>", "()V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class WindowColorFetcherState {
    private boolean hasSetNavigatorBarColor;
    private boolean hasSetStatusBarTextColor;

    @Nullable
    private List<? extends WeakReference<View>> navigatorAreaViews;

    @Nullable
    private Pair<Boolean, Integer> navigatorColorResult;

    @Nullable
    private List<? extends WeakReference<View>> statusAreaViews;

    @Nullable
    private Pair<Boolean, Integer> statusBarColorResult;

    @Nullable
    private WeakReference<Window> windowWrf;

    public final void setHasSetNavigatorBarColor(boolean z16) {
        this.hasSetNavigatorBarColor = z16;
    }

    public final void setHasSetStatusBarTextColor(boolean z16) {
        this.hasSetStatusBarTextColor = z16;
    }

    public final void setNavigatorAreaViews(@Nullable List<? extends WeakReference<View>> list) {
        this.navigatorAreaViews = list;
    }

    public final void setNavigatorColorResult(@Nullable Pair<Boolean, Integer> pair) {
        this.navigatorColorResult = pair;
    }

    public final void setStatusAreaViews(@Nullable List<? extends WeakReference<View>> list) {
        this.statusAreaViews = list;
    }

    public final void setStatusBarColorResult(@Nullable Pair<Boolean, Integer> pair) {
        this.statusBarColorResult = pair;
    }

    public final void setWindowWrf(@Nullable WeakReference<Window> weakReference) {
        this.windowWrf = weakReference;
    }
}
