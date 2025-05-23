package com.qzone.album.business.photolist.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.business.albumlist.ui.VideoHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.event.QZoneFeedxLayerCommentEvent;
import com.qzone.reborn.event.QZoneFeedxLayerPraiseEvent;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.MergeProcessor;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes39.dex */
public class QZonePersonalAlbumRecentAdapter extends com.qzone.album.business.photolist.adapter.c implements SimpleEventReceiver {
    private j C;
    public ArrayList<PhotoCacheData> F;
    private int G;
    private Rect I;
    private f J;

    /* renamed from: d, reason: collision with root package name */
    private Context f42610d;

    /* renamed from: e, reason: collision with root package name */
    private int f42611e;

    /* renamed from: f, reason: collision with root package name */
    private int f42612f = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f42613h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f42614i = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f42615m = 50;
    private ArrayList<g> D = new ArrayList<>();
    private ArrayList<i> E = new ArrayList<>();
    private int K = -1;
    private View.OnClickListener L = new a();
    private long H = com.qzone.album.env.common.a.m().s();

    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0) {
                if (QZonePersonalAlbumRecentAdapter.this.J != null) {
                    f fVar = QZonePersonalAlbumRecentAdapter.this.J;
                    QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter = QZonePersonalAlbumRecentAdapter.this;
                    fVar.a(view, qZonePersonalAlbumRecentAdapter.X(qZonePersonalAlbumRecentAdapter.D), intValue);
                }
            } else {
                com.qzone.proxy.feedcomponent.b.c("QZonePersonalAlbumRecentAdapter", "clickPos is invalid: " + intValue);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42619d;

        b(int i3) {
            this.f42619d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePersonalAlbumRecentAdapter.this.J != null) {
                ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
                if (QZonePersonalAlbumRecentAdapter.this.D != null) {
                    Iterator it = QZonePersonalAlbumRecentAdapter.this.D.iterator();
                    while (it.hasNext()) {
                        g gVar = (g) it.next();
                        if (gVar != null) {
                            arrayList.add(gVar.f42627a);
                        }
                    }
                }
                QZonePersonalAlbumRecentAdapter.this.J.a(view, arrayList, this.f42619d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() > 0 && (viewGroup.getChildAt(0) instanceof CheckBox)) {
                    viewGroup.getChildAt(0).performClick();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42622d;

        d(int i3) {
            this.f42622d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) view;
                boolean isChecked = checkBox.isChecked();
                if (isChecked) {
                    QZonePersonalAlbumRecentAdapter.this.f42614i++;
                } else {
                    QZonePersonalAlbumRecentAdapter.this.f42614i--;
                }
                if (QZonePersonalAlbumRecentAdapter.this.f42614i > QZonePersonalAlbumRecentAdapter.this.f42615m) {
                    checkBox.setChecked(false);
                    QZonePersonalAlbumRecentAdapter.this.f42614i--;
                    ToastUtil.r(String.format(QZonePersonalAlbumRecentAdapter.this.f42610d.getString(R.string.gr5), Integer.valueOf(QZonePersonalAlbumRecentAdapter.this.f42615m)));
                } else {
                    int i3 = this.f42622d;
                    ((g) QZonePersonalAlbumRecentAdapter.this.D.get(i3)).f42628b = isChecked;
                    if (isChecked) {
                        QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter = QZonePersonalAlbumRecentAdapter.this;
                        if (qZonePersonalAlbumRecentAdapter.F == null) {
                            qZonePersonalAlbumRecentAdapter.F = new ArrayList<>();
                        }
                        QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter2 = QZonePersonalAlbumRecentAdapter.this;
                        qZonePersonalAlbumRecentAdapter2.F.add(((g) qZonePersonalAlbumRecentAdapter2.D.get(i3)).f42627a);
                    } else {
                        QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter3 = QZonePersonalAlbumRecentAdapter.this;
                        ArrayList<PhotoCacheData> arrayList = qZonePersonalAlbumRecentAdapter3.F;
                        if (arrayList != null && arrayList.contains(((g) qZonePersonalAlbumRecentAdapter3.D.get(i3)).f42627a)) {
                            QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter4 = QZonePersonalAlbumRecentAdapter.this;
                            qZonePersonalAlbumRecentAdapter4.F.remove(((g) qZonePersonalAlbumRecentAdapter4.D.get(i3)).f42627a);
                        }
                    }
                }
                if (QZonePersonalAlbumRecentAdapter.this.C != null) {
                    QZonePersonalAlbumRecentAdapter.this.C.onSelectedChanged(QZonePersonalAlbumRecentAdapter.this.f42614i);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public interface f {
        void a(View view, ArrayList<PhotoCacheData> arrayList, int i3);
    }

    /* loaded from: classes39.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        public PhotoCacheData f42627a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42628b;

        public g(PhotoCacheData photoCacheData, boolean z16) {
            this.f42627a = photoCacheData;
            this.f42628b = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup f42630a;

        /* renamed from: b, reason: collision with root package name */
        public int f42631b;

        /* renamed from: c, reason: collision with root package name */
        public VideoHeaderCell f42632c;

        /* renamed from: d, reason: collision with root package name */
        public ViewGroup[] f42633d;

        /* renamed from: e, reason: collision with root package name */
        public AsyncImageView[] f42634e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup[] f42635f;

        /* renamed from: g, reason: collision with root package name */
        public TextView[] f42636g;

        /* renamed from: h, reason: collision with root package name */
        public ViewGroup[] f42637h;

        /* renamed from: i, reason: collision with root package name */
        public TextView[] f42638i;

        /* renamed from: j, reason: collision with root package name */
        public ImageView[] f42639j;

        /* renamed from: k, reason: collision with root package name */
        public TextView[] f42640k;

        /* renamed from: l, reason: collision with root package name */
        public ViewGroup[] f42641l;

        /* renamed from: m, reason: collision with root package name */
        public CheckBox[] f42642m;

        /* renamed from: n, reason: collision with root package name */
        public TextView[] f42643n;

        /* renamed from: o, reason: collision with root package name */
        public ImageView[] f42644o;

        public h(View view, int i3) {
            this.f42630a = (ViewGroup) view.findViewById(1);
            this.f42632c = (VideoHeaderCell) view.findViewById(200);
            this.f42633d = new ViewGroup[i3];
            this.f42634e = new AsyncImageView[i3];
            this.f42635f = new ViewGroup[i3];
            this.f42636g = new TextView[i3];
            this.f42637h = new ViewGroup[i3];
            this.f42638i = new TextView[i3];
            this.f42639j = new ImageView[i3];
            this.f42640k = new TextView[i3];
            this.f42641l = new ViewGroup[i3];
            this.f42642m = new CheckBox[i3];
            this.f42643n = new TextView[i3];
            this.f42644o = new ImageView[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                this.f42633d[i16] = (ViewGroup) view.findViewById(i16 + 400);
                this.f42634e[i16] = (AsyncImageView) view.findViewById(i16 + 500);
                this.f42635f[i16] = (ViewGroup) view.findViewById(i16 + 600);
                this.f42636g[i16] = (TextView) view.findViewById(i16 + 700);
                this.f42637h[i16] = (ViewGroup) view.findViewById(i16 + 800);
                this.f42638i[i16] = (TextView) view.findViewById(i16 + 900);
                this.f42639j[i16] = (ImageView) view.findViewById(i16 + 1000);
                this.f42640k[i16] = (TextView) view.findViewById(i16 + 1100);
                this.f42641l[i16] = (ViewGroup) view.findViewById(i16 + 1200);
                this.f42642m[i16] = (CheckBox) view.findViewById(i16 + 1300);
                this.f42643n[i16] = (TextView) view.findViewById(i16 + 1400);
                this.f42644o[i16] = (ImageView) view.findViewById(i16 + 1500);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private final int f42645a;

        /* renamed from: b, reason: collision with root package name */
        private g[] f42646b;

        /* renamed from: c, reason: collision with root package name */
        private int[] f42647c;

        /* renamed from: d, reason: collision with root package name */
        private int f42648d = 0;

        public i(int i3) {
            this.f42645a = i3;
            this.f42646b = new g[i3];
            this.f42647c = new int[i3];
        }

        public void a(g gVar, int i3) {
            int i16 = this.f42648d;
            if (i16 < this.f42645a) {
                this.f42646b[i16] = gVar;
                this.f42647c[i16] = i3;
                this.f42648d = i16 + 1;
            }
        }

        public g b(int i3) {
            if (i3 < this.f42648d) {
                return this.f42646b[i3];
            }
            return null;
        }

        public int c(int i3) {
            if (i3 < this.f42648d) {
                return this.f42647c[i3];
            }
            return -1;
        }

        public boolean d() {
            return this.f42648d == 0;
        }

        public boolean e() {
            return this.f42648d == this.f42645a;
        }

        public int f() {
            return this.f42648d;
        }
    }

    /* loaded from: classes39.dex */
    public interface j {
        void onSelectedChanged(int i3);
    }

    public QZonePersonalAlbumRecentAdapter(Context context, List<PhotoCacheData> list, int i3, j jVar) {
        this.f42611e = 1;
        this.f42610d = context;
        this.f42611e = i3;
        if (list != null && !list.isEmpty()) {
            if (list.size() > 0) {
                QZLog.d("QZonePersonalAlbumRecentAdapter", 2, "setAdapterData size : " + list.size());
                this.D.clear();
                Iterator<PhotoCacheData> it = list.iterator();
                while (it.hasNext()) {
                    this.D.add(new g(it.next(), false));
                }
            } else {
                this.D.clear();
            }
            n();
            o();
        }
        if (jVar != null && this.f42611e == 2) {
            this.C = jVar;
        }
        this.G = l();
        this.I = QzoneConfig.getInstance().getGifDisplayConfig();
    }

    private void B(final QZoneFeedxLayerCommentEvent qZoneFeedxLayerCommentEvent) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                PhotoCacheData photoCacheData;
                QZoneFeedxLayerCommentEvent qZoneFeedxLayerCommentEvent2 = qZoneFeedxLayerCommentEvent;
                if (qZoneFeedxLayerCommentEvent2 == null) {
                    return;
                }
                String str = qZoneFeedxLayerCommentEvent2.lloc;
                if (QZonePersonalAlbumRecentAdapter.this.D == null || QZonePersonalAlbumRecentAdapter.this.D.isEmpty()) {
                    return;
                }
                for (int i3 = 0; i3 < QZonePersonalAlbumRecentAdapter.this.D.size(); i3++) {
                    g gVar = (g) QZonePersonalAlbumRecentAdapter.this.D.get(i3);
                    if (gVar != null && (photoCacheData = gVar.f42627a) != null && TextUtils.equals(photoCacheData.lloc, str)) {
                        gVar.f42627a.cmtnum++;
                        return;
                    }
                }
            }
        });
    }

    private void C(final QZoneFeedxLayerPraiseEvent qZoneFeedxLayerPraiseEvent) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                PhotoCacheData photoCacheData;
                QZoneFeedxLayerPraiseEvent qZoneFeedxLayerPraiseEvent2 = qZoneFeedxLayerPraiseEvent;
                if (qZoneFeedxLayerPraiseEvent2 == null) {
                    return;
                }
                boolean z16 = qZoneFeedxLayerPraiseEvent2.isPraise;
                int i3 = qZoneFeedxLayerPraiseEvent2.likeNum;
                String str = qZoneFeedxLayerPraiseEvent2.lloc;
                if (QZonePersonalAlbumRecentAdapter.this.D == null || QZonePersonalAlbumRecentAdapter.this.D.isEmpty()) {
                    return;
                }
                for (int i16 = 0; i16 < QZonePersonalAlbumRecentAdapter.this.D.size(); i16++) {
                    g gVar = (g) QZonePersonalAlbumRecentAdapter.this.D.get(i16);
                    if (gVar != null && (photoCacheData = gVar.f42627a) != null && TextUtils.equals(photoCacheData.lloc, str)) {
                        PhotoCacheData photoCacheData2 = gVar.f42627a;
                        photoCacheData2.mylike = z16 ? 1 : 0;
                        photoCacheData2.likenum = i3;
                        return;
                    }
                }
            }
        });
    }

    private View E(int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f42610d);
        relativeLayout.setId(i3 + 1200);
        relativeLayout.setBackgroundResource(R.color.ajr);
        CheckBox checkBox = new CheckBox(this.f42610d);
        checkBox.setId(i3 + 1300);
        checkBox.setBackgroundResource(R.drawable.f162296bw1);
        checkBox.setButtonDrawable(this.f42610d.getResources().getDrawable(17170445));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ar.e(22.0f), ar.e(22.0f));
        layoutParams.setMargins(ar.e(11.0f), ar.e(11.0f), ar.e(11.0f), ar.e(11.0f));
        relativeLayout.addView(checkBox, layoutParams);
        return relativeLayout;
    }

    private View F(int i3) {
        LinearLayout linearLayout = new LinearLayout(this.f42610d);
        linearLayout.setId(i3 + 800);
        linearLayout.setOrientation(0);
        ImageView imageView = new ImageView(this.f42610d);
        imageView.setAdjustViewBounds(false);
        imageView.setImageResource(R.drawable.fvm);
        TextView textView = new TextView(this.f42610d);
        textView.setId(i3 + 900);
        textView.setTextSize(12.0f);
        textView.setTextColor(-1);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ar.e(13.0f), ar.e(13.0f));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = ar.e(6.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = ar.e(2.0f);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View G() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f42610d);
        relativeLayout.setId(1);
        VideoHeaderCell videoHeaderCell = new VideoHeaderCell(this.f42610d);
        videoHeaderCell.setId(200);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = ar.e(3.0f);
        relativeLayout.addView(videoHeaderCell, layoutParams);
        relativeLayout.setBackgroundResource(R.color.ajr);
        return relativeLayout;
    }

    private View H() {
        LinearLayout linearLayout = new LinearLayout(this.f42610d);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ar.e(44.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(G(), layoutParams);
        linearLayout.addView(I(), layoutParams2);
        linearLayout.setBackgroundResource(R.color.ajr);
        return linearLayout;
    }

    private View I() {
        LinearLayout linearLayout = new LinearLayout(this.f42610d);
        linearLayout.setOrientation(0);
        for (int i3 = 0; i3 < q(); i3++) {
            int i16 = this.G;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i16);
            if (i3 != q() - 1) {
                layoutParams.rightMargin = ar.e(2.0f);
            }
            layoutParams.bottomMargin = ar.e(2.0f);
            linearLayout.addView(K(i3), layoutParams);
        }
        return linearLayout;
    }

    private View J(int i3) {
        TextView textView = new TextView(this.f42610d);
        textView.setId(i3 + 1100);
        textView.setGravity(17);
        textView.setTextSize(10.0f);
        textView.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setSize(ar.e(30.0f), ar.e(18.0f));
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, ar.e(2.0f), ar.e(2.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(1291845632);
        textView.setBackgroundDrawable(gradientDrawable);
        return textView;
    }

    private View K(int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f42610d);
        relativeLayout.setId(i3 + 400);
        relativeLayout.setOnClickListener(this.L);
        AsyncImageView asyncImageView = new AsyncImageView(this.f42610d);
        asyncImageView.setId(i3 + 500);
        asyncImageView.setAdjustViewBounds(false);
        com.qzone.album.util.c.b(asyncImageView);
        asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int i16 = this.G;
        asyncImageView.setAsyncClipSize(i16, i16);
        MergeProcessor mergeProcessor = new MergeProcessor();
        int i17 = this.G;
        mergeProcessor.addProcessor(new NewGifDrawableSpecifiedRegionProcessor(i17, i17, this.I));
        asyncImageView.setAsyncImageProcessor(mergeProcessor);
        relativeLayout.addView(asyncImageView, new RelativeLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this.f42610d);
        imageView.setId(i3 + 1500);
        imageView.setImageResource(R.drawable.gai);
        imageView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ar.e(4.0f);
        layoutParams.leftMargin = ar.e(4.0f);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        relativeLayout.addView(imageView, layoutParams);
        int i18 = this.f42611e;
        if (i18 == 1 || i18 == 3) {
            ImageView imageView2 = new ImageView(this.f42610d);
            imageView2.setId(i3 + 1000);
            imageView2.setAdjustViewBounds(false);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setImageResource(R.drawable.gik);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ar.e(30.0f), ar.e(18.0f));
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.bottomMargin = ar.e(4.0f);
            layoutParams4.addRule(9);
            layoutParams4.addRule(12);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.alignWithParent = true;
            layoutParams5.bottomMargin = ar.e(4.0f);
            layoutParams5.addRule(11);
            layoutParams5.addRule(12);
            relativeLayout.addView(imageView2, layoutParams2);
            relativeLayout.addView(J(i3), layoutParams3);
            View F = F(i3);
            relativeLayout.addView(F, layoutParams4);
            layoutParams5.addRule(1, F.getId());
            relativeLayout.addView(L(i3), layoutParams5);
        } else if (i18 == 2) {
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(ar.e(44.0f), ar.e(44.0f));
            layoutParams6.addRule(11);
            layoutParams6.addRule(10);
            TextView textView = new TextView(this.f42610d);
            textView.setId(i3 + 1400);
            textView.setTextSize(12.0f);
            textView.setTextColor(-1);
            textView.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeShared", "\u5171\u4eab"));
            textView.setIncludeFontPadding(false);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.rightMargin = ar.e(9.5f);
            layoutParams7.bottomMargin = ar.e(7.0f);
            layoutParams7.addRule(11);
            layoutParams7.addRule(12);
            relativeLayout.addView(E(i3), layoutParams6);
            relativeLayout.addView(textView, layoutParams7);
        }
        return relativeLayout;
    }

    private View L(int i3) {
        LinearLayout linearLayout = new LinearLayout(this.f42610d);
        linearLayout.setId(i3 + 600);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.f42610d);
        textView.setId(i3 + 700);
        textView.setGravity(85);
        textView.setTextSize(12.0f);
        textView.setTextColor(-1);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = ar.e(9.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = ar.e(9.0f);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private void T(h hVar, int i3) {
        if (D(i3)) {
            hVar.f42632c.a(this.f42610d);
            hVar.f42632c.b(t(i3, 0).f42627a);
            hVar.f42630a.setVisibility(0);
            hVar.f42630a.setLayoutParams(new LinearLayout.LayoutParams(-2, ar.e(55.0f)));
            return;
        }
        hVar.f42630a.setVisibility(8);
    }

    private void U(h hVar, int i3) {
        T(hVar, i3);
        V(hVar, i3);
    }

    private void V(h hVar, int i3) {
        int i16;
        i r16 = r(i3);
        for (int i17 = 0; i17 < r16.f() && i17 < q(); i17++) {
            g b16 = r16.b(i17);
            if (b16 != null) {
                int i18 = this.f42611e;
                if (i18 == 2) {
                    P(hVar, i17, b16);
                } else if (i18 == 1 || i18 == 3) {
                    W(hVar, i17, b16.f42627a);
                }
            }
            int c16 = r16.c(i17);
            hVar.f42633d[i17].setTag(Integer.valueOf(c16));
            hVar.f42633d[i17].setVisibility(0);
            if (AppSetting.f99565y && b16 != null) {
                hVar.f42633d[i17].setContentDescription(com.qzone.util.l.a(R.string.s1s) + (c16 + 1) + ", " + com.qzone.album.util.g.d(b16.f42627a.uploadtime * 1000));
            }
            ImageView imageView = hVar.f42644o[i17];
            if (imageView != null) {
                if (b16 != null && b16.f42627a != null) {
                    if (((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama() && ((i16 = b16.f42627a.flag) == 16 || i16 == 32)) {
                        hVar.f42644o[i17].setVisibility(0);
                    } else {
                        hVar.f42644o[i17].setVisibility(8);
                    }
                } else {
                    imageView.setVisibility(8);
                }
            }
            if (this.f42611e == 2) {
                hVar.f42633d[i17].setOnClickListener(new b(c16));
                hVar.f42641l[i17].setOnClickListener(new c());
                hVar.f42642m[i17].setChecked(this.D.get(c16).f42628b);
                hVar.f42642m[i17].setOnClickListener(new d(c16));
            }
        }
        for (int f16 = r16.f(); f16 < q(); f16++) {
            hVar.f42633d[f16].setVisibility(8);
        }
    }

    private void W(h hVar, int i3, PhotoCacheData photoCacheData) {
        VideoInfo videoInfo;
        boolean j3 = com.qzone.album.env.common.a.m().j();
        boolean z16 = true;
        hVar.f42634e[i3].setNeedGifStream(photoCacheData.isGifPhoto() && j3);
        if (photoCacheData.videoflag == 1 && (videoInfo = photoCacheData.videodata) != null) {
            PictureUrl pictureUrl = videoInfo.coverUrl;
            if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                hVar.f42634e[i3].setAsyncImage(photoCacheData.videodata.coverUrl.url);
            } else {
                hVar.f42634e[i3].setAsyncImage(s(photoCacheData));
            }
            if (photoCacheData.isFakePhoto()) {
                hVar.f42636g[i3].setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumVideoProcessing", "\u89c6\u9891\u5904\u7406\u4e2d..."));
            } else {
                hVar.f42636g[i3].setTextAppearance(this.f42610d, R.style.f173794ks);
                hVar.f42636g[i3].setText(A(photoCacheData.videodata.videoTime));
            }
            hVar.f42635f[i3].setVisibility(0);
        } else {
            hVar.f42634e[i3].setAsyncImage(s(photoCacheData));
            hVar.f42635f[i3].setVisibility(8);
        }
        int i16 = photoCacheData.cmtnum;
        if (i16 > 0) {
            hVar.f42638i[i3].setText(String.valueOf(i16));
            hVar.f42637h[i3].setVisibility(0);
        } else {
            hVar.f42637h[i3].setVisibility(8);
            z16 = false;
        }
        if (z16) {
            hVar.f42639j[i3].setVisibility(0);
        } else {
            hVar.f42639j[i3].setVisibility(8);
        }
        if (photoCacheData.isGifPhoto() && !j3) {
            hVar.f42640k[i3].setText("GIF");
            hVar.f42640k[i3].setVisibility(0);
        } else if (photoCacheData.isLongPhoto()) {
            hVar.f42640k[i3].setText(com.qzone.util.l.a(R.string.s1z));
            hVar.f42640k[i3].setVisibility(0);
        } else {
            hVar.f42640k[i3].setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PhotoCacheData> X(ArrayList<g> arrayList) {
        ArrayList<PhotoCacheData> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().f42627a);
            }
        }
        return arrayList2;
    }

    private void n() {
        Iterator<g> it = this.D.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
    }

    private void o() {
        this.E.clear();
        i iVar = new i(q());
        Calendar calendar = Calendar.getInstance();
        int i3 = -1;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = 0; i18 < this.D.size(); i18++) {
            g gVar = this.D.get(i18);
            calendar.setTimeInMillis(gVar.f42627a.uploadtime * 1000);
            int i19 = calendar.get(1);
            int i26 = calendar.get(2);
            int i27 = calendar.get(5);
            if (this.f42611e == 3) {
                if (i19 != i3 || i26 != i17 || i27 != i16) {
                    if (!iVar.d()) {
                        this.E.add(iVar);
                    }
                    iVar = new i(q());
                    i3 = i19;
                    i17 = i26;
                    i16 = i27;
                }
            } else if (i19 != i3 || i26 != i17) {
                if (!iVar.d()) {
                    this.E.add(iVar);
                }
                iVar = new i(q());
                i3 = i19;
                i17 = i26;
            }
            if (iVar.e()) {
                this.E.add(iVar);
                iVar = new i(q());
            }
            iVar.a(gVar, i18);
        }
        if (iVar.d()) {
            return;
        }
        this.E.add(iVar);
    }

    private int q() {
        if (this.K <= 0) {
            this.K = pl.a.f426446a.d(this.f42610d, ar.e(2.0f), 3);
        }
        return this.K;
    }

    public void M(boolean z16) {
        ArrayList<g> arrayList;
        this.f42613h = z16;
        if (z16 || (arrayList = this.D) == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            this.D.get(i3).f42628b = false;
            this.f42614i = 0;
        }
    }

    public void N(int i3) {
        this.f42615m = i3;
    }

    public void O(f fVar) {
        this.J = fVar;
    }

    public void S(int i3) {
        this.f42614i = i3;
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void b(Configuration configuration) {
        this.G = l();
        notifyDataSetChanged();
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void c() {
        super.c();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.E.size();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxLayerPraiseEvent.class);
        arrayList.add(QZoneFeedxLayerCommentEvent.class);
        return arrayList;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public int l() {
        int l3;
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            l3 = ar.k();
        } else {
            l3 = ar.l();
        }
        return (l3 - (ar.e(2.0f) * (q() - 1))) / q();
    }

    public void m() {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.clear();
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedxLayerPraiseEvent) {
            C((QZoneFeedxLayerPraiseEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QZoneFeedxLayerCommentEvent) {
            B((QZoneFeedxLayerCommentEvent) simpleBaseEvent);
        }
    }

    public ArrayList<g> p() {
        return this.D;
    }

    public PhotoCacheData v(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            if (this.D.get(i3) != null && this.D.get(i3).f42627a != null && str.equals(this.D.get(i3).f42627a.unikey)) {
                return this.D.get(i3).f42627a;
            }
        }
        return null;
    }

    public PhotoCacheData w(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (int i3 = 0; i3 < this.D.size(); i3++) {
                if (this.D.get(i3) != null && this.D.get(i3).f42627a != null && str.equals(this.D.get(i3).f42627a.albumid) && str2.equals(this.D.get(i3).f42627a.lloc)) {
                    return this.D.get(i3).f42627a;
                }
            }
        }
        return null;
    }

    public ArrayList<PhotoCacheData> x(String str) {
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            if (this.D.get(i3) != null && this.D.get(i3).f42627a != null && str.equals(this.D.get(i3).f42627a.pssUgcKey)) {
                arrayList.add(this.D.get(i3).f42627a);
            }
        }
        return arrayList;
    }

    public ArrayList<PhotoCacheData> y() {
        ArrayList<g> arrayList = this.D;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        ArrayList<PhotoCacheData> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            if (this.D.get(i3).f42628b) {
                arrayList2.add(this.D.get(i3).f42627a);
            }
        }
        return arrayList2;
    }

    public ArrayList<PhotoCacheData> z() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements AsyncImageable.AsyncImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f42624d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f42625e;

        e(h hVar, int i3) {
            this.f42624d = hVar;
            this.f42625e = i3;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            WeakReference<Drawable> weakReference;
            if (asyncImageable == null || !this.f42624d.f42634e[this.f42625e].equals(asyncImageable)) {
                return;
            }
            ImageLoader.Options downloadFailedOptions = this.f42624d.f42634e[this.f42625e].getDownloadFailedOptions();
            if (downloadFailedOptions != null && (weakReference = downloadFailedOptions.watermarkDrawableRef) != null && weakReference.get() != null) {
                boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_ALBUM_WATER_PIC, 1) == 1;
                QZLog.d("QZonePersonalAlbumRecentAdapter", 1, "onImageFailed enableAlbumWaterPic:" + z16);
                if (z16) {
                    this.f42624d.f42634e[this.f42625e].setImageDrawable(downloadFailedOptions.watermarkDrawableRef.get());
                    return;
                }
                return;
            }
            QZLog.d("QZonePersonalAlbumRecentAdapter", 1, "onImageFailed options or options.watermarkDrawableRef is null");
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return t(i3, 0);
    }

    private i r(int i3) {
        if (i3 >= 0 && i3 < this.E.size()) {
            return this.E.get(i3);
        }
        return new i(q());
    }

    private g t(int i3, int i16) {
        if (i3 >= 0 && i3 < this.E.size()) {
            return this.E.get(i3).b(i16);
        }
        return new g(null, false);
    }

    public void Q(List<PhotoCacheData> list, int i3) {
        if (list != null && list.size() > 0) {
            QZLog.d("QZonePersonalAlbumRecentAdapter", 2, "setAdapterData size : " + list.size());
            this.D.clear();
            Iterator<PhotoCacheData> it = list.iterator();
            while (it.hasNext()) {
                this.D.add(new g(it.next(), false));
            }
        } else {
            this.D.clear();
        }
        this.f42612f = i3;
        n();
        o();
    }

    public void R(List<PhotoCacheData> list, int i3, ArrayList<PhotoCacheData> arrayList) {
        boolean z16;
        if (list != null && list.size() > 0) {
            QZLog.d("QZonePersonalAlbumRecentAdapter", 2, "setAdapterData size : " + list.size());
            this.D.clear();
            if (arrayList != null) {
                int i16 = 0;
                for (PhotoCacheData photoCacheData : list) {
                    int i17 = i16;
                    while (true) {
                        if (i17 >= arrayList.size()) {
                            z16 = false;
                            break;
                        } else {
                            if (photoCacheData.currentUrl.equals(arrayList.get(i17).currentUrl)) {
                                i16++;
                                z16 = true;
                                break;
                            }
                            i17++;
                        }
                    }
                    this.D.add(new g(photoCacheData, z16));
                }
            } else {
                Iterator<PhotoCacheData> it = list.iterator();
                while (it.hasNext()) {
                    this.D.add(new g(it.next(), false));
                }
            }
        } else {
            this.D.clear();
        }
        this.f42612f = i3;
        n();
        o();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        h hVar;
        if (view != null) {
            hVar = (h) view.getTag();
        } else {
            view = H();
            hVar = new h(view, q());
            hVar.f42631b = this.G;
            view.setTag(hVar);
        }
        if (hVar.f42631b != this.G) {
            view = H();
            hVar = new h(view, q());
            hVar.f42631b = this.G;
            view.setTag(hVar);
        }
        U(hVar, i3);
        view.setFocusable(true);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public PhotoCacheData u(int i3) {
        if (i3 < 0 || i3 >= this.D.size()) {
            return null;
        }
        return this.D.get(i3).f42627a;
    }

    private boolean D(int i3) {
        if (i3 == 0) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(t(i3, 0).f42627a.uploadtime * 1000);
        int i16 = calendar.get(1);
        int i17 = calendar.get(2);
        int i18 = calendar.get(5);
        calendar.setTimeInMillis(t(i3 - 1, 0).f42627a.uploadtime * 1000);
        int i19 = calendar.get(1);
        int i26 = calendar.get(2);
        return this.f42611e == 3 ? (i16 == i19 && i17 == i26 && i18 == calendar.get(5)) ? false : true : (i16 == i19 && i17 == i26) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P(h hVar, int i3, g gVar) {
        String str;
        PhotoCacheData photoCacheData;
        if (gVar != null) {
            PhotoCacheData photoCacheData2 = gVar.f42627a;
            if (photoCacheData2 != null) {
                if (this.f42612f == 1 && this.f42613h) {
                    if (!TextUtils.isEmpty(photoCacheData2.faceInfoUrl)) {
                        str = gVar.f42627a.faceInfoUrl;
                    } else {
                        QZLog.d("QZonePersonalAlbumRecentAdapter", 4, "faceinfourl is null");
                        str = "";
                    }
                } else if (!TextUtils.isEmpty(photoCacheData2.currentUrl)) {
                    str = gVar.f42627a.currentUrl;
                } else if (!TextUtils.isEmpty(gVar.f42627a.middleUrl)) {
                    str = gVar.f42627a.middleUrl;
                } else if (!TextUtils.isEmpty(gVar.f42627a.bigUrl)) {
                    str = gVar.f42627a.bigUrl;
                } else if (!TextUtils.isEmpty(gVar.f42627a.smallUrl)) {
                    str = gVar.f42627a.smallUrl;
                }
                com.qzone.album.util.c.b(hVar.f42634e[i3]);
                hVar.f42634e[i3].setScaleType(ImageView.ScaleType.CENTER_CROP);
                hVar.f42634e[i3].setAsyncPriority(true);
                AsyncImageView asyncImageView = hVar.f42634e[i3];
                int i16 = this.G;
                asyncImageView.setAsyncClipSize(i16, i16);
                hVar.f42634e[i3].setAsyncImage(str);
                hVar.f42634e[i3].setAsyncImageListener(new e(hVar, i3));
                photoCacheData = gVar.f42627a;
                if (photoCacheData == null && this.H == photoCacheData.uploadUin) {
                    hVar.f42643n[i3].setVisibility(8);
                } else {
                    hVar.f42643n[i3].setVisibility(0);
                }
                if (!this.f42613h) {
                    hVar.f42641l[i3].setVisibility(0);
                    hVar.f42642m[i3].setVisibility(0);
                    return;
                } else {
                    hVar.f42641l[i3].setVisibility(8);
                    hVar.f42642m[i3].setVisibility(8);
                    return;
                }
            }
            str = null;
            com.qzone.album.util.c.b(hVar.f42634e[i3]);
            hVar.f42634e[i3].setScaleType(ImageView.ScaleType.CENTER_CROP);
            hVar.f42634e[i3].setAsyncPriority(true);
            AsyncImageView asyncImageView2 = hVar.f42634e[i3];
            int i162 = this.G;
            asyncImageView2.setAsyncClipSize(i162, i162);
            hVar.f42634e[i3].setAsyncImage(str);
            hVar.f42634e[i3].setAsyncImageListener(new e(hVar, i3));
            photoCacheData = gVar.f42627a;
            if (photoCacheData == null) {
            }
            hVar.f42643n[i3].setVisibility(0);
            if (!this.f42613h) {
            }
        } else {
            hVar.f42634e[i3].setVisibility(8);
            hVar.f42643n[i3].setVisibility(8);
            hVar.f42641l[i3].setVisibility(8);
            hVar.f42642m[i3].setVisibility(8);
        }
    }

    private String s(PhotoCacheData photoCacheData) {
        if (photoCacheData == null) {
            return null;
        }
        if (photoCacheData.isGifPhoto() && com.qzone.album.env.common.a.m().j() && !TextUtils.isEmpty(photoCacheData.bigUrl)) {
            return photoCacheData.bigUrl;
        }
        if (!TextUtils.isEmpty(photoCacheData.currentUrl)) {
            return photoCacheData.currentUrl;
        }
        if (!TextUtils.isEmpty(photoCacheData.thumbUrl)) {
            return photoCacheData.thumbUrl;
        }
        if (!TextUtils.isEmpty(photoCacheData.smallUrl)) {
            return photoCacheData.smallUrl;
        }
        if (!TextUtils.isEmpty(photoCacheData.middleUrl)) {
            return photoCacheData.middleUrl;
        }
        if (!TextUtils.isEmpty(photoCacheData.bigUrl)) {
            return photoCacheData.bigUrl;
        }
        if (TextUtils.isEmpty(photoCacheData.orgUrl)) {
            return null;
        }
        return photoCacheData.orgUrl;
    }

    private String A(long j3) {
        StringBuilder sb5;
        String str;
        int i3;
        Object obj;
        if (j3 >= 60000) {
            int round = (int) Math.round(((j3 % 60000) * 1.0d) / 1000.0d);
            if (round >= 60) {
                i3 = round / 60;
                round %= 60;
            } else {
                i3 = 0;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append((j3 / 60000) + i3);
            sb6.append(":");
            if (round > 9) {
                obj = Integer.valueOf(round);
            } else {
                obj = "0" + round;
            }
            sb6.append(obj);
            return sb6.toString();
        }
        int round2 = (int) Math.round((j3 * 1.0d) / 1000.0d);
        if (round2 > 9) {
            sb5 = new StringBuilder();
            str = "0:";
        } else {
            sb5 = new StringBuilder();
            str = "0:0";
        }
        sb5.append(str);
        sb5.append(round2);
        return sb5.toString();
    }
}
