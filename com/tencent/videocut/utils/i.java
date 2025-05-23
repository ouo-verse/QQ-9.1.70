package com.tencent.videocut.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0002\u000b\u001aB\u001d\b\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/videocut/utils/i;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "keyboardHeightInPx", "", "d", "c", "e", "onGlobalLayout", "Lcom/tencent/videocut/utils/i$b;", "listener", "a", "f", "", "Ljava/util/List;", "listeners", "I", "mFirstHeight", "lastSoftKeyboardHeightInPx", "Landroid/view/View;", tl.h.F, "Landroid/view/View;", "activityRootView", "", "i", "Z", "b", "()Z", "setSoftKeyboardOpened", "(Z)V", "isSoftKeyboardOpened", "<init>", "(Landroid/view/View;Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class i implements ViewTreeObserver.OnGlobalLayoutListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<b> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mFirstHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastSoftKeyboardHeightInPx;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View activityRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSoftKeyboardOpened;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/utils/i$a;", "", "", "KEYBOARD_HIDE_MAX_HEIGHT", "I", "KEYBOARD_OPEN_MIN_HEIGHT", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.videocut.utils.i$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/utils/i$b;", "", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public interface b {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int keyboardHeightInPx);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8351);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public i(@Nullable View view) {
        this(view, false, 2, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
    }

    private final void c() {
        Iterator<b> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSoftKeyboardClosed();
        }
    }

    private final void d(int keyboardHeightInPx) {
        this.lastSoftKeyboardHeightInPx = keyboardHeightInPx;
        Iterator<b> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSoftKeyboardOpened(keyboardHeightInPx);
        }
    }

    public final void a(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listeners.add(listener);
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSoftKeyboardOpened;
    }

    public final void e() {
        ViewTreeObserver viewTreeObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.listeners.clear();
        View view = this.activityRootView;
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        this.activityRootView = null;
    }

    public final void f(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        List<b> list = this.listeners;
        if (list != null) {
            TypeIntrinsics.asMutableCollection(list).remove(listener);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Rect rect = new Rect();
        View view = this.activityRootView;
        if (view != null) {
            view.getWindowVisibleDisplayFrame(rect);
        }
        int height = rect.height();
        int i3 = this.mFirstHeight;
        if (i3 == 0) {
            this.mFirstHeight = height;
            return;
        }
        int i16 = i3 - height;
        boolean z16 = this.isSoftKeyboardOpened;
        if (!z16 && i16 >= 250) {
            this.isSoftKeyboardOpened = true;
            d(i16);
        } else if (z16 && i16 < 100) {
            this.isSoftKeyboardOpened = false;
            c();
        }
    }

    @JvmOverloads
    public i(@Nullable View view, boolean z16) {
        ViewTreeObserver viewTreeObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Boolean.valueOf(z16));
            return;
        }
        this.activityRootView = view;
        this.isSoftKeyboardOpened = z16;
        this.listeners = new LinkedList();
        View view2 = this.activityRootView;
        if (view2 == null || (viewTreeObserver = view2.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    public /* synthetic */ i(View view, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i3 & 2) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, view, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
