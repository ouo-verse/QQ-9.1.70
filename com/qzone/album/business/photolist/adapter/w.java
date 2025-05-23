package com.qzone.album.business.photolist.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.misc.localphoto.ui.QZoneImageSwitchView;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import eo.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class w extends com.qzone.album.business.photolist.adapter.c {
    private static final int[] W = {0};
    public static int X = 2;
    private int C;
    private int D;
    private int E;
    private int F;
    private e K;
    private String L;
    private String M;
    private String N;
    private String P;
    private String Q;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42765d;

    /* renamed from: e, reason: collision with root package name */
    private Context f42766e;

    /* renamed from: f, reason: collision with root package name */
    private List<AlbumCacheData[]> f42767f;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f42768h;

    /* renamed from: i, reason: collision with root package name */
    private int f42769i;

    /* renamed from: m, reason: collision with root package name */
    private int f42770m;
    private final int G = 340;
    private final int H = 340;
    private final float I = 0.95f;
    private QZoneImageSwitchView J = null;
    private int R = 9999;
    private int S = 999;
    private int T = 999;
    private String U = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ALBUM_LIST_MAX_COUNT, QzoneConfig.DefaultValue.DEFAULT_ALBUM_LIST_MAX_COUNT);
    private View.OnClickListener V = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends ImageProcessor {

        /* renamed from: a, reason: collision with root package name */
        private SpecifiedSizeCropByPivotProcessor f42771a;

        /* renamed from: b, reason: collision with root package name */
        private RoundCornerProcessor f42772b = new RoundCornerProcessor(ar.e(4.0f));

        /* renamed from: c, reason: collision with root package name */
        private ScaleProcessor f42773c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f42774d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f42775e;

        a(float f16, float f17) {
            this.f42774d = f16;
            this.f42775e = f17;
            this.f42771a = new SpecifiedSizeCropByPivotProcessor(w.this.f42769i, w.this.f42770m, f16, f17);
            this.f42773c = new ScaleProcessor(w.this.f42769i, w.this.f42770m);
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return this.f42773c.process(this.f42772b.process(this.f42771a.process(drawable)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (w.this.K != null) {
                w.this.K.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements AbsListView.RecyclerListener {
        c() {
        }

        @Override // com.tencent.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            w.this.j(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d extends ImageProcessor {

        /* renamed from: a, reason: collision with root package name */
        private SpecifiedSizeCropByPivotProcessor f42779a;

        /* renamed from: b, reason: collision with root package name */
        private RoundCornerProcessor f42780b = new RoundCornerProcessor(ar.e(4.0f));

        /* renamed from: c, reason: collision with root package name */
        private ScaleProcessor f42781c;

        public d(int i3, int i16, float f16, float f17) {
            this.f42779a = new SpecifiedSizeCropByPivotProcessor(i3, i16, f16, f17);
            this.f42781c = new ScaleProcessor(i3, i16);
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return this.f42781c.process(this.f42780b.process(this.f42779a.process(drawable)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface e {
        void onClick(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        LinearLayout f42782a;

        /* renamed from: b, reason: collision with root package name */
        g[] f42783b = new g[w.X];

        /* renamed from: c, reason: collision with root package name */
        int f42784c;

        public f() {
            int i3 = 0;
            while (true) {
                g[] gVarArr = this.f42783b;
                if (i3 >= gVarArr.length) {
                    return;
                }
                gVarArr[i3] = new g();
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f42786a;

        /* renamed from: b, reason: collision with root package name */
        View f42787b;

        /* renamed from: c, reason: collision with root package name */
        View f42788c;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f42789d;

        /* renamed from: e, reason: collision with root package name */
        QZoneImageSwitchView f42790e;

        /* renamed from: f, reason: collision with root package name */
        View f42791f;

        /* renamed from: g, reason: collision with root package name */
        TextView f42792g;

        /* renamed from: h, reason: collision with root package name */
        QUIBadge f42793h;

        /* renamed from: i, reason: collision with root package name */
        TextView f42794i;

        /* renamed from: j, reason: collision with root package name */
        TextView f42795j;

        /* renamed from: k, reason: collision with root package name */
        ImageView f42796k;

        /* renamed from: l, reason: collision with root package name */
        AsyncImageView f42797l;

        g() {
        }
    }

    public w(Context context, List<AlbumCacheData[]> list, int i3) {
        QZLog.d("QZonePersonalAlbumListAdapter", 1, "mColumnCount=" + i3);
        X = i3;
        if (context != null) {
            this.f42766e = context;
            o(com.qzone.album.env.common.a.m().v());
            this.f42768h = LayoutInflater.from(context);
        }
        if (list == null) {
            this.f42767f = new ArrayList();
        } else {
            this.f42767f = list;
        }
    }

    private void h(g gVar) {
        if (AlbumPersonalizeManager.L().Q()) {
            s5.a.m(gVar.f42792g);
            s5.a.k(gVar.f42794i);
            s5.a.k(gVar.f42795j);
        }
    }

    private boolean i() {
        AlbumCacheData albumCacheData;
        QZoneImageSwitchView qZoneImageSwitchView = this.J;
        return qZoneImageSwitchView != null && this.f42765d && (albumCacheData = (AlbumCacheData) qZoneImageSwitchView.getTag()) != null && albumCacheData.isToppedAlbum;
    }

    private void l(g gVar, ViewGroup viewGroup) {
        View inflate = this.f42768h.inflate(R.layout.hl_, viewGroup, false);
        gVar.f42786a = (RelativeLayout) inflate.findViewById(R.id.skx);
        gVar.f42789d = (RelativeLayout) inflate.findViewById(R.id.f164263sl1);
        gVar.f42790e = (QZoneImageSwitchView) inflate.findViewById(R.id.f164262sl0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gVar.f42789d.getLayoutParams();
        layoutParams.height = this.f42770m;
        gVar.f42789d.setLayoutParams(layoutParams);
        gVar.f42792g = (TextView) inflate.findViewById(R.id.skt);
        gVar.f42793h = (QUIBadge) inflate.findViewById(R.id.f657939w);
        gVar.f42794i = (TextView) inflate.findViewById(R.id.skz);
        gVar.f42795j = (TextView) inflate.findViewById(R.id.sks);
        gVar.f42796k = (ImageView) inflate.findViewById(R.id.sku);
        gVar.f42797l = (AsyncImageView) inflate.findViewById(R.id.skv);
        gVar.f42791f = inflate.findViewById(R.id.sky);
        gVar.f42787b = inflate.findViewById(R.id.skw);
        View findViewById = inflate.findViewById(R.id.f164264sl2);
        gVar.f42788c = findViewById;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        int i3 = (int) (this.f42769i * 0.95f);
        layoutParams2.width = i3;
        gVar.f42788c.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) gVar.f42787b.getLayoutParams();
        layoutParams3.width = (int) (i3 * 0.95f);
        gVar.f42787b.setLayoutParams(layoutParams3);
        viewGroup.addView(inflate);
    }

    private String m(boolean z16, int i3, int i16, int i17) {
        int i18 = this.R;
        if (i3 > i18) {
            i3 = i18;
        }
        if (z16) {
            return String.format(this.M, Integer.valueOf(i3));
        }
        if (!this.f42765d) {
            return String.format(this.L, Integer.valueOf(i3));
        }
        int i19 = this.S;
        if (i16 > i19) {
            i16 = i19;
        }
        int i26 = this.T;
        if (i17 > i26) {
            i17 = i26;
        }
        if (i16 > 0 && i17 > 0) {
            return String.format(this.N, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        if (i16 > 0) {
            return String.format(this.Q, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i17 > 0) {
            return String.format(this.P, Integer.valueOf(i3), Integer.valueOf(i17));
        }
        return String.format(this.L, Integer.valueOf(i3));
    }

    private String n(int i3, boolean z16) {
        if (z16 || i3 == 1) {
            return "";
        }
        return BusinessAlbumInfo.Privacy.getDescription(i3);
    }

    private void p(f fVar, ViewGroup viewGroup) {
        fVar.f42784c = this.F;
        fVar.f42782a = (LinearLayout) viewGroup.findViewById(R.id.hiu);
        fo.b bVar = new fo.b();
        bVar.h(new c.a());
        fo.c.o(fVar.f42782a, "em_qz_new_album", bVar);
        for (int i3 = 0; i3 < X; i3++) {
            l(fVar.f42783b[i3], viewGroup);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.C, this.D);
        layoutParams.setMargins(this.E, this.f42766e.getResources().getDimensionPixelSize(R.dimen.ao_), 0, 0);
        for (int i16 = 0; i16 < X; i16++) {
            fVar.f42783b[i16].f42786a.setLayoutParams(layoutParams);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.C, this.f42770m);
        layoutParams2.setMargins(this.E, this.f42766e.getResources().getDimensionPixelSize(R.dimen.ao_), 0, 0);
        fVar.f42782a.setLayoutParams(layoutParams2);
    }

    private void t() {
        if (i()) {
            LpReportInfo_pf00064.allReport(326, 1, 3);
            AlbumCacheData albumCacheData = (AlbumCacheData) this.J.getTag();
            if (albumCacheData != null && albumCacheData.coverUrlList != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<PictureUrl> it = albumCacheData.coverUrlList.iterator();
                while (it.hasNext()) {
                    PictureUrl next = it.next();
                    if (next != null) {
                        arrayList.add(next.url);
                    }
                }
                this.J.setData(arrayList);
            }
            v();
        }
    }

    private void x(g gVar, AlbumCacheData albumCacheData) {
        gVar.f42793h.setVisibility(8);
        if (albumCacheData.anonymity != 103) {
            return;
        }
        dh.a aVar = dh.a.f393805d;
        boolean p16 = aVar.p();
        QLog.i("QZ_QFS_QZonePersonalAlbumListAdapter", 1, "updateRedDotView, showQcircleEntranceRedDot=" + p16);
        if (p16) {
            gVar.f42793h.setVisibility(0);
            gVar.f42793h.setRedDot();
            if (gVar.f42786a.isAttachedToWindow()) {
                aVar.q(gVar.f42786a);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f42767f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f42767f.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i3);
        f fVar = null;
        if (view == null) {
            if (viewGroup != null) {
                o(viewGroup.getMeasuredWidth());
            }
            if (this.f42768h == null) {
                this.f42768h = LayoutInflater.from(this.f42766e);
            }
            if (itemViewType == 0) {
                f fVar2 = new f();
                ViewGroup viewGroup2 = (ViewGroup) this.f42768h.inflate(R.layout.f169025bo1, (ViewGroup) null);
                p(fVar2, viewGroup2);
                viewGroup2.setTag(fVar2);
                fVar = fVar2;
                view = viewGroup2;
            }
        } else if (itemViewType == 0) {
            fVar = (f) view.getTag();
        }
        if (itemViewType == 0) {
            if (fVar.f42784c != this.F) {
                p(fVar, (ViewGroup) view);
            }
            q(fVar);
            try {
                k(view, fVar, i3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return W.length;
    }

    public void o(int i3) {
        String[] split;
        if (i3 == 0 || i3 != this.F) {
            this.F = i3;
            Resources resources = this.f42766e.getResources();
            if (resources != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ao9);
                this.E = dimensionPixelSize;
                int i16 = this.F;
                int i17 = X;
                int i18 = (i16 - ((i17 + 1) * dimensionPixelSize)) / i17;
                this.C = i18;
                this.D = -2;
                this.f42769i = i18;
                this.f42770m = (i18 * 340) / 340;
                this.L = resources.getString(R.string.gb8);
                this.M = resources.getString(R.string.gb9);
                this.N = resources.getString(R.string.gb5);
                this.Q = resources.getString(R.string.gb6);
                this.P = resources.getString(R.string.gb7);
            }
            if (TextUtils.isEmpty(this.U) || (split = this.U.split(",")) == null || split.length < 3) {
                return;
            }
            try {
                this.R = Integer.parseInt(split[0]);
                this.S = Integer.parseInt(split[1]);
                this.T = Integer.parseInt(split[2]);
            } catch (NumberFormatException e16) {
                QZLog.e("QZonePersonalAlbumListAdapter", 2, "parse max count NumberFormatException ", e16);
                this.R = 9999;
                this.S = 999;
                this.T = 999;
            } catch (Exception e17) {
                QZLog.e("QZonePersonalAlbumListAdapter", 2, "parse max count exception ", e17);
                this.R = 9999;
                this.S = 999;
                this.T = 999;
            }
        }
    }

    public void r(boolean z16) {
        this.f42765d = z16;
    }

    public void v() {
        if (i()) {
            this.J.h();
        }
    }

    public void w() {
        if (i()) {
            this.J.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view) {
        f fVar;
        QZoneImageSwitchView qZoneImageSwitchView;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof f) || (fVar = (f) view.getTag()) == null) {
            return;
        }
        for (g gVar : fVar.f42783b) {
            if (gVar != null && (qZoneImageSwitchView = gVar.f42790e) != null) {
                qZoneImageSwitchView.f();
                gVar.f42790e.setAsyncImageProcessor(null);
            }
        }
    }

    private void q(f fVar) {
        LinearLayout linearLayout;
        RelativeLayout relativeLayout;
        if (fVar == null || (linearLayout = fVar.f42782a) == null) {
            return;
        }
        linearLayout.setVisibility(8);
        for (int i3 = 0; i3 < X; i3++) {
            g gVar = fVar.f42783b[i3];
            if (gVar != null && (relativeLayout = gVar.f42786a) != null) {
                relativeLayout.setVisibility(8);
            }
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void a(ListView listView) {
        if (listView == null || !com.qzone.reborn.configx.g.f53821a.b().x()) {
            return;
        }
        for (int i3 = 0; i3 < listView.getChildCount(); i3++) {
            View childAt = listView.getChildAt(i3);
            j(childAt);
            RFWLog.d("QZonePersonalAlbumListAdapter", RFWLog.USR, "doCancelImageRequest: " + childAt + ", position: " + i3);
        }
    }

    public void s(e eVar) {
        if (eVar != null) {
            this.K = eVar;
        }
    }

    public void u(QZonePullToRefreshListView qZonePullToRefreshListView) {
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.setRecyclerListener(new c());
        }
    }

    private void k(View view, f fVar, int i3) {
        AlbumCacheData[] albumCacheDataArr;
        int i16;
        if (fVar == null || (albumCacheDataArr = (AlbumCacheData[]) getItem(i3)) == null || albumCacheDataArr.length == 0) {
            return;
        }
        if (albumCacheDataArr.length == 2 && albumCacheDataArr[0] == null && albumCacheDataArr[1] == null) {
            return;
        }
        if (AlbumPersonalizeManager.L().P()) {
            fVar.f42782a.setBackgroundColor(1291845631);
            ((ImageView) fVar.f42782a.findViewById(R.id.hau)).setImageResource(R.drawable.fum);
            ((TextView) fVar.f42782a.findViewById(R.id.hav)).setTextColor(-1);
        } else {
            fVar.f42782a.setBackgroundColor(-657931);
            ((ImageView) fVar.f42782a.findViewById(R.id.hau)).setImageResource(R.drawable.fun);
            ((TextView) fVar.f42782a.findViewById(R.id.hav)).setTextColor(-7894119);
        }
        if (AlbumPersonalizeManager.L().Q()) {
            s5.a.g(fVar.f42782a);
            s5.a.e((ImageView) fVar.f42782a.findViewById(R.id.hau));
            s5.a.k((TextView) fVar.f42782a.findViewById(R.id.hav));
        }
        for (int i17 = 0; i17 < X; i17++) {
            AlbumCacheData albumCacheData = albumCacheDataArr[i17];
            if (albumCacheData == null) {
                if (!this.f42765d && i3 == 0) {
                    fVar.f42782a.setTag(QZoneOptAlbumRequest.FIELD_CMD_CREATE);
                    fVar.f42782a.setOnClickListener(this.V);
                    fVar.f42782a.setVisibility(0);
                    fVar.f42782a.setOutlineProvider(new z4.b(ar.e(5.0f)));
                    fVar.f42782a.setClipToOutline(true);
                }
            } else {
                QZoneImageSwitchView qZoneImageSwitchView = fVar.f42783b[i17].f42790e;
                qZoneImageSwitchView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                qZoneImageSwitchView.setAdjustViewBounds(false);
                qZoneImageSwitchView.setDefaultAndFailedImage();
                PictureUrl pictureUrl = albumCacheData.coverUrl;
                float f16 = pictureUrl.pivotXRate;
                float f17 = pictureUrl.pivotYRate;
                if (com.qzone.reborn.configx.g.f53821a.b().x()) {
                    qZoneImageSwitchView.setAsyncImageProcessor(new d(this.f42769i, this.f42770m, f16, f17));
                } else {
                    qZoneImageSwitchView.setAsyncImageProcessor(new a(f16, f17));
                }
                qZoneImageSwitchView.setAsyncClipSize(this.f42769i, this.f42770m);
                qZoneImageSwitchView.setInitImage(albumCacheData.getLloc());
                qZoneImageSwitchView.reset();
                String str = null;
                if (albumCacheData.isToppedAlbum && this.f42765d) {
                    this.J = qZoneImageSwitchView;
                    qZoneImageSwitchView.setTag(albumCacheData);
                    t();
                } else {
                    this.J = null;
                    qZoneImageSwitchView.i();
                }
                fVar.f42783b[i17].f42791f.setVisibility(0);
                if (albumCacheData.isToppedAlbum) {
                    fVar.f42783b[i17].f42791f.setBackgroundResource((QQTheme.isNowThemeIsNightForQzone() && AlbumPersonalizeManager.L().Q()) ? R.drawable.nwk : R.drawable.fvb);
                } else if (albumCacheData.isJustUploaded()) {
                    fVar.f42783b[i17].f42791f.setBackgroundResource((QQTheme.isNowThemeIsNightForQzone() && AlbumPersonalizeManager.L().Q()) ? R.drawable.nwq : R.drawable.fxj);
                } else {
                    fVar.f42783b[i17].f42791f.setVisibility(8);
                }
                int i18 = albumCacheData.anonymity;
                if (i18 == 5) {
                    str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeBaby", "\u4eb2\u5b50");
                    i16 = (QQTheme.isNowThemeIsNightForQzone() && AlbumPersonalizeManager.L().Q()) ? R.drawable.fv9 : R.drawable.fv8;
                } else if (i18 == 6) {
                    str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeTravel", "\u65c5\u6e38");
                    i16 = (QQTheme.isNowThemeIsNightForQzone() && AlbumPersonalizeManager.L().Q()) ? R.drawable.fva : R.drawable.fv_;
                } else if (i18 == 8) {
                    str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeLover", "\u60c5\u4fa3");
                    i16 = (QQTheme.isNowThemeIsNightForQzone() && AlbumPersonalizeManager.L().Q()) ? R.drawable.fv5 : R.drawable.f162178fv4;
                } else if (i18 != 9) {
                    if (QZoneAlbumUtil.t(albumCacheDataArr[i17].anonymity) == 1 && albumCacheDataArr[i17].individual == 1) {
                        str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypePersonal", "\u4e2a\u6027");
                        i16 = AlbumPersonalizeManager.L().P() ? R.drawable.f162177fv3 : R.drawable.f162176fv2;
                    } else {
                        i16 = 0;
                    }
                } else {
                    str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTypeMulti", "\u591a\u4eba");
                    i16 = (QQTheme.isNowThemeIsNightForQzone() && AlbumPersonalizeManager.L().Q()) ? R.drawable.fv7 : R.drawable.fv6;
                }
                if (!TextUtils.isEmpty(str) && i16 != 0) {
                    fVar.f42783b[i17].f42796k.setImageResource(i16);
                    fVar.f42783b[i17].f42796k.setVisibility(0);
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    fVar.f42783b[i17].f42796k.measure(makeMeasureSpec, makeMeasureSpec);
                    g gVar = fVar.f42783b[i17];
                    gVar.f42792g.setMaxWidth((this.f42769i - gVar.f42796k.getMeasuredWidth()) - this.f42766e.getResources().getDimensionPixelSize(R.dimen.ao5));
                } else {
                    fVar.f42783b[i17].f42796k.setVisibility(8);
                    fVar.f42783b[i17].f42792g.setMaxWidth(this.f42770m);
                }
                if (this.f42765d && !TextUtils.isEmpty(albumCacheData.albumTypeIcon)) {
                    fVar.f42783b[i17].f42797l.setVisibility(0);
                    fVar.f42783b[i17].f42797l.setAsyncImage(albumCacheData.albumTypeIcon);
                } else {
                    fVar.f42783b[i17].f42797l.setVisibility(8);
                }
                fVar.f42783b[i17].f42792g.setText(albumCacheDataArr[i17].albumname);
                h(fVar.f42783b[i17]);
                x(fVar.f42783b[i17], albumCacheDataArr[i17]);
                if (albumCacheData.albumtype != 21) {
                    int i19 = albumCacheData.anonymity;
                    if (i19 != 10) {
                        if (i19 != 101 && i19 != 103) {
                            fVar.f42783b[i17].f42794i.setText(m(false, albumCacheData.albumnum, albumCacheData.viewCount, albumCacheData.likeCount));
                        } else {
                            fVar.f42783b[i17].f42794i.setText(m(true, albumCacheData.albumnum, albumCacheData.viewCount, albumCacheData.likeCount));
                        }
                        fVar.f42783b[i17].f42794i.setVisibility(0);
                        String n3 = n(albumCacheData.albumrights, this.f42765d);
                        fVar.f42783b[i17].f42795j.setText(n3);
                        fVar.f42783b[i17].f42795j.setGravity(48);
                        AlbumPersonalizeManager.L().S(fVar.f42783b[i17].f42795j);
                        fVar.f42783b[i17].f42795j.setVisibility(TextUtils.isEmpty(n3) ? 8 : 0);
                    } else {
                        if (!this.f42765d) {
                            fVar.f42783b[i17].f42794i.setText(m(true, albumCacheData.albumnum, albumCacheData.viewCount, albumCacheData.likeCount));
                        } else {
                            fVar.f42783b[i17].f42794i.setText("");
                        }
                        fVar.f42783b[i17].f42795j.setVisibility(8);
                    }
                }
                AlbumPersonalizeManager.L().S(fVar.f42783b[i17].f42794i);
                fVar.f42783b[i17].f42786a.setTag(albumCacheData);
                fVar.f42783b[i17].f42786a.setOnClickListener(this.V);
                fVar.f42783b[i17].f42786a.setVisibility(0);
            }
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void b(Configuration configuration) {
    }
}
