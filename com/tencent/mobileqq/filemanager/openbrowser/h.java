package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h extends f {
    public h(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        z(0);
        y(this.f209027e.size());
        A(this.f209027e.size());
        u();
    }

    private void A(int i3) {
        Iterator<WeiYunFileInfo> it = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getWeiYunFiles().iterator();
        while (it.hasNext()) {
            WeiYunFileInfo next = it.next();
            if (FileManagerUtil.getFileType(next.f209605f) == 0) {
                j g16 = com.tencent.mobileqq.filemanager.fileviewer.d.g(this.f209026d, next);
                this.C.put(String.valueOf(g16.getSessionId()), Integer.valueOf(i3));
                this.f209027e.add(c(i3, g16));
                this.f209031m.add(g16);
                this.f209028f.add(h(g16));
                i3++;
            }
        }
    }

    private void y(int i3) {
        for (FileInfo fileInfo : ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles()) {
            if (fileInfo.getType() == 0) {
                j h16 = com.tencent.mobileqq.filemanager.fileviewer.d.h(fileInfo);
                this.f209027e.add(c(i3, h16));
                this.f209031m.add(h16);
                this.f209028f.add(mb1.a.f416517a.c(fileInfo));
                i3++;
            }
        }
    }

    private void z(int i3) {
        Iterator<FileManagerEntity> it = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getRecentFiles().iterator();
        while (it.hasNext()) {
            FileManagerEntity next = it.next();
            if (next.nFileType == 0) {
                j f16 = com.tencent.mobileqq.filemanager.fileviewer.d.f(this.f209026d, next);
                this.f209027e.add(c(i3, f16));
                this.C.put(String.valueOf(f16.getSessionId()), Integer.valueOf(i3));
                this.f209031m.add(f16);
                this.f209028f.add(mb1.a.f416517a.d(next));
                i3++;
            }
        }
    }
}
