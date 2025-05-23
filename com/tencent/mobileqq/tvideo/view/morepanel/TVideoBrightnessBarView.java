package com.tencent.mobileqq.tvideo.view.morepanel;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import dy2.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoBrightnessBarView extends TVideoMorePanelSeekBar {
    public TVideoBrightnessBarView(Context context) {
        super(context);
    }

    private void h(int i3) {
        if (i() != null) {
            a.f395204a.d(i(), i3 / 100.0f);
        }
    }

    @Nullable
    private Activity i() {
        Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    private void l() {
        if (i() != null) {
            this.f304821d.setProgress((int) (a.f395204a.a(i()) * 100.0f));
        }
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar
    protected String b() {
        return "https://ugd.gtimg.com//vg/1673857868523_tvideo_brightness_start.png";
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar
    protected String c() {
        return "https://ugd.gtimg.com//vg/1673857843614_tvideo_brightness_end.png";
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar
    protected int d() {
        return R.string.f237037fz;
    }

    public void k() {
        l();
    }

    @Override // com.tencent.mobileqq.tvideo.view.morepanel.TVideoMorePanelSeekBar, android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (seekBar != null && z16) {
            h(i3);
        }
    }

    public TVideoBrightnessBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TVideoBrightnessBarView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void j() {
    }
}
