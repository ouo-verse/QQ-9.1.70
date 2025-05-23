package com.tencent.hydevteam.common.progress;

import com.tencent.hydevteam.common.annotation.API;
import java.util.concurrent.Future;

@API
/* loaded from: classes7.dex */
public interface ProgressFuture<T> extends Progress, Future<T> {
}
