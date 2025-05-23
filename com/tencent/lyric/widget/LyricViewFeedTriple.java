package com.tencent.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewFeedTriple extends LyricView {
    static IPatchRedirector $redirector_;

    public LyricViewFeedTriple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168304fl1, this);
        this.f147107e = (LyricViewScroll) inflate.findViewById(R.id.l37);
        LyricViewInternalFeedTriple lyricViewInternalFeedTriple = (LyricViewInternalFeedTriple) inflate.findViewById(R.id.l36);
        this.f147106d = lyricViewInternalFeedTriple;
        lyricViewInternalFeedTriple.l(this.f147108f);
        this.f147107e.setScrollEnable(this.f147109h);
        this.f147107e.setSeekScrollListener(((LyricViewInternalFeedTriple) this.f147106d).f147225j1);
    }
}
