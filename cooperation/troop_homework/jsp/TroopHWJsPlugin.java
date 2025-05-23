package cooperation.troop_homework.jsp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.JpegExifReader;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOp;
import com.tencent.mm.vfs.VFSFileOutputStream;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ContentItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.homework.submit.fragment.SubmitHomeworkFragment;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.troop_homework.TroopHomeworkHelper;
import cooperation.troop_homework.jsp.TroopHWFileDownloadManager;
import cooperation.troop_homework.jsp.TroopHWVoiceController;
import cooperation.troop_homework.outer.TroopHWRecordArrangeActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes28.dex */
public class TroopHWJsPlugin extends WebViewPlugin implements ITroopMemberApiClientApi.a, TroopHWVoiceController.b, TroopHWFileDownloadManager.b {
    private TroopHWFileDownloadManager Q;
    private String R;

    /* renamed from: f, reason: collision with root package name */
    String f390948f;

    /* renamed from: h, reason: collision with root package name */
    String f390949h;

    /* renamed from: i, reason: collision with root package name */
    String f390950i;

    /* renamed from: m, reason: collision with root package name */
    String f390951m;

    /* renamed from: d, reason: collision with root package name */
    int f390946d = 540;

    /* renamed from: e, reason: collision with root package name */
    int f390947e = 540;
    ActionSheet C = null;
    boolean D = false;
    int E = 0;
    int F = 1;
    ITroopMemberApiClientApi G = null;
    TroopHWVoiceController H = null;
    String I = null;
    int J = -1;
    String K = null;
    boolean L = false;
    String M = null;
    HashMap<Integer, String> N = new HashMap<>();
    HashMap<Integer, UploadMediaEntry> P = new HashMap<>();
    private boolean S = false;
    private final String T = FlockBaseRequest.QUN_DOMAIN;
    private final String[] U = {FlockBaseRequest.QUN_DOMAIN};
    private Handler V = new d();

    /* loaded from: classes28.dex */
    class CompressImageJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private HashMap<Integer, String> f390955d;

        public CompressImageJob(HashMap<Integer, String> hashMap) {
            this.f390955d = (HashMap) hashMap.clone();
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0094 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            VFSFile vFSFile = new VFSFile(TroopHWJsPlugin.L());
            if (!vFSFile.exists()) {
                vFSFile.mkdirs();
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry<Integer, String> entry : this.f390955d.entrySet()) {
                int intValue = entry.getKey().intValue();
                String value = entry.getValue();
                QLog.d("TroopHWJsPlugin", 1, "CompressImage, path = " + value);
                if (!TextUtils.isEmpty(value)) {
                    try {
                        TroopHWJsPlugin troopHWJsPlugin = TroopHWJsPlugin.this;
                        String C = TroopHWJsPlugin.C(intValue, value, troopHWJsPlugin.E, troopHWJsPlugin);
                        QLog.d("TroopHWJsPlugin", 1, "CompressImage, result path = " + value);
                        if (!TextUtils.isEmpty(C) && FileUtils.fileExistsAndNotEmpty(C)) {
                            str = C;
                            if (!TextUtils.isEmpty(str)) {
                                QLog.e("TroopHWJsPlugin", 1, "compressImage failed!");
                                TroopHWJsPlugin.this.V.sendEmptyMessage(0);
                            } else {
                                TroopHWJsPlugin.this.N.put(Integer.valueOf(intValue), str);
                                hashMap.put(Integer.valueOf(intValue), str);
                                TroopHWJsPlugin troopHWJsPlugin2 = TroopHWJsPlugin.this;
                                g gVar = new g(troopHWJsPlugin2.f390948f, troopHWJsPlugin2.f390951m, troopHWJsPlugin2.f390950i);
                                TroopHWJsPlugin troopHWJsPlugin3 = TroopHWJsPlugin.this;
                                UploadMediaEntry F = troopHWJsPlugin3.F(troopHWJsPlugin3, intValue, str, null, gVar, 1, value);
                                TroopHWJsPlugin.this.P.put(Integer.valueOf(intValue), F);
                                F.b();
                            }
                        }
                        str = value;
                        if (!TextUtils.isEmpty(str)) {
                        }
                    } catch (Exception e16) {
                        QLog.e("TroopHWJsPlugin", 1, "compressImage failed!", e16);
                        TroopHWJsPlugin.this.V.sendEmptyMessage(0);
                    }
                } else {
                    TroopHWJsPlugin.this.V.sendEmptyMessage(3);
                    QLog.e("TroopHWJsPlugin", 2, "compressImage failed! empty image!");
                }
            }
        }
    }

    /* loaded from: classes28.dex */
    class CompressVideoJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private HashMap<Integer, String> f390956d;

        /* renamed from: e, reason: collision with root package name */
        private g f390957e;

        public CompressVideoJob(g gVar, HashMap<Integer, String> hashMap) {
            this.f390956d = hashMap;
            this.f390957e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = TroopHWJsPlugin.this.mRuntime.a().getApplicationContext();
            VFSFile vFSFile = new VFSFile(TroopHWJsPlugin.L());
            if (!vFSFile.exists() && !vFSFile.mkdirs()) {
                QLog.d("TroopHWJsPlugin", 1, "dirs not exists. mkdirs false! dirs path = " + vFSFile.getPath());
                TroopHWJsPlugin.this.T(vFSFile);
            }
            TroopHWJsPlugin.this.B(vFSFile);
            boolean z16 = false;
            for (Map.Entry<Integer, String> entry : this.f390956d.entrySet()) {
                int intValue = entry.getKey().intValue();
                String value = entry.getValue();
                QLog.d("TroopHWJsPlugin", 1, "compressVideo, path = " + value);
                if (!TextUtils.isEmpty(value)) {
                    try {
                        Bitmap R = TroopHWJsPlugin.this.R(intValue, value);
                        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(vFSFile.getAbsolutePath() + "/" + new File(value).getName());
                        TroopHWJsPlugin.this.Q(intValue, 0.05f);
                        int d16 = TroopHomeworkHelper.d(applicationContext, value, sDKPrivatePath);
                        QLog.d("TroopHWJsPlugin", 1, "compressVideo ret: " + d16);
                        TroopHWJsPlugin.this.Q(intValue, 0.1f);
                        if (d16 == 1) {
                            TroopHWJsPlugin troopHWJsPlugin = TroopHWJsPlugin.this;
                            UploadMediaEntry F = troopHWJsPlugin.F(troopHWJsPlugin, intValue, value, R, this.f390957e, 2, value);
                            TroopHWJsPlugin.this.P.put(Integer.valueOf(intValue), F);
                            F.b();
                        } else if (d16 == 0 && new File(sDKPrivatePath).exists()) {
                            TroopHWJsPlugin troopHWJsPlugin2 = TroopHWJsPlugin.this;
                            UploadMediaEntry F2 = troopHWJsPlugin2.F(troopHWJsPlugin2, intValue, sDKPrivatePath, R, this.f390957e, 2, value);
                            TroopHWJsPlugin.this.P.put(Integer.valueOf(intValue), F2);
                            F2.b();
                        } else {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.w("TroopHWJsPlugin", 2, "CompressVideoJob failed:" + d16);
                                }
                                TroopHWJsPlugin troopHWJsPlugin3 = TroopHWJsPlugin.this;
                                UploadMediaEntry F3 = troopHWJsPlugin3.F(troopHWJsPlugin3, intValue, value, R, this.f390957e, 2, value);
                                TroopHWJsPlugin.this.P.put(Integer.valueOf(intValue), F3);
                                F3.b();
                                z16 = true;
                            } catch (Exception e16) {
                                e = e16;
                                z16 = true;
                                QLog.e("TroopHWJsPlugin", 1, "compressVideo, Exception happened!", e);
                                TroopHWJsPlugin.this.V.sendEmptyMessage(0);
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                } else {
                    TroopHWJsPlugin.this.V.sendEmptyMessage(4);
                    QLog.e("TroopHWJsPlugin", 1, "compressVideo,video empty!");
                }
            }
            if (z16) {
                TroopHWJsPlugin.this.T(vFSFile);
            }
        }
    }

    /* loaded from: classes28.dex */
    public class UploadMediaEntry {

        /* renamed from: a, reason: collision with root package name */
        g f390958a;

        /* renamed from: b, reason: collision with root package name */
        TroopHomeworkHelper.UploadFileTask f390959b;

        /* renamed from: c, reason: collision with root package name */
        int f390960c;

        /* renamed from: d, reason: collision with root package name */
        Bitmap f390961d;

        /* renamed from: e, reason: collision with root package name */
        String f390962e;

        /* renamed from: f, reason: collision with root package name */
        boolean f390963f;

        /* renamed from: g, reason: collision with root package name */
        String f390964g;

        /* renamed from: i, reason: collision with root package name */
        int f390966i;

        /* renamed from: j, reason: collision with root package name */
        String f390967j;

        /* renamed from: k, reason: collision with root package name */
        String f390968k;

        /* renamed from: h, reason: collision with root package name */
        AtomicBoolean f390965h = new AtomicBoolean(false);

        /* renamed from: l, reason: collision with root package name */
        TroopHomeworkHelper.f f390969l = new a();

        /* loaded from: classes28.dex */
        class a implements TroopHomeworkHelper.f {

            /* renamed from: cooperation.troop_homework.jsp.TroopHWJsPlugin$UploadMediaEntry$a$a, reason: collision with other inner class name */
            /* loaded from: classes28.dex */
            class C10125a implements h {
                C10125a() {
                }

                @Override // cooperation.troop_homework.jsp.TroopHWJsPlugin.h
                public void onResult(boolean z16, String str) {
                    if (z16) {
                        UploadMediaEntry uploadMediaEntry = UploadMediaEntry.this;
                        JSONObject J = TroopHWJsPlugin.this.J(uploadMediaEntry.f390958a.f390995c, uploadMediaEntry.f390960c, uploadMediaEntry.f390966i, "uploaded", uploadMediaEntry.f390962e, 0);
                        try {
                            J.put("result", 0);
                            J.put("progress", 1.0d);
                            J.put("coverurl", str);
                            QLog.d("TroopHWJsPlugin", 1, "upload thumb success:" + J.toString());
                            UploadMediaEntry uploadMediaEntry2 = UploadMediaEntry.this;
                            TroopHWJsPlugin.this.callJs(uploadMediaEntry2.f390958a.f390993a, J.toString());
                            return;
                        } catch (Exception e16) {
                            QLog.e("TroopHWJsPlugin", 1, "upload thumb exception:", e16);
                            return;
                        }
                    }
                    QLog.e("TroopHWJsPlugin", 1, "upload thumb failed!");
                    a.this.onError(-1);
                }
            }

            a() {
            }

            @Override // cooperation.troop_homework.TroopHomeworkHelper.f
            public void onComplete(String str) {
                int i3;
                String str2;
                QLog.d("TroopHWJsPlugin", 1, "UploadMediaEntry onComplete id = " + UploadMediaEntry.this.f390960c + " url = " + str);
                int i16 = UploadMediaEntry.this.f390966i;
                if (i16 == 0) {
                    i3 = 11;
                } else {
                    i3 = 0;
                }
                if (i16 == 2) {
                    str2 = "uploading";
                } else {
                    str2 = "uploaded";
                }
                String str3 = str2;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(UploadMediaEntry.this.f390968k)) {
                    str = str + "?md5=" + UploadMediaEntry.this.f390968k;
                }
                UploadMediaEntry uploadMediaEntry = UploadMediaEntry.this;
                JSONObject J = TroopHWJsPlugin.this.J(uploadMediaEntry.f390958a.f390995c, uploadMediaEntry.f390960c, uploadMediaEntry.f390966i, str3, str, i3);
                UploadMediaEntry.this.f390962e = str;
                try {
                    J.put("result", 0);
                    int i17 = UploadMediaEntry.this.f390966i;
                    if (2 == i17) {
                        J.put("progress", 0.949999988079071d);
                    } else if (i17 == 1) {
                        J.put("progress", 1.0d);
                        J.put("size", "[0,400,694,1000]");
                    } else if (i17 == 0) {
                        J.put("progress", 1.0d);
                    }
                    UploadMediaEntry uploadMediaEntry2 = UploadMediaEntry.this;
                    if (uploadMediaEntry2.f390966i != 2) {
                        TroopHWJsPlugin.this.callJs(uploadMediaEntry2.f390958a.f390993a, J.toString());
                    }
                    UploadMediaEntry uploadMediaEntry3 = UploadMediaEntry.this;
                    uploadMediaEntry3.f390963f = false;
                    if (!uploadMediaEntry3.f390965h.get() && UploadMediaEntry.this.f390966i == 2) {
                        C10125a c10125a = new C10125a();
                        UploadMediaEntry uploadMediaEntry4 = UploadMediaEntry.this;
                        TroopHWJsPlugin troopHWJsPlugin = TroopHWJsPlugin.this;
                        ThreadManagerV2.postImmediately(new UploadVideoThumbJob(uploadMediaEntry4, c10125a, troopHWJsPlugin.S), null, false);
                    }
                } catch (Exception e16) {
                    QLog.e("TroopHWJsPlugin", 1, "uploadVideoCallback exception", e16);
                }
            }

            @Override // cooperation.troop_homework.TroopHomeworkHelper.f
            public void onError(int i3) {
                QLog.d("TroopHWJsPlugin", 1, "upload failed! errorCode = " + i3);
                UploadMediaEntry uploadMediaEntry = UploadMediaEntry.this;
                uploadMediaEntry.f390963f = false;
                JSONObject J = TroopHWJsPlugin.this.J(uploadMediaEntry.f390958a.f390995c, uploadMediaEntry.f390960c, uploadMediaEntry.f390966i, "uploaded", "", 0);
                try {
                    J.put("result", i3);
                } catch (Exception e16) {
                    QLog.e("TroopHWJsPlugin", 1, "upload error!", e16);
                }
                UploadMediaEntry uploadMediaEntry2 = UploadMediaEntry.this;
                TroopHWJsPlugin.this.callJs(uploadMediaEntry2.f390958a.f390993a, J.toString());
            }

            @Override // cooperation.troop_homework.TroopHomeworkHelper.f
            public void onProgress(int i3) {
                float f16;
                UploadMediaEntry uploadMediaEntry = UploadMediaEntry.this;
                JSONObject J = TroopHWJsPlugin.this.J(uploadMediaEntry.f390958a.f390995c, uploadMediaEntry.f390960c, uploadMediaEntry.f390966i, "uploading", "", 0);
                try {
                    if (UploadMediaEntry.this.f390966i == 2) {
                        f16 = ((i3 / 100.0f) * 0.85f) + 0.1f;
                        if (f16 > 1.0f) {
                            f16 = 1.0f;
                        }
                    } else {
                        f16 = i3 / 100.0f;
                    }
                    J.put("progress", f16);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("TroopHWJsPlugin", 4, "id = " + UploadMediaEntry.this.f390960c + " progress = " + i3 + " realProgress = " + f16);
                    }
                    UploadMediaEntry uploadMediaEntry2 = UploadMediaEntry.this;
                    TroopHWJsPlugin.this.callJs(uploadMediaEntry2.f390958a.f390993a, J.toString());
                    UploadMediaEntry.this.f390963f = true;
                } catch (Exception e16) {
                    QLog.e("TroopHWJsPlugin", 1, "UploadMediaEntry,exp\uff0cprogress:" + i3, e16);
                }
            }
        }

        public UploadMediaEntry() {
        }

        public void a() {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.3
                @Override // java.lang.Runnable
                public void run() {
                    UploadMediaEntry.this.f390959b.j();
                }
            }, null, false);
        }

        public void b() {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("TroopHWJsPlugin", 1, "start upload!id = " + UploadMediaEntry.this.f390960c + " type = " + UploadMediaEntry.this.f390966i);
                    try {
                        if (!TextUtils.isEmpty(UploadMediaEntry.this.f390967j)) {
                            UploadMediaEntry uploadMediaEntry = UploadMediaEntry.this;
                            uploadMediaEntry.f390968k = FileUtils.calcMd5(uploadMediaEntry.f390967j);
                        }
                    } catch (Exception unused) {
                        QLog.e("TroopHWJsPlugin", 1, "calcMd5 error!");
                    }
                    UploadMediaEntry.this.f390959b.l();
                }
            }, null, false);
        }
    }

    /* loaded from: classes28.dex */
    class UploadVideoThumbJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        UploadMediaEntry f390975d;

        /* renamed from: e, reason: collision with root package name */
        h f390976e;

        /* renamed from: f, reason: collision with root package name */
        protected boolean f390977f;

        /* loaded from: classes28.dex */
        class a implements sd2.a {
            a() {
            }

            @Override // sd2.a
            public void onFail(@NonNull String str) {
                QLog.e("TroopHWJsPlugin", 1, "fail to get pskey, domain = qun.qq.com errMsg: " + str);
            }

            @Override // sd2.a
            public void onSuccess(@NonNull Map<String, String> map) {
                QLog.d("TroopHWJsPlugin", 1, "get pskey onSuccess");
                UploadVideoThumbJob.this.b(map.get(FlockBaseRequest.QUN_DOMAIN));
            }
        }

        public UploadVideoThumbJob(UploadMediaEntry uploadMediaEntry, h hVar, boolean z16) {
            this.f390975d = uploadMediaEntry;
            this.f390976e = hVar;
            this.f390977f = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            String str2;
            boolean z16;
            h hVar;
            JSONObject optJSONObject;
            QLog.d("TroopHWJsPlugin", 2, "UploadVideoThumbJob start, entry id:" + this.f390975d.f390960c);
            Bitmap bitmap = this.f390975d.f390961d;
            if (bitmap != null && !bitmap.isRecycled() && !this.f390975d.f390965h.get()) {
                if (this.f390977f) {
                    str2 = "https://qun.qq.com/cgi-bin/homework/upload/picture.fcg";
                } else {
                    str2 = "http://qun.qq.com/cgi-bin/homework/upload/picture.fcg";
                }
                String str3 = str2;
                String account = TroopHWJsPlugin.this.mRuntime.b().getAccount();
                File file = null;
                try {
                    try {
                        File file2 = new File(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH + "tempVideoCover.png");
                        try {
                            BaseImageUtil.saveBitmapToFile(this.f390975d.f390961d, file2);
                            if (this.f390975d.f390965h.get()) {
                                QLog.d("TroopHWJsPlugin", 2, "UploadVideoThumbJob canceled, id = " + this.f390975d.f390960c);
                                Bitmap bitmap2 = this.f390975d.f390961d;
                                if (bitmap2 != null) {
                                    bitmap2.recycle();
                                }
                                file2.delete();
                                return;
                            }
                            if (file2.exists()) {
                                QLog.d("TroopHWJsPlugin", 2, "tempVideoCoverFile path:" + file2.getCanonicalPath() + " size:" + file2.length());
                                String r16 = TroopHomeworkHelper.r(str3, file2.getCanonicalPath(), account, str, 1234567L);
                                if (this.f390975d.f390965h.get()) {
                                    Bitmap bitmap3 = this.f390975d.f390961d;
                                    if (bitmap3 != null) {
                                        bitmap3.recycle();
                                    }
                                    file2.delete();
                                    return;
                                }
                                if (!TextUtils.isEmpty(r16)) {
                                    JSONObject jSONObject = new JSONObject(r16);
                                    if (jSONObject.optInt("retcode", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                        String optString = optJSONObject.optString("url");
                                        h hVar2 = this.f390976e;
                                        if (hVar2 != null) {
                                            hVar2.onResult(true, optString);
                                        }
                                        z16 = true;
                                        if (!z16 && (hVar = this.f390976e) != null) {
                                            hVar.onResult(false, null);
                                        }
                                    }
                                }
                                z16 = false;
                                if (!z16) {
                                    hVar.onResult(false, null);
                                }
                            }
                            Bitmap bitmap4 = this.f390975d.f390961d;
                            if (bitmap4 != null) {
                                bitmap4.recycle();
                            }
                            file2.delete();
                        } catch (Exception e16) {
                            e = e16;
                            file = file2;
                            QLog.e("TroopHWJsPlugin", 1, "UploadVideoThumbJob run exception:", e);
                            Bitmap bitmap5 = this.f390975d.f390961d;
                            if (bitmap5 != null) {
                                bitmap5.recycle();
                            }
                            if (file != null) {
                                file.delete();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            file = file2;
                            Bitmap bitmap6 = this.f390975d.f390961d;
                            if (bitmap6 != null) {
                                bitmap6.recycle();
                            }
                            if (file != null) {
                                file.delete();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ((IPskeyManager) TroopHWJsPlugin.this.mRuntime.b().getRuntimeService(IPskeyManager.class, "all")).getPskey(TroopHWJsPlugin.this.U, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f390979d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f390980e;

        a(int i3, ActionSheet actionSheet) {
            this.f390979d = i3;
            this.f390980e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                TroopHWJsPlugin.this.A((ao.b("homework") << 8) + 2);
            } else if (i3 == 1) {
                TroopHWJsPlugin.this.y(this.f390979d);
            }
            this.f390980e.superDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f390982a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f390983b;

        b(Activity activity, int i3) {
            this.f390982a = activity;
            this.f390983b = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            TroopHWJsPlugin.this.f390949h = TroopHWJsPlugin.D(this.f390982a, this.f390983b);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f390985a;

        c(int i3) {
            this.f390985a = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("TroopHWJsPlugin", 1, "checkAndGoPicSelect onAllGranted");
            TroopHWJsPlugin.this.M(this.f390985a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.d("TroopHWJsPlugin", 1, "checkAndGoPicSelect onDenied");
        }
    }

    /* loaded from: classes28.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            QQToast.makeText(BaseApplication.getContext(), R.string.ena, 0).show();
                            return;
                        }
                        return;
                    }
                    QQToast.makeText(BaseApplication.getContext(), R.string.en_, 0).show();
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), R.string.eno, 0).show();
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), R.string.enb, 0).show();
        }
    }

    /* loaded from: classes28.dex */
    class e implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f390988a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ double f390989b;

        e(String str, double d16) {
            this.f390988a = str;
            this.f390989b = d16;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.e("TroopHWJsPlugin", 1, "fail to get pskey, domain = qun.qq.com errMsg: " + str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            QLog.d("TroopHWJsPlugin", 1, "get pskey onSuccess");
            TroopHWJsPlugin.this.S(this.f390988a, this.f390989b, map.get(FlockBaseRequest.QUN_DOMAIN));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class f extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f390991a;

        f(int i3) {
            this.f390991a = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            TroopHWJsPlugin.this.N(this.f390991a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public String f390993a;

        /* renamed from: b, reason: collision with root package name */
        public String f390994b;

        /* renamed from: c, reason: collision with root package name */
        public String f390995c;

        public g(String str, String str2, String str3) {
            this.f390993a = str;
            this.f390994b = str2;
            this.f390995c = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public interface h {
        void onResult(boolean z16, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3) {
        Activity a16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            a16 = null;
        } else {
            a16 = bVar.a();
        }
        if (a16 == null) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f170671xw, 0).show();
            return;
        }
        if (a16 instanceof AppActivity) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(a16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK));
            if (!O(qQPermission)) {
                QLog.i("TroopHWJsPlugin", 1, "checkAndnterSnapshot has no camera permission");
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new b(a16, i3));
                return;
            } else {
                this.f390949h = D(a16, i3);
                return;
            }
        }
        this.f390949h = D(a16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(VFSFile vFSFile) {
        VFSFile vFSFile2 = new VFSFile(VFSAssistantUtils.getSDKPrivatePath(vFSFile.getAbsolutePath() + "/test.tmp"));
        try {
            if (!vFSFile2.exists()) {
                QLog.d("TroopHWJsPlugin", 1, "checkCompressOutPathIsValid exists false, createResult = " + vFSFile2.createNewFile());
            } else if (vFSFile2.delete()) {
                QLog.d("TroopHWJsPlugin", 1, "checkCompressOutPathIsValid exists true, createResult = " + vFSFile2.createNewFile());
            } else {
                QLog.d("TroopHWJsPlugin", 1, "checkCompressOutPathIsValid exists true, tmpFile delete false");
            }
        } catch (Exception e16) {
            QLog.d("TroopHWJsPlugin", 1, e16.getMessage());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:16|17|18|19|(7:28|(1:30)(1:141)|31|32|33|35|(3:37|38|39)(9:(2:41|42)(1:131)|43|(1:45)(1:130)|46|47|48|50|51|(2:53|54)(14:55|(1:57)|58|59|60|(6:62|63|64|(1:66)|67|68)(2:(1:112)|113)|69|70|(3:72|(1:74)|75)|(3:77|78|79)(1:95)|(1:81)|(1:83)|84|85)))|142|(0)(0)|31|32|33|35|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x013e, code lost:
    
        if (r4 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0127, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0133, code lost:
    
        r6 = 1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0129, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x012a, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x028f A[Catch: OutOfMemoryError -> 0x02a1, TryCatch #14 {OutOfMemoryError -> 0x02a1, blocks: (B:5:0x0022, B:11:0x0040, B:14:0x0053, B:16:0x005a, B:38:0x00c2, B:51:0x0121, B:53:0x0143, B:55:0x014a, B:57:0x015e, B:58:0x0161, B:81:0x026b, B:83:0x0270, B:90:0x0282, B:92:0x0287, B:101:0x028f, B:103:0x0294, B:104:0x0297, B:138:0x029b, B:139:0x029e), top: B:4:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0294 A[Catch: OutOfMemoryError -> 0x02a1, TryCatch #14 {OutOfMemoryError -> 0x02a1, blocks: (B:5:0x0022, B:11:0x0040, B:14:0x0053, B:16:0x005a, B:38:0x00c2, B:51:0x0121, B:53:0x0143, B:55:0x014a, B:57:0x015e, B:58:0x0161, B:81:0x026b, B:83:0x0270, B:90:0x0282, B:92:0x0287, B:101:0x028f, B:103:0x0294, B:104:0x0297, B:138:0x029b, B:139:0x029e), top: B:4:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0079 A[Catch: all -> 0x012c, IOException -> 0x0130, TryCatch #12 {IOException -> 0x0130, all -> 0x012c, blocks: (B:19:0x0060, B:30:0x0077, B:31:0x007b, B:141:0x0079), top: B:18:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[Catch: all -> 0x012c, IOException -> 0x0130, TryCatch #12 {IOException -> 0x0130, all -> 0x012c, blocks: (B:19:0x0060, B:30:0x0077, B:31:0x007b, B:141:0x0079), top: B:18:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc A[Catch: IOException -> 0x0127, all -> 0x0298, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x0127, blocks: (B:37:0x00bc, B:42:0x00c9, B:131:0x00ce), top: B:35:0x00ba }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0282 A[Catch: OutOfMemoryError -> 0x02a1, TRY_ENTER, TryCatch #14 {OutOfMemoryError -> 0x02a1, blocks: (B:5:0x0022, B:11:0x0040, B:14:0x0053, B:16:0x005a, B:38:0x00c2, B:51:0x0121, B:53:0x0143, B:55:0x014a, B:57:0x015e, B:58:0x0161, B:81:0x026b, B:83:0x0270, B:90:0x0282, B:92:0x0287, B:101:0x028f, B:103:0x0294, B:104:0x0297, B:138:0x029b, B:139:0x029e), top: B:4:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0287 A[Catch: OutOfMemoryError -> 0x02a1, TryCatch #14 {OutOfMemoryError -> 0x02a1, blocks: (B:5:0x0022, B:11:0x0040, B:14:0x0053, B:16:0x005a, B:38:0x00c2, B:51:0x0121, B:53:0x0143, B:55:0x014a, B:57:0x015e, B:58:0x0161, B:81:0x026b, B:83:0x0270, B:90:0x0282, B:92:0x0287, B:101:0x028f, B:103:0x0294, B:104:0x0297, B:138:0x029b, B:139:0x029e), top: B:4:0x0022 }] */
    /* JADX WARN: Type inference failed for: r0v26, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r16v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.StringBuilder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String C(int i3, String str, int i16, TroopHWJsPlugin troopHWJsPlugin) throws IOException, JSONException {
        FileInputStream fileInputStream;
        Bitmap bitmap;
        float f16;
        VFSFileOutputStream vFSFileOutputStream;
        String str2;
        int readOrientation;
        boolean z16;
        int i17;
        float f17;
        int width;
        if (new File(str).length() > 3) {
            ?? sb5 = new StringBuilder();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inPurgeable = true;
                BitmapFactory.decodeFile(str, options);
                int i18 = options.outWidth;
                int i19 = options.outHeight;
                if (i18 > 0 && i19 > 0) {
                    if (i18 <= i16) {
                        if (troopHWJsPlugin != null) {
                            QLog.d("TroopHWJsPlugin", 1, "compressPic <= maxOutputWidth return getFileRawData");
                            return H(troopHWJsPlugin.f390950i, i3, str, i18, i19, troopHWJsPlugin);
                        }
                        QLog.d("TroopHWJsPlugin", 1, "compressPic <= maxOutputWidth return path");
                        return str;
                    }
                    Matrix matrix = new Matrix();
                    try {
                        readOrientation = JpegExifReader.readOrientation(str);
                    } catch (IOException e16) {
                        e = e16;
                        bitmap = null;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                    }
                    try {
                        if (readOrientation != 5 && readOrientation != 6 && readOrientation != 7 && readOrientation != 8) {
                            z16 = false;
                            if (!z16) {
                                i17 = i19 / i16;
                            } else {
                                i17 = i18 / i16;
                            }
                            options.inJustDecodeBounds = false;
                            int i26 = (i17 >>> 1) | i17;
                            int i27 = i26 | (i26 >>> 2);
                            int i28 = i27 | (i27 >>> 4);
                            int i29 = i28 | (i28 >>> 8);
                            int i36 = i29 | (i29 >>> 16);
                            options.inSampleSize = (i36 + 1) >>> 1;
                            QLog.d("TroopHWJsPlugin", 1, "compress inSampleSize:" + options.inSampleSize + ",rate=" + i36);
                            fileInputStream = new FileInputStream(str);
                            bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                            if (bitmap != null) {
                                QLog.d("TroopHWJsPlugin", 1, "compressPic BitmapFactory.decodeStream got null");
                                fileInputStream.close();
                                return null;
                            }
                            if (z16) {
                                f17 = i16;
                                width = bitmap.getHeight();
                            } else {
                                f17 = i16;
                                width = bitmap.getWidth();
                            }
                            ?? r16 = 4603579539098121011;
                            if (f17 / width < 0.6d) {
                                f16 = 0.8f;
                            } else {
                                f16 = 1.0f;
                            }
                            try {
                                switch (readOrientation) {
                                    case 2:
                                        matrix.setScale(-f16, f16);
                                        break;
                                    case 3:
                                        matrix.setScale(f16, f16);
                                        matrix.postRotate(180.0f);
                                        break;
                                    case 4:
                                        matrix.setScale(f16, -f16);
                                        break;
                                    case 5:
                                        matrix.setScale(f16, -f16);
                                        matrix.postRotate(90.0f);
                                        break;
                                    case 6:
                                        matrix.setScale(f16, f16);
                                        matrix.postRotate(90.0f);
                                        break;
                                    case 7:
                                        matrix.setScale(-f16, f16);
                                        matrix.postRotate(90.0f);
                                        break;
                                    case 8:
                                        matrix.setScale(f16, f16);
                                        matrix.postRotate(270.0f);
                                        break;
                                    default:
                                        matrix.setScale(f16, f16);
                                        break;
                                }
                            } catch (IOException e17) {
                                e = e17;
                                QLog.d("TroopHWJsPlugin", 1, "compressPic scale exception", e);
                                matrix.setScale(f16, f16);
                            }
                            fileInputStream.close();
                            if (bitmap == null) {
                                QLog.d("TroopHWJsPlugin", 1, "compressPic Bmp not init");
                                return null;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            if (bitmap != createBitmap) {
                                bitmap.recycle();
                            }
                            int width2 = createBitmap.getWidth();
                            int height = createBitmap.getHeight();
                            int G = G(createBitmap);
                            try {
                                try {
                                    if (G > 0) {
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                        try {
                                            createBitmap.compress(Bitmap.CompressFormat.JPEG, G, byteArrayOutputStream);
                                            if (troopHWJsPlugin != null) {
                                                sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                                            }
                                            QLog.d("TroopHWJsPlugin", 1, "encoded base64 size:" + sb5.length());
                                            r16 = byteArrayOutputStream;
                                        } catch (IOException e18) {
                                            e = e18;
                                            r16 = byteArrayOutputStream;
                                            vFSFileOutputStream = null;
                                            e.printStackTrace();
                                            QLog.e("TroopHWJsPlugin", 1, "compressPic, exception: ", e);
                                            if (r16 != 0) {
                                            }
                                            if (vFSFileOutputStream != null) {
                                            }
                                            return null;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            r16 = byteArrayOutputStream;
                                            sb5 = 0;
                                            if (r16 != 0) {
                                            }
                                            if (sb5 != 0) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        if (G == 0 && troopHWJsPlugin != null) {
                                            troopHWJsPlugin.V.sendEmptyMessage(1);
                                        }
                                        r16 = 0;
                                    }
                                } catch (IOException e19) {
                                    e = e19;
                                    vFSFileOutputStream = null;
                                    r16 = 0;
                                } catch (Throwable th7) {
                                    th = th7;
                                    sb5 = 0;
                                    r16 = 0;
                                }
                                try {
                                    QLog.d("TroopHWJsPlugin", 1, "compressPic getCompressRate=", Integer.valueOf(G));
                                    createBitmap.recycle();
                                    if (troopHWJsPlugin != null) {
                                        ?? J = troopHWJsPlugin.J(troopHWJsPlugin.f390950i, i3, 1, "stop", null, -1);
                                        if (!TextUtils.isEmpty(sb5.toString())) {
                                            J.put("imgstr", sb5);
                                        }
                                        J.put("width", width2);
                                        J.put("height", height);
                                        troopHWJsPlugin.callJs(troopHWJsPlugin.f390948f, J.toString());
                                        QLog.d("TroopHWJsPlugin", 1, "compressPic success plugin.callJs");
                                    }
                                    if (r16 != 0) {
                                        String str3 = L() + str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")) + System.currentTimeMillis() + q.j(str);
                                        vFSFileOutputStream = new VFSFileOutputStream(str3);
                                        try {
                                            vFSFileOutputStream.write(r16.toByteArray());
                                            str2 = VFSFileOp.exportExternalPath(str3, false);
                                        } catch (IOException e26) {
                                            e = e26;
                                            e.printStackTrace();
                                            QLog.e("TroopHWJsPlugin", 1, "compressPic, exception: ", e);
                                            if (r16 != 0) {
                                                r16.close();
                                            }
                                            if (vFSFileOutputStream != null) {
                                                vFSFileOutputStream.close();
                                            }
                                            return null;
                                        }
                                    } else {
                                        str2 = null;
                                        vFSFileOutputStream = null;
                                    }
                                    if (r16 != 0) {
                                        r16.close();
                                    }
                                    if (vFSFileOutputStream != null) {
                                        vFSFileOutputStream.close();
                                    }
                                    return str2;
                                } catch (IOException e27) {
                                    e = e27;
                                    vFSFileOutputStream = null;
                                    e.printStackTrace();
                                    QLog.e("TroopHWJsPlugin", 1, "compressPic, exception: ", e);
                                    if (r16 != 0) {
                                    }
                                    if (vFSFileOutputStream != null) {
                                    }
                                    return null;
                                } catch (Throwable th8) {
                                    th = th8;
                                    sb5 = 0;
                                    if (r16 != 0) {
                                        r16.close();
                                    }
                                    if (sb5 != 0) {
                                        sb5.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        }
                        bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                        if (bitmap != null) {
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                    z16 = true;
                    if (!z16) {
                    }
                    options.inJustDecodeBounds = false;
                    int i262 = (i17 >>> 1) | i17;
                    int i272 = i262 | (i262 >>> 2);
                    int i282 = i272 | (i272 >>> 4);
                    int i292 = i282 | (i282 >>> 8);
                    int i362 = i292 | (i292 >>> 16);
                    options.inSampleSize = (i362 + 1) >>> 1;
                    QLog.d("TroopHWJsPlugin", 1, "compress inSampleSize:" + options.inSampleSize + ",rate=" + i362);
                    fileInputStream = new FileInputStream(str);
                }
                return null;
            } catch (OutOfMemoryError e28) {
                e28.printStackTrace();
                QLog.e("TroopHWJsPlugin", 1, "compressPic, exception: ", e28);
                System.gc();
            }
        }
        QLog.e("TroopHWJsPlugin", 1, "compressPic but file.length() <= 3, return null");
        return null;
    }

    public static String D(Activity activity, int i3) {
        QLog.i("TroopHWJsPlugin", 1, "enterSnapshot");
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            return "";
        }
        BaseApplication context = BaseApplication.getContext();
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE + System.currentTimeMillis() + ".jpg");
        File parentFile = new File(sDKPrivatePath).getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            QQToast.makeText(context, R.string.h9v, 0).show();
        }
        Intent intent = new Intent();
        FileProvider7Helper.setSystemCapture(activity, new File(sDKPrivatePath), intent);
        if (activity != null) {
            try {
                activity.startActivityForResult(intent, i3);
            } catch (Exception e16) {
                e16.printStackTrace();
                QQToast.makeText(context, R.string.f170671xw, 0).show();
                QLog.e("TroopHWJsPlugin", 1, "enterSnapshot exception", e16);
            }
        }
        return sDKPrivatePath;
    }

    @TargetApi(12)
    public static int G(Bitmap bitmap) {
        int byteCount = bitmap.getByteCount();
        if (byteCount > 41246720) {
            return 0;
        }
        if (byteCount > 6291456) {
            return 50;
        }
        if (byteCount > 1048576) {
            return 80;
        }
        if (byteCount > 102400) {
            return 90;
        }
        return 100;
    }

    public static String H(String str, int i3, String str2, int i16, int i17, TroopHWJsPlugin troopHWJsPlugin) throws IOException, JSONException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str2);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            byte[] bArr = new byte[30720];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                if (read < 30720) {
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr2, 2));
                } else {
                    sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2));
                }
            }
            if (troopHWJsPlugin != null) {
                JSONObject J = troopHWJsPlugin.J(str, i3, 1, "stop", null, -1);
                if (!TextUtils.isEmpty(sb5.toString())) {
                    J.put("imgstr", sb5);
                }
                J.put("width", i16);
                J.put("height", i17);
                troopHWJsPlugin.callJs(troopHWJsPlugin.f390948f, J.toString());
            }
            fileInputStream.close();
            return str2;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static ArrayList<BaseItem> I(@androidx.annotation.NonNull JSONObject jSONObject) {
        char c16;
        ArrayList<BaseItem> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("content").getJSONObject("text").getJSONArray("c");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                String string = jSONObject2.getString("type");
                try {
                    switch (string.hashCode()) {
                        case 104387:
                            if (string.equals("img")) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case 114225:
                            if (string.equals("str")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case 112202875:
                            if (string.equals("video")) {
                                c16 = 3;
                                break;
                            }
                            break;
                        case 112386354:
                            if (string.equals("voice")) {
                                c16 = 1;
                                break;
                            }
                            break;
                    }
                    c16 = '\uffff';
                    if (c16 != 0) {
                        if (c16 != 1) {
                            if (c16 != 2) {
                                if (c16 == 3) {
                                    VideoItem videoItem = new VideoItem();
                                    videoItem.setHttpUrl(jSONObject2.getString("url"));
                                    videoItem.setWidth(jSONObject2.getInt("width"));
                                    videoItem.setHeight(jSONObject2.getInt("height"));
                                    videoItem.setPosterHttpUrl(jSONObject2.getString(QAdVrReport.ElementID.AD_POSTER));
                                    arrayList.add(videoItem);
                                }
                            } else {
                                ImageItem imageItem = new ImageItem();
                                imageItem.setHttpUrl(jSONObject2.getString("url"));
                                imageItem.setWidth(jSONObject2.getInt("width"));
                                imageItem.setHeight(jSONObject2.getInt("height"));
                                arrayList.add(imageItem);
                            }
                        } else {
                            AudioItem audioItem = new AudioItem();
                            audioItem.setHttpUrl(jSONObject2.getString("url"));
                            audioItem.setCountTime(jSONObject2.getLong("time") * 1000);
                            audioItem.setFileSize(jSONObject2.getLong("size"));
                            arrayList.add(audioItem);
                        }
                    } else {
                        ContentItem contentItem = new ContentItem();
                        contentItem.setContent(jSONObject2.getString("text"));
                        arrayList.add(contentItem);
                    }
                } catch (JSONException e16) {
                    QLog.e("TroopHWJsPlugin", 1, "Failed to parse item of type: " + string, e16);
                }
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
            QLog.e("TroopHWJsPlugin", 1, "handle HW js submit failed for json to baseItem error", e17);
        }
        return arrayList;
    }

    public static String L() {
        ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
        if (applicationInfo != null && applicationInfo.targetSdkVersion >= 31) {
            int i3 = Build.VERSION.SDK_INT;
        }
        return BaseApplication.getContext().getFilesDir().getPath() + "/Tencent/QQHomework_recv/homeworkTmp/";
    }

    private boolean O(QQPermission qQPermission) {
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            return true;
        }
        return false;
    }

    private boolean P(QQPermission qQPermission) {
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00c1 -> B:10:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a7 -> B:10:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008a -> B:10:0x0080). Please report as a decompilation issue!!! */
    public Bitmap R(int i3, String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        String str2 = "error retrieve video info";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject J = J(this.f390950i, i3, 2, "stop", null, -1);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(-1L);
                if (bitmap != null) {
                    try {
                        int i16 = this.f390946d;
                        int i17 = 540;
                        if (i16 <= 0) {
                            i16 = 540;
                        }
                        int i18 = this.f390947e;
                        if (i18 > 0) {
                            i17 = i18;
                        }
                        bitmap2 = ThumbnailUtils.extractThumbnail(bitmap, i16, i17);
                        if (bitmap2 != null) {
                            try {
                                String x16 = x(bitmap2, G(bitmap2));
                                if (!TextUtils.isEmpty(x16)) {
                                    J.put("imgstr", x16);
                                    J.put("width", bitmap2.getWidth());
                                    J.put("height", bitmap2.getHeight());
                                } else {
                                    QLog.e("TroopHWJsPlugin", 1, "get video thumbnail failed");
                                }
                            } catch (IllegalArgumentException e16) {
                                e = e16;
                                str2 = str2 + e.getMessage();
                                QLog.w("TroopHWJsPlugin", 1, str2);
                                mediaMetadataRetriever.release();
                            } catch (RuntimeException e17) {
                                e = e17;
                                str2 = str2 + e.getMessage();
                                QLog.w("TroopHWJsPlugin", 1, str2);
                                mediaMetadataRetriever.release();
                            } catch (JSONException e18) {
                                e = e18;
                                str2 = "error bitmapToBase64" + e.getMessage();
                                QLog.w("TroopHWJsPlugin", 1, str2);
                                mediaMetadataRetriever.release();
                            }
                        }
                    } catch (IllegalArgumentException e19) {
                        e = e19;
                        bitmap2 = null;
                        str2 = str2 + e.getMessage();
                        QLog.w("TroopHWJsPlugin", 1, str2);
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e26) {
                        e = e26;
                        bitmap2 = null;
                        str2 = str2 + e.getMessage();
                        QLog.w("TroopHWJsPlugin", 1, str2);
                        mediaMetadataRetriever.release();
                    } catch (JSONException e27) {
                        e = e27;
                        bitmap2 = null;
                        str2 = "error bitmapToBase64" + e.getMessage();
                        QLog.w("TroopHWJsPlugin", 1, str2);
                        mediaMetadataRetriever.release();
                    }
                } else {
                    bitmap2 = null;
                }
            } catch (IllegalArgumentException e28) {
                e = e28;
                bitmap = null;
                bitmap2 = null;
            } catch (RuntimeException e29) {
                e = e29;
                bitmap = null;
                bitmap2 = null;
            } catch (JSONException e36) {
                e = e36;
                bitmap = null;
                bitmap2 = null;
            }
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                callJs(this.f390948f, J.toString());
                if (bitmap2 != null) {
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    return bitmap2;
                }
                if (bitmap == null) {
                    return null;
                }
                return bitmap;
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused2) {
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final String str, double d16, final String str2) {
        this.N.put(Integer.valueOf(this.F), str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.F);
            jSONObject.put("state", "stop");
            jSONObject.put("path", str);
            jSONObject.put("time", Math.round(d16 / 1000.0d));
            callJs(this.f390948f, jSONObject.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.F++;
        if (this.L) {
            ThreadManagerV2.post(new Runnable() { // from class: cooperation.troop_homework.jsp.TroopHWJsPlugin.7
                @Override // java.lang.Runnable
                public void run() {
                    String r16;
                    JSONObject optJSONObject;
                    String account = TroopHWJsPlugin.this.mRuntime.b().getAccount();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(TroopHWJsPlugin.this.M) && (r16 = TroopHomeworkHelper.r(TroopHWJsPlugin.this.M, str, account, str2, 1234567L)) != null) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(r16);
                            if (jSONObject2.optInt("retcode", -1) == 0 && (optJSONObject = jSONObject2.optJSONObject("data")) != null) {
                                String optString = optJSONObject.optString("url");
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("id", TroopHWJsPlugin.this.F - 1);
                                jSONObject3.put("state", "uploaded");
                                jSONObject3.put("url", optString);
                                TroopHWJsPlugin troopHWJsPlugin = TroopHWJsPlugin.this;
                                troopHWJsPlugin.callJs(troopHWJsPlugin.f390948f, jSONObject3.toString());
                            }
                        } catch (JSONException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
            }, 2, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(VFSFile vFSFile) {
        if (vFSFile != null && QLog.isColorLevel()) {
            VFSFile vFSFile2 = new VFSFile(AppConstants.SDCARD_HOMEWORK_AUDIO);
            QLog.d("TroopHWJsPlugin", 1, "compressVideo: dirs path = " + vFSFile.getPath() + " dirs isExists = " + vFSFile.exists() + " parentDirs path =" + vFSFile2.getPath() + " parentDir isExists = " + vFSFile2.exists() + " parentDir permission = " + vFSFile2.canRead() + vFSFile2.canWrite());
        }
    }

    private void U(int i3) {
        ActionSheet actionSheet = this.C;
        if (actionSheet != null && actionSheet.isShowing()) {
            return;
        }
        QLog.i("TroopHWJsPlugin", 1, "showGetPictureDialog");
        ActionSheet create = ActionSheet.create(this.mRuntime.a());
        create.addButton(R.string.hel, 1);
        create.addButton(R.string.heb, 1);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new a(i3, create));
        create.show();
        this.C = create;
    }

    @NonNull
    public static Intent getSelectMediaIntent(int i3, Activity activity, String str) {
        return ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).getSelectMediaIntent(i3, activity, str);
    }

    public static String x(Bitmap bitmap, int i3) {
        String str;
        String str2;
        ByteArrayOutputStream byteArrayOutputStream = null;
        String str3 = null;
        r1 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(1024);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream3);
                        str3 = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
                        QLog.i("TroopHWJsPlugin", 1, "encodeToString result:" + str3.length());
                        str = str3;
                        byteArrayOutputStream = byteArrayOutputStream3;
                    } catch (Exception e16) {
                        e = e16;
                        str2 = str3;
                        byteArrayOutputStream2 = byteArrayOutputStream3;
                        e.printStackTrace();
                        QLog.i("TroopHWJsPlugin", 1, "bitmapToBase64 exception:" + e);
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.flush();
                                byteArrayOutputStream2.close();
                                return str2;
                            } catch (IOException e17) {
                                e17.printStackTrace();
                                return str2;
                            }
                        }
                        return str2;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream2 = byteArrayOutputStream3;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.flush();
                                byteArrayOutputStream2.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e19) {
                e = e19;
                str2 = null;
            }
        } else {
            str = null;
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        }
        return str;
    }

    public String E(String str, String str2) {
        String K = K(str, str2);
        if (new File(K).exists()) {
            return K;
        }
        return "";
    }

    public UploadMediaEntry F(TroopHWJsPlugin troopHWJsPlugin, int i3, String str, Bitmap bitmap, g gVar, int i16, String str2) {
        Objects.requireNonNull(troopHWJsPlugin);
        UploadMediaEntry uploadMediaEntry = new UploadMediaEntry();
        uploadMediaEntry.f390960c = i3;
        uploadMediaEntry.f390958a = gVar;
        TroopHomeworkHelper.UploadFileTask uploadFileTask = new TroopHomeworkHelper.UploadFileTask(troopHWJsPlugin.mRuntime.b(), str, gVar.f390994b);
        uploadMediaEntry.f390959b = uploadFileTask;
        uploadFileTask.k(uploadMediaEntry.f390969l);
        uploadMediaEntry.f390961d = bitmap;
        uploadMediaEntry.f390964g = str;
        uploadMediaEntry.f390966i = i16;
        uploadMediaEntry.f390967j = str2;
        return uploadMediaEntry;
    }

    public JSONObject J(String str, int i3, int i16, String str2, String str3, int i17) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i3);
            jSONObject.put("webid", str);
            jSONObject.put("state", str2);
            jSONObject.put("path", "");
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("url", str3);
            }
            if (i16 == 0) {
                jSONObject.put("type", QQPermissionConstants.Permission.AUIDO_GROUP);
                jSONObject.put("time", i17);
            } else if (i16 == 2) {
                jSONObject.put("type", "video");
            } else {
                jSONObject.put("type", "image");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public String K(String str, String str2) {
        String str3 = MD5Utils.toMD5(str2) + ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).getFileSuffix(str2);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_HOMEWORK_ATTACH + str + File.separator);
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sDKPrivatePath + str3;
    }

    protected void M(int i3) {
        Activity a16 = this.mRuntime.a();
        WebViewProvider f16 = this.mRuntime.f();
        if (!((ITroopHWApi) QRoute.api(ITroopHWApi.class)).isAbsBaseWebViewActivity(a16) && f16 == null) {
            QLog.d("TroopHWJsPlugin", 1, "goPicSelect but runtime error:" + a16);
            this.V.sendEmptyMessage(3);
            return;
        }
        ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).gotoSelectPicture(a16, f16, this, i3, (byte) 3);
    }

    protected void N(int i3) {
        Activity a16 = this.mRuntime.a();
        WebViewProvider f16 = this.mRuntime.f();
        if (!((ITroopHWApi) QRoute.api(ITroopHWApi.class)).isAbsBaseWebViewActivity(a16) && f16 == null) {
            this.V.sendEmptyMessage(4);
            return;
        }
        Intent selectMediaIntent = getSelectMediaIntent(i3, a16, this.mRuntime.b().getCurrentAccountUin());
        selectMediaIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).goSelectMedia(a16, f16, this, selectMediaIntent, (byte) 5);
    }

    public void Q(int i3, float f16) {
        JSONObject J = J(this.f390950i, i3, 2, "uploading", null, -1);
        try {
            J.put("progress", f16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        callJs(this.f390948f, J.toString());
    }

    @Override // cooperation.troop_homework.jsp.TroopHWVoiceController.b
    public void a(String str, double d16) {
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            QLog.e("TroopHWJsPlugin", 1, "TroopHWJsPlugin onWebRecordEnd runtime is null!");
        } else {
            ((IPskeyManager) b16.getRuntimeService(IPskeyManager.class, "all")).getPskey(this.U, new e(str, d16));
        }
    }

    @Override // cooperation.troop_homework.jsp.TroopHWFileDownloadManager.b
    public void c(String str, int i3, int i16, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put("state", i3);
            jSONObject.put("finishLen", 0);
            jSONObject.put("fileLen", 0);
            if (i3 == 3) {
                jSONObject.put("filePath", str3);
            }
            callJs(this.R, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            super.callJs(str, strArr);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
    public void callback(Bundle bundle) {
        if (bundle != null && "getFileInfo".equals(bundle.getString("method"))) {
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.E(bundle.getLong("sessionId"));
            forwardFileInfo.w(bundle.getInt("cloudType"));
            forwardFileInfo.N(bundle.getInt("type"));
            forwardFileInfo.C(bundle.getString("filePath"));
            forwardFileInfo.y(bundle.getString(WadlProxyConsts.PARAM_FILENAME));
            forwardFileInfo.z(bundle.getLong("fileSize"));
            forwardFileInfo.B(bundle.getLong(IProfileProtocolConst.PARAM_TROOP_CODE));
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openTroopFilerDetailBrowse(this.mRuntime.a(), forwardFileInfo);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "homework";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 2L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934597L) {
            this.D = this.H.o();
        } else if (j3 == 2 && this.D) {
            callJs(this.f390948f, "{'webid':" + this.f390950i + ", 'type':'home', 'state':'click'}");
            this.D = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        UploadMediaEntry uploadMediaEntry;
        String optString;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3 = 0;
        if (str == null || !"homework".equals(str2) || str3 == null) {
            return false;
        }
        String str8 = null;
        try {
            jSONObject = new JSONObject(strArr[0]);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if ("lelePublish".equals(str3)) {
            callJs(jSONObject != null ? jSONObject.optString("callback") : null, "");
            Activity a16 = this.mRuntime.a();
            if (a16 == null) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("params", strArr[0]);
            a16.setResult(-1, intent);
            if (!a16.isFinishing()) {
                a16.finish();
            }
            return true;
        }
        if (jSONObject != null) {
            String optString2 = jSONObject.optString("cb");
            String optString3 = jSONObject.optString("webid");
            this.f390948f = optString2;
            this.f390950i = optString3;
            this.K = str2;
            this.f390951m = jSONObject.optString("groupcode", "");
            this.f390946d = jSONObject.optInt("outMaxWidth");
            int optInt = jSONObject.optInt("outMaxHeight");
            this.f390947e = optInt;
            if (this.f390946d == 0) {
                this.f390946d = 540;
            }
            if (optInt == 0) {
                this.f390947e = 540;
            }
        }
        if ("openRecord".equals(str3)) {
            Activity a17 = this.mRuntime.a();
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(a17, (Class<?>) TroopHWRecordArrangeActivity.class));
            intent2.putExtra("webid", this.f390950i);
            if (TextUtils.isEmpty(this.f390948f)) {
                a17.startActivity(intent2);
            } else {
                startActivityForResult(intent2, (byte) 1);
            }
        } else if ("playRecord".equals(str3)) {
            int optInt2 = jSONObject != null ? jSONObject.optInt("id") : -1;
            int i16 = this.J;
            if (i16 == -1) {
                this.H.k(optInt2, this.N.get(Integer.valueOf(optInt2)));
                this.J = optInt2;
            } else if (optInt2 != i16) {
                this.H.o();
                this.H.k(optInt2, this.N.get(Integer.valueOf(optInt2)));
                this.J = optInt2;
            }
        } else if ("stopPlayRecord".equals(str3)) {
            int optInt3 = jSONObject != null ? jSONObject.optInt("id") : -1;
            int i17 = this.J;
            if (i17 != -1 && optInt3 == i17) {
                this.H.o();
                this.J = -1;
            }
        } else if ("openUploadImage".equals(str3)) {
            int i18 = 10;
            if (jSONObject != null) {
                i18 = jSONObject.optInt(WidgetCacheConstellationData.NUM, 10);
                this.E = jSONObject.optInt("outMaxWidth");
                i3 = jSONObject.optInt("sourcetype");
            }
            QLog.i("TroopHWJsPlugin", 1, "openUploadVideo,options:" + i3);
            if (i3 == 1) {
                A((ao.b("homework") << 8) + 2);
            } else if (i3 == 2) {
                y(i18);
            } else if (i3 == 3) {
                QLog.d("TroopHWJsPlugin", 1, "openUploadVideo:" + jSONObject);
                if (TextUtils.isEmpty(this.f390948f) || TextUtils.isEmpty(this.f390951m)) {
                    QLog.w("TroopHWJsPlugin", 1, "empty openUploadVideo mJsCallback == " + this.f390948f + ", mTroopUin == " + this.f390951m);
                    return true;
                }
                z(i18);
            } else {
                U(i18);
            }
        } else if ("ShowGroupFile".equals(str3)) {
            if (jSONObject != null) {
                String optString4 = jSONObject.optString("filename");
                String optString5 = jSONObject.optString("filepath");
                String optString6 = jSONObject.optString("groupcode");
                String optString7 = jSONObject.optString(MediaDBValues.FILESIZE);
                str5 = jSONObject.optString("filebusinesstype");
                str7 = optString4;
                str6 = optString5;
                str4 = optString6;
                str8 = optString7;
            } else {
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            long longValue = TextUtils.isEmpty(str8) ? 0L : Long.valueOf(str8).longValue();
            int intValue = !TextUtils.isEmpty(str5) ? Integer.valueOf(str5).intValue() : 102;
            try {
                if (!TextUtils.isEmpty(str4)) {
                    this.G.getTroopFileStatusInfo(Long.valueOf(str4).longValue(), str6, str7, longValue, intValue, this);
                } else if (QLog.isColorLevel()) {
                    QLog.e("TroopHWJsPlugin", 2, "troopCode isEmpty ");
                }
            } catch (NumberFormatException unused2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopHWJsPlugin", 2, "NumberFormatException, troopCode " + str4);
                }
            }
        } else if ("PlayOnlineRecord".equals(str3)) {
            optString = jSONObject != null ? jSONObject.optString("url") : "";
            String str9 = this.I;
            if (str9 == null) {
                this.H.j(optString);
                this.I = optString;
            } else if (!str9.equals(optString)) {
                QLog.d("TroopHWJsPlugin", 1, "stop before play:" + this.I);
                this.H.o();
                this.H.j(optString);
                this.I = optString;
            }
        } else if ("StopOnlineRecord".equals(str3)) {
            optString = jSONObject != null ? jSONObject.optString("url") : "";
            String str10 = this.I;
            if (str10 != null && str10.equals(optString)) {
                this.H.o();
                this.I = null;
            } else {
                QLog.d("TroopHWJsPlugin", 1, "failed stop for current:" + this.I + ", target:" + optString);
            }
        } else if ("startRecord".equals(str3)) {
            this.H.g(this.mRuntime.b().getAccount());
        } else if ("endRecord".equals(str3)) {
            if (jSONObject != null) {
                this.L = jSONObject.optBoolean(AppConstants.Key.COLUMN_IS_VALID);
                this.M = jSONObject.optString("cgiUrl");
            }
            this.H.h();
        } else if ("getWeatherBackground".equals(str3)) {
            final String filePath = AbsDownloader.getFilePath(str);
            ThreadManagerV2.post(new Runnable() { // from class: cooperation.troop_homework.jsp.TroopHWJsPlugin.1
                /* JADX WARN: Removed duplicated region for block: B:64:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    FileInputStream fileInputStream;
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            try {
                                fileInputStream = new FileInputStream(filePath);
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                fileInputStream = null;
                            } catch (Exception e17) {
                                e = e17;
                                fileInputStream = null;
                            } catch (Throwable th5) {
                                th = th5;
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("imgData", (Object) null);
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                }
                                TroopHWJsPlugin troopHWJsPlugin = TroopHWJsPlugin.this;
                                troopHWJsPlugin.callJs(troopHWJsPlugin.f390948f, jSONObject2.toString());
                                if (0 == 0) {
                                }
                            }
                            try {
                                StringBuilder sb5 = new StringBuilder();
                                byte[] bArr = new byte[30720];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    if (read < 30720) {
                                        byte[] bArr2 = new byte[read];
                                        System.arraycopy(bArr, 0, bArr2, 0, read);
                                        sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr2, 2));
                                    } else {
                                        sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2));
                                    }
                                }
                                String sb6 = sb5.toString();
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.put("imgData", sb6);
                                } catch (Exception e19) {
                                    e19.printStackTrace();
                                }
                                TroopHWJsPlugin troopHWJsPlugin2 = TroopHWJsPlugin.this;
                                troopHWJsPlugin2.callJs(troopHWJsPlugin2.f390948f, jSONObject3.toString());
                                fileInputStream.close();
                            } catch (FileNotFoundException e26) {
                                e = e26;
                                e.printStackTrace();
                                JSONObject jSONObject4 = new JSONObject();
                                try {
                                    jSONObject4.put("imgData", (Object) null);
                                } catch (Exception e27) {
                                    e27.printStackTrace();
                                }
                                TroopHWJsPlugin troopHWJsPlugin3 = TroopHWJsPlugin.this;
                                troopHWJsPlugin3.callJs(troopHWJsPlugin3.f390948f, jSONObject4.toString());
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            } catch (Exception e28) {
                                e = e28;
                                e.printStackTrace();
                                JSONObject jSONObject5 = new JSONObject();
                                try {
                                    jSONObject5.put("imgData", (Object) null);
                                } catch (Exception e29) {
                                    e29.printStackTrace();
                                }
                                TroopHWJsPlugin troopHWJsPlugin4 = TroopHWJsPlugin.this;
                                troopHWJsPlugin4.callJs(troopHWJsPlugin4.f390948f, jSONObject5.toString());
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            JSONObject jSONObject22 = new JSONObject();
                            jSONObject22.put("imgData", (Object) null);
                            TroopHWJsPlugin troopHWJsPlugin5 = TroopHWJsPlugin.this;
                            troopHWJsPlugin5.callJs(troopHWJsPlugin5.f390948f, jSONObject22.toString());
                            if (0 == 0) {
                                try {
                                    fileInputStream2.close();
                                    throw th;
                                } catch (Exception e36) {
                                    e36.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e37) {
                        e37.printStackTrace();
                    }
                }
            }, 8, null, false);
        } else if ("startDownloadFile".equals(str3)) {
            if (jSONObject != null) {
                String optString8 = jSONObject.optString("url");
                String optString9 = jSONObject.optString("troopUin");
                this.R = jSONObject.optString("cb");
                this.Q.g(optString8, K(optString9, optString8), this);
            }
        } else if ("stopDownloadFile".equals(str3)) {
            if (jSONObject != null) {
                this.Q.f(jSONObject.optString("url"));
            }
        } else if ("isLocalFileExists".equals(str3)) {
            if (jSONObject != null) {
                String optString10 = jSONObject.optString("troopUin");
                JSONArray optJSONArray = jSONObject.optJSONArray("fileUrls");
                String optString11 = jSONObject.optString("cb");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    int length = optJSONArray.length();
                    for (int i19 = 0; i19 < length; i19++) {
                        jSONArray.put(i19, E(optString10, optJSONArray.getString(i19)));
                    }
                    jSONObject2.put("localFilePaths", jSONArray);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopHWJsPlugin", 2, "isLocalFileExists:", e16);
                    }
                }
                String jSONObject3 = jSONObject2.toString();
                callJs(optString11, jSONObject3);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopHWJsPlugin", 2, "isLocalFileExists:" + jSONObject + ", result:" + jSONObject3);
                }
            }
        } else if ("openLocalFilePreview".equals(str3)) {
            if (jSONObject != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopHWJsPlugin", 2, "openLocalFilePreview:" + jSONObject);
                }
                this.G.openLocalFilePreview(jSONObject.optString("localFilePath"), jSONObject.optString("fileDisPlayName"));
            }
        } else if ("reUpload".equals(str3) && jSONObject != null) {
            jSONObject.optString("type");
            UploadMediaEntry uploadMediaEntry2 = this.P.get(Integer.valueOf(jSONObject.optInt("id")));
            if (uploadMediaEntry2 != null && !uploadMediaEntry2.f390963f) {
                uploadMediaEntry2.a();
            }
        } else if ("cancelUpload".equals(str3) && jSONObject != null) {
            jSONObject.optString("type");
            UploadMediaEntry uploadMediaEntry3 = this.P.get(Integer.valueOf(jSONObject.optInt("id")));
            if (uploadMediaEntry3 != null && uploadMediaEntry3.f390963f) {
                uploadMediaEntry3.f390965h.set(true);
            }
        } else if ("clearRedPoint".equals(str3)) {
            if (jSONObject != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopHWJsPlugin", 2, "clearRedPoint. json:", jSONObject);
                }
                try {
                    this.G.clearHomeworkTroopRedPoint(jSONObject.optString("troopUin"), jSONObject.optString("type"));
                } catch (Exception e17) {
                    QLog.e("TroopHWJsPlugin", 1, "clearRedPoint exception.", e17);
                }
            }
        } else if ("playVideo".equals(str3)) {
            if (jSONObject != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopHWJsPlugin", 2, "playVideo:" + jSONObject);
                }
                UploadMediaEntry uploadMediaEntry4 = this.P.get(Integer.valueOf(jSONObject.optInt("id", 0)));
                if (uploadMediaEntry4 == null || TextUtils.isEmpty(uploadMediaEntry4.f390964g)) {
                    QLog.e("TroopHWJsPlugin", 1, "playVideo failed! entry = " + uploadMediaEntry4);
                } else {
                    ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                    forwardFileInfo.C(uploadMediaEntry4.f390964g);
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openTroopFilerDetailBrowse(this.mRuntime.a(), forwardFileInfo);
                }
            }
        } else if ("clearData".equals(str3)) {
            this.P.clear();
            this.F = 1;
        } else if ("showImage".equals(str3)) {
            if (jSONObject != null && (uploadMediaEntry = this.P.get(Integer.valueOf(jSONObject.optInt("id", 0)))) != null && !TextUtils.isEmpty(uploadMediaEntry.f390964g)) {
                this.G.openLocalFilePreview(uploadMediaEntry.f390964g, new File(uploadMediaEntry.f390964g).getName());
            }
        } else if ("publish".equals(str3)) {
            try {
                String string = new JSONObject(strArr[0]).getString("group_id");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        j3 = Long.parseLong(string);
                    } catch (Exception unused3) {
                        j3 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopHWJsPlugin", 2, "handle HW js publish, group_id = " + j3);
                    }
                    if (j3 > 0) {
                        WebViewPlugin.b bVar = this.mRuntime;
                        Activity a18 = bVar != null ? bVar.a() : null;
                        if (a18 != null) {
                            PublishHomeWorkFragment.Gi(a18, null, string);
                            a18.overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
                        }
                    } else {
                        QLog.w("TroopHWJsPlugin", 1, "handle HW js publish error, invalid group_id = " + string);
                    }
                }
            } catch (Exception e18) {
                QLog.e("TroopHWJsPlugin", 1, "publish handle Js arguments error ", e18);
            }
        } else if ("submit".equals(str3)) {
            try {
                JSONObject jSONObject4 = new JSONObject(strArr[0]);
                String string2 = jSONObject4.getString("hw_id");
                if (!TextUtils.isEmpty(string2)) {
                    try {
                        j16 = Long.parseLong(string2);
                    } catch (Exception unused4) {
                        j16 = 0;
                    }
                    QLog.d("TroopHWJsPlugin", 1, "handle HW js submit, hw_id = " + j16);
                    String string3 = jSONObject4.getString("group_id");
                    if (TextUtils.isEmpty(string3)) {
                        j17 = 0;
                    } else {
                        try {
                            j17 = Long.parseLong(string3);
                        } catch (Exception unused5) {
                            j17 = 0;
                        }
                        QLog.d("TroopHWJsPlugin", 1, "handle HW js submit, group_id = " + j17);
                    }
                    jSONObject4.getString("cb");
                    if (j16 > 0 && j17 > 0) {
                        WebViewPlugin.b bVar2 = this.mRuntime;
                        Activity a19 = bVar2 != null ? bVar2.a() : null;
                        ArrayList<BaseItem> I = I(jSONObject4);
                        if (a19 != null) {
                            SubmitHomeworkFragment.INSTANCE.a(string2, string3, a19, I, 8);
                        } else {
                            QLog.d("TroopHWJsPlugin", 1, "handle HW js submit failed for activity is null");
                        }
                    } else {
                        QLog.d("TroopHWJsPlugin", 1, "handle HW js submit failed for hwId,troopUin is " + j16 + "," + j17);
                    }
                }
            } catch (Exception e19) {
                QLog.e("TroopHWJsPlugin", 1, "handle submit Js arguments error ", e19);
            }
        } else if ("modify".equals(str3)) {
            try {
                JSONObject jSONObject5 = new JSONObject(strArr[0]);
                String string4 = jSONObject5.getString("hw_id");
                String string5 = jSONObject5.getString("group_id");
                QLog.d("TroopHWJsPlugin", 1, "handle HW js modify, group_id = " + string4 + ", hwId = " + string5);
                if (!TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string5)) {
                    try {
                        j18 = Long.parseLong(string4);
                    } catch (Exception unused6) {
                        j18 = 0;
                    }
                    try {
                        j19 = Long.parseLong(string5);
                    } catch (Exception unused7) {
                        j19 = 0;
                    }
                    if (j18 > 0 && j19 > 0) {
                        WebViewPlugin.b bVar3 = this.mRuntime;
                        Activity a26 = bVar3 != null ? bVar3.a() : null;
                        Bundle bundle = new Bundle();
                        bundle.putLong("hw_id", j18);
                        bundle.putInt("publish_homework_mode", 2);
                        if (a26 != null) {
                            PublishHomeWorkFragment.Gi(a26, bundle, string5);
                            a26.overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("TroopHWJsPlugin", 2, "handle Js arguments error homeworkId = " + string4 + " troopUinStr:" + string5);
                }
            } catch (Exception e26) {
                QLog.e("TroopHWJsPlugin", 1, "modify handle Js arguments error ", e26);
            }
        }
        return true;
    }

    @Override // cooperation.troop_homework.jsp.TroopHWVoiceController.b
    public void i(int i3, String str) {
        QLog.i("TroopHWJsPlugin", 1, "onStatusUpdate:" + i3 + "," + str);
        if (i3 != 1) {
            if (i3 == 3) {
                callJs(this.f390948f, "{'webid':'" + this.f390950i + "', 'type':'record', 'state':'stopPlay', 'url':'" + str + "'}");
                String str2 = this.I;
                if (str2 != null && str2.equals(str)) {
                    this.I = null;
                    return;
                }
                return;
            }
            return;
        }
        callJs(this.f390948f, "{'webid':'" + this.f390950i + "', 'type':'record', 'state':'downloaded', 'url':'" + str + "'}");
    }

    @Override // cooperation.troop_homework.jsp.TroopHWVoiceController.b
    public void o(int i3, String str) {
        callJs(this.f390948f, J(this.f390950i, i3, 0, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, null, -1).toString());
        int i16 = this.J;
        if (i16 != -1 && i3 == i16) {
            this.J = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c2  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String stringExtra;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String stringExtra2;
        ArrayList<String> arrayList;
        int i16;
        boolean z16;
        super.onActivityResult(intent, b16, i3);
        QLog.d("TroopHWJsPlugin", 1, "onActivityResult,req:" + ((int) b16) + ",res:" + i3);
        if (b16 != 1) {
            if (b16 != 2 && b16 != 3 && b16 != 5) {
                if (b16 != 7) {
                    if (b16 == 8 && i3 == -1 && intent != null) {
                        String stringExtra3 = intent.getStringExtra("SubmitHWAnimPartJsCallback");
                        if (!TextUtils.isEmpty(stringExtra3)) {
                            callJs(this.f390948f, stringExtra3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i3 == -1 && intent != null) {
                    String stringExtra4 = intent.getStringExtra("SubmitHomeWorkFragment:js_callback");
                    if (!TextUtils.isEmpty(stringExtra4)) {
                        callJs(this.f390948f, stringExtra4);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 == -1) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                if (b16 == 2 && !TextUtils.isEmpty(this.f390949h)) {
                    BaseImageUtil.savePhotoToSysAlbum(this.mRuntime.a(), this.f390949h);
                    hashMap.put(Integer.valueOf(this.F), this.f390949h);
                    this.F++;
                } else {
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null && arrayList.size() != 0) {
                        HashMap hashMap3 = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("selected pic or video! size = ");
                        if (hashMap3 != null) {
                            i16 = hashMap3.size();
                        } else {
                            i16 = 0;
                        }
                        sb5.append(i16);
                        QLog.d("TroopHWJsPlugin", 1, sb5.toString());
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (hashMap3 != null && QAlbumUtil.getMediaType((LocalMediaInfo) hashMap3.get(next)) == 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                hashMap2.put(Integer.valueOf(this.F), next);
                            } else {
                                hashMap.put(Integer.valueOf(this.F), next);
                            }
                            this.F++;
                        }
                        if (TextUtils.isEmpty(this.f390948f) || TextUtils.isEmpty(this.f390951m)) {
                            QLog.w("TroopHWJsPlugin", 1, "mJsCallback == " + this.f390948f + ", mTroopUin == " + this.f390951m);
                            return;
                        }
                    } else {
                        QLog.e("TroopHWJsPlugin", 1, "selected list empty!");
                        this.V.sendEmptyMessage(0);
                        return;
                    }
                }
                if (hashMap2.size() > 0) {
                    QLog.d("TroopHWJsPlugin", 1, "video selected! size = " + hashMap2.size());
                    VFSFile vFSFile = new VFSFile(L());
                    if (!vFSFile.exists()) {
                        vFSFile.mkdirs();
                    }
                    for (Map.Entry entry : hashMap2.entrySet()) {
                        int intValue = ((Integer) entry.getKey()).intValue();
                        if (!TextUtils.isEmpty((String) entry.getValue())) {
                            try {
                                callJs(this.f390948f, J(this.f390950i, intValue, 2, "select", null, -1).toString());
                            } catch (Exception e16) {
                                QLog.d("TroopHWJsPlugin", 1, "video selected callJs exception ", e16);
                                this.V.sendEmptyMessage(0);
                            }
                        }
                    }
                    ThreadManagerV2.postImmediately(new CompressVideoJob(new g(this.f390948f, this.f390951m, this.f390950i), hashMap2), null, false);
                }
                if (hashMap.size() > 0) {
                    QLog.d("TroopHWJsPlugin", 1, "pic selected! size = " + hashMap.size());
                    VFSFile vFSFile2 = new VFSFile(L());
                    if (!vFSFile2.exists()) {
                        vFSFile2.mkdirs();
                    }
                    for (Map.Entry entry2 : hashMap.entrySet()) {
                        int intValue2 = ((Integer) entry2.getKey()).intValue();
                        if (!TextUtils.isEmpty((String) entry2.getValue())) {
                            try {
                                callJs(this.f390948f, J(this.f390950i, intValue2, 1, "select", null, -1).toString());
                            } catch (Exception e17) {
                                QLog.d("TroopHWJsPlugin", 1, "picture selected callJs exception ", e17);
                                this.V.sendEmptyMessage(0);
                            }
                        }
                    }
                    ThreadManagerV2.postImmediately(new CompressImageJob(hashMap), null, false);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == -1) {
            if (intent == null) {
                stringExtra = "";
            } else {
                stringExtra = intent.getStringExtra("jscallback");
            }
            try {
                jSONObject2 = new JSONObject(stringExtra);
            } catch (JSONException e18) {
                e = e18;
                jSONObject = null;
            }
            try {
                jSONObject2.put("id", this.F);
            } catch (JSONException e19) {
                e = e19;
                jSONObject = jSONObject2;
                e.printStackTrace();
                jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                }
            }
            if (jSONObject2 != null) {
                this.V.sendEmptyMessage(0);
                return;
            }
            callJs(this.f390948f, jSONObject2.toString());
            if (intent == null) {
                stringExtra2 = "";
            } else {
                stringExtra2 = intent.getStringExtra("localPath");
            }
            this.N.put(Integer.valueOf(this.F), stringExtra2);
            UploadMediaEntry F = F(this, this.F, stringExtra2, null, new g(this.f390948f, this.f390951m, this.f390950i), 0, stringExtra2);
            this.P.put(Integer.valueOf(this.F), F);
            F.b();
            this.F++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        ITroopMemberApiClientApi iTroopMemberApiClientApi = (ITroopMemberApiClientApi) QRoute.api(ITroopMemberApiClientApi.class);
        this.G = iTroopMemberApiClientApi;
        iTroopMemberApiClientApi.doBindService();
        this.H = new TroopHWVoiceController(this.mRuntime.a(), this);
        this.Q = new TroopHWFileDownloadManager(this.mRuntime.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        ITroopMemberApiClientApi iTroopMemberApiClientApi = this.G;
        if (iTroopMemberApiClientApi != null) {
            iTroopMemberApiClientApi.doUnbindService();
        }
        super.onDestroy();
        TroopHWFileDownloadManager troopHWFileDownloadManager = this.Q;
        if (troopHWFileDownloadManager != null) {
            troopHWFileDownloadManager.e(this.mRuntime.a());
        }
        if ("homework".equals(this.K)) {
            Iterator<Map.Entry<Integer, String>> it = this.N.entrySet().iterator();
            while (it.hasNext()) {
                String value = it.next().getValue();
                if (!TextUtils.isEmpty(value) && value.contains("stream")) {
                    VFSFile vFSFile = new VFSFile(value);
                    if (vFSFile.exists()) {
                        vFSFile.delete();
                    }
                }
            }
        }
    }

    @Override // cooperation.troop_homework.jsp.TroopHWFileDownloadManager.b
    public void onProgress(String str, long j3, long j16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put("state", 2);
            jSONObject.put("finishLen", j3);
            jSONObject.put("fileLen", j16);
            callJs(this.R, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        CustomWebView e16 = this.mRuntime.e();
        if (e16 != null && e16.getUrl() != null && e16.getUrl().contains("https://")) {
            this.S = true;
        }
    }

    protected void y(int i3) {
        Activity a16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            a16 = null;
        } else {
            a16 = bVar.a();
        }
        if (a16 == null) {
            QLog.w("TroopHWJsPlugin", 1, "checkAndGoPicSelect activity == null");
            this.V.sendEmptyMessage(3);
        } else {
            if (a16 instanceof AppActivity) {
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(a16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK));
                if (!P(qQPermission)) {
                    qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(i3));
                    return;
                } else {
                    M(i3);
                    return;
                }
            }
            M(i3);
        }
    }

    protected void z(int i3) {
        Activity a16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            a16 = null;
        } else {
            a16 = bVar.a();
        }
        if (a16 == null) {
            this.V.sendEmptyMessage(4);
            return;
        }
        if (a16 instanceof AppActivity) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(a16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP_APP, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK));
            if (!P(qQPermission)) {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new f(i3));
                return;
            } else {
                N(i3);
                return;
            }
        }
        N(i3);
    }

    @Override // cooperation.troop_homework.jsp.TroopHWVoiceController.b
    public void f() {
    }

    @Override // cooperation.troop_homework.jsp.TroopHWVoiceController.b
    public void g() {
    }
}
