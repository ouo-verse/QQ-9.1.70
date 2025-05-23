package com.tencent.mobileqq.guild.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\f\u001a\u00020\t*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/data/o;", "", "a", "(Lcom/tencent/mobileqq/guild/data/o;)Ljava/lang/String;", "logString", "", "b", "(Lcom/tencent/mobileqq/guild/data/o;)J", "progress", "", "c", "(Lcom/tencent/mobileqq/guild/data/o;)Z", "isStateInKeyLogPoint", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class p {
    @NotNull
    public static final String a(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        return "{id:" + oVar.getFileId() + ", result:" + oVar.getErrCode() + ", errMsg:" + oVar.getErrMsg() + ", isActive:" + oVar.isActive() + ", state=" + oVar.getState() + ", isCompleted:" + oVar.isCompleted() + ", isFinishSuccess:" + oVar.e() + ", isFinishError:" + oVar.j() + ", isCancelled:" + oVar.isCompleted() + " url:" + oVar.getUrl() + ", videoId:" + oVar.f() + ", progress:" + b(oVar) + ",  upSize:" + oVar.i() + ", totalSize:" + oVar.d() + " coverUrl:" + oVar.getCoverUrl() + '}';
    }

    public static final long b(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        if (oVar.d() <= 0) {
            return 0L;
        }
        return (oVar.i() * 100) / oVar.d();
    }

    public static final boolean c(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        if ((!oVar.isActive() && !oVar.isCompleted()) || oVar.isCompleted() || oVar.isCancelled()) {
            return true;
        }
        if (!oVar.isActive()) {
            return false;
        }
        long b16 = b(oVar);
        if ((b16 == 0 && oVar.i() == 0) || b16 == 50 || b16 == 100) {
            return true;
        }
        return false;
    }
}
