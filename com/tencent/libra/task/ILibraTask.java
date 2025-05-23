package com.tencent.libra.task;

import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ILibraTask extends Runnable {
    void cancel();

    String getLogTag();

    Option getOption();

    @Override // java.lang.Runnable
    void run();
}
