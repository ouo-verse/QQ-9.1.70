package com.tencent.mobileqq.kandian.biz.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.net.URL;
import k62.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VideoCountDownView extends RelativeLayout {
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    public final int H;
    public final int I;
    public final int J;
    private boolean K;
    private a L;

    /* renamed from: d, reason: collision with root package name */
    private Context f239762d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f239763e;

    /* renamed from: f, reason: collision with root package name */
    private Button f239764f;

    /* renamed from: h, reason: collision with root package name */
    private Button f239765h;

    /* renamed from: i, reason: collision with root package name */
    private KandianUrlImageView f239766i;

    /* renamed from: m, reason: collision with root package name */
    private View f239767m;

    public VideoCountDownView(Context context) {
        this(context, null);
    }

    public void a(int i3) {
        this.f239763e.setText(getResources().getString(R.string.gyp, Integer.valueOf(i3), this.L.f411769a));
    }

    public void b() {
        this.f239763e.setVisibility(8);
    }

    public void c() {
        this.f239766i.setVisibility(8);
    }

    public void e(URL url) {
        try {
            this.f239766i.setVisibility(0);
            this.f239766i.setImage(url);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void f() {
        this.f239765h.setVisibility(8);
        this.f239763e.setVisibility(8);
    }

    public void setIsXgMode(boolean z16) {
        this.K = z16;
    }

    public void setNextVideoInfo(a aVar) {
        this.L = aVar;
        if (aVar == null) {
            return;
        }
        this.f239765h.setVisibility(0);
        this.f239763e.setVisibility(0);
        if (this.K) {
            this.f239763e.setText(getResources().getString(R.string.gyq, this.L.f411769a));
        } else {
            this.f239765h.setText(getResources().getString(R.string.gyr));
        }
    }

    public void setOnCustomClickListener(View.OnClickListener onClickListener) {
        this.f239764f.setOnClickListener(onClickListener);
        this.f239767m.setOnClickListener(onClickListener);
        this.C.setOnClickListener(onClickListener);
        this.D.setOnClickListener(onClickListener);
        this.E.setOnClickListener(onClickListener);
        this.F.setOnClickListener(onClickListener);
        this.G.setOnClickListener(onClickListener);
        this.f239765h.setOnClickListener(onClickListener);
        this.f239763e.setOnClickListener(onClickListener);
    }

    public VideoCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoCountDownView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239762d = context;
        this.H = getResources().getDimensionPixelOffset(R.dimen.f158714n4);
        this.I = getResources().getDimensionPixelOffset(R.dimen.f158703ms);
        this.J = getResources().getDimensionPixelOffset(R.dimen.f158705mu);
        d();
    }

    private void d() {
    }

    public void setTitle(String str) {
    }
}
