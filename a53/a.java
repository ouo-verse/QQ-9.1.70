package a53;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c53.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends BaseAdapter {

    /* renamed from: m, reason: collision with root package name */
    private static int f25533m;

    /* renamed from: d, reason: collision with root package name */
    private int f25534d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25535e = false;

    /* renamed from: f, reason: collision with root package name */
    private c53.a f25536f;

    /* renamed from: h, reason: collision with root package name */
    private List<d53.b> f25537h;

    /* renamed from: i, reason: collision with root package name */
    private final Context f25538i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: a53.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class ViewOnTouchListenerC0012a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f25539d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f25540e;

        ViewOnTouchListenerC0012a(int i3, View view) {
            this.f25539d = i3;
            this.f25540e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 || action == 3) {
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        view.setPressed(false);
                    }
                } else {
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    view.setPressed(false);
                    a aVar = a.this;
                    c53.a s16 = new c53.a(aVar.f25538i).s(a.this.f25537h);
                    a.f(a.this);
                    c53.a t16 = s16.t(null);
                    a.g(a.this);
                    c53.a u16 = t16.u(null);
                    a.b(a.this);
                    aVar.f25536f = u16.r(null).p(view, this.f25539d, a.this.f25534d);
                    a.f(a.this);
                }
            } else {
                view.setScaleX(0.95f);
                view.setScaleY(0.95f);
                view.setPressed(true);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public View f25542a;

        /* renamed from: b, reason: collision with root package name */
        public View f25543b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f25544c;

        /* renamed from: d, reason: collision with root package name */
        public int f25545d;

        public b(View view, int i3) {
            this.f25542a = view;
            this.f25543b = view.findViewById(R.id.f65873_4);
            this.f25544c = (ImageView) view.findViewById(R.id.f65893_6);
            if (a.this.f25535e) {
                this.f25543b.setAlpha(0.5f);
            }
            this.f25545d = i3;
        }

        public void a(d53.b bVar, int i3) {
            if (bVar == null) {
                return;
            }
            this.f25545d = i3;
            a.i(this.f25544c, bVar.f393037a, false);
            a.f(a.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
    }

    public a(Context context) {
        this.f25538i = context;
    }

    static /* bridge */ /* synthetic */ a.e b(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ b53.a f(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ c g(a aVar) {
        aVar.getClass();
        return null;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public static void i(ImageView imageView, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(f25533m);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.getScreenWidth();
        obtain.mRequestHeight = ViewUtils.getScreenHeight();
        Drawable drawable = imageView.getResources().getDrawable(R.drawable.qui_cardlist_icon_default);
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mUseApngImage = true;
        obtain.mRetryCount = 3;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        if (drawable2.getStatus() == 2) {
            drawable2.restartDownload();
        }
        imageView.setImageDrawable(drawable2);
    }

    private void j(RelativeLayout relativeLayout, int i3) {
        int i16;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        Resources resources = this.f25538i.getResources();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.d_p), resources.getDimensionPixelSize(R.dimen.d_n));
        } else {
            layoutParams.width = resources.getDimensionPixelSize(R.dimen.d_p);
            if (i3 == 0) {
                layoutParams.width = resources.getDimensionPixelSize(R.dimen.d_r);
            }
            layoutParams.height = resources.getDimensionPixelSize(R.dimen.d_n);
        }
        relativeLayout.setLayoutParams(layoutParams);
        if (i3 == 0) {
            i16 = resources.getDimensionPixelSize(R.dimen.d_j);
        } else {
            i16 = 0;
        }
        relativeLayout.setPadding(i16, 0, resources.getDimensionPixelSize(R.dimen.d_o), 0);
    }

    private void k(View view, int i3) {
        view.findViewById(R.id.f65903_7).setOnTouchListener(new ViewOnTouchListenerC0012a(i3, view));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d53.b> list = this.f25537h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<d53.b> list = this.f25537h;
        if (list != null && i3 < list.size()) {
            return this.f25537h.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        Context context = this.f25538i;
        View view3 = null;
        if (context == null) {
            view2 = view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.f168947hg0, (ViewGroup) null);
                bVar = new b(view, i3);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            k(view, i3);
            j((RelativeLayout) view, i3);
            bVar.a((d53.b) getItem(i3), i3);
            view3 = view;
            view2 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }

    public void l(int i3) {
        this.f25534d = i3;
    }

    public void n(int i3) {
        f25533m = i3;
    }

    public void setData(List<d53.b> list) {
        this.f25537h = list;
        notifyDataSetChanged();
    }

    public void m(a.e eVar) {
    }

    public void o(b53.a aVar) {
    }

    public void p(c cVar) {
    }
}
