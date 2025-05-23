package com.tencent.mobileqq.receipt;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.LayerImageView;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReceiptBubbleLayerImageView extends LayerImageView {
    static IPatchRedirector $redirector_;

    public ReceiptBubbleLayerImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }
}
