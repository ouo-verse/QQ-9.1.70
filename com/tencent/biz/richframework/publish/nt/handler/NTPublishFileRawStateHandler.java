package com.tencent.biz.richframework.publish.nt.handler;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileStateHandler;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import com.tencent.weiyun.utils.IOUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/handler/NTPublishFileRawStateHandler;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileStateHandler;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "()V", "getLogTag", "", "handle", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "file", "toString", "Companion", "rfw-upload_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class NTPublishFileRawStateHandler implements IRFWPublishFileStateHandler<NTPublishFile> {
    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "NTPublishFileRawStateHandler";
    }

    public String toString() {
        return "NTPublishFileRawStateHandler";
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileStateHandler
    public RFWPublishFile.FileState handle(NTPublishFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String[] fileSha1AndMd5 = IOUtils.getFileSha1AndMd5(file.getFilePath());
        if (fileSha1AndMd5.length < 2) {
            RFWLog.e(getLogTag(), RFWLog.USR, "handle getFileSha1AndMd5 error!file:" + file + ",filePath:" + file.getFilePath());
            file.setState(RFWPublishFile.FileState.ERROR);
            return file.getState();
        }
        file.setSha1(fileSha1AndMd5[0]);
        file.setMd5(fileSha1AndMd5[1]);
        file.setFileSize(IOUtils.getFileSize(file.getFilePath()));
        file.setFileName(IOUtils.getFileName(file.getFilePath()));
        file.setState(RFWPublishFile.FileState.PROCESSING);
        return file.getState();
    }
}
