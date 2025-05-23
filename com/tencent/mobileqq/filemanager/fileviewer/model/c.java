package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends C2CFileModel {
    public c(QQAppInterface qQAppInterface, Activity activity, List<j> list, int i3) {
        super(qQAppInterface, activity, list, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int A() {
        if (!q1()) {
            return 1;
        }
        return super.A();
    }

    boolean q1() {
        if (G() != 3) {
            return false;
        }
        return FileManagerUtil.fileExist(N());
    }
}
