package com.tencent.mobileqq.pttlogic.api.impl;

import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PTTPreDownloaderImpl implements IPTTPreDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_ADDR_PROVIDER_CHANDED = 3;
    private static final int MSG_DOWNLOAD_FINISH = 2;
    private static final int MSG_RECEIVED_PTT = 0;
    private static final int MSG_VIEW_PTT = 4;
    private static final int PER_TYPE_MAX_DOWNLOADING_COUNT = 3;
    static final String TAG = "PTTPreDownloader";
    private boolean mAddrProviderReady;
    AppRuntime mApp;
    private final a mC2CCache;
    private boolean mDestroy;
    private final a mDissCache;
    private final a mGrpCache;
    private final WeakReferenceHandler mHandler;
    private IPTTPreDownloader.a mStrategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f261301a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<MessageForPtt> f261302b;

        /* renamed from: c, reason: collision with root package name */
        public final int f261303c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f261301a = 0;
            this.f261302b = new ArrayList<>(100);
            this.f261303c = 99;
        }
    }

    public PTTPreDownloaderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDestroy = false;
        this.mC2CCache = new a();
        this.mGrpCache = new a();
        this.mDissCache = new a();
        this.mHandler = new WeakReferenceHandler(ThreadManagerV2.getQQCommonThreadLooper(), this);
    }

    private void cancelCache(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancelCache");
        }
        for (int i3 = 0; i3 < aVar.f261302b.size(); i3++) {
            MessageForPtt messageForPtt = aVar.f261302b.get(i3);
            if (this.mStrategy.c(messageForPtt)) {
                long j3 = messageForPtt.extFlag;
                if (j3 != -1) {
                    j3 &= -4;
                }
                messageForPtt.extFlag = j3;
                messageForPtt.serial();
                ((IPttTempApi) QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
            }
        }
    }

    private a getCache(MessageForPtt messageForPtt) {
        int i3 = messageForPtt.istroop;
        if (i3 == 0) {
            return this.mC2CCache;
        }
        if (i3 == 1) {
            return this.mGrpCache;
        }
        if (i3 == 3000) {
            return this.mDissCache;
        }
        return null;
    }

    private void handleAddrReady(boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleAddrReady:" + z16);
        }
        this.mAddrProviderReady = z16;
        if (z16) {
            startDownloadCache(this.mC2CCache);
            startDownloadCache(this.mGrpCache);
            startDownloadCache(this.mDissCache);
        }
    }

    private void handleDownloadFinish(boolean z16, int i3, MessageForPtt messageForPtt) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleDownloadFinish uin:" + messageForPtt.frienduin + ", seq:" + messageForPtt.uniseq + ", sucess:" + z16);
        }
        long j3 = messageForPtt.extFlag;
        if (j3 > 0 && (1 & j3) > 0) {
            if (z16) {
                this.mStrategy.c(messageForPtt);
            } else if ((2 & j3) == 0 && this.mStrategy.b(messageForPtt, 3)) {
                long j16 = messageForPtt.extFlag;
                if (j16 != -1) {
                    j16 &= -4;
                }
                messageForPtt.extFlag = j16;
                messageForPtt.serial();
                ((IPttTempApi) QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
            }
        }
        a cache = getCache(messageForPtt);
        if (cache != null) {
            int i16 = cache.f261301a - 1;
            cache.f261301a = i16;
            if (i16 < 0) {
                cache.f261301a = 0;
            }
            startDownloadCache(cache);
        }
    }

    private boolean handlePlayPTT(MessageForPtt messageForPtt) {
        return true;
    }

    private boolean handleReceivedPTT(MessageForPtt messageForPtt) {
        a cache;
        if ((messageForPtt.istroop == 1 && ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(this.mApp, messageForPtt.frienduin) != GroupMsgMask.NOTIFY) || ((IPttTempApi) QRoute.api(IPttTempApi.class)).isHotChat(this.mApp, messageForPtt.frienduin)) {
            return true;
        }
        int receivedPTTStatus = ((IPttUtils) QRoute.api(IPttUtils.class)).getReceivedPTTStatus((AppInterface) this.mApp, messageForPtt);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleReceivedPTT uin:" + messageForPtt.frienduin + ", seq:" + messageForPtt.uniseq + ", status:" + receivedPTTStatus);
        }
        if ((receivedPTTStatus == 0 || receivedPTTStatus == -1) && (cache = getCache(messageForPtt)) != null) {
            if (this.mAddrProviderReady) {
                if (cache.f261301a < 3 && this.mStrategy.a(messageForPtt)) {
                    if (!startDownload(messageForPtt)) {
                        if (this.mStrategy.c(messageForPtt)) {
                            long j3 = messageForPtt.extFlag;
                            if (j3 != -1) {
                                j3 &= -4;
                            }
                            messageForPtt.extFlag = j3;
                            messageForPtt.serial();
                            ((IPttTempApi) QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
                        }
                    } else {
                        cache.f261301a++;
                    }
                } else if (cache.f261302b.size() + 1 < 99) {
                    cache.f261302b.add(messageForPtt);
                }
                if (messageForPtt.voiceChangeFlag == 1) {
                    ReportController.o(this.mApp, "CliOper", "", "", "changevoice", "0X8006F7D", 0, 0, "" + messageForPtt.istroop, "", "", "");
                }
            } else if (cache.f261302b.size() + 1 < 99) {
                cache.f261302b.add(messageForPtt);
            }
        }
        return true;
    }

    private boolean handleViewPTT(MessageForPtt messageForPtt) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleViewPTT uin:" + messageForPtt.frienduin + ", seq:" + messageForPtt.uniseq);
        }
        if (this.mStrategy.b(messageForPtt, 1)) {
            long j3 = messageForPtt.extFlag;
            long j16 = 2;
            if (j3 != -1) {
                j16 = 2 | j3;
            }
            messageForPtt.extFlag = j16;
            messageForPtt.serial();
            ((IPttTempApi) QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
        }
        return true;
    }

    private void setStrategy(IPTTPreDownloader.a aVar) {
        this.mStrategy = aVar;
    }

    private boolean startDownload(MessageForPtt messageForPtt) {
        boolean z16;
        int receivedPTTStatus = ((IPttUtils) QRoute.api(IPttUtils.class)).getReceivedPTTStatus((AppInterface) this.mApp, messageForPtt);
        boolean z17 = false;
        if (receivedPTTStatus == 0 || receivedPTTStatus == -1) {
            TransferRequest transferRequest = new TransferRequest();
            transferRequest.mSelfUin = this.mApp.getAccount();
            transferRequest.mPeerUin = messageForPtt.frienduin;
            transferRequest.mUinType = messageForPtt.istroop;
            transferRequest.mFileType = 2;
            transferRequest.mUniseq = messageForPtt.uniseq;
            transferRequest.mIsUp = false;
            transferRequest.mServerPath = messageForPtt.urlAtServer;
            transferRequest.mOutFilePath = messageForPtt.getLocalFilePath();
            if (!messageForPtt.isSendFromOtherTerminal() && !messageForPtt.isSend()) {
                z16 = false;
            } else {
                z16 = true;
            }
            transferRequest.mIsSelfSend = z16;
            transferRequest.mMd5 = messageForPtt.md5;
            transferRequest.mGroupFileID = messageForPtt.groupFileID;
            transferRequest.mGroupFileKeyStr = messageForPtt.groupFileKeyStr;
            transferRequest.mDbRecVersion = messageForPtt.subVersion;
            transferRequest.mRec = messageForPtt;
            transferRequest.mDownMode = 1;
            transferRequest.mExtraObj = new TransferRequest.PttDownExtraInfo(6, 0);
            try {
                z17 = ((ITransFileController) this.mApp.getRuntimeService(ITransFileController.class, "all")).transferAsync(transferRequest);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "startDownload  exception=" + e16.getMessage());
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "startDownload uin:" + messageForPtt.frienduin + ", seq:" + messageForPtt.uniseq + ", doIt:" + z17);
        }
        return z17;
    }

    private boolean startDownloadCache(a aVar) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startDownloadCache");
        }
        loop0: while (true) {
            z16 = false;
            while (aVar.f261301a < 3 && aVar.f261302b.size() > 0) {
                MessageForPtt messageForPtt = aVar.f261302b.get(0);
                if (!this.mStrategy.a(messageForPtt)) {
                    break loop0;
                }
                if (!startDownload(messageForPtt)) {
                    if (this.mStrategy.c(messageForPtt)) {
                        long j3 = messageForPtt.extFlag;
                        if (j3 != -1) {
                            j3 &= -4;
                        }
                        messageForPtt.extFlag = j3;
                        try {
                            messageForPtt.serial();
                        } catch (OutOfMemoryError unused) {
                        }
                        ((IPttTempApi) QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
                    }
                    aVar.f261302b.remove(0);
                } else {
                    aVar.f261301a++;
                    aVar.f261302b.remove(0);
                    z16 = true;
                }
            }
        }
        return z16;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        if (this.mDestroy) {
            return true;
        }
        int i3 = message.what;
        if (i3 != 0) {
            boolean z16 = false;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        handleViewPTT((MessageForPtt) message.obj);
                    }
                } else {
                    if (message.arg1 != 0) {
                        z16 = true;
                    }
                    handleAddrReady(z16);
                }
            } else {
                if (message.arg1 != 0) {
                    z16 = true;
                }
                handleDownloadFinish(z16, message.arg2, (MessageForPtt) message.obj);
            }
        } else {
            handleReceivedPTT((MessageForPtt) message.obj);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader
    public void onAddrProviderReady(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z16) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "onAddrProviderReady delay:" + z17);
        }
        if (z17) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, z16 ? 1 : 0, 0), 30000L);
        } else {
            this.mHandler.removeMessages(3);
            this.mHandler.obtainMessage(3, z16 ? 1 : 0, 0).sendToTarget();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            setStrategy(new PTTPreDownloadStrategy(appRuntime, this.mHandler));
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mDestroy = true;
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(4);
        cancelCache(this.mC2CCache);
        cancelCache(this.mGrpCache);
        cancelCache(this.mDissCache);
        this.mStrategy.onDestroy();
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader
    public void onDownloadFinish(boolean z16, int i3, TransferRequest.PttDownExtraInfo pttDownExtraInfo, MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3), pttDownExtraInfo, messageForPtt);
        } else {
            this.mHandler.obtainMessage(2, z16 ? 1 : 0, i3, messageForPtt).sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader
    public boolean onPlayPTT(MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader
    public boolean onReceivedPTTMsg(MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        this.mHandler.obtainMessage(0, messageForPtt).sendToTarget();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    @Override // com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onViewPTT(MessageForPtt messageForPtt) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        long j3 = 2;
        if (!messageForPtt.isSendFromLocal() && messageForPtt.getPttStreamFlag() != 10001) {
            long j16 = messageForPtt.extFlag;
            if (j16 != -1 && (j16 & 2) <= 0 && messageForPtt.fileSize > 0) {
                z16 = true;
                if (z16) {
                    return true;
                }
                long j17 = messageForPtt.extFlag;
                if (j17 != -1) {
                    j3 = 2 | j17;
                }
                messageForPtt.extFlag = j3;
                this.mHandler.obtainMessage(4, messageForPtt).sendToTarget();
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
