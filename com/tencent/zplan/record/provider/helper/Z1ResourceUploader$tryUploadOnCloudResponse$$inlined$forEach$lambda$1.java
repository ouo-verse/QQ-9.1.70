package com.tencent.zplan.record.provider.helper;

import android.webkit.URLUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.manager.ZPlanResourceUploader;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import dx4.e;
import ex4.LocalRecordStartResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/zplan/record/provider/helper/Z1ResourceUploader$tryUploadOnCloudResponse$3$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.helper.Z1ResourceUploader$tryUploadOnCloudResponse$3$1", f = "Z1ResourceUploader.kt", i = {0, 0, 1, 1, 1, 1}, l = {140, 146}, m = "invokeSuspend", n = {"resource", "startResult", "resource", "startResult", "uploadUrl", "success"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "Z$0"})
/* loaded from: classes27.dex */
public final class Z1ResourceUploader$tryUploadOnCloudResponse$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $currentUploadCallback$inlined;
    final /* synthetic */ Map.Entry $it;
    final /* synthetic */ String $tmpLogInfo$inlined;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ Z1ResourceUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z1ResourceUploader$tryUploadOnCloudResponse$$inlined$forEach$lambda$1(Map.Entry entry, Continuation continuation, Z1ResourceUploader z1ResourceUploader, String str, e eVar) {
        super(2, continuation);
        this.$it = entry;
        this.this$0 = z1ResourceUploader;
        this.$tmpLogInfo$inlined = str;
        this.$currentUploadCallback$inlined = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new Z1ResourceUploader$tryUploadOnCloudResponse$$inlined$forEach$lambda$1(this.$it, completion, this.this$0, this.$tmpLogInfo$inlined, this.$currentUploadCallback$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Z1ResourceUploader$tryUploadOnCloudResponse$$inlined$forEach$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0193  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ZPlanRecordResource zPlanRecordResource;
        LocalRecordStartResult localRecordStartResult;
        EngineType engineType;
        String str;
        Object f16;
        String str2;
        boolean z16;
        boolean z17;
        ZPlanRecordResource zPlanRecordResource2;
        String str3;
        Map<String, String> mapOf;
        d a16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    z17 = this.Z$0;
                    str3 = (String) this.L$2;
                    localRecordStartResult = (LocalRecordStartResult) this.L$1;
                    zPlanRecordResource2 = (ZPlanRecordResource) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Z1ResourceUploader z1ResourceUploader = this.this$0;
                    Intrinsics.checkNotNull(str3);
                    String i16 = z1ResourceUploader.i(str3);
                    a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.c(a16, "[ZPlanRRC]_Z1ResourceUploader", 1, this.$tmpLogInfo$inlined + ", uploadSuccess, taskId:" + localRecordStartResult.getTaskId() + ", finalUrl:" + i16, null, 8, null);
                    }
                    this.$currentUploadCallback$inlined.a(localRecordStartResult.getTaskId(), i16);
                    z16 = z17;
                    str2 = str3;
                    zPlanRecordResource = zPlanRecordResource2;
                    Z1ResourceUploader z1ResourceUploader2 = this.this$0;
                    String sender = z1ResourceUploader2.getParams().getSender();
                    long portraitId = localRecordStartResult.getCommonAction().getPortraitId();
                    int scene = this.this$0.getParams().getScene();
                    String name = this.this$0.getParams().getUploadConfig().getTarget().name();
                    String dressKey = zPlanRecordResource.getDressKey();
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uploadPath", localRecordStartResult.getUploadPath()), TuplesKt.to(MiniAppGetGameTaskTicketServlet.KEY_TASKID, localRecordStartResult.getTaskId()));
                    z1ResourceUploader2.j(sender, portraitId, scene, name, z16, str2, false, dressKey, mapOf);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LocalRecordStartResult localRecordStartResult2 = (LocalRecordStartResult) this.L$1;
            ZPlanRecordResource zPlanRecordResource3 = (ZPlanRecordResource) this.L$0;
            ResultKt.throwOnFailure(obj);
            f16 = obj;
            localRecordStartResult = localRecordStartResult2;
            zPlanRecordResource = zPlanRecordResource3;
        } else {
            ResultKt.throwOnFailure(obj);
            zPlanRecordResource = (ZPlanRecordResource) this.$it.getKey();
            localRecordStartResult = (LocalRecordStartResult) this.$it.getValue();
            BusinessConfig businessConfig = this.this$0.getParams().getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (businessConfig != null) {
                engineType = businessConfig.getTargetEngine();
            } else {
                engineType = null;
            }
            boolean z18 = engineType instanceof EngineType.Filament;
            if (localRecordStartResult.getNeedUpload()) {
                UploadConfig.UploadTarget target = this.this$0.getParams().getUploadConfig().getTarget();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(localRecordStartResult.getUploadPath());
                String name2 = target.name();
                if (name2 != null) {
                    String lowerCase = name2.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    sb5.append(lowerCase);
                    sb5.append(util.base64_pad_url + this.this$0.getParams().getSender());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(util.base64_pad_url);
                    sb6.append(System.currentTimeMillis());
                    sb5.append(sb6.toString());
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("_and");
                    if (z18) {
                        str = "_fila";
                    } else {
                        str = "";
                    }
                    sb7.append(str);
                    sb5.append(sb7.toString());
                    String sb8 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb8, "StringBuilder().apply(builderAction).toString()");
                    ZPlanResourceUploader zPlanResourceUploader = ZPlanResourceUploader.f386016c;
                    ZPlanRecordResource zPlanRecordResource4 = (ZPlanRecordResource) this.$it.getKey();
                    this.L$0 = zPlanRecordResource;
                    this.L$1 = localRecordStartResult;
                    this.label = 1;
                    f16 = zPlanResourceUploader.f(zPlanRecordResource4, sb8, target, this);
                    if (f16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return Unit.INSTANCE;
        }
        String str4 = (String) f16;
        boolean isValidUrl = URLUtil.isValidUrl(str4);
        LogUtil logUtil = LogUtil.f385285b;
        d a17 = logUtil.a();
        if (a17 != null) {
            d.a.c(a17, "[ZPlanRRC]_Z1ResourceUploader", 1, this.$tmpLogInfo$inlined + ", uploadUrl:" + str4 + ", success:" + isValidUrl + ", resource:" + zPlanRecordResource + ", startResult:" + localRecordStartResult, null, 8, null);
        }
        if (isValidUrl) {
            zPlanRecordResource.r(str4);
            ZPlanResourceManager zPlanResourceManager = ZPlanResourceManager.f386013d;
            String key = zPlanRecordResource.getKey();
            this.L$0 = zPlanRecordResource;
            this.L$1 = localRecordStartResult;
            this.L$2 = str4;
            this.Z$0 = isValidUrl;
            this.label = 2;
            if (zPlanResourceManager.b(key, zPlanRecordResource, false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            z17 = isValidUrl;
            zPlanRecordResource2 = zPlanRecordResource;
            str3 = str4;
            Z1ResourceUploader z1ResourceUploader3 = this.this$0;
            Intrinsics.checkNotNull(str3);
            String i162 = z1ResourceUploader3.i(str3);
            a16 = LogUtil.f385285b.a();
            if (a16 != null) {
            }
            this.$currentUploadCallback$inlined.a(localRecordStartResult.getTaskId(), i162);
            z16 = z17;
            str2 = str3;
            zPlanRecordResource = zPlanRecordResource2;
            Z1ResourceUploader z1ResourceUploader22 = this.this$0;
            String sender2 = z1ResourceUploader22.getParams().getSender();
            long portraitId2 = localRecordStartResult.getCommonAction().getPortraitId();
            int scene2 = this.this$0.getParams().getScene();
            String name3 = this.this$0.getParams().getUploadConfig().getTarget().name();
            String dressKey2 = zPlanRecordResource.getDressKey();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uploadPath", localRecordStartResult.getUploadPath()), TuplesKt.to(MiniAppGetGameTaskTicketServlet.KEY_TASKID, localRecordStartResult.getTaskId()));
            z1ResourceUploader22.j(sender2, portraitId2, scene2, name3, z16, str2, false, dressKey2, mapOf);
            return Unit.INSTANCE;
        }
        d a18 = logUtil.a();
        if (a18 != null) {
            d.a.c(a18, "[ZPlanRRC]_Z1ResourceUploader", 1, this.$tmpLogInfo$inlined + ", uploadFailed, taskId:" + localRecordStartResult.getTaskId(), null, 8, null);
        }
        this.$currentUploadCallback$inlined.b(localRecordStartResult.getTaskId(), -10004, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_UPLOAD_FAILED);
        str2 = str4;
        z16 = isValidUrl;
        Z1ResourceUploader z1ResourceUploader222 = this.this$0;
        String sender22 = z1ResourceUploader222.getParams().getSender();
        long portraitId22 = localRecordStartResult.getCommonAction().getPortraitId();
        int scene22 = this.this$0.getParams().getScene();
        String name32 = this.this$0.getParams().getUploadConfig().getTarget().name();
        String dressKey22 = zPlanRecordResource.getDressKey();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uploadPath", localRecordStartResult.getUploadPath()), TuplesKt.to(MiniAppGetGameTaskTicketServlet.KEY_TASKID, localRecordStartResult.getTaskId()));
        z1ResourceUploader222.j(sender22, portraitId22, scene22, name32, z16, str2, false, dressKey22, mapOf);
        return Unit.INSTANCE;
    }
}
