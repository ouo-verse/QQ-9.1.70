package com.qzone.business.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ch;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.util.ToastUtil;
import com.qzone.util.aj;
import com.qzone.util.image.c;
import com.qzone.util.l;
import com.qzone.util.z;
import com.tencent.ark.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.QQCustomArkDialogUtil;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShareUtils {

    /* renamed from: a, reason: collision with root package name */
    private static Dialog f44690a;

    /* renamed from: b, reason: collision with root package name */
    private static String f44691b = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageShareWithPerssion", "\u4f60\u7684\u7a7a\u95f4\u6709\u6743\u9650\uff0c\u5206\u4eab\u51fa\u53bb\u7684\u9875\u9762\u6240\u6709\u4eba\u90fd\u53ef\u4ee5\u770b");

    /* renamed from: c, reason: collision with root package name */
    private static String f44692c = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleShareWithPerssion", "\u63d0\u793a");

    /* renamed from: d, reason: collision with root package name */
    private static String f44693d = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogButtonShareWithPerssion", "\u7ee7\u7eed\u5206\u4eab");

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CancelRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public ShareImageloaderListener f44694d;

        /* renamed from: e, reason: collision with root package name */
        public ImageLoader.Options f44695e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference<QQProgressDialog> f44696f;

        public CancelRunnable(QQProgressDialog qQProgressDialog, ShareImageloaderListener shareImageloaderListener, ImageLoader.Options options) {
            if (qQProgressDialog != null) {
                this.f44696f = new WeakReference<>(qQProgressDialog);
            }
            this.f44694d = shareImageloaderListener;
            this.f44695e = options;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44694d.G) {
                return;
            }
            QZLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, "wxshare img download timeout");
            ImageLoader imageLoader = ImageLoader.getInstance();
            ShareImageloaderListener shareImageloaderListener = this.f44694d;
            imageLoader.cancel(shareImageloaderListener.D, shareImageloaderListener, this.f44695e);
            WeakReference<QQProgressDialog> weakReference = this.f44696f;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            QQProgressDialog qQProgressDialog = this.f44696f.get();
            if (qQProgressDialog.isShowing()) {
                qQProgressDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements s52.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f44706a;

        a(Handler handler) {
            this.f44706a = handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements s52.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f44707a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f44708b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f44709c;

        b(f fVar, Activity activity, int i3) {
            this.f44707a = fVar;
            this.f44708b = activity;
            this.f44709c = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements IQzoneShareApi.WXShareListener {
        c() {
        }

        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            int i3 = baseResp.errCode;
            if (i3 == 0) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShared", "\u5df2\u5206\u4eab"), 5);
                return;
            }
            if (i3 != -2) {
                ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShareFail", ShareJsPlugin.ERRMSG_INVITE_REQUIRE) + ":" + i3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("wx share fail:");
                sb5.append(i3);
                QZLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, sb5.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d extends g {

        /* renamed from: h, reason: collision with root package name */
        private c.a f44710h = new c.a(0, 0);

        public static d a(PhotoInfo photoInfo, PhotoParam photoParam, c.a aVar) {
            String str;
            String str2;
            String c16;
            int i3;
            String str3;
            Object obj;
            String str4;
            int i16;
            int i17;
            PictureUrl pictureUrl;
            d dVar = new d();
            dVar.f44740a = photoInfo.shareWeixinUrl;
            if (TextUtils.isEmpty(photoInfo.albumName)) {
                str = photoInfo.shareTitle;
            } else {
                str = photoInfo.albumName;
            }
            dVar.f44741b = str;
            dVar.f44742c = photoInfo.shareSummary;
            if (!TextUtils.isEmpty(photoInfo.sharePhotoUrl)) {
                str2 = photoInfo.sharePhotoUrl;
            } else if (!TextUtils.isEmpty(photoInfo.currentUrl)) {
                str2 = photoInfo.currentUrl;
            } else {
                str2 = photoInfo.bigUrl;
            }
            dVar.f44743d = str2;
            boolean b16 = z.b(photoInfo);
            if (b16 && (pictureUrl = photoInfo.videodata.coverUrl) != null) {
                c16 = pictureUrl.url;
            } else {
                c16 = aj.c(photoInfo);
            }
            if (c16 != null) {
                c16 = c16.replace("&t=6", "");
            }
            if (photoInfo.videoflag == 0 && c16 != null && !c16.startsWith("https")) {
                c16 = c16.replaceFirst("^http", "https");
            }
            if (aVar != null) {
                dVar.f44710h = aVar;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u5206\u4eab\u7ed9\u4f601");
            sb5.append(l.a(b16 ? R.string.tf7 : R.string.f172700tf4));
            dVar.f44741b = sb5.toString();
            dVar.f44746g = "";
            dVar.f44744e = "gh_4c0cc223391a";
            if (b16) {
                i3 = 1000;
            } else {
                try {
                    i3 = photoInfo.photoType;
                } catch (UnsupportedEncodingException e16) {
                    QZLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, 2, "fromPhotoInfo", e16);
                }
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("/pages/gallery/gallery?id=");
            sb6.append(photoInfo.lloc);
            sb6.append("&shareFlag=1&shareTitle=");
            sb6.append(URLEncoder.encode(dVar.f44741b, "UTF-8"));
            sb6.append("&videoFlag=");
            sb6.append(photoInfo.videoflag);
            sb6.append("&vid=");
            if (!b16) {
                str3 = "";
            } else {
                str3 = photoInfo.videodata.videoId;
            }
            sb6.append(str3);
            sb6.append("&videoTime=");
            if (!b16) {
                obj = "";
            } else {
                obj = Long.valueOf(photoInfo.videodata.videoTime);
            }
            sb6.append(obj);
            sb6.append("&videoUrl=");
            if (!b16) {
                str4 = "";
            } else {
                str4 = URLEncoder.encode(photoInfo.videodata.videoUrl.url, "UTF-8");
            }
            sb6.append(str4);
            sb6.append("&sizeWidth=");
            if (b16) {
                i16 = photoInfo.videodata.width;
            } else {
                i16 = dVar.f44710h.f59812a;
            }
            sb6.append(i16);
            sb6.append("&sizeHeight=");
            if (b16) {
                i17 = photoInfo.videodata.height;
            } else {
                i17 = dVar.f44710h.f59813b;
            }
            sb6.append(i17);
            sb6.append("&from=");
            sb6.append(QUA.getQUA3());
            sb6.append("&uin=");
            sb6.append(LoginData.getInstance().getUinString());
            sb6.append("&ownerUin=");
            long j3 = 0;
            if (photoParam != null) {
                long j16 = photoParam.realOwnerUin;
                j3 = j16 != 0 ? j16 : photoParam.ownerUin;
            }
            sb6.append(j3);
            sb6.append("&albumId=");
            sb6.append(photoInfo.albumId);
            sb6.append("&shareTime=");
            sb6.append(System.currentTimeMillis());
            sb6.append("&qzoneAppId=");
            sb6.append(photoParam != null ? photoParam.appid : 0);
            sb6.append("&photoType=");
            sb6.append(String.valueOf(i3));
            sb6.append("&picUrl=");
            sb6.append(URLEncoder.encode(c16 != null ? c16 : "", "UTF-8"));
            dVar.f44745f = sb6.toString();
            return dVar;
        }

        public static d b(PhotoInfo photoInfo, String str, String str2, String str3) {
            String str4;
            String str5;
            d dVar = new d();
            dVar.f44740a = photoInfo.shareWeixinUrl;
            if (TextUtils.isEmpty(photoInfo.albumName)) {
                str4 = photoInfo.shareTitle;
            } else {
                str4 = photoInfo.albumName;
            }
            dVar.f44741b = str4;
            dVar.f44742c = photoInfo.shareSummary;
            if (!TextUtils.isEmpty(photoInfo.sharePhotoUrl)) {
                str5 = photoInfo.sharePhotoUrl;
            } else if (!TextUtils.isEmpty(photoInfo.currentUrl)) {
                str5 = photoInfo.currentUrl;
            } else {
                str5 = photoInfo.bigUrl;
            }
            dVar.f44743d = str5;
            if (TextUtils.isEmpty(str3)) {
                boolean b16 = z.b(photoInfo);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(l.a(R.string.tfe));
                sb5.append(l.a(b16 ? R.string.tfd : R.string.tf_));
                dVar.f44741b = sb5.toString();
            } else {
                dVar.f44741b = str3;
            }
            dVar.f44746g = "";
            dVar.f44744e = str;
            dVar.f44745f = str2;
            return dVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class e extends g {

        /* renamed from: h, reason: collision with root package name */
        public int f44711h;

        /* renamed from: i, reason: collision with root package name */
        public String f44712i;

        /* renamed from: j, reason: collision with root package name */
        public int f44713j;

        /* renamed from: k, reason: collision with root package name */
        public String f44714k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f44715l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f44716m;

        /* renamed from: n, reason: collision with root package name */
        public long f44717n;

        /* renamed from: o, reason: collision with root package name */
        public int f44718o;

        /* renamed from: p, reason: collision with root package name */
        public String f44719p;

        /* renamed from: q, reason: collision with root package name */
        public String f44720q;

        /* renamed from: r, reason: collision with root package name */
        public String f44721r;

        /* renamed from: s, reason: collision with root package name */
        public String f44722s;

        /* renamed from: t, reason: collision with root package name */
        public String f44723t;

        /* renamed from: u, reason: collision with root package name */
        public String f44724u;

        /* renamed from: v, reason: collision with root package name */
        public String f44725v;

        /* renamed from: w, reason: collision with root package name */
        public String f44726w;

        /* renamed from: x, reason: collision with root package name */
        public String f44727x;

        public String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("app")) {
                    return "";
                }
                return jSONObject.get("app").toString();
            } catch (JSONException e16) {
                QZLog.e("QZoneSharePanel", "[getViewIdFromArkContent] error: ", e16);
                return "";
            }
        }

        public void b(String str, String str2, String str3) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("prompt")) {
                    this.f44723t = jSONObject.get("prompt").toString();
                }
                if (jSONObject.has(DownloadInfo.spKey_Config)) {
                    this.f44724u = jSONObject.get(DownloadInfo.spKey_Config).toString();
                }
                if (jSONObject.has("desc")) {
                    this.f44725v = jSONObject.get("desc").toString();
                }
                if (jSONObject.has(PublicAccountMessageUtilImpl.META_NAME)) {
                    this.f44722s = jSONObject.getJSONObject(PublicAccountMessageUtilImpl.META_NAME).toString();
                } else {
                    this.f44722s = jSONObject.toString();
                }
                if (jSONObject.has(QQCustomArkDialogUtil.BIZ_SRC)) {
                    this.f44727x = jSONObject.get(QQCustomArkDialogUtil.BIZ_SRC).toString();
                }
                if (jSONObject.has("view")) {
                    this.f44726w = jSONObject.get("view").toString();
                }
                this.f44721r = str3;
                this.f44720q = str2;
                this.f44711h = 39;
            } catch (JSONException e16) {
                QZLog.e(str3, "update ark share data", e16);
            }
        }

        public void c(String str, String str2, String str3, String str4) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String replace = str4.replace("https://", "").replace("http://", "");
                if (jSONObject.has("prompt")) {
                    this.f44723t = jSONObject.get("prompt").toString();
                }
                if (jSONObject.has(DownloadInfo.spKey_Config)) {
                    this.f44724u = jSONObject.get(DownloadInfo.spKey_Config).toString();
                }
                if (jSONObject.has("desc")) {
                    this.f44725v = jSONObject.get("desc").toString();
                }
                if (jSONObject.has(PublicAccountMessageUtilImpl.META_NAME)) {
                    if (jSONObject.getJSONObject(PublicAccountMessageUtilImpl.META_NAME).has("albumData")) {
                        jSONObject.getJSONObject(PublicAccountMessageUtilImpl.META_NAME).getJSONObject("albumData").put("h5Url", replace);
                    }
                    this.f44722s = jSONObject.getJSONObject(PublicAccountMessageUtilImpl.META_NAME).toString();
                } else {
                    if (jSONObject.has("albumData")) {
                        jSONObject.getJSONObject("albumData").put("h5Url", replace);
                    }
                    this.f44722s = jSONObject.toString();
                }
                if (jSONObject.has(QQCustomArkDialogUtil.BIZ_SRC)) {
                    this.f44727x = jSONObject.get(QQCustomArkDialogUtil.BIZ_SRC).toString();
                }
                if (jSONObject.has("view")) {
                    this.f44726w = jSONObject.get("view").toString();
                }
                this.f44721r = str3;
                this.f44720q = str2;
                this.f44711h = 39;
            } catch (JSONException e16) {
                QZLog.e(str3, "update ark share data", e16);
            }
        }

        public void d(String str, String str2, String str3, String str4, String str5, String str6) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str6.replace("https://", "").replace("http://", "");
                if (jSONObject.has("prompt")) {
                    this.f44723t = jSONObject.get("prompt").toString();
                }
                if (jSONObject.has(DownloadInfo.spKey_Config)) {
                    this.f44724u = jSONObject.get(DownloadInfo.spKey_Config).toString();
                }
                if (jSONObject.has("desc")) {
                    this.f44725v = jSONObject.get("desc").toString();
                }
                if (jSONObject.has(PublicAccountMessageUtilImpl.META_NAME)) {
                    this.f44722s = jSONObject.get(PublicAccountMessageUtilImpl.META_NAME).toString();
                }
                if (jSONObject.has(QQCustomArkDialogUtil.BIZ_SRC)) {
                    this.f44727x = jSONObject.get(QQCustomArkDialogUtil.BIZ_SRC).toString();
                }
                if (jSONObject.has("view")) {
                    this.f44726w = jSONObject.get("view").toString();
                }
                this.f44721r = str3;
                this.f44720q = str2;
                this.f44711h = 39;
            } catch (JSONException e16) {
                QZLog.e(str3, "update ark share data", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class f extends g {

        /* renamed from: h, reason: collision with root package name */
        public String f44728h;

        /* renamed from: i, reason: collision with root package name */
        public int f44729i;

        /* renamed from: j, reason: collision with root package name */
        public int f44730j;

        /* renamed from: k, reason: collision with root package name */
        public int f44731k;

        /* renamed from: l, reason: collision with root package name */
        public int f44732l;

        /* renamed from: m, reason: collision with root package name */
        public String f44733m;

        /* renamed from: n, reason: collision with root package name */
        public int f44734n = 2;

        /* renamed from: o, reason: collision with root package name */
        public String f44735o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f44736p;

        /* renamed from: q, reason: collision with root package name */
        public long f44737q;

        /* renamed from: r, reason: collision with root package name */
        public int f44738r;

        /* renamed from: s, reason: collision with root package name */
        public String f44739s;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public String f44740a;

        /* renamed from: b, reason: collision with root package name */
        public String f44741b;

        /* renamed from: c, reason: collision with root package name */
        public String f44742c;

        /* renamed from: d, reason: collision with root package name */
        public String f44743d;

        /* renamed from: e, reason: collision with root package name */
        public String f44744e;

        /* renamed from: f, reason: collision with root package name */
        public String f44745f;

        /* renamed from: g, reason: collision with root package name */
        public String f44746g;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("ShareData{");
            stringBuffer.append("detailUrl='");
            stringBuffer.append(this.f44740a);
            stringBuffer.append('\'');
            stringBuffer.append(", title='");
            stringBuffer.append(this.f44741b);
            stringBuffer.append('\'');
            stringBuffer.append(", summary='");
            stringBuffer.append(this.f44742c);
            stringBuffer.append('\'');
            stringBuffer.append(", sharePhotoUrl='");
            stringBuffer.append(this.f44743d);
            stringBuffer.append('\'');
            stringBuffer.append(", wxminiprogramid='");
            stringBuffer.append(this.f44744e);
            stringBuffer.append('\'');
            stringBuffer.append(", wxminiprogrampath='");
            stringBuffer.append(this.f44745f);
            stringBuffer.append('\'');
            stringBuffer.append(", wxminiprogramsharekey='");
            stringBuffer.append(this.f44746g);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public static boolean a(String str, String str2) {
        boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHARE_BATCH_PHOTO_TO_MINIPROGRAM, 1) == 1;
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        return z16 && iQzoneShareApi.isWXinstalled() && iQzoneShareApi.isWxSupportMiniProgramm() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2);
    }

    public static int c(int i3, boolean z16, int i16, int i17) {
        if (z16 && i3 == 311 && i17 != 1) {
            return 3;
        }
        return 0;
    }

    protected static String f() {
        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(System.currentTimeMillis()));
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str);
            return TextUtils.isEmpty(parse.getQueryParameter("g_f")) ? parse.buildUpon().appendQueryParameter("g_f", String.valueOf(2000000393)).build().toString() : str;
        } catch (Exception e16) {
            QZLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, e16.getStackTrace().toString());
            return str;
        }
    }

    public static String h(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("t=6")) ? str : yo.f.f(str, "t");
    }

    public static void i(Handler handler, String str) {
        if (TextUtils.isEmpty(str)) {
            m(handler, false, "videoUrl is empty", null);
        } else {
            ((IThirdVideoManager) QRoute.api(IThirdVideoManager.class)).sendUrlToUUIDRequest(str, new a(handler));
        }
    }

    private static boolean j(String str) {
        return TextUtils.equals(str, "com.tencent.qzone.albumInvite") || TextUtils.equals(str, "com.tencent.qqlover.inviteark") || TextUtils.equals(str, "com.tencent.qzone.video") || TextUtils.equals(str, "com.tencent.qzone.albumShare") || TextUtils.equals(str, "com.tencent.wezone.share");
    }

    public static boolean k() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHARE_OUTSITE_PENETRATE_ARK, 1) == 1;
    }

    public static void l() {
        ClickReport.m("302", WadlProxyConsts.OPER_TYPE_MONITOR, "7");
    }

    private static void m(Handler handler, boolean z16, String str, String str2) {
        QZoneResult qZoneResult = new QZoneResult(1000084);
        qZoneResult.setSucceed(z16);
        qZoneResult.setMessage(str);
        if (z16) {
            qZoneResult.setData(str2);
        }
        qZoneResult.sendToHandler(handler);
    }

    public static void s(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle(f44692c);
        qQCustomDialog.setMessage(f44691b);
        qQCustomDialog.setPositiveButton(f44693d, onClickListener);
        qQCustomDialog.setNegativeButton(l.a(R.string.j6l), onClickListener2);
        qQCustomDialog.show();
    }

    public static void u() {
        ClickReport.m("302", WadlProxyConsts.OPER_TYPE_MONITOR, "8");
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ShareImageloaderListener implements ImageLoader.ImageLoadListener {
        private QQProgressDialog C;
        public String D;
        int E;
        g F;
        public volatile boolean G = false;

        /* renamed from: d, reason: collision with root package name */
        private Activity f44697d;

        /* renamed from: e, reason: collision with root package name */
        private IQzoneShareApi f44698e;

        /* renamed from: f, reason: collision with root package name */
        private String f44699f;

        /* renamed from: h, reason: collision with root package name */
        private String f44700h;

        /* renamed from: i, reason: collision with root package name */
        private String f44701i;

        /* renamed from: m, reason: collision with root package name */
        private int f44702m;

        public ShareImageloaderListener(Activity activity, IQzoneShareApi iQzoneShareApi, String str, String str2, String str3, int i3, QQProgressDialog qQProgressDialog, String str4, g gVar, int i16) {
            this.f44697d = activity;
            this.f44698e = iQzoneShareApi;
            this.f44699f = str;
            this.f44700h = str2;
            this.f44701i = str3;
            this.f44702m = i3;
            this.C = qQProgressDialog;
            this.D = str4;
            this.F = gVar;
            this.E = i16;
        }

        public void h(final Bitmap bitmap, final boolean z16) {
            if (this.G) {
                return;
            }
            this.G = true;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.business.share.ShareUtils.ShareImageloaderListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ShareImageloaderListener.this.f44697d.runOnUiThread(new Runnable() { // from class: com.qzone.business.share.ShareUtils.ShareImageloaderListener.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ShareImageloaderListener.this.C != null && ShareImageloaderListener.this.C.isShowing()) {
                                ShareImageloaderListener.this.C.dismiss();
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            Bitmap bitmap2 = bitmap;
                            if (!z16 && (bitmap2 == null || bitmap2.isRecycled())) {
                                bitmap2 = j.g(ShareImageloaderListener.this.f44697d.getResources(), R.drawable.qzone_icon_action_sheet_qzone);
                            }
                            Bitmap bitmap3 = bitmap2;
                            QZLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, "wxshare img null,download succeed:" + bitmap + "url:" + ShareImageloaderListener.this.F.f44743d);
                            ShareImageloaderListener shareImageloaderListener = ShareImageloaderListener.this;
                            if (shareImageloaderListener.E == 1 && shareImageloaderListener.f44702m == 0) {
                                IQzoneShareApi iQzoneShareApi = ShareImageloaderListener.this.f44698e;
                                String str = ShareImageloaderListener.this.f44699f;
                                String str2 = ShareImageloaderListener.this.f44700h;
                                String str3 = ShareImageloaderListener.this.f44701i;
                                ShareImageloaderListener shareImageloaderListener2 = ShareImageloaderListener.this;
                                g gVar = shareImageloaderListener2.F;
                                iQzoneShareApi.shareMiniProgram(str, bitmap3, str2, str3, gVar.f44745f, gVar.f44744e, gVar.f44746g, shareImageloaderListener2.f44702m);
                                return;
                            }
                            ShareImageloaderListener.this.f44698e.shareWebPage(ShareImageloaderListener.this.f44699f, bitmap3, ShareImageloaderListener.this.f44700h, ShareImageloaderListener.this.f44701i, ShareImageloaderListener.this.f44702m);
                        }
                    });
                }
            });
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            h(com.qzone.util.image.c.o(drawable), true);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            h(null, false);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            h(null, false);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public static boolean q(Activity activity, int i3, g gVar) {
        return r(activity, i3, gVar, 0);
    }

    private static void t(Activity activity, String str) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        ReportDialog reportDialog = new ReportDialog(activity, R.style.f174269ui);
        f44690a = reportDialog;
        reportDialog.setContentView(R.layout.bqd);
        f44690a.findViewById(R.id.kja).setVisibility(8);
        f44690a.findViewById(R.id.cib).setVisibility(0);
        ((TextView) f44690a.findViewById(R.id.dialogText)).setText(str);
        f44690a.show();
    }

    public static boolean o(Activity activity, f fVar, int i3) {
        if (activity == null || fVar == null || TextUtils.isEmpty(fVar.f44728h)) {
            return false;
        }
        if (TextUtils.isEmpty(fVar.f44733m)) {
            ((IThirdVideoManager) QRoute.api(IThirdVideoManager.class)).sendUrlToUUIDRequest(fVar.f44728h, new b(fVar, activity, i3));
            t(activity, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetSharingVID", "\u6b63\u5728\u83b7\u53d6\u5206\u4eabVID"));
            return true;
        }
        return e(activity, fVar, i3);
    }

    protected static boolean e(Activity activity, f fVar, int i3) {
        if (activity == null || fVar == null || TextUtils.isEmpty(fVar.f44733m)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("VINFO", fVar.f44733m);
        bundle.putString("TINFO", fVar.f44733m);
        bundle.putInt("PREVIEW_VIDEO_TIME", fVar.f44730j);
        bundle.putInt("PREVIEW_VIDEO_WIDTH", fVar.f44731k);
        bundle.putInt("PREVIEW_VIDEO_HEIGHT", fVar.f44732l);
        bundle.putInt("FULL_VIDEO_TIME", fVar.f44729i);
        bundle.putInt("TYPE", fVar.f44734n);
        bundle.putInt(AppConstants.Key.SHARE_LAYOUT_ITEM, 5);
        bundle.putBoolean(AppConstants.Key.SHARE_VIDEO_SHOULD_LOAD, false);
        bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, h(fVar.f44743d));
        bundle.putString("detail_url", g(fVar.f44740a));
        bundle.putString("video_url", fVar.f44733m);
        bundle.putString("title", fVar.f44741b);
        bundle.putString(AppConstants.Key.SHARE_REQ_CREATE_TIME, f());
        bundle.putString(AppConstants.Key.SHARE_BRIEF, fVar.f44741b);
        bundle.putString(AppConstants.Key.SHARE_REQ_QZONE_MSG, fVar.f44735o);
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 140);
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) i.e(bundle);
        if (!TextUtils.isEmpty(structMsgForGeneralShare.mMsgBrief) && structMsgForGeneralShare.mMsgBrief.indexOf(l.a(R.string.tf9)) == -1) {
            structMsgForGeneralShare.mMsgBrief = l.a(R.string.tf6) + structMsgForGeneralShare.mMsgBrief;
        }
        com.tencent.biz.pubaccount.util.g.b(structMsgForGeneralShare);
        structMsgForGeneralShare.mSourceAppid = 1103584836L;
        structMsgForGeneralShare.mSourceAction = "web";
        structMsgForGeneralShare.mSourceUrl = "";
        structMsgForGeneralShare.mSourceName = activity.getString(R.string.gg_);
        structMsgForGeneralShare.mSourceIcon = "https://open.gtimg.cn/open/app_icon/03/58/48/36/1103584836_100_m.png";
        structMsgForGeneralShare.setFlag(0);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("forward_type", -3);
        bundle2.putInt("emoInputType", 2);
        bundle2.putInt(AppConstants.Key.STRUCT_MSG_SERVICE_ID, 154);
        bundle2.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, structMsgForGeneralShare.getBytes());
        bundle2.putBoolean("forwardDirect", true);
        if (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        if (fVar.f44736p) {
            Intent intent = new Intent(activity, (Class<?>) DirectForwardActivity.class);
            intent.putExtras(bundle2);
            intent.putExtra("toUin", String.valueOf(fVar.f44737q));
            intent.putExtra("uinType", fVar.f44738r);
            intent.putExtra("nickName", fVar.f44739s);
            activity.startActivityForResult(intent, i3);
        } else {
            Intent intent2 = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
            intent2.putExtras(bundle2);
            activity.startActivityForResult(intent2, i3);
        }
        return true;
    }

    public static boolean p(Activity activity, int i3, String str, String str2, String str3, String str4) {
        if (str == null) {
            return false;
        }
        try {
            e eVar = new e();
            eVar.f44740a = str;
            eVar.f44711h = 2;
            eVar.f44743d = str2;
            eVar.f44712i = "1000027";
            eVar.f44713j = 1;
            eVar.f44742c = str3;
            eVar.f44741b = str4;
            eVar.f44715l = true;
            Intent intent = new Intent(activity, (Class<?>) TroopActivity.class);
            intent.putExtra("forward_type", eVar.f44711h);
            intent.putExtra("call_by_forward", true);
            if (!TextUtils.isEmpty(eVar.f44712i)) {
                intent.putExtra("req_share_id", Long.parseLong(eVar.f44712i));
            }
            intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, h(eVar.f44743d));
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, eVar.f44713j);
            if (!TextUtils.isEmpty(eVar.f44740a)) {
                intent.putExtra("detail_url", g(eVar.f44740a));
            }
            intent.putExtra("title", eVar.f44741b);
            intent.putExtra("desc", eVar.f44742c);
            intent.putExtra("refuse_show_share_result_dialog", eVar.f44715l);
            intent.putExtra(AppConstants.Key.FORWARD_SEND_TO_UIN, eVar.f44717n);
            intent.putExtra(AppConstants.Key.FORWARD_SEND_TO_UIN_NICKNAME, eVar.f44719p);
            activity.startActivityForResult(intent, i3);
        } catch (NumberFormatException e16) {
            QLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, 1, e16, new Object[0]);
            ToastUtil.n(R.string.gjn);
        }
        return false;
    }

    public static boolean n(Activity activity, e eVar, int i3) {
        Intent intent;
        Bundle a16;
        if (eVar != null && activity != null) {
            try {
                if (eVar.f44716m) {
                    if (activity instanceof BasePluginActivity) {
                        intent = new Intent(((BasePluginActivity) activity).getOutActivity(), (Class<?>) DirectForwardActivity.class);
                    } else {
                        intent = new Intent(activity, (Class<?>) DirectForwardActivity.class);
                    }
                    intent.putExtra("toUin", String.valueOf(eVar.f44717n));
                    intent.putExtra("uinType", eVar.f44718o);
                    intent.putExtra("nickName", eVar.f44719p);
                } else if (activity instanceof BasePluginActivity) {
                    intent = new Intent(((BasePluginActivity) activity).getOutActivity(), (Class<?>) ForwardRecentActivity.class);
                } else {
                    intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
                }
                intent.putExtra("forward_type", eVar.f44711h);
                if (QZoneConfigHelper.v()) {
                    intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
                }
                if (!TextUtils.isEmpty(eVar.f44712i)) {
                    intent.putExtra("req_share_id", Long.parseLong(eVar.f44712i));
                }
                intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, h(eVar.f44743d));
                intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, eVar.f44713j);
                if (!TextUtils.isEmpty(eVar.f44740a)) {
                    intent.putExtra("detail_url", g(eVar.f44740a));
                }
                if (!TextUtils.isEmpty(eVar.f44722s)) {
                    new Bundle();
                    if (j(eVar.f44720q)) {
                        a16 = QQCustomArkDialog.b.a(eVar.f44720q, eVar.f44721r, "", Constants.DEFAULT_MIN_APP_VERSION, eVar.f44722s, activity.getResources().getDisplayMetrics().scaledDensity, null, null);
                    } else {
                        a16 = QQCustomArkDialog.b.a(eVar.f44721r, eVar.f44726w, eVar.f44727x, Constants.DEFAULT_MIN_APP_VERSION, eVar.f44722s, activity.getResources().getDisplayMetrics().scaledDensity, null, null);
                    }
                    intent.putExtras(a16);
                    intent.putExtra("forward_ark_app_meta", eVar.f44722s);
                    intent.putExtra("is_ark_display_share", true);
                }
                if (j(eVar.f44720q)) {
                    if (!TextUtils.isEmpty(eVar.f44721r)) {
                        intent.putExtra("forward_ark_app_view", eVar.f44721r);
                    }
                    if (!TextUtils.isEmpty(eVar.f44720q)) {
                        intent.putExtra("forward_ark_app_name", eVar.f44720q);
                    }
                } else {
                    if (!TextUtils.isEmpty(eVar.f44721r)) {
                        intent.putExtra("forward_ark_app_name", eVar.f44721r);
                    }
                    if (!TextUtils.isEmpty(eVar.f44727x)) {
                        intent.putExtra("forward_ark_biz_src", eVar.f44727x);
                    } else if (!TextUtils.isEmpty(eVar.f44720q)) {
                        intent.putExtra("forward_ark_biz_src", eVar.f44720q);
                    }
                }
                if (!TextUtils.isEmpty(eVar.f44723t)) {
                    intent.putExtra("forward_ark_app_prompt", eVar.f44723t);
                }
                if (!TextUtils.isEmpty(eVar.f44724u)) {
                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, eVar.f44724u);
                }
                if (!TextUtils.isEmpty(eVar.f44725v)) {
                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, eVar.f44725v);
                }
                if (!TextUtils.isEmpty(eVar.f44726w) && !j(eVar.f44720q)) {
                    intent.putExtra("forward_ark_app_view", eVar.f44726w);
                }
                intent.putExtra("title", eVar.f44741b);
                intent.putExtra("desc", eVar.f44742c);
                intent.putExtra("refuse_show_share_result_dialog", eVar.f44715l);
                intent.putExtra(AppConstants.Key.FORWARD_SEND_TO_UIN, eVar.f44717n);
                intent.putExtra(AppConstants.Key.FORWARD_SEND_TO_UIN_NICKNAME, eVar.f44719p);
                intent.putExtra(AppConstants.Key.STRUCT_MSG_SERVICE_ID, 154);
                activity.startActivityForResult(intent, i3);
            } catch (NumberFormatException e16) {
                QLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, 1, e16, new Object[0]);
                ToastUtil.n(R.string.gjn);
            }
        }
        return false;
    }

    public static boolean r(Activity activity, int i3, g gVar, int i16) {
        Bitmap o16;
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        if (!iQzoneShareApi.isWXinstalled()) {
            ToastUtil.n(R.string.gjp);
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(activity);
            return false;
        }
        if (i3 == 9 && !iQzoneShareApi.isWxSupportMiniProgramm()) {
            ToastUtil.n(R.string.gjq);
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(activity);
            return false;
        }
        if (i3 == 10 && !iQzoneShareApi.isWxSupportTimeLine()) {
            ToastUtil.n(R.string.gjq);
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(activity);
            return false;
        }
        if (gVar != null) {
            try {
                String str = gVar.f44741b;
                String str2 = gVar.f44742c;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "m.qzone.com";
                }
                String str3 = str2;
                String str4 = gVar.f44740a + "&g_f=2000000392";
                if (!gVar.f44740a.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str4 = gVar.f44740a + "?g_f=2000000392";
                }
                String str5 = str4;
                ImageLoader.Options obtain = ImageLoader.Options.obtain();
                obtain.clipWidth = 400;
                obtain.clipHeight = 400;
                Drawable b16 = ch.b(gVar.f44743d);
                QZLog.d(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, 1, "wxshare img:" + b16 + ",url:" + gVar.f44743d);
                if (b16 == null) {
                    b16 = ImageLoader.getInstance().loadImage(gVar.f44743d, (ImageLoader.ImageLoadListener) null, obtain);
                }
                if (b16 != null && (b16 instanceof BitmapDrawable)) {
                    o16 = ((BitmapDrawable) b16).getBitmap();
                } else {
                    o16 = com.qzone.util.image.c.o(b16);
                    QZLog.e(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, "wxshare img not bitmapDrawable:" + o16 + ",url:" + gVar.f44743d);
                }
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(new c());
                int i17 = i3 == 9 ? 0 : 1;
                if ((o16 == null || o16.isRecycled()) && gVar.f44743d != null) {
                    QQProgressDialog qQProgressDialog = new QQProgressDialog(activity);
                    qQProgressDialog.setMessage(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetSharingPicture", "\u6b63\u5728\u83b7\u53d6\u56fe\u7247"));
                    ShareImageloaderListener shareImageloaderListener = new ShareImageloaderListener(activity, iQzoneShareApi, str, str3, str5, i17, qQProgressDialog, gVar.f44743d, gVar, i16);
                    ImageLoader.getInstance().loadImage(gVar.f44743d, shareImageloaderListener, obtain);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new CancelRunnable(qQProgressDialog, shareImageloaderListener, obtain), 10000L);
                    qQProgressDialog.show();
                    return false;
                }
                if (i16 == 1 && i17 == 0) {
                    iQzoneShareApi.shareMiniProgram(str, o16, str3, str5, gVar.f44745f, gVar.f44744e, gVar.f44746g, i17);
                } else {
                    iQzoneShareApi.shareWebPage(str, o16, str3, str5, i17);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                ToastUtil.o(R.string.gjn, 4);
            }
        }
        return false;
    }

    public static int b(boolean z16, int i3, int i16, boolean z17) {
        if (!z16 || (i16 == 1 && i3 == 1)) {
            if (z16 || i16 == 1) {
                return (z16 || i3 == 1) ? 0 : 4;
            }
            return 4;
        }
        if (!z17) {
            return 3;
        }
        ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastContentHasPerssion", "\u4e3b\u4eba\u7a7a\u95f4\u6709\u6743\u9650\uff0c\u4ec5\u5141\u8bb8\u7a7a\u95f4\u5185\u8f6c\u53d1"));
        return 3;
    }

    public static int d(boolean z16, int i3, int i16, boolean z17, boolean z18) {
        if (z18) {
            return (i16 == 1 && i3 == 1) ? 0 : 4;
        }
        if (z16) {
            if (QZLog.isColorLevel()) {
                QZLog.d(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, 2, "share in guest, spaceRight=" + i3 + ", albumRight=" + i16 + ", isVideoForwardWeiXin=" + z18);
            }
            if (i16 != 1) {
                if (z17) {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastAlbumHasPerssion", "\u4e3b\u4eba\u76f8\u518c\u6709\u6743\u9650\uff0c\u4ec5\u5141\u8bb8\u7a7a\u95f4\u5185\u8f6c\u53d1"));
                }
                return 1;
            }
            if (i3 != 1) {
                if (z17) {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastUserHomeHasPerssion", "\u4e3b\u4eba\u7a7a\u95f4\u6709\u6743\u9650\uff0c\u4ec5\u5141\u8bb8\u7a7a\u95f4\u5185\u8f6c\u53d1"));
                }
                return 2;
            }
        } else {
            if (QZLog.isColorLevel()) {
                QZLog.d(com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.TAG, 2, "share in host, spaceRight=" + i3 + ", albumRight=" + i16);
            }
            if (i16 != 1) {
                if (!z17) {
                    return 3;
                }
                ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastContentHasPerssion", "\u8be5\u5185\u5bb9\u6709\u6743\u9650\uff0c\u4ec5\u5141\u8bb8\u7a7a\u95f4\u5185\u8f6c\u53d1"));
                return 3;
            }
            if (i3 != 1) {
                return 4;
            }
        }
        return 0;
    }
}
