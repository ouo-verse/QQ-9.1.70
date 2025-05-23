package com.tencent.cache.api.memory;

import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010%\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0006\u0010\t\"\u0004\b\u001b\u0010\u000bR\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u001e\u0010\u000bR.\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010!\u001a\u0004\b\u001d\u0010\"\"\u0004\b#\u0010$R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b&\u0010\u000b\u00a8\u0006*"}, d2 = {"Lcom/tencent/cache/api/memory/d;", "", "", "toString", "r", "", "a", "I", "i", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, "b", "k", MiniGameMemoryLimitReport.BeaconKey.DALVIKPSS, "c", "e", DomainData.DOMAIN_NAME, MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, "d", "f", "o", MiniGameMemoryLimitReport.BeaconKey.OTHERPSS, h.F, "p", "swappedPss", "j", "codePss", "g", "l", "graphicPss", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setPssDetail", "(Ljava/util/Map;)V", "pssDetail", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "modifiedTotalPss", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int totalPss;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int dalvikPss;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int nativePss;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int otherPss;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int swappedPss;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int codePss;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int graphicPss;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Integer> pssDetail;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int modifiedTotalPss;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pssDetail = new LinkedHashMap();
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.codePss;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.dalvikPss;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.graphicPss;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.modifiedTotalPss;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.nativePss;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.otherPss;
    }

    @NotNull
    public final Map<String, Integer> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Map) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.pssDetail;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.swappedPss;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.totalPss;
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.codePss = i3;
        }
    }

    public final void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.dalvikPss = i3;
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.graphicPss = i3;
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.modifiedTotalPss = i3;
        }
    }

    public final void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.nativePss = i3;
        }
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.otherPss = i3;
        }
    }

    public final void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.swappedPss = i3;
        }
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.totalPss = i3;
        }
    }

    @NotNull
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("dalvikPss: ");
        a16.append(this.dalvikPss);
        a16.append(", nativePss: ");
        a16.append(this.nativePss);
        a16.append(", codePss: ");
        a16.append(this.codePss);
        a16.append(", graphicPss: ");
        a16.append(this.graphicPss);
        return a16.toString();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("totalPss: ");
        a16.append(this.totalPss);
        a16.append(", ");
        a16.append(r());
        return a16.toString();
    }
}
