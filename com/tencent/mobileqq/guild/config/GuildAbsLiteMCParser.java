package com.tencent.mobileqq.guild.config;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0016*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001\u0017B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0014\u00a2\u0006\u0004\b\u0011\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildAbsLiteMCParser;", "Lcom/tencent/freesia/IConfigData;", "Item", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/a;", "", "content", "onParse", "([B)Lcom/tencent/freesia/IConfigData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onUpdate", "(Lcom/tencent/freesia/IConfigData;)V", "parse", "defaultConfig", "()Lcom/tencent/freesia/IConfigData;", DownloadInfo.spKey_Config, "doOnConfigUpdate", "Lcom/tencent/mobileqq/guild/config/w;", "holder", "<init>", "(Lcom/tencent/mobileqq/guild/config/w;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class GuildAbsLiteMCParser<Item extends IConfigData> extends BaseConfigParser<Item> implements a<Item> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final /* synthetic */ w<Item> $$delegate_0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildAbsLiteMCParser$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.GuildAbsLiteMCParser$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public GuildAbsLiteMCParser(@NotNull w<Item> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.$$delegate_0 = holder;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public Item defaultConfig() {
        return onParse(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    public void doOnConfigUpdate(@Nullable Item config) {
        onUpdate(config);
    }

    @Override // com.tencent.mobileqq.guild.config.a
    @NotNull
    public Item onParse(@Nullable byte[] content) {
        return (Item) this.$$delegate_0.onParse(content);
    }

    @Override // com.tencent.mobileqq.guild.config.a
    public void onUpdate(@Nullable Item item) {
        this.$$delegate_0.onUpdate(item);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    public Item parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return onParse(content);
    }
}
