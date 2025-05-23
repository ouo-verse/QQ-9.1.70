package com.tencent.mobileqq.guild.base.extension;

import com.tencent.mobileqq.guild.util.ch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ7\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/base/extension/r;", "", "Lmqq/app/api/IRuntimeService;", "T", "Ljava/lang/Class;", "clazz", "", "process", "a", "(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;", "tag", "c", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class r {

    /* renamed from: a */
    @NotNull
    public static final r f214743a = new r();

    r() {
    }

    public static /* synthetic */ IRuntimeService b(r rVar, Class cls, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        return rVar.a(cls, str);
    }

    public static /* synthetic */ IRuntimeService d(r rVar, Class cls, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return rVar.c(cls, str, str2);
    }

    @NotNull
    public final <T extends IRuntimeService> T a(@NotNull Class<T> clazz, @NotNull String process) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(process, "process");
        T t16 = (T) ch.S0(clazz, process);
        Intrinsics.checkNotNullExpressionValue(t16, "runtimeService(clazz, process)");
        return t16;
    }

    @NotNull
    public final <T extends IRuntimeService> T c(@NotNull Class<T> clazz, @NotNull String tag, @NotNull String process) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(process, "process");
        return (T) MiscKt.c(clazz, tag, process);
    }
}
