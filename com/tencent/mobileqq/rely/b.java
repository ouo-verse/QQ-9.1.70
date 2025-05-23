package com.tencent.mobileqq.rely;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.rely.a;
import com.tencent.widget.SwipTextViewMenuBuilder;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected final int[] f280860e;

    /* renamed from: f, reason: collision with root package name */
    protected final int[] f280861f;

    /* renamed from: g, reason: collision with root package name */
    protected final int[] f280862g;

    /* renamed from: h, reason: collision with root package name */
    protected final int[] f280863h;

    /* renamed from: i, reason: collision with root package name */
    protected final int f280864i;

    public b(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
        super(i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            return;
        }
        this.f280863h = iArr;
        this.f280864i = i17;
        this.f280860e = iArr2;
        this.f280861f = iArr3;
        this.f280862g = iArr4;
    }

    @Override // com.tencent.mobileqq.rely.a
    public View a(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
        SimpleTextView simpleTextView = new SimpleTextView(context);
        simpleTextView.setLayoutParams(new LinearLayout.LayoutParams(this.f280863h[i3], this.f280864i));
        simpleTextView.setGravity(17);
        simpleTextView.setTextSize(16.0f);
        simpleTextView.setTextColor(-1);
        return simpleTextView;
    }

    @Override // com.tencent.mobileqq.rely.a
    public View e(int i3, Object obj, a.b bVar, View.OnClickListener onClickListener) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), obj, bVar, onClickListener);
        }
        SimpleTextView simpleTextView = null;
        if (bVar != null && bVar.f280855a >= 0 && (i16 = bVar.f280856b) >= 0) {
            View view = bVar.f280859e;
            if (view instanceof SimpleTextView) {
                simpleTextView = (SimpleTextView) view;
            }
            int i17 = this.f280861f[i16];
            int i18 = this.f280862g[i16];
            int i19 = this.f280860e[i16];
            if (simpleTextView != null) {
                simpleTextView.setVisibility(0);
                simpleTextView.setText(simpleTextView.getContext().getResources().getString(i17));
                simpleTextView.setBackgroundResource(i18);
                simpleTextView.setId(i19);
                simpleTextView.setTag(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM);
                simpleTextView.setTag(-2, Integer.valueOf(i17));
                simpleTextView.setTag(-1, Integer.valueOf(i3));
                simpleTextView.setContentDescription(simpleTextView.getResources().getString(i17));
                simpleTextView.setOnClickListener(onClickListener);
                bVar.f280857c = this.f280863h[bVar.f280855a];
                bVar.f280858d = this.f280864i;
            }
        }
        return simpleTextView;
    }
}
