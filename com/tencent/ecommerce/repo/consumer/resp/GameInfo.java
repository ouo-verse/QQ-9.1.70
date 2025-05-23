package com.tencent.ecommerce.repo.consumer.resp;

import com.tencent.imsdk.BuildConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/GameInfo;", "", "()V", BuildConfig.FLAVOR, "Lcom/tencent/ecommerce/repo/consumer/resp/GameBasicInfo;", "getBasic", "()Lcom/tencent/ecommerce/repo/consumer/resp/GameBasicInfo;", "download", "Lcom/tencent/ecommerce/repo/consumer/resp/GameDownLoadInfo;", "getDownload", "()Lcom/tencent/ecommerce/repo/consumer/resp/GameDownLoadInfo;", "privilege", "Lcom/tencent/ecommerce/repo/consumer/resp/GamePrivilegeInfo;", "getPrivilege", "()Lcom/tencent/ecommerce/repo/consumer/resp/GamePrivilegeInfo;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class GameInfo {
    private final GameBasicInfo basic = new GameBasicInfo();
    private final GamePrivilegeInfo privilege = new GamePrivilegeInfo();
    private final GameDownLoadInfo download = new GameDownLoadInfo();

    public final GameBasicInfo getBasic() {
        return this.basic;
    }

    public final GameDownLoadInfo getDownload() {
        return this.download;
    }

    public final GamePrivilegeInfo getPrivilege() {
        return this.privilege;
    }
}
