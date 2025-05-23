package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0000R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppData;", "", "miniAppId", "", MiniChatConstants.MINI_APP_NAME, "", "miniAppAvatarUrl", "(ILjava/lang/String;Ljava/lang/String;)V", "getMiniAppAvatarUrl", "()Ljava/lang/String;", "getMiniAppId", "()I", "getMiniAppName", "areContentsTheSame", "", "newItem", "areItemsTheSame", "getChangePayload", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppData {
    private final String miniAppAvatarUrl;
    private final int miniAppId;
    private final String miniAppName;

    public MiniAppData(int i3, String miniAppName, String miniAppAvatarUrl) {
        Intrinsics.checkNotNullParameter(miniAppName, "miniAppName");
        Intrinsics.checkNotNullParameter(miniAppAvatarUrl, "miniAppAvatarUrl");
        this.miniAppId = i3;
        this.miniAppName = miniAppName;
        this.miniAppAvatarUrl = miniAppAvatarUrl;
    }

    public final boolean areContentsTheSame(MiniAppData newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return this.miniAppId == newItem.miniAppId;
    }

    public final boolean areItemsTheSame(MiniAppData newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return this.miniAppId == newItem.miniAppId;
    }

    public final Object getChangePayload(MiniAppData newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return new Object();
    }

    public final String getMiniAppAvatarUrl() {
        return this.miniAppAvatarUrl;
    }

    public final int getMiniAppId() {
        return this.miniAppId;
    }

    public final String getMiniAppName() {
        return this.miniAppName;
    }
}
