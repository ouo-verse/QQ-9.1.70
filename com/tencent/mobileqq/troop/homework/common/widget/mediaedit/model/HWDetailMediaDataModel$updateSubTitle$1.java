package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel$updateSubTitle$1", f = "HWDetailMediaDataModel.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWDetailMediaDataModel$updateSubTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $authorUin;
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ long $publishTime;
    Object L$0;
    int label;
    final /* synthetic */ HWDetailMediaDataModel<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWDetailMediaDataModel$updateSubTitle$1(HWDetailMediaDataModel<T> hWDetailMediaDataModel, long j3, long j16, Function0<Unit> function0, Continuation<? super HWDetailMediaDataModel$updateSubTitle$1> continuation) {
        super(2, continuation);
        this.this$0 = hWDetailMediaDataModel;
        this.$authorUin = j3;
        this.$publishTime = j16;
        this.$callback = function0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hWDetailMediaDataModel, Long.valueOf(j3), Long.valueOf(j16), function0, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWDetailMediaDataModel$updateSubTitle$1(this.this$0, this.$authorUin, this.$publishTime, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        SimpleDateFormat simpleDateFormat;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                String str = null;
                TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(this.this$0.q(), String.valueOf(this.$authorUin), null, "HW.MediaEdit.HWDetailMediaDataModel-updateData");
                if (troopMemberInfoSync == null) {
                    HWDetailMediaDataModel<T> hWDetailMediaDataModel = this.this$0;
                    long j3 = this.$authorUin;
                    QLog.e("HW.MediaEdit.HWDetailMediaDataModel", 1, "updateData,getTroopMember is null, " + hWDetailMediaDataModel.q() + "-" + j3);
                }
                TitleItem p16 = this.this$0.p();
                if (troopMemberInfoSync != null) {
                    str = troopMemberInfoSync.troopnick;
                }
                simpleDateFormat = ((HWDetailMediaDataModel) this.this$0).pubTimeFormatter;
                p16.setSubTitleText(str + "\u53d1\u5e03 " + simpleDateFormat.format(new Date(this.$publishTime * 1000)));
                Function0<Unit> function0 = this.$callback;
                if (function0 != null) {
                    HWDetailMediaDataModel<T> hWDetailMediaDataModel2 = this.this$0;
                    this.L$0 = function0;
                    this.label = 1;
                    if (hWDetailMediaDataModel2.e(function0, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWDetailMediaDataModel$updateSubTitle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
