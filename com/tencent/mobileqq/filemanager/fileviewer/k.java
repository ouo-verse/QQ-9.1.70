package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.net.URL;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class k extends BaseAdapter implements com.tencent.mobileqq.activity.photo.c {

    /* renamed from: d, reason: collision with root package name */
    private Context f208319d;

    /* renamed from: e, reason: collision with root package name */
    private List<FileBrowserModelBase.b> f208320e;

    /* renamed from: f, reason: collision with root package name */
    private int f208321f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f208322h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f208323i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f208324m = null;
    private SparseArray<URLDrawable> C = new SparseArray<>();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        URLImageView f208325a;

        /* renamed from: b, reason: collision with root package name */
        TextView f208326b;

        /* renamed from: c, reason: collision with root package name */
        ProgressBar f208327c = null;

        a() {
        }
    }

    public k(Context context) {
        this.f208319d = context;
        this.f208321f = context.getResources().getDisplayMetrics().densityDpi;
        this.f208322h = context.getResources().getDrawable(R.drawable.h7n);
        this.f208323i = context.getResources().getDrawable(R.drawable.common_loading6);
    }

    private void c(View view, URLDrawable uRLDrawable, int i3) {
        int i16 = 3;
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 8) {
                    i16 = 0;
                }
            } else {
                i16 = 1;
            }
        } else {
            i16 = 2;
        }
        boolean z16 = !uRLDrawable.isAnim();
        view.setTag(Gallery.ID_CHILD_ROTATEABLE, Boolean.valueOf(z16));
        if (z16) {
            view.setTag(Gallery.ID_DEFAULT_ROTATE, Integer.valueOf(i16));
        }
    }

    public int a(String str, FileBrowserModelBase.b bVar) {
        try {
            if (q.f(str)) {
                return JpegExifReader.readOrientation(str);
            }
        } catch (Throwable th5) {
            QLog.e("FileViewerGalleryAdapter", 1, th5, new Object[0]);
        }
        return bVar.getOrientation();
    }

    public void b(List<FileBrowserModelBase.b> list) {
        this.f208320e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FileBrowserModelBase.b> list = this.f208320e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<FileBrowserModelBase.b> list = this.f208320e;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f208319d).inflate(R.layout.ams, (ViewGroup) null);
            aVar = new a();
            aVar.f208325a = (URLImageView) view.findViewById(R.id.image);
            aVar.f208326b = (TextView) view.findViewById(R.id.jmp);
            aVar.f208327c = (ProgressBar) view.findViewById(R.id.g1o);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        FileBrowserModelBase.b bVar = (FileBrowserModelBase.b) getItem(i3);
        if (bVar == null) {
            aVar.f208325a.setImageDrawable(this.f208322h);
        } else {
            URL imageUrl = bVar.getImageUrl();
            int imageType = bVar.getImageType();
            if (imageUrl != null) {
                Drawable drawable = this.f208323i;
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = this.f208322h;
                obtain.mPlayGifImage = true;
                obtain.mUseExifOrientation = false;
                URLDrawable drawable2 = URLDrawable.getDrawable(imageUrl, obtain);
                drawable2.setTargetDensity(this.f208321f);
                aVar.f208325a.setImageDrawable(drawable2);
                if (bVar.isLoading()) {
                    aVar.f208327c.setVisibility(0);
                } else {
                    aVar.f208327c.setVisibility(4);
                }
                c(view, drawable2, a(imageUrl.getFile(), bVar));
                if (imageType == 1 && AsyncImageView.j(imageUrl) && q.p(bVar.e())) {
                    drawable2.setTag(1);
                    this.C.put(i3, drawable2);
                } else {
                    this.C.remove(i3);
                }
            } else {
                aVar.f208325a.setImageDrawable(this.f208322h);
                if (!bVar.b()) {
                    aVar.f208326b.setVisibility(0);
                    view.setTag(Gallery.ID_USER_DEFINE_SCALE, Float.valueOf(1.0f));
                }
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public View onCreateView(int i3, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onDestroyView(int i3, View view, ViewGroup viewGroup) {
        URLDrawable uRLDrawable = this.C.get(i3);
        if (uRLDrawable != null) {
            if (uRLDrawable.getStatus() == 0) {
                uRLDrawable.cancelDownload(true);
            }
            this.C.remove(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        URLDrawable uRLDrawable = this.C.get(i3);
        if (uRLDrawable != null) {
            uRLDrawable.updateRegionBitmap(regionDrawableData);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onSlot(int i3, View view, ViewGroup viewGroup) {
        System.gc();
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onscaleBegin(int i3, View view, ViewGroup viewGroup) {
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onViewDetached(int i3, View view, ViewGroup viewGroup, boolean z16) {
    }
}
