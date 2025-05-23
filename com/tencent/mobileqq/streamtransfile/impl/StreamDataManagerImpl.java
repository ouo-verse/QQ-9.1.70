package com.tencent.mobileqq.streamtransfile.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.streamtransfile.c;
import com.tencent.mobileqq.streamtransfile.d;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StreamDataManagerImpl implements IStreamDataManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "StreamDataManagerImpl";

    public StreamDataManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.streamtransfile.IStreamDataManager
    public Map.Entry<String, c> getStreamFileInfoEntryByMsg(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map.Entry) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16));
        }
        HashMap<String, c> b16 = d.b();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getStreamFileInfoEntryByMsg  try get random is:" + j3 + ",msgSeq is:" + j16);
        }
        if (b16 != null && b16.size() > 0) {
            for (Map.Entry<String, c> entry : b16.entrySet()) {
                c value = entry.getValue();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getStreamFileInfoEntryByMsg  random is:" + s.f((int) value.f290264k) + ",msgSeq is:" + value.f290263j);
                }
                if (s.f((int) value.f290264k) == j3 && j16 == value.f290263j) {
                    return entry;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.streamtransfile.IStreamDataManager
    public boolean removeStreamTaskToMemoryPool(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        HashMap<String, c> b16 = d.b();
        if (b16 != null && b16.containsKey(str)) {
            synchronized (b16) {
                b16.remove(str);
            }
            return true;
        }
        return false;
    }
}
