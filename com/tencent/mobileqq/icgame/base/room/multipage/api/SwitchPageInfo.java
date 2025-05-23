package com.tencent.mobileqq.icgame.base.room.multipage.api;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\t\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "f", "(I)V", "pageIndex", "", "J", "c", "()J", "g", "(J)V", "roomid", "Ljava/lang/String;", "d", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "e", "(Landroid/os/Bundle;)V", WadlProxyConsts.EXTRA_DATA, "<init>", "(IJLjava/lang/String;Landroid/os/Bundle;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.base.room.multipage.api.f, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class SwitchPageInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int pageIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long roomid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String videoUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Bundle extraData;

    public SwitchPageInfo() {
        this(0, 0L, null, null, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bundle getExtraData() {
        return this.extraData;
    }

    /* renamed from: b, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: c, reason: from getter */
    public final long getRoomid() {
        return this.roomid;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final void e(@Nullable Bundle bundle) {
        this.extraData = bundle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwitchPageInfo)) {
            return false;
        }
        SwitchPageInfo switchPageInfo = (SwitchPageInfo) other;
        if (this.pageIndex == switchPageInfo.pageIndex && this.roomid == switchPageInfo.roomid && Intrinsics.areEqual(this.videoUrl, switchPageInfo.videoUrl) && Intrinsics.areEqual(this.extraData, switchPageInfo.extraData)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.pageIndex = i3;
    }

    public final void g(long j3) {
        this.roomid = j3;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoUrl = str;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((((this.pageIndex * 31) + androidx.fragment.app.a.a(this.roomid)) * 31) + this.videoUrl.hashCode()) * 31;
        Bundle bundle = this.extraData;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        return a16 + hashCode;
    }

    @NotNull
    public String toString() {
        return "SwitchPageInfo(pageIndex=" + this.pageIndex + ", roomid=" + this.roomid + ", videoUrl=" + this.videoUrl + ", extraData=" + this.extraData + ')';
    }

    public SwitchPageInfo(int i3, long j3, @NotNull String videoUrl, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        this.pageIndex = i3;
        this.roomid = j3;
        this.videoUrl = videoUrl;
        this.extraData = bundle;
    }

    public /* synthetic */ SwitchPageInfo(int i3, long j3, String str, Bundle bundle, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? "" : str, (i16 & 8) != 0 ? new Bundle() : bundle);
    }
}
