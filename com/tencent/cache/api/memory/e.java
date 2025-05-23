package com.tencent.cache.api.memory;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\"\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u001f\u0010\u000bR\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u001e\u0010\t\"\u0004\b!\u0010\u000bR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0007\u001a\u0004\b\u0006\u0010\t\"\u0004\b#\u0010\u000b\u00a8\u0006'"}, d2 = {"Lcom/tencent/cache/api/memory/e;", "", "", "p", "toString", "", "a", "I", "g", "()I", "o", "(I)V", "totalMem", "b", "i", "availMem", "c", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "threshold", "", "d", "Z", "()Z", "k", "(Z)V", HippyReporter.RemoveEngineReason.LOW_MEMORY, "getMemoryLimit", "l", "memoryLimit", "f", "j", "largeMemoryLimit", DomainData.DOMAIN_NAME, "totalBlockSize", h.F, "availBlockSize", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int totalMem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int availMem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int threshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean lowMemory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int memoryLimit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int largeMemoryLimit;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int totalBlockSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int availBlockSize;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.availBlockSize;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.availMem;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.largeMemoryLimit;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.lowMemory;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.threshold;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.totalBlockSize;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.totalMem;
    }

    public final void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.availBlockSize = i3;
        }
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.availMem = i3;
        }
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.largeMemoryLimit = i3;
        }
    }

    public final void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.lowMemory = z16;
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.memoryLimit = i3;
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.threshold = i3;
        }
    }

    public final void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.totalBlockSize = i3;
        }
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.totalMem = i3;
        }
    }

    @NotNull
    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("totalMem:");
        a16.append(this.totalMem);
        a16.append(" MB, availMem:");
        a16.append(this.availMem);
        a16.append(" MB, ");
        a16.append("threshold:");
        a16.append(this.threshold);
        a16.append(" MB, lowMemory:");
        a16.append(this.lowMemory);
        a16.append(", ");
        a16.append("totalBlock:");
        a16.append(this.totalBlockSize);
        a16.append(" MB, availBlock:");
        a16.append(this.availBlockSize);
        a16.append(" MB");
        return a16.toString();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("totalMem:");
        a16.append(this.totalMem);
        a16.append(" MB, availMem:");
        a16.append(this.availMem);
        a16.append(" MB, ");
        a16.append("threshold:");
        a16.append(this.threshold);
        a16.append(" MB, lowMemory:");
        a16.append(this.lowMemory);
        a16.append(", ");
        a16.append("java memoryLimit:");
        a16.append(this.memoryLimit);
        a16.append(" MB, largeMemoryLimit:");
        a16.append(this.largeMemoryLimit);
        a16.append(" MB, ");
        a16.append("totalBlock:");
        a16.append(this.totalBlockSize);
        a16.append(" MB, availBlock:");
        a16.append(this.availBlockSize);
        a16.append(" MB");
        return a16.toString();
    }
}
