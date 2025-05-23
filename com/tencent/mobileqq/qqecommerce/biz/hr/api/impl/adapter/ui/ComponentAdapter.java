package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.richtext.ui.component.image.VImage2;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dk0.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ComponentAdapter implements d {

    /* renamed from: a, reason: collision with root package name */
    private Set<URLDrawable> f262602a = new HashSet();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private static class b implements com.tencent.ecommerce.richtext.ui.component.image.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d.a> f262616a;

        /* renamed from: b, reason: collision with root package name */
        private String f262617b;

        public b(d.a aVar, String str) {
            this.f262616a = new WeakReference<>(aVar);
            this.f262617b = str;
        }

        @Override // com.tencent.ecommerce.richtext.ui.component.image.a
        public void a(Object obj, String str, Bundle bundle) {
            d.a aVar;
            if (!(obj instanceof Drawable) || (aVar = this.f262616a.get()) == null) {
                return;
            }
            aVar.a(str, (Drawable) obj, true, bundle);
        }

        @Override // com.tencent.ecommerce.richtext.ui.component.image.a
        public ImageView getTarget() {
            return null;
        }

        @Override // com.tencent.ecommerce.richtext.ui.component.image.a
        public void onCancel() {
            d.a aVar = this.f262616a.get();
            if (aVar != null) {
                aVar.a(this.f262617b, null, false, null);
            }
            QLog.e("ComponentAdapter", 1, "load img span cancel: " + this.f262617b);
        }

        @Override // com.tencent.ecommerce.richtext.ui.component.image.a
        public void onError() {
            d.a aVar = this.f262616a.get();
            if (aVar != null) {
                aVar.a(this.f262617b, null, false, null);
            }
            QLog.e("ComponentAdapter", 1, "load img span error: " + this.f262617b);
        }
    }

    private static StringBuilder n(String str) {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 2) < str.length()) {
                int i17 = i16 + 1;
                int charAt = (((str.charAt(i17) - 'A') * 128) + str.charAt(i3)) - 65;
                if (QLog.isColorLevel()) {
                    QLog.d("ComponentAdapter", 2, "faceIndex:" + charAt);
                }
                int convertToLocal = QQSysFaceUtil.convertToLocal(charAt);
                if (convertToLocal >= 0) {
                    sb5.append(str.charAt(i16));
                    sb5.append((char) convertToLocal);
                }
                i16 = i17 + 1;
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5;
    }

    private Bundle o(URLDrawable uRLDrawable) {
        File fileInLocal;
        Bundle bundle = new Bundle();
        if (uRLDrawable == null || (fileInLocal = uRLDrawable.getFileInLocal()) == null || !fileInLocal.exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(fileInLocal.getAbsolutePath(), options);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.tencent.ecommerce.richtext.ui.component.image.a aVar, String str, String str2, boolean z16, boolean z17, int i3, int i16) {
        URLDrawable.URLDrawableOptions s16 = s(z17, i3, i16);
        s16.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, s16);
        if (fileDrawable != null) {
            u(aVar, fileDrawable, z16, str2);
            return;
        }
        QLog.e("ComponentAdapter", 1, "load local file error, url: " + str2);
        aVar.onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.tencent.ecommerce.richtext.ui.component.image.a aVar, String str, int i3, int i16, boolean z16, boolean z17) {
        URLDrawable drawable = URLDrawable.getDrawable(str, s(z16, i3, i16));
        this.f262602a.add(drawable);
        if (QLog.isColorLevel()) {
            QLog.d("ComponentAdapter", 2, "enqueue action, url: " + str);
        }
        if (drawable.getFileInLocal() != null) {
            t(aVar, drawable, z17);
            this.f262602a.remove(drawable);
        } else {
            drawable.startDownload();
            drawable.setTag(0);
            drawable.setURLDrawableListener(new a(z17, aVar));
        }
    }

    public static URLDrawable.URLDrawableOptions s(boolean z16, int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i16;
        if (z16) {
            v();
            obtain.mPlayGifImage = true;
        } else {
            obtain.mPlayGifImage = false;
        }
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(com.tencent.ecommerce.richtext.ui.component.image.a aVar, String str, boolean z16, boolean z17, int i3, int i16) {
        if (!str.startsWith("file://")) {
            return false;
        }
        String substring = str.substring(7);
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        p(aVar, substring, str, z16, z17, i3, i16);
        return true;
    }

    @Override // dk0.d
    public void a(String str, int i3, int i16, boolean z16, com.tencent.ecommerce.richtext.ui.component.image.a aVar, boolean z17, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str) || aVar == null || aVar.getTarget() == null) {
            return;
        }
        if (aVar instanceof VImage2) {
            ((VImage2) aVar).m();
        }
        q(aVar, str, i3, i16, z16, z17);
    }

    @Override // dk0.d
    public boolean b(TextPaint textPaint, String str, int i3) {
        Typeface createFromAsset;
        if (TextUtils.isEmpty(str) || textPaint == null) {
            return false;
        }
        if (str.equals("EurostileNextPro-Bold")) {
            RFWTypefaceUtil.setNumberTypeface(textPaint, "https://dlied5.qq.com/now/qq-live/fonts/EurostileNextPro-Bold.ttf");
            return true;
        }
        boolean equals = str.equals("DIN");
        String str2 = VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH;
        if (!equals) {
            if (str.equals("bebas")) {
                str2 = "fonts/readinjoy_operation_bar_number.ttf";
            } else if (!"din-black".equals(str)) {
                str2 = "Qvideo Digit".equals(str) ? "fonts/Qvideo Digit.ttf" : null;
            }
        }
        if (str2 == null || (createFromAsset = Typeface.createFromAsset(BaseApplicationImpl.getApplication().getAssets(), str2)) == null) {
            return false;
        }
        textPaint.setTypeface(createFromAsset);
        return true;
    }

    @Override // dk0.d
    public CharSequence d(CharSequence charSequence, int i3, int i16) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        try {
            StringBuilder n3 = n(charSequence.toString());
            if (i16 == -1.0f) {
                i16 = (int) (i3 / 2.5d);
            }
            return new QQText(n3, 2, i16);
        } catch (Throwable th5) {
            QLog.e("ComponentAdapter", 1, "setEmoticonTextError: " + th5.getMessage());
            return "";
        }
    }

    @Override // dk0.d
    public Bitmap e(Drawable drawable) {
        if (drawable instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) drawable).getCurrDrawable();
            if (currDrawable instanceof RegionDrawable) {
                return ((RegionDrawable) currDrawable).getBitmap();
            }
            if (currDrawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) currDrawable).getBitmap();
            }
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    @Override // dk0.d
    public DisplayMetrics f() {
        return FontSettingManager.systemMetrics;
    }

    @Override // dk0.d
    public void g(final String str, final int i3, final int i16, final d.a aVar) {
        fk0.d.c().d(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.ui.ComponentAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                b bVar = new b(aVar, str);
                if (TextUtils.isEmpty("") || !new File("").exists()) {
                    ComponentAdapter.this.r(bVar, str, i3, i16, false, false);
                } else {
                    ComponentAdapter.this.p(bVar, "", str, false, false, i3, i16);
                }
            }
        });
    }

    @Override // dk0.d
    public void runOnUiThread(Runnable runnable) {
        ThreadManagerV2.getUIHandlerV2().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.tencent.ecommerce.richtext.ui.component.image.a aVar, URLDrawable uRLDrawable, boolean z16) {
        u(aVar, uRLDrawable, z16, null);
    }

    private void q(final com.tencent.ecommerce.richtext.ui.component.image.a aVar, String str, final int i3, final int i16, final boolean z16, final boolean z17) {
        if (aVar == null || TextUtils.isEmpty(str) || aVar.getTarget() == null) {
            return;
        }
        if (str.startsWith("//")) {
            str = "https:" + str;
        }
        final String str2 = str;
        fk0.d.c().d(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.ui.ComponentAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty("") && new File("").exists()) {
                    ComponentAdapter.this.p(aVar, "", str2, z16, z17, i3, i16);
                }
                if (!ComponentAdapter.this.w(aVar, str2, z16, z17, i3, i16) && str2.startsWith("http")) {
                    ComponentAdapter.this.r(aVar, str2, i3, i16, z17, z16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(com.tencent.ecommerce.richtext.ui.component.image.a aVar, URLDrawable uRLDrawable, Throwable th5) {
        if (aVar == null || uRLDrawable == null || !NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            return;
        }
        Object tag = uRLDrawable.getTag();
        if (tag instanceof Integer) {
            int intValue = ((Integer) tag).intValue();
            if (intValue < 3) {
                uRLDrawable.setTag(Integer.valueOf(intValue + 1));
                uRLDrawable.restartDownload();
                if (uRLDrawable.getURL() != null) {
                    uRLDrawable.getURL().toString();
                }
                th5.getMessage();
                return;
            }
            if (uRLDrawable.getURL() != null) {
                uRLDrawable.getURL().toString();
            }
            th5.getMessage();
            aVar.onError();
            this.f262602a.remove(uRLDrawable);
        }
    }

    @Override // dk0.d
    public void c(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 16, null, true);
    }

    private void u(com.tencent.ecommerce.richtext.ui.component.image.a aVar, URLDrawable uRLDrawable, boolean z16, String str) {
        if (aVar == null) {
            return;
        }
        Bundle o16 = z16 ? o(uRLDrawable) : null;
        if (TextUtils.isEmpty(str)) {
            str = uRLDrawable.getURL() != null ? uRLDrawable.getURL().toString() : null;
        }
        aVar.a(uRLDrawable, str, o16);
    }

    private static void v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<com.tencent.ecommerce.richtext.ui.component.image.a> f262613d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f262614e;

        public a(boolean z16, com.tencent.ecommerce.richtext.ui.component.image.a aVar) {
            this.f262613d = new WeakReference<>(aVar);
            this.f262614e = z16;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            com.tencent.ecommerce.richtext.ui.component.image.a aVar;
            WeakReference<com.tencent.ecommerce.richtext.ui.component.image.a> weakReference = this.f262613d;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.onCancel();
            ComponentAdapter.this.f262602a.remove(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            WeakReference<com.tencent.ecommerce.richtext.ui.component.image.a> weakReference = this.f262613d;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ComponentAdapter.this.x(this.f262613d.get(), uRLDrawable, th5);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            WeakReference<com.tencent.ecommerce.richtext.ui.component.image.a> weakReference = this.f262613d;
            if (weakReference != null && weakReference.get() != null) {
                ComponentAdapter.this.t(this.f262613d.get(), uRLDrawable, this.f262614e);
            }
            ComponentAdapter.this.f262602a.remove(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
