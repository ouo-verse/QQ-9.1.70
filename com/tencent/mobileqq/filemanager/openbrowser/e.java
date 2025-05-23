package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends f {
    public e(QQAppInterface qQAppInterface, List<FileInfo> list, FileInfo fileInfo) {
        super(qQAppInterface);
        boolean z16 = false;
        int i3 = 0;
        for (FileInfo fileInfo2 : list) {
            if (w(fileInfo2.getType(), 3)) {
                if (!z16 && fileInfo2.j().equals(fileInfo.j()) && fileInfo2.l() == fileInfo.l() && fileInfo2.e() == fileInfo.e()) {
                    this.f209030i = i3;
                    z16 = true;
                }
                this.f209027e.add(a(i3, fileInfo2));
                this.f209028f.add(mb1.a.f416517a.c(fileInfo2));
                this.f209031m.add(com.tencent.mobileqq.filemanager.fileviewer.d.h(fileInfo2));
                i3++;
            }
        }
    }

    public e(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface);
        this.f209027e.add(b(0, fileManagerEntity));
        this.f209028f.add(mb1.a.f416517a.d(fileManagerEntity));
        this.f209031m.add(com.tencent.mobileqq.filemanager.fileviewer.d.f(qQAppInterface, fileManagerEntity));
    }
}
