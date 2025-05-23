package com.qzone.album.business.photolist.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.FlexiableProcessImageView;
import com.qzone.widget.TriangleView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class y extends BaseAdapter {
    private e C;
    private ArrayList<PhotoCategorySummaryInfo> D;
    int E;

    /* renamed from: d, reason: collision with root package name */
    private Context f42825d;

    /* renamed from: e, reason: collision with root package name */
    private long f42826e;

    /* renamed from: f, reason: collision with root package name */
    private int f42827f = 3;

    /* renamed from: h, reason: collision with root package name */
    private int f42828h;

    /* renamed from: i, reason: collision with root package name */
    private int f42829i;

    /* renamed from: m, reason: collision with root package name */
    private f f42830m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends ImageProcessor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f42831a;

        a(float f16) {
            this.f42831a = f16;
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            float f16 = this.f42831a;
            return new RoundCornerProcessor(6.0f).process(new SpecifiedSizeCropByPivotProcessor((int) f16, (int) f16).process(drawable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42833d;

        b(int i3) {
            this.f42833d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (y.this.f42830m != null) {
                y.this.f42830m.a(this.f42833d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42835d;

        c(int i3) {
            this.f42835d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (y.this.C != null) {
                y.this.C.a(y.this.D, this.f42835d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42837d;

        d(int i3) {
            this.f42837d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (y.this.C != null) {
                y.this.C.b(y.this.D, this.f42837d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface e {
        void a(ArrayList<PhotoCategorySummaryInfo> arrayList, int i3);

        void b(ArrayList<PhotoCategorySummaryInfo> arrayList, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface f {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        public FlexiableProcessImageView f42839a;

        /* renamed from: b, reason: collision with root package name */
        TextView f42840b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f42841c;

        /* renamed from: d, reason: collision with root package name */
        LinearLayout f42842d;

        /* renamed from: e, reason: collision with root package name */
        AsyncImageView[] f42843e;

        /* renamed from: f, reason: collision with root package name */
        ImageView[] f42844f;

        /* renamed from: g, reason: collision with root package name */
        TextView[] f42845g;

        /* renamed from: h, reason: collision with root package name */
        RelativeLayout[] f42846h;

        /* renamed from: i, reason: collision with root package name */
        TriangleView f42847i;

        /* renamed from: j, reason: collision with root package name */
        ViewStub f42848j;

        /* renamed from: k, reason: collision with root package name */
        RelativeLayout f42849k;

        /* renamed from: l, reason: collision with root package name */
        TextView f42850l;

        /* renamed from: m, reason: collision with root package name */
        TextView f42851m;

        /* renamed from: n, reason: collision with root package name */
        TextView f42852n;

        public g() {
        }

        public boolean a() {
            if (this.f42849k != null) {
                return true;
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.f42848j.inflate();
            this.f42849k = relativeLayout;
            if (relativeLayout == null) {
                return false;
            }
            this.f42850l = (TextView) relativeLayout.findViewById(R.id.hbc);
            this.f42851m = (TextView) this.f42849k.findViewById(R.id.hb9);
            this.f42852n = (TextView) this.f42849k.findViewById(R.id.hb7);
            return true;
        }
    }

    public y(Context context, long j3) {
        this.f42825d = context;
        this.f42826e = j3;
        d();
    }

    private void e(g gVar, View view) {
        float dimension = this.f42825d.getResources().getDimension(R.dimen.f159256yp);
        FlexiableProcessImageView flexiableProcessImageView = (FlexiableProcessImageView) view.findViewById(R.id.h_3);
        gVar.f42839a = flexiableProcessImageView;
        int i3 = (int) dimension;
        com.qzone.album.util.c.c(flexiableProcessImageView, i3, i3);
        gVar.f42839a.setAsyncImageProcessor(new a(dimension));
        gVar.f42840b = (TextView) view.findViewById(R.id.h_4);
        gVar.f42841c = (TextView) view.findViewById(R.id.h_5);
        gVar.f42848j = (ViewStub) view.findViewById(R.id.hb8);
        TriangleView triangleView = (TriangleView) view.findViewById(R.id.ham);
        gVar.f42847i = triangleView;
        triangleView.setDrawColor(-16669697);
        gVar.f42847i.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.h_6);
        gVar.f42842d = linearLayout;
        linearLayout.removeAllViews();
        int i16 = this.f42827f;
        gVar.f42846h = new RelativeLayout[i16];
        gVar.f42843e = new AsyncImageView[i16];
        gVar.f42845g = new TextView[i16];
        gVar.f42844f = new ImageView[i16];
        for (int i17 = 0; i17 < this.f42827f; i17++) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f42825d);
            gVar.f42846h[i17] = relativeLayout;
            int i18 = this.f42828h;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i18, i18);
            if (i17 != this.f42827f - 1) {
                layoutParams.rightMargin = this.f42829i;
            }
            AsyncImageView asyncImageView = new AsyncImageView(this.f42825d);
            asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            com.qzone.album.util.c.b(asyncImageView);
            gVar.f42843e[i17] = asyncImageView;
            int i19 = this.f42828h;
            relativeLayout.addView(asyncImageView, new RelativeLayout.LayoutParams(i19, i19));
            TextView textView = new TextView(this.f42825d);
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            textView.setVisibility(4);
            gVar.f42845g[i17] = textView;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(12);
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = ar.e(9.5f);
            layoutParams2.bottomMargin = ar.e(7.0f);
            relativeLayout.addView(textView, layoutParams2);
            ImageView imageView = new ImageView(this.f42825d);
            imageView.setImageResource(R.drawable.gai);
            imageView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(10);
            layoutParams3.addRule(9);
            layoutParams3.leftMargin = ar.e(4.0f);
            layoutParams3.topMargin = ar.e(4.0f);
            gVar.f42844f[i17] = imageView;
            relativeLayout.addView(imageView, layoutParams3);
            gVar.f42842d.addView(relativeLayout, layoutParams);
        }
    }

    private void f(g gVar, PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        if (!TextUtils.isEmpty(photoCategorySummaryInfo.avatarUrl)) {
            gVar.f42839a.setVisibility(0);
            gVar.f42839a.setAsyncImage(photoCategorySummaryInfo.avatarUrl);
        } else {
            gVar.f42839a.setVisibility(8);
        }
    }

    private void g(g gVar, int i3, PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        if (photoCategorySummaryInfo.categoryType == 1 && photoCategorySummaryInfo.needShow && !TextUtils.isEmpty(photoCategorySummaryInfo.nick) && photoCategorySummaryInfo.faceStatus == 3 && photoCategorySummaryInfo.uin != 0 && gVar.a()) {
            Paint paint = new Paint();
            paint.setTextSize(32.0f);
            float[] fArr = new float[photoCategorySummaryInfo.nick.length()];
            int textWidths = paint.getTextWidths(photoCategorySummaryInfo.nick, fArr);
            int i16 = 0;
            int i17 = 0;
            while (i16 < textWidths) {
                float f16 = i17;
                float f17 = fArr[i16];
                if (f16 + f17 >= this.E * 0.3d) {
                    break;
                }
                i17 = (int) (f16 + f17);
                i16++;
            }
            if (i16 == photoCategorySummaryInfo.nick.length()) {
                gVar.f42850l.setText(com.qzone.util.l.a(R.string.f172551s31) + photoCategorySummaryInfo.nick + com.qzone.util.l.a(R.string.s3d));
            } else {
                gVar.f42850l.setText(com.qzone.util.l.a(R.string.s2t) + photoCategorySummaryInfo.nick.substring(0, i16) + com.qzone.util.l.a(R.string.s2p));
            }
            gVar.f42851m.setOnClickListener(new c(i3));
            gVar.f42852n.setOnClickListener(new d(i3));
            gVar.f42847i.setVisibility(0);
            gVar.f42849k.setVisibility(0);
            gVar.f42849k.bringToFront();
            return;
        }
        RelativeLayout relativeLayout = gVar.f42849k;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        gVar.f42847i.setVisibility(8);
    }

    private int h(g gVar, PhotoCategorySummaryInfo photoCategorySummaryInfo, int i3) {
        while (i3 < this.f42827f && i3 < photoCategorySummaryInfo.previewPhotos.size()) {
            RelativeLayout relativeLayout = gVar.f42846h[i3];
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                PhotoCategorySinglePicInfo photoCategorySinglePicInfo = photoCategorySummaryInfo.previewPhotos.get(i3);
                if (photoCategorySinglePicInfo != null && photoCategorySinglePicInfo.singlePicInfo != null) {
                    j(gVar.f42843e[i3], photoCategorySinglePicInfo);
                    r(gVar, i3, photoCategorySinglePicInfo);
                    p(gVar.f42844f[i3], photoCategorySinglePicInfo);
                }
            }
            i3++;
        }
        return i3;
    }

    private void i(g gVar, int i3) {
        PhotoCategorySummaryInfo photoCategorySummaryInfo = (PhotoCategorySummaryInfo) getItem(i3);
        if (photoCategorySummaryInfo != null) {
            f(gVar, photoCategorySummaryInfo);
            k(gVar, photoCategorySummaryInfo);
            g(gVar, i3, photoCategorySummaryInfo);
            l(gVar, i3, photoCategorySummaryInfo);
            m(gVar, photoCategorySummaryInfo);
            ArrayList<PhotoCategorySinglePicInfo> arrayList = photoCategorySummaryInfo.previewPhotos;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            for (int h16 = h(gVar, photoCategorySummaryInfo, 0); h16 < this.f42827f; h16++) {
                RelativeLayout relativeLayout = gVar.f42846h[h16];
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }
    }

    private void j(AsyncImageView asyncImageView, PhotoCategorySinglePicInfo photoCategorySinglePicInfo) {
        String str;
        int i3 = this.f42828h;
        asyncImageView.setAsyncClipSize(i3, i3);
        if (!TextUtils.isEmpty(photoCategorySinglePicInfo.singlePicInfo.currentUrl)) {
            str = photoCategorySinglePicInfo.singlePicInfo.currentUrl;
        } else if (!TextUtils.isEmpty(photoCategorySinglePicInfo.singlePicInfo.middleUrl)) {
            str = photoCategorySinglePicInfo.singlePicInfo.middleUrl;
        } else if (!TextUtils.isEmpty(photoCategorySinglePicInfo.singlePicInfo.bigUrl)) {
            str = photoCategorySinglePicInfo.singlePicInfo.bigUrl;
        } else {
            str = !TextUtils.isEmpty(photoCategorySinglePicInfo.singlePicInfo.smallUrl) ? photoCategorySinglePicInfo.singlePicInfo.smallUrl : null;
        }
        asyncImageView.setAsyncImage(str);
    }

    private void k(g gVar, PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        int i3;
        if (!TextUtils.isEmpty(photoCategorySummaryInfo.nick) && ((i3 = photoCategorySummaryInfo.faceStatus) == 1 || i3 == 2 || photoCategorySummaryInfo.categoryType != 1)) {
            gVar.f42840b.setTextColor(-16777216);
            gVar.f42840b.setText(photoCategorySummaryInfo.nick);
        } else if (photoCategorySummaryInfo.categoryType == 1) {
            gVar.f42840b.setTextColor(Color.rgb(187, 187, 187));
            gVar.f42840b.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumAddName", "\u6dfb\u52a0\u540d\u5b57"));
        } else {
            gVar.f42840b.setTextColor(-16777216);
            gVar.f42840b.setText("");
        }
    }

    private void l(g gVar, int i3, PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        if (photoCategorySummaryInfo.categoryType == 1) {
            gVar.f42840b.setOnClickListener(new b(i3));
        }
    }

    private void m(g gVar, PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        if (photoCategorySummaryInfo.photoNumber >= 0) {
            gVar.f42841c.setText(photoCategorySummaryInfo.photoNumber + com.qzone.util.l.a(R.string.s3e));
            return;
        }
        gVar.f42841c.setText("0\u5f20");
    }

    private void r(g gVar, int i3, PhotoCategorySinglePicInfo photoCategorySinglePicInfo) {
        if (this.f42826e != photoCategorySinglePicInfo.singlePicInfo.uploadUin) {
            gVar.f42845g[i3].setVisibility(0);
            gVar.f42845g[i3].setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeShared", "\u5171\u4eab"));
            return;
        }
        gVar.f42845g[i3].setVisibility(8);
    }

    protected void d() {
        this.E = this.f42825d.getResources().getDisplayMetrics().widthPixels;
        int o16 = u4.a.z().o(2.0f);
        this.f42829i = o16;
        int i3 = this.E;
        if (i3 < 480) {
            this.f42827f = 3;
        }
        int i16 = this.f42827f;
        this.f42828h = (i3 - (o16 * (i16 - 1))) / i16;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<PhotoCategorySummaryInfo> arrayList = this.D;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<PhotoCategorySummaryInfo> arrayList = this.D;
        if (arrayList == null || i3 < 0 || i3 >= arrayList.size()) {
            return null;
        }
        return this.D.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public void n(e eVar) {
        this.C = eVar;
    }

    public void o(f fVar) {
        this.f42830m = fVar;
    }

    public void q(ArrayList<PhotoCategorySummaryInfo> arrayList) {
        this.D = arrayList;
        notifyDataSetChanged();
    }

    private void p(ImageView imageView, PhotoCategorySinglePicInfo photoCategorySinglePicInfo) {
        int i3;
        if (imageView != null) {
            if (((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama() && ((i3 = photoCategorySinglePicInfo.singlePicInfo.flag) == 32 || i3 == 16)) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        g gVar;
        if (view == null) {
            gVar = new g();
            View inflate = LayoutInflater.from(this.f42825d).inflate(R.layout.bmf, (ViewGroup) null);
            e(gVar, inflate);
            inflate.setTag(gVar);
            view2 = inflate;
        } else {
            view2 = view;
            gVar = (g) view.getTag();
        }
        i(gVar, i3);
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }
}
