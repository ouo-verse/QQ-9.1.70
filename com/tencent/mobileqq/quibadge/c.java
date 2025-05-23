package com.tencent.mobileqq.quibadge;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/quibadge/c;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/quibadge/c$c;", "Lcom/tencent/mobileqq/quibadge/c$a;", "Lcom/tencent/mobileqq/quibadge/c$b;", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B)\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0004\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/quibadge/c$a;", "Lcom/tencent/mobileqq/quibadge/c;", "", "", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", SquareJSConst.Params.PARAMS_UIN_LIST, "b", "Ljava/lang/String;", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "", "Z", "()Z", "setShowAnim", "(Z)V", "showAnim", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    public static class a extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> uinList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String text;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean showAnim;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull List<String> uinList, @NotNull String text, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, uinList, text, Boolean.valueOf(z16));
                return;
            }
            this.uinList = uinList;
            this.text = text;
            this.showAnim = z16;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.showAnim;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        @NotNull
        public final List<String> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (List) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.uinList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/quibadge/c$b;", "Lcom/tencent/mobileqq/quibadge/c;", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    public static class b extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String text;

        public b(@Nullable String str, @Nullable String str2) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                this.url = str;
                this.text = str2;
            }
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.url;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/quibadge/c$c;", "Lcom/tencent/mobileqq/quibadge/c;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.quibadge.c$c, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C8449c extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.url;
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }
}
