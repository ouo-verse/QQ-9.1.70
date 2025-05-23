package lo2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends com.tencent.mobileqq.search.business.net.view.c {
    public TextView M;
    public LinearLayout N;
    public int P;
    public LinearLayout Q;
    public int R;
    public URLImageView S;
    public LinearLayout T;
    public LinearLayout U;

    public k(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        View j3 = j(this.E);
        this.M = (TextView) j3.findViewById(R.id.title);
        LinearLayout linearLayout = (LinearLayout) j3.findViewById(R.id.f165767de4);
        this.N = linearLayout;
        this.P = linearLayout.getChildCount();
        LinearLayout linearLayout2 = (LinearLayout) j3.findViewById(R.id.e7n);
        this.Q = linearLayout2;
        this.R = linearLayout2.getChildCount();
        this.S = (URLImageView) this.Q.findViewById(R.id.de6);
        this.T = (LinearLayout) this.Q.findViewById(R.id.fsg);
        this.U = (LinearLayout) this.Q.findViewById(R.id.fsh);
    }
}
