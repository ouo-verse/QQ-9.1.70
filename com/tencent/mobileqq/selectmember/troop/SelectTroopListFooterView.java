package com.tencent.mobileqq.selectmember.troop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QUITokenResCompat;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectTroopListFooterView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f285965d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f285966e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f285967f;

    public SelectTroopListFooterView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public SelectTroopListFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SelectTroopListFooterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f169086hq1, this);
        this.f285966e = (RelativeLayout) findViewById(R.id.f82754hq);
        ImageView imageView = (ImageView) findViewById(R.id.f82744hp);
        this.f285967f = imageView;
        imageView.setImageResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_info_circle));
        this.f285965d = context;
    }
}
