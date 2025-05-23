package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.oskplayer.cache.FileDataSink;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class PreloadManager {

    /* renamed from: m, reason: collision with root package name */
    private static PreloadManager f80165m;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f80169d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f80170e;

    /* renamed from: a, reason: collision with root package name */
    public final String f80166a = "ReadInJoyArticleDetailPreloadManager";

    /* renamed from: b, reason: collision with root package name */
    private List<String> f80167b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<String> f80168c = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public Object f80171f = new Object();

    /* renamed from: g, reason: collision with root package name */
    ArrayList<a> f80172g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    Object f80173h = new Object();

    /* renamed from: i, reason: collision with root package name */
    Object f80174i = new Object();

    /* renamed from: k, reason: collision with root package name */
    private MQLruCache<String, byte[]> f80176k = new MQLruCache<>(30);

    /* renamed from: l, reason: collision with root package name */
    private volatile HashMap<String, ArrayList<a>> f80177l = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    Handler f80175j = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.biz.pubaccount.util.PreloadManager$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 extends BaseThread {
        final /* synthetic */ PreloadManager this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.this$0.f80176k != null) {
                this.this$0.f80176k.releaseLargeCache();
            }
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (currentTimeMillis - file2.lastModified() > 172800000) {
                        file2.delete();
                    }
                }
            }
            File file3 = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE);
            if (file3.exists() && file3.isDirectory()) {
                for (File file4 : file3.listFiles()) {
                    if (currentTimeMillis - file4.lastModified() > 172800000) {
                        file4.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class FeedslistDownlaodImageThread implements Runnable {
        FeedslistDownlaodImageThread() {
        }

        a e() {
            synchronized (PreloadManager.this.f80171f) {
                for (int i3 = 3; i3 > 0; i3--) {
                    for (ArrayList arrayList : PreloadManager.this.f80177l.values()) {
                        if (arrayList != null && arrayList.size() != 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                a aVar = (a) it.next();
                                if (aVar == null) {
                                    return null;
                                }
                                if (PreloadManager.x(aVar.f80181a) == 0 && aVar.f80182b == i3) {
                                    return aVar;
                                }
                            }
                        }
                        return null;
                    }
                }
                return null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            PreloadManager.this.f80170e = true;
            while (true) {
                a e16 = e();
                if (e16 != null) {
                    if (NetworkState.getNetworkType() != 1) {
                        return;
                    } else {
                        PreloadManager.this.v(e16.f80181a);
                    }
                } else {
                    PreloadManager.this.f80170e = false;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class PreloadThread implements Runnable {
        PreloadThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = PreloadManager.this.f80167b.iterator();
            while (it.hasNext()) {
                PreloadManager.this.j((String) it.next());
            }
            synchronized (PreloadManager.this.f80173h) {
                PreloadManager.this.f80167b.clear();
                if (PreloadManager.this.f80168c.size() > 0) {
                    PreloadManager.this.C();
                } else {
                    PreloadManager.this.f80169d = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class ReadFileThread implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f80178d;

        /* renamed from: e, reason: collision with root package name */
        String f80179e;

        /* renamed from: f, reason: collision with root package name */
        boolean f80180f = false;

        public ReadFileThread(String str, String str2) {
            this.f80178d = str;
            this.f80179e = str2;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0154 -> B:59:0x01b5). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        public void run() {
            String q16 = PreloadManager.q(this.f80178d);
            if (q16 == null) {
                return;
            }
            this.f80180f = this.f80178d.startsWith("https");
            byte[] bArr = (byte[]) PreloadManager.this.f80176k.get(q16);
            if (bArr == null) {
                File file = new File(new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD), q16);
                if (file.exists() && System.currentTimeMillis() - file.lastModified() < 2400000) {
                    FileInputStream fileInputStream = null;
                    try {
                        try {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "ReadFileThread \u6b64\u65f6\u5f00\u59cb\u5c06\u6587\u4ef6\u8bfb\u5165\u5185\u5b58" + System.currentTimeMillis());
                                }
                                FileInputStream fileInputStream2 = new FileInputStream(file);
                                try {
                                    byte[] bArr2 = new byte[fileInputStream2.available()];
                                    fileInputStream2.read(bArr2);
                                    fileInputStream2.close();
                                    byte[] h16 = PreloadManager.h(PreloadManager.w(this.f80179e), bArr2);
                                    if (h16 != null) {
                                        String str = new String(h16);
                                        String substring = str.substring(str.lastIndexOf("articleId") + 10, str.length());
                                        if (QLog.isColorLevel()) {
                                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "ReadFileThread \u5f53\u524d\u7684articleID\u4e3a" + substring);
                                        }
                                        if (!q16.equals(substring)) {
                                            try {
                                                fileInputStream2.close();
                                                return;
                                            } catch (IOException e16) {
                                                e16.printStackTrace();
                                                return;
                                            }
                                        }
                                        String substring2 = str.substring(0, str.lastIndexOf("articleId"));
                                        synchronized (PreloadManager.this.f80174i) {
                                            PreloadManager.this.f80176k.put((MQLruCache) q16, (String) substring2.getBytes());
                                        }
                                        new ArrayList();
                                        ArrayList t16 = PreloadManager.this.t(substring2, this.f80180f);
                                        synchronized (PreloadManager.this.f80171f) {
                                            PreloadManager.this.f80177l.put(q16, t16);
                                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "input from ReadFileThread articleId" + q16);
                                        }
                                        if (!PreloadManager.this.f80170e && NetworkState.getNetworkType() == 1 && PreloadManager.this.u()) {
                                            PreloadManager.this.m();
                                        }
                                    }
                                    fileInputStream2.close();
                                } catch (IOException e17) {
                                    e = e17;
                                    fileInputStream = fileInputStream2;
                                    e.printStackTrace();
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e18) {
                                            e18.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (IOException e19) {
                            e = e19;
                        }
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    return;
                }
                return;
            }
            new ArrayList();
            try {
                ArrayList t17 = PreloadManager.this.t(new String(bArr), this.f80180f);
                synchronized (PreloadManager.this.f80171f) {
                    PreloadManager.this.f80177l.put(q16, t17);
                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "input from ReadFileThread articleId" + q16);
                }
                if (!PreloadManager.this.f80170e && NetworkState.getNetworkType() == 1 && PreloadManager.this.u()) {
                    PreloadManager.this.m();
                }
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "out of memory");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f80181a;

        /* renamed from: b, reason: collision with root package name */
        public int f80182b;
    }

    PreloadManager() {
    }

    private boolean B() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        int readInJoyIpConnectReportSwitch = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnectReportSwitch();
        boolean z16 = false;
        if (readInJoyIpConnectReportSwitch != 0 && (readInJoyIpConnectReportSwitch == 1 || (readInJoyIpConnectReportSwitch == 2 && !TextUtils.isEmpty(account) && !TextUtils.isEmpty(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnectReportTail()) && account.endsWith(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnectReportTail())))) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "shouldDoStatisticReport->uin:" + account + ", result:" + z16);
        }
        return z16;
    }

    private String g(String str, boolean z16) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith("http:") && !str.startsWith("https")) {
            if (z16) {
                return "https:" + str;
            }
            return "http:" + str;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] h(byte[] bArr, byte[] bArr2) {
        Cipher cipher;
        if (bArr2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        try {
            cipher = Cipher.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_AES);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            cipher = null;
            if (cipher == null) {
            }
        } catch (NoSuchPaddingException e17) {
            e17.printStackTrace();
            cipher = null;
            if (cipher == null) {
            }
        }
        if (cipher == null) {
            return null;
        }
        try {
            cipher.init(2, secretKeySpec);
        } catch (InvalidKeyException e18) {
            e18.printStackTrace();
        }
        try {
            return cipher.doFinal(bArr2);
        } catch (OutOfMemoryError e19) {
            e19.printStackTrace();
            return null;
        } catch (BadPaddingException e26) {
            e26.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e27) {
            e27.printStackTrace();
            return null;
        }
    }

    private void i(boolean z16, long j3, int i3, String str, String str2, String str3, String str4) {
        if (!B()) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String str5 = "1";
        hashMap.put("param_dataSource", "1");
        if (!((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect()) {
            str5 = "0";
        }
        String str6 = str5;
        hashMap.put("param_enableIpConnect", str6);
        hashMap.put("param_connType", String.valueOf(i3));
        hashMap.put("param_host", str);
        hashMap.put("param_ipAddr", str2);
        hashMap.put("param_ipConnResult", str3);
        hashMap.put("param_hostConnResult", str4);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - j3;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.READINJOY_IP_CONNECT, z16, serverTimeMillis, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "doStatisticReport-->success:" + z16 + ", costTime:" + serverTimeMillis + ", param_dataSource:1, param_enableIpConnect:" + str6 + ", param_connType:" + i3 + ", param_host:" + str + ", param_ipAddr:" + str2 + ", param_ipConnResult:" + str3 + ", param_hostConnResult:" + str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        Throwable th5;
        String q16;
        long currentTimeMillis = System.currentTimeMillis();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    q16 = q(str);
                } catch (IOException e16) {
                    e = e16;
                }
                if (q16 == null) {
                    return;
                }
                String currentUin = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
                StringBuilder sb5 = new StringBuilder();
                String str2 = AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD;
                sb5.append(str2);
                sb5.append(q16);
                String sb6 = sb5.toString();
                if (QLog.isColorLevel()) {
                    QLog.i("PubAccountPreloadPlugin", 2, "-->downloadFile:" + sb6 + "utl:" + str);
                }
                if (FileUtils.fileExistsAndNotEmpty(sb6)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "the file already exists");
                    }
                    z(str, currentUin);
                    return;
                }
                String k3 = k(str);
                if (k3 == null) {
                    return;
                }
                this.f80172g = t(k3, str.startsWith("https"));
                synchronized (this.f80171f) {
                    this.f80177l.put(q16, this.f80172g);
                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "from downaload thread articleId" + q16);
                }
                if (!this.f80170e && NetworkState.getNetworkType() == 1 && u()) {
                    m();
                }
                try {
                    this.f80176k.put((MQLruCache<String, byte[]>) q16, (String) k3.getBytes());
                    if (TextUtils.isEmpty(k3)) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007623", "0X8007623", 0, 0, "0", "" + currentTimeMillis2, "200", "");
                        return;
                    }
                    try {
                        byte[] bytes = (k3 + "articleId=" + q16).getBytes();
                        byte[] w3 = w(currentUin);
                        if (w3 == null || bytes == null) {
                            return;
                        }
                        byte[] p16 = p(w3, bytes);
                        File file = new File(str2);
                        if (!file.exists() && !file.mkdirs()) {
                            return;
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, q16 + "temp.html"));
                        try {
                        } catch (IOException e17) {
                            e = e17;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007623", "0X8007623", 0, 0, "0", "" + currentTimeMillis3, e.getMessage(), "");
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return;
                        } catch (Throwable th6) {
                            th5 = th6;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th5;
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                        if (p16 == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "download response bytes are null");
                            }
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007623", "0X8007623", 0, 0, "0", "" + currentTimeMillis4, "200", "");
                            fileOutputStream2.close();
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                return;
                            }
                        }
                        fileOutputStream2.write(p16);
                        fileOutputStream2.close();
                        new File(str2 + q16 + "temp.html").renameTo(new File(sb6));
                        long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007623", "0X8007623", 0, 0, "1", "" + currentTimeMillis5, "200", "");
                        fileOutputStream2.close();
                    } catch (OutOfMemoryError unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, " out of memory");
                        }
                    }
                } catch (OutOfMemoryError unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, " out of memory");
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
    }

    private String k(String str) throws IOException {
        String str2;
        String str3 = "";
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithCondition:" + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect());
        }
        if (((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect()) {
            return l(str);
        }
        if (B()) {
            try {
                str2 = new URL(str).getHost();
            } catch (MalformedURLException unused) {
                str2 = "";
            }
            try {
                str3 = InetAddress.getByName(str2).getHostAddress();
            } catch (UnknownHostException unused2) {
            }
            String str4 = str3;
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            try {
                String openUrlForPubAccount = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                i(true, serverTimeMillis, 0, str2, str4, "-1", "0");
                return openUrlForPubAccount;
            } catch (IOException e16) {
                i(false, serverTimeMillis, 1, str2, str4, "-1", e16.getMessage());
                throw e16;
            }
        }
        return HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0164 A[Catch: MalformedURLException -> 0x0208, TRY_LEAVE, TryCatch #1 {MalformedURLException -> 0x0208, blocks: (B:13:0x0039, B:15:0x0052, B:73:0x0072, B:86:0x00c5, B:88:0x00ce, B:89:0x00e3, B:90:0x00f7, B:17:0x00f8, B:32:0x015b, B:34:0x0164, B:49:0x01d4, B:51:0x01dd, B:52:0x01f2, B:53:0x0207), top: B:12:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017f A[Catch: IOException -> 0x01d0, TryCatch #9 {IOException -> 0x01d0, blocks: (B:36:0x0179, B:38:0x017f, B:39:0x0194), top: B:35:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01dd A[Catch: MalformedURLException -> 0x0208, TryCatch #1 {MalformedURLException -> 0x0208, blocks: (B:13:0x0039, B:15:0x0052, B:73:0x0072, B:86:0x00c5, B:88:0x00ce, B:89:0x00e3, B:90:0x00f7, B:17:0x00f8, B:32:0x015b, B:34:0x0164, B:49:0x01d4, B:51:0x01dd, B:52:0x01f2, B:53:0x0207), top: B:12:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String l(String str) throws IOException {
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        IOException iOException;
        String str6;
        String str7;
        IOException iOException2;
        String str8;
        String str9;
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "begin downloadHtmlWithIpConnect!");
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect empty url:" + str);
            }
            return null;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        try {
            String host = new URL(str).getHost();
            String reqDns = InnerDns.getInstance().reqDns(host, 1008);
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect host:" + host + ", ip:" + reqDns);
            }
            if (reqDns == null) {
                try {
                    str2 = InetAddress.getByName(host).getHostAddress();
                } catch (UnknownHostException unused) {
                    str2 = "";
                }
                String str10 = str2;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect direct download html with host:" + str);
                    }
                    String openUrlForPubAccount = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                    str3 = host;
                    try {
                        i(true, serverTimeMillis, 0, str3, str10, "-1", "0");
                        return openUrlForPubAccount;
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect direct download html error:" + e);
                        }
                        i(false, serverTimeMillis, 1, str3, str10, "-1", e.getMessage());
                        throw e;
                    }
                } catch (IOException e17) {
                    e = e17;
                    str3 = host;
                }
            } else {
                String replaceFirst = str.replaceFirst(host, reqDns);
                Bundle bundle = new Bundle();
                bundle.putString("Host", host);
                try {
                    if (QLog.isColorLevel()) {
                        try {
                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect download html with ip:" + replaceFirst);
                        } catch (IOException e18) {
                            iOException = e18;
                            str4 = host;
                            i3 = 1008;
                            str5 = reqDns;
                            iOException.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect download html with ip error:" + iOException);
                            }
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect retry direct download html with host:" + str);
                                }
                                str8 = str4;
                                int i16 = i3;
                                str9 = str5;
                                try {
                                    String openUrlForPubAccount2 = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                                    InnerDns.getInstance().reportBadIp(str8, str9, i16);
                                    str7 = str9;
                                    str6 = str8;
                                    iOException2 = iOException;
                                } catch (IOException e19) {
                                    e = e19;
                                    str7 = str9;
                                    str6 = str8;
                                    iOException2 = iOException;
                                    e.printStackTrace();
                                    if (QLog.isColorLevel()) {
                                    }
                                    i(false, serverTimeMillis, 4, str6, str7, iOException2.getMessage(), e.getMessage());
                                    throw e;
                                }
                            } catch (IOException e26) {
                                e = e26;
                                str6 = str4;
                                str7 = str5;
                            }
                            try {
                                i(true, serverTimeMillis, 3, str6, str7, iOException.getMessage(), "0");
                                return openUrlForPubAccount2;
                            } catch (IOException e27) {
                                e = e27;
                                e.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect retry direct download html error:" + e);
                                }
                                i(false, serverTimeMillis, 4, str6, str7, iOException2.getMessage(), e.getMessage());
                                throw e;
                            }
                        }
                    }
                    try {
                        String openUrlForPubAccount3 = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), replaceFirst, "GET", null, bundle, host);
                        i3 = 1008;
                        str5 = reqDns;
                        str4 = host;
                        try {
                            i(true, serverTimeMillis, 2, str4, str5, "0", "-1");
                            return openUrlForPubAccount3;
                        } catch (IOException e28) {
                            e = e28;
                            iOException = e;
                            iOException.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            str8 = str4;
                            int i162 = i3;
                            str9 = str5;
                            String openUrlForPubAccount22 = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                            InnerDns.getInstance().reportBadIp(str8, str9, i162);
                            str7 = str9;
                            str6 = str8;
                            iOException2 = iOException;
                            i(true, serverTimeMillis, 3, str6, str7, iOException.getMessage(), "0");
                            return openUrlForPubAccount22;
                        }
                    } catch (IOException e29) {
                        e = e29;
                        i3 = 1008;
                        str5 = reqDns;
                        str4 = host;
                    }
                } catch (IOException e36) {
                    e = e36;
                    str4 = host;
                    i3 = 1008;
                    str5 = reqDns;
                }
            }
        } catch (MalformedURLException e37) {
            e37.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect illegal url:" + str);
            }
            return null;
        }
    }

    private byte[] n(String str) throws IOException {
        String str2;
        String str3 = "";
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithCondition:" + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect());
        }
        if (((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect()) {
            return o(str);
        }
        if (B()) {
            try {
                str2 = new URL(str).getHost();
            } catch (MalformedURLException unused) {
                str2 = "";
            }
            try {
                str3 = InetAddress.getByName(str2).getHostAddress();
            } catch (UnknownHostException unused2) {
            }
            String str4 = str3;
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            try {
                byte[] openUrlForByteForPubAccount = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                i(true, serverTimeMillis, 0, str2, str4, "-1", "0");
                return openUrlForByteForPubAccount;
            } catch (IOException e16) {
                i(false, serverTimeMillis, 1, str2, str4, "-1", e16.getMessage());
                throw e16;
            }
        }
        return HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0164 A[Catch: MalformedURLException -> 0x0208, TRY_LEAVE, TryCatch #1 {MalformedURLException -> 0x0208, blocks: (B:13:0x0039, B:15:0x0052, B:73:0x0072, B:86:0x00c5, B:88:0x00ce, B:89:0x00e3, B:90:0x00f7, B:17:0x00f8, B:32:0x015b, B:34:0x0164, B:49:0x01d4, B:51:0x01dd, B:52:0x01f2, B:53:0x0207), top: B:12:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017f A[Catch: IOException -> 0x01d0, TryCatch #9 {IOException -> 0x01d0, blocks: (B:36:0x0179, B:38:0x017f, B:39:0x0194), top: B:35:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01dd A[Catch: MalformedURLException -> 0x0208, TryCatch #1 {MalformedURLException -> 0x0208, blocks: (B:13:0x0039, B:15:0x0052, B:73:0x0072, B:86:0x00c5, B:88:0x00ce, B:89:0x00e3, B:90:0x00f7, B:17:0x00f8, B:32:0x015b, B:34:0x0164, B:49:0x01d4, B:51:0x01dd, B:52:0x01f2, B:53:0x0207), top: B:12:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] o(String str) throws IOException {
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        IOException iOException;
        String str6;
        String str7;
        IOException iOException2;
        String str8;
        String str9;
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "begin downloadImageWithIpConnect!");
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect empty url:" + str);
            }
            return null;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        try {
            String host = new URL(str).getHost();
            String reqDns = InnerDns.getInstance().reqDns(host, 1009);
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect host:" + host + ", ip:" + reqDns);
            }
            if (reqDns == null) {
                try {
                    str2 = InetAddress.getByName(host).getHostAddress();
                } catch (UnknownHostException unused) {
                    str2 = "";
                }
                String str10 = str2;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect direct download image with host:" + str);
                    }
                    byte[] openUrlForByteForPubAccount = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                    str3 = host;
                    try {
                        i(true, serverTimeMillis, 0, str3, str10, "-1", "0");
                        return openUrlForByteForPubAccount;
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect direct download image error:" + e);
                        }
                        i(false, serverTimeMillis, 1, str3, str10, "-1", e.getMessage());
                        throw e;
                    }
                } catch (IOException e17) {
                    e = e17;
                    str3 = host;
                }
            } else {
                String replaceFirst = str.replaceFirst(host, reqDns);
                Bundle bundle = new Bundle();
                bundle.putString("Host", host);
                try {
                    if (QLog.isColorLevel()) {
                        try {
                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect download image with ip:" + replaceFirst);
                        } catch (IOException e18) {
                            iOException = e18;
                            str4 = host;
                            i3 = 1009;
                            str5 = reqDns;
                            iOException.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect download image with ip error:" + iOException);
                            }
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect retry direct download image with host:" + str);
                                }
                                str8 = str4;
                                int i16 = i3;
                                str9 = str5;
                                try {
                                    byte[] openUrlForByteForPubAccount2 = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                                    InnerDns.getInstance().reportBadIp(str8, str9, i16);
                                    str7 = str9;
                                    str6 = str8;
                                    iOException2 = iOException;
                                } catch (IOException e19) {
                                    e = e19;
                                    str7 = str9;
                                    str6 = str8;
                                    iOException2 = iOException;
                                    e.printStackTrace();
                                    if (QLog.isColorLevel()) {
                                    }
                                    i(false, serverTimeMillis, 4, str6, str7, iOException2.getMessage(), e.getMessage());
                                    throw e;
                                }
                            } catch (IOException e26) {
                                e = e26;
                                str6 = str4;
                                str7 = str5;
                            }
                            try {
                                i(true, serverTimeMillis, 3, str6, str7, iOException.getMessage(), "0");
                                return openUrlForByteForPubAccount2;
                            } catch (IOException e27) {
                                e = e27;
                                e.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect retry direct download image error:" + e);
                                }
                                i(false, serverTimeMillis, 4, str6, str7, iOException2.getMessage(), e.getMessage());
                                throw e;
                            }
                        }
                    }
                    try {
                        byte[] openUrlForByteForPubAccount3 = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), replaceFirst, "GET", null, bundle, host);
                        i3 = 1009;
                        str5 = reqDns;
                        str4 = host;
                        try {
                            i(true, serverTimeMillis, 2, str4, str5, "0", "-1");
                            return openUrlForByteForPubAccount3;
                        } catch (IOException e28) {
                            e = e28;
                            iOException = e;
                            iOException.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            str8 = str4;
                            int i162 = i3;
                            str9 = str5;
                            byte[] openUrlForByteForPubAccount22 = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), str, "GET", null, null, null);
                            InnerDns.getInstance().reportBadIp(str8, str9, i162);
                            str7 = str9;
                            str6 = str8;
                            iOException2 = iOException;
                            i(true, serverTimeMillis, 3, str6, str7, iOException.getMessage(), "0");
                            return openUrlForByteForPubAccount22;
                        }
                    } catch (IOException e29) {
                        e = e29;
                        i3 = 1009;
                        str5 = reqDns;
                        str4 = host;
                    }
                } catch (IOException e36) {
                    e = e36;
                    str4 = host;
                    i3 = 1009;
                    str5 = reqDns;
                }
            }
        } catch (MalformedURLException e37) {
            e37.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect illegal url:" + str);
            }
            return null;
        }
    }

    private static byte[] p(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        byte[] bArr3 = null;
        try {
            Cipher cipher = Cipher.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_AES);
            try {
                cipher.init(1, secretKeySpec);
                try {
                    bArr3 = cipher.doFinal(bArr2);
                } catch (BadPaddingException e16) {
                    e16.printStackTrace();
                } catch (IllegalBlockSizeException e17) {
                    e17.printStackTrace();
                }
            } catch (InvalidKeyException e18) {
                e18.printStackTrace();
            }
        } catch (OutOfMemoryError e19) {
            e19.printStackTrace();
        } catch (NoSuchAlgorithmException e26) {
            e26.printStackTrace();
        } catch (NoSuchPaddingException e27) {
            e27.printStackTrace();
        }
        return bArr3;
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.parse(str).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
        } catch (Exception unused) {
            return null;
        }
    }

    public static PreloadManager s() {
        if (f80165m == null) {
            f80165m = new PreloadManager();
        }
        return f80165m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public ArrayList<a> t(String str, boolean z16) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new ArrayList();
        new ArrayList();
        ArrayList<a> arrayList = new ArrayList<>();
        Matcher matcher = Pattern.compile("<head>[.\\s\\S\\w]*?</head>").matcher(str);
        if (matcher.find()) {
            Matcher matcher2 = Pattern.compile("<meta[.\\s\\S\\w]*?/>").matcher(matcher.group());
            String str3 = null;
            while (matcher2.find()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, matcher2.group());
                if (Pattern.compile("itemprop[\\s]*=[\\s]*\"[\\s]*prefetch-images[\\s]*\"").matcher(matcher2.group()).find()) {
                    Matcher matcher3 = Pattern.compile("content[\\s]*=[\\s]*\"(.*?)\"").matcher(matcher2.group());
                    if (matcher3.find()) {
                        str2 = matcher3.group(1);
                    }
                    Matcher matcher4 = Pattern.compile("priority[\\s]*=[\\s]*\"(.*?)\"").matcher(matcher2.group());
                    if (matcher4.find()) {
                        str3 = matcher4.group(1);
                    }
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        List<String> r16 = r(str2, true, z16);
                        List<String> r17 = r(str3, false, z16);
                        int size = r16.size();
                        int size2 = r17.size();
                        if (size2 != 0 && size2 >= size && size2 <= size) {
                            for (int i3 = 0; i3 < r16.size(); i3++) {
                                a aVar = new a();
                                aVar.f80181a = r16.get(i3);
                                try {
                                    try {
                                        aVar.f80182b = Integer.parseInt(r17.get(i3));
                                    } catch (NumberFormatException e16) {
                                        aVar.f80182b = 0;
                                        e16.printStackTrace();
                                    }
                                    arrayList.add(aVar);
                                } catch (Throwable th5) {
                                    arrayList.add(aVar);
                                    throw th5;
                                }
                            }
                        } else {
                            for (int i16 = 0; i16 < r16.size(); i16++) {
                                a aVar2 = new a();
                                aVar2.f80181a = r16.get(i16);
                                aVar2.f80182b = 0;
                                arrayList.add(aVar2);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static byte[] w(String str) {
        SecretKeyFactory secretKeyFactory;
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(str.toCharArray(), bArr, 1000, 256);
        byte[] bArr2 = null;
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            secretKeyFactory = null;
        }
        if (secretKeyFactory != null) {
            try {
                bArr2 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
            } catch (InvalidKeySpecException e17) {
                e17.printStackTrace();
            }
        }
        return new SecretKeySpec(bArr2, KeyPropertiesCompact.KEY_ALGORITHM_AES).getEncoded();
    }

    static int x(String str) {
        String md5 = MD5Utils.toMD5(str);
        String str2 = md5 + FileDataSink.TEMP_FILE;
        String str3 = AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE;
        File file = new File(str3, md5);
        File file2 = new File(str3, str2);
        if (file.exists()) {
            return 2;
        }
        if (file2.exists()) {
            return 1;
        }
        return 0;
    }

    public byte[] A(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f80176k.get(str);
    }

    public void C() {
        this.f80167b.addAll(this.f80168c);
        this.f80168c.clear();
        this.f80169d = true;
        y();
    }

    public void m() {
        if (NetworkState.getNetworkType() != 1) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "current network is not wifi");
                return;
            }
            return;
        }
        ThreadManagerV2.executeOnNetWorkThread(new FeedslistDownlaodImageThread());
    }

    public List<String> r(String str, boolean z16, boolean z17) {
        int i3;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == ';' || i16 == str.length() - 1) {
                if (i16 == str.length() - 1) {
                    i3 = str.length();
                } else {
                    i3 = i16;
                }
                if (i3 > i17) {
                    String substring = str.substring(i17, i3);
                    if (z16) {
                        substring = g(substring, z17);
                    }
                    if (substring != null) {
                        arrayList.add(substring);
                        if (QLog.isColorLevel()) {
                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "\u9884\u4e0b\u8f7d\u56fe\u7247url = " + substring);
                        }
                    }
                    i17 = i3 + 1;
                    i16 = i17;
                }
            }
            i16++;
        }
        return arrayList;
    }

    public boolean u() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        return BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + qQAppInterface.getCurrentAccountUin(), 0).getBoolean("kandian_feeds_image_preload", false);
    }

    public boolean v(String str) {
        Throwable th5;
        long currentTimeMillis = System.currentTimeMillis();
        String md5 = MD5Utils.toMD5(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    File file = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE);
                    if (!file.exists() && !file.mkdirs()) {
                        return false;
                    }
                    File file2 = new File(file, md5 + FileDataSink.TEMP_FILE);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] n3 = n(str);
                        if (n3 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "getPreloadImage from url sucessed, url =" + str + "\n\u65f6\u95f4\u4e3a" + System.currentTimeMillis());
                            }
                            fileOutputStream2.write(n3);
                            file2.renameTo(new File(file, md5));
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007624", "0X8007624", 0, 0, "1", "" + currentTimeMillis2, "200", "0");
                            try {
                                fileOutputStream2.close();
                                return true;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                return true;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "getPreloadImageFromUrl download error");
                        }
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007624", "0X8007624", 0, 0, "0", "" + currentTimeMillis3, "200", "0");
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        return false;
                    } catch (IOException e18) {
                        e = e18;
                        fileOutputStream = fileOutputStream2;
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007624", "0X8007624", 0, 0, "0", "" + currentTimeMillis4, e.getMessage(), "0");
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (IllegalArgumentException e19) {
                        e = e19;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (OutOfMemoryError unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (Throwable th6) {
                        th5 = th6;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                throw th5;
                            } catch (IOException e26) {
                                e26.printStackTrace();
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (IOException e27) {
                    e = e27;
                } catch (IllegalArgumentException e28) {
                    e = e28;
                } catch (OutOfMemoryError unused2) {
                }
            } catch (Throwable th7) {
                th5 = th7;
            }
        } catch (IOException e29) {
            e29.printStackTrace();
        }
    }

    public void y() {
        ThreadManagerV2.executeOnNetWorkThread(new PreloadThread());
    }

    public void z(String str, String str2) {
        ThreadManagerV2.executeOnFileThread(new ReadFileThread(str, str2));
    }
}
