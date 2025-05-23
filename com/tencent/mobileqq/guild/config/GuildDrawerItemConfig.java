package com.tencent.mobileqq.guild.config;

import androidx.annotation.Keep;
import com.tencent.freesia.IConfigData;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildDrawerItemConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", VideoTemplateParser.ITEM_LIST, "", "Lcom/tencent/mobileqq/guild/config/GuildDrawerItemConfig$DrawerItem;", "getItemList", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "toString", "", "DrawerItem", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildDrawerItemConfig implements IConfigData {

    @NotNull
    private List<DrawerItem> itemList;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildDrawerItemConfig$DrawerItem;", "", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "id", "getId", "setId", "name", "getName", "setName", QZoneDTLoginReporter.SCHEMA, "getSchema", "setSchema", "type", "getType", "setType", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class DrawerItem {

        @Nullable
        private String id = "";

        @Nullable
        private String name = "";

        @Nullable
        private String icon = "";

        @Nullable
        private String schema = "";

        @Nullable
        private String type = "";

        @Nullable
        public final String getIcon() {
            return this.icon;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getSchema() {
            return this.schema;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setIcon(@Nullable String str) {
            this.icon = str;
        }

        public final void setId(@Nullable String str) {
            this.id = str;
        }

        public final void setName(@Nullable String str) {
            this.name = str;
        }

        public final void setSchema(@Nullable String str) {
            this.schema = str;
        }

        public final void setType(@Nullable String str) {
            this.type = str;
        }

        @NotNull
        public String toString() {
            return "DrawerItem(name='" + this.name + "', icon='" + this.icon + "', schema='" + this.schema + "', type=" + this.type + ")";
        }
    }

    public GuildDrawerItemConfig() {
        List<DrawerItem> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.itemList = emptyList;
    }

    @NotNull
    public final List<DrawerItem> getItemList() {
        return this.itemList;
    }

    public final void setItemList(@NotNull List<DrawerItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.itemList = list;
    }

    @NotNull
    public String toString() {
        return "GuildDrawerItemConfig(itemList=" + this.itemList + ")";
    }
}
