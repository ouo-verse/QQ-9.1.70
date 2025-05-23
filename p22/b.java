package p22;

import android.content.Context;
import au0.c;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.app.AppConstants;
import g32.h;
import i22.e;
import i22.g;
import i22.k;
import i22.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001e\u00a8\u0006!"}, d2 = {"Lp22/b;", "", "Lp22/a;", "", "roomId", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "", "d", "e", "Landroid/content/Context;", "context", "b", "", "isPageClose", "shouldExitRoom", "c", "Lau0/c;", "roomSwitcher", "g", "f", "a", "Lg32/h;", "Lg32/h;", "trigger", "Lo22/b;", "Lo22/b;", "roomInfoService", "Lau0/c;", "<init>", "(Lg32/h;Lo22/b;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h trigger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final o22.b roomInfoService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c roomSwitcher;

    public b(@NotNull h trigger, @NotNull o22.b roomInfoService) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(roomInfoService, "roomInfoService");
        this.trigger = trigger;
        this.roomInfoService = roomInfoService;
    }

    @Override // p22.a
    @Nullable
    /* renamed from: a, reason: from getter */
    public c getRoomSwitcher() {
        return this.roomSwitcher;
    }

    public void b(@NotNull Context context, long roomId, @NotNull LiveRoomExtraInfo extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        o22.b bVar = this.roomInfoService;
        bVar.m(roomId);
        bVar.f(extraInfo);
        this.trigger.w0(new e());
    }

    public void c(long roomId, boolean isPageClose, boolean shouldExitRoom) {
        this.trigger.w0(new g(isPageClose, shouldExitRoom));
    }

    public void d(long roomId, @Nullable String videoUrl, @Nullable LiveRoomExtraInfo extraInfo) {
        o22.b bVar = this.roomInfoService;
        bVar.m(roomId);
        bVar.f(extraInfo);
        bVar.r(videoUrl);
        this.trigger.w0(new i22.h(roomId, videoUrl, extraInfo));
    }

    public void e() {
        this.trigger.w0(new k());
    }

    public void f() {
        this.trigger.w0(new l());
    }

    public void g(@NotNull c roomSwitcher) {
        Intrinsics.checkNotNullParameter(roomSwitcher, "roomSwitcher");
        this.roomSwitcher = roomSwitcher;
    }
}
