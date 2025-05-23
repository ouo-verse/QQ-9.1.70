package com.tencent.mobileqq.guild.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/data/t;", "", "", "e", "()Z", "isFinishSuccess", "j", "isFinishError", "isCancelled", "isCompleted", "isActive", "", "c", "()J", "originSize", "i", "totalUploadFileSize", "d", "totalFileSize", "", "getErrCode", "()I", "errCode", "", "getErrMsg", "()Ljava/lang/String;", "errMsg", "getState", "state", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface t {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull t tVar) {
            if (!tVar.e() && !tVar.j()) {
                return false;
            }
            return true;
        }
    }

    long c();

    long d();

    boolean e();

    int getErrCode();

    @NotNull
    String getErrMsg();

    int getState();

    long i();

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    boolean j();
}
