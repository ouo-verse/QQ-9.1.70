package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import cooperation.qzone.QZoneHelper;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRQZoneShareAction$reqTailLinkAndShareToQZone$1", f = "QRQZoneShareAction.kt", i = {0, 0, 1, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$launch", "troopInfoData", "$this$launch", "troopInfoData", "tailExtBundle"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes19.dex */
public final class QRQZoneShareAction$reqTailLinkAndShareToQZone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QBaseActivity $activity;
    final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b $shareContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ QRQZoneShareAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRQZoneShareAction$reqTailLinkAndShareToQZone$1(com.tencent.mobileqq.troop.troopsetting.share.b bVar, QRQZoneShareAction qRQZoneShareAction, QBaseActivity qBaseActivity, Continuation<? super QRQZoneShareAction$reqTailLinkAndShareToQZone$1> continuation) {
        super(2, continuation);
        this.$shareContext = bVar;
        this.this$0 = qRQZoneShareAction;
        this.$activity = qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, qRQZoneShareAction, qBaseActivity, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        QRQZoneShareAction$reqTailLinkAndShareToQZone$1 qRQZoneShareAction$reqTailLinkAndShareToQZone$1 = new QRQZoneShareAction$reqTailLinkAndShareToQZone$1(this.$shareContext, this.this$0, this.$activity, continuation);
        qRQZoneShareAction$reqTailLinkAndShareToQZone$1.L$0 = obj;
        return qRQZoneShareAction$reqTailLinkAndShareToQZone$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Object j3;
        TroopInfoData troopInfoData;
        Bundle bundle;
        String str;
        boolean z16;
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            String str2 = "";
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        Bundle bundle2 = (Bundle) this.L$2;
                        troopInfoData = (TroopInfoData) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        bundle = bundle2;
                        str = (String) obj;
                        if (str.length() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            TroopSettingShareManager.Companion companion = TroopSettingShareManager.INSTANCE;
                            QBaseActivity qBaseActivity = this.$activity;
                            String qqStr = HardCodeUtil.qqStr(R.string.hit);
                            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.share_fail)");
                            companion.b(qBaseActivity, 1, qqStr);
                            return Unit.INSTANCE;
                        }
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime instanceof AppInterface) {
                            appInterface = (AppInterface) peekAppRuntime;
                        } else {
                            appInterface = null;
                        }
                        if (appInterface == null) {
                            QBaseActivity qBaseActivity2 = this.$activity;
                            TroopSettingShareManager.Companion companion2 = TroopSettingShareManager.INSTANCE;
                            String qqStr2 = HardCodeUtil.qqStr(R.string.hit);
                            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.share_fail)");
                            companion2.b(qBaseActivity2, 1, qqStr2);
                            return Unit.INSTANCE;
                        }
                        QBaseActivity qBaseActivity3 = this.$activity;
                        Object[] objArr = new Object[2];
                        objArr[0] = com.tencent.mobileqq.troop.troopsetting.modules.base.a.d(troopInfoData);
                        String str3 = troopInfoData.troopUin;
                        if (str3 != null) {
                            str2 = str3;
                        }
                        objArr[1] = str2;
                        String string = qBaseActivity3.getString(R.string.f216955zp, objArr);
                        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(\n    \u2026n ?: \"\"\n                )");
                        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                        userInfo.qzone_uin = appInterface.getAccount();
                        userInfo.nickname = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getAccountNickName(appInterface, appInterface.getAccount());
                        QBaseActivity qBaseActivity4 = this.$activity;
                        QZoneHelper.forwardToPublishMoodWithExtBundle(qBaseActivity4, userInfo, str, qBaseActivity4.getString(R.string.f216965zq), string, bundle, 1);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                troopInfoData = (TroopInfoData) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                TroopInfoData h16 = this.$shareContext.h();
                QRQZoneShareAction qRQZoneShareAction = this.this$0;
                String g16 = this.$shareContext.g();
                if (g16 == null) {
                    g16 = "";
                }
                this.L$0 = coroutineScope;
                this.L$1 = h16;
                this.label = 1;
                j3 = qRQZoneShareAction.j(h16, g16, this);
                if (j3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                troopInfoData = h16;
                obj = j3;
            }
            Bundle bundle3 = (Bundle) obj;
            QRQZoneShareAction qRQZoneShareAction2 = this.this$0;
            com.tencent.mobileqq.troop.troopsetting.share.b bVar = this.$shareContext;
            this.L$0 = coroutineScope;
            this.L$1 = troopInfoData;
            this.L$2 = bundle3;
            this.label = 2;
            Object h17 = qRQZoneShareAction2.h(bVar, this);
            if (h17 == coroutine_suspended) {
                return coroutine_suspended;
            }
            bundle = bundle3;
            obj = h17;
            str = (String) obj;
            if (str.length() != 0) {
            }
            if (!z16) {
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QRQZoneShareAction$reqTailLinkAndShareToQZone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
