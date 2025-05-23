package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends f {
    public g(QQAppInterface qQAppInterface, String str, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface);
        int i3;
        boolean z16 = false;
        int i16 = 0;
        for (FileManagerEntity fileManagerEntity2 : new ArrayList(qQAppInterface.getFileManagerProxy().t())) {
            if (str == null || str.equals(fileManagerEntity2.peerUin)) {
                if (w(fileManagerEntity2.nFileType, fileManagerEntity2.getCloudType())) {
                    if (!z16 && fileManagerEntity2.nSessionId == fileManagerEntity.nSessionId) {
                        this.f209030i = i16;
                        z16 = true;
                    }
                    if (fileManagerEntity2.nFileType == 2 && !FileUtils.fileExistsAndNotEmpty(fileManagerEntity2.getFilePath())) {
                        if (!fileManagerEntity2.isSend() || (i3 = fileManagerEntity2.status) == 1 || i3 == -1) {
                            int i17 = fileManagerEntity.peerType;
                            if (i17 != 0 && i17 != 3000) {
                            }
                        }
                    }
                    this.f209027e.add(b(i16, fileManagerEntity2));
                    this.f209028f.add(mb1.a.f416517a.d(fileManagerEntity2));
                    j f16 = com.tencent.mobileqq.filemanager.fileviewer.d.f(qQAppInterface, fileManagerEntity2);
                    this.C.put(String.valueOf(fileManagerEntity2.nSessionId), Integer.valueOf(i16));
                    this.f209031m.add(f16);
                    i16++;
                }
            }
        }
        u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        r3 = r2.f209603d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r3 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r3.equalsIgnoreCase(r9.f209603d) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        r6.f209030i = r0;
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g(QQAppInterface qQAppInterface, List<WeiYunFileInfo> list, WeiYunFileInfo weiYunFileInfo) {
        super(qQAppInterface);
        Iterator<WeiYunFileInfo> it = list.iterator();
        int i3 = 0;
        boolean z16 = false;
        while (it.hasNext()) {
            WeiYunFileInfo next = it.next();
            int fileType = FileManagerUtil.getFileType(next.f209605f);
            if (fileType == 0 || fileType == 2 || (next.K && next.f209605f.toLowerCase().endsWith("heic"))) {
                j g16 = com.tencent.mobileqq.filemanager.fileviewer.d.g(qQAppInterface, next);
                this.f209027e.add(c(i3, g16));
                this.f209028f.add(h(g16));
                if (g16.getEntity() != null) {
                    this.C.put(String.valueOf(g16.getEntity().nSessionId), Integer.valueOf(i3));
                } else {
                    this.C.put(String.valueOf(g16.getSessionId()), Integer.valueOf(i3));
                }
                this.f209031m.add(g16);
                i3++;
            }
        }
        u();
    }
}
