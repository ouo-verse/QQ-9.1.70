package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRFriendShareAction$doAction$1", f = "QRFriendShareAction.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class QRFriendShareAction$doAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QBaseActivity $activity;
    final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b $shareContext;
    int label;
    final /* synthetic */ QRFriendShareAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRFriendShareAction$doAction$1(QRFriendShareAction qRFriendShareAction, com.tencent.mobileqq.troop.troopsetting.share.b bVar, QBaseActivity qBaseActivity, Continuation<? super QRFriendShareAction$doAction$1> continuation) {
        super(2, continuation);
        this.this$0 = qRFriendShareAction;
        this.$shareContext = bVar;
        this.$activity = qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qRFriendShareAction, bVar, qBaseActivity, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QRFriendShareAction$doAction$1(this.this$0, this.$shareContext, this.$activity, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        Class forwardRecentActivityClass;
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
                QRFriendShareAction qRFriendShareAction = this.this$0;
                com.tencent.mobileqq.troop.troopsetting.share.b bVar = this.$shareContext;
                this.label = 1;
                obj = qRFriendShareAction.h(bVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                TroopSettingShareManager.Companion companion = TroopSettingShareManager.INSTANCE;
                QBaseActivity qBaseActivity = this.$activity;
                String qqStr = HardCodeUtil.qqStr(R.string.hit);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.share_fail)");
                companion.b(qBaseActivity, 1, qqStr);
                return Unit.INSTANCE;
            }
            Intent l3 = this.this$0.l(str);
            this.this$0.j(this.$shareContext, l3);
            if (Intrinsics.areEqual(this.$shareContext.a(), "mypc")) {
                forwardRecentActivityClass = ((IForwardApi) QRoute.api(IForwardApi.class)).getForwardRecentTranslucentActivityClass();
            } else {
                forwardRecentActivityClass = ((IForwardApi) QRoute.api(IForwardApi.class)).getForwardRecentActivityClass();
            }
            ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(this.$activity, l3, forwardRecentActivityClass, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QRFriendShareAction$doAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
