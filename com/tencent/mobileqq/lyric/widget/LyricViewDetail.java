package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LyricViewDetail extends LyricView {
    static IPatchRedirector $redirector_;

    public LyricViewDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167675dy, this);
        this.f243181e = (LyricViewScroll) inflate.findViewById(R.id.l37);
        LyricViewInternal lyricViewInternal = (LyricViewInternal) inflate.findViewById(R.id.l36);
        this.f243180d = lyricViewInternal;
        lyricViewInternal.g(this.f243182f);
        this.f243181e.setScrollEnable(this.f243183h);
    }
}
