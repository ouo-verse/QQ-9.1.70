package k4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    public Context f411636b;

    /* renamed from: c, reason: collision with root package name */
    public View f411637c;

    /* renamed from: d, reason: collision with root package name */
    private View f411638d;

    /* renamed from: e, reason: collision with root package name */
    private View f411639e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f411640f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f411641g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f411642h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f411643i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f411644j;

    /* renamed from: k, reason: collision with root package name */
    private RelativeLayout f411645k;

    /* renamed from: l, reason: collision with root package name */
    private RelativeLayout f411646l;

    /* renamed from: m, reason: collision with root package name */
    private String f411647m;

    /* renamed from: n, reason: collision with root package name */
    private AlbumDataOutShare f411648n;

    /* renamed from: o, reason: collision with root package name */
    private AlbumCacheData f411649o;

    /* renamed from: p, reason: collision with root package name */
    private ArrayList<String> f411650p;

    /* renamed from: a, reason: collision with root package name */
    private int f411635a = 1;

    /* renamed from: q, reason: collision with root package name */
    private k4.a f411651q = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f411652d;

        a(g gVar) {
            this.f411652d = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.f411635a = 1;
            h.this.l();
            g gVar = this.f411652d;
            if (gVar != null) {
                gVar.X(true);
                if (h.this.f411648n != null) {
                    yo.d.d(h.this.f411648n.qqUrl, h.this.f411636b, null);
                }
            }
            com.qzone.album.env.common.a.m().P(724, 1, "1", true, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f411654d;

        b(g gVar) {
            this.f411654d = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.f411635a = 2;
            h.this.l();
            String i3 = yo.f.i(yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_ALBUM_SHARE_DYNAMIC_URL, QzoneConfig.DefaultValue.DEFAULT_ALBUM_SHARE_DYNAMIC_URL), "{albumid}", h.this.f411649o.albumid), "{hostuin}", h.this.f411649o.ownerUin);
            com.qzone.album.base.Service.e.e().t(true);
            yo.d.d(i3, h.this.f411636b, null);
            g gVar = this.f411654d;
            if (gVar != null) {
                gVar.W(true);
                this.f411654d.b(true);
            }
            com.qzone.album.env.common.a.m().P(724, 2, "1", true, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.f411635a = 1;
            h.this.l();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f411657d;

        d(g gVar) {
            this.f411657d = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h.this.f411635a = 2;
            h.this.l();
            g gVar = this.f411657d;
            if (gVar != null) {
                gVar.E(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public h(Context context, g gVar, AlbumCacheData albumCacheData, ArrayList<String> arrayList, String str) {
        this.f411649o = albumCacheData;
        this.f411650p = arrayList;
        this.f411647m = str;
        h(context);
        m(albumCacheData);
        g(gVar);
    }

    private void g(g gVar) {
        View view = this.f411638d;
        if (view != null) {
            view.setOnClickListener(new a(gVar));
        }
        View view2 = this.f411639e;
        if (view2 != null) {
            view2.setOnClickListener(new b(gVar));
        }
        RelativeLayout relativeLayout = this.f411645k;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new c());
        }
        RelativeLayout relativeLayout2 = this.f411646l;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new d(gVar));
        }
    }

    private void k(String str) {
        k4.a aVar = this.f411651q;
        if (aVar != null) {
            aVar.f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int parseColor;
        int parseColor2;
        if (this.f411635a == 1) {
            com.qzone.album.env.common.a.m().P(724, 1, "2", true, null);
            ImageView imageView = this.f411642h;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.ghd);
            }
            ImageView imageView2 = this.f411643i;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.ghe);
            }
            View view = this.f411638d;
            if (view != null) {
                view.setBackgroundResource(R.drawable.ar3);
            }
            View view2 = this.f411639e;
            if (view2 != null) {
                view2.setBackgroundResource(0);
            }
        } else {
            com.qzone.album.env.common.a.m().P(724, 2, "2", true, null);
            ImageView imageView3 = this.f411642h;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.ghe);
            }
            ImageView imageView4 = this.f411643i;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.ghd);
            }
            View view3 = this.f411638d;
            if (view3 != null) {
                view3.setBackgroundResource(0);
            }
            View view4 = this.f411639e;
            if (view4 != null) {
                view4.setBackgroundResource(R.drawable.ar3);
            }
        }
        RelativeLayout relativeLayout = this.f411645k;
        if (relativeLayout != null) {
            if (this.f411635a == 1) {
                parseColor2 = Color.parseColor("#f3f3f3");
            } else {
                parseColor2 = Color.parseColor(TipsElementData.DEFAULT_COLOR);
            }
            relativeLayout.setBackgroundColor(parseColor2);
        }
        RelativeLayout relativeLayout2 = this.f411646l;
        if (relativeLayout2 != null) {
            if (this.f411635a == 2) {
                parseColor = Color.parseColor("#f3f3f3");
            } else {
                parseColor = Color.parseColor(TipsElementData.DEFAULT_COLOR);
            }
            relativeLayout2.setBackgroundColor(parseColor);
        }
    }

    private void m(AlbumCacheData albumCacheData) {
        this.f411649o = albumCacheData;
        View b16 = new i(this.f411636b, albumCacheData, this.f411650p).b();
        this.f411638d = b16;
        if (this.f411645k != null && b16 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ar.e(113.0f), ar.e(157.0f));
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            layoutParams.setMargins(0, 0, 0, ar.e(47.0f));
            this.f411645k.addView(this.f411638d, layoutParams);
        }
        k4.a aVar = new k4.a(this.f411636b, this.f411649o, this.f411647m);
        this.f411651q = aVar;
        View d16 = aVar.d();
        this.f411639e = d16;
        if (this.f411646l != null && d16 != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ar.e(113.0f), ar.e(157.0f));
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(14, -1);
            layoutParams2.setMargins(0, 0, 0, ar.e(47.0f));
            this.f411646l.addView(this.f411639e, layoutParams2);
        }
        this.f411635a = 1;
        l();
    }

    public View e() {
        return this.f411637c;
    }

    public int f() {
        return this.f411635a;
    }

    public void i(AlbumDataOutShare albumDataOutShare) {
        this.f411648n = albumDataOutShare;
    }

    public void j(AlbumCacheData albumCacheData) {
        k(albumCacheData.albumname);
    }

    private void h(Context context) {
        if (context != null) {
            this.f411636b = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.br9, (ViewGroup) null);
            this.f411637c = inflate;
            this.f411644j = (LinearLayout) inflate.findViewById(R.id.hr_);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ar.e(242.0f));
            layoutParams.addRule(3, R.id.hra);
            this.f411644j.setLayoutParams(layoutParams);
            this.f411645k = (RelativeLayout) this.f411637c.findViewById(R.id.f166740hq4);
            TextView textView = (TextView) this.f411637c.findViewById(R.id.hji);
            this.f411640f = textView;
            textView.setText(l.a(R.string.jcv));
            ImageView imageView = (ImageView) this.f411637c.findViewById(R.id.f166737hq1);
            this.f411642h = imageView;
            imageView.setVisibility(0);
            this.f411646l = (RelativeLayout) this.f411637c.findViewById(R.id.htl);
            TextView textView2 = (TextView) this.f411637c.findViewById(R.id.f166742hr3);
            this.f411641g = textView2;
            textView2.setText(l.a(R.string.jcq));
            ImageView imageView2 = (ImageView) this.f411637c.findViewById(R.id.htj);
            this.f411643i = imageView2;
            imageView2.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ar.e(21.0f), ar.e(21.0f));
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(14, -1);
            layoutParams2.setMargins(0, 0, 0, ar.e(10.5f));
            this.f411643i.setLayoutParams(layoutParams2);
            this.f411642h.setLayoutParams(layoutParams2);
        }
    }
}
