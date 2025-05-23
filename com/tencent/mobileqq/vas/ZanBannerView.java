package com.tencent.mobileqq.vas;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profile.like.c;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ZanBannerView extends FrameLayout {

    /* renamed from: m, reason: collision with root package name */
    private static String f307887m = "spKeyZanBannerIndex";

    /* renamed from: d, reason: collision with root package name */
    private List<c.a> f307888d;

    /* renamed from: e, reason: collision with root package name */
    private int f307889e;

    /* renamed from: f, reason: collision with root package name */
    private c.a f307890f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f307891h;

    /* renamed from: i, reason: collision with root package name */
    private a f307892i;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f307893a;

        /* renamed from: b, reason: collision with root package name */
        TextView f307894b;

        /* renamed from: c, reason: collision with root package name */
        TextView f307895c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f307896d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f307897e;

        a(RelativeLayout relativeLayout) {
            this.f307893a = relativeLayout;
            this.f307894b = (TextView) relativeLayout.findViewById(R.id.title);
            this.f307895c = (TextView) relativeLayout.findViewById(R.id.j5r);
            this.f307896d = (ImageView) relativeLayout.findViewById(R.id.f165883ds0);
            this.f307897e = (ImageView) relativeLayout.findViewById(R.id.f165884ds1);
        }
    }

    public ZanBannerView(Context context) {
        super(context);
        this.f307889e = -1;
        d(context);
    }

    private c.a c() {
        if (e()) {
            return null;
        }
        List<c.a> list = this.f307888d;
        int i3 = this.f307889e;
        this.f307889e = i3 + 1;
        this.f307890f = list.get(i3 % list.size());
        BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(f307887m, this.f307889e).commit();
        return this.f307890f;
    }

    private void d(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.bcd, (ViewGroup) null);
        this.f307891h = relativeLayout;
        this.f307892i = new a(relativeLayout);
        addView(this.f307891h);
        int i3 = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt(f307887m, 0);
        this.f307889e = i3;
        if (i3 > 100) {
            this.f307889e = 0;
        }
    }

    private boolean e() {
        List<c.a> list = this.f307888d;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    private void f(a aVar) {
        c.a c16 = c();
        if (c16 != null) {
            aVar.f307894b.setText(c16.f260228a);
            aVar.f307895c.setText(c16.f260229b);
            Vector<String> vector = c16.f260230c;
            if (vector != null) {
                int size = vector.size();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                int dpToPx = ViewUtils.dpToPx(36.0f);
                obtain.mRequestWidth = dpToPx;
                obtain.mRequestHeight = dpToPx;
                if (size == 1) {
                    aVar.f307896d.setImageDrawable(URLDrawable.getDrawable(c16.f260230c.get(0), obtain));
                    aVar.f307897e.setVisibility(8);
                } else if (size > 1) {
                    URLDrawable drawable = URLDrawable.getDrawable(c16.f260230c.get(0), obtain);
                    URLDrawable drawable2 = URLDrawable.getDrawable(c16.f260230c.get(1), obtain);
                    aVar.f307896d.setImageDrawable(drawable);
                    aVar.f307897e.setImageDrawable(drawable2);
                    aVar.f307897e.setVisibility(0);
                }
            }
        }
    }

    public String a() {
        c.a aVar = this.f307890f;
        if (aVar != null) {
            return aVar.f260231d;
        }
        return null;
    }

    public String b() {
        c.a aVar = this.f307890f;
        if (aVar != null) {
            return aVar.f260232e;
        }
        return "";
    }

    public void setInfoList(List<c.a> list) {
        this.f307888d = list;
        f(this.f307892i);
    }

    public ZanBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f307889e = -1;
        d(context);
    }

    public ZanBannerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f307889e = -1;
        d(context);
    }
}
