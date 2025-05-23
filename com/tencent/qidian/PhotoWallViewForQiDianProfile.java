package com.tencent.qidian;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.ui.PhotoHorizontalScrollView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.List;

@TargetApi(9)
/* loaded from: classes22.dex */
public class PhotoWallViewForQiDianProfile extends LinearLayout {
    static IPatchRedirector $redirector_;
    public int C;
    public GridView D;
    private ImageView E;
    private View F;
    public PhotoHorizontalScrollView G;
    private AdapterView.OnItemClickListener H;

    /* renamed from: d, reason: collision with root package name */
    View f342652d;

    /* renamed from: e, reason: collision with root package name */
    private Context f342653e;

    /* renamed from: f, reason: collision with root package name */
    public List<com.tencent.qidian.data.a> f342654f;

    /* renamed from: h, reason: collision with root package name */
    public c f342655h;

    /* renamed from: i, reason: collision with root package name */
    public int f342656i;

    /* renamed from: m, reason: collision with root package name */
    public int f342657m;

    /* loaded from: classes22.dex */
    class a implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoWallViewForQiDianProfile.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            com.tencent.qidian.data.a aVar = PhotoWallViewForQiDianProfile.this.f342654f.get(i3);
            c cVar = PhotoWallViewForQiDianProfile.this.f342655h;
            if (cVar == null) {
                return;
            }
            cVar.a(aVar);
        }
    }

    /* loaded from: classes22.dex */
    public class b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Context f342659d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f342660e;

        /* renamed from: f, reason: collision with root package name */
        List<com.tencent.qidian.data.a> f342661f;

        /* loaded from: classes22.dex */
        class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            URLImageView f342663a;

            /* renamed from: b, reason: collision with root package name */
            TextView f342664b;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }
        }

        public b(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoWallViewForQiDianProfile.this, (Object) context);
                return;
            }
            this.f342660e = null;
            this.f342659d = context;
            this.f342660e = LayoutInflater.from(context);
        }

        public void a(List<com.tencent.qidian.data.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                this.f342661f = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            List<com.tencent.qidian.data.a> list = this.f342661f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            List<com.tencent.qidian.data.a> list = this.f342661f;
            if (list != null) {
                return list.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00da  */
        @Override // android.widget.Adapter
        @TargetApi(16)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i3, View view, ViewGroup viewGroup) {
            String str;
            String str2;
            View view2;
            a aVar;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                try {
                    str = this.f342661f.get(i3).f342873c;
                    try {
                        str2 = this.f342661f.get(i3).f342871a;
                    } catch (Exception e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.d("PhotoWallViewForQiDianProfile", 2, "getView url error!");
                        }
                        e.printStackTrace();
                        str2 = null;
                        if (view != null) {
                        }
                        aVar.f342663a.setTag(new com.tencent.mobileqq.profile.b(25, Integer.valueOf(i3)));
                        if (!TextUtils.isEmpty(str)) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        view3 = view2;
                        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
                        return view2;
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = null;
                }
                if (view != null) {
                    aVar = new a();
                    view2 = this.f342660e.inflate(R.layout.c4u, (ViewGroup) null);
                    PhotoWallViewForQiDianProfile photoWallViewForQiDianProfile = PhotoWallViewForQiDianProfile.this;
                    view2.setLayoutParams(new AbsListView.LayoutParams(photoWallViewForQiDianProfile.f342656i, photoWallViewForQiDianProfile.f342657m));
                    aVar.f342663a = (URLImageView) view2.findViewById(R.id.fqt);
                    TextView textView = (TextView) view2.findViewById(R.id.enn);
                    aVar.f342664b = textView;
                    textView.setMaxLines(2);
                    aVar.f342664b.setTextColor(-1);
                    aVar.f342664b.setTextSize(2, 14.0f);
                    aVar.f342664b.setMaxLines(2);
                    Resources resources = this.f342659d.getResources();
                    aVar.f342664b.setLineSpacing(BaseAIOUtils.f(2.5f, resources), 1.0f);
                    aVar.f342664b.setGravity(80);
                    aVar.f342664b.setEllipsize(TextUtils.TruncateAt.END);
                    aVar.f342664b.setBackgroundResource(R.drawable.f161223sj);
                    int f16 = BaseAIOUtils.f(11.0f, resources);
                    int f17 = BaseAIOUtils.f(14.0f, resources);
                    aVar.f342664b.setPadding(f17, 0, f17, f16);
                    view2.setTag(aVar);
                } else {
                    view2 = view;
                    aVar = (a) view.getTag();
                }
                aVar.f342663a.setTag(new com.tencent.mobileqq.profile.b(25, Integer.valueOf(i3)));
                if (!TextUtils.isEmpty(str)) {
                    aVar.f342663a.setImageResource(R.drawable.h2r);
                } else {
                    aVar.f342663a.setImageDrawable(URLDrawable.getDrawable(str));
                }
                if (!TextUtils.isEmpty(str2)) {
                    aVar.f342664b.setVisibility(0);
                    aVar.f342664b.setText(str2);
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes22.dex */
    public interface c {
        void a(com.tencent.qidian.data.a aVar);
    }

    public PhotoWallViewForQiDianProfile(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f342656i = -1;
        this.f342657m = -1;
        this.C = -1;
        this.H = new a();
    }

    public void a(Context context, List<com.tencent.qidian.data.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PhotoWallViewForQiDianProfile", 2, "initView");
        }
        this.f342653e = context;
        this.f342654f = list;
        View inflate = LayoutInflater.from(context).inflate(R.layout.c4w, (ViewGroup) this, true);
        this.f342652d = inflate;
        GridView gridView = (GridView) inflate.findViewById(R.id.fqh);
        this.D = gridView;
        gridView.setClickable(true);
        this.G = (PhotoHorizontalScrollView) this.f342652d.findViewById(R.id.fqi);
        this.E = (ImageView) this.f342652d.findViewById(R.id.g1c);
        this.F = this.f342652d.findViewById(R.id.h77);
        this.C = getResources().getDimensionPixelSize(R.dimen.abx);
        this.f342656i = getResources().getDimensionPixelSize(R.dimen.abz);
        this.f342657m = getResources().getDimensionPixelSize(R.dimen.aby);
        if (VersionUtils.isGingerBread()) {
            this.G.setOverScrollMode(2);
        }
        b();
    }

    public void b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel() && this.f342654f != null) {
            QLog.i("PhotoWallViewForQiDianProfile", 2, "updatePhotoView urlList size=" + this.f342654f.size());
        }
        List<com.tencent.qidian.data.a> list = this.f342654f;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            this.D.setColumnWidth(this.f342656i);
            this.D.setStretchMode(0);
            this.D.setHorizontalSpacing(this.C);
            b bVar = new b(this.f342653e);
            bVar.a(this.f342654f);
            int size = this.f342654f.size();
            this.D.setLayoutParams(new LinearLayout.LayoutParams((this.f342656i + this.C) * size, this.f342657m));
            this.D.setNumColumns(size);
            this.D.setAdapter((ListAdapter) bVar);
            this.D.setOnItemClickListener(this.H);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.D.setVisibility(0);
            setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setPhotoWallCallback(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.f342655h = cVar;
        }
    }

    public PhotoWallViewForQiDianProfile(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f342656i = -1;
        this.f342657m = -1;
        this.C = -1;
        this.H = new a();
    }

    @TargetApi(11)
    public PhotoWallViewForQiDianProfile(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f342656i = -1;
        this.f342657m = -1;
        this.C = -1;
        this.H = new a();
    }
}
