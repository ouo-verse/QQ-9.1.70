package com.tencent.mobileqq.richmedialist.model;

import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "Ljava/io/Serializable;", "()V", "extra", "", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "fileId", "", "getFileId", "()Ljava/lang/String;", "setFileId", "(Ljava/lang/String;)V", "itemType", "Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "getItemType", "()Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "setItemType", "(Lcom/tencent/mobileqq/richmedialist/model/ItemType;)V", "isSameItem", "", "other", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public class BaseItemInfo implements Serializable {

    @Nullable
    private Object extra;

    @NotNull
    private String fileId;

    @NotNull
    private ItemType itemType;

    public BaseItemInfo() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.fileId = uuid;
        this.itemType = ItemType.DIRECTORY;
    }

    @Nullable
    public final Object getExtra() {
        return this.extra;
    }

    @NotNull
    public final String getFileId() {
        return this.fileId;
    }

    @NotNull
    public final ItemType getItemType() {
        return this.itemType;
    }

    public final boolean isSameItem(@NotNull BaseItemInfo other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(other.getClass())) && Intrinsics.areEqual(this.fileId, other.fileId)) {
            return true;
        }
        return false;
    }

    public final void setExtra(@Nullable Object obj) {
        this.extra = obj;
    }

    public final void setFileId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileId = str;
    }

    public final void setItemType(@NotNull ItemType itemType) {
        Intrinsics.checkNotNullParameter(itemType, "<set-?>");
        this.itemType = itemType;
    }
}
