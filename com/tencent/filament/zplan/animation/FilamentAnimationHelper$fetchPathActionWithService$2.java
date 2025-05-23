package com.tencent.filament.zplan.animation;

import com.tencent.filament.zplanservice.download.ZPlanAvatarFileDownloadDescriptor;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.animation.FilamentAnimationHelper$fetchPathActionWithService$2", f = "FilamentAnimationHelper.kt", i = {0, 1}, l = {86, 87}, m = "invokeSuspend", n = {"bodyPathDeferred", "faceResult"}, s = {"L$0", "L$0"})
/* loaded from: classes6.dex */
public final class FilamentAnimationHelper$fetchPathActionWithService$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ ZPlanAvatarService $avatarService;
    final /* synthetic */ String $bodyPath;
    final /* synthetic */ String $facePath;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentAnimationHelper$fetchPathActionWithService$2(String str, ZPlanAvatarService zPlanAvatarService, String str2, Continuation continuation) {
        super(2, continuation);
        this.$facePath = str;
        this.$avatarService = zPlanAvatarService;
        this.$bodyPath = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        FilamentAnimationHelper$fetchPathActionWithService$2 filamentAnimationHelper$fetchPathActionWithService$2 = new FilamentAnimationHelper$fetchPathActionWithService$2(this.$facePath, this.$avatarService, this.$bodyPath, completion);
        filamentAnimationHelper$fetchPathActionWithService$2.L$0 = obj;
        return filamentAnimationHelper$fetchPathActionWithService$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((FilamentAnimationHelper$fetchPathActionWithService$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c1, code lost:
    
        if (r7 != null) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x009b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        Deferred async$default;
        boolean z17;
        Deferred async$default2;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        Deferred deferred;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2;
        String str;
        String str2;
        ZPlanAvatarFileDownloadDescriptor[] allFiles;
        Object firstOrNull;
        ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor;
        String url;
        ZPlanAvatarFileDownloadDescriptor[] allFiles2;
        Object firstOrNull2;
        ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z18 = false;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult3 = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    zPlanAvatarInterfaceResult3 = (ZPlanAvatarInterfaceResult) obj;
                    zPlanAvatarInterfaceResult = zPlanAvatarInterfaceResult2;
                    str = "";
                    if (zPlanAvatarInterfaceResult != null || (r2 = zPlanAvatarInterfaceResult.getResult()) == null) {
                        String str3 = "";
                    }
                    if (zPlanAvatarInterfaceResult3 != null || (r6 = zPlanAvatarInterfaceResult3.getResult()) == null) {
                        String str4 = "";
                    }
                    if (zPlanAvatarInterfaceResult != null && (allFiles2 = zPlanAvatarInterfaceResult.getAllFiles()) != null) {
                        firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(allFiles2);
                        zPlanAvatarFileDownloadDescriptor2 = (ZPlanAvatarFileDownloadDescriptor) firstOrNull2;
                        if (zPlanAvatarFileDownloadDescriptor2 != null) {
                            str2 = zPlanAvatarFileDownloadDescriptor2.getUrl();
                        }
                    }
                    str2 = "";
                    if (zPlanAvatarInterfaceResult3 != null && (allFiles = zPlanAvatarInterfaceResult3.getAllFiles()) != null) {
                        firstOrNull = ArraysKt___ArraysKt.firstOrNull(allFiles);
                        zPlanAvatarFileDownloadDescriptor = (ZPlanAvatarFileDownloadDescriptor) firstOrNull;
                        if (zPlanAvatarFileDownloadDescriptor != null && (url = zPlanAvatarFileDownloadDescriptor.getUrl()) != null) {
                            str = url;
                        }
                    }
                    ZPlanAction zPlanAction = new ZPlanAction(str3, str4, str2, str);
                    if ((zPlanAvatarInterfaceResult != null && zPlanAvatarInterfaceResult.isDownload()) || (zPlanAvatarInterfaceResult3 != null && zPlanAvatarInterfaceResult3.isDownload())) {
                        z18 = true;
                    }
                    zPlanAction.f(z18);
                    return zPlanAction;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            deferred = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.$facePath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentAnimationHelper$fetchPathActionWithService$2$facePathDeferred$1(this, null), 3, null);
            } else {
                async$default = null;
            }
            if (this.$bodyPath.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentAnimationHelper$fetchPathActionWithService$2$bodyPathDeferred$1(this, null), 3, null);
            } else {
                async$default2 = null;
            }
            if (async$default != null) {
                this.L$0 = async$default2;
                this.label = 1;
                Object await = async$default.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = async$default2;
                obj = await;
            } else {
                zPlanAvatarInterfaceResult = null;
                if (async$default2 != null) {
                    this.L$0 = zPlanAvatarInterfaceResult;
                    this.label = 2;
                    obj = async$default2.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanAvatarInterfaceResult2 = zPlanAvatarInterfaceResult;
                    zPlanAvatarInterfaceResult3 = (ZPlanAvatarInterfaceResult) obj;
                    zPlanAvatarInterfaceResult = zPlanAvatarInterfaceResult2;
                }
                str = "";
                if (zPlanAvatarInterfaceResult != null) {
                }
                String str32 = "";
                if (zPlanAvatarInterfaceResult3 != null) {
                }
                String str42 = "";
                if (zPlanAvatarInterfaceResult != null) {
                    firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(allFiles2);
                    zPlanAvatarFileDownloadDescriptor2 = (ZPlanAvatarFileDownloadDescriptor) firstOrNull2;
                    if (zPlanAvatarFileDownloadDescriptor2 != null) {
                    }
                }
                str2 = "";
                if (zPlanAvatarInterfaceResult3 != null) {
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(allFiles);
                    zPlanAvatarFileDownloadDescriptor = (ZPlanAvatarFileDownloadDescriptor) firstOrNull;
                    if (zPlanAvatarFileDownloadDescriptor != null) {
                        str = url;
                    }
                }
                ZPlanAction zPlanAction2 = new ZPlanAction(str32, str42, str2, str);
                if (zPlanAvatarInterfaceResult != null) {
                    z18 = true;
                    zPlanAction2.f(z18);
                    return zPlanAction2;
                }
                z18 = true;
                zPlanAction2.f(z18);
                return zPlanAction2;
            }
        }
        Deferred deferred2 = deferred;
        zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
        async$default2 = deferred2;
        if (async$default2 != null) {
        }
        str = "";
        if (zPlanAvatarInterfaceResult != null) {
        }
        String str322 = "";
        if (zPlanAvatarInterfaceResult3 != null) {
        }
        String str422 = "";
        if (zPlanAvatarInterfaceResult != null) {
        }
        str2 = "";
        if (zPlanAvatarInterfaceResult3 != null) {
        }
        ZPlanAction zPlanAction22 = new ZPlanAction(str322, str422, str2, str);
        if (zPlanAvatarInterfaceResult != null) {
        }
        z18 = true;
        zPlanAction22.f(z18);
        return zPlanAction22;
    }
}
