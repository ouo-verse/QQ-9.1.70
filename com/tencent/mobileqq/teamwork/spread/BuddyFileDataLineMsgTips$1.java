package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes18.dex */
class BuddyFileDataLineMsgTips$1 implements Runnable {
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        final List<FileManagerEntity> T = this.this$0.f292381a.getFileManagerProxy().T(this.this$0.f292382b);
        if (T != null && T.size() != 0) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.BuddyFileDataLineMsgTips$1.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(T);
                    if (QLog.isColorLevel()) {
                        QLog.i("BuddyFileDataLineMsgTips", 1, "sub Thread getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
                    }
                    ArrayList arrayList2 = new ArrayList();
                    StringTokenizer stringTokenizer = new StringTokenizer(TencentDocDataLineTipsConfigProcessor.a().d(), "|");
                    if (!stringTokenizer.hasMoreTokens()) {
                        if (QLog.isColorLevel()) {
                            QLog.i("BuddyFileDataLineMsgTips", 1, "config filetype is null");
                        }
                        BuddyFileDataLineMsgTips$1.this.getClass();
                        throw null;
                    }
                    int countTokens = stringTokenizer.countTokens();
                    String[] strArr = new String[countTokens];
                    int i3 = 0;
                    while (stringTokenizer.hasMoreTokens()) {
                        strArr[i3] = stringTokenizer.nextToken();
                        i3++;
                    }
                    long K0 = com.tencent.mobileqq.service.message.e.K0() * 1000;
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FileManagerEntity fileManagerEntity = (FileManagerEntity) it.next();
                        String[] strArr2 = strArr;
                        if (fileManagerEntity.uniseq != BuddyFileDataLineMsgTips$1.this.this$0.f292384d.uniseq) {
                            if (fileManagerEntity.srvTime - K0 > 86400000) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("BuddyFileDataLineMsgTips", 1, "file is over 24h");
                                }
                            } else {
                                String j3 = q.j(fileManagerEntity.fileName);
                                int i16 = 0;
                                while (true) {
                                    if (i16 < countTokens) {
                                        if (strArr2[i16].equalsIgnoreCase(j3)) {
                                            z16 = true;
                                            break;
                                        }
                                        i16++;
                                    } else {
                                        z16 = false;
                                        break;
                                    }
                                }
                                if (z16) {
                                    arrayList2.add(fileManagerEntity.fileName);
                                }
                            }
                        }
                        strArr = strArr2;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("BuddyFileDataLineMsgTips", 1, "find file msg count[" + arrayList2.size() + "]");
                    }
                    BuddyFileDataLineMsgTips$1.this.getClass();
                    throw null;
                }
            }, 8, null, true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BuddyFileDataLineMsgTips", 1, "current AIO has not File,peerType[" + this.this$0.f292383c + "]");
        }
        new ArrayList();
        throw null;
    }
}
