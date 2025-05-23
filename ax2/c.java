package ax2;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout.RoundRelativeLayout;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f27196a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f27197b;

    public c(boolean z16) {
        this.f27196a = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a() {
        if (this.f27197b) {
            if (this.f27196a) {
                return s.b();
            }
            return s.c();
        }
        if (this.f27196a) {
            return s.c();
        }
        return s.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout.LayoutParams b(View view) {
        return (RelativeLayout.LayoutParams) view.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        if (this.f27197b) {
            if (this.f27196a) {
                return s.c();
            }
            return s.b();
        }
        if (this.f27196a) {
            return s.b();
        }
        return s.c();
    }

    public void d(boolean z16) {
        this.f27197b = z16;
    }

    public abstract void e(View view);

    public abstract void f(View view);

    public abstract void g(RoundRelativeLayout roundRelativeLayout);
}
