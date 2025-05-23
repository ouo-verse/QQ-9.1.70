package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildHomeApi;
import com.tencent.mobileqq.guild.home.parts.GuildHomeSubFragmentPart;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildHomeApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildHomeApi;", "", "enable", "", "changeGuildHomeTabListLog", "", "getVisitorBarHeight", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildHomeApiImpl implements IGuildHomeApi {

    @NotNull
    private static final String TAG = "GuildHomeTabListLogApiImpl";

    @Override // com.tencent.mobileqq.guild.api.IGuildHomeApi
    public void changeGuildHomeTabListLog(boolean enable) {
        GuildHomeSubFragmentPart.INSTANCE.c(enable);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHomeApi
    public int getVisitorBarHeight() {
        return ViewUtils.dpToPx(100.0f);
    }
}
