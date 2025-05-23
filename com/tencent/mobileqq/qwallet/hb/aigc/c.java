package com.tencent.mobileqq.qwallet.hb.aigc;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.utils.an;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/c;", "", "", "path", "b", "c", "", "it", "", "f", "", "code", "errorMsg", "d", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f277218a = new c();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(long j3, String str) {
        boolean z16;
        boolean z17;
        if (1000 <= j3 && j3 < 10000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (j3 >= -9999 && j3 <= -1000)) {
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
                return;
            }
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci8, 0).show();
    }

    @Nullable
    public final String b(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return an.e(an.f326680a, path, 1920, 90, false, 8, null);
    }

    @NotNull
    public final String c(@NotNull String path) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(path, "path");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            String substring = path.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return "";
    }

    public final void d(final long code, @Nullable final String errorMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.b
            @Override // java.lang.Runnable
            public final void run() {
                c.e(code, errorMsg);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(@NotNull Throwable it) {
        List emptyList;
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            String message = it.getMessage();
            if (message == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (emptyList.size() == 2) {
                d(Long.parseLong((String) emptyList.get(0)), (String) emptyList.get(1));
            }
        } catch (Exception unused) {
            d(0L, "");
        }
    }
}
