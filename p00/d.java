package p00;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d extends Dialog implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private KandianUrlImageView f424858d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f424859e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f424860f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f424861h;

    /* renamed from: i, reason: collision with root package name */
    private q00.b f424862i;

    /* renamed from: m, reason: collision with root package name */
    private a f424863m;

    private Drawable d() {
        return getContext().getResources().getDrawable(R.drawable.n87);
    }

    private void j() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
    }

    private void k() {
        a aVar = this.f424863m;
        if (aVar != null) {
            aVar.b();
        }
        dismiss();
    }

    private void l() {
        a aVar = this.f424863m;
        if (aVar != null) {
            aVar.a(g(this.f424862i));
        }
        dismiss();
    }

    public void a(q00.b bVar) {
        this.f424862i = bVar;
        WSPicLoader.g().w(this.f424858d, f(bVar), d());
        this.f424859e.setText(h(bVar));
        this.f424860f.setText(e(bVar));
        this.f424861h.setText(b(bVar));
    }

    public void m(a aVar) {
        this.f424863m = aVar;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.p4j) {
            k();
        } else {
            if (id5 != R.id.p7v) {
                return;
            }
            l();
        }
    }

    private String b(q00.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.a())) {
            return bVar.a();
        }
        return getContext().getString(R.string.x9m);
    }

    private String e(q00.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.c())) {
            return bVar.c();
        }
        return getContext().getString(R.string.f169729x94);
    }

    private String f(q00.b bVar) {
        if (bVar != null && bVar.d() != null) {
            return bVar.d();
        }
        return "";
    }

    private String g(q00.b bVar) {
        if (bVar != null && bVar.f() != null) {
            return bVar.f();
        }
        return "";
    }

    private String h(q00.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.g())) {
            return bVar.g();
        }
        return getContext().getString(R.string.x8j);
    }

    public d(Context context) {
        super(context, R.style.f173280zp);
        i();
        j();
        setCanceledOnTouchOutside(false);
    }

    private void i() {
        setContentView(R.layout.d0i);
        this.f424858d = (KandianUrlImageView) findViewById(R.id.p4k);
        this.f424859e = (TextView) findViewById(R.id.p7x);
        this.f424860f = (TextView) findViewById(R.id.p7w);
        TextView textView = (TextView) findViewById(R.id.p7v);
        this.f424861h = textView;
        textView.setOnClickListener(this);
        findViewById(R.id.p4j).setOnClickListener(this);
    }
}
