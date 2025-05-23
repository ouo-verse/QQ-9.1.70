package com.tencent.tdf.embed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.embed.mutatorsstack.EmbeddedMutatorView;
import com.tencent.tdf.embed.mutatorsstack.MutatorsStack;
import com.tencent.tdf.view.INativeViewDelegate;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EmbeddedViewController implements INativeViewDelegate {
    static IPatchRedirector $redirector_;
    private EmbeddedMutatorView mEmbeddedMutatorView;
    private EmbeddedView mEmbeddedView;
    protected String viewType;

    public EmbeddedViewController(Context context, int i3, EmbeddedView embeddedView, Map<String, String> map) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), embeddedView, map);
            return;
        }
        this.mEmbeddedView = embeddedView;
        if (map.containsKey("__intrinsic_scale")) {
            f16 = Float.valueOf(map.get("__intrinsic_scale")).floatValue();
        } else {
            f16 = 1.0f;
        }
        EmbeddedMutatorView embeddedMutatorView = new EmbeddedMutatorView(context, this.mEmbeddedView.getView(), f16);
        this.mEmbeddedMutatorView = embeddedMutatorView;
        embeddedMutatorView.setTargetViewId(i3);
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void deleteView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        }
    }

    public final View getEmbeddedView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mEmbeddedMutatorView;
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public Rect getLayoutRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Rect) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mEmbeddedMutatorView.getLayoutRect();
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void insertView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
        }
    }

    public Bitmap makeSnapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mEmbeddedView.makeSnapshot();
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void onDispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mEmbeddedView.dispose();
        }
    }

    public void setViewType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.viewType = str;
        }
    }

    public final void updateEmbeddedViewClipRect(MutatorsStack mutatorsStack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) mutatorsStack);
        } else {
            this.mEmbeddedMutatorView.setMutatorsStack(mutatorsStack);
            this.mEmbeddedMutatorView.invalidate();
        }
    }

    public void updateEmbeddedViewProps(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
        } else {
            this.mEmbeddedView.updateProps(map);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void updateLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mEmbeddedMutatorView.updateLayoutParams(i3, i16, i17, i18);
        }
    }
}
