package com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B!\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/j;", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "", "o0", "", "w", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/k;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/k;", "n0", "()Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/k;", "p0", "(Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/k;)V", "switchLayoutChangeListener", "Lmqq/util/WeakReference;", "Landroid/view/View;", "y", "Lmqq/util/WeakReference;", "switchBtnViewRef", "Landroid/view/View$OnLayoutChangeListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View$OnLayoutChangeListener;", "m0", "()Landroid/view/View$OnLayoutChangeListener;", "rightLayoutChangeListener", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "left", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "right", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b;Lcom/tencent/mobileqq/widget/listitem/x$c;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class j extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k switchLayoutChangeListener;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> switchBtnViewRef;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener rightLayoutChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/j$a", "Lcom/tencent/mobileqq/widget/listitem/g;", "Landroid/view/View;", "view", "", "M", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.mobileqq.widget.listitem.g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.widget.listitem.g
        public void M(@NotNull View view) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            j.this.switchBtnViewRef = new WeakReference(view);
            WeakReference weakReference = j.this.switchBtnViewRef;
            if (weakReference != null && (view2 = (View) weakReference.get()) != null) {
                view2.addOnLayoutChangeListener(j.this.m0());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/j$b", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "switchView", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@Nullable View switchView, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                WeakReference weakReference = j.this.switchBtnViewRef;
                if (weakReference != null) {
                    view = (View) weakReference.get();
                } else {
                    view = null;
                }
                if (view == null) {
                    if (switchView != null) {
                        switchView.removeOnLayoutChangeListener(this);
                        return;
                    }
                    return;
                }
                if (switchView != null && switchView.getWidth() != 0 && switchView.getHeight() != 0) {
                    QLog.i(j.this.TAG, 1, "switchView, width: " + switchView.getWidth() + ", height: " + switchView.getHeight());
                    k n06 = j.this.n0();
                    if (n06 != null) {
                        n06.a(switchView);
                    }
                    switchView.removeOnLayoutChangeListener(this);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, switchView, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(oldLeft), Integer.valueOf(oldTop), Integer.valueOf(oldRight), Integer.valueOf(oldBottom));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull x.b left, @NotNull x.c right, @Nullable QUIListItemAdapter qUIListItemAdapter) {
        super(left, right, qUIListItemAdapter);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, left, right, qUIListItemAdapter);
            return;
        }
        this.TAG = "FriendTimeConfig";
        this.rightLayoutChangeListener = new b();
        x.c O = O();
        if (O instanceof x.c.f) {
            O.b(new a());
        }
    }

    @NotNull
    public final View.OnLayoutChangeListener m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View.OnLayoutChangeListener) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.rightLayoutChangeListener;
    }

    @Nullable
    public final k n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (k) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.switchLayoutChangeListener;
    }

    public final void o0() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        WeakReference<View> weakReference = this.switchBtnViewRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.removeOnLayoutChangeListener(this.rightLayoutChangeListener);
        }
    }

    public final void p0(@Nullable k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) kVar);
        } else {
            this.switchLayoutChangeListener = kVar;
        }
    }
}
