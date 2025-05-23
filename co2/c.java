package co2;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.ui.w;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends yn2.c {
    private final SparseArray<w> H;
    private ImageView I;
    private TextView J;
    private View K;
    private List<TextView> L;

    public c(ViewGroup viewGroup, int i3, SparseArray<w> sparseArray) {
        super(viewGroup, i3);
        this.H = sparseArray;
        QLog.i("gameFriInfo.GameFriendSearchResultView", 2, "[GameFriendSearchResultView]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // yn2.c, sn2.g
    public void a() {
        super.a();
        this.f434004m = (ImageView) this.f433999d.findViewById(R.id.f165909du3);
        this.f434000e = (TextView) this.f433999d.findViewById(R.id.f108016bz);
        this.f434001f = (TextView) this.f433999d.findViewById(R.id.f111006k2);
        this.f434002h = (TextView) this.f433999d.findViewById(R.id.bgt);
        this.I = (ImageView) this.f433999d.findViewById(R.id.f165936y50);
        this.J = (TextView) this.f433999d.findViewById(R.id.f108766e0);
        this.K = this.f433999d.findViewById(R.id.f222803a);
        this.L = Arrays.asList(this.f434000e, this.f434001f, this.J, this.f434002h);
        q();
    }

    public void q() {
        int color;
        if (QQTheme.isNowThemeIsNight()) {
            color = this.f434004m.getResources().getColor(R.color.bjv);
        } else {
            color = this.f434004m.getResources().getColor(R.color.bju);
        }
        Iterator<TextView> it = this.L.iterator();
        while (it.hasNext()) {
            it.next().setTextColor(color);
        }
    }

    public void r(int i3, int i16) {
        w wVar = this.H.get(i3);
        if (wVar != null) {
            this.K.setVisibility(0);
            this.K.setBackground(wVar.f213386c);
            this.I.setImageDrawable(wVar.f213387d);
            this.J.setText(wVar.a(i16));
            this.J.setTextColor(wVar.f213385b);
            return;
        }
        this.K.setVisibility(8);
    }
}
