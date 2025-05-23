package com.tencent.mobileqq.guild.discoveryv2.config;

import com.tencent.freesia.BaseConfigParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import th1.a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/config/GuildDiscRefreshConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lth1/a;", "b", "", "content", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildDiscRefreshConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        a defaultConfig = defaultConfig();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            defaultConfig.b(new String(content, Charsets.UTF_8));
        }
        return defaultConfig;
    }
}
