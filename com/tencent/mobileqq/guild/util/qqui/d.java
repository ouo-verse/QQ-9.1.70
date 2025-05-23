package com.tencent.mobileqq.guild.util.qqui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.temporary.api.IUrlDrawableApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, String> f235608a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<Integer, String> f235609b = new HashMap();

    static {
        f235608a.put(1, LoadingUtil.LoadingType.LOADING_TYPE_WHITE_MD5);
        f235608a.put(3, LoadingUtil.LoadingType.LOADING_TYPE_BLACK_MD5);
        f235608a.put(2, LoadingUtil.LoadingType.LOADING_TYPE_GRAY_MD5);
        f235609b.put(1, LoadingUtil.LoadingType.LOADING_TYPE_WHITE_PATH);
        f235609b.put(3, LoadingUtil.LoadingType.LOADING_TYPE_BLACK_PATH);
        f235609b.put(2, LoadingUtil.LoadingType.LOADING_TYPE_GRAY_PATH);
    }

    private static URL b(String str, String str2) {
        URL url;
        if (str2 == null) {
            str2 = "";
        }
        URL url2 = null;
        try {
            url = new URL("assets_img", "host_image", String.format("%s?md5=%s", str, str2));
        } catch (MalformedURLException e16) {
            e = e16;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("LoadingUtil", 2, "getDrawable url:" + url.toString());
                return url;
            }
            return url;
        } catch (MalformedURLException e17) {
            e = e17;
            url2 = url;
            if (QLog.isColorLevel()) {
                QLog.d("LoadingUtil", 2, "getDrawable ,", e);
            }
            return url2;
        }
    }

    public static View c(Context context, boolean z16) {
        int i3 = 1;
        if (context == null) {
            QLog.i("LoadingUtil", 1, "getLoadingDialogTipsRight context == null");
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167842e52, (ViewGroup) null);
        if (inflate == null) {
            QLog.i("LoadingUtil", 1, "getLoadingDialogTipsRight view == null");
            return null;
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ysu);
        if (!z16) {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ef_);
            linearLayout.setBackground(null);
            linearLayout.setGravity(17);
        }
        if (!z16) {
            i3 = 2;
        }
        imageView.setImageDrawable(d(context, i3));
        return inflate;
    }

    public static Drawable d(Context context, int i3) {
        if (context == null) {
            QLog.i("LoadingUtil", 1, "getLoadingDrawable context == null");
            return null;
        }
        return f(b(f235609b.get(Integer.valueOf(i3)), f235608a.get(Integer.valueOf(i3))));
    }

    public static View e(Context context, int i3, int i16, int i17) {
        if (context == null) {
            QLog.i("LoadingUtil", 1, "getLoadingView context == null");
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(d(context, i17));
        linearLayout.addView(imageView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        imageView.setLayoutParams(layoutParams);
        return linearLayout;
    }

    private static URLDrawable f(URL url) {
        if (URLDrawable.depImp == null) {
            ((IUrlDrawableApi) QRoute.api(IUrlDrawableApi.class)).initUrlDrawable();
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Drawable currDrawable = drawable.getCurrDrawable();
        if (currDrawable != null && (currDrawable instanceof ApngDrawable)) {
            g(drawable);
        } else {
            drawable.setURLDrawableListener(new a());
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(URLDrawable uRLDrawable) {
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable != null && (currDrawable instanceof ApngDrawable)) {
            QLog.i("LoadingUtil", 2, "initDrawable success");
            ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
            apngDrawable.getImage().setSupportGlobalPasued(false);
            apngDrawable.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.i("LoadingUtil", 1, "URLDrawable.onLoadCanceled:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.i("LoadingUtil", 1, "URLDrawable.onLoadFialed:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (QLog.isDevelopLevel()) {
                QLog.i("LoadingUtil", 1, "URLDrawable.onLoadSuccessed:");
            }
            d.g(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
