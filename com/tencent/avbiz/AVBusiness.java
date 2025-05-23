package com.tencent.avbiz;

import android.os.Bundle;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class AVBusiness {
    static IPatchRedirector $redirector_;
    private static long SEQ;
    private static final String TAG;
    private final String mName;
    private final HashMap<Long, Integer> mPriorityMap;
    private final String mProcessName;
    private final long mRequestType;
    private final long mSeq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            TAG = AVBusiness.class.getSimpleName();
            SEQ = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVBusiness(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.mName = str;
        this.mProcessName = str2;
        long longValue = Constants.REQUEST_DEVICE_MAP.get(str).longValue();
        this.mRequestType = longValue;
        this.mPriorityMap = initPriorityMap(str, longValue);
        if (Constants.Business.QQ_RTC.equals(str) && str2 != null && !str2.isEmpty()) {
            this.mSeq = 0L;
            return;
        }
        long j3 = SEQ;
        SEQ = 1 + j3;
        this.mSeq = j3;
    }

    private static HashMap<Long, Integer> initPriorityMap(String str, long j3) {
        HashMap<Long, Integer> hashMap = new HashMap<>();
        long j16 = 1;
        while (j3 != 0) {
            if ((j3 & 1) != 0) {
                Iterator<HashSet<String>> it = Constants.Priority.PRIORITY_MAP.get(Long.valueOf(j16)).iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().contains(str)) {
                        hashMap.put(Long.valueOf(j16), Integer.valueOf(i3));
                        break;
                    }
                    i3++;
                }
            }
            j3 >>= 1;
            j16 <<= 1;
        }
        if (QLog.isColorLevel()) {
            for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
                QLog.i(TAG, 2, "mPriorityMap, type[" + entry.getKey() + "], priority[" + entry.getValue() + "]");
            }
        }
        return hashMap;
    }

    public boolean comparePriority(AVBusiness aVBusiness) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVBusiness)).booleanValue();
        }
        long requestType = getRequestType() & aVBusiness.getRequestType();
        long j3 = 1;
        while (requestType != 0) {
            if ((requestType & 1) != 0) {
                int intValue = this.mPriorityMap.get(Long.valueOf(j3)).intValue();
                int intValue2 = aVBusiness.mPriorityMap.get(Long.valueOf(j3)).intValue();
                if (intValue < intValue2) {
                    return true;
                }
                if (intValue > intValue2) {
                    return false;
                }
            }
            requestType >>= 1;
            j3 <<= 1;
        }
        HashSet<String> hashSet = Constants.AUDIO_PLAYER_BUSINESS;
        if (hashSet.contains(getName()) && hashSet.contains(aVBusiness.getName())) {
            if (this.mSeq <= aVBusiness.mSeq) {
                return false;
            }
            return true;
        }
        if (this.mSeq >= aVBusiness.mSeq) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj)).booleanValue();
        }
        if ((obj instanceof AVBusiness) && (str = this.mName) != null) {
            AVBusiness aVBusiness = (AVBusiness) obj;
            if (str.equals(aVBusiness.mName) && (str2 = this.mProcessName) != null && str2.equals(aVBusiness.mProcessName) && this.mRequestType == aVBusiness.mRequestType && this.mSeq == aVBusiness.mSeq) {
                return true;
            }
        }
        return false;
    }

    public void gainFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "gainFocus, business[" + this.mName + "], process[" + this.mProcessName + "]");
        }
        String str = this.mProcessName;
        if (str != null && !str.isEmpty() && !"com.tencent.mobileqq".equals(this.mProcessName)) {
            QIPCServerHelper.getInstance().getServer().callClient(this.mProcessName, 1, this.mName, Constants.Action.NOTIFY_FOCUS_GAIN, new Bundle(), null);
            return;
        }
        IModule moduleByName = AVBizModuleFactory.getModuleByName(this.mName);
        if (moduleByName instanceof IModule.FocusChangeListener) {
            ((IModule.FocusChangeListener) moduleByName).onFocusGain();
        }
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mName;
    }

    public String getProcessName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mProcessName;
    }

    public long getRequestType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mRequestType;
    }

    public void lossFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "lossFocus, business[" + this.mName + "], process[" + this.mProcessName + "]");
        }
        String str = this.mProcessName;
        if (str != null && !str.isEmpty() && !"com.tencent.mobileqq".equals(this.mProcessName)) {
            QIPCServerHelper.getInstance().getServer().callClient(this.mProcessName, 1, this.mName, Constants.Action.NOTIFY_FOCUS_LOSS, new Bundle(), null);
            return;
        }
        IModule moduleByName = AVBizModuleFactory.getModuleByName(this.mName);
        if (moduleByName instanceof IModule.FocusChangeListener) {
            ((IModule.FocusChangeListener) moduleByName).onFocusLoss();
        }
    }
}
