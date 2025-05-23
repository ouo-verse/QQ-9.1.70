package com.tencent.biz.pubaccount.subscript;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c implements URLDrawable.URLDrawableListener {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<URLDrawable, a> f80094d = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<ImageView> f80095a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<b> f80096b;

        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        boolean a(ImageView imageView);
    }

    public void a() {
        this.f80094d.clear();
        this.f80094d = null;
    }

    public void b(Object obj, ImageView imageView, int i3, int i16, b bVar) {
        URLDrawable drawable;
        if (obj != null && (obj instanceof String)) {
            try {
                drawable = URLDrawableHelper.getDrawable((String) obj, i3, i16);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("SubscriptPicManager", 2, e16.toString());
                }
            }
        } else {
            if (obj != null && (obj instanceof URL)) {
                drawable = URLDrawableHelper.getDrawable((URL) obj, i3, i16);
            }
            drawable = null;
        }
        if (drawable == null) {
            return;
        }
        if (drawable.getStatus() != 1) {
            imageView.setTag(R.id.j7m, drawable.getURL());
            a aVar = new a();
            aVar.f80095a = new WeakReference<>(imageView);
            aVar.f80096b = new WeakReference<>(bVar);
            this.f80094d.put(drawable, aVar);
            drawable.setURLDrawableListener(this);
        }
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(drawable);
    }

    public void c(Object obj, ImageView imageView, int i3, int i16, b bVar, int i17) {
        URLDrawable drawable;
        if (obj != null && (obj instanceof String)) {
            try {
                drawable = URLDrawableHelper.getDrawable((String) obj);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("SubscriptPicManager", 2, e16.toString());
                }
            }
        } else {
            if (obj != null && (obj instanceof URL)) {
                drawable = URLDrawableHelper.getDrawable((URL) obj);
            }
            drawable = null;
        }
        if (drawable == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable.getStatus() != 1) {
            imageView.setTag(R.id.j7m, drawable.getURL());
            imageView.setTag(R.id.j7g, Boolean.TRUE);
            imageView.setTag(R.id.j7j, Integer.valueOf(i3));
            imageView.setTag(R.id.j7h, Integer.valueOf(i16));
            imageView.setTag(R.id.j7i, Integer.valueOf(i17));
            a aVar = new a();
            aVar.f80095a = new WeakReference<>(imageView);
            aVar.f80096b = new WeakReference<>(bVar);
            this.f80094d.put(drawable, aVar);
            drawable.setURLDrawableListener(this);
        }
        drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(i3, i16, (int) (i17 * ah.q())));
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(drawable);
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        a aVar;
        HashMap<URLDrawable, a> hashMap = this.f80094d;
        if (hashMap == null || uRLDrawable == null || (aVar = hashMap.get(uRLDrawable)) == null) {
            return;
        }
        this.f80094d.remove(uRLDrawable);
        ImageView imageView = aVar.f80095a.get();
        if (imageView != null && uRLDrawable.getURL().equals(imageView.getTag(R.id.j7m))) {
            b bVar = aVar.f80096b.get();
            if (bVar == null || bVar.a(imageView)) {
                if (imageView.getTag(R.id.j7g) != null && ((Boolean) imageView.getTag(R.id.j7g)).booleanValue()) {
                    uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(((Integer) imageView.getTag(R.id.j7j)).intValue(), ((Integer) imageView.getTag(R.id.j7h)).intValue(), (int) (((Integer) imageView.getTag(R.id.j7i)).intValue() * ah.q())));
                    uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                }
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(uRLDrawable);
                imageView.setTag(R.id.j7m, null);
            }
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
    }
}
