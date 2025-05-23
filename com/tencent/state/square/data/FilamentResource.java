package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tH\u00c6\u0003J7\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\u0006\u0010-\u001a\u00020)J\t\u0010.\u001a\u00020\u0016H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/square/data/FilamentResource;", "", "resource", "Lcom/tencent/state/square/data/ResourceIdentify;", "multiUser", "Lcom/tencent/state/square/data/MultiMotionUser;", "userDressKey", "Lcom/tencent/state/square/data/DressKeys;", "recordCover", "Lcom/tencent/state/square/data/FilamentCoverResource;", "(Lcom/tencent/state/square/data/ResourceIdentify;Lcom/tencent/state/square/data/MultiMotionUser;Lcom/tencent/state/square/data/DressKeys;Lcom/tencent/state/square/data/FilamentCoverResource;)V", "getMultiUser", "()Lcom/tencent/state/square/data/MultiMotionUser;", "getRecordCover", "()Lcom/tencent/state/square/data/FilamentCoverResource;", "getResource", "()Lcom/tencent/state/square/data/ResourceIdentify;", "toUin", "", "getToUin", "()Ljava/lang/Long;", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getUserDressKey", "()Lcom/tencent/state/square/data/DressKeys;", "setUserDressKey", "(Lcom/tencent/state/square/data/DressKeys;)V", "checkOwnerDressKey", "", "key", "uin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isRecordCoverCorrect", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class FilamentResource {

    @Nullable
    private final MultiMotionUser multiUser;

    @Nullable
    private final FilamentCoverResource recordCover;

    @NotNull
    private final ResourceIdentify resource;

    @NotNull
    private String url;

    @Nullable
    private DressKeys userDressKey;

    public FilamentResource() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FilamentResource copy$default(FilamentResource filamentResource, ResourceIdentify resourceIdentify, MultiMotionUser multiMotionUser, DressKeys dressKeys, FilamentCoverResource filamentCoverResource, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            resourceIdentify = filamentResource.resource;
        }
        if ((i3 & 2) != 0) {
            multiMotionUser = filamentResource.multiUser;
        }
        if ((i3 & 4) != 0) {
            dressKeys = filamentResource.userDressKey;
        }
        if ((i3 & 8) != 0) {
            filamentCoverResource = filamentResource.recordCover;
        }
        return filamentResource.copy(resourceIdentify, multiMotionUser, dressKeys, filamentCoverResource);
    }

    public final void checkOwnerDressKey(@NotNull String key, @NotNull String uin) {
        boolean isBlank;
        String str;
        boolean z16;
        DressKeys dressKeys;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(uin, "uin");
        isBlank = StringsKt__StringsJVMKt.isBlank(key);
        if (isBlank) {
            key = uin;
        }
        DressKeys dressKeys2 = this.userDressKey;
        if (dressKeys2 != null) {
            dressKeys2.setOwner(key);
        } else {
            this.userDressKey = new DressKeys(key, "");
        }
        Long toUin = getToUin();
        if (toUin != null) {
            long longValue = toUin.longValue();
            DressKeys dressKeys3 = this.userDressKey;
            if (dressKeys3 != null) {
                str = dressKeys3.getOther();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 && (dressKeys = this.userDressKey) != null) {
                dressKeys.setOther(String.valueOf(longValue));
            }
        }
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ResourceIdentify getResource() {
        return this.resource;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final MultiMotionUser getMultiUser() {
        return this.multiUser;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final DressKeys getUserDressKey() {
        return this.userDressKey;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final FilamentCoverResource getRecordCover() {
        return this.recordCover;
    }

    @NotNull
    public final FilamentResource copy(@NotNull ResourceIdentify resource, @Nullable MultiMotionUser multiUser, @Nullable DressKeys userDressKey, @Nullable FilamentCoverResource recordCover) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new FilamentResource(resource, multiUser, userDressKey, recordCover);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FilamentResource) {
                FilamentResource filamentResource = (FilamentResource) other;
                if (!Intrinsics.areEqual(this.resource, filamentResource.resource) || !Intrinsics.areEqual(this.multiUser, filamentResource.multiUser) || !Intrinsics.areEqual(this.userDressKey, filamentResource.userDressKey) || !Intrinsics.areEqual(this.recordCover, filamentResource.recordCover)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final MultiMotionUser getMultiUser() {
        return this.multiUser;
    }

    @Nullable
    public final FilamentCoverResource getRecordCover() {
        return this.recordCover;
    }

    @NotNull
    public final ResourceIdentify getResource() {
        return this.resource;
    }

    @Nullable
    public final Long getToUin() {
        String str;
        MultiMotionUser multiMotionUser = this.multiUser;
        if (multiMotionUser == null || (str = multiMotionUser.getSelectUin()) == null) {
            MultiMotionUser multiMotionUser2 = this.multiUser;
            if (multiMotionUser2 != null) {
                str = multiMotionUser2.getToUin();
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final DressKeys getUserDressKey() {
        return this.userDressKey;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        ResourceIdentify resourceIdentify = this.resource;
        int i18 = 0;
        if (resourceIdentify != null) {
            i3 = resourceIdentify.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        MultiMotionUser multiMotionUser = this.multiUser;
        if (multiMotionUser != null) {
            i16 = multiMotionUser.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        DressKeys dressKeys = this.userDressKey;
        if (dressKeys != null) {
            i17 = dressKeys.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        FilamentCoverResource filamentCoverResource = this.recordCover;
        if (filamentCoverResource != null) {
            i18 = filamentCoverResource.hashCode();
        }
        return i27 + i18;
    }

    public final boolean isRecordCoverCorrect() {
        FilamentCoverResource filamentCoverResource = this.recordCover;
        if (filamentCoverResource == null) {
            return false;
        }
        boolean z16 = true;
        if (!Intrinsics.areEqual(filamentCoverResource.getActionMd5(), this.resource.getMd5())) {
            return false;
        }
        String coverUrl = filamentCoverResource.getCoverUrl();
        if (coverUrl != null && coverUrl.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        return filamentCoverResource.getRecordDressKeys().equals(this.userDressKey);
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void setUserDressKey(@Nullable DressKeys dressKeys) {
        this.userDressKey = dressKeys;
    }

    @NotNull
    public String toString() {
        return "FilamentResource(resource=" + this.resource + ", multiUser=" + this.multiUser + ", userDressKey=" + this.userDressKey + ", recordCover=" + this.recordCover + ")";
    }

    public FilamentResource(@NotNull ResourceIdentify resource, @Nullable MultiMotionUser multiMotionUser, @Nullable DressKeys dressKeys, @Nullable FilamentCoverResource filamentCoverResource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.resource = resource;
        this.multiUser = multiMotionUser;
        this.userDressKey = dressKeys;
        this.recordCover = filamentCoverResource;
        this.url = resource.getUrl();
    }

    public /* synthetic */ FilamentResource(ResourceIdentify resourceIdentify, MultiMotionUser multiMotionUser, DressKeys dressKeys, FilamentCoverResource filamentCoverResource, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ResourceIdentify(null, null, null, null, 0, 31, null) : resourceIdentify, (i3 & 2) != 0 ? null : multiMotionUser, (i3 & 4) != 0 ? null : dressKeys, (i3 & 8) != 0 ? null : filamentCoverResource);
    }
}
