package com.tencent.open.filedownload;

import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.open.filedownload.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9280a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f341561d;

        C9280a(ImageView imageView) {
            this.f341561d = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.d("CommonUtils_", 1, "onLoadCanceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.d("CommonUtils_", 1, "onLoadFialed urldrawable load failed ");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            QLog.d("CommonUtils_", 1, "onLoadProgressed");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            this.f341561d.setImageDrawable(uRLDrawable);
            QLog.d("CommonUtils_", 1, "onLoadSuccessed");
        }
    }

    private static String a(String str) {
        return str.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace(ContainerUtils.FIELD_DELIMITER, "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
    }

    private static String b(String str) {
        if (str != null) {
            return URLDecoder.decode(str);
        }
        return "";
    }

    public static String c(String str) {
        String str2;
        f.e("CommonUtils_", "genExistedAPKFileNameByUrl url = " + str);
        if (str.contains(".apk")) {
            str2 = str.trim().substring(str.lastIndexOf("/") + 1).trim();
            if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str2 = str2.substring(0, str2.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
            }
            if (!TextUtils.isEmpty(str2)) {
                String a16 = a(b(str2));
                f.e("CommonUtils_", "genExistedAPKFileNameByUrl  fileName = " + a16);
                return a16;
            }
        } else {
            str2 = null;
        }
        if (str2 == null) {
            String calcMD5AsString = GlobalUtil.calcMD5AsString(str);
            if (TextUtils.isEmpty(calcMD5AsString)) {
                calcMD5AsString = Integer.toString(Math.abs(str.hashCode()));
            }
            str2 = calcMD5AsString + ".apk";
        }
        f.e("CommonUtils_", "genExistedAPKFileNameByUrl fileName == null, return fileName = " + str2);
        return str2;
    }

    public static boolean d() {
        MyAppApi.z();
        return MyAppApi.G();
    }

    public static void e(ImageView imageView, String str) {
        try {
            URL url = new URL(str);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = 234;
            obtain.mRequestWidth = 234;
            obtain.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.d8y);
            obtain.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.d8y);
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            drawable.setAutoDownload(true);
            drawable.setURLDrawableListener(new C9280a(imageView));
            drawable.startDownload();
            imageView.setImageDrawable(drawable);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
        }
    }
}
