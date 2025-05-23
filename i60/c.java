package i60;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final View f407293a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f407294b;

    public c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gsj, viewGroup, false);
        this.f407293a = inflate;
        this.f407294b = (TextView) inflate.findViewById(android.R.id.text1);
    }

    public View a() {
        return this.f407293a;
    }

    public View b() {
        return this.f407294b;
    }

    public void c(boolean z16) {
        this.f407294b.setTypeface(null, z16 ? 1 : 0);
    }
}
