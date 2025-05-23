package com.qzone.album.business.photolist.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import r4.b;
import r4.f;
import r4.h;

/* loaded from: classes39.dex */
public class CommonPhotoSearchBoxView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private ListView f43265d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.album.business.photolist.controller.d f43266e;

    /* renamed from: f, reason: collision with root package name */
    private a f43267f;

    public CommonPhotoSearchBoxView(Context context) {
        super(context);
        c();
    }

    private void c() {
        this.f43265d = (ListView) LayoutInflater.from(getContext()).inflate(R.layout.bu6, this).findViewById(R.id.b5v);
        a aVar = new a(getContext());
        this.f43267f = aVar;
        this.f43265d.setAdapter((ListAdapter) aVar);
    }

    public ListView b() {
        return this.f43265d;
    }

    public void d() {
        a aVar = this.f43267f;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void e(r4.a aVar, com.qzone.album.business.photolist.controller.d dVar) {
        this.f43266e = dVar;
        a aVar2 = this.f43267f;
        if (aVar2 != null) {
            aVar2.d(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private r4.a f43268d;

        /* renamed from: e, reason: collision with root package name */
        private Context f43269e;

        /* renamed from: f, reason: collision with root package name */
        private ImageProcessor f43270f = new C0339a();

        /* renamed from: com.qzone.album.business.photolist.ui.CommonPhotoSearchBoxView$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0339a extends ImageProcessor {
            C0339a() {
            }

            @Override // com.tencent.component.media.image.ImageProcessor
            public Drawable process(Drawable drawable) {
                return new RoundCornerProcessor(ar.e(7.0f)).process(new NormalFeedImageProcessor(ar.e(110.0f), ar.e(110.0f)).process(drawable));
            }
        }

        /* loaded from: classes39.dex */
        public class b {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f43273a;

            /* renamed from: b, reason: collision with root package name */
            TextView f43274b;

            /* renamed from: c, reason: collision with root package name */
            RelativeLayout f43275c;

            /* renamed from: d, reason: collision with root package name */
            ImageView f43276d;

            /* renamed from: e, reason: collision with root package name */
            RelativeLayout f43277e;

            /* renamed from: f, reason: collision with root package name */
            LinearLayout f43278f;

            /* renamed from: g, reason: collision with root package name */
            RelativeLayout[] f43279g;

            /* renamed from: h, reason: collision with root package name */
            TextView[] f43280h;

            /* renamed from: i, reason: collision with root package name */
            LinearLayout f43281i;

            /* renamed from: j, reason: collision with root package name */
            RelativeLayout[] f43282j;

            /* renamed from: k, reason: collision with root package name */
            AsyncImageView[] f43283k;

            /* renamed from: l, reason: collision with root package name */
            TextView[] f43284l;

            b() {
                if (this.f43280h == null) {
                    this.f43280h = new TextView[3];
                }
                if (this.f43279g == null) {
                    this.f43279g = new RelativeLayout[3];
                }
                if (this.f43282j == null) {
                    this.f43282j = new RelativeLayout[4];
                }
                if (this.f43283k == null) {
                    this.f43283k = new AsyncImageView[4];
                }
                if (this.f43284l == null) {
                    this.f43284l = new TextView[4];
                }
            }
        }

        public a(Context context) {
            this.f43269e = context;
        }

        private void g(b bVar, int i3) {
            r4.c d16 = this.f43268d.d(i3);
            if (d16 != null) {
                if (d16.f430703f) {
                    bVar.f43276d.setImageResource(R.drawable.fw5);
                } else {
                    bVar.f43276d.setImageResource(R.drawable.f162185fw4);
                }
            }
            if (CommonPhotoSearchBoxView.this.f43266e != null) {
                bVar.f43277e.setOnClickListener(CommonPhotoSearchBoxView.this.f43266e.v(i3));
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r4.a getItem(int i3) {
            return null;
        }

        public void d(r4.a aVar) {
            this.f43268d = aVar;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            r4.a aVar = this.f43268d;
            if (aVar == null) {
                return 0;
            }
            return aVar.f430687f;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            r4.b c16 = this.f43268d.c(i3);
            if (c16 == null) {
                return 0;
            }
            return c16.d();
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            b bVar;
            int itemViewType = getItemViewType(i3);
            r4.b c16 = this.f43268d.c(i3);
            r4.c d16 = this.f43268d.d(i3);
            if (view == null) {
                view = LayoutInflater.from(this.f43269e).inflate(R.layout.bu5, (ViewGroup) null);
                bVar = new b();
                bVar.f43273a = (RelativeLayout) view.findViewById(R.id.ij7);
                bVar.f43274b = (TextView) view.findViewById(R.id.ij6);
                bVar.f43275c = (RelativeLayout) view.findViewById(R.id.f166834ij3);
                bVar.f43276d = (ImageView) view.findViewById(R.id.f166832ij1);
                bVar.f43277e = (RelativeLayout) view.findViewById(R.id.f166833ij2);
                b(bVar, view);
                c(bVar, view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        j.f("AlbumPhotoSearchBox", "getview type:" + itemViewType);
                    } else if ((c16 instanceof r4.d) && bVar != null) {
                        e(i3, bVar, (r4.d) c16);
                        bVar.f43275c.setVisibility(8);
                        bVar.f43273a.setVisibility(8);
                        bVar.f43278f.setVisibility(8);
                        bVar.f43281i.setVisibility(0);
                    }
                } else if ((c16 instanceof f) && bVar != null) {
                    f(i3, bVar, (f) c16);
                    bVar.f43275c.setVisibility(8);
                    bVar.f43273a.setVisibility(8);
                    bVar.f43278f.setVisibility(0);
                    bVar.f43281i.setVisibility(8);
                }
            } else if ((c16 instanceof h) && bVar != null) {
                h hVar = (h) c16;
                if (hVar.c()) {
                    bVar.f43273a.setVisibility(8);
                    bVar.f43275c.setVisibility(0);
                    bVar.f43277e.setVisibility(8);
                } else {
                    bVar.f43275c.setVisibility(8);
                    bVar.f43273a.setVisibility(0);
                    if (d16 != null && d16.a()) {
                        bVar.f43277e.setVisibility(0);
                    } else {
                        bVar.f43277e.setVisibility(8);
                    }
                    bVar.f43274b.setText(hVar.f430713c.f430690a);
                    g(bVar, i3);
                }
                bVar.f43278f.setVisibility(8);
                bVar.f43281i.setVisibility(8);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        private void b(b bVar, View view) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f166835ij4);
            bVar.f43281i = linearLayout;
            linearLayout.removeAllViews();
            for (int i3 = 0; i3 < 4; i3++) {
                bVar.f43282j[i3] = (RelativeLayout) LayoutInflater.from(this.f43269e).inflate(R.layout.f169048bu3, (ViewGroup) null);
                bVar.f43283k[i3] = (AsyncImageView) bVar.f43282j[i3].findViewById(R.id.iiz);
                bVar.f43283k[i3].setAsyncImageProcessor(this.f43270f);
                bVar.f43284l[i3] = (TextView) bVar.f43282j[i3].findViewById(R.id.f166831ij0);
                bVar.f43281i.addView(bVar.f43282j[i3], new LinearLayout.LayoutParams(0, -2, 1.0f));
            }
        }

        private void c(b bVar, View view) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ij5);
            bVar.f43278f = linearLayout;
            linearLayout.removeAllViews();
            for (int i3 = 0; i3 < 3; i3++) {
                bVar.f43279g[i3] = (RelativeLayout) LayoutInflater.from(this.f43269e).inflate(R.layout.f169049bu4, (ViewGroup) null);
                bVar.f43280h[i3] = (TextView) bVar.f43279g[i3].findViewById(R.id.ij_);
                bVar.f43278f.addView(bVar.f43279g[i3], new LinearLayout.LayoutParams(0, -2, 1.0f));
            }
        }

        private void e(int i3, b bVar, r4.d dVar) {
            for (int i16 = 0; i16 < 4; i16++) {
                if (i16 < dVar.b()) {
                    ArrayList<b.a> i17 = dVar.i();
                    b.a aVar = i17 != null ? i17.get(i16) : null;
                    if (aVar != null) {
                        bVar.f43283k[i16].setAsyncImage(aVar.f430690a);
                        bVar.f43284l[i16].setText(aVar.f430691b);
                        if (aVar.f430692c) {
                            bVar.f43283k[i16].setForeground(R.drawable.aqw);
                            bVar.f43284l[i16].setTextColor(CommonPhotoSearchBoxView.this.getResources().getColor(R.color.a6d));
                        } else {
                            bVar.f43283k[i16].setForeground(R.drawable.aqv);
                            bVar.f43284l[i16].setTextColor(-16777216);
                        }
                        bVar.f43283k[i16].setVisibility(0);
                        bVar.f43284l[i16].setVisibility(0);
                        bVar.f43282j[i16].setVisibility(0);
                        if (CommonPhotoSearchBoxView.this.f43266e != null) {
                            bVar.f43282j[i16].setOnClickListener(CommonPhotoSearchBoxView.this.f43266e.x(i3, i16, 2, dVar));
                        }
                    }
                } else {
                    bVar.f43282j[i16].setVisibility(4);
                    bVar.f43282j[i16].setOnClickListener(null);
                }
            }
        }

        private void f(int i3, b bVar, f fVar) {
            for (int i16 = 0; i16 < 3; i16++) {
                if (i16 < fVar.b()) {
                    ArrayList<b.a> i17 = fVar.i();
                    b.a aVar = i17 != null ? i17.get(i16) : null;
                    if (aVar != null) {
                        if (aVar.f430692c) {
                            bVar.f43280h[i16].setBackgroundResource(R.drawable.gbh);
                            bVar.f43280h[i16].setTextColor(CommonPhotoSearchBoxView.this.getResources().getColor(R.color.a6d));
                        } else {
                            bVar.f43280h[i16].setBackgroundResource(R.drawable.avx);
                            bVar.f43280h[i16].setTextColor(-16777216);
                        }
                        bVar.f43280h[i16].setText(aVar.f430690a);
                        bVar.f43280h[i16].setVisibility(0);
                        bVar.f43279g[i16].setVisibility(0);
                        if (CommonPhotoSearchBoxView.this.f43266e != null) {
                            bVar.f43279g[i16].setOnClickListener(CommonPhotoSearchBoxView.this.f43266e.x(i3, i16, 1, fVar));
                        }
                    }
                } else {
                    bVar.f43279g[i16].setVisibility(4);
                    bVar.f43279g[i16].setOnClickListener(null);
                }
            }
        }
    }

    public CommonPhotoSearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public CommonPhotoSearchBoxView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}
