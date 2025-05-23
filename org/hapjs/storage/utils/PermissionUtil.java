package org.hapjs.storage.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eR-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lorg/hapjs/storage/utils/PermissionUtil;", "", "()V", "sPlatformMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSPlatformMap", "()Ljava/util/HashMap;", "chooseExistPlatform", "", "context", "Landroid/content/Context;", "isDebug", "", "isTrustedHost", "pkg", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class PermissionUtil {

    @NotNull
    public static final PermissionUtil INSTANCE = new PermissionUtil();

    @NotNull
    private static final HashMap<String, String> sPlatformMap;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        sPlatformMap = hashMap;
        hashMap.put("com.nearme.instant.platform", "0e76297ae23cdb91dc06240a42bbe04b438951d68ef6e43e1ea0bde6c76d4250");
        hashMap.put("com.coloros.assistantscreen", "64aafaf1d5bc9155a9e417a849e4f8eda1d0d1341667c28ed7c443c76f820b9a");
        hashMap.put("com.android.launcher", "fc98dae63ad39626c8c67fbe83f2f06f74932a9cd146b92cecfc6a047a904386");
        hashMap.put("com.oppo.launcher", "36f2b10b97a86d741989553eb8ecb8d8e4f07d8d0cf2a77da9a70dbdb9eca661");
    }

    PermissionUtil() {
    }

    @Nullable
    public final Map<String, String> chooseExistPlatform(@NotNull Context context, boolean isDebug) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap<String, String> hashMap = sPlatformMap;
        if (hashMap != null && !hashMap.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            PackageManager pm5 = context.getPackageManager();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                PackageUtil packageUtil = PackageUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(pm5, "pm");
                PackageInfo packageInfo = packageUtil.getPackageInfo(pm5, key);
                if (packageInfo != null) {
                    String sha256 = packageUtil.getSha256(packageInfo.signatures[0].toByteArray());
                    if (isDebug || TextUtils.equals(sha256, value)) {
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(sha256)) {
                            Intrinsics.checkNotNull(key);
                            Intrinsics.checkNotNull(sha256);
                            hashMap2.put(key, sha256);
                        }
                    }
                }
            }
            return hashMap2;
        }
        return null;
    }

    @NotNull
    public final HashMap<String, String> getSPlatformMap() {
        return sPlatformMap;
    }

    public final boolean isTrustedHost(@NotNull Context context, @Nullable String pkg, boolean isDebug) {
        Map<String, String> chooseExistPlatform;
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(pkg)) {
            return false;
        }
        PackageManager pm5 = context.getPackageManager();
        PackageUtil packageUtil = PackageUtil.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(pm5, "pm");
        String appSignSha256 = packageUtil.getAppSignSha256(pm5, pkg);
        if (TextUtils.isEmpty(appSignSha256)) {
            return false;
        }
        if (!isDebug && ((chooseExistPlatform = chooseExistPlatform(context, isDebug)) == null || !TextUtils.equals(appSignSha256, chooseExistPlatform.get(pkg)))) {
            return false;
        }
        return true;
    }
}
