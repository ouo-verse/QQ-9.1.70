package com.tencent.mobileqq.guild.config;

import androidx.annotation.Keep;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.config.GuildAbsLiteMCParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildFeedShareConfigParser;", "Lcom/tencent/mobileqq/guild/config/GuildAbsLiteMCParser;", "Lcom/tencent/mobileqq/guild/config/GuildFeedShareConfig;", "()V", "Holder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedShareConfigParser extends GuildAbsLiteMCParser<GuildFeedShareConfig> {

    /* renamed from: Holder, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0096\u0001R\u0014\u0010\u000b\u001a\u00020\u00028\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildFeedShareConfigParser$Holder;", "Lcom/tencent/mobileqq/guild/config/w;", "Lcom/tencent/mobileqq/guild/config/GuildFeedShareConfig;", "", "content", "c", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "d", "b", "()Lcom/tencent/mobileqq/guild/config/GuildFeedShareConfig;", DownloadInfo.spKey_Config, "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "liveConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.GuildFeedShareConfigParser$Holder, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion implements w<GuildFeedShareConfig> {

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ w<GuildFeedShareConfig> f216073d;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.mobileqq.guild.config.w
        @NotNull
        public MutableLiveData<GuildFeedShareConfig> a() {
            return this.f216073d.a();
        }

        @Override // com.tencent.mobileqq.guild.config.w
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildFeedShareConfig getConfig() {
            return this.f216073d.getConfig();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.config.a
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public GuildFeedShareConfig onParse(@Nullable byte[] content) {
            return (GuildFeedShareConfig) this.f216073d.onParse(content);
        }

        @Override // com.tencent.mobileqq.guild.config.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onUpdate(@Nullable GuildFeedShareConfig item) {
            this.f216073d.onUpdate(item);
        }

        Companion() {
            GuildAbsLiteMCParser.Companion companion = GuildAbsLiteMCParser.INSTANCE;
            this.f216073d = new GuildFeedShareConfigParser$Holder$special$$inlined$defineConfig$1("105884");
        }
    }

    public GuildFeedShareConfigParser() {
        super(INSTANCE);
    }
}
