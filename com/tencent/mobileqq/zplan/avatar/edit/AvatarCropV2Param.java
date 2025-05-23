package com.tencent.mobileqq.zplan.avatar.edit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0017\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\tB]\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\t\u0010\u001fR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "srcPicPath", "b", "desPicDirPath", "", "c", "D", "e", "()D", "startX", "f", "startY", "g", "width", "height", "getAppearanceKey", "appearanceKey", tl.h.F, "I", "()I", "actionId", "i", "getType", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDDDLjava/lang/String;II)V", "j", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.avatar.edit.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class AvatarCropV2Param {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String srcPicPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desPicDirPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final double startX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final double startY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final double width;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final double height;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String appearanceKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public AvatarCropV2Param(@NotNull String srcPicPath, @NotNull String desPicDirPath, double d16, double d17, double d18, double d19, @Nullable String str, int i3, int i16) {
        Intrinsics.checkNotNullParameter(srcPicPath, "srcPicPath");
        Intrinsics.checkNotNullParameter(desPicDirPath, "desPicDirPath");
        this.srcPicPath = srcPicPath;
        this.desPicDirPath = desPicDirPath;
        this.startX = d16;
        this.startY = d17;
        this.width = d18;
        this.height = d19;
        this.appearanceKey = str;
        this.actionId = i3;
        this.type = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDesPicDirPath() {
        return this.desPicDirPath;
    }

    /* renamed from: c, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSrcPicPath() {
        return this.srcPicPath;
    }

    /* renamed from: e, reason: from getter */
    public final double getStartX() {
        return this.startX;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarCropV2Param)) {
            return false;
        }
        AvatarCropV2Param avatarCropV2Param = (AvatarCropV2Param) other;
        if (Intrinsics.areEqual(this.srcPicPath, avatarCropV2Param.srcPicPath) && Intrinsics.areEqual(this.desPicDirPath, avatarCropV2Param.desPicDirPath) && Double.compare(this.startX, avatarCropV2Param.startX) == 0 && Double.compare(this.startY, avatarCropV2Param.startY) == 0 && Double.compare(this.width, avatarCropV2Param.width) == 0 && Double.compare(this.height, avatarCropV2Param.height) == 0 && Intrinsics.areEqual(this.appearanceKey, avatarCropV2Param.appearanceKey) && this.actionId == avatarCropV2Param.actionId && this.type == avatarCropV2Param.type) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final double getStartY() {
        return this.startY;
    }

    /* renamed from: g, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.srcPicPath.hashCode() * 31) + this.desPicDirPath.hashCode()) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.startX)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.startY)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.width)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.height)) * 31;
        String str = this.appearanceKey;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((hashCode2 + hashCode) * 31) + this.actionId) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "AvatarCropV2Param(srcPicPath=" + this.srcPicPath + ", desPicDirPath=" + this.desPicDirPath + ", startX=" + this.startX + ", startY=" + this.startY + ", width=" + this.width + ", height=" + this.height + ", appearanceKey=" + this.appearanceKey + ", actionId=" + this.actionId + ", type=" + this.type + ')';
    }
}
