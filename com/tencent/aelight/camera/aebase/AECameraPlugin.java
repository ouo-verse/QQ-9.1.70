package com.tencent.aelight.camera.aebase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.ab;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class AECameraPlugin extends WebViewPlugin {
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private String f65963d;

    /* renamed from: e, reason: collision with root package name */
    private int f65964e = -1;

    /* renamed from: f, reason: collision with root package name */
    private DownloadRunnable f65965f;

    /* renamed from: h, reason: collision with root package name */
    private int f65966h;

    /* renamed from: i, reason: collision with root package name */
    private int f65967i;

    /* renamed from: m, reason: collision with root package name */
    private double f65968m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class DownloadRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        AppInterface f65976d;

        /* renamed from: e, reason: collision with root package name */
        String f65977e;

        /* renamed from: f, reason: collision with root package name */
        String f65978f;

        /* renamed from: h, reason: collision with root package name */
        INetEngineListener f65979h;

        /* renamed from: i, reason: collision with root package name */
        String f65980i;

        DownloadRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AECameraPlugin.J(this.f65976d, this.f65977e, this.f65978f, this.f65979h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ INetEngineListener f65989d;

        d(INetEngineListener iNetEngineListener) {
            this.f65989d = iNetEngineListener;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            INetEngineListener iNetEngineListener = this.f65989d;
            if (iNetEngineListener != null) {
                iNetEngineListener.onResp(netResp);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            INetEngineListener iNetEngineListener = this.f65989d;
            if (iNetEngineListener != null) {
                iNetEngineListener.onUpdateProgeress(netReq, j3, j16);
            }
        }
    }

    /* loaded from: classes32.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f65990a;

        /* renamed from: b, reason: collision with root package name */
        public int f65991b;

        /* renamed from: c, reason: collision with root package name */
        public double f65992c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f65993d;

        /* renamed from: e, reason: collision with root package name */
        public String f65994e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f65995f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f65996g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f65997h;
    }

    static {
        File file = new File(g.c.a.f65286d);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (Y(BaseApplication.getContext())) {
            File file2 = new File(com.tencent.aelight.camera.ae.g.a());
            if (file2.exists()) {
                return;
            }
            file2.mkdirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject B(String str, int i3) throws IOException, JSONException, OutOfMemoryError {
        g0(str);
        String H = H(str, i3);
        StringBuilder K = K(H);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("succeeded", true);
        jSONObject.put("picData", K);
        jSONObject.put("picPath", H);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject C(String str, int i3, int i16) throws IOException, JSONException, OutOfMemoryError {
        g0(str);
        String I = I(str, i3, i16);
        StringBuilder K = K(I);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("succeeded", true);
        jSONObject.put("picData", K);
        jSONObject.put("picPath", I);
        return jSONObject;
    }

    private JSONObject D(js.a aVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (str2 == null) {
                jSONObject.put("succeeded", true);
                jSONObject.put("message", "");
            } else {
                jSONObject.put("succeeded", false);
                jSONObject.put("message", str2);
            }
            if (aVar != null) {
                jSONObject.put("sourceType", aVar.b());
                jSONObject.put("sourceBusiness", aVar.a());
            }
            if (str == null) {
                str = "";
            }
            jSONObject.put("activityID", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject E(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("succeeded", false);
            jSONObject.put("message", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject F(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("succeeded", false);
            jSONObject.put("message", str2);
            jSONObject.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject G(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("succeeded", true);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("message", str2);
            }
            jSONObject.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private String H(String str, int i3) {
        CompressInfo compressInfo = new CompressInfo(str, i3);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        return compressInfo.H;
    }

    private String I(String str, int i3, int i16) {
        String str2 = g.c.a.f65286d + File.separator + "ae_pic_" + System.currentTimeMillis() + ".jpeg";
        this.f65968m = 0.7d;
        BaseImageUtil.compressImageJpg(str, str2, i3, i16, (int) (0.7d * 100.0d));
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(AppInterface appInterface, String str, String str2, INetEngineListener iNetEngineListener) {
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str2;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        httpNetReq.mCallback = new d(iNetEngineListener);
        try {
            ((IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        }
        httpNetReq.mCallback.onUpdateProgeress(httpNetReq, 1L, 100L);
    }

    private StringBuilder K(String str) {
        StringBuilder sb5;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        String str2 = options.outMimeType;
        if (!"image/png".equalsIgnoreCase(str2) && !"image/gif".equals(str2) && !MimeHelper.IMAGE_BMP.equals(str2)) {
            sb5 = new StringBuilder("data:image/jpeg;base64,");
            decodeFile.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        } else {
            sb5 = new StringBuilder("data:image/png;base64,");
            decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        }
        decodeFile.recycle();
        sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        return sb5;
    }

    private String L(String str) {
        String str2 = str.split("\\.")[r0.length - 1];
        if (Y(this.mRuntime.a())) {
            return com.tencent.aelight.camera.ae.g.a() + str.hashCode() + "." + str2;
        }
        return g.c.a.f65286d + File.separator + str.hashCode() + "." + str2;
    }

    private String M(String str) {
        return g.c.a.f65286d + File.separator + str.hashCode() + "_thumb.jpg";
    }

    private static Bitmap N(String str, int i3) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, i3);
        if (createVideoThumbnail == null) {
            return createVideoThumbnail;
        }
        int width = createVideoThumbnail.getWidth();
        int height = createVideoThumbnail.getHeight();
        if (width > 300) {
            height = (int) ((300.0f / width) * height);
            width = 300;
        }
        return ThumbnailUtils.extractThumbnail(createVideoThumbnail, width, height, 2);
    }

    private void O(String str) {
        DownloadRunnable downloadRunnable = this.f65965f;
        if (downloadRunnable != null && downloadRunnable.f65977e.equals(str) && this.f65964e == 1) {
            callJs(this.f65965f.f65980i, F(str, "downloading canceled").toString());
            ThreadManagerV2.removeJobFromThreadPool(this.f65965f, 128);
        }
        this.f65965f = null;
        this.f65963d = null;
        this.f65964e = -1;
        File file = new File(L(str));
        if (file.exists()) {
            q.c(file);
        }
    }

    private void P(String str, String str2) {
        String L = L(str);
        if (!new File(L).exists()) {
            J(this.mRuntime.b(), str, L, new c(L, str2));
        } else {
            a0(str2);
            U(L);
        }
    }

    private void Q(String str, String str2) {
        int i3;
        if (!TextUtils.isEmpty(this.f65963d) && this.f65963d.equals(str) && ((i3 = this.f65964e) == 1 || i3 == 2)) {
            return;
        }
        O(str);
        this.f65963d = str;
        this.f65964e = 1;
        String L = L(str);
        b bVar = new b(str, str2, L);
        DownloadRunnable downloadRunnable = new DownloadRunnable();
        this.f65965f = downloadRunnable;
        downloadRunnable.f65976d = this.mRuntime.b();
        DownloadRunnable downloadRunnable2 = this.f65965f;
        downloadRunnable2.f65977e = str;
        downloadRunnable2.f65978f = L;
        downloadRunnable2.f65979h = bVar;
        downloadRunnable2.f65980i = str2;
        ThreadManagerV2.excute(downloadRunnable2, 128, null, true);
    }

    private void R(final String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = IAECameraPrefsUtil.KEY_WEB_SELECTED_PIC_PATH;
        }
        final String j3 = AECameraPrefsUtil.f().j(str2, "", 0);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.AECameraPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AECameraPlugin.this.callJs(str, AECameraPlugin.this.B(j3, 0).toString());
                } catch (IOException unused) {
                    AECameraPlugin.this.callJs(str, AECameraPlugin.this.E("io exception").toString());
                } catch (OutOfMemoryError unused2) {
                    AECameraPlugin.this.callJs(str, AECameraPlugin.this.E("out of memory").toString());
                } catch (JSONException unused3) {
                    AECameraPlugin.this.callJs(str, AECameraPlugin.this.E("json exception").toString());
                }
            }
        }, 64, null, true);
    }

    private void S(String str) {
        JSONObject D;
        Intent intent = this.mRuntime.a().getIntent();
        String stringExtra = this.mRuntime.a().getIntent().getStringExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID);
        if (intent == null) {
            D = D(js.a.f410904d, stringExtra, "intent is null ");
        } else {
            D = D(js.a.e(intent.getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b())), stringExtra, null);
        }
        callJs(str, D.toString());
    }

    private void T(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = IAECameraPrefsUtil.KEY_WEB_SELECTED_PIC_PATH;
        }
        AECameraPrefsUtil.f().p(str2, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str) {
        String stringExtra;
        js.a aVar;
        Intent intent = this.mRuntime.a().getIntent();
        if (intent == null) {
            aVar = js.a.f410904d;
            stringExtra = "";
        } else {
            js.a e16 = js.a.e(intent.getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
            stringExtra = intent.getStringExtra("url");
            aVar = e16;
        }
        if (gq.a.f(aVar.b()) && !TextUtils.isEmpty(stringExtra)) {
            Intent intent2 = new Intent();
            intent2.putExtra("file_send_path", str);
            intent2.putExtra(ShortVideoConstants.FILE_SEND_IS_PHOTO, true);
            try {
                String encode = URLEncoder.encode(stringExtra, "UTF-8");
                intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, encode);
                QLog.i("AECameraPlugin", 1, "handleSharePic---encodeUrl=" + encode);
            } catch (UnsupportedEncodingException unused) {
            }
            ab.i(this.mRuntime.a(), intent2);
            this.mRuntime.a().setResult(-1, intent2);
            this.mRuntime.a().finish();
            return;
        }
        try {
            ab.c(this.mRuntime.a(), str, gq.a.K(this.mRuntime.a()), 4);
        } catch (Exception unused2) {
            QQToast.makeText(this.mRuntime.a(), R.string.hit, 0).show();
        }
    }

    private void V(String str) {
        String stringExtra;
        js.a aVar;
        String L = L(str);
        String M = M(str);
        if (!new File(L).exists()) {
            QQToast.makeText(this.mRuntime.a(), R.string.hit, 0).show();
            return;
        }
        Intent intent = this.mRuntime.a().getIntent();
        if (intent == null) {
            aVar = js.a.f410904d;
            stringExtra = "";
        } else {
            js.a e16 = js.a.e(intent.getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
            stringExtra = intent.getStringExtra("url");
            aVar = e16;
        }
        if (gq.a.f(aVar.b()) && !TextUtils.isEmpty(stringExtra)) {
            Intent intent2 = new Intent();
            intent2.putExtra("file_send_path", L);
            intent2.putExtra(ShortVideoConstants.FILE_SEND_DURATION, ShortVideoUtils.getDuration(L));
            try {
                String encode = URLEncoder.encode(stringExtra, "UTF-8");
                intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, encode);
                QLog.i("AECameraPlugin", 1, "handleShareVideo---encodeUrl=" + encode);
            } catch (UnsupportedEncodingException unused) {
            }
            ab.i(this.mRuntime.a(), intent2);
            this.mRuntime.a().setResult(-1, intent2);
            this.mRuntime.a().finish();
            return;
        }
        Bitmap N = N(L, 1);
        try {
            try {
            } catch (IOException unused2) {
                QQToast.makeText(this.mRuntime.a(), R.string.hit, 0).show();
                if (N == null) {
                    return;
                }
            }
            if (Z()) {
                Intent intent3 = new Intent();
                intent3.putExtra(AECameraConstants.H5_KEY_FLAG, true);
                intent3.putExtra(AECameraConstants.H5_KEY_VIDEO_PATH, L);
                intent3.putExtra(AECameraConstants.H5_KEY_THUMB_PATH, M);
                intent3.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, URLEncoder.encode(stringExtra, "UTF-8"));
                if (N != null) {
                    BaseImageUtil.saveBitmapFileAsJPEG(N, 80, new File(M));
                }
                this.mRuntime.a().setResult(-1, intent3);
                this.mRuntime.a().finish();
                if (N != null) {
                    N.recycle();
                    return;
                }
                return;
            }
            if (N != null) {
                BaseImageUtil.saveBitmapFileAsJPEG(N, 80, new File(M));
                ab.e(this.mRuntime.a(), L, M, gq.a.K(this.mRuntime.a()), d0(21));
            } else {
                QQToast.makeText(this.mRuntime.a(), R.string.hit, 0).show();
            }
            if (N == null) {
                return;
            }
            N.recycle();
        } catch (Throwable th5) {
            if (N != null) {
                N.recycle();
            }
            throw th5;
        }
    }

    private void X(e eVar, String str) {
        this.f65966h = eVar.f65990a;
        this.f65967i = eVar.f65991b;
        this.C = str;
        gq.c.s(this.mRuntime.a(), d0(1), js.a.V.b(), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Y(Context context) {
        return PermissionUtils.isStorePermissionEnable(context);
    }

    private boolean Z() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.a() == null || this.mRuntime.a().getIntent() == null) {
            return false;
        }
        return gq.a.q(this.mRuntime.a().getIntent().getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("succeeded", true);
            jSONObject.put("message", "download success");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        callJs(str, jSONObject.toString());
    }

    private void b0(String str) {
        if (str.equals("")) {
            return;
        }
        AEResUtil.h(str);
    }

    private void c0(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.AECameraPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                AECameraPlugin.this.e0(str, str2);
            }
        }, 128, null, false);
    }

    public static int d0(int i3) {
        return i3 + (ao.b("aecamera") << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(String str, String str2) {
        AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
        aEMaterialMetaData.name = str;
        aEMaterialMetaData.f69050id = str;
        aEMaterialMetaData.resurl = str2;
        AEMaterialDownloader.l(fr.b.a(), aEMaterialMetaData, aEMaterialMetaData.getZipDownloadPath(), new a());
    }

    private void f0() {
        Intent qzoneFriendFeedActivity;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return;
        }
        if (!gq.a.K(bVar.a()) && !gq.a.L(this.mRuntime.a())) {
            qzoneFriendFeedActivity = SplashActivity.getAliasIntent(this.mRuntime.a());
            QLog.i("AECameraPlugin", 1, "toSourceActivity---to splash");
        } else {
            qzoneFriendFeedActivity = QZoneHelper.getQzoneFriendFeedActivity(this.mRuntime.a());
            QLog.i("AECameraPlugin", 1, "toSourceActivity---to Qzone Feeds");
        }
        qzoneFriendFeedActivity.addFlags(67108864);
        qzoneFriendFeedActivity.addFlags(536870912);
        this.mRuntime.a().startActivity(qzoneFriendFeedActivity);
    }

    private void g0(String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.length() >= 3) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i3 = options.outWidth;
                int i16 = options.outHeight;
                if (i3 < 0 || i16 < 0) {
                    throw new IOException();
                }
                return;
            }
            throw new IOException();
        }
        throw new IOException();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "aecamera";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"aecamera".equals(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if ("takePhoto".equals(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                e eVar = new e();
                eVar.f65990a = jSONObject.getInt("outMaxWidth");
                eVar.f65991b = jSONObject.getInt("outMaxHeight");
                eVar.f65992c = jSONObject.optDouble("compression");
                eVar.f65993d = jSONObject.optBoolean("backDevicePosition");
                eVar.f65994e = jSONObject.optString("guideImage");
                eVar.f65995f = jSONObject.optBoolean("enableCountDown");
                eVar.f65996g = jSONObject.optBoolean("sensitiveValidate");
                eVar.f65997h = jSONObject.optBoolean("disableFaceDetect");
                X(eVar, jSONObject.getString("callback"));
                return true;
            } catch (Exception e16) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e16.getMessage());
                return true;
            }
        }
        if ("setLastSelectedPicture".equals(str3)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                T(jSONObject2.optString("picPath"), jSONObject2.optString("id"));
                return true;
            } catch (Exception e17) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e17.getMessage());
                return true;
            }
        }
        if ("getLastSelectedPicture".equals(str3)) {
            try {
                JSONObject jSONObject3 = new JSONObject(strArr[0]);
                R(jSONObject3.optString("callback"), jSONObject3.optString("id"));
                return true;
            } catch (Exception e18) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e18.getMessage());
                return true;
            }
        }
        if ("downloadVideo".equals(str3)) {
            try {
                JSONObject jSONObject4 = new JSONObject(strArr[0]);
                Q(jSONObject4.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL), jSONObject4.optString("callback"));
                return true;
            } catch (Exception e19) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e19.getMessage());
                return true;
            }
        }
        if ("cancelDownload".equals(str3)) {
            try {
                O(new JSONObject(strArr[0]).optString(AppConstants.Key.KEY_QZONE_VIDEO_URL));
                return true;
            } catch (Exception e26) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e26.getMessage());
                return true;
            }
        }
        if ("shareVideo".equals(str3)) {
            try {
                V(new JSONObject(strArr[0]).optString(AppConstants.Key.KEY_QZONE_VIDEO_URL));
                return true;
            } catch (Exception e27) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e27.getMessage());
                return true;
            }
        }
        if ("sharePic".equals(str3)) {
            try {
                JSONObject jSONObject5 = new JSONObject(strArr[0]);
                P(jSONObject5.optString("picUrl"), jSONObject5.optString("callback"));
                return true;
            } catch (Exception e28) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e28.getMessage());
                return true;
            }
        }
        if ("runtimeContext".equals(str3)) {
            try {
                S(new JSONObject(strArr[0]).optString("callback"));
                return true;
            } catch (Exception e29) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e29.getMessage());
                return true;
            }
        }
        if ("preloadMaterial".equals(str3)) {
            try {
                JSONObject jSONObject6 = new JSONObject(strArr[0]);
                c0(jSONObject6.optString("itemId"), jSONObject6.optString("resourceURL"));
                return true;
            } catch (Exception e36) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("AECameraPlugin", 2, e36.getMessage());
                return true;
            }
        }
        if (!"preloadLightBundle".equals(str3)) {
            return true;
        }
        try {
            b0(new JSONObject(strArr[0]).optString("bundleKey"));
            return true;
        } catch (Exception e37) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.e("AECameraPlugin", 2, e37.getMessage());
            return true;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (b16 == 1) {
            W(intent, i3);
        } else if (b16 == 21 && i3 == -1) {
            f0();
        }
        super.onActivityResult(intent, b16, i3);
    }

    private void W(Intent intent, int i3) {
        if (i3 != -1) {
            callJs(this.C, E("not get valid image").toString());
            return;
        }
        final String stringExtra = intent.getStringExtra(AECameraConstants.INTENT_RESULT_KEY_TAKE_PHOTO_PATH);
        final int i16 = this.f65966h;
        if (i16 == 0) {
            i16 = 400;
        }
        int i17 = this.f65967i;
        final int i18 = i17 != 0 ? i17 : 400;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.AECameraPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject C = AECameraPlugin.this.C(stringExtra, i16, i18);
                    AECameraPlugin aECameraPlugin = AECameraPlugin.this;
                    aECameraPlugin.callJs(aECameraPlugin.C, C.toString());
                } catch (IOException unused) {
                    JSONObject E = AECameraPlugin.this.E("io exception");
                    AECameraPlugin aECameraPlugin2 = AECameraPlugin.this;
                    aECameraPlugin2.callJs(aECameraPlugin2.C, E.toString());
                } catch (OutOfMemoryError unused2) {
                    JSONObject E2 = AECameraPlugin.this.E("out of memory");
                    AECameraPlugin aECameraPlugin3 = AECameraPlugin.this;
                    aECameraPlugin3.callJs(aECameraPlugin3.C, E2.toString());
                } catch (JSONException unused3) {
                    JSONObject E3 = AECameraPlugin.this.E("json exception");
                    AECameraPlugin aECameraPlugin4 = AECameraPlugin.this;
                    aECameraPlugin4.callJs(aECameraPlugin4.C, E3.toString());
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.aelight.camera.download.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            ms.a.a("AECameraPlugin", "onDownloadFinish " + i3);
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f65982d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f65983e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f65984f;

        b(String str, String str2, String str3) {
            this.f65982d = str;
            this.f65983e = str2;
            this.f65984f = str3;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (netResp.mErrCode == 0) {
                AECameraPlugin.this.f65964e = 2;
                AECameraPlugin.this.callJs(this.f65983e, AECameraPlugin.this.G(this.f65982d, "downloading succeeded").toString());
                if (AECameraPlugin.Y(AECameraPlugin.this.mRuntime.a())) {
                    com.tencent.biz.qqstory.utils.d.b(BaseApplicationImpl.getApplication(), new File(this.f65984f));
                    return;
                }
                return;
            }
            AECameraPlugin.this.f65964e = 3;
            AECameraPlugin.this.callJs(this.f65983e, AECameraPlugin.this.F(this.f65982d, "downloading failed").toString());
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f65986d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f65987e;

        c(String str, String str2) {
            this.f65986d = str;
            this.f65987e = str2;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (netResp.mErrCode == 0) {
                if (AECameraPlugin.Y(AECameraPlugin.this.mRuntime.a())) {
                    com.tencent.biz.qqstory.utils.d.b(BaseApplicationImpl.getApplication(), new File(this.f65986d));
                }
                AECameraPlugin.this.a0(this.f65987e);
                AECameraPlugin.this.U(this.f65986d);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("succeeded", false);
                jSONObject.put("message", "download fail");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            AECameraPlugin.this.callJs(this.f65987e, jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
