package com.tencent.biz.qqcircle.immersive.redpacket.task;

import com.tencent.biz.qqcircle.immersive.redpacket.task.o;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \t*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/g;", "DATA", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/e;", "", "a", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", "b", "(Ljava/lang/Object;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;)V", "c", "()Ljava/lang/String;", "tag", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g<DATA> extends e<DATA> {
    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    @NotNull
    public String a() {
        return "CheckNetworkProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    public void b(DATA data, @NotNull o<DATA> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("CheckNetworkProcess", 1, "doProcess, network is not available ");
            o.a.a(callback, null, 1, null);
        } else {
            QLog.d("CheckNetworkProcess", 1, "doProcess, network is available ");
            callback.onSuccess(data);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e
    @NotNull
    public String c() {
        return "CheckNetworkProcess";
    }
}
