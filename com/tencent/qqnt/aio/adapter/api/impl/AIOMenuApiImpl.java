package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooptodo.ITroopTodoAIOMenuApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOMenuApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J8\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J6\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOMenuApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOMenuApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "friendUin", "", "isSend", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "isTroopOwnerOrMgrAction", "isOverTimeTwoMinutes", "isOverTimeTwoHoursForC2CFileMsg", "isOverTimeTwoMinutesReal", "", "chatType", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "revokerUin", "isSupportRevokeMsgByTroopOwnerOrMgr", "isSupportUinType", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "isTroopOwnerOrAdmin", "isSupportRevoke", "getTroopTodoType", "Landroid/content/Context;", "isCancel", "", "onTroopTodoClicked", "checkSupportReply", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOMenuApiImpl implements IAIOMenuApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "AIOMenuApiImpl";
    private static final Lazy<Boolean> singleWayFriendRevoke$delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOMenuApiImpl$a;", "", "", "singleWayFriendRevoke$delegate", "Lkotlin/Lazy;", "b", "()Z", "singleWayFriendRevoke", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOMenuApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) AIOMenuApiImpl.singleWayFriendRevoke$delegate.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOMenuApiImpl$Companion$singleWayFriendRevoke$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("single_way_revoke_9150", true));
            }
        });
        singleWayFriendRevoke$delegate = lazy;
    }

    private final boolean isOverTimeTwoHoursForC2CFileMsg(MsgRecord msgRecord, QQAppInterface app) {
        if (!(com.tencent.mobileqq.activity.aio.l.H(msgRecord) || com.tencent.mobileqq.activity.aio.l.I(msgRecord))) {
            return false;
        }
        boolean z16 = !com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ae.f(app, msgRecord.msgTime, 7200000L);
        QLog.d(TAG, 1, "isOverTimeTwoHoursForC2CFileMsg, isOverTimeTwoHours=" + z16);
        return z16;
    }

    private final boolean isOverTimeTwoMinutes(MsgRecord msgRecord, String friendUin, boolean isSend, QQAppInterface app, boolean isTroopOwnerOrMgrAction, boolean isOverTimeTwoMinutes) {
        boolean C = TroopUtils.C(app, friendUin, app.getCurrentAccountUin());
        boolean H = com.tencent.mobileqq.activity.aio.l.H(msgRecord);
        QLog.d(TAG, 1, "isOwnerOrAdmin=" + C + ", isC2CFileMsg=" + H);
        if (isOverTimeTwoMinutes) {
            return (C && isSend) || H || isTroopOwnerOrMgrAction;
        }
        return true;
    }

    private final boolean isOverTimeTwoMinutesReal(MsgRecord msgRecord, QQAppInterface app) {
        boolean z16 = !com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ae.f(app, msgRecord.msgTime, 120000L);
        QLog.d(TAG, 1, "isOverTimeTwoMinutes, isOverTimeTwoHours=" + z16);
        return z16;
    }

    private final boolean isSupportUinType(int chatType) {
        if (chatType == 1 || chatType == 2 || chatType == 3 || chatType == 100) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public boolean checkSupportReply(Context context, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 2) {
            return true;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        String valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopGagMgr");
        if (!((com.tencent.mobileqq.troop.utils.aj) manager).a(valueOf, true).f300235b) {
            return true;
        }
        QQToast.makeText(context, R.string.emm, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public int getTroopTodoType(AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return ((ITroopTodoAIOMenuApi) QRoute.api(ITroopTodoAIOMenuApi.class)).getTroopTodoType(msgItem);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public void onTroopTodoClicked(Context context, AIOMsgItem msgItem, boolean isCancel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ((ITroopTodoAIOMenuApi) QRoute.api(ITroopTodoAIOMenuApi.class)).onTroopTodoClicked(context, msgItem, isCancel);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public boolean isSupportRevoke(com.tencent.aio.api.runtime.a context, AIOMsgItem msgItem, boolean isTroopOwnerOrAdmin, boolean isOverTimeTwoMinutes) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        String valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
        String valueOf2 = String.valueOf(msgItem.getMsgRecord().senderUin);
        int i3 = msgItem.getMsgRecord().chatType;
        boolean isSelf = msgItem.isSelf();
        boolean J = com.tencent.mobileqq.aio.utils.d.J(msgItem);
        boolean z16 = isSupportRevokeMsgByTroopOwnerOrMgr(qQAppInterface, i3, valueOf, valueOf2, qQAppInterface.getCurrentAccountUin()) && !J;
        int i16 = msgItem.getMsgRecord().sendStatus;
        boolean z17 = i16 == 2 || (i16 == 3 && (i3 == 1 || i3 == 100));
        QLog.d(TAG, 1, "friendUin=" + StringUtil.getSimpleUinForPrint(valueOf) + ", senderUin=" + StringUtil.getSimpleUinForPrint(valueOf2) + ", currentAccountUin=" + StringUtil.getSimpleUinForPrint(qQAppInterface.getCurrentAccountUin()) + ", chatType=" + i3 + ", isSend=" + isSelf + ", isPaiYiPai=" + J + ", isTroopOwnerOrMgrAction=" + z16 + ", isOverTimeTwoMinutes=" + isOverTimeTwoMinutes + ", isSendSuccess=" + z17 + ", isAnonymousMsg=" + com.tencent.mobileqq.aio.utils.d.s(msgItem));
        if (msgItem.K0() && !z17) {
            return false;
        }
        boolean z18 = z16;
        if (!isOverTimeTwoMinutes(msgItem.getMsgRecord(), valueOf, isSelf, qQAppInterface, z16, isOverTimeTwoMinutes) || isOverTimeTwoHoursForC2CFileMsg(msgItem.getMsgRecord(), qQAppInterface)) {
            return false;
        }
        if (!isSelf && !z18) {
            return false;
        }
        if (J && isOverTimeTwoMinutesReal(msgItem.getMsgRecord(), qQAppInterface)) {
            return false;
        }
        if (i3 == 1 && !INSTANCE.b()) {
            if (J) {
                return true;
            }
            if (!com.tencent.qqnt.contact.friends.b.f355778a.c(valueOf, TAG)) {
                QLog.d(TAG, 1, "isFriend false");
                return false;
            }
        }
        return isSupportUinType(i3);
    }

    private final boolean isSupportRevokeMsgByTroopOwnerOrMgr(QQAppInterface app, int chatType, String friendUin, String senderUin, String revokerUin) {
        if (chatType != 2 || TextUtils.equals(senderUin, revokerUin)) {
            return false;
        }
        Manager manager = app.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopInfo k3 = ((TroopManager) manager).k(friendUin);
        if (k3 == null) {
            QLog.d(TAG, 1, "troopInfo == null");
            return false;
        }
        if (k3.isTroopOwner(revokerUin)) {
            QLog.d(TAG, 1, "isTroopOwner");
            return true;
        }
        boolean isTroopAdmin = k3.isTroopAdmin(revokerUin);
        boolean isTroopOwner = k3.isTroopOwner(senderUin);
        boolean isTroopAdmin2 = k3.isTroopAdmin(senderUin);
        QLog.d(TAG, 1, "isTroopAdminRevoker=" + isTroopAdmin + ", isTroopOwnerSender=" + isTroopOwner + ", isTroopOwnerAdmin=" + isTroopAdmin2);
        return (!isTroopAdmin || isTroopOwner || isTroopAdmin2) ? false : true;
    }
}
