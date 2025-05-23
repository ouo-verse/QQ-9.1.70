package com.tencent.state.utils;

import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/utils/RegexUtils;", "", "()V", "TAG", "", "isValidUrl", "", "test", "checkSuffix", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RegexUtils {
    public static final RegexUtils INSTANCE = new RegexUtils();
    private static final String TAG = "RegexUtils";

    RegexUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isValidUrl(String test, boolean checkSuffix) {
        boolean z16;
        boolean startsWith;
        boolean startsWith2;
        boolean startsWith3;
        boolean isBlank;
        if (test != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(test);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                if (!checkSuffix) {
                    startsWith = StringsKt__StringsJVMKt.startsWith(test, "http://", true);
                    if (!startsWith) {
                        startsWith2 = StringsKt__StringsJVMKt.startsWith(test, "https://", true);
                        if (!startsWith2) {
                            startsWith3 = StringsKt__StringsJVMKt.startsWith(test, "file://", true);
                            if (!startsWith3) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
                return new Regex("https?:\\/\\/(.+\\/)+.+(\\.(gif|png|jpg|jpeg|webp|svg|psd|bmp|tif|pag))").matches(test);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public static /* synthetic */ boolean isValidUrl$default(RegexUtils regexUtils, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return regexUtils.isValidUrl(str, z16);
    }
}
