package com.tencent.rdelivery.reshub.core;

import android.app.Application;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.raft.standard.file.IRFile;
import com.tencent.raft.standard.net.IRDownload;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.rdelivery.reshub.api.ResHubParams;
import com.tencent.rdelivery.reshub.api.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u001a*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u001a\u0006\u0010\u000b\u001a\u00020\n\u001a\b\u0010\r\u001a\u00020\fH\u0000\u001a\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/raft/standard/file/IRFile;", "f", "", "path", "destination", "", "overwrite", NotificationActivity.PASSWORD, "", "a", "Lcom/tencent/raft/standard/net/IRDownload;", "e", "Landroid/app/Application;", "d", "Lcom/tencent/rdelivery/reshub/api/s;", tl.h.F, "Lcom/tencent/raft/standard/storage/IRStorage;", "c", "resId", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "g", "Lcom/tencent/rdelivery/reshub/api/a;", "Ljz3/e;", DownloadInfo.spKey_Config, "i", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "j", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class g {
    public static final int a(@NotNull String path, @NotNull String destination, boolean z16, @NotNull String password) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        Intrinsics.checkParameterIsNotNull(password, "password");
        return f().unzipFileAtPath(path, destination, z16, password);
    }

    public static /* synthetic */ int b(String str, String str2, boolean z16, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            str3 = "";
        }
        return a(str, str2, z16, str3);
    }

    @NotNull
    public static final IRStorage c() {
        return j.L.c();
    }

    @NotNull
    public static final Application d() {
        return j.L.d();
    }

    @NotNull
    public static final IRDownload e() {
        return j.L.i();
    }

    private static final IRFile f() {
        return j.L.p();
    }

    public static final int g(@NotNull String resId, @NotNull a appInfo) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        m M = j.L.M();
        if (M != null) {
            return M.a(appInfo, resId);
        }
        return 0;
    }

    @NotNull
    public static final ResHubParams h() {
        return j.L.w();
    }

    public static final boolean i(@NotNull com.tencent.rdelivery.reshub.api.a appInfo, @NotNull jz3.e config) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (config.A == 1) {
            return false;
        }
        return j.L.L().a(appInfo, config);
    }

    public static final boolean j(@NotNull k req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        jz3.e resConfig = req.getResConfig();
        if (resConfig != null) {
            return i(req.getAppInfo(), resConfig);
        }
        return false;
    }
}
