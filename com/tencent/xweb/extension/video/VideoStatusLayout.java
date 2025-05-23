package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoStatusLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f385132a;

    /* renamed from: b, reason: collision with root package name */
    public VideoDotPercentIndicator f385133b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f385134c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f385135d;

    /* renamed from: e, reason: collision with root package name */
    public LinearLayout f385136e;

    /* renamed from: f, reason: collision with root package name */
    public b f385137f;

    /* renamed from: g, reason: collision with root package name */
    public int f385138g;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoStatusLayout.this.setVisibility(8);
        }
    }

    public VideoStatusLayout(Context context) {
        super(context);
        this.f385138g = 1000;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.i8r, this);
        this.f385134c = (TextView) findViewById(R.id.f110116hn);
        this.f385132a = (ImageView) findViewById(R.id.f165768xj0);
        this.f385133b = (VideoDotPercentIndicator) findViewById(R.id.f28640jh);
        this.f385135d = (TextView) findViewById(R.id.f95925ga);
        this.f385136e = (LinearLayout) findViewById(R.id.f166032yg4);
        this.f385137f = new b();
        setVisibility(8);
    }

    public void setBrightProgress(int i3) {
        this.f385133b.setProgress(i3);
        this.f385133b.setVisibility(0);
        this.f385135d.setText(R.string.f242727vc);
        this.f385136e.setVisibility(0);
        this.f385132a.setImageResource(R.drawable.m7a);
        this.f385134c.setVisibility(8);
    }

    public void setDuration(int i3) {
        this.f385138g = i3;
    }

    public void setVideoTimeProgress(String str) {
        this.f385134c.setText(str);
        this.f385134c.setVisibility(0);
        this.f385136e.setVisibility(8);
    }

    public void setVolumeProgress(int i3) {
        this.f385133b.setProgress(i3);
        this.f385133b.setVisibility(0);
        this.f385135d.setText(R.string.f242897vt);
        this.f385136e.setVisibility(0);
        this.f385132a.setImageResource(R.drawable.m7m);
        this.f385134c.setVisibility(8);
    }

    public VideoStatusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f385138g = 1000;
        a(context);
    }

    public void a() {
        setVisibility(0);
        removeCallbacks(this.f385137f);
        postDelayed(this.f385137f, this.f385138g);
    }
}
