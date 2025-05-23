package com.tencent.mobileqq.reminder.chats.notifycard.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 &2\u00020\u0001:\u0002\u0007\u0005B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b+\u0010,J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010(\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0013\u0010*\u001a\u0004\u0018\u00010\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;", "", "", "textId", "", "b", "bgId", "a", "", "text", "e", "", "intervalMs", "Landroid/view/View$OnClickListener;", "listener", "g", "Landroid/view/View;", "Landroid/view/View;", "mBtnRoot", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mBtnText", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "mBtnBg", "", "enable", "isEnabled", "()Z", "f", "(Z)V", "value", "getVisibility", "()I", "i", "(I)V", "visibility", "d", "()Landroid/view/View;", "root", "()Landroid/widget/ImageView;", "btnBg", "<init>", "(Landroid/view/View;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mBtnRoot;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mBtnText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mBtnBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b$a;", "", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "rootId", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b;", "a", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.view.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final b a(@NotNull View parent, int rootId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, rootId);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            View findViewById = parent.findViewById(rootId);
            if (findViewById == null) {
                return null;
            }
            return new b(findViewById);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/b$b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "", "d", "J", "getIntervalMs", "()J", "intervalMs", "e", "Landroid/view/View$OnClickListener;", "getListener", "()Landroid/view/View$OnClickListener;", "listener", "f", "getLastClickTimestamp", "setLastClickTimestamp", "(J)V", "lastClickTimestamp", "<init>", "(JLandroid/view/View$OnClickListener;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class ViewOnClickListenerC8507b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long intervalMs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View.OnClickListener listener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long lastClickTimestamp;

        public ViewOnClickListenerC8507b(long j3, @NotNull View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), listener);
            } else {
                this.intervalMs = j3;
                this.listener = listener;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lastClickTimestamp > this.intervalMs) {
                    this.lastClickTimestamp = currentTimeMillis;
                    this.listener.onClick(v3);
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull View mBtnRoot) {
        Intrinsics.checkNotNullParameter(mBtnRoot, "mBtnRoot");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mBtnRoot);
        } else {
            this.mBtnRoot = mBtnRoot;
        }
    }

    public static /* synthetic */ void h(b bVar, long j3, View.OnClickListener onClickListener, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        bVar.g(j3, onClickListener);
    }

    public final void a(int bgId) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, bgId);
            return;
        }
        View findViewById = this.mBtnRoot.findViewById(bgId);
        if (findViewById instanceof ImageView) {
            imageView = (ImageView) findViewById;
        } else {
            imageView = null;
        }
        this.mBtnBg = imageView;
    }

    public final void b(int textId) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, textId);
            return;
        }
        View findViewById = this.mBtnRoot.findViewById(textId);
        if (findViewById instanceof TextView) {
            textView = (TextView) findViewById;
        } else {
            textView = null;
        }
        this.mBtnText = textView;
    }

    @Nullable
    public final ImageView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ImageView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mBtnBg;
    }

    @NotNull
    public final View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mBtnRoot;
    }

    public final void e(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.mBtnText;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public final void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mBtnRoot.setEnabled(z16);
        }
    }

    public final void g(long intervalMs, @Nullable View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(intervalMs), listener);
            return;
        }
        if (intervalMs > 0 && listener != null) {
            listener = new ViewOnClickListenerC8507b(intervalMs, listener);
        }
        this.mBtnRoot.setOnClickListener(listener);
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mBtnRoot.setVisibility(i3);
        }
    }
}
