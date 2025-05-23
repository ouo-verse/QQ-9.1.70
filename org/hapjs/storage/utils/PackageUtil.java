package org.hapjs.storage.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lorg/hapjs/storage/utils/PackageUtil;", "", "()V", "HEX_ARRAY", "", "TAG", "", "byte2HexString", "bytes", "", "getAppSignSha256", "pm", "Landroid/content/pm/PackageManager;", "pkg", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "getSha256", "input", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class PackageUtil {
    private static final char[] HEX_ARRAY;

    @NotNull
    public static final PackageUtil INSTANCE = new PackageUtil();
    private static final String TAG = "PackageUtil";

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        HEX_ARRAY = charArray;
    }

    PackageUtil() {
    }

    @NotNull
    public final String byte2HexString(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] cArr = new char[bytes.length * 2];
        int length = bytes.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = bytes[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }

    @Nullable
    public final String getAppSignSha256(@NotNull PackageManager pm5, @Nullable String pkg) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(pm5, "pm");
        try {
            packageInfo = getPackageInfo(pm5, pkg);
        } catch (Exception e16) {
            Log.w(TAG, "getNativeAppSignMd5 error", e16);
        }
        if (packageInfo == null) {
            return null;
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr.length > 0) {
            return getSha256(signatureArr[0].toByteArray());
        }
        return null;
    }

    @Nullable
    public final PackageInfo getPackageInfo(@NotNull PackageManager pm5, @Nullable String pkg) {
        Intrinsics.checkNotNullParameter(pm5, "pm");
        try {
            Intrinsics.checkNotNull(pkg);
            return InstalledAppListMonitor.getPackageInfo(pm5, pkg, 64);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public final String getSha256(@Nullable byte[] input) {
        if (input != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
                messageDigest.update(input);
                byte[] digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "lDigest.digest()");
                return byte2HexString(digest);
            } catch (Exception e16) {
                Log.w(TAG, "getSha256 error", e16);
                return null;
            }
        }
        return null;
    }
}
