package com.tencent.mobileqq.bigbrother.RockDownloader;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RockDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f200355a;

    /* renamed from: b, reason: collision with root package name */
    private static String f200356b;

    /* renamed from: c, reason: collision with root package name */
    private static EntityManager f200357c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f200355a = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".Rock/");
    }

    public static RockDownloadInfo a(Context context, String str) {
        PackageInfo packageArchiveInfo;
        if (TextUtils.isEmpty(str) || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 16384)) == null) {
            return null;
        }
        RockDownloadInfo rockDownloadInfo = new RockDownloadInfo();
        rockDownloadInfo.setPackageName(packageArchiveInfo.packageName);
        rockDownloadInfo.setRealVersionCode(packageArchiveInfo.versionCode);
        return rockDownloadInfo;
    }

    public static String b() {
        if (f200356b == null) {
            String str = f200355a;
            f200356b = str;
            VFSFile vFSFile = new VFSFile(str);
            if (!vFSFile.exists()) {
                vFSFile.mkdirs();
            }
        }
        return f200356b;
    }

    public static EntityManager c() {
        if (f200357c == null) {
            f200357c = new c().createEntityManager();
        }
        return f200357c;
    }

    public static boolean d(RockDownloaderTask rockDownloaderTask) {
        if (!rockDownloaderTask.getDownloadInfo().verifyDate(4)) {
            if (QLog.isColorLevel()) {
                QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
            }
            return false;
        }
        VFSFile vFSFile = new VFSFile(rockDownloaderTask.getDownloadInfo().localPath);
        if (!vFSFile.exists() || !g(rockDownloaderTask.getRuntime().getApplication(), vFSFile)) {
            return false;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.putExtra("big_brother_source_key", rockDownloaderTask.getDownloadInfo().businessName);
        intent.setFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(VFSFileOp.exportExternalPath(vFSFile.getAbsolutePath(), false))), AppSetting.e());
        rockDownloaderTask.getRuntime().getApplication().startActivity(intent);
        f(rockDownloaderTask, "0x800A1E7");
        return true;
    }

    public static void e(RockDownloaderTask rockDownloaderTask) {
        if (!rockDownloaderTask.getDownloadInfo().verifyDate(2)) {
            if (QLog.isColorLevel()) {
                QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
            }
            if (rockDownloaderTask.getQueryAPKListener() != null) {
                rockDownloaderTask.getQueryAPKListener().a(rockDownloaderTask.getDownloadInfo(), "RockDownloadInfo verifyDate fail", 10001);
                return;
            }
            return;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RockDownloaderTask.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                List<? extends Entity> query = RockDownloader.c().query(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[]{RockDownloaderTask.this.getDownloadInfo().businessName, RockDownloaderTask.this.getDownloadInfo().packageName}, null, null, null, null);
                ArrayList<RockDownloadInfo> arrayList = new ArrayList<>();
                if (query != null && query.size() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RockDownloader", 2, "result size=", Integer.valueOf(query.size()));
                    }
                    for (Entity entity : query) {
                        if (entity instanceof RockDownloadInfo) {
                            RockDownloadInfo rockDownloadInfo = (RockDownloadInfo) entity;
                            if (!TextUtils.isEmpty(rockDownloadInfo.localPath) && new VFSFile(rockDownloadInfo.localPath).exists()) {
                                arrayList.add(rockDownloadInfo);
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("RockDownloader", 2, "File Removed: ", entity.toString());
                                }
                                RockDownloader.c().remove(rockDownloadInfo);
                            }
                        }
                    }
                }
                if (RockDownloaderTask.this.getQueryAPKListener() != null) {
                    if (arrayList.size() > 0) {
                        RockDownloaderTask.this.getQueryAPKListener().b(arrayList);
                    } else {
                        RockDownloaderTask.this.getQueryAPKListener().a(RockDownloaderTask.this.getDownloadInfo(), HardCodeUtil.qqStr(R.string.t2y), 10002);
                    }
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.tencent.mobileqq.statistics.StatisticCollector] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void f(@NonNull RockDownloaderTask rockDownloaderTask, String str) {
        String str2;
        RockDownloadInfo downloadInfo = rockDownloaderTask.getDownloadInfo();
        ?? sb5 = new StringBuilder();
        HashMap<String, String> hashMap = new HashMap<>();
        if (downloadInfo != null) {
            sb5.append(downloadInfo.getBusinessName());
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(downloadInfo.getBusinessScene());
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(downloadInfo.getPackageName());
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(QQDeviceInfo.getIMEI("0"));
            hashMap.put("BusinessName", downloadInfo.getBusinessName());
            hashMap.put("BusinessScene", downloadInfo.getBusinessScene());
            hashMap.put("PackageName", downloadInfo.getPackageName());
            hashMap.put(Global.TRACKING_IMEI, QQDeviceInfo.getIMEI("0"));
            hashMap.put("reportID", str);
        }
        ?? r122 = 2;
        try {
            try {
                if (rockDownloaderTask.getRuntime() instanceof QQAppInterface) {
                    ReportController.o((QQAppInterface) rockDownloaderTask.getRuntime(), "dc00898", "", ((QQAppInterface) rockDownloaderTask.getRuntime()).getCurrentUin(), str, str, 1, 1, "", "", sb5.toString(), "");
                    str2 = 2;
                    r122 = "";
                    StatisticCollector.getInstance(((QQAppInterface) rockDownloaderTask.getRuntime()).getApp()).collectPerformance(((QQAppInterface) rockDownloaderTask.getRuntime()).getCurrentUin(), "RockDownloader", true, 0L, 0L, hashMap, r122);
                    sb5 = 2;
                } else {
                    try {
                        if (rockDownloaderTask.getRuntime() != null) {
                            String account = rockDownloaderTask.getRuntime().getAccount();
                            String sb6 = sb5.toString();
                            sb5 = 2;
                            str2 = "dc00898";
                            ReportController.o(null, str2, "", account, str, str, 1, 1, "", "", sb6, "");
                            StatisticCollector.getInstance(rockDownloaderTask.getRuntime().getApplication()).collectPerformance(rockDownloaderTask.getRuntime().getAccount(), "RockDownloader", true, 0L, 0L, hashMap, "");
                            r122 = "";
                        } else {
                            str2 = "dc00898";
                            ReportController.o(null, "dc00898", "", "", str, str, 1, 1, "", "", sb5.toString(), "");
                            sb5 = 2;
                            String str3 = "";
                            StatisticCollector.getInstance(BaseApplication.context).collectPerformance("", "RockDownloader", true, 0L, 0L, hashMap, str3);
                            r122 = str3;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (QLog.isColorLevel()) {
                            QLog.d("RockDownloader", (int) sb5, th, new Object[0]);
                        }
                        if (!QLog.isColorLevel()) {
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                sb5 = str2;
            }
        } catch (Throwable th7) {
            th = th7;
            sb5 = r122;
        }
        if (!QLog.isColorLevel()) {
            StringBuilder sb7 = new StringBuilder();
            for (String str4 : hashMap.keySet()) {
                sb7.append(str4);
                sb7.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb7.append(hashMap.get(str4));
                sb7.append("\n");
            }
            QLog.d("RockDownloader", (int) sb5, sb7.toString());
        }
    }

    private static boolean g(Context context, VFSFile vFSFile) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(VFSFileOp.exportExternalPath(vFSFile.getAbsolutePath(), false), "rw");
                try {
                    FileChannel channel = randomAccessFile2.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 4L);
                    for (int i3 = 0; i3 < 4; i3++) {
                        byte b16 = map.get(i3);
                        if (i3 == 0 && b16 == 80) {
                            break;
                        }
                        map.put(i3, (byte) (b16 - 4));
                    }
                    map.flip();
                    map.force();
                    map.clear();
                    channel.close();
                    randomAccessFile2.close();
                    if (a(context, VFSFileOp.exportExternalPath(vFSFile.getAbsolutePath(), false)) != null) {
                        try {
                            randomAccessFile2.close();
                            return true;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            return true;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("RockDownloader", 2, "getAPKFileInfo fail");
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    return false;
                } catch (FileNotFoundException e18) {
                    e = e18;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    return false;
                } catch (IOException e26) {
                    e = e26;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e29) {
                e = e29;
            } catch (IOException e36) {
                e = e36;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
