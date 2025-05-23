package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BaseViewHolder<M> extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;
    private SparseArray<View> viewArray;

    public BaseViewHolder(ViewGroup viewGroup, int i3) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.viewArray = new SparseArray<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup, i3);
        }
    }

    public void bindData(M m3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) m3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.itemView.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends View> T getView(@IdRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        T t16 = (T) this.viewArray.get(i3);
        if (t16 == null) {
            T t17 = (T) this.itemView.findViewById(i3);
            this.viewArray.put(i3, t17);
            return t17;
        }
        return t16;
    }

    public void onViewDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public BaseViewHolder(View view) {
        super(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.viewArray = new SparseArray<>();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
    }
}
