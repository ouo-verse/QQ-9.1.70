package com.tencent.aekit.openrender;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CropFilter extends VideoFilterBase {
    static IPatchRedirector $redirector_;
    private float bottom;
    private float left;

    public CropFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.left = 0.0f;
            this.bottom = 0.0f;
        }
    }

    private void updateTexCords(int i3, int i16, int i17, int i18) {
        float f16 = ((i17 - i3) / 2.0f) / i17;
        float f17 = 1.0f - f16;
        float f18 = ((i18 - i16) / 2.0f) / i18;
        float f19 = 1.0f - f18;
        if (Float.compare(f16, this.left) == 0 && Float.compare(f18, this.bottom) == 0) {
            return;
        }
        this.left = f16;
        this.bottom = f18;
        setTexCords(new float[]{f16, f18, f16, f19, f17, f19, f17, f18});
    }

    public void updateCorpRect(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            updateTexCords(i3, i16, i17, i18);
        }
    }
}
