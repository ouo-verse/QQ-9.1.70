package com.tencent.mobileqq.activity.shortvideo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.aa;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.l;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<BaseActivity> f186324a;

    /* renamed from: b, reason: collision with root package name */
    String f186325b;

    /* renamed from: c, reason: collision with root package name */
    String f186326c;

    /* renamed from: d, reason: collision with root package name */
    long f186327d;

    /* renamed from: e, reason: collision with root package name */
    long f186328e;

    /* renamed from: f, reason: collision with root package name */
    String f186329f;

    /* renamed from: g, reason: collision with root package name */
    int f186330g;

    /* renamed from: h, reason: collision with root package name */
    String f186331h;

    /* renamed from: i, reason: collision with root package name */
    String f186332i;

    /* renamed from: j, reason: collision with root package name */
    String f186333j;

    /* renamed from: k, reason: collision with root package name */
    int f186334k;

    /* renamed from: l, reason: collision with root package name */
    int f186335l;

    /* renamed from: m, reason: collision with root package name */
    String f186336m;

    /* renamed from: n, reason: collision with root package name */
    TextView f186337n;

    /* renamed from: o, reason: collision with root package name */
    ProgressDialog f186338o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f186339d;

        a(Context context) {
            this.f186339d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ((Activity) this.f186339d).finish();
        }
    }

    public f(BaseActivity baseActivity) {
        this.f186324a = new WeakReference<>(baseActivity);
        Intent intent = baseActivity.getIntent();
        this.f186326c = intent.getExtras().getString("file_send_path");
        this.f186328e = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_DURATION);
        this.f186327d = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_SIZE);
        this.f186329f = intent.getExtras().getString("uin");
        this.f186330g = intent.getIntExtra("uintype", -1);
        this.f186331h = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
        this.f186332i = intent.getExtras().getString(ShortVideoConstants.FILE_SHORTVIDEO_MD5);
        this.f186325b = intent.getExtras().getString(ShortVideoConstants.ACTIVITY_BEFORE_ENTER_SEND_VIDEO);
        this.f186336m = intent.getExtras().getString(ShortVideoConstants.THUMBFILE_MD5);
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, " SendAppShortVideoTask(),  mVideoPath :" + this.f186326c + ", mDuration:" + this.f186328e + ", mFileSize:" + this.f186327d + ",mUin" + this.f186329f + ",mUinType:" + this.f186330g + ",mFileSource:" + this.f186331h);
        }
    }

    public static void e(Context context, int i3) {
        DialogUtil.createCustomDialog(context, 232, null, context.getString(i3), new a(context), null).show();
    }

    void a() {
        try {
            ProgressDialog progressDialog = this.f186338o;
            if (progressDialog != null) {
                progressDialog.cancel();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:25|26|(6:27|28|30|31|32|(2:34|(1:36))(2:50|(1:52)))|37|(0)|40|41|42|43) */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00f0, code lost:
    
        if (r12 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01dc, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01e1, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01e3, code lost:
    
        com.tencent.qphone.base.util.QLog.e("SendVideoActivity", 2, "sendVideo mVideoPath=" + r15.f186326c + " FileNotFoundException error=" + r1.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0207, code lost:
    
        r11 = 5;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x027e: MOVE (r10 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:639), block:B:120:0x027e */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0281 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int b() {
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        FileInputStream fileInputStream;
        int i3 = 1;
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f186326c, 1);
        String l3 = j.l("" + System.currentTimeMillis(), "jpg");
        FileUtils.createFileIfNotExits(j.k() + ".nomedia");
        File file = new File(l3);
        File file2 = new File(file.getParent());
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        if (!file.exists() || !file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        OutputStream outputStream2 = null;
        String str = null;
        int i16 = 2;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                if (createVideoThumbnail != null) {
                    try {
                        createVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                        bufferedOutputStream.flush();
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "sendVideo thumbFilePath=" + l3 + "FileNotFoundException error=" + e.getMessage());
                        }
                    } catch (IOException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "sendVideo thumbFilePath=" + l3 + " IOException error=" + e.getMessage());
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        i3 = 2;
                        if (!file.exists()) {
                        }
                        return i16;
                    }
                } else {
                    i3 = 2;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                bufferedOutputStream = null;
            } catch (IOException e26) {
                e = e26;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (outputStream2 != null) {
                }
                throw th;
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException unused2) {
                if (!file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(l3);
                    } catch (FileNotFoundException e27) {
                        e = e27;
                        fileInputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                        }
                        if (!TextUtils.isEmpty(null)) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            str = HexUtil.bytes2HexStr(MD5.toMD5Byte(fileInputStream, file.length()));
                            try {
                                fileInputStream.close();
                            } catch (IOException e28) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SendVideoActivity", 2, "sendVideo localThumbMd5=" + l3 + " IOException error=" + e28.getMessage());
                                }
                            }
                            if (TextUtils.isEmpty(str)) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SendVideoActivity", 2, "sendVideo processThumb: mCoverMd5 is empty, " + str);
                                }
                            } else {
                                String l16 = j.l(str, "jpg");
                                if (FileUtils.rename(l3, l16)) {
                                    l3 = l16;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e29) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("SendVideoActivity", 2, "sendVideo localThumbMd5=" + l3 + " IOException error=" + e29.getMessage());
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(null)) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SendVideoActivity", 2, "sendVideo processThumb: mCoverMd5 is empty, " + ((String) null));
                                }
                            } else {
                                FileUtils.rename(l3, j.l(null, "jpg"));
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e36) {
                        e = e36;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e37) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("SendVideoActivity", 2, "sendVideo localThumbMd5=" + l3 + " IOException error=" + e37.getMessage());
                                }
                            }
                        }
                        if (TextUtils.isEmpty(null)) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SendVideoActivity", 2, "sendVideo processThumb: mCoverMd5 is empty, " + ((String) null));
                            }
                        } else {
                            String l17 = j.l(null, "jpg");
                            if (FileUtils.rename(l3, l17)) {
                                l3 = l17;
                            }
                        }
                        i3 = 2;
                        this.f186336m = str;
                        this.f186333j = l3;
                        if (createVideoThumbnail != null) {
                            this.f186334k = createVideoThumbnail.getWidth();
                            this.f186335l = createVideoThumbnail.getHeight();
                        }
                        fileInputStream = new FileInputStream(this.f186326c);
                        i16 = i3;
                        this.f186332i = HexUtil.bytes2HexStr(MD5.toMD5Byte(fileInputStream, new File(this.f186326c).length()));
                        return i16;
                    }
                    this.f186336m = str;
                    this.f186333j = l3;
                    if (createVideoThumbnail != null) {
                    }
                    fileInputStream = new FileInputStream(this.f186326c);
                    i16 = i3;
                    this.f186332i = HexUtil.bytes2HexStr(MD5.toMD5Byte(fileInputStream, new File(this.f186326c).length()));
                } else if (QLog.isColorLevel()) {
                    QLog.e("SendVideoActivity", 2, "sendVideo error  thumbFile.exists = false");
                }
                return i16;
            }
        } catch (Throwable th8) {
            th = th8;
            outputStream2 = outputStream;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        return Integer.valueOf(b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f186324a.get() == null) {
            return;
        }
        a();
        switch (num.intValue()) {
            case 1:
                Intent intent = this.f186324a.get().getIntent();
                intent.putExtra("uin", this.f186329f);
                intent.putExtra("uintype", this.f186330g);
                intent.putExtra("file_send_path", this.f186326c);
                intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, this.f186327d);
                intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) (this.f186328e / 1000));
                intent.putExtra(ShortVideoConstants.FILE_SOURCE, this.f186331h);
                intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, this.f186333j);
                intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, this.f186332i);
                intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, this.f186334k);
                intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, this.f186335l);
                intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, this.f186336m);
                intent.putExtra(ShortVideoConstants.FILE_SEND_BUSINESS_TYPE, 2);
                v b16 = com.tencent.mobileqq.shortvideo.h.b(0, 2);
                aa b17 = l.b(2, intent, b16);
                b16.e(b17);
                xq2.b aioShortVideoSendOperator = ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(this.f186324a.get().app);
                MessageRecord l3 = aioShortVideoSendOperator.l(b17);
                if (l3 != null) {
                    aioShortVideoSendOperator.e(l3);
                    MessageForShortVideo messageForShortVideo = (MessageForShortVideo) l3;
                    FileUtils.copyFile(this.f186326c, ShortVideoUtils.realGetShortVideoSavePath(messageForShortVideo.md5, messageForShortVideo.frienduin, messageForShortVideo.uniseq, "mp4"));
                    v b18 = com.tencent.mobileqq.shortvideo.h.b(0, 2);
                    aa c16 = l.c(l3, b18);
                    c16.f287755x = false;
                    b18.e(c16);
                    l.e(b18, this.f186324a.get().app);
                    Intent intent2 = this.f186324a.get().getIntent();
                    if (intent2.getBooleanExtra(ShortVideoConstants.START_INIT_ACTIVITY_AFTER_SENDED, true)) {
                        String stringExtra = intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                        intent.setClassName(intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), stringExtra);
                        if (QLog.isColorLevel()) {
                            QLog.d("SendVideoActivity", 2, "SendAppShortVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + stringExtra);
                        }
                        intent.addFlags(603979776);
                        this.f186324a.get().startActivity(intent);
                    }
                    this.f186324a.get().finish();
                    this.f186324a.get().overridePendingTransition(0, R.anim.f154425m);
                    return;
                }
                return;
            case 2:
            case 6:
                e(this.f186324a.get(), R.string.hly);
                return;
            case 3:
                e(this.f186324a.get(), R.string.hlt);
                return;
            case 4:
                e(this.f186324a.get(), R.string.f173146hl0);
                return;
            case 5:
                e(this.f186324a.get(), R.string.hlq);
                return;
            default:
                return;
        }
    }

    void f(Context context, int i3) {
        try {
            if (this.f186338o != null) {
                a();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context, R.style.qZoneInputDialog);
                this.f186338o = reportProgressDialog;
                reportProgressDialog.setCancelable(true);
                this.f186338o.show();
                this.f186338o.setContentView(R.layout.f168383uh);
                this.f186337n = (TextView) this.f186338o.findViewById(R.id.photo_prievew_progress_dialog_text);
            }
            this.f186337n.setText(i3);
            if (!this.f186338o.isShowing()) {
                this.f186338o.show();
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
        f(this.f186324a.get(), R.string.cuv);
    }
}
