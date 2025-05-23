package com.tencent.robot.adelie.homepage.create.viewmodel;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotOperationType;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1", f = "AdelieCreateOrEditPageViewModel.kt", i = {0, 1}, l = {249, 261}, m = "invokeSuspend", n = {"$this$qLaunch", PhotoCategorySummaryInfo.AVATAR_URL}, s = {"L$0", "L$0"})
/* loaded from: classes25.dex */
public final class AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatarPath;
    final /* synthetic */ String $bgPath;
    final /* synthetic */ Function3<Integer, String, MyBotInfo, Unit> $cb;
    final /* synthetic */ MyBotInfo $curBotInfo;
    final /* synthetic */ long $startTime;
    final /* synthetic */ ChangeMyBotOperationType $type;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdelieCreateOrEditPageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1(String str, MyBotInfo myBotInfo, AdelieCreateOrEditPageViewModel adelieCreateOrEditPageViewModel, Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> function3, String str2, long j3, ChangeMyBotOperationType changeMyBotOperationType, Continuation<? super AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1> continuation) {
        super(2, continuation);
        this.$avatarPath = str;
        this.$curBotInfo = myBotInfo;
        this.this$0 = adelieCreateOrEditPageViewModel;
        this.$cb = function3;
        this.$bgPath = str2;
        this.$startTime = j3;
        this.$type = changeMyBotOperationType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1 adelieCreateOrEditPageViewModel$uploadPicAndCreate$1 = new AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1(this.$avatarPath, this.$curBotInfo, this.this$0, this.$cb, this.$bgPath, this.$startTime, this.$type, continuation);
        adelieCreateOrEditPageViewModel$uploadPicAndCreate$1.L$0 = obj;
        return adelieCreateOrEditPageViewModel$uploadPicAndCreate$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0102  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        boolean z16;
        String str;
        boolean z17;
        Deferred async$default;
        Object await;
        int i3;
        boolean z18;
        boolean z19;
        String str2;
        boolean z26;
        Deferred async$default2;
        Object await2;
        String str3;
        int i16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        boolean z27 = false;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    str3 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    await2 = obj;
                    AdelieUtils.UploadResult uploadResult = (AdelieUtils.UploadResult) await2;
                    this.this$0.uploadErrorCode = uploadResult.getErrCode();
                    str2 = uploadResult.getUrl();
                    str = str3;
                    i16 = this.this$0.uploadErrorCode;
                    if (i16 == 0) {
                        if (str2 == null || str2.length() == 0) {
                            z27 = true;
                        }
                        if (!z27) {
                            this.this$0.uploadCostTime = System.currentTimeMillis() - this.$startTime;
                            this.$curBotInfo.botAvatar = str;
                            this.this$0._botAvatarPath = "";
                            this.$curBotInfo.c2cDayBackground = str2;
                            this.this$0._botBackgroundPath = "";
                            if (AppNetConnInfo.isNetSupport()) {
                                this.this$0.b2(this.$type, this.$curBotInfo, this.$cb);
                                return Unit.INSTANCE;
                            }
                            this.$cb.invoke(Boxing.boxInt(BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD), "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5", new MyBotInfo());
                            return Unit.INSTANCE;
                        }
                    }
                    this.$cb.invoke(Boxing.boxInt(999996), "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", new MyBotInfo());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            String str4 = this.$avatarPath;
            if (str4 != null && str4.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str5 = this.$curBotInfo.botAvatar;
                if (str5 != null && str5.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1$avatarUrl$avatarUrlJob$1(this.$avatarPath, null), 3, null);
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    await = async$default.await(this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            str = this.$curBotInfo.botAvatar;
            CoroutineScope coroutineScope2 = coroutineScope;
            i3 = this.this$0.uploadErrorCode;
            if (i3 == 0) {
                if (str != null && str.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    String str6 = this.$bgPath;
                    if (str6 != null && str6.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        String str7 = this.$curBotInfo.c2cDayBackground;
                        if (str7 != null && str7.length() != 0) {
                            z26 = false;
                        } else {
                            z26 = true;
                        }
                        if (z26) {
                            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1$bgUrl$bgUrlJob$1(this.$bgPath, null), 3, null);
                            this.L$0 = str;
                            this.label = 2;
                            await2 = async$default2.await(this);
                            if (await2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = str;
                            AdelieUtils.UploadResult uploadResult2 = (AdelieUtils.UploadResult) await2;
                            this.this$0.uploadErrorCode = uploadResult2.getErrCode();
                            str2 = uploadResult2.getUrl();
                            str = str3;
                            i16 = this.this$0.uploadErrorCode;
                            if (i16 == 0) {
                            }
                            this.$cb.invoke(Boxing.boxInt(999996), "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", new MyBotInfo());
                            return Unit.INSTANCE;
                        }
                    }
                    str2 = this.$curBotInfo.c2cDayBackground;
                    i16 = this.this$0.uploadErrorCode;
                    if (i16 == 0) {
                    }
                    this.$cb.invoke(Boxing.boxInt(999996), "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", new MyBotInfo());
                    return Unit.INSTANCE;
                }
            }
            this.$cb.invoke(Boxing.boxInt(999996), "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", new MyBotInfo());
            return Unit.INSTANCE;
        }
        AdelieUtils.UploadResult uploadResult3 = (AdelieUtils.UploadResult) await;
        this.this$0.uploadErrorCode = uploadResult3.getErrCode();
        str = uploadResult3.getUrl();
        CoroutineScope coroutineScope22 = coroutineScope;
        i3 = this.this$0.uploadErrorCode;
        if (i3 == 0) {
        }
        this.$cb.invoke(Boxing.boxInt(999996), "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", new MyBotInfo());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
