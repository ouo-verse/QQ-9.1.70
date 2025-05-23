package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
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
import com.tencent.qqnt.kernel.nativeinterface.UnreadCnt;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopTitlePart$setNotificationRedDotListener$1", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "onContactUnreadCntUpdate", "", "newUnreadCntInfos", "Ljava/util/HashMap;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopTitlePart$setNotificationRedDotListener$1 implements IKernelMsgListener {
    final /* synthetic */ MiniAppDesktopTitlePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniAppDesktopTitlePart$setNotificationRedDotListener$1(MiniAppDesktopTitlePart miniAppDesktopTitlePart) {
        this.this$0 = miniAppDesktopTitlePart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onContactUnreadCntUpdate$lambda$0(MiniAppDesktopTitlePart this$0, Integer num) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView = this$0.mRedDotTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDotTv");
            textView = null;
        }
        textView.setText(num.toString());
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
        ax.a(this, msgRecord);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onContactUnreadCntUpdate(HashMap<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntInfos) {
        UnreadCnt showUnreadCnt;
        QLog.d(this.this$0.getTAG(), 1, "onContactUnreadCntUpdate!");
        final Integer num = null;
        HashMap<String, UnreadCntInfo> hashMap = newUnreadCntInfos != null ? newUnreadCntInfos.get(114) : null;
        if (hashMap != null) {
            UnreadCntInfo unreadCntInfo = hashMap.get(QzoneConfig.DEFAULT_APPLETS_UID);
            if (unreadCntInfo != null && (showUnreadCnt = unreadCntInfo.getShowUnreadCnt()) != null) {
                num = Integer.valueOf(showUnreadCnt.getCnt());
            }
            if (num == null || num.intValue() == 0) {
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final MiniAppDesktopTitlePart miniAppDesktopTitlePart = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.aj
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppDesktopTitlePart$setNotificationRedDotListener$1.onContactUnreadCntUpdate$lambda$0(MiniAppDesktopTitlePart.this, num);
                }
            });
        }
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
    public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
        ax.S(this, i3, j3, j16, z16, arrayList);
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
