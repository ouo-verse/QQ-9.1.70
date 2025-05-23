package com.tencent.tdf.view.overlay;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tdf.TDFEngine;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFOverlayViewFactory {
    static IPatchRedirector $redirector_;
    private static TDFOverlayViewFactory sInstance;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tdf.view.overlay.TDFOverlayViewFactory$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tdf$view$overlay$TDFOverlayViewFactory$OverlayViewKind;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19210);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[OverlayViewKind.values().length];
            $SwitchMap$com$tencent$tdf$view$overlay$TDFOverlayViewFactory$OverlayViewKind = iArr;
            try {
                iArr[OverlayViewKind.SurfaceView.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tdf$view$overlay$TDFOverlayViewFactory$OverlayViewKind[OverlayViewKind.TextureView.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$tdf$view$overlay$TDFOverlayViewFactory$OverlayViewKind[OverlayViewKind.ImageView.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class OverlayViewKind {
        private static final /* synthetic */ OverlayViewKind[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final OverlayViewKind ImageView;
        public static final OverlayViewKind SurfaceView;
        public static final OverlayViewKind TextureView;
        private int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19214);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            OverlayViewKind overlayViewKind = new OverlayViewKind("SurfaceView", 0, 0);
            SurfaceView = overlayViewKind;
            OverlayViewKind overlayViewKind2 = new OverlayViewKind("TextureView", 1, 1);
            TextureView = overlayViewKind2;
            OverlayViewKind overlayViewKind3 = new OverlayViewKind("ImageView", 2, 2);
            ImageView = overlayViewKind3;
            $VALUES = new OverlayViewKind[]{overlayViewKind, overlayViewKind2, overlayViewKind3};
        }

        OverlayViewKind(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static OverlayViewKind valueOf(String str) {
            return (OverlayViewKind) Enum.valueOf(OverlayViewKind.class, str);
        }

        public static OverlayViewKind[] values() {
            return (OverlayViewKind[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19231);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            sInstance = new TDFOverlayViewFactory();
        }
    }

    TDFOverlayViewFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TDFOverlayViewFactory getInstance() {
        return sInstance;
    }

    public View createOverlayView(OverlayViewKind overlayViewKind, TDFEngine tDFEngine, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, overlayViewKind, tDFEngine, Long.valueOf(j3));
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$tdf$view$overlay$TDFOverlayViewFactory$OverlayViewKind[overlayViewKind.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return new TDFOverlayImageView(tDFEngine.getTDFView().getContext(), tDFEngine, tDFEngine.getTDFView().getWidth(), tDFEngine.getTDFView().getHeight(), j3);
            }
            TDFOverlayTextureView tDFOverlayTextureView = new TDFOverlayTextureView(tDFEngine.getTDFView().getContext(), tDFEngine, j3);
            tDFOverlayTextureView.setOpaque(false);
            return tDFOverlayTextureView;
        }
        TDFOverlaySurfaceView tDFOverlaySurfaceView = new TDFOverlaySurfaceView(tDFEngine.getTDFView().getContext(), tDFEngine, j3);
        tDFOverlaySurfaceView.setZOrderOnTop(true);
        return tDFOverlaySurfaceView;
    }
}
