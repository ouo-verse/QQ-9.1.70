package oo0;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.qqui.QQViewPager;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends oo0.a {

    /* renamed from: h, reason: collision with root package name */
    private static final int f423248h = ViewUtils.getScreenHeight();

    /* renamed from: c, reason: collision with root package name */
    private final e f423249c;

    /* renamed from: d, reason: collision with root package name */
    private AbstractC10933c f423250d;

    /* renamed from: e, reason: collision with root package name */
    private f f423251e;

    /* renamed from: f, reason: collision with root package name */
    private int f423252f;

    /* renamed from: g, reason: collision with root package name */
    private final DataSetObserver f423253g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends ViewPager.SimpleOnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (c.this.f423249c != null) {
                c.this.f423249c.onPageSelected(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            String charSequence;
            super.onChanged();
            int count = c.this.f423250d.getCount();
            String[] strArr = new String[count];
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence pageTitle = c.this.f423250d.getPageTitle(i3);
                if (pageTitle == null) {
                    charSequence = "";
                } else {
                    charSequence = pageTitle.toString();
                }
                strArr[i3] = charSequence;
            }
            c.this.f423251e.f423258b.setVisibility(c.this.f423252f);
            c.this.f423251e.f423257a.setOffscreenPageLimit(c.this.f423250d.getCount());
            c.this.f423250d.e(c.this.f423251e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface d {
        void onPageSelected(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class e implements d {

        /* renamed from: d, reason: collision with root package name */
        List<d> f423256d;

        e() {
        }

        public void a(d dVar) {
            if (dVar == null) {
                return;
            }
            if (this.f423256d == null) {
                this.f423256d = new ArrayList();
            }
            this.f423256d.add(dVar);
        }

        @Override // oo0.c.d
        public void onPageSelected(int i3) {
            List<d> list = this.f423256d;
            if (list != null && !list.isEmpty()) {
                Iterator it = new ArrayList(this.f423256d).iterator();
                while (it.hasNext()) {
                    ((d) it.next()).onPageSelected(i3);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public QQViewPager f423257a;

        /* renamed from: b, reason: collision with root package name */
        public View f423258b;

        f(View view) {
            this.f423257a = (QQViewPager) view.findViewById(R.id.x4p);
            this.f423258b = view.findViewById(R.id.x1p);
        }
    }

    public c(Context context) {
        super(context);
        this.f423252f = 0;
        this.f423253g = new b();
        this.f423249c = new e();
    }

    private void o(AbstractC10933c abstractC10933c) {
        this.f423251e.f423257a.addOnPageChangeListener(new a());
        this.f423251e.f423257a.setAdapter(abstractC10933c);
        abstractC10933c.registerDataSetObserver(this.f423253g);
    }

    private ViewGroup.LayoutParams p() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // oo0.a
    protected int b() {
        return R.layout.f_c;
    }

    @Override // oo0.a
    public int d() {
        return f423248h;
    }

    @Override // oo0.a
    public void g() {
        super.g();
        AbstractC10933c abstractC10933c = this.f423250d;
        if (abstractC10933c != null) {
            abstractC10933c.d();
        }
    }

    @Override // oo0.a
    protected void h(@NonNull ViewGroup viewGroup) {
        this.f423251e = new f(viewGroup);
        if (this.f423250d == null) {
            return;
        }
        viewGroup.setLayoutParams(p());
        o(this.f423250d);
    }

    @Override // oo0.a
    public void i() {
        super.i();
        AbstractC10933c abstractC10933c = this.f423250d;
        if (abstractC10933c != null) {
            abstractC10933c.unregisterDataSetObserver(this.f423253g);
            this.f423250d.onDestroy();
        }
    }

    public void n(d dVar) {
        this.f423249c.a(dVar);
    }

    public int q() {
        if (s() != null) {
            return s().getCurrentItem();
        }
        return -1;
    }

    public int r() {
        return this.f423252f;
    }

    public QQViewPager s() {
        f fVar = this.f423251e;
        if (fVar != null) {
            return fVar.f423257a;
        }
        return null;
    }

    public void t(AbstractC10933c abstractC10933c) {
        if (this.f423250d != null) {
            o(abstractC10933c);
        }
        this.f423250d = abstractC10933c;
    }

    public void u(int i3) {
        View view;
        f fVar = this.f423251e;
        if (fVar != null && (view = fVar.f423258b) != null) {
            view.setVisibility(i3);
        }
        this.f423252f = i3;
    }

    /* compiled from: P */
    /* renamed from: oo0.c$c, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC10933c extends PagerAdapter {
        public abstract void e(f fVar);

        @Override // androidx.viewpager.widget.PagerAdapter
        public abstract int getCount();

        public void d() {
        }

        public void onDestroy() {
        }
    }
}
