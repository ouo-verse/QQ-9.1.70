package com.tencent.filament.zplanservice.feature.model;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplanservice/feature/model/FilamentMiniHomeSceneUrlTemplate;", "", "", "toString", "cdnUrlPrefix", "Ljava/lang/String;", "baseResource", "getBaseResource", "()Ljava/lang/String;", "baseAnimResource", "getBaseAnimResource", "decorateResource", "getDecorateResource", "animResource", "getAnimResource", "connectResource", "getConnectResource", "version", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentMiniHomeSceneUrlTemplate {

    @NotNull
    public static final String DEFAULT_VERSION = "0.4";

    @SerializedName("mini_home_anim_res_url")
    @NotNull
    private final String animResource;

    @SerializedName("mini_home_base_anim_resource")
    @NotNull
    private final String baseAnimResource;

    @SerializedName("mini_home_base_resource")
    @NotNull
    private final String baseResource;
    private final String cdnUrlPrefix;

    @SerializedName("mini_home_connect_resource")
    @NotNull
    private final String connectResource;

    @SerializedName("mini_home_decorate_resource")
    @NotNull
    private final String decorateResource;

    public FilamentMiniHomeSceneUrlTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final String getAnimResource() {
        return this.animResource;
    }

    @NotNull
    public final String getBaseAnimResource() {
        return this.baseAnimResource;
    }

    @NotNull
    public final String getBaseResource() {
        return this.baseResource;
    }

    @NotNull
    public final String getConnectResource() {
        return this.connectResource;
    }

    @NotNull
    public final String getDecorateResource() {
        return this.decorateResource;
    }

    @NotNull
    public String toString() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this)");
        return json;
    }

    public FilamentMiniHomeSceneUrlTemplate(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        String str = "https://zplan-lite.cdn-go.cn/minihome-resource/" + version + "/f/v1";
        this.cdnUrlPrefix = str;
        this.baseResource = str + "/baseResources_[backend]_[platform].fasset";
        this.baseAnimResource = str + "/baseAnimResources.fasset";
        this.decorateResource = str + "/decorate/[ID]/[subID]/Mesh.fasset";
        this.animResource = str + "/{action_id}.fasset";
        this.connectResource = str + "/xwConnect/{res_id}.fasset";
    }

    public /* synthetic */ FilamentMiniHomeSceneUrlTemplate(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? DEFAULT_VERSION : str);
    }
}
