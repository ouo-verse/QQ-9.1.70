package com.tencent.biz.richframework.publish.base.interfaces;

import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H'\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileStateHandler;", "T", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "handle", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "file", "(Ljava/lang/Object;)Lcom/tencent/biz/richframework/publish/base/RFWPublishFile$FileState;", "rfw-upload_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public interface IRFWPublishFileStateHandler<T> extends IRFWLog {
    RFWPublishFile.FileState handle(T file);
}
