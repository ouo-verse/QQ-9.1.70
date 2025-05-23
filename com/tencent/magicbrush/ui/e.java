package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.magicbrush.ui.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends SurfaceView implements g.b, SurfaceHolder.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final View f147503a;

    /* renamed from: b, reason: collision with root package name */
    public final g.h f147504b;

    /* renamed from: c, reason: collision with root package name */
    public g.c f147505c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f147503a = this;
        this.f147504b = g.h.f147523a;
        getHolder().addCallback(this);
    }

    public void a(SurfaceHolder holder, boolean z16) {
        Object surfaceTexture;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, holder, Boolean.valueOf(z16));
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        g.c cVar = this.f147505c;
        if (cVar != null) {
            if (getSurfaceTexture() == null) {
                surfaceTexture = holder.getSurface();
            } else {
                surfaceTexture = getSurfaceTexture();
                Intrinsics.checkNotNull(surfaceTexture);
            }
            Intrinsics.checkNotNullExpressionValue(surfaceTexture, "when (getSurfaceTexture(\u2026-> getSurfaceTexture()!!}");
            cVar.a(surfaceTexture, z16);
        }
    }

    @Override // com.tencent.magicbrush.ui.g.b
    @Nullable
    public Object getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return g.b.a.a(this);
    }

    @Nullable
    public Object getSurfaceTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.magicbrush.ui.g.b
    @Nullable
    public View getThisView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f147503a;
    }

    @Override // com.tencent.magicbrush.ui.g.b
    @NotNull
    public g.h getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g.h) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f147504b;
    }

    @Override // com.tencent.magicbrush.ui.g.b
    public void setSurfaceListener(@Nullable g.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.f147505c = cVar;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int i3, int i16, int i17) {
        Object surfaceTexture;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, holder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        g.c cVar = this.f147505c;
        if (cVar != null) {
            if (getSurfaceTexture() == null) {
                surfaceTexture = holder.getSurface();
            } else {
                surfaceTexture = getSurfaceTexture();
                Intrinsics.checkNotNull(surfaceTexture);
            }
            Intrinsics.checkNotNullExpressionValue(surfaceTexture, "when (getSurfaceTexture(\u2026-> getSurfaceTexture()!!}");
            cVar.a(surfaceTexture, i16, i17);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Object surfaceTexture;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Rect surfaceFrame = holder.getSurfaceFrame();
        g.c cVar = this.f147505c;
        if (cVar != null) {
            if (getSurfaceTexture() == null) {
                surfaceTexture = holder.getSurface();
            } else {
                surfaceTexture = getSurfaceTexture();
                Intrinsics.checkNotNull(surfaceTexture);
            }
            Object obj = surfaceTexture;
            Intrinsics.checkNotNullExpressionValue(obj, "when (getSurfaceTexture(\u2026-> getSurfaceTexture()!!}");
            g.c.a.a(cVar, obj, surfaceFrame.width(), surfaceFrame.height(), false, false, 16, null);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            a(holder, false);
        }
    }
}
