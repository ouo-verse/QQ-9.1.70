package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.util.f;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hr.e;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b<hr.e> implements View.OnClickListener {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class a extends LinearLayout {

        /* renamed from: d, reason: collision with root package name */
        private int f68573d;

        /* renamed from: e, reason: collision with root package name */
        private int f68574e;

        /* renamed from: f, reason: collision with root package name */
        private float f68575f;

        /* renamed from: h, reason: collision with root package name */
        private int f68576h;

        /* renamed from: i, reason: collision with root package name */
        private View.OnClickListener f68577i;

        /* renamed from: m, reason: collision with root package name */
        private final int f68578m;

        public a(Context context, int i3, int i16, float f16, View.OnClickListener onClickListener) {
            super(context);
            this.f68578m = 5;
            this.f68577i = onClickListener;
            this.f68573d = i3;
            this.f68574e = i16;
            this.f68575f = f16;
            int a16 = zr.a.a(getContext(), 6.0f);
            int i17 = this.f68573d;
            int i18 = this.f68574e;
            this.f68576h = (i17 - (((i18 - 1) * 2) * a16)) / i18;
            b();
        }

        public void a(hr.e eVar, int i3, int i16, boolean z16) {
            int i17 = this.f68574e;
            int i18 = i3 * i17;
            int b16 = i3 == i16 - 1 ? eVar.b() : i18 + i17;
            c(b16 - i18);
            for (int i19 = i18; i19 < b16; i19++) {
                View childAt = getChildAt(i19 - i18);
                View findViewById = childAt.findViewById(R.id.egl);
                URLImageView uRLImageView = (URLImageView) childAt.findViewById(R.id.egg);
                TextView textView = (TextView) childAt.findViewById(R.id.egm);
                ProgressBar progressBar = (ProgressBar) childAt.findViewById(R.id.egk);
                String g16 = eVar.g(i19);
                String d16 = eVar.d(i19);
                if (d16 == null) {
                    hd0.c.i("LocationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", eVar.toString());
                } else {
                    textView.setText(g16);
                    findViewById.setOnClickListener(this.f68577i);
                    uRLImageView.setTag(R.id.f166944jb1, Integer.valueOf(i19));
                    if (!z16) {
                        progressBar.setVisibility(4);
                        uRLImageView.setImageDrawable(null);
                    } else {
                        uRLImageView.setTag(R.id.jb9, d16);
                        uRLImageView.setTag(R.id.jai, Boolean.FALSE);
                        progressBar.setVisibility(0);
                        b bVar = new b(d16, uRLImageView, progressBar);
                        uRLImageView.setURLDrawableDownListener(bVar);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                        obtain.mFailedDrawable = drawable;
                        obtain.mLoadingDrawable = drawable;
                        obtain.mUseAutoScaleParams = false;
                        URLDrawable drawable2 = URLDrawable.getDrawable(d16, obtain);
                        if (drawable2.getStatus() == 1) {
                            bVar.onLoadSuccessed(uRLImageView, drawable2);
                        }
                        uRLImageView.setImageDrawable(z16 ? drawable2 : null);
                    }
                }
            }
        }

        private void b() {
            setOrientation(0);
            setGravity(17);
            int a16 = zr.a.a(getContext(), 12.0f);
            int i3 = (int) ((this.f68576h - (a16 * 2)) * this.f68575f);
            for (int i16 = 0; i16 < this.f68574e; i16++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167923mk, (ViewGroup) null);
                int i17 = this.f68576h;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i17, i17);
                if (i16 == 0) {
                    layoutParams.setMargins(0, a16, a16 / 2, 0);
                } else if (this.f68574e - 1 == i16) {
                    layoutParams.setMargins(a16 / 2, a16, 0, 0);
                } else {
                    int i18 = a16 / 2;
                    layoutParams.setMargins(i18, a16, i18, 0);
                }
                inflate.setLayoutParams(layoutParams);
                ((ImageView) inflate.findViewById(R.id.egg)).setPadding(i3, i3, i3, i3);
                addView(inflate);
            }
        }

        private void c(int i3) {
            for (int i16 = 0; i16 < i3 && i16 < getChildCount(); i16++) {
                getChildAt(i16).setVisibility(0);
            }
            while (i3 < this.f68574e && i3 < getChildCount()) {
                getChildAt(i3).setVisibility(4);
                i3++;
            }
        }
    }

    public e(Context context, FaceListPage faceListPage) {
        super(context, faceListPage);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.f68564e == 0) {
            view2 = view;
        } else {
            if (view == null) {
                aVar = new a(this.f68563d, viewGroup.getWidth(), ((hr.e) this.f68564e).a(), ((hr.e) this.f68564e).c(), this);
            } else {
                aVar = (a) view;
            }
            aVar.a((hr.e) this.f68564e, i3, getCount(), a());
            view2 = aVar;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        float f16;
        EventCollector.getInstance().onViewClickedBefore(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.egg);
        e.a aVar = ((hr.e) this.f68564e).f406043n.get(((Integer) imageView.getTag(R.id.f166944jb1)).intValue());
        Boolean bool = (Boolean) imageView.getTag(R.id.jai);
        if (bool != null && bool.booleanValue()) {
            Drawable drawable = imageView.getDrawable();
            aVar.f406050e = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int width = imageView.getWidth();
                int paddingLeft = imageView.getPaddingLeft();
                if (width > intrinsicWidth) {
                    f16 = ((((width - intrinsicWidth) / 2) - paddingLeft) * 2) + intrinsicWidth;
                } else {
                    f16 = intrinsicWidth - ((((intrinsicWidth - width) / 2) + paddingLeft) * 2);
                }
                float f17 = (float) ((f16 / intrinsicWidth) * ((hr.e) this.f68564e).f405998k);
                f.a a16 = f.a();
                this.f68565f.b(aVar, a16.f67202a, a16.f67203b, f17);
            }
        } else {
            hd0.c.a("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        private final String f68579d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<ImageView> f68580e;

        /* renamed from: f, reason: collision with root package name */
        private final WeakReference<ProgressBar> f68581f;

        public b(String str, ImageView imageView, ProgressBar progressBar) {
            this.f68579d = str;
            this.f68580e = new WeakReference<>(imageView);
            this.f68581f = new WeakReference<>(progressBar);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            hd0.c.a("LocationFaceAdapter", "onLoadCanceled,url:" + this.f68579d);
            ImageView imageView = this.f68580e.get();
            ProgressBar progressBar = this.f68581f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(4);
                imageView.setTag(R.id.jai, Boolean.FALSE);
            } else {
                hd0.c.a("LocationFaceAdapter", "onLoadCanceled error.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            hd0.c.a("LocationFaceAdapter", "onLoadFialed,url:" + this.f68579d);
            ImageView imageView = this.f68580e.get();
            ProgressBar progressBar = this.f68581f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(0);
                imageView.setTag(R.id.jai, Boolean.FALSE);
            } else {
                hd0.c.a("LocationFaceAdapter", "onLoadFialed error.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            hd0.c.a("LocationFaceAdapter", "onLoadProgressed,url:" + this.f68579d);
            ImageView imageView = this.f68580e.get();
            ProgressBar progressBar = this.f68581f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(0);
                imageView.setTag(R.id.jai, Boolean.FALSE);
            } else {
                hd0.c.a("LocationFaceAdapter", "onLoadProgressed error.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            hd0.c.a("LocationFaceAdapter", "onLoadSuccessed,url:" + this.f68579d);
            ImageView imageView = this.f68580e.get();
            ProgressBar progressBar = this.f68581f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(4);
                imageView.setTag(R.id.jai, Boolean.TRUE);
            } else {
                hd0.c.a("LocationFaceAdapter", "onLoadSuccessed error.");
            }
        }

        private boolean a(ImageView imageView) {
            String str = (String) imageView.getTag(R.id.jb9);
            return !TextUtils.isEmpty(str) && str.equals(this.f68579d);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }
    }
}
