package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.managers.MsgRefreshTipMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
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
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/x;", "Lcom/tencent/mobileqq/activity/home/chats/biz/d;", "", "na", "Lmqq/app/AppRuntime;", "app", "oa", "", "ea", "J9", "K9", "newRuntime", "onAccountChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/activity/home/chats/biz/x$a$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/home/chats/biz/x$a$a;", "kernelListener", "", "D", "Z", "ma", "()Z", "pa", "(Z)V", "needShowTips", "Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;", "paramGetter", "<init>", "(Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;)V", "E", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class x extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Companion.C7172a kernelListener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean needShowTips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/x$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.chats.biz.x$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/x$a$a;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "", "onNtMsgSyncStart", "onNtFirstViewMsgSyncEnd", "onNtMsgSyncEnd", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/home/chats/biz/x;", "d", "Lmqq/util/WeakReference;", "weakPart", "<init>", "(Lmqq/util/WeakReference;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.activity.home.chats.biz.x$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C7172a implements IKernelMsgListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final WeakReference<x> weakPart;

            public C7172a(@NotNull WeakReference<x> weakPart) {
                Intrinsics.checkNotNullParameter(weakPart, "weakPart");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakPart);
                } else {
                    this.weakPart = weakPart;
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
            public void onNtFirstViewMsgSyncEnd() {
                Boolean bool;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                x xVar = this.weakPart.get();
                if (xVar != null) {
                    bool = Boolean.valueOf(xVar.ma());
                } else {
                    bool = null;
                }
                QLog.d("ConvTitleAreaPart", 1, "onNtFirstViewMsgSyncEnd " + bool);
                if (xVar != null && xVar.ma()) {
                    MsgRefreshTipMgr.INSTANCE.a().k(4);
                    xVar.pa(false);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
            public /* synthetic */ void onNtMsgSyncContactUnread() {
                ax.F(this);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
            public void onNtMsgSyncEnd() {
                Boolean bool;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                x xVar = this.weakPart.get();
                if (xVar != null) {
                    bool = Boolean.valueOf(xVar.ma());
                } else {
                    bool = null;
                }
                QLog.d("ConvTitleAreaPart", 1, "onNtMsgSyncEnd " + bool);
                if (xVar != null && xVar.ma()) {
                    MsgRefreshTipMgr.INSTANCE.a().k(4);
                    xVar.pa(false);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
            public void onNtMsgSyncStart() {
                Boolean bool;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                x xVar = this.weakPart.get();
                if (xVar != null) {
                    bool = Boolean.valueOf(xVar.ma());
                } else {
                    bool = null;
                }
                QLog.d("ConvTitleAreaPart", 1, "onNtMsgSyncStart " + bool);
                if (xVar != null && xVar.ma()) {
                    MsgRefreshTipMgr.INSTANCE.a().k(3);
                }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public x(@Nullable com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.needShowTips = true;
        }
    }

    private final void na() {
        com.tencent.qqnt.kernel.api.w msgService;
        AppRuntime X9 = X9();
        if (X9 != null && (msgService = ((IKernelService) X9.getRuntimeService(IKernelService.class, "all")).getMsgService()) != null) {
            Companion.C7172a c7172a = new Companion.C7172a(new WeakReference(this));
            this.kernelListener = c7172a;
            Intrinsics.checkNotNull(c7172a);
            msgService.addMsgListener(c7172a);
            if (msgService.U() && !msgService.J0()) {
                QLog.d("ConvTitleAreaPart", 1, "MsgSyncStart");
                MsgRefreshTipMgr.INSTANCE.a().k(3);
            } else if (msgService.J0()) {
                QLog.d("ConvTitleAreaPart", 1, "MsgSyncEnd");
                MsgRefreshTipMgr.INSTANCE.a().k(4);
            }
        }
    }

    private final void oa(AppRuntime app) {
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.w msgService;
        Companion.C7172a c7172a = this.kernelListener;
        if (c7172a != null && app != null && (iKernelService = (IKernelService) app.getRuntimeService(IKernelService.class, "all")) != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.removeMsgListener(c7172a);
        }
        this.kernelListener = null;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void J9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.J9();
            na();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void K9(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        super.K9(app);
        oa(app);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    @NotNull
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ConvTitleAreaPart";
    }

    public final boolean ma() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.needShowTips;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newRuntime);
            return;
        }
        super.onAccountChanged(newRuntime);
        na();
        this.needShowTips = true;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        oa(X9());
    }

    public final void pa(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.needShowTips = z16;
        }
    }
}
