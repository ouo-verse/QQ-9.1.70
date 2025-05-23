package com.tencent.mobileqq.filter;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.LinkedList;

/* loaded from: classes12.dex */
public class GpuImagePartsFilterGroup extends GPUBaseFilter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f209709a;

    /* renamed from: b, reason: collision with root package name */
    private b f209710b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedList<Runnable> f209711c;

    public GpuImagePartsFilterGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f209711c = new LinkedList<>();
        }
    }

    private void f(@NonNull LinkedList<Runnable> linkedList) {
        synchronized (linkedList) {
            while (!linkedList.isEmpty()) {
                Runnable poll = linkedList.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        }
    }

    private void g(@NonNull Runnable runnable) {
        synchronized (this.f209711c) {
            this.f209711c.add(runnable);
        }
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        b bVar = this.f209709a;
        if (bVar != null) {
            bVar.destroy();
        }
        b bVar2 = this.f209710b;
        if (bVar2 != null) {
            bVar2.destroy();
        }
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void drawTexture(int i3, float[] fArr, float[] fArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), fArr, fArr2);
            return;
        }
        if (!e()) {
            hd0.c.g("Q.qqstory.publish.edit GpuImagePartsFilterGroup", "must set filters before draw texture");
            return;
        }
        b bVar = this.f209709a;
        if (bVar != null) {
            bVar.drawTexture(i3, fArr, fArr2);
        }
        this.f209710b.drawTexture(i3, fArr, fArr2);
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f209709a == null && this.f209710b == null) {
            return false;
        }
        return true;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            f(this.f209711c);
        }
    }

    public void i(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (a.b(i3)) {
            g(new Runnable(i3, i16, i17) { // from class: com.tencent.mobileqq.filter.GpuImagePartsFilterGroup.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f209712d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f209713e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f209714f;

                {
                    this.f209712d = i3;
                    this.f209713e = i16;
                    this.f209714f = i17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GpuImagePartsFilterGroup.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        b bVar = GpuImagePartsFilterGroup.this.f209709a;
                        b bVar2 = null;
                        GpuImagePartsFilterGroup.this.f209709a = null;
                        if (GpuImagePartsFilterGroup.this.f209710b == null || GpuImagePartsFilterGroup.this.f209710b.getFilterType() != this.f209712d) {
                            bVar2 = GpuImagePartsFilterGroup.this.f209710b;
                            GpuImagePartsFilterGroup.this.f209710b = (b) a.a(this.f209712d);
                            GpuImagePartsFilterGroup.this.f209710b.init();
                            GpuImagePartsFilterGroup.this.f209710b.onOutputSizeChanged(this.f209713e, this.f209714f);
                        }
                        GpuImagePartsFilterGroup.this.f209710b.b(false, 0.0f);
                        if (bVar != null) {
                            bVar.destroy();
                        }
                        if (bVar2 != null) {
                            bVar2.destroy();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("filterType " + i3 + " is invalid color filter type");
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        b bVar = this.f209709a;
        if (bVar != null && !bVar.isInitialized()) {
            this.f209709a.init();
        }
        b bVar2 = this.f209710b;
        if (bVar2 != null && !bVar2.isInitialized()) {
            this.f209710b.init();
        }
    }

    public void j(int i3, int i16, float f16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
        } else {
            g(new Runnable(i3, i18, i19, i16, i17, f16) { // from class: com.tencent.mobileqq.filter.GpuImagePartsFilterGroup.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f209715d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f209716e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f209717f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f209718h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f209719i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ float f209720m;

                {
                    this.f209715d = i3;
                    this.f209716e = i18;
                    this.f209717f = i19;
                    this.f209718h = i16;
                    this.f209719i = i17;
                    this.f209720m = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GpuImagePartsFilterGroup.this, Integer.valueOf(i3), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    b bVar2 = null;
                    if (GpuImagePartsFilterGroup.this.f209709a == null || GpuImagePartsFilterGroup.this.f209709a.getFilterType() != this.f209715d) {
                        bVar = GpuImagePartsFilterGroup.this.f209709a;
                        GpuImagePartsFilterGroup.this.f209709a = (b) a.a(this.f209715d);
                        GpuImagePartsFilterGroup.this.f209709a.init();
                        GpuImagePartsFilterGroup.this.f209709a.onOutputSizeChanged(this.f209716e, this.f209717f);
                    } else {
                        bVar = null;
                    }
                    if (GpuImagePartsFilterGroup.this.f209710b == null || GpuImagePartsFilterGroup.this.f209710b.getFilterType() != this.f209718h) {
                        bVar2 = GpuImagePartsFilterGroup.this.f209710b;
                        GpuImagePartsFilterGroup.this.f209710b = (b) a.a(this.f209718h);
                        GpuImagePartsFilterGroup.this.f209710b.init();
                        GpuImagePartsFilterGroup.this.f209710b.onOutputSizeChanged(this.f209716e, this.f209717f);
                    }
                    int i26 = this.f209719i;
                    if (i26 != 90 && i26 != 270) {
                        GpuImagePartsFilterGroup.this.f209709a.a(true);
                        GpuImagePartsFilterGroup.this.f209710b.a(true);
                    } else {
                        GpuImagePartsFilterGroup.this.f209709a.a(false);
                        GpuImagePartsFilterGroup.this.f209710b.a(false);
                    }
                    GpuImagePartsFilterGroup.this.f209709a.b(true, this.f209720m + 0.1f);
                    GpuImagePartsFilterGroup.this.f209710b.b(false, this.f209720m - 0.1f);
                    if (bVar != null) {
                        bVar.destroy();
                    }
                    if (bVar2 != null) {
                        bVar2.destroy();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onOutputSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        b bVar = this.f209709a;
        if (bVar != null) {
            bVar.onOutputSizeChanged(i3, i16);
        }
        b bVar2 = this.f209710b;
        if (bVar2 != null) {
            bVar2.onOutputSizeChanged(i3, i16);
        }
    }
}
