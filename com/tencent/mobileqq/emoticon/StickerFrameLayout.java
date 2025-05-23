package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class StickerFrameLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;
    ImageView stickerImage;

    public StickerFrameLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            super.setWillNotDraw(false);
        }
    }

    public ImageView getStickerImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.stickerImage == null) {
            this.stickerImage = (ImageView) findViewById(R.id.shf);
        }
        return this.stickerImage;
    }
}
