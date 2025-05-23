package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import com.tencent.magicbrush.ui.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends TextureView implements g.b, TextureView.SurfaceTextureListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final View f147506a;

    /* renamed from: b, reason: collision with root package name */
    public g.c f147507b;

    /* renamed from: c, reason: collision with root package name */
    public final g.h f147508c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f147506a = this;
        super.setSurfaceTextureListener(this);
        this.f147508c = g.h.f147524b;
    }

    public final void a(SurfaceTexture surface, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surface, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        Intrinsics.checkNotNullParameter(surface, "surface");
        g.c cVar = this.f147507b;
        if (cVar != null) {
            g.c.a.a(cVar, surface, i3, i16, z16, false, 16, null);
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

    @Override // com.tencent.magicbrush.ui.g.b
    @Nullable
    public View getThisView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f147506a;
    }

    @Override // com.tencent.magicbrush.ui.g.b
    @NotNull
    public g.h getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (g.h) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f147508c;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, surface, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            Intrinsics.checkNotNullParameter(surface, "surface");
            a(surface, i3, i16, true);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) surface)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(surface, "surface");
        g.c cVar = this.f147507b;
        if (cVar != null) {
            cVar.a(surface, false);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, surface, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Intrinsics.checkNotNullParameter(surface, "surface");
        g.c cVar = this.f147507b;
        if (cVar != null) {
            cVar.a(surface, i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) surface);
        } else {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    @Override // com.tencent.magicbrush.ui.g.b
    public void setSurfaceListener(@Nullable g.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
        } else {
            this.f147507b = cVar;
        }
    }
}
