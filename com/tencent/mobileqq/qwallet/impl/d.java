package com.tencent.mobileqq.qwallet.impl;

import Wallet.ReportHBGameReq;
import Wallet.ReportHBGameRsp;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipIOException;
import com.tencent.mobileqq.qwallet.impl.servlet.request.ReportHBGameRequest;
import com.tencent.mobileqq.qwallet.utils.j;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Comparator<File> {
        a() {
        }

        private int b(String str) {
            int parseInt;
            try {
                int lastIndexOf = str.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    parseInt = Integer.parseInt(str);
                } else {
                    parseInt = Integer.parseInt(str.substring(0, lastIndexOf));
                }
                return parseInt;
            } catch (Exception unused) {
                return 0;
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return b(file.getName()) - b(file2.getName());
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements BusinessObserver {
        b() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            ReportHBGameRsp reportHBGameRsp = (ReportHBGameRsp) bundle.getSerializable("rsp");
            if (QLog.isColorLevel()) {
                QLog.d("QWalletTools", 2, "ReportHBGameRsp reportObserver:" + z16 + "|" + reportHBGameRsp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private float f278228d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f278229e;

        c(float f16) {
            this.f278229e = f16;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f278228d = view.getAlpha();
                view.setAlpha(this.f278229e);
                return false;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (motionEvent.getAction() == 2) {
                    if (!d.q(view, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        view.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            view.setAlpha(this.f278228d);
            return false;
        }
    }

    public static boolean A(String str, String str2) {
        return B(str, str2, false);
    }

    public static boolean B(String str, String str2, boolean z16) {
        File file = new File(str);
        QZipFile qZipFile = null;
        try {
            QZipFile qZipFile2 = new QZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile2.entries();
                while (entries.hasMoreElements()) {
                    D(qZipFile2, entries.nextElement(), str2, z16);
                }
                try {
                    qZipFile2.close();
                } catch (Throwable th5) {
                    QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", th5);
                }
                return true;
            } catch (Throwable th6) {
                th = th6;
                qZipFile = qZipFile2;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.e("QWallet.unzip", 2, "Error while extracting file " + file + th);
                    }
                    if (qZipFile != null) {
                        try {
                            qZipFile.close();
                            return false;
                        } catch (Throwable th7) {
                            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", th7);
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th8) {
                    if (qZipFile != null) {
                        try {
                            qZipFile.close();
                        } catch (Throwable th9) {
                            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    public static boolean C(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        String str3 = str + "Tmp";
        File file2 = new File(str3);
        QLog.d("QWalletTools", 2, "unzipAtomically1" + file + file.exists() + file2 + file2.exists());
        FileUtils.delete(str3, false);
        if (QLog.isColorLevel()) {
            QLog.d("QWalletTools", 2, "unzipAtomically2" + file + file.exists() + file2 + file2.exists());
        }
        if (QLog.isColorLevel() && !file.exists()) {
            try {
                FileUtils.writeFile(new byte[]{0, 0}, str);
                QLog.d("QWalletTools", 2, "3." + file + file.exists());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("intern");
                e(sb5.toString(), false, file);
                QLog.d("QWalletTools", 2, "4." + file + file.exists());
                FileUtils.writeFile(new byte[]{0, 0}, str);
                QLog.d("QWalletTools", 2, "0." + file + file.exists());
                e(str3, false, file);
                QLog.d("QWalletTools", 2, "2." + file + file.exists());
            } catch (Throwable th5) {
                QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", th5);
            }
        }
        if (!A(str, str3) || !file2.exists()) {
            return false;
        }
        File file3 = new File(str2);
        FileUtils.delete(str2, false);
        if (!FileUtils.renameFile(file2, file3) || !file3.exists()) {
            return false;
        }
        return true;
    }

    private static void D(ZipFile zipFile, ZipEntry zipEntry, String str, boolean z16) throws IOException {
        String str2;
        String i3 = i(zipEntry);
        if (zipEntry.isDirectory()) {
            b(new File(str, i3));
            return;
        }
        if (z16) {
            str2 = i3 + "tmp";
        } else {
            str2 = i3;
        }
        File file = new File(str, str2);
        if (!file.getParentFile().exists()) {
            b(file.getParentFile());
        }
        if (QLog.isDebugVersion()) {
            QLog.i("QWallet.unzip", 4, "Extracting: " + zipEntry);
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                } else {
                    bufferedOutputStream.write(bArr, 0, read);
                }
            }
            bufferedOutputStream.flush();
        } finally {
            bufferedOutputStream.close();
            bufferedInputStream.close();
            if (z16) {
                FileUtils.renameFile(file, new File(str, i3));
            }
        }
    }

    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    private static void b(File file) {
        if (file.exists()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QWallet.unzip", 2, "Creating dir " + file.getName());
        }
        if (file.mkdirs()) {
            return;
        }
        throw new RuntimeException("Can not create dir " + file);
    }

    public static String c(Context context, String str, float f16, TextPaint textPaint) {
        if (f16 == 0.0f) {
            return str;
        }
        float c16 = x.c(context, f16);
        if (textPaint.measureText(str) <= c16) {
            return str;
        }
        for (int length = str.length(); length > 0; length--) {
            String substring = str.substring(0, length - 1);
            if (textPaint.measureText(substring + MiniBoxNoticeInfo.APPNAME_SUFFIX) <= c16) {
                return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
        }
        return str;
    }

    public static void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                FileUtils.delete(str, false);
            }
        } catch (Throwable th5) {
            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", th5);
        }
    }

    public static void e(String str, boolean z16, File file) {
        QLog.d("QWalletTools", 2, "1.0 delete " + str + z16 + file + file.exists());
        if (str == null) {
            return;
        }
        File file2 = new File(str);
        QLog.d("QWalletTools", 2, "1.0 delete tag0" + file2 + file2.exists());
        if (!file2.exists()) {
            QLog.d("QWalletTools", 2, "1.0 delete tag1" + file.exists());
            return;
        }
        if (file2.isFile()) {
            QLog.d("QWalletTools", 2, "1.0 delete tag2" + file2 + file2.exists() + file.exists());
            file2.delete();
            QLog.d("QWalletTools", 2, "1.0 delete tag3" + file2 + file2.exists() + file.exists());
            return;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null) {
            QLog.d("QWalletTools", 2, "1.0 delete tag4" + file.exists());
            return;
        }
        for (File file3 : listFiles) {
            QLog.d("QWalletTools", 2, "1.0 delete tag5" + file3 + file.exists());
            e(file3.getAbsolutePath(), z16, file);
            QLog.d("QWalletTools", 2, "1.0 delete tag6" + file3 + file.exists());
        }
        if (!z16) {
            QLog.d("QWalletTools", 2, "1.0 delete tag7" + file2 + file.exists());
            file2.delete();
            QLog.d("QWalletTools", 2, "1.0 delete tag8" + file2 + file.exists());
        }
    }

    public static View.OnTouchListener f(float f16) {
        return new c(f16);
    }

    public static AppRuntime g() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static String h() {
        return g().getCurrentUin();
    }

    public static String i(ZipEntry zipEntry) throws QZipIOException {
        if (!QZipIOException.isInvalidEntry(zipEntry)) {
            return zipEntry.getName();
        }
        throw new QZipIOException();
    }

    public static long j(String str) {
        return k(str, -1L);
    }

    public static long k(String str, long j3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (TextUtils.isEmpty(str)) {
            return j3;
        }
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("QWalletTools", 2, "getFormatTime exception|" + str);
                return j3;
            }
            return j3;
        }
    }

    public static int l(Map<String, String> map, String str, int i3) {
        if (map != null && map.containsKey(str)) {
            return x05.c.j(map.get(str), i3);
        }
        return i3;
    }

    public static String m(Map<String, String> map, String str, String str2) {
        if (map != null && map.containsKey(str)) {
            return map.get(str);
        }
        return str2;
    }

    public static BaseQQAppInterface n() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof BaseQQAppInterface)) {
            return null;
        }
        return (BaseQQAppInterface) waitAppRuntime;
    }

    public static String o() {
        String str = j.f279283b;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static void p(AppInterface appInterface, String str, String str2, String str3, ResultReceiver resultReceiver) {
        if (QLog.isColorLevel()) {
            QLog.d("QWalletTools", 2, "GrapHbWithParam params:" + str + ",gameid:" + str2 + ",score:" + str3);
        }
        if (appInterface == null) {
            return;
        }
        try {
            String str4 = "gameid=" + str2 + "&point=" + str3;
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("feedsid", str4);
            Bundle bundle = new Bundle();
            bundle.putString("extra_data", jSONObject.toString());
            bundle.putString("callbackSn", "0");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 22);
            Parcel obtain = Parcel.obtain();
            resultReceiver.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            bundle2.putParcelable(IPayLogic.RECEIVER_COM_KEY, resultReceiver2);
            bundle2.putBundle("_qwallet_payparams_data", bundle);
            bundle2.putString("_qwallet_payparams_tag", "graphb");
            QWalletPayBridge.launchBackground(BaseApplication.getContext(), bundle2);
        } catch (Throwable th5) {
            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", th5);
        }
    }

    public static boolean q(View view, float f16, float f17) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int height = view.getHeight() + i3;
        int i16 = iArr[0];
        int width = view.getWidth() + i16;
        if (f17 >= i3 && f17 < height && f16 > i16 && f16 < width) {
            return true;
        }
        return false;
    }

    public static boolean r(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 == null) {
            return false;
        }
        if (str == null && str2 != null) {
            return false;
        }
        return str.equals(str2);
    }

    public static HashMap<String, String> s(String str) {
        try {
            return t(new JSONObject(str));
        } catch (Exception e16) {
            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e16);
            return new HashMap<>();
        }
    }

    public static HashMap<String, String> t(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
        } catch (Exception e16) {
            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e16);
        }
        return hashMap;
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Utils.e(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e16) {
            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e16);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a A[Catch: IOException -> 0x0096, TryCatch #3 {IOException -> 0x0096, blocks: (B:52:0x0092, B:41:0x009a, B:43:0x009f, B:45:0x00a4), top: B:51:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f A[Catch: IOException -> 0x0096, TryCatch #3 {IOException -> 0x0096, blocks: (B:52:0x0092, B:41:0x009a, B:43:0x009f, B:45:0x00a4), top: B:51:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4 A[Catch: IOException -> 0x0096, TRY_LEAVE, TryCatch #3 {IOException -> 0x0096, blocks: (B:52:0x0092, B:41:0x009a, B:43:0x009f, B:45:0x00a4), top: B:51:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c6 A[Catch: IOException -> 0x00c2, TryCatch #16 {IOException -> 0x00c2, blocks: (B:69:0x00be, B:58:0x00c6, B:60:0x00cb, B:62:0x00d0), top: B:68:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb A[Catch: IOException -> 0x00c2, TryCatch #16 {IOException -> 0x00c2, blocks: (B:69:0x00be, B:58:0x00c6, B:60:0x00cb, B:62:0x00d0), top: B:68:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d0 A[Catch: IOException -> 0x00c2, TRY_LEAVE, TryCatch #16 {IOException -> 0x00c2, blocks: (B:69:0x00be, B:58:0x00c6, B:60:0x00cb, B:62:0x00d0), top: B:68:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object v(String str) throws Exception {
        ?? r46;
        Object obj;
        Object obj2;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        Exception e16;
        Object obj3;
        ObjectInputStream objectInputStream2;
        ?? r65;
        ObjectInputStream objectInputStream3 = null;
        try {
            try {
                File file = new File((String) str);
                if (!file.exists()) {
                    return null;
                }
                str = new FileInputStream(file);
                try {
                    r46 = new ByteArrayOutputStream();
                } catch (Exception e17) {
                    e = e17;
                    obj2 = null;
                    e16 = e;
                    QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e16);
                    throw e16;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    r46 = null;
                    obj = str;
                    objectInputStream = r46;
                    obj3 = obj;
                    objectInputStream2 = objectInputStream;
                    r65 = objectInputStream;
                    str = obj3;
                    try {
                        QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e);
                        if (objectInputStream2 != null) {
                        }
                        if (r65 != 0) {
                        }
                        if (r46 != null) {
                        }
                        if (str != 0) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        objectInputStream3 = objectInputStream2;
                        ByteArrayInputStream byteArrayInputStream2 = r65;
                        th = th5;
                        byteArrayInputStream = byteArrayInputStream2;
                        if (objectInputStream3 != null) {
                            try {
                                objectInputStream3.close();
                            } catch (IOException e19) {
                                QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e19);
                                throw th;
                            }
                        }
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        if (r46 != null) {
                            r46.close();
                        }
                        if (str != 0) {
                            str.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r46 = null;
                    str = str;
                    th = th;
                    byteArrayInputStream = r46;
                    if (objectInputStream3 != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    if (r46 != null) {
                    }
                    if (str != 0) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = str.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        r46.write(bArr, 0, read);
                    }
                    ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(r46.toByteArray());
                    try {
                        ObjectInputStream objectInputStream4 = new ObjectInputStream(byteArrayInputStream3);
                        try {
                            Object readObject = objectInputStream4.readObject();
                            try {
                                objectInputStream4.close();
                                byteArrayInputStream3.close();
                                r46.close();
                                str.close();
                            } catch (IOException e26) {
                                QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e26);
                            }
                            return readObject;
                        } catch (Exception e27) {
                            e16 = e27;
                            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e16);
                            throw e16;
                        } catch (OutOfMemoryError e28) {
                            r65 = byteArrayInputStream3;
                            e = e28;
                            objectInputStream2 = objectInputStream4;
                            str = str;
                            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e);
                            if (objectInputStream2 != null) {
                            }
                            if (r65 != 0) {
                            }
                            if (r46 != null) {
                            }
                            if (str != 0) {
                            }
                            return null;
                        } catch (Throwable th7) {
                            th = th7;
                            objectInputStream3 = objectInputStream4;
                            byteArrayInputStream = byteArrayInputStream3;
                            if (objectInputStream3 != null) {
                            }
                            if (byteArrayInputStream != null) {
                            }
                            if (r46 != null) {
                            }
                            if (str != 0) {
                            }
                            throw th;
                        }
                    } catch (Exception e29) {
                        e16 = e29;
                    } catch (OutOfMemoryError e36) {
                        objectInputStream2 = null;
                        r65 = byteArrayInputStream3;
                        e = e36;
                        str = str;
                    }
                } catch (Exception e37) {
                    e16 = e37;
                } catch (OutOfMemoryError e38) {
                    e = e38;
                    objectInputStream = null;
                    obj3 = str;
                    objectInputStream2 = objectInputStream;
                    r65 = objectInputStream;
                    str = obj3;
                    QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e);
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e39) {
                            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e39);
                            return null;
                        }
                    }
                    if (r65 != 0) {
                        r65.close();
                    }
                    if (r46 != null) {
                        r46.close();
                    }
                    if (str != 0) {
                        str.close();
                    }
                    return null;
                } catch (Throwable th8) {
                    th = th8;
                    byteArrayInputStream = null;
                }
            } catch (Exception e46) {
                e = e46;
                obj2 = null;
            } catch (OutOfMemoryError e47) {
                e = e47;
                obj = null;
                r46 = null;
            } catch (Throwable th9) {
                th = th9;
                str = 0;
                r46 = null;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    public static void w(String str, long j3, String str2, int i3, boolean z16, boolean z17, int i16) {
        ReportHBGameReq reportHBGameReq = new ReportHBGameReq();
        reportHBGameReq.sHBId = str;
        reportHBGameReq.lUin = j3;
        reportHBGameReq.sPoint = str2;
        reportHBGameReq.iAmount = i3;
        reportHBGameReq.bSucc = z16;
        reportHBGameReq.bStart = z17;
        reportHBGameReq.iGameId = i16;
        com.tencent.mobileqq.qwallet.impl.servlet.c.c(new ReportHBGameRequest(reportHBGameReq), new b());
    }

    public static void x(Object obj, String str) {
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                }
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    fileOutputStream.close();
                } catch (Throwable th7) {
                    th = th7;
                    objectOutputStream2 = objectOutputStream;
                    try {
                        QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", th);
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th8) {
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (IOException e16) {
                                QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e16);
                                throw th8;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th8;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                fileOutputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (IOException e17) {
            QLog.e("QWalletTools", 1, "error msg in qqpay-impl module: ", e17);
        }
    }

    public static void y(View view, float f16) {
        if (view != null) {
            view.setOnTouchListener(f(f16));
        }
    }

    public static void z(File[] fileArr) {
        Arrays.sort(fileArr, new a());
    }
}
