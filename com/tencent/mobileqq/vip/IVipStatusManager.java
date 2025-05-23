package com.tencent.mobileqq.vip;

import com.tencent.mobileqq.vas.api.IVasManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vip/IVipStatusManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "getPrivilegeFlags", "", "uin", "", "isBigClub", "", "isSVip", "isStar", "isSuperQQ", "isVip", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IVipStatusManager extends IVasManager {
    int getPrivilegeFlags(@Nullable String uin);

    boolean isBigClub();

    boolean isSVip();

    boolean isStar();

    boolean isSuperQQ();

    boolean isVip();
}
