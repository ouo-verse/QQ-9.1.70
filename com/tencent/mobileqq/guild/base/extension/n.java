package com.tencent.mobileqq.guild.base.extension;

import com.tencent.biz.richframework.part.Part;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"T", "Lcom/tencent/biz/richframework/part/Part;", "", "key", "a", "(Lcom/tencent/biz/richframework/part/Part;Ljava/lang/String;)Ljava/lang/Object;", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class n {
    public static final <T> T a(@NotNull Part part, @NotNull String key) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) part.getHostFragment().requireArguments().get(key);
    }
}
