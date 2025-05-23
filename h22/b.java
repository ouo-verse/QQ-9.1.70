package h22;

import android.content.Context;
import android.content.Intent;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.PageLifecycle;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.c;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import k22.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tBG\u0012\u0006\u00104\u001a\u00020\u0002\u0012\u0006\u00105\u001a\u00020\u0004\u0012\u0006\u00106\u001a\u00020\u0005\u0012\u0006\u00107\u001a\u00020\u0006\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0007\u0012\u0006\u0010:\u001a\u00020\b\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u000b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\fH\u0096\u0001J\u0013\u0010 \u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\u0013\u0010\"\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0011\u0010$\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010&\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0018H\u0096\u0001J\t\u0010'\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010)\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0018H\u0096\u0001J\t\u0010+\u001a\u00020*H\u0096\u0001J\t\u0010-\u001a\u00020,H\u0096\u0001J\t\u0010.\u001a\u00020\u0018H\u0096\u0001J\t\u0010/\u001a\u00020\u0018H\u0096\u0001J\u0011\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u000200H\u0096\u0001J\u0011\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u000200H\u0096\u0001\u00a8\u0006?"}, d2 = {"Lh22/b;", "Lh22/a;", "Lo22/b;", "Lk22/d;", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/c;", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/d;", "Ln22/b;", "Lk22/c;", "Lj22/b;", "", "Lcom/tencent/mobileqq/icgame/data/anchor/room/QQLiveAnchorRoomInfo;", "getAnchorRoomInfo", "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "k", "", "a", "", "getRoomId", "Landroid/content/Intent;", "o", "", "getRoomType", "", "j", "c", ReportConstant.COSTREPORT_PREFIX, "liveInfo", "", DomainData.DOMAIN_NAME, "extra", "f", WebAccelerateHelper.KEY_PRELOAD_URL, "r", "roomId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "show", "e", "t", "shouldExitRoom", "b", "Landroid/content/Context;", "d", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/PageLifecycle;", "l", "p", h.F, "Lk22/b;", "handler", "g", "i", "roomInfoService", "actLifecycleService", "pageLifecycleService", "orientationChangeService", "closeRoomService", "backEventService", "fragmentService", "Ln22/a;", "configuration", "<init>", "(Lo22/b;Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/c;Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/d;Ln22/b;Lk22/d;Lk22/c;Lj22/b;Ln22/a;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class b implements a, o22.b, d, c, com.tencent.mobileqq.icgame.base.room.service.lifecycle.d, n22.b, k22.c, j22.b {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ o22.b f404116a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ d f404117b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ c f404118c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.icgame.base.room.service.lifecycle.d f404119d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ n22.b f404120e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ k22.c f404121f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ j22.b f404122g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ n22.a f404123h;

    public b(@NotNull o22.b roomInfoService, @NotNull c actLifecycleService, @NotNull com.tencent.mobileqq.icgame.base.room.service.lifecycle.d pageLifecycleService, @NotNull n22.b orientationChangeService, @NotNull d closeRoomService, @NotNull k22.c backEventService, @NotNull j22.b fragmentService, @NotNull n22.a configuration) {
        Intrinsics.checkNotNullParameter(roomInfoService, "roomInfoService");
        Intrinsics.checkNotNullParameter(actLifecycleService, "actLifecycleService");
        Intrinsics.checkNotNullParameter(pageLifecycleService, "pageLifecycleService");
        Intrinsics.checkNotNullParameter(orientationChangeService, "orientationChangeService");
        Intrinsics.checkNotNullParameter(closeRoomService, "closeRoomService");
        Intrinsics.checkNotNullParameter(backEventService, "backEventService");
        Intrinsics.checkNotNullParameter(fragmentService, "fragmentService");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f404116a = roomInfoService;
        this.f404117b = closeRoomService;
        this.f404118c = actLifecycleService;
        this.f404119d = pageLifecycleService;
        this.f404120e = orientationChangeService;
        this.f404121f = backEventService;
        this.f404122g = fragmentService;
        this.f404123h = configuration;
    }

    @Override // o22.b
    @Nullable
    /* renamed from: a */
    public String getPreLoadVideoUrl() {
        return this.f404116a.getPreLoadVideoUrl();
    }

    @Override // k22.d
    public void b(boolean shouldExitRoom) {
        this.f404117b.b(shouldExitRoom);
    }

    @Override // o22.b
    public boolean c() {
        return this.f404116a.c();
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.c
    @NotNull
    public Context d() {
        return this.f404118c.d();
    }

    @Override // o22.b
    public void e(boolean show) {
        this.f404116a.e(show);
    }

    @Override // o22.b
    public void f(@Nullable LiveRoomExtraInfo extra) {
        this.f404116a.f(extra);
    }

    @Override // k22.c
    public void g(@NotNull k22.b handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f404121f.g(handler);
    }

    @Override // o22.b
    @Nullable
    public QQLiveAnchorRoomInfo getAnchorRoomInfo() {
        return this.f404116a.getAnchorRoomInfo();
    }

    @Override // o22.b
    public long getRoomId() {
        return this.f404116a.getRoomId();
    }

    @Override // o22.b
    public int getRoomType() {
        return this.f404116a.getRoomType();
    }

    @Override // n22.b
    public boolean h() {
        return this.f404120e.h();
    }

    @Override // k22.c
    public void i(@NotNull k22.b handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f404121f.i(handler);
    }

    @Override // o22.b
    /* renamed from: j */
    public boolean getShowFloatWindow() {
        return this.f404116a.getShowFloatWindow();
    }

    @Override // o22.b
    @Nullable
    /* renamed from: k */
    public LiveRoomExtraInfo getExtraInfo() {
        return this.f404116a.getExtraInfo();
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.d
    @NotNull
    /* renamed from: l */
    public PageLifecycle getCurPageLifecycle() {
        return this.f404119d.getCurPageLifecycle();
    }

    @Override // o22.b
    public void m(long roomId) {
        this.f404116a.m(roomId);
    }

    @Override // o22.b
    public void n(@NotNull LiveInfo liveInfo) {
        Intrinsics.checkNotNullParameter(liveInfo, "liveInfo");
        this.f404116a.n(liveInfo);
    }

    @Override // o22.b
    @Nullable
    /* renamed from: o */
    public Intent getIntent() {
        return this.f404116a.getIntent();
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.d
    public boolean p() {
        return this.f404119d.p();
    }

    @Override // o22.b
    @Nullable
    /* renamed from: q */
    public LiveInfo getCurLiveInfo() {
        return this.f404116a.getCurLiveInfo();
    }

    @Override // o22.b
    public void r(@Nullable String preloadUrl) {
        this.f404116a.r(preloadUrl);
    }

    @Override // o22.b
    public boolean s() {
        return this.f404116a.s();
    }

    @Override // k22.d
    public boolean t() {
        return this.f404117b.t();
    }
}
