package com.tencent.mobileqq.activity.shortvideo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ac;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.l;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqnt.aio.api.IAIOFileTransfer;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import cooperation.peak.PeakConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a, reason: collision with root package name */
    final WeakReference<BaseActivity> f186343a;

    /* renamed from: b, reason: collision with root package name */
    String f186344b;

    /* renamed from: c, reason: collision with root package name */
    public String f186345c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<String> f186346d;

    /* renamed from: e, reason: collision with root package name */
    long f186347e;

    /* renamed from: f, reason: collision with root package name */
    long f186348f;

    /* renamed from: g, reason: collision with root package name */
    String f186349g;

    /* renamed from: h, reason: collision with root package name */
    int f186350h;

    /* renamed from: i, reason: collision with root package name */
    String f186351i;

    /* renamed from: j, reason: collision with root package name */
    String f186352j;

    /* renamed from: k, reason: collision with root package name */
    String f186353k;

    /* renamed from: l, reason: collision with root package name */
    int f186354l;

    /* renamed from: m, reason: collision with root package name */
    int f186355m;

    /* renamed from: n, reason: collision with root package name */
    String f186356n;

    /* renamed from: o, reason: collision with root package name */
    int f186357o;

    /* renamed from: p, reason: collision with root package name */
    int f186358p;

    /* renamed from: q, reason: collision with root package name */
    Bitmap f186359q;

    /* renamed from: r, reason: collision with root package name */
    TextView f186360r;

    /* renamed from: s, reason: collision with root package name */
    ProgressDialog f186361s;

    /* renamed from: t, reason: collision with root package name */
    boolean f186362t;

    /* renamed from: u, reason: collision with root package name */
    boolean f186363u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f186364d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BaseActivity f186365e;

        a(boolean z16, BaseActivity baseActivity) {
            this.f186364d = z16;
            this.f186365e = baseActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!this.f186364d) {
                this.f186365e.finish();
            }
        }
    }

    public h(BaseActivity baseActivity, Intent intent) {
        if (baseActivity == null) {
            QLog.e("SendVideoTask", 1, "SendVideoTask construct error, activity is null! stack=" + QLog.getStackTraceString(new RuntimeException()));
            this.f186343a = new WeakReference<>(null);
            return;
        }
        this.f186343a = new WeakReference<>(baseActivity);
        intent = intent == null ? baseActivity.getIntent() : intent;
        this.f186345c = intent.getExtras().getString("file_send_path");
        this.f186346d = intent.getStringArrayListExtra(PeakConstants.PHOTO_PATHS_BY_FILE);
        this.f186348f = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_DURATION);
        this.f186347e = intent.getExtras().getLong(ShortVideoConstants.FILE_SEND_SIZE);
        this.f186349g = intent.getExtras().getString("uin");
        this.f186350h = intent.getIntExtra("uintype", -1);
        this.f186351i = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
        this.f186352j = intent.getExtras().getString(ShortVideoConstants.FILE_SHORTVIDEO_MD5);
        this.f186344b = intent.getExtras().getString(ShortVideoConstants.ACTIVITY_BEFORE_ENTER_SEND_VIDEO);
        this.f186362t = intent.getExtras().getBoolean(PeakConstants.SEND_IN_BACKGROUND);
        this.f186363u = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0) == 2;
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.f186345c + ", mDuration:" + this.f186348f + ", mFileSize:" + this.f186347e + ",mUin" + this.f186349g + ",mUinType:" + this.f186350h + ",mFileSource:" + this.f186351i + ",mSendBackground = " + this.f186362t + ", mSendRawVideo:" + this.f186363u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(ArrayList arrayList, int i3, String str, MsgElement msgElement) {
        arrayList.add(msgElement);
        ((IMsgService) QRoute.api(IMsgService.class)).addSendMsg(new Contact(i3, str, ""), arrayList);
    }

    public static void h(BaseActivity baseActivity, int i3, boolean z16) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(baseActivity, 232, null, baseActivity.getString(i3), new a(z16, baseActivity), null);
        if (!baseActivity.isFinishing()) {
            createCustomDialog.show();
        }
    }

    void b() {
        if (this.f186362t) {
            return;
        }
        try {
            ProgressDialog progressDialog = this.f186361s;
            if (progressDialog != null) {
                progressDialog.cancel();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        return Integer.valueOf(g());
    }

    public void d() {
        BaseActivity baseActivity = this.f186343a.get();
        if (baseActivity == null) {
            QLog.e("SendVideoTask", 1, "doSendVideo error, activity is null!");
            return;
        }
        Intent intent = baseActivity.getIntent();
        intent.putExtra("uin", this.f186349g);
        intent.putExtra("uintype", this.f186350h);
        intent.putExtra("file_send_path", this.f186345c);
        intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, this.f186347e);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) (this.f186348f / 1000));
        intent.putExtra(ShortVideoConstants.FILE_SOURCE, this.f186351i);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, this.f186353k);
        intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, this.f186352j);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, this.f186354l);
        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, this.f186355m);
        intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, this.f186356n);
        intent.putExtra(ShortVideoConstants.FILE_WIDTH, this.f186357o);
        intent.putExtra(ShortVideoConstants.FILE_HEIGHT, this.f186358p);
        intent.putExtra(ShortVideoConstants.FILE_RAW_SIZE, this.f186363u);
        if (this.f186350h == 10014) {
            ArrayList<MsgElement> arrayList = new ArrayList<>();
            arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createVideoElement(this.f186345c, 4601, true, null));
            int intExtra = intent.getIntExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, -1);
            String stringExtra = intent.getStringExtra(IGuildForwardUtilsApi.EXTRA_GUILD_ID);
            String stringExtra2 = intent.getStringExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHANNEL_ID);
            Contact contact = new Contact(intExtra, stringExtra2, stringExtra);
            if (intExtra != -1 && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                ((IMsgService) QRoute.api(IMsgService.class)).addSendMsg(contact, arrayList);
                return;
            }
            QLog.i("SendVideoTask", 1, "doSendVideo. info empty! chatType: " + intExtra + ", has guildId: " + TextUtils.isEmpty(stringExtra) + ", has peerUin: " + TextUtils.isEmpty(stringExtra2));
            return;
        }
        String str = this.f186344b;
        if (str != null && str.equals(ShortVideoPreviewActivity.class.getName())) {
            intent.putExtra(ShortVideoConstants.FILE_SEND_BUSINESS_TYPE, 2);
            v b16 = com.tencent.mobileqq.shortvideo.h.b(0, 2);
            b16.e(l.b(2, intent, b16));
            l.e(b16, baseActivity.app);
        } else {
            final String stringExtra3 = intent.getStringExtra(AppConstants.Key.NT_UID);
            final int intExtra2 = intent.getIntExtra(AppConstants.Key.NT_CHAT_TYPE, -1);
            QLog.i("SendVideoTask", 1, "NT SendVideoTask chatType: " + intExtra2 + " ,uid: " + stringExtra3 + ", videoPath: " + this.f186345c);
            if (QLog.isColorLevel()) {
                QLog.i("SendVideoTask", 1, "NT SendVideoTask chatType: " + intExtra2 + ", uid: " + stringExtra3);
            }
            if (intExtra2 != -1 && !TextUtils.isEmpty(stringExtra3)) {
                intent.putExtra(PeakConstants.PANEL_VIDEO_EDIT_SEND, true);
                if (8 == intExtra2) {
                    ((IAIOFileTransfer) QRoute.api(IAIOFileTransfer.class)).sendLocalFile(new Contact(intExtra2, stringExtra3, ""), this.f186345c, null);
                } else {
                    final ArrayList arrayList2 = new ArrayList();
                    d.b(this.f186345c, 4601, true, null, new b() { // from class: com.tencent.mobileqq.activity.shortvideo.g
                        @Override // com.tencent.mobileqq.activity.shortvideo.b
                        public final void a(MsgElement msgElement) {
                            h.e(arrayList2, intExtra2, stringExtra3, msgElement);
                        }
                    });
                }
            } else {
                return;
            }
        }
        if (!this.f186362t) {
            Intent intent2 = baseActivity.getIntent();
            if (intent2.getBooleanExtra(ShortVideoConstants.START_INIT_ACTIVITY_AFTER_SENDED, true)) {
                String stringExtra4 = intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                intent.setClassName(intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), stringExtra4);
                if (QLog.isColorLevel()) {
                    QLog.d("SendVideoActivity", 2, "SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + stringExtra4);
                }
                intent.addFlags(603979776);
                baseActivity.startActivity(intent);
            }
            baseActivity.finish();
            baseActivity.overridePendingTransition(0, R.anim.f154425m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        BaseActivity baseActivity = this.f186343a.get();
        if (baseActivity == null) {
            QLog.e("SendVideoTask", 1, "onPostExecute error, activity is null! result = ", num);
            return;
        }
        b();
        int intValue = num.intValue();
        if (intValue != 9) {
            switch (intValue) {
                case 1:
                    d();
                    return;
                case 2:
                case 6:
                    h(baseActivity, R.string.hly, this.f186362t);
                    return;
                case 3:
                    h(baseActivity, R.string.hlt, this.f186362t);
                    return;
                case 4:
                    h(baseActivity, R.string.f173146hl0, this.f186362t);
                    return;
                case 5:
                    h(baseActivity, R.string.hlq, this.f186362t);
                    return;
                default:
                    return;
            }
        }
        baseActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v27, types: [com.tencent.mobileqq.app.QQAppInterface] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.FileInputStream] */
    public int g() {
        ?? r85;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        BaseActivity baseActivity = this.f186343a.get();
        if (baseActivity == null) {
            return 5;
        }
        ArrayList<String> arrayList = this.f186346d;
        if (arrayList != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_from_scene", 2);
            r85 = baseActivity.app;
            SendByFile.e(r85, this.f186346d, this.f186349g, this.f186350h, bundle);
            String str = this.f186345c;
            if (str == null || str == "") {
                return 9;
            }
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                int a16 = ac.b(baseActivity.app).a();
                if (QLog.isColorLevel()) {
                    QLog.d("SendVideoActivity", 2, "processThumb, step: getEncodeConfig, maxLength = " + a16);
                }
                Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(baseActivity, this.f186345c, a16);
                if (videoThumbnail == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SendVideoActivity", 2, "processThumb: create thumbnail fail");
                    }
                    videoThumbnail = this.f186359q;
                    if (videoThumbnail == null) {
                        return 2;
                    }
                }
                this.f186354l = videoThumbnail.getWidth();
                int height = videoThumbnail.getHeight();
                this.f186355m = height;
                if (this.f186354l != 0 && height != 0) {
                    String l3 = j.l("" + System.currentTimeMillis(), "jpg");
                    FileUtils.createFileIfNotExits(j.k() + ".nomedia");
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
                        videoThumbnail.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                        bufferedOutputStream2.flush();
                        r85 = new FileInputStream(file);
                    } catch (IOException e16) {
                        e = e16;
                        r85 = 0;
                    } catch (Exception e17) {
                        e = e17;
                        r85 = 0;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        r85 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        r85 = 0;
                    }
                    try {
                        long length = file.length();
                        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.toMD5Byte(r85, length));
                        this.f186356n = bytes2HexStr;
                        if (TextUtils.isEmpty(bytes2HexStr)) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SendVideoActivity", 2, "processThumb: mThumbMd5 is empty, " + this.f186356n);
                            }
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused) {
                            }
                            try {
                                r85.close();
                            } catch (IOException unused2) {
                            }
                            return 5;
                        }
                        String l16 = j.l(this.f186356n, "jpg");
                        this.f186353k = l16;
                        if (!FileUtils.rename(l3, l16)) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                            try {
                                r85.close();
                            } catch (IOException unused4) {
                            }
                            return 5;
                        }
                        String formatFileSize = Formatter.formatFileSize(baseActivity, length);
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb: mThumbFile Size:" + formatFileSize);
                        }
                        if (this.f186348f == 0) {
                            this.f186348f = ShortVideoUtils.getDuration(this.f186345c);
                        }
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException unused5) {
                        }
                        try {
                            r85.close();
                            return 1;
                        } catch (IOException unused6) {
                            return 1;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        bufferedOutputStream = bufferedOutputStream2;
                        fileInputStream3 = r85;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb failure", e);
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                                return 3;
                            } catch (IOException unused8) {
                                return 3;
                            }
                        }
                        return 3;
                    } catch (Exception e26) {
                        e = e26;
                        bufferedOutputStream = bufferedOutputStream2;
                        fileInputStream2 = r85;
                        if (QLog.isColorLevel()) {
                            QLog.e("SendVideoActivity", 2, "processThumb failure", e);
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused9) {
                            }
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused10) {
                            }
                        }
                        return 5;
                    } catch (OutOfMemoryError e27) {
                        e = e27;
                        bufferedOutputStream = bufferedOutputStream2;
                        fileInputStream = r85;
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
                        if (r85 != 0) {
                            try {
                                r85.close();
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
                fileInputStream3 = null;
            } catch (Exception e29) {
                e = e29;
                fileInputStream2 = null;
            } catch (OutOfMemoryError e36) {
                e = e36;
                fileInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                r85 = 0;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    void i(Context context, int i3) {
        if (this.f186362t) {
            return;
        }
        try {
            if (this.f186361s != null) {
                b();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context, R.style.qZoneInputDialog);
                this.f186361s = reportProgressDialog;
                reportProgressDialog.setCancelable(true);
                this.f186361s.show();
                this.f186361s.setContentView(R.layout.f168383uh);
                this.f186360r = (TextView) this.f186361s.findViewById(R.id.photo_prievew_progress_dialog_text);
            }
            this.f186360r.setText(i3);
            if (!this.f186361s.isShowing()) {
                this.f186361s.show();
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
        i(this.f186343a.get(), R.string.cuv);
    }
}
