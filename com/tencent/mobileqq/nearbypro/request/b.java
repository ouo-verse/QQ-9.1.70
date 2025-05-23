package com.tencent.mobileqq.nearbypro.request;

import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001H&\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/b;", "Req", "Rsp", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/nearbypro/request/d;", "rspStatus", "rsp", "", "a", "(Ljava/lang/Object;Lcom/tencent/mobileqq/nearbypro/request/d;Ljava/lang/Object;)V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b<Req, Rsp> {
    void a(Req request, @NotNull RspStatus rspStatus, @Nullable Rsp rsp);
}
