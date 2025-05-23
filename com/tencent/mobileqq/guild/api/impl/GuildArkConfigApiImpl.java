package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildArkConfigApi;
import com.tencent.mobileqq.guild.data.ark.ArkHeightCache;
import com.tencent.mobileqq.guild.util.bw;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildArkConfigApiImpl implements IGuildArkConfigApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildArkConfigApi
    public ArkHeightCache getHeightCache(String str, String str2) {
        return bw.g(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildArkConfigApi
    public void saveHeightCache(String str, String str2, ArkHeightCache arkHeightCache) {
        if (arkHeightCache == null) {
            return;
        }
        bw.I0(str, str2, arkHeightCache);
    }
}
