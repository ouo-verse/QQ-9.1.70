package com.tencent.mobileqq.filemanager.fileviewer.data;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.j;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends c {
    public e(j jVar) {
        super(jVar);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.c, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public boolean c(String str) {
        String str2;
        FileManagerEntity entity = this.f208234a.getEntity();
        if (entity == null || (str2 = entity.strTroopFilePath) == null || !str2.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
