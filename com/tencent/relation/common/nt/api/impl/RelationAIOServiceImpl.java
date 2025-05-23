package com.tencent.relation.common.nt.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.nt.api.IProfileNtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import com.tencent.relation.common.nt.api.IRelationAIOService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/relation/common/nt/api/impl/RelationAIOServiceImpl;", "Lcom/tencent/relation/common/nt/api/IRelationAIOService;", "Landroid/content/Context;", "context", "", "toPhone", "", "enterContactStrangerAIO", "Lcom/tencent/common/app/AppInterface;", "appInterface", "nickName", "ntPrepareContactStrangerTempChat", "toUid", "troopUin", "ntPrepareTroopMemberStrangerTempChat", "mobileNumber", "getNameFromPhone", "<init>", "()V", "Companion", "a", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RelationAIOServiceImpl implements IRelationAIOService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "RelationAIOServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/relation/common/nt/api/impl/RelationAIOServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "relation-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.relation.common.nt.api.impl.RelationAIOServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RelationAIOServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ntPrepareContactStrangerTempChat$lambda$0(int i3, String str) {
        QLog.d(TAG, 2, "prepareTempChat: ", Integer.valueOf(i3), ", errMsg: ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ntPrepareTroopMemberStrangerTempChat$lambda$1(int i3, String str) {
        QLog.e(TAG, 1, "prepareTempChat: ", Integer.valueOf(i3), ", errMsg: ", str);
    }

    @Override // com.tencent.relation.common.nt.api.IRelationAIOService
    public void enterContactStrangerAIO(@NotNull Context context, @NotNull String toPhone) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) toPhone);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toPhone, "toPhone");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        String nameFromPhone = getNameFromPhone(toPhone);
        if (TextUtils.isEmpty(nameFromPhone)) {
            nameFromPhone = toPhone;
        }
        ntPrepareContactStrangerTempChat(appInterface, nameFromPhone, toPhone);
        Intent enterNtAIOIntent = ((IProfileNtApi) QRoute.api(IProfileNtApi.class)).getEnterNtAIOIntent(context);
        enterNtAIOIntent.putExtra("uin", toPhone);
        enterNtAIOIntent.putExtra("uinname", nameFromPhone);
        enterNtAIOIntent.putExtra("uintype", 1006);
        enterNtAIOIntent.putExtra("hidden_aio_msg_source", 2);
        enterNtAIOIntent.putExtra("key_need_show_unread_count", true);
        context.startActivity(enterNtAIOIntent);
    }

    @Override // com.tencent.relation.common.nt.api.IRelationAIOService
    @NotNull
    public String getNameFromPhone(@NotNull String mobileNumber) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) mobileNumber);
        }
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        if (TextUtils.isEmpty(mobileNumber)) {
            QLog.d(TAG, 1, "getNameFromPhone is error! mobileNumber is invalid");
            return "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        IRuntimeService runtimeService = ((AppInterface) peekAppRuntime).getRuntimeService(IPhoneContactService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
        PhoneContact queryContactByCodeNumber = ((IPhoneContactService) runtimeService).queryContactByCodeNumber(mobileNumber);
        if (queryContactByCodeNumber == null) {
            return "";
        }
        String str = queryContactByCodeNumber.name;
        Intrinsics.checkNotNullExpressionValue(str, "phoneContact.name");
        return str;
    }

    @Override // com.tencent.relation.common.nt.api.IRelationAIOService
    public void ntPrepareContactStrangerTempChat(@NotNull AppInterface appInterface, @NotNull String nickName, @NotNull String toPhone) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, nickName, toPhone);
            return;
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(toPhone, "toPhone");
        w msgService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.d(TAG, 1, "ntPrepareContactStrangerTempChat  msgService is null");
            return;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IPhoneContactService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
        IPhoneContactService iPhoneContactService = (IPhoneContactService) runtimeService;
        if (iPhoneContactService.getSelfBindInfo() == null) {
            QLog.d(TAG, 1, "ntPrepareContactStrangerTempChat is error! selfBindInfo is null");
            return;
        }
        msgService.prepareTempChat(new TempChatPrepareInfo(111, toPhone, nickName, "", new byte[0], appInterface.getCurrentUid(), iPhoneContactService.getSelfBindInfo().nationCode + iPhoneContactService.getSelfBindInfo().mobileNo, new TempChatGameSession()), new IOperateCallback() { // from class: com.tencent.relation.common.nt.api.impl.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RelationAIOServiceImpl.ntPrepareContactStrangerTempChat$lambda$0(i3, str);
            }
        });
    }

    @Override // com.tencent.relation.common.nt.api.IRelationAIOService
    public void ntPrepareTroopMemberStrangerTempChat(@NotNull AppInterface appInterface, @NotNull String nickName, @NotNull String toUid, @NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, nickName, toUid, troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(toUid, "toUid");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        w msgService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e(TAG, 1, "ntPrepareTroopMemberStrangerTempChat is error! msgService is null");
        } else {
            msgService.prepareTempChat(new TempChatPrepareInfo(100, toUid, nickName, troopUin, new byte[0], appInterface.getCurrentUid(), "", new TempChatGameSession()), new IOperateCallback() { // from class: com.tencent.relation.common.nt.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RelationAIOServiceImpl.ntPrepareTroopMemberStrangerTempChat$lambda$1(i3, str);
                }
            });
        }
    }
}
