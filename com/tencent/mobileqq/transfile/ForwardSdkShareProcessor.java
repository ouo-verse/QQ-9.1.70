package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.forward.f;
import com.tencent.mobileqq.forward.u;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.g;
import com.tencent.open.appcommon.d;
import com.tencent.open.base.i;
import com.tencent.protofile.getappinfo.GetAppInfoProto$AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes19.dex */
public class ForwardSdkShareProcessor extends BaseTransProcessor implements f {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_UPLOAD_FAIL_IMG_URL = "https://pub.idqqimg.com/pc/misc/files/20191015/32ed5b691a1138ac452a59e42f3f83b5.png";
    private static final int MAX_RETRY_COUNT = 2;
    private static final String STAG = "Q.share.ForwardSdkShareProcessor";
    protected QQAppInterface app;
    protected Context mAppContext;
    private long mAppId;
    protected TransferRequest.AppInfo mAppInfo;
    protected String mAudioUrl;
    protected int mForwardType;
    private long mGetAppInfoTime;
    protected AtomicBoolean mIsAllUrlShort;
    private AtomicBoolean mIsImgUrlShort;
    private AtomicBoolean mIsThumbReady;
    private int mLackOfItems;
    protected String mLocalImgUrl;
    private String mPkgName;
    private boolean mRefreshTicket;
    protected String mRemoteImgUrl;
    private int mRetryCount;
    private RichStep mRichStep;
    private String mSKey;
    private ForwardStep mSendMsgByServerStep;
    private ForwardStep mSendMsgStep;
    protected int mServiceType;
    protected String mShareSummary;
    protected String mShareTitle;
    long mStartTime;
    protected String mTargetUrl;
    protected HashMap<String, String> mUrlMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public abstract class ForwardStep {
        static IPatchRedirector $redirector_;
        protected long beginTime;
        protected AtomicBoolean isCancelled;
        protected AtomicBoolean isRunning;
        private ForwardStep[] lastSteps;
        private ForwardStep nextStep;
        protected String stepName;

        ForwardStep() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
                return;
            }
            this.isRunning = new AtomicBoolean(false);
            this.isCancelled = new AtomicBoolean(false);
            this.stepName = "ForwardStep";
            this.beginTime = 0L;
        }

        protected void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (isFinished()) {
                return;
            }
            this.isCancelled.set(true);
            ForwardStep[] forwardStepArr = this.lastSteps;
            if (forwardStepArr != null && forwardStepArr.length > 0) {
                for (ForwardStep forwardStep : forwardStepArr) {
                    forwardStep.cancel();
                }
            }
        }

        protected void doCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            this.isRunning.set(false);
            long j3 = 0;
            if (this.beginTime != 0) {
                j3 = System.currentTimeMillis() - this.beginTime;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, this.stepName + "|doCancel,cost=" + j3);
        }

        void doError() {
            this.isRunning.set(false);
            long j3 = 0;
            if (this.beginTime != 0) {
                j3 = System.currentTimeMillis() - this.beginTime;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, this.stepName + "|doError,cost=" + j3);
            ForwardSdkShareProcessor.this.onError();
        }

        void doNextStep() {
            this.isRunning.set(false);
            long j3 = 0;
            if (this.beginTime != 0) {
                j3 = System.currentTimeMillis() - this.beginTime;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, this.stepName + "|finished,cost=" + j3);
            ForwardStatisticsReporter.d(this.stepName, j3);
            if (this.nextStep != null && !this.isCancelled.get()) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardStep.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                ForwardStep.this.nextStep.doStep();
                            }
                        }
                    }, 128, null, true);
                } else {
                    this.nextStep.doStep();
                }
            }
        }

        void doStep() {
            boolean z16;
            QLog.d(ForwardSdkShareProcessor.STAG, 1, this.stepName + "|doStep");
            ForwardStep[] forwardStepArr = this.lastSteps;
            if (forwardStepArr != null && forwardStepArr.length > 0) {
                z16 = true;
                for (ForwardStep forwardStep : forwardStepArr) {
                    QLog.d(ForwardSdkShareProcessor.STAG, 1, forwardStep.stepName, "|finished=", Boolean.valueOf(forwardStep.isFinished()), ", processing=", Boolean.valueOf(forwardStep.isProcessing()));
                    if (!forwardStep.isFinished()) {
                        if (!forwardStep.isProcessing()) {
                            forwardStep.doStep();
                        }
                        z16 = false;
                    }
                }
            } else {
                z16 = true;
            }
            if (z16 && !isFinished() && !isProcessing()) {
                this.isRunning.set(true);
                this.beginTime = System.currentTimeMillis();
                process();
            }
        }

        protected boolean isFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        protected boolean isProcessing() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isRunning.get();
        }

        protected abstract void process();

        void setLastSteps(ForwardStep[] forwardStepArr) {
            this.lastSteps = forwardStepArr;
            if (forwardStepArr != null && forwardStepArr.length > 0) {
                for (ForwardStep forwardStep : forwardStepArr) {
                    forwardStep.nextStep = this;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class GetAppInfoStep extends ForwardStep {
        static IPatchRedirector $redirector_;
        private AtomicBoolean isFinished;
        d mAppInfoObserver;
        private int retryCount;

        GetAppInfoStep() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
                return;
            }
            this.isFinished = new AtomicBoolean(false);
            this.mAppInfoObserver = new d() { // from class: com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetAppInfoStep.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GetAppInfoStep.this);
                    }
                }

                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z16, Bundle bundle) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                        return;
                    }
                    QLog.d(ForwardSdkShareProcessor.STAG, 1, "GetAppInfoStep|isSuccess=" + z16 + ",time=" + (System.currentTimeMillis() - ForwardSdkShareProcessor.this.mGetAppInfoTime));
                    int i16 = -1;
                    if (z16) {
                        try {
                            byte[] byteArray = bundle.getByteArray("data");
                            if (byteArray != null) {
                                GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                                getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                                i16 = getAppInfoProto$GetAppinfoResponse.ret.get();
                                if (QLog.isColorLevel()) {
                                    QLog.i(ForwardSdkShareProcessor.STAG, 2, "GetAppInfoStep|ret=" + i16);
                                }
                                if (i16 == 0) {
                                    ForwardSdkShareProcessor.this.mAppInfo.sourceIconSmall = Share.k(getAppInfoProto$GetAppinfoResponse.iconsURL, 16);
                                    ForwardSdkShareProcessor.this.mAppInfo.sourceIconBig = Share.k(getAppInfoProto$GetAppinfoResponse.iconsURL, 100);
                                    GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo;
                                    if (getAppInfoProto$AndroidInfo != null) {
                                        if (getAppInfoProto$AndroidInfo.packName.has()) {
                                            ForwardSdkShareProcessor.this.mAppInfo.packName = getAppInfoProto$AndroidInfo.packName.get();
                                        }
                                        if (getAppInfoProto$AndroidInfo.messagetail.has()) {
                                            ForwardSdkShareProcessor.this.mAppInfo.sourceName = getAppInfoProto$AndroidInfo.messagetail.get();
                                        }
                                        if (getAppInfoProto$AndroidInfo.sourceUrl.has() && ForwardSdkShareProcessor.this.mAppId != Long.parseLong(QZoneShareManager.QQ_SHARE_APPID)) {
                                            ForwardSdkShareProcessor.this.mAppInfo.sourceUrl = getAppInfoProto$AndroidInfo.sourceUrl.get();
                                        }
                                    }
                                    GetAppInfoStep getAppInfoStep = GetAppInfoStep.this;
                                    ForwardSdkShareProcessor.this.mAppInfo.status = 1;
                                    getAppInfoStep.updateMessageRecord();
                                }
                            }
                        } catch (Exception e16) {
                            QLog.e(ForwardSdkShareProcessor.STAG, 1, e16, new Object[0]);
                        }
                    }
                    GetAppInfoStep getAppInfoStep2 = GetAppInfoStep.this;
                    if (ForwardSdkShareProcessor.this.mAppInfo.status != 1 && getAppInfoStep2.retryCount < 2 && i16 != 110507 && i16 != 110401) {
                        GetAppInfoStep.this.retryCount++;
                        GetAppInfoStep.this.process();
                    } else {
                        GetAppInfoStep.this.isFinished.set(true);
                        GetAppInfoStep.this.doNextStep();
                    }
                }
            };
            this.stepName = "GetAppInfoStep";
            this.isFinished.set(ForwardSdkShareProcessor.this.mAppInfo.status == 1);
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected boolean isFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isFinished.get();
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected void process() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, "GetAppInfoStep|process|appId=" + ForwardSdkShareProcessor.this.mAppId + ",pkgName=" + ForwardSdkShareProcessor.this.mPkgName + ",retry=" + this.retryCount);
            if (this.isCancelled.get()) {
                doCancel();
                return;
            }
            ForwardSdkShareProcessor.this.mGetAppInfoTime = System.currentTimeMillis();
            ForwardSdkShareProcessor forwardSdkShareProcessor = ForwardSdkShareProcessor.this;
            int i3 = forwardSdkShareProcessor.mForwardType;
            if (i3 != 2) {
                if (i3 == 11) {
                    com.tencent.mobileqq.forward.b d16 = ((u) forwardSdkShareProcessor.app.getManager(QQManagerFactory.SDK_SHARE)).c().d(ForwardSdkShareProcessor.this.mAppId);
                    if (d16 != null) {
                        useCachedAppInfo(d16);
                        return;
                    }
                    long j3 = ForwardSdkShareProcessor.this.mGetAppInfoTime / 1000;
                    ForwardSdkShareProcessor forwardSdkShareProcessor2 = ForwardSdkShareProcessor.this;
                    String o16 = g.o(forwardSdkShareProcessor2.mAppContext, forwardSdkShareProcessor2.mPkgName, j3 + "");
                    if (QLog.isColorLevel()) {
                        QLog.d(ForwardSdkShareProcessor.STAG, 2, "GetAppInfoStep|process|sign: " + o16);
                    }
                    ForwardSdkShareProcessor forwardSdkShareProcessor3 = ForwardSdkShareProcessor.this;
                    QQAppInterface qQAppInterface = forwardSdkShareProcessor3.app;
                    Share.n(qQAppInterface, forwardSdkShareProcessor3.mAppContext, qQAppInterface.getCurrentAccountUin(), ForwardSdkShareProcessor.this.mAppId, o16, j3, this.mAppInfoObserver, ForwardSdkShareProcessor.this.mPkgName);
                    return;
                }
                return;
            }
            QQAppInterface qQAppInterface2 = forwardSdkShareProcessor.app;
            Share.p(qQAppInterface2, forwardSdkShareProcessor.mAppContext, qQAppInterface2.getCurrentAccountUin(), ForwardSdkShareProcessor.this.mAppId, 0L, this.mAppInfoObserver, ForwardSdkShareProcessor.this.mPkgName);
        }

        void updateMessageRecord() {
            QQMessageFacade messageFacade = ForwardSdkShareProcessor.this.app.getMessageFacade();
            TransferRequest transferRequest = ForwardSdkShareProcessor.this.mUiRequest;
            MessageRecord w06 = messageFacade.w0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            if (w06 instanceof MessageForStructing) {
                AbsStructMsg absStructMsg = ((MessageForStructing) w06).structingMsg;
                if (absStructMsg instanceof AbsShareMsg) {
                    AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                    ForwardSdkShareProcessor forwardSdkShareProcessor = ForwardSdkShareProcessor.this;
                    TransferRequest.AppInfo appInfo = forwardSdkShareProcessor.mAppInfo;
                    absShareMsg.mSource_A_ActionData = appInfo.packName;
                    absShareMsg.mSourceName = appInfo.sourceName;
                    absShareMsg.mSourceIcon = appInfo.sourceIconSmall;
                    absShareMsg.mSourceUrl = appInfo.sourceUrl;
                    absShareMsg.shareData.appInfoStatus = (byte) 1;
                    QQMessageFacade messageFacade2 = forwardSdkShareProcessor.app.getMessageFacade();
                    TransferRequest transferRequest2 = ForwardSdkShareProcessor.this.mUiRequest;
                    messageFacade2.Y0(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq, absShareMsg.getBytes());
                    ForwardSdkShareProcessor.this.sendMessageToUpdate(1002);
                }
            }
        }

        void useCachedAppInfo(com.tencent.mobileqq.forward.b bVar) {
            QLog.d(ForwardSdkShareProcessor.STAG, 1, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - ForwardSdkShareProcessor.this.mGetAppInfoTime));
            ForwardSdkShareProcessor.this.mAppInfo.sourceIconSmall = bVar.i();
            ForwardSdkShareProcessor.this.mAppInfo.sourceIconBig = bVar.h();
            if (bVar.o()) {
                if (!TextUtils.isEmpty(bVar.j())) {
                    ForwardSdkShareProcessor.this.mAppInfo.packName = bVar.j();
                }
                if (!TextUtils.isEmpty(bVar.f())) {
                    ForwardSdkShareProcessor.this.mAppInfo.sourceName = bVar.f();
                }
                if (!TextUtils.isEmpty(bVar.n()) && ForwardSdkShareProcessor.this.mAppId != Long.parseLong(QZoneShareManager.QQ_SHARE_APPID)) {
                    ForwardSdkShareProcessor.this.mAppInfo.sourceUrl = bVar.n();
                }
            }
            ForwardSdkShareProcessor.this.mAppInfo.status = 1;
            updateMessageRecord();
            this.isFinished.set(true);
            doNextStep();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class ImageUploadStep extends ForwardStep {
        static IPatchRedirector $redirector_;
        private int retryCount;

        ImageUploadStep() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
            } else {
                this.retryCount = 0;
                this.stepName = "ImageUploadStep";
            }
        }

        Pair<Integer, String> instanceUpload(String str, long j3) {
            long j16;
            Pair<Integer, String> pair;
            String currentUin = ForwardSdkShareProcessor.this.app.getCurrentUin();
            int i3 = 0;
            CompressInfo compressInfo = new CompressInfo(str, 0);
            compressInfo.K = 0;
            ForwardStatisticsReporter.m("compress_local_image");
            ForwardStatisticsReporter.j("compress_local_image", currentUin, ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo));
            if (!TextUtils.isEmpty(compressInfo.H)) {
                ForwardSdkShareProcessor.this.mLocalImgUrl = compressInfo.H;
            }
            File file = new File(ForwardSdkShareProcessor.this.mLocalImgUrl);
            if (file.exists()) {
                j16 = file.length();
            } else {
                j16 = 0;
            }
            String calcMd5 = FileUtils.calcMd5(ForwardSdkShareProcessor.this.mLocalImgUrl);
            if (j16 > 0 && !TextUtils.isEmpty(calcMd5)) {
                String format = String.format(HttpUtil.LOCAL_IMAGE_QUERY_URL, calcMd5, Long.valueOf(j16));
                ForwardStatisticsReporter.m("query_image");
                pair = HttpUtil.queryImageByIP(com.tencent.biz.common.util.g.c(format, 1007), currentUin);
                HashMap hashMap = new HashMap();
                String str2 = "0";
                if (pair == null) {
                    hashMap.put("param_ret_code", "-1");
                    hashMap.put("param_need_upload", "0");
                    ForwardStatisticsReporter.i("query_image", currentUin, hashMap, false);
                } else {
                    hashMap.put("param_ret_code", String.valueOf(pair.first));
                    if (!TextUtils.isEmpty(pair.second)) {
                        str2 = "1";
                    }
                    hashMap.put("param_need_upload", str2);
                    ForwardStatisticsReporter.i("query_image", currentUin, hashMap, !TextUtils.isEmpty(pair.second));
                }
            } else {
                pair = null;
            }
            long currentTimeMillis = System.currentTimeMillis() - j3;
            if (pair == null) {
                pair = new Pair<>(-1, "");
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, "ImageUploadStep|queryImage|ret=" + pair.first + ",cost=" + currentTimeMillis + JefsClass.INDEX_URL + pair.second);
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "16");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(pair.first);
            bundle.putString("intext_1", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("");
            if (pair.first.intValue() != -1) {
                i3 = pair.first.intValue();
            }
            sb6.append(i3);
            bundle.putString("intext_2", sb6.toString());
            bundle.putString("intext_5", "" + currentTimeMillis);
            ReportCenter.f().m(bundle, "", currentUin, false, ForwardSdkShareProcessor.this.isSdkShare());
            return pair;
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected boolean isFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return ForwardSdkShareProcessor.this.mIsThumbReady.get();
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected void process() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, "ImageUploadStep|process|ready=" + ForwardSdkShareProcessor.this.mIsThumbReady + ",remoteUrl=" + ForwardSdkShareProcessor.this.mRemoteImgUrl + " ,localUrl=" + ForwardSdkShareProcessor.this.mLocalImgUrl);
            if (this.isCancelled.get()) {
                doCancel();
            } else if (ForwardSdkShareProcessor.this.mIsThumbReady.get()) {
                doNextStep();
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImageUploadStep.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        byte b16;
                        boolean booleanValue;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.d(ForwardSdkShareProcessor.STAG, 1, "ImageUploadStep|run|retry=" + ImageUploadStep.this.retryCount);
                        if (ImageUploadStep.this.isCancelled.get()) {
                            ImageUploadStep.this.doCancel();
                            return;
                        }
                        String currentUin = ForwardSdkShareProcessor.this.app.getCurrentUin();
                        long currentTimeMillis = System.currentTimeMillis();
                        int i3 = 0;
                        if (!TextUtils.isEmpty(ForwardSdkShareProcessor.this.mLocalImgUrl) && TextUtils.isEmpty(ForwardSdkShareProcessor.this.mRemoteImgUrl)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            b16 = 2;
                        } else {
                            b16 = 4;
                        }
                        if (z16) {
                            ImageUploadStep imageUploadStep = ImageUploadStep.this;
                            String str = ForwardSdkShareProcessor.this.mLocalImgUrl;
                            if (imageUploadStep.isCancelled.get()) {
                                ImageUploadStep.this.doCancel();
                                return;
                            }
                            Pair<Integer, String> instanceUpload = ImageUploadStep.this.instanceUpload(str, currentTimeMillis);
                            if (!TextUtils.isEmpty(instanceUpload.second)) {
                                ForwardSdkShareProcessor forwardSdkShareProcessor = ForwardSdkShareProcessor.this;
                                forwardSdkShareProcessor.mRemoteImgUrl = instanceUpload.second;
                                forwardSdkShareProcessor.mIsImgUrlShort.set(true);
                                booleanValue = true;
                            } else if (ImageUploadStep.this.isCancelled.get()) {
                                ImageUploadStep.this.doCancel();
                                return;
                            } else {
                                Pair<Integer, Boolean> uploadImage = ImageUploadStep.this.uploadImage(currentTimeMillis);
                                i3 = uploadImage.first.intValue();
                                booleanValue = uploadImage.second.booleanValue();
                            }
                            if (booleanValue) {
                                try {
                                    str = new File(str).toURL().toString();
                                } catch (MalformedURLException e16) {
                                    QLog.d(ForwardSdkShareProcessor.STAG, 1, "srcPath to URL err:" + e16.getMessage());
                                }
                                ForwardStatisticsReporter.m("reuse_image_for_aio");
                                ForwardSdkShareProcessor forwardSdkShareProcessor2 = ForwardSdkShareProcessor.this;
                                i.b(true, str, forwardSdkShareProcessor2.mLocalImgUrl, forwardSdkShareProcessor2.mRemoteImgUrl);
                                ForwardStatisticsReporter.j("reuse_image_for_aio", currentUin, true);
                            } else {
                                if (i3 == 100000 && ForwardSdkShareProcessor.this.mRetryCount < 2) {
                                    ForwardSdkShareProcessor.this.mRetryCount++;
                                    ForwardSdkShareProcessor.this.mSKey = null;
                                    ForwardSdkShareProcessor.this.mRefreshTicket = true;
                                    ForwardSdkShareProcessor.this.innerRetry();
                                    return;
                                }
                                ImageUploadStep imageUploadStep2 = ImageUploadStep.this;
                                int i16 = imageUploadStep2.retryCount;
                                imageUploadStep2.retryCount = i16 + 1;
                                if (i16 < 2) {
                                    run();
                                    return;
                                }
                                ForwardSdkShareProcessor forwardSdkShareProcessor3 = ForwardSdkShareProcessor.this;
                                String str2 = forwardSdkShareProcessor3.mAppInfo.sourceIconBig;
                                forwardSdkShareProcessor3.mRemoteImgUrl = str2;
                                if (TextUtils.isEmpty(str2)) {
                                    ForwardSdkShareProcessor.this.mRemoteImgUrl = ForwardSdkShareProcessor.DEFAULT_UPLOAD_FAIL_IMG_URL;
                                }
                                QLog.e(ForwardSdkShareProcessor.STAG, 1, "ImageUploadStep.process: upload image fail, use default remoteImageUrl instead: " + ForwardSdkShareProcessor.this.mRemoteImgUrl);
                            }
                            b16 = 1;
                        } else {
                            QLog.d(ForwardSdkShareProcessor.STAG, 1, "skip ImageUploadStep change remote url : " + ForwardSdkShareProcessor.this.mRemoteImgUrl);
                        }
                        QQMessageFacade messageFacade = ForwardSdkShareProcessor.this.app.getMessageFacade();
                        TransferRequest transferRequest = ForwardSdkShareProcessor.this.mUiRequest;
                        MessageRecord w06 = messageFacade.w0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
                        if (w06 instanceof MessageForStructing) {
                            AbsStructMsg absStructMsg = ((MessageForStructing) w06).structingMsg;
                            if (absStructMsg instanceof AbsShareMsg) {
                                AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                                absShareMsg.updateCover(ForwardSdkShareProcessor.this.mRemoteImgUrl);
                                absShareMsg.shareData.imageUrlStatus = b16;
                                QQMessageFacade messageFacade2 = ForwardSdkShareProcessor.this.app.getMessageFacade();
                                TransferRequest transferRequest2 = ForwardSdkShareProcessor.this.mUiRequest;
                                messageFacade2.Y0(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq, absShareMsg.getBytes());
                            }
                        }
                        ForwardSdkShareProcessor.this.mIsThumbReady.set(true);
                        ImageUploadStep.this.doNextStep();
                    }
                }, 128, null, true);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0247  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Pair<Integer, Boolean> uploadImage(long j3) {
            boolean z16;
            String str;
            HashMap hashMap;
            int i3;
            boolean z17;
            String currentUin = ForwardSdkShareProcessor.this.app.getCurrentUin();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Connection", "keep-alive");
            hashMap2.put("Referer", "http://www.qq.com");
            hashMap2.put("Host", HttpUtil.LOCAL_IMAGE_UPLOAD_HOST);
            String pskey = ((TicketManager) BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(currentUin, "connect.qq.com");
            if (!TextUtils.isEmpty(pskey)) {
                hashMap2.put("Cookie", "p_uin=" + currentUin + ";p_skey=" + pskey);
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("share_image", ForwardSdkShareProcessor.this.mLocalImgUrl);
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "51");
            bundle.putString("intext_3", "0");
            bundle.putString("stringext_1", ForwardSdkShareProcessor.this.mTargetUrl);
            ReportCenter.f().m(bundle, "", currentUin, false, ForwardSdkShareProcessor.this.isSdkShare());
            HashMap hashMap4 = new HashMap();
            hashMap4.put("param_is_ip_direct", "1");
            ForwardStatisticsReporter.m("upload_local_thumb_image");
            String uploadImageWithHttps = HttpUtil.uploadImageWithHttps(com.tencent.biz.common.util.g.c(HttpUtil.LOCAL_IMAGE_UPLOAD_URL, 1007), HttpUtil.LOCAL_IMAGE_UPLOAD_HOST, currentUin, null, hashMap3, hashMap2, false);
            if (uploadImageWithHttps == null) {
                ForwardStatisticsReporter.i("upload_local_thumb_image", currentUin, hashMap4, false);
                ForwardStatisticsReporter.m("upload_local_thumb_image");
                str = "upload_local_thumb_image";
                hashMap = hashMap4;
                z16 = false;
                uploadImageWithHttps = HttpUtil.uploadImageWithHttps(HttpUtil.LOCAL_IMAGE_UPLOAD_URL, HttpUtil.LOCAL_IMAGE_UPLOAD_HOST, currentUin, null, hashMap3, hashMap2, true);
                hashMap.put("param_is_ip_direct", "0");
            } else {
                z16 = false;
                str = "upload_local_thumb_image";
                hashMap = hashMap4;
            }
            if (uploadImageWithHttps != null) {
                try {
                    JSONObject jSONObject = new JSONObject(uploadImageWithHttps);
                    i3 = jSONObject.getInt("retcode");
                    z17 = z16;
                    if (i3 == 0) {
                        try {
                            z17 = z16;
                            if (jSONObject.has("result")) {
                                ForwardSdkShareProcessor.this.mRemoteImgUrl = jSONObject.getJSONObject("result").getString("url");
                                ForwardSdkShareProcessor.this.mIsImgUrlShort.set(true);
                                z17 = 1;
                            }
                        } catch (JSONException e16) {
                            e = e16;
                            z17 = z16;
                            if (QLog.isColorLevel()) {
                                QLog.d(ForwardSdkShareProcessor.STAG, 2, e.getMessage());
                                z17 = z16;
                            }
                            hashMap.put("param_ret_code", Integer.toString(i3));
                            ForwardStatisticsReporter.j(str, currentUin, z17);
                            long currentTimeMillis = System.currentTimeMillis() - j3;
                            if (QLog.isColorLevel()) {
                            }
                            if (z17 == 0) {
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                            bundle2.putString("act_type", "11");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("");
                            sb5.append(!z17);
                            bundle2.putString("intext_1", sb5.toString());
                            bundle2.putString("intext_2", "" + i3);
                            bundle2.putString("intext_3", "0");
                            bundle2.putString("intext_5", "" + currentTimeMillis);
                            if (z17 == 0) {
                            }
                            ReportCenter.f().m(bundle2, "", currentUin, false, ForwardSdkShareProcessor.this.isSdkShare());
                            return new Pair<>(Integer.valueOf(i3), Boolean.valueOf(z17));
                        }
                    }
                } catch (JSONException e17) {
                    e = e17;
                    i3 = z16 ? 1 : 0;
                }
            } else {
                i3 = z16 ? 1 : 0;
                z17 = z16;
            }
            hashMap.put("param_ret_code", Integer.toString(i3));
            ForwardStatisticsReporter.j(str, currentUin, z17);
            long currentTimeMillis2 = System.currentTimeMillis() - j3;
            if (QLog.isColorLevel()) {
                String str2 = "ImageUploadStep|uploadImage|suc=" + z17 + ",cost=" + currentTimeMillis2 + ",localImgUrl=" + ForwardSdkShareProcessor.this.mLocalImgUrl + ",targetUrl=" + ForwardSdkShareProcessor.this.mTargetUrl;
                if (z17 != 0 && currentTimeMillis2 <= 5000) {
                    QLog.d(ForwardSdkShareProcessor.STAG, 2, str2);
                } else {
                    QLog.e(ForwardSdkShareProcessor.STAG, 2, str2);
                }
            }
            if (z17 == 0) {
                QLog.e(ForwardSdkShareProcessor.STAG, 1, "ImageUploadStep|uploadImage|ret=" + i3 + ",retry=" + this.retryCount);
            }
            Bundle bundle22 = new Bundle();
            bundle22.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle22.putString("act_type", "11");
            StringBuilder sb52 = new StringBuilder();
            sb52.append("");
            sb52.append(!z17);
            bundle22.putString("intext_1", sb52.toString());
            bundle22.putString("intext_2", "" + i3);
            bundle22.putString("intext_3", "0");
            bundle22.putString("intext_5", "" + currentTimeMillis2);
            if (z17 == 0) {
                bundle22.putString("stringext_2", ForwardSdkShareProcessor.this.mLocalImgUrl);
                bundle22.putString("stringext_1", ForwardSdkShareProcessor.this.mTargetUrl);
            }
            ReportCenter.f().m(bundle22, "", currentUin, false, ForwardSdkShareProcessor.this.isSdkShare());
            return new Pair<>(Integer.valueOf(i3), Boolean.valueOf(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class RichStep extends ForwardStep {
        static IPatchRedirector $redirector_;
        boolean isDidRich;
        AtomicBoolean needRich;
        AtomicInteger retryCount;

        RichStep() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
                return;
            }
            this.needRich = new AtomicBoolean(false);
            this.retryCount = new AtomicInteger(0);
            this.isDidRich = false;
            this.stepName = "RichStep";
            reset();
        }

        private void reportAfter(int i3, long j3, int i16, int i17) {
            int i18;
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "13");
            bundle.putString("intext_3", "0");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            if (i3 != 0) {
                i18 = 1;
            } else {
                i18 = 0;
            }
            sb5.append(i18);
            bundle.putString("intext_1", sb5.toString());
            bundle.putString("stringext_2", "" + i3);
            bundle.putString("stringext_3", "1");
            bundle.putString("intext_5", "" + j3);
            bundle.putString("intext_2", "" + i16);
            bundle.putString("intext_4", "" + i17);
            if (i3 != 0) {
                bundle.putString("stringext_1", ForwardSdkShareProcessor.this.mTargetUrl);
            }
            ReportCenter.f().m(bundle, "", ForwardSdkShareProcessor.this.app.getCurrentAccountUin(), false, ForwardSdkShareProcessor.this.isSdkShare());
            if (QLog.isColorLevel()) {
                String str = "RichStep|run|ret=" + i3 + ",lack=" + ForwardSdkShareProcessor.this.mLackOfItems + ",cost=" + j3;
                if (i3 == 0 && j3 <= 3000) {
                    QLog.d(BaseTransProcessor.TAG, 2, str);
                } else {
                    QLog.e(BaseTransProcessor.TAG, 2, str);
                }
            }
        }

        private void reportBefore() {
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "53");
            bundle.putString("intext_4", "1");
            bundle.putString("intext_3", "0");
            bundle.putString("intext_2", "" + ForwardSdkShareProcessor.this.mLackOfItems);
            bundle.putString("stringext_1", ForwardSdkShareProcessor.this.mTargetUrl);
            ReportCenter.f().m(bundle, "", ForwardSdkShareProcessor.this.app.getCurrentAccountUin(), false, ForwardSdkShareProcessor.this.isSdkShare());
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0125  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int doRich() {
            int i3;
            int i16;
            int i17;
            reportBefore();
            long currentTimeMillis = System.currentTimeMillis();
            int i18 = ForwardSdkShareProcessor.this.mLackOfItems;
            int i19 = -1;
            int i26 = 0;
            try {
                ForwardSdkShareProcessor forwardSdkShareProcessor = ForwardSdkShareProcessor.this;
                Object[] a16 = i.a(forwardSdkShareProcessor.mAppContext, forwardSdkShareProcessor.mTargetUrl, forwardSdkShareProcessor.app.getCurrentAccountUin());
                i19 = ((Integer) a16[0]).intValue();
                if (i19 == 0) {
                    String str = (String) a16[1];
                    String str2 = (String) a16[2];
                    String str3 = (String) a16[3];
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mShareTitle)) {
                                ForwardSdkShareProcessor.this.mLackOfItems &= -5;
                                ForwardSdkShareProcessor.this.mShareTitle = str;
                            }
                            i3 = 4;
                        } catch (Exception e16) {
                            e = e16;
                            i3 = 4;
                            if (QLog.isColorLevel()) {
                                QLog.d(ForwardSdkShareProcessor.STAG, 4, e, new Object[0]);
                            }
                            i17 = i19;
                            i16 = i3;
                            reportAfter(i17, System.currentTimeMillis() - currentTimeMillis, i18, i16);
                            return i17;
                        }
                    } else {
                        i3 = 0;
                    }
                    try {
                        if (!TextUtils.isEmpty(str2)) {
                            i3 |= 2;
                            if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mShareSummary)) {
                                ForwardSdkShareProcessor.this.mLackOfItems &= -3;
                                ForwardSdkShareProcessor.this.mShareSummary = str2;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            i3 |= 1;
                            if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mRemoteImgUrl) && TextUtils.isEmpty(ForwardSdkShareProcessor.this.mLocalImgUrl)) {
                                ForwardSdkShareProcessor.this.mLackOfItems &= -2;
                                ForwardSdkShareProcessor.this.mRemoteImgUrl = str3;
                            }
                        }
                        this.needRich.set(false);
                        QQMessageFacade messageFacade = ForwardSdkShareProcessor.this.app.getMessageFacade();
                        TransferRequest transferRequest = ForwardSdkShareProcessor.this.mUiRequest;
                        MessageRecord w06 = messageFacade.w0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
                        if ((w06 instanceof MessageForStructing) && (((MessageForStructing) w06).structingMsg instanceof AbsShareMsg)) {
                            AbsShareMsg absShareMsg = (AbsShareMsg) ((MessageForStructing) w06).structingMsg;
                            String str4 = ForwardSdkShareProcessor.this.mShareTitle;
                            if (str4 != null) {
                                s.c(str4, false);
                            }
                            String str5 = ForwardSdkShareProcessor.this.mShareSummary;
                            if (str5 != null) {
                                s.c(str5, false);
                            }
                            ForwardSdkShareProcessor forwardSdkShareProcessor2 = ForwardSdkShareProcessor.this;
                            absShareMsg.updateTitleSummaryAndCover(forwardSdkShareProcessor2.mShareTitle, forwardSdkShareProcessor2.mShareSummary, forwardSdkShareProcessor2.mRemoteImgUrl);
                            QQMessageFacade messageFacade2 = ForwardSdkShareProcessor.this.app.getMessageFacade();
                            TransferRequest transferRequest2 = ForwardSdkShareProcessor.this.mUiRequest;
                            messageFacade2.Y0(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq, absShareMsg.getBytes());
                            ForwardSdkShareProcessor.this.sendMessageToUpdate(1002);
                        }
                        i26 = i3;
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                        }
                        i17 = i19;
                        i16 = i3;
                        reportAfter(i17, System.currentTimeMillis() - currentTimeMillis, i18, i16);
                        return i17;
                    }
                }
                i17 = i19;
                i16 = i26;
            } catch (Exception e18) {
                e = e18;
                i3 = 0;
            }
            reportAfter(i17, System.currentTimeMillis() - currentTimeMillis, i18, i16);
            return i17;
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected boolean isFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.needRich.get() && this.retryCount.get() < 2) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected void process() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, "RichStep|process|neeRich=" + this.needRich + ",lack=" + ForwardSdkShareProcessor.this.mLackOfItems);
            if (this.isCancelled.get()) {
                doCancel();
            } else if (this.needRich.get()) {
                this.retryCount.set(0);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RichStep.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(ForwardSdkShareProcessor.STAG, 2, "RichStep|run|retry=" + RichStep.this.retryCount);
                        }
                        if (RichStep.this.isCancelled.get()) {
                            RichStep.this.doCancel();
                            return;
                        }
                        int doRich = RichStep.this.doRich();
                        if (RichStep.this.needRich.get()) {
                            if (doRich == -1 && RichStep.this.retryCount.getAndIncrement() < 2) {
                                run();
                                return;
                            }
                            RichStep.this.needRich.set(false);
                            QLog.d(ForwardSdkShareProcessor.STAG, 1, "RichStep|rich fail,lack=" + ForwardSdkShareProcessor.this.mLackOfItems);
                        }
                        RichStep richStep = RichStep.this;
                        richStep.isDidRich = true;
                        richStep.doNextStep();
                    }
                }, 128, null, true);
            } else {
                doNextStep();
            }
        }

        void reset() {
            this.retryCount.set(0);
            this.needRich.set(false);
            if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mRemoteImgUrl) && TextUtils.isEmpty(ForwardSdkShareProcessor.this.mLocalImgUrl)) {
                ForwardSdkShareProcessor.this.mLackOfItems |= 1;
            }
            if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mShareSummary)) {
                ForwardSdkShareProcessor.this.mLackOfItems |= 2;
            }
            if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mShareTitle)) {
                ForwardSdkShareProcessor.this.mLackOfItems |= 4;
            }
            if (ForwardSdkShareProcessor.this.mLackOfItems > 0) {
                this.needRich.set(true);
            }
            if (ForwardSdkShareProcessor.this.isSdkShare()) {
                this.needRich.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public class SendMsgByServerStep extends ForwardStep {
        static IPatchRedirector $redirector_;
        private boolean isFinished;

        SendMsgByServerStep() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
            } else {
                this.stepName = "SendMsgByServerStep";
            }
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected boolean isFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isFinished;
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected void process() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, "SendMsgByServerStep|process");
            if (this.isCancelled.get()) {
                doCancel();
                return;
            }
            if (!com.tencent.biz.common.util.g.b(ForwardSdkShareProcessor.this.mAppContext)) {
                QLog.w(ForwardSdkShareProcessor.STAG, 1, "SendMsgByServerStep|no network");
                if (ForwardSdkShareProcessor.this.mLackOfItems > 0 || !ForwardSdkShareProcessor.this.mIsThumbReady.get() || !ForwardSdkShareProcessor.this.mIsAllUrlShort.get() || ForwardSdkShareProcessor.this.mAppInfo.status != 1) {
                    ForwardSdkShareProcessor.this.mProcessorReport.setError(9004, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, null, null);
                    doError();
                    return;
                }
            }
            TransferRequest transferRequest = ForwardSdkShareProcessor.this.mUiRequest;
            if (transferRequest != null && transferRequest.mUpCallBack != null) {
                ad.a aVar = new ad.a();
                String str = ForwardSdkShareProcessor.this.mUrlMap.get("audioUrl");
                String[] strArr = new String[2];
                strArr[0] = ForwardSdkShareProcessor.this.mRemoteImgUrl;
                if (TextUtils.isEmpty(str)) {
                    str = ForwardSdkShareProcessor.this.mAudioUrl;
                }
                strArr[1] = str;
                aVar.f258608l = strArr;
                aVar.f258597a = 0;
                ForwardSdkShareProcessor.this.mUiRequest.mUpCallBack.q(aVar);
            }
            this.isFinished = true;
            doNextStep();
            ForwardSdkShareProcessor.this.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public class SendMsgStep extends ForwardStep {
        static IPatchRedirector $redirector_;
        private boolean isFinished;

        SendMsgStep() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
            } else {
                this.stepName = "SendMsgStep";
            }
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected boolean isFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isFinished;
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected void process() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(ForwardSdkShareProcessor.STAG, 1, "SendMsgStep|process");
            if (this.isCancelled.get()) {
                doCancel();
                return;
            }
            if (!com.tencent.biz.common.util.g.b(ForwardSdkShareProcessor.this.mAppContext)) {
                QLog.w(ForwardSdkShareProcessor.STAG, 1, "SendMsgStep|no network");
                if (ForwardSdkShareProcessor.this.mLackOfItems > 0 || !ForwardSdkShareProcessor.this.mIsThumbReady.get() || !ForwardSdkShareProcessor.this.mIsAllUrlShort.get() || ForwardSdkShareProcessor.this.mAppInfo.status != 1) {
                    ForwardSdkShareProcessor.this.mProcessorReport.setError(9004, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, null, null);
                    doError();
                    return;
                }
            }
            QQMessageFacade messageFacade = ForwardSdkShareProcessor.this.app.getMessageFacade();
            TransferRequest transferRequest = ForwardSdkShareProcessor.this.mUiRequest;
            MessageRecord w06 = messageFacade.w0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            if (w06 != null) {
                ForwardSdkShareProcessor.this.app.getMessageFacade().D0(w06, null);
            }
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "14");
            bundle.putString("intext_2", "" + ForwardSdkShareProcessor.this.mLackOfItems);
            bundle.putString("stringext_1", "" + ForwardSdkShareProcessor.this.mTargetUrl);
            bundle.putString("intext_3", "0");
            ReportCenter.f().m(bundle, "", ForwardSdkShareProcessor.this.app.getCurrentAccountUin(), false, ForwardSdkShareProcessor.this.isSdkShare());
            this.isFinished = true;
            doNextStep();
            ForwardSdkShareProcessor.this.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public class UrlExchangeStep extends ForwardStep {
        static IPatchRedirector $redirector_;
        private AtomicInteger retCode;
        private AtomicInteger retryCount;

        UrlExchangeStep() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
                return;
            }
            this.retryCount = new AtomicInteger(0);
            this.retCode = new AtomicInteger(-1);
            this.stepName = "UrlExchangeStep";
        }

        protected Runnable buildJob() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Runnable) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new Runnable() { // from class: com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UrlExchangeStep.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int length;
                    byte b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UrlExchangeStep.this.qlog("UrlExchangeStep|run,retry=" + UrlExchangeStep.this.retryCount);
                    if (UrlExchangeStep.this.isCancelled.get()) {
                        UrlExchangeStep.this.doCancel();
                        return;
                    }
                    Bundle bundle = new Bundle();
                    String currentUin = ForwardSdkShareProcessor.this.app.getCurrentUin();
                    if (!ForwardSdkShareProcessor.this.mIsImgUrlShort.get() && TextUtils.isEmpty(ForwardSdkShareProcessor.this.mRemoteImgUrl)) {
                        length = 0;
                    } else {
                        length = ForwardSdkShareProcessor.this.mRemoteImgUrl.length();
                    }
                    bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                    bundle.putString("act_type", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE);
                    String str = "0";
                    bundle.putString("intext_3", "0");
                    bundle.putString("stringext_1", ForwardSdkShareProcessor.this.mTargetUrl);
                    bundle.putString("intext_4", "" + length);
                    ReportCenter.f().m(bundle, "", currentUin, false, ForwardSdkShareProcessor.this.isSdkShare());
                    long currentTimeMillis = System.currentTimeMillis();
                    ForwardStatisticsReporter.m("batch_url_exchange");
                    Bundle bundle2 = new Bundle();
                    ForwardSdkShareProcessor forwardSdkShareProcessor = ForwardSdkShareProcessor.this;
                    HashMap<String, String> batchUrlExchange = HttpUtil.batchUrlExchange(forwardSdkShareProcessor.mAppContext, currentUin, 1, forwardSdkShareProcessor.mUrlMap, bundle2);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    boolean z16 = bundle2.getBoolean("isSuccess");
                    int i3 = bundle2.getInt("retcode", -1);
                    UrlExchangeStep.this.retCode.set(i3);
                    HashMap hashMap = new HashMap();
                    hashMap.put("param_ret_code", Integer.toString(i3));
                    ForwardStatisticsReporter.i("batch_url_exchange", currentUin, hashMap, z16);
                    UrlExchangeStep.this.qlog("UrlExchangeStep|run,suc=" + z16 + ",ret=" + UrlExchangeStep.this.retCode + ",cost=" + currentTimeMillis2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                    bundle3.putString("act_type", "12");
                    bundle3.putString("intext_3", "0");
                    if (!z16) {
                        str = "1";
                    }
                    bundle3.putString("intext_1", str);
                    bundle3.putString("intext_2", "" + UrlExchangeStep.this.retCode);
                    bundle3.putString("intext_5", "" + currentTimeMillis2);
                    if (!z16) {
                        bundle3.putString("stringext_1", ForwardSdkShareProcessor.this.mTargetUrl);
                    }
                    ReportCenter.f().m(bundle3, "", currentUin, false, ForwardSdkShareProcessor.this.isSdkShare());
                    if (z16) {
                        ForwardSdkShareProcessor.this.mUrlMap.putAll(batchUrlExchange);
                        ForwardSdkShareProcessor.this.mIsAllUrlShort.set(true);
                        UrlExchangeStep.this.qlog("UrlExchangeStep|run,url=" + ForwardSdkShareProcessor.this.mUrlMap.toString());
                        String str2 = ForwardSdkShareProcessor.this.mUrlMap.get("imageUrl");
                        if (str2 != null) {
                            ForwardStatisticsReporter.m("reuse_image_for_aio");
                            String str3 = ForwardSdkShareProcessor.this.mRemoteImgUrl;
                            i.b(false, str3, str3, str2);
                            ForwardStatisticsReporter.j("reuse_image_for_aio", currentUin, true);
                        }
                    } else {
                        if (UrlExchangeStep.this.retCode.get() == 100000 && ForwardSdkShareProcessor.this.mRetryCount < 2) {
                            ForwardSdkShareProcessor.this.mRetryCount++;
                            ForwardSdkShareProcessor.this.mSKey = null;
                            ForwardSdkShareProcessor.this.mRefreshTicket = true;
                            ForwardSdkShareProcessor.this.innerRetry();
                            return;
                        }
                        if (UrlExchangeStep.this.retCode.get() == -1 && UrlExchangeStep.this.retryCount.getAndIncrement() < 2) {
                            run();
                            return;
                        }
                    }
                    if (!z16) {
                        QLog.i(ForwardSdkShareProcessor.STAG, 1, "UrlExchangeStep|ret=" + UrlExchangeStep.this.retCode + ",cost=" + currentTimeMillis2 + JefsClass.INDEX_URL + ForwardSdkShareProcessor.this.mUrlMap.toString());
                    }
                    QQMessageFacade messageFacade = ForwardSdkShareProcessor.this.app.getMessageFacade();
                    TransferRequest transferRequest = ForwardSdkShareProcessor.this.mUiRequest;
                    MessageRecord w06 = messageFacade.w0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
                    if (w06 != null && (w06 instanceof MessageForStructing)) {
                        AbsStructMsg absStructMsg = ((MessageForStructing) w06).structingMsg;
                        if (absStructMsg instanceof AbsShareMsg) {
                            AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                            String str4 = ForwardSdkShareProcessor.this.mUrlMap.get("targetUrl");
                            if (str4 != null) {
                                absShareMsg.mMsgUrl = str4;
                            }
                            String str5 = ForwardSdkShareProcessor.this.mUrlMap.get("sourceUrl");
                            if (str5 != null) {
                                absShareMsg.mSourceUrl = str5;
                            }
                            String str6 = ForwardSdkShareProcessor.this.mUrlMap.get("sourceIcon");
                            if (str6 != null) {
                                absShareMsg.mSourceIcon = str6;
                            }
                            String str7 = ForwardSdkShareProcessor.this.mUrlMap.get("audioUrl");
                            if (str7 != null) {
                                absShareMsg.mContentSrc = str7;
                            }
                            String str8 = ForwardSdkShareProcessor.this.mUrlMap.get("imageUrl");
                            if (str8 != null) {
                                b16 = 1;
                                absShareMsg.shareData.imageUrlStatus = (byte) 1;
                                absShareMsg.updateCover(str8);
                            } else {
                                b16 = 1;
                            }
                            if (ForwardSdkShareProcessor.this.mIsAllUrlShort.get()) {
                                absShareMsg.shareData.shortUrlStatus = b16;
                            }
                            QQMessageFacade messageFacade2 = ForwardSdkShareProcessor.this.app.getMessageFacade();
                            TransferRequest transferRequest2 = ForwardSdkShareProcessor.this.mUiRequest;
                            messageFacade2.Y0(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq, absShareMsg.getBytes());
                        }
                    }
                    UrlExchangeStep.this.doNextStep();
                }
            };
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected boolean isFinished() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (!ForwardSdkShareProcessor.this.mIsAllUrlShort.get() && this.retCode.get() == -1 && this.retryCount.get() < 2) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
        protected void process() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.isCancelled.get()) {
                doCancel();
                return;
            }
            if (ForwardSdkShareProcessor.this.isSdkShare()) {
                QLog.i(ForwardSdkShareProcessor.STAG, 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
                ForwardSdkShareProcessor.this.mIsAllUrlShort.set(true);
                doNextStep();
                return;
            }
            if (!TextUtils.isEmpty(ForwardSdkShareProcessor.this.mTargetUrl) && ForwardSdkShareProcessor.this.mTargetUrl.length() > 150) {
                ForwardSdkShareProcessor forwardSdkShareProcessor = ForwardSdkShareProcessor.this;
                forwardSdkShareProcessor.mUrlMap.put("targetUrl", forwardSdkShareProcessor.mTargetUrl);
            }
            if (!TextUtils.isEmpty(ForwardSdkShareProcessor.this.mAppInfo.sourceUrl)) {
                ForwardSdkShareProcessor forwardSdkShareProcessor2 = ForwardSdkShareProcessor.this;
                forwardSdkShareProcessor2.mUrlMap.put("sourceUrl", forwardSdkShareProcessor2.mAppInfo.sourceUrl);
            }
            if (!TextUtils.isEmpty(ForwardSdkShareProcessor.this.mAppInfo.sourceIconSmall)) {
                ForwardSdkShareProcessor forwardSdkShareProcessor3 = ForwardSdkShareProcessor.this;
                forwardSdkShareProcessor3.mUrlMap.put("sourceIcon", forwardSdkShareProcessor3.mAppInfo.sourceIconSmall);
            }
            ForwardSdkShareProcessor forwardSdkShareProcessor4 = ForwardSdkShareProcessor.this;
            if (forwardSdkShareProcessor4.mServiceType == 2 && HttpUtil.isValidUrl(forwardSdkShareProcessor4.mAudioUrl)) {
                ForwardSdkShareProcessor forwardSdkShareProcessor5 = ForwardSdkShareProcessor.this;
                forwardSdkShareProcessor5.mUrlMap.put("audioUrl", forwardSdkShareProcessor5.mAudioUrl);
            }
            if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mRemoteImgUrl)) {
                ForwardSdkShareProcessor forwardSdkShareProcessor6 = ForwardSdkShareProcessor.this;
                forwardSdkShareProcessor6.mRemoteImgUrl = forwardSdkShareProcessor6.mAppInfo.sourceIconBig;
                forwardSdkShareProcessor6.mIsImgUrlShort.set(false);
                QLog.i(ForwardSdkShareProcessor.STAG, 1, "UrlExchangeStep|use app icon:" + ForwardSdkShareProcessor.this.mRemoteImgUrl);
                Bundle bundle = new Bundle();
                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                bundle.putString("act_type", "18");
                if (TextUtils.isEmpty(ForwardSdkShareProcessor.this.mRemoteImgUrl)) {
                    str = "1";
                } else {
                    str = "0";
                }
                bundle.putString("intext_1", str);
                ReportCenter.f().m(bundle, "" + ForwardSdkShareProcessor.this.mAppId, ForwardSdkShareProcessor.this.app.getCurrentUin(), false, ForwardSdkShareProcessor.this.isSdkShare());
            }
            if (!ForwardSdkShareProcessor.this.mIsImgUrlShort.get() && HttpUtil.isValidUrl(ForwardSdkShareProcessor.this.mRemoteImgUrl)) {
                ForwardSdkShareProcessor forwardSdkShareProcessor7 = ForwardSdkShareProcessor.this;
                forwardSdkShareProcessor7.mUrlMap.put("imageUrl", forwardSdkShareProcessor7.mRemoteImgUrl);
            }
            qlog("UrlExchangeStep|process|url=" + ForwardSdkShareProcessor.this.mUrlMap.toString());
            if (ForwardSdkShareProcessor.this.mUrlMap.isEmpty()) {
                ForwardSdkShareProcessor.this.mIsAllUrlShort.set(true);
                doNextStep();
            } else {
                ThreadManagerV2.excute(buildJob(), 128, null, true);
            }
        }

        protected void qlog(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else if (QLog.isColorLevel()) {
                QLog.d(ForwardSdkShareProcessor.STAG, 2, str);
            }
        }
    }

    public ForwardSdkShareProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mIsThumbReady = new AtomicBoolean(false);
        this.mIsImgUrlShort = new AtomicBoolean(false);
        this.mIsAllUrlShort = new AtomicBoolean(false);
        this.mRefreshTicket = false;
        this.mUrlMap = new HashMap<>();
        this.mRetryCount = 0;
        this.mStartTime = 0L;
        QQAppInterface qQAppInterface = (QQAppInterface) super.app;
        this.app = qQAppInterface;
        this.mAppContext = qQAppInterface.getApp().getApplicationContext();
        Object obj = this.mUiRequest.mExtraObj;
        if (obj instanceof TransferRequest.ShareExtraInfo) {
            TransferRequest.ShareExtraInfo shareExtraInfo = (TransferRequest.ShareExtraInfo) obj;
            this.mForwardType = shareExtraInfo.forwardType;
            this.mServiceType = shareExtraInfo.serviceType;
            this.mTargetUrl = shareExtraInfo.targetUrl;
            this.mShareTitle = shareExtraInfo.title;
            this.mShareSummary = shareExtraInfo.summary;
            this.mAudioUrl = shareExtraInfo.audioUrl;
            this.mAppId = shareExtraInfo.appId;
            this.mPkgName = shareExtraInfo.pkgName;
            this.mAppInfo = shareExtraInfo.appInfo;
            if (shareExtraInfo.imageUrlStatus == 2) {
                this.mLocalImgUrl = shareExtraInfo.imageUrl;
            } else {
                this.mRemoteImgUrl = shareExtraInfo.imageUrl;
            }
            QLog.i(BaseTransProcessor.TAG, 1, "forwardShare info.imageUrlStatus =" + shareExtraInfo.imageUrlStatus + ",mRemoteImgUrl=" + this.mRemoteImgUrl);
            AtomicBoolean atomicBoolean = this.mIsThumbReady;
            int i3 = shareExtraInfo.imageUrlStatus;
            if (i3 != 1 && i3 != 3) {
                z16 = false;
            } else {
                z16 = true;
            }
            atomicBoolean.set(z16);
            AtomicBoolean atomicBoolean2 = this.mIsImgUrlShort;
            if (shareExtraInfo.imageUrlStatus == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            atomicBoolean2.set(z17);
            this.mIsAllUrlShort.set(shareExtraInfo.shortUrlStatus == 1);
            return;
        }
        QLog.i(BaseTransProcessor.TAG, 1, "mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo : false");
    }

    public static TransferRequest buildTransferRequest(MessageRecord messageRecord, JSONObject jSONObject, ad adVar) {
        TransferRequest.ShareExtraInfo shareExtraInfo = new TransferRequest.ShareExtraInfo();
        shareExtraInfo.forwardType = jSONObject.optInt("forward_type");
        shareExtraInfo.serviceType = jSONObject.optInt("serviceType");
        shareExtraInfo.appId = jSONObject.optLong("appId");
        shareExtraInfo.pkgName = jSONObject.optString("pkg_name");
        shareExtraInfo.targetUrl = jSONObject.optString("targetUrl");
        shareExtraInfo.title = jSONObject.optString("title");
        shareExtraInfo.summary = jSONObject.optString("summary");
        shareExtraInfo.imageUrl = jSONObject.optString("image_url");
        shareExtraInfo.audioUrl = jSONObject.optString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        shareExtraInfo.imageUrlStatus = jSONObject.optInt("imageUrlStatus");
        shareExtraInfo.shortUrlStatus = jSONObject.optInt("shortUrlStatus");
        TransferRequest.AppInfo appInfo = new TransferRequest.AppInfo();
        shareExtraInfo.appInfo = appInfo;
        appInfo.sourceName = jSONObject.optString("appInfo_sourceName");
        shareExtraInfo.appInfo.sourceIconSmall = jSONObject.optString("appInfo_sourceIconSmall");
        shareExtraInfo.appInfo.sourceIconBig = jSONObject.optString("appInfo_sourceIconBig");
        shareExtraInfo.appInfo.sourceUrl = jSONObject.optString("appInfo_sourceUrl");
        shareExtraInfo.appInfo.packName = jSONObject.optString("appInfo_packName");
        shareExtraInfo.appInfo.status = jSONObject.optInt("appInfo_status");
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = messageRecord.selfuin;
        transferRequest.mPeerUin = messageRecord.frienduin;
        transferRequest.mUinType = messageRecord.istroop;
        transferRequest.mFileType = 52;
        transferRequest.mUniseq = messageRecord.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = 11;
        transferRequest.needSendMsg = false;
        transferRequest.mExtraObj = shareExtraInfo;
        transferRequest.mUpCallBack = adVar;
        return transferRequest;
    }

    public static TransferRequest buildTransferRequestFromMessage(MessageRecord messageRecord, AbsShareMsg absShareMsg) {
        TransferRequest.ShareExtraInfo shareExtraInfo = new TransferRequest.ShareExtraInfo();
        shareExtraInfo.forwardType = absShareMsg.forwardType;
        shareExtraInfo.serviceType = absShareMsg.mMsgServiceID;
        shareExtraInfo.appId = absShareMsg.mSourceAppid;
        AbsShareMsg.ShareData shareData = absShareMsg.shareData;
        shareExtraInfo.pkgName = shareData.pkgName;
        shareExtraInfo.targetUrl = absShareMsg.mMsgUrl;
        shareExtraInfo.title = absShareMsg.mContentTitle;
        shareExtraInfo.summary = absShareMsg.mContentSummary;
        shareExtraInfo.imageUrl = absShareMsg.mContentCover;
        shareExtraInfo.audioUrl = absShareMsg.mContentSrc;
        shareExtraInfo.imageUrlStatus = shareData.imageUrlStatus;
        shareExtraInfo.shortUrlStatus = shareData.shortUrlStatus;
        TransferRequest.AppInfo appInfo = new TransferRequest.AppInfo();
        shareExtraInfo.appInfo = appInfo;
        appInfo.sourceName = absShareMsg.mSourceName;
        appInfo.sourceIconSmall = absShareMsg.mSourceIcon;
        AbsShareMsg.ShareData shareData2 = absShareMsg.shareData;
        appInfo.sourceIconBig = shareData2.sourceIconBig;
        appInfo.sourceUrl = absShareMsg.mSourceUrl;
        appInfo.packName = absShareMsg.mSource_A_ActionData;
        appInfo.status = shareData2.appInfoStatus;
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = messageRecord.selfuin;
        transferRequest.mPeerUin = messageRecord.frienduin;
        transferRequest.mUinType = messageRecord.istroop;
        transferRequest.mFileType = 52;
        transferRequest.mUniseq = messageRecord.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = 11;
        transferRequest.needSendMsg = false;
        transferRequest.mExtraObj = shareExtraInfo;
        return transferRequest;
    }

    public static TransferRequest buildTransferRequestFromMessageExtra(MessageRecord messageRecord, AbsShareMsg absShareMsg, ad adVar) {
        TransferRequest buildTransferRequestFromMessage = buildTransferRequestFromMessage(messageRecord, absShareMsg);
        buildTransferRequestFromMessage.mUpCallBack = adVar;
        return buildTransferRequestFromMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerRetry() {
        if (this.mIsCancel) {
            return;
        }
        ForwardStep forwardStep = this.mSendMsgStep;
        if (forwardStep != null) {
            forwardStep.cancel();
        }
        ForwardStep forwardStep2 = this.mSendMsgByServerStep;
        if (forwardStep2 != null) {
            forwardStep2.cancel();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ForwardSdkShareProcessor.this.start();
                }
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        QLog.d(STAG, 1, "cancel");
        super.cancel();
        ForwardStep forwardStep = this.mSendMsgStep;
        if (forwardStep != null) {
            forwardStep.cancel();
        }
        ForwardStep forwardStep2 = this.mSendMsgByServerStep;
        if (forwardStep2 != null) {
            forwardStep2.cancel();
        }
        QQMessageFacade messageFacade = this.app.getMessageFacade();
        TransferRequest transferRequest = this.mUiRequest;
        messageFacade.Z0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq, 32768, AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL);
        sendMessageToUpdate(1004);
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (!(this.mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo)) {
            QLog.w(STAG, 1, "checkParam|SdkShareInfo null");
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("SdkShareInfo null")), null, null);
            onError();
            return -1;
        }
        if (TextUtils.isEmpty(this.mTargetUrl)) {
            QLog.w(STAG, 1, "checkParam|share targetUrl null");
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("share targetUrl null")), null, null);
            onError();
            return -1;
        }
        if (this.mAppInfo == null) {
            QLog.w(STAG, 1, "checkParam|mAppInfo null");
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("mAppInfo null")), null, null);
            onError();
            return -1;
        }
        if (!ForwardUtils.M(this.mForwardType, this.mServiceType)) {
            String str = "err forwardType=" + this.mForwardType + ",serviceType=" + this.mServiceType;
            QLog.w(STAG, 1, "checkParam|" + str);
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception(str)), null, null);
            onError();
            return -1;
        }
        return 0;
    }

    public boolean isSdkShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.mForwardType == 11) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        QLog.e(STAG, 1, "On Error, code=" + this.mProcessorReport.errCode + ", cost=" + currentTimeMillis);
        super.onError();
        ForwardStep forwardStep = this.mSendMsgStep;
        if (forwardStep != null) {
            forwardStep.cancel();
        }
        ForwardStep forwardStep2 = this.mSendMsgByServerStep;
        if (forwardStep2 != null) {
            forwardStep2.cancel();
        }
        ad.a aVar = new ad.a();
        aVar.f258597a = -1;
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null && transferRequest.mUpCallBack != null) {
            if (isSdkShare() && this.mProcessorReport.errCode == 9402 && !BaseForwardUtil.b(this.mAppContext)) {
                String str = this.mUrlMap.get("audioUrl");
                String[] strArr = new String[2];
                strArr[0] = this.mRemoteImgUrl;
                if (TextUtils.isEmpty(str)) {
                    str = this.mAudioUrl;
                }
                strArr[1] = str;
                aVar.f258608l = strArr;
                aVar.f258598b = this.mProcessorReport.errCode;
            }
            this.mUiRequest.mUpCallBack.q(aVar);
        }
        if (isSdkShare()) {
            QLog.d(STAG, 1, "SDK_SHARE onError");
        } else {
            if (this.mUiRequest != null) {
                QQMessageFacade messageFacade = this.app.getMessageFacade();
                TransferRequest transferRequest2 = this.mUiRequest;
                messageFacade.Z0(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq, 32768, this.mProcessorReport.errCode);
            }
            sendMessageToUpdate(1005);
        }
        Bundle bundle = new Bundle();
        bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle.putString("act_type", "56");
        bundle.putString("intext_1", "" + this.mProcessorReport.errCode);
        bundle.putString("intext_5", "" + currentTimeMillis);
        ReportCenter.f().m(bundle, "" + this.mAppId, this.app.getCurrentUin(), false, isSdkShare());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        QLog.d(STAG, 1, "OnSuccess, cost=" + currentTimeMillis);
        QQMessageFacade messageFacade = this.app.getMessageFacade();
        TransferRequest transferRequest = this.mUiRequest;
        MessageRecord w06 = messageFacade.w0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
        if (w06 != null && (w06 instanceof MessageForStructing)) {
            AbsStructMsg absStructMsg = ((MessageForStructing) w06).structingMsg;
            if (absStructMsg instanceof AbsShareMsg) {
                AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                absShareMsg.shareData.status = 1003;
                absShareMsg.forwardType = 0;
                QQMessageFacade messageFacade2 = this.app.getMessageFacade();
                TransferRequest transferRequest2 = this.mUiRequest;
                messageFacade2.Y0(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq, absShareMsg.getBytes());
            }
        }
        super.onSuccess();
        Bundle bundle = new Bundle();
        bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle.putString("act_type", "56");
        bundle.putString("intext_1", "0");
        bundle.putString("intext_5", "" + currentTimeMillis);
        ReportCenter.f().m(bundle, "" + this.mAppId, this.app.getCurrentUin(), false, isSdkShare());
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i(STAG, 1, "pause");
        if (!this.mIsPause) {
            this.mIsPause = true;
            ForwardStep forwardStep = this.mSendMsgStep;
            if (forwardStep != null) {
                forwardStep.cancel();
            }
            ForwardStep forwardStep2 = this.mSendMsgByServerStep;
            if (forwardStep2 != null) {
                forwardStep2.cancel();
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        QLog.i(STAG, 1, "resume");
        if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            start();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i(STAG, 1, "start");
        this.mSendMsgStep = new SendMsgStep();
        this.mSendMsgByServerStep = new SendMsgByServerStep();
        ForwardStep urlExchangeStep = new UrlExchangeStep();
        if (isSdkShare()) {
            this.mSendMsgByServerStep.setLastSteps(new ForwardStep[]{urlExchangeStep});
        } else {
            this.mSendMsgStep.setLastSteps(new ForwardStep[]{urlExchangeStep});
        }
        GetAppInfoStep getAppInfoStep = new GetAppInfoStep();
        ForwardStep imageUploadStep = new ImageUploadStep();
        if (!urlExchangeStep.isFinished() && imageUploadStep.isFinished()) {
            urlExchangeStep.setLastSteps(new ForwardStep[]{getAppInfoStep});
        } else {
            urlExchangeStep.setLastSteps(new ForwardStep[]{imageUploadStep});
            RichStep richStep = new RichStep();
            this.mRichStep = richStep;
            imageUploadStep.setLastSteps(new ForwardStep[]{getAppInfoStep, richStep});
        }
        this.mStartTime = System.currentTimeMillis();
        if (isSdkShare()) {
            this.mSendMsgByServerStep.doStep();
            return;
        }
        this.mSendMsgStep.doStep();
        sendMessageToUpdate(1001);
        sendMessageToUpdateDelay(1002, MessageHandler.f194802e0);
    }
}
