package com.tencent.mobileqq.vas.aiotip.api.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager;
import com.tencent.mobileqq.vas.aiotip.api.KeywordLimitConfig;
import com.tencent.mobileqq.vas.graytips.api.IVasGrayTips;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip$FromChannel;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasAioTipManagerImpl implements IVasAioTipManager {
    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public String[] getDirtyWords() {
        return com.tencent.mobileqq.vip.b.c().f312926i;
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public KeywordLimitConfig getKeywordLimitConfig() {
        return new KeywordLimitConfig(com.tencent.mobileqq.vip.b.c().f312919b, com.tencent.mobileqq.vip.b.c().f312922e, com.tencent.mobileqq.vip.b.c().f312920c, com.tencent.mobileqq.vip.b.c().f312923f, com.tencent.mobileqq.vip.b.c().f312921d, com.tencent.mobileqq.vip.b.c().f312924g);
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public String[] getKeywords() {
        return com.tencent.mobileqq.vip.b.f312916l;
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public boolean isGray(int i3, String str) {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public void requestUnitGrayTips(int i3, int i16, @NonNull String str, @Nullable Map<String, String> map, @Nullable BusinessObserver businessObserver) {
        UniGrayTip$FromChannel uniGrayTip$FromChannel = new UniGrayTip$FromChannel();
        uniGrayTip$FromChannel.channel.set(i16);
        uniGrayTip$FromChannel.fromUin.set(str);
        ((IVasGrayTips) QRoute.api(IVasGrayTips.class)).requestUnitGrayTips(i3, uniGrayTip$FromChannel, map, businessObserver);
    }

    @Override // com.tencent.mobileqq.vas.aiotip.api.IVasAioTipManager
    public int transformFrom(int i3) {
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        return 1;
    }
}
