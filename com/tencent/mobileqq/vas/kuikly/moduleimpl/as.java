package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.util.ThreeDes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b)\u0010*JE\u0010\r\u001a\u00020\u00062+\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002J,\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J:\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J \u0010!\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002JG\u0010#\u001a\u00020\u00062+\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u00072\u0006\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J;\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\t2+\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u0007J;\u0010'\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\t2+\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u0007J;\u0010(\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\t2+\u0010\b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u0007\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/as;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/vas/spanend/H5DataCacheCallback;", "callback", "", "hash", "Ljava/io/File;", "file", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "key", "pathDir", "encryptData", "", "i", "data", "l", "path", "host", "Lcom/tencent/common/app/AppInterface;", "appInterface", "f", "", "k", "actionType", "", "isDelAllHostData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "uin", DomainData.DOMAIN_NAME, "ret", "d", "j", "jsonStr", "r", "o", "g", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class as {

    /* renamed from: b, reason: collision with root package name */
    private static final String f309810b = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pubaccount/");

    /* renamed from: c, reason: collision with root package name */
    private static long f309811c = IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE;

    private final void d(Function1<Object, Unit> callback, int ret, String data) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", ret);
        jSONObject.put("data", data);
        if (callback != null) {
            callback.invoke(jSONObject.toString());
        }
    }

    static /* synthetic */ void e(as asVar, Function1 function1, int i3, String str, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str = "";
        }
        asVar.d(function1, i3, str);
    }

    private final int f(String path, String key, String host, AppInterface appInterface) {
        if (TextUtils.isEmpty(path)) {
            return -6;
        }
        if (TextUtils.isEmpty(key)) {
            return -7;
        }
        if (appInterface != null && appInterface.isLogin()) {
            if (host == null) {
                QLog.i("VasKuiklyH5DataCacheImpl", 1, "writeH5Data host is null");
                return -13;
            }
            return 0;
        }
        return -11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(as this$0, String host, String path, String key, boolean z16, String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(key, "$key");
        this$0.m(2, host, path, key, "", z16);
        String str2 = f309810b + "/" + HexUtil.string2HexString(str) + "/" + host;
        if (!z16) {
            str2 = str2 + "/" + HexUtil.string2HexString(path);
            if (!TextUtils.isEmpty(key)) {
                str2 = str2 + "/" + HexUtil.string2HexString(key);
            }
        }
        if (com.tencent.mobileqq.webview.util.d.b(str2)) {
            e(this$0, function1, 0, null, 4, null);
        } else {
            e(this$0, function1, -5, null, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int i(String key, File pathDir, String encryptData) {
        FileWriter fileWriter;
        IOException e16;
        File file = new File(pathDir, HexUtil.string2HexString(key));
        if (file.exists()) {
            file.delete();
        }
        int i3 = -9;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
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
                fileWriter.write(encryptData);
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

    private final AppInterface j() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    private final long k() {
        File file = new File(f309810b);
        long j3 = 0;
        if (!file.exists()) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        while (!arrayList.isEmpty()) {
            Object remove = arrayList.remove(0);
            Intrinsics.checkNotNullExpressionValue(remove, "fileList.removeAt(0)");
            File file2 = (File) remove;
            if (file2.isFile()) {
                j3 += file2.length();
            } else {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    Collections.addAll(arrayList, Arrays.copyOf(listFiles, listFiles.length));
                }
            }
        }
        return j3;
    }

    private final String l(String data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = data.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            String sign = HexUtil.bytes2HexStr(messageDigest.digest());
            messageDigest.reset();
            Intrinsics.checkNotNullExpressionValue(sign, "sign");
            return sign;
        } catch (NoSuchAlgorithmException unused) {
            return "wronghash";
        }
    }

    private final String m(int actionType, String host, String path, String key, String hash, boolean isDelAllHostData) {
        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        String str;
        AppInterface j3 = j();
        CouponH5Data couponH5Data = null;
        if (j3 == null || (entityManagerFactory = j3.getEntityManagerFactory(j3.getAccount())) == null) {
            return null;
        }
        try {
            entityManager = entityManagerFactory.createEntityManager();
        } catch (RuntimeException e16) {
            QLog.e("VasKuiklyH5DataCacheImpl", 1, "operateHash createEntityManager error, app:", j3, " entityManagerFactory:", entityManagerFactory, " e:", e16);
            entityManager = null;
        }
        if (entityManager == null) {
            return null;
        }
        if (isDelAllHostData) {
            Entity find = DBMethodProxy.find(entityManager, CouponH5Data.class, "mHost = ?", new String[]{host});
            if (find instanceof CouponH5Data) {
                couponH5Data = (CouponH5Data) find;
            }
        } else {
            Entity find2 = DBMethodProxy.find(entityManager, CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[]{host, path, key});
            if (find2 instanceof CouponH5Data) {
                couponH5Data = (CouponH5Data) find2;
            }
        }
        if (actionType != 1) {
            if (actionType == 2) {
                if (TextUtils.isEmpty(key)) {
                    List<? extends Entity> query = entityManager.query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[]{host, path}, null, null, null, null);
                    if (query != null) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            CouponH5Data couponH5Data2 = (CouponH5Data) it.next();
                            if (couponH5Data2 != null) {
                                entityManager.remove(couponH5Data2);
                            }
                        }
                    }
                } else if (couponH5Data != null) {
                    entityManager.remove(couponH5Data);
                }
            }
        } else if (couponH5Data == null) {
            couponH5Data = new CouponH5Data(host, path, key, hash);
            entityManager.persist(couponH5Data);
        } else {
            couponH5Data.mData = hash;
            entityManager.update(couponH5Data);
        }
        entityManager.close();
        if (couponH5Data == null || (str = couponH5Data.mData) == null) {
            return "";
        }
        return str;
    }

    private final File n(String host, String path, String uin) {
        File file = new File(f309810b + "/" + HexUtil.string2HexString(uin));
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        File file2 = new File(file, host);
        if (!file2.exists()) {
            file2.mkdirs();
        } else if (file2.isFile()) {
            file2.delete();
            file2.mkdirs();
        }
        File file3 = new File(file2, HexUtil.string2HexString(path));
        if (!file3.exists()) {
            file3.mkdirs();
        } else if (file3.isFile()) {
            file3.delete();
            file3.mkdirs();
        }
        return file3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(as this$0, String host, String path, String key, Function1 function1, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        String m3 = this$0.m(0, host, path, key, "", false);
        if (m3 == null) {
            m3 = "";
        }
        if (TextUtils.isEmpty(m3)) {
            e(this$0, function1, -11, null, 4, null);
            return;
        }
        File file = new File(f309810b + "/" + HexUtil.string2HexString(uin) + "/" + host + "/" + HexUtil.string2HexString(path) + "/" + HexUtil.string2HexString(key));
        if (!file.exists()) {
            e(this$0, function1, -11, null, 4, null);
        } else {
            this$0.q(function1, m3, file);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q(Function1<Object, Unit> callback, String hash, File file) {
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    synchronized (this) {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                long length = file.length();
                                try {
                                    if (length <= 0) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("ret", -11);
                                        if (callback != null) {
                                            callback.invoke(jSONObject.toString());
                                        }
                                        fileInputStream2.close();
                                        return;
                                    }
                                    byte[] bArr = new byte[(int) length];
                                    fileInputStream2.read(bArr);
                                    String str = new String(bArr, Charsets.UTF_8);
                                    if (TextUtils.isEmpty(str)) {
                                        e(this, callback, -11, null, 4, null);
                                        QLog.e("VasKuiklyH5DataCacheImpl", 1, "readDataFile string is null, byteData = " + bArr);
                                        fileInputStream2.close();
                                        return;
                                    }
                                    String decode = ThreeDes.decode(str, hash);
                                    if (decode == null) {
                                        e(this, callback, -11, null, 4, null);
                                        fileInputStream2.close();
                                        return;
                                    } else {
                                        d(callback, 0, decode);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                } catch (IOException unused) {
                                    fileInputStream = fileInputStream2;
                                    e(this, callback, -9, null, 4, null);
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
                                        } catch (IOException e16) {
                                            e16.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                fileInputStream = fileInputStream2;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    }
                    throw th;
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (IOException unused2) {
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(as this$0, String host, String path, String key, String hash, String uin, String data, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(hash, "$hash");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.m(1, host, path, key, hash, false);
        File n3 = this$0.n(host, path, uin);
        String encryptData = ThreeDes.encode(data, hash);
        Intrinsics.checkNotNullExpressionValue(encryptData, "encryptData");
        int i3 = this$0.i(key, n3, encryptData);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", i3);
        if (function1 != null) {
            function1.invoke(jSONObject.toString());
        }
    }

    public final void g(@NotNull String jsonStr, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        try {
            if (TextUtils.isEmpty(jsonStr)) {
                e(this, callback, -3, null, 4, null);
                return;
            }
            JSONObject jSONObject = new JSONObject(jsonStr);
            final String string = jSONObject.getString("host");
            Intrinsics.checkNotNullExpressionValue(string, "params.getString(\"host\")");
            final String string2 = jSONObject.getString("path");
            Intrinsics.checkNotNullExpressionValue(string2, "params.getString(\"path\")");
            final String string3 = jSONObject.getString("key");
            Intrinsics.checkNotNullExpressionValue(string3, "params.getString(\"key\")");
            final boolean optBoolean = jSONObject.optBoolean("delAllHostData");
            AppInterface j3 = j();
            try {
                int f16 = f(string2, string3, string, j3);
                if (f16 != 0) {
                    e(this, callback, f16, null, 4, null);
                } else {
                    final String currentAccountUin = j3.getCurrentAccountUin();
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.ar
                        @Override // java.lang.Runnable
                        public final void run() {
                            as.h(as.this, string, string2, string3, optBoolean, currentAccountUin, callback);
                        }
                    }, 64, null, false);
                }
            } catch (JSONException e16) {
                e = e16;
                e(this, callback, -2, null, 4, null);
                QLog.e("VasKuiklyH5DataCacheImpl", 1, "deleteData JSONException", e);
            } catch (Exception e17) {
                e = e17;
                e(this, callback, -14, null, 4, null);
                QLog.e("VasKuiklyH5DataCacheImpl", 1, "deleteData Exception", e);
            }
        } catch (JSONException e18) {
            e = e18;
        } catch (Exception e19) {
            e = e19;
        }
    }

    public final void o(@NotNull String jsonStr, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        try {
            if (TextUtils.isEmpty(jsonStr)) {
                e(this, callback, -3, null, 4, null);
                return;
            }
            JSONObject jSONObject = new JSONObject(jsonStr);
            final String string = jSONObject.getString("host");
            Intrinsics.checkNotNullExpressionValue(string, "params.getString(\"host\")");
            final String string2 = jSONObject.getString("path");
            Intrinsics.checkNotNullExpressionValue(string2, "params.getString(\"path\")");
            final String string3 = jSONObject.getString("key");
            Intrinsics.checkNotNullExpressionValue(string3, "params.getString(\"key\")");
            AppInterface j3 = j();
            try {
                int f16 = f(string2, string3, string, j3);
                if (f16 != 0) {
                    e(this, callback, f16, null, 4, null);
                    return;
                }
                final String currentAccountUin = j3.getCurrentAccountUin();
                Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appInterface.currentAccountUin");
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        as.p(as.this, string, string2, string3, callback, currentAccountUin);
                    }
                }, 64, null, false);
            } catch (JSONException e16) {
                e = e16;
                e(this, callback, -2, null, 4, null);
                QLog.e("VasKuiklyH5DataCacheImpl", 1, "readData JSONException", e);
            } catch (Exception e17) {
                e = e17;
                e(this, callback, -14, null, 4, null);
                QLog.e("VasKuiklyH5DataCacheImpl", 1, "readData Exception", e);
            }
        } catch (JSONException e18) {
            e = e18;
        } catch (Exception e19) {
            e = e19;
        }
    }

    public final void r(@NotNull String jsonStr, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        try {
            if (TextUtils.isEmpty(jsonStr)) {
                e(this, callback, -3, null, 4, null);
                return;
            }
            JSONObject jSONObject = new JSONObject(jsonStr);
            final String string = jSONObject.getString("host");
            Intrinsics.checkNotNullExpressionValue(string, "params.getString(\"host\")");
            final String string2 = jSONObject.getString("path");
            Intrinsics.checkNotNullExpressionValue(string2, "params.getString(\"path\")");
            final String string3 = jSONObject.getString("key");
            Intrinsics.checkNotNullExpressionValue(string3, "params.getString(\"key\")");
            final String string4 = jSONObject.getString("data");
            Intrinsics.checkNotNullExpressionValue(string4, "params.getString(\"data\")");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            int f16 = f(string2, string3, string, appInterface);
            if (TextUtils.isEmpty(string4)) {
                f16 = -8;
            }
            if (k() > f309811c) {
                f16 = -12;
            }
            int i3 = f16;
            if (i3 != 0) {
                e(this, callback, i3, null, 4, null);
                return;
            }
            final String currentAccountUin = appInterface.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appInterface.currentAccountUin");
            final String l3 = l(string4);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.ap
                @Override // java.lang.Runnable
                public final void run() {
                    as.s(as.this, string, string2, string3, l3, currentAccountUin, string4, callback);
                }
            }, 64, null, false);
        } catch (JSONException e16) {
            e(this, callback, -2, null, 4, null);
            QLog.e("VasKuiklyH5DataCacheImpl", 1, "writeData JSONException", e16);
        } catch (Exception e17) {
            e(this, callback, -14, null, 4, null);
            QLog.e("VasKuiklyH5DataCacheImpl", 1, "writeData Exception", e17);
        }
    }
}
