package com.qzone.reborn.groupalbum.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumBannerEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "img", "getImg", "color", "getColor", "text", "getText", "actionUrl", "getActionUrl", "", "intervalTime", "J", "getIntervalTime", "()J", "", "actionType", "I", "getActionType", "()I", "", "isHasPermission", "Z", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZ)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumBannerEvent extends SimpleBaseEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f56553d = "qun_right_setting_page";
    private final int actionType;
    private final String actionUrl;
    private final String color;
    private final String id;
    private final String img;
    private final long intervalTime;
    private final boolean isHasPermission;
    private final String text;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumBannerEvent$a;", "", "", "GROUP_MASTER_ACTION_URL", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.event.GroupAlbumBannerEvent$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return GroupAlbumBannerEvent.f56553d;
        }

        Companion() {
        }
    }

    public GroupAlbumBannerEvent() {
        this(null, null, null, null, null, 0L, 0, false, 255, null);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImg() {
        return this.img;
    }

    public final long getIntervalTime() {
        return this.intervalTime;
    }

    public final String getText() {
        return this.text;
    }

    /* renamed from: isHasPermission, reason: from getter */
    public final boolean getIsHasPermission() {
        return this.isHasPermission;
    }

    public /* synthetic */ GroupAlbumBannerEvent(String str, String str2, String str3, String str4, String str5, long j3, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "0xFFFFFF" : str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) == 0 ? str5 : "", (i16 & 32) != 0 ? 0L : j3, (i16 & 64) != 0 ? 0 : i3, (i16 & 128) != 0 ? true : z16);
    }

    public GroupAlbumBannerEvent(String id5, String img, String color, String text, String actionUrl, long j3, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(actionUrl, "actionUrl");
        this.id = id5;
        this.img = img;
        this.color = color;
        this.text = text;
        this.actionUrl = actionUrl;
        this.intervalTime = j3;
        this.actionType = i3;
        this.isHasPermission = z16;
    }
}
