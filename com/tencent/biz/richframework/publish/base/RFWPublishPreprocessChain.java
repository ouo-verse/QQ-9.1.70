package com.tencent.biz.richframework.publish.base;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.ProcessState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/RFWPublishPreprocessChain;", "", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "file", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "executePreprocess", "Ljava/util/ArrayList;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishPreprocess;", "Lkotlin/collections/ArrayList;", "processChain", "Ljava/util/ArrayList;", "<init>", "()V", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class RFWPublishPreprocessChain {
    private final ArrayList<RFWPublishPreprocess> processChain = new ArrayList<>();

    public final RFWPublishFile.FileState executePreprocess(RFWPublishFile<?> file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.getState() != RFWPublishFile.FileState.PROCESSING) {
            RFWLog.e(file.getLogTag(), RFWLog.USR, "not in file processing step,current:" + file.getState().name());
            return file.getState();
        }
        Iterator<RFWPublishPreprocess> it = this.processChain.iterator();
        while (it.hasNext()) {
            RFWPublishPreprocess next = it.next();
            if (next.process(file) == ProcessState.FAILED) {
                RFWLog.e(file.getLogTag(), RFWLog.USR, "Error in step " + next);
                file.setState(RFWPublishFile.FileState.ERROR);
                return file.getState();
            }
        }
        file.setState(RFWPublishFile.FileState.READY_TO_UPLOAD);
        return file.getState();
    }
}
