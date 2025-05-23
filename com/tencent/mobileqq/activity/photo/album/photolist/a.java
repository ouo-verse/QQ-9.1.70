package com.tencent.mobileqq.activity.photo.album.photolist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.album.photolist.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.NumberCheckBox;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;
    public ImageView E;
    public ImageView F;
    public ImageView G;
    public ImageView H;
    public ImageView I;
    public NumberCheckBox J;
    public URLDrawable K;
    public TextView L;
    public View M;
    public TextView N;
    public d.a P;
    public d.b Q;

    public a(@NonNull View view) {
        super(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        }
    }
}
