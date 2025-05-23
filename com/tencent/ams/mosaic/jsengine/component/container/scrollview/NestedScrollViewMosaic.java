package com.tencent.ams.mosaic.jsengine.component.container.scrollview;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NestedScrollViewMosaic extends NestedScrollView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private NestedScrollView.OnScrollChangeListener f71105d;

    public NestedScrollViewMosaic(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        f.a("NestedScrollViewMosaic", "onScrollChanged :" + this.f71105d);
        NestedScrollView.OnScrollChangeListener onScrollChangeListener = this.f71105d;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i3, i16, i17, i18);
        }
    }

    @Override // androidx.core.widget.NestedScrollView
    public void setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener onScrollChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onScrollChangeListener);
            return;
        }
        f.a("NestedScrollViewMosaic", "setOnScrollChangeListener :" + onScrollChangeListener);
        this.f71105d = onScrollChangeListener;
    }
}
