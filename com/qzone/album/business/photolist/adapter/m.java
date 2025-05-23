package com.qzone.album.business.photolist.adapter;

import NS_MOBILE_MATERIAL.CustomAlbumItem;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.PhotoFrameView;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qzone.album.business.photolist.adapter.h;
import com.qzone.album.business.photolist.adapter.m;
import com.qzone.album.business.photolist.ui.listitem.BigPhotoView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.NinePatchRefDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes39.dex */
public class m extends h {

    /* renamed from: d0, reason: collision with root package name */
    private boolean f42707d0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AbsListView.RecyclerListener {
        a() {
        }

        @Override // com.tencent.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            com.qzone.proxy.feedcomponent.b.a("BigPhotoListAdapter", "Big onMovedToScrapHeap");
            e eVar = (e) view.getTag();
            eVar.f42695a.d();
            eVar.f42719e.setBackgroundDrawable(null);
            eVar.f42696b.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends QZoneAlbumUtil.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f42709d;

        b(e eVar) {
            this.f42709d = eVar;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f42709d.f42698d.setBackgroundDrawable(drawable);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f42709d.f42698d.getLayoutParams();
            layoutParams.width = u4.a.z().o(drawable.getIntrinsicWidth() / 2);
            layoutParams.height = u4.a.z().o(drawable.getIntrinsicHeight() / 2);
            layoutParams.gravity = 17;
            this.f42709d.f42698d.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends QZoneAlbumUtil.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f42711d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PhotoCacheData f42712e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f42713f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f42714h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ PhotoCacheData[] f42715i;

        c(e eVar, PhotoCacheData photoCacheData, int i3, int i16, PhotoCacheData[] photoCacheDataArr) {
            this.f42711d = eVar;
            this.f42712e = photoCacheData;
            this.f42713f = i3;
            this.f42714h = i16;
            this.f42715i = photoCacheDataArr;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Drawable newDrawable;
            if (drawable instanceof NinePatchRefDrawable) {
                newDrawable = ((NinePatchRefDrawable) drawable).newInstance();
            } else if (drawable instanceof BitmapRefDrawable) {
                newDrawable = ((BitmapRefDrawable) drawable).newDrawable();
            } else {
                newDrawable = drawable.getConstantState().newDrawable();
            }
            Rect rect = new Rect();
            newDrawable.getPadding(rect);
            BigPhotoView bigPhotoView = this.f42711d.f42695a;
            m mVar = m.this;
            bigPhotoView.f(mVar.f42651d, rect, this.f42712e, mVar.f42653f, mVar.f42654h);
            ViewGroup.LayoutParams layoutParams = this.f42711d.f42719e.getLayoutParams();
            layoutParams.width = m.this.f42655i;
            layoutParams.height = this.f42711d.f42695a.a() + rect.bottom + rect.top;
            this.f42711d.f42719e.setLayoutParams(layoutParams);
            this.f42711d.f42719e.setBackgroundDrawable(newDrawable);
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                this.f42711d.f42695a.setContentDescription(com.qzone.util.l.a(R.string.f171656k14) + ((this.f42713f - this.f42714h) + 1) + ", " + com.qzone.album.util.g.d(this.f42715i[0].uploadtime * 1000));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d extends QZoneAlbumUtil.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f42717d;

        d(e eVar) {
            this.f42717d = eVar;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Drawable newDrawable;
            if (drawable instanceof NinePatchRefDrawable) {
                newDrawable = ((NinePatchRefDrawable) drawable).newInstance();
            } else if (drawable instanceof BitmapRefDrawable) {
                newDrawable = ((BitmapRefDrawable) drawable).newDrawable();
            } else {
                newDrawable = drawable.getConstantState().newDrawable();
            }
            this.f42717d.f42696b.setBackgroundDrawable(newDrawable);
            Rect rect = new Rect();
            newDrawable.getPadding(rect);
            this.f42717d.f42696b.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class e extends h.d {

        /* renamed from: e, reason: collision with root package name */
        private View f42719e;
    }

    public m(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
        this.f42707d0 = VasNormalToggle.QZONE_PHOTO_NEW_IMAGE_SWITCH.isEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit U(FastDynamicDrawable fastDynamicDrawable, e eVar, PhotoCacheData photoCacheData, int i3, int i16, PhotoCacheData[] photoCacheDataArr, com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        Rect rect = new Rect();
        fastDynamicDrawable.getPadding(rect);
        eVar.f42695a.f(this.f42651d, rect, photoCacheData, this.f42653f, this.f42654h);
        ViewGroup.LayoutParams layoutParams = eVar.f42719e.getLayoutParams();
        layoutParams.width = this.f42655i;
        layoutParams.height = eVar.f42695a.a() + rect.bottom + rect.top;
        eVar.f42719e.setLayoutParams(layoutParams);
        eVar.f42719e.setBackgroundDrawable(fastDynamicDrawable);
        if (!com.qzone.adapter.feedcomponent.i.H().S0()) {
            return null;
        }
        eVar.f42695a.setContentDescription(com.qzone.util.l.a(R.string.f171656k14) + ((i3 - i16) + 1) + ", " + com.qzone.album.util.g.d(photoCacheDataArr[0].uploadtime * 1000));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit W(e eVar, FastDynamicDrawable fastDynamicDrawable, com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        eVar.f42696b.setBackgroundDrawable(fastDynamicDrawable);
        Rect rect = new Rect();
        fastDynamicDrawable.getPadding(rect);
        eVar.f42696b.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        return null;
    }

    private void Y(e eVar, View view, int i3) {
        ArrayList<PhotoFrameView> d16 = com.qzone.album.util.b.d(this.f42651d.g());
        if (d16 == null || d16.isEmpty()) {
            return;
        }
        PhotoFrameView photoFrameView = d16.get(i3 % d16.size());
        PhotoCacheData[] photoCacheDataArr = (PhotoCacheData[]) getItem(i3);
        if (photoCacheDataArr == null || photoCacheDataArr.length == 0) {
            return;
        }
        a0(eVar, photoCacheDataArr[0]);
        Z(eVar, photoFrameView, photoCacheDataArr);
        N(photoCacheDataArr[0], eVar, i3);
        M(photoCacheDataArr[0], eVar, i3);
        X(eVar, i3, photoFrameView, photoCacheDataArr, 0);
    }

    @Override // com.qzone.album.business.photolist.adapter.h
    public void L(x4.a aVar) {
        if (aVar.getListView() != null) {
            com.qzone.proxy.feedcomponent.b.a("BigPhotoListAdapter", "setRecyclerListener");
            aVar.getListView().setRecyclerListener(new a());
        }
    }

    protected void S(e eVar, View view) {
        super.K(eVar, view);
        eVar.f42697c = (ViewGroup) view.findViewById(R.id.fre);
        FeedDate feedDate = (FeedDate) view.findViewById(R.id.jlb);
        eVar.f42698d = feedDate;
        feedDate.a(false);
        eVar.f42696b = (CellTextView) view.findViewById(R.id.fob);
        eVar.f42719e = view.findViewById(R.id.a8k);
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        this.K = true;
        if (QZoneAlbumUtil.B(this.I)) {
            o(list);
            list = H(this.I);
        }
        return super.a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
        kVar.C(750);
        kVar.B(264);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
        kVar.C(750);
        kVar.B(264);
    }

    private void a0(e eVar, PhotoCacheData photoCacheData) {
        long j3;
        if (photoCacheData != null && photoCacheData.timevisible) {
            eVar.f42698d.a(false);
            eVar.f42698d.setVisibility(0);
            if (QZoneAlbumUtil.B(this.I)) {
                j3 = photoCacheData.shoottime;
            } else {
                j3 = photoCacheData.uploadtime;
            }
            eVar.f42698d.setTextSize(14.0f);
            eVar.f42698d.setText(new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(Long.valueOf(j3 * 1000)));
            CustomAlbumItem e16 = com.qzone.album.util.b.e(this.f42651d.g());
            if (e16 == null || e16.stBgImage == null) {
                return;
            }
            eVar.f42698d.setTextColor((int) e16.iTextColor);
            QZoneAlbumUtil.F(e16.stBgImage.strUrl, new b(eVar));
            return;
        }
        eVar.f42698d.setVisibility(8);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        e eVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bmd, (ViewGroup) null);
            eVar = new e();
            S(eVar, view);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        try {
            this.f42687c0.add(new WeakReference<>(eVar));
            Y(eVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("BigPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    private void Z(final e eVar, PhotoFrameView photoFrameView, PhotoCacheData[] photoCacheDataArr) {
        PhotoCacheData photoCacheData;
        MaterialFile materialFile;
        if (photoCacheDataArr != null && (photoCacheData = photoCacheDataArr[0]) != null && photoCacheData.descvisible && !TextUtils.isEmpty(photoCacheData.desc)) {
            eVar.f42696b.setRichText(photoCacheDataArr[0].desc);
            eVar.f42696b.setVisibility(0);
            if (photoFrameView != null) {
                eVar.f42696b.setTextColor((int) photoFrameView.iTextColor);
            }
            if (photoFrameView != null && (materialFile = photoFrameView.stBgImageText) != null) {
                if (this.f42707d0) {
                    final FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().e(QidPagView.DESIGN_PAG_WIDTH, 132).g(new a.c() { // from class: com.qzone.album.business.photolist.adapter.i
                        @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                        public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                            m.V(kVar);
                        }
                    }).l(VasDynamicDrawableCache.INSTANCE).k(photoFrameView.stBgImageText.strUrl).a();
                    a16.c0(new Function1() { // from class: com.qzone.album.business.photolist.adapter.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit W;
                            W = m.W(m.e.this, a16, (com.tencent.cachedrawable.dynamicdrawable.d) obj);
                            return W;
                        }
                    });
                } else {
                    QZoneAlbumUtil.E(materialFile.strUrl, this.f42655i, new d(eVar));
                }
            }
        } else {
            eVar.f42696b.setVisibility(8);
        }
        if (!this.C && this.E && photoCacheDataArr != null && photoCacheDataArr[0] != null) {
            eVar.f42696b.setClickable(true);
            eVar.f42696b.setOnClickListener(this.f42651d.r(photoCacheDataArr[0]));
        }
        if (eVar.f42696b.getVisibility() == 8 && eVar.f42698d.getVisibility() == 8) {
            eVar.f42697c.setVisibility(8);
        } else {
            eVar.f42697c.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void X(final e eVar, int i3, PhotoFrameView photoFrameView, final PhotoCacheData[] photoCacheDataArr, int i16) {
        final int i17;
        String str;
        String str2;
        PhotoCacheData photoCacheData;
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            int i18 = i3;
            while (i18 >= 0) {
                PhotoCacheData[] photoCacheDataArr2 = (PhotoCacheData[]) getItem(i18);
                if (photoCacheDataArr2 != null && photoCacheDataArr2.length > 0 && (photoCacheData = photoCacheDataArr2[0]) != null && photoCacheData.timevisible) {
                    break;
                } else {
                    i18--;
                }
            }
            i17 = i18 * this.f42652e;
        } else {
            i17 = i16;
        }
        int i19 = this.f42652e;
        final int i26 = i3 * i19;
        eVar.f42695a.setTag(Integer.valueOf(i19 * i3));
        PhotoCacheData photoCacheData2 = photoCacheDataArr.length > 0 ? photoCacheDataArr[0] : null;
        if (photoCacheData2 == null) {
            eVar.f42695a.setVisibility(4);
            return;
        }
        if (photoFrameView != null) {
            PhotoCacheData photoCacheData3 = photoCacheDataArr[0];
            if (photoCacheData3 != null && photoCacheData3.descvisible && !TextUtils.isEmpty(photoCacheData3.desc)) {
                MaterialFile materialFile = photoFrameView.stBgImagePhoto;
                str2 = materialFile != null ? materialFile.strUrl : null;
            } else {
                MaterialFile materialFile2 = photoFrameView.stBgImagePhotoOnly;
                String str3 = materialFile2 != null ? materialFile2.strUrl : null;
                if (TextUtils.isEmpty(str3)) {
                    str2 = photoFrameView.stBgImagePhoto.strUrl;
                } else {
                    str = str3;
                    if (!TextUtils.isEmpty(str)) {
                        if (this.f42707d0) {
                            final FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().e(QidPagView.DESIGN_PAG_WIDTH, 132).g(new a.c() { // from class: com.qzone.album.business.photolist.adapter.k
                                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                                public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                                    m.T(kVar);
                                }
                            }).l(VasDynamicDrawableCache.INSTANCE).k(str).a();
                            final PhotoCacheData photoCacheData4 = photoCacheData2;
                            a16.c0(new Function1() { // from class: com.qzone.album.business.photolist.adapter.l
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit U;
                                    U = m.this.U(a16, eVar, photoCacheData4, i26, i17, photoCacheDataArr, (com.tencent.cachedrawable.dynamicdrawable.d) obj);
                                    return U;
                                }
                            });
                        } else {
                            QZoneAlbumUtil.E(str, this.f42655i, new c(eVar, photoCacheData2, i26, i17, photoCacheDataArr));
                        }
                    }
                }
            }
            str = str2;
            if (!TextUtils.isEmpty(str)) {
            }
        }
        eVar.f42695a.setOnClickListener(null);
        eVar.f42695a.setOnLongClickListener(null);
        if (this.C) {
            eVar.f42695a.setClickable(false);
            eVar.f42695a.setOnClickListener(this.f42651d.a(this.f42652e * i3, photoCacheData2.fakeType));
        } else {
            if (!photoCacheData2.isFakePhoto()) {
                eVar.f42695a.setOnClickListener(this.V);
                eVar.f42695a.setOnLongClickListener(this.W);
            }
            eVar.f42695a.setClickable(true);
        }
    }
}
