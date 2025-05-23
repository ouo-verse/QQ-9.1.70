package jo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import sn2.b;
import sn2.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements b {

    /* renamed from: d, reason: collision with root package name */
    protected View f410742d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f410743e;

    /* renamed from: f, reason: collision with root package name */
    private List<c> f410744f = new ArrayList();

    public a(ViewGroup viewGroup, int i3) {
        this.f410742d = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        this.f410743e = (LinearLayout) this.f410742d.findViewById(R.id.ecl);
    }

    public LinearLayout a() {
        return this.f410743e;
    }

    @Override // sn2.b
    public TextView b() {
        return b();
    }

    @Override // sn2.b
    public List<c> e() {
        return this.f410744f;
    }

    @Override // sn2.b
    public TextView getMoreView() {
        return null;
    }

    @Override // sn2.d
    public View getView() {
        return this.f410742d;
    }
}
