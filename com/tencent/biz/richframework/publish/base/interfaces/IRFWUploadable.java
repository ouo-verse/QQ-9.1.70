package com.tencent.biz.richframework.publish.base.interfaces;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadable;", "T", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "genUploadTask", "()Ljava/lang/Object;", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface IRFWUploadable<T> extends IRFWLog {
    T genUploadTask();
}
