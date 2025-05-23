package cooperation.qqfav.widget;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ck;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.bg;
import com.tencent.mobileqq.utils.bh;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qqfav.QfavPluginProxyActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QfavJumpActivity extends BaseActivity implements Handler.Callback {

    /* renamed from: g0, reason: collision with root package name */
    protected static String f390689g0;

    /* renamed from: a0, reason: collision with root package name */
    private ck f390690a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f390691b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f390692c0;

    /* renamed from: d0, reason: collision with root package name */
    private QQCustomDialog f390693d0;

    /* renamed from: e0, reason: collision with root package name */
    String f390694e0;

    /* renamed from: f0, reason: collision with root package name */
    MqqHandler f390695f0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InputStream f390699d;

        a(InputStream inputStream) {
            this.f390699d = inputStream;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                this.f390699d.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            QfavJumpActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f390701d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InputStream f390702e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f390703f;

        b(String str, InputStream inputStream, long j3) {
            this.f390701d = str;
            this.f390702e = inputStream;
            this.f390703f = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                QfavJumpActivity.this.J2(this.f390701d, this.f390702e, this.f390703f);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("qqfav|QfavJumpActivity", 2, "copy file error", e16);
                }
                QfavJumpActivity qfavJumpActivity = QfavJumpActivity.this;
                qfavJumpActivity.P2(qfavJumpActivity.L2());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QfavJumpActivity.this.f390691b0 = false;
            QfavJumpActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (QfavJumpActivity.this.f390691b0) {
                QfavJumpActivity.this.f390691b0 = false;
                QfavJumpActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QfavJumpActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(final String str, final InputStream inputStream, final long j3) {
        this.f390691b0 = true;
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qqfav.widget.QfavJumpActivity.3
            /* JADX WARN: Removed duplicated region for block: B:39:0x011b A[Catch: all -> 0x0152, TryCatch #14 {all -> 0x0152, blocks: (B:19:0x0036, B:37:0x0115, B:39:0x011b, B:40:0x0125), top: B:18:0x0036 }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0148 A[Catch: IOException -> 0x014c, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x014c, blocks: (B:47:0x0148, B:89:0x00f9), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0156  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x014d -> B:37:0x0151). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Throwable th5;
                FileOutputStream fileOutputStream;
                File file;
                byte[] bArr;
                int i3 = 0;
                byte[] bArr2 = null;
                try {
                    try {
                        file = new File(str);
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = null;
                    } catch (Throwable th6) {
                        th5 = th6;
                        fileOutputStream = null;
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                if (!file.exists() && !file.createNewFile()) {
                    QfavJumpActivity.this.f390695f0.sendEmptyMessage(1);
                    QfavJumpActivity.this.f390691b0 = false;
                    try {
                        inputStream.close();
                        return;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        return;
                    }
                }
                fileOutputStream = new FileOutputStream(str);
                try {
                    try {
                        bArr2 = ByteArrayPool.getGenericInstance().getBuf(8192);
                        long j16 = 0;
                        long j17 = 0;
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                try {
                                    if (!QfavJumpActivity.this.f390691b0) {
                                        break;
                                    }
                                    j16 += read;
                                    fileOutputStream.write(bArr2, i3, read);
                                    double d16 = j16 - j17;
                                    long j18 = j3;
                                    bArr = bArr2;
                                    if (d16 / j18 > 0.1d) {
                                        try {
                                            MqqHandler mqqHandler = QfavJumpActivity.this.f390695f0;
                                            mqqHandler.sendMessage(mqqHandler.obtainMessage(3, (int) ((j16 / j18) * 100.0d), 0));
                                            j17 = j16;
                                        } catch (Exception e19) {
                                            e = e19;
                                            bArr2 = bArr;
                                            if (QLog.isColorLevel()) {
                                            }
                                            QfavJumpActivity.this.f390695f0.sendEmptyMessage(1);
                                            if (bArr2 != null) {
                                            }
                                            QfavJumpActivity.this.f390691b0 = false;
                                            try {
                                                inputStream.close();
                                            } catch (IOException e26) {
                                                e26.printStackTrace();
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                        } catch (Throwable th7) {
                                            th5 = th7;
                                            bArr2 = bArr;
                                            if (bArr2 != null) {
                                            }
                                            QfavJumpActivity.this.f390691b0 = false;
                                            try {
                                                inputStream.close();
                                            } catch (IOException e27) {
                                                e27.printStackTrace();
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                        }
                                    }
                                    bArr2 = bArr;
                                    i3 = 0;
                                } catch (Exception e28) {
                                    e = e28;
                                    if (QLog.isColorLevel()) {
                                        QLog.w("qqfav|QfavJumpActivity", 2, "resolve file error", e);
                                    }
                                    QfavJumpActivity.this.f390695f0.sendEmptyMessage(1);
                                    if (bArr2 != null) {
                                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                                    }
                                    QfavJumpActivity.this.f390691b0 = false;
                                    inputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    return;
                                } catch (Throwable th8) {
                                    th = th8;
                                    th5 = th;
                                    if (bArr2 != null) {
                                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                                    }
                                    QfavJumpActivity.this.f390691b0 = false;
                                    inputStream.close();
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            throw th5;
                                        } catch (IOException e29) {
                                            e29.printStackTrace();
                                            throw th5;
                                        }
                                    }
                                    throw th5;
                                }
                            } catch (Exception e36) {
                                e = e36;
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        }
                        bArr = bArr2;
                        if (j16 == 0) {
                            QfavJumpActivity.f390689g0 = QfavJumpActivity.this.getString(R.string.b8k);
                            QfavJumpActivity.this.f390695f0.sendEmptyMessage(1);
                        }
                        try {
                            if (QfavJumpActivity.this.f390691b0) {
                                MqqHandler mqqHandler2 = QfavJumpActivity.this.f390695f0;
                                mqqHandler2.sendMessage(mqqHandler2.obtainMessage(3, 100, 0));
                                QfavJumpActivity.this.f390695f0.sendEmptyMessageDelayed(2, 200L);
                            } else {
                                IOUtils.closeQuietly(fileOutputStream);
                                file.delete();
                            }
                            if (bArr != null) {
                                ByteArrayPool.getGenericInstance().returnBuf(bArr);
                            }
                            QfavJumpActivity.this.f390691b0 = false;
                            try {
                                inputStream.close();
                            } catch (IOException e37) {
                                e37.printStackTrace();
                            }
                            fileOutputStream.close();
                        } catch (Exception e38) {
                            e = e38;
                            bArr2 = bArr;
                            if (QLog.isColorLevel()) {
                            }
                            QfavJumpActivity.this.f390695f0.sendEmptyMessage(1);
                            if (bArr2 != null) {
                            }
                            QfavJumpActivity.this.f390691b0 = false;
                            inputStream.close();
                            if (fileOutputStream != null) {
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            bArr2 = bArr;
                            th5 = th;
                            if (bArr2 != null) {
                            }
                            QfavJumpActivity.this.f390691b0 = false;
                            inputStream.close();
                            if (fileOutputStream != null) {
                            }
                        }
                    } catch (Throwable th11) {
                        th = th11;
                    }
                } catch (Exception e39) {
                    e = e39;
                }
            }
        }, 5, null, true);
        if (this.f390693d0 == null) {
            QQCustomDialog createCustomProgressDialog = DialogUtil.createCustomProgressDialog(this, getString(R.string.aex), HardCodeUtil.qqStr(R.string.j6l), new c());
            this.f390693d0 = createCustomProgressDialog;
            createCustomProgressDialog.setOnDismissListener(new d());
        }
        this.f390693d0.show();
    }

    private static void K2(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (System.currentTimeMillis() - file2.lastModified() > 86400000) {
                file2.delete();
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x016e: MOVE (r14 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]) (LINE:367), block:B:53:0x016e */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String M2(Uri uri) {
        Cursor cursor;
        Cursor cursor2;
        String str;
        ContentResolver contentResolver = getContentResolver();
        String[] strArr = new String[1];
        Cursor cursor3 = null;
        try {
            try {
                cursor = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (cursor3 != null) {
                }
                throw th;
            }
            try {
                if (cursor == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("qqfav|QfavJumpActivity", 2, "query file failed");
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                int columnIndex = cursor.getColumnIndex("_size");
                cursor.moveToFirst();
                long j3 = cursor.getLong(columnIndex);
                if (((float) j3) > FileUtils.getAvailableExternalMemorySize()) {
                    f390689g0 = getString(R.string.hiw);
                    cursor.close();
                    return null;
                }
                strArr[0] = cursor.getString(columnIndexOrThrow);
                File externalCacheDir = getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir + "";
                } else {
                    str = "" + getCacheDir();
                }
                String str2 = str + "/share/";
                K2(str2);
                String str3 = str2 + FileUtils.getUnitFileName(str2, strArr[0]);
                File file = new File(str2);
                if (!file.exists() && !file.mkdirs()) {
                    P2(HardCodeUtil.qqStr(R.string.q8v));
                    cursor.close();
                    return null;
                }
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("qqfav|QfavJumpActivity", 2, "open input stream failed");
                    }
                    cursor.close();
                    return null;
                }
                if (j3 > 209715200) {
                    this.f390692c0 = true;
                    QQCustomDialog qQCustomDialog = new QQCustomDialog(this, R.style.qZoneInputDialog);
                    qQCustomDialog.setContentView(R.layout.f167856jn);
                    qQCustomDialog.setTitle(getString(R.string.f173206i10));
                    qQCustomDialog.setMessage(getString(R.string.b8t));
                    qQCustomDialog.setCanceledOnTouchOutside(false);
                    qQCustomDialog.setCancelable(false);
                    qQCustomDialog.setNegativeButton(getString(R.string.f170647xd), new a(openInputStream));
                    qQCustomDialog.setPositiveButton(getString(R.string.ans), new b(str3, openInputStream, j3));
                    qQCustomDialog.show();
                } else {
                    J2(str3, openInputStream, j3);
                }
                cursor.close();
                return str3;
            } catch (Exception e17) {
                e = e17;
                this.f390691b0 = false;
                if (QLog.isColorLevel()) {
                    QLog.w("qqfav|QfavJumpActivity", 2, "query file error", e);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            cursor3 = cursor2;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
    }

    private boolean N2(Intent intent) {
        String action = intent.getAction();
        if (!"android.intent.action.SEND".equals(action) && !"android.intent.action.SEND_MULTIPLE".equals(action)) {
            if ("qqfav.action.ENTER_QQMAP".equals(action)) {
                if (this.f390690a0 == null) {
                    this.f390690a0 = new ck(this.app.getAccount());
                }
                intent.setClassName("com.tencent.mobileqq", "cooperation.qqfav.widget.LocationDetailActivity");
                intent.setAction(null);
                super.startActivityForResult(intent, 2);
                return true;
            }
            return false;
        }
        Intent intent2 = new Intent();
        intent2.putExtras(intent);
        intent2.putExtra("nOperation", 8);
        QfavPluginProxyActivity.L2(this, this.app.getAccount(), intent2, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(String str) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(getString(R.string.f173206i10));
        qQCustomDialog.setMessage(str);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setNegativeButton(getString(R.string.button_back), new e());
        qQCustomDialog.show();
    }

    private void dismissDialog() {
        QQCustomDialog qQCustomDialog = this.f390693d0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    protected String L2() {
        String str = f390689g0;
        if (str == null) {
            return getString(R.string.hiy);
        }
        return str;
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
        if (i3 != 0) {
            if (i3 == 2) {
                ck ckVar = this.f390690a0;
                if (ckVar != null) {
                    ckVar.e();
                }
                setResult(i16, intent);
            }
            super.finish();
            return;
        }
        if (i16 != -1 || !N2(getIntent())) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(12:24|(2:25|26)|(2:30|(2:32|(8:34|35|36|(2:43|(1:45))|47|(1:64)(1:53)|54|(2:62|63))))|69|35|36|(4:38|41|43|(0))|47|(1:49)|64|54|(3:56|62|63)) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0084, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0085, code lost:
    
        r8 = r7;
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x008b, code lost:
    
        new java.util.ArrayList();
        r12.getParcelableArrayListExtra("android.intent.extra.STREAM");
        com.tencent.qphone.base.util.QLog.e("qqfav|QfavJumpActivity", 1, r7.toString());
        r7 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ed A[Catch: Exception -> 0x010e, TryCatch #0 {Exception -> 0x010e, blocks: (B:3:0x000b, B:5:0x0016, B:8:0x001a, B:10:0x0020, B:12:0x0024, B:14:0x0038, B:16:0x00e5, B:18:0x00ed, B:20:0x0104, B:22:0x010a, B:24:0x0041, B:47:0x009b, B:49:0x00a4, B:51:0x00a8, B:54:0x00ba, B:56:0x00c0, B:58:0x00c6, B:62:0x00d3, B:67:0x008b), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0104 A[Catch: Exception -> 0x010e, TryCatch #0 {Exception -> 0x010e, blocks: (B:3:0x000b, B:5:0x0016, B:8:0x001a, B:10:0x0020, B:12:0x0024, B:14:0x0038, B:16:0x00e5, B:18:0x00ed, B:20:0x0104, B:22:0x010a, B:24:0x0041, B:47:0x009b, B:49:0x00a4, B:51:0x00a8, B:54:0x00ba, B:56:0x00c0, B:58:0x00c6, B:62:0x00d3, B:67:0x008b), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a4 A[Catch: Exception -> 0x010e, TryCatch #0 {Exception -> 0x010e, blocks: (B:3:0x000b, B:5:0x0016, B:8:0x001a, B:10:0x0020, B:12:0x0024, B:14:0x0038, B:16:0x00e5, B:18:0x00ed, B:20:0x0104, B:22:0x010a, B:24:0x0041, B:47:0x009b, B:49:0x00a4, B:51:0x00a8, B:54:0x00ba, B:56:0x00c0, B:58:0x00c6, B:62:0x00d3, B:67:0x008b), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0 A[Catch: Exception -> 0x010e, TryCatch #0 {Exception -> 0x010e, blocks: (B:3:0x000b, B:5:0x0016, B:8:0x001a, B:10:0x0020, B:12:0x0024, B:14:0x0038, B:16:0x00e5, B:18:0x00ed, B:20:0x0104, B:22:0x010a, B:24:0x0041, B:47:0x009b, B:49:0x00a4, B:51:0x00a8, B:54:0x00ba, B:56:0x00c0, B:58:0x00c6, B:62:0x00d3, B:67:0x008b), top: B:2:0x000b }] */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        boolean z17;
        String M2;
        String r16;
        try {
            this.mNeedStatusTrans = false;
            super.doOnCreate(bundle);
            if (!bh.a(this, true)) {
                super.finish();
                return false;
            }
            Intent intent = super.getIntent();
            if (intent == null) {
                super.finish();
                return false;
            }
            String action = intent.getAction();
            String type = intent.getType();
            this.f390694e0 = null;
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                Parcelable parcelableExtra = intent.getParcelableExtra("android.intent.extra.STREAM");
                try {
                } catch (Exception e16) {
                    e = e16;
                    boolean z18 = false;
                }
                if ((parcelableExtra instanceof Uri) && (r16 = ForwardFileBaseOption.r(this, (Uri) parcelableExtra)) != null) {
                    File file = new File(r16);
                    if (file.exists()) {
                        if (file.isFile()) {
                            z16 = true;
                            if (!TextUtils.isEmpty(type) && type.startsWith("image") && !z16 && (parcelableExtra instanceof Uri)) {
                                M2 = M2((Uri) parcelableExtra);
                                this.f390694e0 = M2;
                                if (M2 != null) {
                                    return true;
                                }
                            }
                            if (!"text/x-vcard".equals(type) && (parcelableExtra instanceof Uri) && "content".equals(((Uri) parcelableExtra).getScheme())) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!TextUtils.isEmpty(type) && ((type.startsWith("image") || type.startsWith("text")) && !z16 && !z17)) {
                                intent.setClass(this, JumpActivity.class);
                                intent.putExtra("qqfav_extra_from_system_share", true);
                                super.startActivity(intent);
                                super.finish();
                                return false;
                            }
                        }
                    }
                }
                z16 = false;
                if (!TextUtils.isEmpty(type)) {
                    M2 = M2((Uri) parcelableExtra);
                    this.f390694e0 = M2;
                    if (M2 != null) {
                    }
                }
                if (!"text/x-vcard".equals(type)) {
                }
                z17 = false;
                if (!TextUtils.isEmpty(type)) {
                    intent.setClass(this, JumpActivity.class);
                    intent.putExtra("qqfav_extra_from_system_share", true);
                    super.startActivity(intent);
                    super.finish();
                    return false;
                }
            }
            if (this.app.isLogin()) {
                Intent intent2 = new Intent();
                intent2.addFlags(67371008);
                intent2.putExtra("isActionSend", true);
                RouteUtils.startActivityForResult(this, intent2, RouterConstants.UI_ROUTER_LOGIN, 0);
                return true;
            }
            if (!N2(intent)) {
                super.finish();
            }
            return true;
        } catch (Exception e17) {
            QLog.e("qqfav|QfavJumpActivity", 1, "QfavJumpActivity doOnCreate|exp:" + e17.getMessage());
            super.finish();
            return false;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    QLog.i("qqfav|QfavJumpActivity", 2, "progress: " + message.arg1);
                    this.f390693d0.setProgress(message.arg1);
                    return false;
                }
                return false;
            }
            dismissDialog();
            Intent intent = super.getIntent();
            intent.setClass(this, JumpActivity.class);
            intent.putExtra("android.intent.extra.STREAM", this.f390694e0);
            intent.putExtra("qqfav_extra_from_system_share", true);
            super.startActivity(intent);
            super.finish();
            return false;
        }
        dismissDialog();
        P2(L2());
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        try {
            if (bg.k(this)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return super.showPreview();
    }
}
