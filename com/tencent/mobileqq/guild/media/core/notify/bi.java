package com.tencent.mobileqq.guild.media.core.notify;

import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "d", "Z", "b", "()Z", "hasTalkPermission", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$PermissionChangeType;", "e", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$PermissionChangeType;", "a", "()Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$PermissionChangeType;", "changeType", "<init>", "(ZLcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$PermissionChangeType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bi implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean hasTalkPermission;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaChannelPermissionHelper.PermissionChangeType changeType;

    public bi(boolean z16, @NotNull MediaChannelPermissionHelper.PermissionChangeType changeType) {
        Intrinsics.checkNotNullParameter(changeType, "changeType");
        this.hasTalkPermission = z16;
        this.changeType = changeType;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final MediaChannelPermissionHelper.PermissionChangeType getChangeType() {
        return this.changeType;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasTalkPermission() {
        return this.hasTalkPermission;
    }
}
