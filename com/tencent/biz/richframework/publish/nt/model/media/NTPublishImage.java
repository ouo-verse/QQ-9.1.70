package com.tencent.biz.richframework.publish.nt.model.media;

import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.qqnt.kernel.nativeinterface.FileClass;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaBusinessType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishImage;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "filePath", "", "(Ljava/lang/String;)V", "genBizExtInfo", "", "genUploadTask", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTask;", "rfw-upload_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public abstract class NTPublishImage extends NTPublishFile {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPublishImage(String filePath) {
        super(filePath);
        Intrinsics.checkNotNullParameter(filePath, "filePath");
    }

    public byte[] genBizExtInfo() {
        return new byte[0];
    }

    @Override // com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile, com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadable
    public BatchUploadTask genUploadTask() {
        BatchUploadTask genUploadTask = super.genUploadTask();
        genUploadTask.fileInfo.fileType.klass = FileClass.KFILECLASSPICTURE.ordinal();
        genUploadTask.businessType = RichMediaBusinessType.KBUSINESSTYPEPICTURE.ordinal();
        byte[] genBizExtInfo = genBizExtInfo();
        if (!(genBizExtInfo.length == 0)) {
            genUploadTask.bizTransInfo = genBizExtInfo;
        }
        return genUploadTask;
    }
}
