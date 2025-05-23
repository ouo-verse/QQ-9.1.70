package com.tencent.qqnt.kernel.invorker;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/j;", "Lcom/tencent/qqnt/kernel/invorker/KBaseInvorkService;", "", ReportConstant.COSTREPORT_PREFIX, "r", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "listener", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/invorker/f;", "notify", "<init>", "(Lcom/tencent/qqnt/kernel/api/IKernelService;Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/invorker/f;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class j extends KBaseInvorkService {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private IKernelMsgListener listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000{\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J6\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J*\u0010 \u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J>\u0010%\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0016\u0010&\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J(\u0010*\u001a\u00020\u00052\u001e\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020(0'0'H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u0010,\u001a\u000200H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u0005H\u0016\u00a8\u00065"}, d2 = {"com/tencent/qqnt/kernel/invorker/j$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onRecvMsg", "", "msgBuf", "onRecvSysMsg", "", "businessType", "", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "", TPReportKeys.Common.COMMON_ONLINE, "onSysMsgNotification", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "kickedInfo", "onKickedOffLine", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgSetting;", "msgSetting", "onMsgSettingUpdate", "msgRecord", "onAddSendMsg", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "errorCode", "", "errorMsg", "onSendMsgError", QCircleLpReportDc010001.KEY_SUBTYPE, "retCode", "", "transInfo", "onRecvMsgSvrRspTransInfo", "onMsgInfoListUpdate", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "newUnreadCntInfos", "onContactUnreadCntUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "onRichMediaUploadComplete", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiNotifyInfo;", "onEmojiDownloadComplete", "onNtMsgSyncStart", "onNtFirstViewMsgSyncEnd", "onNtMsgSyncEnd", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(@NotNull MsgRecord msgRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgRecord);
            } else {
                Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                j.this.t("onAddSendMsg", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("msgRecord", msgRecord.channelId)));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onContactUnreadCntUpdate(@NotNull HashMap<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntInfos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) newUnreadCntInfos);
            } else {
                Intrinsics.checkNotNullParameter(newUnreadCntInfos, "newUnreadCntInfos");
                j.this.t("onContactUnreadCntUpdate", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("newUnreadCntInfos", Integer.valueOf(newUnreadCntInfos.size()))));
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
        public void onEmojiDownloadComplete(@NotNull EmojiNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) notifyInfo);
            } else {
                Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
                j.this.t("onEmojiDownloadComplete", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("notifyInfo", notifyInfo.errMsg)));
            }
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
        public void onKickedOffLine(@NotNull KickedInfo kickedInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) kickedInfo);
            } else {
                Intrinsics.checkNotNullParameter(kickedInfo, "kickedInfo");
                j.this.t("onKickedOffLine", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("kickedInfo", Integer.valueOf(kickedInfo.appId))));
            }
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
        public void onMsgInfoListUpdate(@NotNull ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgList);
            } else {
                Intrinsics.checkNotNullParameter(msgList, "msgList");
                j.this.t("onMsgInfoListUpdate", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to(TabPreloadItem.TAB_NAME_MESSAGE, Integer.valueOf(msgList.size()))));
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgSetting);
            } else {
                Intrinsics.checkNotNullParameter(msgSetting, "msgSetting");
                j.this.t("onMsgSettingUpdate", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("msgSetting", msgSetting.callRemind)));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onNtFirstViewMsgSyncEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this);
            } else {
                j.this.t("onNtFirstViewMsgSyncEnd", "");
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onNtMsgSyncEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this);
            } else {
                j.this.t("onNtMsgSyncEnd", "");
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onNtMsgSyncStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this);
            } else {
                j.this.t("onNtMsgSyncStart", "");
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsg(@NotNull ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgList);
            } else {
                Intrinsics.checkNotNullParameter(msgList, "msgList");
                j.this.t("onRecvMsg", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to(TabPreloadItem.TAB_NAME_MESSAGE, Integer.valueOf(msgList.size()))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsgSvrRspTransInfo(long msgId, @Nullable Contact peer, int subType, int retCode, @Nullable String errorMsg, @Nullable byte[] transInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Long.valueOf(msgId), peer, Integer.valueOf(subType), Integer.valueOf(retCode), errorMsg, transInfo);
            } else {
                j.this.t("onRecvMsgSvrRspTransInfo", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("msgId", Long.valueOf(msgId)), TuplesKt.to(QCircleLpReportDc010001.KEY_SUBTYPE, Integer.valueOf(subType)), TuplesKt.to("peer", peer), TuplesKt.to("errorMsg", errorMsg)));
                ax.J(this, msgId, peer, subType, retCode, errorMsg, transInfo);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvSysMsg(@NotNull ArrayList<Byte> msgBuf) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgBuf);
            } else {
                Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
                j.this.t("onRecvSysMsg", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("msgBuf", Integer.valueOf(msgBuf.size()))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(@NotNull FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) notifyInfo);
            } else {
                Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
                j.this.t("onRichMediaDownloadComplete", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("notifyInfo", Long.valueOf(notifyInfo.msgId))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(@NotNull FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) notifyInfo);
            } else {
                Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
                j.this.t("onRichMediaProgerssUpdate", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("notifyInfo", Long.valueOf(notifyInfo.msgId))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaUploadComplete(@NotNull FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) notifyInfo);
            } else {
                Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
                j.this.t("onRichMediaUploadComplete", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("notifyInfo", Long.valueOf(notifyInfo.msgId))));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSendMsgError(long msgId, @Nullable Contact peer, int errorCode, @NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Long.valueOf(msgId), peer, Integer.valueOf(errorCode), errorMsg);
            } else {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                j.this.t("onSendMsgError", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("msgId", Long.valueOf(msgId)), TuplesKt.to("errorCode", Integer.valueOf(errorCode)), TuplesKt.to("peer", peer), TuplesKt.to("errorMsg", errorMsg)));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSysMsgNotification(int businessType, long msgType, long msgSubType, boolean online, @NotNull ArrayList<Byte> msgBuf) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(businessType), Long.valueOf(msgType), Long.valueOf(msgSubType), Boolean.valueOf(online), msgBuf);
            } else {
                Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
                j.this.t("onSysMsgNotification", com.tencent.qqnt.kernel.internel.a.f359089a.b(TuplesKt.to("businessType", Integer.valueOf(businessType)), TuplesKt.to(QQBrowserActivity.KEY_MSG_TYPE, Long.valueOf(msgType)), TuplesKt.to("msgSubType", Long.valueOf(msgSubType)), TuplesKt.to(TPReportKeys.Common.COMMON_ONLINE, Boolean.valueOf(online)), TuplesKt.to("msgBuf", Integer.valueOf(msgBuf.size()))));
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull IKernelService kernelService, @NotNull AppRuntime app, @NotNull f notify) {
        super(QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME, w.class, kernelService, app, notify);
        Intrinsics.checkNotNullParameter(kernelService, "kernelService");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(notify, "notify");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, kernelService, app, notify);
        }
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.listener = new a();
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IMsgService");
        w wVar = (w) p16;
        IKernelMsgListener iKernelMsgListener = this.listener;
        if (iKernelMsgListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelMsgListener = null;
        }
        wVar.addMsgListener(iKernelMsgListener);
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.invorker.KBaseInvorkService
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qqnt.kernel.api.j p16 = p();
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IMsgService");
        w wVar = (w) p16;
        IKernelMsgListener iKernelMsgListener = this.listener;
        if (iKernelMsgListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            iKernelMsgListener = null;
        }
        wVar.removeMsgListener(iKernelMsgListener);
    }
}
