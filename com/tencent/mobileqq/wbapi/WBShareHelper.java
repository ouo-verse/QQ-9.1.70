package com.tencent.mobileqq.wbapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.mobileqq.forward.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WBShareHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<a> f313225a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Activity> f313228a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<IWBAPI> f313229b;

        a(Activity activity, IWBAPI iwbapi) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) iwbapi);
            } else {
                this.f313228a = new WeakReference<>(activity);
                this.f313229b = new WeakReference<>(iwbapi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final WBShareHelper f313230a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31106);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f313230a = new WBShareHelper();
            }
        }
    }

    WBShareHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f313225a = new ArrayList();
        QLog.d("WBShareHelper", 1, "WBShareHelper init");
        BaseApplication context = BaseApplication.getContext();
        WBAPIFactory.createWBAPI(null).registerApp(context, new AuthInfo(context, "94065651", "https://connect.qq.com", "status/share"));
    }

    private boolean b(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            return true;
        }
        QLog.d("WBShareHelper", 1, "shareImage activity == null || activity.isFinishing()");
        w.c(MobileQQ.sMobileQQ, "UI \u5df2\u7ecf\u9500\u6bc1");
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0022: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:35), block:B:25:0x0022 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] c(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e16) {
                e = e16;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (byteArrayOutputStream3 != null) {
                }
                throw th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e17) {
                    QLog.e("WBShareHelper", 1, "Exception", e17);
                }
                return byteArray;
            } catch (Exception e18) {
                e = e18;
                QLog.e("WBShareHelper", 1, "Exception", e);
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e19) {
                        QLog.e("WBShareHelper", 1, "Exception", e19);
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream3 = byteArrayOutputStream2;
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.close();
                } catch (IOException e26) {
                    QLog.e("WBShareHelper", 1, "Exception", e26);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Activity activity, WeiboMultiMessage weiboMultiMessage) {
        QLog.d("WBShareHelper", 1, "doShare");
        try {
            i(activity).shareMessage(weiboMultiMessage, false);
        } catch (Exception e16) {
            QLog.e("WBShareHelper", 1, "Exception", e16);
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0013: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:20), block:B:20:0x0013 */
    public static Bitmap f(String str) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                w.a(closeable2);
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                w.a(fileInputStream);
                return decodeStream;
            } catch (Exception e18) {
                e = e18;
                QLog.e("WBShareHelper", 1, "Exception", e);
                w.a(fileInputStream);
                return null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                QLog.e("WBShareHelper", 1, "OutOfMemoryError", e);
                w.a(fileInputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            w.a(closeable2);
            throw th;
        }
    }

    private static int g(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static WBShareHelper h(int i3) {
        if (i3 <= 0 || i3 >= 5) {
            QLog.e("WBShareHelper", 1, "getInstance Exception", Log.getStackTraceString(new Throwable()));
        }
        return b.f313230a;
    }

    private IWBAPI i(Activity activity) {
        Iterator<a> it = this.f313225a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f313228a.get() == null) {
                it.remove();
            }
            if (next.f313228a.get() == activity && next.f313229b.get() != null) {
                return next.f313229b.get();
            }
        }
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(activity);
        createWBAPI.setLoggerEnable(false);
        this.f313225a.add(new a(activity, createWBAPI));
        return createWBAPI;
    }

    public static boolean k(Intent intent, int i3) {
        Bundle extras;
        QLog.d("WBShareHelper", 1, "isWeiBoShare requestCode=", Integer.valueOf(i3));
        if (10001 != i3 || intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("_weibo_resp_errcode")) {
            return false;
        }
        return true;
    }

    private boolean n(Activity activity, WeiboMultiMessage weiboMultiMessage) {
        if ("com.tencent.mobileqq".equals(Common.m())) {
            e(activity, weiboMultiMessage);
            return true;
        }
        com.tencent.mobileqq.wbapi.a.a(new Runnable(activity, weiboMultiMessage) { // from class: com.tencent.mobileqq.wbapi.WBShareHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f313226d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ WeiboMultiMessage f313227e;

            {
                this.f313226d = activity;
                this.f313227e = weiboMultiMessage;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, WBShareHelper.this, activity, weiboMultiMessage);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QLog.d("WBShareHelper", 1, "WBQIPCClient installWBSdk onCallback");
                    WBShareHelper.this.e(this.f313226d, this.f313227e);
                }
            }
        });
        return true;
    }

    private boolean q(Activity activity, String str) {
        Object valueOf;
        Bitmap f16;
        ImageObject imageObject = new ImageObject();
        try {
            f16 = f(str);
        } catch (Exception e16) {
            QLog.e("WBShareHelper", 1, "Exception", e16);
        } catch (OutOfMemoryError e17) {
            QLog.e("WBShareHelper", 1, "OutOfMemoryError", e17);
        }
        if (f16 == null) {
            QLog.d("WBShareHelper", 1, "shareSingleBitmap text is empty");
            w.c(activity, "\u56fe\u7247\u4e3a\u7a7a\uff0c\u7981\u6b62\u5206\u4eab");
            return false;
        }
        imageObject.setImageData(f16);
        while (true) {
            byte[] bArr = imageObject.imageData;
            if (bArr == null || bArr.length < 630784) {
                break;
            }
            w.c(activity, "\u56fe\u7247\u592a\u5927\uff0c\u8bf7\u4e1a\u52a1\u538b\u7f29");
            QLog.d("WBShareHelper", 1, "shareSingleBitmap compress getBitmapSize=", Integer.valueOf(g(f16)), ", arr=", Integer.valueOf(imageObject.imageData.length));
            f16 = l(f16);
            imageObject.setImageData(f16);
        }
        Object[] objArr = new Object[2];
        objArr[0] = "shareSingleBitmap arr=";
        byte[] bArr2 = imageObject.imageData;
        if (bArr2 == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr2.length);
        }
        objArr[1] = valueOf;
        QLog.d("WBShareHelper", 1, objArr);
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.imageObject = imageObject;
        return n(activity, weiboMultiMessage);
    }

    public static boolean u(Activity activity) {
        if (activity != null && activity.getIntent() != null) {
            return activity.getIntent().getBooleanExtra("use_wei_bo_sdk", false);
        }
        QLog.e("WBShareHelper", 1, "useWBSdkShare null == activity || activity.getIntent() == null");
        return false;
    }

    public void d(Activity activity, Intent intent, WbShareCallback wbShareCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, intent, wbShareCallback);
        } else {
            QLog.d("WBShareHelper", 1, "doResultIntent");
            i(activity).doResultIntent(intent, wbShareCallback);
        }
    }

    public boolean j(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        boolean isWBAppInstalled = i(activity).isWBAppInstalled();
        QLog.d("WBShareHelper", 1, "isWBAppInstalled = " + isWBAppInstalled);
        return isWBAppInstalled;
    }

    public Bitmap l(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
        }
        Matrix matrix = new Matrix();
        matrix.postScale(0.9f, 0.9f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public boolean m(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) str)).booleanValue();
        }
        if (!b(activity)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("WBShareHelper", 1, "shareImage text is empty");
            w.c(activity, "\u56fe\u7247\u4e3a\u7a7a\uff0c\u7981\u6b62\u5206\u4eab");
            return false;
        }
        QLog.d("WBShareHelper", 1, "shareImage");
        if (i(activity).isWBAppSupportMultipleImage()) {
            return p(activity, " ", new String[]{str});
        }
        return q(activity, str);
    }

    public boolean o(Activity activity, String str, ArrayList<Uri> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, activity, str, arrayList)).booleanValue();
        }
        if (!b(activity)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && arrayList != null && !arrayList.isEmpty()) {
            if (!i(activity).isWBAppSupportMultipleImage()) {
                QLog.d("WBShareHelper", 1, "shareMultImage not support Multi Image");
                w.c(activity, "\u7248\u672c\u8f83\u4f4e\uff0c\u4e0d\u652f\u6301\u591a\u56fe\u5206\u4eab");
                return false;
            }
            QLog.d("WBShareHelper", 1, "shareMultImage imageUrls.size=" + arrayList.size());
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            TextObject textObject = new TextObject();
            textObject.text = str;
            weiboMultiMessage.textObject = textObject;
            MultiImageObject multiImageObject = new MultiImageObject();
            multiImageObject.imageList = arrayList;
            weiboMultiMessage.multiImageObject = multiImageObject;
            return n(activity, weiboMultiMessage);
        }
        QLog.d("WBShareHelper", 1, "shareMultImage invalid params");
        w.c(activity, "\u53c2\u6570\u4e0d\u5408\u6cd5\uff0c\u7981\u6b62\u5206\u4eab");
        return false;
    }

    public boolean p(Activity activity, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, activity, str, strArr)).booleanValue();
        }
        if (strArr != null && strArr.length != 0) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            for (String str2 : strArr) {
                arrayList.add(Uri.fromFile(new File(str2)));
            }
            return o(activity, str, arrayList);
        }
        QLog.d("WBShareHelper", 1, "null == imageUrls || imageUrls.length == 0");
        return false;
    }

    public boolean r(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) str)).booleanValue();
        }
        QLog.d("WBShareHelper", 1, ThirdPartyMiniPageProxy.KEY_SHARE_TEXT);
        if (!b(activity)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("WBShareHelper", 1, "shareText text is empty");
            w.c(activity, "\u6587\u672c\u4e3a\u7a7a\uff0c\u7981\u6b62\u5206\u4eab");
            return false;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        TextObject textObject = new TextObject();
        textObject.text = str;
        weiboMultiMessage.textObject = textObject;
        return n(activity, weiboMultiMessage);
    }

    public boolean s(Activity activity, String str, String str2, String str3, String str4, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, activity, str, str2, str3, str4, bitmap)).booleanValue();
        }
        QLog.d("WBShareHelper", 1, "shareUrl");
        if (!b(activity)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("WBShareHelper", 1, "shareUrl title empty");
            w.c(activity, "title\u4e3a\u7a7a\uff0c\u7981\u6b62\u5206\u4eab");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.d("WBShareHelper", 1, "shareUrl description empty");
            w.c(activity, "description\u4e3a\u7a7a\uff0c\u7981\u6b62\u5206\u4eab");
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            QLog.d("WBShareHelper", 1, "shareUrl actionUrl empty");
            w.c(activity, "actionUrl\u4e3a\u7a7a\uff0c\u7981\u6b62\u5206\u4eab");
            return false;
        }
        if (TextUtils.isEmpty(str4)) {
            QLog.d("WBShareHelper", 1, "shareUrl defaultText empty");
            w.c(activity, "defaultText\u4e3a\u7a7a\uff0c\u7981\u6b62\u5206\u4eab");
            return false;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.title = str;
        webpageObject.description = str2;
        webpageObject.actionUrl = str3;
        webpageObject.defaultText = str4;
        if (bitmap != null) {
            webpageObject.thumbData = c(bitmap);
            while (true) {
                byte[] bArr = webpageObject.thumbData;
                if (bArr == null || bArr.length < 32768) {
                    break;
                }
                w.c(activity, "\u56fe\u7247\u592a\u5927\uff0c\u8bf7\u4e1a\u52a1\u538b\u7f29");
                QLog.d("WBShareHelper", 1, "shareUrl compress getBitmapSize=", Integer.valueOf(g(bitmap)), "arr=", Integer.valueOf(webpageObject.thumbData.length));
                bitmap = l(bitmap);
                webpageObject.thumbData = c(bitmap);
            }
        }
        TextObject textObject = new TextObject();
        textObject.text = str4;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.textObject = textObject;
        weiboMultiMessage.mediaObject = webpageObject;
        return n(activity, weiboMultiMessage);
    }

    public boolean t(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, activity, str, str2)).booleanValue();
        }
        if (!b(activity)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!i(activity).isWBAppSupportMultipleImage()) {
                QLog.d("WBShareHelper", 1, "shareVideo not support Multi Image");
                w.c(activity, "\u7248\u672c\u8f83\u4f4e\uff0c\u4e0d\u652f\u6301\u89c6\u9891\u5206\u4eab");
                return false;
            }
            QLog.d("WBShareHelper", 1, "shareUrl text=", str, ", videoPath=", str2);
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            TextObject textObject = new TextObject();
            textObject.text = str;
            weiboMultiMessage.textObject = textObject;
            VideoSourceObject videoSourceObject = new VideoSourceObject();
            videoSourceObject.videoPath = Uri.fromFile(new File(str2));
            weiboMultiMessage.videoSourceObject = videoSourceObject;
            return n(activity, weiboMultiMessage);
        }
        QLog.d("WBShareHelper", 1, "shareVideo invalid params");
        w.c(activity, "\u53c2\u6570\u4e0d\u5408\u6cd5\uff0c\u7981\u6b62\u5206\u4eab");
        return false;
    }
}
