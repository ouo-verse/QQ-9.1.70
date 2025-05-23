package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.temp.api.IGuildBackgroundApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildBackgroundApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildBackgroundApi;", "Lr02/a;", "getGuildBackground", "", "getSkinAioInputBg", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildBackgroundApiImpl implements IGuildBackgroundApi {
    @Override // com.tencent.mobileqq.guild.temp.api.IGuildBackgroundApi
    public r02.a getGuildBackground() {
        return bf1.a.f28353a;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildBackgroundApi
    public int getSkinAioInputBg() {
        return R.drawable.skin_aio_input_bar_bg_theme_version2;
    }
}
