package go2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends sn2.g {
    protected TextView F;
    protected ImageView G;
    protected ImageView H;
    protected ImageView I;
    protected ImageView J;
    protected ImageView K;
    protected TextView L;
    protected QUIButton M;

    public e(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sn2.g
    public void a() {
        super.a();
        this.F = (TextView) this.f433999d.findViewById(R.id.f98795o2);
        this.G = (ImageView) this.f433999d.findViewById(R.id.x1d);
        this.H = (ImageView) this.f433999d.findViewById(R.id.x1c);
        this.I = (ImageView) this.f433999d.findViewById(R.id.w1j);
        this.J = (ImageView) this.f433999d.findViewById(R.id.w1h);
        this.K = (ImageView) this.f433999d.findViewById(R.id.w1i);
        this.L = (TextView) this.f433999d.findViewById(R.id.f166931j64);
        this.M = (QUIButton) this.f433999d.findViewById(R.id.dzc);
        if (aq.a()) {
            TextView u16 = u();
            n(u16, R.color.qui_common_text_secondary);
            n(b(), R.color.qui_common_text_primary);
            n(this.f434002h, R.color.qui_common_text_secondary);
            if (u16 != null) {
                Drawable background = u16.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setColor(u16.getResources().getColorStateList(R.color.qui_common_bg_bottom_standard));
                }
            }
            View findViewById = this.f433999d.findViewById(R.id.dpr);
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            }
        }
    }

    @Override // sn2.g, sn2.c
    public TextView c() {
        return this.L;
    }

    public ImageView o() {
        return this.J;
    }

    public ImageView p() {
        return this.K;
    }

    public ImageView q() {
        return this.I;
    }

    public ImageView r() {
        return this.G;
    }

    public ImageView s() {
        return this.H;
    }

    public QUIButton t() {
        return this.M;
    }

    public TextView u() {
        return this.F;
    }
}
