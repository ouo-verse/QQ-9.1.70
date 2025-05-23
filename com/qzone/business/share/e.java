package com.qzone.business.share;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.util.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ak;
import com.tencent.mobileqq.utils.aw;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {
    public static void a(Context context, String str, QQCustomDialog qQCustomDialog) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneSharePreviewDialog", 2, "addSourceNameView start! sourceName =" + str);
        }
        if (str == null || "".equals(str) || qQCustomDialog == null) {
            return;
        }
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(12.0f);
        textView.setPadding(0, ViewUtils.dip2px(10.0f), 0, 0);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-8355712);
        qQCustomDialog.addView(textView);
    }

    public static QQCustomDialogWtihEmoticonInput b(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        View e16;
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        String string3 = bundle.getString("app_name");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
            layoutParams.setMargins(ViewUtils.dip2px(-10.0f), 0, ViewUtils.dip2px(-7.5f), 0);
            e16 = c(context, bundle);
        } else {
            layoutParams.setMargins(ViewUtils.dip2px(-15.0f), 0, ViewUtils.dip2px(-15.0f), ViewUtils.dip2px(5.0f));
            e16 = e(context, bundle);
        }
        QQCustomDialogWtihEmoticonInput k3 = ak.k(context, null, null, null, onClickListener, onClickListener2);
        k3.s0();
        k3.r0(QZoneConfigHelper.a0());
        k3.setOnCancelListener(onCancelListener);
        k3.addView(e16);
        if (!TextUtils.isEmpty(string3)) {
            a(context, string3, k3);
        }
        k3.setMessageMaxLine(3);
        return k3;
    }

    public static View c(Context context, Bundle bundle) {
        Resources resources = context.getResources();
        int i3 = (int) resources.getDisplayMetrics().density;
        URLImageView uRLImageView = new URLImageView(context);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int i16 = i3 * 140;
        uRLImageView.setMaxHeight(i16);
        uRLImageView.setAdjustViewBounds(true);
        uRLImageView.setPadding(0, 10, 0, 10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setMinimumHeight(i3 * 120);
        Drawable drawable = resources.getDrawable(R.drawable.h2r);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("image_url");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            String str = stringArrayList.get(0);
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                Bitmap g16 = com.tencent.biz.common.util.e.g(str, i16);
                if (g16 != null) {
                    uRLImageView.setImageBitmap(aw.s(g16, new File(str)));
                } else {
                    uRLImageView.setImageDrawable(drawable);
                }
            } else {
                Drawable loadImage = ImageLoader.getInstance().loadImage(str, new b(uRLImageView), f());
                if (loadImage != null) {
                    uRLImageView.setImageDrawable(loadImage);
                } else {
                    uRLImageView.setImageDrawable(drawable);
                }
            }
            return uRLImageView;
        }
        uRLImageView.setImageDrawable(drawable);
        return uRLImageView;
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            String a16 = com.qzone.util.g.a(QzoneEmotionUtils.splash2Emo(str.replaceAll(l.a(R.string.s8c), l.a(R.string.s8z)).replaceAll(l.a(R.string.f172580s93), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2192465w), "/chigua")));
            if (!TextUtils.isEmpty(a16)) {
                return a16.trim();
            }
        }
        return "";
    }

    public static View e(Context context, Bundle bundle) {
        String str;
        String str2;
        Drawable loadImage;
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("image_url");
        View inflate = LayoutInflater.from(context).inflate(R.layout.br7, (ViewGroup) null);
        inflate.findViewById(R.id.dca).setVisibility(0);
        URLImageView uRLImageView = (URLImageView) inflate.findViewById(R.id.dgb);
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) inflate.findViewById(R.id.kbs);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_summary);
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string.length() > 30) {
            str = context.getString(R.string.aaf, string.substring(0, 30)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        } else {
            str = string;
        }
        if (string2.length() > 40) {
            str2 = context.getString(R.string.aaf, string2.substring(0, 40)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        } else {
            str2 = string2;
        }
        textView.setText(string);
        textView2.setText(string2);
        textView.setContentDescription(str);
        textView2.setContentDescription(str2);
        if (!TextUtils.isEmpty(string)) {
            textView.setVisibility(0);
            textView2.setMaxLines(2);
            textView2.setPadding(0, ViewUtils.dpToPx(37.0f), 0, 0);
        } else {
            textView.setVisibility(8);
            textView2.setPadding(0, 0, 0, 0);
            textView2.setMaxLines(4);
        }
        textView.setMaxLines(TextUtils.isEmpty(string2) ? 3 : 2);
        uRLImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.asd));
        if (stringArrayList != null && !stringArrayList.isEmpty() && (loadImage = ImageLoader.getInstance().loadImage(stringArrayList.get(0), new a(uRLImageView), f())) != null) {
            uRLImageView.setImageDrawable(loadImage);
        }
        return inflate;
    }

    private static ImageLoader.Options f() {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f44792d;

        a(URLImageView uRLImageView) {
            this.f44792d = uRLImageView;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable != null) {
                this.f44792d.setImageDrawable(drawable);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f44793d;

        b(URLImageView uRLImageView) {
            this.f44793d = uRLImageView;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable != null) {
                this.f44793d.setImageDrawable(drawable);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
