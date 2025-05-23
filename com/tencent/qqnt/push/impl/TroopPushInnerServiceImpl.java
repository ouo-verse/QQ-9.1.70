package com.tencent.qqnt.push.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.f;
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
import com.tencent.qqnt.push.ITroopPushInnerService;
import com.tencent.qqnt.push.TroopPushCMD;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\t\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J8\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/push/impl/TroopPushInnerServiceImpl;", "Lcom/tencent/qqnt/push/ITroopPushInnerService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "initAfterNTCreated", "", "businessType", "", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "", TPReportKeys.Common.COMMON_ONLINE, "Ljava/util/ArrayList;", "", "msgBuf", "onSysMsgNotification", "isMainProcess", "()Z", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class TroopPushInnerServiceImpl implements ITroopPushInnerService, IKernelMsgListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopPushInnerServiceImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/push/impl/TroopPushInnerServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.impl.TroopPushInnerServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62566);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopPushInnerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAfterNTCreated$lambda$5$lambda$4(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "registerSysMsgNotification: result=" + i3 + ", errMsg=" + str);
        }
    }

    private final boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDestroy$lambda$2$lambda$1(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unregisterSysMsgNotification: result=" + i3 + ", errMsg=" + str);
        }
    }

    @Override // com.tencent.qqnt.push.ITroopPushInnerService
    public void initAfterNTCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!isMainProcess()) {
            return;
        }
        w c16 = f.f356721a.c();
        if (c16 != null) {
            c16.addMsgListener(this);
        }
        for (Map.Entry<Integer, Map<Long, Lazy<com.tencent.qqnt.push.a>>> entry : TroopPushCMD.f360703a.b().entrySet()) {
            bg bgVar = bg.f302144a;
            Map<Long, Lazy<com.tencent.qqnt.push.a>> value = entry.getValue();
            ArrayList arrayList = new ArrayList(value.size());
            Iterator<Map.Entry<Long, Lazy<com.tencent.qqnt.push.a>>> it = value.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().getKey().longValue()));
            }
            ArrayList<Long> n3 = bgVar.n(arrayList);
            w c17 = f.f356721a.c();
            if (c17 != null) {
                c17.registerSysMsgNotification(0, entry.getKey().intValue(), n3, new IOperateCallback() { // from class: com.tencent.qqnt.push.impl.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        TroopPushInnerServiceImpl.initAfterNTCreated$lambda$5$lambda$4(i3, str);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
        ax.a(this, msgRecord);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
        ax.b(this, hashMap);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
        ax.c(this, customWithdrawConfig);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!isMainProcess()) {
            return;
        }
        w c16 = f.f356721a.c();
        if (c16 != null) {
            c16.removeMsgListener(this);
        }
        for (Map.Entry<Integer, Map<Long, Lazy<com.tencent.qqnt.push.a>>> entry : TroopPushCMD.f360703a.b().entrySet()) {
            bg bgVar = bg.f302144a;
            Map<Long, Lazy<com.tencent.qqnt.push.a>> value = entry.getValue();
            ArrayList arrayList = new ArrayList(value.size());
            Iterator<Map.Entry<Long, Lazy<com.tencent.qqnt.push.a>>> it = value.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().getKey().longValue()));
            }
            ArrayList<Long> n3 = bgVar.n(arrayList);
            w c17 = f.f356721a.c();
            if (c17 != null) {
                c17.unregisterSysMsgNotification(0, entry.getKey().intValue(), n3, new IOperateCallback() { // from class: com.tencent.qqnt.push.impl.b
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        TroopPushInnerServiceImpl.onDestroy$lambda$2$lambda$1(i3, str);
                    }
                });
            }
        }
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
        Lazy<com.tencent.qqnt.push.a> lazy;
        com.tencent.qqnt.push.a value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(businessType), Long.valueOf(msgType), Long.valueOf(msgSubType), Boolean.valueOf(online), msgBuf);
            return;
        }
        if (QLog.isColorLevel() && (((int) msgType) != 732 || ((int) msgSubType) != 17)) {
            QLog.d(TAG, 2, "onSysMsgNotification: msg=0x" + Util.toHexString(msgType) + "_0x" + Util.toHexString(msgSubType) + ", online=" + online);
        }
        try {
            Map<Long, Lazy<com.tencent.qqnt.push.a>> map = TroopPushCMD.f360703a.b().get(Integer.valueOf((int) msgType));
            if (map != null && (lazy = map.get(Long.valueOf(msgSubType))) != null && (value = lazy.getValue()) != null) {
                value.a(msgBuf);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onSysMsgNotification: ", e16);
            throw e16;
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
