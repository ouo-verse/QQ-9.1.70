package com.tencent.state.square.data;

import android.graphics.Point;
import android.util.Size;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import com.tencent.state.square.SquareBase;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 H2\u00020\u0001:\u0001HBi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010A\u001a\u00020\u000bJ\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020\u0000J\b\u0010G\u001a\u00020EH\u0016R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010/\"\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010/R\u0011\u00103\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010/R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00105\"\u0004\b>\u00107R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(\u00a8\u0006I"}, d2 = {"Lcom/tencent/state/square/data/Resource;", "", "actionId", "", TabPreloadItem.TAB_NAME_DYNAMIC, "Lcom/tencent/state/square/data/ResourceIdentify;", "static", "showSize", "Landroid/util/Size;", "recordSize", "isDefault", "", "bubbleCoordinate", "Landroid/graphics/Point;", "actionType", "actionStyle", ZPlanApiImpl.FILAMENT_TAG, "Lcom/tencent/state/square/data/FilamentResource;", "(ILcom/tencent/state/square/data/ResourceIdentify;Lcom/tencent/state/square/data/ResourceIdentify;Landroid/util/Size;Landroid/util/Size;ZLandroid/graphics/Point;IILcom/tencent/state/square/data/FilamentResource;)V", "action", "Lcom/tencent/state/square/data/AvatarAction;", "getAction", "()Lcom/tencent/state/square/data/AvatarAction;", "setAction", "(Lcom/tencent/state/square/data/AvatarAction;)V", "getActionId", "()I", "setActionId", "(I)V", "getActionStyle", "setActionStyle", "getActionType", "setActionType", "getBubbleCoordinate", "()Landroid/graphics/Point;", "setBubbleCoordinate", "(Landroid/graphics/Point;)V", "getDynamic", "()Lcom/tencent/state/square/data/ResourceIdentify;", "setDynamic", "(Lcom/tencent/state/square/data/ResourceIdentify;)V", "getFilament", "()Lcom/tencent/state/square/data/FilamentResource;", "setFilament", "(Lcom/tencent/state/square/data/FilamentResource;)V", "filamentReady", "getFilamentReady", "()Z", "setDefault", "(Z)V", "isMultiAction", "isSingleAction", "getRecordSize", "()Landroid/util/Size;", "setRecordSize", "(Landroid/util/Size;)V", "related", "getRelated", "()Lcom/tencent/state/square/data/Resource;", "setRelated", "(Lcom/tencent/state/square/data/Resource;)V", "getShowSize", "setShowSize", "getStatic", "setStatic", "canPlay", "getFilamentCoverUrl", "Lcom/tencent/state/square/data/FilamentAvatarCoverUri;", "getKey", "", "resetDefault", "toString", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class Resource {
    private static final int ACTION_EASY = 0;
    private static final int ACTION_MULTI = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String FILAMENT_CACHE_DIR_NAME = "state_filament_cover";

    @Nullable
    private AvatarAction action;
    private int actionId;
    private int actionStyle;
    private int actionType;

    @NotNull
    private Point bubbleCoordinate;

    @NotNull
    private ResourceIdentify dynamic;

    @NotNull
    private FilamentResource filament;
    private boolean isDefault;

    @NotNull
    private Size recordSize;

    @Nullable
    private Resource related;

    @NotNull
    private Size showSize;

    @NotNull
    private ResourceIdentify static;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/data/Resource$Companion;", "", "()V", "ACTION_EASY", "", "ACTION_MULTI", "FILAMENT_CACHE_DIR_NAME", "", "getFullCoverCacheDir", "getFullCoverCacheFileUrl", "filename", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String getFullCoverCacheDir() {
            return SquareBase.INSTANCE.getConfig().getRootCacheDir().getAbsolutePath() + File.separator + Resource.FILAMENT_CACHE_DIR_NAME;
        }

        @NotNull
        public final String getFullCoverCacheFileUrl(@Nullable String filename) {
            return getFullCoverCacheDir() + '/' + filename;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Resource() {
        this(0, null, null, null, null, false, null, 0, 0, null, 1023, null);
    }

    public final boolean canPlay() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.dynamic.getUrl());
        return !isBlank;
    }

    @Nullable
    public final AvatarAction getAction() {
        return this.action;
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final int getActionStyle() {
        return this.actionStyle;
    }

    public final int getActionType() {
        return this.actionType;
    }

    @NotNull
    public final Point getBubbleCoordinate() {
        return this.bubbleCoordinate;
    }

    @NotNull
    public final ResourceIdentify getDynamic() {
        return this.dynamic;
    }

    @NotNull
    public final FilamentResource getFilament() {
        return this.filament;
    }

    @NotNull
    public final FilamentAvatarCoverUri getFilamentCoverUrl() {
        String str;
        boolean isBlank;
        boolean isBlank2;
        String fullCoverCacheFileUrl = INSTANCE.getFullCoverCacheFileUrl(this.actionId + util.base64_pad_url + this.filament.getResource().getMd5() + util.base64_pad_url + this.filament.getUserDressKey() + ".png");
        FilamentCoverResource recordCover = this.filament.getRecordCover();
        if (recordCover == null || (str = recordCover.getCoverUrl()) == null) {
            str = "";
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            str = this.static.getUrl();
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank2) {
            str = this.static.getDefaultUrl();
        }
        return new FilamentAvatarCoverUri(fullCoverCacheFileUrl, str, this.filament.isRecordCoverCorrect());
    }

    public final boolean getFilamentReady() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.filament.getUrl());
        return !isBlank;
    }

    @NotNull
    public final String getKey() {
        boolean isBlank;
        String md5 = this.dynamic.getMd5();
        isBlank = StringsKt__StringsJVMKt.isBlank(md5);
        if (isBlank) {
            return String.valueOf(this.actionId);
        }
        return md5;
    }

    @NotNull
    public final Size getRecordSize() {
        return this.recordSize;
    }

    @Nullable
    public final Resource getRelated() {
        return this.related;
    }

    @NotNull
    public final Size getShowSize() {
        return this.showSize;
    }

    @NotNull
    public final ResourceIdentify getStatic() {
        return this.static;
    }

    /* renamed from: isDefault, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public final boolean isMultiAction() {
        if (this.actionType == 1) {
            return true;
        }
        return false;
    }

    public final boolean isSingleAction() {
        if (this.actionType == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Resource resetDefault() {
        this.isDefault = true;
        this.dynamic.resetDefault();
        this.static.resetDefault();
        return this;
    }

    public final void setAction(@Nullable AvatarAction avatarAction) {
        this.action = avatarAction;
    }

    public final void setActionId(int i3) {
        this.actionId = i3;
    }

    public final void setActionStyle(int i3) {
        this.actionStyle = i3;
    }

    public final void setActionType(int i3) {
        this.actionType = i3;
    }

    public final void setBubbleCoordinate(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.bubbleCoordinate = point;
    }

    public final void setDefault(boolean z16) {
        this.isDefault = z16;
    }

    public final void setDynamic(@NotNull ResourceIdentify resourceIdentify) {
        Intrinsics.checkNotNullParameter(resourceIdentify, "<set-?>");
        this.dynamic = resourceIdentify;
    }

    public final void setFilament(@NotNull FilamentResource filamentResource) {
        Intrinsics.checkNotNullParameter(filamentResource, "<set-?>");
        this.filament = filamentResource;
    }

    public final void setRecordSize(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.recordSize = size;
    }

    public final void setRelated(@Nullable Resource resource) {
        this.related = resource;
    }

    public final void setShowSize(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.showSize = size;
    }

    public final void setStatic(@NotNull ResourceIdentify resourceIdentify) {
        Intrinsics.checkNotNullParameter(resourceIdentify, "<set-?>");
        this.static = resourceIdentify;
    }

    @NotNull
    public String toString() {
        return "Resource(actionId=" + this.actionId + ", style:" + this.actionStyle + ", isDefault=" + this.isDefault + ", dynamic=" + this.dynamic + ", static=" + this.static + " key=" + getKey() + ')';
    }

    public Resource(int i3, @NotNull ResourceIdentify dynamic, @NotNull ResourceIdentify resourceIdentify, @NotNull Size showSize, @NotNull Size recordSize, boolean z16, @NotNull Point bubbleCoordinate, int i16, int i17, @NotNull FilamentResource filament) {
        Intrinsics.checkNotNullParameter(dynamic, "dynamic");
        Intrinsics.checkNotNullParameter(resourceIdentify, "static");
        Intrinsics.checkNotNullParameter(showSize, "showSize");
        Intrinsics.checkNotNullParameter(recordSize, "recordSize");
        Intrinsics.checkNotNullParameter(bubbleCoordinate, "bubbleCoordinate");
        Intrinsics.checkNotNullParameter(filament, "filament");
        this.actionId = i3;
        this.dynamic = dynamic;
        this.static = resourceIdentify;
        this.showSize = showSize;
        this.recordSize = recordSize;
        this.isDefault = z16;
        this.bubbleCoordinate = bubbleCoordinate;
        this.actionType = i16;
        this.actionStyle = i17;
        this.filament = filament;
    }

    public /* synthetic */ Resource(int i3, ResourceIdentify resourceIdentify, ResourceIdentify resourceIdentify2, Size size, Size size2, boolean z16, Point point, int i16, int i17, FilamentResource filamentResource, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? -1 : i3, (i18 & 2) != 0 ? new ResourceIdentify(null, null, null, null, 0, 31, null) : resourceIdentify, (i18 & 4) != 0 ? new ResourceIdentify(null, null, null, null, 0, 31, null) : resourceIdentify2, (i18 & 8) != 0 ? new Size(0, 0) : size, (i18 & 16) != 0 ? new Size(0, 0) : size2, (i18 & 32) != 0 ? false : z16, (i18 & 64) != 0 ? new Point(0, 0) : point, (i18 & 128) == 0 ? i16 : 0, (i18 & 256) != 0 ? 1 : i17, (i18 & 512) != 0 ? new FilamentResource(null, null, null, null, 15, null) : filamentResource);
    }
}
