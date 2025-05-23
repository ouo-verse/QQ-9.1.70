package cl0;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000 \u00142\u00020\u0001:\u0001\u0004B\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0005\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0004\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcl0/a;", "", "", "toString", "a", "Ljava/lang/String;", "cdnUrlPrefix", "sceneBpUrl", "f", "()Ljava/lang/String;", "sceneAvatarAnimUrl", "d", "sceneAvatarBpUrl", "e", "singleAnimAvatarAnimUrl", "g", "singleAnimAvatarBpUrl", tl.h.F, "coupleAnimAvatarAnimUrl", "coupleAnimAvatarBpUrl", "b", "coupleAnimAvatarDetailBpUrl", "c", "version", "<init>", "(Ljava/lang/String;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String cdnUrlPrefix;

    @SerializedName("couple_anim_avatar_anim_url")
    @NotNull
    private final String coupleAnimAvatarAnimUrl;

    @SerializedName("couple_anim_avatar_bp_url")
    @NotNull
    private final String coupleAnimAvatarBpUrl;

    @SerializedName("couple_anim_avatar_detail_bp_url")
    @NotNull
    private final String coupleAnimAvatarDetailBpUrl;

    @SerializedName("scene_avatar_anim_url")
    @NotNull
    private final String sceneAvatarAnimUrl;

    @SerializedName("scene_avatar_bp_url")
    @NotNull
    private final String sceneAvatarBpUrl;

    @SerializedName("scene_bp_url")
    @NotNull
    private final String sceneBpUrl;

    @SerializedName("single_anim_avatar_anim_url")
    @NotNull
    private final String singleAnimAvatarAnimUrl;

    @SerializedName("single_anim_avatar_bp_url")
    @NotNull
    private final String singleAnimAvatarBpUrl;

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCoupleAnimAvatarAnimUrl() {
        return this.coupleAnimAvatarAnimUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCoupleAnimAvatarBpUrl() {
        return this.coupleAnimAvatarBpUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCoupleAnimAvatarDetailBpUrl() {
        return this.coupleAnimAvatarDetailBpUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSceneAvatarAnimUrl() {
        return this.sceneAvatarAnimUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSceneAvatarBpUrl() {
        return this.sceneAvatarBpUrl;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSceneBpUrl() {
        return this.sceneBpUrl;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getSingleAnimAvatarAnimUrl() {
        return this.singleAnimAvatarAnimUrl;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getSingleAnimAvatarBpUrl() {
        return this.singleAnimAvatarBpUrl;
    }

    @NotNull
    public String toString() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this)");
        return json;
    }

    public a(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        String str = "https://pre.cdn-go.cn/zplan-lite/resources/" + version + "/f/v1";
        this.cdnUrlPrefix = str;
        this.sceneBpUrl = str + "/couple/scene/{id}/room/{bp_theme}.fasset";
        this.sceneAvatarAnimUrl = str + "/couple/scene/{id}/{side}/{gender}/avatar/{part}.fasset";
        this.sceneAvatarBpUrl = str + "/couple/scene/{id}/{side}/{gender}/bp.fasset";
        this.singleAnimAvatarAnimUrl = str + "/couple/single_anim/{id}/{gender}/avatar/{part}.fasset";
        this.singleAnimAvatarBpUrl = str + "/couple/single_anim/{id}/{gender}/bp.fasset";
        this.coupleAnimAvatarAnimUrl = str + "/couple/couple_anim/{id}/{side}/{gender}/avatar/{part}.fasset";
        this.coupleAnimAvatarBpUrl = str + "/couple/couple_anim/{id}/bp.fasset";
        this.coupleAnimAvatarDetailBpUrl = str + "/couple/couple_anim/{id}/{side}/{gender}/bp.fasset";
    }

    public /* synthetic */ a(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "4047b698" : str);
    }
}
