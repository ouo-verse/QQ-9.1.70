package com.tencent.android.androidbypass.parser;

import androidx.annotation.ColorRes;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.android.androidbypass.enhance.g;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.span.ClickableUrlSpan;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\b\u001d\u0011B\u0011\u0012\b\b\u0002\u0010 \u001a\u00020\u001e\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0015J\u0014\u0010\u0019\u001a\u00020\u00002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/android/androidbypass/parser/d;", "", "", "Lcom/tencent/android/androidbypass/parser/api/b;", "listenerList", "e", "Lcom/tencent/android/androidbypass/span/ClickableUrlSpan$a;", "listener", "a", "Ltt/a;", "f", "", "colorRes", "j", "Lcom/tencent/android/androidbypass/e;", "d", "Lst/a;", "c", "Lcom/tencent/android/androidbypass/enhance/g;", "urlToDrawable", "k", "Lcom/tencent/android/androidbypass/enhance/i;", "i", "Lut/a;", "renderList", "g", "styleSheet", h.F, "Lcom/tencent/android/androidbypass/parser/a;", "b", "Lcom/tencent/android/androidbypass/parser/d$b;", "Lcom/tencent/android/androidbypass/parser/d$b;", "builderOptions", "<init>", "(Lcom/tencent/android/androidbypass/parser/d$b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b builderOptions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/parser/d$a;", "", "Lst/a;", "a", "Lst/a;", "()Lst/a;", "b", "(Lst/a;)V", "codeBlockHighlightListener", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private st.a codeBlockHighlightListener;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Nullable
        public final st.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (st.a) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.codeBlockHighlightListener;
        }

        public final void b(@Nullable st.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                this.codeBlockHighlightListener = aVar;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\bD\u0010ER$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0012\u0010#\"\u0004\b$\u0010%R$\u0010,\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010(\u001a\u0004\b!\u0010)\"\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010=\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b7\u0010;\u001a\u0004\b\f\u0010<R$\u0010C\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010?\u001a\u0004\b5\u0010@\"\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/android/androidbypass/parser/d$b;", "", "Lcom/tencent/android/androidbypass/e;", "a", "Lcom/tencent/android/androidbypass/e;", "d", "()Lcom/tencent/android/androidbypass/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/android/androidbypass/e;)V", "imageClickListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/android/androidbypass/parser/api/b;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "onSchemeClickListeners", "Lcom/tencent/android/androidbypass/span/ClickableUrlSpan$a;", "c", "Lcom/tencent/android/androidbypass/span/ClickableUrlSpan$a;", "()Lcom/tencent/android/androidbypass/span/ClickableUrlSpan$a;", "k", "(Lcom/tencent/android/androidbypass/span/ClickableUrlSpan$a;)V", "allLinkClickListener", "Ltt/a;", "Ltt/a;", "g", "()Ltt/a;", "o", "(Ltt/a;)V", "reservedHiddenLinkClickListener", "", "Lut/a;", "e", "Ljava/util/List;", "()Ljava/util/List;", "l", "(Ljava/util/List;)V", "hiddenLinkRender", "Lcom/tencent/android/androidbypass/Bypass$e;", "Lcom/tencent/android/androidbypass/Bypass$e;", "()Lcom/tencent/android/androidbypass/Bypass$e;", DomainData.DOMAIN_NAME, "(Lcom/tencent/android/androidbypass/Bypass$e;)V", "imageGetter", "Lcom/tencent/android/androidbypass/enhance/g;", "Lcom/tencent/android/androidbypass/enhance/g;", "j", "()Lcom/tencent/android/androidbypass/enhance/g;", "p", "(Lcom/tencent/android/androidbypass/enhance/g;)V", "urlDrawableLoader", "Lcom/tencent/android/androidbypass/parser/d$c;", h.F, "Lcom/tencent/android/androidbypass/parser/d$c;", "i", "()Lcom/tencent/android/androidbypass/parser/d$c;", "uiOption", "Lcom/tencent/android/androidbypass/parser/d$a;", "Lcom/tencent/android/androidbypass/parser/d$a;", "()Lcom/tencent/android/androidbypass/parser/d$a;", "codeBlockOption", "Lcom/tencent/android/androidbypass/richui/c;", "Lcom/tencent/android/androidbypass/richui/c;", "()Lcom/tencent/android/androidbypass/richui/c;", "setRichUIFactory", "(Lcom/tencent/android/androidbypass/richui/c;)V", "richUIFactory", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.android.androidbypass.e imageClickListener;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CopyOnWriteArrayList<com.tencent.android.androidbypass.parser.api.b> onSchemeClickListeners;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ClickableUrlSpan.a allLinkClickListener;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private tt.a reservedHiddenLinkClickListener;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<? extends ut.a> hiddenLinkRender;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bypass.e imageGetter;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private g urlDrawableLoader;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c uiOption;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a codeBlockOption;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.android.androidbypass.richui.c richUIFactory;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this);
                return;
            }
            this.onSchemeClickListeners = new CopyOnWriteArrayList<>();
            this.uiOption = new c();
            this.codeBlockOption = new a();
        }

        @Nullable
        public final ClickableUrlSpan.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ClickableUrlSpan.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.allLinkClickListener;
        }

        @NotNull
        public final a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (a) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return this.codeBlockOption;
        }

        @Nullable
        public final List<ut.a> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (List) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.hiddenLinkRender;
        }

        @Nullable
        public final com.tencent.android.androidbypass.e d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.android.androidbypass.e) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.imageClickListener;
        }

        @Nullable
        public final Bypass.e e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Bypass.e) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.imageGetter;
        }

        @NotNull
        public final CopyOnWriteArrayList<com.tencent.android.androidbypass.parser.api.b> f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.onSchemeClickListeners;
        }

        @Nullable
        public final tt.a g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (tt.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.reservedHiddenLinkClickListener;
        }

        @Nullable
        public final com.tencent.android.androidbypass.richui.c h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (com.tencent.android.androidbypass.richui.c) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.richUIFactory;
        }

        @NotNull
        public final c i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (c) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.uiOption;
        }

        @Nullable
        public final g j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (g) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.urlDrawableLoader;
        }

        public final void k(@Nullable ClickableUrlSpan.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            } else {
                this.allLinkClickListener = aVar;
            }
        }

        public final void l(@Nullable List<? extends ut.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            } else {
                this.hiddenLinkRender = list;
            }
        }

        public final void m(@Nullable com.tencent.android.androidbypass.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                this.imageClickListener = eVar;
            }
        }

        public final void n(@Nullable Bypass.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) eVar);
            } else {
                this.imageGetter = eVar;
            }
        }

        public final void o(@Nullable tt.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            } else {
                this.reservedHiddenLinkClickListener = aVar;
            }
        }

        public final void p(@Nullable g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) gVar);
            } else {
                this.urlDrawableLoader = gVar;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/android/androidbypass/parser/d$c;", "", "", "a", "I", "()I", "d", "(I)V", "linkColorRes", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setUnsupportedMessagePrompt", "(Ljava/lang/String;)V", "unsupportedMessagePrompt", "Lcom/tencent/android/androidbypass/enhance/i;", "Lcom/tencent/android/androidbypass/enhance/i;", "()Lcom/tencent/android/androidbypass/enhance/i;", "e", "(Lcom/tencent/android/androidbypass/enhance/i;)V", "markdownStyleSheet", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int linkColorRes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String unsupportedMessagePrompt;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private i markdownStyleSheet;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                this.unsupportedMessagePrompt = "[\u8be5\u6d88\u606f\u6682\u4e0d\u652f\u6301\u5c55\u793a]";
                this.markdownStyleSheet = new i();
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.linkColorRes;
        }

        @NotNull
        public final i b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (i) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.markdownStyleSheet;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.unsupportedMessagePrompt;
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.linkColorRes = i3;
            }
        }

        public final void e(@NotNull i iVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) iVar);
            } else {
                Intrinsics.checkNotNullParameter(iVar, "<set-?>");
                this.markdownStyleSheet = iVar;
            }
        }
    }

    public d() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this);
    }

    @NotNull
    public final d a(@NotNull ClickableUrlSpan.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.builderOptions.k(listener);
        return this;
    }

    @NotNull
    public final com.tencent.android.androidbypass.parser.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.android.androidbypass.parser.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.builderOptions.e() == null) {
            b bVar = this.builderOptions;
            bVar.n(new com.tencent.android.androidbypass.enhance.h(bVar.j()));
        }
        return new e(this.builderOptions);
    }

    @NotNull
    public final d c(@NotNull st.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.builderOptions.b().b(listener);
        return this;
    }

    @NotNull
    public final d d(@Nullable com.tencent.android.androidbypass.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        }
        this.builderOptions.m(listener);
        return this;
    }

    @NotNull
    public final d e(@NotNull List<? extends com.tencent.android.androidbypass.parser.api.b> listenerList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (d) iPatchRedirector.redirect((short) 1, (Object) this, (Object) listenerList);
        }
        Intrinsics.checkNotNullParameter(listenerList, "listenerList");
        this.builderOptions.f().addAllAbsent(listenerList);
        return this;
    }

    @NotNull
    public final d f(@NotNull tt.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.builderOptions.o(listener);
        return this;
    }

    @NotNull
    public final d g(@NotNull List<? extends ut.a> renderList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (d) iPatchRedirector.redirect((short) 10, (Object) this, (Object) renderList);
        }
        Intrinsics.checkNotNullParameter(renderList, "renderList");
        this.builderOptions.l(renderList);
        return this;
    }

    @NotNull
    public final d h(@NotNull i styleSheet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (d) iPatchRedirector.redirect((short) 11, (Object) this, (Object) styleSheet);
        }
        Intrinsics.checkNotNullParameter(styleSheet, "styleSheet");
        this.builderOptions.i().e(styleSheet);
        return this;
    }

    @NotNull
    public final i i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (i) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.builderOptions.i().b();
    }

    @NotNull
    public final d j(@ColorRes int colorRes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, colorRes);
        }
        this.builderOptions.i().d(colorRes);
        return this;
    }

    @NotNull
    public final d k(@NotNull g urlToDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (d) iPatchRedirector.redirect((short) 8, (Object) this, (Object) urlToDrawable);
        }
        Intrinsics.checkNotNullParameter(urlToDrawable, "urlToDrawable");
        this.builderOptions.p(urlToDrawable);
        return this;
    }

    public d(@NotNull b builderOptions) {
        Intrinsics.checkNotNullParameter(builderOptions, "builderOptions");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.builderOptions = builderOptions;
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) builderOptions);
        }
    }

    public /* synthetic */ d(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new b() : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, this, bVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
