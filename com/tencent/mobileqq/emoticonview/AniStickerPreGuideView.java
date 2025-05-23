package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class AniStickerPreGuideView extends PopupWindow {
    static IPatchRedirector $redirector_;
    protected Context mContext;

    public AniStickerPreGuideView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
        }
    }

    public void initUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        setContentView(LayoutInflater.from(this.mContext).inflate(R.layout.dxb, (ViewGroup) null));
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setTouchable(true);
        setFocusable(true);
    }
}
