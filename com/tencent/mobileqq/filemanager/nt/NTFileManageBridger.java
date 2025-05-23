package com.tencent.mobileqq.filemanager.nt;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.aio.input.filetoobig.FileTooBigIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFileDataReporter;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ITempChatSigListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.UploadStatusParams;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IRichMediaService;
import com.tencent.qqnt.msg.migration.DataLineNTMsgMigrationUtil;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class NTFileManageBridger {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f208700a;

    /* renamed from: c, reason: collision with root package name */
    private IKernelMsgListener f208702c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f208703d;

    /* renamed from: e, reason: collision with root package name */
    private NTC2CFileTransferMgr f208704e;

    /* renamed from: f, reason: collision with root package name */
    private cc f208705f;

    /* renamed from: b, reason: collision with root package name */
    private boolean f208701b = false;

    /* renamed from: g, reason: collision with root package name */
    private Handler f208706g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements IKernelMsgListener {
        a() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(MsgRecord msgRecord) {
            if (NTFileUtils.p(msgRecord.getChatType()) || NTFileUtils.q(msgRecord.getChatType())) {
                NTFileManageBridger.this.f208704e.Q(msgRecord);
            }
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
        public void onFileMsgCome(ArrayList<MsgRecord> arrayList) {
            Iterator<MsgRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord next = it.next();
                if (NTFileUtils.p(next.getChatType())) {
                    NTFileManageBridger.this.f208704e.O(next);
                }
            }
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
        public void onRecvMsg(ArrayList<MsgRecord> arrayList) {
            Iterator<MsgRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord next = it.next();
                if (NTFileUtils.p(next.getChatType()) || NTFileUtils.q(next.getChatType())) {
                    NTFileManageBridger.this.f208704e.Q(next);
                }
            }
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
        public void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            if (fileTransNotifyInfo.getFileDownType() == 2) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onRichMediaDownloadComplete KRMDOWNTYPETHUMB FileTransNotifyInfo " + fileTransNotifyInfo);
                NTFileManageBridger.this.f208704e.r0(fileTransNotifyInfo);
                NTFileManageBridger.this.f208705f.o0(fileTransNotifyInfo);
                return;
            }
            if (fileTransNotifyInfo.getFileDownType() == 1) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onRichMediaDownloadComplete KRMDOWNTYPEORIG FileTransNotifyInfo " + fileTransNotifyInfo);
                NTFileManageBridger.this.f208704e.m0(fileTransNotifyInfo);
                NTFileManageBridger.this.f208705f.l0(fileTransNotifyInfo);
                ((IFileDataReporter) QRoute.api(IFileDataReporter.class)).reportMultiPicTransferResult(fileTransNotifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onRichMediaProgerssUpdate FileTransNotifyInfo " + fileTransNotifyInfo);
            NTFileManageBridger.this.f208704e.s0(fileTransNotifyInfo);
            NTFileManageBridger.this.f208705f.p0(fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onRichMediaUploadComplete FileTransNotifyInfo " + fileTransNotifyInfo);
            NTFileManageBridger.this.f208704e.u0(fileTransNotifyInfo);
            NTFileManageBridger.this.f208705f.r0(fileTransNotifyInfo);
            ((IFileDataReporter) QRoute.api(IFileDataReporter.class)).reportMultiPicTransferResult(fileTransNotifyInfo);
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null) {
                com.tencent.qqnt.aio.utils.c.f352293a.a(qBaseActivity, new FileTooBigIntent.FileUploadComplete(fileTransNotifyInfo));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements ITempChatSigListener {
        b() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ITempChatSigListener
        public byte[] getTempChatSig(int i3, String str) {
            return new byte[0];
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ITempChatSigListener
        public void onRecvTempChatSig(int i3, String str, byte[] bArr) {
            String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str);
            if (!TextUtils.isEmpty(uinFromUid)) {
                NTFileManageBridger.this.a0().getMsgCache().h(uinFromUid, bArr);
                NTFileManageBridger.this.a0().getMsgCache().h(str, new byte[]{0});
                return;
            }
            NTFileManageBridger.this.a0().getMsgCache().h(str, bArr);
            QLog.e("NTFileManageBridger", 1, "[onRecvTempChatSig] uin = null uid=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements QFileAppStorePromoteManager.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208709a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f208710b;

        c(FileManagerEntity fileManagerEntity, Runnable runnable) {
            this.f208709a = fileManagerEntity;
            this.f208710b = runnable;
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
        public void a(boolean z16, AppDetail appDetail) {
            FileManagerEntity fileManagerEntity = this.f208709a;
            fileManagerEntity.yybApkPackageName = appDetail.packageName;
            fileManagerEntity.yybApkName = appDetail.appName;
            fileManagerEntity.yybApkIconUrl = appDetail.iconUrl;
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
        public void b() {
            QLog.i("NTFileManageBridger", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + this.f208709a.yybApkName + "]");
            ah.b.a().execute(this.f208710b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements ah.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208712a;

        d(FileManagerEntity fileManagerEntity) {
            this.f208712a = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.d
        public void onResult(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f208712a.strThumbPath = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        void a();

        void b(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        void onResult(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        void a();

        void b(int i3, String str);
    }

    public NTFileManageBridger(QQAppInterface qQAppInterface) {
        this.f208700a = new WeakReference<>(qQAppInterface);
        this.f208704e = new NTC2CFileTransferMgr(qQAppInterface);
        this.f208705f = new cc(qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(final TroopFileTransferManager.Item item, final g gVar) {
        item.ProgressTotal = com.tencent.mobileqq.filemanager.util.ah.l0(item.LocalFile);
        this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.aa
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.z0(item, gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B0(int i3, TroopFileTransferManager.Item item, Runnable runnable, boolean z16) {
        if (i3 == 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            FilePicURLDrawlableHelper.m(item.LocalFile, options);
            int exifOrientation = BaseImageUtil.getExifOrientation(item.LocalFile);
            if (exifOrientation != 90 && exifOrientation != 270) {
                item.width = options.outWidth;
                item.height = options.outHeight;
            } else {
                item.width = options.outHeight;
                item.height = options.outWidth;
            }
        } else if (i3 == 2) {
            int[] videoFileRtAndTime = ShortVideoUtils.getVideoFileRtAndTime(item.LocalFile);
            item.width = videoFileRtAndTime[0];
            item.height = videoFileRtAndTime[1];
            item.duration = videoFileRtAndTime[2];
        }
        ah.b.a().execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H() {
        if (a0() != null && a0().getAccount() != null) {
            if (this.f208702c == null) {
                IKernelService iKernelService = (IKernelService) a0().getRuntimeService(IKernelService.class, "all");
                if (iKernelService != null && iKernelService.getMsgService() != null) {
                    this.f208702c = new a();
                    b bVar = new b();
                    com.tencent.qqnt.kernel.api.w msgService = iKernelService.getMsgService();
                    if (msgService != null) {
                        msgService.addMsgListener(this.f208702c);
                        msgService.addKernelTempChatSigListener(bVar);
                    }
                    QLog.i("NTFileManageBridger", 1, "addMsgListener suc!!");
                    return true;
                }
            } else {
                QLog.i("NTFileManageBridger", 1, "already addMsgListener");
            }
            return false;
        }
        QLog.e("NTFileManageBridger", 1, "addMsgListener. but app/account is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface a0() {
        QQAppInterface qQAppInterface = this.f208700a.get();
        if (qQAppInterface == null) {
            QQAppInterface qQAppInterface2 = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            this.f208700a = new WeakReference<>(qQAppInterface2);
            return qQAppInterface2;
        }
        return qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(List list) {
        if (this.f208700a != null && a0().getFileManagerDataCenter() != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a0().getFileManagerDataCenter().t((FileManagerEntity) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(final List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FileManagerEntity fileManagerEntity = (FileManagerEntity) it.next();
            com.tencent.mobileqq.filemanager.util.ah.u(fileManagerEntity);
            FilePicURLDrawlableHelper.e(fileManagerEntity);
            a0().getFileManagerProxy().x(fileManagerEntity);
        }
        this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ak
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.b0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(FileManagerEntity fileManagerEntity) {
        if (a0() != null) {
            a0().getFileManagerEngine().i0(fileManagerEntity.nSessionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(NTFileUtils.b bVar, MsgRecord msgRecord, long j3) {
        final FileManagerEntity fileManagerEntity;
        if (a0() != null) {
            fileManagerEntity = NTFileUtils.i(a0(), bVar, msgRecord, j3);
        } else {
            fileManagerEntity = null;
        }
        if (fileManagerEntity == null) {
            QLog.e("NTFileManageBridger", 1, "cancelDownloadAioNTFileMsg err. getFileEntityOfNTMsg fail:entity/app = null");
        } else {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.z
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.d0(fileManagerEntity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(FileManagerEntity fileManagerEntity) {
        this.f208704e.x(fileManagerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(TroopFileTransferManager.Item item, Bundle bundle, int i3) {
        this.f208705f.z(item, bundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(FileManagerEntity fileManagerEntity) {
        this.f208704e.z(fileManagerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(TroopFileTransferManager.Item item) {
        this.f208705f.B(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Activity activity, FileManagerEntity fileManagerEntity, String str, f fVar) {
        this.f208704e.C(activity, fileManagerEntity, str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(NTFileUtils.b bVar, MsgRecord msgRecord, long j3, final Activity activity, final String str, final f fVar) {
        FileManagerEntity fileManagerEntity;
        if (a0() != null) {
            fileManagerEntity = NTFileUtils.i(a0(), bVar, msgRecord, j3);
        } else {
            QLog.e("NTFileManageBridger", 1, "downloadAioNTFileMsg err. app=null");
            fileManagerEntity = null;
        }
        final FileManagerEntity fileManagerEntity2 = fileManagerEntity;
        this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ah
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.j0(activity, fileManagerEntity2, str, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(FileManagerEntity fileManagerEntity) {
        this.f208704e.D(fileManagerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(FileManagerEntity fileManagerEntity, com.tencent.qqnt.aio.adapter.richmedia.provider.i iVar, boolean z16) {
        String str;
        int i3;
        if (fileManagerEntity != null && a0() != null) {
            if (1 == fileManagerEntity.cloudType) {
                if (fileManagerEntity.isZipInnerFile) {
                    str = a0().getFileManagerEngine().q(fileManagerEntity);
                } else {
                    if (z16) {
                        i3 = 7;
                    } else {
                        i3 = 3;
                    }
                    str = a0().getFileManagerEngine().m(fileManagerEntity, i3);
                }
            } else {
                str = null;
            }
            if (str != null && iVar != null) {
                iVar.a(0, str);
                return;
            }
            return;
        }
        if (iVar != null) {
            iVar.a(-1, "download err data=null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(NTFileUtils.b bVar, MsgRecord msgRecord, long j3, final com.tencent.qqnt.aio.adapter.richmedia.provider.i iVar, final boolean z16) {
        final FileManagerEntity fileManagerEntity;
        if (a0() != null) {
            fileManagerEntity = NTFileUtils.i(a0(), bVar, msgRecord, j3);
        } else {
            fileManagerEntity = null;
        }
        this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.af
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.m0(fileManagerEntity, iVar, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(TroopFileTransferManager.Item item, Bundle bundle, e eVar) {
        this.f208705f.E(item, bundle, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(String str, String str2, long j3, int i3) {
        if (a0() != null && a0().getFileManagerEngine() != null) {
            QLog.i("NTFileManageBridger", 1, "forwardShareLocalFileToTroop. strFilePath:" + str + " recvUin:" + str2 + "originUniSeq:" + j3 + " forwardID:" + i3);
            a0().getFileManagerEngine().J0(str, str2, j3, i3);
            return;
        }
        QLog.e("NTFileManageBridger", 1, "forwardShareLocalFileToTroop fail. strFilePath:" + str + " strUin:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0() {
        if (this.f208703d != null) {
            QLog.i("NTFileManageBridger", 1, "unregisterReceiver of kernel init complete");
            try {
                BaseApplication.getContext().unregisterReceiver(this.f208703d);
            } catch (Exception e16) {
                QLog.e("NTFileManageBridger", 1, "unregisterReceiver exp", e16);
            }
            this.f208703d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(FileManagerEntity fileManagerEntity, g gVar) {
        this.f208704e.y0(fileManagerEntity, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(TroopFileTransferManager.Item item, g gVar) {
        this.f208705f.v0(item, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(FileManagerEntity fileManagerEntity, g gVar) {
        if (a0() != null && a0().getFileManagerDataCenter() != null) {
            a0().getFileManagerDataCenter().t(fileManagerEntity);
        }
        this.f208704e.A0(fileManagerEntity, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(final FileManagerEntity fileManagerEntity, final g gVar) {
        com.tencent.mobileqq.filemanager.util.ah.u(fileManagerEntity);
        FilePicURLDrawlableHelper.e(fileManagerEntity);
        this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ai
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.v0(fileManagerEntity, gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(FileManagerEntity fileManagerEntity, Runnable runnable, String str, String str2) {
        fileManagerEntity.fileName = str;
        fileManagerEntity.strApkPackageName = str2;
        a0().getFileManagerEngine().J().g(str2, new c(fileManagerEntity, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y0(long j3, final TroopFileTransferManager.Item item, final int i3, final Runnable runnable, boolean z16) {
        TroopFileThumbnailMgr.j().g(j3, item, 640, new TroopFileThumbnailMgr.a() { // from class: com.tencent.mobileqq.filemanager.nt.ag
            @Override // com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.a
            public final void a(boolean z17) {
                NTFileManageBridger.B0(i3, item, runnable, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(TroopFileTransferManager.Item item, g gVar) {
        this.f208705f.w0(item, gVar);
    }

    public FileManagerEntity C0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, boolean z16, long j3, int i16) {
        return this.f208704e.k0(fileManagerEntity, str, str2, str3, i3, z16, j3, i16);
    }

    public void D0() {
        QLog.i("NTFileManageBridger", 1, "onAppDestroy...");
        if (this.f208702c != null && a0() != null) {
            QLog.i("NTFileManageBridger", 1, "removeMsgListener!!!");
            IKernelService iKernelService = (IKernelService) a0().getRuntimeService(IKernelService.class, "all");
            if (iKernelService != null && iKernelService.getMsgService() != null) {
                iKernelService.getMsgService().removeMsgListener(this.f208702c);
                this.f208702c = null;
            }
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.an
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.s0();
            }
        });
        this.f208704e.B();
        this.f208705f.C();
        this.f208701b = true;
    }

    public void E0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.1
            @Override // java.lang.Runnable
            public void run() {
                NTFileManageBridger.this.H();
            }
        }, 16, null, true);
    }

    public List<FileManagerEntity> F(List<String> list, String str, String str2, String str3, int i3, long j3, int i16, Bundle bundle, List<g> list2) {
        int i17;
        String str4;
        String str5 = "NTFileManageBridger";
        int i18 = 1;
        if (TextUtils.isEmpty(str3)) {
            QLog.e("NTFileManageBridger", 1, "sendLocalFileToC2C err!! peerUid is null. strFilePathList: " + list.size());
            return null;
        }
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        long g16 = NTFileUtils.g(l3);
        final ArrayList arrayList = new ArrayList(list.size());
        for (String str6 : list) {
            if (str6 != null && !str6.isEmpty()) {
                FileManagerEntity fileManagerEntity = new FileManagerEntity();
                String str7 = str5;
                long g17 = NTFileUtils.g(l3);
                com.tencent.mobileqq.filemanager.util.j.f209387a.e(fileManagerEntity, g17, l3);
                fileManagerEntity.uniseq = g17;
                fileManagerEntity.ntMsgId = g16;
                fileManagerEntity.peerUin = str2;
                fileManagerEntity.peerUid = str3;
                fileManagerEntity.peerType = i3;
                fileManagerEntity.selfUin = a0().getAccount();
                fileManagerEntity.isReaded = false;
                fileManagerEntity.status = 2;
                fileManagerEntity.nOpType = 0;
                fileManagerEntity.setCloudType(3);
                long j16 = g16;
                fileManagerEntity.fileSize = com.tencent.mobileqq.filemanager.util.ah.l0(str6);
                fileManagerEntity.isReaded = true;
                fileManagerEntity.peerUin = str2;
                fileManagerEntity.peerNick = com.tencent.mobileqq.filemanager.util.ah.z0(a0(), str2, null, i3);
                fileManagerEntity.setFilePath(str6);
                fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
                fileManagerEntity.fileName = com.tencent.mobileqq.filemanager.util.ah.h0(str6);
                fileManagerEntity.nFileType = com.tencent.mobileqq.filemanager.util.ah.o0(str6);
                fileManagerEntity.setCloudType(3);
                fileManagerEntity.bSend = true;
                fileManagerEntity.msgSeq = com.tencent.mobileqq.filemanager.util.ah.P();
                fileManagerEntity.msgUid = com.tencent.mobileqq.filemanager.util.ah.Q();
                com.tencent.mobileqq.filemanager.util.ah.v(str6, 150, 150, new d(fileManagerEntity));
                fileManagerEntity.isPhotoToMyComputer = true;
                com.tencent.mobileqq.filemanager.util.ah.O1(a0(), str, str2, fileManagerEntity);
                a0().getAccount();
                if (i3 != 1004 && i3 != 1000 && i3 == 1006) {
                    fileManagerEntity.tmpSessionFromPhone = str;
                    fileManagerEntity.tmpSessionToPhone = str2;
                }
                com.tencent.mobileqq.activity.aio.forward.b.d().e(g17, j3, i16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sendLocalFileToC2C strFilePath:");
                sb5.append(str6);
                sb5.append(" peerUin:");
                sb5.append(str2);
                sb5.append(" peerUid:");
                sb5.append(str3);
                sb5.append(" peerType:");
                sb5.append(i3);
                sb5.append(" srcUin:");
                sb5.append(str);
                sb5.append(" ntMsgId:");
                g16 = j16;
                sb5.append(g16);
                sb5.append(" ntElementId:");
                sb5.append(g17);
                sb5.append(" nSessionId:");
                sb5.append(fileManagerEntity.nSessionId);
                sb5.append(" forwardID:");
                sb5.append(i16);
                String sb6 = sb5.toString();
                str4 = str7;
                i17 = 1;
                QLog.i(str4, 1, sb6);
                arrayList.add(fileManagerEntity);
            } else {
                i17 = i18;
                str4 = str5;
                QLog.e(str4, i17, "sendLocalFileToC2C strFilePath err!!");
            }
            str5 = str4;
            i18 = i17;
        }
        this.f208704e.v(arrayList, list2);
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ad
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.c0(arrayList);
            }
        });
        return arrayList;
    }

    public void F0(Activity activity, MsgRecord msgRecord, f fVar) {
        if (msgRecord == null) {
            QLog.e("NTFileManageBridger", 1, "reSendAioNTFile err. msgRecord=null");
            if (fVar != null) {
                fVar.onResult(-2, "");
                return;
            }
            return;
        }
        QLog.i("NTFileManageBridger", 1, "reSendAioNTFile. ntMsgId:" + msgRecord.getMsgId() + "peerUid:" + msgRecord.getPeerUid() + " peerType:" + msgRecord.getChatType());
        if (NTFileUtils.p(msgRecord.getChatType())) {
            this.f208704e.x0(activity, msgRecord, fVar);
            return;
        }
        if (msgRecord.getChatType() == 2) {
            this.f208705f.u0(activity, msgRecord, fVar);
            return;
        }
        QLog.e("NTFileManageBridger", 1, "reSendAioNTFile. un support chat type");
        if (fVar != null) {
            fVar.onResult(-2, "");
        }
    }

    public final void G(long j3, com.tencent.mobileqq.troop.data.t tVar, long j16, long j17, String str, String str2, String str3, boolean z16) {
        this.f208705f.y(j3, tVar, j16, j17, str, str2, str3, z16);
    }

    public void G0(final FileManagerEntity fileManagerEntity, final g gVar) {
        if (fileManagerEntity == null) {
            QLog.i("NTFileManageBridger", 1, "reSendFileToC2C entry = null:");
            if (gVar != null) {
                gVar.b(-1, "entry=null");
                return;
            }
            return;
        }
        QLog.i("NTFileManageBridger", 1, "reSendFileToC2C fileName:" + fileManagerEntity.fileName + " filePath:" + fileManagerEntity.getFilePath() + " sessionId:" + fileManagerEntity.nSessionId);
        if (fileManagerEntity.status != 2) {
            fileManagerEntity.status = 2;
            a0().getFileManagerDataCenter().f0(fileManagerEntity);
        }
        a0().getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.aq
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.t0(fileManagerEntity, gVar);
                }
            });
        } else {
            this.f208704e.y0(fileManagerEntity, gVar);
        }
    }

    public void H0(long j3, final TroopFileTransferManager.Item item, final g gVar) {
        if (item == null) {
            QLog.i("NTFileManageBridger", 1, "reSendFileToTroop item err!!");
            if (gVar != null) {
                gVar.b(-1, "item err!!");
                return;
            }
            return;
        }
        QLog.i("NTFileManageBridger", 1, "reSendFileToTroop fileName:" + item.FileName + " strFilePath:" + item.LocalFile + " troopuin:" + item.troopuin);
        long j16 = item.troopuin;
        if (item.Status != 1) {
            com.tencent.mobileqq.troop.filemanager.b.e(j16, item, 1);
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ac
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.u0(item, gVar);
                }
            });
        } else {
            this.f208705f.v0(item, gVar);
        }
    }

    public void I(final NTFileUtils.b bVar, final MsgRecord msgRecord, final long j3) {
        String str;
        long j16;
        if (msgRecord != null && j3 != 0) {
            String peerUid = msgRecord.getPeerUid();
            int chatType = msgRecord.getChatType();
            if (bVar != null) {
                peerUid = bVar.f208720b;
                chatType = bVar.f208722d;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cancelDownloadAioNTFileMsg. rooMsgInfo:");
            if (bVar != null) {
                str = bVar.toString();
            } else {
                str = "";
            }
            sb5.append(str);
            sb5.append(" ntMsgId:");
            sb5.append(msgRecord.getMsgId());
            sb5.append(" elemId:");
            sb5.append(j3);
            sb5.append("msgPeerUid:");
            sb5.append(msgRecord.getPeerUid());
            sb5.append(" msgPeerType:");
            sb5.append(msgRecord.getChatType());
            QLog.i("NTFileManageBridger", 1, sb5.toString());
            if (NTFileUtils.p(chatType)) {
                ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTFileManageBridger.this.e0(bVar, msgRecord, j3);
                    }
                });
                return;
            }
            if (chatType == 2) {
                try {
                    j16 = Long.valueOf(peerUid).longValue();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    j16 = 0;
                }
                if (j16 == 0) {
                    QLog.e("NTFileManageBridger", 1, "cancelDownloadAioNTFileMsg err. troopCode = 0\uff0c fileElemId=" + j3);
                    return;
                }
                FileElement l3 = NTFileUtils.l(msgRecord, j3);
                if (l3 == null) {
                    QLog.e("NTFileManageBridger", 1, "cancelDownloadAioNTFileMsg err. fileElement = null\uff0c fileElemId=" + j3);
                    return;
                }
                com.tencent.mobileqq.troop.data.n A = TroopFileManager.F(a0(), j16).A(l3.getFileUuid());
                if (A == null) {
                    QLog.e("NTFileManageBridger", 1, "cancelDownloadAioNTFileMsg err. info = null\uff0c fileElement.getFileUuid=" + l3.getFileUuid());
                    return;
                }
                TroopFileTransferManager.O(a0(), j16).C0(A.f294915a);
                return;
            }
            QLog.e("NTFileManageBridger", 1, "un support chat type");
            return;
        }
        QLog.e("NTFileManageBridger", 1, "cancelDownloadAioNTFileMsg err. msgRecord/fileElemId=null/0");
    }

    public FileManagerEntity I0(String str, String str2, String str3, String str4, int i3, long j3, int i16, Bundle bundle, final g gVar) {
        if (str != null && !str.isEmpty()) {
            if (TextUtils.isEmpty(str4)) {
                QLog.e("NTFileManageBridger", 1, "sendLocalFileToC2C err!! peerUid is null. strFilePath:" + str);
                return null;
            }
            int l3 = com.tencent.nt.adapter.session.c.l(i3);
            long g16 = NTFileUtils.g(l3);
            long g17 = NTFileUtils.g(l3);
            final FileManagerEntity fileManagerEntity = new FileManagerEntity();
            com.tencent.mobileqq.filemanager.util.j.f209387a.e(fileManagerEntity, g17, l3);
            fileManagerEntity.uniseq = g17;
            fileManagerEntity.ntMsgId = g16;
            fileManagerEntity.peerUin = str3;
            fileManagerEntity.peerUid = str4;
            fileManagerEntity.peerType = i3;
            fileManagerEntity.selfUin = a0().getAccount();
            fileManagerEntity.isReaded = false;
            fileManagerEntity.status = 2;
            fileManagerEntity.nOpType = 0;
            fileManagerEntity.setCloudType(3);
            fileManagerEntity.fileSize = com.tencent.mobileqq.filemanager.util.ah.l0(str);
            fileManagerEntity.isReaded = true;
            fileManagerEntity.peerUin = str3;
            fileManagerEntity.peerNick = com.tencent.mobileqq.filemanager.util.ah.z0(a0(), str3, null, i3);
            fileManagerEntity.setFilePath(str);
            fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
            fileManagerEntity.fileName = com.tencent.mobileqq.filemanager.util.ah.h0(str);
            fileManagerEntity.nFileType = com.tencent.mobileqq.filemanager.util.ah.o0(str);
            fileManagerEntity.setCloudType(3);
            fileManagerEntity.bSend = true;
            fileManagerEntity.msgSeq = com.tencent.mobileqq.filemanager.util.ah.P();
            fileManagerEntity.msgUid = com.tencent.mobileqq.filemanager.util.ah.Q();
            fileManagerEntity.strThumbPath = com.tencent.mobileqq.filemanager.util.ah.v(str, 150, 150, null);
            if (bundle != null && bundle.getBoolean("forward_photo_to_myComputer")) {
                fileManagerEntity.isPhotoToMyComputer = true;
            }
            com.tencent.mobileqq.filemanager.util.ah.O1(a0(), str2, str3, fileManagerEntity);
            a0().getAccount();
            if (i3 != 1004 && i3 != 1000 && i3 == 1006) {
                fileManagerEntity.tmpSessionFromPhone = str2;
                fileManagerEntity.tmpSessionToPhone = str3;
            }
            com.tencent.mobileqq.activity.aio.forward.b.d().e(g17, j3, i16);
            QLog.i("NTFileManageBridger", 1, "sendLocalFileToC2C strFilePath:" + str + " peerUin:" + str3 + " peerUid:" + str4 + " peerType:" + i3 + " srcUin:" + str2 + " ntMsgId:" + g16 + " ntElementId:" + g17 + " nSessionId:" + fileManagerEntity.nSessionId + " forwardID:" + i16);
            a0().getFileManagerProxy().x(fileManagerEntity);
            final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ar
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.w0(fileManagerEntity, gVar);
                }
            };
            if (fileManagerEntity.nFileType == 5) {
                if (!((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(fileManagerEntity.getFilePath(), new com.tencent.mobileqq.filemanager.util.s() { // from class: com.tencent.mobileqq.filemanager.nt.as
                    @Override // com.tencent.mobileqq.filemanager.util.s
                    public final void a(String str5, String str6) {
                        NTFileManageBridger.this.x0(fileManagerEntity, runnable, str5, str6);
                    }
                })) {
                    ah.b.a().execute(runnable);
                }
            } else {
                ah.b.a().execute(runnable);
            }
            return fileManagerEntity;
        }
        QLog.e("NTFileManageBridger", 1, "sendLocalFileToC2C strFilePath err!!");
        return null;
    }

    public void J(final FileManagerEntity fileManagerEntity) {
        QLog.i("NTFileManageBridger", 1, "cancelDownloadC2CFile fileName:" + fileManagerEntity.fileName + " sid:" + fileManagerEntity.nSessionId);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.am
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.f0(fileManagerEntity);
                }
            });
        } else {
            this.f208704e.x(fileManagerEntity);
        }
    }

    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void p0(String str, String str2, String str3, String str4, int i3, boolean z16, long j3, int i16) {
        QLog.i("NTFileManageBridger", 1, "sendLocalFileToC2CByFMEng. strFilePath:" + str + " recvUin:" + str3 + "recvUid:" + str4 + " peerType:" + i3);
        String checkAndGetUid = FileManagerUtil.checkAndGetUid(str4, str3, "sendLocalFileToC2CByFMEng");
        if (TextUtils.isEmpty(checkAndGetUid)) {
            checkAndGetUid = DataLineNTMsgMigrationUtil.e(str3);
        }
        String str5 = checkAndGetUid;
        if (!TextUtils.isEmpty(str5)) {
            a0().getFileManagerEngine().F0(str, str2, str3, str5, i3, z16);
            return;
        }
        QLog.e("NTFileManageBridger", 1, "sendLocalFileToC2CByFMEng uid error. strFilePath:" + str);
    }

    public void K(final TroopFileTransferManager.Item item, final Bundle bundle, final int i3) {
        QLog.i("NTFileManageBridger", 1, "cancelDownloadTroopFile fileName:" + item.FileName + " id:" + item.idStr());
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ab
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.g0(item, bundle, i3);
                }
            });
        } else {
            this.f208705f.z(item, bundle, i3);
        }
    }

    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void q0(String str, String str2, String str3, String str4, int i3, boolean z16, long j3, int i16, Bundle bundle) {
        QLog.i("NTFileManageBridger", 1, "sendLocalFileToMyComputerByFMEng. strFilePath:" + str + " recvUin:" + str3 + "recvUid:" + str4 + " peerType:" + i3);
        if (!TextUtils.isEmpty(FileManagerUtil.checkAndGetUid(str4, str3, "sendLocalFileToC2CByFMEng"))) {
            a0().getFileManagerEngine().H0(str, str2, str3, str4, i3, z16, 0L, 0, bundle);
            return;
        }
        QLog.e("NTFileManageBridger", 1, "sendLocalFileToMyComputerByFMEng uid error. strFilePath:" + str);
    }

    public void L(MsgRecord msgRecord) {
        if (msgRecord == null) {
            QLog.e("NTFileManageBridger", 1, "cancelSendAioNTFile err. msgRecord=null");
            return;
        }
        QLog.i("NTFileManageBridger", 1, "cancelSendAioNTFile. ntMsgId:" + msgRecord.getMsgId() + "peerUid:" + msgRecord.getPeerUid() + " peerType:" + msgRecord.getChatType());
        if (NTFileUtils.p(msgRecord.getChatType())) {
            this.f208704e.y(msgRecord);
        } else if (msgRecord.getChatType() == 2) {
            this.f208705f.A(msgRecord);
        } else {
            QLog.e("NTFileManageBridger", 1, "un support chat type");
        }
    }

    public void L0(final long j3, final TroopFileTransferManager.Item item, Bundle bundle, final g gVar) {
        if (item == null) {
            QLog.i("NTFileManageBridger", 1, "sendLocalFileToTroop item err!!");
            if (gVar != null) {
                gVar.b(-1, "item err!!");
                return;
            }
            return;
        }
        if (bundle != null && bundle.getBoolean("resend")) {
            H0(j3, item, gVar);
            return;
        }
        QLog.i("NTFileManageBridger", 1, "sendLocalFileToTroop strFilePath:" + item.LocalFile + " troopuin:" + item.troopuin);
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.u
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.A0(item, gVar);
            }
        };
        long j16 = item.troopuin;
        if (item.Status != 1) {
            com.tencent.mobileqq.troop.filemanager.b.e(j16, item, 1);
        }
        final int o06 = com.tencent.mobileqq.filemanager.util.ah.o0(item.LocalFile);
        if (o06 != 0 && o06 != 2) {
            ah.b.a().execute(runnable);
        } else {
            TroopFileThumbnailMgr.j().g(j3, item, 128, new TroopFileThumbnailMgr.a() { // from class: com.tencent.mobileqq.filemanager.nt.v
                @Override // com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.a
                public final void a(boolean z16) {
                    NTFileManageBridger.y0(j3, item, o06, runnable, z16);
                }
            });
        }
    }

    public void M(final FileManagerEntity fileManagerEntity) {
        QLog.i("NTFileManageBridger", 1, "cancelSendLocalFileToC2C fileName:" + fileManagerEntity.fileName + " sid:" + fileManagerEntity.nSessionId);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.y
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.h0(fileManagerEntity);
                }
            });
        } else {
            this.f208704e.z(fileManagerEntity);
        }
    }

    public void M0(FileManagerEntity fileManagerEntity, int i3) {
        String str;
        if (fileManagerEntity != null && fileManagerEntity.ntMsgId != 0 && fileManagerEntity.uniseq != 0) {
            QLog.i("NTFileManageBridger", 1, "update c2c nt elem status: msgId:" + fileManagerEntity.ntMsgId + " elemId:" + fileManagerEntity.uniseq + " sessionId:" + fileManagerEntity.nSessionId + " strFilePath:" + fileManagerEntity.strFilePath + " status:" + i3);
            String str2 = fileManagerEntity.peerUid;
            if (TextUtils.isEmpty(str2)) {
                str2 = FileManagerUtil.checkAndGetUid("", fileManagerEntity.peerUin, "updateC2CVideoPlayStatus");
                if (TextUtils.isEmpty(str2)) {
                    QLog.e("NTFileManageBridger", 1, "update c2c nt elem status: peerUid is empty");
                    return;
                }
            }
            String str3 = str2;
            com.tencent.nt.adapter.session.c cVar = com.tencent.nt.adapter.session.c.f339128a;
            int l3 = com.tencent.nt.adapter.session.c.l(fileManagerEntity.peerType);
            String str4 = fileManagerEntity.strFilePath;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            if (i3 == 4 && TextUtils.isEmpty(str)) {
                QLog.e("NTFileManageBridger", 1, "update c2c nt elem status: success but filePath is null");
                return;
            }
            int i16 = fileManagerEntity.nFileType;
            if (i16 != 2 && i16 != 0) {
                return;
            }
            ((IRichMediaService) QRoute.api(IRichMediaService.class)).updateOnlineVideoElemStatus(new UploadStatusParams(fileManagerEntity.ntMsgId, fileManagerEntity.uniseq, fileManagerEntity.nSessionId, str3, l3, i3, str));
        }
    }

    public void N(final TroopFileTransferManager.Item item) {
        QLog.i("NTFileManageBridger", 1, "cancelSendLocalFileToTroop fileName:" + item.FileName + " id:" + item.idStr());
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.at
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.i0(item);
                }
            });
        } else {
            this.f208705f.B(item);
        }
    }

    public void N0(TroopFileTransferManager.Item item, boolean z16) {
        int i3;
        if (item != null && item.ntMsgId != 0 && item.ntElementId != 0) {
            QLog.i("NTFileManageBridger", 1, "update troop nt elem status: msgId:" + item.ntMsgId + " elemId:" + item.ntElementId + " id:" + item.idStr() + " strFilePath:" + item.LocalFile + " suc:" + z16);
            String valueOf = String.valueOf(item.troopuin);
            if (TextUtils.isEmpty(valueOf)) {
                QLog.e("NTFileManageBridger", 1, "update troop nt elem status: peerUid is empty");
                return;
            }
            if (!z16) {
                i3 = 5;
            } else {
                i3 = 4;
            }
            String str = item.LocalFile;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            if (i3 == 4 && TextUtils.isEmpty(str2)) {
                QLog.e("NTFileManageBridger", 1, "update c2c nt elem status: success but filePath is null");
            } else {
                ((IRichMediaService) QRoute.api(IRichMediaService.class)).updateOnlineVideoElemStatus(new UploadStatusParams(item.ntMsgId, item.ntElementId, 0L, valueOf, 2, i3, str2));
            }
        }
    }

    public void O(final Activity activity, final NTFileUtils.b bVar, final MsgRecord msgRecord, final long j3, final String str, final f fVar) {
        String str2;
        if (msgRecord != null && j3 != 0) {
            int chatType = msgRecord.getChatType();
            if (bVar != null) {
                chatType = bVar.f208722d;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("downloadAioNTFileMsg. rooMsgInfo:");
            if (bVar == null) {
                str2 = "";
            } else {
                str2 = bVar.toString();
            }
            sb5.append(str2);
            sb5.append(" ntMsgId:");
            sb5.append(msgRecord.getMsgId());
            sb5.append(" elemId:");
            sb5.append(j3);
            sb5.append(" msgPeerUid:");
            sb5.append(msgRecord.getPeerUid());
            sb5.append(" msgPeerType:");
            sb5.append(msgRecord.getChatType());
            QLog.i("NTFileManageBridger", 1, sb5.toString());
            if (NTFileUtils.p(chatType)) {
                ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTFileManageBridger.this.k0(bVar, msgRecord, j3, activity, str, fVar);
                    }
                });
                return;
            } else {
                if (chatType == 2) {
                    this.f208705f.D(activity, bVar, msgRecord, j3, str, fVar);
                    return;
                }
                QLog.e("NTFileManageBridger", 1, "downloadAioNTFileMsg. un support chat type");
                if (fVar != null) {
                    fVar.onResult(-2, "");
                    return;
                }
                return;
            }
        }
        QLog.e("NTFileManageBridger", 1, "downloadAioNTFileMsg err. msgRecord/fileElemId=null/0");
        if (fVar != null) {
            fVar.onResult(-2, "");
        }
    }

    public void P(final FileManagerEntity fileManagerEntity) {
        QLog.i("NTFileManageBridger", 1, "downloadC2CFile fileName:" + fileManagerEntity.fileName + " sid:" + fileManagerEntity.nSessionId);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ap
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.l0(fileManagerEntity);
                }
            });
        } else {
            this.f208704e.D(fileManagerEntity);
        }
    }

    public void Q(final NTFileUtils.b bVar, final MsgRecord msgRecord, final long j3, final boolean z16, final com.tencent.qqnt.aio.adapter.richmedia.provider.i iVar) {
        String str;
        int i3;
        int chatType = msgRecord.getChatType();
        if (bVar != null) {
            chatType = bVar.f208722d;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("downloadThumbForMediaBrowser. rooMsgInfo:");
        if (bVar != null) {
            str = bVar.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(" ntMsgId:");
        sb5.append(msgRecord.getMsgId());
        sb5.append(" elemId:");
        sb5.append(j3);
        sb5.append("peerUid:");
        sb5.append(msgRecord.getPeerUid());
        sb5.append(" peerType:");
        sb5.append(msgRecord.getChatType());
        QLog.i("NTFileManageBridger", 1, sb5.toString());
        if (NTFileUtils.p(chatType)) {
            ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.x
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.n0(bVar, msgRecord, j3, iVar, z16);
                }
            });
            return;
        }
        if (chatType == 2) {
            long longValue = Long.valueOf(msgRecord.getPeerUid()).longValue();
            FileElement l3 = NTFileUtils.l(msgRecord, j3);
            if (l3 == null) {
                if (iVar != null) {
                    iVar.a(-1, "download err data=null");
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            long msgId = msgRecord.getMsgId();
            if (bVar != null) {
                msgId = bVar.f208719a;
            }
            bundle.putLong("TRANS_PARAM_NT_MSGID", msgId);
            bundle.putLong("TRANS_PARAM_NT_ELEMENTID", j3);
            bundle.putLong("TRANS_PARAM_UPLOAD_TIME", msgRecord.getMsgTime());
            TroopFileTransferManager O = TroopFileTransferManager.O(a0(), longValue);
            if (z16) {
                i3 = 640;
            } else {
                i3 = 383;
            }
            O.C(l3.getFileUuid(), l3.getFileName(), 102, i3, bundle);
            return;
        }
        QLog.e("NTFileManageBridger", 1, "downloadAioNTFileMsg. un support chat type");
    }

    public void R(final TroopFileTransferManager.Item item, final Bundle bundle, final e eVar) {
        QLog.i("NTFileManageBridger", 1, "downloadTroopFile fileName:" + item.FileName + " id:" + item.idStr());
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f208706g.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.aj
                @Override // java.lang.Runnable
                public final void run() {
                    NTFileManageBridger.this.o0(item, bundle, eVar);
                }
            });
        } else {
            this.f208705f.E(item, bundle, eVar);
        }
    }

    public void S(FileManagerEntity fileManagerEntity, String str, String str2, int i3, int i16) {
        if (i3 == 1) {
            this.f208705f.F(fileManagerEntity, str, i16);
            return;
        }
        if (i3 != 0 && i3 != 6000 && i3 != 6005 && i3 != 6003) {
            QLog.e("NTFileManageBridger", 1, "forwardFavFile2X error. un support peertype:" + i3);
            return;
        }
        if (i3 == 6000) {
            str2 = PeerUid.DATALINE_PC_UID;
        } else if (i3 == 6005) {
            str2 = PeerUid.DATALINE_PHONE_UID;
        } else if (i3 == 6003) {
            str2 = PeerUid.DATALINE_PAD_UID;
        }
        this.f208704e.F(fileManagerEntity, str, str2, i3, i16);
    }

    public void T(FileManagerEntity fileManagerEntity) {
        this.f208704e.I(fileManagerEntity);
    }

    public void U(FileManagerEntity fileManagerEntity, String str, long j3, int i3) {
        this.f208705f.G(fileManagerEntity, str, j3, i3);
    }

    public void V(final String str, final String str2, final String str3, final String str4, final int i3, final boolean z16, final long j3, final int i16) {
        this.f208706g.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.t
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.p0(str, str2, str3, str4, i3, z16, j3, i16);
            }
        }, 200L);
    }

    public void W(final String str, final String str2, final String str3, final String str4, final int i3, final boolean z16, final long j3, final int i16, final Bundle bundle) {
        this.f208706g.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.al
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.q0(str, str2, str3, str4, i3, z16, j3, i16, bundle);
            }
        }, 200L);
    }

    public void X(final String str, final String str2, final long j3, final int i3) {
        this.f208706g.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.nt.ao
            @Override // java.lang.Runnable
            public final void run() {
                NTFileManageBridger.this.r0(str, str2, j3, i3);
            }
        }, 200L);
    }

    public boolean Y(FileManagerEntity fileManagerEntity, long j3, long j16, String str, int i3, int i16, long j17, int i17) {
        if (i3 == 1) {
            return this.f208705f.H(fileManagerEntity, j3, j16, i16, j17, i17);
        }
        return this.f208704e.G(fileManagerEntity, j3, j16, str, i3, i16, j17, i17);
    }

    public void Z(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, int i16) {
        if (i3 == 1) {
            this.f208705f.I(fileManagerEntity, str, str2, i16);
            return;
        }
        if (str == null || str.length() == 0) {
            str = a0().getCurrentAccountUin();
        }
        this.f208704e.H(fileManagerEntity, str, str2, str3, i3, i16);
    }
}
