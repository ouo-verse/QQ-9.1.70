package com.tencent.mobileqq.guild.config;

import androidx.annotation.Keep;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.config.GuildAbsLiteMCParser;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0004\u0005B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildFeedPreferConfigParser;", "Lcom/tencent/mobileqq/guild/config/GuildAbsLiteMCParser;", "Lcom/tencent/mobileqq/guild/config/GuildFeedPreferConfigParser$Data;", "()V", "Data", "Holder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedPreferConfigParser extends GuildAbsLiteMCParser<Data> {

    /* renamed from: Holder, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildFeedPreferConfigParser$Data;", "Lcom/tencent/freesia/IConfigData;", "preferSwitch", "", "nickMaxLength", "", "(ZI)V", "getNickMaxLength", "()I", "getPreferSwitch", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class Data implements IConfigData {

        @SerializedName("guild_feed_prefer_nick_max_length")
        private final int nickMaxLength;

        @SerializedName("guild_feed_prefer_switch")
        private final boolean preferSwitch;

        public Data() {
            this(false, 0 == true ? 1 : 0, 3, null);
        }

        public static /* synthetic */ Data copy$default(Data data, boolean z16, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                z16 = data.preferSwitch;
            }
            if ((i16 & 2) != 0) {
                i3 = data.nickMaxLength;
            }
            return data.copy(z16, i3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getPreferSwitch() {
            return this.preferSwitch;
        }

        /* renamed from: component2, reason: from getter */
        public final int getNickMaxLength() {
            return this.nickMaxLength;
        }

        @NotNull
        public final Data copy(boolean preferSwitch, int nickMaxLength) {
            return new Data(preferSwitch, nickMaxLength);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            if (this.preferSwitch == data.preferSwitch && this.nickMaxLength == data.nickMaxLength) {
                return true;
            }
            return false;
        }

        public final int getNickMaxLength() {
            return this.nickMaxLength;
        }

        public final boolean getPreferSwitch() {
            return this.preferSwitch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.preferSwitch;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.nickMaxLength;
        }

        @NotNull
        public String toString() {
            return "Data(preferSwitch=" + this.preferSwitch + ", nickMaxLength=" + this.nickMaxLength + ")";
        }

        public Data(boolean z16, int i3) {
            this.preferSwitch = z16;
            this.nickMaxLength = i3;
        }

        public /* synthetic */ Data(boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? true : z16, (i16 & 2) != 0 ? 6 : i3);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0096\u0001R\u0014\u0010\u000b\u001a\u00020\u00028\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildFeedPreferConfigParser$Holder;", "Lcom/tencent/mobileqq/guild/config/w;", "Lcom/tencent/mobileqq/guild/config/GuildFeedPreferConfigParser$Data;", "", "content", "c", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "d", "b", "()Lcom/tencent/mobileqq/guild/config/GuildFeedPreferConfigParser$Data;", DownloadInfo.spKey_Config, "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "liveConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.GuildFeedPreferConfigParser$Holder, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion implements w<Data> {

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ w<Data> f216068d;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.mobileqq.guild.config.w
        @NotNull
        public MutableLiveData<Data> a() {
            return this.f216068d.a();
        }

        @Override // com.tencent.mobileqq.guild.config.w
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Data getConfig() {
            return this.f216068d.getConfig();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.config.a
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Data onParse(@Nullable byte[] content) {
            return (Data) this.f216068d.onParse(content);
        }

        @Override // com.tencent.mobileqq.guild.config.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onUpdate(@Nullable Data item) {
            this.f216068d.onUpdate(item);
        }

        Companion() {
            GuildAbsLiteMCParser.Companion companion = GuildAbsLiteMCParser.INSTANCE;
            this.f216068d = new GuildFeedPreferConfigParser$Holder$special$$inlined$defineConfig$1("106110");
        }
    }

    public GuildFeedPreferConfigParser() {
        super(INSTANCE);
    }
}
