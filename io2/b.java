package io2;

import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;
import sn2.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends g {
    protected TextView F;
    protected URLImageView G;
    protected URLImageView H;

    public b(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sn2.g
    public void a() {
        super.a();
        this.F = (TextView) this.f433999d.findViewById(R.id.iww);
        this.H = (URLImageView) this.f433999d.findViewById(R.id.yk_);
        this.G = (URLImageView) this.f433999d.findViewById(R.id.jpr);
        if (aq.a()) {
            n(p(), R.color.qui_common_text_primary);
            n(b(), R.color.qui_common_text_primary);
            n(k(), R.color.qui_common_text_secondary);
            View findViewById = this.f433999d.findViewById(R.id.dpr);
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            }
        }
    }

    @Override // sn2.g, sn2.c
    public TextView k() {
        return super.k();
    }

    public URLImageView o() {
        return this.H;
    }

    public TextView p() {
        return this.F;
    }

    public URLImageView q() {
        return this.G;
    }
}
