package com.tencent.mobileqq.search.util;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/search/util/af;", "", "", "content", "", "maxLen", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final af f284993a = new af();

    af() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable String content, int maxLen) {
        if (content == null) {
            return "";
        }
        if (!QLog.isDebugVersion()) {
            String w3 = cq.w(content, maxLen);
            Intrinsics.checkNotNullExpressionValue(w3, "{\n            QQNTWrappe\u2026ontent, maxLen)\n        }");
            return w3;
        }
        return content;
    }

    public static /* synthetic */ String b(String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 2;
        }
        return a(str, i3);
    }
}
