package com.qwallet.activity.sso;

import android.app.Activity;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qwallet.activity.QWalletAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class QWalletBaseProtocol {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f41388a;

    /* renamed from: b, reason: collision with root package name */
    private int f41389b;

    /* renamed from: com.qwallet.activity.sso.QWalletBaseProtocol$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f41395d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f41396e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object[] f41397f;
        final /* synthetic */ QWalletBaseProtocol this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f41395d || !this.this$0.m() || !this.this$0.k(this.f41396e)) {
                this.this$0.u(this.f41396e, this.f41397f);
            }
        }
    }

    private void p(int i3, boolean z16, boolean z17, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.i("QWalletBaseProtocol", 2, "cmd[" + d() + "]notify ui update from cache" + z17);
        }
        QWalletAppInterface.getInstance().notifyUI(i3, i(), z16, z17, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3, Object... objArr) {
        v(i3, d(), g(objArr));
    }

    private void v(int i3, String str, HashMap<String, Object> hashMap) {
        if (QLog.isColorLevel()) {
            QLog.i("QWalletBaseProtocol", 2, "cmd[" + d() + "]send request,params=" + hashMap);
        }
        this.f41388a = hashMap;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), str);
            if (hashMap != null) {
                toServiceMsg.setAttributes(hashMap);
            }
            NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, e.class);
            newIntent.putExtra(ToServiceMsg.class.getName(), toServiceMsg);
            newIntent.putExtra("id", f());
            newIntent.putExtra(QCircleQualityReporter.KEY_ID, i3);
            MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(newIntent);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("QWalletBaseProtocol", 2, "cmd[" + d() + "]send request failed");
            }
            QLog.e("QWalletBaseProtocol", 1, "", e16);
        }
    }

    public abstract String b();

    protected File c() {
        return MobileQQ.sMobileQQ.getFilesDir();
    }

    public abstract String d();

    /* JADX WARN: Removed duplicated region for block: B:47:0x00a0 A[Catch: Exception -> 0x009c, TRY_LEAVE, TryCatch #1 {Exception -> 0x009c, blocks: (B:54:0x0098, B:47:0x00a0), top: B:53:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String e(int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        String str;
        FileInputStream fileInputStream2 = null;
        try {
            if (i3 == -1) {
                str = b();
            } else {
                str = b() + "_" + i3;
            }
            File file = new File(c(), str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e16) {
                e = e16;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream3.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str2 = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                try {
                    fileInputStream3.close();
                    byteArrayOutputStream.close();
                } catch (Exception e17) {
                    QLog.e("QWalletBaseProtocol", 1, "", e17);
                }
                return str2;
            } catch (Exception e18) {
                e = e18;
                Exception exc = e;
                fileInputStream = fileInputStream3;
                e = exc;
                try {
                    QLog.e("QWalletBaseProtocol", 1, "", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e19) {
                            QLog.e("QWalletBaseProtocol", 1, "", e19);
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e26) {
                            QLog.e("QWalletBaseProtocol", 1, "", e26);
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                fileInputStream2 = fileInputStream3;
                th = th;
                if (fileInputStream2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e27) {
            e = e27;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
        }
    }

    public abstract int f();

    public abstract HashMap<String, Object> g(Object... objArr);

    public abstract Class<?> h();

    public abstract int i();

    public abstract void j(ToServiceMsg toServiceMsg, Packet packet);

    public boolean k(int i3) {
        String str;
        Object obj;
        try {
            if (i3 == -1) {
                str = b();
            } else {
                str = b() + "_" + i3;
            }
        } catch (Throwable th5) {
            QLog.e("QWalletBaseProtocol", 1, "", th5);
        }
        if (!new File(c(), str + "_").exists()) {
            return false;
        }
        byte[] t16 = t(i3);
        if (t16 != null && t16.length > 0) {
            JceInputStream jceInputStream = new JceInputStream(t16);
            jceInputStream.setServerEncoding("utf-8");
            JceStruct jceStruct = (JceStruct) h().newInstance();
            jceStruct.readFrom(jceInputStream);
            obj = jceStruct;
        } else {
            String e16 = e(i3);
            if (TextUtils.isEmpty(e16)) {
                return false;
            }
            obj = r(new JSONObject(e16));
        }
        if (obj != null) {
            p(i3, true, true, obj);
            return true;
        }
        return false;
    }

    public abstract Object l(FromServiceMsg fromServiceMsg);

    public abstract boolean m();

    public boolean n() {
        return false;
    }

    public int o() {
        return 3;
    }

    public void q(final int i3, FromServiceMsg fromServiceMsg) {
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (QLog.isColorLevel()) {
            QLog.i("QWalletBaseProtocol", 2, "cmd[" + d() + "]receive is success:" + isSuccess);
        }
        if (isSuccess) {
            try {
                final Object l3 = l(fromServiceMsg);
                if (l3 != null && (l3 instanceof JceStruct) && m()) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.qwallet.activity.sso.QWalletBaseProtocol.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            JceOutputStream jceOutputStream = new JceOutputStream();
                            try {
                                jceOutputStream.setServerEncoding("utf-8");
                                JceStruct s16 = QWalletBaseProtocol.this.s((JceStruct) l3);
                                if (s16 == null) {
                                    return;
                                }
                                s16.writeTo(jceOutputStream);
                                if (i3 == -1) {
                                    str = QWalletBaseProtocol.this.b();
                                } else {
                                    str = QWalletBaseProtocol.this.b() + "_" + i3;
                                }
                                FileUtils.writeFile(jceOutputStream.toByteArray(), new File(QWalletBaseProtocol.this.c(), str + "_").getAbsolutePath());
                            } catch (Exception e16) {
                                QLog.e("QWalletBaseProtocol", 1, "", e16);
                            }
                        }
                    }, 10, null, true);
                }
                p(i3, true, false, l3);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.i("QWalletBaseProtocol", 2, "cmd[" + d() + "]handleResponse failed,may resp error");
                }
                QLog.e("QWalletBaseProtocol", 1, "", th5);
                isSuccess = false;
            }
        }
        if (!isSuccess) {
            if (n()) {
                int i16 = this.f41389b;
                this.f41389b = i16 + 1;
                if (i16 < o()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QWalletBaseProtocol", 2, "cmd[" + d() + "]try sendRequest, tryNum" + this.f41389b);
                    }
                    v(i3, d(), this.f41388a);
                    return;
                }
                p(i3, false, false, null);
                return;
            }
            p(i3, false, false, null);
        }
    }

    public abstract Object r(JSONObject jSONObject) throws Exception;

    /* JADX WARN: Removed duplicated region for block: B:47:0x00af A[Catch: Exception -> 0x00ab, TRY_LEAVE, TryCatch #3 {Exception -> 0x00ab, blocks: (B:54:0x00a7, B:47:0x00af), top: B:53:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected byte[] t(int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        FileInputStream fileInputStream2 = null;
        try {
            if (i3 == -1) {
                str = b();
            } else {
                str = b() + "_" + i3;
            }
            File file = new File(c(), str + "_");
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e16) {
                byteArrayOutputStream2 = null;
                fileInputStream = fileInputStream3;
                e = e16;
            } catch (Throwable th5) {
                fileInputStream2 = fileInputStream3;
                th = th5;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream3.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    fileInputStream3.close();
                    byteArrayOutputStream.close();
                } catch (Exception e17) {
                    QLog.e("QWalletBaseProtocol", 1, "", e17);
                }
                return byteArray;
            } catch (Exception e18) {
                fileInputStream = fileInputStream3;
                e = e18;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    QLog.e("QWalletBaseProtocol", 1, "", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e19) {
                            QLog.e("QWalletBaseProtocol", 1, "", e19);
                            return null;
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e26) {
                            QLog.e("QWalletBaseProtocol", 1, "", e26);
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                fileInputStream2 = fileInputStream3;
                th = th7;
                if (fileInputStream2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e27) {
            e = e27;
            fileInputStream = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
        }
    }

    public void w(int i3, boolean z16, String str, Object... objArr) {
        x(null, i3, z16, str, objArr);
    }

    public void x(Activity activity, final int i3, final boolean z16, String str, final Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.i("QWalletBaseProtocol", 2, "cmd[" + d() + "] sendRequest");
        }
        this.f41389b = 0;
        ThreadManagerV2.post(new Runnable() { // from class: com.qwallet.activity.sso.QWalletBaseProtocol.2
            @Override // java.lang.Runnable
            public void run() {
                if (z16 || !QWalletBaseProtocol.this.m() || !QWalletBaseProtocol.this.k(i3)) {
                    QWalletBaseProtocol.this.u(i3, objArr);
                }
            }
        }, 10, null, true);
    }

    public void y(Activity activity, boolean z16, String str, Object... objArr) {
        x(activity, -1, z16, str, objArr);
    }

    public JceStruct s(JceStruct jceStruct) {
        return jceStruct;
    }
}
