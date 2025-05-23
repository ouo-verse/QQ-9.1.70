package com.tencent.rdelivery.reshub.util;

import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.raft.standard.file.IRFile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/f;", "Lcom/tencent/raft/standard/file/IRFile;", "", "path", "destination", "", "overwrite", NotificationActivity.PASSWORD, "", "unzipFileAtPath", "a", "Z", "preferZipFileForUnzipping", "<init>", "(Z)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class f implements IRFile {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean preferZipFileForUnzipping;

    public f(boolean z16) {
        this.preferZipFileForUnzipping = z16;
    }

    @Override // com.tencent.raft.standard.file.IRFile
    public int unzipFileAtPath(@NotNull String path, @NotNull String destination, boolean overwrite, @NotNull String password) {
        boolean c16;
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(password, "password");
        com.tencent.rdelivery.reshub.core.j.L.I();
        if (this.preferZipFileForUnzipping) {
            c16 = com.tencent.rdelivery.reshub.util.zip.c.e(path, destination);
        } else {
            c16 = com.tencent.rdelivery.reshub.util.zip.c.c(path, destination);
        }
        if (c16) {
            return 0;
        }
        return -1;
    }

    public /* synthetic */ f(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
