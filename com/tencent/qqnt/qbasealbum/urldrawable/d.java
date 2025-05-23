package com.tencent.qqnt.qbasealbum.urldrawable;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0005R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/d;", "", "Lcom/tencent/qqnt/qbasealbum/urldrawable/d$a;", "b", "buffer", "", "c", "a", "", "I", "poolSize", "bufferSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "pool", "<init>", "(II)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int poolSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int bufferSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> pool;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u000fR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/d$a;", "", "", "a", "[B", "()[B", "d", "([B)V", "data", "", "b", "I", "c", "()I", "f", "(I)V", "offset", "e", "length", "capacity", "<init>", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private byte[] data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int offset;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int length;

        public a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.data = new byte[i3];
            }
        }

        @NotNull
        public final byte[] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.length;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.offset;
        }

        public final void d(@NotNull byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            } else {
                Intrinsics.checkNotNullParameter(bArr, "<set-?>");
                this.data = bArr;
            }
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.length = i3;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.offset = i3;
            }
        }
    }

    public d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.poolSize = i3;
        this.bufferSize = i16;
        this.pool = new ArrayList<>(i3);
    }

    public final synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.pool.clear();
        }
    }

    @NotNull
    public final synchronized a b() {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        int size = this.pool.size();
        if (size > 0) {
            a remove = this.pool.remove(size - 1);
            Intrinsics.checkNotNullExpressionValue(remove, "pool.removeAt(n - 1)");
            aVar = remove;
        } else {
            aVar = new a(this.bufferSize);
        }
        return aVar;
    }

    public final synchronized void c(@NotNull a buffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) buffer);
            return;
        }
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.a().length == this.bufferSize && this.pool.size() < this.poolSize) {
            buffer.f(0);
            buffer.e(0);
            this.pool.add(buffer);
        }
    }
}
