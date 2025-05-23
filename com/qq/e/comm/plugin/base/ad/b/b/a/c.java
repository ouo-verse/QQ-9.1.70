package com.qq.e.comm.plugin.base.ad.b.b.a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.qq.e.comm.util.RoundRectUtil;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f38426a;

    /* renamed from: b, reason: collision with root package name */
    private String f38427b;

    /* renamed from: c, reason: collision with root package name */
    private String f38428c;

    /* renamed from: d, reason: collision with root package name */
    private String f38429d;

    /* renamed from: e, reason: collision with root package name */
    private String f38430e;

    /* renamed from: f, reason: collision with root package name */
    private IInnerWebView f38431f;

    /* renamed from: g, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.b.b.a f38432g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f38433h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f38434i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f38435j;

    public c(Context context, com.qq.e.comm.plugin.base.ad.b.b.a aVar) {
        this.f38426a = context;
        this.f38432g = aVar;
        f();
        d();
        e();
    }

    private void a(View view, View view2, View view3) {
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
                EventCollector.getInstance().onViewClickedBefore(view4);
                c.this.f38435j.setVisibility(4);
                c.this.f38433h.setVisibility(4);
                EventCollector.getInstance().onViewClicked(view4);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
                EventCollector.getInstance().onViewClickedBefore(view4);
                c.this.f38435j.setVisibility(4);
                c.this.f38433h.setVisibility(4);
                if (c.this.f38431f != null) {
                    c.this.f38431f.reload();
                } else if (c.this.f38432g != null) {
                    c.this.f38432g.e();
                }
                EventCollector.getInstance().onViewClicked(view4);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
                EventCollector.getInstance().onViewClickedBefore(view4);
                c.this.f38435j.setVisibility(4);
                c.this.f38433h.setVisibility(4);
                if (!TextUtils.isEmpty(c.this.f38428c)) {
                    ClipboardMonitor.setPrimaryClip((ClipboardManager) c.this.f38426a.getSystemService("clipboard"), ClipData.newRawUri("Label", Uri.parse(c.this.f38428c)));
                }
                c.this.f38434i.setVisibility(0);
                aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.c.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f38434i.setVisibility(4);
                    }
                }, 500L);
                EventCollector.getInstance().onViewClicked(view4);
            }
        });
    }

    private void d() {
        ImageView imageView = new ImageView(this.f38426a);
        this.f38433h = imageView;
        imageView.setBackgroundColor(-16777216);
        this.f38433h.getBackground().setAlpha(150);
        this.f38433h.setVisibility(4);
        this.f38433h.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void e() {
        ImageView imageView = new ImageView(this.f38426a);
        this.f38434i = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f38434i.setImageBitmap(am.a("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"));
        this.f38434i.setVisibility(4);
    }

    private LinearLayout f() {
        LinearLayout linearLayout = new LinearLayout(this.f38426a);
        this.f38435j = linearLayout;
        linearLayout.setOrientation(1);
        this.f38435j.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(a(20, 0, 4), -1, 0));
        this.f38435j.setVisibility(4);
        LinearLayout linearLayout2 = new LinearLayout(this.f38426a);
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(a(20, 0, 4), -1, 220));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setPadding(ak.a(this.f38426a, 24), ak.a(this.f38426a, 24), ak.a(this.f38426a, 24), ak.a(this.f38426a, 24));
        this.f38435j.addView(linearLayout2, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(ak.a(this.f38426a, 6), ak.a(this.f38426a, 6), ak.a(this.f38426a, 6), ak.a(this.f38426a, 6));
        int c16 = com.qq.e.comm.plugin.base.a.a.a().c();
        if (a(c16, 1)) {
            linearLayout2.addView(a("iVBORw0KGgoAAAANSUhEUgAAAKAAAACgCAMAAAC8EZcfAAAAmVBMVEUAAAAS4HcS4HcT4HYY5Hoy/4YS4HYT4XkS4HcT4HcU43po/5gT4HcT4XcS4HcT4Xcf5XsT4HYU4XgV43kS4HcS4HcS4HcT4HcS4HcT4XcU4XgS4HcS4HYT4HcT4HYT4XgT4HYT4HcV4XcU4XgU5HsU64QS4HcT4HgY534e5YcU4HgT4HcU4HgS4HYS4HYT4nkT4XcT4HcS33Y6e8hOAAAAMnRSTlMA++T3HwXtQdbLJQKch4BWEOhnLvLBta2oUDrdz7xwXqSRSCoYDIxjFAh0a1rGljR3eqaDo2MAAAQKSURBVHja7dpnk6JAEAbgd4gCBlQMmHPcdff6//+4OynvrpAgOIDWXT8frbJsmNA97YAxxhhjjDHGGGOMMcYYY/+brXneDSbjtidUQ5n0L9+rA97G1q/XBEUoi/kGr3ec91VK1GvpeCl7aVA6Y2fjZeyFoAymI7zEoS4oo/oB1dsblJ3RcVCtzZTysdaokqlQXt4K1ekIyk90UJUmPWfnoBI7etagkghP9Lw6yvdBMpoo21olKSuU61gjOe0NSrWke97i1OzHhlKfNXoUMUCZ1iJSUGkJG/fQxS8tr9pBjiQ4xUVgJCjMcpLWVM1BaUy6N8fNkMJGuLHoXgulGdA9GzczChHH5Fk7QVlsQfcOCdujkZYXv1CG+N8yk/KflvzWaYmSWBSxAAKukpAyNI8iFJRDoxgfuNKHdEeMcLXtUYw1StGiOPWu7q4sihCNtXPwxxSng1I0KJ6gBCqFGdawcerMW34XpeiThPHyw0bJavSs2vcaN9uN3V1rBwclUOgpYnFbL+b30DJ+fzieLuc2iqXSE0RdC3aA2TSuv3RZ6SiOoPw+g7H9GgpKoJxcFKVNeYkf17nm9yiNt9NetUgm3Wsh9vhr4rJFET4pn50O6A1BGYxHKEA9fyOhO6FsREOHtA7lIFrXb6iU2WQDWV+UwzzvE1FNOkLdoMy+Y+IrP8ILZTUAsKe8agfpM1NGYxfwKb/JEVKcMWVjAppBT7hUs44HkRO02liNzgqFqU1zNGsXeqrXFcpA1e6rby+oUN1wymsHxcxhEp6GOqTsMzYB9fBkOCOgqTHn9y6FzCCnR491gTmFbP4ky5ijffhZFB1SbPVxhQUgPG5qXH9ESej3tCDnTI+cIsNGWlw95MZXcdPSSwY72oLYxe2j3/GHWeFCjt6jVEpMC0LMg1yuhAfeD4I2Cm9+uRal6QO6Svd6zVm07O//OA0E3WtAlptauTauU1BGH9K2U0p2BnySMYY8p0GJPoA9yTBQBF+lBD4wIxkChZinvMEzyfBQiKNK8WbX4GUoBQUoklfximRMUAgzpZbRSMai3G4m1QAYJGFWcEPdWyz7oXx/kGx1jlAEV/yu5bdBKdra9bw/uVRqI1ScIhvqAw1/bdem/7HffwEbQU9bohCLYL2ZSDCkp3VRCCP9NtFIslSQN1SXbin/CIxQEB2pbPG+10JkLv+0XVRF/6T8xArV0RTK7QeqZCtyWbh8djtnfA4qts4VYd1B5WyLshJnvILeFJSJZ+JFvmpvcisu0bFpyFWp5Tuex/TIEC/l+D1K18arbfaDNoWpn8v9zPpTBr4BzT9d+j2rZk0H9Uanq+Nqrtzanm9r21SDxuob04ZEHt6aaQ3AGGOMMcYYY4wxxhhjjLF/2k8oFutl8ze7uAAAAABJRU5ErkJggg==", "\u5fae\u4fe1\u597d\u53cb", 1), layoutParams2);
        }
        if (a(c16, 2)) {
            linearLayout2.addView(a("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", "\u5fae\u4fe1\u670b\u53cb\u5708", 2), layoutParams2);
        }
        LinearLayout a16 = a("iVBORw0KGgoAAAANSUhEUgAAAKAAAACgCAMAAAC8EZcfAAAAmVBMVEUAAAAdHR0iIiJISEgaGholJSUbGxsbGxsfHx8mJiYaGhoaGhoaGhoaGhoaGhoaGhoaGhobGxsaGhobGxsaGhobGxsbGxsaGhoaGhobGxscHBwaGhocHBwbGxsfHx8aGhoaGhoaGhoaGhobGxscHBwdHR0bGxsaGhobGxsbGxsaGhoaGhocHBwcHBwbGxsbGxsbGxsbGxsaGhrcQIc2AAAAMnRSTlMAKxQDkw3SaR4I6ab18X3f+77sxa2gVtaIbU9CPOUYzbSZYlxIIty52cnCczYn3Y2DxiNlkokAAAOKSURBVHja7dtbc6owFIbhD5BKFHfF7QnFs1Z7sIf8/x+3W5YtsoMzcLO6LtZzVyczfScSm6QjlFJKKaWUUkoppZRSSin1q8LzwUAof9d9je2n3mQzk1c5T/r2Sjz0IMlLYh2jA6QIWrZKvw0Z/MTesAkgwPnVFnonWigXTyF+ndexF4vWPu/xx6OevVj/+hz+9HVSgx/+NLZkCnbVfcMQJdHKkh2YVff9wf9M1+YGIdi5fW24gnXRzs/tc4UTWtg+amLsIy/NppC1jwztlxXq4e+DZ3NL1MDdR+gp3KIe/j5M8zEt1MPfhxl9iKMe/j5k+agP1MPfh0M+7BU18PcVy3iCevj7MM8HJqiHvw/bfGQX9fD3ocu+J1wumvQFg3zsHmzMY5M+jGk7Y8Bm1KgveOD+nB436kNqc2OwKGbEPqOWjC5D7sCmTX0j1BJ1LPMSMQuaEVOv7576nsBmXsxI/b5BBDZvNCON+voZ+DxUHcTNrT7SBp/I5nxc+dOzSVTdx3+gy9wj2s5+OoUy+qq273R3cAxE9CF1D0BDCnkT0YdnN2ZuyYuEPuwq/oxMqeUooa/YvlfcYM3x7Ym3zz0A9QJcCwfl7Ii5r50cZ7gwPZqsqiez74MsWfuCbmk7N6Rl7OwgSoPW7H32sXxEiyOUtMoHt3CzuBuDAfWVjt1L2oBuULLPX3wAN+orHxo3NjfDtZDmFcyKvr8G36KYFrKHa7R2QvAq+kJnR2hPBldO+WtncHL7iH9vczt3m3gAG7ev4NH7meIKve8GTNw+d8/VP6Pg03MJFm6fYxvb3s49zE/AaFP0VTCeqbgN2YBP6vQ53N3CDGzm/SZ9eKfPaQMu4aBRXxRzX2BNqW8VNrov9MBlSTPSiRrdF3bBpmVzWaPR/QNYFJfK3bp9JAWbrJiR+n0j8KElsm7U92HAZ0VXUk367nwwokcwEtsX0CMotu9y7L4X2/f931OxfZfN50BsH0A7mUBsHxZ03Se2D0f75V1sH1L63WL7ENncTGofcEcfNIHUPmwp4F1qH4IJJYyF9gFjaojdx9CMJPQBxxvX4MsPGX3wHyx5nKNgngdC+ugGizylB3ows+nCiukD9rH90Vkdk9PVz48C+gDv3t4wEvJNGz+xlZ4hRbCtmMS1qG8BmXRhS5IM0ry8r/oU1xtulxApWHr77CzgazVKKaWUUkoppZRSSimlbvsH/0sTDY0v7U0AAAAASUVORK5CYII=", "\u590d\u5236\u94fe\u63a5");
        linearLayout2.addView(a16, layoutParams2);
        LinearLayout a17 = a("iVBORw0KGgoAAAANSUhEUgAAAKAAAACgCAMAAAC8EZcfAAAAn1BMVEUAAABNTU0aGhobGxsrKysaGhoaGhoeHh4aGhoaGhoaGhojIyMaGhoaGhobGxsaGhohISEaGhobGxsaGhocHBwaGhoaGhobGxsbGxscHBwcHBwaGhobGxscHBweHh4dHR0aGhoaGhobGxscHBwgICAeHh4bGxsdHR0aGhobGxscHBwzMzMaGhoaGhoaGhoaGhobGxsbGxsbGxsbGxsaGhp3HACKAAAANHRSTlMAA8X4DJPsIvWceRTnflNOB/Hau23hsqFxRSbOMSwdGt6nZzgXENI9wF5ZBdSKYq2D05ZJcThSXQAAA89JREFUeNrt2+t6ojAQBuAvoCAUBfF8th5WXdu6bef+r20fCWXdda22TjQ/5v3bqqMZMskEIIQQQgghhBBCCCGEsN24vOtuYa+JR0ROCdb6RWR3hAFZHuFPsj3CR9sjVBKhRGgBqyNU/nv37TGyM0I1rzZc0uyLUPU6dTrWgB3Gzy36vx4s4AcunTLD3S069Ikh7kw163TIczrhz/c4Je0ZdzYa0B+Vdlf/YA8/SCvjzmYVKqxfSoBd8ZUe6YMb+IBt8U1+FOGVx7Avvv6Ucs4IFsY3jEirv8DG+PoeaYP+V+NbvDnBBIZNWqQFCQ4kg/PxlVIiisYwavlKWhV/6Rbxndv5DUowqX2i0gYX5N+MMjsY1CXt5egP5+OD71ImhDHzkx+ROLr+XvL13CEMSdLTA6lq3fmlDZKnBGZU8+l5i2/arg0udYoc8sZXdumIXB8F/iu4xtBkeoQBc8q0cZUdZebQ+H/Aio+rjF1Tm75RXkF4erE0AreOXsEscaWSp0s5mJX0Gv8X12TlPoDXRmcgw9suXCP75gbtdcAgMHGZLBj7GT3KPICTnmAjBQYqyldEnALO7UY5TxdO07zKsYhpLwWjMWvaLCkzgcaX1wMw0RubGHyaOmt4M7oLPm+8m4mQ9t7Yp+kamNTYp+oBb9N0qLcm7LOMzzsptMDH4y1OD7TngY9LewmYJLTnsgeowETpANmHeAkmS/Yh1j23sb0XyRPvRmfEPs04ernKW9odgHlL17S0tAMIedvj5aK0W1o8mUt7kdWVLVhsK+zNBVWnvRVYrHSTQvF3jqqcjdA2+LvnDuek1QWnIWX6YNA3ciQ/ZeodFQ24KXjpvGkpXE218nzm5VPmJ9u9kD6YOVwF/om9EB8WE6rZ8j5HVEp7acJyWpUqsNuwdNGrlNmAn5rmp0QMp1VTBQPia47qtK1DmRhGtK8+CnwuTquM8CtXfv+YitMqM5r5B8zxLfMKHW8djAyy17/mhpY2zFm2KNPqfyO+j9cuYU4xSt4QXzT0ivwwKiat3sOX9OqkxTDshXJVhYupKuVeYFxIucYEF5qsKRfiBmaUqzfVF+92neEmai7lBiuctRpQzq3hRlYRfVj38Knemj5EK9zMokGFwWyJE5azARUaC9yQCl0quLvNBEcmm93h/4QKtzVa06E0aL77qnh0oxmkdGg9wu1tIvpXJUrTqEL/ija4i1IY0QWisIR7SZpTOmPaTHBXq6BOJ9WDFe4vicuv9B+v5TiBLRZx2HG8w0c34gdYqLTo9xf2PG8lhBBCCCGEEEIIIYT41G+hSS609dJYkwAAAABJRU5ErkJggg==", "\u5237\u65b0");
        linearLayout2.addView(a17, layoutParams2);
        TextView textView = new TextView(this.f38426a);
        textView.setText("\u53d6\u6d88");
        textView.setTextSize(16.0f);
        textView.setTextColor(-16777216);
        textView.setGravity(17);
        textView.setBackgroundColor(-1);
        this.f38435j.addView(textView, new LinearLayout.LayoutParams(-1, ak.a(this.f38426a, 50)));
        a(a16, a17, textView);
        return this.f38435j;
    }

    public View b() {
        return this.f38434i;
    }

    public LinearLayout c() {
        return this.f38435j;
    }

    private float[] a(int i3, int i16, int i17) {
        float[] fArr = new float[8];
        while (i16 < i17) {
            fArr[i16] = ak.a(this.f38426a, i3);
            i16++;
        }
        return fArr;
    }

    private LinearLayout a(String str, String str2) {
        LinearLayout linearLayout = new LinearLayout(this.f38426a);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.f38426a);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(am.a(str));
        imageView.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(ak.a(this.f38426a, 10), -1, 255));
        imageView.setPadding(ak.a(this.f38426a, 5), ak.a(this.f38426a, 5), ak.a(this.f38426a, 5), ak.a(this.f38426a, 5));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ak.a(this.f38426a, 50), ak.a(this.f38426a, 50));
        layoutParams.setMargins(0, 0, 0, ak.a(this.f38426a, 5));
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f38426a);
        textView.setText(str2);
        textView.setTextSize(10.0f);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, ak.a(this.f38426a, 19));
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    public c(Context context, IInnerWebView iInnerWebView) {
        this.f38426a = context;
        this.f38431f = iInnerWebView;
        f();
        d();
        e();
    }

    private LinearLayout a(String str, String str2, final int i3) {
        LinearLayout a16 = a(str, str2);
        a16.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c.this.f38435j.setVisibility(4);
                c.this.f38433h.setVisibility(4);
                com.qq.e.comm.plugin.base.a.a.a().a(i3, c.this.f38427b, c.this.f38429d, c.this.f38430e, c.this.f38428c);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return a16;
    }

    public ImageView a() {
        return this.f38433h;
    }

    public static boolean a(int i3, int i16) {
        int i17 = i16 - 1;
        return (i3 & (1 << i17)) == ((int) Math.pow(2.0d, (double) i17));
    }
}
