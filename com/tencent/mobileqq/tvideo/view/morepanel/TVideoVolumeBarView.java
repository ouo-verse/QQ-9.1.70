package com.tencent.mobileqq.tvideo.view.morepanel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.player.playercontroller.impl.TVideoVolumeBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dy2.d;
import ly2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoVolumeBarView extends TVideoMorePanelSeekBar {

    /* renamed from: e */
    private boolean f304822e;

    /* renamed from: f */
    private d f304823f;

    /* renamed from: h */
    private Runnable f304824h;

    public TVideoVolumeBarView(Context context) {
        super(context);
        this.f304822e = false;
        this.f304823f = new d();
        this.f304824h = new b(this);
    }

    private void i(int i3) {
        this.f304823f.c(i3 / 100.0f);
    }

    public void l() {
        if (!this.f304822e) {
            this.f304821d.setProgress((int) ((this.f304823f.a() * 100.0f) / this.f304823f.b()));
        }
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar
    protected String b() {
        return "https://ugd.gtimg.com//vg/1673857913687_tvideo_volume_start.png";
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar
    protected String c() {
        return "https://ugd.gtimg.com//vg/1673857901165_tvideo_volume_end.png";
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar
    protected int d() {
        return R.string.f237057g1;
    }

    public void j() {
        try {
            TVideoVolumeBroadcastReceiver.b().h();
            TVideoVolumeBroadcastReceiver.b().g(this.f304824h);
        } catch (Exception e16) {
            QLog.d("VolumeBarView", 4, "onHide e " + e16);
        }
    }

    public void k() {
        if (this.f304824h == null) {
            this.f304824h = new b(this);
        }
        if (this.f304823f == null) {
            this.f304823f = new d();
        }
        this.f304821d.setProgress((int) ((this.f304823f.a() * 100.0f) / this.f304823f.b()));
        TVideoVolumeBroadcastReceiver.b().f();
        TVideoVolumeBroadcastReceiver.b().e(this.f304824h);
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar, android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (seekBar == null) {
            return;
        }
        if (this.f304822e || z16) {
            i(i3);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f304822e = true;
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        super.onStopTrackingTouch(seekBar);
        this.f304822e = false;
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    public TVideoVolumeBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f304822e = false;
        this.f304823f = new d();
        this.f304824h = new b(this);
    }

    public TVideoVolumeBarView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f304822e = false;
        this.f304823f = new d();
        this.f304824h = new b(this);
    }
}
