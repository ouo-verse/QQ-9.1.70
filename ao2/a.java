package ao2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;
import sn2.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends g {
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;

    public a(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sn2.g
    public void a() {
        super.a();
        this.F = (TextView) this.f433999d.findViewById(R.id.f166851io2);
        this.G = (TextView) this.f433999d.findViewById(R.id.f166850io1);
        this.H = (TextView) this.f433999d.findViewById(R.id.f166849io0);
        this.I = (TextView) this.f433999d.findViewById(R.id.il9);
        if (aq.a()) {
            this.f433999d.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }

    public TextView o() {
        return this.I;
    }

    public TextView p() {
        return this.H;
    }

    public TextView q() {
        return this.G;
    }

    public TextView r() {
        return this.F;
    }

    public a(View view) {
        super(view);
    }
}
