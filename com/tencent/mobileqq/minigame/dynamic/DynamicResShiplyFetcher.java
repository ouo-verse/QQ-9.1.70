package com.tencent.mobileqq.minigame.dynamic;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.n;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004JJ\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2:\u0010\u0014\u001a6\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/minigame/dynamic/DynamicResShiplyFetcher;", "", "Lcom/tencent/rdelivery/reshub/api/g;", "res", "", "pageName", "getDexPathFile", WadlProxyConsts.PARAM_FILENAME, "appendDexPath", "", "getResVersion", "getDexPagePath", "", "forceUpdate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "", "result", "updateDexRes", "Lcom/tencent/rdelivery/reshub/api/i;", "resHub", "Lcom/tencent/rdelivery/reshub/api/i;", "resId", "Ljava/lang/String;", "validateResFile", "Z", "latestResInfo", "Lcom/tencent/rdelivery/reshub/api/g;", "<init>", "(Lcom/tencent/rdelivery/reshub/api/i;Ljava/lang/String;Z)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class DynamicResShiplyFetcher {
    public static final String TAG = "DynamicResShiplyFetcher";
    private g latestResInfo;
    private final i resHub;
    private final String resId;
    private final boolean validateResFile;

    public DynamicResShiplyFetcher(i resHub, String resId, boolean z16) {
        Intrinsics.checkNotNullParameter(resHub, "resHub");
        Intrinsics.checkNotNullParameter(resId, "resId");
        this.resHub = resHub;
        this.resId = resId;
        this.validateResFile = z16;
        long currentTimeMillis = System.currentTimeMillis();
        this.latestResInfo = resHub.q(resId, z16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private final String getDexPathFile(g res, String pageName) {
        String appendDexPath = appendDexPath(res, pageName + ".apk");
        if (appendDexPath == null || !new File(appendDexPath).exists()) {
            return null;
        }
        return appendDexPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDexRes$lambda$0(DynamicResShiplyFetcher this$0, DynamicResShiplyFetcher$updateDexRes$resCallback$1 resCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resCallback, "$resCallback");
        this$0.resHub.j(this$0.resId, resCallback, true);
    }

    public final String getDexPagePath(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return getDexPathFile(this.latestResInfo, pageName);
    }

    public final long getResVersion() {
        g gVar = this.latestResInfo;
        if (gVar != null) {
            return gVar.getVersion();
        }
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.minigame.dynamic.DynamicResShiplyFetcher$updateDexRes$resCallback$1] */
    public final void updateDexRes(final boolean forceUpdate, final Function2<? super Boolean, ? super String, Unit> result) {
        final ?? r06 = new h() { // from class: com.tencent.mobileqq.minigame.dynamic.DynamicResShiplyFetcher$updateDexRes$resCallback$1
            @Override // com.tencent.rdelivery.reshub.api.h
            public void onComplete(boolean isSuccess, g res, n error) {
                Intrinsics.checkNotNullParameter(error, "error");
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                QLog.i(DynamicResShiplyFetcher.TAG, 1, "[updateDexRes] forceUpdate:" + forceUpdate + " isSuccess:" + isSuccess + " updateCost:" + serverTimeMillis + " error: " + error.b() + "," + error.message() + ", res:" + res);
                if (forceUpdate) {
                    this.latestResInfo = res;
                }
                if (isSuccess && res != null) {
                    Function2<Boolean, String, Unit> function2 = result;
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, null);
                        return;
                    }
                    return;
                }
                Function2<Boolean, String, Unit> function22 = result;
                if (function22 != null) {
                    function22.invoke(Boolean.FALSE, "updateDexRes error " + error.b() + ", " + error.message());
                }
            }

            @Override // com.tencent.rdelivery.reshub.api.h
            public void onProgress(float f16) {
                h.a.a(this, f16);
            }
        };
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.dynamic.a
            @Override // java.lang.Runnable
            public final void run() {
                DynamicResShiplyFetcher.updateDexRes$lambda$0(DynamicResShiplyFetcher.this, r06);
            }
        }, 128, null, true);
    }

    private final String appendDexPath(g res, String fileName) {
        if (res == null) {
            return null;
        }
        return res.e() + fileName;
    }

    public /* synthetic */ DynamicResShiplyFetcher(i iVar, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, str, (i3 & 4) != 0 ? true : z16);
    }
}
