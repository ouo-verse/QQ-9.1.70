package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.teamwork.spread.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BuddyFileAIOMsgTips extends a {
    public BuddyFileAIOMsgTips(QQAppInterface qQAppInterface, ChatMessage chatMessage, ConfigSetting configSetting) {
        super(qQAppInterface, chatMessage, configSetting);
    }

    @Override // com.tencent.mobileqq.teamwork.spread.a
    protected String a() {
        return ((MessageForFile) this.f292379d).fileName;
    }

    @Override // com.tencent.mobileqq.teamwork.spread.a
    protected void b(final a.InterfaceC8642a interfaceC8642a) {
        if (QLog.isColorLevel()) {
            QLog.i("BuddyFileAIOMsgTips", 1, "getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1
            @Override // java.lang.Runnable
            public void run() {
                final List<FileManagerEntity> T = BuddyFileAIOMsgTips.this.f292376a.getFileManagerProxy().T(BuddyFileAIOMsgTips.this.f292377b);
                if (T != null && T.size() != 0) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z16;
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(T);
                            if (QLog.isColorLevel()) {
                                QLog.i("BuddyFileAIOMsgTips", 1, "sub Thread getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
                            }
                            ArrayList arrayList2 = new ArrayList();
                            StringTokenizer stringTokenizer = new StringTokenizer(TencentDocTipsConfigProcessor.a().h(), "|");
                            if (!stringTokenizer.hasMoreTokens()) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("BuddyFileAIOMsgTips", 1, "config filetype is null");
                                }
                                interfaceC8642a.a(arrayList2);
                                return;
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
                                if (fileManagerEntity.uniseq != BuddyFileAIOMsgTips.this.f292379d.uniseq) {
                                    if (fileManagerEntity.srvTime - K0 > 86400000) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("BuddyFileAIOMsgTips", 1, "file is over 24h");
                                        }
                                    } else {
                                        String j3 = q.j(fileManagerEntity.fileName);
                                        int i16 = 0;
                                        while (true) {
                                            if (i16 < countTokens) {
                                                if (strArr[i16].equalsIgnoreCase(j3)) {
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
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("BuddyFileAIOMsgTips", 1, "find file msg count[" + arrayList2.size() + "]");
                            }
                            interfaceC8642a.a(arrayList2);
                        }
                    }, 8, null, true);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("BuddyFileAIOMsgTips", 1, "current AIO has not File,peerType[" + BuddyFileAIOMsgTips.this.f292378c + "]");
                }
                interfaceC8642a.a(new ArrayList());
            }
        });
    }
}
