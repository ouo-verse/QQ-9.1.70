package com.tencent.mobileqq.wink.share;

import com.google.gson.annotations.SerializedName;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.ttpic.openapi.filter.LightConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/share/b;", "", "", "target", "I", "getTarget", "()I", "j", "(I)V", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Ljava/lang/String;", "getMaterialId", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "categoryId", "getCategoryId", "c", "medias", "b", "g", "gender", "a", "e", "nickname", "getNickname", tl.h.F, "shareUrl", "getShareUrl", "i", "from", "getFrom", "isCouple", "d", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    @SerializedName("is_couple")
    private int isCouple;

    @SerializedName("target")
    private int target = Integer.parseInt("25");

    @SerializedName("material_id")
    @NotNull
    private String materialId = "qzone_ai_avatar_mainpage";

    @SerializedName(PictureConst.KEY_CATEGORY_ID)
    @NotNull
    private String categoryId = "";

    @SerializedName("medias")
    @NotNull
    private String medias = "https://shadow-h5-image-1251316161.file.myqcloud.com/2023-aigc/wecom-temp-143487-e5a1fb8b2f66f7d63dbf0d93f1e88b0d.png";

    @SerializedName("gender")
    @NotNull
    private String gender = LightConstants.MALE;

    @SerializedName("nickname")
    @NotNull
    private String nickname = "";

    @SerializedName(GetGuildJoinUrlServlet.BUNDLE_KEY_URL)
    @NotNull
    private String shareUrl = "https://shadow-h5-image-1251316161.file.myqcloud.com/2023-aigc/wecom-temp-143487-e5a1fb8b2f66f7d63dbf0d93f1e88b0d.png";

    @SerializedName("come_from")
    private final int from = 1;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMedias() {
        return this.medias;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryId = str;
    }

    public final void d(int i3) {
        this.isCouple = i3;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gender = str;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.materialId = str;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.medias = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareUrl = str;
    }

    public final void j(int i3) {
        this.target = i3;
    }
}
