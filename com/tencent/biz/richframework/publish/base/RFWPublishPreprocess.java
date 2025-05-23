package com.tencent.biz.richframework.publish.base;

import com.tencent.biz.richframework.publish.base.interfaces.IRFWProcessable;
import com.tencent.biz.richframework.publish.base.interfaces.ProcessState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/RFWPublishPreprocess;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWProcessable;", "()V", "state", "Lcom/tencent/biz/richframework/publish/base/interfaces/ProcessState;", "rfw-upload_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public abstract class RFWPublishPreprocess implements IRFWProcessable {
    private ProcessState state = ProcessState.WAITING;
}
