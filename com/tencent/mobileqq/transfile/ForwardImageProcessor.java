package com.tencent.mobileqq.transfile;

import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import java.io.File;

/* loaded from: classes19.dex */
public class ForwardImageProcessor implements IHttpCommunicatorListener {
    static IPatchRedirector $redirector_;
    private QQAppInterface app;
    private String downloadProcessorKey;
    private String filepath;
    private String orgUin;
    private int orgUinType;
    private long orgUniseq;
    private String orgUrl;
    private String targetUin;
    private int targetUinType;
    private TransProcessorHandler thandler;
    private long uniseq;

    public ForwardImageProcessor(long j3, String str, QQAppInterface qQAppInterface, int i3, String str2, String str3, String str4, String str5, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, qQAppInterface, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j16), Integer.valueOf(i16));
            return;
        }
        TransProcessorHandler transProcessorHandler = new TransProcessorHandler() { // from class: com.tencent.mobileqq.transfile.ForwardImageProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardImageProcessor.this);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i17 = message.what;
                FileMsg fileMsg = (FileMsg) message.obj;
                if (ForwardImageProcessor.this.orgUin.equals(fileMsg.mUin) && fileMsg.fileType == 1 && i17 != 2002) {
                    String str6 = fileMsg.forwardTaskKey;
                    if (str6 != null && str6.equals(ForwardImageProcessor.this.downloadProcessorKey)) {
                        switch (i17) {
                            case 2003:
                                if (!FileUtils.fileExistsAndNotEmpty(ForwardImageProcessor.this.filepath)) {
                                    ForwardImageProcessor.this.sendReceiveFailToUI();
                                    break;
                                } else {
                                    ((ITransFileController) ForwardImageProcessor.this.app.getRuntimeService(ITransFileController.class)).removeHandle(this);
                                    ForwardImageProcessor.this.uploadImage();
                                    break;
                                }
                            case 2004:
                            case 2005:
                                ForwardImageProcessor.this.sendReceiveFailToUI();
                                break;
                        }
                    } else {
                        return;
                    }
                }
                super.handleMessage(message);
            }
        };
        this.thandler = transProcessorHandler;
        this.downloadProcessorKey = str;
        this.targetUinType = i3;
        this.targetUin = str2;
        this.filepath = str3;
        this.orgUin = str5;
        this.app = qQAppInterface;
        this.uniseq = j3;
        this.orgUrl = str4;
        this.orgUniseq = j16;
        this.orgUinType = i16;
        transProcessorHandler.addFilter(BuddyTransfileProcessor.class, ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass());
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.thandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReceiveFailToUI() {
        stopListening();
        ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).removeProcessor(this.targetUin + this.uniseq);
        Message message = new Message();
        message.what = 1005;
        FileMsg fileMsg = new FileMsg(this.targetUin, this.filepath, 0);
        fileMsg.fileType = 1;
        fileMsg.uniseq = this.uniseq;
        message.obj = fileMsg;
        message.arg1 = 0;
        BaseTransProcessor.sendCustomMessageToUpdateDelay(message, ForwardImageProcessor.class, 0L);
        this.app.getMessageFacade().i2(this.targetUin, this.targetUinType, this.uniseq, this.orgUrl, this.orgUin, this.orgUniseq, this.orgUinType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadImage() {
        long c2CPicSizeLimit;
        ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).removeProcessor(this.targetUin + this.uniseq);
        int i3 = this.targetUinType;
        if (i3 == 1 || i3 == 1001 || i3 == 10002 || i3 == 3000) {
            if (i3 == 1001) {
                c2CPicSizeLimit = AppSetting.J;
            } else {
                c2CPicSizeLimit = ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
            }
            int i16 = (int) c2CPicSizeLimit;
            if (new File(this.filepath).length() > i16) {
                aw.m(-1L, this.targetUinType, true, "group_compress", "ForwardImageProcessor.uploadImage");
                this.filepath = BaseImageUtil.compressImageForGroup(this.app.getApp().getBaseContext(), this.filepath, i16);
            }
            if (!aw.q(null, this.filepath, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
                return;
            }
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = this.app.getAccount();
        transferRequest.mPeerUin = this.targetUin;
        transferRequest.mUinType = this.targetUinType;
        transferRequest.mFileType = 1;
        transferRequest.mUniseq = this.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = 1009;
        transferRequest.mLocalPath = this.filepath;
        ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) httpMsg, (Object) httpMsg2);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) httpMsg, (Object) httpMsg2);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    public void setId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.uniseq = j3;
        }
    }

    public void startListen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).addHandle(this.thandler);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 6, this, httpMsg, httpMsg2, Integer.valueOf(i3))).booleanValue();
    }

    public void stopListening() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.thandler);
        }
    }
}
