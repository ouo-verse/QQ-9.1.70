package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostShareUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSShareSuccessEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetShareMessageInfoRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.widgets.person.QFSPersonalQrcodeFragment;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.api.data.QCircleFeedCoverBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleTransActivityLifeEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSetCoverFeedEvent;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import com.tencent.richframework.engineer.test.api.RFWTestDataSource;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.SetShareMessageInfoRsp;
import feedcloud.ShareMessageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import vb0.a;

/* loaded from: classes4.dex */
public class QFSSharePart extends com.tencent.biz.qqcircle.bizparts.b implements DialogInterface.OnShowListener, SimpleEventReceiver {
    private Activity E;
    private Context F;
    private QCircleRichMediaDownLoadPart G;
    private View H;
    private View I;
    private Dialog J;
    private yb0.j K;
    private QFSPersonalQrcodeFragment L;
    private IKernelMsgListener N;

    /* renamed from: d, reason: collision with root package name */
    private HostShareUtils f82808d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleShareInfo f82809e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StFeed f82810f;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> f82813m;

    /* renamed from: h, reason: collision with root package name */
    private String f82811h = "";

    /* renamed from: i, reason: collision with root package name */
    private byte[] f82812i = null;
    private boolean C = false;
    private Handler D = new Handler(Looper.getMainLooper());
    private boolean M = false;
    private final AtomicBoolean P = new AtomicBoolean(false);
    private final ConcurrentHashMap<String, Long> Q = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, MsgRecord> R = new ConcurrentHashMap<>();
    private final Runnable S = new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSSharePart.1
        @Override // java.lang.Runnable
        public void run() {
            QFSSharePart.this.qa();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSSharePart$11, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(QCircleSetShareMessageInfoRequest qCircleSetShareMessageInfoRequest, BaseRequest baseRequest, boolean z16, long j3, String str, SetShareMessageInfoRsp setShareMessageInfoRsp) {
            QLog.d("QFSSharePart", 1, "[requestSetShareMessage] onReceive: dispatch Success:" + z16 + " | TraceId:" + qCircleSetShareMessageInfoRequest.getTraceId() + " | SeqId:" + qCircleSetShareMessageInfoRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            ArrayList arrayList = new ArrayList();
            for (Long l3 : QFSSharePart.this.Q.values()) {
                if (l3 != null) {
                    for (Map.Entry entry : QFSSharePart.this.R.entrySet()) {
                        if (l3.equals(entry.getKey())) {
                            if (QFSSharePart.this.f82809e != null && QFSSharePart.this.f82809e.feed != null) {
                                str = QFSSharePart.this.f82809e.feed.f398449id.get();
                            } else {
                                str = null;
                            }
                            ShareMessageInfo a16 = com.tencent.biz.qqcircle.immersive.utils.au.a(str, (MsgRecord) entry.getValue());
                            if (a16 != null) {
                                QLog.d(QFSSharePart.this.getTAG(), 1, "[requestSetShareMessage] feedID:" + a16.feedID + ", shareUin:" + a16.shareUin + ", dstUin:" + a16.dstUin + ", dstUinType:" + a16.dstUinType);
                                arrayList.add(a16);
                            }
                        }
                    }
                }
            }
            QFSSharePart.this.Q.clear();
            QFSSharePart.this.R.clear();
            QFSSharePart.this.P.set(false);
            if (QFSSharePart.this.f82808d != null && !QFSSharePart.this.f82808d.isShowing()) {
                QLog.e(QFSSharePart.this.getTAG(), 1, "[requestSetShareMessage] share action sheet is not showing, remove msg listener");
                QFSSharePart.this.pa();
            }
            if (!arrayList.isEmpty()) {
                QLog.d(QFSSharePart.this.getTAG(), 1, "[requestSetShareMessage] start, size:" + arrayList.size());
                final QCircleSetShareMessageInfoRequest qCircleSetShareMessageInfoRequest = new QCircleSetShareMessageInfoRequest(arrayList);
                VSNetworkHelper.getInstance().sendRequest(qCircleSetShareMessageInfoRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.dv
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                        QFSSharePart.AnonymousClass11.b(QCircleSetShareMessageInfoRequest.this, baseRequest, z16, j3, str2, (SetShareMessageInfoRsp) obj);
                    }
                });
                return;
            }
            QLog.e(QFSSharePart.this.getTAG(), 1, "[requestSetShareMessage] shareMessageInfoList is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements IKernelMsgListener {
        a() {
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
        public void onMsgInfoListUpdate(ArrayList<MsgRecord> arrayList) {
            if (arrayList.isEmpty()) {
                return;
            }
            Iterator<MsgRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord next = it.next();
                if (next != null && next.sendStatus == 2) {
                    QLog.d(QFSSharePart.this.getTAG(), 1, "[onMsgInfoListUpdate] chatType:" + next.getChatType() + ", msgId:" + next.getMsgId() + ", sendUin:" + next.getSenderUin() + ", sendUid:" + next.getSenderUid() + ", peerUin:" + next.getPeerUin() + ", peerUid:" + next.getPeerUid());
                    QFSSharePart.this.R.put(Long.valueOf(next.getMsgId()), next);
                }
            }
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
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.P(this, fileTransNotifyInfo);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f82818d;

        b(Activity activity) {
            this.f82818d = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String str = "mqq://card/show_pslcard?src_type=internal&version=1&card_type=person&uin=" + QCircleCommonUtil.getCurrentAccount();
            QLog.d(QFSSharePart.this.getTAG(), 1, "[handleQFSSetQQProfileCoverEvent] click url:" + str);
            i40.c.f407182a.a(this.f82818d, str);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QFSSharePart.this.ra(false);
            QFSSharePart.this.K = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnCancelListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            QFSSharePart.this.ra(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnShowListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ yb0.j f82822d;

        e(yb0.j jVar) {
            this.f82822d = jVar;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            QFSSharePart.this.na(this.f82822d);
            QFSSharePart.this.ua(dialogInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements wb0.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb0.j f82824a;

        f(yb0.j jVar) {
            this.f82824a = jVar;
        }

        @Override // wb0.c
        public void a() {
            this.f82824a.F(QCircleBaseShareOperation.s((Activity) QFSSharePart.this.getContext(), QFSSharePart.this.f82809e.feed));
            if (QFSSharePart.this.W9()) {
                this.f82824a.k(QFSSharePart.this.getContext(), QFSSharePart.this.f82810f);
            }
        }

        @Override // wb0.c
        public void b() {
            this.f82824a.F(new Intent());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements QCircleRichMediaDownLoadManager.e {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3) {
            QFSSharePart.this.broadcastMessage("rich_meida_download_progress", Integer.valueOf(i3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(boolean z16) {
            QFSSharePart.this.broadcastMessage("rich_media_download_status", Boolean.valueOf(z16));
        }

        @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
        public void onProgress(final int i3) {
            if (QFSSharePart.this.getPartManager() != null) {
                QFSSharePart.this.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dx
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSSharePart.g.this.c(i3);
                    }
                });
            } else if (QFSSharePart.this.G != null) {
                QFSSharePart.this.G.handleBroadcastMessage("rich_meida_download_progress", Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
        public void onStatusChange(final boolean z16) {
            if (QFSSharePart.this.getPartManager() != null) {
                QFSSharePart.this.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.dw
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSSharePart.g.this.d(z16);
                    }
                });
            } else if (QFSSharePart.this.G != null) {
                QFSSharePart.this.G.handleBroadcastMessage("rich_media_download_status", Boolean.valueOf(z16));
            }
        }
    }

    private void V9() {
        if (this.M) {
            return;
        }
        if (this.N == null) {
            this.N = new a();
        }
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W9() {
        int i3;
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (qCircleShareInfo != null && (i3 = qCircleShareInfo.type) != 12 && i3 != 13) {
            return true;
        }
        return false;
    }

    private void X9() {
        try {
            if (this.H != null && (this.I instanceof ViewGroup) && ja()) {
                QLog.d("QFSSharePart", 1, "clear dim success. ");
                ((ViewGroup) this.I).removeView(this.H);
            }
            this.H = null;
        } catch (Exception e16) {
            QLog.e("QFSSharePart", 1, "clearDim error !", e16);
        }
    }

    private ShareActionSheetClickListener Y9() {
        QLog.d("QFSSharePart", 1, "[createActionSheetListener]");
        return new a.h().u(this.f82809e).l(getActivity()).r(this.f82811h).s(this.f82812i).p(getPageId()).q(getParentPageId()).t(getReportBean()).o(ia()).n(ha()).m(this.f82810f).k();
    }

    private void Z9() {
        QLog.d("QFSSharePart", 1, "[feedReRank]");
        if (wa0.c.f().g() > 0) {
            cc0.e.b(this.f82809e.feedBlockData);
        }
    }

    private ShareConfig aa() {
        ShareConfig shareConfig = new ShareConfig();
        shareConfig.isShowShareToFriend = false;
        shareConfig.isShowShareToQZone = false;
        shareConfig.isShowShareToWechat = false;
        shareConfig.isShowShareToWechatCircle = false;
        shareConfig.isShowShareToChannel = false;
        shareConfig.isForceNightTheme = false;
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (qCircleShareInfo == null) {
            return shareConfig;
        }
        shareConfig.isShowSetToPublicPermission = qCircleShareInfo.isShowSetToPublicPermission;
        shareConfig.isShowSetToPrivatePermission = qCircleShareInfo.isShowSetToPrivatePermission;
        shareConfig.isShowDelete = qCircleShareInfo.isShowDelete;
        shareConfig.isShowStick = qCircleShareInfo.isShowStick;
        shareConfig.isShowUnStick = qCircleShareInfo.isShowUnStick;
        shareConfig.isShowHideThisWork = qCircleShareInfo.isShowHideThisWork;
        shareConfig.isShowReport = qCircleShareInfo.isShowReport;
        shareConfig.isShowDeletePush = qCircleShareInfo.isShowDeletePush;
        shareConfig.isShowDeletePushDisable = qCircleShareInfo.isShowDeletePushDisable;
        shareConfig.isShowDebug = QCircleApplication.isRDMVersion();
        QCircleShareInfo qCircleShareInfo2 = this.f82809e;
        shareConfig.isShowCopyContent = qCircleShareInfo2.isShowCopyContent;
        shareConfig.isShowCopySchemaLink = false;
        shareConfig.isShowDeleteAndEditAlbum = qCircleShareInfo2.isShowDeleteAndEditAlbum;
        shareConfig.isShowShareToChannel = HostStaticInvokeHelper.isShowGuildTab();
        return shareConfig;
    }

    private ShareConfig ba() {
        boolean z16;
        if (getFeedData() != null && getFeedData().feedType.get() == 4) {
            return aa();
        }
        ShareConfig shareConfig = new ShareConfig();
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (qCircleShareInfo == null) {
            return shareConfig;
        }
        shareConfig.isShowDelete = qCircleShareInfo.isShowDelete;
        if ("\u7ba1\u7406\u4f5c\u54c1".equals(qCircleShareInfo.mShareTitle) && QCirclePluginUtil.isFeedOwner(this.f82809e.feed)) {
            z16 = true;
        } else {
            z16 = false;
        }
        shareConfig.isShowSave = z16;
        return shareConfig;
    }

    private void ca() {
        if (!com.tencent.biz.qqcircle.utils.bz.t()) {
            return;
        }
        QLog.d("QFSSharePart", 1, "[handlePartDestroyInPad] ");
        X9();
        sa();
        HostShareUtils hostShareUtils = this.f82808d;
        if (hostShareUtils != null && hostShareUtils.isShowing()) {
            this.f82808d.dismiss();
            QLog.d("QFSSharePart", 1, "[handlePartDestroyInPad] dismiss");
        }
    }

    private void da(QFSSetCoverFeedEvent qFSSetCoverFeedEvent) {
        QCircleFeedCoverBean qCircleFeedCoverBean;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str = null;
        if (qFSSetCoverFeedEvent != null) {
            qCircleFeedCoverBean = qFSSetCoverFeedEvent.getCoverBean();
        } else {
            qCircleFeedCoverBean = null;
        }
        if (qCircleFeedCoverBean == null) {
            QLog.e(getTAG(), 1, "[handleQFSSetQQProfileCoverEvent] cover bean is null");
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e(getTAG(), 1, "[handleQFSSetQQProfileCoverEvent] activity is null");
            return;
        }
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (str != null && TextUtils.equals(str, qCircleFeedCoverBean.qcircleFeedId)) {
            QLog.d(getTAG(), 1, "[handleQFSSetQQProfileCoverEvent] feedId:" + qCircleFeedCoverBean.qcircleFeedId + ", launchFrom:" + qCircleFeedCoverBean.launchFrom);
            if (!TextUtils.equals(qCircleFeedCoverBean.launchFrom, "sharepanel")) {
                QLog.e(getTAG(), 1, "[handleQFSSetQQProfileCoverEvent] not from share panel");
                return;
            } else {
                QUIBottomToast.g(activity, 2, com.tencent.biz.qqcircle.utils.h.a(R.string.f19044424), com.tencent.biz.qqcircle.utils.h.a(R.string.f1908743_), new b(activity), QCirclePluginUtil.getBottomMarginHeight(activity) - com.tencent.biz.qqcircle.utils.cx.d(activity)).n();
                return;
            }
        }
        QLog.e(getTAG(), 1, "[handleQFSSetQQProfileCoverEvent] feedId not equal");
    }

    private void ea(QFSShareSuccessEvent qFSShareSuccessEvent) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qFSShareSuccessEvent == null) {
            QLog.e(getTAG(), 1, "[handleQFSShareSuccessEvent] event is null");
            return;
        }
        if (this.M) {
            return;
        }
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        } else {
            str = null;
        }
        if (str != null && TextUtils.equals(str, qFSShareSuccessEvent.getFeedId())) {
            if (getPageId() != qFSShareSuccessEvent.getPageId()) {
                QLog.e(getTAG(), 1, "[handleQFSShareSuccessEvent] pageId not equal");
                return;
            }
            Map<String, Long> msgIdMap = qFSShareSuccessEvent.getMsgIdMap();
            if (msgIdMap != null && !msgIdMap.isEmpty()) {
                QLog.d(getTAG(), 1, "[handleQFSShareSuccessEvent] feedId:" + qFSShareSuccessEvent.getFeedId() + ", msgIdMap:" + msgIdMap);
                this.Q.putAll(qFSShareSuccessEvent.getMsgIdMap());
                wa();
                return;
            }
            QLog.e(getTAG(), 1, "[handleQFSShareSuccessEvent] msgIdMap is empty");
            return;
        }
        QLog.e(getTAG(), 1, "[handleQFSShareSuccessEvent] feedId not equal");
    }

    private void ga() {
        QLog.d(getTAG(), 1, "[handleBroadcastMessage] handleShareInfo");
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = qCircleShareInfo.extraTypeInfo;
        if (qCircleExtraTypeInfo != null) {
            qCircleExtraTypeInfo.mFeed = qCircleShareInfo.feed;
        }
        QCircleReportBean qCircleReportBean = qCircleShareInfo.mReportBean;
        if (qCircleReportBean != null) {
            this.mReportBean = qCircleReportBean;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qCircleShareInfo.feed;
        this.f82810f = feedCloudMeta$StFeed;
        if (feedCloudMeta$StFeed != null) {
            this.f82811h = feedCloudMeta$StFeed.f398449id.get();
            if (this.f82810f.busiReport.has()) {
                this.f82812i = this.f82810f.busiReport.get().toByteArray();
            }
        }
    }

    private String getDtPageId() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null && !TextUtils.isEmpty(qCircleReportBean.getDtPageId())) {
            return this.mReportBean.getDtPageId();
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.f82813m;
        if (aVar != null && aVar.getReportBean() != null && !TextUtils.isEmpty(this.f82813m.getReportBean().getDtPageId())) {
            return this.f82813m.getReportBean().getDtPageId();
        }
        if (getHostFragment() instanceof QFSLayerPageFragment) {
            return QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE;
        }
        return "";
    }

    private FeedCloudMeta$StFeed getFeedData() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null) {
            return feedCloudMeta$StFeed;
        }
        return new FeedCloudMeta$StFeed();
    }

    private wb0.a ha() {
        return new wb0.a() { // from class: com.tencent.biz.qqcircle.bizparts.QFSSharePart.8
            @Override // wb0.a
            public void a(boolean z16) {
                QFSSharePart.this.ra(z16);
            }

            @Override // wb0.a
            public void b(boolean z16) {
                QFSSharePart.this.oa(z16);
                if (QFSSharePart.this.L != null) {
                    QFSSharePart.this.L.a(QFSSharePart.this.f82809e);
                }
            }

            @Override // wb0.a
            public void c() {
                QFSSharePart.this.sa();
            }

            @Override // wb0.a
            public void d() {
                QFSSharePart.this.ta();
            }

            @Override // wb0.a
            public void e(final QCircleShareInfo qCircleShareInfo) {
                a(false);
                if (QFSSharePart.this.D == null) {
                    QFSSharePart.this.D = new Handler(Looper.getMainLooper());
                }
                QFSSharePart.this.D.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSSharePart.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSSharePart.this.handleBroadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
                    }
                }, 200L);
            }

            @Override // wb0.a
            public void f() {
                if (QFSSharePart.this.getPartManager() != null) {
                    QFSSharePart.this.broadcastMessage("rich_media_download_show", null);
                } else if (QFSSharePart.this.G != null) {
                    QFSSharePart.this.G.handleBroadcastMessage("rich_media_download_show", null);
                }
            }

            @Override // wb0.a
            public void g(Consumer<String> consumer) {
                if (QFSSharePart.this.L != null) {
                    QFSSharePart.this.L.d(consumer);
                }
            }

            @Override // wb0.a
            public void report() {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleTransActivityLifeEvent(0));
            }

            @Override // wb0.a
            public void saveQrcode() {
                if (QFSSharePart.this.L != null) {
                    QFSSharePart.this.L.c();
                } else {
                    QLog.d("QFSSharePart", 1, "[saveQrcode] mQrcodeView is null, save qrcode is fail");
                    QCircleToast.h(R.string.f1899140o, 0);
                }
            }
        };
    }

    private QCircleRichMediaDownLoadManager.e ia() {
        return new g();
    }

    private boolean ja() {
        boolean z16;
        Context context = this.F;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QFSSharePart", 1, "isActivityAlive | " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void la() {
        uq3.k.a().j("qfs_key_has_show_share_contacts_guide_tips", true);
    }

    private void ma() {
        String str;
        wb0.a aVar;
        if (this.f82809e == null) {
            QLog.e("QFSSharePart", 1, "[multiShare] shareInfo is null.");
            return;
        }
        if (fb0.a.b("QFSSharePartmultiShare", 800L)) {
            return;
        }
        QLog.d("QFSSharePart", 1, "[multiShare] start show.");
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (qCircleShareInfo.mReportBean == null) {
            qCircleShareInfo.mReportBean = new QCircleReportBean();
        }
        this.f82809e.mReportBean.setDtPageId(getDtPageId());
        yb0.j jVar = new yb0.j(ba(), this.f82809e);
        jVar.J(this.f82809e.mSelectedUserList);
        jVar.H(new c());
        jVar.G(new d());
        jVar.I(new e(jVar));
        jVar.j();
        ShareActionSheetClickListener Y9 = Y9();
        jVar.K(Y9);
        boolean r16 = yb0.r.h().r(this.f82809e);
        yb0.r h16 = yb0.r.h();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f82809e.feed;
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        } else {
            str = "";
        }
        boolean o16 = h16.o(str);
        QLog.d("QFSSharePart", 1, "[preloadShareData] needRequest: " + r16 + ", hasShowedSetQQProfileDialog:" + o16);
        if ((r16 || o16) && this.f82809e.feed != null) {
            yb0.r.h().b(com.tencent.biz.qqcircle.utils.af.a(this.f82809e.feed.f398449id.get()), new f(jVar));
            if (Y9 instanceof vb0.a) {
                aVar = ((vb0.a) Y9).n();
            } else {
                aVar = null;
            }
            yb0.r.h().t(this.f82809e, aVar, null);
        } else {
            jVar.F(QCircleBaseShareOperation.s((Activity) getContext(), this.f82809e.feed));
            if (W9()) {
                jVar.k(getContext(), this.f82810f);
            }
        }
        Context hostContext = ASEngineUtils.getHostContext(getContext());
        if (hostContext == null) {
            QLog.d("QFSSharePart", 1, "[multiShare] hostContext is null.");
            return;
        }
        jVar.L(hostContext);
        QCirclePluginUtil.setIsSharePanelOnShow(true);
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(1, this.f82811h, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z16) {
        QCircleShareInfo qCircleShareInfo = this.f82809e;
        if (z16 == qCircleShareInfo.isShowUnCollect) {
            return;
        }
        qCircleShareInfo.isShowCollect = !z16;
        qCircleShareInfo.isShowUnCollect = z16;
        HostShareUtils hostShareUtils = this.f82808d;
        if (hostShareUtils != null) {
            hostShareUtils.setActionSheetItems(ba());
        }
        yb0.j jVar = this.K;
        if (jVar != null) {
            jVar.M(ba());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa() {
        if (this.N != null) {
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.removeMsgListener(this.N);
            }
            this.N = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        if (!this.Q.isEmpty() && !this.R.isEmpty()) {
            QLog.d(getTAG(), 1, "[requestSetShareMessage");
            RFWThreadManager.getInstance().execOnSubThread(new AnonymousClass11());
        } else {
            QLog.e(getTAG(), 1, "[requestSetShareMessage] map is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(boolean z16) {
        QLog.d("QFSSharePart", 1, "[safeCloseSheet] isKeepDim: " + z16);
        if (!z16) {
            X9();
        }
        HostShareUtils hostShareUtils = this.f82808d;
        if (hostShareUtils != null && hostShareUtils.isShowing()) {
            this.f82808d.dismiss();
            QLog.d("QFSSharePart", 1, "[safeCloseSheet] dismiss");
        }
        HostShareUtils hostShareUtils2 = this.f82808d;
        if (hostShareUtils2 != null) {
            hostShareUtils2.setOnShowListener(null);
            this.f82808d.setCancelListener(null);
            this.f82808d.setOnDismissListener(null);
        }
        if (this.D == null) {
            this.D = new Handler(Looper.getMainLooper());
        }
        this.D.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSSharePart.2
            @Override // java.lang.Runnable
            public void run() {
                QFSSharePart.this.f82808d = null;
                QFSSharePart.this.C = false;
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(1, QFSSharePart.this.f82811h, false));
                QLog.d("QFSSharePart", 1, "delayCloseHostEnvironment");
            }
        }, 200L);
        QCirclePluginUtil.setIsSharePanelOnShow(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa() {
        if (this.J != null && ja()) {
            this.J.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta() {
        if (this.J == null && ja()) {
            this.J = LoadingUtil.showLoadingDialog(this.F, "\u52a0\u8f7d\u4e2d", true);
        }
        Dialog dialog = this.J;
        if (dialog != null && !dialog.isShowing()) {
            this.J.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(DialogInterface dialogInterface) {
        QCircleShareInfo qCircleShareInfo;
        Window window;
        View childAt;
        if (uq3.k.a().c("qfs_key_has_show_share_contacts_guide_tips", false) || (qCircleShareInfo = this.f82809e) == null || !qCircleShareInfo.isEnableShareToMutual || !(dialogInterface instanceof Dialog) || (window = ((Dialog) dialogInterface).getWindow()) == null) {
            return;
        }
        View findViewById = window.findViewById(R.id.zip);
        if (!(findViewById instanceof RecyclerView) || (childAt = ((RecyclerView) findViewById).getChildAt(0)) == null) {
            return;
        }
        mc0.a.d(getContext(), com.tencent.biz.qqcircle.utils.h.a(R.string.f1906442n)).setPosition(0).setAlignment(1).setAnchor(childAt).addStatusCallback(new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.biz.qqcircle.bizparts.du
            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public /* synthetic */ void onClick(View view) {
                a04.d.a(this, view);
            }

            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public /* synthetic */ void onDismiss() {
                a04.d.b(this);
            }

            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public final void onShow() {
                QFSSharePart.la();
            }
        });
    }

    private void va() {
        yb0.r.h().B(true);
        if (this.f82809e == null) {
            QLog.e("QFSSharePart", 1, "[silentShare] shareInfo is null. ");
            return;
        }
        if (fb0.a.b("QFSSharePart_silentShare", 800L)) {
            return;
        }
        QLog.d("QFSSharePart", 1, "[silentShare]");
        if (this.f82809e.silentShareType == -1) {
            QLog.d("QFSSharePart", 1, "fastShare error. didn't set silentShareType");
        } else {
            ((vb0.a) Y9()).w(this.f82809e);
        }
    }

    private void wa() {
        Handler mainHandler;
        if (this.P.compareAndSet(false, true) && (mainHandler = getMainHandler()) != null) {
            mainHandler.removeCallbacks(this.S);
            mainHandler.postDelayed(this.S, 5000L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Activity getActivity() {
        Activity activity = this.E;
        if (activity == null) {
            return super.getActivity();
        }
        return activity;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Context getContext() {
        return getActivity();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSShareSuccessEvent.class);
        arrayList.add(QFSSetCoverFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSharePart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.b
    public int getPageId() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getPageId("QFSSharePart", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.f82813m;
        if (aVar != null) {
            return QCircleReportBean.getPageId("QFSSharePart", aVar.getReportBean());
        }
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.b
    protected int getParentPageId() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getParentPageId("QFSSharePart", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.f82813m;
        if (aVar != null) {
            return QCircleReportBean.getParentPageId("QFSSharePart", aVar.getReportBean());
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (!(obj instanceof QCircleShareInfo)) {
            return;
        }
        this.f82809e = (QCircleShareInfo) obj;
        this.F = ASEngineUtils.getHostContext(getContext());
        ga();
        Z9();
        if (TextUtils.equals(str, "share_action_show_share_sheet")) {
            ma();
        } else if (TextUtils.equals(str, "share_action_silent_share")) {
            va();
        }
        V9();
    }

    @RFWTestDataSource(key = "share_action_sheet", objName = "mShareManager.mShareInstance.shareFragment.rootView")
    public void na(yb0.j jVar) {
        this.K = jVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        QLog.d("QFSSharePart", 4, "onActivityResult:" + i3 + "," + i16);
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.I = view;
        super.onInitView(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.M = uq3.o.b();
        QLog.d(getTAG(), 1, "[onPartCreate] disableRequestSetShareMessage:" + this.M);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.D != null) {
            this.D = null;
        }
        ca();
        this.F = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.Q.clear();
        this.R.clear();
        pa();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.C = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSShareSuccessEvent) {
            ea((QFSShareSuccessEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSetCoverFeedEvent) {
            da((QFSSetCoverFeedEvent) simpleBaseEvent);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        QLog.d(getTAG(), 1, "Share Dialog onShow");
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.f82813m = aVar;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.b, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean("QFSSharePart", qCircleReportBean).m466clone();
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.f82813m;
        if (aVar != null) {
            return QCircleReportBean.getReportBean("QFSSharePart", aVar.getReportBean()).m466clone();
        }
        return new QCircleReportBean();
    }
}
