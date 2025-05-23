package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationH5;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationWink;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZoneImageUtils;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QZoneMediaWebPlugin;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.BaseActivity;
import okhttp3.HttpUrl;
import org.apache.http.HttpResponse;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class MediaApiPlugin extends WebViewPlugin implements QQProgressDialog.b, ITroopMemberApiClientApi.a, ThreadExcutor.IThreadListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    static final String f238608i;

    /* renamed from: d, reason: collision with root package name */
    Thread f238609d;

    /* renamed from: e, reason: collision with root package name */
    QQProgressDialog f238610e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.biz.troop.b f238611f;

    /* renamed from: h, reason: collision with root package name */
    private QQPermission f238612h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class PreparePicturesAndCallbackThread extends BaseThread {
        static IPatchRedirector $redirector_;
        String C;
        int D;
        int E;
        int F;
        int G;
        String[] H;
        String I;
        String J;
        boolean K;
        String L;

        public PreparePicturesAndCallbackThread(String str, boolean z16, String str2, int i3, int i16, int i17, int i18, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), strArr);
                return;
            }
            this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            this.C = str;
            this.D = i3;
            this.E = i16;
            this.F = i17;
            this.G = i18;
            this.H = strArr;
            this.K = z16;
            this.L = str2;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    try {
                        try {
                            try {
                                int length = this.H.length;
                                for (int i3 = 0; i3 < length; i3++) {
                                    if (!isInterrupted()) {
                                        jSONArray.mo162put(MediaApiPlugin.P(this.H[i3], this.F, this.G, this.D, this.E));
                                    } else {
                                        throw new InterruptedException();
                                    }
                                }
                            } catch (JSONException unused) {
                                this.I = "2";
                                this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                                QQProgressDialog qQProgressDialog = MediaApiPlugin.this.f238610e;
                                if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                                    MediaApiPlugin.this.f238610e.dismiss();
                                }
                                if (!this.K) {
                                    try {
                                        MediaApiPlugin.this.callJs(this.C, this.I, this.J);
                                        return;
                                    } catch (OutOfMemoryError unused2) {
                                        System.gc();
                                        this.I = "3";
                                        this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                                        MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                        return;
                                    }
                                }
                            }
                        } catch (OutOfMemoryError unused3) {
                            System.gc();
                            this.I = "3";
                            this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                            QQProgressDialog qQProgressDialog2 = MediaApiPlugin.this.f238610e;
                            if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                                MediaApiPlugin.this.f238610e.dismiss();
                            }
                            if (!this.K) {
                                try {
                                    MediaApiPlugin.this.callJs(this.C, this.I, this.J);
                                    return;
                                } catch (OutOfMemoryError unused4) {
                                    System.gc();
                                    this.I = "3";
                                    this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                                    MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                    return;
                                }
                            }
                        }
                    } catch (IOException unused5) {
                        this.I = "2";
                        this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                        QQProgressDialog qQProgressDialog3 = MediaApiPlugin.this.f238610e;
                        if (qQProgressDialog3 != null && qQProgressDialog3.isShowing()) {
                            MediaApiPlugin.this.f238610e.dismiss();
                        }
                        if (!this.K) {
                            try {
                                MediaApiPlugin.this.callJs(this.C, this.I, this.J);
                                return;
                            } catch (OutOfMemoryError unused6) {
                                System.gc();
                                this.I = "3";
                                this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                                MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused7) {
                    Activity a16 = MediaApiPlugin.this.mRuntime.a();
                    if (a16 != null && !a16.isFinishing()) {
                        this.I = "4";
                        this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                    }
                    QQProgressDialog qQProgressDialog4 = MediaApiPlugin.this.f238610e;
                    if (qQProgressDialog4 != null && qQProgressDialog4.isShowing()) {
                        MediaApiPlugin.this.f238610e.dismiss();
                    }
                    if (!this.K) {
                        try {
                            MediaApiPlugin.this.callJs(this.C, this.I, this.J);
                            return;
                        } catch (OutOfMemoryError unused8) {
                            System.gc();
                            this.I = "3";
                            this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                            MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                            return;
                        }
                    }
                }
                if (!isInterrupted()) {
                    this.I = "0";
                    this.J = jSONArray.toString();
                    QQProgressDialog qQProgressDialog5 = MediaApiPlugin.this.f238610e;
                    if (qQProgressDialog5 != null && qQProgressDialog5.isShowing()) {
                        MediaApiPlugin.this.f238610e.dismiss();
                    }
                    if (!this.K) {
                        try {
                            MediaApiPlugin.this.callJs(this.C, this.I, this.J);
                            return;
                        } catch (OutOfMemoryError unused9) {
                            System.gc();
                            this.I = "3";
                            this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                            MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                            return;
                        }
                    }
                    MediaApiPlugin.this.callJs4OpenApiIfNeeded(this.L, 0, this.J);
                    return;
                }
                throw new InterruptedException();
            } catch (Throwable th5) {
                QQProgressDialog qQProgressDialog6 = MediaApiPlugin.this.f238610e;
                if (qQProgressDialog6 != null && qQProgressDialog6.isShowing()) {
                    MediaApiPlugin.this.f238610e.dismiss();
                }
                if (this.K) {
                    MediaApiPlugin.this.callJs4OpenApiIfNeeded(this.L, 0, this.J);
                } else {
                    try {
                        MediaApiPlugin.this.callJs(this.C, this.I, this.J);
                    } catch (OutOfMemoryError unused10) {
                        System.gc();
                        this.I = "3";
                        this.J = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                        MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    }
                }
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class PreparePicturesAndCallbackThreadV2 extends BaseThread {
        static IPatchRedirector $redirector_;
        String C;
        int D;
        String[] E;

        public PreparePicturesAndCallbackThreadV2(String str, int i3, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, str, Integer.valueOf(i3), strArr);
                return;
            }
            this.C = str;
            this.D = i3;
            this.E = strArr;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            JSONArray jSONArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    try {
                        try {
                            jSONArray = new JSONArray();
                            int length = this.E.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                if (!isInterrupted()) {
                                    jSONArray.mo162put(MediaApiPlugin.Q(this.E[i3], this.D));
                                } else {
                                    throw new InterruptedException();
                                }
                            }
                        } catch (IOException unused) {
                            MediaApiPlugin.this.callJs(this.C, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                            if (!MediaApiPlugin.this.f238610e.isShowing()) {
                                return;
                            }
                        } catch (OutOfMemoryError unused2) {
                            System.gc();
                            MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                            if (!MediaApiPlugin.this.f238610e.isShowing()) {
                                return;
                            }
                        }
                    } catch (JSONException unused3) {
                        MediaApiPlugin.this.callJs(this.C, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        if (!MediaApiPlugin.this.f238610e.isShowing()) {
                            return;
                        }
                    }
                } catch (InterruptedException unused4) {
                    Activity a16 = MediaApiPlugin.this.mRuntime.a();
                    if (a16 != null && !a16.isFinishing()) {
                        MediaApiPlugin.this.callJs(this.C, "1", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    }
                    if (!MediaApiPlugin.this.f238610e.isShowing()) {
                        return;
                    }
                }
                if (!isInterrupted()) {
                    MediaApiPlugin.this.callJs(this.C, "0", jSONArray.toString());
                    if (!MediaApiPlugin.this.f238610e.isShowing()) {
                        return;
                    }
                    MediaApiPlugin.this.f238610e.dismiss();
                    return;
                }
                throw new InterruptedException();
            } catch (Throwable th5) {
                if (MediaApiPlugin.this.f238610e.isShowing()) {
                    MediaApiPlugin.this.f238610e.dismiss();
                }
                throw th5;
            }
        }
    }

    /* loaded from: classes15.dex */
    class PrepareSinglePictureAndCallbackThread extends BaseThread {
        static IPatchRedirector $redirector_;
        String C;
        int D;
        int E;
        int F;
        int G;
        String H;

        public PrepareSinglePictureAndCallbackThread(String str, int i3, int i16, int i17, int i18, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str2);
                return;
            }
            this.C = str;
            this.D = i3;
            this.E = i16;
            this.F = i17;
            this.G = i18;
            this.H = str2;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            JSONObject P;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    try {
                        try {
                            P = MediaApiPlugin.P(this.H, this.F, this.G, this.D, this.E);
                        } catch (InterruptedException unused) {
                            Activity a16 = MediaApiPlugin.this.mRuntime.a();
                            if (a16 != null && !a16.isFinishing()) {
                                MediaApiPlugin.this.callJs(this.C, "1", "{}");
                            }
                            QQProgressDialog qQProgressDialog = MediaApiPlugin.this.f238610e;
                            if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
                                return;
                            }
                        } catch (OutOfMemoryError unused2) {
                            System.gc();
                            MediaApiPlugin.this.callJs(this.C, "3", "{}");
                            QQProgressDialog qQProgressDialog2 = MediaApiPlugin.this.f238610e;
                            if (qQProgressDialog2 == null || !qQProgressDialog2.isShowing()) {
                                return;
                            }
                        }
                    } catch (IOException unused3) {
                        MediaApiPlugin.this.callJs(this.C, "2", "{}");
                        QQProgressDialog qQProgressDialog3 = MediaApiPlugin.this.f238610e;
                        if (qQProgressDialog3 == null || !qQProgressDialog3.isShowing()) {
                            return;
                        }
                    }
                } catch (JSONException unused4) {
                    MediaApiPlugin.this.callJs(this.C, "2", "{}");
                    QQProgressDialog qQProgressDialog4 = MediaApiPlugin.this.f238610e;
                    if (qQProgressDialog4 == null || !qQProgressDialog4.isShowing()) {
                        return;
                    }
                }
                if (!isInterrupted()) {
                    MediaApiPlugin.this.callJs(this.C, "0", P.toString());
                    QQProgressDialog qQProgressDialog5 = MediaApiPlugin.this.f238610e;
                    if (qQProgressDialog5 == null || !qQProgressDialog5.isShowing()) {
                        return;
                    }
                    MediaApiPlugin.this.f238610e.dismiss();
                    return;
                }
                throw new InterruptedException();
            } catch (Throwable th5) {
                QQProgressDialog qQProgressDialog6 = MediaApiPlugin.this.f238610e;
                if (qQProgressDialog6 != null && qQProgressDialog6.isShowing()) {
                    MediaApiPlugin.this.f238610e.dismiss();
                }
                throw th5;
            }
        }
    }

    /* loaded from: classes15.dex */
    class PrepareSinglePictureAndCallbackThreadV2 extends BaseThread {
        static IPatchRedirector $redirector_;
        String C;
        int D;
        String E;

        public PrepareSinglePictureAndCallbackThreadV2(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, str, Integer.valueOf(i3), str2);
                return;
            }
            this.C = str;
            this.D = i3;
            this.E = str2;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            JSONObject Q;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    try {
                        Q = MediaApiPlugin.Q(this.E, this.D);
                    } catch (InterruptedException unused) {
                        Activity a16 = MediaApiPlugin.this.mRuntime.a();
                        if (a16 != null && !a16.isFinishing()) {
                            MediaApiPlugin.this.callJs(this.C, "1", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        }
                        if (!MediaApiPlugin.this.f238610e.isShowing()) {
                            return;
                        }
                    } catch (JSONException unused2) {
                        MediaApiPlugin.this.callJs(this.C, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        if (!MediaApiPlugin.this.f238610e.isShowing()) {
                            return;
                        }
                    }
                } catch (IOException unused3) {
                    MediaApiPlugin.this.callJs(this.C, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    if (!MediaApiPlugin.this.f238610e.isShowing()) {
                        return;
                    }
                } catch (OutOfMemoryError unused4) {
                    System.gc();
                    MediaApiPlugin.this.callJs(this.C, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    if (!MediaApiPlugin.this.f238610e.isShowing()) {
                        return;
                    }
                }
                if (!isInterrupted()) {
                    MediaApiPlugin.this.callJs(this.C, "0", Q.toString());
                    if (!MediaApiPlugin.this.f238610e.isShowing()) {
                        return;
                    }
                    MediaApiPlugin.this.f238610e.dismiss();
                    return;
                }
                throw new InterruptedException();
            } catch (Throwable th5) {
                if (MediaApiPlugin.this.f238610e.isShowing()) {
                    MediaApiPlugin.this.f238610e.dismiss();
                }
                throw th5;
            }
        }
    }

    /* loaded from: classes15.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f238622a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f238623b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f238624c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f238625d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f238626e;

        a(Intent intent, Context context, String str, JSONObject jSONObject, boolean z16) {
            this.f238622a = intent;
            this.f238623b = context;
            this.f238624c = str;
            this.f238625d = jSONObject;
            this.f238626e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, intent, context, str, jSONObject, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MediaApiPlugin.this.O(this.f238622a, this.f238623b, this.f238624c, this.f238625d, this.f238626e);
                super.onAllGranted();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            QLog.d(MediaApiPlugin.f238608i, 1, "User requestPermissions " + list + list2);
        }
    }

    /* loaded from: classes15.dex */
    class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f238628a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f238629b;

        b(boolean z16, String[] strArr) {
            this.f238628a = z16;
            this.f238629b = strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, Boolean.valueOf(z16), strArr);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                MediaApiPlugin.this.V(this.f238628a, this.f238629b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class c implements Consumer<RFWSaveMediaResultBean> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238631d;

        c(String str) {
            this.f238631d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MediaApiPlugin.this, (Object) str);
            }
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MediaApiPlugin.this.H(this.f238631d, rFWSaveMediaResultBean);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rFWSaveMediaResultBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d implements Consumer<RFWSaveMediaResultBean> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238633d;

        d(String str) {
            this.f238633d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MediaApiPlugin.this, (Object) str);
            }
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MediaApiPlugin.this.H(this.f238633d, rFWSaveMediaResultBean);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rFWSaveMediaResultBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class e extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f238635a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f238636b;

        e(JSONObject jSONObject, boolean z16) {
            this.f238635a = jSONObject;
            this.f238636b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, jSONObject, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MediaApiPlugin.this.X(this.f238635a, this.f238636b);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            QLog.d(MediaApiPlugin.f238608i, 1, "User requestPermissions " + list + list2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72656);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f238608i = UiApiPlugin.class.getSimpleName();
        }
    }

    public MediaApiPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A(Intent intent, byte b16, int i3) {
        int i16;
        String str;
        int i17;
        int i18;
        ArrayList<String> arrayList;
        String[] strArr;
        boolean z16;
        ThreadExcutor.IThreadListener iThreadListener;
        int i19;
        String str2;
        String str3;
        boolean z17;
        long j3;
        SharedPreferences y16 = y(BaseApplication.getContext());
        String string = y16.getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, "");
        String string2 = y16.getString(QZoneMediaWebPlugin.KEY_GET_MEDIA_PARAM, "");
        boolean z18 = y16.getBoolean("calledFromOpenApi", false);
        y16.edit().remove(AppConstants.Preferences.CAMERA_PHOTO_PATH).remove(QZoneMediaWebPlugin.KEY_GET_MEDIA_PARAM).remove("calledFromOpenApi").commit();
        if (b16 == 6) {
            string2 = intent.getStringExtra("savedParam");
        }
        if (TextUtils.isEmpty(string2) && !z18) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            String optString = jSONObject.optString("method");
            String optString2 = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString2) && !z18) {
                return;
            }
            if (intent == null || intent.getIntExtra("skipSelect", 0) <= 0) {
                Object obj = "";
                String str4 = string2;
                if (b16 != 1 && b16 != 2) {
                    if (b16 == 6) {
                        i16 = 1;
                        str = optString;
                        i18 = -1;
                        i17 = 5;
                    } else {
                        if (b16 == 3 && i3 == -1) {
                            if (intent != null) {
                                str2 = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                            } else {
                                str2 = null;
                            }
                            if (intent != null && intent.getBooleanExtra(PeakConstants.IS_VIDEO_SELECTED, false)) {
                                z17 = true;
                                str3 = optString;
                            } else {
                                str3 = optString;
                                z17 = false;
                            }
                            long j16 = 0;
                            if (intent != null) {
                                j3 = intent.getLongExtra(PeakConstants.VIDEO_SIZE, 0L);
                            } else {
                                j3 = 0;
                            }
                            if (intent != null) {
                                j16 = intent.getLongExtra(ShortVideoConstants.FILE_SEND_DURATION, 0L);
                            }
                            if (z17) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject z19 = z(str2);
                                try {
                                    z19.put("videoDuration", j16 / 1000);
                                    z19.put(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, j3 / 1024);
                                    z19.put("mediaType", 1);
                                } catch (JSONException e16) {
                                    e16.printStackTrace();
                                }
                                jSONArray.mo162put(z19);
                                callJs(optString2, "0", jSONArray.toString());
                                return;
                            }
                            PreparePicturesAndCallbackThread preparePicturesAndCallbackThread = new PreparePicturesAndCallbackThread(optString2, z18, str3, jSONObject.optInt("outMaxWidth", 2000), jSONObject.optInt("outMaxHeight", 3000), jSONObject.optInt("inMinWidth", 0), jSONObject.optInt("inMinHeight", 0), new String[]{str2});
                            this.f238609d = preparePicturesAndCallbackThread;
                            ThreadManagerV2.post(preparePicturesAndCallbackThread, 5, null, true);
                            return;
                        }
                        return;
                    }
                } else {
                    i16 = 1;
                    str = optString;
                    i17 = 5;
                    i18 = -1;
                }
                if (i3 == i18) {
                    if (b16 == i16) {
                        strArr = new String[i16];
                        strArr[0] = string;
                    } else {
                        if (intent != null) {
                            arrayList = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                        } else {
                            arrayList = null;
                        }
                        if (arrayList != null && arrayList.size() != 0) {
                            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                        } else {
                            String str5 = str;
                            if (z18) {
                                callJs4OpenApiIfNeeded(str5, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                return;
                            } else {
                                callJs(optString2, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                return;
                            }
                        }
                    }
                    if (b16 == i16 && jSONObject.optBoolean("needCrop", false)) {
                        if (getCurrentContext() == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(f238608i, 2, " currentContext is null");
                                return;
                            }
                            return;
                        }
                        Intent intent2 = new Intent();
                        int optInt = jSONObject.optInt("businessOrigin");
                        if (optInt == 0) {
                            optInt = 103;
                        }
                        int switchRequestCode = this.mRuntime.f().switchRequestCode(this, (byte) 6);
                        intent2.putExtra("keyAction", "actionSelectPicture");
                        intent2.putExtra("requestCode", switchRequestCode);
                        intent2.putExtra("savedParam", str4);
                        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit((Activity) getCurrentContext(), intent2, strArr[0], optInt);
                        return;
                    }
                    String str6 = null;
                    if (jSONObject.optBoolean("urlOnly", false)) {
                        try {
                            JSONArray jSONArray2 = new JSONArray();
                            int length = strArr.length;
                            int i26 = 0;
                            while (i26 < length) {
                                String str7 = strArr[i26];
                                JSONObject jSONObject2 = new JSONObject();
                                Object obj2 = obj;
                                jSONObject2.put("data", obj2);
                                jSONObject2.put(QZoneImageUtils.KEY_IMAGE_ID, str7);
                                str6 = QZoneImageUtils.KEY_MATCH;
                                jSONObject2.put(QZoneImageUtils.KEY_MATCH, 0);
                                jSONArray2.mo162put(jSONObject2);
                                i26++;
                                obj = obj2;
                            }
                            try {
                                if (z18) {
                                    str6 = str;
                                    callJs4OpenApiIfNeeded(str6, 0, jSONArray2.toString());
                                } else {
                                    str6 = str;
                                    String[] strArr2 = new String[2];
                                    strArr2[0] = "0";
                                    strArr2[i16] = jSONArray2.toString();
                                    callJs(optString2, strArr2);
                                }
                            } catch (JSONException unused) {
                                if (z18) {
                                    callJs4OpenApiIfNeeded(str6, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                } else {
                                    callJs(optString2, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                }
                            }
                        } catch (JSONException unused2) {
                            str6 = str;
                        }
                    } else {
                        String str8 = str;
                        if (this.f238610e == null) {
                            Activity a16 = this.mRuntime.a();
                            QQProgressDialog qQProgressDialog = new QQProgressDialog(a16, a16.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                            this.f238610e = qQProgressDialog;
                            qQProgressDialog.setMessage(R.string.c7z);
                            this.f238610e.O(this);
                        }
                        Thread thread = this.f238609d;
                        if (thread != null) {
                            thread.interrupt();
                        }
                        if (!this.f238610e.isShowing()) {
                            this.f238610e.show();
                        }
                        if ("getPictureV2".equals(str8)) {
                            this.f238609d = new PreparePicturesAndCallbackThreadV2(optString2, jSONObject.optInt(HippyQQPagViewController.PropertyName.SCALE_MODE, 0), strArr);
                            z16 = i16;
                            i19 = i17;
                            iThreadListener = null;
                        } else {
                            z16 = i16;
                            iThreadListener = null;
                            i19 = i17;
                            this.f238609d = new PreparePicturesAndCallbackThread(optString2, z18, str8, jSONObject.optInt("outMaxWidth", 1280), jSONObject.optInt("outMaxHeight", 1280), jSONObject.optInt("inMinWidth", i16), jSONObject.optInt("inMinHeight", i16), strArr);
                        }
                        ThreadManagerV2.post(this.f238609d, i19, iThreadListener, z16);
                    }
                } else {
                    String str9 = str;
                    if (z18) {
                        callJs4OpenApiIfNeeded(str9, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    } else {
                        callJs(optString2, "1", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    }
                }
            } else {
                callJs(optString2, "0", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }

    private void B() {
        QQProgressDialog qQProgressDialog = this.f238610e;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f238610e.dismiss();
        }
    }

    private void C(final String str, final String str2) {
        W();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.r
            @Override // java.lang.Runnable
            public final void run() {
                MediaApiPlugin.this.M(str2, str);
            }
        }, 128, this, true);
    }

    private boolean D(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            QLog.e(f238608i, 1, "[insertImg] imagePath is empty.");
            return false;
        }
        if (!new File(str2).exists()) {
            QLog.e(f238608i, 1, "[insertImg] file not exists.");
            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.nyx), 0).show();
            return false;
        }
        RFWSaveUtil.insertMedia(BaseApplication.getContext(), str2, new c(str));
        return true;
    }

    private boolean E(String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null) {
                QLog.e(f238608i, 1, "[insertMediaBytes] not img data.");
                return false;
            }
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("photo/");
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("media_api_plugin_enable_delete_photo_file_8988", true)) {
                File file = new File(sDKPrivatePath);
                if (file.exists() && file.isFile()) {
                    RFWFileUtils.deleteFile(file);
                    QLog.d(f238608i, 1, "delete photo file.");
                }
            }
            RFWSaveUtil.saveBitmapAndInsertImage(BaseApplication.getContext(), decodeByteArray, sDKPrivatePath + System.currentTimeMillis() + ".jpg", false, new d(str));
            return true;
        }
        QLog.e(f238608i, 1, "[insertMediaBytes] imageData is empty.");
        return false;
    }

    private void F(String str, int i3, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", i3);
            jSONObject.put("msg", str2);
        } catch (JSONException e16) {
            QLog.e(f238608i, 1, "[insertImgCallBack] json error: " + e16);
        }
        L(str, jSONObject.toString());
    }

    private void G(String str, int i3, String str2, int i16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", i3);
            jSONObject.put("msg", str2);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i16);
        } catch (JSONException e16) {
            QLog.e(f238608i, 1, "[insertImgCallBack] json error: " + e16);
        }
        L(str, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        BaseApplication context = BaseApplication.getContext();
        boolean z16 = rFWSaveMediaResultBean.isSuccess;
        int i16 = !z16 ? 1 : 0;
        if (z16) {
            i3 = R.string.h4_;
        } else {
            i3 = R.string.g2q;
        }
        Object string = context.getString(i3);
        String str2 = rFWSaveMediaResultBean.savePath;
        try {
            jSONObject.put("retCode", i16);
            jSONObject.put("msg", string);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(QZoneImageUtils.KEY_IMAGE_ID, str2);
            }
        } catch (JSONException e16) {
            QLog.e(f238608i, 1, "[insertImgCallBack] json error: " + e16);
        }
        L(str, jSONObject.toString());
    }

    private void I(String[] strArr) {
        JSONException e16;
        final String str;
        JSONObject jSONObject;
        final BaseApplication context = BaseApplication.getContext();
        String str2 = null;
        try {
            jSONObject = new JSONObject(strArr[0]);
            str = jSONObject.optString("callback");
        } catch (JSONException e17) {
            e16 = e17;
            str = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String optString = jSONObject.optString("imagePath");
            if (!TextUtils.isEmpty(optString)) {
                QLog.d(f238608i, 1, "[insertImgToAlbum] save imagePath.");
                if (!D(str, optString)) {
                    F(str, 2, context.getString(R.string.h47));
                    return;
                }
                return;
            }
            final String string = jSONObject.getString("content");
            if (TextUtils.isEmpty(string)) {
                QLog.e(f238608i, 1, "[insertMedia] content is empty.");
                F(str, 4, context.getString(R.string.h47));
                return;
            }
            if (!string.startsWith("http://") && !string.startsWith("https://")) {
                if (string.startsWith("data:")) {
                    QLog.d(f238608i, 1, "[insertImgToAlbum] decode and save imagePath.");
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaApiPlugin.this.N(string, str, context);
                        }
                    }, 64, null, true);
                    return;
                }
                return;
            }
            QLog.d(f238608i, 1, "[insertImgToAlbum] download and save imagePath.");
            C(str, string);
        } catch (JSONException e18) {
            e16 = e18;
            F(str, 4, context.getString(R.string.h47));
            QLog.e(f238608i, 1, "[insertMedia] error: " + e16);
        } catch (Throwable th6) {
            th = th6;
            str2 = str;
            F(str2, 1, context.getString(R.string.h49));
            QLog.e(f238608i, 1, "[insertMedia] error: " + th);
        }
    }

    private boolean J() {
        boolean z16;
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_MEDIA);
        if (this.f238612h == null) {
            this.f238612h = QQPermissionFactory.getQQPermission(this.mRuntime.a(), businessConfig);
        }
        if (this.f238612h.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Camera.getNumberOfCameras() > 0) {
            return true;
        }
        return false;
    }

    private static boolean K(Activity activity) {
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        if ((activity instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && !fragments.isEmpty()) {
            for (Fragment fragment : fragments) {
                if ((fragment instanceof BaseHippyFragment) || "MiniHippyWebViewFragment".equals(fragment.getClass().getSimpleName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(String str, String str2) {
        BaseApplication context = BaseApplication.getContext();
        try {
            HttpResponse openRequest = HttpUtil.openRequest(BaseApplication.getContext(), str, null, "GET", null, null);
            if (openRequest != null) {
                int statusCode = openRequest.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    if (!E(str2, HttpUtil.readHttpResponseSteam(openRequest).toByteArray())) {
                        F(str2, 2, context.getString(R.string.h47));
                    }
                } else {
                    G(str2, 3, context.getString(R.string.h48), statusCode);
                }
            }
        } catch (Exception e16) {
            QLog.w(f238608i, 1, "insertImageRemote network exception. ", e16);
            F(str2, 1, context.getString(R.string.h49));
        } catch (OutOfMemoryError e17) {
            F(str2, -1, context.getString(R.string.h4a));
            QLog.e(f238608i, 1, "[insertMedia] oom: " + e17.getMessage(), e17);
        } catch (Throwable th5) {
            F(str2, -1, context.getString(R.string.f223936hk));
            QLog.e(f238608i, 1, "[insertMedia] error: " + th5.getMessage(), th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(String str, String str2, Context context) {
        byte[] bArr;
        try {
            int indexOf = str.indexOf(44);
            if (indexOf > 0) {
                bArr = PluginBaseInfoHelper.Base64Helper.decode(str.substring(indexOf), 0);
            } else {
                bArr = null;
            }
            if (bArr != null && bArr.length != 0) {
                if (!E(str2, bArr)) {
                    F(str2, 2, context.getString(R.string.h47));
                    return;
                }
                return;
            }
            F(str2, 4, context.getString(R.string.h47));
        } catch (IllegalArgumentException e16) {
            F(str2, 4, context.getString(R.string.h47));
            QLog.e(f238608i, 1, "[insertMedia] error: " + e16.getMessage(), e16);
        } catch (OutOfMemoryError e17) {
            F(str2, -1, context.getString(R.string.h4a));
            QLog.e(f238608i, 1, "[insertMedia] oom: " + e17.getMessage(), e17);
        } catch (Throwable th5) {
            F(str2, -1, context.getString(R.string.f223936hk));
            QLog.e(f238608i, 1, "[insertMedia] error: " + th5.getMessage(), th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Intent intent, Context context, String str, JSONObject jSONObject, boolean z16) {
        try {
            startActivityForResult(intent, (byte) 1);
            y(context).edit().putString(AppConstants.Preferences.CAMERA_PHOTO_PATH, str).putString(QZoneMediaWebPlugin.KEY_GET_MEDIA_PARAM, jSONObject.toString()).putBoolean("calledFromOpenApi", z16).commit();
        } catch (Exception e16) {
            QLog.e(f238608i, 1, e16, new Object[0]);
            QQToast.makeText(context, R.string.f170671xw, 0).show();
        }
    }

    public static JSONObject P(String str, int i3, int i16, int i17, int i18) throws JSONException, IOException, InterruptedException, OutOfMemoryError {
        float f16;
        int height;
        StringBuilder sb5;
        FileInputStream fileInputStream;
        StringBuilder sb6;
        JSONObject jSONObject = new JSONObject();
        File file = new File(str);
        if (file.length() >= 3) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i19 = options.outWidth;
            int i26 = options.outHeight;
            if (i19 < 0 || i26 < 0) {
                throw new IOException();
            }
            if (i19 < i3 || i26 < i16) {
                jSONObject.put(QZoneImageUtils.KEY_MATCH, 1);
            } else if (i19 <= i17 && i26 <= i18) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    int read = fileInputStream.read();
                    int read2 = fileInputStream.read();
                    int read3 = fileInputStream.read();
                    if (read == 255 && read2 == 216) {
                        sb6 = new StringBuilder("data:image/jpeg;base64,");
                    } else if (read == 66 && read2 == 77) {
                        sb6 = new StringBuilder("data:image/bmp;base64,");
                    } else if (read == 137 && read2 == 80) {
                        sb6 = new StringBuilder("data:image/png;base64,");
                    } else if (read == 71 && read2 == 73) {
                        sb6 = new StringBuilder("data:image/gif;base64,");
                    } else {
                        sb6 = new StringBuilder("data:base64,");
                    }
                    sb6.append(PluginBaseInfoHelper.Base64Helper.encodeToString(new byte[]{(byte) read, (byte) read2, (byte) read3}, 2));
                    byte[] bArr = new byte[30720];
                    while (true) {
                        int read4 = fileInputStream.read(bArr);
                        if (read4 != -1) {
                            if (Thread.currentThread().isInterrupted()) {
                                throw new InterruptedException();
                            }
                            if (read4 < 30720) {
                                byte[] bArr2 = new byte[read4];
                                System.arraycopy(bArr, 0, bArr2, 0, read4);
                                sb6.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr2, 2));
                            } else {
                                sb6.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2));
                            }
                        } else {
                            jSONObject.put(QZoneImageUtils.KEY_MATCH, 0);
                            jSONObject.put("data", sb6);
                            jSONObject.put(QZoneImageUtils.KEY_IMAGE_ID, str);
                            fileInputStream.close();
                            break;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            } else {
                int max = Math.max(i19 / i17, i26 / i18);
                options.inJustDecodeBounds = false;
                int i27 = max | (max >>> 1);
                int i28 = i27 | (i27 >>> 2);
                int i29 = i28 | (i28 >>> 4);
                int i36 = i29 | (i29 >>> 8);
                options.inSampleSize = ((i36 | (i36 >>> 16)) + 1) >>> 1;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    if (i19 * i18 > i26 * i17) {
                        f16 = i17;
                        height = decodeFile.getWidth();
                    } else {
                        f16 = i18;
                        height = decodeFile.getHeight();
                    }
                    float f17 = f16 / height;
                    Matrix matrix = new Matrix();
                    switch (JpegExifReader.readOrientation(str)) {
                        case 2:
                            matrix.setScale(-f17, f17);
                            break;
                        case 3:
                            matrix.setScale(f17, f17);
                            matrix.postRotate(180.0f);
                            break;
                        case 4:
                            matrix.setScale(f17, -f17);
                            break;
                        case 5:
                            matrix.setScale(f17, -f17);
                            matrix.postRotate(90.0f);
                            break;
                        case 6:
                            matrix.setScale(f17, f17);
                            matrix.postRotate(90.0f);
                            break;
                        case 7:
                            matrix.setScale(-f17, f17);
                            matrix.postRotate(90.0f);
                            break;
                        case 8:
                            matrix.setScale(f17, f17);
                            matrix.postRotate(270.0f);
                            break;
                        default:
                            matrix.setScale(f17, f17);
                            break;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                    if (decodeFile != createBitmap) {
                        decodeFile.recycle();
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    String str2 = options.outMimeType;
                    if (!"image/png".equalsIgnoreCase(str2) && !"image/gif".equals(str2) && !MimeHelper.IMAGE_BMP.equals(str2)) {
                        sb5 = new StringBuilder("data:image/jpeg;base64,");
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                    } else {
                        sb5 = new StringBuilder("data:image/png;base64,");
                        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    }
                    createBitmap.recycle();
                    sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                    jSONObject.put(QZoneImageUtils.KEY_MATCH, 0);
                    jSONObject.put("data", sb5);
                    jSONObject.put(QZoneImageUtils.KEY_IMAGE_ID, str);
                } else {
                    throw new IOException();
                }
            }
            return jSONObject;
        }
        throw new IOException();
    }

    public static JSONObject Q(String str, int i3) throws JSONException, IOException, InterruptedException, OutOfMemoryError {
        StringBuilder sb5;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        File file = new File(str);
        if (file.length() >= 3) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i16 = options.outWidth;
            int i17 = options.outHeight;
            if (QLog.isColorLevel()) {
                QLog.d(f238608i, 2, "packImageObjectV2 realWidth: " + i16 + ", realHeight: " + i17 + ", realSize: " + file.length());
            }
            if (i16 >= 0 && i17 >= 0) {
                String w3 = w(str, i3);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(w3, options2);
                if (QLog.isColorLevel()) {
                    File file2 = new File(w3);
                    QLog.d(f238608i, 2, "packImageObjectV2 curWidth: " + options2.outWidth + ", curHeight: " + options2.outHeight + ", realSize: " + file2.length());
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                String str2 = options2.outMimeType;
                if (!"image/png".equalsIgnoreCase(str2) && !"image/gif".equals(str2) && !MimeHelper.IMAGE_BMP.equals(str2)) {
                    sb5 = new StringBuilder("data:image/jpeg;base64,");
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                } else {
                    sb5 = new StringBuilder("data:image/png;base64,");
                    decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                }
                decodeFile.recycle();
                sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                jSONObject.put(QZoneImageUtils.KEY_MATCH, 0);
                jSONObject.put("data", sb5);
                jSONObject.put(QZoneImageUtils.KEY_IMAGE_ID, str);
                if (QLog.isColorLevel()) {
                    QLog.d(f238608i, 2, "packImageObjectV2 time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                return jSONObject;
            }
            throw new IOException();
        }
        throw new IOException();
    }

    public static void R(Context context, String str, long j3, long j16) {
        Intent intent = new Intent(context, (Class<?>) ShortVideoPreviewActivity.class);
        intent.putExtra("file_send_path", str);
        intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, j3);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, j16);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", context.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(ShortVideoPreviewActivity.PREVIEW_ONLY, true);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private boolean T(boolean z16, String[] strArr) {
        OutOfMemoryError e16;
        String str;
        JSONObject jSONObject;
        String optString;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        try {
            try {
                jSONObject = new JSONObject(strArr[0]);
                str = jSONObject.optString("callback");
            } catch (JSONException e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(f238608i, 4, "saveImage failed:" + e17);
                }
            }
            try {
                optString = jSONObject.optString("imagePath");
            } catch (OutOfMemoryError e18) {
                e16 = e18;
                if (QLog.isDevelopLevel()) {
                    QLog.d(f238608i, 4, "saveImage failed:" + e16);
                }
                if (!TextUtils.isEmpty(str) && atomicBoolean.compareAndSet(false, true)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("retCode", -1);
                        jSONObject2.put("msg", BaseApplication.getContext().getString(R.string.h4a));
                    } catch (JSONException unused) {
                    }
                    if (z16) {
                        callJs(str, jSONObject2.toString());
                    } else {
                        callJs4OpenApiIfNeeded("saveImage", 0, jSONObject2.toString());
                    }
                }
                return false;
            }
        } catch (OutOfMemoryError e19) {
            e16 = e19;
            str = null;
        }
        if (!TextUtils.isEmpty(optString)) {
            if (!new File(optString).exists()) {
                QQToast.makeText(this.mRuntime.b().getApplication(), 1, HardCodeUtil.qqStr(R.string.nyx), 0).show();
            } else {
                ThreadManagerV2.post(new Runnable(optString, str, atomicBoolean) { // from class: com.tencent.mobileqq.jsp.MediaApiPlugin.5
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f238613d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f238614e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ AtomicBoolean f238615f;

                    {
                        this.f238613d = optString;
                        this.f238614e = str;
                        this.f238615f = atomicBoolean;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, optString, str, atomicBoolean);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        BaseApplication context = BaseApplication.getContext();
                        try {
                            try {
                                try {
                                    String U = MediaApiPlugin.this.U(FileUtils.readFile(this.f238613d));
                                    jSONObject3.put("retCode", 0);
                                    jSONObject3.put("msg", context.getString(R.string.h4_));
                                    jSONObject3.put(QZoneImageUtils.KEY_IMAGE_ID, U);
                                } catch (IllegalArgumentException unused2) {
                                    jSONObject3.put("retCode", 2);
                                    jSONObject3.put("msg", context.getString(R.string.h47));
                                } catch (OutOfMemoryError e26) {
                                    QLog.e(MediaApiPlugin.f238608i, 2, "saveImage: " + QLog.getStackTraceString(e26));
                                }
                            } catch (IOException unused3) {
                                jSONObject3.put("retCode", 1);
                                jSONObject3.put("msg", context.getString(R.string.h49));
                            }
                        } catch (JSONException unused4) {
                        }
                        if (!TextUtils.isEmpty(this.f238614e) && this.f238615f.compareAndSet(false, true)) {
                            MediaApiPlugin.this.callJs(this.f238614e, jSONObject3.toString());
                        } else {
                            MediaApiPlugin.this.callJs4OpenApiIfNeeded("saveImage", 0, jSONObject3.toString());
                        }
                    }
                }, 8, null, true);
            }
            return true;
        }
        String string = jSONObject.getString("content");
        if (!string.startsWith("http://") && !string.startsWith("https://")) {
            ThreadManager.getSubThreadHandler().post(new Runnable(string, str, atomicBoolean) { // from class: com.tencent.mobileqq.jsp.MediaApiPlugin.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f238619d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f238620e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ AtomicBoolean f238621f;

                {
                    this.f238619d = string;
                    this.f238620e = str;
                    this.f238621f = atomicBoolean;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, string, str, atomicBoolean);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    byte[] bArr;
                    int indexOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    BaseApplication context = BaseApplication.getContext();
                    try {
                        try {
                            try {
                                if (this.f238619d.startsWith("data:") && (indexOf = this.f238619d.indexOf(44)) > 0) {
                                    bArr = PluginBaseInfoHelper.Base64Helper.decode(this.f238619d.substring(indexOf), 0);
                                } else {
                                    bArr = null;
                                }
                            } catch (IOException unused2) {
                                jSONObject3.put("retCode", 1);
                                jSONObject3.put("msg", context.getString(R.string.h49));
                            } catch (IllegalArgumentException unused3) {
                                jSONObject3.put("retCode", 2);
                                jSONObject3.put("msg", context.getString(R.string.h47));
                            }
                        } catch (OutOfMemoryError unused4) {
                            jSONObject3.put("retCode", -1);
                            jSONObject3.put("msg", context.getString(R.string.h4a));
                        }
                    } catch (JSONException unused5) {
                    }
                    if (bArr != null) {
                        String U = MediaApiPlugin.this.U(bArr);
                        jSONObject3.put("retCode", 0);
                        jSONObject3.put("msg", context.getString(R.string.h4_));
                        jSONObject3.put(QZoneImageUtils.KEY_IMAGE_ID, U);
                        if (!TextUtils.isEmpty(this.f238620e) && this.f238621f.compareAndSet(false, true)) {
                            MediaApiPlugin.this.callJs(this.f238620e, jSONObject3.toString());
                            return;
                        } else {
                            MediaApiPlugin.this.callJs4OpenApiIfNeeded("saveImage", 0, jSONObject3.toString());
                            return;
                        }
                    }
                    throw new IllegalArgumentException();
                }
            });
            return false;
        }
        W();
        ThreadManagerV2.post(new Runnable(string, str, atomicBoolean) { // from class: com.tencent.mobileqq.jsp.MediaApiPlugin.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f238616d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f238617e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f238618f;

            {
                this.f238616d = string;
                this.f238617e = str;
                this.f238618f = atomicBoolean;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MediaApiPlugin.this, string, str, atomicBoolean);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:69:0x00e9, code lost:
            
                if (r6.isShowing() != false) goto L39;
             */
            /* JADX WARN: Code restructure failed: missing block: B:70:0x00d4, code lost:
            
                r17.this$0.f238610e.dismiss();
             */
            /* JADX WARN: Code restructure failed: missing block: B:88:0x00d2, code lost:
            
                if (r6.isShowing() != false) goto L39;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i3;
                QQProgressDialog qQProgressDialog;
                boolean isShowing;
                String U;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                BaseApplication context = BaseApplication.getContext();
                int i16 = -1;
                try {
                    try {
                        HttpResponse openRequest = HttpUtil.openRequest(BaseApplication.getContext(), this.f238616d, null, "GET", null, null);
                        if (openRequest != null) {
                            i3 = openRequest.getStatusLine().getStatusCode();
                            if (i3 == 200) {
                                try {
                                    try {
                                        byte[] byteArray = HttpUtil.readHttpResponseSteam(openRequest).toByteArray();
                                        try {
                                            jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i3);
                                        } catch (JSONException unused2) {
                                        }
                                        try {
                                            U = MediaApiPlugin.this.U(byteArray);
                                        } catch (IOException unused3) {
                                            jSONObject3.put("retCode", 1);
                                            jSONObject3.put("msg", context.getString(R.string.h49));
                                        } catch (IllegalArgumentException unused4) {
                                            jSONObject3.put("retCode", 2);
                                            jSONObject3.put("msg", context.getString(R.string.h47));
                                        }
                                        try {
                                            jSONObject3.put("retCode", 0);
                                            jSONObject3.put("msg", context.getString(R.string.h4_));
                                            jSONObject3.put(QZoneImageUtils.KEY_IMAGE_ID, U);
                                        } catch (JSONException unused5) {
                                        }
                                        if (!TextUtils.isEmpty(this.f238617e) && this.f238618f.compareAndSet(false, true)) {
                                            MediaApiPlugin.this.callJs(this.f238617e, jSONObject3.toString());
                                        } else {
                                            MediaApiPlugin.this.callJs4OpenApiIfNeeded("saveImage", 0, jSONObject3.toString());
                                        }
                                        if (qQProgressDialog != null) {
                                            if (isShowing) {
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (IOException unused6) {
                                        i16 = i3;
                                        QQProgressDialog qQProgressDialog2 = MediaApiPlugin.this.f238610e;
                                        if (qQProgressDialog2 != null) {
                                        }
                                        jSONObject3.put("retCode", 3);
                                        jSONObject3.put("msg", context.getString(R.string.h48));
                                        jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i16);
                                        if (TextUtils.isEmpty(this.f238617e)) {
                                        }
                                        MediaApiPlugin.this.callJs4OpenApiIfNeeded("saveImage", 0, jSONObject3.toString());
                                    }
                                } catch (OutOfMemoryError unused7) {
                                    try {
                                        jSONObject3.put("retCode", -1);
                                        jSONObject3.put("msg", context.getString(R.string.h4a));
                                        jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i3);
                                    } catch (JSONException unused8) {
                                    }
                                    if (!TextUtils.isEmpty(this.f238617e) && this.f238618f.compareAndSet(false, true)) {
                                        MediaApiPlugin.this.callJs(this.f238617e, jSONObject3.toString());
                                    } else {
                                        MediaApiPlugin.this.callJs4OpenApiIfNeeded("saveImage", 0, jSONObject3.toString());
                                    }
                                    QQProgressDialog qQProgressDialog3 = MediaApiPlugin.this.f238610e;
                                    if (qQProgressDialog3 != null && qQProgressDialog3.isShowing()) {
                                        MediaApiPlugin.this.f238610e.dismiss();
                                        return;
                                    }
                                    return;
                                }
                            }
                            i16 = i3;
                        }
                        QQProgressDialog qQProgressDialog4 = MediaApiPlugin.this.f238610e;
                        if (qQProgressDialog4 != null) {
                        }
                    } catch (IOException unused9) {
                    } catch (OutOfMemoryError unused10) {
                        i3 = -1;
                    }
                    try {
                        jSONObject3.put("retCode", 3);
                        jSONObject3.put("msg", context.getString(R.string.h48));
                        jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i16);
                    } catch (JSONException unused11) {
                    }
                    if (TextUtils.isEmpty(this.f238617e) && this.f238618f.compareAndSet(false, true)) {
                        MediaApiPlugin.this.callJs(this.f238617e, jSONObject3.toString());
                    } else {
                        MediaApiPlugin.this.callJs4OpenApiIfNeeded("saveImage", 0, jSONObject3.toString());
                    }
                } finally {
                    qQProgressDialog = MediaApiPlugin.this.f238610e;
                    if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                        MediaApiPlugin.this.f238610e.dismiss();
                    }
                }
            }
        }, 5, null, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z16, String[] strArr) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("media_api_plugin_enable_insert_media_8985", true)) {
            I(strArr);
        } else {
            T(z16, strArr);
        }
    }

    private void W() {
        if (this.f238610e == null) {
            Activity a16 = this.mRuntime.a();
            QQProgressDialog qQProgressDialog = new QQProgressDialog(a16, a16.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.f238610e = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.c7z);
            this.f238610e.O(this);
        }
        if (!this.f238610e.isShowing()) {
            this.f238610e.show();
        }
    }

    @NotNull
    private List<String> v(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (this.f238612h.hasPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String w(String str, int i3) {
        CompressInfo compressInfo = new CompressInfo(str, i3, 1035);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        return compressInfo.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void L(final String str, final String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.jsp.s
                @Override // java.lang.Runnable
                public final void run() {
                    MediaApiPlugin.this.L(str, str2);
                }
            });
            return;
        }
        QLog.d(f238608i, 1, "[doInsertImgCallback] result: " + str2);
        if (!TextUtils.isEmpty(str)) {
            callJs(str, str2);
        } else {
            callJs4OpenApiIfNeeded("saveImage", 0, str2);
        }
    }

    private static SharedPreferences y(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 4);
    }

    void S(boolean z16, JSONObject jSONObject) {
        this.f238612h.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new e(jSONObject, z16));
    }

    String U(byte[] bArr) throws IOException, IllegalArgumentException {
        String str;
        FileOutputStream fileOutputStream;
        String str2;
        FileOutputStream fileOutputStream2;
        String str3 = AppConstants.SDCARD_IMG_SAVE;
        File file = new File(str3);
        file.mkdirs();
        if (file.canWrite()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            boolean z16 = true;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (options.outWidth > 0 && options.outHeight > 0) {
                FileOutputStream fileOutputStream3 = null;
                if ("image/jpeg".equals(options.outMimeType)) {
                    str = ".jpg";
                } else if (MimeHelper.IMAGE_BMP.equals(options.outMimeType)) {
                    str = ".bmp";
                } else if ("image/png".equals(options.outMimeType)) {
                    str = ".png";
                } else if ("image/gif".equals(options.outMimeType)) {
                    str = QzoneEmotionUtils.SIGN_ICON_URL_END;
                } else {
                    str = null;
                }
                if (str != null) {
                    str2 = str3 + "wv_" + System.currentTimeMillis() + str;
                    File file2 = new File(str2);
                    try {
                        fileOutputStream2 = new FileOutputStream(file2);
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        fileOutputStream2.write(bArr);
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream3 = fileOutputStream2;
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f238608i, 2, "exception occur while writing file in saveImage");
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    String str4 = str3 + "wv_" + System.currentTimeMillis() + ".jpg";
                    File file3 = new File(str4);
                    try {
                        fileOutputStream = new FileOutputStream(file3);
                    } catch (Throwable th7) {
                        th = th7;
                    }
                    try {
                        boolean compress = BitmapFactory.decodeByteArray(bArr, 0, bArr.length).compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                        if (!compress) {
                            if (file3.exists()) {
                                file3.delete();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(f238608i, 2, "exception occur while compressing bmp in saveImage");
                            }
                        }
                        z16 = compress;
                        str2 = str4;
                    } catch (Throwable th8) {
                        th = th8;
                        fileOutputStream3 = fileOutputStream;
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (file3.exists()) {
                            file3.delete();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f238608i, 2, "exception occur while compressing bmp in saveImage");
                            throw th;
                        }
                        throw th;
                    }
                }
                if (z16) {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.parse("file://" + str2));
                    BaseApplication.getContext().sendBroadcast(intent);
                    return str2;
                }
                throw new IOException();
            }
            throw new IllegalArgumentException("not image data");
        }
        throw new IOException("dir can not write");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void X(JSONObject jSONObject, boolean z16) {
        BaseApplication context = BaseApplication.getContext();
        boolean optBoolean = jSONObject.optBoolean("needCrop", false);
        boolean optBoolean2 = jSONObject.optBoolean("NEED_HEIF", false);
        int optInt = jSONObject.optInt("mediaType", 0);
        double optDouble = jSONObject.optDouble("maxProportion", 2.0d);
        double optDouble2 = jSONObject.optDouble("minProportion", 0.6d);
        int optInt2 = jSONObject.optInt("imageSizeLimit", 8192) * 1024;
        long optLong = jSONObject.optLong("videoSizeLimit", 512000L) * 1024;
        long optLong2 = jSONObject.optLong("videoDurationLimit", 120L);
        Activity a16 = this.mRuntime.a();
        String account = this.mRuntime.b().getAccount();
        boolean z17 = a16 instanceof AbsBaseWebViewActivity;
        boolean z18 = a16 instanceof com.tencent.mobileqq.webviewplugin.d;
        boolean optBoolean3 = jSONObject.optBoolean("allowSkipSelect", false);
        Intent intent = new Intent();
        if (z18) {
            com.tencent.mobileqq.webviewplugin.d dVar = (com.tencent.mobileqq.webviewplugin.d) a16;
            if (dVar.Q()) {
                intent.setClass(getCurrentContext(), NewPhotoListActivity.class);
                intent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
                intent.putExtra("PhotoConst.PLUGIN_APK", dVar.w());
                intent.putExtra("PhotoConst.PLUGIN_NAME", dVar.v0());
                intent.putExtra("PhotoConst.UIN", this.mRuntime.b().getCurrentAccountUin());
                intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", a16.getClass().getName());
                intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                intent.putExtra(QAlbumConstants.SHOW_GIF_TYPE_ICON, true);
                intent.putExtra("NEED_HEIF", optBoolean2);
                intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationH5.F);
                if (optBoolean3) {
                    intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationWink.H);
                }
                if (optBoolean) {
                    int optInt3 = jSONObject.optInt("businessOrigin");
                    if (optInt3 == 0) {
                        optInt3 = 103;
                    }
                    Point clipRectSize = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(a16, optInt3);
                    intent.putExtra(PeakConstants.CLIP_WIDTH, clipRectSize.x);
                    intent.putExtra(PeakConstants.CLIP_HEIGHT, clipRectSize.y);
                    intent.putExtra(PeakConstants.TARGET_WIDTH, 640);
                    intent.putExtra(PeakConstants.TARGET_HEIGHT, 640);
                    intent.putExtra("Business_Origin", optInt3);
                    intent.putExtra("BUSINESS_ORIGIN_NEW", optInt3);
                    intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
                    intent.putExtra(PeakConstants.TARGET_PATH, ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getUploadPhotoTempPath());
                }
                if (optInt != 0) {
                    int optInt4 = jSONObject.optInt("max", 1);
                    intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", optInt4);
                    if (optInt4 == 1) {
                        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
                    }
                    if (optBoolean3) {
                        intent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
                    }
                    intent.putExtra("imageSizeLimit", optInt2);
                    if (z17) {
                        ((AbsBaseWebViewActivity) a16).gotoSelectPicture(this, intent, (byte) 2);
                    } else if (z18) {
                        ((com.tencent.mobileqq.webviewplugin.d) a16).gotoSelectPicture(this, intent, (byte) 2);
                    } else {
                        com.tencent.mobileqq.webview.swift.ao.c(this, intent, (byte) 2, this.mRuntime.f());
                    }
                } else if (optInt == 1) {
                    intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
                    intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 2);
                    intent.putExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, 2);
                    if (z17) {
                        ((AbsBaseWebViewActivity) a16).gotoSelectPicture(this, intent, (byte) 3);
                    } else if (z18) {
                        ((com.tencent.mobileqq.webviewplugin.d) a16).gotoSelectPicture(this, intent, (byte) 3);
                    } else {
                        com.tencent.mobileqq.webview.swift.ao.c(this, intent, (byte) 3, this.mRuntime.f());
                    }
                } else if (optInt == 2) {
                    intent.putExtra("uin", account);
                    intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
                    intent.putExtra(PeakConstants.IS_FROM_TROOP_REWARD, true);
                    intent.putExtra("maxProportion", optDouble);
                    intent.putExtra("minProportion", optDouble2);
                    intent.putExtra("imageSizeLimit", optInt2);
                    intent.putExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, 1000 * optLong2);
                    intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 0);
                    intent.putExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, optLong);
                    if (z17) {
                        ((AbsBaseWebViewActivity) a16).gotoSelectPicture(this, intent, (byte) 3);
                    } else if (z18) {
                        ((com.tencent.mobileqq.webviewplugin.d) a16).gotoSelectPicture(this, intent, (byte) 3);
                    } else {
                        com.tencent.mobileqq.webview.swift.ao.c(this, intent, (byte) 3, this.mRuntime.f());
                    }
                }
                y(context).edit().putString(QZoneMediaWebPlugin.KEY_GET_MEDIA_PARAM, jSONObject.toString()).putBoolean("calledFromOpenApi", z16).commit();
            }
        }
        intent.setClass(a16, NewPhotoListActivity.class);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", a16.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(QAlbumConstants.SHOW_GIF_TYPE_ICON, true);
        intent.putExtra("NEED_HEIF", optBoolean2);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationH5.F);
        if (optBoolean3) {
        }
        if (optBoolean) {
        }
        if (optInt != 0) {
        }
        y(context).edit().putString(QZoneMediaWebPlugin.KEY_GET_MEDIA_PARAM, jSONObject.toString()).putBoolean("calledFromOpenApi", z16).commit();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
    public void callback(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
        }
    }

    Context getCurrentContext() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QAdVrReportParams.ParamKey.MEDIA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ac, code lost:
    
        if (r18.mRuntime.f() != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00be, code lost:
    
        if ((r18.mRuntime.a() instanceof mqq.app.AppActivity) != false) goto L40;
     */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        String optString;
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (!QAdVrReportParams.ParamKey.MEDIA.equals(str2)) {
            return false;
        }
        boolean z17 = jsBridgeListener != null && jsBridgeListener.f314008c;
        addOpenApiListenerIfNeeded(str3, jsBridgeListener);
        if ((QZoneJsConstants.METHOD_QZONE_SELECT_GET_PICTURE.equals(str3) || "getPictureV2".equals(str3)) && strArr.length == 1) {
            try {
                jSONObject = new JSONObject(strArr[0]);
                jSONObject.put("method", str3);
                optString = jSONObject.optString("callback");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            if (TextUtils.isEmpty(optString) && !z17) {
                return true;
            }
            int optInt = jSONObject.optInt("source", 0);
            BaseApplication context = BaseApplication.getContext();
            if (optInt == 0) {
                Activity a16 = this.mRuntime.a();
                boolean z18 = a16 instanceof AbsBaseWebViewActivity;
                boolean z19 = a16 instanceof com.tencent.mobileqq.webviewplugin.d;
                if (!K(a16) && !z18 && !z19) {
                    try {
                    } catch (Throwable th5) {
                        QLog.d(f238608i, 1, "getPicture ", th5);
                    }
                }
                if (this.mRuntime.a() != null) {
                }
                if (!(this.mRuntime.a() instanceof BaseActivity)) {
                    if (z17) {
                        callJs4OpenApiIfNeeded(str3, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    } else {
                        callJs(optString, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    }
                    return true;
                }
                BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_MEDIA);
                if (this.f238612h == null) {
                    this.f238612h = QQPermissionFactory.getQQPermission(this.mRuntime.a(), businessConfig);
                }
                if (this.f238612h.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                    S(z17, jSONObject);
                    z16 = true;
                }
                if (!z16) {
                    X(jSONObject, z17);
                }
            } else {
                if (optInt != 1 || QavCameraUsage.a(BaseApplication.getContext())) {
                    return true;
                }
                try {
                    file = File.createTempFile("IMAGE_" + System.currentTimeMillis() + "_", ".jpg", context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                } catch (IOException e17) {
                    QLog.e(f238608i, 1, "createImageFileError: ", e17);
                    file = null;
                }
                if (file == null) {
                    return true;
                }
                String absolutePath = file.getAbsolutePath();
                Intent intent = new Intent();
                FileProvider7Helper.setSystemCapture(BaseApplication.getContext(), file, intent);
                if (jSONObject.optBoolean("front", false)) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                }
                WebViewPlugin.b bVar = this.mRuntime;
                if ((bVar != null ? bVar.a() : null) == null) {
                    return true;
                }
                BusinessConfig businessConfig2 = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_MEDIA);
                if (this.f238612h == null) {
                    this.f238612h = QQPermissionFactory.getQQPermission(this.mRuntime.a(), businessConfig2);
                }
                List<String> v3 = v(QQPermissionConstants.Permission.CAMERA);
                if (!v3.isEmpty()) {
                    this.f238612h.requestPermissions((String[]) v3.toArray(new String[0]), 2, new a(intent, context, absolutePath, jSONObject, z17));
                } else {
                    O(intent, context, absolutePath, jSONObject, z17);
                }
            }
            e16.printStackTrace();
        } else if (("getLocalImage".equals(str3) || "getLocalImageV2".equals(str3)) && strArr.length == 1) {
            try {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                String optString2 = jSONObject2.optString("callback");
                String optString3 = jSONObject2.optString(QZoneImageUtils.KEY_IMAGE_ID);
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    W();
                    if ("getLocalImageV2".equals(str3)) {
                        ThreadManagerV2.post(new PrepareSinglePictureAndCallbackThreadV2(optString2, jSONObject2.optInt(HippyQQPagViewController.PropertyName.SCALE_MODE, 0), optString3), 5, null, true);
                    } else {
                        ThreadManagerV2.post(new PrepareSinglePictureAndCallbackThread(optString2, jSONObject2.optInt("outMaxWidth", 1280), jSONObject2.optInt("outMaxHeight", 1280), jSONObject2.optInt("inMinWidth", 1), jSONObject2.optInt("inMinHeight", 1), optString3), 5, null, true);
                    }
                }
                return true;
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        } else {
            if ("saveImage".equals(str3) && strArr.length == 1) {
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity == null) {
                    V(z17, strArr);
                    return true;
                }
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(qBaseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.SHARE_SAVE_PIC));
                if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                    qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(z17, strArr));
                    return true;
                }
                V(z17, strArr);
                return true;
            }
            if ("previewLocalVideo".equals(str3) && strArr.length == 1) {
                try {
                    JSONObject jSONObject3 = new JSONObject(strArr[0]);
                    if (QLog.isColorLevel()) {
                        QLog.d("MediaApiPlugin", 2, "previewLocalVideo:" + jSONObject3);
                    }
                    R(this.mRuntime.a(), jSONObject3.optString("path"), jSONObject3.optLong(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE), jSONObject3.optLong("videoDuration"));
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.w("MediaApiPlugin", 2, "previewLocalVideo exp", e19);
                    }
                }
            } else if ("getIsLTUser".equals(str3) && strArr.length >= 1) {
                try {
                    String optString4 = new JSONObject(strArr[0]).optString("callback");
                    callJs(optString4, String.valueOf(2));
                    if (QLog.isColorLevel()) {
                        QLog.w("MediaApiPlugin", 2, "WL_DEBUG GetIsLTUser args[0] = " + strArr[0] + "callback = " + optString4);
                    }
                } catch (Exception e26) {
                    if (QLog.isColorLevel()) {
                        QLog.w("MediaApiPlugin", 2, "WL_DEBUG GetIsLTUser e = " + e26);
                    }
                }
            } else if ("isCameraAvailable".equals(str3)) {
                try {
                    String optString5 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString5)) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("result", J());
                        callJs(optString5, jSONObject4.toString());
                    }
                } catch (Exception e27) {
                    if (QLog.isColorLevel()) {
                        QLog.w(f238608i, 2, "call isCameraAvailable error", e27);
                    }
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
        } else {
            super.onActivityResult(intent, b16, i3);
            A(intent, b16, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onAdded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Thread thread = this.f238609d;
        if (thread != null) {
            thread.interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Thread thread = this.f238609d;
        if (thread != null) {
            thread.interrupt();
        }
        QQProgressDialog qQProgressDialog = this.f238610e;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f238610e.dismiss();
        }
        com.tencent.biz.troop.b bVar = this.f238611f;
        if (bVar != null) {
            bVar.q();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPostRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            B();
        }
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPreRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0052 -> B:9:0x0055). Please report as a decompilation issue!!! */
    JSONObject z(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(null, str);
        StringBuilder sb5 = new StringBuilder("data:image/jpeg;base64,");
        if (videoThumbnail != null) {
            videoThumbnail.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            videoThumbnail.recycle();
        }
        sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        JSONObject jSONObject = new JSONObject();
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                jSONObject.put(QZoneImageUtils.KEY_THUMB_DATA, sb5);
                jSONObject.put("videoID", str);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (JSONException e17) {
                e17.printStackTrace();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            }
            return jSONObject;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            throw th5;
        }
    }
}
