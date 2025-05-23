package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\"\u000e\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0004H&R\u0014\u0010\r\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0017\u001a\u00020\u00168&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010&\u001a\u0004\u0018\u00010!8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "", "", "panelId", "", "e", "", "why", "flag", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getState", "()I", "state", "b", "normalPanelHeight", "g", "stableKeyboardShowHeight", "j", "currentMaxExpandedHeight", "f", "expandedHeight", "", "isEnableInsetAnimationListener", "()Z", h.F, "(Z)V", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "getStateUpdateListener", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "d", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;)V", "stateUpdateListener", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "a", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "i", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;)V", "uiStateUpdater", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "", "", "height", "targetHeightHint", "", "a", "panelId", "targetHeight", "e", "f", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(int height, int targetHeightHint);

        void b();

        void e(int panelId, int targetHeight);

        void f();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;", "", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "b", "()Landroid/view/ViewGroup;", "inputPanelContainer", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {
        @NotNull
        ViewGroup b();

        @NotNull
        View getRoot();
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class d {
        public static /* synthetic */ void a(e eVar, String str, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                eVar.c(str, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideAllPanelAndKeyboard");
        }
    }

    @Nullable
    b a();

    int b();

    void c(@NotNull String why, int flag);

    void d(@Nullable a aVar);

    void e(int panelId);

    int f();

    int g();

    int getState();

    void h(boolean z16);

    void i(@Nullable b bVar);

    int j();

    void onDestroy();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "", "", "foldState", "keyboardHeight", "", "c", "state", "onStateChanged", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void c(int foldState, int keyboardHeight);

        void d();

        void onStateChanged(int state);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7749a {
            public static void a(@NotNull a aVar) {
            }
        }
    }
}
