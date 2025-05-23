package com.tencent.mm.plugin.appbrand.widget.music;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MusicSeekBar extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Context f152399a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f152400b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f152401c;

    /* renamed from: d, reason: collision with root package name */
    public SeekBar f152402d;

    /* renamed from: e, reason: collision with root package name */
    public ValueAnimator f152403e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f152404f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f152405g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.yl.a f152406h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f152407i;

    /* renamed from: j, reason: collision with root package name */
    public c f152408j;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MusicSeekBar.this.f152406h.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            MusicSeekBar.this.f152402d.setThumb(MusicSeekBar.this.f152406h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(int i3);
    }

    public MusicSeekBar(Context context) {
        this(context, null);
    }

    public void setColor(int i3) {
        this.f152400b.setTextColor(i3);
        this.f152401c.setTextColor(i3);
        this.f152402d.getProgressDrawable().setColorFilter(i3, PorterDuff.Mode.MULTIPLY);
        this.f152402d.getThumb().setColorFilter(i3, PorterDuff.Mode.MULTIPLY);
        this.f152407i.setColorFilter(i3, PorterDuff.Mode.MULTIPLY);
        this.f152406h.setColorFilter(i3, PorterDuff.Mode.MULTIPLY);
    }

    public void setMaxProgress(int i3) {
        this.f152401c.setText(a(i3));
        this.f152402d.setMax(i3);
    }

    public void setOnSeekBarChange(c cVar) {
        this.f152408j = cVar;
    }

    public void setProgress(int i3) {
        if (!this.f152405g && !this.f152404f) {
            this.f152400b.setText(a(i3));
            this.f152402d.setProgress(i3);
        }
    }

    public MusicSeekBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f152399a).inflate(R.layout.fmp, this);
        this.f152400b = (TextView) inflate.findViewById(R.id.bcp);
        this.f152401c = (TextView) inflate.findViewById(R.id.uvk);
        this.f152402d = (SeekBar) inflate.findViewById(R.id.ilm);
        this.f152400b.setText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT);
        this.f152401c.setText("--:--");
        this.f152406h = new com.tencent.luggage.wxa.yl.a(getResources().getDrawable(R.drawable.ok_));
        this.f152407i = getResources().getDrawable(R.drawable.k1v);
        this.f152402d.setOnSeekBarChangeListener(new a());
    }

    public MusicSeekBar(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152404f = false;
        this.f152405g = false;
        this.f152399a = context;
        a();
    }

    public void a(boolean z16) {
        if (this.f152403e == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            this.f152403e = ofFloat;
            ofFloat.setTarget(this.f152402d);
            this.f152403e.setRepeatCount(100);
            this.f152403e.setDuration(5000L);
            this.f152403e.setInterpolator(new LinearInterpolator());
            this.f152403e.addUpdateListener(new b());
        }
        this.f152405g = z16;
        if (z16) {
            this.f152403e.start();
        } else {
            this.f152403e.cancel();
            this.f152402d.setThumb(this.f152407i);
        }
    }

    public static String a(int i3) {
        StringBuilder sb5 = new StringBuilder();
        long j3 = i3 / 60000;
        long floor = (long) Math.floor((i3 % 60000) / 1000);
        if (j3 < 10) {
            sb5.append("0");
        }
        sb5.append(j3 + ":");
        if (floor < 10) {
            sb5.append("0");
        }
        sb5.append(floor);
        return sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            MusicSeekBar.this.f152404f = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            MusicSeekBar musicSeekBar = MusicSeekBar.this;
            musicSeekBar.f152404f = false;
            if (musicSeekBar.f152408j != null) {
                MusicSeekBar.this.f152408j.a(seekBar.getProgress());
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }
}
