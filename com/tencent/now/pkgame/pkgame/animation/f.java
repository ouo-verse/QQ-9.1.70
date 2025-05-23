package com.tencent.now.pkgame.pkgame.animation;

import com.tencent.component.core.log.LogUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/animation/f;", "", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "a", "", "d", "", "url", "", "c", "b", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "Z", "needShowPkFireAnim", "", "Ljava/util/List;", "apngResList", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f338957a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAegisLogApi aegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final boolean needShowPkFireAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> apngResList;

    static {
        List<String> mutableListOf;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        aegisLog = (IAegisLogApi) api;
        boolean isHighPerfDevice = DeviceInfoUtils.isHighPerfDevice();
        needShowPkFireAnim = isHighPerfDevice;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLBkE0DpdMDvrCA31vaY71vGNk5MwkmyrIE2TjkJfeTWfQ/");
        apngResList = mutableListOf;
        if (isHighPerfDevice) {
            mutableListOf.add("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEJ3KEZ1DBTgFTxxdENGzoZbtTl61Bgj5yiaTvp2bJLqm9w/");
            mutableListOf.add("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEIKdIZoibWQ0kPOwHWD4bXiaxjicDZqvGM0XpwJcY0ibBFPpA/");
        }
    }

    f() {
    }

    private final ApngOptions a() {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(0);
        apngOptions.setUseCache(true);
        return apngOptions;
    }

    public final boolean b() {
        boolean z16;
        if (c("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEJ3KEZ1DBTgFTxxdENGzoZbtTl61Bgj5yiaTvp2bJLqm9w/") && c("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEIKdIZoibWQ0kPOwHWD4bXiaxjicDZqvGM0XpwJcY0ibBFPpA/")) {
            z16 = true;
        } else {
            z16 = false;
        }
        aegisLog.i("PKApngResLoader", "isFireAPNGReady:" + z16);
        return z16;
    }

    public final boolean c(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("PKApngResLoader", url, a());
        if (apngURLDrawable != null && apngURLDrawable.getFileInLocal() != null && apngURLDrawable.getFileInLocal().exists()) {
            aegisLog.i("PKApngResLoader", 1, "Apng resources is load success.");
            return true;
        }
        return false;
    }

    public final void d() {
        IAegisLogApi iAegisLogApi = aegisLog;
        boolean z16 = needShowPkFireAnim;
        List<String> list = apngResList;
        iAegisLogApi.i("PKApngResLoader", "needShowPkFire:" + z16 + ", apngList.size:" + list.size());
        for (String str : list) {
            f fVar = f338957a;
            if (fVar.c(str)) {
                LogUtil.i("PKApngResLoader", "APNG is ready, url: " + str, new Object[0]);
            } else {
                URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("PKApngResLoader", str, fVar.a());
                if (apngURLDrawable != null) {
                    apngURLDrawable.startDownload();
                }
            }
        }
    }
}
