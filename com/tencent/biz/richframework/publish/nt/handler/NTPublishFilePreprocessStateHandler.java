package com.tencent.biz.richframework.publish.nt.handler;

import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileStateHandler;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/handler/NTPublishFilePreprocessStateHandler;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileStateHandler;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "file", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "handle", "", "toString", "<init>", "()V", "Companion", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class NTPublishFilePreprocessStateHandler implements IRFWPublishFileStateHandler<NTPublishFile> {
    public String toString() {
        return "NTPublishFilePreprocessStateHandler";
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileStateHandler
    public RFWPublishFile.FileState handle(NTPublishFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.executePreprocess();
    }
}
