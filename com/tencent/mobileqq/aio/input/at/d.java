package com.tencent.mobileqq.aio.input.at;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/d;", "Lcom/tencent/mvi/api/ability/d;", "<init>", "()V", "a", "b", "c", "d", "e", "Lcom/tencent/mobileqq/aio/input/at/d$b;", "Lcom/tencent/mobileqq/aio/input/at/d$c;", "Lcom/tencent/mobileqq/aio/input/at/d$d;", "Lcom/tencent/mobileqq/aio/input/at/d$e;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class d implements com.tencent.mvi.api.ability.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/d$a;", "", "", "AT_ALL_SPAN", "Ljava/lang/String;", "AT_MEMBER_SPAN", "GET_MATCH_AT_SPAN_COUNT", "HAS_AT_MEMBER_SPAN", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.d$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/d$b;", "Lcom/tencent/mobileqq/aio/input/at/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f189316b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53196);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189316b = new b();
            }
        }

        b() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/d$c;", "Lcom/tencent/mobileqq/aio/input/at/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lkotlin/Function1;", "Lcom/tencent/qqnt/aio/at/c;", "b", "Lkotlin/jvm/functions/Function1;", "a", "()Lkotlin/jvm/functions/Function1;", "matcher", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class c extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Function1<com.tencent.qqnt.aio.at.c, Boolean> matcher;

        public c() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        @Nullable
        public final Function1<com.tencent.qqnt.aio.at.c, Boolean> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Function1) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.matcher;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof c) && Intrinsics.areEqual(this.matcher, ((c) other).matcher)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            Function1<com.tencent.qqnt.aio.at.c, Boolean> function1 = this.matcher;
            if (function1 == null) {
                return 0;
            }
            return function1.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "GetAtMemberSpanCountVBState(matcher=" + this.matcher + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(@Nullable Function1<? super com.tencent.qqnt.aio.at.c, Boolean> function1) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.matcher = function1;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        public /* synthetic */ c(Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : function1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, function1, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/d$d;", "Lcom/tencent/mobileqq/aio/input/at/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "memberUid", "c", "memberUin", "d", "nickName", "e", "Z", "a", "()Z", "insertSpace", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.d$d, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final /* data */ class C7258d extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String memberUid;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String memberUin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String nickName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean insertSpace;

        public /* synthetic */ C7258d(String str, String str2, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i3 & 8) != 0 ? true : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.insertSpace;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.memberUid;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.memberUin;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.nickName;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C7258d)) {
                return false;
            }
            C7258d c7258d = (C7258d) other;
            if (Intrinsics.areEqual(this.memberUid, c7258d.memberUid) && Intrinsics.areEqual(this.memberUin, c7258d.memberUin) && Intrinsics.areEqual(this.nickName, c7258d.nickName) && this.insertSpace == c7258d.insertSpace) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            int hashCode = ((((this.memberUid.hashCode() * 31) + this.memberUin.hashCode()) * 31) + this.nickName.hashCode()) * 31;
            boolean z16 = this.insertSpace;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "GetAtMemberSpanVBState(memberUid=" + this.memberUid + ", memberUin=" + this.memberUin + ", nickName=" + this.nickName + ", insertSpace=" + this.insertSpace + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7258d(@NotNull String memberUid, @NotNull String memberUin, @NotNull String nickName, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(memberUid, "memberUid");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, memberUid, memberUin, nickName, Boolean.valueOf(z16));
                return;
            }
            this.memberUid = memberUid;
            this.memberUin = memberUin;
            this.nickName = nickName;
            this.insertSpace = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/d$e;", "Lcom/tencent/mobileqq/aio/input/at/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "getMemberUid", "()Ljava/lang/String;", "memberUid", "c", "a", "memberUin", "d", "getNickName", "nickName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class e extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String memberUid;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String memberUin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String nickName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull String memberUid, @NotNull String memberUin, @NotNull String nickName) {
            super(null);
            Intrinsics.checkNotNullParameter(memberUid, "memberUid");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, memberUid, memberUin, nickName);
                return;
            }
            this.memberUid = memberUid;
            this.memberUin = memberUin;
            this.nickName = nickName;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.memberUin;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof e)) {
                return false;
            }
            e eVar = (e) other;
            if (Intrinsics.areEqual(this.memberUid, eVar.memberUid) && Intrinsics.areEqual(this.memberUin, eVar.memberUin) && Intrinsics.areEqual(this.nickName, eVar.nickName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.memberUid.hashCode() * 31) + this.memberUin.hashCode()) * 31) + this.nickName.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "GetHasAtMemberSpanVBState(memberUid=" + this.memberUid + ", memberUin=" + this.memberUin + ", nickName=" + this.nickName + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
