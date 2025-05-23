package com.tencent.luggage.wxa.b1;

import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements b {
    @Override // com.tencent.luggage.wxa.b1.b
    public void a(String str, ImageView imageView, c cVar) {
        if (cVar == c.FOLDER) {
            imageView.setImageResource(R.drawable.m6g);
        } else {
            imageView.setImageResource(R.drawable.m6h);
        }
        com.bumptech.glide.b.t(imageView.getContext()).p(str).w0(x.c.i()).p0(imageView);
    }
}
