package com.tencent.mobileqq.emotionintegrate;

import android.content.Intent;
import android.os.Handler;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.EmotionDataSource;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback;
import com.tencent.mobileqq.emotionintegrate.aa;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
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
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class aa extends EmotionDataSource implements EmotionDownGIFCallback.a {
    static IPatchRedirector $redirector_;
    private HashMap<MessageForPic, EmotionDownGIFCallback> C;
    private EmotionDownGIFCallback.a D;
    private EmotionGallery E;

    /* renamed from: d, reason: collision with root package name */
    public r f205189d;

    /* renamed from: e, reason: collision with root package name */
    public MessageRecord f205190e;

    /* renamed from: f, reason: collision with root package name */
    public SessionInfo f205191f;

    /* renamed from: h, reason: collision with root package name */
    AIOContact f205192h;

    /* renamed from: i, reason: collision with root package name */
    private long f205193i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f205194m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<aa> f205195d;

        /* renamed from: e, reason: collision with root package name */
        private final MessageForPic f205196e;

        public a(aa aaVar, MessageForPic messageForPic) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aaVar, (Object) messageForPic);
            } else {
                this.f205195d = new WeakReference<>(aaVar);
                this.f205196e = messageForPic;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16) {
            aa aaVar = this.f205195d.get();
            if (aaVar != null) {
                aaVar.d2(z16, this.f205196e);
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
        public void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileTransNotifyInfo);
                return;
            }
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.removeMsgListener(this);
            }
            if (this.f205196e == null) {
                QLog.d("MsgEmotionFragmentDataSource", 1, "onRichMediaDownloadComplete pic is null");
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = "onRichMediaDownloadComplete msgId=";
                if (fileTransNotifyInfo != null) {
                    obj = Long.valueOf(fileTransNotifyInfo.getMsgId());
                } else {
                    obj = "null";
                }
                objArr[1] = obj;
                objArr[2] = ", rootMsgId=";
                objArr[3] = Long.valueOf(this.f205196e.getNTRootMsgId());
                QLog.d("MsgEmotionFragmentDataSource", 2, objArr);
            }
            if (fileTransNotifyInfo != null && fileTransNotifyInfo.getMsgId() == this.f205196e.getNTRootMsgId()) {
                final boolean fileExists = FileUtils.fileExists(fileTransNotifyInfo.getFilePath());
                this.f205196e.path = fileTransNotifyInfo.getFilePath();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        aa.a.this.b(fileExists);
                    }
                });
            }
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

    public aa(Intent intent, y yVar, SessionInfo sessionInfo) {
        this(intent, yVar, sessionInfo, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, intent, yVar, sessionInfo);
    }

    public static void f(List<p> list, MessageRecord messageRecord) {
        Pair<Boolean, Integer> j3;
        if (messageRecord == null) {
            QLog.e("MsgEmotionFragmentDataSource", 1, "checkAndAddClickedData error, messageRecord is null!");
            return;
        }
        int size = list.size();
        if (t.f205295a.b()) {
            j3 = i(list, messageRecord);
        } else {
            j3 = j(list, messageRecord);
        }
        if (j3.getFirst().booleanValue()) {
            QLog.i("MsgEmotionFragmentDataSource", 1, "checkAndAddClickedData==contain");
            return;
        }
        int intValue = j3.getSecond().intValue();
        QLog.i("MsgEmotionFragmentDataSource", 1, "checkAndAddClickedData insertIndex = " + intValue);
        if (intValue < 0) {
            size = 0;
        } else if (intValue <= size) {
            size = intValue;
        }
        list.add(size, new y(messageRecord));
    }

    private static Pair<Boolean, Integer> i(List<p> list, MessageRecord messageRecord) {
        int i3;
        int size = list.size() - 1;
        while (true) {
            if (size >= 0) {
                p pVar = list.get(size);
                if (messageRecord.shmsgseq > pVar.j()) {
                    i3 = size + 1;
                    break;
                }
                if (messageRecord.uniseq == pVar.k()) {
                    QLog.i("MsgEmotionFragmentDataSource", 1, "findInsertIndexWithMsgSeq==contain");
                    return new Pair<>(Boolean.TRUE, -1);
                }
                size--;
            } else {
                i3 = 0;
                break;
            }
        }
        return new Pair<>(Boolean.FALSE, Integer.valueOf(i3));
    }

    private static Pair<Boolean, Integer> j(List<p> list, MessageRecord messageRecord) {
        int i3;
        int size = list.size() - 1;
        while (true) {
            if (size >= 0) {
                p pVar = list.get(size);
                if (messageRecord.uniseq > pVar.k()) {
                    i3 = size + 1;
                    break;
                }
                if (messageRecord.uniseq == pVar.k()) {
                    QLog.i("MsgEmotionFragmentDataSource", 1, "findInsertIndexWithUniSeq==contain");
                    return new Pair<>(Boolean.TRUE, -1);
                }
                size--;
            } else {
                i3 = 0;
                break;
            }
        }
        return new Pair<>(Boolean.FALSE, Integer.valueOf(i3));
    }

    private IPicTransFile.a l(MessageForPic messageForPic) {
        QQAppInterface k3 = k();
        if (k3 != null) {
            com.tencent.mobileqq.pic.k kVar = new com.tencent.mobileqq.pic.k();
            int i3 = messageForPic.fileSizeFlag;
            kVar.R = i3;
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            IHttpCommunicatorListener findProcessor = ((ITransFileController) k3.getRuntimeService(ITransFileController.class)).findProcessor(BaseTransFileController.makeReceiveKey(messageForPic.md5, messageForPic.uuid, ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE, z16)));
            if (findProcessor != null && (findProcessor instanceof IPicTransFile.a)) {
                return (IPicTransFile.a) findProcessor;
            }
            return null;
        }
        return null;
    }

    private boolean n(long j3, MessageRecord messageRecord) {
        if (j3 == messageRecord.uniseq) {
            return true;
        }
        if (!(messageRecord instanceof MessageForPic)) {
            return false;
        }
        long j16 = ((MessageForPic) messageRecord).replyRealSourceMsgId;
        if (j16 != -1 && j16 == j3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanMessage(this.f205190e)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public List<p> c(boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        MessageRecord messageRecord = this.f205190e;
        if (messageRecord != null && messageRecord.isMultiMsg) {
            j3 = messageRecord.msgseq;
        } else {
            j3 = -1;
        }
        long j16 = j3;
        r rVar = this.f205189d;
        SessionInfo sessionInfo = this.f205191f;
        List<MessageRecord> d16 = rVar.d(sessionInfo.f179557e, sessionInfo.f179555d, z16, j16);
        ArrayList arrayList = new ArrayList();
        if (d16 != null && !d16.isEmpty()) {
            Iterator<MessageRecord> it = d16.iterator();
            while (it.hasNext()) {
                arrayList.add(new y(it.next()));
            }
            f(arrayList, this.f205190e);
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgEmotionFragmentDataSource", 2, "loadData result empty!");
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.a
    public void d2(boolean z16, MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), messageForPic);
            return;
        }
        EmotionDownGIFCallback remove = this.C.remove(messageForPic);
        IPicTransFile.a l3 = l(messageForPic);
        if (l3 != null) {
            l3.removeDownCallBack(remove);
        }
        p pVar = (p) this.E.getSelectedItem();
        if (!(pVar instanceof y)) {
            return;
        }
        MessageRecord messageRecord = ((y) pVar).f205303a;
        if (messageRecord != null && messageForPic != null && messageRecord != messageForPic) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgEmotionFragmentDataSource", 2, "onUIResult, mr not equal, picMr:" + messageForPic.uniseq + " mr:" + messageRecord.uniseq);
                return;
            }
            return;
        }
        this.D.d2(z16, messageForPic);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!this.C.isEmpty()) {
            for (Map.Entry<MessageForPic, EmotionDownGIFCallback> entry : this.C.entrySet()) {
                IPicTransFile.a l3 = l(entry.getKey());
                if (l3 != null) {
                    l3.removeDownCallBack(entry.getValue());
                }
            }
        }
        this.C.clear();
    }

    public boolean g(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) pVar)).booleanValue();
        }
        if (!(pVar instanceof y)) {
            return true;
        }
        MessageRecord messageRecord = ((y) pVar).f205303a;
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            if (!FileUtils.fileExists(messageForPic.path)) {
                return false;
            }
            File file = new File(messageForPic.path);
            if (messageForPic.fileSizeFlag != 1 && messageForPic.mShowLength > 0) {
                long j3 = messageForPic.size;
                if (!messageForPic.isMixed) {
                    long length = file.length();
                    if (length < j3) {
                        if (QLog.isColorLevel()) {
                            QLog.i("MsgEmotionFragmentDataSource", 2, "checkMsgPicReady, fileLen:" + length + " fileLenBySender:" + j3);
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    protected r h(SessionInfo sessionInfo, AIOContact aIOContact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (r) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sessionInfo, (Object) aIOContact);
        }
        return new r(sessionInfo, sessionInfo.f179557e, sessionInfo.f179555d, aIOContact);
    }

    protected QQAppInterface k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public void m(EmotionGallery emotionGallery, EmotionAdapter emotionAdapter, long j3, EmotionDataSource.a aVar) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, emotionGallery, emotionAdapter, Long.valueOf(j3), aVar);
            return;
        }
        if (this.f205194m && j3 == this.f205193i) {
            aVar.m5();
            return;
        }
        List<p> e16 = emotionAdapter.e();
        if (e16 != null) {
            Iterator<p> it = e16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if ((next instanceof y) && ((y) next).f205303a.uniseq == j3) {
                    z16 = true;
                    break;
                }
            }
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgEmotionFragmentDataSource", 2, "onRevokeMsg notContain seq:" + j3);
                return;
            }
            return;
        }
        p pVar = (p) emotionGallery.getSelectedItem();
        if (pVar == null) {
            return;
        }
        MessageRecord messageRecord = ((y) pVar).f205303a;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRevokeMsg seq:");
            sb5.append(j3);
            sb5.append(", selectItem seq:");
            if (messageRecord != null) {
                j16 = messageRecord.uniseq;
            } else {
                j16 = 0;
            }
            sb5.append(j16);
            QLog.d("MsgEmotionFragmentDataSource", 2, sb5.toString());
        }
        if (messageRecord == null) {
            return;
        }
        if (n(j3, messageRecord)) {
            aVar.m5();
        } else {
            d(aVar, pVar, true);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.a
    public void nf(int i3, MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) messageForPic);
            return;
        }
        p pVar = (p) this.E.getSelectedItem();
        if (!(pVar instanceof y) || ((y) pVar).f205303a != messageForPic) {
            return;
        }
        this.D.nf(i3, messageForPic);
    }

    public void o(EmotionGallery emotionGallery, Handler handler, p pVar, EmotionDownGIFCallback.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, emotionGallery, handler, pVar, aVar);
            return;
        }
        if (!(pVar instanceof y)) {
            return;
        }
        MessageRecord messageRecord = ((y) pVar).f205303a;
        if (!(messageRecord instanceof MessageForPic)) {
            return;
        }
        this.D = aVar;
        this.E = emotionGallery;
        MessageForPic messageForPic = (MessageForPic) messageRecord;
        if (QLog.isColorLevel()) {
            QLog.d("MsgEmotionFragmentDataSource", 2, "triggerDownloadPic, mr uniseq: " + messageForPic.uniseq);
        }
        if (this.f205192h == null) {
            QLog.e("MsgEmotionFragmentDataSource", 1, "triggerDownloadPic error, mNTAIOContact is null!");
            return;
        }
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("MsgEmotionFragmentDataSource", 1, "triggerDownloadPic error, kernelMsgService is null!");
            return;
        }
        EmotionDownGIFCallback emotionDownGIFCallback = new EmotionDownGIFCallback(messageForPic, handler, this);
        if (!this.C.containsKey(messageForPic)) {
            this.C.put(messageForPic, emotionDownGIFCallback);
        }
        e16.addMsgListener(new a(this, messageForPic));
        e16.getRichMediaElement(new RichMediaElementGetReq(messageForPic.getNTRootMsgId(), messageForPic.getNTRootPeerUid(), messageForPic.getNTRootChatType(), messageForPic.subTypeId, 1, 0, "", 0L, 2, 0));
        AIOImageProviderService.O5(k(), messageForPic);
    }

    public aa(Intent intent, y yVar, SessionInfo sessionInfo, AIOContact aIOContact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, yVar, sessionInfo, aIOContact);
            return;
        }
        this.C = new HashMap<>();
        this.f205192h = aIOContact;
        this.f205189d = h(sessionInfo, aIOContact);
        this.f205190e = yVar.f205303a;
        this.f205191f = sessionInfo;
        if (sessionInfo.f179557e == null) {
            QLog.d("MsgEmotionFragmentDataSource", 1, "mSessionInfo.curFriendUin is null, force update to \"\"");
            this.f205191f.f179557e = "";
        }
        this.f205193i = intent.getLongExtra(PeakConstants.KEY_MULTI_FORWARD_SEQ, 0L);
        this.f205194m = intent.getBooleanExtra(PeakConstants.KEY_IS_MULTI_FROWARD_MSG, false);
    }
}
