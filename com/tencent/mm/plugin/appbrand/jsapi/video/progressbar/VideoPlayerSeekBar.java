package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.dn.c;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class VideoPlayerSeekBar extends com.tencent.luggage.wxa.ch.a implements g.b {
    public c H;
    public boolean I;
    public int J;
    public int K;
    public int L;

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                w.d("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
                VideoPlayerSeekBar videoPlayerSeekBar = VideoPlayerSeekBar.this;
                videoPlayerSeekBar.f123511m = false;
                videoPlayerSeekBar.C = motionEvent.getX();
                g.d dVar = VideoPlayerSeekBar.this.f123499a;
                if (dVar != null) {
                    dVar.a();
                }
            } else if (motionEvent.getAction() == 2) {
                float x16 = motionEvent.getX();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VideoPlayerSeekBar.this.f123503e.getLayoutParams();
                VideoPlayerSeekBar videoPlayerSeekBar2 = VideoPlayerSeekBar.this;
                int a16 = videoPlayerSeekBar2.a(layoutParams.leftMargin + ((int) (x16 - videoPlayerSeekBar2.C)), videoPlayerSeekBar2.H);
                layoutParams.leftMargin = a16;
                VideoPlayerSeekBar.this.f123503e.setLayoutParams(layoutParams);
                int i3 = VideoPlayerSeekBar.this.H.f124397a;
                VideoPlayerSeekBar videoPlayerSeekBar3 = VideoPlayerSeekBar.this;
                if (videoPlayerSeekBar3.f123507i > 0) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) videoPlayerSeekBar3.f123501c.getLayoutParams();
                    layoutParams2.width = a16;
                    VideoPlayerSeekBar.this.f123501c.setLayoutParams(layoutParams2);
                }
                VideoPlayerSeekBar.this.f123505g.setText(VideoPlayerSeekBar.this.c(i3 / 60) + ":" + VideoPlayerSeekBar.this.c(i3 % 60));
                VideoPlayerSeekBar.this.f123511m = true;
            } else {
                VideoPlayerSeekBar videoPlayerSeekBar4 = VideoPlayerSeekBar.this;
                int i16 = videoPlayerSeekBar4.f123508j;
                if (videoPlayerSeekBar4.f123511m) {
                    i16 = videoPlayerSeekBar4.H.f124397a;
                    videoPlayerSeekBar4.f123508j = i16;
                }
                if (VideoPlayerSeekBar.this.f123499a != null) {
                    w.d("MicroMsg.Video.VideoPlayerSeekBar", "current time : " + i16);
                    VideoPlayerSeekBar.this.f123499a.a(i16);
                }
                VideoPlayerSeekBar.this.f123511m = false;
            }
            return true;
        }
    }

    public VideoPlayerSeekBar(Context context) {
        super(context);
        this.H = new c();
        this.I = false;
        this.J = -1;
        this.K = -1;
        this.L = -1;
    }

    private int getBarPointPaddingLeft() {
        if (this.K == -1) {
            this.K = this.f123503e.getPaddingLeft();
        }
        return this.K;
    }

    private int getBarPointPaddingRight() {
        if (this.L == -1) {
            this.L = this.f123503e.getPaddingRight();
        }
        return this.L;
    }

    @Override // com.tencent.luggage.wxa.mg.g.b
    public void b(int i3) {
        a(i3);
    }

    @Override // com.tencent.luggage.wxa.ch.a
    public int getBarPointWidth() {
        if (this.J == -1) {
            this.J = this.f123503e.getWidth();
        }
        return this.J;
    }

    @Override // com.tencent.luggage.wxa.ch.a
    public int getLayoutId() {
        return R.layout.dyv;
    }

    public ImageView getPlayBtn() {
        return this.f123504f;
    }

    public TextView getPlaytimeTv() {
        return this.f123505g;
    }

    @Override // com.tencent.luggage.wxa.ch.a
    public void o() {
        View inflate = View.inflate(getContext(), getLayoutId(), this);
        this.f123500b = inflate;
        this.f123501c = (ImageView) inflate.findViewById(R.id.f25900c3);
        this.f123502d = (ImageView) this.f123500b.findViewById(R.id.f25890c2);
        this.f123503e = (ImageView) this.f123500b.findViewById(R.id.f25920c5);
        this.f123504f = (ImageView) this.f123500b.findViewById(R.id.fuz);
        this.f123505g = (TextView) this.f123500b.findViewById(R.id.f25650be);
        this.f123506h = (TextView) this.f123500b.findViewById(R.id.f25720bl);
        this.f123503e.setOnTouchListener(new a());
    }

    @Override // com.tencent.luggage.wxa.ch.a
    public void q() {
        if (this.f123507i == 0 || this.f123511m || this.f123503e == null || getBarLen() == 0) {
            return;
        }
        this.f123505g.setText(c(this.f123508j / 60) + ":" + c(this.f123508j % 60));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f123503e.getLayoutParams();
        int barLen = getBarLen();
        layoutParams.leftMargin = a(this.f123508j, barLen);
        this.f123503e.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f123501c.getLayoutParams();
        layoutParams2.width = (int) (((this.f123508j * 1.0d) / this.f123507i) * barLen);
        this.f123501c.setLayoutParams(layoutParams2);
        requestLayout();
    }

    @Override // com.tencent.luggage.wxa.ch.a, com.tencent.luggage.wxa.mg.g.a
    public void setIsPlay(boolean z16) {
        this.I = z16;
        super.setIsPlay(z16);
    }

    public void setPlayBtnOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f123504f;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.luggage.wxa.ch.a, com.tencent.luggage.wxa.mg.g.b
    public void setVideoTotalTime(int i3) {
        this.f123507i = i3;
        this.f123508j = 0;
        this.f123506h.setText(c(this.f123507i / 60) + ":" + c(this.f123507i % 60));
        q();
    }

    public final int a(int i3, c cVar) {
        int barPointPaddingLeft = ((FrameLayout.LayoutParams) this.f123502d.getLayoutParams()).leftMargin - getBarPointPaddingLeft();
        int i16 = i3 - barPointPaddingLeft;
        int i17 = this.f123507i;
        int barLen = (int) (((i16 * 1.0d) / getBarLen()) * i17);
        cVar.f124397a = barLen;
        if (barLen <= 0) {
            cVar.f124397a = 0;
            if (i16 <= barPointPaddingLeft) {
                return barPointPaddingLeft;
            }
        } else if (barLen >= i17) {
            cVar.f124397a = i17;
            return getBarLen() - (((getBarPointWidth() - getBarPointPaddingLeft()) - getBarPointPaddingRight()) / 2);
        }
        return i16;
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = new c();
        this.I = false;
        this.J = -1;
        this.K = -1;
        this.L = -1;
    }

    public int a(int i3, int i16) {
        if (i3 <= 0) {
            return 0;
        }
        int i17 = this.f123507i;
        return i3 >= i17 ? i16 - (((getBarPointWidth() - getBarPointPaddingLeft()) - getBarPointPaddingRight()) / 2) : (int) (((i3 * 1.0d) / i17) * i16);
    }

    public void a(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = this.f123507i;
        if (i3 >= i16) {
            i3 = i16;
        }
        if (this.f123508j != i3) {
            this.f123508j = i3;
            q();
        }
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = new c();
        this.I = false;
        this.J = -1;
        this.K = -1;
        this.L = -1;
    }

    @Override // com.tencent.luggage.wxa.mg.g.b
    public void a(boolean z16) {
        setIsPlay(z16);
    }
}
