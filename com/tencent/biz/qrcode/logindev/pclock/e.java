package com.tencent.biz.qrcode.logindev.pclock;

import android.content.BroadcastReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x16a.SubMsgType0x16a$LockStatusChangeNotify;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\u0011\u001a\u00020\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/pclock/e;", "", "", "e", "Ltencent/im/s2c/msgtype0x210/submsgtype0x16a/SubMsgType0x16a$LockStatusChangeNotify;", "lockStatusChangeNotify", "", "c", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "f", "i", "g", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", BaseConstants.ATTRIBUTE_KEY_PB_DATA, "d", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "msgListener", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mKernelInitCompleteListener", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f94954a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IKernelMsgListener msgListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static BroadcastReceiver mKernelInitCompleteListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/biz/qrcode/logindev/pclock/e$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "", "businessType", "", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "", TPReportKeys.Common.COMMON_ONLINE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "", "onSysMsgNotification", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a implements IKernelMsgListener {
        a() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSysMsgNotification(int businessType, long msgType, long msgSubType, boolean online, @Nullable ArrayList<Byte> msgBuf) {
            if (msgType == 528 && msgSubType == 362 && msgBuf != null) {
                try {
                    QLog.d("NTUnlockPushManager", 2, "onSysMsgNotification catch 0x16a push");
                    e.f94954a.d(msgBuf);
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("NTUnlockPushManager", 2, "convertMsgCommPB fail", e16);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    e() {
    }

    private final void c(SubMsgType0x16a$LockStatusChangeNotify lockStatusChangeNotify) {
        int i3 = lockStatusChangeNotify.instance_id.get();
        int i16 = lockStatusChangeNotify.lock_status.get();
        String devName = lockStatusChangeNotify.dev_name.get().toStringUtf8();
        int i17 = lockStatusChangeNotify.platform_id.get();
        QLog.d("NTUnlockPushManager", 1, "handleAskUnlock platform id: " + i17 + " lock status: " + i16);
        Intrinsics.checkNotNullExpressionValue(devName, "devName");
        b.f94950a.e(new UnlockPCPushModel(i3, i16, i17, devName));
    }

    private final boolean e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        if (appInterface.getAccount() == null) {
            QLog.e("NTUnlockPushManager", 1, "addMsgListener. but app/account is null");
            return false;
        }
        if (msgListener == null) {
            IRuntimeService runtimeService = appInterface.getRuntimeService(IKernelService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IK\u2026onstant.ALL\n            )");
            IKernelService iKernelService = (IKernelService) runtimeService;
            if (iKernelService.getMsgService() != null) {
                msgListener = new a();
                w msgService = iKernelService.getMsgService();
                Intrinsics.checkNotNull(msgService);
                IKernelMsgListener iKernelMsgListener = msgListener;
                Intrinsics.checkNotNull(iKernelMsgListener, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener");
                msgService.addMsgListener(iKernelMsgListener);
                return true;
            }
        }
        return false;
    }

    private final void f(QQAppInterface app, SubMsgType0x16a$LockStatusChangeNotify lockStatusChangeNotify) {
        Manager manager = app.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.biz.qrcode.logindev.LoginDevicesManager");
        ((rd0.g) manager).s(lockStatusChangeNotify.instance_id.get(), lockStatusChangeNotify.lock_status.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        if (mKernelInitCompleteListener != null) {
            QLog.i("NTUnlockPushManager", 1, "unregisterReceiver of kernel init complete");
            try {
                BaseApplication.getContext().unregisterReceiver(mKernelInitCompleteListener);
            } catch (Exception e16) {
                QLog.e("NTUnlockPushManager", 1, "unregisterReceiver exp", e16);
            }
            mKernelInitCompleteListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, String str) {
        QLog.i("NTUnlockPushManager", 1, "register result = " + i3 + ", errMsg = " + str);
    }

    public final void d(@NotNull ArrayList<Byte> pbData) {
        byte[] byteArray;
        Intrinsics.checkNotNullParameter(pbData, "pbData");
        SubMsgType0x16a$LockStatusChangeNotify subMsgType0x16a$LockStatusChangeNotify = new SubMsgType0x16a$LockStatusChangeNotify();
        try {
            nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
            byteArray = CollectionsKt___CollectionsKt.toByteArray(pbData);
            nt_msg_common_msg.mergeFrom(byteArray);
            if (nt_msg_common_msg.body.has() && nt_msg_common_msg.body.msg_content.has()) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                AppInterface appInterface = (AppInterface) peekAppRuntime;
                subMsgType0x16a$LockStatusChangeNotify.mergeFrom(nt_msg_common_msg.body.msg_content.get().toByteArray());
                int i3 = subMsgType0x16a$LockStatusChangeNotify.type.get();
                QLog.d("NTUnlockPushManager", 2, "type: " + i3 + " platform id :" + subMsgType0x16a$LockStatusChangeNotify.platform_id.get());
                if (i3 != 2) {
                    if (i3 == 3) {
                        f((QQAppInterface) appInterface, subMsgType0x16a$LockStatusChangeNotify);
                        return;
                    }
                    return;
                }
                c(subMsgType0x16a$LockStatusChangeNotify);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("NTUnlockPushManager", 2, "handleDavInviteMsg: hasBody:" + nt_msg_common_msg.body.has() + ", hasMsgContent" + nt_msg_common_msg.body.msg_content.has());
            }
        } catch (Exception e16) {
            QLog.w("NTUnlockPushManager", 1, "merge from exception", e16);
        }
    }

    public final void g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        if (msgListener != null) {
            QLog.i("NTUnlockPushManager", 1, "removeMsgListener!!!");
            IRuntimeService runtimeService = appInterface.getRuntimeService(IKernelService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026onstant.ALL\n            )");
            IKernelService iKernelService = (IKernelService) runtimeService;
            if (iKernelService.getMsgService() != null) {
                w msgService = iKernelService.getMsgService();
                Intrinsics.checkNotNull(msgService);
                IKernelMsgListener iKernelMsgListener = msgListener;
                Intrinsics.checkNotNull(iKernelMsgListener);
                msgService.removeMsgListener(iKernelMsgListener);
                msgListener = null;
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.logindev.pclock.c
            @Override // java.lang.Runnable
            public final void run() {
                e.h();
            }
        }, 16, null, true);
    }

    public final void i() {
        List mutableListOf;
        QLog.i("NTUnlockPushManager", 1, "onNTKernelSessionCreated...");
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(362L);
        Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long> }");
        iMsgService.registerSysMsgNotification(0, 528L, (ArrayList) mutableListOf, new IOperateCallback() { // from class: com.tencent.biz.qrcode.logindev.pclock.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                e.j(i3, str);
            }
        });
        e();
    }
}
