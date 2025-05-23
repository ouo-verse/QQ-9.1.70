package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Executor f69652a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Executor f69653b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final DiffUtil.ItemCallback<T> f69654c;

    /* compiled from: P */
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0643a<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private static final Object f69655d;

        /* renamed from: e, reason: collision with root package name */
        private static Executor f69656e;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private Executor f69657a;

        /* renamed from: b, reason: collision with root package name */
        private Executor f69658b;

        /* renamed from: c, reason: collision with root package name */
        private final DiffUtil.ItemCallback<T> f69659c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11055);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                f69655d = new Object();
                f69656e = null;
            }
        }

        public C0643a(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemCallback);
            } else {
                this.f69659c = itemCallback;
            }
        }

        @NonNull
        public a<T> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (this.f69658b == null) {
                synchronized (f69655d) {
                    if (f69656e == null) {
                        f69656e = ProxyExecutors.newFixedThreadPool(2);
                    }
                }
                this.f69658b = f69656e;
            }
            return new a<>(this.f69657a, this.f69658b, this.f69659c);
        }
    }

    a(@Nullable Executor executor, @NonNull Executor executor2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, executor, executor2, itemCallback);
            return;
        }
        this.f69652a = executor;
        this.f69653b = executor2;
        this.f69654c = itemCallback;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DiffUtil.ItemCallback) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f69654c;
    }
}
