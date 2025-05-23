package com.qq.e.comm.plugin.base.ad.b.b.a;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f38415a;

    /* renamed from: b, reason: collision with root package name */
    private ProgressBar f38416b;

    /* renamed from: c, reason: collision with root package name */
    private a f38417c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f38418d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f38419e;

    /* renamed from: f, reason: collision with root package name */
    private Context f38420f;

    /* renamed from: g, reason: collision with root package name */
    private final int f38421g;

    public b(Context context) {
        super(context);
        this.f38421g = (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        if (context == null) {
            return;
        }
        this.f38420f = context;
        d();
    }

    private void d() {
        e();
        j();
        f();
        g();
        h();
        i();
    }

    private void e() {
        this.f38417c = new a(this.f38420f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 29.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 35.0f, getResources().getDisplayMetrics()));
        this.f38417c.a(Color.parseColor("#2a2d33"));
        this.f38417c.a(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        layoutParams.gravity = 19;
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics());
        this.f38417c.setLayoutParams(layoutParams);
        a aVar = this.f38417c;
        int i3 = this.f38421g;
        aVar.setPadding(i3, i3, i3, i3);
        addView(this.f38417c);
        this.f38417c.setVisibility(8);
    }

    private void f() {
        View view = new View(this.f38420f);
        view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 0.67f, getResources().getDisplayMetrics()));
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    private void g() {
        try {
            this.f38416b = new ProgressBar(this.f38420f, null, R.attr.progressBarStyleHorizontal);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.34f, getResources().getDisplayMetrics()));
            layoutParams.gravity = 80;
            this.f38416b.setLayoutParams(layoutParams);
            this.f38416b.setMax(100);
            ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(0), 3, 1);
            ClipDrawable clipDrawable2 = new ClipDrawable(new ColorDrawable(Color.parseColor("#ff008de8")), 3, 1);
            clipDrawable.setLevel(10000);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            this.f38416b.setProgressDrawable(layerDrawable);
            addView(this.f38416b);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void h() {
        try {
            this.f38415a = new TextView(this.f38420f);
            int applyDimension = (int) TypedValue.applyDimension(1, 95.0f, getResources().getDisplayMetrics());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = applyDimension;
            layoutParams.rightMargin = applyDimension;
            this.f38415a.setLayoutParams(layoutParams);
            this.f38415a.setTextSize(2, 15.33f);
            this.f38415a.setTextColor(Color.parseColor("#ff2a2d33"));
            this.f38415a.setSingleLine();
            this.f38415a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            addView(this.f38415a);
        } catch (Throwable th5) {
            GDTLogger.e("initTitleView error:", th5);
        }
    }

    private void i() {
        ImageView imageView = new ImageView(this.f38420f);
        this.f38418d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f38418d.setImageBitmap(am.a("iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4BAMAAADLSivhAAAAG1BMVEUAAAAzMzM0NDQ0NDQzMzM1NTU3Nzc2NjYzMzOWGSDVAAAACHRSTlMA8djAmkMlPXIsu/oAAACFSURBVFjD7dQxCsJAEIVhQUxvZQ5gYWlpbWVpaZkreIRoAu/YIUwx7SyPNOH/yh8Wlt2dPQAAAADARk7P8/XdFFL3kPQfWkL6anVpCKnrtRqHekhHhXs9pI/CXA/ppTDVQ7op/Ooh9QpjITiLrW1bB2ZdlfVIrOfpDIY1ktZnAAAAAGDXFqcOwHOP/Db5AAAAAElFTkSuQmCC"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388629;
        this.f38418d.setLayoutParams(layoutParams);
        ImageView imageView2 = this.f38418d;
        int i3 = this.f38421g;
        imageView2.setPadding(i3, i3, i3, i3);
        this.f38418d.setVisibility(4);
        addView(this.f38418d);
    }

    private void j() {
        ImageView imageView = new ImageView(this.f38420f);
        this.f38419e = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f38419e.setImageBitmap(am.a("iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAAAXNSR0IArs4c6QAAABxpRE9UAAAAAgAAAAAAAAAUAAAAKAAAABQAAAAUAAAA7JKkhcsAAAC4SURBVFgJ7JXhCoAgDIR7xPpV7/8jqGcIagcOLFy5ORHCgQjh7r5dUsPQqyfQE/hvAiONttFaaU0VxoQmtOEBL3Xt1HGGddC+qBXkBmhBk/UBqS5MxwLYvSDnoBVrw0tdeAXxlB6Qz+RY03yFJEGkoK1UcgjAonXz9oCsBsekJQYlveyftVuMLD1ZMNIhjaHmrORnep5j7HFvTXDc9AbZHO4LMvXtxEBNKpVk/Idw+c6VTiZBusBdAAAA///+uqAkAAAAqklEQVTtldEKgCAMRfvEeqr/fwj6h6B2gr3ItMzRILxggrJ7jxNpGNq1iMUu40gGa+yFKgensKGQFhxAaTdDIHNwswCW9j65biCsLrGuCoN8AhcGWQP3OeQbOIVsqVWP4uwR4OFhQnoae3pdsJN8716rearCYg6SrGqtUqF/BGZgCWiVBUlWtTapUEAvOIVIIcmq1igVFHK6V1dwk4gn3mSQ1dU70Dvwyw6c2DEXoRUQ0S8AAAAASUVORK5CYII="));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.f38420f, 40), ak.a(this.f38420f, 40));
        layoutParams.leftMargin = ak.a(this.f38420f, 36);
        layoutParams.gravity = 19;
        this.f38419e.setLayoutParams(layoutParams);
        ImageView imageView2 = this.f38419e;
        int i3 = this.f38421g;
        imageView2.setPadding(i3, i3, i3, i3);
        this.f38419e.setVisibility(4);
        addView(this.f38419e);
    }

    public void a() {
        a aVar = this.f38417c;
        if (aVar == null || aVar.getVisibility() == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.f38420f, 40), ak.a(this.f38420f, 40));
        layoutParams.leftMargin = ak.a(this.f38420f, 7);
        layoutParams.gravity = 19;
        this.f38419e.setLayoutParams(layoutParams);
    }

    public void b(View.OnClickListener onClickListener) {
        ImageView imageView = this.f38419e;
        if (imageView != null) {
            imageView.setClickable(true);
            this.f38419e.setOnClickListener(onClickListener);
        }
    }

    public void c() {
        a aVar = this.f38417c;
        if (aVar != null) {
            aVar.setVisibility(0);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        ImageView imageView = this.f38418d;
        if (imageView != null) {
            imageView.setClickable(true);
            this.f38418d.setOnClickListener(onClickListener);
        }
    }

    public void b() {
        ImageView imageView = this.f38419e;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void a(String str) {
        TextView textView = this.f38415a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f38417c.setClickable(true);
        this.f38417c.setOnClickListener(onClickListener);
    }
}
