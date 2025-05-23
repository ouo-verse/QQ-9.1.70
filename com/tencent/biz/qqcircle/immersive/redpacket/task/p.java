package com.tencent.biz.qqcircle.immersive.redpacket.task;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/p;", "DATA", "", "", "a", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", "b", "(Ljava/lang/Object;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;)V", "cancel", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public interface p<DATA> {
    @NotNull
    String a();

    void b(DATA data, @NotNull o<DATA> callback);

    void cancel();
}
