package com.tencent.mobileqq.pic.operator;

import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.n;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.pic.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GuildPicDownloadProcessor;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.UrlDownloader;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes16.dex */
public class DownloadPicOperator extends BasePicOperator implements com.tencent.mobileqq.pic.c {
    static IPatchRedirector $redirector_;
    com.tencent.mobileqq.pic.c E;
    private TransferResult F;

    public DownloadPicOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.E = this;
        }
    }

    private void B(TransferRequest transferRequest, BaseTransProcessor baseTransProcessor) {
        try {
            if (transferRequest.mResult.mResult == -2) {
                RichMediaUtil.log(transferRequest.mUinType, transferRequest.mIsUp, transferRequest.mFileType, String.valueOf(transferRequest.mUniseq), "callwait", "");
                LockMethodProxy.wait(baseTransProcessor);
                RichMediaUtil.log(transferRequest.mUinType, transferRequest.mIsUp, transferRequest.mFileType, String.valueOf(transferRequest.mUniseq), "waitfin", "");
            }
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    private void D(c.a aVar) {
        MessageForPic messageForPic;
        if (aVar != null && (messageForPic = this.f258751f.H) != null && aVar.f258658e != null) {
            File file = new File(aVar.f258658e);
            if (messageForPic.imageType != 2000 && GifDrawable.isGifFile(file)) {
                messageForPic.imageType = 2000;
                messageForPic.serial();
                if (messageForPic.subMsgId == MessageForPic.defaultSuMsgId) {
                    MessageRecord queryMsgItemByUniseq = ((IMessageFacade) this.f258754m.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq);
                    if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(queryMsgItemByUniseq)) {
                        ((IMsgStructing) QRoute.api(IMsgStructing.class)).updateMsgAfterDownload(this.f258754m, queryMsgItemByUniseq, messageForPic);
                        return;
                    } else {
                        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "onDownload", "Update GIF flag of MessageForPic");
                        ((IMessageFacade) this.f258754m.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq, messageForPic.msgData);
                        return;
                    }
                }
                MessageRecord queryMsgItemByUniseq2 = ((IMessageFacade) this.f258754m.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq);
                if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(queryMsgItemByUniseq2)) {
                    ((IMsgMixed) QRoute.api(IMsgMixed.class)).updateMsgAfterDownload(this.f258754m, queryMsgItemByUniseq2, messageForPic);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d8, code lost:
    
        r5.put(r19, r18);
        r18.setKey(r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e2, code lost:
    
        if (r18.checkParam() != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e4, code lost:
    
        com.tencent.mobileqq.pic.n.m(r16.f258754m, r17);
        r18.start();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ec, code lost:
    
        if (r20 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ee, code lost:
    
        com.tencent.mobileqq.transfile.RichMediaUtil.log(r17.mUinType, r17.mIsUp, r17.mFileType, java.lang.String.valueOf(r17.mUniseq), "callwait", "");
        com.tencent.mobileqq.perf.block.LockMethodProxy.wait(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0107, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0108, code lost:
    
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void A(TransferRequest transferRequest, BaseTransProcessor baseTransProcessor, String str, boolean z16) {
        String str2;
        if (z16) {
            str2 = "sync ";
        } else {
            str2 = "aync ";
        }
        if (z16) {
            ((PicPreDownloadImpl) this.f258754m.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader.q(str);
        }
        ConcurrentHashMap<String, IHttpCommunicatorListener> processMap = ((ITransFileController) this.f258754m.getRuntimeService(ITransFileController.class, "")).getProcessMap();
        IHttpCommunicatorListener iHttpCommunicatorListener = processMap.get(str);
        if (iHttpCommunicatorListener != null) {
            if (iHttpCommunicatorListener instanceof BaseDownloadProcessor) {
                BaseDownloadProcessor baseDownloadProcessor = (BaseDownloadProcessor) iHttpCommunicatorListener;
                synchronized (baseDownloadProcessor) {
                    long fileStatus = baseDownloadProcessor.getFileStatus();
                    TransferRequest transferRequest2 = baseDownloadProcessor.getTransferRequest();
                    RichMediaUtil.log(transferRequest.mUinType, transferRequest.mIsUp, transferRequest.mFileType, String.valueOf(transferRequest.mUniseq), str2 + "startDownloadProcessor", "status:" + fileStatus + ",key:" + str);
                    if (fileStatus != -1 && fileStatus != 2002 && fileStatus != 2001) {
                        if (fileStatus != 2004 && fileStatus != 2005) {
                            if (fileStatus == 2003) {
                                transferRequest.mResult = transferRequest2.mResult;
                                if (transferRequest.mDownCallBack != null) {
                                    c.a aVar = new c.a();
                                    aVar.f258654a = 0;
                                    aVar.f258658e = transferRequest.mOutFilePath;
                                    aVar.f258660g = transferRequest.mMd5;
                                    aVar.f258661h = transferRequest.mFileType;
                                    aVar.f258662i = transferRequest.mDownMode;
                                    transferRequest.mDownCallBack.h(aVar);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    transferRequest.mResult = transferRequest2.mResult;
                    com.tencent.mobileqq.pic.c cVar = transferRequest.mDownCallBack;
                    if (cVar != null) {
                        baseDownloadProcessor.mDownCallBacks.add(cVar);
                    }
                    if (z16) {
                        B(transferRequest, baseDownloadProcessor);
                    }
                    return;
                }
            }
            return;
        }
        RichMediaUtil.log(transferRequest.mUinType, transferRequest.mIsUp, transferRequest.mFileType, String.valueOf(transferRequest.mUniseq), str2 + "startDownloadProcessor", "firs time ,key:" + str);
        processMap.put(str, baseTransProcessor);
        baseTransProcessor.setKey(str);
        if (baseTransProcessor.checkParam() == 0) {
            n.m(this.f258754m, transferRequest);
            baseTransProcessor.start();
            if (z16) {
                synchronized (baseTransProcessor) {
                    B(transferRequest, baseTransProcessor);
                }
            }
        }
    }

    void C(com.tencent.mobileqq.pic.k kVar, TransferRequest transferRequest, TransferRequest.PicDownExtraInfo picDownExtraInfo) {
        int i3 = transferRequest.mFileType;
        if (i3 == 65537) {
            ReportInfo reportInfo = kVar.f258728e0;
            if (reportInfo != null) {
                reportInfo.f258586i = kVar.f258727d0;
                reportInfo.f258585h = com.tencent.mobileqq.pic.a.a();
                ReportInfo reportInfo2 = kVar.f258728e0;
                long currentTimeMillis = System.currentTimeMillis();
                ReportInfo reportInfo3 = kVar.f258728e0;
                reportInfo2.f258587m = currentTimeMillis - reportInfo3.f258583e;
                reportInfo3.f258582d = 1;
            }
            picDownExtraInfo.mUrlFromMsg = kVar.M;
            return;
        }
        if (i3 == 1) {
            picDownExtraInfo.mUrlFromMsg = kVar.N;
            ReportInfo reportInfo4 = kVar.f258728e0;
            if (reportInfo4 != null) {
                reportInfo4.C = kVar.f258727d0;
                reportInfo4.E = com.tencent.mobileqq.pic.a.a();
                ReportInfo reportInfo5 = kVar.f258728e0;
                long currentTimeMillis2 = System.currentTimeMillis();
                ReportInfo reportInfo6 = kVar.f258728e0;
                reportInfo5.D = currentTimeMillis2 - reportInfo6.f258583e;
                reportInfo6.f258582d = 2;
                return;
            }
            return;
        }
        if (i3 == 131075) {
            picDownExtraInfo.mUrlFromMsg = kVar.P;
            ReportInfo reportInfo7 = kVar.f258728e0;
            if (reportInfo7 != null) {
                reportInfo7.C = kVar.f258727d0;
                reportInfo7.E = com.tencent.mobileqq.pic.a.a();
                ReportInfo reportInfo8 = kVar.f258728e0;
                long currentTimeMillis3 = System.currentTimeMillis();
                ReportInfo reportInfo9 = kVar.f258728e0;
                reportInfo8.D = currentTimeMillis3 - reportInfo9.f258583e;
                reportInfo9.f258582d = 2;
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.c
    public void a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        q qVar = new q();
        qVar.f258790a = 0;
        qVar.f258793d = Integer.valueOf(i3);
        qVar.f258796g = z16;
        e(1, 0, qVar);
    }

    @Override // com.tencent.mobileqq.pic.c
    public void h(c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        if (this.f258751f != null) {
            D(aVar);
            z(aVar);
            if (aVar == null) {
                m.a aVar2 = new m.a();
                aVar2.f258737b = "result == null";
                aVar2.f258736a = "onDownload";
                c(0, aVar2);
                return;
            }
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "onDownload", "result:" + aVar.f258654a);
            q qVar = new q();
            int i3 = aVar.f258654a;
            qVar.f258790a = i3;
            qVar.f258793d = aVar;
            qVar.f258794e = aVar.f258663j;
            if (i3 == 0) {
                d(0, qVar);
                return;
            }
            m.a aVar3 = aVar.f258657d;
            if (aVar3 == null) {
                m.a aVar4 = new m.a();
                aVar4.f258737b = aVar.f258655b + "_" + aVar.f258656c;
                aVar4.f258736a = "onDownload";
                c(0, aVar4);
                return;
            }
            c(0, aVar3);
        }
    }

    @Override // com.tencent.mobileqq.pic.operator.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        p pVar = this.f258751f;
        if (pVar.J == 1280) {
            x(pVar);
        } else {
            v(pVar);
        }
    }

    boolean p(com.tencent.mobileqq.pic.k kVar) {
        if (kVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "checkPicDownloadInfo", "info:" + kVar);
            return kVar.b();
        }
        com.tencent.mobileqq.pic.f.e(this.f258750e, this.f258749d, "checkPicDownloadInfo", "info == null");
        return false;
    }

    TransferRequest s(com.tencent.mobileqq.pic.k kVar, String str) {
        boolean z16;
        MessageForPic messageForPic;
        kVar.f258714i = this.f258754m.getCurrentAccountUin();
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = false;
        transferRequest.mUinType = kVar.f258713h;
        if (kVar.R == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        transferRequest.mFileType = ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(str, z16);
        transferRequest.mUniseq = kVar.D;
        transferRequest.mSubMsgId = kVar.f258724a0;
        transferRequest.mSelfUin = kVar.f258714i;
        transferRequest.mPeerUin = kVar.f258715m;
        transferRequest.mServerPath = kVar.K;
        transferRequest.mLocalPath = null;
        transferRequest.mDownCallBack = this.E;
        transferRequest.useOutputstream = false;
        transferRequest.bEnableEnc = kVar.f258729f0;
        transferRequest.mOutFilePath = kVar.d();
        p pVar = this.f258751f;
        if (pVar != null && (messageForPic = pVar.H) != null) {
            transferRequest.mRec = messageForPic;
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "convert2TranferRequest", "outFilePath:" + transferRequest.mOutFilePath + "info.protocol:" + kVar.I);
        TransferRequest.PicDownExtraInfo picDownExtraInfo = new TransferRequest.PicDownExtraInfo();
        transferRequest.mExtraObj = picDownExtraInfo;
        C(kVar, transferRequest, picDownExtraInfo);
        transferRequest.mMd5 = kVar.J;
        transferRequest.mGroupFileID = kVar.L;
        transferRequest.mDbRecVersion = kVar.G;
        transferRequest.mBusiType = kVar.f258712f;
        transferRequest.mNeedReport = true;
        transferRequest.mDownMode = kVar.f258727d0;
        transferRequest.mMsgTime = kVar.S;
        transferRequest.mIsOnlyGetUrl = kVar.f258726c0;
        String str2 = kVar.f258725b0;
        if (str2 != null && kVar.f258713h == 10014) {
            transferRequest.mExtentionInfo = str2.getBytes();
            transferRequest.mSecondId = kVar.C;
            transferRequest.extraObject = kVar.F;
        }
        return transferRequest;
    }

    TransferRequest t(p pVar) {
        com.tencent.mobileqq.pic.k kVar = pVar.f258788m;
        if (!p(kVar)) {
            c.a aVar = new c.a();
            aVar.f258654a = -1;
            aVar.f258657d = kVar.f258735d;
            this.E.h(aVar);
            return null;
        }
        MessageForPic messageForPic = pVar.H;
        int i3 = pVar.J;
        TransferRequest s16 = s(kVar, kVar.I);
        String str = s16.mOutFilePath;
        long length = new File(str).length();
        int i16 = 0;
        if (1537 == i3 && length > 0 && length < pVar.H.size) {
            c.a aVar2 = new c.a();
            aVar2.f258654a = 0;
            aVar2.f258658e = s16.mOutFilePath;
            aVar2.f258660g = s16.mMd5;
            aVar2.f258661h = s16.mFileType;
            aVar2.f258662i = kVar.f258727d0;
            aVar2.f258663j = true;
            this.E.h(aVar2);
            if (QLog.isDevelopLevel()) {
                QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
            }
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        if (length == 0) {
            s16.mRequestOffset = 0;
            int i17 = messageForPic.mDownloadLength;
            if (i17 == pVar.H.size) {
                s16.mRequestLength = 0;
            } else {
                if (i3 != 1536) {
                    i16 = i17;
                }
                s16.mRequestLength = i16;
            }
            sb5.append("nofile:");
        } else if (length < pVar.H.size) {
            s16.mRequestOffset = messageForPic.mDownloadLength;
            s16.mRequestLength = 0;
            sb5.append("part1:");
        } else {
            c.a aVar3 = new c.a();
            aVar3.f258654a = 0;
            aVar3.f258658e = s16.mOutFilePath;
            aVar3.f258660g = s16.mMd5;
            aVar3.f258661h = s16.mFileType;
            aVar3.f258662i = kVar.f258727d0;
            aVar3.f258663j = false;
            this.E.h(aVar3);
            if (QLog.isDevelopLevel()) {
                QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
            }
            return null;
        }
        sb5.append("mRequestOffset is " + s16.mRequestOffset + ", mRequestLength is " + s16.mRequestLength + ", ");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("outPath is ");
        sb6.append(str);
        sb5.append(sb6.toString());
        if (QLog.isDevelopLevel()) {
            QLog.d("peak_pgjpeg", 4, sb5.toString());
        }
        s16.mRequestDisplayLength = messageForPic.mShowLength;
        s16.mDisplayOutFilePath = kVar.g();
        if (!TextUtils.isEmpty(this.f258754m.getAccount())) {
            u((ITransFileController) this.f258754m.getRuntimeService(ITransFileController.class, ""), s16);
        }
        return s16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransferResult u(ITransFileController iTransFileController, TransferRequest transferRequest) {
        BaseTransProcessor groupPicDownloadProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TransferResult) iPatchRedirector.redirect((short) 6, (Object) this, (Object) iTransFileController, (Object) transferRequest);
        }
        transferRequest.mIsUp = false;
        transferRequest.mResult = new TransferResult();
        AtomicBoolean isWorking = iTransFileController.isWorking();
        if (isWorking.get()) {
            synchronized (iTransFileController.isWorking()) {
                if (isWorking.get() && this.f258754m != null) {
                    try {
                        if (transferRequest.mFileType == 131076) {
                            groupPicDownloadProcessor = new UrlDownloader((BaseTransFileController) iTransFileController, transferRequest);
                        } else {
                            int i3 = transferRequest.mUinType;
                            if (i3 != 1 && i3 != 3000) {
                                if (i3 == 10014) {
                                    groupPicDownloadProcessor = new GuildPicDownloadProcessor((BaseTransFileController) iTransFileController, transferRequest);
                                } else {
                                    groupPicDownloadProcessor = new C2CPicDownloadProcessor((BaseTransFileController) iTransFileController, transferRequest);
                                }
                            }
                            groupPicDownloadProcessor = new GroupPicDownloadProcessor((BaseTransFileController) iTransFileController, transferRequest);
                        }
                        A(transferRequest, groupPicDownloadProcessor, BaseTransFileController.makeReceiveKey(transferRequest), false);
                    } catch (NullPointerException unused) {
                        TransferResult transferResult = transferRequest.mResult;
                        transferResult.mResult = -1;
                        transferResult.mErrCode = 9366L;
                        transferResult.mErrDesc = "transfilecontroller closed";
                        return transferResult;
                    }
                } else {
                    TransferResult transferResult2 = transferRequest.mResult;
                    transferResult2.mResult = -1;
                    transferResult2.mErrCode = 9366L;
                    transferResult2.mErrDesc = "transfilecontroller closed";
                    return transferResult2;
                }
            }
        } else {
            TransferResult transferResult3 = transferRequest.mResult;
            transferResult3.mResult = -1;
            transferResult3.mErrCode = 9366L;
            transferResult3.mErrDesc = "transfilecontroller closed";
        }
        return transferRequest.mResult;
    }

    public void v(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pVar);
            return;
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "downloadPic", "start " + Thread.currentThread().getId());
        com.tencent.mobileqq.pic.k kVar = pVar.f258788m;
        if (p(kVar)) {
            this.f258749d += "|" + kVar.D;
            if (!kVar.I.equals(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE)) {
                TransferRequest s16 = s(kVar, kVar.I);
                if (!new File(s16.mOutFilePath).exists()) {
                    u((ITransFileController) this.f258754m.getRuntimeService(ITransFileController.class, ""), s16);
                    return;
                }
                c.a aVar = new c.a();
                aVar.f258654a = 0;
                aVar.f258658e = s16.mOutFilePath;
                aVar.f258660g = s16.mMd5;
                aVar.f258661h = s16.mFileType;
                aVar.f258662i = kVar.f258727d0;
                this.E.h(aVar);
                return;
            }
            t(pVar);
            return;
        }
        c.a aVar2 = new c.a();
        aVar2.f258654a = -1;
        aVar2.f258657d = kVar.f258735d;
        this.E.h(aVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransferResult w(ITransFileController iTransFileController, TransferRequest transferRequest) {
        BaseTransProcessor groupPicDownloadProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TransferResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) iTransFileController, (Object) transferRequest);
        }
        transferRequest.mIsUp = false;
        transferRequest.mResult = new TransferResult();
        if (iTransFileController.isWorking().get()) {
            if (transferRequest.mFileType == 131076) {
                groupPicDownloadProcessor = new UrlDownloader((BaseTransFileController) iTransFileController, transferRequest);
            } else {
                int i3 = transferRequest.mUinType;
                if (i3 != 1 && i3 != 3000) {
                    if (i3 == 10014) {
                        groupPicDownloadProcessor = new GuildPicDownloadProcessor((BaseTransFileController) iTransFileController, transferRequest);
                    } else {
                        groupPicDownloadProcessor = new C2CPicDownloadProcessor((BaseTransFileController) iTransFileController, transferRequest);
                    }
                } else {
                    groupPicDownloadProcessor = new GroupPicDownloadProcessor((BaseTransFileController) iTransFileController, transferRequest);
                }
            }
            A(transferRequest, groupPicDownloadProcessor, BaseTransFileController.makeReceiveKey(transferRequest), true);
        } else {
            TransferResult transferResult = transferRequest.mResult;
            transferResult.mResult = -1;
            transferResult.mErrCode = 9366L;
            transferResult.mErrDesc = "transfilecontroller closed";
        }
        return transferRequest.mResult;
    }

    void x(p pVar) {
        com.tencent.mobileqq.pic.k kVar = pVar.f258788m;
        String str = kVar.I;
        Object obj = pVar.N;
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "downloadPicSync", "start " + Thread.currentThread().getId());
        if (p(kVar)) {
            this.f258749d += "|" + kVar.D;
            ITransFileController iTransFileController = (ITransFileController) this.f258754m.getRuntimeService(ITransFileController.class, "");
            TransferRequest s16 = s(kVar, str);
            Object obj2 = s16.mExtraObj;
            if (obj2 != null && (obj2 instanceof TransferRequest.PicDownExtraInfo) && obj != null && (obj instanceof URLDrawableHandler)) {
                ((TransferRequest.PicDownExtraInfo) obj2).mHandler = (URLDrawableHandler) obj;
            }
            this.F = w(iTransFileController, s16);
            return;
        }
        c.a aVar = new c.a();
        aVar.f258654a = -1;
        aVar.f258657d = kVar.f258735d;
        this.E.h(aVar);
        TransferResult transferResult = new TransferResult();
        transferResult.mResult = -1;
        transferResult.mErrCode = 9302L;
        if (kVar.f258735d != null) {
            transferResult.mErrDesc = "downloadPicSync," + kVar.f258735d.f258737b;
        } else {
            transferResult.mErrDesc = "downloadPicSync param check error";
        }
        this.F = transferResult;
    }

    public TransferResult y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TransferResult) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.F;
    }

    void z(c.a aVar) {
        ThreadManagerV2.excute(new Runnable(aVar) { // from class: com.tencent.mobileqq.pic.operator.DownloadPicOperator.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c.a f258741d;

            {
                this.f258741d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadPicOperator.this, (Object) aVar);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
            
                if (r0 != 131075) goto L27;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                MessageForPic messageForPic;
                s sVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                c.a aVar2 = this.f258741d;
                if (aVar2 != null && (messageForPic = DownloadPicOperator.this.f258751f.H) != null && aVar2.f258658e != null) {
                    File file = new File(this.f258741d.f258658e);
                    if (this.f258741d.f258654a == 0 && (sVar = ((PicPreDownloadImpl) DownloadPicOperator.this.f258754m.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager) != null) {
                        long length = file.length();
                        int i3 = this.f258741d.f258661h;
                        if (i3 != 1) {
                            if (i3 == 65537) {
                                sVar.c(13059, length);
                            }
                        }
                        sVar.c(13060, length);
                        sVar.b(messageForPic);
                    }
                }
                DownloadPicOperator downloadPicOperator = DownloadPicOperator.this;
                com.tencent.mobileqq.pic.f.c(downloadPicOperator.f258750e, downloadPicOperator.f258749d, "processAfterDownload, run", " uniseq:" + DownloadPicOperator.this.f258751f.f258788m.D);
                ((PicPreDownloadImpl) DownloadPicOperator.this.f258754m.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader.x(DownloadPicOperator.this.f258751f, this.f258741d);
            }
        }, 128, null, false);
    }
}
