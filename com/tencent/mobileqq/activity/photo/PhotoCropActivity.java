package com.tencent.mobileqq.activity.photo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IAvatarPhotoPickerHelperApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarIpcUpdateAvatarUtilsApiImpl;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qzonehub.api.IQZoneEnvApi;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.util.CommonMMKVUtils;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes10.dex */
public class PhotoCropActivity extends BaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    int A0;
    int B0;
    int C0;
    int D0;
    int E0;
    boolean F0;
    boolean G0;
    boolean H0;
    int I0;
    boolean J0;
    com.tencent.mobileqq.activity.photo.e K0;
    private IQQAvatarDataService L0;
    private String M0;
    boolean N0;
    protected boolean O0;
    protected int P0;
    private boolean Q0;
    private ArrayList<String> R0;
    public QQProgressDialog S0;
    public Handler T0;
    CardObserver U0;

    /* renamed from: a0, reason: collision with root package name */
    public String f183983a0;

    /* renamed from: b0, reason: collision with root package name */
    final long f183984b0;

    /* renamed from: c0, reason: collision with root package name */
    ViewGroup f183985c0;

    /* renamed from: d0, reason: collision with root package name */
    PortraitImageview f183986d0;

    /* renamed from: e0, reason: collision with root package name */
    RegionView f183987e0;

    /* renamed from: f0, reason: collision with root package name */
    RelativeLayout f183988f0;

    /* renamed from: g0, reason: collision with root package name */
    Button f183989g0;

    /* renamed from: h0, reason: collision with root package name */
    Button f183990h0;

    /* renamed from: i0, reason: collision with root package name */
    TextView f183991i0;

    /* renamed from: j0, reason: collision with root package name */
    CheckBox f183992j0;

    /* renamed from: k0, reason: collision with root package name */
    TextView f183993k0;

    /* renamed from: l0, reason: collision with root package name */
    Button f183994l0;

    /* renamed from: m0, reason: collision with root package name */
    String f183995m0;

    /* renamed from: n0, reason: collision with root package name */
    Button f183996n0;

    /* renamed from: o0, reason: collision with root package name */
    TextView f183997o0;

    /* renamed from: p0, reason: collision with root package name */
    String f183998p0;

    /* renamed from: q0, reason: collision with root package name */
    String f183999q0;

    /* renamed from: r0, reason: collision with root package name */
    int f184000r0;

    /* renamed from: s0, reason: collision with root package name */
    int f184001s0;

    /* renamed from: t0, reason: collision with root package name */
    String[] f184002t0;

    /* renamed from: u0, reason: collision with root package name */
    Intent f184003u0;

    /* renamed from: v0, reason: collision with root package name */
    View f184004v0;

    /* renamed from: w0, reason: collision with root package name */
    String f184005w0;

    /* renamed from: x0, reason: collision with root package name */
    private Uri f184006x0;

    /* renamed from: y0, reason: collision with root package name */
    String f184007y0;

    /* renamed from: z0, reason: collision with root package name */
    int f184008z0;

    /* loaded from: classes10.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Button button;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1002) {
                if (i3 == 1003) {
                    if (!PhotoCropActivity.this.isFinishing()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PhotoCropActivity", 2, "LOADING_TIMEOUT");
                        }
                        PhotoCropActivity.this.i3(R.string.f172970g64);
                        PhotoCropActivity.this.R2();
                    }
                    if (("FROM_ZPLAN_BG_EDIT".equals(PhotoCropActivity.this.f183999q0) || "FROM_SMALL_HOME_TAKE_PHOTO".equals(PhotoCropActivity.this.f183998p0)) && (button = PhotoCropActivity.this.f183994l0) != null) {
                        button.setEnabled(true);
                        return;
                    }
                    return;
                }
                return;
            }
            PhotoCropActivity.this.j3();
            Handler handler = PhotoCropActivity.this.T0;
            handler.sendMessageDelayed(Message.obtain(handler, 1003), 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropActivity.this);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            Handler handler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            if ((i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) && (handler = PhotoCropActivity.this.T0) != null) {
                handler.sendEmptyMessage(1001);
            }
        }
    }

    /* loaded from: classes10.dex */
    class c extends CardObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onUpdateAvatar(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            if ("FROM_SDK_AVATAR_SET_IMAGE".equals(PhotoCropActivity.this.f183998p0)) {
                PhotoCropActivity.this.T0.removeMessages(1003);
                PhotoCropActivity.this.R2();
                if (!z16) {
                    Intent intent = PhotoCropActivity.this.getIntent();
                    intent.putExtra(IProfileCardConst.KEY_FROM_SET_AVATAR_RESULT, false);
                    PhotoCropActivity.this.setResult(-1, intent);
                    PhotoCropActivity.this.finish();
                    return;
                }
                ReportController.o(PhotoCropActivity.this.app, "dc00898", "", "", "0X8009B6B", "0X8009B6B", 0, 0, "", "", "", "");
                Intent intent2 = PhotoCropActivity.this.getIntent();
                intent2.putExtra(IProfileCardConst.KEY_FROM_SET_AVATAR_RESULT, true);
                PhotoCropActivity.this.setResult(-1, intent2);
                PhotoCropActivity.this.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    private class d extends AsyncTask<Void, Void, Bitmap> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f184017a;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCropActivity.this);
            }
        }

        private void a(String str) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("proavatar_photo_crop_act_check_file_can_read_switch", true);
            QLog.i("PhotoCropActivity", 1, "checkFileCanRead switchOn: " + isSwitchOn);
            if (!isSwitchOn) {
                return;
            }
            try {
                File file = new File(str);
                if (!file.exists() || !file.canRead()) {
                    QLog.i("PhotoCropActivity", 1, "checkFileCanRead file can not read. exist? " + file.exists() + ", canRead? " + file.canRead());
                    this.f184017a = 3;
                }
            } catch (Throwable th5) {
                QLog.e("PhotoCropActivity", 1, "checkFileCanRead catch throwable: ", th5);
            }
        }

        private Bitmap b() {
            InputStream inputStream;
            Bitmap.Config config;
            if (PhotoCropActivity.this.f184006x0 == null) {
                return null;
            }
            try {
                inputStream = PhotoCropActivity.this.getContentResolver().openInputStream(PhotoCropActivity.this.f184006x0);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    if (PhotoCropActivity.this.F0) {
                        config = Bitmap.Config.ARGB_8888;
                    } else {
                        config = Bitmap.Config.RGB_565;
                    }
                    options.inPreferredConfig = config;
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(inputStream, null, options);
                    e(inputStream);
                    int i3 = PhotoCropActivity.this.D0;
                    options.inSampleSize = PhotoCropActivity.W2(i3, i3, options.outWidth, options.outHeight);
                    options.inJustDecodeBounds = false;
                    inputStream = PhotoCropActivity.this.getContentResolver().openInputStream(PhotoCropActivity.this.f184006x0);
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    QLog.d("PhotoCropActivity", 4, "decodePhotoUri bitmap: " + decodeStream);
                    return decodeStream;
                } catch (Throwable unused) {
                    try {
                        QLog.e("PhotoCropActivity", 1, "decodePhotoUri ");
                        return null;
                    } finally {
                        e(inputStream);
                    }
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
        }

        private void e(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap.Config config;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                PhotoCropActivity photoCropActivity = PhotoCropActivity.this;
                if (photoCropActivity.F0) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                options.inJustDecodeBounds = true;
                BaseImageUtil.decodeFileWithBufferedStream(photoCropActivity.f184005w0, options);
                int i3 = PhotoCropActivity.this.D0;
                options.inSampleSize = PhotoCropActivity.W2(i3, i3, options.outWidth, options.outHeight);
                boolean z16 = false;
                options.inJustDecodeBounds = false;
                Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(PhotoCropActivity.this.f184005w0, options);
                if (decodeFileWithBufferedStream == null) {
                    PhotoCropActivity photoCropActivity2 = PhotoCropActivity.this;
                    decodeFileWithBufferedStream = photoCropActivity2.V2(photoCropActivity2.f184005w0);
                }
                Bitmap exifBitmap = ((IPicUtil) QRoute.api(IPicUtil.class)).getExifBitmap(PhotoCropActivity.this.f184005w0, decodeFileWithBufferedStream);
                if (exifBitmap == null) {
                    QLog.d("PhotoCropActivity", 1, "bitmap is null because of OOM");
                    this.f184017a = 1;
                    a(PhotoCropActivity.this.f184005w0);
                }
                if (exifBitmap == null) {
                    exifBitmap = b();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("doInBackground decode uri null? ");
                    if (exifBitmap == null) {
                        z16 = true;
                    }
                    sb5.append(z16);
                    QLog.i("PhotoCropActivity", 1, sb5.toString());
                }
                return exifBitmap;
            } catch (Exception e16) {
                this.f184017a = 2;
                QLog.d("PhotoCropActivity", 1, "LoadBitmapTask err " + e16);
                return null;
            } catch (OutOfMemoryError unused) {
                this.f184017a = 1;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
                return;
            }
            if (bitmap != null) {
                PhotoCropActivity photoCropActivity = PhotoCropActivity.this;
                photoCropActivity.f183986d0.setRestrict(photoCropActivity.f184008z0, photoCropActivity.A0);
                PhotoCropActivity.this.f183986d0.setImageBitmap(bitmap);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                PhotoCropActivity photoCropActivity2 = PhotoCropActivity.this;
                PhotoCropActivity photoCropActivity3 = PhotoCropActivity.this;
                photoCropActivity2.f183987e0 = new RegionView(photoCropActivity3, photoCropActivity3.f183986d0, photoCropActivity3.B0, photoCropActivity3.C0, photoCropActivity3.E0, photoCropActivity3.F0);
                PhotoCropActivity.this.g3();
                PhotoCropActivity.this.f183985c0.removeAllViews();
                PhotoCropActivity photoCropActivity4 = PhotoCropActivity.this;
                photoCropActivity4.f183985c0.addView(photoCropActivity4.f183986d0, layoutParams);
                PhotoCropActivity photoCropActivity5 = PhotoCropActivity.this;
                photoCropActivity5.f183985c0.addView(photoCropActivity5.f183987e0, layoutParams);
                Handler handler = PhotoCropActivity.this.T0;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(1000, 250L);
                    return;
                }
                return;
            }
            if (PhotoCropActivity.this.getIntent().getBooleanExtra("open_chat_from_avator", false)) {
                PhotoCropActivity photoCropActivity6 = PhotoCropActivity.this;
                photoCropActivity6.f183986d0.setRestrict(photoCropActivity6.f184008z0, photoCropActivity6.A0);
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                PhotoCropActivity photoCropActivity7 = PhotoCropActivity.this;
                PhotoCropActivity photoCropActivity8 = PhotoCropActivity.this;
                photoCropActivity7.f183987e0 = new RegionView(photoCropActivity8, photoCropActivity8.f183986d0, photoCropActivity8.B0, photoCropActivity8.C0, photoCropActivity8.E0, photoCropActivity8.F0);
                PhotoCropActivity.this.g3();
                PhotoCropActivity.this.f183985c0.removeAllViews();
                PhotoCropActivity photoCropActivity9 = PhotoCropActivity.this;
                photoCropActivity9.f183985c0.addView(photoCropActivity9.f183986d0, layoutParams2);
                PhotoCropActivity photoCropActivity10 = PhotoCropActivity.this;
                photoCropActivity10.f183985c0.addView(photoCropActivity10.f183987e0, layoutParams2);
                PhotoCropActivity.this.f183989g0.setEnabled(false);
                return;
            }
            int i3 = this.f184017a;
            if (i3 == 1) {
                QQToast.makeText(PhotoCropActivity.this, HardCodeUtil.qqStr(R.string.p4b), 0).show();
            } else if (i3 == 2) {
                QQToast.makeText(PhotoCropActivity.this, HardCodeUtil.qqStr(R.string.p4c), 0).show();
            } else if (i3 == 3) {
                QQToast.makeText(PhotoCropActivity.this, "\u8bf7\u5f00\u542f\u7cfb\u7edf\u76f8\u518c\u6743\u9650", 1).show();
            } else {
                QQToast.makeText(PhotoCropActivity.this, HardCodeUtil.qqStr(R.string.p4a), 0).show();
            }
            PhotoCropActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f184019a;

        /* renamed from: b, reason: collision with root package name */
        public String f184020b;

        public e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f184019a = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class f extends AsyncTask<Void, Void, e> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        boolean f184021a;

        /* renamed from: b, reason: collision with root package name */
        boolean f184022b;

        public f(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhotoCropActivity.this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.f184021a = z16;
                this.f184022b = z17;
            }
        }

        private void c(ArrayList<String> arrayList, e eVar) {
            if (this.f184021a) {
                d(arrayList, eVar, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM);
                return;
            }
            PhotoCropActivity.this.getIntent().putExtra(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, PhotoCropActivity.this.O0);
            PhotoCropActivity.this.getIntent().putExtra("PhotoConst.SYNCQZONE_CHECKSTATE", PhotoCropActivity.this.P0);
            PhotoCropActivity photoCropActivity = PhotoCropActivity.this;
            PhotoUtils.sendPhoto(photoCropActivity, photoCropActivity.getIntent(), arrayList, 0, false);
            if (this.f184022b) {
                d(arrayList, eVar, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM);
            }
        }

        private void d(ArrayList<String> arrayList, e eVar, String str) {
            String str2;
            if (arrayList.size() > 0) {
                PhotoCropActivity.this.getIntent().putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
            }
            String stringExtra = PhotoCropActivity.this.getIntent().getStringExtra(QQWinkConstants.AVATAR_OLD_HD_PATH);
            QLog.d("PhotoCropActivity", 1, "handleWinkPublish, currentAvatarPath:" + PhotoCropActivity.this.M0);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = PhotoCropActivity.this.M0;
            }
            String str3 = stringExtra;
            String str4 = eVar.f184020b;
            if (str.equals(QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM)) {
                str2 = "qq_avatar_album";
            } else {
                str2 = QQWinkConstants.WinkPublishTaskID.XSJ_TOUXIANG;
            }
            String str5 = str2;
            if (this.f184021a) {
                ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToWinkEditorAfterProcessContent(PhotoCropActivity.this.getBaseContext(), "QCIRCLE", PhotoCropActivity.this.f183983a0, str3, str4, null, str5, str, false);
            } else if (this.f184022b) {
                ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToWinkEditorAfterProcessContent(PhotoCropActivity.this.getBaseContext(), "QCIRCLE", PhotoCropActivity.this.f183983a0, str3, str4, null, str5, str, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(e eVar, String str) {
            String str2;
            String str3;
            if (PhotoCropActivity.this.G0) {
                str2 = "album";
                str3 = "qq_avatar_album";
            } else {
                str2 = "camera";
                str3 = "qq_avatar_camera";
            }
            QLog.d("PhotoCropActivity", 1, "jumpToAvatarShareWindow, currentAvatarPath:" + PhotoCropActivity.this.M0);
            Bundle bundle = new Bundle();
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            bundle.putString("app_key", "00000QG6YX3X0LZH");
            bundle.putString(QQWinkConstants.AVATAR_ORIGIN_HD_PATH, PhotoCropActivity.this.M0);
            String str4 = eVar.f184020b;
            if (str4 != null) {
                str = str4;
            }
            bundle.putString(QQWinkConstants.AVATAR_NEW_HD_PATH, str);
            bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, str2);
            bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, str3);
            bundle.putInt("AVATAR_TO_EXPERIENCE_FROM_TYPE", PhotoCropActivity.this.I0);
            bundle.putSerializable(QQWinkConstants.SPECIFIC_WINK_HOME_CLASS_TYPE, IQQWinkLaucher.WinkHomePageType.TYPE_COLLECTION_PICKER);
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToAvatarShareWindow(PhotoCropActivity.this.getActivity(), bundle);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private String g(Bitmap bitmap) {
            BufferedOutputStream bufferedOutputStream;
            BufferedOutputStream bufferedOutputStream2 = null;
            if (bitmap == null) {
                return null;
            }
            File file = new File(PhotoCropActivity.this.f183995m0);
            try {
                if (!file.exists()) {
                    BaseImageUtil.createNewFile(PhotoCropActivity.this.f183995m0);
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (IOException e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, PhotoCropActivity.this.f184001s0, bufferedOutputStream);
                    String str = PhotoCropActivity.this.f183995m0;
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PhotoCropActivity", 2, "ioexception", e17);
                        }
                    }
                    return str;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e18) {
                            if (QLog.isColorLevel()) {
                                QLog.e("PhotoCropActivity", 2, "ioexception", e18);
                            }
                        }
                    }
                    throw th;
                }
            } catch (IOException e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e("PhotoCropActivity", 2, "ioexception", e);
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e26) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PhotoCropActivity", 2, "ioexception", e26);
                        }
                    }
                }
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e doInBackground(Void... voidArr) {
            Bitmap a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
                return new e("sdcardfull");
            }
            try {
                PhotoCropActivity photoCropActivity = PhotoCropActivity.this;
                if (photoCropActivity.J0) {
                    a16 = photoCropActivity.f183987e0.d();
                } else {
                    a16 = photoCropActivity.f183987e0.a();
                }
                String g16 = g(a16);
                e eVar = new e(g16);
                eVar.f184020b = PhotoCropActivity.this.Q2(g16);
                if (QLog.isColorLevel()) {
                    QLog.i("PhotoCropActivity", 2, String.format("store to %s", g16));
                }
                PhotoCropActivity photoCropActivity2 = PhotoCropActivity.this;
                if (photoCropActivity2.J0) {
                    Rect c16 = photoCropActivity2.f183987e0.c();
                    PhotoCropActivity.this.getIntent().putExtra(ITroopPhotoUtilsApi.KEY_CLIP_INFO, ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getClipStr(c16.left, c16.top, c16.right, c16.bottom));
                }
                return eVar;
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PhotoCropActivity", 2, e16.getMessage());
                }
                return new e("oom");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(final e eVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
                return;
            }
            final String str2 = eVar.f184019a;
            if (!"oom".equals(str2) && str2 != null) {
                if ("sdcardfull".equals(str2)) {
                    QQToast.makeText(PhotoCropActivity.this, R.string.f171168cu0, 0).show();
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str2);
                if ("FROM_SDK_AVATAR_SET_IMAGE".equals(PhotoCropActivity.this.f183998p0)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhotoCropActivity", 2, "StoreFileTask");
                    }
                    Intent intent = PhotoCropActivity.this.getIntent();
                    if (ProfileCardUtil.h0(PhotoCropActivity.this.app, str2, intent)) {
                        Handler handler = PhotoCropActivity.this.T0;
                        handler.sendMessage(Message.obtain(handler, 1002));
                        return;
                    } else {
                        intent.putExtra(IProfileCardConst.KEY_FROM_SET_AVATAR_RESULT, false);
                        PhotoCropActivity.this.setResult(-1, intent);
                        PhotoCropActivity.this.finish();
                        return;
                    }
                }
                if (!"FROM_EXTEND_FRIEND_AVATAR".equals(PhotoCropActivity.this.f183998p0) && !"FROM_QCIRCLE_AVATAR".equals(PhotoCropActivity.this.f183998p0) && !"FROM_LOGIN_AVATAR".equals(PhotoCropActivity.this.f183998p0)) {
                    if (PhotoCropActivity.this.e3()) {
                        ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).insertAvatarPendantInfo(PhotoCropActivity.this.getIntent(), arrayList);
                        c(arrayList, eVar);
                        return;
                    }
                    PhotoCropActivity photoCropActivity = PhotoCropActivity.this;
                    if (100 == photoCropActivity.f184000r0) {
                        photoCropActivity.getIntent().putExtra(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, PhotoCropActivity.this.O0);
                        PhotoCropActivity.this.getIntent().putExtra("PhotoConst.SYNCQZONE_CHECKSTATE", PhotoCropActivity.this.P0);
                        if (((IAvatarPhotoPickerHelperApi) QRoute.api(IAvatarPhotoPickerHelperApi.class)).needInsertVasShoppingPageInfo(PhotoCropActivity.this)) {
                            ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).insertAvatarPendantInfo(PhotoCropActivity.this.getIntent(), arrayList);
                        }
                    }
                    PhotoCropActivity.this.R0 = arrayList;
                    if (!"FROM_ZPLAN_BG_EDIT".equals(PhotoCropActivity.this.f183999q0) && !"FROM_SMALL_HOME_TAKE_PHOTO".equals(PhotoCropActivity.this.f183998p0)) {
                        PhotoCropActivity photoCropActivity2 = PhotoCropActivity.this;
                        PhotoUtils.sendPhoto(photoCropActivity2, photoCropActivity2.getIntent(), arrayList, 0, false);
                        if (sa0.b.c()) {
                            PhotoCropActivity photoCropActivity3 = PhotoCropActivity.this;
                            if (photoCropActivity3.G0 || photoCropActivity3.H0) {
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.g
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        PhotoCropActivity.f.this.e(eVar, str2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    PhotoCropActivity photoCropActivity4 = PhotoCropActivity.this;
                    if (TextUtils.isEmpty(photoCropActivity4.f183999q0)) {
                        str = PhotoCropActivity.this.f183998p0;
                    } else {
                        str = PhotoCropActivity.this.f183999q0;
                    }
                    photoCropActivity4.l3(arrayList, str);
                    return;
                }
                d(arrayList, eVar, QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_AVATAR);
                if (!this.f184021a) {
                    PhotoCropActivity photoCropActivity5 = PhotoCropActivity.this;
                    photoCropActivity5.setResult(-1, photoCropActivity5.getIntent());
                    PhotoCropActivity.this.finish();
                    return;
                }
                return;
            }
            QQToast.makeText(PhotoCropActivity.this, R.string.ctz, 0).show();
        }
    }

    public PhotoCropActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183983a0 = "QCIRCLE_" + UUID.randomUUID();
        this.f183984b0 = 10000L;
        this.G0 = false;
        this.H0 = false;
        this.I0 = 0;
        this.L0 = null;
        this.M0 = "";
        this.N0 = false;
        this.O0 = false;
        this.P0 = 0;
        this.Q0 = false;
        this.R0 = new ArrayList<>();
        this.T0 = new a();
        this.U0 = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Q2(String str) {
        if ((sa0.b.c() && (this.G0 || this.H0)) || d3() || e3()) {
            try {
                String fileName = FileUtils.getFileName(str);
                String winkCachePath = ((IWinkAPI) QRoute.api(IWinkAPI.class)).getWinkCachePath(System.nanoTime() + "_" + fileName);
                FileUtils.copyFile(str, winkCachePath);
                return winkCachePath;
            } catch (Exception e16) {
                QLog.e("PhotoCropActivity", 2, "copyFileForAvatarVideo", e16);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2() {
        String avatarCacheOldPath = FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin());
        if (!TextUtils.isEmpty(avatarCacheOldPath)) {
            FileUtils.deleteFile(avatarCacheOldPath);
        }
        this.L0 = (IQQAvatarDataService) this.app.getRuntimeService(IQQAvatarDataService.class, "");
        FileUtils.copyFile(FaceUtil.getAvatarCacheNewPath(this.app.getCurrentUin()), FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin()));
        String str = this.L0.getHistoryAvatarPath() + "";
        this.M0 = str;
        if (TextUtils.isEmpty(str) || !FileUtils.fileExists(this.M0)) {
            FileUtils.copyFile(this.L0.getCustomFaceFilePath(false, this.app.getCurrentUin()), FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin()));
            this.M0 = FaceUtil.getAvatarCacheOldPath(this.app.getCurrentUin());
        }
    }

    private void T2(String str, String str2) {
        if (!d3()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_AVATAR_ADJUST_PAGE);
        hashMap.put("xsj_eid", str2);
        hashMap.put("xsj_is_tick", Integer.valueOf(f3() ? 1 : 0));
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, WinkDTParamBuilder.APP_KEY);
        VideoReport.reportEvent(str, hashMap);
    }

    private boolean U2(boolean z16) {
        return CommonMMKVUtils.getBoolean("sp_key_avatar_qcircle_share_open", !z16, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap V2(String str) {
        Bitmap bitmap;
        File file = new File(str);
        boolean isSharpP = SharpPUtils.isSharpP(file);
        boolean a16 = com.tencent.qzone.avif.a.a(file);
        if (!isSharpP && !a16) {
            return null;
        }
        try {
        } catch (Exception e16) {
            QLog.d("PhotoCropActivity", 1, "getBitmapByType exp ", e16);
        } catch (OutOfMemoryError e17) {
            QLog.e("PhotoCropActivity", 1, "Out of Memory ", e17);
        }
        if (isSharpP) {
            QLog.d("PhotoCropActivity", 1, "getBitmapByType isSharp");
            bitmap = SharpPUtils.decodeSharpP(str);
        } else if (a16) {
            QLog.d("PhotoCropActivity", 1, "getBitmapByType isAvif");
            bitmap = com.tencent.qzone.image.api.a.c().b(str, null, 0, 0);
        } else {
            bitmap = null;
            if (bitmap != null) {
                return null;
            }
            return bitmap;
        }
        if (bitmap != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int W2(long j3, long j16, long j17, long j18) {
        int i3 = 1;
        if (j3 != 0 && j16 != 0 && j3 != -1 && j16 != -1) {
            long j19 = j3 * j16;
            while (true) {
                if ((j18 <= j16 && j17 <= j3) || j17 * j18 <= j19 || Math.max(Math.round(((float) j18) / ((float) j16)), Math.round(((float) j17) / ((float) j3))) < 2) {
                    break;
                }
                j17 /= 2;
                j18 /= 2;
                i3 *= 2;
            }
        }
        return i3;
    }

    private void Y2() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(24.0f));
        layoutParams.addRule(3, this.f183988f0.getId());
        layoutParams.setMargins(0, 0, 0, 0);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackgroundColor(getResources().getColor(R.color.black));
        TextView textView = new TextView(this);
        textView.setText("\u6846\u9009\u5934\u90e8\u533a\u57df\uff0c\u4fdd\u7559\u89d2\u8272\u5f62\u8c61\u7279\u5f81");
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#9AFFFFFF"));
        textView.setTypeface(Typeface.create(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_REGULAR, 0));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(6, relativeLayout.getId());
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        ((RelativeLayout) this.f184004v0).addView(relativeLayout);
    }

    private boolean d3() {
        if ("FROM_QCIRCLE_AVATAR".equals(this.f183998p0) && sa0.b.d()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e3() {
        if (100 == this.f184000r0 && this.G0 && sa0.b.e()) {
            return true;
        }
        return false;
    }

    private boolean f3() {
        CheckBox checkBox = this.f183992j0;
        if (checkBox != null && checkBox.getVisibility() == 0 && this.f183992j0.isChecked()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3() {
        if (this.f184000r0 == 105) {
            this.f183987e0.setBorderRadius(ViewUtils.dip2px(3.0f));
        }
    }

    private void h3() {
        if (this.f183992j0 == null || CommonMMKVUtils.getBoolean("sp_key_has_show_avatar_qcircle_share_bubble", false, true)) {
            return;
        }
        QUIDefaultBubbleTip.r(this).S(this.f183992j0).o0(com.dataline.util.j.d(getString(R.string.f174232va))).k0(0).R(0).m0(4).s0();
        CommonMMKVUtils.putBoolean("sp_key_has_show_avatar_qcircle_share_bubble", true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(int i3) {
        if (!isFinishing()) {
            QQToast.makeText(this, i3, 0).show(getTitleBarHeight());
        }
    }

    protected void R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.S0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.S0.dismiss();
            } catch (Exception unused) {
            }
        }
        this.S0 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z2() {
        if (this.N0) {
            return;
        }
        this.N0 = true;
        if (f3()) {
            new f(false, true).execute(new Void[0]);
        } else {
            new f(false, false).execute(new Void[0]);
        }
    }

    protected boolean b3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Intent intent = getIntent();
        this.f184003u0 = intent;
        this.f183998p0 = intent.getStringExtra("FROM_WHERE");
        this.f183999q0 = intent.getStringExtra("PhotoConst.SUB_SOURCE_FROM");
        this.G0 = intent.getBooleanExtra("AVATAR_TO_CIRCLE_PUBLISH_ALBUM", false);
        this.H0 = intent.getBooleanExtra("AVATAR_TO_CIRCLE_PUBLISH_PHOTO", false);
        this.I0 = intent.getIntExtra("AVATAR_TO_EXPERIENCE_FROM_TYPE", 0);
        intent.removeExtra("FROM_WHERE");
        this.f184005w0 = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        this.f184006x0 = (Uri) intent.getParcelableExtra(PeakConstants.CROP_SINGLE_PHOTO_URI);
        this.f184007y0 = intent.getStringExtra(PeakConstants.QZONE_COVER_CROP_LEFT_TITLE);
        this.f184008z0 = intent.getIntExtra(PeakConstants.CLIP_WIDTH, 400);
        this.A0 = intent.getIntExtra(PeakConstants.CLIP_HEIGHT, 400);
        this.F0 = intent.getBooleanExtra(PeakConstants.USE_32_BIT_CONFIG, false);
        this.B0 = intent.getIntExtra(PeakConstants.TARGET_WIDTH, 400);
        this.C0 = intent.getIntExtra(PeakConstants.TARGET_HEIGHT, 400);
        this.D0 = intent.getIntExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1280);
        this.J0 = intent.getBooleanExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, false);
        this.f183995m0 = intent.getStringExtra(PeakConstants.TARGET_PATH);
        this.f184000r0 = intent.getIntExtra("BUSINESS_ORIGIN_NEW", 0);
        if (this.f183995m0 == null) {
            QQToast.makeText(this, R.string.f171169cu1, 0).show();
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PhotoCropActivity", 2, String.format("initData path=%s target=%s", this.f184005w0, this.f183995m0));
        }
        this.E0 = intent.getIntExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
        this.f184001s0 = intent.getIntExtra(PeakConstants.COMPRESS_QUALITY, 100);
        this.f184002t0 = intent.getStringArrayExtra(PeakConstants.QZONE_COVER_SOURCE);
        if (QLog.isColorLevel()) {
            QLog.d("PhotoCropActivity", 2, "initData from=" + this.f183998p0 + " targetSampleSize=" + this.D0 + " keepClipInfo=" + this.J0);
        }
        if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.f183998p0)) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009B68", "0X8009B68", 0, 0, "", "", "", "");
        }
        if ("FROM_LOGIN_AVATAR".equals(this.f183998p0)) {
            QQAppInterface qQAppInterface = this.app;
            ao.Companion companion = ao.INSTANCE;
            ReportController.o(qQAppInterface, "dc00898", "", companion.d(), "0X800C32A", "0X800C32A", companion.c(), 0, "", "", "", "");
        }
        if ((sa0.b.c() && (this.G0 || this.H0)) || e3()) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_photo_crop_use_file_thread", true)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        PhotoCropActivity.this.S2();
                    }
                }, 64, null, true);
            } else {
                S2();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, mqq.app.AppActivity
    public void beforeDoOnCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.beforeDoOnCreate();
            QLog.d("PhotoCropActivity", 1, "init qzone image env result:", Boolean.valueOf(((IQZoneEnvApi) QRoute.api(IQZoneEnvApi.class)).initImageEnv(getBaseContext())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void c3(String str, int i3, int i16, int i17, int i18, int i19) {
        this.f184004v0 = findViewById(R.id.root);
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.f184004v0, WinkDaTongReportConstant.PageId.PG_BAS_AI_AVATAR_PHOTO_ADJUST);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f184004v0.setFitsSystemWindows(true);
        }
        this.f183985c0 = (ViewGroup) findViewById(R.id.fqy);
        this.f183989g0 = (Button) findViewById(R.id.f164942bd1);
        this.f183994l0 = (Button) findViewById(R.id.aip);
        VideoReport.setElementId(this.f183989g0, "em_photo_finish_button");
        VideoReport.setElementClickPolicy(this.f183989g0, ClickPolicy.REPORT_ALL);
        this.f183996n0 = (Button) findViewById(R.id.a4c);
        this.f183997o0 = (TextView) findViewById(R.id.title);
        this.f183988f0 = (RelativeLayout) findViewById(R.id.f166999jt2);
        this.f183989g0.setOnClickListener(this);
        this.f183996n0.setOnClickListener(this);
        this.f183994l0.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.f184007y0)) {
            this.f183996n0.setText(this.f184007y0);
        }
        if (sa0.b.c() && (this.G0 || this.H0)) {
            this.f183989g0.setText("\u66f4\u6362\u5934\u50cf");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(40.0f));
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = ViewUtils.dip2px(38.0f);
            layoutParams.rightMargin = ViewUtils.dip2px(16.0f);
            layoutParams.leftMargin = ViewUtils.dip2px(16.0f);
            this.f183989g0.setLayoutParams(layoutParams);
        }
        if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.f183998p0)) {
            this.f183996n0.setText("");
            this.f183997o0.setText("\u8c03\u6574QQ\u5934\u50cf");
        }
        if ("FROM_ZPLAN_BG_EDIT".equals(this.f183999q0) || "FROM_SMALL_HOME_TAKE_PHOTO".equals(this.f183998p0)) {
            this.f183989g0.setVisibility(8);
            this.f183994l0.setVisibility(0);
        }
        if ("SUB_FROM_ROBOT_ADELIE_AVATAR".equals(this.f183999q0)) {
            Y2();
        }
        if (d3()) {
            this.f183989g0.setVisibility(8);
            this.f183990h0 = (Button) findViewById(R.id.f364014g);
            this.f183991i0 = (TextView) findViewById(R.id.f364114h);
            this.f183993k0 = (TextView) findViewById(R.id.f364214i);
            this.f183992j0 = (CheckBox) findViewById(R.id.f54792g6);
            this.f183990h0.setVisibility(0);
            this.f183991i0.setVisibility(0);
            this.f183993k0.setVisibility(0);
            this.f183992j0.setVisibility(0);
            this.f183993k0.setText(com.dataline.util.j.d(BaseApplication.getContext().getString(R.string.f174222v_)));
            this.f183990h0.setOnClickListener(this);
            this.f183991i0.setOnClickListener(this);
            this.f183992j0.setOnClickListener(this);
            boolean isExperiment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_avatarVideo");
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_avatarVideo");
            this.f183992j0.setChecked(U2(isExperiment));
            h3();
        }
        PortraitImageview portraitImageview = new PortraitImageview(this);
        this.f183986d0 = portraitImageview;
        portraitImageview.addOnLayoutChangeListener(new b());
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 2) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168376ua);
        if (!b3()) {
            finish();
            return false;
        }
        c3(this.f184005w0, this.f184008z0, this.A0, this.B0, this.C0, this.E0);
        addObserver(this.U0);
        new d().execute(new Void[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.doOnDestroy();
            removeObserver(this.U0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.e("doOnNewIntent", 2, "get new intent");
        }
        setIntent(intent);
        if (!b3()) {
            finish();
        } else {
            c3(this.f184005w0, this.f184008z0, this.A0, this.B0, this.C0, this.E0);
            new d().execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        if (getIntent().getBooleanExtra(PeakConstants.TITLE_BAR_BLACK_BG, false)) {
            this.f183988f0.setBackgroundColor(getResources().getColor(R.color.black));
            this.f183997o0.setTextColor(getResources().getColor(R.color.f158017al3));
            this.f183996n0.setBackgroundResource(R.drawable.top_back_left_selector);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(R.color.black);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "peak";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    protected void j3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        try {
            if (!isFinishing()) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
                this.S0 = qQProgressDialog;
                qQProgressDialog.setCancelable(false);
                this.S0.setMessage(R.string.a2h);
                this.S0.show();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void l3(ArrayList<String> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) arrayList, (Object) str);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            String str2 = arrayList.get(0);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.PhotoCropActivity.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoCropActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Button button = PhotoCropActivity.this.f183994l0;
                    if (button != null) {
                        button.setEnabled(false);
                    }
                }
            });
            Handler handler = this.T0;
            handler.sendMessage(Message.obtain(handler, 1002));
            ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).uploadPic(getCurrentAccountUin(), str2, str, new nk3.k(arrayList) { // from class: com.tencent.mobileqq.activity.photo.PhotoCropActivity.4
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ArrayList f184009a;

                {
                    this.f184009a = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoCropActivity.this, (Object) arrayList);
                    }
                }

                @Override // nk3.k
                public void a(Boolean bool, String str3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool, (Object) str3);
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable(bool, str3) { // from class: com.tencent.mobileqq.activity.photo.PhotoCropActivity.4.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Boolean f184011d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f184012e;

                            {
                                this.f184011d = bool;
                                this.f184012e = str3;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, bool, str3);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                PhotoCropActivity.this.T0.removeMessages(1003);
                                if (this.f184011d.booleanValue()) {
                                    QQToastUtil.showQQToast(2, R.string.f174432vu);
                                    Intent intent = PhotoCropActivity.this.getIntent();
                                    intent.putExtra("BIG_DATA_CHANNEL_URL", this.f184012e);
                                    if ("FROM_ZPLAN_BG_EDIT".equals(PhotoCropActivity.this.f183999q0)) {
                                        PhotoCropActivity photoCropActivity = PhotoCropActivity.this;
                                        PhotoUtils.sendPhoto(photoCropActivity, photoCropActivity.getIntent(), AnonymousClass4.this.f184009a, 0, false);
                                        return;
                                    } else {
                                        if ("FROM_SMALL_HOME_TAKE_PHOTO".equals(PhotoCropActivity.this.f183998p0)) {
                                            intent.putExtra("from_type", "from_small_home");
                                            ((IZPlanApi) QRoute.api(IZPlanApi.class)).startZPlanBackgroundEdit(PhotoCropActivity.this, intent);
                                            PhotoCropActivity.this.finish();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                QQToastUtil.showQQToast(1, R.string.f174422vt);
                                Button button = PhotoCropActivity.this.f183994l0;
                                if (button != null) {
                                    button.setEnabled(true);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (PhotoCommonBaseData.FROM_PHOTO_LIST.equals(this.f183998p0)) {
            Intent intent = getIntent();
            intent.setClass(this, NewPhotoListActivity.class);
            intent.removeExtra("PhotoConst.PHOTO_PATHS");
            if (intent.getBooleanExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, false)) {
                setResult(-1, intent.putExtra(PeakConstants.PHOTO_CROP_CANCEL, true));
            } else {
                startActivity(intent);
            }
        } else if ("FROM_NEARBY_PROFILE".equals(this.f183998p0)) {
            PhotoUtils.sendPhoto(this, getIntent(), new ArrayList(), 0, false);
        } else if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.f183998p0)) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009B69", "0X8009B69", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d("PhotoCropActivity", 2, "onBackEvent");
            }
            Intent intent2 = getIntent();
            intent2.putExtra(IProfileCardConst.KEY_FROM_SET_AVATAR_RESULT, false);
            setResult(0, intent2);
        }
        finish();
        QAlbumUtil.anim(this, true, false);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.aip && id5 != R.id.f164942bd1 && id5 != R.id.f364014g && id5 != R.id.uc8) {
                if (id5 != R.id.f364114h && id5 != R.id.f164934uc2) {
                    if (id5 == R.id.f54792g6) {
                        T2("dt_clck", QCircleDaTongConstant.ElementId.EM_XSJ_SHARE_TO_XSJ);
                    } else if (id5 == R.id.a4c) {
                        onBackEvent();
                    }
                } else if (!FastClickUtils.isFastDoubleClick("PhotoCropActivity syncQCirclePreview", 500L)) {
                    new f(true, false).execute(new Void[0]);
                    T2("dt_clck", "em_xsj_clck_preview");
                }
            } else {
                VideoReport.reportEvent("dt_clck", view, null);
                if (this.f184002t0 != null) {
                    if (this.K0 == null) {
                        h hVar = new h(this);
                        this.K0 = hVar;
                        hVar.b(this.f184002t0);
                    }
                    if (this.f183987e0 != null) {
                        this.K0.c();
                    }
                } else {
                    if (!this.Q0 && this.f183987e0 != null) {
                        Z2();
                    }
                    if ("FROM_ZPLAN_BG_EDIT".equals(this.f183999q0) || "FROM_SMALL_HOME_TAKE_PHOTO".equals(this.f183998p0)) {
                        ArrayList<String> arrayList = this.R0;
                        if (TextUtils.isEmpty(this.f183999q0)) {
                            str = this.f183998p0;
                        } else {
                            str = this.f183999q0;
                        }
                        l3(arrayList, str);
                    }
                }
                QAlbumUtil.clearSelectItemInfo();
                com.tencent.mobileqq.utils.e.a(this.f184003u0);
                if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.f183998p0)) {
                    ReportController.o(this.app, "dc00898", "", "", "0X8009B6A", "0X8009B6A", 0, 0, "", "", "", "");
                }
                if ("FROM_LOGIN_AVATAR".equals(this.f183998p0)) {
                    QQAppInterface qQAppInterface = this.app;
                    ao.Companion companion = ao.INSTANCE;
                    ReportController.o(qQAppInterface, "dc00898", "", companion.d(), "0X800C32B", "0X800C32B", companion.c(), 0, "", "", "", "");
                }
                if (this.f183992j0 != null && d3()) {
                    CommonMMKVUtils.putBoolean("sp_key_avatar_qcircle_share_open", this.f183992j0.isChecked(), true);
                }
                T2("dt_clck", "em_xsj_complete_button");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
            T2("dt_imp", QCircleDaTongConstant.ElementId.EM_XSJ_SHARE_TO_XSJ);
        }
    }
}
