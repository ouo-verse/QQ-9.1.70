package com.tencent.qqnt.aio.adapter.api.impl;

import android.widget.Toast;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler;
import com.tencent.qqnt.kernel.api.IKernelService;
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
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0001\u001c\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOFileErrHandlerNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOFileErrHandler;", "", "startListen", "stopListen", "", "msg", "", "getErrCodeInMsg", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "registerFileIdListen", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "info", "isDownload", "onFileErr", "unRegisterFileIdListen", "Ljava/util/concurrent/ConcurrentHashMap;", "listenIds", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/text/Regex;", "reg$delegate", "Lkotlin/Lazy;", "getReg", "()Lkotlin/text/Regex;", "reg", "com/tencent/qqnt/aio/adapter/api/impl/AIOFileErrHandlerNtImpl$b", "errHandler", "Lcom/tencent/qqnt/aio/adapter/api/impl/AIOFileErrHandlerNtImpl$b;", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOFileErrHandlerNtImpl implements IAIOFileErrHandler {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final long DEFAULT_MSG_ID = -1;

    @NotNull
    public static final String TAG = "AIOFileErrHandlerNtImpl";

    @NotNull
    private final b errHandler;

    @NotNull
    private final ConcurrentHashMap<Long, Contact> listenIds;

    /* renamed from: reg$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy reg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOFileErrHandlerNtImpl$a;", "", "", "DEFAULT_MSG_ID", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOFileErrHandlerNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOFileErrHandlerNtImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaUploadComplete", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFileErrHandlerNtImpl.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            com.tencent.qqnt.kernel.nativeinterface.ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            com.tencent.qqnt.kernel.nativeinterface.ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            com.tencent.qqnt.kernel.nativeinterface.ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            com.tencent.qqnt.kernel.nativeinterface.ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            com.tencent.qqnt.kernel.nativeinterface.ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            com.tencent.qqnt.kernel.nativeinterface.ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            com.tencent.qqnt.kernel.nativeinterface.ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            com.tencent.qqnt.kernel.nativeinterface.ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            com.tencent.qqnt.kernel.nativeinterface.ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            com.tencent.qqnt.kernel.nativeinterface.ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) notifyInfo);
                return;
            }
            if (notifyInfo == null) {
                return;
            }
            long j3 = notifyInfo.msgId;
            QLog.d(AIOFileErrHandlerNtImpl.TAG, 1, "onRichMediaUploadComplete: " + j3);
            if (notifyInfo.trasferStatus == 5) {
                if (AIOFileErrHandlerNtImpl.this.listenIds.containsKey(Long.valueOf(j3)) || AIOFileErrHandlerNtImpl.this.listenIds.containsKey(-1L)) {
                    AIOFileErrHandlerNtImpl.this.onFileErr(notifyInfo, true);
                    if (AIOFileErrHandlerNtImpl.this.listenIds.containsKey(Long.valueOf(j3))) {
                        AIOFileErrHandlerNtImpl.this.unRegisterFileIdListen(notifyInfo.msgId);
                    } else {
                        AIOFileErrHandlerNtImpl.this.unRegisterFileIdListen(-1L);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaUploadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) notifyInfo);
                return;
            }
            if (notifyInfo == null) {
                return;
            }
            long j3 = notifyInfo.msgId;
            QLog.d(AIOFileErrHandlerNtImpl.TAG, 1, "onRichMediaUploadComplete: " + j3);
            if (notifyInfo.trasferStatus == 5) {
                if (AIOFileErrHandlerNtImpl.this.listenIds.containsKey(Long.valueOf(j3)) || AIOFileErrHandlerNtImpl.this.listenIds.containsKey(-1L)) {
                    AIOFileErrHandlerNtImpl.this.onFileErr(notifyInfo, false);
                    if (AIOFileErrHandlerNtImpl.this.listenIds.containsKey(Long.valueOf(j3))) {
                        AIOFileErrHandlerNtImpl.this.unRegisterFileIdListen(notifyInfo.msgId);
                    } else {
                        AIOFileErrHandlerNtImpl.this.unRegisterFileIdListen(-1L);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            com.tencent.qqnt.kernel.nativeinterface.ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Z(this, i3, j3, str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOFileErrHandlerNtImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.listenIds = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(AIOFileErrHandlerNtImpl$reg$2.INSTANCE);
        this.reg = lazy;
        this.errHandler = new b();
    }

    private final int getErrCodeInMsg(String msg2) {
        String removePrefix;
        String removeSuffix;
        MatchResult find$default = Regex.find$default(getReg(), msg2, 0, 2, null);
        if (find$default != null) {
            removePrefix = StringsKt__StringsKt.removePrefix(find$default.getValue(), (CharSequence) "[");
            removeSuffix = StringsKt__StringsKt.removeSuffix(removePrefix, (CharSequence) "]");
            return Integer.parseInt(removeSuffix);
        }
        QLog.d(TAG, 1, "get errcode failed");
        return -1;
    }

    private final Regex getReg() {
        return (Regex) this.reg.getValue();
    }

    private final boolean startListen() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "startListen but app is null");
            return false;
        }
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.d(TAG, 1, "startListen but msgService is null");
            return false;
        }
        msgService.addMsgListener(this.errHandler);
        QLog.d(TAG, 1, "startListen");
        return true;
    }

    private final boolean stopListen() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "stopListen but app is null");
            return false;
        }
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.d(TAG, 1, "stopListen but msgService is null");
            return false;
        }
        msgService.removeMsgListener(this.errHandler);
        QLog.d(TAG, 1, "stopListen");
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler
    public boolean onFileErr(@NotNull FileTransNotifyInfo info, boolean isDownload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, info, Boolean.valueOf(isDownload))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        this.listenIds.get(Long.valueOf(info.msgId));
        Toast.makeText(mobileQQ, "download fail, error code: " + info.fileSrvErrCode + " " + info.clientMsg, 0).show();
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler
    public boolean registerFileIdListen(long msgId, @NotNull Contact contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), contact)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (this.listenIds.isEmpty()) {
            startListen();
        }
        if (this.listenIds.contains(Long.valueOf(msgId))) {
            return false;
        }
        this.listenIds.put(Long.valueOf(msgId), contact);
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileErrHandler
    public boolean unRegisterFileIdListen(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, msgId)).booleanValue();
        }
        Contact remove = this.listenIds.remove(Long.valueOf(msgId));
        if (this.listenIds.isEmpty()) {
            stopListen();
        }
        if (remove != null) {
            return true;
        }
        return false;
    }
}
