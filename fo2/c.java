package fo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IPublicAcountFetcher;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements sn2.b {

    /* renamed from: d, reason: collision with root package name */
    private View f400168d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f400169e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f400170f;

    public c(ViewGroup viewGroup, int i3, int i16, int i17) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        this.f400168d = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        if (imageView != null && i16 > 0) {
            imageView.setImageResource(i16);
        }
        this.f400169e = (TextView) this.f400168d.findViewById(R.id.e0z);
        TextView textView = (TextView) this.f400168d.findViewById(R.id.bgt);
        this.f400170f = textView;
        if (i17 == 12) {
            textView.setText(HardCodeUtil.qqStr(R.string.t7h) + ((IPublicAcountFetcher) QRoute.api(IPublicAcountFetcher.class)).getSubscriptName() + HardCodeUtil.qqStr(R.string.t7g));
        }
    }

    @Override // sn2.b
    public TextView b() {
        return null;
    }

    @Override // sn2.b
    public List<sn2.c> e() {
        return null;
    }

    @Override // sn2.b
    public TextView getMoreView() {
        return this.f400169e;
    }

    @Override // sn2.d
    public View getView() {
        return this.f400168d;
    }
}
