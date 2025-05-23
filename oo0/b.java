package oo0;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import no0.k;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private final k f423247c;

    public b(Context context, @NonNull k kVar) {
        super(context);
        this.f423247c = kVar;
    }

    @Override // oo0.a
    protected int b() {
        return R.layout.eg8;
    }

    @Override // oo0.a
    public int d() {
        ViewGroup viewGroup = this.f423246b;
        if (viewGroup != null) {
            int height = viewGroup.getHeight();
            if (height <= 0) {
                return this.f423247c.f420571a.f420599n;
            }
            return height;
        }
        return 0;
    }

    @Override // oo0.a
    protected void h(@NonNull ViewGroup viewGroup) {
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f423247c.f420571a.f420599n));
        viewGroup.setBackgroundResource(this.f423247c.f420573c.f420606a);
        ((TextView) viewGroup.findViewById(R.id.l__)).setTextColor(this.f423247c.f420572b.f420574a);
    }
}
