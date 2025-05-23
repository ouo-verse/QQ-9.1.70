package com.tencent.mobileqq.vas.util;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/util/VersionUtil;", "", "()V", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VersionUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/util/VersionUtil$Companion;", "", "()V", "isLaterVersion", "", "compareVersion", "", "targetVersion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean isLaterVersion(@NotNull String compareVersion, @NotNull String targetVersion) {
            int parseInt;
            int parseInt2;
            Intrinsics.checkNotNullParameter(compareVersion, "compareVersion");
            Intrinsics.checkNotNullParameter(targetVersion, "targetVersion");
            if (!TextUtils.isEmpty(compareVersion) && !TextUtils.isEmpty(targetVersion)) {
                Object[] array = new Regex("\\.").split(compareVersion, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                Object[] array2 = new Regex("\\.").split(targetVersion, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array2;
                int max = Math.max(strArr.length, strArr2.length);
                for (int i3 = 0; i3 < max; i3++) {
                    if (i3 < strArr.length) {
                        try {
                            parseInt = Integer.parseInt(strArr[i3]);
                        } catch (Exception unused) {
                        }
                        if (i3 < strArr2.length) {
                            try {
                                parseInt2 = Integer.parseInt(strArr2[i3]);
                            } catch (Exception unused2) {
                            }
                            if (i3 != max - 1) {
                                if (parseInt2 > parseInt) {
                                    return true;
                                }
                                if (parseInt2 < parseInt) {
                                    return false;
                                }
                            } else {
                                if (parseInt2 >= parseInt) {
                                    return true;
                                }
                                if (parseInt2 < parseInt) {
                                    return false;
                                }
                            }
                        }
                        parseInt2 = 0;
                        if (i3 != max - 1) {
                        }
                    }
                    parseInt = 0;
                    if (i3 < strArr2.length) {
                    }
                    parseInt2 = 0;
                    if (i3 != max - 1) {
                    }
                }
            }
            return false;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final boolean isLaterVersion(@NotNull String str, @NotNull String str2) {
        return INSTANCE.isLaterVersion(str, str2);
    }
}
