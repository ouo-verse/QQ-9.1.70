package com.tencent.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LoadingUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LoadingUtil";
    private static Map<Integer, String> loadingResID2MD5;
    private static Map<Integer, String> loadingResID2PATH;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface LoadingType {
        public static final int LOADING_TYPE_BLACK = 3;
        public static final String LOADING_TYPE_BLACK_MD5 = "3D2F0B932DC6ED5A7AE04AFC066B04A6";
        public static final String LOADING_TYPE_BLACK_PATH = "loading/icon_loading_black.png";
        public static final int LOADING_TYPE_COLORFUL = 4;
        public static final String LOADING_TYPE_COLORFUL_MD5 = "B62EF97B7D19CA7FB8494B380D7C702D";
        public static final String LOADING_TYPE_COLORFUL_PATH = "loading/icon_loading_colorful.png";
        public static final int LOADING_TYPE_GRAY = 2;
        public static final String LOADING_TYPE_GRAY_MD5 = "B0AED17A42CDD2E8BE5BA39223CE3269";
        public static final String LOADING_TYPE_GRAY_PATH = "loading/icon_loading_gray.png";
        public static final int LOADING_TYPE_WHITE = 1;
        public static final String LOADING_TYPE_WHITE_MD5 = "80E2BE4A94D68FE74CFE8372D5908241";
        public static final String LOADING_TYPE_WHITE_PATH = "loading/icon_loading_white.png";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            } else {
                QLog.i(LoadingUtil.TAG, 1, "URLDrawable.onLoadCanceled:");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            } else {
                QLog.i(LoadingUtil.TAG, 1, "URLDrawable.onLoadFialed:");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LoadingUtil.initDrawable(uRLDrawable);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53733);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        loadingResID2MD5 = new HashMap();
        loadingResID2PATH = new HashMap();
        loadingResID2MD5.put(1, LoadingType.LOADING_TYPE_WHITE_MD5);
        loadingResID2MD5.put(3, LoadingType.LOADING_TYPE_BLACK_MD5);
        loadingResID2MD5.put(2, LoadingType.LOADING_TYPE_GRAY_MD5);
        loadingResID2MD5.put(4, LoadingType.LOADING_TYPE_COLORFUL_MD5);
        loadingResID2PATH.put(1, LoadingType.LOADING_TYPE_WHITE_PATH);
        loadingResID2PATH.put(3, LoadingType.LOADING_TYPE_BLACK_PATH);
        loadingResID2PATH.put(2, LoadingType.LOADING_TYPE_GRAY_PATH);
        loadingResID2PATH.put(4, LoadingType.LOADING_TYPE_COLORFUL_PATH);
    }

    public LoadingUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Dialog createLoadingDialog(Context context, String str, boolean z16) {
        if (context == null) {
            QLog.i(TAG, 1, "createLoadingDialog context == null");
            return null;
        }
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167843e53);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.ysu);
        TextView textView = (TextView) reportDialog.findViewById(R.id.yt9);
        imageView.setImageDrawable(getLoadingDrawable(context, 1));
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        reportDialog.setCanceledOnTouchOutside(z16);
        return reportDialog;
    }

    static URL getDrawableURL(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        try {
            return new URL("assets_img", "host_image", String.format("%s?md5=%s", str, str2));
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDrawable ,", e16);
            }
            return null;
        }
    }

    public static View getLoadingDialogTipsRight(Context context, boolean z16) {
        int i3 = 1;
        if (context == null) {
            QLog.i(TAG, 1, "getLoadingDialogTipsRight context == null");
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167842e52, (ViewGroup) null);
        if (inflate == null) {
            QLog.i(TAG, 1, "getLoadingDialogTipsRight view == null");
            return null;
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ysu);
        if (!z16) {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ef_);
            linearLayout.setBackground(null);
            linearLayout.setGravity(17);
            ((TextView) inflate.findViewById(R.id.yt9)).setTextColor(context.getColor(R.color.qui_common_text_secondary));
        }
        if (!z16) {
            i3 = 2;
        }
        imageView.setImageDrawable(getLoadingDrawable(context, i3));
        return inflate;
    }

    public static Drawable getLoadingDrawable(Context context, int i3) {
        if (context == null) {
            QLog.i(TAG, 1, "getLoadingDrawable context == null");
            return null;
        }
        return getUrlDrawable(getDrawableURL(loadingResID2PATH.get(Integer.valueOf(i3)), loadingResID2MD5.get(Integer.valueOf(i3))));
    }

    public static View getLoadingView(Context context, int i3, int i16, int i17) {
        if (context == null) {
            QLog.i(TAG, 1, "getLoadingView context == null");
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(getLoadingDrawable(context, i17));
        linearLayout.addView(imageView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        imageView.setLayoutParams(layoutParams);
        return linearLayout;
    }

    private static URLDrawable getUrlDrawable(URL url) {
        URLDrawable uRLDrawable;
        if (URLDrawable.depImp == null) {
            QQUITemp.initUrlDrawable();
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            uRLDrawable = URLDrawable.getDrawable(url, obtain);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getUrlDrawable error, ", e16);
            uRLDrawable = null;
        }
        if (uRLDrawable == null) {
            return null;
        }
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable != null && (currDrawable instanceof ApngDrawable)) {
            initDrawable(uRLDrawable);
        } else {
            uRLDrawable.setURLDrawableListener(new a());
        }
        return uRLDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initDrawable(URLDrawable uRLDrawable) {
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable != null && (currDrawable instanceof ApngDrawable)) {
            ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
            apngDrawable.getImage().setSupportGlobalPasued(false);
            try {
                apngDrawable.resume();
            } catch (Exception e16) {
                QLog.i(TAG, 1, e16.toString());
            }
        }
    }

    public static Dialog showLoadingDialog(Context context, String str, boolean z16) {
        if (context == null) {
            QLog.i(TAG, 1, "showLoadingDialog context == null");
            return null;
        }
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167841e51);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.ysu);
        TextView textView = (TextView) reportDialog.findViewById(R.id.yt9);
        imageView.setImageDrawable(getLoadingDrawable(context, 1));
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        reportDialog.setCanceledOnTouchOutside(z16);
        return reportDialog;
    }

    public static Dialog showLoadingDialogTipsRight(Context context, boolean z16, boolean z17) {
        if (context == null) {
            QLog.i(TAG, 1, "showLoadingDialogTipsRight context == null");
            return null;
        }
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(getLoadingDialogTipsRight(context, z16));
        Window window = reportDialog.getWindow();
        window.setBackgroundDrawableResource(17170445);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 1.0f;
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        reportDialog.setCanceledOnTouchOutside(z17);
        return reportDialog;
    }

    public static Dialog showOnlyLoadingImageDialog(Context context, int i3, boolean z16) {
        if (context == null) {
            QLog.i(TAG, 1, "showOnlyLoadingImageDialog context == null");
            return null;
        }
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(getLoadingView(context, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), i3));
        reportDialog.setCanceledOnTouchOutside(z16);
        return reportDialog;
    }

    public static Dialog showPersistentLoadingDialog(Context context, String str, boolean z16, boolean z17) {
        if (context == null) {
            QLog.i(TAG, 1, "showLoadingDialog context == null");
            return null;
        }
        com.tencent.widget.a aVar = new com.tencent.widget.a(context, R.style.qZoneInputDialog, z17);
        aVar.setContentView(R.layout.f167841e51);
        ImageView imageView = (ImageView) aVar.findViewById(R.id.ysu);
        TextView textView = (TextView) aVar.findViewById(R.id.yt9);
        imageView.setImageDrawable(getLoadingDrawable(context, 1));
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        aVar.setCanceledOnTouchOutside(z16);
        return aVar;
    }

    public static Dialog showTransLoadingDialog(Context context, String str, boolean z16) {
        if (context == null) {
            QLog.i(TAG, 1, "showLoadingDialog context == null");
            return null;
        }
        ReportDialog reportDialog = new ReportDialog(context, R.style.b0h);
        reportDialog.setContentView(R.layout.f167841e51);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.ysu);
        TextView textView = (TextView) reportDialog.findViewById(R.id.yt9);
        imageView.setImageDrawable(getLoadingDrawable(context, 1));
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        reportDialog.setCanceledOnTouchOutside(z16);
        return reportDialog;
    }
}
