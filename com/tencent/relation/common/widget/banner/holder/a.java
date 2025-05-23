package com.tencent.relation.common.widget.banner.holder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;
    public ImageView E;

    public a(@NonNull View view) {
        super(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        } else {
            this.E = (ImageView) view;
        }
    }
}
