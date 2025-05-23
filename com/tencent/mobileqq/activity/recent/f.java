package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends j {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.j
    public View f(int i3, Object obj, i iVar, View view, ViewGroup viewGroup, Context context, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, DragFrameLayout.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, iVar, view, viewGroup, context, onClickListener, onLongClickListener, bVar);
        }
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.f167783hc, (ViewGroup) null);
        }
        view.setOnClickListener(onClickListener);
        view.setOnLongClickListener(onLongClickListener);
        view.setTag(-1, Integer.valueOf(i3));
        return view;
    }
}
