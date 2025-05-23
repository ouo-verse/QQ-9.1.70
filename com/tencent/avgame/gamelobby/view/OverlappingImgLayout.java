package com.tencent.avgame.gamelobby.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OverlappingImgLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private IFaceDecoder C;
    private boolean D;
    private int E;
    DecodeTaskCompletionListener F;

    /* renamed from: d, reason: collision with root package name */
    private int f77551d;

    /* renamed from: e, reason: collision with root package name */
    private int f77552e;

    /* renamed from: f, reason: collision with root package name */
    private int f77553f;

    /* renamed from: h, reason: collision with root package name */
    private int f77554h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f77555i;

    /* renamed from: m, reason: collision with root package name */
    private List<ImageView> f77556m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OverlappingImgLayout.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            if (!TextUtils.isEmpty(str) && bitmap != null && OverlappingImgLayout.this.f77555i != null && str.length() != 0) {
                for (int i17 = 0; i17 < OverlappingImgLayout.this.f77555i.length; i17++) {
                    if (i17 < 3 && str.equals(OverlappingImgLayout.this.f77555i[i17])) {
                        ((ImageView) OverlappingImgLayout.this.f77556m.get(i17)).setImageBitmap(bitmap);
                        if (QLog.isColorLevel()) {
                            QLog.d("OverlappingImgLayout", 2, "mDecodeTaskCompletionListener update");
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("OverlappingImgLayout", 2, "onDecodeTaskCompleted, uin: " + str + ", type: " + i16);
                }
            }
        }
    }

    public OverlappingImgLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f77551d = 0;
        this.f77552e = 0;
        this.f77553f = 0;
        this.f77554h = 1;
        this.f77555i = null;
        this.f77556m = new ArrayList();
        this.D = true;
        this.E = 1;
        this.F = new a();
    }

    private void c() {
        removeAllViews();
        if (this.f77556m.size() == 0) {
            return;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f77556m.size(); i16++) {
            View view = (ImageView) this.f77556m.get(i16);
            if (this.f77554h > 0) {
                int a16 = (int) al.a(getContext(), this.f77554h);
                view.setPadding(a16, a16, a16, a16);
                if (!h()) {
                    view.setBackgroundResource(R.drawable.aaa);
                } else {
                    view.setBackgroundResource(R.drawable.hjr);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f77552e, this.f77551d);
            layoutParams.setMargins(i3 * (-1), 0, 0, 0);
            view.setLayoutParams(layoutParams);
            addView(view);
            i3 = this.f77553f;
        }
    }

    private Bitmap d(String str, int i3) {
        if (i3 != 1) {
            return null;
        }
        return e(str);
    }

    private Bitmap e(String str) {
        IFaceDecoder iFaceDecoder = this.C;
        if (iFaceDecoder == null) {
            if (QLog.isColorLevel()) {
                QLog.i("OverlappingImgLayout", 2, "mFaceDecoder null");
            }
            return null;
        }
        Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(1, str, 0, (byte) 4);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (!this.C.isPausing()) {
            this.C.requestDecodeFace(str, 200, false, 1, true, (byte) 0, 4);
        }
        return null;
    }

    private boolean h() {
        if (!this.D) {
            return false;
        }
        if (!"1103".equals(ThemeUtil.curThemeId) && !"2920".equals(ThemeUtil.curThemeId)) {
            return false;
        }
        return true;
    }

    private void j(int i3) {
        ImageView imageView;
        this.f77556m.clear();
        String[] strArr = this.f77555i;
        if (strArr != null && strArr.length != 0) {
            for (int i16 = 0; i16 < this.f77555i.length && i16 < 3; i16++) {
                if (this.D) {
                    imageView = new ThemeImageView(getContext());
                } else {
                    imageView = new ImageView(getContext());
                }
                imageView.setImageBitmap(d(this.f77555i[i16], i3));
                this.f77556m.add(imageView);
            }
        }
    }

    public void f(int i3, int i16, int i17, String[] strArr, IFaceDecoder iFaceDecoder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), strArr, iFaceDecoder);
            return;
        }
        this.f77551d = (int) al.a(getContext(), i3);
        this.f77552e = (int) al.a(getContext(), i16);
        this.f77553f = i17;
        setOrientation(0);
        this.C = iFaceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(this.F);
        }
        this.E = 1;
        i(strArr);
    }

    public void g(int i3, int i16, String[] strArr, IFaceDecoder iFaceDecoder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), strArr, iFaceDecoder);
        } else {
            f(i3, i16, (int) al.a(getContext(), 4.0f), strArr, iFaceDecoder);
        }
    }

    public void i(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) strArr);
            return;
        }
        this.f77555i = strArr;
        j(this.E);
        c();
    }

    public void setBorderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f77554h = i3;
        }
    }

    public void setNeedNightMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }

    public OverlappingImgLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f77551d = 0;
        this.f77552e = 0;
        this.f77553f = 0;
        this.f77554h = 1;
        this.f77555i = null;
        this.f77556m = new ArrayList();
        this.D = true;
        this.E = 1;
        this.F = new a();
    }

    public OverlappingImgLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f77551d = 0;
        this.f77552e = 0;
        this.f77553f = 0;
        this.f77554h = 1;
        this.f77555i = null;
        this.f77556m = new ArrayList();
        this.D = true;
        this.E = 1;
        this.F = new a();
    }
}
