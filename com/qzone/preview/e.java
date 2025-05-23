package com.qzone.preview;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.common.galleryactivity.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.preview.b f49907d;

    /* renamed from: e, reason: collision with root package name */
    private BasePicureViewController f49908e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AbsListView.RecyclerListener {
        a() {
        }

        @Override // com.tencent.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof c)) {
                return;
            }
            c cVar = (c) tag;
            cVar.f49914a.cancelAsyncLoadImage();
            cVar.f49914a.setImageDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements AsyncImageable.AsyncImageListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<c> f49910d;

        /* renamed from: e, reason: collision with root package name */
        private PhotoInfo f49911e;

        /* renamed from: f, reason: collision with root package name */
        private int f49912f;

        public b(c cVar, PhotoInfo photoInfo, int i3) {
            this.f49910d = new WeakReference<>(cVar);
            this.f49911e = photoInfo;
            this.f49912f = i3;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            c cVar = this.f49910d.get();
            if (cVar == null) {
                QZLog.e("[PhotoAlbum]VerticalPictureAdapter", "onImageProgress: null == verticalPictureHolder");
            } else {
                cVar.f49916c.show();
                cVar.f49916c.start((int) f16);
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
            if (this.f49911e == null) {
                QZLog.e("[PhotoAlbum]VerticalPictureAdapter", "onImageStarted: photoInfo is null");
                return;
            }
            PhotoInfo photoInfo = this.f49911e;
            QZLog.d("[PhotoAlbum]VerticalPictureAdapter", 1, String.format("onImageStarted: position=%d, currentUrl=%s, bigUrl=%s, orgUrl=%s", Integer.valueOf(this.f49912f), photoInfo.currentUrl, photoInfo.bigUrl, photoInfo.orgUrl));
            c cVar = this.f49910d.get();
            if (cVar == null) {
                QZLog.e("[PhotoAlbum]VerticalPictureAdapter", "onImageStarted: null == verticalPictureHolder");
            } else {
                cVar.f49915b.setVisibility(0);
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            QZLog.d("[PhotoAlbum]VerticalPictureAdapter", 1, String.format("onImageFailed: position=%d", Integer.valueOf(this.f49912f)));
            c cVar = this.f49910d.get();
            if (cVar == null) {
                QZLog.e("[PhotoAlbum]VerticalPictureAdapter", "onImageFailed: null == verticalPictureHolder");
            } else {
                cVar.f49915b.setVisibility(8);
                cVar.f49916c.stop();
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            QZLog.d("[PhotoAlbum]VerticalPictureAdapter", 1, String.format("onImageLoaded: position=%d", Integer.valueOf(this.f49912f)));
            c cVar = this.f49910d.get();
            if (cVar == null) {
                QZLog.e("[PhotoAlbum]VerticalPictureAdapter", "onImageLoaded: null == verticalPictureHolder");
                return;
            }
            if (this.f49911e.heightWeightProportion == 0.0f && asyncImageable.getDrawable() != null) {
                this.f49911e.heightWeightProportion = (float) ((asyncImageable.getDrawable().getIntrinsicHeight() * 1.0d) / asyncImageable.getDrawable().getIntrinsicWidth());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.f49914a.getLayoutParams();
                QZLog.d("[PhotoAlbum]VerticalPictureAdapter", 1, "onImageLoaded photoInfo.heightWeightProportion:", Float.valueOf(this.f49911e.heightWeightProportion));
                if (this.f49911e.heightWeightProportion != 0.0f) {
                    layoutParams.height = (int) (ar.l() * this.f49911e.heightWeightProportion);
                }
                cVar.f49914a.setLayoutParams(layoutParams);
            }
            cVar.f49915b.setVisibility(8);
            cVar.f49916c.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public AsyncImageView f49914a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f49915b;

        /* renamed from: c, reason: collision with root package name */
        public l f49916c;

        c() {
        }
    }

    public e(com.qzone.preview.b bVar, BasePicureViewController basePicureViewController) {
        this.f49907d = bVar;
        this.f49908e = basePicureViewController;
        c();
    }

    private void b(c cVar, int i3) {
        String str;
        PhotoInfo photoInfo = (PhotoInfo) getItem(i3);
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.bigUrl)) {
            cVar.f49914a.setAsyncImageListener(new b(cVar, photoInfo, i3));
            cVar.f49914a.setNeedProgress(true);
            if (TextUtils.isEmpty(photoInfo.orgUrl)) {
                cVar.f49914a.setAsyncImage(photoInfo.bigUrl);
                return;
            }
            Boolean bool = photoInfo.hasLocalOrgFile;
            if (bool != null && bool.booleanValue()) {
                str = photoInfo.orgUrl;
            } else {
                str = photoInfo.bigUrl;
            }
            if (photoInfo.isPanorama()) {
                str = photoInfo.orgUrl;
            }
            cVar.f49914a.setAsyncImage(str);
            return;
        }
        QZLog.e("[PhotoAlbum]VerticalPictureAdapter", "loadImageData: bigUrl is empty");
    }

    private void c() {
        this.f49907d.getListView().setRecyclerListener(new a());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f49908e.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f49908e.getItem(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        PhotoInfo photoInfo = (PhotoInfo) getItem(i3);
        c cVar = new c();
        if (view == null) {
            view = LayoutInflater.from(this.f49907d.getHostActivity()).inflate(R.layout.bp5, (ViewGroup) null);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        a(cVar, view, photoInfo);
        b(cVar, i3);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    private void a(c cVar, View view, PhotoInfo photoInfo) {
        cVar.f49914a = (AsyncImageView) view.findViewById(R.id.f165764de0);
        cVar.f49915b = (ImageView) view.findViewById(R.id.g2g);
        l lVar = new l();
        cVar.f49916c = lVar;
        lVar.b(this.f49907d.getHostActivity(), cVar.f49915b);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.f49914a.getLayoutParams();
        QZLog.d("[PhotoAlbum]VerticalPictureAdapter", 1, "photoInfo.heightWeightProportion:", Float.valueOf(photoInfo.heightWeightProportion));
        if (photoInfo.heightWeightProportion != 0.0f) {
            layoutParams.height = (int) (ar.l() * photoInfo.heightWeightProportion);
        } else {
            layoutParams.height = ar.l();
        }
        cVar.f49914a.setLayoutParams(layoutParams);
        cVar.f49914a.setImageDrawable(null);
    }
}
