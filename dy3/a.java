package dy3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqnt.aio.utils.m;
import com.tencent.qqnt.compress.api.IVideoManagerConfigApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.shortvideo.NTShortVideoUtils;
import cooperation.peak.PeakConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<Activity> f395209a;

    /* renamed from: b, reason: collision with root package name */
    String f395210b;

    /* renamed from: c, reason: collision with root package name */
    public String f395211c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<String> f395212d;

    /* renamed from: e, reason: collision with root package name */
    long f395213e;

    /* renamed from: f, reason: collision with root package name */
    long f395214f;

    /* renamed from: g, reason: collision with root package name */
    String f395215g;

    /* renamed from: h, reason: collision with root package name */
    int f395216h;

    /* renamed from: i, reason: collision with root package name */
    String f395217i;

    /* renamed from: j, reason: collision with root package name */
    String f395218j;

    /* renamed from: k, reason: collision with root package name */
    String f395219k;

    /* renamed from: l, reason: collision with root package name */
    int f395220l;

    /* renamed from: m, reason: collision with root package name */
    int f395221m;

    /* renamed from: n, reason: collision with root package name */
    String f395222n;

    /* renamed from: o, reason: collision with root package name */
    int f395223o;

    /* renamed from: p, reason: collision with root package name */
    int f395224p;

    /* renamed from: q, reason: collision with root package name */
    Bitmap f395225q;

    /* renamed from: r, reason: collision with root package name */
    TextView f395226r;

    /* renamed from: s, reason: collision with root package name */
    ProgressDialog f395227s;

    /* renamed from: t, reason: collision with root package name */
    boolean f395228t;

    /* renamed from: u, reason: collision with root package name */
    boolean f395229u;

    public a(Activity activity, Intent intent) {
        if (activity == null) {
            QLog.e("SendVideoTask", 1, "SendVideoTask construct error, activity is null!");
            return;
        }
        this.f395209a = new WeakReference<>(activity);
        intent = intent == null ? activity.getIntent() : intent;
        this.f395211c = intent.getExtras().getString("file_send_path");
        this.f395212d = intent.getStringArrayListExtra(PeakConstants.PHOTO_PATHS_BY_FILE);
        this.f395214f = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_DURATION);
        this.f395213e = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_SIZE);
        this.f395215g = intent.getExtras().getString("uin");
        this.f395216h = intent.getIntExtra("uintype", -1);
        this.f395217i = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
        this.f395218j = intent.getExtras().getString(ShortVideoConstants.FILE_SHORTVIDEO_MD5);
        this.f395210b = intent.getExtras().getString(ShortVideoConstants.ACTIVITY_BEFORE_ENTER_SEND_VIDEO);
        this.f395228t = intent.getExtras().getBoolean(PeakConstants.SEND_IN_BACKGROUND);
        this.f395229u = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0) == 2;
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.f395211c + ", mDuration:" + this.f395214f + ", mFileSize:" + this.f395213e + ",mUin" + this.f395215g + ",mUinType:" + this.f395216h + ",mFileSource:" + this.f395217i + ",mSendBackground = " + this.f395228t + ", mSendRawVideo:" + this.f395229u);
        }
    }

    private boolean d() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    void a() {
        if (this.f395228t) {
            return;
        }
        try {
            ProgressDialog progressDialog = this.f395227s;
            if (progressDialog != null) {
                progressDialog.cancel();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        return Integer.valueOf(f());
    }

    public void c() {
        Activity activity = this.f395209a.get();
        if (activity == null) {
            QLog.e("SendVideoTask", 1, "doSendVideo error, activity is null!");
            return;
        }
        Intent intent = activity.getIntent();
        intent.putExtra("uin", this.f395215g);
        intent.putExtra("uintype", this.f395216h);
        intent.putExtra("file_send_path", this.f395211c);
        intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, this.f395213e);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) (this.f395214f / 1000));
        intent.putExtra(ShortVideoConstants.FILE_SOURCE, this.f395217i);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, this.f395219k);
        intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, this.f395218j);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, this.f395220l);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, this.f395221m);
        intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, this.f395222n);
        intent.putExtra(ShortVideoConstants.FILE_WIDTH, this.f395223o);
        intent.putExtra(ShortVideoConstants.FILE_HEIGHT, this.f395224p);
        intent.putExtra(ShortVideoConstants.FILE_RAW_SIZE, this.f395229u);
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createVideoElement(this.f395211c));
        Contact contact = new Contact(this.f395216h, this.f395215g, "");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService().o0(0L, contact, arrayList);
        }
        if (!this.f395228t) {
            Intent intent2 = activity.getIntent();
            if (intent2.getBooleanExtra(ShortVideoConstants.START_INIT_ACTIVITY_AFTER_SENDED, true)) {
                String stringExtra = intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                intent.setClassName(intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), stringExtra);
                if (QLog.isColorLevel()) {
                    QLog.d("SendVideoActivity", 2, "SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + stringExtra);
                }
                intent.addFlags(603979776);
                activity.startActivity(intent);
            }
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        Activity activity = this.f395209a.get();
        if (activity == null) {
            QLog.e("SendVideoTask", 1, "onPostExecute error, activity is null! result = ", num);
            return;
        }
        a();
        int intValue = num.intValue();
        if (intValue != 9) {
            switch (intValue) {
                case 1:
                    c();
                    return;
                case 2:
                case 6:
                    g(activity, R.string.hly, this.f395228t);
                    return;
                case 3:
                    g(activity, R.string.hlt, this.f395228t);
                    return;
                case 4:
                    g(activity, R.string.f173146hl0, this.f395228t);
                    return;
                case 5:
                    g(activity, R.string.hlq, this.f395228t);
                    return;
                default:
                    return;
            }
        }
        activity.finish();
    }

    public int f() {
        FileInputStream fileInputStream;
        Activity activity = this.f395209a.get();
        if (activity == null) {
            return 5;
        }
        ArrayList<String> arrayList = this.f395212d;
        if (arrayList != null && !arrayList.isEmpty() && d()) {
            return 9;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                int d16 = ((IVideoManagerConfigApi) com.tencent.qqnt.aio.adapter.a.b(IVideoManagerConfigApi.class)).getConfig(MobileQQ.sMobileQQ.peekAppRuntime()).d();
                if (QLog.isColorLevel()) {
                    QLog.d("SendVideoActivity", 2, "processThumb, step: getEncodeConfig, maxLength = " + d16);
                }
                Bitmap s16 = NTShortVideoUtils.s(this.f395211c, d16);
                if (s16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SendVideoActivity", 2, "processThumb: create thumbnail fail");
                    }
                    s16 = this.f395225q;
                    if (s16 == null) {
                        return 2;
                    }
                }
                this.f395220l = s16.getWidth();
                int height = s16.getHeight();
                this.f395221m = height;
                if (this.f395220l != 0 && height != 0) {
                    String l3 = NTShortVideoUtils.l("" + System.currentTimeMillis(), "jpg");
                    m.b(NTShortVideoUtils.k() + ".nomedia");
                    File file = new File(l3);
                    File file2 = new File(file.getParent());
                    if (!file2.exists() || !file2.isDirectory()) {
                        file2.mkdirs();
                    }
                    if (!file.exists() || !file.isFile()) {
                        file.createNewFile();
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        s16.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                        bufferedOutputStream2.flush();
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException e16) {
                        e = e16;
                        fileInputStream = null;
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = null;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                    }
                    try {
                        long length = file.length();
                        String a16 = com.tencent.qqnt.shortvideo.a.a(MD5.toMD5Byte(fileInputStream, length));
                        this.f395222n = a16;
                        if (TextUtils.isEmpty(a16)) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SendVideoActivity", 2, "processThumb: mThumbMd5 is empty, " + this.f395222n);
                            }
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                            return 5;
                        }
                        String l16 = NTShortVideoUtils.l(this.f395222n, "jpg");
                        this.f395219k = l16;
                        if (!m.j(l3, l16)) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                            return 5;
                        }
                        String formatFileSize = Formatter.formatFileSize(activity, length);
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb: mThumbFile Size:" + formatFileSize);
                        }
                        if (this.f395214f == 0) {
                            this.f395214f = NTShortVideoUtils.f(this.f395211c);
                        }
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException unused5) {
                        }
                        try {
                            fileInputStream.close();
                            return 1;
                        } catch (IOException unused6) {
                            return 1;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb failure", e);
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return 3;
                            } catch (IOException unused8) {
                                return 3;
                            }
                        }
                        return 3;
                    } catch (Exception e26) {
                        e = e26;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb failure", e);
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused9) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused10) {
                            }
                        }
                        return 5;
                    } catch (OutOfMemoryError e27) {
                        e = e27;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb OutOfMemoryError", e);
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused11) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return 4;
                            } catch (IOException unused12) {
                                return 4;
                            }
                        }
                        return 4;
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused13) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                throw th;
                            } catch (IOException unused14) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("SendVideoActivity", 2, "processThumb: resize thumbnail fail");
                }
                return 2;
            } catch (IOException e28) {
                e = e28;
                fileInputStream = null;
            } catch (Exception e29) {
                e = e29;
                fileInputStream = null;
            } catch (OutOfMemoryError e36) {
                e = e36;
                fileInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    void h(Context context, int i3) {
        if (this.f395228t) {
            return;
        }
        try {
            if (this.f395227s != null) {
                a();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context, R.style.qZoneInputDialog);
                this.f395227s = reportProgressDialog;
                reportProgressDialog.setCancelable(true);
                this.f395227s.show();
                this.f395227s.setContentView(R.layout.f168383uh);
                this.f395226r = (TextView) this.f395227s.findViewById(R.id.photo_prievew_progress_dialog_text);
            }
            this.f395226r.setText(i3);
            if (!this.f395227s.isShowing()) {
                this.f395227s.show();
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("SendVideoActivity", 2, "showProgressDialog", th5);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        h(this.f395209a.get(), R.string.f174392vq);
    }

    public static void g(Activity activity, int i3, boolean z16) {
    }
}
