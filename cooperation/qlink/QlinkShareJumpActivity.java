package cooperation.qlink;

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
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QlinkShareJumpActivity extends BaseActivity implements Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    private String f390454a0;

    /* renamed from: b0, reason: collision with root package name */
    private Bundle f390455b0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f390457d0;

    /* renamed from: f0, reason: collision with root package name */
    private QQCustomDialog f390459f0;

    /* renamed from: c0, reason: collision with root package name */
    private String f390456c0 = HardCodeUtil.qqStr(R.string.qj8);

    /* renamed from: e0, reason: collision with root package name */
    MqqHandler f390458e0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<String> f390460g0 = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QlinkShareJumpActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QlinkShareJumpActivity.this.finish();
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
            QlinkShareJumpActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QlinkShareJumpActivity.this.f390457d0 = false;
            QlinkShareJumpActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (QlinkShareJumpActivity.this.f390457d0) {
                QlinkShareJumpActivity.this.f390457d0 = false;
                QlinkShareJumpActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QlinkShareJumpActivity.this.finish();
        }
    }

    private void I2(final String str, final InputStream inputStream, final long j3) {
        this.f390457d0 = true;
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qlink.QlinkShareJumpActivity.4
            /* JADX WARN: Removed duplicated region for block: B:39:0x011c A[Catch: all -> 0x0153, TryCatch #14 {all -> 0x0153, blocks: (B:19:0x0042, B:37:0x0116, B:39:0x011c, B:40:0x0126), top: B:18:0x0042 }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0130  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0149 A[Catch: IOException -> 0x014d, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x014d, blocks: (B:47:0x0149, B:89:0x00fa), top: B:2:0x0011 }] */
            /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0157  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x014e -> B:37:0x0152). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Throwable th5;
                FileOutputStream fileOutputStream;
                File file;
                byte[] bArr;
                QlinkShareJumpActivity.this.f390456c0 = HardCodeUtil.qqStr(R.string.qjb);
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
                    QlinkShareJumpActivity.this.f390458e0.sendEmptyMessage(1);
                    QlinkShareJumpActivity.this.f390457d0 = false;
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
                                    if (!QlinkShareJumpActivity.this.f390457d0) {
                                        break;
                                    }
                                    j16 += read;
                                    fileOutputStream.write(bArr2, i3, read);
                                    double d16 = j16 - j17;
                                    long j18 = j3;
                                    bArr = bArr2;
                                    if (d16 / j18 > 0.1d) {
                                        try {
                                            MqqHandler mqqHandler = QlinkShareJumpActivity.this.f390458e0;
                                            mqqHandler.sendMessage(mqqHandler.obtainMessage(3, (int) ((j16 / j18) * 100.0d), 0));
                                            j17 = j16;
                                        } catch (Exception e19) {
                                            e = e19;
                                            bArr2 = bArr;
                                            if (QLog.isColorLevel()) {
                                            }
                                            QlinkShareJumpActivity.this.f390458e0.sendEmptyMessage(1);
                                            if (bArr2 != null) {
                                            }
                                            QlinkShareJumpActivity.this.f390457d0 = false;
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
                                            QlinkShareJumpActivity.this.f390457d0 = false;
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
                                        QLog.w("qqBaseActivity", 2, "resolve file error", e);
                                    }
                                    QlinkShareJumpActivity.this.f390458e0.sendEmptyMessage(1);
                                    if (bArr2 != null) {
                                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                                    }
                                    QlinkShareJumpActivity.this.f390457d0 = false;
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
                                    QlinkShareJumpActivity.this.f390457d0 = false;
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
                            QlinkShareJumpActivity.this.f390458e0.sendEmptyMessage(1);
                        }
                        try {
                            if (QlinkShareJumpActivity.this.f390457d0) {
                                MqqHandler mqqHandler2 = QlinkShareJumpActivity.this.f390458e0;
                                mqqHandler2.sendMessage(mqqHandler2.obtainMessage(3, 100, 0));
                                QlinkShareJumpActivity.this.f390458e0.sendEmptyMessageDelayed(2, 200L);
                            } else {
                                IOUtils.closeQuietly(fileOutputStream);
                                file.delete();
                            }
                            if (bArr != null) {
                                ByteArrayPool.getGenericInstance().returnBuf(bArr);
                            }
                            QlinkShareJumpActivity.this.f390457d0 = false;
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
                            QlinkShareJumpActivity.this.f390458e0.sendEmptyMessage(1);
                            if (bArr2 != null) {
                            }
                            QlinkShareJumpActivity.this.f390457d0 = false;
                            inputStream.close();
                            if (fileOutputStream != null) {
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            bArr2 = bArr;
                            th5 = th;
                            if (bArr2 != null) {
                            }
                            QlinkShareJumpActivity.this.f390457d0 = false;
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
        if (this.f390459f0 == null) {
            QQCustomDialog createCustomProgressDialog = DialogUtil.createCustomProgressDialog(this, getString(R.string.aex), HardCodeUtil.qqStr(R.string.j6l), new d());
            this.f390459f0 = createCustomProgressDialog;
            createCustomProgressDialog.setOnDismissListener(new e());
        }
        this.f390459f0.show();
    }

    private static void J2(String str) {
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

    private String K2(Uri uri) {
        return FileProvider7Helper.getRealPathFromContentURI(this, uri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010c  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String L2(Uri uri) {
        Cursor cursor;
        ContentResolver contentResolver = getContentResolver();
        String[] strArr = new String[1];
        ?? r122 = 0;
        try {
            try {
                cursor = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r122 != 0) {
                }
                throw th;
            }
            try {
                if (cursor == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("qqBaseActivity", 2, "query file failed");
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
                    this.f390456c0 = getString(R.string.hiw);
                    cursor.close();
                    return null;
                }
                strArr[0] = cursor.getString(columnIndexOrThrow);
                String str = getExternalCacheDir() + "/qlink_share/";
                J2(str);
                String str2 = str + FileUtils.getUnitFileName(str, strArr[0]);
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    this.f390456c0 = HardCodeUtil.qqStr(R.string.qj_);
                    cursor.close();
                    return null;
                }
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("qqBaseActivity", 2, "open input stream failed");
                    }
                    this.f390456c0 = HardCodeUtil.qqStr(R.string.qjc);
                    cursor.close();
                    return null;
                }
                if (j3 > 209715200) {
                    this.f390456c0 = HardCodeUtil.qqStr(R.string.qj9);
                    try {
                        openInputStream.close();
                    } catch (Exception unused) {
                    }
                    cursor.close();
                    return null;
                }
                I2(str2, openInputStream, j3);
                cursor.close();
                return str2;
            } catch (Exception e17) {
                e = e17;
                this.f390457d0 = false;
                if (QLog.isColorLevel()) {
                    QLog.w("qqBaseActivity", 2, "query file error", e);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            r122 = contentResolver;
            if (r122 != 0) {
                r122.close();
            }
            throw th;
        }
    }

    private boolean M2(boolean z16) {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (BaseGesturePWDUtil.getJumpLock(this, this.app.getCurrentAccountUin())) {
            if (z16 || !BaseGesturePWDUtil.getAppForground(this)) {
                Intent intent2 = new Intent(getActivity(), (Class<?>) GesturePWDUnlockActivity.class);
                intent2.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_JUMPACTIVITY, true);
                intent2.setAction(intent.getAction());
                intent2.putExtra("isActionSend", true);
                intent2.putExtras(extras);
                intent2.putExtras(intent);
                startActivityForResult(intent2, 4097);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean N2() {
        Intent intent = getIntent();
        if (intent.getExtras() == null) {
            new Bundle();
        }
        if (this.app.isLogin()) {
            return false;
        }
        Intent intent2 = new Intent();
        intent2.addFlags(67371008);
        ArrayList<String> arrayList = this.f390460g0;
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("qlink_share_filepaths", this.f390460g0);
        }
        intent2.putExtra("qlink_share_intent_data", intent);
        intent2.putExtra("from_register_guide", true);
        RouteUtils.startActivity(this, intent2, RouterConstants.UI_ROUTER_LOGIN);
        finish();
        overridePendingTransition(0, 0);
        return true;
    }

    private void P2() {
        ArrayList<String> arrayList = this.f390460g0;
        if (arrayList != null && arrayList.size() > 0) {
            this.app.getQQProxyForQlink().B("0X8004F47", this.f390460g0.size());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("string_filepaths", this.f390460g0);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
            bundle.putInt("string_beforeshare_selectedfile_count", arrayList2.size());
            QQProxyForQlink.P(this, 10, bundle);
            finish();
            return;
        }
        DialogUtil.createCustomDialog(this, 230, getString(R.string.f4d), getString(R.string.f5l), R.string.f47, R.string.f47, new f(), (DialogInterface.OnClickListener) null).show();
    }

    private void Q2() {
        boolean z16;
        boolean z17 = false;
        if (this.f390455b0 == null) {
            S2(false);
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z18 = true;
        if (this.f390454a0.equals("android.intent.action.SEND")) {
            Uri uri = (Uri) this.f390455b0.get("android.intent.extra.STREAM");
            if (uri != null) {
                String K2 = K2(uri);
                if (!TextUtils.isEmpty(K2) && q.p(K2) && new File(K2).canRead()) {
                    z18 = false;
                } else {
                    K2 = L2(uri);
                }
                if (!TextUtils.isEmpty(K2)) {
                    arrayList.add(K2);
                }
            } else {
                z18 = false;
            }
            z16 = false;
            z17 = z18;
        } else {
            ArrayList arrayList2 = (ArrayList) this.f390455b0.get("android.intent.extra.STREAM");
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                z16 = false;
                while (it.hasNext()) {
                    String K22 = K2((Uri) it.next());
                    if (q.p(K22)) {
                        arrayList.add(K22);
                    } else {
                        z16 = true;
                    }
                }
            } else {
                z16 = false;
            }
        }
        if (arrayList.size() == 0) {
            S2(z16);
            return;
        }
        this.f390460g0.addAll(arrayList);
        if (!z17) {
            startShare();
        }
    }

    private void R2(String str) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(getString(R.string.f173206i10));
        qQCustomDialog.setMessage(str);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setNegativeButton(getString(R.string.button_back), new c());
        qQCustomDialog.show();
    }

    private void S2(boolean z16) {
        int i3;
        if (z16) {
            i3 = R.string.f5k;
        } else {
            i3 = R.string.f5l;
        }
        DialogUtil.createCustomDialog(this, 230, getString(R.string.f4d), getString(i3), R.string.f47, R.string.f47, new a(), (DialogInterface.OnClickListener) null).show();
    }

    private void dismissDialog() {
        QQCustomDialog qQCustomDialog = this.f390459f0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    private void startShare() {
        if (this.f390460g0.size() > 50) {
            DialogUtil.createCustomDialog(this, 230, getString(R.string.f4d), getString(R.string.f4h), R.string.f47, R.string.f47, new b(), (DialogInterface.OnClickListener) null).show();
        } else {
            if (N2() || M2(false)) {
                return;
            }
            P2();
        }
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
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 == 4097) {
                P2();
                return;
            } else {
                finish();
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.f390454a0 = intent.getAction();
                this.f390455b0 = intent.getExtras();
                if (!TextUtils.isEmpty(this.f390454a0) && (this.f390454a0.equals("android.intent.action.SEND") || this.f390454a0.equals("android.intent.action.SEND_MULTIPLE"))) {
                    if (intent.getBooleanExtra("qlink_share_login_suc_flag", false)) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("qlink_share_filepaths");
                        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                            Iterator<String> it = stringArrayListExtra.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                if (q.p(next)) {
                                    if (this.f390460g0 == null) {
                                        this.f390460g0 = new ArrayList<>();
                                    }
                                    this.f390460g0.add(next);
                                }
                            }
                        }
                        if (!M2(true)) {
                            P2();
                        }
                    } else {
                        Q2();
                    }
                    return true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("qqBaseActivity", 1, "QlinkShareJumpActivity doOnCreate exp");
            }
        }
        finish();
        overridePendingTransition(0, 0);
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f390459f0.setProgress(message.arg1);
                    return false;
                }
                return false;
            }
            dismissDialog();
            startShare();
            return false;
        }
        dismissDialog();
        Object obj = message.obj;
        if (obj != null && (obj instanceof String)) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f390456c0;
        }
        R2(str);
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
