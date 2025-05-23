package p4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.publish.utils.DownloadBoxForTitle;
import com.qzone.publish.utils.PublishBoxForTitle;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: q, reason: collision with root package name */
    public static String f425249q = "AlbumWidgetBar";

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f425250r = {R.id.hm8, R.id.hm5, R.id.hm9, R.id.f165896dt3, R.id.hm6};

    /* renamed from: a, reason: collision with root package name */
    private PublishBoxForTitle f425251a;

    /* renamed from: b, reason: collision with root package name */
    private DownloadBoxForTitle f425252b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f425253c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f425254d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f425255e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f425256f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f425257g;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f425258h;

    /* renamed from: i, reason: collision with root package name */
    private View f425259i;

    /* renamed from: j, reason: collision with root package name */
    private View f425260j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f425261k;

    /* renamed from: l, reason: collision with root package name */
    private View f425262l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f425263m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<ViewGroup> f425264n;

    /* renamed from: o, reason: collision with root package name */
    private b f425265o;

    /* renamed from: p, reason: collision with root package name */
    private int[] f425266p;

    public c(ViewGroup viewGroup) {
        if (viewGroup != null) {
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.hmb);
            if (viewStub != null) {
                this.f425253c = (ViewGroup) viewStub.inflate();
                return;
            } else {
                j.c(f425249q, "QZonePersonalAlbumWidgetTitleBar init error : viewstub widgetBarRootStubis null");
                return;
            }
        }
        j.c(f425249q, "QZonePersonalAlbumWidgetTitleBar init error : passed titleBarRootis null");
    }

    private void B() {
        ViewGroup viewGroup = this.f425253c;
        if (viewGroup == null) {
            return;
        }
        if (this.f425254d == null) {
            this.f425254d = (ViewGroup) viewGroup.findViewById(R.id.f166720hm2);
        }
        if (this.f425255e == null) {
            this.f425255e = (ViewGroup) this.f425253c.findViewById(R.id.f166721hm3);
        }
        if (this.f425256f == null) {
            this.f425256f = (ViewGroup) this.f425253c.findViewById(R.id.f166722hm4);
        }
        ArrayList<ViewGroup> arrayList = new ArrayList<>();
        this.f425264n = arrayList;
        arrayList.add(this.f425254d);
        this.f425264n.add(this.f425255e);
        this.f425264n.add(this.f425256f);
        j();
        d();
        l();
        m();
        h();
    }

    private void J(int i3) {
        b bVar = this.f425265o;
        if (bVar == null) {
            j.c(f425249q, "[showWidget] error : mWidgetMgr == null");
        } else {
            bVar.r(i3);
            K(this.f425265o.f());
        }
    }

    private void K(int[] iArr) {
        if (this.f425254d != null && this.f425255e != null && this.f425256f != null) {
            if (iArr != null && iArr.length == 2) {
                if (C(this.f425266p, iArr)) {
                    return;
                }
                L(iArr);
                D(iArr);
                this.f425266p = iArr;
                return;
            }
            j.c(f425249q, "[updateUI] error : newStatus is null or length != 2");
            return;
        }
        j.c(f425249q, "[updateUI] error : container widget is null");
    }

    private void L(int[] iArr) {
        int i3;
        int i16;
        int i17;
        int[] iArr2 = this.f425266p;
        if (iArr2 == null || iArr2.length != 2) {
            return;
        }
        if (iArr[0] != -99 && (i3 = iArr[1]) != -99 && (i16 = iArr2[0]) != -99 && (i17 = iArr2[1]) != -99) {
            if (i17 != 99 && i17 != i3) {
                View c16 = c(i17, this.f425255e);
                if (c16 != null) {
                    c16.setVisibility(8);
                } else {
                    j.c(f425249q, "[workoutDiff] error : right locatedView = null");
                }
            }
            if (i16 == 99 || i16 == iArr[0]) {
                return;
            }
            View c17 = c(i16, this.f425254d);
            if (c17 != null) {
                c17.setVisibility(8);
                return;
            } else {
                j.c(f425249q, "[workoutDiff] error : left locatedView = null");
                return;
            }
        }
        j.c(f425249q, "[workoutDiff] error : status = ERROR_STATUS");
    }

    private void u(int i3) {
        b bVar = this.f425265o;
        if (bVar == null) {
            j.c(f425249q, "[showWidget] error : mWidgetMgr == null");
        } else {
            bVar.j(i3);
            K(this.f425265o.f());
        }
    }

    private boolean y() {
        return this.f425253c != null;
    }

    public void A() {
        PublishBoxForTitle publishBoxForTitle;
        if (y() && (publishBoxForTitle = this.f425251a) != null) {
            publishBoxForTitle.g();
        }
    }

    public void E() {
        if (y() && this.f425252b != null) {
            J(R.id.hm5);
        }
    }

    public void F() {
        if (y() && h() != null) {
            J(R.id.hm6);
        }
    }

    public void G() {
        if (y() && this.f425251a != null) {
            J(R.id.hm8);
        }
    }

    public void H() {
        if (y() && l() != null) {
            J(R.id.hm9);
        }
    }

    public void I() {
        if (y() && m() != null) {
            J(R.id.f165896dt3);
        }
    }

    public void a() {
        DownloadBoxForTitle downloadBoxForTitle;
        if (y() && (downloadBoxForTitle = this.f425252b) != null) {
            downloadBoxForTitle.d();
        }
    }

    public void b() {
        PublishBoxForTitle publishBoxForTitle;
        if (y() && (publishBoxForTitle = this.f425251a) != null) {
            publishBoxForTitle.d();
        }
    }

    public ViewGroup d() {
        ViewStub viewStub;
        if (!y()) {
            return null;
        }
        if (this.f425258h == null && (viewStub = (ViewStub) this.f425253c.findViewById(R.id.hm5)) != null) {
            ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
            this.f425258h = viewGroup;
            viewGroup.setVisibility(8);
        }
        return this.f425258h;
    }

    public DownloadBoxForTitle e() {
        return this.f425252b;
    }

    public int[] f() {
        return f425250r;
    }

    public ImageView g() {
        if (!y() || h() == null) {
            return null;
        }
        if (this.f425263m == null && h() != null) {
            ImageView imageView = (ImageView) h().findViewById(R.id.hm7);
            this.f425263m = imageView;
            imageView.setContentDescription(l.a(R.string.f172548s21));
        }
        return this.f425263m;
    }

    public View h() {
        ViewStub viewStub;
        if (!y()) {
            return null;
        }
        if (this.f425262l == null && (viewStub = (ViewStub) this.f425253c.findViewById(R.id.hm6)) != null) {
            View inflate = viewStub.inflate();
            this.f425262l = inflate;
            inflate.setVisibility(8);
        }
        return this.f425262l;
    }

    public PublishBoxForTitle i() {
        return this.f425251a;
    }

    public ViewGroup j() {
        ViewStub viewStub;
        if (!y()) {
            return null;
        }
        if (this.f425257g == null && (viewStub = (ViewStub) this.f425253c.findViewById(R.id.hm8)) != null) {
            ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
            this.f425257g = viewGroup;
            viewGroup.setVisibility(8);
        }
        return this.f425257g;
    }

    public ImageView k() {
        if (!y() || l() == null) {
            return null;
        }
        if (this.f425261k == null && l() != null) {
            ImageView imageView = (ImageView) l().findViewById(R.id.hm_);
            this.f425261k = imageView;
            imageView.setContentDescription(l.a(R.string.s1u));
        }
        return this.f425261k;
    }

    public View l() {
        ViewStub viewStub;
        if (!y()) {
            return null;
        }
        if (this.f425260j == null && (viewStub = (ViewStub) this.f425253c.findViewById(R.id.hm9)) != null) {
            View inflate = viewStub.inflate();
            this.f425260j = inflate;
            inflate.setVisibility(8);
        }
        return this.f425260j;
    }

    public View m() {
        ViewStub viewStub;
        if (!y()) {
            return null;
        }
        if (this.f425259i == null && (viewStub = (ViewStub) this.f425253c.findViewById(R.id.hma)) != null) {
            View inflate = viewStub.inflate();
            this.f425259i = inflate;
            inflate.setId(R.id.f165896dt3);
            this.f425259i.setVisibility(8);
        }
        return this.f425259i;
    }

    public a n(int i3) {
        a aVar = new a();
        aVar.f425238f = 8;
        if (i3 == R.id.hm8) {
            aVar.f425236d = 3;
            aVar.f425237e = 5;
            aVar.f425233a = R.id.hm8;
        } else if (i3 == R.id.hm5) {
            aVar.f425236d = 3;
            aVar.f425237e = 4;
            aVar.f425233a = R.id.hm5;
        } else if (i3 == R.id.hm9) {
            aVar.f425236d = 1;
            aVar.f425237e = 3;
            aVar.f425233a = R.id.hm9;
        } else if (i3 == R.id.f165896dt3) {
            aVar.f425236d = 2;
            aVar.f425237e = 3;
            aVar.f425233a = R.id.f165896dt3;
        } else {
            if (i3 != R.id.hm6) {
                return null;
            }
            aVar.f425236d = 2;
            aVar.f425237e = 0;
            aVar.f425233a = R.id.hm6;
        }
        return aVar;
    }

    public ViewGroup o() {
        return this.f425256f;
    }

    public void p() {
        if (y() && this.f425252b != null) {
            u(R.id.hm5);
        }
    }

    public void q() {
        if (y() && h() != null) {
            u(R.id.hm6);
        }
    }

    public void r() {
        if (y() && this.f425251a != null) {
            u(R.id.hm8);
        }
    }

    public void s() {
        if (y() && l() != null) {
            u(R.id.hm9);
        }
    }

    public void t() {
        if (y() && m() != null) {
            u(R.id.f165896dt3);
        }
    }

    public void v(DownloadBoxForTitle.c cVar, String str) {
        this.f425252b = new DownloadBoxForTitle(cVar, str);
    }

    public void w(PublishBoxForTitle.b bVar, String str) {
        this.f425251a = new PublishBoxForTitle(bVar, str);
    }

    public void x() {
        B();
        this.f425265o = new b(this);
    }

    public void z() {
        DownloadBoxForTitle downloadBoxForTitle;
        if (y() && (downloadBoxForTitle = this.f425252b) != null) {
            downloadBoxForTitle.g();
        }
    }

    private void D(int[] iArr) {
        int i3;
        int i16 = iArr[0];
        if (i16 == -99 || (i3 = iArr[1]) == -99) {
            j.c(f425249q, "[locateTargetWidget] error : status = ERROR_STATUS");
            return;
        }
        if (i3 != 99) {
            View c16 = c(i3, this.f425255e);
            if (c16 != null) {
                c16.setVisibility(0);
            } else {
                j.c(f425249q, "[setTargetWidget] error : left locatedView = null");
            }
        }
        if (i16 != 99) {
            View c17 = c(i16, this.f425254d);
            if (c17 != null) {
                c17.setVisibility(0);
            } else {
                j.c(f425249q, "[setTargetWidget] error : right locatedView = null");
            }
        }
    }

    private View c(int i3, ViewGroup viewGroup) {
        if (viewGroup == null) {
            j.c(f425249q, "[findWidgetById] error : targetContainer is null");
            return null;
        }
        ViewGroup viewGroup2 = null;
        View view = null;
        int i16 = -1;
        for (int i17 = 0; i17 < this.f425264n.size(); i17++) {
            ViewGroup viewGroup3 = this.f425264n.get(i17);
            if (viewGroup3 != null && viewGroup3.getChildCount() != 0) {
                int i18 = 0;
                while (true) {
                    if (i18 >= viewGroup3.getChildCount()) {
                        break;
                    }
                    View childAt = viewGroup3.getChildAt(i18);
                    if (childAt.getId() == i3) {
                        viewGroup2 = viewGroup3;
                        i16 = i18;
                        view = childAt;
                        break;
                    }
                    i18++;
                }
                if (viewGroup2 != null && view != null && i16 != -1) {
                    break;
                }
            }
        }
        if (viewGroup2 == null || view == null || i16 == -1) {
            j.c(f425249q, "[findWidgetById] error : can not find the view by widget id");
            return null;
        }
        if (viewGroup2 == viewGroup) {
            return view;
        }
        viewGroup2.removeViewAt(i16);
        viewGroup.addView(view);
        return view;
    }

    private boolean C(int[] iArr, int[] iArr2) {
        return iArr != null && iArr2 != null && iArr.length == 2 && iArr.length == iArr2.length && iArr[0] == iArr2[0] && iArr[1] == iArr2[1];
    }
}
