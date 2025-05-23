package com.tencent.gamematrix.gmcg.base.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.core.content.ContextCompat;

/* loaded from: classes6.dex */
public class CGPermissionUtil {
    public static boolean hasPermissions(@NonNull Context context, @NonNull @Size(min = 1) String... strArr) {
        if (context != null) {
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("Can't check permissions for null context");
    }
}
