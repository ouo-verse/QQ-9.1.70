package com.tencent.mobileqq.wink.utils;

import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/l;", "", "", "filePath", "a", "folderPath", MimeTypeParser.ATTR_EXTENSION, "c", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f326716a = new l();

    l() {
    }

    @Nullable
    public final String a(@Nullable String filePath) {
        boolean z16;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return filePath;
        }
        String fileMd5 = SecUtil.getFileMd5(filePath);
        if (StringUtil.isEmpty(fileMd5)) {
            return b(filePath);
        }
        return fileMd5;
    }

    @NotNull
    public final String b(@NotNull String filePath) {
        boolean z16;
        int lastIndexOf$default;
        int lastIndexOf$default2;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (filePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filePath, ".", 0, false, 6, (Object) null);
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filePath, separator, 0, false, 6, (Object) null);
            if (lastIndexOf$default2 == -1) {
                if (lastIndexOf$default != -1) {
                    String substring = filePath.substring(0, lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    return substring;
                }
                return filePath;
            }
            if (lastIndexOf$default == -1) {
                String substring2 = filePath.substring(lastIndexOf$default2 + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                return substring2;
            }
            if (lastIndexOf$default2 < lastIndexOf$default) {
                String substring3 = filePath.substring(lastIndexOf$default2 + 1, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring3;
            }
            String substring4 = filePath.substring(lastIndexOf$default2 + 1);
            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String).substring(startIndex)");
            return substring4;
        }
        return filePath;
    }

    @Nullable
    public final String c(@Nullable String filePath, @NotNull String folderPath, @NotNull String extension) {
        boolean z16;
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(extension, "extension");
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return filePath;
        }
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Object a16 = com.tencent.videocut.utils.k.f384249b.a(filePath);
        if (a16 == null) {
            a16 = Long.valueOf(System.currentTimeMillis());
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(folderPath + "/" + a16 + "." + extension, "//", "/", false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "..", ".", false, 4, (Object) null);
        return replace$default2;
    }
}
