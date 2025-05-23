package com.tencent.mobileqq.tvideo.view.morepanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import jy2.f;

/* loaded from: classes19.dex */
public abstract class TVideoMorePanelSeekBar extends LinearLayout implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: d, reason: collision with root package name */
    protected SeekBar f304821d;

    public TVideoMorePanelSeekBar(Context context) {
        super(context);
        f(context);
    }

    private void f(Context context) {
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.i2f, this);
        ImageView imageView = (ImageView) findViewById(R.id.yh9);
        ImageView imageView2 = (ImageView) findViewById(R.id.f166795ia4);
        f fVar = f.f411169a;
        fVar.j(imageView, b());
        fVar.j(imageView2, c());
        ((TextView) findViewById(R.id.title)).setText(d());
        this.f304821d = (SeekBar) findViewById(R.id.ilm);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    protected abstract String b();

    protected abstract String c();

    protected abstract int d();

    protected void e() {
        this.f304821d.setOnClickListener(new View.OnClickListener() { // from class: ly2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TVideoMorePanelSeekBar.g(view);
            }
        });
        this.f304821d.setOnSeekBarChangeListener(this);
    }

    public TVideoMorePanelSeekBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context);
    }

    public TVideoMorePanelSeekBar(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f(context);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
    }
}
