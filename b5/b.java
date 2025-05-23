package b5;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.ui.widget.SafePopupWindow;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<c> f27877a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f27878b;

    /* renamed from: c, reason: collision with root package name */
    private SafePopupWindow f27879c;

    /* renamed from: d, reason: collision with root package name */
    public ListView f27880d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f27881e;

    /* renamed from: f, reason: collision with root package name */
    private int f27882f;

    /* renamed from: g, reason: collision with root package name */
    private int f27883g = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* compiled from: P */
    /* renamed from: b5.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0099b implements PopupWindow.OnDismissListener {
        C0099b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.i(1.0f);
            b.this.h(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f27886a;

        /* renamed from: b, reason: collision with root package name */
        private String f27887b = "";

        /* renamed from: c, reason: collision with root package name */
        private boolean f27888c = true;

        /* renamed from: d, reason: collision with root package name */
        private int[] f27889d = null;

        /* renamed from: e, reason: collision with root package name */
        private View.OnClickListener[] f27890e = null;

        /* renamed from: f, reason: collision with root package name */
        private String f27891f = null;

        public c() {
        }

        public Drawable c() {
            return this.f27886a;
        }

        public String d() {
            return this.f27891f;
        }

        public String e() {
            return this.f27887b;
        }

        public boolean f() {
            return this.f27888c;
        }

        public void g(int[] iArr, View.OnClickListener[] onClickListenerArr) {
            this.f27889d = iArr;
            this.f27890e = onClickListenerArr;
        }

        public void h(Drawable drawable) {
            this.f27886a = drawable;
        }

        public void i(String str) {
            this.f27891f = str;
        }

        public void j(String str) {
            this.f27887b = str;
        }

        public void k(boolean z16) {
            boolean z17 = this.f27888c;
            if (z17 && !z16) {
                b bVar = b.this;
                bVar.f27882f--;
            } else if (!z17 && z16) {
                b.this.f27882f++;
            }
            this.f27888c = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f27893a;

        /* renamed from: b, reason: collision with root package name */
        TextView f27894b;

        /* renamed from: c, reason: collision with root package name */
        View f27895c;

        /* renamed from: d, reason: collision with root package name */
        LinearLayout f27896d;

        d() {
        }
    }

    public b(Context context) {
        if (context != null) {
            this.f27878b = context;
            this.f27877a = new ArrayList<>();
            View inflate = LayoutInflater.from(context).inflate(R.layout.bgw, (ViewGroup) null);
            ListView listView = (ListView) inflate.findViewById(R.id.eaw);
            this.f27880d = listView;
            listView.setAdapter((ListAdapter) new e());
            this.f27880d.setOnTouchListener(new a());
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fx8);
            this.f27881e = linearLayout;
            linearLayout.setVisibility(8);
            SafePopupWindow safePopupWindow = new SafePopupWindow(inflate, -1, -2);
            this.f27879c = safePopupWindow;
            safePopupWindow.setFocusable(true);
            this.f27879c.setBackgroundDrawable(new BitmapDrawable());
            this.f27879c.setOnDismissListener(new C0099b());
        }
    }

    public void d(c cVar) {
        ArrayList<c> arrayList = this.f27877a;
        if (arrayList == null || cVar == null) {
            return;
        }
        arrayList.add(cVar);
        this.f27882f++;
    }

    public void e() {
        SafePopupWindow safePopupWindow = this.f27879c;
        if (safePopupWindow != null) {
            safePopupWindow.dismiss();
        }
    }

    public int f() {
        return this.f27882f;
    }

    public void g(int i3) {
        View findViewById;
        LinearLayout linearLayout = this.f27881e;
        if (linearLayout == null || (findViewById = linearLayout.findViewById(R.id.fx9)) == null) {
            return;
        }
        ((LinearLayout.LayoutParams) findViewById.getLayoutParams()).weight = i3;
    }

    public void h(int i3) {
        LinearLayout linearLayout = this.f27881e;
        if (linearLayout != null) {
            linearLayout.setVisibility(i3);
        }
    }

    public void i(float f16) {
        WindowManager.LayoutParams attributes = ((Activity) this.f27878b).getWindow().getAttributes();
        attributes.alpha = f16;
        ((Activity) this.f27878b).getWindow().setAttributes(attributes);
    }

    public void j(int i3) {
        this.f27880d.setBackgroundColor(i3);
    }

    public void k(int i3) {
        this.f27883g = i3;
    }

    public void l(AdapterView.OnItemClickListener onItemClickListener) {
        ListView listView = this.f27880d;
        if (listView == null || onItemClickListener == null) {
            return;
        }
        listView.setOnItemClickListener(onItemClickListener);
    }

    public void m(View view) {
        if (this.f27879c == null || view == null) {
            return;
        }
        this.f27880d.setBackgroundResource(R.drawable.f162479h25);
        this.f27879c.showAsDropDown(view, 0, -this.f27878b.getResources().getDimensionPixelSize(R.dimen.f158707mw));
        this.f27879c.setFocusable(true);
        this.f27879c.setOutsideTouchable(true);
        try {
            this.f27879c.update();
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]PopupMenu", "exception e:", e16);
        }
    }

    public void n(View view, int i3, int i16, float f16) {
        SafePopupWindow safePopupWindow = this.f27879c;
        if (safePopupWindow == null || view == null) {
            return;
        }
        safePopupWindow.showAsDropDown(view, i3, i16);
        this.f27879c.setFocusable(true);
        this.f27879c.setOutsideTouchable(true);
        try {
            this.f27879c.update();
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]PopupMenu", "exception e:", e16);
        }
        i(f16);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private final class e extends BaseAdapter {
        e() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<c> arrayList = b.this.f27877a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            ArrayList<c> arrayList = b.this.f27877a;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            if (b.this.f27877a != null) {
                return r3.size();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            d dVar;
            String str;
            int[] iArr;
            View.OnClickListener[] onClickListenerArr;
            ArrayList<c> arrayList;
            Drawable drawable = null;
            if (view == null) {
                view = LayoutInflater.from(b.this.f27878b).inflate(R.layout.bgx, (ViewGroup) null);
                dVar = new d();
                dVar.f27893a = (ImageView) view.findViewById(R.id.image);
                dVar.f27894b = (TextView) view.findViewById(R.id.title);
                dVar.f27895c = view.findViewById(R.id.bmt);
                dVar.f27896d = (LinearLayout) view.findViewById(R.id.fxd);
                if (b.this.f27883g != 0) {
                    ((RelativeLayout) view.findViewById(R.id.fxc)).getLayoutParams().height = b.this.f27883g;
                }
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            ArrayList<c> arrayList2 = b.this.f27877a;
            if (arrayList2 != null) {
                drawable = arrayList2.get(i3).c();
                str = b.this.f27877a.get(i3).e();
                iArr = b.this.f27877a.get(i3).f27889d;
                onClickListenerArr = b.this.f27877a.get(i3).f27890e;
                if (!b.this.f27877a.get(i3).f()) {
                    view.findViewById(R.id.fxc).setVisibility(8);
                } else {
                    view.findViewById(R.id.fxc).setVisibility(0);
                }
            } else {
                str = "";
                iArr = null;
                onClickListenerArr = null;
            }
            ImageView imageView = dVar.f27893a;
            if (imageView != null && drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            TextView textView = dVar.f27894b;
            if (textView != null) {
                textView.setText(str);
            }
            LinearLayout linearLayout = dVar.f27896d;
            if (linearLayout != null && iArr != null && iArr.length > 0 && onClickListenerArr != null && onClickListenerArr.length > 0 && iArr.length == onClickListenerArr.length) {
                linearLayout.removeAllViews();
                for (int i16 = 0; i16 < iArr.length; i16++) {
                    ImageView imageView2 = new ImageView(b.this.f27878b);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ar.d(30.0f), ar.d(30.0f));
                    layoutParams.leftMargin = ar.d(23.0f);
                    imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView2.setImageDrawable(b.this.f27878b.getResources().getDrawable(iArr[i16]));
                    imageView2.setOnClickListener(onClickListenerArr[i16]);
                    dVar.f27896d.addView(imageView2, layoutParams);
                }
                dVar.f27896d.setVisibility(0);
                view.setClickable(false);
            } else if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            int count = getCount();
            if (1 < count && i3 < count - 1 && (arrayList = b.this.f27877a) != null && arrayList.get(i3).f()) {
                dVar.f27895c.setVisibility(0);
            } else {
                dVar.f27895c.setVisibility(4);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }
}
