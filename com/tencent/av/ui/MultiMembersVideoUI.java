package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.ui.n;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;
import mqq.app.BaseFragmentActivity;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MultiMembersVideoUI extends RelativeLayout implements n {
    HorizontalScrollView C;
    View D;
    VideoAppInterface E;
    LayoutInflater F;
    ArrayList<n.b> G;
    com.tencent.av.utils.y H;
    int I;
    boolean J;
    AdapterView.OnItemClickListener K;
    View.OnTouchListener L;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<Context> f74914d;

    /* renamed from: e, reason: collision with root package name */
    long f74915e;

    /* renamed from: f, reason: collision with root package name */
    int f74916f;

    /* renamed from: h, reason: collision with root package name */
    boolean f74917h;

    /* renamed from: i, reason: collision with root package name */
    GridView f74918i;

    /* renamed from: m, reason: collision with root package name */
    c f74919m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            MultiMembersVideoUI multiMembersVideoUI;
            int i16;
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            if (MultiMembersVideoUI.this.H != null) {
                n.a aVar = (n.a) view.getTag();
                if (aVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("MultiMembersVideoUI", 2, "onItemClick-->holder is null");
                    }
                } else if (MultiMembersVideoUI.this.G.size() > 8 && ((i16 = (multiMembersVideoUI = MultiMembersVideoUI.this).f74916f) == 1 || i16 == 2)) {
                    multiMembersVideoUI.H.b(aVar.f76094a, aVar.f76095b, i3, true);
                } else {
                    MultiMembersVideoUI.this.H.b(aVar.f76094a, aVar.f76095b, i3, false);
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.tencent.av.utils.y yVar = MultiMembersVideoUI.this.H;
            if (yVar != null) {
                yVar.a();
            }
            if (motionEvent.getAction() == 2) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends BaseAdapter {
        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
        }

        n.a a(View view) {
            n.a aVar = new n.a();
            aVar.f76099f = (ViewGroup) view.findViewById(R.id.g8n);
            aVar.f76100g = (ImageView) view.findViewById(R.id.g8k);
            aVar.f76101h = (TextView) view.findViewById(R.id.f166570g90);
            aVar.f76096c = (ImageView) view.findViewById(R.id.f166572g92);
            aVar.f76102i = (TextView) view.findViewById(R.id.g8m);
            aVar.f76106m = (ImageView) view.findViewById(R.id.g8z);
            aVar.f76109p = (ImageView) view.findViewById(R.id.g8l);
            MultiMembersVideoUI multiMembersVideoUI = MultiMembersVideoUI.this;
            if (multiMembersVideoUI.J && aVar.f76101h != null && aVar.f76100g != null) {
                float f16 = MultiMembersVideoUI.super.getResources().getDisplayMetrics().density;
                aVar.f76101h.setTextSize(12.0f);
                int i3 = (int) (f16 * 1.5d);
                aVar.f76100g.setPadding(i3, i3, i3, i3);
            }
            TextView textView = aVar.f76101h;
            if (textView != null) {
                MultiMembersVideoUI multiMembersVideoUI2 = MultiMembersVideoUI.this;
                if (multiMembersVideoUI2.f74917h) {
                    textView.setTextColor(multiMembersVideoUI2.getResources().getColor(R.color.f157526s4));
                } else {
                    textView.setTextColor(multiMembersVideoUI2.getResources().getColor(R.color.f157526s4));
                }
            }
            ViewGroup viewGroup = aVar.f76099f;
            if (viewGroup != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                MultiMembersVideoUI multiMembersVideoUI3 = MultiMembersVideoUI.this;
                if (multiMembersVideoUI3.f74917h) {
                    layoutParams.width = multiMembersVideoUI3.getResources().getDimensionPixelSize(R.dimen.f159358a74);
                    layoutParams.height = MultiMembersVideoUI.this.getResources().getDimensionPixelSize(R.dimen.f159357a73);
                } else {
                    layoutParams.width = multiMembersVideoUI3.getResources().getDimensionPixelSize(R.dimen.a7_);
                    layoutParams.height = MultiMembersVideoUI.this.getResources().getDimensionPixelSize(R.dimen.a78);
                }
                aVar.f76099f.setLayoutParams(layoutParams);
            }
            return aVar;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            MultiMembersVideoUI multiMembersVideoUI = MultiMembersVideoUI.this;
            int i3 = multiMembersVideoUI.f74916f;
            if ((i3 == 1 || i3 == 2) && multiMembersVideoUI.G.size() > 8) {
                return 8;
            }
            return MultiMembersVideoUI.this.G.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return MultiMembersVideoUI.this.G.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            n.a aVar;
            String str;
            Drawable drawable;
            View view2 = view;
            if (i3 != 0 || view2 == null || viewGroup.getChildCount() == i3) {
                if (view2 == null) {
                    view2 = MultiMembersVideoUI.this.F.inflate(R.layout.f168508yj, (ViewGroup) null);
                    aVar = a(view2);
                    view2.setTag(aVar);
                } else {
                    aVar = (n.a) view.getTag();
                    if (aVar == null) {
                        aVar = a(view2);
                    }
                }
                n.b bVar = MultiMembersVideoUI.this.G.get(i3);
                if (bVar.f76117g == null || bVar.f76119i == null || !bVar.f76116f) {
                    if (bVar.f76120j == 0) {
                        String valueOf = String.valueOf(bVar.f76111a);
                        String U = com.tencent.av.r.h0().U(valueOf, String.valueOf(MultiMembersVideoUI.this.f74915e), MultiMembersVideoUI.this.f74916f);
                        bVar.f76117g = U;
                        if (U.compareTo(valueOf) != 0) {
                            bVar.f76116f = true;
                        } else {
                            bVar.f76116f = false;
                        }
                        Bitmap S = com.tencent.av.r.h0().S(valueOf, String.valueOf(MultiMembersVideoUI.this.f74915e), MultiMembersVideoUI.this.f74916f, false, true);
                        if (S != null) {
                            bVar.f76119i = S;
                        } else {
                            bVar.f76119i = null;
                            bVar.f76116f = false;
                        }
                    } else {
                        long j3 = bVar.f76111a;
                        AVPhoneUserInfo aVPhoneUserInfo = bVar.f76122l;
                        if (aVPhoneUserInfo == null) {
                            aVPhoneUserInfo = com.tencent.av.r.h0().C(j3, com.tencent.av.n.e().f().f73061o1);
                        }
                        if (aVPhoneUserInfo != null && (str = aVPhoneUserInfo.telInfo.mobile) != null) {
                            bVar.f76117g = str;
                            String P = VideoAppInterface.N().P(aVPhoneUserInfo.telInfo.mobile);
                            if (P != null) {
                                bVar.f76118h = com.tencent.mobileqq.utils.ac.L(P);
                                bVar.f76117g = P;
                            } else {
                                bVar.f76118h = null;
                                bVar.f76117g = com.tencent.av.utils.ae.g(aVPhoneUserInfo.telInfo.mobile, 4);
                            }
                        } else {
                            if (aVPhoneUserInfo != null && QLog.isColorLevel()) {
                                QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + aVPhoneUserInfo.toString());
                            }
                            bVar.f76118h = null;
                            bVar.f76117g = MultiMembersVideoUI.super.getResources().getString(R.string.box);
                        }
                        bVar.f76119i = ((BitmapDrawable) MultiMembersVideoUI.super.getResources().getDrawable(R.drawable.dbo)).getBitmap();
                        bVar.f76116f = true;
                    }
                }
                MultiMembersVideoUI multiMembersVideoUI = MultiMembersVideoUI.this;
                int i16 = multiMembersVideoUI.f74916f;
                if ((i16 == 1 || i16 == 2) && i3 == 7 && multiMembersVideoUI.G.size() > 8) {
                    aVar.f76105l = false;
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(1);
                    gradientDrawable.setColor(Color.parseColor("#4C000000"));
                    aVar.f76100g.setImageDrawable(gradientDrawable);
                    aVar.f76102i = (TextView) view2.findViewById(R.id.g8m);
                    aVar.f76102i.setText("" + ((MultiMembersVideoUI.this.G.size() - 8) + 1) + Marker.ANY_NON_NULL_MARKER);
                    aVar.f76102i.setTextColor(-1);
                    aVar.f76102i.setVisibility(0);
                    aVar.f76101h.setText("");
                    view2.setContentDescription(MultiMembersVideoUI.super.getResources().getString(R.string.bow));
                } else {
                    aVar.f76105l = true;
                    long j16 = bVar.f76111a;
                    aVar.f76094a = j16;
                    String str2 = bVar.f76117g;
                    if (str2 != null) {
                        aVar.f76101h.setText(str2);
                    } else {
                        aVar.f76101h.setText(String.valueOf(j16));
                    }
                    if (bVar.f76119i != null) {
                        if (bVar.f76120j != 0 && bVar.f76118h != null) {
                            aVar.f76102i.setVisibility(0);
                            aVar.f76102i.setText(bVar.f76118h);
                            aVar.f76100g.setImageBitmap(((BitmapDrawable) MultiMembersVideoUI.super.getResources().getDrawable(R.drawable.day)).getBitmap());
                        } else {
                            aVar.f76102i.setVisibility(8);
                            aVar.f76100g.setImageBitmap(bVar.f76119i);
                        }
                    } else {
                        aVar.f76102i.setVisibility(8);
                        aVar.f76100g.setImageResource(R.drawable.f160830com);
                    }
                    if ((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || com.tencent.av.n.e().f().S0 == 2) {
                        if (bVar.f76123m) {
                            if (aVar.f76106m.getVisibility() != 0) {
                                aVar.f76106m.setVisibility(0);
                            }
                            if (aVar.f76096c.getVisibility() == 0) {
                                aVar.f76096c.setVisibility(8);
                            }
                            bVar.f76112b = false;
                        } else if (aVar.f76106m.getVisibility() == 0) {
                            aVar.f76106m.setVisibility(8);
                        }
                    }
                    boolean z16 = bVar.f76112b;
                    aVar.f76104k = z16;
                    if (z16) {
                        aVar.f76096c.setVisibility(0);
                    } else {
                        aVar.f76096c.setVisibility(8);
                    }
                    int i17 = bVar.f76114d;
                    if (i17 == 2) {
                        aVar.f76095b = 5;
                    } else if (bVar.f76115e) {
                        aVar.f76095b = 3;
                    } else if (i17 == 1) {
                        aVar.f76095b = 2;
                    } else if (bVar.f76113c) {
                        aVar.f76095b = 1;
                    } else {
                        aVar.f76095b = 0;
                    }
                    if (aVar.f76100g != null && (((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || MultiMembersVideoUI.this.f74916f == 2) && !bVar.f76125o && (drawable = aVar.f76100g.getDrawable()) != null && (drawable instanceof BitmapDrawable))) {
                        aVar.f76100g.setImageBitmap(BaseImageUtil.drawBitmapCoverLayer(((BitmapDrawable) drawable).getBitmap(), true));
                    }
                }
            }
            View view3 = view2;
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view3;
        }
    }

    @TargetApi(9)
    public MultiMembersVideoUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Activity activity;
        this.f74914d = null;
        this.f74915e = 0L;
        this.f74916f = 0;
        this.f74917h = false;
        this.f74918i = null;
        this.f74919m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = new ArrayList<>();
        this.H = null;
        this.I = 0;
        this.J = false;
        this.K = new a();
        this.L = new b();
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f74914d = weakReference;
        if (weakReference.get() instanceof BaseActivity) {
            activity = (BaseActivity) this.f74914d.get();
            this.E = (VideoAppInterface) ((BaseActivity) this.f74914d.get()).getAppRuntime();
        } else if (this.f74914d.get() instanceof BaseFragmentActivity) {
            activity = (BaseFragmentActivity) this.f74914d.get();
            this.E = (VideoAppInterface) ((BaseFragmentActivity) this.f74914d.get()).getAppRuntime();
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
                return;
            }
            return;
        }
        if (this.E == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
            }
            activity.finish();
            return;
        }
        if (com.tencent.av.r.h0() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
            }
            activity.finish();
            return;
        }
        LayoutInflater from = LayoutInflater.from(this.f74914d.get());
        this.F = from;
        View inflate = from.inflate(R.layout.f168509yk, (ViewGroup) null);
        this.D = inflate;
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f74918i = (GridView) this.D.findViewById(R.id.f49);
        this.C = (HorizontalScrollView) this.D.findViewById(R.id.f47);
        this.f74918i.setNumColumns(-1);
        this.f74918i.setGravity(17);
        this.f74918i.setSelector(new ColorDrawable(0));
        this.C.setOverScrollMode(2);
        this.f74918i.setOverScrollMode(2);
        c cVar = new c();
        this.f74919m = cVar;
        this.f74918i.setAdapter((ListAdapter) cVar);
        this.f74918i.setOnItemClickListener(this.K);
        this.f74918i.setOnTouchListener(this.L);
        super.addView(this.D);
    }

    void f() {
        int i3;
        Activity activity = (Activity) this.f74914d.get();
        if (activity == null) {
            return;
        }
        int size = this.G.size();
        int screenWidth = ba.getScreenWidth(activity.getApplicationContext());
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.a5u);
        this.I = dimensionPixelSize;
        this.f74918i.setColumnWidth(dimensionPixelSize);
        int i16 = 0;
        if (this.f74917h) {
            if (size <= 4) {
                i3 = (screenWidth - (this.I * size)) / 2;
            } else {
                int i17 = (int) (screenWidth / 4.5d);
                this.I = i17;
                this.f74918i.setColumnWidth(i17);
                i3 = 0;
            }
        } else if (size <= 6) {
            int dimensionPixelSize2 = activity.getResources().getDimensionPixelSize(R.dimen.a5w);
            int i18 = (screenWidth - (dimensionPixelSize2 * 2)) / 6;
            this.I = i18;
            this.f74918i.setColumnWidth(i18);
            i3 = dimensionPixelSize2;
        } else {
            int i19 = (int) (screenWidth / 6.5d);
            this.I = i19;
            this.f74918i.setColumnWidth(i19);
            i3 = 0;
        }
        if (i3 >= 0) {
            i16 = i3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.leftMargin = i16;
        this.C.setLayoutParams(layoutParams);
    }

    void g() {
        int i3;
        int size = this.G.size();
        int i16 = this.f74916f;
        if ((i16 == 1 || i16 == 2) && size > 8) {
            i3 = this.I * 8;
        } else {
            i3 = size * this.I;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f74918i.getLayoutParams();
        layoutParams.width = i3;
        this.f74918i.setLayoutParams(layoutParams);
        this.f74919m.notifyDataSetChanged();
    }

    int h() {
        long scrollX = this.C.getScrollX();
        int i3 = this.I;
        if (i3 > 0) {
            return ((int) scrollX) / i3;
        }
        return 0;
    }

    public void i(long j3, int i3, boolean z16) {
        this.f74915e = j3;
        this.f74916f = i3;
        this.f74917h = z16;
    }

    public void j(ArrayList<com.tencent.av.e> arrayList) {
        if (arrayList != null) {
            k(arrayList);
            f();
            g();
        }
    }

    void k(ArrayList<com.tencent.av.e> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("MultiMembersVideoUI", 2, "refreshDataSource");
        }
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMembersVideoUI", 2, "refreshDataSource-->friends list is null");
                return;
            }
            return;
        }
        this.G.clear();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.tencent.av.e eVar = arrayList.get(i3);
            n.b bVar = new n.b();
            bVar.f76111a = eVar.f73701a;
            bVar.f76114d = eVar.f73706f;
            bVar.f76113c = eVar.f73705e;
            bVar.f76112b = eVar.f73703c;
            bVar.f76115e = eVar.f73707g;
            bVar.f76120j = eVar.f73715o;
            bVar.f76122l = eVar.f73716p;
            bVar.f76123m = eVar.f73717q;
            bVar.f76125o = eVar.f73724x;
            this.G.add(bVar);
        }
    }

    public void l() {
        int h16 = h();
        boolean z16 = false;
        if (h16 < 0) {
            h16 = 0;
        }
        int min = Math.min(h16 + 4, this.G.size());
        int i3 = h16;
        while (true) {
            if (i3 >= min) {
                break;
            }
            if (!this.G.get(i3).f76116f) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiMembersVideoUI", 2, "refreshHeadbitmap-->minIndex=" + h16 + ",maxIndex=" + min + ",needRefresh=" + z16);
        }
        if (z16) {
            this.f74919m.notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(com.tencent.av.utils.y yVar) {
        this.H = yVar;
    }

    public MultiMembersVideoUI(Context context) {
        super(context);
        this.f74914d = null;
        this.f74915e = 0L;
        this.f74916f = 0;
        this.f74917h = false;
        this.f74918i = null;
        this.f74919m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = new ArrayList<>();
        this.H = null;
        this.I = 0;
        this.J = false;
        this.K = new a();
        this.L = new b();
    }
}
