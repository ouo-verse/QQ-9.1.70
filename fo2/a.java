package fo2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements sn2.b {

    /* renamed from: d, reason: collision with root package name */
    protected View f400165d;

    public a(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        this.f400165d = linearLayout;
        linearLayout.setVisibility(8);
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
        return null;
    }

    @Override // sn2.d
    public View getView() {
        return this.f400165d;
    }
}
