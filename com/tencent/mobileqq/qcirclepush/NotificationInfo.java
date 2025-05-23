package com.tencent.mobileqq.qcirclepush;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.BaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qcirclepush/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "notifyId", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", BaseConstants.EXTRA_PUSHID, "c", "getFromUin", "fromUin", "d", "g", "title", "description", "iconUrl", WadlProxyConsts.KEY_JUMP_URL, h.F, "extInfo", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qcirclepush.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class NotificationInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int notifyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pushId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String fromUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String description;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String extInfo;

    public NotificationInfo(int i3, @NotNull String pushId, @NotNull String fromUin, @NotNull String title, @NotNull String description, @NotNull String iconUrl, @NotNull String jumpUrl, @NotNull String extInfo) {
        Intrinsics.checkNotNullParameter(pushId, "pushId");
        Intrinsics.checkNotNullParameter(fromUin, "fromUin");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        this.notifyId = i3;
        this.pushId = pushId;
        this.fromUin = fromUin;
        this.title = title;
        this.description = description;
        this.iconUrl = iconUrl;
        this.jumpUrl = jumpUrl;
        this.extInfo = extInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getExtInfo() {
        return this.extInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: e, reason: from getter */
    public final int getNotifyId() {
        return this.notifyId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationInfo)) {
            return false;
        }
        NotificationInfo notificationInfo = (NotificationInfo) other;
        if (this.notifyId == notificationInfo.notifyId && Intrinsics.areEqual(this.pushId, notificationInfo.pushId) && Intrinsics.areEqual(this.fromUin, notificationInfo.fromUin) && Intrinsics.areEqual(this.title, notificationInfo.title) && Intrinsics.areEqual(this.description, notificationInfo.description) && Intrinsics.areEqual(this.iconUrl, notificationInfo.iconUrl) && Intrinsics.areEqual(this.jumpUrl, notificationInfo.jumpUrl) && Intrinsics.areEqual(this.extInfo, notificationInfo.extInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPushId() {
        return this.pushId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((this.notifyId * 31) + this.pushId.hashCode()) * 31) + this.fromUin.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.extInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "NotificationInfo(notifyId=" + this.notifyId + ", pushId=" + this.pushId + ", fromUin=" + this.fromUin + ", title=" + this.title + ", description=" + this.description + ", iconUrl=" + this.iconUrl + ", jumpUrl=" + this.jumpUrl + ", extInfo=" + this.extInfo + ")";
    }
}
