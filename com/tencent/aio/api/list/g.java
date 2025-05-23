package com.tencent.aio.api.list;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\t\nJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/api/list/g;", "T", "", "Lcom/tencent/aio/api/list/g$b;", "action", "", DomainData.DOMAIN_NAME, "", "t", "a", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface g<T> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/list/g$a;", "", "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B;\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u0016\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/aio/api/list/g$b;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "newList", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "()Lkotlinx/coroutines/CoroutineScope;", "d", "(Lkotlinx/coroutines/CoroutineScope;)V", "coroutineScope", "c", "Z", "getImmediate", "()Z", "immediate", "Lcom/tencent/aio/api/list/g$a;", "Lcom/tencent/aio/api/list/g$a;", "()Lcom/tencent/aio/api/list/g$a;", "e", "(Lcom/tencent/aio/api/list/g$a;)V", "runnable", "<init>", "(Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;ZLcom/tencent/aio/api/list/g$a;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final /* data */ class b<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<T> newList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private CoroutineScope coroutineScope;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean immediate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private a runnable;

        public b() {
            this(null, null, false, null, 15, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        @Nullable
        public final CoroutineScope a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CoroutineScope) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.coroutineScope;
        }

        @Nullable
        public final List<T> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (List) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.newList;
        }

        @Nullable
        public final a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.runnable;
        }

        public final void d(@Nullable CoroutineScope coroutineScope) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) coroutineScope);
            } else {
                this.coroutineScope = coroutineScope;
            }
        }

        public final void e(@Nullable a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            } else {
                this.runnable = aVar;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof b) {
                    b bVar = (b) other;
                    if (!Intrinsics.areEqual(this.newList, bVar.newList) || !Intrinsics.areEqual(this.coroutineScope, bVar.coroutineScope) || this.immediate != bVar.immediate || !Intrinsics.areEqual(this.runnable, bVar.runnable)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            List<T> list = this.newList;
            int i17 = 0;
            if (list != null) {
                i3 = list.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = i3 * 31;
            CoroutineScope coroutineScope = this.coroutineScope;
            if (coroutineScope != null) {
                i16 = coroutineScope.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            boolean z16 = this.immediate;
            int i26 = z16;
            if (z16 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            a aVar = this.runnable;
            if (aVar != null) {
                i17 = aVar.hashCode();
            }
            return i27 + i17;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "SubmitAction(newList=" + this.newList + ", coroutineScope=" + this.coroutineScope + ", immediate=" + this.immediate + ", runnable=" + this.runnable + ")";
        }

        public b(@Nullable List<? extends T> list, @Nullable CoroutineScope coroutineScope, boolean z16, @Nullable a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, list, coroutineScope, Boolean.valueOf(z16), aVar);
                return;
            }
            this.newList = list;
            this.coroutineScope = coroutineScope;
            this.immediate = z16;
            this.runnable = aVar;
        }

        public /* synthetic */ b(List list, CoroutineScope coroutineScope, boolean z16, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? null : coroutineScope, (i3 & 4) != 0 ? false : z16, (i3 & 8) == 0 ? aVar : null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, this, list, coroutineScope, Boolean.valueOf(z16), aVar, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    void n(@NotNull b<T> action);

    @NotNull
    List<T> t();
}
