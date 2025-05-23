package com.tencent.tavcut.core.render.builder.light.model.properties;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J]\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020'H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e\u00a8\u0006("}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/properties/Properties;", "", TtmlNode.TAG_LAYOUT, "Lcom/tencent/tavcut/core/render/builder/light/model/properties/Layout;", "boundsTrackerPlaceHolders", "Lcom/google/gson/JsonArray;", "musicIDs", "fonts", "movieConfig", "Lcom/google/gson/JsonObject;", "materialConfigs", "resourceIDs", "(Lcom/tencent/tavcut/core/render/builder/light/model/properties/Layout;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;)V", "getBoundsTrackerPlaceHolders", "()Lcom/google/gson/JsonArray;", "getFonts", "getLayout", "()Lcom/tencent/tavcut/core/render/builder/light/model/properties/Layout;", "setLayout", "(Lcom/tencent/tavcut/core/render/builder/light/model/properties/Layout;)V", "getMaterialConfigs", "getMovieConfig", "()Lcom/google/gson/JsonObject;", "getMusicIDs", "getResourceIDs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class Properties {

    @Nullable
    private final JsonArray boundsTrackerPlaceHolders;

    @Nullable
    private final JsonArray fonts;

    @Nullable
    private Layout layout;

    @Nullable
    private final JsonArray materialConfigs;

    @Nullable
    private final JsonObject movieConfig;

    @Nullable
    private final JsonArray musicIDs;

    @Nullable
    private final JsonArray resourceIDs;

    public Properties() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Properties copy$default(Properties properties, Layout layout, JsonArray jsonArray, JsonArray jsonArray2, JsonArray jsonArray3, JsonObject jsonObject, JsonArray jsonArray4, JsonArray jsonArray5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            layout = properties.layout;
        }
        if ((i3 & 2) != 0) {
            jsonArray = properties.boundsTrackerPlaceHolders;
        }
        JsonArray jsonArray6 = jsonArray;
        if ((i3 & 4) != 0) {
            jsonArray2 = properties.musicIDs;
        }
        JsonArray jsonArray7 = jsonArray2;
        if ((i3 & 8) != 0) {
            jsonArray3 = properties.fonts;
        }
        JsonArray jsonArray8 = jsonArray3;
        if ((i3 & 16) != 0) {
            jsonObject = properties.movieConfig;
        }
        JsonObject jsonObject2 = jsonObject;
        if ((i3 & 32) != 0) {
            jsonArray4 = properties.materialConfigs;
        }
        JsonArray jsonArray9 = jsonArray4;
        if ((i3 & 64) != 0) {
            jsonArray5 = properties.resourceIDs;
        }
        return properties.copy(layout, jsonArray6, jsonArray7, jsonArray8, jsonObject2, jsonArray9, jsonArray5);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Layout getLayout() {
        return this.layout;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final JsonArray getBoundsTrackerPlaceHolders() {
        return this.boundsTrackerPlaceHolders;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final JsonArray getMusicIDs() {
        return this.musicIDs;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final JsonArray getFonts() {
        return this.fonts;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JsonObject getMovieConfig() {
        return this.movieConfig;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final JsonArray getMaterialConfigs() {
        return this.materialConfigs;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final JsonArray getResourceIDs() {
        return this.resourceIDs;
    }

    @NotNull
    public final Properties copy(@Nullable Layout layout, @Nullable JsonArray boundsTrackerPlaceHolders, @Nullable JsonArray musicIDs, @Nullable JsonArray fonts, @Nullable JsonObject movieConfig, @Nullable JsonArray materialConfigs, @Nullable JsonArray resourceIDs) {
        return new Properties(layout, boundsTrackerPlaceHolders, musicIDs, fonts, movieConfig, materialConfigs, resourceIDs);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Properties) {
                Properties properties = (Properties) other;
                if (!Intrinsics.areEqual(this.layout, properties.layout) || !Intrinsics.areEqual(this.boundsTrackerPlaceHolders, properties.boundsTrackerPlaceHolders) || !Intrinsics.areEqual(this.musicIDs, properties.musicIDs) || !Intrinsics.areEqual(this.fonts, properties.fonts) || !Intrinsics.areEqual(this.movieConfig, properties.movieConfig) || !Intrinsics.areEqual(this.materialConfigs, properties.materialConfigs) || !Intrinsics.areEqual(this.resourceIDs, properties.resourceIDs)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final JsonArray getBoundsTrackerPlaceHolders() {
        return this.boundsTrackerPlaceHolders;
    }

    @Nullable
    public final JsonArray getFonts() {
        return this.fonts;
    }

    @Nullable
    public final Layout getLayout() {
        return this.layout;
    }

    @Nullable
    public final JsonArray getMaterialConfigs() {
        return this.materialConfigs;
    }

    @Nullable
    public final JsonObject getMovieConfig() {
        return this.movieConfig;
    }

    @Nullable
    public final JsonArray getMusicIDs() {
        return this.musicIDs;
    }

    @Nullable
    public final JsonArray getResourceIDs() {
        return this.resourceIDs;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        Layout layout = this.layout;
        int i27 = 0;
        if (layout != null) {
            i3 = layout.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = i3 * 31;
        JsonArray jsonArray = this.boundsTrackerPlaceHolders;
        if (jsonArray != null) {
            i16 = jsonArray.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        JsonArray jsonArray2 = this.musicIDs;
        if (jsonArray2 != null) {
            i17 = jsonArray2.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        JsonArray jsonArray3 = this.fonts;
        if (jsonArray3 != null) {
            i18 = jsonArray3.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (i36 + i18) * 31;
        JsonObject jsonObject = this.movieConfig;
        if (jsonObject != null) {
            i19 = jsonObject.hashCode();
        } else {
            i19 = 0;
        }
        int i38 = (i37 + i19) * 31;
        JsonArray jsonArray4 = this.materialConfigs;
        if (jsonArray4 != null) {
            i26 = jsonArray4.hashCode();
        } else {
            i26 = 0;
        }
        int i39 = (i38 + i26) * 31;
        JsonArray jsonArray5 = this.resourceIDs;
        if (jsonArray5 != null) {
            i27 = jsonArray5.hashCode();
        }
        return i39 + i27;
    }

    public final void setLayout(@Nullable Layout layout) {
        this.layout = layout;
    }

    @NotNull
    public String toString() {
        return "Properties(layout=" + this.layout + ", boundsTrackerPlaceHolders=" + this.boundsTrackerPlaceHolders + ", musicIDs=" + this.musicIDs + ", fonts=" + this.fonts + ", movieConfig=" + this.movieConfig + ", materialConfigs=" + this.materialConfigs + ", resourceIDs=" + this.resourceIDs + ")";
    }

    public Properties(@Nullable Layout layout, @Nullable JsonArray jsonArray, @Nullable JsonArray jsonArray2, @Nullable JsonArray jsonArray3, @Nullable JsonObject jsonObject, @Nullable JsonArray jsonArray4, @Nullable JsonArray jsonArray5) {
        this.layout = layout;
        this.boundsTrackerPlaceHolders = jsonArray;
        this.musicIDs = jsonArray2;
        this.fonts = jsonArray3;
        this.movieConfig = jsonObject;
        this.materialConfigs = jsonArray4;
        this.resourceIDs = jsonArray5;
    }

    public /* synthetic */ Properties(Layout layout, JsonArray jsonArray, JsonArray jsonArray2, JsonArray jsonArray3, JsonObject jsonObject, JsonArray jsonArray4, JsonArray jsonArray5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : layout, (i3 & 2) != 0 ? null : jsonArray, (i3 & 4) != 0 ? null : jsonArray2, (i3 & 8) != 0 ? null : jsonArray3, (i3 & 16) != 0 ? null : jsonObject, (i3 & 32) != 0 ? null : jsonArray4, (i3 & 64) != 0 ? null : jsonArray5);
    }
}
