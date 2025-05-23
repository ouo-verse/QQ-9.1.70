package com.qzone.album.business.photolist.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class x extends BaseAdapter {
    private static final int K = ar.d(85.0f);
    private int C;
    private String D;
    private g E;
    private f F;
    private e G;
    private final int H = 2;
    private final int I = 0;
    private final int J = 1;

    /* renamed from: d, reason: collision with root package name */
    private Context f42799d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f42800e;

    /* renamed from: f, reason: collision with root package name */
    private List<BusinessAlbumInfo> f42801f;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f42802h;

    /* renamed from: i, reason: collision with root package name */
    private int f42803i;

    /* renamed from: m, reason: collision with root package name */
    private int f42804m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42805d;

        a(int i3) {
            this.f42805d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (x.this.F != null) {
                x.this.F.a(this.f42805d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42807d;

        b(int i3) {
            this.f42807d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (x.this.F != null) {
                x.this.F.a(this.f42807d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42809d;

        c(int i3) {
            this.f42809d = i3;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            boolean a16 = x.this.E == null ? false : x.this.E.a(this.f42809d, x.this.f42800e);
            EventCollector.getInstance().onViewLongClicked(view);
            return a16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessAlbumInfo f42811d;

        d(BusinessAlbumInfo businessAlbumInfo) {
            this.f42811d = businessAlbumInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LpReportInfo_pf00064.allReport(602, 11, 5);
            u4.a.z().M((Activity) x.this.f42799d, this.f42811d.mAlbumId, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface e {
        int ta(String str);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface f {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface g {
        boolean a(int i3, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        View f42813a;

        /* renamed from: b, reason: collision with root package name */
        AsyncImageView f42814b;

        /* renamed from: c, reason: collision with root package name */
        TextView f42815c;

        /* renamed from: d, reason: collision with root package name */
        TextView f42816d;

        /* renamed from: e, reason: collision with root package name */
        TextView f42817e;

        /* renamed from: f, reason: collision with root package name */
        TextView f42818f;

        /* renamed from: g, reason: collision with root package name */
        LinearLayout f42819g;

        /* renamed from: h, reason: collision with root package name */
        ImageView f42820h;

        /* renamed from: i, reason: collision with root package name */
        TextView f42821i;

        /* renamed from: j, reason: collision with root package name */
        LinearLayout f42822j;

        /* renamed from: k, reason: collision with root package name */
        TextView f42823k;

        h() {
        }
    }

    public x(Context context, List<BusinessAlbumInfo> list, boolean z16, e eVar) {
        if (context != null) {
            this.f42799d = context;
            f();
            this.f42802h = LayoutInflater.from(context);
        }
        if (list == null) {
            this.f42801f = new ArrayList();
        } else {
            this.f42801f = list;
        }
        this.f42800e = z16;
        this.G = eVar;
    }

    private void f() {
        Resources resources = this.f42799d.getResources();
        if (resources != null) {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.w_);
            this.f42803i = dimensionPixelSize;
            this.f42804m = dimensionPixelSize;
            this.C = ar.l() - ar.e(250.0f);
        }
    }

    public void g(String str) {
        this.D = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f42800e) {
            return this.f42801f.size() + 1;
        }
        return this.f42801f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (!this.f42800e) {
            return this.f42801f.get(i3);
        }
        if (i3 == 0) {
            return null;
        }
        return this.f42801f.get(i3 - 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        if (!this.f42800e) {
            return i3;
        }
        if (i3 == 0) {
            return -1L;
        }
        return i3 - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return (this.f42800e && i3 == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        h hVar;
        if (!this.f42800e || i3 != 0) {
            if (view == null) {
                view = this.f42802h.inflate(R.layout.boa, (ViewGroup) null);
                hVar = new h();
                hVar.f42813a = view.findViewById(R.id.hd5);
                hVar.f42814b = (AsyncImageView) view.findViewById(R.id.dfs);
                hVar.f42815c = (TextView) view.findViewById(R.id.f164265q7);
                hVar.f42816d = (TextView) view.findViewById(R.id.f164267q9);
                hVar.f42817e = (TextView) view.findViewById(R.id.f164283qo);
                hVar.f42820h = (ImageView) view.findViewById(R.id.dft);
                hVar.f42818f = (TextView) view.findViewById(R.id.f164285qr);
                hVar.f42819g = (LinearLayout) view.findViewById(R.id.f164284qp);
                hVar.f42821i = (TextView) view.findViewById(R.id.f164266q8);
                hVar.f42822j = (LinearLayout) view.findViewById(R.id.j8u);
                hVar.f42823k = (TextView) view.findViewById(R.id.j8t);
                view.setTag(hVar);
            } else {
                hVar = (h) view.getTag();
            }
            BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) getItem(i3);
            if (businessAlbumInfo != null) {
                e(hVar, businessAlbumInfo, view, i3);
            }
        } else if (view == null && (view = this.f42802h.inflate(R.layout.bob, (ViewGroup) null)) != null) {
            view.setClickable(true);
            view.setOnClickListener(new a(i3));
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void h(f fVar) {
        this.F = fVar;
    }

    public void i(g gVar) {
        this.E = gVar;
    }

    private void e(h hVar, BusinessAlbumInfo businessAlbumInfo, View view, int i3) {
        String config;
        if (hVar == null || businessAlbumInfo == null) {
            return;
        }
        AsyncImageView asyncImageView = hVar.f42814b;
        asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        asyncImageView.setAdjustViewBounds(false);
        com.qzone.album.util.c.b(asyncImageView);
        asyncImageView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor(this.f42803i, this.f42804m));
        asyncImageView.setAsyncClipSize(this.f42803i, this.f42804m);
        asyncImageView.setCornerRadius(ar.e(4.0f));
        asyncImageView.setAsyncImage(businessAlbumInfo.mCover);
        View view2 = hVar.f42813a;
        if (view2 != null) {
            view2.setClickable(true);
            hVar.f42813a.setOnClickListener(new b(i3));
        }
        hVar.f42815c.setText(businessAlbumInfo.mTitle);
        int i16 = businessAlbumInfo.mAnonymity;
        if (i16 == 5) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeBaby", "\u4eb2\u5b50");
        } else if (i16 == 6) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeTravel", "\u65c5\u6e38");
        } else if (i16 == 8) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeLover", "\u60c5\u4fa3");
        } else if (i16 == 9) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeMulti", "\u591a\u4eba");
        } else {
            config = businessAlbumInfo.isIndividualityAlbum ? QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypePersonal", "\u4e2a\u6027") : null;
        }
        if (!TextUtils.isEmpty(config)) {
            hVar.f42821i.setText(config);
            hVar.f42821i.setVisibility(0);
        } else {
            hVar.f42821i.setVisibility(8);
        }
        hVar.f42815c.setMaxWidth(this.C);
        if (businessAlbumInfo.mAlbumType != 21) {
            hVar.f42816d.setText(String.format("%d\u5f20", Integer.valueOf(businessAlbumInfo.mTotal)));
            hVar.f42816d.setVisibility(0);
            String description = BusinessAlbumInfo.Privacy.getDescription(businessAlbumInfo.mPrivacy);
            hVar.f42817e.setText(description);
            if (this.f42799d.getResources().getString(R.string.gc6).equals(description)) {
                hVar.f42817e.setVisibility(8);
            } else {
                hVar.f42817e.setVisibility(0);
            }
        } else {
            if (businessAlbumInfo.mTotal > 0) {
                hVar.f42817e.setVisibility(0);
                hVar.f42817e.setText(String.format(com.qzone.util.l.a(R.string.s1v), Integer.valueOf(businessAlbumInfo.mTotal)));
                hVar.f42817e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                hVar.f42817e.setVisibility(8);
            }
            hVar.f42816d.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.D)) {
            hVar.f42820h.setImageResource(R.drawable.aug);
            hVar.f42820h.setVisibility(0);
        } else {
            hVar.f42820h.setImageResource(R.drawable.gds);
            String str = businessAlbumInfo.mAlbumId;
            if (str != null && str.equals(this.D)) {
                hVar.f42820h.setVisibility(0);
            } else {
                hVar.f42820h.setVisibility(4);
            }
        }
        e eVar = this.G;
        if (eVar != null) {
            int ta5 = eVar.ta(businessAlbumInfo.mAlbumId);
            if (ta5 > 0) {
                hVar.f42819g.setVisibility(0);
                hVar.f42818f.setText(ta5 + "");
            } else {
                hVar.f42819g.setVisibility(4);
            }
        }
        LinearLayout linearLayout = hVar.f42822j;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            View view3 = hVar.f42813a;
            if (view3 != null) {
                view3.setOnLongClickListener(new c(i3));
            }
            view.setTag(-3, Integer.valueOf(K));
            hVar.f42823k.setOnClickListener(new d(businessAlbumInfo));
        }
    }
}
