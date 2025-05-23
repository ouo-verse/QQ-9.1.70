package com.tencent.gdtad.downloader;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.io.Closeable;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/gdtad/downloader/k;", "", "Ljava/io/Closeable;", "cursor", "", "a", "", "url", "c", "", "d", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/open/downloadnew/DownloadInfo;", "b", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f109187a = new k();

    k() {
    }

    public final void a(@Nullable Closeable cursor) {
        if (cursor == null) {
            return;
        }
        try {
            cursor.close();
        } catch (Exception e16) {
            QLog.e("AdDownloadHelper", 1, "", e16);
        }
    }

    @NotNull
    public final DownloadInfo b(@NotNull JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        DownloadInfo downloadInfo = new DownloadInfo();
        String optString = json.optString("appId");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(DownloadConstants.PARAMS_APP_ID)");
        if (TextUtils.isEmpty(optString)) {
            optString = json.optString("appid");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"appid\")");
        }
        downloadInfo.f341184e = optString;
        downloadInfo.f341186f = json.optString(com.tencent.open.downloadnew.e.f341501j);
        downloadInfo.f341189h = json.optString("packageName");
        downloadInfo.f341191i = json.optString(com.tencent.open.downloadnew.e.f341503l);
        downloadInfo.S = json.optInt(com.tencent.open.downloadnew.e.f341502k);
        downloadInfo.C = json.optString(com.tencent.open.downloadnew.e.f341500i);
        boolean z16 = false;
        downloadInfo.Z = json.optInt(com.tencent.open.downloadnew.e.J, 0);
        downloadInfo.Y = json.optString(com.tencent.open.downloadnew.e.F);
        downloadInfo.f341183d0 = json.optString(com.tencent.open.downloadnew.e.L).equals("1");
        downloadInfo.f341181c0 = json.optString(com.tencent.open.downloadnew.e.K);
        downloadInfo.J = json.optInt(com.tencent.open.downloadnew.e.H, 0);
        downloadInfo.f341187f0 = json.optLong(com.tencent.open.downloadnew.e.I, 0L);
        downloadInfo.N = json.optInt(com.tencent.open.downloadnew.e.f341517z, 0);
        downloadInfo.E = json.optInt(com.tencent.open.downloadnew.e.f341506o, 0);
        downloadInfo.H = json.optString(com.tencent.open.downloadnew.e.f341495d);
        downloadInfo.I = json.optInt(com.tencent.open.downloadnew.e.f341496e, 0);
        if (json.optInt("isAutoInstall") == 1) {
            z16 = true;
        }
        downloadInfo.T = z16;
        downloadInfo.U = json.optBoolean(com.tencent.open.downloadnew.e.f341515x);
        downloadInfo.f341188g0 = json.optString("recommendId");
        downloadInfo.f341190h0 = json.optString("sourceFromServer");
        downloadInfo.f341193j0 = json.optString("traceId");
        downloadInfo.f341194k0 = json.optString("adId");
        downloadInfo.f341195l0 = json.optString("posId");
        downloadInfo.f341206v0 = json.optInt(VirtualAppProxy.KEY_DOWNLOAD_SCENE, 3);
        downloadInfo.m();
        return downloadInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r11, ".", 0, false, 6, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(@NotNull String url) {
        boolean z16;
        String str;
        int lastIndexOf$default;
        int i3;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String path = new URL(url).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "tempUrl.path");
            url = path;
        } catch (Throwable th5) {
            QLog.e("AdDownloadHelper", 1, "getFileSuffixByUrl error", th5);
        }
        if (url.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && lastIndexOf$default != -1 && (i3 = lastIndexOf$default + 1) < url.length()) {
            str = url.substring(i3);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        } else {
            str = "";
        }
        return "." + str;
    }

    public final boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100240", false);
    }
}
