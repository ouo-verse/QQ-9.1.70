package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.IScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.IScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.MultiMsgDownloadProcessor;
import com.tencent.mobileqq.transfile.MultiMsgUpProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.ShareToWXUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TransFileControllerImpl extends BaseTransFileController implements ITransFileController {
    static IPatchRedirector $redirector_ = null;
    public static final boolean CLIENT_PERMIT_PRE_CONN = false;
    public static final String KEY_USE_PRE_CONN = "key_pre_conn";
    public static final String TAG = "Q.richmedia.TransFileController";
    public static final String VALUE_USE_PRE_CONN = "use";
    public static HashSet<Integer> nearByFileType;
    TransFileControllerBusHelper busHelper;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface OnCancelListener {
        void onCancel(ArrayList<MessageRecord> arrayList);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        nearByFileType = hashSet;
        hashSet.add(8);
        nearByFileType.add(64);
        nearByFileType.add(22);
        nearByFileType.add(21);
        nearByFileType.add(34);
        nearByFileType.add(35);
        nearByFileType.add(36);
        nearByFileType.add(37);
        nearByFileType.add(38);
        nearByFileType.add(48);
        nearByFileType.add(23);
        nearByFileType.add(39);
        nearByFileType.add(40);
        nearByFileType.add(41);
        nearByFileType.add(50);
        nearByFileType.add(51);
        nearByFileType.add(56);
        nearByFileType.add(67);
        nearByFileType.add(68);
        nearByFileType.add(69);
        nearByFileType.add(70);
        nearByFileType.add(71);
        nearByFileType.add(72);
        nearByFileType.add(Integer.valueOf(FileMsg.TRANSFILE_TYPE_ZPLAN_UGC_DYEING));
    }

    public TransFileControllerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransFileController
    protected void fillTransRequestMessage(BaseTransProcessor baseTransProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseTransProcessor);
            return;
        }
        try {
            TransferRequest transferRequest = baseTransProcessor.getTransferRequest();
            if (transferRequest != null && transferRequest.mUniseq != 0 && transferRequest.mRec == null) {
                AppInterface appInterface = baseTransProcessor.app;
                if (appInterface instanceof QQAppInterface) {
                    transferRequest.mRec = ((QQAppInterface) appInterface).getMessageFacade().w0(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
                }
            }
        } catch (Exception e16) {
            QLog.e("Q.richmedia.TransFileController", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.ITransFileController
    public TransFileControllerBusHelper getBusHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TransFileControllerBusHelper) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.busHelper;
    }

    public BaseTransProcessor getC2CDownProcessor(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 12, (Object) this, (Object) transferRequest);
        }
        int i3 = transferRequest.mFileType;
        if (i3 != 2 && i3 != 32 && i3 != 33 && i3 != 327696) {
            if (i3 != 6 && i3 != 7 && i3 != 17 && i3 != 18 && i3 != 9 && i3 != 16) {
                if (i3 != 1 && i3 != 65537 && i3 != 131075) {
                    if (i3 == 131079) {
                        return new StructLongMessageDownloadProcessor(this, transferRequest);
                    }
                    return null;
                }
                return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
            }
            return new ShortVideoDownloadProcessor(this, transferRequest);
        }
        return ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, transferRequest);
    }

    public BaseTransProcessor getC2CProcessor(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 13, (Object) this, (Object) transferRequest);
        }
        if (transferRequest.mIsUp) {
            return getC2CUpProcessor(transferRequest);
        }
        return getC2CDownProcessor(transferRequest);
    }

    public BaseTransProcessor getC2CUpProcessor(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 11, (Object) this, (Object) transferRequest);
        }
        int i3 = transferRequest.mFileType;
        if (i3 != 2 && i3 != 32 && i3 != 327696 && i3 != 327699) {
            if (i3 != 6 && i3 != 17 && i3 != 9) {
                if (nearByFileType.contains(Integer.valueOf(i3))) {
                    return new NearbyPeoplePhotoUploadProcessor(this, transferRequest);
                }
                int i16 = transferRequest.mFileType;
                if (i16 == 20) {
                    return ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getProcessor(this, transferRequest);
                }
                if (i16 == 24) {
                    return new BDHCommonUploadProcessor(this, transferRequest);
                }
                if (i16 == 327681) {
                    return new StoryUploadProcessor(this, transferRequest);
                }
                return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
            }
            return ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getProcessor(this, transferRequest);
        }
        return ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, transferRequest);
    }

    public BaseTransProcessor getGuildProcess(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 10, (Object) this, (Object) transferRequest);
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.richmedia.TransFileController", 2, "getProcessor UIN_TYPE_GUILD isUp = " + transferRequest.mIsUp);
        }
        if (transferRequest.mIsUp) {
            int i3 = transferRequest.mFileType;
            if (i3 != 6 && i3 != 17 && i3 != 9 && i3 != 67 && i3 != 20) {
                if (i3 != 2) {
                    return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
                }
                return null;
            }
            return ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getProcessor(this, transferRequest);
        }
        int i16 = transferRequest.mFileType;
        if (i16 != 1 && i16 != 65537 && i16 != 131075) {
            if (i16 != 6 && i16 != 7 && i16 != 17 && i16 != 18 && i16 != 9 && i16 != 16 && i16 != 67 && i16 != 68) {
                return null;
            }
            return new ShortVideoDownloadProcessor(this, transferRequest);
        }
        return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
    }

    public BaseTransProcessor getHotChatProcessor(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 8, (Object) this, (Object) transferRequest);
        }
        if (transferRequest.mFileType == 2) {
            return ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, transferRequest);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransFileController
    public BaseTransProcessor getProcessor(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 14, (Object) this, (Object) transferRequest);
        }
        if (transferRequest == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.TransFileController", 2, transferRequest.toString());
        }
        int i3 = transferRequest.mFileType;
        if (i3 == 131078) {
            if (transferRequest.mIsUp) {
                return new MultiMsgUpProcessor(this, transferRequest);
            }
            return new MultiMsgDownloadProcessor(this, transferRequest);
        }
        if (i3 == 262153) {
            if (transferRequest.mIsUp) {
                return ((IScribblePicUploadProcessor) QRoute.api(IScribblePicUploadProcessor.class)).createProcessor(this, transferRequest);
            }
            return ((IScribblePicDownloadProcessor) QRoute.api(IScribblePicDownloadProcessor.class)).createProcessor(this, transferRequest);
        }
        if (i3 == 66) {
            return new ShareToWXUploadProcessor(this, transferRequest);
        }
        if (i3 == 52 && transferRequest.mIsUp) {
            return new ForwardSdkShareProcessor(this, transferRequest);
        }
        int i16 = transferRequest.mUinType;
        if (i16 == 1026) {
            return getHotChatProcessor(transferRequest);
        }
        if (i16 != 1 && i16 != 3000) {
            if (i16 == 10014) {
                return getGuildProcess(transferRequest);
            }
            return getC2CProcessor(transferRequest);
        }
        return getTroopProcessor(transferRequest);
    }

    public BaseTransProcessor getTroopProcessor(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 9, (Object) this, (Object) transferRequest);
        }
        if (transferRequest.mIsUp) {
            int i3 = transferRequest.mFileType;
            if (i3 != 6 && i3 != 17 && i3 != 9) {
                if (i3 == 20) {
                    return ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getProcessor(this, transferRequest);
                }
                if (i3 == 55) {
                    return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
                }
                if (transferRequest.mBusiType == 1045) {
                    return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
                }
                if (i3 == 2) {
                    return ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, transferRequest);
                }
                return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
            }
            return ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getProcessor(this, transferRequest);
        }
        int i16 = transferRequest.mFileType;
        if (i16 != 2 && i16 != 327696) {
            if (i16 != 1 && i16 != 65537 && i16 != 131075) {
                if (i16 != 6 && i16 != 7 && i16 != 17 && i16 != 18 && i16 != 9 && i16 != 16) {
                    return null;
                }
                return new ShortVideoDownloadProcessor(this, transferRequest);
            }
            return ((IPicFactory) QRoute.api(IPicFactory.class)).getProcessor(this, transferRequest);
        }
        return ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, transferRequest);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
        }
        this.app = (AppInterface) appRuntime;
        this.mHandler = new BaseTransFileController.ProcHandler(ThreadManagerV2.getSubThreadLooper());
        this.busHelper = new TransFileControllerBusHelper(this.app);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.mWorking.get()) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.mWorking) {
                this.mWorking.set(false);
                IHttpEngineService iHttpEngineService = (IHttpEngineService) this.app.getRuntimeService(IHttpEngineService.class, "all");
                if (iHttpEngineService != null) {
                    iHttpEngineService.onDestroy();
                }
                stopCurrentWork();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.TransFileController", 2, "destroy transfilecontroller:" + this + " elapsed:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.ITransFileController
    public void removeProcessorByPeerUin(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        for (String str2 : getKeySetClone(this.processorMap)) {
            IHttpCommunicatorListener iHttpCommunicatorListener = this.processorMap.get(str2);
            if (i3 == 0 && (iHttpCommunicatorListener instanceof BuddyTransfileProcessor) && str.equals(((BuddyTransfileProcessor) iHttpCommunicatorListener).file.mUin)) {
                ((BaseTransProcessor) iHttpCommunicatorListener).stop();
                this.processorMap.remove(str2);
            }
        }
    }

    public TransFileControllerImpl(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface);
    }
}
