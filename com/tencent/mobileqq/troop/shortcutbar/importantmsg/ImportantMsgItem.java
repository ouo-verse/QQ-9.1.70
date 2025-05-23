package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "troopUin")
/* loaded from: classes19.dex */
public class ImportantMsgItem extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int MAX_MSGINFO_LIST_COUNT = 20;
    public static final String TAG = "ImportantMsgItem";
    public long maxImportantMsgSeq;
    public byte[] msgInfoData;

    @notColumn
    private ArrayList<MsgInfo> msgInfoList;
    public long troopUin;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class MsgInfo implements Serializable, Comparable<MsgInfo> {
        static IPatchRedirector $redirector_ = null;
        public static final int NOT_SHOW_TYPE_CONFIG = 3;
        public static final int NOT_SHOW_TYPE_DEFAULT = 0;
        public static final int NOT_SHOW_TYPE_DEL = 1;
        public static final int NOT_SHOW_TYPE_REVOKE = 2;
        public static final int NOT_SHOW_TYPE_TROOPNOTIFICATION_SHOWWINDOW = 4;
        private static final long serialVersionUID = 1;
        int msgEnum;
        boolean msgNeedShow;
        int msgNotShowType;
        String msgSendUin;
        long msgSeq;
        String msgSummary;
        long msgTime;

        public MsgInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.msgTime = 0L;
            this.msgSeq = 0L;
            this.msgSendUin = "";
            this.msgEnum = 0;
            this.msgSummary = "";
            this.msgNeedShow = true;
            this.msgNotShowType = 0;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
            }
            if (obj == null || !(obj instanceof MsgInfo) || ((MsgInfo) obj).msgSeq != this.msgSeq) {
                return false;
            }
            return true;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "msgTime" + ContainerUtils.KEY_VALUE_DELIMITER + this.msgTime + ", msgSeq" + ContainerUtils.KEY_VALUE_DELIMITER + this.msgSeq + ", msgSendUin" + ContainerUtils.KEY_VALUE_DELIMITER + this.msgSendUin + ", msgEnum" + ContainerUtils.KEY_VALUE_DELIMITER + this.msgEnum + ", msgNeedShow" + ContainerUtils.KEY_VALUE_DELIMITER + this.msgNeedShow + ", msgNotShowType" + ContainerUtils.KEY_VALUE_DELIMITER + this.msgNotShowType;
        }

        @Override // java.lang.Comparable
        public int compareTo(MsgInfo msgInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgInfo)).intValue();
            }
            long j3 = this.msgSeq;
            long j16 = msgInfo.msgSeq;
            if (j3 > j16) {
                return 1;
            }
            return j3 == j16 ? 0 : -1;
        }

        public MsgInfo(long j3, long j16, String str, int i3, String str2, boolean z16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), Integer.valueOf(i16));
                return;
            }
            this.msgTime = j3;
            this.msgSeq = j16;
            this.msgSendUin = str;
            this.msgEnum = i3;
            this.msgSummary = str2;
            this.msgNeedShow = z16;
            this.msgNotShowType = i16;
        }
    }

    public ImportantMsgItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.msgInfoList = new ArrayList<>();
        this.troopUin = 0L;
        this.maxImportantMsgSeq = 0L;
    }

    private void sortAndlimitMsgInfoList() {
        Collections.sort(this.msgInfoList, Collections.reverseOrder());
        if (this.msgInfoList.size() > 20) {
            Iterator<MsgInfo> it = this.msgInfoList.iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                i3++;
                MsgInfo next = it.next();
                boolean z16 = next.msgNeedShow;
                if (z16) {
                    i16++;
                }
                if (i3 > 20) {
                    if (!z16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "sortAndlimitMsgInfoList remove seq:" + next.msgSeq);
                        }
                        it.remove();
                    } else if (i16 > 20) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "sortAndlimitMsgInfoList remove seq:" + next.msgSeq);
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean addMsgInfo(MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgInfo)).booleanValue();
        }
        if (msgInfo == null || this.msgInfoList.contains(msgInfo)) {
            return false;
        }
        this.msgInfoList.add(msgInfo);
        sortAndlimitMsgInfoList();
        return true;
    }

    public boolean addMsgInfos(ArrayList<MsgInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList)).booleanValue();
        }
        if (arrayList == null) {
            return false;
        }
        Iterator<MsgInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgInfo next = it.next();
            if (!this.msgInfoList.contains(next)) {
                this.msgInfoList.add(next);
            }
        }
        sortAndlimitMsgInfoList();
        return true;
    }

    public ArrayList<MsgInfo> getMsgInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msgInfoList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void postRead() {
        ObjectInputStream objectInputStream;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.postRead();
        byte[] bArr = this.msgInfoData;
        if (bArr != null && bArr.length != 0) {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgInfoData));
            } catch (Exception e16) {
                e = e16;
                objectInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                objectInputStream = null;
                if (objectInputStream != null) {
                }
                this.msgInfoData = null;
                throw th;
            }
            try {
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof ArrayList) {
                        this.msgInfoList = (ArrayList) readObject;
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("postRead:");
                            sb5.append(e.toString());
                            QLog.e(TAG, 2, sb5.toString());
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e18) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "postRead:" + e18.toString());
                            }
                        }
                    }
                    this.msgInfoData = null;
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "postRead:" + e.toString());
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e26) {
                        e = e26;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("postRead:");
                            sb5.append(e.toString());
                            QLog.e(TAG, 2, sb5.toString());
                        }
                    }
                }
                this.msgInfoData = null;
            }
            this.msgInfoData = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postwrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (this.msgInfoData != null) {
            this.msgInfoData = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        ObjectOutputStream objectOutputStream;
        Throwable th5;
        IOException e16;
        StringBuilder sb5;
        ByteArrayOutputStream byteArrayOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.prewrite();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e17) {
            objectOutputStream = null;
            e16 = e17;
        } catch (Throwable th6) {
            objectOutputStream = null;
            th5 = th6;
            if (objectOutputStream != null) {
            }
            throw th5;
        }
        try {
            try {
                objectOutputStream.writeObject(this.msgInfoList);
                objectOutputStream.flush();
                this.msgInfoData = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (IOException e18) {
                    e = e18;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("prewrite:");
                        sb5.append(e.toString());
                        QLog.e(TAG, 2, sb5.toString());
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e19) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "prewrite:" + e19.toString());
                        }
                    }
                }
                throw th5;
            }
        } catch (IOException e26) {
            e16 = e26;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "prewrite:" + e16.toString());
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e27) {
                    e = e27;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("prewrite:");
                        sb5.append(e.toString());
                        QLog.e(TAG, 2, sb5.toString());
                    }
                }
            }
        }
    }

    public boolean setMsgInfos(ArrayList<MsgInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList)).booleanValue();
        }
        if (arrayList == null) {
            return false;
        }
        this.msgInfoList.clear();
        this.msgInfoList.addAll(arrayList);
        sortAndlimitMsgInfoList();
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "troopUin" + ContainerUtils.KEY_VALUE_DELIMITER + this.troopUin + ", msgInfo" + ContainerUtils.KEY_VALUE_DELIMITER + this.msgInfoList.toString() + ", maxImportantMsgSeq" + ContainerUtils.KEY_VALUE_DELIMITER + this.maxImportantMsgSeq;
    }

    public void updateMaxMsgSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.msgInfoList.size() > 0) {
            this.maxImportantMsgSeq = this.msgInfoList.get(0).msgSeq;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ImportantMsgItem m225clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImportantMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ImportantMsgItem importantMsgItem = new ImportantMsgItem();
        importantMsgItem.troopUin = this.troopUin;
        importantMsgItem.msgInfoList.addAll(this.msgInfoList);
        importantMsgItem.maxImportantMsgSeq = this.maxImportantMsgSeq;
        return importantMsgItem;
    }
}
