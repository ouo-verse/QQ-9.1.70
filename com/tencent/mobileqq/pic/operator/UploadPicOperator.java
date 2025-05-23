package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.pic.s;
import com.tencent.mobileqq.pic.u;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes16.dex */
public class UploadPicOperator extends BasePicOperator implements ad {
    static IPatchRedirector $redirector_;

    public UploadPicOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v.a A(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (v.a) iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent);
        }
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("troop_uin");
        int intExtra = intent.getIntExtra("uintype", 1003);
        int intExtra2 = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0);
        int intExtra3 = intent.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, -1);
        String stringExtra3 = intent.getStringExtra(PeakConstants.PHOTO_SEND_PATH);
        int intExtra4 = intent.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
        int intExtra5 = intent.getIntExtra(ConfessInfo.KEY_CONFESS_TOPICID, 0);
        boolean booleanExtra = intent.getBooleanExtra(ShortVideoConstants.KEY_STORY_PIC_TO_RECENT, false);
        String stringExtra4 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
        String stringExtra5 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
        v.a aVar = new v.a();
        aVar.x(stringExtra);
        aVar.v(stringExtra3);
        aVar.I(intExtra);
        aVar.A(stringExtra2);
        aVar.m(intExtra3);
        aVar.C(intExtra2);
        aVar.H(intExtra5);
        aVar.n(intExtra4);
        aVar.D(booleanExtra);
        if (!TextUtils.isEmpty(stringExtra4)) {
            u uVar = new u();
            uVar.f258804a = stringExtra4;
            uVar.f258805b = stringExtra5;
            aVar.o(uVar);
        }
        return aVar;
    }

    public v B(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (v) iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
        }
        if (intent != null) {
            v.a A = A(intent);
            if (A == null) {
                return null;
            }
            v l3 = A.l();
            int intExtra = intent.getIntExtra(PeakConstants.KEY_IS_SYNC_QZONE, 0);
            if (intExtra == 1) {
                String stringExtra = intent.getStringExtra(PeakConstants.KEY_QZONE_ALBUM_ID);
                l3.f258823i0 = intExtra;
                l3.f258826l0 = stringExtra;
                l3.f258825k0 = intent.getLongExtra(PeakConstants.KEY_QZONE_BATCH_ID, 0L);
                l3.f258827m0 = intent.getIntExtra(PeakConstants.PHOTO_COUNT, 0);
                l3.f258828n0 = intent.getIntExtra(PeakConstants.PHOTO_SEND_PATH_INDEX, 0);
            }
            boolean booleanExtra = intent.getBooleanExtra(IPicBus.IS_EMO_SEARCH, false);
            boolean booleanExtra2 = intent.getBooleanExtra(HotPicData.HOT_PIC_SEND, false);
            int intExtra2 = intent.getIntExtra("key_pic_send_source", 0);
            if (l3.f258840z0 == null) {
                l3.f258840z0 = new u();
            }
            u uVar = l3.f258840z0;
            uVar.f258811h = intExtra2;
            uVar.f258809f = booleanExtra;
            uVar.f258810g = booleanExtra2;
            l3.f258840z0.f258812i = intent.getIntExtra("delay_show_progress_time_in_ms", 2000);
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "createPicUploadInfo", "");
            return l3;
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "createPicUploadInfo", "unknow obj");
        return null;
    }

    protected void C(p pVar, MessageRecord messageRecord, v vVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, pVar, messageRecord, vVar);
            return;
        }
        PicMessageExtraData picMessageExtraData = pVar.E;
        if (picMessageExtraData != null) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            messageForPic.picExtraData = picMessageExtraData;
            ((IDep) QRoute.api(IDep.class)).fillStickInfo(messageForPic, picMessageExtraData);
        }
        MessageForPic messageForPic2 = (MessageForPic) messageRecord;
        if (messageForPic2.checkGif()) {
            PicMessageExtraData picMessageExtraData2 = messageForPic2.picExtraData;
            if (picMessageExtraData2 == null) {
                picMessageExtraData2 = new PicMessageExtraData();
            }
            if (TextUtils.isEmpty(picMessageExtraData2.textSummary)) {
                picMessageExtraData2.textSummary = this.f258754m.getApp().getString(R.string.iml);
            }
            picMessageExtraData2.emojiPkgId = String.valueOf(vVar.f258839y0);
            picMessageExtraData2.from = vVar.f258834t0;
            picMessageExtraData2.source = vVar.f258835u0;
            picMessageExtraData2.webUrl = vVar.f258836v0;
            picMessageExtraData2.iconUrl = vVar.f258837w0;
            picMessageExtraData2.packageName = vVar.f258838x0;
            if (picMessageExtraData2.imageBizType <= 0 && ((i3 = pVar.f258784e) == 1050 || i3 == 1051 || i3 == 1052)) {
                picMessageExtraData2.imageBizType = 11;
            }
            messageForPic2.picExtraData = picMessageExtraData2;
        }
        u uVar = vVar.f258840z0;
        if (uVar != null && !TextUtils.isEmpty(uVar.f258804a)) {
            PicMessageExtraData picMessageExtraData3 = messageForPic2.picExtraData;
            if (picMessageExtraData3 == null) {
                picMessageExtraData3 = new PicMessageExtraData();
            }
            u uVar2 = vVar.f258840z0;
            picMessageExtraData3.mTemplateId = uVar2.f258804a;
            picMessageExtraData3.mTemplateName = uVar2.f258805b;
            messageForPic2.picExtraData = picMessageExtraData3;
        }
        if (pVar.f258784e == 1053) {
            PicMessageExtraData picMessageExtraData4 = messageForPic2.picExtraData;
            if (picMessageExtraData4 == null) {
                picMessageExtraData4 = new PicMessageExtraData();
            }
            picMessageExtraData4.imageBizType = 1002;
            messageForPic2.picExtraData = picMessageExtraData4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransferRequest D(p pVar, v vVar, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TransferRequest) iPatchRedirector.redirect((short) 12, this, pVar, vVar, messageRecord);
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = this.f258754m.getAccount();
        transferRequest.mPeerUin = messageRecord.frienduin;
        transferRequest.mSecondId = messageRecord.senderuin;
        transferRequest.mUinType = messageRecord.istroop;
        boolean z16 = true;
        transferRequest.mFileType = 1;
        transferRequest.mUniseq = messageRecord.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = vVar.f258712f;
        transferRequest.mLocalPath = vVar.K;
        transferRequest.mMd5 = vVar.J;
        TransferRequest.PicUpExtraInfo picUpExtraInfo = new TransferRequest.PicUpExtraInfo();
        if (vVar.g() != 1) {
            z16 = false;
        }
        picUpExtraInfo.mIsRaw = z16;
        transferRequest.mExtraObj = picUpExtraInfo;
        transferRequest.mUpCallBack = this;
        transferRequest.mRec = this.f258752h;
        transferRequest.mIsPresend = vVar.U;
        transferRequest.myPresendInvalid = vVar.W;
        u uVar = vVar.f258840z0;
        if (uVar != null) {
            transferRequest.mPicSendSource = uVar.f258811h;
            transferRequest.delayShowProgressTimeInMs = uVar.f258812i;
        }
        return transferRequest;
    }

    void E(ad.a aVar) {
        s sVar = ((PicPreDownloadImpl) this.f258754m.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager;
        if (sVar != null) {
            sVar.c(13057, aVar.f258601e);
        }
    }

    public MessageRecord F(p pVar, v vVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pVar, (Object) vVar);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (vVar == null) {
            return null;
        }
        MessageForPic messageForPic = (MessageForPic) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_Pic(this.f258754m, vVar.f258715m, vVar.C, vVar.f258713h);
        messageForPic.busiType = vVar.f258712f;
        messageForPic.path = vVar.K;
        messageForPic.size = 0L;
        messageForPic.type = 1;
        messageForPic.isRead = true;
        messageForPic.extraflag = 32772;
        if (vVar.Q == 1) {
            messageForPic.fileSizeFlag = 1;
        }
        messageForPic.localUUID = vVar.f258711e;
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "bindUrlKeyAndUniseq", messageForPic.localUUID + "|" + messageForPic.uniseq);
        messageForPic.md5 = s(messageForPic.path);
        I(vVar, messageForPic);
        messageForPic.thumbWidth = vVar.M;
        messageForPic.thumbHeight = vVar.N;
        K(vVar, messageForPic);
        messageForPic.extLong = vVar.Y;
        messageForPic.extStr = vVar.Z;
        messageForPic.msgVia = vVar.f258820f0;
        boolean z16 = vVar.f258824j0;
        messageForPic.sync2Story = z16;
        String str2 = com.tencent.mobileqq.service.message.i.f286270m;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        messageForPic.saveExtInfoToExtStr(str2, str);
        w(messageForPic, vVar);
        ArrayList<Integer> arrayList = vVar.P;
        if (arrayList != null && !arrayList.isEmpty()) {
            n(vVar, messageForPic);
            messageForPic.imageType = 1003;
        } else if (QLog.isColorLevel()) {
            QLog.d("peak_pgjpeg", 2, "Slice infos is null");
        }
        messageForPic.serial();
        if (messageForPic.istroop == 10014) {
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageForPic, ((IGPSService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildIdOf(messageForPic.frienduin));
            messageForPic.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
            C(pVar, messageForPic, vVar);
        }
        vVar.D = messageForPic.uniseq;
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "packMsg", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        messageForPic.DSKey = vVar.S;
        return messageForPic;
    }

    void G() {
        this.f258754m.getHwEngine().preConnect();
    }

    public void H(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pVar);
        } else {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "sendPic.start", "");
            ThreadManagerV2.excute(new Runnable(pVar) { // from class: com.tencent.mobileqq.pic.operator.UploadPicOperator.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ p f258745d;

                {
                    this.f258745d = pVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadPicOperator.this, (Object) pVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (UploadPicOperator.this.u(this.f258745d.C)) {
                        UploadPicOperator.this.y(this.f258745d);
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.pic.operator.UploadPicOperator.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    UploadPicOperator.this.c(3, anonymousClass2.f258745d.C.f258735d);
                                }
                            }
                        });
                    }
                }
            }, 16, null, false);
        }
    }

    void I(v vVar, MessageForPic messageForPic) {
        messageForPic.thumbMsgUrl = vVar.L;
    }

    void J(MessageForPic messageForPic) {
        IMessageFacade iMessageFacade = (IMessageFacade) this.f258754m.getRuntimeService(IMessageFacade.class, "");
        MessageRecord messageRecord = this.f258752h;
        iMessageFacade.updateMsgContentByUniseq(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, messageForPic.msgData);
    }

    void K(v vVar, MessageForPic messageForPic) {
        File file = new File(vVar.K);
        if (file.exists()) {
            if (GifDrawable.isGifFile(file)) {
                messageForPic.imageType = 2000;
            } else {
                messageForPic.imageType = com.tencent.mobileqq.v.a(vVar.K);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            SafeBitmapFactory.decodeFile(vVar.K, options);
            messageForPic.width = options.outWidth;
            messageForPic.height = options.outHeight;
            if (RichMediaUtil.isPicLandscape(vVar.K)) {
                messageForPic.width = options.outHeight;
                messageForPic.height = options.outWidth;
                if (QLog.isColorLevel()) {
                    com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + options.outWidth + ",options.outHeight = " + options.outHeight + ",mr.width = " + messageForPic.width + ",mr.height = " + messageForPic.height);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 14, (Object) this, (Object) im_msg_body_richtext);
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "attachRichText2Msg", "");
        MessageRecord messageRecord = this.f258752h;
        if (messageRecord != null && (messageRecord instanceof MessageForRichText)) {
            ((MessageForRichText) messageRecord).richText = im_msg_body_richtext;
        }
        return messageRecord;
    }

    @Override // com.tencent.mobileqq.pic.operator.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            H(this.f258751f);
        }
    }

    protected void p(MessageForPic messageForPic, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) messageForPic, (Object) str);
        } else {
            ((IPicHelper) QRoute.api(IPicHelper.class)).cachePicToDisk(messageForPic, str);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            c(3, null);
            return;
        }
        p pVar = this.f258751f;
        if (pVar != null) {
            int i3 = pVar.f258783d;
            if (i3 == 2 || i3 == 4) {
                if (aVar.f258597a == 0) {
                    r(aVar);
                    E(aVar);
                    q qVar = new q();
                    qVar.f258790a = 0;
                    qVar.f258793d = aVar;
                    d(3, qVar);
                    return;
                }
                m.a aVar2 = new m.a();
                aVar2.f258737b = aVar.f258599c;
                c(3, aVar2);
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "updateMsg", "resut:" + aVar);
            MessageRecord messageRecord = this.f258752h;
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            messageForPic.size = aVar.f258601e;
            messageForPic.uuid = aVar.f258602f;
            messageForPic.groupFileID = aVar.f258604h;
            messageForPic.md5 = aVar.f258603g;
            try {
                PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
                if (picMessageExtraData != null && (bArr = aVar.f258611o) != null && messageRecord.istroop == 10014) {
                    picMessageExtraData.mDownloadIndex = new String(bArr, "utf-8");
                }
            } catch (UnsupportedEncodingException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("UploadPicOperator", 2, "updateMsg error:  index" + Arrays.toString(aVar.f258611o) + e16);
                }
            }
            messageForPic.serial();
            J(messageForPic);
        }
    }

    String s(String str) {
        String str2 = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str2 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        } catch (UnsatisfiedLinkError unused) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                    if (d16 != null) {
                        str2 = d16;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "calcMD5", "md5:" + str2 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean t(v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) vVar)).booleanValue();
        }
        String str = vVar.K;
        int i3 = vVar.Q;
        int i16 = vVar.f258712f;
        com.tencent.mobileqq.activity.photo.incompatiblephoto.b b16 = com.tencent.mobileqq.activity.photo.incompatiblephoto.b.b(str);
        boolean z16 = true;
        if (b16 != null) {
            com.tencent.mobileqq.activity.photo.incompatiblephoto.c cVar = new com.tencent.mobileqq.activity.photo.incompatiblephoto.c(b16);
            if (i3 == 1) {
                String d16 = cVar.d();
                if (d16 != null) {
                    vVar.K = d16;
                    if (!z16) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pic.operator.UploadPicOperator.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadPicOperator.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    QQToast.makeText(BaseApplication.getContext(), R.string.ii_, 1).show();
                                }
                            }
                        });
                    }
                } else {
                    vVar.a("PicBaseInfo.check", "incompatible photo generate jpg fail");
                    z16 = false;
                    if (!z16) {
                    }
                }
            } else {
                if (i16 != 1006 && i16 != 1009) {
                    vVar.a("PicBaseInfo.check", "incompatible file,and not PROTOCOL_RAW_PIC:" + i3);
                } else {
                    String d17 = cVar.d();
                    if (d17 != null) {
                        vVar.K = d17;
                        if (!z16) {
                        }
                    } else {
                        vVar.a("PicBaseInfo.check", "incompatible photo generate jpg fail");
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
        }
        return z16;
    }

    protected boolean u(v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) vVar)).booleanValue();
        }
        if (vVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "checkPicUploadInfo", "info:" + vVar);
            if (vVar.b()) {
                return t(vVar);
            }
            return false;
        }
        com.tencent.mobileqq.pic.f.e(this.f258750e, this.f258749d, "checkPicUploadInfo", "info == null");
        return false;
    }

    protected v v(v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (v) iPatchRedirector.redirect((short) 11, (Object) this, (Object) vVar);
        }
        CompressInfo compressInfo = new CompressInfo(vVar.K, 0);
        com.tencent.mobileqq.pic.compress.c.f(compressInfo);
        String str = compressInfo.H;
        if (str != null) {
            vVar.L = str;
            vVar.M = compressInfo.I;
            vVar.N = compressInfo.J;
        }
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(MessageForPic messageForPic, v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic, (Object) vVar);
            return;
        }
        ((IConfessMsgUtil) QRoute.api(IConfessMsgUtil.class)).bindConfessInfo((BaseQQAppInterface) this.f258754m, messageForPic, vVar.f258715m, vVar.f258713h, vVar.f258822h0);
        int i3 = vVar.f258713h;
        if (i3 == 0) {
            ((IConfessMsgUtil) QRoute.api(IConfessMsgUtil.class)).bindC2CFirstMsgConfessInfo((BaseQQAppInterface) this.f258754m, messageForPic, vVar.f258715m);
        } else if (i3 == 1) {
            ((IConfessMsgUtil) QRoute.api(IConfessMsgUtil.class)).bindGroupFirstMsgConfessInfo((BaseQQAppInterface) this.f258754m, messageForPic, vVar.f258715m);
        }
        if (vVar.f258823i0 == 1) {
            messageForPic.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_IS_SYNC_QZONE, String.valueOf(1));
            messageForPic.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_ALBUM_ID, vVar.f258826l0);
            messageForPic.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_ID, String.valueOf(vVar.f258825k0));
            messageForPic.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_IS_RAW, String.valueOf(vVar.Q));
            messageForPic.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_COUNT, String.valueOf(vVar.f258827m0));
            messageForPic.saveExtInfoToExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_PHOTO_INDEX, String.valueOf(vVar.f258828n0));
        }
        if (vVar.f258713h == 10007) {
            com.tencent.mobileqq.gamecenter.util.c.a(messageForPic);
        }
        if (vVar.f258833s0) {
            messageForPic.isStoryPhoto = true;
        }
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData == null) {
            picMessageExtraData = new PicMessageExtraData();
        }
        if (vVar.i()) {
            picMessageExtraData.imageBizType = 13;
        } else if (vVar.j()) {
            picMessageExtraData.imageBizType = 2;
        }
        u uVar = vVar.f258840z0;
        if (uVar != null) {
            picMessageExtraData.mOriginImageMd5 = uVar.f258814k;
        }
        messageForPic.picExtraData = picMessageExtraData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransferRequest x(p pVar, v vVar) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TransferRequest) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pVar, (Object) vVar);
        }
        G();
        v v3 = v(vVar);
        MessageRecord F = F(pVar, v3);
        if (F == null) {
            com.tencent.mobileqq.pic.f.b(this.f258750e, "doSendPic", "error, mr==null, return");
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic) F).msgVia);
        }
        z(F, pVar);
        if (MessageForPic.class.isInstance(F)) {
            C(pVar, F, vVar);
            MessageForPic messageForPic = (MessageForPic) F;
            p(messageForPic, v3.L);
            if (TextUtils.isEmpty(v3.L)) {
                o(messageForPic);
            }
        }
        if (F.istroop == 1 && vVar.A0 == null) {
            ((IDep) QRoute.api(IDep.class)).bindAnonymousInfo(F);
        }
        if (F.istroop == 1046 && (appInterface = this.f258754m) != null) {
            pVar.C.f258714i = appInterface.getCurrentUin();
            pVar.C.C = this.f258754m.getCurrentUin();
        }
        if (vVar.U) {
            synchronized (vVar) {
                vVar.F = F;
                vVar.notifyAll();
                com.tencent.mobileqq.pic.f.b(this.f258750e, "doSendPic ", "PresendStatus: destPath:" + vVar.K + ",uuid:" + this.f258749d + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
                if (vVar.E == 3) {
                    com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
                    com.tencent.mobileqq.pic.f.b(this.f258750e, "doSendPic", "PresendStatus: destPath:" + vVar.K + ",uuid:" + this.f258749d + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
                    return null;
                }
            }
        }
        this.f258752h = F;
        long currentTimeMillis = System.currentTimeMillis();
        TransferRequest D = D(pVar, vVar, F);
        if (vVar.U) {
            synchronized (vVar) {
                if (vVar.V) {
                    com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "PresendPic doSendPic cancel transferAsync!", "");
                    com.tencent.mobileqq.pic.f.b(this.f258750e, "doSendPic ", "PresendStatus: destPath:" + vVar.K + ",uuid:" + this.f258749d + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
                    return null;
                }
                com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "PresendPic doSendPic start transferAsync!", "");
                AppInterface appInterface2 = this.f258754m;
                if (appInterface2 != null) {
                    ((ITransFileController) appInterface2.getRuntimeService(ITransFileController.class, "")).transferAsync(D);
                }
                com.tencent.mobileqq.pic.f.b(this.f258750e, "doSendPic ", "PresendStatus: destPath:" + vVar.K + ",uuid:" + this.f258749d + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
            }
        } else {
            AppInterface appInterface3 = this.f258754m;
            if (appInterface3 != null) {
                ((ITransFileController) appInterface3.getRuntimeService(ITransFileController.class, "")).transferAsync(D);
            }
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "sendReq", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (vVar.T && !vVar.U) {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "sendPic", "@#addMsg");
            k(F, vVar.f258831q0);
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "getSendTask.start", "");
        return D;
    }

    protected void y(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pVar);
            return;
        }
        v vVar = pVar.C;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable(pVar, vVar) { // from class: com.tencent.mobileqq.pic.operator.UploadPicOperator.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ p f258747d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ v f258748e;

                {
                    this.f258747d = pVar;
                    this.f258748e = vVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UploadPicOperator.this, pVar, vVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        UploadPicOperator.this.x(this.f258747d, this.f258748e);
                    }
                }
            }, 16, null, false);
        } else {
            x(pVar, vVar);
        }
    }

    protected void z(MessageRecord messageRecord, p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord, (Object) pVar);
        } else {
            ((IForwardOrderManager) QRoute.api(IForwardOrderManager.class)).mapUniSeqId(messageRecord.uniseq, 0L, pVar.I);
        }
    }
}
