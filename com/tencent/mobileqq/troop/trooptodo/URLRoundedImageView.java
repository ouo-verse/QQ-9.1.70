package com.tencent.mobileqq.troop.trooptodo;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class URLRoundedImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f301762d;

    /* renamed from: e, reason: collision with root package name */
    private int f301763e;

    /* renamed from: f, reason: collision with root package name */
    private int f301764f;

    /* renamed from: h, reason: collision with root package name */
    private Context f301765h;

    public URLRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.image.URLImageView
    public void setBackgroundURL(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            setBackgroundResource(R.drawable.f162622ow4);
            QLog.w("URLRoundedImageView-TodoInfo", 4, "troop to do icon url is empty");
        } else {
            if ((getBackground() instanceof URLDrawable) && ((URLDrawable) getBackground()).getURL().toString().equals(str)) {
                return;
            }
            try {
                URLDrawable drawable = URLDrawable.getDrawable(str, ContextCompat.getDrawable(this.f301765h, R.drawable.lxj), ContextCompat.getDrawable(this.f301765h, R.drawable.f162622ow4));
                drawable.setTag(o.b(this.f301763e, this.f301764f, this.f301762d));
                drawable.setDecodeHandler(o.f301827j);
                setBackgroundDrawable(drawable);
            } catch (IllegalArgumentException unused) {
                QLog.w("URLRoundedImageView-TodoInfo", 4, "troop to do icon url don't have protocol head");
                setBackgroundResource(R.drawable.f162622ow4);
            }
        }
    }

    public URLRoundedImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    public URLRoundedImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f301762d = -1;
        this.f301763e = -1;
        this.f301764f = -1;
        this.f301765h = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ss2.a.f434618v6, i3, 0);
        this.f301762d = obtainStyledAttributes.getDimensionPixelSize(ss2.a.f434641y6, 5);
        this.f301763e = obtainStyledAttributes.getDimensionPixelSize(ss2.a.f434625w6, 0);
        this.f301764f = obtainStyledAttributes.getDimensionPixelSize(ss2.a.f434633x6, 0);
        obtainStyledAttributes.recycle();
    }
}
