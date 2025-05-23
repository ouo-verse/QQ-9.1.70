package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.pic.s;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes16.dex */
public class ForwardPicOperator extends d implements com.tencent.mobileqq.pic.c, ad {
    static IPatchRedirector $redirector_;

    public ForwardPicOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean t(l lVar) {
        if (lVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "checkFowardPicInfo", "info:" + lVar);
            return lVar.b();
        }
        com.tencent.mobileqq.pic.f.e(this.f258750e, this.f258749d, "checkFowardPicInfo", "info == null");
        return false;
    }

    private void u(p pVar) {
        ThreadManagerV2.post(new Runnable(pVar.D, pVar) { // from class: com.tencent.mobileqq.pic.operator.ForwardPicOperator.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ l f258742d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ p f258743e;

            {
                this.f258742d = r8;
                this.f258743e = pVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ForwardPicOperator.this, r8, pVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ForwardPicOperator forwardPicOperator = ForwardPicOperator.this;
                com.tencent.mobileqq.pic.f.c(forwardPicOperator.f258750e, forwardPicOperator.f258749d, "doFastForward", "start");
                ForwardPicOperator forwardPicOperator2 = ForwardPicOperator.this;
                MessageRecord messageRecord = forwardPicOperator2.f258752h;
                if (messageRecord == null) {
                    this.f258742d.a("doFastForward", "rec==null");
                    ForwardPicOperator.this.c(4, this.f258742d.f258735d);
                    return;
                }
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                messageForPic.path = this.f258742d.f258731f.K;
                forwardPicOperator2.z(this.f258743e, messageForPic.uniseq);
                PicMessageExtraData picMessageExtraData = this.f258743e.E;
                if (picMessageExtraData != null) {
                    messageForPic.picExtraData = picMessageExtraData;
                }
                boolean z16 = false;
                CompressInfo compressInfo = new CompressInfo(messageForPic.path, 0);
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo);
                String str = compressInfo.H;
                if (str != null) {
                    messageForPic.thumbMsgUrl = str;
                    messageForPic.thumbWidth = compressInfo.I;
                    messageForPic.thumbHeight = compressInfo.J;
                }
                messageForPic.serial();
                ((IMessageFacade) ForwardPicOperator.this.f258754m.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq, messageForPic.msgData);
                TransferRequest transferRequest = new TransferRequest();
                transferRequest.mSelfUin = ForwardPicOperator.this.f258754m.getAccount();
                MessageRecord messageRecord2 = ForwardPicOperator.this.f258752h;
                transferRequest.mPeerUin = messageRecord2.frienduin;
                transferRequest.mSecondId = messageRecord2.senderuin;
                transferRequest.mUinType = messageRecord2.istroop;
                transferRequest.mFileType = 1;
                transferRequest.mUniseq = messageRecord2.uniseq;
                transferRequest.mIsUp = true;
                v vVar = this.f258742d.f258731f;
                transferRequest.mBusiType = vVar.f258712f;
                transferRequest.mLocalPath = vVar.K;
                TransferRequest.PicUpExtraInfo picUpExtraInfo = new TransferRequest.PicUpExtraInfo();
                l lVar = this.f258742d;
                v vVar2 = lVar.f258731f;
                if (vVar2.f258818d0 == 1) {
                    z16 = true;
                }
                picUpExtraInfo.mIsRaw = z16;
                transferRequest.mExtraObj = picUpExtraInfo;
                ForwardPicOperator forwardPicOperator3 = ForwardPicOperator.this;
                transferRequest.mUpCallBack = forwardPicOperator3;
                transferRequest.mIsFastForward = true;
                String str2 = vVar2.J;
                if (str2 != null && vVar2.f258815a0 != 0 && vVar2.f258816b0 != 0 && vVar2.f258817c0 != 0) {
                    transferRequest.mMd5 = str2;
                    com.tencent.mobileqq.pic.f.c(forwardPicOperator3.f258750e, forwardPicOperator3.f258749d, "doFastForward", " Get width/height/filesize from UploadInfo");
                    v vVar3 = this.f258742d.f258731f;
                    transferRequest.mFastForwardWidth = vVar3.f258815a0;
                    transferRequest.mFastForwardHeight = vVar3.f258816b0;
                    transferRequest.mFastForwardFileSize = vVar3.f258817c0;
                    ITransFileController iTransFileController = (ITransFileController) ForwardPicOperator.this.f258754m.getRuntimeService(ITransFileController.class, "");
                    iTransFileController.removeProcessor(transferRequest.mPeerUin + transferRequest.mUniseq);
                    iTransFileController.transferAsync(transferRequest);
                    ForwardPicOperator forwardPicOperator4 = ForwardPicOperator.this;
                    forwardPicOperator4.k(forwardPicOperator4.f258752h, this.f258742d.f258731f.f258831q0);
                    ForwardPicOperator forwardPicOperator5 = ForwardPicOperator.this;
                    com.tencent.mobileqq.pic.f.c(forwardPicOperator5.f258750e, forwardPicOperator5.f258749d, "doFastForward", "end, req.mFastForwardWidth = " + transferRequest.mFastForwardWidth + ",req.mFastForwardHeight = " + transferRequest.mFastForwardHeight);
                    return;
                }
                lVar.a("doFastForward", "upInfo uncomplete!");
                ForwardPicOperator.this.c(4, this.f258742d.f258735d);
            }
        }, 8, null, true);
    }

    private void v(p pVar) {
        ThreadManagerV2.post(new Runnable(pVar) { // from class: com.tencent.mobileqq.pic.operator.ForwardPicOperator.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ p f258744d;

            {
                this.f258744d = pVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPicOperator.this, (Object) pVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                l lVar = this.f258744d.D;
                ForwardPicOperator forwardPicOperator = ForwardPicOperator.this;
                com.tencent.mobileqq.pic.f.c(forwardPicOperator.f258750e, forwardPicOperator.f258749d, "doForward", "start");
                ForwardPicOperator forwardPicOperator2 = ForwardPicOperator.this;
                MessageRecord messageRecord = forwardPicOperator2.f258752h;
                if (messageRecord == null) {
                    lVar.a("doForward", "rec==null");
                    ForwardPicOperator.this.c(4, lVar.f258735d);
                    return;
                }
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                messageForPic.path = lVar.f258731f.K;
                forwardPicOperator2.z(this.f258744d, messageForPic.uniseq);
                PicMessageExtraData picMessageExtraData = this.f258744d.E;
                if (picMessageExtraData != null) {
                    messageForPic.picExtraData = picMessageExtraData;
                }
                boolean z16 = false;
                CompressInfo compressInfo = new CompressInfo(messageForPic.path, 0);
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo);
                String str = compressInfo.H;
                if (str != null) {
                    messageForPic.thumbMsgUrl = str;
                    messageForPic.thumbWidth = compressInfo.I;
                    messageForPic.thumbHeight = compressInfo.J;
                }
                messageForPic.serial();
                ((IMessageFacade) ForwardPicOperator.this.f258754m.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq, messageForPic.msgData);
                TransferRequest transferRequest = new TransferRequest();
                transferRequest.mSelfUin = ForwardPicOperator.this.f258754m.getAccount();
                MessageRecord messageRecord2 = ForwardPicOperator.this.f258752h;
                transferRequest.mPeerUin = messageRecord2.frienduin;
                transferRequest.mSecondId = messageRecord2.senderuin;
                transferRequest.mUinType = messageRecord2.istroop;
                transferRequest.mFileType = 1;
                transferRequest.mUniseq = messageRecord2.uniseq;
                transferRequest.mIsUp = true;
                v vVar = lVar.f258731f;
                transferRequest.mBusiType = vVar.f258712f;
                transferRequest.mLocalPath = vVar.K;
                TransferRequest.PicUpExtraInfo picUpExtraInfo = new TransferRequest.PicUpExtraInfo();
                if (lVar.f258731f.f258818d0 == 1) {
                    z16 = true;
                }
                picUpExtraInfo.mIsRaw = z16;
                transferRequest.mRec = messageForPic;
                transferRequest.mExtraObj = picUpExtraInfo;
                ForwardPicOperator forwardPicOperator3 = ForwardPicOperator.this;
                transferRequest.mUpCallBack = forwardPicOperator3;
                ITransFileController iTransFileController = (ITransFileController) forwardPicOperator3.f258754m.getRuntimeService(ITransFileController.class, "");
                iTransFileController.removeProcessor(transferRequest.mPeerUin + transferRequest.mUniseq);
                iTransFileController.transferAsync(transferRequest);
                ForwardPicOperator forwardPicOperator4 = ForwardPicOperator.this;
                forwardPicOperator4.k(forwardPicOperator4.f258752h, lVar.f258731f.f258831q0);
                ForwardPicOperator forwardPicOperator5 = ForwardPicOperator.this;
                com.tencent.mobileqq.pic.f.c(forwardPicOperator5.f258750e, forwardPicOperator5.f258749d, "doForward", "end");
            }
        }, 8, null, true);
    }

    private void w(p pVar) {
        a l3 = l(pVar);
        if (l3 instanceof DownloadPicOperator) {
            DownloadPicOperator downloadPicOperator = (DownloadPicOperator) l3;
            downloadPicOperator.E = this;
            downloadPicOperator.f258752h = this.f258752h;
            downloadPicOperator.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(p pVar, long j3) {
        long j16;
        MessageForPic messageForPic = pVar.H;
        if (messageForPic != null) {
            j16 = messageForPic.uniseq;
        } else {
            j16 = 0;
        }
        long j17 = j16;
        Integer num = -1;
        MessageForPic messageForPic2 = pVar.H;
        if (messageForPic2 != null) {
            Map<p, Integer> map = messageForPic2.forwardId;
            if (map != null && map.size() > 0) {
                num = map.remove(pVar);
            }
        } else {
            num = Integer.valueOf(pVar.I);
        }
        if (num != null && num.intValue() > 0) {
            ((IForwardOrderManager) QRoute.api(IForwardOrderManager.class)).mapUniSeqId(j3, j17, num.intValue());
        }
    }

    @Override // com.tencent.mobileqq.pic.c
    public void a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 5, (Object) this, (Object) im_msg_body_richtext);
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "attachRichText2Msg", "");
        MessageRecord messageRecord = this.f258752h;
        if (messageRecord != null && (messageRecord instanceof MessageForRichText)) {
            ((MessageForRichText) messageRecord).richText = im_msg_body_richtext;
        }
        return messageRecord;
    }

    @Override // com.tencent.mobileqq.pic.c
    public void h(c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        p pVar = this.f258751f;
        if (pVar != null && pVar.f258783d == 3) {
            if (aVar.f258654a == 0) {
                pVar.D.f258731f.K = aVar.f258658e;
                com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "onDownload", "dowanload pic success,is to forward the pic");
                v(this.f258751f);
                return;
            }
            c(4, pVar.D.f258735d);
        }
    }

    @Override // com.tencent.mobileqq.pic.operator.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            x(this.f258751f);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 7;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            c(3, null);
            return;
        }
        p pVar = this.f258751f;
        if (pVar != null && pVar.f258783d == 3) {
            if (aVar.f258597a == 0) {
                r(aVar);
                s sVar = ((PicPreDownloadImpl) this.f258754m.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager;
                if (sVar != null) {
                    sVar.c(13058, aVar.f258601e);
                }
                q qVar = new q();
                qVar.f258790a = 0;
                qVar.f258793d = aVar;
                d(4, qVar);
                return;
            }
            if (aVar.f258598b == 9333) {
                l lVar = pVar.D;
                com.tencent.mobileqq.pic.k kVar = lVar.f258732h;
                kVar.f258712f = 3;
                kVar.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
                if (lVar.f258731f.f258818d0 != 1) {
                    i3 = 6;
                }
                com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "onSend", "fastForward md5 missed,is to Download the pic");
                ((IMessageFacade) this.f258754m.getRuntimeService(IMessageFacade.class, "")).removeMsgByMessageRecord(this.f258752h, false);
                if (this.f258752h != null) {
                    IOrderMediaMsgService iOrderMediaMsgService = (IOrderMediaMsgService) this.f258754m.getRuntimeService(IOrderMediaMsgService.class, "");
                    MessageRecord messageRecord = this.f258752h;
                    iOrderMediaMsgService.removeMediaMsgByUniseq(messageRecord.frienduin, messageRecord.uniseq);
                }
                p e16 = com.tencent.mobileqq.pic.i.e(i3, 3);
                MessageRecord p16 = p(this.f258751f.D);
                this.f258752h = p16;
                e16.d((MessageForPic) p16, this.f258751f.D.f258732h);
                w(e16);
                return;
            }
            m.a aVar2 = new m.a();
            aVar2.f258737b = aVar.f258599c;
            aVar2.f258736a = String.valueOf(aVar.f258598b);
            c(4, aVar2);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "updateMsg", "resut:" + aVar);
            MessageForPic messageForPic = (MessageForPic) this.f258752h;
            messageForPic.size = aVar.f258601e;
            messageForPic.uuid = aVar.f258602f;
            messageForPic.groupFileID = aVar.f258604h;
            messageForPic.md5 = aVar.f258603g;
            messageForPic.serial();
            IMessageFacade iMessageFacade = (IMessageFacade) this.f258754m.getRuntimeService(IMessageFacade.class, "");
            MessageRecord messageRecord = this.f258752h;
            iMessageFacade.updateMsgContentByUniseq(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, messageForPic.msgData);
        }
    }

    public void x(p pVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pVar);
            return;
        }
        l lVar = pVar.D;
        if (!t(lVar)) {
            c(4, lVar.f258735d);
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(lVar.f258731f.K)) {
            lVar.f258730e = true;
            this.f258752h = p(lVar);
            v(pVar);
            return;
        }
        if (lVar.f258731f.f()) {
            File c16 = lVar.f258731f.c();
            if (c16 != null) {
                lVar.f258731f.K = c16.toString();
            }
            lVar.f258730e = true;
            this.f258752h = p(lVar);
            v(pVar);
            return;
        }
        lVar.f258730e = true;
        this.f258752h = p(lVar);
        v vVar = lVar.f258731f;
        if (vVar.J != null && vVar.f258817c0 != 0 && vVar.f258815a0 != 0 && vVar.f258816b0 != 0) {
            u(pVar);
            return;
        }
        com.tencent.mobileqq.pic.k kVar = lVar.f258732h;
        kVar.f258712f = 3;
        kVar.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
        if (vVar.f258818d0 == 1) {
            i3 = 7;
        } else {
            i3 = 6;
        }
        p e16 = com.tencent.mobileqq.pic.i.e(i3, 3);
        e16.d((MessageForPic) this.f258752h, lVar.f258732h);
        w(e16);
    }

    public l y(Intent intent) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (l) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        }
        if (intent != null && (intent instanceof Intent)) {
            String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            String stringExtra2 = intent.getStringExtra(AppConstants.Key.FORWARD_URL_KEY);
            int intExtra = intent.getIntExtra(AppConstants.Key.FORWARD_UIN_TYPE, -1);
            String stringExtra3 = intent.getStringExtra(AppConstants.Key.SENDER_TROOP_UIN);
            String stringExtra4 = intent.getStringExtra(AppConstants.Key.FORWARD_PEER_UIN);
            String stringExtra5 = intent.getStringExtra(AppConstants.Key.FORWARD_SELF_UIN);
            String stringExtra6 = intent.getStringExtra(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL);
            String stringExtra7 = intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN);
            int intExtra2 = intent.getIntExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN_TYPE, -1);
            String stringExtra8 = intent.getStringExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_SERVER_PATH);
            long longExtra = intent.getLongExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ITEM_ID, 0L);
            int intExtra3 = intent.getIntExtra(AppConstants.Key.FORWARD_PHOTO_FILE_SIZE_FLAG, 0);
            String stringExtra9 = intent.getStringExtra(AppConstants.Key.FORWARD_PHOTO_MD5);
            int intExtra4 = intent.getIntExtra(AppConstants.Key.FORWARD_PHOTO_ISSEND, -1);
            long longExtra2 = intent.getLongExtra(AppConstants.Key.FORWARD_PHOTO_GROUP_FILEID, 0L);
            long longExtra3 = intent.getLongExtra(AppConstants.Key.FORWARD_IMAGE_WIDTH, 0L);
            long longExtra4 = intent.getLongExtra(AppConstants.Key.FORWARD_IMAGE_HEIGHT, 0L);
            long longExtra5 = intent.getLongExtra(AppConstants.Key.FORWARD_FILE_SIZE, 0L);
            int intExtra5 = intent.getIntExtra(AppConstants.Key.FORWARD_IMAGE_TYPE, 0);
            int intExtra6 = intent.getIntExtra(AppConstants.Key.FORWARD_PHOTO_IMAGEBIZ_TYPE, -1);
            l lVar = new l();
            v.a aVar = new v.a();
            aVar.m(1009);
            aVar.v(stringExtra);
            aVar.B(stringExtra5);
            aVar.y(10);
            aVar.J((int) longExtra3);
            aVar.s((int) longExtra4);
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "createForwardPicInfo(Intent obj)", "image_width = " + longExtra3 + ",image_height = " + longExtra4);
            aVar.p((long) ((int) longExtra5));
            aVar.q(intExtra3);
            aVar.u(intExtra5);
            File file = AbsDownloader.getFile(stringExtra6);
            if (file != null) {
                aVar.F(file.getAbsolutePath());
            }
            aVar.I(intExtra);
            aVar.A(stringExtra3);
            aVar.x(stringExtra4);
            aVar.w(stringExtra9);
            aVar.r(longExtra);
            aVar.t(intExtra6);
            v l3 = aVar.l();
            lVar.f258731f = l3;
            l3.f258711e = stringExtra2;
            if (intExtra3 == 1) {
                l3.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW;
            } else {
                l3.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
            }
            if (com.tencent.mobileqq.v.d(stringExtra)) {
                bm.a();
                try {
                    l3.P = com.tencent.mobileqq.v.b(stringExtra);
                } catch (OutOfMemoryError unused) {
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("OutOfMemoryError occurred in PeakUtils.getSliceInfos\uff0c ");
                        str = stringExtra;
                        sb5.append(str);
                        sb5.append("'s size is ");
                        sb5.append(FileUtils.getFileSizes(str));
                        str2 = "peak_pgjpeg";
                        QLog.w(str2, 2, sb5.toString());
                    }
                }
                str2 = "peak_pgjpeg";
                str = stringExtra;
                bm.b(str2, "PeakUtils.getSliceInfos(" + str + ")");
            } else {
                str = stringExtra;
            }
            if (!FileUtils.fileExistsAndNotEmpty(str)) {
                k.a aVar2 = new k.a();
                aVar2.j(1009);
                aVar2.n(stringExtra5);
                aVar2.m(stringExtra7);
                aVar2.p(intExtra2);
                aVar2.r(stringExtra8);
                aVar2.q(longExtra);
                aVar2.l(stringExtra9);
                aVar2.k(intExtra4);
                com.tencent.mobileqq.pic.k i3 = aVar2.i();
                lVar.f258732h = i3;
                i3.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
                i3.R = intExtra3;
                i3.L = longExtra2;
            }
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "createForwardPicInfo", "");
            return lVar;
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "createForwardPicInfo", "unknow obj");
        return null;
    }
}
