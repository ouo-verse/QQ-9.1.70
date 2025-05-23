package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    private static Method f263788i;

    /* renamed from: a, reason: collision with root package name */
    private final View f263789a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f263790b;

    /* renamed from: c, reason: collision with root package name */
    private final View f263791c;

    /* renamed from: d, reason: collision with root package name */
    private final ImageView f263792d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f263793e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f263794f;

    /* renamed from: g, reason: collision with root package name */
    private int f263795g = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f263796h = "";

    public b(View view) {
        this.f263789a = view.findViewById(R.id.f68303fo);
        this.f263790b = (TextView) view.findViewById(R.id.f68323fq);
        this.f263791c = view.findViewById(R.id.f69513iy);
        this.f263792d = (ImageView) view.findViewById(R.id.f69503ix);
        this.f263793e = (TextView) view.findViewById(R.id.f69533j0);
        this.f263794f = (TextView) view.findViewById(R.id.f69523iz);
        try {
            ImageLoader.getInstance().downloadImageOnly("https://sola.gtimg.cn/aoi/sola/20200526111437_Jxz3xRir1X.png", null);
        } catch (Throwable th5) {
            QLog.w("ExtendEmptyViewDirector", 1, "init: failed to download image", th5);
        }
    }

    private static Method a(ImageView imageView) {
        Method method = f263788i;
        if (method != null) {
            return method;
        }
        try {
            f263788i = imageView.getClass().getMethod("setAsyncImage", String.class);
        } catch (Throwable th5) {
            QLog.w("ExtendEmptyViewDirector", 1, "getSetAsyncImageMethod: failed", th5);
        }
        return f263788i;
    }

    private void b(ImageView imageView, String str) {
        Method a16;
        if (this.f263796h.equals(str) || (a16 = a(imageView)) == null) {
            return;
        }
        try {
            a16.invoke(imageView, str);
            this.f263796h = str;
        } catch (Throwable th5) {
            QLog.w("ExtendEmptyViewDirector", 1, "setAsyncImage: failed", th5);
        }
    }

    public void c() {
        if (this.f263795g == 3) {
            return;
        }
        this.f263789a.setVisibility(8);
        this.f263791c.setVisibility(0);
        this.f263793e.setText("\u4ec0\u4e48\u90fd\u6ca1\u627e\u5230\u54e6");
        this.f263794f.setText("\u6ca1\u6709\u641c\u7d22\u5230\u76f8\u5173\u5185\u5bb9");
        b(this.f263792d, "https://sola.gtimg.cn/aoi/sola/20200508145045_234LrOf7V4.png");
        this.f263795g = 3;
    }

    public void d() {
        if (this.f263795g == 2) {
            return;
        }
        this.f263789a.setVisibility(0);
        this.f263791c.setVisibility(8);
        this.f263790b.setText("\u5237\u65b0\u5931\u8d25\uff0c\u8bf7\u4e0b\u62c9\u91cd\u8bd5");
        this.f263795g = 2;
    }

    public void e() {
        if (this.f263795g == 4) {
            return;
        }
        this.f263789a.setVisibility(8);
        this.f263791c.setVisibility(0);
        this.f263793e.setText("\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51");
        this.f263794f.setText("\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e");
        b(this.f263792d, "https://sola.gtimg.cn/aoi/sola/20200526111437_Jxz3xRir1X.png");
        this.f263795g = 4;
    }

    public void f() {
        if (this.f263795g == 0) {
            return;
        }
        this.f263789a.setVisibility(8);
        this.f263791c.setVisibility(8);
        this.f263795g = 0;
    }

    public void g() {
        if (this.f263795g == 1) {
            return;
        }
        this.f263789a.setVisibility(0);
        this.f263791c.setVisibility(8);
        this.f263790b.setText(R.string.gn_);
        this.f263795g = 1;
    }
}
