package com.tencent.mobileqq.filter;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends GPUBaseFilter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f209740a;

    /* renamed from: b, reason: collision with root package name */
    private List<GPUBaseFilter> f209741b;

    /* renamed from: c, reason: collision with root package name */
    private List<RenderBuffer> f209742c;

    /* renamed from: d, reason: collision with root package name */
    private int f209743d;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f209740a = false;
        this.f209743d = -1;
        this.f209741b = new ArrayList();
    }

    private void b() {
        List<RenderBuffer> list = this.f209742c;
        if (list != null) {
            Iterator<RenderBuffer> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.f209742c = null;
        }
    }

    public void a(@NonNull GPUBaseFilter gPUBaseFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gPUBaseFilter);
        } else {
            this.f209741b.add(gPUBaseFilter);
        }
    }

    public RenderBuffer c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RenderBuffer) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        List<RenderBuffer> list = this.f209742c;
        if (list != null && list.size() > 0) {
            return this.f209742c.get(r0.size() - 1);
        }
        throw new RuntimeException("please check your state");
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<GPUBaseFilter> it = this.f209741b.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        b();
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void drawTexture(int i3, float[] fArr, float[] fArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), fArr, fArr2);
            return;
        }
        this.f209743d = i3;
        for (int i16 = 0; i16 < this.f209741b.size(); i16++) {
            if (i16 != this.f209741b.size() - 1) {
                this.f209742c.get(i16).bind();
                this.f209741b.get(i16).drawTexture(this.f209743d, null, null);
                this.f209742c.get(i16).unbind();
                this.f209743d = this.f209742c.get(i16).getTexId();
            } else if (this.f209740a) {
                this.f209741b.get(i16).drawTexture(this.f209743d, fArr, fArr2);
            } else {
                this.f209742c.get(i16).bind();
                this.f209741b.get(i16).drawTexture(this.f209743d, fArr, fArr2);
                this.f209742c.get(i16).unbind();
                this.f209743d = this.f209742c.get(i16).getTexId();
            }
        }
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<GPUBaseFilter> it = this.f209741b.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onOutputSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Iterator<GPUBaseFilter> it = this.f209741b.iterator();
        while (it.hasNext()) {
            it.next().onOutputSizeChanged(i3, i16);
        }
        b();
        this.f209742c = new ArrayList();
        int size = this.f209741b.size();
        if (this.f209740a) {
            size--;
        }
        for (int i17 = 0; i17 < size; i17++) {
            this.f209742c.add(new RenderBuffer(i3, i16, 33984));
        }
    }
}
