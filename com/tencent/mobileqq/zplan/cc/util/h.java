package com.tencent.mobileqq.zplan.cc.util;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/h;", "", "", "path", "", "a", "filePath", "b", WadlProxyConsts.PARAM_FILENAME, "c", "str", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f332563a = new h();

    h() {
    }

    public final boolean a(String path) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) path, "assets", 0, false, 6, (Object) null);
        return indexOf$default >= 0 || new File(path).exists();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r10, '.', 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(String filePath) {
        int lastIndexOf$default;
        if (filePath == null) {
            return "";
        }
        if ((filePath.length() == 0) || lastIndexOf$default <= 0) {
            return "";
        }
        String substring = filePath.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String c(String fileName) {
        String b16 = b(fileName);
        if (b16.length() == 0) {
            return "";
        }
        return "." + b16;
    }

    public final boolean d(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }
}
