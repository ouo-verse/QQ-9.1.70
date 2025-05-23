package nz;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends lz.c<f> {

    /* renamed from: f, reason: collision with root package name */
    private TextView f421607f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.e();
        }
    }

    private void i() {
        this.f421607f = (TextView) this.itemView.findViewById(R.id.uwf);
        this.itemView.setOnClickListener(new a());
    }

    @Override // lz.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void bindData(f fVar) {
        super.bindData(fVar);
        this.f421607f.setText(getContext().getString(R.string.f169720x80, Integer.valueOf(fVar.b())));
        b(fVar.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lz.c
    public void b(boolean z16) {
        if (z16) {
            this.f421607f.setBackgroundResource(R.drawable.k7t);
            this.f421607f.setTextColor(-16777216);
        } else {
            this.f421607f.setBackgroundResource(R.drawable.k7s);
            this.f421607f.setTextColor(-1);
        }
    }

    public e(ViewGroup viewGroup, lz.b<f> bVar) {
        super(viewGroup, R.layout.fvu, bVar);
        i();
    }
}
