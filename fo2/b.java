package fo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import sn2.f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends f {
    public View C;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f400166i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f400167m;

    public b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168016p2, viewGroup, false);
        this.f433995d = inflate;
        this.f400166i = (LinearLayout) inflate.findViewById(R.id.ciw);
        this.f400167m = (TextView) this.f433995d.findViewById(R.id.ciy);
        this.C = this.f433995d.findViewById(R.id.bnd);
    }
}
