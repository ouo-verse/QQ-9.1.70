package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.capture.util.f;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FavFaceAdapter extends b<hr.b> implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name */
    private b.a<String, Drawable> f68508m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class a extends LinearLayout {
        private float C;

        /* renamed from: d, reason: collision with root package name */
        private int f68510d;

        /* renamed from: e, reason: collision with root package name */
        private int f68511e;

        /* renamed from: f, reason: collision with root package name */
        private int f68512f;

        /* renamed from: h, reason: collision with root package name */
        private View.OnClickListener f68513h;

        /* renamed from: i, reason: collision with root package name */
        private int f68514i;

        /* renamed from: m, reason: collision with root package name */
        private b f68515m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FavFaceAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0611a implements URLDrawableDownListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ EmoticonInfo f68516d;

            C0611a(EmoticonInfo emoticonInfo) {
                this.f68516d = emoticonInfo;
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
                QLog.e("FavFaceAdapter", 1, "onLoadFailed: " + this.f68516d.toString());
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
                QLog.e("FavFaceAdapter", 1, "onLoadFailed: " + this.f68516d.toString());
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
                QLog.e("FavFaceAdapter", 1, "onLoadInterrupted: " + this.f68516d.toString());
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.i("FavFaceAdapter", 2, "onLoadProgressed: " + this.f68516d.toString());
                }
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
                if (QLog.isColorLevel()) {
                    QLog.i("FavFaceAdapter", 1, "onLoadSuccess: " + this.f68516d.toString());
                }
            }
        }

        public a(Context context, int i3, int i16, float f16, View.OnClickListener onClickListener, b bVar) {
            super(context);
            this.f68513h = onClickListener;
            this.f68510d = i3;
            this.f68511e = i16;
            this.f68515m = bVar;
            this.C = context.getResources().getDisplayMetrics().density;
            int i17 = i3 / this.f68511e;
            int i18 = (int) (i17 * f16);
            this.f68512f = i18;
            this.f68514i = i17 - (i18 * 2);
            c();
        }

        private String b(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            return String.format(BaseApplication.getContext().getString(R.string.zxi), str);
        }

        public void a(hr.b bVar, int i3, int i16, boolean z16) {
            int i17 = this.f68511e;
            int i18 = i3 * i17;
            int b16 = i3 == i16 + (-1) ? bVar.b() : i18 + i17;
            d(b16 - i18);
            HashMap<Integer, String> g16 = AppSetting.f99565y ? bVar.g() : null;
            for (int i19 = i18; i19 < b16; i19++) {
                URLImageView uRLImageView = (URLImageView) getChildAt(i19 - i18);
                uRLImageView.setTag(R.id.f166944jb1, Integer.valueOf(i19));
                uRLImageView.setOnClickListener(this.f68513h);
                EmoticonInfo emoticonInfo = bVar.h().get(i19);
                Context context = getContext();
                float f16 = this.C;
                Drawable zoomDrawable = emoticonInfo.getZoomDrawable(context, f16, (int) (f16 * 100.0f), (int) (100.0f * f16));
                uRLImageView.setImageDrawable(zoomDrawable);
                if (AppSetting.f99565y && g16 != null) {
                    uRLImageView.setContentDescription(b(g16.get(Integer.valueOf(emoticonInfo.emoId))));
                }
                uRLImageView.setURLDrawableDownListener(new C0611a(emoticonInfo));
                uRLImageView.setImageDrawable(zoomDrawable);
            }
        }

        private void c() {
            setOrientation(0);
            setGravity(17);
            int i3 = this.f68510d / this.f68511e;
            for (int i16 = 0; i16 < this.f68511e; i16++) {
                URLImageView uRLImageView = new URLImageView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                if (i16 == 0) {
                    layoutParams.leftMargin = zr.a.a(getContext(), 7.0f);
                }
                if (i16 == this.f68511e - 1) {
                    layoutParams.rightMargin = zr.a.a(getContext(), 7.0f);
                }
                uRLImageView.setLayoutParams(layoutParams);
                int i17 = this.f68512f;
                uRLImageView.setPadding(i17, i17, i17, i17);
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                addView(uRLImageView);
            }
        }

        private void d(int i3) {
            for (int i16 = 0; i16 < i3 && i16 < getChildCount(); i16++) {
                getChildAt(i16).setVisibility(0);
            }
            while (i3 < this.f68511e && i3 < getChildCount()) {
                getChildAt(i3).setVisibility(4);
                i3++;
            }
        }
    }

    public FavFaceAdapter(Context context, FaceListPage faceListPage) {
        super(context, faceListPage);
        this.f68508m = new b.a<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view) {
        String str;
        QLog.d("FavFaceAdapter", 1, "apply paster");
        ImageView imageView = (ImageView) view;
        int intValue = ((Integer) imageView.getTag(R.id.f166944jb1)).intValue();
        hr.b bVar = (hr.b) this.f68564e;
        Parcelable parcelable = (EmoticonInfo) bVar.h().get(intValue);
        if (parcelable instanceof FavoriteEmoticonInfo) {
            str = ((IFavoriteEmoticonInfo) parcelable).getPath();
        } else if (parcelable instanceof IPicEmoticonInfo) {
            Emoticon emoticon = ((IPicEmoticonInfo) parcelable).getEmoticon();
            if (emoticon == null) {
                QLog.d("FavFaceAdapter", 1, "IPicEmoticonInfo - emoticon is null, return");
                return;
            }
            str = MarketFaceConstants.emoticonPreviewPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
        } else {
            str = "";
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            QLog.d("FavFaceAdapter", 1, "path is empty, do not response click");
            return;
        }
        if (!new File(str2).exists()) {
            QLog.d("FavFaceAdapter", 1, HippyBridge.URI_SCHEME_FILE + str2 + " is not exist, return");
            return;
        }
        String name = new File(str2).getName();
        Drawable c16 = this.f68508m.c(str2);
        if (c16 == null) {
            try {
                c16 = Drawable.createFromPath(str2);
            } catch (OutOfMemoryError e16) {
                hd0.c.h("FavFaceAdapter", "createFromPath error", e16);
            }
            if (c16 != null) {
                this.f68508m.a(str2, c16);
            }
        } else {
            this.f68508m.b();
        }
        Drawable drawable = c16;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            e(bVar, drawable, imageView, str2, name, 0);
        } else {
            hd0.c.g("FavFaceAdapter", "can create drawable from path:" + str2);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        if (this.f68564e == 0) {
            view2 = view;
        } else {
            if (view == null) {
                aVar = new a(this.f68563d, viewGroup.getWidth(), ((hr.b) this.f68564e).a(), ((hr.b) this.f68564e).c(), this, this);
            } else {
                aVar = (a) view;
            }
            aVar.a((hr.b) this.f68564e, i3, getCount(), a());
            view2 = aVar;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FavFaceAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                FavFaceAdapter.this.f(view);
            }
        }, null, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void e(hr.b bVar, Drawable drawable, ImageView imageView, String str, String str2, int i3) {
        int intrinsicHeight;
        int paddingTop;
        float f16;
        QLog.d("FavFaceAdapter", 1, "addFace");
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
        float f17 = (float) ((f16 / intrinsicHeight) * bVar.f405998k);
        vr.a aVar = new vr.a(bVar.f405989b, str2, drawable, i3);
        f.a a16 = f.a();
        this.f68565f.e(aVar, a16.f67202a, a16.f67203b, f17, str, null);
    }
}
