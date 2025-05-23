package com.tencent.relation.common.widget.banner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e<T> extends d<T, com.tencent.relation.common.widget.banner.holder.a> {
    static IPatchRedirector $redirector_;

    public e(List<T> list) {
        super(list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        }
    }

    @Override // com.tencent.relation.common.widget.banner.adapter.d
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public com.tencent.relation.common.widget.banner.holder.a q0(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.relation.common.widget.banner.holder.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return new com.tencent.relation.common.widget.banner.holder.a(imageView);
    }
}
