package com.tencent.biz.qqcircle.comment.abovebar;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"", "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class l {
    @NotNull
    public static final String a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String replace = new Regex("\\[em\\][^\\[]*\\[/em\\]").replace(new Regex("\\s+").replace(new Regex("@\\{uin:\\d+,nick:[^}]*\\}").replace(new Regex("#\\{tagName=[^}]*\\}").replace(str, ""), ""), ""), "");
        QLog.d("QFSCommentRecPicBar", 1, "[filterPatter] originStr =" + str + ", resultStr =" + replace);
        return replace;
    }
}
