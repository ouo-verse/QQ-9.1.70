package com.tencent.biz.qqcircle.immersive.redpacket.task;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "T", "", "value", "", "onSuccess", "(Ljava/lang/Object;)V", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "errorCode", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public interface o<T> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ void a(o oVar, ErrorCode errorCode, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    errorCode = ErrorCode.INSTANCE.a();
                }
                oVar.a(errorCode);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
        }
    }

    void a(@NotNull ErrorCode errorCode);

    void onSuccess(T value);
}
