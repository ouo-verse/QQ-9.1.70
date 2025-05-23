package com.tencent.mobileqq.filemanager.data.search;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ap;
import com.tencent.mobileqq.filemanager.util.q;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends c {
    @Override // com.tencent.mobileqq.filemanager.data.search.c, com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        FileManagerEntity fileManagerEntity = this.G.get(0);
        String a16 = ap.a(fileManagerEntity.srvTime);
        String fileOperationTypeToPeer = FileManagerUtil.getFileOperationTypeToPeer(fileManagerEntity);
        String g16 = q.g(fileManagerEntity.fileSize);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(fileOperationTypeToPeer);
        sb5.append("  ");
        sb5.append(a16);
        sb5.append("  ");
        sb5.append(g16);
        this.J = sb5;
        return sb5;
    }
}
