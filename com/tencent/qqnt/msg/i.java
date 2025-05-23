package com.tencent.qqnt.msg;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DevInfo;
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
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016J8\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0002H\u0016J,\u0010#\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J>\u0010(\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010)\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0002H\u0016J\u0018\u0010*\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0002H\u0016J\u001e\u0010,\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002H\u0016J*\u00100\u001a\u00020\u00052 \u0010/\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020.0-\u0018\u00010-H\u0016J*\u00104\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00022\u0006\u00103\u001a\u00020\u0014H\u0016J\u0012\u00107\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u0012\u00108\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u0012\u00109\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010;\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010>\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010A\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J\u0018\u0010B\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0002H\u0016\u00a8\u0006G"}, d2 = {"Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/DevInfo;", "devList", "", "onLineDev", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "kickedInfo", "onKickedOffLine", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgSetting;", "msgSetting", "onMsgSettingUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "onAddSendMsg", TabPreloadItem.TAB_NAME_MESSAGE, "onRecvMsg", "", "businessType", "", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "", TPReportKeys.Common.COMMON_ONLINE, "", "msgBuf", "onSysMsgNotification", "onRecvSysMsg", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "errorCode", "", "errorMsg", "onSendMsgError", QCircleLpReportDc010001.KEY_SUBTYPE, "retCode", "", "transInfo", "onRecvMsgSvrRspTransInfo", "onMsgInfoListAdd", "onMsgInfoListUpdate", "msgIds", "onMsgDelete", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "newUnreadCntInfos", "onContactUnreadCntUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "draftTime", "onDraftUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "onRichMediaUploadComplete", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiNotifyInfo;", "onEmojiDownloadComplete", "Lcom/tencent/qqnt/kernel/nativeinterface/CustomWithdrawConfig;", DownloadInfo.spKey_Config, "onCustomWithdrawConfigUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "inputStatusInfo", "onInputStatusPush", "onFileMsgCome", "<init>", "()V", "d", "a", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class i implements IKernelMsgListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msg/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.i$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37898);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onAddSendMsg(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (QLog.isDevelopLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onAddSendMsg msgRecord: " + msgRecord);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onContactUnreadCntUpdate(@Nullable HashMap<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntInfos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newUnreadCntInfos);
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onContactUnreadCntUpdate newUnreadCntInfos: " + newUnreadCntInfos);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onCustomWithdrawConfigUpdate(@Nullable CustomWithdrawConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) config);
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onCustomWithdrawConfigUpdate notifyInfo: " + config);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onDraftUpdate(@Nullable Contact peer, @Nullable ArrayList<MsgElement> msgElements, long draftTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, peer, msgElements, Long.valueOf(draftTime));
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onDraftUpdate");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onEmojiDownloadComplete(@Nullable EmojiNotifyInfo notifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) notifyInfo);
        } else {
            QLog.d("IMsgListenerAdapter", 1, "onEmojiDownloadComplete");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
        ax.f(this, emojiResourceInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onFileMsgCome(@Nullable ArrayList<MsgRecord> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) msgList);
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onFileMsgCome");
        }
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
    public void onInputStatusPush(@Nullable InputStatusInfo inputStatusInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) inputStatusInfo);
            return;
        }
        QLog.d("IMsgListenerAdapter", 2, "onInputStatusPush notifyInfo: " + inputStatusInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onKickedOffLine(@NotNull KickedInfo kickedInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) kickedInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(kickedInfo, "kickedInfo");
        if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 1, "onKickedOffLine");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onLineDev(@NotNull ArrayList<DevInfo> devList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) devList);
            return;
        }
        Intrinsics.checkNotNullParameter(devList, "devList");
        if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 1, "onLineDev");
        }
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
    public void onMsgDelete(@NotNull Contact peer, @NotNull ArrayList<Long> msgIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) peer, (Object) msgIds);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onMsgDelete");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onMsgInfoListAdd(@Nullable ArrayList<MsgRecord> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgList);
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onMsgInfoListAdd msgList: " + msgList);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onMsgInfoListUpdate(@Nullable ArrayList<MsgRecord> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgList);
        }
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
    public void onMsgSettingUpdate(@NotNull MsgSetting msgSetting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgSetting);
            return;
        }
        Intrinsics.checkNotNullParameter(msgSetting, "msgSetting");
        if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 1, "onMsgSettingUpdate");
        }
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
    public void onRecvMsg(@NotNull ArrayList<MsgRecord> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (QLog.isDevelopLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onRecvMsg msgList: " + msgList);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onRecvMsgSvrRspTransInfo(long msgId, @Nullable Contact peer, int subType, int retCode, @Nullable String errorMsg, @Nullable byte[] transInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(msgId), peer, Integer.valueOf(subType), Integer.valueOf(retCode), errorMsg, transInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onRecvMsgSvrRspTransInfo msgId: " + msgId + ", subType: " + subType + ", errorMsg: " + errorMsg);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
        ax.K(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onRecvSysMsg(@Nullable ArrayList<Byte> msgBuf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgBuf);
        } else {
            QLog.d("IMsgListenerAdapter", 1, "onRecvSysMsg");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRedTouchChanged() {
        ax.M(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onRichMediaDownloadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) notifyInfo);
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onRichMediaDownloadComplete notifyInfo: " + notifyInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onRichMediaProgerssUpdate(@Nullable FileTransNotifyInfo notifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) notifyInfo);
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onRichMediaProgerssUpdate notifyInfo: " + notifyInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onRichMediaUploadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) notifyInfo);
        } else if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onRichMediaUploadComplete notifyInfo: " + notifyInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
        ax.Q(this, searchGroupFileResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onSendMsgError(long msgId, @Nullable Contact peer, int errorCode, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(msgId), peer, Integer.valueOf(errorCode), errorMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMsgListenerAdapter", 2, "onSendMsgError msgId: " + msgId + ", errorCode: " + errorCode + ", errorMsg: " + errorMsg);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onSysMsgNotification(int businessType, long msgType, long msgSubType, boolean online, @Nullable ArrayList<Byte> msgBuf) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(businessType), Long.valueOf(msgType), Long.valueOf(msgSubType), Boolean.valueOf(online), msgBuf);
            return;
        }
        if (QLog.isColorLevel()) {
            if (msgBuf != null) {
                num = Integer.valueOf(msgBuf.size());
            } else {
                num = null;
            }
            QLog.d("IMsgListenerAdapter", 2, "onSysMsgNotification businessType: " + businessType + ", msgType: " + msgType + ", msgSubType: " + msgSubType + ", online: " + online + ", msgBuf: " + num);
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
