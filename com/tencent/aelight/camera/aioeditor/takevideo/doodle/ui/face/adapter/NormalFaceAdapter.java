package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.capture.util.f;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hr.f;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NormalFaceAdapter extends com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b<f> implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name */
    private b.a<String, Drawable> f68550m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class b extends LinearLayout {

        /* renamed from: d, reason: collision with root package name */
        private int f68557d;

        /* renamed from: e, reason: collision with root package name */
        private int f68558e;

        /* renamed from: f, reason: collision with root package name */
        private int f68559f;

        /* renamed from: h, reason: collision with root package name */
        private View.OnClickListener f68560h;

        /* renamed from: i, reason: collision with root package name */
        private int f68561i;

        /* renamed from: m, reason: collision with root package name */
        private com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b f68562m;

        public b(Context context, int i3, int i16, float f16, View.OnClickListener onClickListener, com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b bVar) {
            super(context);
            this.f68560h = onClickListener;
            this.f68557d = i3;
            this.f68558e = i16;
            this.f68562m = bVar;
            int i17 = i3 / i16;
            int i18 = (int) (i17 * f16);
            this.f68559f = i18;
            this.f68561i = i17 - (i18 * 2);
            b();
        }

        private void b() {
            setOrientation(0);
            setGravity(17);
            int i3 = this.f68557d / this.f68558e;
            for (int i16 = 0; i16 < this.f68558e; i16++) {
                URLImageView uRLImageView = new URLImageView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                if (i16 == 0) {
                    layoutParams.leftMargin = zr.a.a(getContext(), 7.0f);
                }
                if (i16 == this.f68558e - 1) {
                    layoutParams.rightMargin = zr.a.a(getContext(), 7.0f);
                }
                uRLImageView.setLayoutParams(layoutParams);
                int i17 = this.f68559f;
                uRLImageView.setPadding(i17, i17, i17, i17);
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                addView(uRLImageView);
            }
        }

        private void c(int i3) {
            for (int i16 = 0; i16 < i3 && i16 < getChildCount(); i16++) {
                getChildAt(i16).setVisibility(0);
            }
            while (i3 < this.f68558e && i3 < getChildCount()) {
                getChildAt(i3).setVisibility(4);
                i3++;
            }
        }

        public void a(f fVar, int i3, int i16, boolean z16) {
            int i17 = this.f68558e;
            int i18 = i3 * i17;
            int b16 = i3 == i16 + (-1) ? fVar.b() : i18 + i17;
            c(b16 - i18);
            for (int i19 = i18; i19 < b16; i19++) {
                ImageView imageView = (ImageView) getChildAt(i19 - i18);
                imageView.setOnClickListener(this.f68560h);
                String d16 = fVar.d(i19);
                imageView.setTag(R.id.jb9, d16);
                imageView.setTag(R.id.f166944jb1, Integer.valueOf(i19));
                if (fVar.i(i19) == 1) {
                    if (getContext() instanceof EditPicActivity) {
                        String g16 = fVar.g(i19);
                        imageView.setTag(R.id.jb9, g16);
                        ss.c a16 = ss.c.a();
                        int i26 = this.f68561i;
                        a16.c(imageView, g16, i26, i26, z16);
                    } else {
                        URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), Uri.parse(d16).getPath(), "-Dynamic-", null, new int[]{13}, "-Dynamic-", null);
                        if (apngDrawable != null) {
                            if (apngDrawable.getStatus() == 2) {
                                apngDrawable.restartDownload();
                            }
                            if (!z16) {
                                apngDrawable = null;
                            }
                            imageView.setImageDrawable(apngDrawable);
                        } else if (QLog.isColorLevel()) {
                            QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
                        }
                    }
                } else {
                    ss.c a17 = ss.c.a();
                    int i27 = this.f68561i;
                    a17.c(imageView, d16, i27, i27, z16);
                }
            }
        }
    }

    public NormalFaceAdapter(Context context, FaceListPage faceListPage) {
        super(context, faceListPage);
        this.f68550m = new b.a<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(f fVar, Drawable drawable, ImageView imageView, String str, String str2, int i3) {
        int intrinsicHeight;
        int paddingTop;
        float f16;
        if (drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight()) {
            intrinsicHeight = drawable.getIntrinsicWidth();
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        int width = imageView.getWidth();
        if (imageView.getPaddingLeft() > imageView.getPaddingTop()) {
            paddingTop = imageView.getPaddingLeft();
        } else {
            paddingTop = imageView.getPaddingTop();
        }
        if (width > intrinsicHeight) {
            f16 = ((((width - intrinsicHeight) / 2) - paddingTop) * 2) + intrinsicHeight;
        } else {
            f16 = intrinsicHeight - ((((intrinsicHeight - width) / 2) + paddingTop) * 2);
        }
        float f17 = (float) ((f16 / intrinsicHeight) * fVar.f405998k);
        vr.a aVar = new vr.a(fVar.f405989b, str2, drawable, i3);
        f.a a16 = com.tencent.aelight.camera.aioeditor.capture.util.f.a();
        this.f68565f.e(aVar, a16.f67202a, a16.f67203b, f17, str, null);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        if (this.f68564e == 0) {
            view2 = view;
        } else {
            if (view == null) {
                bVar = new b(this.f68563d, viewGroup.getWidth(), ((hr.f) this.f68564e).a(), ((hr.f) this.f68564e).c(), this, this);
            } else {
                bVar = (b) view;
            }
            bVar.a((hr.f) this.f68564e, i3, getCount(), a());
            view2 = bVar;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.NormalFaceAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                NormalFaceAdapter.this.h(view);
            }
        }, null, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view) {
        int i3;
        String str;
        String str2;
        int i16;
        String str3;
        Drawable drawable;
        String g16;
        ImageView imageView = (ImageView) view;
        int intValue = ((Integer) imageView.getTag(R.id.f166944jb1)).intValue();
        hr.f fVar = (hr.f) this.f68564e;
        id0.a.m((Activity) view.getContext(), "sticker_element", ((hr.f) this.f68564e).f405988a, String.valueOf(intValue));
        int i17 = fVar.i(intValue);
        String path = Uri.parse(fVar.d(intValue)).getPath();
        String name = new File(path).getName();
        if (i17 == 1 && (this.f68563d instanceof EditPicActivity) && (g16 = fVar.g(intValue)) != null) {
            str = Uri.parse(g16).getPath();
            i3 = 0;
        } else {
            i3 = i17;
            str = path;
        }
        Drawable c16 = this.f68550m.c(str);
        if (c16 == null) {
            if (i3 != 1) {
                try {
                    c16 = Drawable.createFromPath(str);
                } catch (OutOfMemoryError e16) {
                    hd0.c.h("NormalFaceAdapter", "createFromPath error", e16);
                }
                str2 = "NormalFaceAdapter";
                i16 = i3;
                str3 = str;
            } else {
                URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[]{13}, "-Dynamic-", null);
                if (apngDrawable == null) {
                    str2 = "NormalFaceAdapter";
                    i16 = i3;
                    str3 = str;
                    if (QLog.isColorLevel()) {
                        QLog.d(str2, 2, "urlDrawable apng error");
                    }
                } else {
                    int status = apngDrawable.getStatus();
                    if (status == 1) {
                        str2 = "NormalFaceAdapter";
                        i16 = i3;
                        str3 = str;
                        c16 = apngDrawable;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e("NormalFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + status);
                        }
                        if (status == 2) {
                            apngDrawable.restartDownload();
                        } else {
                            apngDrawable.startDownload();
                        }
                        str2 = "NormalFaceAdapter";
                        i16 = i3;
                        str3 = str;
                        apngDrawable.setURLDrawableListener(new a(str, fVar, imageView, name));
                    }
                }
            }
            Drawable drawable2 = c16;
            if (drawable2 != null) {
                this.f68550m.a(str3, drawable2);
            }
            drawable = drawable2;
        } else {
            str2 = "NormalFaceAdapter";
            i16 = i3;
            str3 = str;
            this.f68550m.b();
            drawable = c16;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            g(fVar, drawable, imageView, str3, name, i16);
        } else {
            hd0.c.g(str2, "can create drawable from path:" + str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f68552d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ hr.f f68553e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f68554f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f68555h;

        a(String str, hr.f fVar, ImageView imageView, String str2) {
            this.f68552d = str;
            this.f68553e = fVar;
            this.f68554f = imageView;
            this.f68555h = str2;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            hd0.c.a("NormalFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.f68552d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            hd0.c.a("NormalFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.f68552d);
            uRLDrawable.setBounds(0, 0, uRLDrawable.getIntrinsicWidth(), uRLDrawable.getIntrinsicHeight());
            NormalFaceAdapter.this.f68550m.a(this.f68552d, uRLDrawable);
            NormalFaceAdapter.this.g(this.f68553e, uRLDrawable, this.f68554f, this.f68552d, this.f68555h, 1);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
