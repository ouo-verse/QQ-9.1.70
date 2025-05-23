package com.tencent.qqnt.doutu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes24.dex */
public class DoutuEmotionHorizonListView extends HorizontalListView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f355983d;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface a {
        void touchEventActionChanged(int i3);
    }

    public DoutuEmotionHorizonListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        a aVar = this.f355983d;
        if (aVar != null) {
            aVar.touchEventActionChanged(motionEvent.getAction());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (i3 > 0 && (getAdapter() instanceof tw3.a)) {
            ((tw3.a) getAdapter()).a();
        }
        super.onOverScrolled(i3, i16, z16, z17);
    }

    public void setTouchListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f355983d = aVar;
        }
    }

    public DoutuEmotionHorizonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
