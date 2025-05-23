package com.tencent.biz.richframework.publish.base.interfaces;

import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H'\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWProcessable;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "process", "Lcom/tencent/biz/richframework/publish/base/interfaces/ProcessState;", "file", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "rfw-upload_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public interface IRFWProcessable extends IRFWLog {
    ProcessState process(RFWPublishFile<?> file);
}
