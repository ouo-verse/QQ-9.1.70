package com.tencent.mobileqq.transfile.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TransFileControllerBusHelper {
    static IPatchRedirector $redirector_;
    private AppInterface app;
    ArrayList<String> lastPasueKeys;
    ArrayList<String> lastPasueKeysForShortVideo;

    public TransFileControllerBusHelper(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.lastPasueKeysForShortVideo = new ArrayList<>();
        this.lastPasueKeys = new ArrayList<>();
        this.app = appInterface;
    }

    public static int findProcessorFileStatus(AppInterface appInterface, String str, String str2, long j3) {
        IHttpCommunicatorListener findProcessor = ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "")).findProcessor(BaseTransFileController.makeKey(str, j3));
        if (findProcessor instanceof BaseTransProcessor) {
            return (int) ((BaseTransProcessor) findProcessor).getFileStatus();
        }
        return -1;
    }

    private boolean resumeRawSend(String str) {
        IHttpCommunicatorListener findProcessor = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class, "")).findProcessor(str);
        if (findProcessor == null || !(findProcessor instanceof BaseTransProcessor)) {
            return false;
        }
        BaseTransProcessor baseTransProcessor = (BaseTransProcessor) findProcessor;
        if (!baseTransProcessor.mIsRawPic || !baseTransProcessor.mIsPause) {
            return false;
        }
        baseTransProcessor.resume();
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "resumeRawSend ,key:" + baseTransProcessor.getKey());
        return true;
    }

    public boolean pauseAllRawSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        this.lastPasueKeys.clear();
        Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            IHttpCommunicatorListener value = it.next().getValue();
            if (value != null && (value instanceof BaseTransProcessor)) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) value;
                if (baseTransProcessor.mIsRawPic && !baseTransProcessor.mIsPause) {
                    baseTransProcessor.pause();
                    if (baseTransProcessor.getKey() != null) {
                        this.lastPasueKeys.add(baseTransProcessor.getKey());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "pauseAllRawSend key:" + baseTransProcessor.getKey());
                    }
                    z16 = true;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "pauseAllRawSend result:" + z16);
        }
        return z16;
    }

    public boolean pauseAllShortVideoReceive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        while (it.hasNext()) {
            IHttpCommunicatorListener value = it.next().getValue();
            if (value != null && (value instanceof BaseTransProcessor)) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) value;
                if (baseTransProcessor.mIsShortVideoReceive && !baseTransProcessor.mIsPause) {
                    baseTransProcessor.pause();
                    if (baseTransProcessor.getKey() != null) {
                        this.lastPasueKeysForShortVideo.add(baseTransProcessor.getKey());
                    }
                    sb5.append(baseTransProcessor.getKey());
                    sb5.append(",");
                    z16 = true;
                }
            }
        }
        if (sb5.length() > 0 && QLog.isColorLevel()) {
            QLog.d(AppConstants.TAG_RAW_SHORT_VIDEO, 2, "pauseAllShortVideoReceive key:" + ((Object) sb5));
        }
        if (QLog.isColorLevel()) {
            QLog.d(AppConstants.TAG_RAW_SHORT_VIDEO, 2, "pauseAllShortVideoReceive result:" + z16);
        }
        return z16;
    }

    public boolean pauseAllShortVideoSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            IHttpCommunicatorListener value = it.next().getValue();
            if (value != null && (value instanceof BaseTransProcessor)) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) value;
                if (baseTransProcessor.mIsShortVideoSend && !baseTransProcessor.mIsPause) {
                    baseTransProcessor.pause();
                    if (baseTransProcessor.getKey() != null) {
                        this.lastPasueKeysForShortVideo.add(baseTransProcessor.getKey());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(AppConstants.TAG_RAW_SHORT_VIDEO, 2, "pauseAllShortVideoSend key:" + baseTransProcessor.getKey());
                    }
                    z16 = true;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(AppConstants.TAG_RAW_SHORT_VIDEO, 2, "pauseAllShortVideoSend result:" + z16);
        }
        return z16;
    }

    public void resumeLastRawSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "resumeLastRawSend keys size:" + this.lastPasueKeys.size());
        }
        Iterator<String> it = this.lastPasueKeys.iterator();
        while (it.hasNext()) {
            resumeRawSend(it.next());
        }
    }

    public void resumeLastShortVideoTransfer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(AppConstants.TAG_RAW_SHORT_VIDEO, 2, "resumeLastShortVideoSend keys size:" + this.lastPasueKeysForShortVideo.size());
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = this.lastPasueKeysForShortVideo.iterator();
        while (it.hasNext()) {
            IHttpCommunicatorListener findProcessor = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class, "")).findProcessor(it.next());
            if (findProcessor != null && (findProcessor instanceof BaseTransProcessor)) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) findProcessor;
                if (baseTransProcessor.mIsPause) {
                    baseTransProcessor.resume();
                    sb5.append(baseTransProcessor.getKey());
                    sb5.append(",");
                }
            }
        }
        if (sb5.length() > 0 && QLog.isColorLevel()) {
            QLog.d(AppConstants.TAG_RAW_SHORT_VIDEO, 2, "resumeLastShortVideoSend , key: " + ((Object) sb5));
        }
        this.lastPasueKeysForShortVideo.clear();
    }

    public boolean resumeRawSend(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return resumeRawSend(str + str2);
    }
}
