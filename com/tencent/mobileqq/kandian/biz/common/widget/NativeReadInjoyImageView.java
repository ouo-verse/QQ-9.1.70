package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NativeReadInjoyImageView extends KandianUrlImageView implements IView {
    private static final Drawable D = new ColorDrawable(0);
    private static Map<String, Drawable> E = new HashMap();
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f239304d;

    /* renamed from: e, reason: collision with root package name */
    private int f239305e;

    /* renamed from: f, reason: collision with root package name */
    private int f239306f;

    /* renamed from: h, reason: collision with root package name */
    private int f239307h;

    /* renamed from: i, reason: collision with root package name */
    private String f239308i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f239309m;

    public NativeReadInjoyImageView(Context context) {
        super(context);
        this.f239308i = null;
        this.f239309m = false;
        this.C = false;
        this.mController.i(false);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void comLayout(int i3, int i16, int i17, int i18) {
        onComLayout(true, i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void measureComponent(int i3, int i16) {
        onComMeasure(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        String str;
        super.onAttachedToWindow();
        com.tencent.mobileqq.kandian.base.image.b g16 = this.mController.g();
        if ((g16 == null || g16.f239007d) && (str = this.f239308i) != null) {
            setImageSrc(str);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        layout(i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        measure(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f239307h > 0 || this.f239306f > 0 || this.f239304d > 0 || this.f239305e > 0) {
            VirtualViewUtils.clipCanvas(canvas, getWidth(), getHeight(), 0, this.f239304d, this.f239305e, this.f239307h, this.f239306f);
        }
        super.onDraw(canvas);
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.tencent.mobileqq.kandian.base.image.b g16 = this.mController.g();
        if ((g16 == null || g16.f239007d) && !TextUtils.isEmpty(this.f239308i)) {
            setImageSrc(this.f239308i);
        }
    }

    public void setCorner(int i3, int i16, int i17, int i18) {
        this.f239304d = i3;
        this.f239305e = i16;
        this.f239306f = i18;
        this.f239307h = i17;
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView
    public void setImageDrawable(Drawable drawable, boolean z16) {
        if (this.C) {
            E.put(this.f239308i, drawable);
            QLog.d("NativeReadInjoyImageView", 2, "setImageDrawable: path is " + this.f239308i);
        }
        if (this.f239309m) {
            z16 = false;
        }
        super.setImageDrawable(drawable, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: MalformedURLException -> 0x0075, TryCatch #0 {MalformedURLException -> 0x0075, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000e, B:9:0x0012, B:12:0x001a, B:15:0x0021, B:16:0x0030, B:18:0x003a, B:19:0x0042, B:21:0x006b, B:23:0x0072, B:25:0x0028), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: MalformedURLException -> 0x0075, TryCatch #0 {MalformedURLException -> 0x0075, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000e, B:9:0x0012, B:12:0x001a, B:15:0x0021, B:16:0x0030, B:18:0x003a, B:19:0x0042, B:21:0x006b, B:23:0x0072, B:25:0x0028), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[Catch: MalformedURLException -> 0x0075, TRY_LEAVE, TryCatch #0 {MalformedURLException -> 0x0075, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000e, B:9:0x0012, B:12:0x001a, B:15:0x0021, B:16:0x0030, B:18:0x003a, B:19:0x0042, B:21:0x006b, B:23:0x0072, B:25:0x0028), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setImageSrc(String str) {
        URL b16;
        Drawable drawable;
        try {
            if (this.C && (drawable = E.get(str)) != null) {
                setImageDrawable(drawable);
                return;
            }
            String str2 = this.f239308i;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path unchanged ");
                com.tencent.mobileqq.kandian.biz.common.a aVar = com.tencent.mobileqq.kandian.biz.common.a.f239282a;
                b16 = aVar.b(this.f239308i);
                if (b16 == null) {
                    b16 = new URL(str);
                    aVar.a(b16);
                }
                QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | mPathUrl :" + this.f239308i);
                if (!((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).shouldShowPlaceHolder(getContext(), b16)) {
                    setImageResource(R.drawable.d7y);
                    return;
                } else {
                    setImage(b16);
                    return;
                }
            }
            this.f239308i = str;
            QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path changed ");
            com.tencent.mobileqq.kandian.biz.common.a aVar2 = com.tencent.mobileqq.kandian.biz.common.a.f239282a;
            b16 = aVar2.b(this.f239308i);
            if (b16 == null) {
            }
            QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | mPathUrl :" + this.f239308i);
            if (!((IReadInJoyDisplayUtils) QRoute.api(IReadInJoyDisplayUtils.class)).shouldShowPlaceHolder(getContext(), b16)) {
            }
        } catch (MalformedURLException unused) {
        }
    }

    public void setIsCacheIcon(boolean z16) {
        this.C = z16;
        if (z16) {
            setPublicAccountImageDownListener(new b());
        }
    }

    public void setIsClosedoAlphaAniamation(boolean z16) {
        this.f239309m = z16;
        if (z16) {
            setImagePlaceHolder(D);
        }
    }

    public NativeReadInjoyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f239308i = null;
        this.f239309m = false;
        this.C = false;
        this.mController.i(false);
    }

    public NativeReadInjoyImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239308i = null;
        this.f239309m = false;
        this.C = false;
        this.mController.i(false);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class b implements iy.a {
        b() {
        }

        @Override // iy.a
        public void a(URL url, Object obj) {
            QLog.d("NativeReadInjoyImageView", 2, "setImageDrawable: url is " + url);
            if (obj instanceof com.tencent.mobileqq.kandian.base.image.imageloader.a) {
                ((com.tencent.mobileqq.kandian.base.image.imageloader.a) obj).mo197clone();
            }
        }

        @Override // iy.a
        public void b(URL url, int i3) {
        }

        @Override // iy.a
        public void c(URL url, Throwable th5) {
        }
    }
}
