package com.tencent.mobileqq.guild.config;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildQUIProfileConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/GuildQUIProfileConfig;", "b", "", "content", "c", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildQUIProfileConfigParser extends BaseConfigParser<GuildQUIProfileConfig> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GuildQUIProfileConfig defaultConfig() {
        return new GuildQUIProfileConfig(false, null, null, null, null, 31, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GuildQUIProfileConfig parse(@NotNull byte[] content) {
        GuildQUIProfileConfig guildQUIProfileConfig;
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                Log.d("Guild.GuildQUIProfileConfigParser", "parse json, content " + new String(content, UTF_8));
            }
            Gson gson = new Gson();
            Charset UTF_82 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
            Object fromJson = gson.fromJson(new String(content, UTF_82), (Class<Object>) GuildQUIProfileConfig.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(String(c\u2026rofileConfig::class.java)");
            return (GuildQUIProfileConfig) fromJson;
        } catch (JsonSyntaxException unused) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            Charset UTF_83 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_83, "UTF_8");
            String str = "parse json error, content " + new String(content, UTF_83);
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.GuildQUIProfileConfigParser", 1, (String) it.next(), null);
            }
            guildQUIProfileConfig = o.f216156a;
            return guildQUIProfileConfig;
        }
    }
}
