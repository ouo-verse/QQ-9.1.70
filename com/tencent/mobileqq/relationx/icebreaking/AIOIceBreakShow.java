package com.tencent.mobileqq.relationx.icebreaking;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.utils.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.g;
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
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AIOIceBreakShow implements Handler.Callback, AIOIceBreakView.b {
    static IPatchRedirector $redirector_;
    private List<g> C;
    private int D;
    private com.tencent.aio.api.runtime.a E;
    private int F;
    private IKernelMsgListener G;

    @Nullable
    private String H;

    /* renamed from: d, reason: collision with root package name */
    private int f280734d;

    /* renamed from: e, reason: collision with root package name */
    private AIOIceBreakView f280735e;

    /* renamed from: f, reason: collision with root package name */
    private int f280736f;

    /* renamed from: h, reason: collision with root package name */
    private String f280737h;

    /* renamed from: i, reason: collision with root package name */
    private MqqWeakReferenceHandler f280738i;

    /* renamed from: m, reason: collision with root package name */
    private MqqWeakReferenceHandler f280739m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class RemoveRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f280742d;

        /* renamed from: e, reason: collision with root package name */
        private final String f280743e;

        public RemoveRunnable(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AIOIceBreakShow.this, Integer.valueOf(i3), str);
            } else {
                this.f280742d = i3;
                this.f280743e = str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            IceBreakingMng iceBreakingMng = (IceBreakingMng) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.ICE_BREAKING_MNG);
            if (iceBreakingMng != null) {
                if (AIOIceBreakShow.this.f280736f == 3) {
                    iceBreakingMng.T(this.f280743e);
                } else {
                    int i3 = this.f280742d;
                    if (i3 == 1) {
                        iceBreakingMng.b0(this.f280743e);
                    } else if (IceBreakingUtil.u(i3)) {
                        iceBreakingMng.W(this.f280743e);
                    } else {
                        int i16 = this.f280742d;
                        if (i16 == 1046) {
                            iceBreakingMng.X(this.f280743e);
                        } else if (IceBreakingUtil.w(i16)) {
                            iceBreakingMng.a0(this.f280743e);
                        } else {
                            iceBreakingMng.S(this.f280743e);
                        }
                    }
                }
            }
            QLog.d("AIOIceBreakShow", 1, String.format("removeDelay, type = %s, uin = %s", Integer.valueOf(this.f280742d), this.f280743e));
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOIceBreakShow.this);
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
        public void onMsgInfoListUpdate(ArrayList<MsgRecord> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                return;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            MsgRecord msgRecord = arrayList.get(0);
            if (!msgRecord.getElements().isEmpty() && AIOIceBreakShow.this.f280734d == 0) {
                if (AIOIceBreakShow.this.E.g().r().c().e() == 2) {
                    QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (qQAppInterface != null && String.valueOf(msgRecord.getSenderUin()).equals(qQAppInterface.getCurrentUin())) {
                        AIOIceBreakShow.this.m();
                        AIOIceBreakShow.this.p();
                        return;
                    }
                    return;
                }
                int i3 = msgRecord.msgType;
                if (i3 != 23 && i3 != 1) {
                    AIOIceBreakShow.this.m();
                    AIOIceBreakShow.this.p();
                }
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

    public AIOIceBreakShow(com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f280734d = -1;
        this.f280736f = -1;
        this.C = null;
        this.D = 0;
        this.E = aVar;
        this.f280738i = new MqqWeakReferenceHandler(ThreadManager.getUIHandler().getLooper(), this);
        this.f280739m = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        this.F = IceBreakingUtil.p(Integer.valueOf(this.E.g().r().c().e())).intValue();
        this.f280737h = su3.b.a(this.E.g()).f179557e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(List list, int i3, int i16, boolean z16) {
        QLog.d("AIOIceBreakShow", 1, "updateShow isSingleFollow: " + z16);
        if (!z16) {
            u(list, i3, i16);
        } else {
            m();
        }
    }

    private void k(int i3, String str) {
        ThreadManager.getFileThreadHandler().post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f280740d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f280741e;

            {
                this.f280740d = i3;
                this.f280741e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AIOIceBreakShow.this, Integer.valueOf(i3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (qQAppInterface == null) {
                    QLog.i("AIOIceBreakShow", 1, "markHadShow is invalid! app is null!");
                    return;
                }
                IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
                int i16 = this.f280740d;
                if (i16 == 1) {
                    iceBreakingMng.l(this.f280741e);
                    iceBreakingMng.h0();
                } else if (IceBreakingUtil.u(i16)) {
                    iceBreakingMng.i(this.f280741e);
                    iceBreakingMng.e0();
                } else {
                    int i17 = this.f280740d;
                    if (i17 == 1046) {
                        iceBreakingMng.j(this.f280741e);
                        iceBreakingMng.f0();
                    } else if (IceBreakingUtil.w(i17)) {
                        iceBreakingMng.k(this.f280741e);
                        iceBreakingMng.g0();
                    } else {
                        iceBreakingMng.h(this.f280741e);
                        iceBreakingMng.d0();
                    }
                }
                QLog.d("AIOIceBreakShow", 1, String.format("markEnteredFlag, type = %s, uin = %s", Integer.valueOf(this.f280740d), this.f280741e));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOIceBreakShow", 2, String.format("remove mState: %s", Integer.valueOf(this.f280734d)));
        }
        if (this.f280734d != 0) {
            return;
        }
        AIOIceBreakView aIOIceBreakView = this.f280735e;
        if (aIOIceBreakView != null) {
            this.E.e().h(new AIOMsgListEvent.RemoveStickerBottomFooterView(aIOIceBreakView));
            this.f280735e = null;
        }
        this.f280734d = 2;
    }

    private void o(int i3, String str) {
        this.f280739m.removeCallbacksAndMessages(null);
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.i("AIOIceBreakShow", 1, "removeDelay is invalid! app is null!");
            return;
        }
        IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        int i16 = iceBreakingMng.T;
        if (i3 == 1) {
            i16 = iceBreakingMng.U;
        }
        this.f280739m.postDelayed(new RemoveRunnable(i3, str), i16 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        QLog.i("AIOIceBreakShow", 1, "removeFromBreakingIceMap for receive or send msg!");
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f280739m;
        if (mqqWeakReferenceHandler == null) {
            return;
        }
        mqqWeakReferenceHandler.removeCallbacksAndMessages(null);
        this.f280739m.postDelayed(new RemoveRunnable(this.F, this.f280737h), 0L);
    }

    private void s() {
        int i3;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("AIOIceBreakShow", 2, String.format("show mState: %s, mIceBreakType: %s", Integer.valueOf(this.f280734d), Integer.valueOf(this.f280736f)));
        }
        if (this.f280734d != -1 || this.f280736f == -1) {
            return;
        }
        if (this.f280735e == null) {
            List<g> list = this.C;
            if (list != null && list.size() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOIceBreakShow", 2, "bind data pic urls: " + this.C);
                }
                if (this.E.c() != null && this.E.c().getContext() != null) {
                    this.f280735e = new AIOIceBreakView(this.E);
                } else {
                    this.f280735e = new AIOIceBreakView(this.E, MobileQQ.sMobileQQ.getApplicationContext());
                }
                AIOIceBreakView aIOIceBreakView = this.f280735e;
                if (this.f280736f == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                aIOIceBreakView.setFromPush(z16);
                String str = this.H;
                if (str != null) {
                    this.f280735e.setGrayText(str);
                }
                this.f280735e.h(this.C, this.D);
                this.f280735e.setTag(R.id.f164128ka, Integer.valueOf(this.f280736f));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                this.f280735e.setLayoutParams(layoutParams);
                this.f280735e.setOnIceImageClickListener(this);
            } else {
                QLog.d("AIOIceBreakShow", 1, "rec mRecEmotionList is empty!");
                return;
            }
        }
        if (this.f280735e.getParent() != null) {
            ((ViewGroup) this.f280735e.getParent()).removeView(this.f280735e);
        }
        this.E.e().h(new AIOMsgListEvent.AddStickerBottomFooterView(this.f280735e, -1));
        this.f280734d = 0;
        o(this.F, this.f280737h);
        k(this.F, this.f280737h);
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (this.f280736f == 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009B95", "0X8009B95", i3, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.b
    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        if (IceBreakingUtil.u(this.F)) {
            if (QLog.isColorLevel()) {
                QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove matchChat Ice show");
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOIceBreakShow.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IceBreakingMng) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.ICE_BREAKING_MNG)).W(AIOIceBreakShow.this.f280737h);
                    }
                }
            });
        } else {
            int i3 = this.F;
            if (i3 == 1046) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove matchFriendChat Ice show");
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOIceBreakShow.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ((IceBreakingMng) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.ICE_BREAKING_MNG)).X(AIOIceBreakShow.this.f280737h);
                        }
                    }
                }, 16, null, false);
            } else if (IceBreakingUtil.w(i3)) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove QCircleChat Ice show");
                }
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.5
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOIceBreakShow.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        IceBreakingMng iceBreakingMng = (IceBreakingMng) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.ICE_BREAKING_MNG);
                        if (iceBreakingMng != null) {
                            iceBreakingMng.a0(AIOIceBreakShow.this.f280737h);
                        }
                    }
                });
            } else if (IceBreakingUtil.t(this.F)) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove Game Ice show");
                }
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.6
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOIceBreakShow.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        IceBreakingMng iceBreakingMng = (IceBreakingMng) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.ICE_BREAKING_MNG);
                        if (iceBreakingMng != null) {
                            iceBreakingMng.U(AIOIceBreakShow.this.f280737h);
                        }
                    }
                });
            } else {
                try {
                    QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (qQAppInterface == null) {
                        QLog.i("AIOIceBreakShow", 1, "onImageClick is invalid! app is null!");
                        return;
                    }
                    IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
                    if (this.f280736f == 3) {
                        iceBreakingMng.T(this.f280737h);
                    } else {
                        iceBreakingMng.S(this.f280737h);
                    }
                } catch (NullPointerException e16) {
                    QLog.e("AIOIceBreakShow", 1, e16, new Object[0]);
                }
            }
        }
        this.f280738i.sendEmptyMessage(1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                m();
                return false;
            }
            return false;
        }
        s();
        return false;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.G == null) {
            this.G = new a();
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(this.G);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        m();
        this.f280738i.removeCallbacksAndMessages(null);
        this.f280739m.removeCallbacksAndMessages(null);
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, "show sprite (normal) onDestroy.");
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.G != null) {
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.removeMsgListener(this.G);
            }
            this.G = null;
        }
    }

    public void q(List<g> list, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, list, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f280736f = i16;
        this.C = list;
        this.D = i3;
        this.f280738i.sendEmptyMessage(1);
    }

    public void r(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.H = str;
        }
    }

    public void t(final List<g> list, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, i3);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.i("AIOIceBreakShow", 1, "updateShow is invalid! app is null!");
            return;
        }
        final int w3 = ((IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).w(this.f280737h, this.F);
        QLog.i("AIOIceBreakShow", 1, String.format("updateShow, newType = %s, oldType = %s", Integer.valueOf(w3), Integer.valueOf(this.f280736f)));
        if (w3 == this.f280736f) {
            return;
        }
        if (IceBreakingUtil.w(this.F)) {
            QLog.d("AIOIceBreakShow", 1, "updateShow qcircle scene");
            com.tencent.mobileqq.qcircle.api.utils.a.e(this.f280737h, new a.b() { // from class: com.tencent.mobileqq.relationx.icebreaking.a
                @Override // com.tencent.mobileqq.qcircle.api.utils.a.b
                public final void a(boolean z16) {
                    AIOIceBreakShow.this.j(list, i3, w3, z16);
                }
            });
        } else {
            u(list, i3, w3);
        }
    }

    public void u(List<g> list, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 != -1) {
            if (list != null && !list.isEmpty()) {
                this.f280736f = i16;
                this.C = list;
                this.D = i3;
                this.f280738i.sendMessage(this.f280738i.obtainMessage(0, 0, 0));
                return;
            }
            QLog.d("AIOIceBreakShow", 1, "update show but hotPicList is empty!");
            return;
        }
        q(list, i3, i16);
    }
}
