package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import com.tencent.mobileqq.guild.widget.adapterdelegates.e;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001&B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\tH\u00c6\u0003J\t\u0010\f\u001a\u00020\u0004H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0012\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\u0010\u0010 \"\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/e;", "Ljava/io/Serializable;", "newItem", "", "areItemsTheSame", "areContentsTheSame", "", "component1", "", "component2", "component3", "component4", "id", "name", "icon", "isCheck", "copy", "toString", "", "hashCode", "", "other", "equals", "J", "getId", "()J", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getIcon", "Z", "()Z", "setCheck", "(Z)V", "<init>", "(JLjava/lang/String;Ljava/lang/String;Z)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class ConfigIconItem implements com.tencent.mobileqq.guild.widget.adapterdelegates.e<ConfigIconItem>, Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String icon;
    private final long id;
    private boolean isCheck;

    @NotNull
    private final String name;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildNavIconInfo;", "data", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConfigIconItem a(@NotNull IGProGuildNavIconInfo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            long iconId = data.getIconId();
            String iconName = data.getIconName();
            Intrinsics.checkNotNullExpressionValue(iconName, "data.iconName");
            String iconUrl = data.getIconUrl();
            Intrinsics.checkNotNullExpressionValue(iconUrl, "data.iconUrl");
            return new ConfigIconItem(iconId, iconName, iconUrl, false);
        }

        Companion() {
        }
    }

    public ConfigIconItem(long j3, @NotNull String name, @NotNull String icon, boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = j3;
        this.name = name;
        this.icon = icon;
        this.isCheck = z16;
    }

    public static /* synthetic */ ConfigIconItem copy$default(ConfigIconItem configIconItem, long j3, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = configIconItem.id;
        }
        long j16 = j3;
        if ((i3 & 2) != 0) {
            str = configIconItem.name;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = configIconItem.icon;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            z16 = configIconItem.isCheck;
        }
        return configIconItem.copy(j16, str3, str4, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsCheck() {
        return this.isCheck;
    }

    @NotNull
    public final ConfigIconItem copy(long id5, @NotNull String name, @NotNull String icon, boolean isCheck) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new ConfigIconItem(id5, name, icon, isCheck);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigIconItem)) {
            return false;
        }
        ConfigIconItem configIconItem = (ConfigIconItem) other;
        if (this.id == configIconItem.id && Intrinsics.areEqual(this.name, configIconItem.name) && Intrinsics.areEqual(this.icon, configIconItem.icon) && this.isCheck == configIconItem.isCheck) {
            return true;
        }
        return false;
    }

    @Nullable
    public Object getChangePayload(@NotNull ConfigIconItem configIconItem) {
        return e.a.a(this, configIconItem);
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((androidx.fragment.app.a.a(this.id) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31;
        boolean z16 = this.isCheck;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    public final boolean isCheck() {
        return this.isCheck;
    }

    public final void setCheck(boolean z16) {
        this.isCheck = z16;
    }

    @NotNull
    public String toString() {
        return "ConfigIconItem(id=" + this.id + ", name=" + this.name + ", icon=" + this.icon + ", isCheck=" + this.isCheck + ")";
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.e
    public boolean areContentsTheSame(@NotNull ConfigIconItem newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(this.icon, newItem.icon) && this.isCheck == newItem.isCheck && Intrinsics.areEqual(this.name, newItem.name);
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.e
    public boolean areItemsTheSame(@NotNull ConfigIconItem newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return this.id == newItem.id;
    }
}
