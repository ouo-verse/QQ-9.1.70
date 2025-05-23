package com.tencent.biz.qqcircle.immersive.manager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f87209d;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, Drawable> f87212c = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final IQCircleResDrawableApi f87210a = (IQCircleResDrawableApi) QRoute.api(IQCircleResDrawableApi.class);

    /* renamed from: b, reason: collision with root package name */
    private final a f87211b = new a(this);

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<View> f87214a;

        /* renamed from: b, reason: collision with root package name */
        private String f87215b;

        /* renamed from: c, reason: collision with root package name */
        private int f87216c = -1;

        /* renamed from: d, reason: collision with root package name */
        private boolean f87217d = false;

        /* renamed from: e, reason: collision with root package name */
        private String f87218e;

        public int a() {
            return this.f87216c;
        }

        public String b() {
            return this.f87218e;
        }

        public String c() {
            return this.f87215b;
        }

        public View d() {
            WeakReference<View> weakReference = this.f87214a;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public boolean e() {
            return this.f87217d;
        }

        public void f(int i3) {
            this.f87216c = i3;
        }

        public void g(String str) {
            this.f87218e = str;
        }

        public b h(String str) {
            this.f87215b = str;
            return this;
        }

        public b i(boolean z16) {
            this.f87217d = z16;
            return this;
        }

        public b j(View view) {
            this.f87214a = new WeakReference<>(view);
            return this;
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, b bVar) {
        String b16;
        if (view == null) {
            return;
        }
        Integer num = null;
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        } else if (view instanceof BaseWidgetView) {
            ((BaseWidgetView) view).setBackgroundDrawable(null);
        } else if (view instanceof FrameLayout) {
            ((FrameLayout) view).setBackgroundDrawable(null);
        } else if (view instanceof LinearLayout) {
            ((LinearLayout) view).setBackgroundDrawable(null);
        }
        if (QLog.isColorLevel()) {
            if (bVar == null) {
                b16 = null;
            } else {
                b16 = bVar.b();
            }
            if (bVar != null) {
                num = Integer.valueOf(bVar.a());
            }
            int intValue = num.intValue();
            QLog.d(e(), 2, "[freeGcBitmapOption] target view gc image drawable, fileName: " + b16 + " | drawableId: " + intValue + " | targetView: " + view);
        }
    }

    public static d c() {
        if (f87209d == null) {
            synchronized (d.class) {
                if (f87209d == null) {
                    f87209d = new d();
                }
            }
        }
        return f87209d;
    }

    private String e() {
        return "[PMC]-QFSLocalPictureRecyclerManager_" + hashCode();
    }

    private void j(@NonNull b bVar) {
        Resources resources;
        if (bVar == null) {
            QLog.e(e(), 1, "[loadLocalPathDrawableToView] option should not be null.");
            return;
        }
        View targetView = this.f87211b.getTargetView(bVar);
        if (!(targetView instanceof ImageView)) {
            QLog.e(e(), 1, "[loadLocalPathDrawableToView] not support view: " + targetView + ", end load flow.");
            return;
        }
        String c16 = bVar.c();
        if (TextUtils.isEmpty(c16)) {
            QLog.e(e(), 1, "[loadLocalPathDrawableToView] current path is empty, end flow");
            return;
        }
        File file = new File(c16);
        if (!file.exists()) {
            QLog.e(e(), 1, "[loadLocalPathDrawableToView] current path: " + c16 + ", not exists.");
            return;
        }
        this.f87211b.registerOption(bVar);
        String name = file.getName();
        bVar.g(name);
        Context context = targetView.getContext();
        if (context == null) {
            resources = null;
        } else {
            resources = context.getResources();
        }
        if (resources == null) {
            QLog.e(e(), 1, "[loadLocalPathDrawableToView] resources should not be null.");
            return;
        }
        ImageView imageView = (ImageView) targetView;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(resources.getColor(R.color.ajr));
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mRequestWidth = targetView.getMeasuredWidth();
        obtain.mRequestHeight = targetView.getMeasuredHeight();
        if (QLog.isColorLevel()) {
            QLog.d(e(), 2, "[loadLocalPathDrawableToView] requestWidth: " + obtain.mRequestWidth + " | requestHeight: " + obtain.mRequestHeight + " | fileName: " + name);
        }
        imageView.setImageDrawable(URLDrawable.getFileDrawable(c16, obtain));
    }

    private void k(@NonNull b bVar) {
        View targetView = this.f87211b.getTargetView(bVar);
        if (targetView == null) {
            QLog.e(e(), 1, "[loadLocalResIdDrawableToView] target view should not be null.");
            return;
        }
        int a16 = bVar.a();
        try {
            Drawable drawable = this.f87210a.getDrawable(a16);
            if (QLog.isColorLevel()) {
                QLog.d(e(), 2, "[loadLocalResIdDrawableToView] load res id: " + bVar.a());
            }
            if (targetView instanceof ImageView) {
                ((ImageView) targetView).setImageDrawable(drawable);
                this.f87211b.registerOption(bVar);
                return;
            }
            if (targetView instanceof BaseWidgetView) {
                ((BaseWidgetView) targetView).setBackgroundDrawable(drawable);
                this.f87211b.registerOption(bVar);
                return;
            }
            if (targetView instanceof FrameLayout) {
                ((FrameLayout) targetView).setBackgroundDrawable(drawable);
                this.f87211b.registerOption(bVar);
            } else {
                if (targetView instanceof LinearLayout) {
                    ((LinearLayout) targetView).setBackgroundDrawable(drawable);
                    this.f87211b.registerOption(bVar);
                    return;
                }
                QLog.d(e(), 1, "[loadLocalResIdDrawableToView] not support current view type" + targetView + ", end flow.");
            }
        } catch (Throwable th5) {
            QLog.e(e(), 1, "[loadLocalResIdDrawableToView] res id: " + a16 + ", error: ", th5);
        }
    }

    public Drawable d(int i3) {
        return this.f87210a.getDrawable(i3);
    }

    public void f() {
        this.f87211b.onHandlerMemoryClear();
    }

    public void g() {
        this.f87211b.onHandlerMemoryRestore();
    }

    public void h(b bVar) {
        if (bVar == null) {
            QLog.e(e(), 1, "[loadDrawableToImageView] option should not be null.");
        } else if (bVar.a() == -1) {
            j(bVar);
        } else {
            k(bVar);
        }
    }

    public void i(View view, int i3) {
        b bVar = new b();
        bVar.j(view).i(true).f(i3);
        h(bVar);
    }

    public void l() {
        m();
        this.f87211b.release();
        this.f87212c.clear();
    }

    public void m() {
        IQCircleResDrawableApi iQCircleResDrawableApi = this.f87210a;
        if (iQCircleResDrawableApi == null) {
            QLog.e(e(), 1, "[releaseResDrawable] release res drawable, not drawable api should not be null.");
        } else {
            iQCircleResDrawableApi.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBasePicLoaderRecycler<b> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f87213a;

        public a(d dVar) {
            this.f87213a = new WeakReference<>(dVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void freeGcBitmapOption(b bVar) {
            d dVar;
            WeakReference<d> weakReference = this.f87213a;
            if (weakReference == null) {
                dVar = null;
            } else {
                dVar = weakReference.get();
            }
            if (dVar != null) {
                dVar.b(getTargetView(bVar), bVar);
            } else {
                QLog.e("[PMC]-QFSLocalPictureRecyclerManager", 1, "[restoreOptionToBitmap] recycler manager should not be null.");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public View getTargetView(b bVar) {
            if (bVar == null) {
                return null;
            }
            return bVar.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean isSupportRecycler(b bVar) {
            Boolean valueOf;
            if (bVar == null) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(bVar.e());
            }
            return valueOf.booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void restoreOptionToBitmap(b bVar) {
            d dVar;
            WeakReference<d> weakReference = this.f87213a;
            if (weakReference == null) {
                dVar = null;
            } else {
                dVar = weakReference.get();
            }
            if (dVar == null) {
                QLog.e("[PMC]-QFSLocalPictureRecyclerManager", 1, "[restoreOptionToBitmap] recycler manager should not be null.");
                return;
            }
            View targetView = getTargetView(bVar);
            if ((targetView instanceof ViewGroup) && targetView.getBackground() == null) {
                dVar.h(bVar);
            } else if ((targetView instanceof ImageView) && ((ImageView) targetView).getDrawable() == null) {
                dVar.h(bVar);
            }
        }

        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        protected void onClearFinish() {
        }

        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        protected void onRestoreFinish() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onRegisterFinish(Integer num, b bVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onUnregisterFinish(Integer num, b bVar, boolean z16) {
        }
    }
}
