package com.tencent.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class LyricViewPractice extends LyricView {
    static IPatchRedirector $redirector_;

    public LyricViewPractice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168307fl4, this);
        this.f147107e = (LyricViewScroll) inflate.findViewById(R.id.zdb);
        LyricViewInternalPractice lyricViewInternalPractice = (LyricViewInternalPractice) inflate.findViewById(R.id.zda);
        this.f147106d = lyricViewInternalPractice;
        lyricViewInternalPractice.l(this.f147108f);
    }
}
