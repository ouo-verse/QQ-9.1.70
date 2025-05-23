package com.tencent.mobileqq.zootopia.ipc.upload;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/upload/b;", "", "", "filePath", "uuid", "Lcom/tencent/mobileqq/zootopia/ipc/upload/a;", "callback", "", "uploadFile", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZplanUploadFile.class, process = "com.tencent.mobileqq")
/* loaded from: classes35.dex */
public interface b {
    void uploadFile(String filePath, String uuid, a callback);
}
