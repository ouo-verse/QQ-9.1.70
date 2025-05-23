package com.tencent.mobileqq.zplan.utils;

import android.content.res.AssetManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/h;", "", "", "sourcePath", "destPath", "a", "url", "c", "md5Result", "", "", "b", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f335824a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock lock = new ReentrantLock();

    h() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b8, code lost:
    
        if (r2 == null) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String a(String sourcePath, String destPath) {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream;
        MessageDigest messageDigest;
        File file;
        File file2;
        ReentrantLock reentrantLock;
        BaseApplication baseApplication = BaseApplication.context;
        InputStream inputStream2 = null;
        r1 = null;
        String str = null;
        AssetManager assets = baseApplication != null ? baseApplication.getAssets() : null;
        if (assets == null) {
            return null;
        }
        String str2 = destPath + ".tmp";
        try {
            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            inputStream = assets.open(sourcePath);
            try {
                file = new File(destPath);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                file2 = new File(str2);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Exception unused) {
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    messageDigest.update(bArr, 0, read);
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                reentrantLock = lock;
                reentrantLock.lock();
            } catch (Exception unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                        throw th;
                    } catch (Exception unused5) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
            inputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedOutputStream = null;
        }
        try {
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
            reentrantLock.unlock();
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "md5Digest.digest()");
            str = HexUtil.bytes2HexStr(digest);
            try {
                inputStream.close();
            } catch (Exception unused7) {
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception unused8) {
                return str;
            }
        } catch (Throwable th8) {
            reentrantLock.unlock();
            throw th8;
        }
    }

    public final Map<String, List<String>> b(String md5Result) {
        Intrinsics.checkNotNullParameter(md5Result, "md5Result");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(md5Result);
        linkedHashMap.put("Etag", arrayList);
        return linkedHashMap;
    }

    public final String c(String url, String destPath) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(destPath, "destPath");
        if (!ZPlanFeatureSwitch.f369852a.x()) {
            return null;
        }
        if (url.length() == 0) {
            return null;
        }
        String replace = new Regex(".*resources").replace(url, "");
        if (replace.length() == 0) {
            return null;
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) replace, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        CharSequence charSequence = replace;
        if (indexOf$default > 0) {
            charSequence = replace.subSequence(0, indexOf$default);
        }
        return a(ZPlanApiImpl.FILAMENT_TAG + ((Object) charSequence), destPath);
    }
}
