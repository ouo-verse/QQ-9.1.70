package com.tencent.mobileqq.guild.hippy.impl;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.guild.hippy.IGuildHippyApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import po1.b;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildHippyApiImpl implements IGuildHippyApi {
    @Override // com.tencent.mobileqq.guild.hippy.IGuildHippyApi
    public HippyAPIProvider getGuildHippyApiProvider() {
        return new b();
    }

    @Override // com.tencent.mobileqq.guild.hippy.IGuildHippyApi
    public boolean isGuildModule(String str) {
        return TextUtils.equals(str, HippyQQConstants.ModuleName.QQ_GUILD);
    }
}
