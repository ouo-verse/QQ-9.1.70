package com.tencent.mobileqq.vas.aiotip.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager;
import com.tencent.mobileqq.vas.aiotip.api.KeywordLimitConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J@\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00052\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/aiotip/api/impl/VasAioTipManagerNtImpl;", "Lcom/tencent/mobileqq/vas/aiotip/api/IVasAioTipManager;", "()V", "getDirtyWords", "", "", "()[Ljava/lang/String;", "getKeywordLimitConfig", "Lcom/tencent/mobileqq/vas/aiotip/api/KeywordLimitConfig;", "getKeywords", "isGray", "", "sessionCurType", "", "curFriendUin", "requestUnitGrayTips", "", "cmd", WadlProxyConsts.CHANNEL, "fromUin", "map", "", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "transformFrom", "peerType", "vas_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasAioTipManagerNtImpl implements IVasAioTipManager {
    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    @Nullable
    public String[] getDirtyWords() {
        return new String[0];
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    @NotNull
    public KeywordLimitConfig getKeywordLimitConfig() {
        return new KeywordLimitConfig(1, 86400L, 1, 86400L, 1, 86400L);
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    @NotNull
    public String[] getKeywords() {
        return new String[]{"\u88c5\u626e"};
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public boolean isGray(int sessionCurType, @Nullable String curFriendUin) {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public void requestUnitGrayTips(int cmd, int channel, @NotNull String fromUin, @Nullable Map<String, String> map, @Nullable BusinessObserver observer) {
        Intrinsics.checkNotNullParameter(fromUin, "fromUin");
        if (observer != null) {
            observer.onUpdate(1, true, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public int transformFrom(int peerType) {
        if (peerType == 2) {
            return 2;
        }
        if (peerType == 3) {
            return 3;
        }
        return 1;
    }
}
