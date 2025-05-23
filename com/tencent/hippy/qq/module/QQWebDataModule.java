package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.VasHippyUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.util.ThreeDes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@HippyNativeModule(name = "QQWebDataModule")
/* loaded from: classes7.dex */
public class QQWebDataModule extends QQBaseModule {
    public static final int ACTION_HASH_DELETE = 2;
    public static final int ACTION_HASH_READ = 0;
    public static final int ACTION_HASH_WRITE = 1;
    static final String CLASSNAME = "QQWebDataModule";
    public static final int ERROR_DATA_NOT_EXIST = -11;
    public static final int ERROR_EMPTY_DATA = -8;
    public static final int ERROR_EMPTY_KEY = -7;
    public static final int ERROR_EMPTY_PARAMS = -3;
    public static final int ERROR_EMPTY_PATH = -6;
    public static final int ERROR_EMPTY_URL = -4;
    public static final int ERROR_NO_HOST = -13;
    public static final int ERROR_NO_PERMISSION_TO_DOMAIN = -5;
    public static final int ERROR_NO_SPACE_OR_NO_SDCARD = -9;
    public static final int ERROR_TOO_MANY_DATA = -12;
    public static final int ERROR_WRONG_IMAGE_DATA = -10;
    public static final int ERROR_WRONG_JSON = -2;
    public static final String PUBACCOUNT_DATA_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pubaccount/");
    private static final String TAG = "QQWebDataModule";
    private final String METHOD_DELETE_H5_DATA;
    private final String METHOD_GET_UA;
    private final String METHOD_READ_H5_DATA;
    private final String METHOD_WRITE_H5_DATA;

    public QQWebDataModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.METHOD_GET_UA = "getDefaultUserAgent";
        this.METHOD_READ_H5_DATA = IH5DataCacheApi.METHOD_READ_H5_DATA;
        this.METHOD_WRITE_H5_DATA = IH5DataCacheApi.METHOD_WRITE_H5_DATA;
        this.METHOD_DELETE_H5_DATA = IH5DataCacheApi.METHOD_DELETE_H5_DATA;
    }

    private int checkParams(String str, String str2, String str3, AppInterface appInterface) {
        if (TextUtils.isEmpty(str)) {
            return -6;
        }
        if (TextUtils.isEmpty(str2)) {
            return -7;
        }
        if (appInterface != null && appInterface.isLogin()) {
            if (str3 == null) {
                QLog.i("QQWebDataModule", 1, "writeH5Data host is null");
                return -13;
            }
            return 0;
        }
        return -11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int doFileWrite(String str, File file, String str2) {
        FileWriter fileWriter;
        IOException e16;
        File file2 = new File(file, HexUtil.string2HexString(str));
        if (file2.exists()) {
            file2.delete();
        }
        int i3 = -9;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file2);
            } catch (IOException e17) {
                fileWriter = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (fileWriter2 != null) {
                }
                throw th;
            }
        } catch (IOException e18) {
            e18.printStackTrace();
        }
        try {
            try {
                fileWriter.write(str2);
                fileWriter.close();
                i3 = 0;
            } catch (Throwable th6) {
                th = th6;
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e26) {
            e16 = e26;
            e16.printStackTrace();
            if (fileWriter != null) {
                fileWriter.close();
            }
            return i3;
        }
        return i3;
    }

    private static long getH5DataUsage() {
        File file = new File(PUBACCOUNT_DATA_PATH);
        long j3 = 0;
        if (!file.exists()) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        while (!arrayList.isEmpty()) {
            File file2 = (File) arrayList.remove(0);
            if (file2.isFile()) {
                j3 += file2.length();
            } else {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    Collections.addAll(arrayList, listFiles);
                }
            }
        }
        return j3;
    }

    private String hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            String bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
            messageDigest.reset();
            return bytes2HexStr;
        } catch (NoSuchAlgorithmException unused) {
            return "wronghash";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String operateHash(int i3, String str, String str2, String str3, String str4, boolean z16) {
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        CouponH5Data couponH5Data;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null || (entityManagerFactory = appInterface.getEntityManagerFactory(appInterface.getAccount())) == null) {
            return null;
        }
        try {
            entityManager = entityManagerFactory.createEntityManager();
        } catch (RuntimeException e16) {
            QLog.e("QQWebDataModule", 1, "operateHash createEntityManager error, app:", appInterface, " entityManagerFactory:", entityManagerFactory, " e:", e16);
            entityManager = null;
        }
        if (entityManager == null) {
            return null;
        }
        if (z16) {
            couponH5Data = (CouponH5Data) DBMethodProxy.find(entityManager, CouponH5Data.class, "mHost = ?", new String[]{str});
        } else {
            couponH5Data = (CouponH5Data) DBMethodProxy.find(entityManager, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{str, str2, str3});
        }
        if (i3 != 1) {
            if (i3 == 2) {
                if (TextUtils.isEmpty(str3)) {
                    List<? extends Entity> query = entityManager.query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[]{str, str2}, null, null, null, null);
                    if (query != null) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            entityManager.remove((CouponH5Data) it.next());
                        }
                    }
                } else if (couponH5Data != null) {
                    entityManager.remove(couponH5Data);
                }
            }
        } else if (couponH5Data == null) {
            couponH5Data = new CouponH5Data(str, str2, str3, str4);
            entityManager.persist(couponH5Data);
        } else {
            couponH5Data.mData = str4;
            entityManager.update(couponH5Data);
        }
        entityManager.close();
        if (couponH5Data == null) {
            return null;
        }
        return couponH5Data.mData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public File paperFilePath(String str, String str2, String str3) {
        File file = new File(PUBACCOUNT_DATA_PATH + "/" + HexUtil.string2HexString(str3));
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        } else if (file2.isFile()) {
            file2.delete();
            file2.mkdirs();
        }
        File file3 = new File(file2, HexUtil.string2HexString(str2));
        if (!file3.exists()) {
            file3.mkdirs();
        } else if (file3.isFile()) {
            file3.delete();
            file3.mkdirs();
        }
        return file3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:52:0x0098
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public void readDataFile(com.tencent.mtt.hippy.modules.Promise r7, com.tencent.mtt.hippy.common.HippyMap r8, @org.jetbrains.annotations.NotNull java.lang.String r9, java.io.File r10) {
        /*
            r6 = this;
            r0 = 0
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9d
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L98
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L98
            long r2 = r10.length()     // Catch: java.lang.Throwable -> L95
            r4 = 0
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r0 = -11
            if (r10 > 0) goto L27
            java.lang.String r9 = ""
            com.tencent.mtt.hippy.common.HippyMap r9 = com.tencent.hippy.qq.utils.VasHippyUtils.newRspObj(r0, r9, r8)     // Catch: java.lang.Throwable -> L95
            r7.resolve(r9)     // Catch: java.lang.Throwable -> L95
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L95
            r1.close()     // Catch: java.io.IOException -> L22
            goto L26
        L22:
            r7 = move-exception
            r7.printStackTrace()
        L26:
            return
        L27:
            int r10 = (int) r2
            byte[] r10 = new byte[r10]     // Catch: java.lang.Throwable -> L95
            r1.read(r10)     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L95
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L95
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L95
            if (r3 == 0) goto L65
            java.lang.String r9 = ""
            com.tencent.mtt.hippy.common.HippyMap r9 = com.tencent.hippy.qq.utils.VasHippyUtils.newRspObj(r0, r9, r8)     // Catch: java.lang.Throwable -> L95
            r7.resolve(r9)     // Catch: java.lang.Throwable -> L95
            java.lang.String r9 = "QQWebDataModule"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r0.<init>()     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = "readDataFile string is null, byteData = "
            r0.append(r2)     // Catch: java.lang.Throwable -> L95
            r0.append(r10)     // Catch: java.lang.Throwable -> L95
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L95
            r0 = 1
            com.tencent.qphone.base.util.QLog.e(r9, r0, r10)     // Catch: java.lang.Throwable -> L95
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L95
            r1.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r7 = move-exception
            r7.printStackTrace()
        L64:
            return
        L65:
            java.lang.String r9 = com.tencent.util.ThreeDes.decode(r2, r9)     // Catch: java.lang.Throwable -> L95
            if (r9 != 0) goto L7f
            java.lang.String r9 = ""
            com.tencent.mtt.hippy.common.HippyMap r9 = com.tencent.hippy.qq.utils.VasHippyUtils.newRspObj(r0, r9, r8)     // Catch: java.lang.Throwable -> L95
            r7.resolve(r9)     // Catch: java.lang.Throwable -> L95
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L95
            r1.close()     // Catch: java.io.IOException -> L7a
            goto L7e
        L7a:
            r7 = move-exception
            r7.printStackTrace()
        L7e:
            return
        L7f:
            java.lang.String r10 = "data"
            r8.pushString(r10, r9)     // Catch: java.lang.Throwable -> L95
            java.lang.String r9 = ""
            r10 = 0
            com.tencent.mtt.hippy.common.HippyMap r9 = com.tencent.hippy.qq.utils.VasHippyUtils.newRspObj(r10, r9, r8)     // Catch: java.lang.Throwable -> L95
            r7.resolve(r9)     // Catch: java.lang.Throwable -> L95
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L95
            r1.close()     // Catch: java.io.IOException -> Laf
            goto Lb3
        L95:
            r9 = move-exception
            r0 = r1
            goto L99
        L98:
            r9 = move-exception
        L99:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L98
            throw r9     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9d
        L9b:
            r7 = move-exception
            goto Lb4
        L9d:
            java.lang.String r9 = ""
            r10 = -9
            com.tencent.mtt.hippy.common.HippyMap r8 = com.tencent.hippy.qq.utils.VasHippyUtils.newRspObj(r10, r9, r8)     // Catch: java.lang.Throwable -> L9b
            r7.resolve(r8)     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto Lb3
            r0.close()     // Catch: java.io.IOException -> Laf
            goto Lb3
        Laf:
            r7 = move-exception
            r7.printStackTrace()
        Lb3:
            return
        Lb4:
            if (r0 == 0) goto Lbe
            r0.close()     // Catch: java.io.IOException -> Lba
            goto Lbe
        Lba:
            r8 = move-exception
            r8.printStackTrace()
        Lbe:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippy.qq.module.QQWebDataModule.readDataFile(com.tencent.mtt.hippy.modules.Promise, com.tencent.mtt.hippy.common.HippyMap, java.lang.String, java.io.File):void");
    }

    @HippyMethod(name = IH5DataCacheApi.METHOD_DELETE_H5_DATA)
    public void deleteH5Data(HippyMap hippyMap, final Promise promise) {
        String string = hippyMap.getString("callId");
        final String string2 = hippyMap.getString("host");
        final String string3 = hippyMap.getString("path");
        final String string4 = hippyMap.getString("key");
        final int i3 = hippyMap.getInt("delAllHostData");
        AppInterface appInterface = getAppInterface();
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        final HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushString("callId", string);
        int checkParams = checkParams(string3, string4, string2, appInterface);
        if (checkParams != 0) {
            promise.resolve(VasHippyUtils.newRspObj(checkParams, "", hippyMap2));
        } else {
            final String currentAccountUin = appInterface.getCurrentAccountUin();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.module.QQWebDataModule.3
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    QQWebDataModule qQWebDataModule = QQWebDataModule.this;
                    String str = string2;
                    String str2 = string3;
                    String str3 = string4;
                    if (i3 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    qQWebDataModule.operateHash(2, str, str2, str3, null, z16);
                    String str4 = QQWebDataModule.PUBACCOUNT_DATA_PATH + "/" + HexUtil.string2HexString(currentAccountUin) + "/" + string2;
                    if (i3 != 1) {
                        str4 = str4 + "/" + HexUtil.string2HexString(string3);
                        if (!TextUtils.isEmpty(string4)) {
                            str4 = str4 + "/" + HexUtil.string2HexString(string4);
                        }
                    }
                    com.tencent.mobileqq.filemanager.util.q.c(new File(str4));
                    promise.resolve(VasHippyUtils.newRspObj(0, "", hippyMap2));
                }
            }, 64, null, false);
        }
    }

    @HippyMethod(name = "getDefaultUserAgent")
    public void getDefaultUserAgent(Promise promise) {
        promise.resolve(com.tencent.mobileqq.webview.swift.utils.i.n(com.tencent.mobileqq.webview.swift.utils.i.i(""), "", false));
    }

    @HippyMethod(name = IH5DataCacheApi.METHOD_READ_H5_DATA)
    public void readH5Data(HippyMap hippyMap, final Promise promise) {
        String string = hippyMap.getString("callId");
        final String string2 = hippyMap.getString("host");
        final String string3 = hippyMap.getString("path");
        final String string4 = hippyMap.getString("key");
        AppInterface appInterface = getAppInterface();
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        final HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushString("callId", string);
        int checkParams = checkParams(string3, string4, string2, appInterface);
        if (checkParams != 0) {
            promise.resolve(VasHippyUtils.newRspObj(checkParams, "", hippyMap2));
        } else {
            final String currentAccountUin = appInterface.getCurrentAccountUin();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.module.QQWebDataModule.1
                @Override // java.lang.Runnable
                public void run() {
                    String operateHash = QQWebDataModule.this.operateHash(0, string2, string3, string4, null, false);
                    if (TextUtils.isEmpty(operateHash)) {
                        promise.resolve(VasHippyUtils.newRspObj(-11, "", hippyMap2));
                        return;
                    }
                    File file = new File(QQWebDataModule.PUBACCOUNT_DATA_PATH + "/" + HexUtil.string2HexString(currentAccountUin) + "/" + string2 + "/" + HexUtil.string2HexString(string3) + "/" + HexUtil.string2HexString(string4));
                    if (file.exists()) {
                        QQWebDataModule.this.readDataFile(promise, hippyMap2, operateHash, file);
                    } else {
                        promise.resolve(VasHippyUtils.newRspObj(-11, "", hippyMap2));
                    }
                }
            }, 64, null, false);
        }
    }

    @HippyMethod(name = IH5DataCacheApi.METHOD_WRITE_H5_DATA)
    public void writeH5Data(HippyMap hippyMap, final Promise promise) {
        String string = hippyMap.getString("callId");
        final String string2 = hippyMap.getString("host");
        final String string3 = hippyMap.getString("path");
        final String string4 = hippyMap.getString("key");
        final String string5 = hippyMap.getString("data");
        AppInterface appInterface = getAppInterface();
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        final HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushString("callId", string);
        int checkParams = checkParams(string3, string4, string2, appInterface);
        if (TextUtils.isEmpty(string5)) {
            checkParams = -8;
        }
        if (getH5DataUsage() > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
            checkParams = -12;
        }
        if (checkParams != 0) {
            promise.resolve(VasHippyUtils.newRspObj(checkParams, "", hippyMap2));
            return;
        }
        final String currentAccountUin = appInterface.getCurrentAccountUin();
        final String hash = hash(string5);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.module.QQWebDataModule.2
            @Override // java.lang.Runnable
            public void run() {
                QQWebDataModule.this.operateHash(1, string2, string3, string4, hash, false);
                promise.resolve(VasHippyUtils.newRspObj(QQWebDataModule.this.doFileWrite(string4, QQWebDataModule.this.paperFilePath(string2, string3, currentAccountUin), ThreeDes.encode(string5, hash)), "", hippyMap2));
            }
        }, 64, null, false);
    }
}
