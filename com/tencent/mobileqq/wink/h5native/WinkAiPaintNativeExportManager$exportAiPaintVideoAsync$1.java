package com.tencent.mobileqq.wink.h5native;

import android.os.SystemClock;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.c;
import com.tencent.mobileqq.wink.h5native.RenderReq;
import com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1", f = "WinkAiPaintNativeExportManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7}, l = {156, 158, 870, 178, 183, 186, 190, 881}, m = "invokeSuspend", n = {"$this$launch", "fetchLightResJob", "startTime", "loadTemplateStartTime", "$this$launch", "fetchLightResJob", "startTime", "loadTemplateStartTime", "$this$launch", "fetchLightResJob", "renderReq", "$this$withLock_u24default$iv", "startTime", "loadTemplateStartTime", "fetchLightResJob", "renderReq", "cacheDir", "downloadImagesJob", "startTime", "loadTemplateStartTime", "fetchLightResJob", "renderReq", "cacheDir", WadlProxyConsts.KEY_MATERIAL, "startTime", "renderReq", "cacheDir", WadlProxyConsts.KEY_MATERIAL, "imagesFiles", "startTime", "cacheDir", WadlProxyConsts.KEY_MATERIAL, "startTime", "cacheDir", WadlProxyConsts.KEY_MATERIAL, "videoPath", "$this$withLock_u24default$iv", "startTime"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
/* loaded from: classes21.dex */
public final class WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $reportParams;
    final /* synthetic */ ExportAiPaintVideoAsyncRequest $request;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1(ExportAiPaintVideoAsyncRequest exportAiPaintVideoAsyncRequest, Map<String, String> map, Continuation<? super WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1> continuation) {
        super(2, continuation);
        this.$request = exportAiPaintVideoAsyncRequest;
        this.$reportParams = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1 winkAiPaintNativeExportManager$exportAiPaintVideoAsync$1 = new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1(this.$request, this.$reportParams, continuation);
        winkAiPaintNativeExportManager$exportAiPaintVideoAsync$1.L$0 = obj;
        return winkAiPaintNativeExportManager$exportAiPaintVideoAsync$1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x024d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x022a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02d9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        long elapsedRealtime;
        Deferred async$default;
        long elapsedRealtime2;
        Job job;
        Object d06;
        Job job2;
        String L;
        RenderReq fromJsonStr;
        Mutex mutex;
        CoroutineScope coroutineScope2;
        Deferred deferred;
        RenderReq renderReq;
        Mutex mutex2;
        Deferred deferred2;
        Deferred async$default2;
        String U;
        String str;
        Deferred async$default3;
        Object await;
        Object await2;
        MetaMaterial metaMaterial;
        List list;
        MetaMaterial metaMaterial2;
        String str2;
        RenderReq renderReq2;
        long j3;
        PlaceHolder placeHolders;
        List<String> list2;
        Object Q;
        MetaMaterial metaMaterial3;
        String str3;
        String str4;
        Mutex mutex3;
        Map<String, String> map;
        long j16;
        String R;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                elapsedRealtime = SystemClock.elapsedRealtime();
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, WinkCoroutineScopes.f317652a.c(), null, new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$fetchLightResJob$1(this.$reportParams, null), 2, null);
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                job = WinkAiPaintNativeExportManager.queryMaterialJob;
                if (job != null) {
                    job2 = WinkAiPaintNativeExportManager.queryMaterialJob;
                    if (job2 != null) {
                        this.L$0 = coroutineScope;
                        this.L$1 = async$default;
                        this.J$0 = elapsedRealtime;
                        this.J$1 = elapsedRealtime2;
                        this.label = 1;
                        if (job2.join(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = WinkAiPaintNativeExportManager.f322863a;
                    this.L$0 = coroutineScope;
                    this.L$1 = async$default;
                    this.J$0 = elapsedRealtime;
                    this.J$1 = elapsedRealtime2;
                    this.label = 2;
                    d06 = winkAiPaintNativeExportManager.d0(this);
                    if (d06 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Deferred deferred3 = async$default;
                CoroutineScope coroutineScope3 = coroutineScope;
                RenderReq.Companion companion = RenderReq.INSTANCE;
                L = WinkAiPaintNativeExportManager.f322863a.L(this.$request.getRenderReq());
                fromJsonStr = companion.fromJsonStr(L);
                if (fromJsonStr == null) {
                    mutex = WinkAiPaintNativeExportManager.syncMutex;
                    this.L$0 = coroutineScope3;
                    this.L$1 = deferred3;
                    this.L$2 = fromJsonStr;
                    this.L$3 = mutex;
                    this.J$0 = elapsedRealtime;
                    this.J$1 = elapsedRealtime2;
                    this.label = 3;
                    if (mutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope2 = coroutineScope3;
                    deferred = deferred3;
                    renderReq = fromJsonStr;
                    mutex2 = mutex;
                    deferred2 = deferred;
                    try {
                        WinkAiPaintNativeExportManager winkAiPaintNativeExportManager2 = WinkAiPaintNativeExportManager.f322863a;
                        WinkAiPaintNativeExportManager.currentTraceID = renderReq.getTraceID();
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
                        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope2, winkCoroutineScopes.c(), null, new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1(renderReq, this.$reportParams, null), 2, null);
                        U = WinkAiPaintNativeExportManager.f322863a.U();
                        str = U;
                        async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope2, winkCoroutineScopes.c(), null, new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1(renderReq, U, null), 2, null);
                        this.L$0 = deferred2;
                        this.L$1 = renderReq;
                        this.L$2 = str;
                        this.L$3 = async$default3;
                        this.J$0 = elapsedRealtime;
                        this.J$1 = elapsedRealtime2;
                        this.label = 4;
                        await = async$default2.await(this);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        MetaMaterial metaMaterial4 = (MetaMaterial) await;
                        WinkAiPaintNativeExportManager winkAiPaintNativeExportManager3 = WinkAiPaintNativeExportManager.f322863a;
                        winkAiPaintNativeExportManager3.e0(this.$reportParams, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_TEMPLATE_TIME, elapsedRealtime2);
                        winkAiPaintNativeExportManager3.I(metaMaterial4, str);
                        this.L$0 = deferred2;
                        this.L$1 = renderReq;
                        this.L$2 = str;
                        this.L$3 = metaMaterial4;
                        this.J$0 = elapsedRealtime;
                        this.label = 5;
                        await2 = async$default3.await(this);
                        if (await2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        metaMaterial = metaMaterial4;
                        List list3 = (List) await2;
                        this.L$0 = renderReq;
                        this.L$1 = str;
                        this.L$2 = metaMaterial;
                        this.L$3 = list3;
                        this.J$0 = elapsedRealtime;
                        this.label = 6;
                        if (deferred2.join(this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list = list3;
                        metaMaterial2 = metaMaterial;
                        str2 = str;
                        renderReq2 = renderReq;
                        j3 = elapsedRealtime;
                        WinkAiPaintNativeExportManager winkAiPaintNativeExportManager4 = WinkAiPaintNativeExportManager.f322863a;
                        winkAiPaintNativeExportManager4.e0(this.$reportParams, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, j3);
                        placeHolders = renderReq2.getPlaceHolders();
                        if (placeHolders == null) {
                            list2 = placeHolders.getText();
                        } else {
                            list2 = null;
                        }
                        Map<String, String> map2 = this.$reportParams;
                        this.L$0 = str2;
                        this.L$1 = metaMaterial2;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.J$0 = j3;
                        this.label = 7;
                        Q = winkAiPaintNativeExportManager4.Q(metaMaterial2, list, list2, str2, map2, this);
                        if (Q != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        metaMaterial3 = metaMaterial2;
                        str3 = str2;
                        str4 = (String) Q;
                        mutex3 = WinkAiPaintNativeExportManager.syncMutex;
                        map = this.$reportParams;
                        this.L$0 = str3;
                        this.L$1 = metaMaterial3;
                        this.L$2 = str4;
                        this.L$3 = mutex3;
                        this.L$4 = map;
                        this.J$0 = j3;
                        this.label = 8;
                        if (mutex3.lock(null, this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j16 = j3;
                        try {
                            WinkAiPaintNativeExportManager winkAiPaintNativeExportManager5 = WinkAiPaintNativeExportManager.f322863a;
                            WinkAiPaintNativeExportManager winkAiPaintNativeExportManager6 = WinkAiPaintNativeExportManager.f322863a;
                            R = winkAiPaintNativeExportManager6.R(str4, c.z(metaMaterial3), map);
                            WinkAiPaintNativeExportManager.currentExportResult = new GetExportAiPaintVideoResultResponse(0, "success", "https://qqcircle_aipainting_native_export.qq.com/local_files" + str4, "https://qqcircle_aipainting_native_export.qq.com/local_files" + str3 + "/data.mqr", R);
                            Unit unit2 = Unit.INSTANCE;
                            mutex3.unlock(null);
                            winkAiPaintNativeExportManager6.e0(this.$reportParams, WinkDengtaReportConstant.Params.REPORT_EXPORT_TOTAL_TIME, j16);
                            winkAiPaintNativeExportManager6.f0(this.$reportParams, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, 0);
                            w53.b.f("WinkAiPaintNativeExportManager", "export cost time: " + this.$reportParams);
                            e.o(e.f326265a, WinkDengtaReportConstant.Action.H5_NATIVE_EXPORT_EVENT_TIME, this.$reportParams, false, 4, null);
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            mutex3.unlock(null);
                            throw th5;
                        }
                    } catch (Throwable th6) {
                        mutex2.unlock(null);
                        throw th6;
                    }
                }
                throw new WinkAiPaintNativeExportManager.AiPaintVideoException(5, "invald request");
            case 1:
            case 2:
                elapsedRealtime2 = this.J$1;
                elapsedRealtime = this.J$0;
                async$default = (Deferred) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Deferred deferred32 = async$default;
                CoroutineScope coroutineScope32 = coroutineScope;
                RenderReq.Companion companion2 = RenderReq.INSTANCE;
                L = WinkAiPaintNativeExportManager.f322863a.L(this.$request.getRenderReq());
                fromJsonStr = companion2.fromJsonStr(L);
                if (fromJsonStr == null) {
                }
                break;
            case 3:
                elapsedRealtime2 = this.J$1;
                elapsedRealtime = this.J$0;
                mutex2 = (Mutex) this.L$3;
                RenderReq renderReq3 = (RenderReq) this.L$2;
                Deferred deferred4 = (Deferred) this.L$1;
                CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = coroutineScope4;
                deferred = deferred4;
                renderReq = renderReq3;
                deferred2 = deferred;
                WinkAiPaintNativeExportManager winkAiPaintNativeExportManager22 = WinkAiPaintNativeExportManager.f322863a;
                WinkAiPaintNativeExportManager.currentTraceID = renderReq.getTraceID();
                Unit unit3 = Unit.INSTANCE;
                mutex2.unlock(null);
                WinkCoroutineScopes winkCoroutineScopes2 = WinkCoroutineScopes.f317652a;
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope2, winkCoroutineScopes2.c(), null, new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1(renderReq, this.$reportParams, null), 2, null);
                U = WinkAiPaintNativeExportManager.f322863a.U();
                str = U;
                async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope2, winkCoroutineScopes2.c(), null, new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadImagesJob$1(renderReq, U, null), 2, null);
                this.L$0 = deferred2;
                this.L$1 = renderReq;
                this.L$2 = str;
                this.L$3 = async$default3;
                this.J$0 = elapsedRealtime;
                this.J$1 = elapsedRealtime2;
                this.label = 4;
                await = async$default2.await(this);
                if (await == coroutine_suspended) {
                }
                MetaMaterial metaMaterial42 = (MetaMaterial) await;
                WinkAiPaintNativeExportManager winkAiPaintNativeExportManager32 = WinkAiPaintNativeExportManager.f322863a;
                winkAiPaintNativeExportManager32.e0(this.$reportParams, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_TEMPLATE_TIME, elapsedRealtime2);
                winkAiPaintNativeExportManager32.I(metaMaterial42, str);
                this.L$0 = deferred2;
                this.L$1 = renderReq;
                this.L$2 = str;
                this.L$3 = metaMaterial42;
                this.J$0 = elapsedRealtime;
                this.label = 5;
                await2 = async$default3.await(this);
                if (await2 == coroutine_suspended) {
                }
                break;
            case 4:
                elapsedRealtime2 = this.J$1;
                elapsedRealtime = this.J$0;
                Deferred deferred5 = (Deferred) this.L$3;
                String str5 = (String) this.L$2;
                renderReq = (RenderReq) this.L$1;
                Deferred deferred6 = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
                str = str5;
                deferred2 = deferred6;
                async$default3 = deferred5;
                await = obj;
                MetaMaterial metaMaterial422 = (MetaMaterial) await;
                WinkAiPaintNativeExportManager winkAiPaintNativeExportManager322 = WinkAiPaintNativeExportManager.f322863a;
                winkAiPaintNativeExportManager322.e0(this.$reportParams, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_TEMPLATE_TIME, elapsedRealtime2);
                winkAiPaintNativeExportManager322.I(metaMaterial422, str);
                this.L$0 = deferred2;
                this.L$1 = renderReq;
                this.L$2 = str;
                this.L$3 = metaMaterial422;
                this.J$0 = elapsedRealtime;
                this.label = 5;
                await2 = async$default3.await(this);
                if (await2 == coroutine_suspended) {
                }
                break;
            case 5:
                long j17 = this.J$0;
                MetaMaterial metaMaterial5 = (MetaMaterial) this.L$3;
                String str6 = (String) this.L$2;
                RenderReq renderReq4 = (RenderReq) this.L$1;
                Deferred deferred7 = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
                str = str6;
                renderReq = renderReq4;
                deferred2 = deferred7;
                elapsedRealtime = j17;
                metaMaterial = metaMaterial5;
                await2 = obj;
                List list32 = (List) await2;
                this.L$0 = renderReq;
                this.L$1 = str;
                this.L$2 = metaMaterial;
                this.L$3 = list32;
                this.J$0 = elapsedRealtime;
                this.label = 6;
                if (deferred2.join(this) != coroutine_suspended) {
                }
                break;
            case 6:
                long j18 = this.J$0;
                list = (List) this.L$3;
                MetaMaterial metaMaterial6 = (MetaMaterial) this.L$2;
                String str7 = (String) this.L$1;
                renderReq2 = (RenderReq) this.L$0;
                ResultKt.throwOnFailure(obj);
                j3 = j18;
                metaMaterial2 = metaMaterial6;
                str2 = str7;
                WinkAiPaintNativeExportManager winkAiPaintNativeExportManager42 = WinkAiPaintNativeExportManager.f322863a;
                winkAiPaintNativeExportManager42.e0(this.$reportParams, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_ALL_RESOURCE_TIME, j3);
                placeHolders = renderReq2.getPlaceHolders();
                if (placeHolders == null) {
                }
                Map<String, String> map22 = this.$reportParams;
                this.L$0 = str2;
                this.L$1 = metaMaterial2;
                this.L$2 = null;
                this.L$3 = null;
                this.J$0 = j3;
                this.label = 7;
                Q = winkAiPaintNativeExportManager42.Q(metaMaterial2, list, list2, str2, map22, this);
                if (Q != coroutine_suspended) {
                }
                break;
            case 7:
                long j19 = this.J$0;
                MetaMaterial metaMaterial7 = (MetaMaterial) this.L$1;
                String str8 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                j3 = j19;
                metaMaterial3 = metaMaterial7;
                str3 = str8;
                Q = obj;
                str4 = (String) Q;
                mutex3 = WinkAiPaintNativeExportManager.syncMutex;
                map = this.$reportParams;
                this.L$0 = str3;
                this.L$1 = metaMaterial3;
                this.L$2 = str4;
                this.L$3 = mutex3;
                this.L$4 = map;
                this.J$0 = j3;
                this.label = 8;
                if (mutex3.lock(null, this) != coroutine_suspended) {
                }
                break;
            case 8:
                j16 = this.J$0;
                map = (Map) this.L$4;
                mutex3 = (Mutex) this.L$3;
                str4 = (String) this.L$2;
                metaMaterial3 = (MetaMaterial) this.L$1;
                str3 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                WinkAiPaintNativeExportManager winkAiPaintNativeExportManager52 = WinkAiPaintNativeExportManager.f322863a;
                WinkAiPaintNativeExportManager winkAiPaintNativeExportManager62 = WinkAiPaintNativeExportManager.f322863a;
                R = winkAiPaintNativeExportManager62.R(str4, c.z(metaMaterial3), map);
                WinkAiPaintNativeExportManager.currentExportResult = new GetExportAiPaintVideoResultResponse(0, "success", "https://qqcircle_aipainting_native_export.qq.com/local_files" + str4, "https://qqcircle_aipainting_native_export.qq.com/local_files" + str3 + "/data.mqr", R);
                Unit unit22 = Unit.INSTANCE;
                mutex3.unlock(null);
                winkAiPaintNativeExportManager62.e0(this.$reportParams, WinkDengtaReportConstant.Params.REPORT_EXPORT_TOTAL_TIME, j16);
                winkAiPaintNativeExportManager62.f0(this.$reportParams, WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, 0);
                w53.b.f("WinkAiPaintNativeExportManager", "export cost time: " + this.$reportParams);
                e.o(e.f326265a, WinkDengtaReportConstant.Action.H5_NATIVE_EXPORT_EVENT_TIME, this.$reportParams, false, 4, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
