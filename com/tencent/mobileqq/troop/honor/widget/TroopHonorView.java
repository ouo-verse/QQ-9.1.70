package com.tencent.mobileqq.troop.honor.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfigParser;
import com.tencent.mobileqq.troop.honor.config.b;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHonorView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final int f297537f;

    /* renamed from: h, reason: collision with root package name */
    private static final int f297538h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f297539i;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.mobileqq.troop.honor.config.a> f297540d;

    /* renamed from: e, reason: collision with root package name */
    private String f297541e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<ImageView> f297542d;

        public a(ImageView imageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) imageView);
            } else {
                this.f297542d = new WeakReference<>(imageView);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
                return;
            }
            ImageView imageView = this.f297542d.get();
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
                return;
            }
            ImageView imageView = this.f297542d.get();
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            ImageView imageView = this.f297542d.get();
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f297537f = ViewUtils.dip2px(16.0f);
        f297538h = ViewUtils.dip2px(16.0f);
        f297539i = ViewUtils.dip2px(1.0f);
    }

    public TroopHonorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f297541e = "";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return com.tencent.mobileqq.troop.honor.util.a.e(this.f297540d);
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        List<com.tencent.mobileqq.troop.honor.config.a> list = this.f297540d;
        if (list != null && list.size() != 0) {
            return (this.f297540d.size() * f297537f) + ((this.f297540d.size() - 1) * f297539i) + getPaddingLeft() + getPaddingRight();
        }
        return 0;
    }

    public void setHonorList(List<com.tencent.mobileqq.troop.honor.config.a> list, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, Float.valueOf(f16));
            return;
        }
        if (list == null) {
            return;
        }
        int paddingLeft = (int) ((((f16 - getPaddingLeft()) - getPaddingRight()) + f297539i) / (f297537f + r0));
        if (paddingLeft <= 0) {
            return;
        }
        Collections.sort(list);
        setHonorList(list.subList(0, Math.min(paddingLeft, list.size())));
    }

    public TroopHonorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f297541e = "";
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public TroopHonorView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f297541e = "";
            setOrientation(0);
        }
    }

    public void setHonorList(List<com.tencent.mobileqq.troop.honor.config.a> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, i3);
            return;
        }
        if (list == null) {
            return;
        }
        if (i3 != 1 && i3 != 2) {
            setHonorList(list);
            return;
        }
        b d16 = TroopHonorConfigParser.d();
        int i16 = d16 != null ? d16.f297520h : 3;
        Collections.sort(list);
        setHonorList(list.subList(0, Math.min(i16, list.size())));
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonorView", 2, "maxNumberOfAIOIcon = " + i16 + ",honorList.size = " + list.size());
        }
    }

    public void setHonorList(List<com.tencent.mobileqq.troop.honor.config.a> list) {
        URLDrawable apngURLDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (this.f297541e.equals(com.tencent.mobileqq.troop.honor.util.a.c(list))) {
            return;
        }
        if (list != null) {
            Collections.sort(list);
        }
        this.f297540d = list;
        this.f297541e = com.tencent.mobileqq.troop.honor.util.a.c(list);
        removeAllViews();
        if (list == null || list.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            com.tencent.mobileqq.troop.honor.config.a aVar = list.get(i16);
            if (!TextUtils.isEmpty(aVar.f297513f) && (apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("TroopHonorView", aVar.f297513f)) != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f297537f, f297538h);
                ImageView imageView = new ImageView(getContext());
                apngURLDrawable.setURLDrawableListener(new a(imageView));
                imageView.setImageDrawable(apngURLDrawable);
                imageView.setContentDescription(aVar.f297512e);
                if (i3 != 0) {
                    layoutParams.leftMargin = f297539i;
                }
                addView(imageView, layoutParams);
                i3++;
            }
        }
    }
}
