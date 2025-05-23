package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.view.IMeasureText;
import com.tencent.pts.ui.view.PTSTextView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

/* loaded from: classes22.dex */
public class PTSNodeText extends PTSNodeTextBase implements IMeasureText {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PTSNodeText";

    /* loaded from: classes22.dex */
    public static class a implements PTSNodeVirtual.a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) pTSNodeVirtual);
            }
            return new PTSTextView(context);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PTSNodeVirtual) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSAppInstance);
            }
            return new PTSNodeText(pTSAppInstance);
        }
    }

    public PTSNodeText(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "text", null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
        }
    }

    @Override // com.tencent.pts.ui.view.IMeasureText
    public float[] getTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (float[]) iPatchRedirector.redirect((short) 2, this, fArr, str, str2, str3, str4, str5, str6);
        }
        return PTSNodeFactory.getTextMeasuredSize(fArr, str, str2, str3, str4, str5);
    }
}
