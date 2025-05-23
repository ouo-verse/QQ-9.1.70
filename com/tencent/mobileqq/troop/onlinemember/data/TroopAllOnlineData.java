package com.tencent.mobileqq.troop.onlinemember.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAllOnlineData extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopAllOnlineData";
    public List<String> memberUinList;
    public long nextReqTime;

    @unique
    public String troopUin;
    public byte[] uinData;

    public TroopAllOnlineData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void postRead() {
        ObjectInputStream objectInputStream;
        Throwable th5;
        Exception e16;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.postRead();
        byte[] bArr = this.uinData;
        if (bArr != null && bArr.length != 0) {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.uinData));
            } catch (Exception e17) {
                objectInputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                objectInputStream = null;
                th5 = th6;
                if (objectInputStream != null) {
                }
                throw th5;
            }
            try {
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof List) {
                        this.memberUinList = (List) readObject;
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("TroopAllOnlineData, postRead:");
                            sb5.append(e.toString());
                            QLog.e(TAG, 2, sb5.toString());
                        }
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "TroopAllOnlineData, postRead:" + e19.toString());
                            }
                        }
                    }
                    throw th5;
                }
            } catch (Exception e26) {
                e16 = e26;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "TroopAllOnlineData, postRead:" + e16.toString());
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e27) {
                        e = e27;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("TroopAllOnlineData, postRead:");
                            sb5.append(e.toString());
                            QLog.e(TAG, 2, sb5.toString());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        Throwable th5;
        ObjectOutputStream objectOutputStream;
        IOException e16;
        StringBuilder sb5;
        ByteArrayOutputStream byteArrayOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.prewrite();
        List<String> list = this.memberUinList;
        if (list != null && list.size() != 0) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException e17) {
                    objectOutputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    throw th5;
                }
                try {
                    objectOutputStream.writeObject(this.memberUinList);
                    objectOutputStream.flush();
                    this.uinData = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("TroopAllOnlineData, prewrite:");
                            sb5.append(e.toString());
                            QLog.e(TAG, 2, sb5.toString());
                        }
                    }
                } catch (IOException e19) {
                    e16 = e19;
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "TroopAllOnlineData, prewrite:" + e16.toString());
                    }
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e26) {
                            e = e26;
                            if (QLog.isColorLevel()) {
                                sb5 = new StringBuilder();
                                sb5.append("TroopAllOnlineData, prewrite:");
                                sb5.append(e.toString());
                                QLog.e(TAG, 2, sb5.toString());
                            }
                        }
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e27) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "TroopAllOnlineData, prewrite:" + e27.toString());
                        }
                    }
                }
                throw th5;
            }
        }
    }
}
